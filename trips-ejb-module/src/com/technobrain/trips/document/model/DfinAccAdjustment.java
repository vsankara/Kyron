package com.technobrain.trips.document.model;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries (
    {
        @NamedQuery(name = "DfinAccAdjustment.findAll", query = "select o from DfinAccAdjustment o"),
        @NamedQuery(name = "DfinAccAdjustment.findById", query = "select o from DfinAccAdjustment o where o.id=?1")
    }
)
@Table(name = "DFIN_ACC_ADJUSTMENT")
@DiscriminatorColumn(name = "DTYPE")
@DiscriminatorValue("ACCADJUSTMENT")
public class DfinAccAdjustment extends DfinDocument   {
    private BigDecimal amount;
    @Column(name="ADJUSTMENT_DATE")
    private Timestamp adjustmentDate;
    private String reason;
    private String tin;
    @Column(name="REVENUE_TYPE")
    private String revenueType;
       
    @Column(name="ADJUSTMENT_TYPE")
    private String adjustmentType;
    private String notes;
    @Column(name="CHARGE_TYPE")
    private String chargeType;
    @Column(name="TRANSACTION_REFERENCE")
    private String transactionReference;
    @Column(name="REVENUE_LEDGER_CODE")
    private String revenueLedgerCode;

    public DfinAccAdjustment() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    //Copied from Cayman start
    public Timestamp getAdjustmentDate() {
        return adjustmentDate;
    }
    
    public void setAdjustmentDate(Timestamp adjustmentDate) {
        this.adjustmentDate = adjustmentDate;
    }

    public void setAdjustmentType(String adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    public String getAdjustmentType() {
        return adjustmentType;
    }
    //Copied from Cayman end

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getTin() {
        return tin;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setRevenueLedgerCode(String revenueLedgerCode) {
        this.revenueLedgerCode = revenueLedgerCode;
    }

    public String getRevenueLedgerCode() {
        return revenueLedgerCode;
    }
}
