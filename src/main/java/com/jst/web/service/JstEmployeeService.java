package com.jst.web.service;

import com.jst.web.dao.JstEmployeeDAO;
import com.jst.web.model.database.JstEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public JstEmployee getEmployeeById(long id) {
        return employeeDAO.getEmployeeById(id);
    }

    public JstEmployee getEmployeeByName(String name) {
        return employeeDAO.getEmployeeByName(name);
    }

    public List<Long> getEmployeeIds(int start, int num) {
        return employeeDAO.getEmployeeIds(start, num);
    }

    public int getEmployeeCount() {
        return employeeDAO.getEmployeeCount();
    }
}
