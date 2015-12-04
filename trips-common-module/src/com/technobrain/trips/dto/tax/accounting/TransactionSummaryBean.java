package com.technobrain.trips.dto.tax.accounting;

import com.technobrain.trips.common.constants.Constants;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.Calendar;


public class TransactionSummaryBean extends GenericSummaryBean{
    private Long transactionID;
    private String transactionType;
    private String transReference;
    private String transCurrency;
    private boolean payment;
    private Long revAccId;
    private Long ddocDocument;
    private BigDecimal debitAmt;
    private BigDecimal creditAmt;
    private String acctTranSign;
    private BigDecimal balance;
    private String taxType;
    private String returnPeriod;
    
    public TransactionSummaryBean(){}
    
    public TransactionSummaryBean (Long transactionID, String periodNo,String periodYear,Timestamp transactionDate,String transactionType,BigDecimal amount){
        try {
            this.transactionID = transactionID;
            this.period = periodNo + "/" +  periodYear;
            this.date = toDate(transactionDate);
            this.transactionType = transactionType;
            this.amount = null != amount ? amount : null;
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
    
    public TransactionSummaryBean (Long revAccId, String transCurrency,Long transactionID, String transReference, Timestamp transactionDate,String transactionType,BigDecimal amount, Long ddocDocument, String accTran, String acctTranSign, BigDecimal balance){
        try {
            this.transactionID = transactionID;
            this.transReference = transReference;
            this.transCurrency = transCurrency;
            this.date = toDate(transactionDate);
            this.transactionType = transactionType;
            this.amount = null != amount ? amount : null;
            this.revAccId = revAccId;
            this.ddocDocument = ddocDocument;
            if (accTran != null) {
                if (accTran.equalsIgnoreCase(Constants.AccountingType.DEBIT)) {
                    this.debitAmt = amount;
                } else if (accTran.equalsIgnoreCase(Constants.AccountingType.CREDIT)) {
                    this.creditAmt = amount;
                }
            }
            this.acctTranSign = acctTranSign;
            this.balance = balance;
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

     public TransactionSummaryBean (Long revAccId, String transCurrency,Long transactionID, String transReference, Timestamp transactionDate,String transactionType,BigDecimal amount, Long ddocDocument, String accTran, String acctTranSign, BigDecimal balance, String taxType, String returnPeriod){
         try {
             this.transactionID = transactionID;
             this.transReference = transReference;
             this.transCurrency = transCurrency;
             this.date = toDate(transactionDate);
             this.transactionType = transactionType;
             this.amount = null != amount ? amount : null;
             this.revAccId = revAccId;
             this.ddocDocument = ddocDocument;
             if (accTran != null) {
                 if (accTran.equalsIgnoreCase(Constants.AccountingType.DEBIT)) {
                     this.debitAmt = amount;
                 } else if (accTran.equalsIgnoreCase(Constants.AccountingType.CREDIT)) {
                     this.creditAmt = amount;
                 }
             }
             this.acctTranSign = acctTranSign;
             this.balance = balance;
             this.taxType =taxType;
             this.returnPeriod=returnPeriod;
         }
         catch (Exception e) {
             log.error(e.getLocalizedMessage(), e);
         }
     }
    
    
    /**
     * Converts to a Calendar
     * @param _timestamp
     * @return
     */
    private Calendar toDate(Timestamp _timestamp) {
        if(_timestamp == null)
            return null;
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(_timestamp.getTime()));
        return c;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransReference(String transReference) {
        this.transReference = transReference;
    }

    public String getTransReference() {
        return transReference;
    }

    public void setTransCurrency(String transCurrency) {
        this.transCurrency = transCurrency;
    }

    public String getTransCurrency() {
        return transCurrency;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setRevAccId(Long revAccId) {
        this.revAccId = revAccId;
    }

    public Long getRevAccId() {
        return revAccId;
    }

    public void setDdocDocument(Long ddocDocument) {
        this.ddocDocument = ddocDocument;
    }

    public Long getDdocDocument() {
        return ddocDocument;
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

    public void setAcctTranSign(String acctTranSign) {
        this.acctTranSign = acctTranSign;
    }

    public String getAcctTranSign() {
        return acctTranSign;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    
    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getReturnPeriod() {
        return returnPeriod;
    }

    public void setReturnPeriod(String returnPeriod) {
        this.returnPeriod = returnPeriod;
    }
}
