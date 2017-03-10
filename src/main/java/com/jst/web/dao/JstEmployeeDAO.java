package com.jst.web.dao;

import com.jst.web.model.database.JstEmployee;

/**
 * Created by Administrator on 2017/3/10.
 */
public interface JstEmployeeDAO {

    public long saveEmployee(JstEmployee emp);
    public JstEmployee getEmployeeById(long id);

}
