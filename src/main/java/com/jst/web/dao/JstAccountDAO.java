package com.jst.web.dao;

import com.jst.web.model.database.JstAccount;

/**
 * Created by Stefan on 2017/3/14.
 */
public interface JstAccountDAO {

    public long saveAccount(JstAccount account);
    public JstAccount getAccountByEmpId(long empId);
    public JstAccount getAccount(String loginName, String pwd);
}
