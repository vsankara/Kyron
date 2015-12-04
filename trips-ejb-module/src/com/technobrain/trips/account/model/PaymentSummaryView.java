package com.technobrain.trips.account.model;

import com.technobrain.trips.document.model.DfinRevCollReceipt;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries ( 
    {
    
    @NamedQuery(name = "PaymentSummaryView.findAll", 
    query = "select o from PaymentSummaryView o"),
    @NamedQuery(name = "PaymentSummaryView.findReceiptByTin", 
    query = "select o from PaymentSummaryView o where o.tin=?1 order by o.receiptId desc ")
    }
)

@Table(name = "PAYMENT_SUMMARY")
public class PaymentSummaryView implements Serializable {
    @Id
    @Column(name="RECEIPT_ID", nullable = false)
    private Long receiptId;
    
    @Column(name="PAYMENT_AMOUNT")
    private Double paymentAmount;
    
    @Column(name="PAYMENT_DATE")
    private Timestamp paymentDate;
    
    @Column(name="PAYMENT_STATUS")
    private String paymentStatus;
    
    @Column(name="RECEIPT_NUMBER")
    private String receiptNumber;
    
    @Column(name="DOCDESC")
    private String docDescription;
    
    private String tin;
    
     
    @JoinColumn(name = "RECEIPT_ID",referencedColumnName = "ID", insertable=false,updatable=false)
    private DfinRevCollReceipt dfinRevCollReceipt;

    public PaymentSummaryView() {
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public void setDocDescription(String docDescription) {
        this.docDescription = docDescription;
    }

    public String getDocDescription() {
        return docDescription;
    }

    public void setDfinRevCollReceipt(DfinRevCollReceipt dfinRevCollReceipt) {
        this.dfinRevCollReceipt = dfinRevCollReceipt;
    }

    public DfinRevCollReceipt getDfinRevCollReceipt() {
        return dfinRevCollReceipt;
    }
}
