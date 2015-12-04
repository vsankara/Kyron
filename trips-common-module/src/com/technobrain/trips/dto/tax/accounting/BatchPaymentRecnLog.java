package com.technobrain.trips.dto.tax.accounting;

import com.technobrain.trips.dto.DataTransferObject;

import java.math.BigDecimal;

import java.util.Calendar;

public class BatchPaymentRecnLog implements DataTransferObject{

    private String indicator;
    private String headAABCode;
    private Calendar collectionDate;
    private Calendar remittanceDate;
    private String branchAABCode;
    private String rdoCode;
    private String bcsStartNumber;
    private String bcsEndNumber;
    private BigDecimal cashAmount;
    private BigDecimal nonCashAmount;
    private BigDecimal bcsAmount;
    private String status;
    private BigDecimal varianceCashAmt;
    private BigDecimal varianceNonCashAmt;

    public BatchPaymentRecnLog() {
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setHeadAABCode(String headAABCode) {
        this.headAABCode = headAABCode;
    }

    public String getHeadAABCode() {
        return headAABCode;
    }

    public void setCollectionDate(Calendar collectionDate) {
        this.collectionDate = collectionDate;
    }

    public Calendar getCollectionDate() {
        return collectionDate;
    }

    public void setRemittanceDate(Calendar remittanceDate) {
        this.remittanceDate = remittanceDate;
    }

    public Calendar getRemittanceDate() {
        return remittanceDate;
    }

    public void setBranchAABCode(String branchAABCode) {
        this.branchAABCode = branchAABCode;
    }

    public String getBranchAABCode() {
        return branchAABCode;
    }

    public void setRdoCode(String rdoCode) {
        this.rdoCode = rdoCode;
    }

    public String getRdoCode() {
        return rdoCode;
    }

    public void setBcsStartNumber(String bcsStartNumber) {
        this.bcsStartNumber = bcsStartNumber;
    }

    public String getBcsStartNumber() {
        return bcsStartNumber;
    }

    public void setBcsEndNumber(String bcsEndNumber) {
        this.bcsEndNumber = bcsEndNumber;
    }

    public String getBcsEndNumber() {
        return bcsEndNumber;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setNonCashAmount(BigDecimal nonCashAmount) {
        this.nonCashAmount = nonCashAmount;
    }

    public BigDecimal getNonCashAmount() {
        return nonCashAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setVarianceCashAmt(BigDecimal varianceCashAmt) {
        this.varianceCashAmt = varianceCashAmt;
    }

    public BigDecimal getVarianceCashAmt() {
        return varianceCashAmt;
    }

    public void setVarianceNonCashAmt(BigDecimal varianceNonCashAmt) {
        this.varianceNonCashAmt = varianceNonCashAmt;
    }

    public BigDecimal getVarianceNonCashAmt() {
        return varianceNonCashAmt;
    }

    public void setBcsAmount(BigDecimal bcsAmount) {
        this.bcsAmount = bcsAmount;
    }

    public BigDecimal getBcsAmount() {
        return bcsAmount;
    }
}
