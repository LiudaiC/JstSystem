package com.jst.web.model.database;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Stefan on 2017/4/21.
 */
public class JstCharge {

    private long id;
    private long memberId;
    private BigDecimal chargeAmount;
    private BigDecimal extraAmount;
    private BigDecimal memDiscount;
    private Timestamp chargeTime;
    private String remark;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
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

    public void setExtraAmount(BigDecimal extraAmount) {
        this.extraAmount = extraAmount;
    }

    public BigDecimal getMemDiscount() {
        if (memDiscount == null) {
            memDiscount = BigDecimal.ONE;
        }
        return memDiscount;
    }

    public void setMemDiscount(BigDecimal memDiscount) {
        this.memDiscount = memDiscount;
    }

    public Timestamp getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(Timestamp chargeTime) {
        this.chargeTime = chargeTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
