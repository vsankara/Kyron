package com.technobrain.trips.dto.tax.accounting;

import com.technobrain.trips.dto.DataTransferObject;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PaymentSummaryInquiry implements DataTransferObject {
    
    private String receiptNumber;
    private Long receiptID;
    private Calendar paymentDate;
    private BigDecimal paymentAmount;
    private String paymentStatus;
    
    private List<GenericTransactionPeriodBean> paymentTransactionList;
    
    
    public PaymentSummaryInquiry() {
    }

    public void setPaymentTransactionList(List<GenericTransactionPeriodBean> paymentTransactionList) {
        this.paymentTransactionList = paymentTransactionList;
    }

    public List<GenericTransactionPeriodBean> getPaymentTransactionList() {
        return paymentTransactionList;
    }
    
    
    public void add(GenericTransactionPeriodBean bean){
        if(paymentTransactionList == null) paymentTransactionList = new ArrayList();
        bean.setPaymentSummaryInquiry(this);
        paymentTransactionList.add(bean);
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptID(Long receiptID) {
        this.receiptID = receiptID;
    }

    public Long getReceiptID() {
        return receiptID;
    }

    public void setPaymentDate(Calendar paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Calendar getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
}
