package com.jst.web.dao;

import com.jst.web.model.database.JstEmployee;
import com.jst.web.model.database.JstOrder;

import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 */
public interface JstOrderDAO {

    public long saveOrder(JstOrder order);
    public JstOrder getOrderById(long id);
    public JstOrder getOrderByName(String name);
    public List<Long> getOrderIds(int start, int num);
    public int getOrderCount();
}
