package com.technobrain.trips.dto.tax.period;

import com.technobrain.trips.dto.DataTransferObject;

import java.math.BigDecimal;

public class GenericPeriodBalanceBean implements DataTransferObject {

    private String transactionRef;
    private Long revledRevPeriod;
    private Long revAcc;
    private BigDecimal amount;
    private String transactionType;
    private String acctTran;
    
    public GenericPeriodBalanceBean() {
    }
    
    public GenericPeriodBalanceBean(String transactionRef, Long revledRevPeriod, Long revAcc, BigDecimal amount, String transactionType, String acctTran){
        this.transactionRef = transactionRef;
        this.revledRevPeriod = revledRevPeriod;
        this.revAcc = revAcc;
        this.amount = amount;
        this.transactionType = transactionType;
        this.acctTran = acctTran;
    }

    public void setTransactionRef(String transactionRef) {
        this.transactionRef = transactionRef;
    }

    public String getTransactionRef() {
        return transactionRef;
    }

    public void setRevledRevPeriod(Long revledRevPeriod) {
        this.revledRevPeriod = revledRevPeriod;
    }

    public Long getRevledRevPeriod() {
        return revledRevPeriod;
    }

    public void setRevAcc(Long revAcc) {
        this.revAcc = revAcc;
    }

    public Long getRevAcc() {
        return revAcc;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setAcctTran(String acctTran) {
        this.acctTran = acctTran;
    }

    public String getAcctTran() {
        return acctTran;
    }
}
