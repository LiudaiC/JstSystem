package com.jst.web.model.request;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/9.
 */
public class RequestProduct {

    private long id;
    private String productName;
    private BigDecimal originalPrice;
    private BigDecimal vipPrice;
    private BigDecimal discountPrice;
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

    @Override
    public String toString() {
        return "RequestProduct{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", originalPrice=" + originalPrice +
                ", vipPrice=" + vipPrice +
                ", discountPrice=" + discountPrice +
                ", proportion=" + proportion +
                ", memProportion=" + memProportion +
                ", promotionProportion=" + promotionProportion +
                '}';
    }
}
