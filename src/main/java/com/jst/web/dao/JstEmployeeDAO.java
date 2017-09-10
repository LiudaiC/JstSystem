package com.jst.web.dao;

import com.jst.web.model.database.JstEmployee;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/10.
 */
public interface JstEmployeeDAO {

    long saveEmployee(JstEmployee emp);
    long updateEmployee(JstEmployee emp);
    JstEmployee getEmployeeById(long id);
    JstEmployee getEmployeeByName(String name);
    List<Long> getEmployeeIds(Map map);
    int getEmployeeCount();
    void deactiveEmployee(Map map);

}
