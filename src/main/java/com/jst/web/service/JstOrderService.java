package com.jst.web.service;

import com.jst.web.dao.JstOrderDAO;
import com.jst.web.model.database.JstOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Long> getOrderIds(int start, int num) {
        return orderDAO.getOrderIds(start, num);
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
