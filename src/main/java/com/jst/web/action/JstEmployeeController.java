package com.jst.web.action;

import com.jst.web.manager.JstEmployeeManager;
import com.jst.web.model.database.JstEmployee;
import com.jst.web.model.request.RequestEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/10.
 */
@RestController
@RequestMapping("/jst")
public class JstEmployeeController {

    @Autowired
    private JstEmployeeManager employeeManager;

    @RequestMapping("/employee/save")
    public long saveEmployee(RequestEmployee emp) {
        long empId = employeeManager.saveEmployee(emp);
        return empId;
    }

    @RequestMapping("/employee/{id}")
    public JstEmployee getEmployee(@PathVariable("id") long id){
        return employeeManager.getEmployeeById(id);
    }
}
