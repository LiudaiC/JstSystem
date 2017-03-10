package com.jst.web.service;

import com.jst.web.dao.JstEmployeeDAO;
import com.jst.web.model.database.JstEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
