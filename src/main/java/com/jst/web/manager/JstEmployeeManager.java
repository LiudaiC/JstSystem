package com.jst.web.manager;

import com.jst.web.model.database.JstAccount;
import com.jst.web.model.database.JstEmployee;
import com.jst.web.model.request.RequestEmployee;
import com.jst.web.model.response.ResponseEmployee;
import com.jst.web.service.JstAccountService;
import com.jst.web.service.JstEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/9.
 */
@Component
@Transactional
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
        emp.setPhone(reqEmp.getPhone());
        emp.setGender(reqEmp.isGender());
        emp.setIdNum(reqEmp.getIdNum());
        emp.setAddress(reqEmp.getAddress());
        emp.setAge(reqEmp.getAge());
        emp.setAdminRight(0);
        long currTime = System.currentTimeMillis();
        Timestamp stamp = new Timestamp(currTime);
        emp.setJoinTime(stamp);
        emp.setUpdateTime(stamp);
        JstAccount account = new JstAccount();
        account = new JstAccount();
        account.setAdminRight(reqEmp.getAdminRight());
        account.setAccount(reqEmp.getAccount());
        account.setPassword(reqEmp.getPassword());
        account.setEmpId(emp.getId());
        if (reqEmp.getId() > 0) {
            emp.setId(reqEmp.getId());
            account.setEmpId(reqEmp.getId());
            employeeService.updateEmployee(emp);
            accountService.updateAccount(account);
        } else {
            employeeService.saveEmployee(emp);
            if (!StringUtils.isEmpty(reqEmp.getAccount())) {
                if (accountService.getAccountByName(reqEmp.getAccount()) != null) {
                    return -4;
                }
                account.setEmpId(emp.getId());
                accountService.saveAccount(account);
            }
        }
        return emp.getId();
    }

    public ResponseEmployee getEmployeeById(long id) {
        ResponseEmployee res = new ResponseEmployee();
        JstEmployee emp = employeeService.getEmployeeById(id);
        res.setId(id);
        res.setName(emp.getName());
        res.setPhone(emp.getPhone());
        res.setAddress(emp.getAddress());
        res.setIdNum(emp.getIdNum());
        JstAccount account = accountService.getAccount(id);
        if (account != null) {
            res.setAccount(account.getAccount());
            res.setPassword(account.getPassword());
            res.setAdminRight(account.getAdminRight());
        }
        return res;
    }

    public JstEmployee getEmployeeByName(String name) {
        return employeeService.getEmployeeByName(name);
    }

    public Map<String, Object> getEmployees(int page, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", employeeService.getEmployeeCount());
        int start = (page - 1)*num;
        List<Long> ids = employeeService.getEmployeeIds(start, num);
        List<JstEmployee> emps = new ArrayList<JstEmployee>();
        for (long id : ids) {
            emps.add(employeeService.getEmployeeById(id));
        }
        map.put("list", emps);
        map.put("page", start);
        return map;
    }

    public void deleteEmployee(long id) {
        long currTime = System.currentTimeMillis();
        Timestamp stamp = new Timestamp(currTime);
        employeeService.deleteEmployee(stamp, stamp, id);
        JstAccount account = new JstAccount();
        account.setEmpId(id);
        account.setActive(false);
        accountService.deactiveAccount(id);
    }

}
