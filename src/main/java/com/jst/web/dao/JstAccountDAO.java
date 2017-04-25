package com.jst.web.dao;

import com.jst.web.model.database.JstAccount;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by Stefan on 2017/3/14.
 */
public interface JstAccountDAO {

    public long saveAccount(JstAccount account);
    public long updateAccount(JstAccount account);
    public JstAccount getAccountByEmpId(@Param("empId") long empId);
    public JstAccount getAccountByName(String name);
    public int updatePassword(Map map);
}
