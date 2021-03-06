package com.jst.web.service;

import com.jst.web.dao.JstEmployeeDAO;
import com.jst.web.model.database.JstEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/10.
 */
@Service
public class JstEmployeeService {

    @Autowired
    private JstEmployeeDAO employeeDAO;

    public void saveEmployee(JstEmployee employee) {
        employeeDAO.saveEmployee(employee);
    }

    public void updateEmployee(JstEmployee employee) {
        employeeDAO.updateEmployee(employee);
    }

    public JstEmployee getEmployeeById(long id) {
        return employeeDAO.getEmployeeById(id);
    }

    public JstEmployee getEmployeeByName(String name) {
        return employeeDAO.getEmployeeByName(name);
    }

    public List<Long> getActiveEmployeeIds(int start, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", start);
        map.put("num", num);
        return employeeDAO.getActiveEmployeeIds(map);
    }

    public List<Long> getAllEmployeeIds(int start, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", start);
        map.put("num", num);
        return employeeDAO.getActiveEmployeeIds(map);
    }

    public int getEmployeeCount() {
        return employeeDAO.getEmployeeCount();
    }

    public void deleteEmployee(Timestamp updateTime, Timestamp dismissionTime, long id) {
        Map map = new HashMap();
        map.put("updateTime", updateTime);
        map.put("dismissionTime", dismissionTime);
        map.put("id", id);
        employeeDAO.deactiveEmployee(map);
    }
}
