package com.jst.web.model.request;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */
public class RequestOrder {

    private long productId;

    private List<Long> pids;
    private long memberId;
    private long empId;
    private BigDecimal realPrice;
    private int resultLevel;
    private int extraProportion;
    private String remark;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public List<Long> getPids() {
        return pids;
    }

    public void setPids(List<Long> pids) {
        this.pids = pids;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }


    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    public int getResultLevel() {
        return resultLevel;
    }

    public int getExtraProportion() {
        return extraProportion;
    }

    public void setExtraProportion(int extraProportion) {
        this.extraProportion = extraProportion;
    }

    public void setResultLevel(int resultLevel) {
        this.resultLevel = resultLevel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
