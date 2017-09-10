package com.jst.web.manager;

import com.jst.web.constant.Constant;
import com.jst.web.model.database.JstEmployee;
import com.jst.web.model.database.JstMember;
import com.jst.web.model.database.JstOrder;
import com.jst.web.model.database.JstProduct;
import com.jst.web.model.request.RequestOrder;
import com.jst.web.model.response.ResponseOrder;
import com.jst.web.service.JstEmployeeService;
import com.jst.web.service.JstMemberService;
import com.jst.web.service.JstOrderService;
import com.jst.web.service.JstProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/3/9.
 */
@Component
public class JstOrderManager {

    @Autowired
    private JstOrderService orderService;
    @Autowired
    private JstProductService productService;
    @Autowired
    private JstMemberService memberService;
    @Autowired
    private JstEmployeeService empService;

    @Transactional
    public long saveOrder(long opEmpId, RequestOrder order) {
        JstOrder jOrder = new JstOrder();
        JstProduct product = productService.getProductById(order.getProductId());
        jOrder.setProductId(order.getProductId());
        jOrder.setDiscountPrice(product.getDiscountPrice());
        jOrder.setOriginalPrice(product.getOriginalPrice());
        jOrder.setVipPrice(product.getVipPrice());
        jOrder.setRealPrice(order.getRealPrice());
        jOrder.setRemark(order.getRemark());
        jOrder.setMemberId(order.getMemberId());
        long currTime = System.currentTimeMillis();
        Timestamp stamp = new Timestamp(currTime);
        jOrder.setAddTime(stamp);
        jOrder.setUpdateTime(stamp);
        jOrder.setEmployeeId(opEmpId);
        if (order.getMemberId() > 0 && order.getRealPrice().doubleValue() > 0) {
            JstMember m = memberService.getMemberById(order.getMemberId());
            if (m.getBalanceAmount().doubleValue() < order.getRealPrice().doubleValue() ) {
                return -2;
            }
            memberService.expense(order.getMemberId(), order.getRealPrice());
        }
        orderService.saveOrder(jOrder);
        return jOrder.getId();
    }

    public JstOrder getOrderById (long id) {
        return orderService.getOrderById(id);
    }

    public JstOrder getOrderByName(String name) {
        return orderService.getOrderByName(name);
    }

    public Map<String, Object> getOrders(Map<String, Object> conMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", orderService.getOrderCount());
        int start = ((Integer) conMap.get("page") - 1)*(Integer) conMap.get("num");
        conMap.put("start", start);
        List<Long> ids = orderService.getOrderIds(conMap);
        List<ResponseOrder> orders = new ArrayList<ResponseOrder>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        BigDecimal totalAmount = new BigDecimal(0);
        BigDecimal realAmount = new BigDecimal(0);
        BigDecimal proportion = new BigDecimal(10);
        ResponseOrder r;
        for (long id : ids) {
            JstOrder o = orderService.getOrderById(id);
            if (o.getStatus() != Constant.NORMAL) {
                continue;
            }
            JstProduct p = productService.getProductById(o.getProductId());
            r = new ResponseOrder();
            r.setProductName(p.getProductName());
            r.setRealPrice(o.getRealPrice());
            r.setStatus(o.getStatus());
            r.setRemark(o.getRemark());
            r.setId(o.getId());
            r.setOrderTime(sdf.format(o.getAddTime()));
            JstEmployee emp = empService.getEmployeeById(o.getEmployeeId());
            r.setEmpName(emp.getName());
            if (o.getMemberId() > 0) {
                JstMember m = memberService.getMemberById(o.getMemberId());
                r.setMemberName(m.getName());
            }
            if (!o.getRealPrice().equals(p.getOriginalPrice()) && !o.getRealPrice().equals(p.getVipPrice())) {
                proportion = p.getPromotionProportion();
            } else if (o.getMemberId() > 0 && o.getRealPrice().equals(p.getVipPrice())) {
                proportion = p.getMemProportion();
            } else if ((Long) conMap.get("empId") > 0){
                proportion = p.getProportion();
            }
            totalAmount = totalAmount.add(o.getRealPrice().multiply(proportion));
            realAmount = realAmount.add(o.getRealPrice());
            orders.add(r);
        }
        map.put("orderNum", orders.size());
        map.put("totalAmount", totalAmount.divide(new BigDecimal(10)));
        map.put("realAmount", realAmount);
        map.put("list", orders);
        map.put("page", start);
        return map;
    }

    public Map<String, Object> getOrdersInMonth(long empId, BigDecimal proportion) {
        Map<String, Object> map = new HashMap<String, Object>();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        List<Long> ids = orderService.getOrderIds(empId, cal.getTimeInMillis());
        BigDecimal totalAmount = new BigDecimal(0);
        BigDecimal realAmount = new BigDecimal(0);
        if (!CollectionUtils.isEmpty(ids)) {
            JstOrder order = null;
            for (long id : ids) {
                order = orderService.getOrderById(id);
                if (order != null && order.getStatus() == Constant.NORMAL)  {
                    JstProduct product = productService.getProductById(order.getProductId());
                    proportion = proportion.doubleValue() < 10 ? product.getProportion() : proportion;
                    totalAmount = totalAmount.add(product.getOriginalPrice().multiply(proportion));
                    realAmount = realAmount.add(order.getRealPrice());
                }
            }
        }
        map.put("orderNum", ids.size());
        map.put("totalAmount", totalAmount.divide(new BigDecimal(10)));
        map.put("realAmount", realAmount);
        return map;
    }

    public List<JstOrder> getOrderIdsByMem(long memId) {
        List<JstOrder> orders = new ArrayList<JstOrder>();
        List<Long> orderIds = orderService.getOrderIdsByMem(memId);
        JstOrder order = null;
        for (long orderId : orderIds) {
            order = orderService.getOrderById(orderId);
            orders.add(order);
        }
        return orders;
    }

    public int revokeOrder(long orderId) {
        JstOrder order = orderService.getOrderById(orderId);
        memberService.expense(order.getMemberId(), new BigDecimal(0).subtract(order.getRealPrice()));
        return orderService.revokeOrder(orderId);
    }

}
