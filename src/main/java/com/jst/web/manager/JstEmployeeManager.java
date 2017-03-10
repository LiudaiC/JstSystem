package com.jst.web.manager;

import com.jst.web.model.database.JstEmployee;
import com.jst.web.model.request.RequestEmployee;
import com.jst.web.service.JstEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/3/9.
 */
@Component
public class JstEmployeeManager {

    @Autowired
    private JstEmployeeService employeeService;

    public long saveEmployee(RequestEmployee reqEmp) {
        JstEmployee emp = new JstEmployee();
        emp.setName(reqEmp.getName());
        emp.setPhone(reqEmp.getName());
        emp.setGender(reqEmp.isGender());
        emp.setIdNum(reqEmp.getIdNum());
        emp.setAddress(reqEmp.getAddress());
        emp.setAge(reqEmp.getAge());
        emp.setAdminRight(0);
        long currTime = System.currentTimeMillis();
        Timestamp stamp = new Timestamp(currTime);
        emp.setJoinTime(stamp);
        emp.setUpdateTime(stamp);
        employeeService.saveEmployee(emp);
        return emp.getId();
    }

    public JstEmployee getEmployeeById(long id) {
        return employeeService.getEmployeeById(id);
    }
}
