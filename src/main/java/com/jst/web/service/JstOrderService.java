package com.jst.web.service;

import com.jst.web.dao.JstOrderDAO;
import com.jst.web.model.database.JstOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
