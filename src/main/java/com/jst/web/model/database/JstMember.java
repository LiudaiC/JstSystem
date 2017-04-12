package com.jst.web.model.database;


import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Stefan on 2017/3/1.
 */
public class JstMember {

    private long id;
    // 添加员工id
    private long empId;
    // 会员卡号
    private String cardNo;
    // 会员卡状态:0 正常，1 注销
    private int status;
    // 充值金额
    private BigDecimal chargeAmount;
    // 消费金额
    private BigDecimal expenseAmount;
    // 姓名
    private String name;
    // 联系方式
    private String phone;
    // 密码
    private String password;
    // 注册时间
    private Timestamp registerTime;
    // 修改时间
    private Timestamp updateTime;
    // 注销时间
    private Timestamp cancelledTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public Timestamp getCancelledTime() {
        return cancelledTime;
    }

    public void setCancelledTime(Timestamp cancelledTime) {
        this.cancelledTime = cancelledTime;
    }
}
