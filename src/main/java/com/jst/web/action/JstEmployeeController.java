package com.jst.web.action;

import com.jst.web.manager.JstEmployeeManager;
import com.jst.web.model.database.JstEmployee;
import com.jst.web.model.request.RequestEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("/employee/{name}")
    public JstEmployee getEmployee(@PathVariable("name") String name){
        return employeeManager.getEmployeeByName(name);
    }

    @RequestMapping("/employees")
    public Map<String, Object> getEmployees(int page, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = employeeManager.getEmployees(page, num);
        return map;
    }


}
