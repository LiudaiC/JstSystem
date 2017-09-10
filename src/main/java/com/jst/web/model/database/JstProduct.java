package com.jst.web.model.database;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Stefan on 2017/3/1.
 */
public class JstProduct {

    // 产品id
    private long id;
    // 产品名称
    private String productName;
    // 原价
    private BigDecimal originalPrice;
    // 会员价
    private BigDecimal vipPrice;
    // 优惠价
    private BigDecimal discountPrice;
    // 新增时间
    private Timestamp addTime;
    // 更新时间
    private Timestamp updateTime;
    // 操作人员
    private long opEmployee;
    // 项目分成
    private BigDecimal proportion;
    // 会员价提成
    private BigDecimal memProportion;
    //活动价提成
    private BigDecimal promotionProportion;

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

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public long getOpEmployee() {
        return opEmployee;
    }

    public void setOpEmployee(long opEmployee) {
        this.opEmployee = opEmployee;
    }

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    public BigDecimal getMemProportion() {
        return memProportion;
    }

    public void setMemProportion(BigDecimal memProportion) {
        this.memProportion = memProportion;
    }

    public BigDecimal getPromotionProportion() {
        return promotionProportion;
    }

    public void setPromotionProportion(BigDecimal promotionProportion) {
        this.promotionProportion = promotionProportion;
    }
}
