package com.jst.web.model.database;

/**
 * Created by Stefan on 2017/3/1.
 */
public class JstEmployee {

    // 职工id
    private long id;
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
    // 修改时间
    private long updateTime;
    // 入职时间
    private long joinTime;
    // 离职时间
    private long dimissionTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(long joinTime) {
        this.joinTime = joinTime;
    }

    public boolean isGender() {
        return gender;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getDimissionTime() {
        return dimissionTime;
    }

    public void setDimissionTime(long dimissionTime) {
        this.dimissionTime = dimissionTime;
    }
}
