package com.jst.web.dao;

import com.jst.web.model.database.JstEmployee;

import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 */
public interface JstEmployeeDAO {

    public long saveEmployee(JstEmployee emp);
    public JstEmployee getEmployeeById(long id);
    public JstEmployee getEmployeeByName(String name);
    public List<Long> getEmployeeIds(int start, int num);
    public int getEmployeeCount();

}
