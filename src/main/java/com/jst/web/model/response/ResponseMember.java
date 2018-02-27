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
    // 赠送金额
    private BigDecimal extraAmount;
    // 消费金额
    private BigDecimal expenseAmount;
    // 余额
    private BigDecimal balanceAmount;
    //会员折扣
    private BigDecimal memDiscount;
    // 姓名
    private String name;
    // 联系方式
    private String phone;
    // 注册时间
    private String registerTime;
    // 修改时间
    private Timestamp updateTime;
    // 注销时间
    private Timestamp cancelledTime;
    // 消费次数
    private int consumeCount;
    // 消费积分
    private int consumeNum;
    // 症状备注
    private String remark;

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

    public BigDecimal getExtraAmount() {
        return extraAmount;
    }

    public void setExtraAmount(BigDecimal extraAmount) {
        this.extraAmount = extraAmount;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public BigDecimal getMemDiscount() {
        return memDiscount;
    }

    public void setMemDiscount(BigDecimal memDiscount) {
        this.memDiscount = memDiscount;
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

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
