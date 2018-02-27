package com.jst.web.manager;

import com.jst.web.model.database.JstCharge;
import com.jst.web.model.database.JstMember;
import com.jst.web.model.database.JstOrder;
import com.jst.web.model.database.JstProduct;
import com.jst.web.model.request.RequestMember;
import com.jst.web.model.response.ResponseMember;
import com.jst.web.model.response.ResponseOrder;
import com.jst.web.service.JstChargeService;
import com.jst.web.service.JstMemberService;
import com.jst.web.service.JstOrderService;
import com.jst.web.service.JstProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stefan on 2017/3/6.
 */
@Component
public class JstMemberManager {

    @Autowired
    private JstMemberService memberService;
    @Autowired
    private JstOrderService orderService;
    @Autowired
    private JstChargeService chargeService;
    @Autowired
    private JstProductService productService;

    @Transactional
    public long saveMember(long empId, RequestMember mem) {
        JstMember oldMem = memberService.getMemberByCardNo(mem.getCardNo());
        if (mem.getId() <= 0 && oldMem != null) {
            return -1;
        }
        JstMember member = new JstMember();
        member.setName(mem.getName());
        member.setPhone(mem.getPhone());
        member.setCardNo(mem.getCardNo());
        member.setChargeAmount(mem.getChargeAmount());
        member.setMemDiscount(mem.getMemDiscount());
        member.setPassword(mem.getPassword());
        long currTime = System.currentTimeMillis();
        Timestamp stamp = new Timestamp(currTime);
        member.setUpdateTime(stamp);
        member.setEmpId(empId);
        member.setRemark(mem.getRemark());
        member.setExtraAmount(mem.getExtraAmount());
        member.setExpenseAmount(new BigDecimal(0));
        member.setBalanceAmount(mem.getChargeAmount().add(mem.getExtraAmount()));
        if (mem.getId() > 0) {
            member.setId(mem.getId());
            memberService.updateMember(member);
        } else {
            member.setRegisterTime(stamp);
            memberService.saveMember(member);
            JstCharge charge = new JstCharge();
            charge.setChargeAmount(mem.getChargeAmount());
            charge.setExtraAmount(mem.getExtraAmount());
            charge.setRemark(mem.getRemark());
            charge.setMemberId(member.getId());
            charge.setChargeTime(stamp);
            chargeService.saveCharge(charge);
        }
        return member.getId();
    }

    public JstMember getMember(long id) {
        return memberService.getMemberById(id);
    }

    public List<JstMember> getMemberByName(String name) {
        List<Long> ids = memberService.getMemberIdsByName(name);
        List<JstMember> list = new ArrayList<JstMember>();
        if (CollectionUtils.isEmpty(ids)) {
            return list;
        }
        JstMember jstMember = null;
        for (long id : ids) {
            jstMember = memberService.getMemberById(id);
            list.add(jstMember);
        }
        return list;
    }

    public Map<String, Object> getMembers(int page, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", memberService.getMemberCount());
        int start = (page - 1)*num;
        List<Long> ids = memberService.getMemberIds(start, num);
        List<ResponseMember> members = new ArrayList<ResponseMember>();
        JstMember member = null;
        ResponseMember resMem = null;
        for (long id : ids) {
            member = memberService.getMemberById(id);
            resMem = new ResponseMember();
            BeanUtils.copyProperties(member,resMem);
            resMem.setConsumeCount(orderService.getTotalByMemberId(id));
            resMem.setConsumeNum(member.getExpenseAmount().intValue());
            resMem.setMemDiscount(member.getMemDiscount());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            resMem.setRegisterTime(sdf.format(member.getRegisterTime()));
            members.add(resMem);
        }
        map.put("list", members);
        map.put("page", start);
        return map;
    }

    public Map<String, Object> getMemberInfo(long memberId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mem", memberService.getMemberById(memberId));
        map.put("chargeList", chargeService.getChargeListByMemberId(memberId));
        List<ResponseOrder> orderList = new ArrayList<ResponseOrder>();
        List<Long> ids = new ArrayList<Long>();
        ids = orderService.getOrderIdsByMem(memberId);
        if (!CollectionUtils.isEmpty(ids)) {
            ResponseOrder order = null;
            JstOrder jstOrder = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (long id:ids) {
                order = new ResponseOrder();
                jstOrder = orderService.getOrderById(id);
                String pid = jstOrder.getProductId();
                String productName = "";
                int a = pid.split(", ").length;
                if (a > 1) {
                    List<String> names = new ArrayList<String>();
                    for (String i : pid.split(", ")) {
                        JstProduct p = productService.getProductById(Long.valueOf(i));
                        names.add(p.getProductName());
                    }
                    productName = names.toString().substring(1, names.toString().length() - 1);
                } else {
                    JstProduct p = productService.getProductById(Long.valueOf(jstOrder.getProductId()));
                    productName = p.getProductName();
                }
                order.setProductName(productName);
                order.setRealPrice(jstOrder.getRealPrice());
                order.setOrderTime(sdf.format(jstOrder.getAddTime()));
                orderList.add(order);
            }
        }
        map.put("expenseList", orderList);
        return map;
    }

    public int revokeMember(long id) {
        return memberService.revokeMember(id);
    }
}
