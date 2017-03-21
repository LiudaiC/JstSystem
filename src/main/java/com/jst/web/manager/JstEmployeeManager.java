package com.jst.web.manager;

import com.jst.web.model.database.JstAccount;
import com.jst.web.model.database.JstEmployee;
import com.jst.web.model.request.RequestEmployee;
import com.jst.web.service.JstAccountService;
import com.jst.web.service.JstEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/9.
 */
@Component
public class JstEmployeeManager {

    @Autowired
    private JstEmployeeService employeeService;
    @Autowired
    private JstAccountService accountService;

    public JstAccount getAccountByEmpId(long empId){
        return accountService.getAccount(empId);
    }

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
        JstAccount account = new JstAccount();
        account.setAdminRight(emp.getAdminRight());
        account.setAccount(reqEmp.getAccount());
        account.setPassword(reqEmp.getPassword());
        account.setEmpId(reqEmp.getEmpId());
        accountService.saveAccount(account);
        return emp.getId();
    }

    public JstEmployee getEmployeeById(long id) {
        return employeeService.getEmployeeById(id);
    }

    public JstEmployee getEmployeeByName(String name) {
        return employeeService.getEmployeeByName(name);
    }

    public Map<String, Object> getEmployees(int page, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", employeeService.getEmployeeCount());
        int start = (page - 1)*num;
        List<Long> ids = employeeService.getEmployeeIds(start, num);
        List<JstEmployee> products = new ArrayList<JstEmployee>();
        for (long id : ids) {
            products.add(employeeService.getEmployeeById(id));
        }
        map.put("list", products);
        map.put("page", start);
        return map;
    }

}
