package com.technobrain.trips.dto.tax.accounting;

import java.math.BigDecimal;

import java.util.Calendar;

public class ItemAdjustmentBean {
    private Calendar adjustmentDate;
    private BigDecimal originalAmount;
    private BigDecimal balanceDue;
    private String adjustmentReason;
    private BigDecimal adjustmentAmount;
    private Long entityId;

    public void setAdjustmentDate(Calendar adjustmentDate) {
        this.adjustmentDate = adjustmentDate;
    }

    public Calendar getAdjustmentDate() {
        return adjustmentDate;
    }

    public void setOriginalAmount(BigDecimal originalamount) {
        this.originalAmount = originalamount;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public void setBalanceDue(BigDecimal balanceDue) {
        this.balanceDue = balanceDue;
    }

    public BigDecimal getBalanceDue() {
        return balanceDue;
    }

    public void setAdjustmentReason(String adjustmentReason) {
        this.adjustmentReason = adjustmentReason;
    }

    public String getAdjustmentReason() {
        return adjustmentReason;
    }

    public void setAdjustmentAmount(BigDecimal adjustmentAmount) {
        this.adjustmentAmount = adjustmentAmount;
    }

    public BigDecimal getAdjustmentAmount() {
        return adjustmentAmount;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Long getEntityId() {
        return entityId;
    }
}
