package com.jst.web.dao;

import com.jst.web.model.database.JstEmployee;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/10.
 */
public interface JstEmployeeDAO {

    public long saveEmployee(JstEmployee emp);
    public long updateEmployee(JstEmployee emp);
    public JstEmployee getEmployeeById(long id);
    public JstEmployee getEmployeeByName(String name);
    public List<Long> getEmployeeIds(Map map);
    public int getEmployeeCount();

}
