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

/**
 * © Crown Agents 2012
 *
 * Entity for table DFIN_CR_ALLOCATION
 *
 * @since	$Date: 12/2/2012 2:17:40 PM$
 * 
 * 
 */
@Entity

    
 @NamedQueries  (
    {
    @NamedQuery(name = "DfinCrAllocation.findAll", 
    query = "select o from DfinCrAllocation o"),
    @NamedQuery(name = "DfinCrAllocation.findAllUnapprovedCrTrans", 
    query = "select o from DfinCrAllocation o where o.crTransactionId = ?1 and o.docStatus = 'PENDAPPR'"),
    @NamedQuery(name = "DfinCrAllocation.findAllUnapprovedDrTrans", 
    query = "select o from DfinCrAllocation o where o.drTransactionId = ?1 and o.docStatus = 'PENDAPPR'"),
    @NamedQuery(name = "DfinCrAllocation.findById", 
         query = "select d from DfinCrAllocation d where d.id = ?1")
    }
)
@Table(name = "DFIN_CR_ALLOCATION")
@DiscriminatorColumn(name = "DTYPE")
@DiscriminatorValue("CRALLOCATION")
public class DfinCrAllocation extends DfinDocument {
    @Column(name="ALLOCATED_AMOUNT", nullable = false)
    private BigDecimal allocatedAmount;
    @Column(name="CREDIT_BALANCE")
    private BigDecimal creditBalance;
    @Column(name="CR_ALLOCATION_NOTES")
    private String crAllocationNotes;
    @Column(name="CR_DOC_TYPE")
    private String crDocType;
    @Column(name="CR_FROM_SUSPENSE")
    private String crFromSuspense;
    @Column(name="CR_PERIOD")
    private Long crPeriod;
    @Column(name="CR_TO_SUSPENSE")
    private String crToSuspense;
    @Column(name="CR_TRANSACTION_DATE")
    private Timestamp crTransactionDate;
    @Column(name="CR_TRANSACTION_REF")
    private String crTransactionRef;
    @Column(name="DR_DOC_TYPE")
    private String drDocType;
    @Column(name="DR_PERIOD")
    private Long drPeriod;
    @Column(name="DR_TRANSACTION_DATE")
    private Timestamp drTransactionDate;
    @Column(name="DR_TRANSACTION_REF")
    private String drTransactionRef;
    @Column(name="LIABILITY_BALANCE")
    private BigDecimal liabilityBalance;
    @Column(name="REVENUE_TYPE", nullable = false)
    private String revenueType;
    @Column(nullable = false)
    private String tin;
    @Column(name="CR_TRANSACTION_ID")
    private Long crTransactionId;
    @Column(name="DR_TRANSACTION_ID")
    private Long drTransactionId;

    public DfinCrAllocation() {
    }

    public BigDecimal getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(BigDecimal allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    public BigDecimal getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(BigDecimal creditBalance) {
        this.creditBalance = creditBalance;
    }

    public String getCrAllocationNotes() {
        return crAllocationNotes;
    }

    public void setCrAllocationNotes(String crAllocationNotes) {
        this.crAllocationNotes = crAllocationNotes;
    }

    public String getCrDocType() {
        return crDocType;
    }

    public void setCrDocType(String crDocType) {
        this.crDocType = crDocType;
    }

    public String getCrFromSuspense() {
        return crFromSuspense;
    }

    public void setCrFromSuspense(String crFromSuspense) {
        this.crFromSuspense = crFromSuspense;
    }

    public Long getCrPeriod() {
        return crPeriod;
    }

    public void setCrPeriod(Long crPeriod) {
        this.crPeriod = crPeriod;
    }

    public String getCrToSuspense() {
        return crToSuspense;
    }

    public void setCrToSuspense(String crToSuspense) {
        this.crToSuspense = crToSuspense;
    }

    public Timestamp getCrTransactionDate() {
        return crTransactionDate;
    }

    public void setCrTransactionDate(Timestamp crTransactionDate) {
        this.crTransactionDate = crTransactionDate;
    }

    public String getCrTransactionRef() {
        return crTransactionRef;
    }

    public void setCrTransactionRef(String crTransactionRef) {
        this.crTransactionRef = crTransactionRef;
    }

    public String getDrDocType() {
        return drDocType;
    }

    public void setDrDocType(String drDocType) {
        this.drDocType = drDocType;
    }

    public Long getDrPeriod() {
        return drPeriod;
    }

    public void setDrPeriod(Long drPeriod) {
        this.drPeriod = drPeriod;
    }

    public Timestamp getDrTransactionDate() {
        return drTransactionDate;
    }

    public void setDrTransactionDate(Timestamp drTransactionDate) {
        this.drTransactionDate = drTransactionDate;
    }

    public String getDrTransactionRef() {
        return drTransactionRef;
    }

    public void setDrTransactionRef(String drTransactionRef) {
        this.drTransactionRef = drTransactionRef;
    }

    public BigDecimal getLiabilityBalance() {
        return liabilityBalance;
    }

    public void setLiabilityBalance(BigDecimal liabilityBalance) {
        this.liabilityBalance = liabilityBalance;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }
    
    public Long getCrTransactionId() {
        return crTransactionId;
    }
    
    public void setCrTransactionId(Long crTransactionId) {
        this.crTransactionId = crTransactionId;
    }
    
    public Long getDrTransactionId() {
        return drTransactionId;
    }
    
    public void setDrTransactionId(Long drTransactionId) {
        this.drTransactionId = drTransactionId;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }
}
