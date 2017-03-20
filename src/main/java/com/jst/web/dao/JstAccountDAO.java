package com.jst.web.dao;

import com.jst.web.model.database.JstAccount;

import java.util.Map;

/**
 * Created by Stefan on 2017/3/14.
 */
public interface JstAccountDAO {

    public long saveAccount(JstAccount account);
    public JstAccount getAccountByEmpId(long empId);
    public JstAccount getAccount(Map<String, String> map);
}
