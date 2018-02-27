package com.jst.web.model.request;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/9.
 */
public class RequestMember {

    private long id;
    private String name;
    private String cardNo;
    private BigDecimal chargeAmount;
    private BigDecimal extraAmount;
    private BigDecimal memDiscount;
    private String phone;
    private String password;
    private String remark;

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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public BigDecimal getExtraAmount() {
        return extraAmount;
    }

    public BigDecimal getMemDiscount() {
        return memDiscount;
    }

    public void setMemDiscount(BigDecimal memDiscount) {
        this.memDiscount = memDiscount;
    }

    public void setExtraAmount(BigDecimal extraAmount) {
        this.extraAmount = extraAmount;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
