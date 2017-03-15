package com.jst.web.manager;

import com.jst.web.model.database.JstOrder;
import com.jst.web.model.request.RequestOrder;
import com.jst.web.service.JstOrderService;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/9.
 */
@Component
public class JstOrderManager {

    @Autowired
    private JstOrderService orderService;

    public long saveOrder(RequestOrder order) {
        JstOrder jOrder = new JstOrder();
        jOrder.setProductId(order.getProductId());
        jOrder.setDiscountPrice(order.getDiscountPrice());
        jOrder.setOriginalPrice(order.getOriginalPrice());
        jOrder.setRealPrice(order.getRealPrice());
        jOrder.setRemark(order.getRemark());
        long currTime = System.currentTimeMillis();
        Timestamp stamp = new Timestamp(currTime);
        jOrder.setAddTime(stamp);
        jOrder.setUpdateTime(stamp);
        orderService.saveOrder(jOrder);
        return jOrder.getId();
    }

    public JstOrder getOrderById (long id) {
        return orderService.getOrderById(id);
    }

    public JstOrder getOrderByName(String name) {
        return orderService.getOrderByName(name);
    }

    public Map<String, Object> getOrders(int page, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", orderService.getOrderCount());
        int start = (page - 1)*num;
        List<Long> ids = orderService.getOrderIds(start, num);
        List<JstOrder> products = new ArrayList<JstOrder>();
        for (long id : ids) {
            products.add(orderService.getOrderById(id));
        }
        map.put("list", products);
        map.put("page", start);
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

}
