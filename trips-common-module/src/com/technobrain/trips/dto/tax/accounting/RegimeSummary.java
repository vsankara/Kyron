package com.technobrain.trips.dto.tax.accounting;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.dto.DataTransferObject;

import java.math.BigDecimal;

import java.util.List;


public class RegimeSummary implements DataTransferObject{
    private String regimeType;
    private String revenueType;
    private String regimeNumber;
    private String regimeDescription;
    private String status;
    private BigDecimal balance;
    private String balanceForDisplay;
    private String acctTran;
    private String acctTranSign;
    private BigDecimal creditAmount;
    private BigDecimal debitAmount;
    private List<GenericRegimePeriodSummaryBean> periodInfo;
    private List<GenericRegimePeriodSummaryBean> adhocInfo;
    private String accountType;
    private List<GenericRegimeDocumentSummaryBean> genericRegimeDocumentSummaries;
    private String modeType;
    private List<GenericTransactionPeriodBean> adhocTransactionList;
    private List<GenericRegimePeriodSummaryBean> adhocPeriodList;
    private List<GenericTransactionPeriodBean>  documentDataList;
    private Long accountId;
    
    public RegimeSummary(){}
    
    public RegimeSummary(String regimeNumber,String regimeType,String regimeDescription,String status,BigDecimal balance,String accountType){
        this.regimeNumber = regimeNumber;
        this.regimeType = regimeType;
        this.regimeDescription = regimeDescription;
        this.status = status;
        this.balance = balance;
        this.accountType = accountType;
    }
    
    public RegimeSummary(String regimeNumber,String regimeType,String regimeDescription,String status,String acctTran, String acctTranSign, BigDecimal amount){
        this.regimeNumber = regimeNumber;
        this.regimeType = regimeType;
        this.regimeDescription = regimeDescription;
        this.status = status;
        this.acctTran = acctTran;
        this.acctTranSign = acctTranSign;
        if (acctTran.equalsIgnoreCase(Constants.AccountingType.DEBIT)) {
            this.debitAmount = amount;
        } else if (acctTran.equalsIgnoreCase(Constants.AccountingType.CREDIT)) {
            this.creditAmount = amount;
        }
    }
    
    public void setRegimeType(String regimeType) {
        this.regimeType = regimeType;
    }

    public String getRegimeType() {
        return regimeType;
    }

    public void setRegimeNumber(String regimeNumber) {
        this.regimeNumber = regimeNumber;
    }

    public String getRegimeNumber() {
        return regimeNumber;
    }

    public void setRegimeDescription(String regimeDescription) {
        this.regimeDescription = regimeDescription;
    }

    public String getRegimeDescription() {
        return regimeDescription;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }
        
    public void setAcctTran(String acctTran) {
        this.acctTran = acctTran;
    }

    public String getAcctTran() {
        return acctTran;
    }

    public void setAcctTranSign(String acctTranSign) {
        this.acctTranSign = acctTranSign;
    }

    public String getAcctTranSign() {
        return acctTranSign;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setPeriodInfo(List<GenericRegimePeriodSummaryBean> periodInfo) {
        this.periodInfo = periodInfo;
    }

    public List<GenericRegimePeriodSummaryBean> getPeriodInfo() {
        return periodInfo;
    }
    
    public void setGenericRegimeDocumentSummaries(List<GenericRegimeDocumentSummaryBean> genericRegimeDocumentSummaries) {
        this.genericRegimeDocumentSummaries = genericRegimeDocumentSummaries;
    }

    public List<GenericRegimeDocumentSummaryBean> getGenericRegimeDocumentSummaries() {
        return genericRegimeDocumentSummaries;
    }

    public void setBalanceForDisplay(String balanceForDisplay) {
        this.balanceForDisplay = balanceForDisplay;
    }

    public String getBalanceForDisplay() {
        return balanceForDisplay;
    }




    public void setModeType(String modeType) {
        this.modeType = modeType;
    }

    public String getModeType() {
        return modeType;
    }

    public void setAdhocInfo(List<GenericRegimePeriodSummaryBean> adhocInfo) {
        this.adhocInfo = adhocInfo;
    }

    public List<GenericRegimePeriodSummaryBean> getAdhocInfo() {
        return adhocInfo;
    }


    public void setAdhocTransactionList(List<GenericTransactionPeriodBean> adhocTransactionList) {
        this.adhocTransactionList = adhocTransactionList;
    }

    public List<GenericTransactionPeriodBean> getAdhocTransactionList() {
        return adhocTransactionList;
    }

    public void setAdhocPeriodList(List<GenericRegimePeriodSummaryBean> adhocPeriodList) {
        this.adhocPeriodList = adhocPeriodList;
    }

    public List<GenericRegimePeriodSummaryBean> getAdhocPeriodList() {
        return adhocPeriodList;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setDocumentDataList(List<GenericTransactionPeriodBean> documentDataList) {
        this.documentDataList = documentDataList;
    }

    public List<GenericTransactionPeriodBean> getDocumentDataList() {
        return documentDataList;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }
}
