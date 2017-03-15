package com.jst.web.model.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/3/15.
 */
public class ResponseMember {
    private long id;
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
    // 注册时间
    private Timestamp registerTime;
    // 修改时间
    private Timestamp updateTime;
    // 注销时间
    private Timestamp cancelledTime;
    // 消费次数
    private int consumeCount;
    // 消费积分
    private int consumeNum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Timestamp getCancelledTime() {
        return cancelledTime;
    }

    public void setCancelledTime(Timestamp cancelledTime) {
        this.cancelledTime = cancelledTime;
    }

    public int getConsumeCount() {
        return consumeCount;
    }

    public void setConsumeCount(int consumeCount) {
        this.consumeCount = consumeCount;
    }

    public int getConsumeNum() {
        return consumeNum;
    }

    public void setConsumeNum(int consumeNum) {
        this.consumeNum = consumeNum;
    }
}
