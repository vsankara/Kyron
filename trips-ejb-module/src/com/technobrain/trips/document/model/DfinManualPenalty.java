package com.technobrain.trips.document.model;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity    
 @NamedQueries  (
    {
    @NamedQuery(name = "DfinManualPenalty.findAll", 
    query = "select o from DfinManualPenalty o"),
    @NamedQuery(name = "DfinManualPenalty.findById", 
         query = "select d from DfinManualPenalty d where d.id = ?1")
    }
)
@Table(name = "DFIN_MANUAL_PENALTY")
@DiscriminatorColumn(name = "DTYPE")
@DiscriminatorValue("MANUAL_PENALTY")
@Inheritance(strategy = InheritanceType.JOINED)

public class DfinManualPenalty extends DfinDocument {
    
    private BigDecimal amount;
    @Column(name="PENALTY_CODE")
    private String penaltyCode;
    @Column(name="REVENUE_LEDGER_CODE")
    private String revenueLedgerCode;
    @Column(name="ENTITY_ID")
    private Long entityId;
    @Column(name="TAX_TYPE")
    private String taxType;
    @Column(name="RETURN_TYPE")
    private String returnType;
    private String notes;
    @Column(name = "PENALTY_DATE")
    private Timestamp penaltyDate;
    @Column(name="LEGAL_REFERENCE")
    private String legalReference;
    @Column(name="AUTHORISED_BY")
    private String authorisedBy;
    private String tin; 
    
    public DfinManualPenalty() {
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setPenaltyCode(String penaltyCode) {
        this.penaltyCode = penaltyCode;
    }

    public String getPenaltyCode() {
        return penaltyCode;
    }

    public void setRevenueLedgerCode(String revenueLedgerCode) {
        this.revenueLedgerCode = revenueLedgerCode;
    }

    public String getRevenueLedgerCode() {
        return revenueLedgerCode;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setPenaltyDate(Timestamp penaltyDate) {
        this.penaltyDate = penaltyDate;
    }

    public Timestamp getPenaltyDate() {
        return penaltyDate;
    }

    public void setLegalReference(String legalReference) {
        this.legalReference = legalReference;
    }

    public String getLegalReference() {
        return legalReference;
    }

    public void setAuthorisedBy(String authorisedBy) {
        this.authorisedBy = authorisedBy;
    }

    public String getAuthorisedBy() {
        return authorisedBy;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getTin() {
        return tin;
    }
}

