package com.jst.web.service;

import com.jst.web.dao.JstOrderDAO;
import com.jst.web.model.database.JstOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/10.
 */
@Service
public class JstOrderService {

    @Autowired
    private JstOrderDAO orderDAO;

    public void saveOrder(JstOrder order) {
        orderDAO.saveOrder(order);
    }

    public JstOrder getOrderById(long id) {
        return orderDAO.getOrderById(id);
    }

    public JstOrder getOrderByName(String name) {
        return orderDAO.getOrderByName(name);
    }

    public List<Long> getOrderIds(long empId, long monthBegin) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("empId", empId);
        map.put("monthBegin", monthBegin);
        return orderDAO.getOrderIdsInMonth(map);
    }

    public List<Long> getOrderIds(Map<String, Object> m) {
        return orderDAO.getOrderIds(m);
    }

    public int revokeOrder(long orderId) {
       return orderDAO.revokeOrder(orderId);
    }

    public int getOrderCount() {
        return orderDAO.getOrderCount();
    }

    public int getTotalByMemberId(long memId) {
        return orderDAO.getTotalByMemberId(memId);
    };

    public List<Long> getOrderIdsByMem(long memId) {
        return orderDAO.getOrderIdsByMem(memId);
    }

}
