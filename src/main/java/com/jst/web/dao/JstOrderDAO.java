package com.jst.web.dao;

import com.jst.web.model.database.JstEmployee;
import com.jst.web.model.database.JstOrder;

/**
 * Created by Administrator on 2017/3/10.
 */
public interface JstOrderDAO {

    public long saveOrder(JstOrder order);
    public JstOrder getOrderById(long id);
}
