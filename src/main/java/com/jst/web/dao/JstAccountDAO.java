package com.jst.web.dao;

import com.jst.web.model.database.JstAccount;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by Stefan on 2017/3/14.
 */
public interface JstAccountDAO {

    long saveAccount(JstAccount account);
    long updateAccount(JstAccount account);
    JstAccount getAccountByEmpId(@Param("empId") long empId);
    JstAccount getAccountByName(String name);
    int updatePassword(Map map);
    void deactiveAccount(@Param("empId") long empId);
}
