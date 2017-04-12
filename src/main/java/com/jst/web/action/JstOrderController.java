package com.jst.web.action;

import com.jst.web.manager.JstOrderManager;
import com.jst.web.model.database.JstAccount;
import com.jst.web.model.database.JstEmployee;
import com.jst.web.model.database.JstOrder;
import com.jst.web.model.request.RequestEmployee;
import com.jst.web.model.request.RequestOrder;
import com.jst.web.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public long saveOrder(RequestOrder emp) {
        JstAccount account = SecurityUtil.getAccount();
        long empId = orderManager.saveOrder(account.getEmpId(), emp);
        return empId;
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
        map = orderManager.getOrders(page, num);
        return map;
    }
}
