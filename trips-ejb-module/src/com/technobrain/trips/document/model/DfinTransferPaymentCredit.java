package com.technobrain.trips.document.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Timestamp;

import javax.persistence.GenerationType;

@Entity
@NamedQuery(name = "DfinTransferPaymentCredit.findAll", 
    query = "select o from DfinTransferPaymentCredit o")
@Table(name = "DFIN_TRANSFER_PAYMENT_CREDIT")
//@DiscriminatorColumn(name = "DTYPE")
//@DiscriminatorValue("TRANSFERPAYMENT")
public class DfinTransferPaymentCredit extends BaseNormalModelObject   {
    
    @Id
    @Column(nullable = false)
    private Long id;
    
    @Column(name="TRANSFER_TYPE")
    private String transferType;
    
    @Column(name="SOURCE_DDOC_ID")
    private Long dDocumentId;
    
    @Column(name="TAX_TYPE")
    private String taxType;
    
    @Column(name="REV_ACC_ID")
    private Long revAccId;
    
    @Column(name="RETURN_PERIOD_ID")
    private Long returnPeriodId;
    
    @Column(name="POSTING_DATE")
    private Timestamp postingDate;
    
    @Column(name="AMOUNT")
    private BigDecimal amount;
    
    @Column(name="REMARKS")
    private String remarks;
    
    public DfinTransferPaymentCredit() {
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setDDocumentId(Long dDocumentId) {
        this.dDocumentId = dDocumentId;
    }

    public Long getDDocumentId() {
        return dDocumentId;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setRevAccId(Long revAccId) {
        this.revAccId = revAccId;
    }

    public Long getRevAccId() {
        return revAccId;
    }

    public void setReturnPeriodId(Long returnPeriodId) {
        this.returnPeriodId = returnPeriodId;
    }

    public Long getReturnPeriodId() {
        return returnPeriodId;
    }

    public void setPostingDate(Timestamp postingDate) {
        this.postingDate = postingDate;
    }

    public Timestamp getPostingDate() {
        return postingDate;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setId(Long id) {
    }

    public Long getId() {
        return null;
    }
}
