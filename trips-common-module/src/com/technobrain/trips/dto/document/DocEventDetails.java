package com.technobrain.trips.dto.document;

import com.technobrain.trips.dto.tax.accounting.GenericTransactionPeriodBean;




import java.math.BigDecimal;

import java.text.DecimalFormat;

import java.text.NumberFormat;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DocEventDetails {
    public DocEventDetails(Locale loc) {
        this.locale = loc;
    }
    
    private Long docEvent;
    
    private Locale locale;
    private String eventDesciption;
    
    private String eventTypeCategory;
    
    private String   balanceToshow;
    
    private boolean periodStatusActive = true;
   
    private Calendar  eventDate;
    private List<GenericTransactionPeriodBean> associatedTransactions;

    public void setDocEvent(Long docEvent) {
        this.docEvent = docEvent;
    }

    public Long getDocEvent() {
        return docEvent;
    }

    public void setEventDesciption(String eventDesciption) {
        this.eventDesciption = eventDesciption;
    }

    public String getEventDesciption() {
        return eventDesciption;
    }

    public void setEventTypeCategory(String eventTypeCategory) {
        this.eventTypeCategory = eventTypeCategory;
    }

    public String getEventTypeCategory() {
        return eventTypeCategory;
    }

    public void setAssociatedTransactions(List<GenericTransactionPeriodBean> associatedTransactions) {
        this.associatedTransactions = associatedTransactions;
    }

    public List<GenericTransactionPeriodBean> getAssociatedTransactions() {
        if(associatedTransactions == null){
            associatedTransactions = new ArrayList<GenericTransactionPeriodBean>();
        }
        return associatedTransactions;
    }

    public void setEventDate(Calendar eventDate) {
        this.eventDate = eventDate;
    }

    public Calendar getEventDate() {
        return eventDate;
    }
    
    public String getEventBalance(){
         
        if (balanceToshow == null) {
            BigDecimal sumOfCrAmounts = new BigDecimal(0).setScale(2);
            BigDecimal sumOfDbAmounts = new BigDecimal(0).setScale(2);
            if (associatedTransactions != null) {
                for(GenericTransactionPeriodBean trnBean : associatedTransactions) {
                    if (trnBean.getBalanceDue() != null) {
                        if(trnBean.getTransactionType() != null && trnBean.getTransactionType().equals("DEBIT")){
                         sumOfDbAmounts = sumOfDbAmounts.add(trnBean.getBalanceDue());
                        }
                        if(trnBean.getTransactionType() != null && trnBean.getTransactionType().equals("CREDIT")){
                          sumOfCrAmounts = sumOfCrAmounts.add(trnBean.getBalanceDue());
                        }
                    }
                }
            }
            String transactionType = "";
            BigDecimal totalBalance = sumOfDbAmounts.subtract(sumOfCrAmounts);
            if (totalBalance.doubleValue()<0){
                transactionType = "CR";
            }
            totalBalance = totalBalance.abs();
            DecimalFormat decimalFormat = getDecimalFormat();
            decimalFormat.setMaximumFractionDigits(2);
            decimalFormat.setMinimumFractionDigits(2);
            decimalFormat.setGroupingUsed(true);   
            String formatted = decimalFormat.format(totalBalance);
            balanceToshow = formatted + " "+transactionType;
        }
        return balanceToshow;
    }
    private DecimalFormat getDecimalFormat(){
        DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getInstance(locale);
        return decimalFormat;
    }

    public void setPeriodStatusActive(boolean periodStatusActive) {
        this.periodStatusActive = periodStatusActive;
    }

    public boolean isPeriodStatusActive() {
        return periodStatusActive;
    }
}
