package com.technobrain.trips.dto.tax.accounting;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Date;

public class LedgerInquiryBean {

    private String transType;
    private Timestamp transDate;
    private Timestamp postingDate;
    private Timestamp returnPeriod;
    private BigDecimal debitAmt;
    private BigDecimal creditAmt;
    private BigDecimal balance;
    private String description;
    private String transStatus;
    private BigDecimal amount;
    private String acctTran;
    private String acctTranSign;
    
    public LedgerInquiryBean() {
    }
    
    public LedgerInquiryBean(String tempTransType, Timestamp tempTransDate, Timestamp tempPostingDate, Timestamp tempReturnPeriod, BigDecimal tempDebitAmt, 
                                BigDecimal tempCreditAmt, BigDecimal tempBalance, String tempDescription, String tempTransStatus, String acctTranSign){
        
        this.transType = tempTransType;
        this.transDate = tempTransDate;
        this.postingDate = tempPostingDate;
        this.returnPeriod = tempReturnPeriod;
        this.debitAmt = tempDebitAmt;
        this.creditAmt = tempCreditAmt;
        this.balance = tempBalance;
        this.description = tempDescription;
        this.transStatus = tempTransStatus;  
        this.acctTranSign = acctTranSign;
    }
    
    public LedgerInquiryBean(String tempTransType, Timestamp tempTransDate, Timestamp tempPostingDate, Timestamp tempReturnPeriod, BigDecimal tempAmount, 
                                BigDecimal tempBalance, String tempDescription, String tempTransStatus, String tempAcctTran, String acctTranSign){
        
        this.transType = tempTransType;
        this.transDate = tempTransDate;
        this.postingDate = tempPostingDate;
        this.returnPeriod = tempReturnPeriod;
        this.amount = tempAmount; 
        this.balance = tempBalance;
        this.description = tempDescription;
        this.transStatus = tempTransStatus;    
        this.acctTran = tempAcctTran;
        this.acctTranSign = acctTranSign;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransDate(Timestamp transDate) {
        this.transDate = transDate;
    }

    public Timestamp getTransDate() {
        return transDate;
    }

    public void setReturnPeriod(Timestamp returnPeriod) {
        this.returnPeriod = returnPeriod;
    }

    public Timestamp getReturnPeriod() {
        return returnPeriod;
    }

    public void setDebitAmt(BigDecimal debitAmt) {
        this.debitAmt = debitAmt;
    }

    public BigDecimal getDebitAmt() {
        return debitAmt;
    }

    public void setCreditAmt(BigDecimal creditAmt) {
        this.creditAmt = creditAmt;
    }

    public BigDecimal getCreditAmt() {
        return creditAmt;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAcctTran(String acctTran) {
        this.acctTran = acctTran;
    }

    public String getAcctTran() {
        return acctTran;
    }

    public void setPostingDate(Timestamp postingDate) {
        this.postingDate = postingDate;
    }

    public Timestamp getPostingDate() {
        return postingDate;
    }

    public void setAcctTranSign(String acctTranSign) {
        this.acctTranSign = acctTranSign;
    }

    public String getAcctTranSign() {
        return acctTranSign;
    }
}
