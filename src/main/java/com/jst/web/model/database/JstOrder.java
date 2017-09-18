package com.jst.web.model.database;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Stefan on 2017/3/7.
 */
public class JstOrder {

    // 订单id
    private long id;
    // 产品id
    private long productId;
    // 员工id
    private long employeeId;
    // 原价
    private BigDecimal originalPrice;
    // 优惠价
    private BigDecimal discountPrice;
    // 会员价
    private BigDecimal vipPrice;
    // 实际支付价格
    private BigDecimal realPrice;
    // 新增时间
    private Timestamp addTime;
    // 修改时间
    private Timestamp updateTime;
    // 会员id
    private long memberId;
    // 订单状态
    private int status;
    // 订单备注
    private String remark;

    public JstOrder() {
    }

    public JstOrder(long productId, long employeeId, BigDecimal originalPrice,
                    BigDecimal discountPrice, BigDecimal vipPrice, BigDecimal realPrice,
                    Timestamp addTime, Timestamp updateTime, long memberId,
                    String remark) {
        this.productId = productId;
        this.employeeId = employeeId;
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
        this.vipPrice = vipPrice;
        this.realPrice = realPrice;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.memberId = memberId;
        this.remark = remark;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public BigDecimal getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(BigDecimal vipPrice) {
        this.vipPrice = vipPrice;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "JstOrder{" +
                "id=" + id +
                ", productId=" + productId +
                ", employeeId=" + employeeId +
                ", originalPrice=" + originalPrice +
                ", discountPrice=" + discountPrice +
                ", vipPrice=" + vipPrice +
                ", realPrice=" + realPrice +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", memberId=" + memberId +
                ", remark='" + remark + '\'' +
                '}';
    }
}
