package com.jst.web.manager;

import com.jst.web.model.database.JstOrder;
import com.jst.web.model.request.RequestOrder;
import com.jst.web.service.JstOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

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
}
