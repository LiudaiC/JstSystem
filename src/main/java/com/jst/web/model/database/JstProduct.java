package com.jst.web.model.database;

import java.math.BigDecimal;

/**
 * Created by Stefan on 2017/3/1.
 */
public class JstProduct {

    private long id;
    private String productName;
    private BigDecimal originalPrice;
    private BigDecimal vipPrice;
    private BigDecimal discountPrice;
    private long addTime;
    private long updateTime;
    private long opEmployee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(BigDecimal vipPrice) {
        this.vipPrice = vipPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public long getAddTime() {
        return addTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getOpEmployee() {
        return opEmployee;
    }

    public void setOpEmployee(long opEmployee) {
        this.opEmployee = opEmployee;
    }
}
