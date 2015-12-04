package com.technobrain.trips.dto.tax.accounting;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.dto.DataTransferObject;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class GenericRegimePeriodSummaryBean implements DataTransferObject {
    private Long periodId;
    private String period;
    private BigDecimal periodBalance;
    private List<GenericTransactionPeriodBean> periodTransactionList;
    private List<GenericTransactionPeriodBean> adhocTransactionList;
    private BigDecimal regimeBalance;
    private String periodLabel;
    private String transactionType;
    private String periodBalForDisplay;
    private String taxReturnType;
    private String adhocRevenueType;
    private List<GenericTransactionPeriodBean> documentDataList;
    private String periodStatus;
    private String recordStatus;
    private String taxReturnTypeDesc;
    private Calendar returnDueDate;
    private Calendar paymentDueDate;
    
    public GenericRegimePeriodSummaryBean() {
    }
    
    public GenericRegimePeriodSummaryBean(Long periodId, BigDecimal periodNo,String periodYear,BigDecimal periodBal) {
        this.periodId = periodId;
        this.period = (periodNo == null ? null : periodNo.longValue()) + "/" + periodYear;
        this.periodBalance = periodBal;
    }

    public GenericRegimePeriodSummaryBean(Long periodId, Integer periodNo,Integer periodYear,BigDecimal periodBal) {
        this.periodId = periodId;
        this.period = (periodNo == null ? null : periodNo.longValue()) + "/" + periodYear;
        this.periodBalance = periodBal;
    }
    
    public GenericRegimePeriodSummaryBean(Long periodId, Integer periodNo,Integer periodYear,BigDecimal periodBal,String taxReturnType, String periodStatus) {
        this.periodId = periodId;
        this.period = (periodNo == null ? null : periodNo.longValue()) + "/" + periodYear;
        this.periodBalance = periodBal;
        this.taxReturnType=taxReturnType;
        this.periodStatus = periodStatus;
    }
    
    public GenericRegimePeriodSummaryBean(Long periodId, Integer periodNo,Integer periodYear,BigDecimal periodBal,
                String taxReturnType, String periodStatus, String recordStatus, Timestamp returnDueDate, Timestamp paymentDueDate,
                String taxReturnTypeDesc) {
        this.periodId = periodId;
        this.period = (periodNo == null ? null : periodNo.longValue()) + "/" + periodYear;
        this.periodBalance = periodBal;
        this.taxReturnType=taxReturnType;
        this.periodStatus = periodStatus;
        this.recordStatus = recordStatus;
        this.returnDueDate=DateHelper.getCalendar(returnDueDate) ;
        this.paymentDueDate=DateHelper.getCalendar(paymentDueDate);
        this.taxReturnTypeDesc=taxReturnTypeDesc;
    }
    
    public GenericRegimePeriodSummaryBean(Long periodId, BigDecimal periodNo,String periodYear,BigDecimal periodBal,String periodLabel) {
        this.periodId = periodId;
        this.period = (periodNo == null ? null : periodNo.longValue()) + "/" + periodYear;
        this.periodBalance = periodBal;
        this.periodLabel = periodLabel;
    }
    
    public void addGenericTransactionPeriodBean(GenericTransactionPeriodBean bean){
        if(periodTransactionList == null) periodTransactionList = new ArrayList();
        bean.setPeriodSummary(this);
        periodTransactionList.add(bean);
    }
    
    public void setPeriodTransactionList(List<GenericTransactionPeriodBean>  periodTransactions) {
        this.periodTransactionList = periodTransactions;
    }

    public List<GenericTransactionPeriodBean>  getPeriodTransactionList() {
        return periodTransactionList;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriodBalance(BigDecimal periodBalance) {
        this.periodBalance = periodBalance;
    }

    public BigDecimal getPeriodBalance() {
        return periodBalance;
    }

    public void setRegimeBalance(BigDecimal regimeBalance) {
        this.regimeBalance = regimeBalance;
    }

    public BigDecimal getRegimeBalance() {
        return regimeBalance;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodLabel(String periodLabel) {
        this.periodLabel = periodLabel;
    }

    public String getPeriodLabel() {
        return periodLabel;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setPeriodBalForDisplay(String periodBalForDisplay) {
        this.periodBalForDisplay = periodBalForDisplay;
    }

    public String getPeriodBalForDisplay() {
        return periodBalForDisplay;
    }


    public void setTaxReturnType(String taxReturnType) {
        this.taxReturnType = taxReturnType;
    }

    public String getTaxReturnType() {
        return taxReturnType;
    }

    public void setAdhocTransactionList(List<GenericTransactionPeriodBean> adhocTransactionList) {
        this.adhocTransactionList = adhocTransactionList;
    }

    public List<GenericTransactionPeriodBean> getAdhocTransactionList() {
        return adhocTransactionList;
    }

    public void setAdhocRevenueType(String adhocRevenueType) {
        this.adhocRevenueType = adhocRevenueType;
    }

    public String getAdhocRevenueType() {
        return adhocRevenueType;
    }

    public void setDocumentDataList(List<GenericTransactionPeriodBean> documentDataList) {
        this.documentDataList = documentDataList;
    }

    public List<GenericTransactionPeriodBean> getDocumentDataList() {
        return documentDataList;
    }

    public String getPeriodStatus() {
        return periodStatus;
    }

    public void setPeriodStatus(String periodStatus) {
        this.periodStatus = periodStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getRecordStatus() {
        return recordStatus;
    }
    
    public boolean isPeriodActive(){
        if(Constants.RecordStatus.ACTIVE.equalsIgnoreCase(recordStatus)){
            return true;
        } 
        return false;
    }

    public void setTaxReturnTypeDesc(String taxReturnTypeDesc) {
        this.taxReturnTypeDesc = taxReturnTypeDesc;
    }

    public String getTaxReturnTypeDesc() {
        return taxReturnTypeDesc;
    }

    public void setReturnDueDate(Calendar returnDueDate) {
        this.returnDueDate = returnDueDate;
    }

    public Calendar getReturnDueDate() {
        return returnDueDate;
    }

    public void setPaymentDueDate(Calendar paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public Calendar getPaymentDueDate() {
        return paymentDueDate;
    }
}
