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
    private String account;
    // 登录密码
    private String password;
    // 上次登录时间
    private Timestamp lastLoginTime;
    // 是否有效
    private boolean active = true;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
