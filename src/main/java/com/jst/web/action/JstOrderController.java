package com.jst.web.action;

import com.jst.web.constant.Constant;
import com.jst.web.interceptor.JstInterceptor;
import com.jst.web.manager.JstOrderManager;
import com.jst.web.model.database.JstAccount;
import com.jst.web.model.database.JstOrder;
import com.jst.web.model.request.CommonRequest;
import com.jst.web.model.request.RequestOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/9.
 */
@RestController
@RequestMapping("/jst")
public class JstOrderController {

    @Autowired
    private JstOrderManager orderManager;

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public long saveOrder(@RequestBody RequestOrder order, HttpServletRequest req, HttpServletResponse res) {
        JstAccount account = JstInterceptor.authenticate(req, res);
        long empId = order.getEmpId() > 0 ? order.getEmpId() : account.getEmpId();
        long orderId = orderManager.saveOrder(empId, order);
        return orderId;
    }

    @RequestMapping("/orders/all")
    public Map<String, Object> getOrders(HttpServletRequest req, HttpServletResponse res) {
        Map<String, Object> map = new HashMap<String, Object>();
        JstAccount account = JstInterceptor.authenticate(req, res);
        long empId = account.getAdminRight() > Constant.ALL_RIGHT ? 0 : account.getEmpId();
        map = orderManager.getOrders(empId,1,1000);
        return map;
    }

    @RequestMapping("/orders/users/{empId}")
    public Map<String, Object> getOrders(@PathVariable("empId") long empId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = orderManager.getOrdersInMonth(empId, new BigDecimal(0));
        map.put("list", orderManager.getOrders(empId,1,1000).get("list"));
        return map;
    }

    @RequestMapping("/orders/personal")
    public Map<String, Object> getPersonalOrders(HttpServletRequest req, HttpServletResponse res) {
        JstAccount account = JstInterceptor.authenticate(req,res);
        long empId = account.getAdminRight() > Constant.ALL_RIGHT ? 0 : account.getEmpId();
        BigDecimal proportion = account.getAdminRight() > Constant.ALL_RIGHT ? new BigDecimal(10) : new BigDecimal(0);
        return orderManager.getOrdersInMonth(empId, proportion);
    }

    @RequestMapping("/orders/revoke")
    public int revokeOrder(@RequestBody CommonRequest com ) {
        return orderManager.revokeOrder(com.getId());
    }
    @RequestMapping("/orders/{id}")
    public JstOrder getOrder(@PathVariable("id") long id){
        return orderManager.getOrderById(id);
    }

    @RequestMapping("/orders/{name}")
    public JstOrder getOrder(@PathVariable("name") String name){
        return orderManager.getOrderByName(name);
    }

    @RequestMapping("/orders")
    public Map<String, Object> getOrders(int page, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = orderManager.getOrders(0, page, num);
        return map;
    }
}
