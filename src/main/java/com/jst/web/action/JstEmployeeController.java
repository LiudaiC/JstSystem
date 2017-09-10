package com.jst.web.action;

import com.jst.web.manager.JstEmployeeManager;
import com.jst.web.model.database.JstEmployee;
import com.jst.web.model.request.RequestEmployee;
import com.jst.web.model.response.ResponseEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public long saveEmployee(@RequestBody RequestEmployee emp) {
        long empId = employeeManager.saveEmployee(emp);
        return empId;
    }

    @RequestMapping("/employees/{id}")
    public ResponseEmployee getEmployee(@PathVariable("id") long id){
        return employeeManager.getEmployeeById(id);
    }

    @PostMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") long id) {
        employeeManager.deleteEmployee(id);
        return new ResponseEntity("OK", HttpStatus.OK);
    }

    @RequestMapping("/employees/query/{name}")
    public JstEmployee getEmployee(@PathVariable("name") String name){
        return employeeManager.getEmployeeByName(name);
    }

    @RequestMapping("/employees")
    public Map<String, Object> getEmployees(int page, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = employeeManager.getEmployees(page, num);
        return map;
    }

    @RequestMapping("/employees/all")
    public Map<String, Object> getEmployees() {
        Map<String, Object> map = new HashMap<String, Object>();
        map = employeeManager.getEmployees(1, 1000);
        return map;
    }


}
