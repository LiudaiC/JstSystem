package com.jst.web.model.request;

/**
 * Created by Administrator on 2017/3/9.
 */
public class RequestEmployee {

    // 姓名
    private String name;
    // 性别
    private boolean gender;
    // 管理权限：0-无权限，1-超级管理员，2-会员增改，3-产品增改，4-结账管理
    private int adminRight;
    // 年龄
    private int age;
    // 电话
    private String phone;
    // 身份证号
    private String idNum;
    // 住址
    private String address;
    // 员工id
    private long empId;
    // 账号
    private String account;
    // 密码
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAdminRight() {
        return adminRight;
    }

    public void setAdminRight(int adminRight) {
        this.adminRight = adminRight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
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
}
