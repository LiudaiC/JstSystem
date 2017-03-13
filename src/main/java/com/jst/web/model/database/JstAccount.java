package com.jst.web.model.database;

import java.sql.Timestamp;

/**
 * Created by Stefan on 2017/3/1.
 */
public class JstAccount {
    private long id;
    // 员工账号
    private long empId;
    // 管理权限
    private int adminRight;
    // 登录账号
    private String loginName;
    // 登录密码
    private String loginPwd;
    // 上次登录时间
    private Timestamp lastLoginTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public int getAdminRight() {
        return adminRight;
    }

    public void setAdminRight(int adminRight) {
        this.adminRight = adminRight;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
