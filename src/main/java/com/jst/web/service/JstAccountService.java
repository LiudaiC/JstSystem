package com.jst.web.service;

import com.jst.web.dao.JstAccountDAO;
import com.jst.web.model.database.JstAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public JstAccount getAccount(String name, String pwd) {
        return accountDAO.getAccount(name, pwd);
    }

    public JstAccount getAccount(long empId) {
        return accountDAO.getAccountByEmpId(empId);
    }
}
