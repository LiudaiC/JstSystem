package com.jst.web.service;

import com.jst.web.dao.JstAccountDAO;
import com.jst.web.model.database.JstAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stefan on 2017/3/14.
 */
@Service
public class JstAccountService {

    @Autowired
    private JstAccountDAO accountDAO;

    public void saveAccount(JstAccount account) {
        accountDAO.saveAccount(account);
    }

    public void updateAccount(JstAccount account) {
        accountDAO.updateAccount(account);
    }

    public JstAccount getAccountByName(String name) {
        return accountDAO.getAccountByName(name);
    }

    public JstAccount getAccount(long empId) {
        return accountDAO.getAccountByEmpId(empId);
    }

    public int updatePassword(long accountId, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", accountId);
        map.put("password", password);
        return accountDAO.updatePassword(map);
    }
}
