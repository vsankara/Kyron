package com.technobrain.trips.debtmanagement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * Model class representing the table DEBT_CASE_WRITE_OFF. 
 * 
 *@author
 *@version
 *@since   
 *@see DebtCaseDetails
 * 
 */
@Entity
@NamedQuery(name = "DebtCaseWriteOff.findAll", 
            query = "select o from DebtCaseWriteOff o")
@Table(name = "DEBT_CASE_WRITE_OFF")
public class DebtCaseWriteOff extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "DEBT_CASE_WRITE_OFF_SEQ")
    @SequenceGenerator(name = "DEBT_CASE_WRITE_OFF_SEQ", 
                       sequenceName = "DEBT_CASE_WRITE_OFF_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name = "AMOUNT")
    private BigDecimal writeOffAmount;
    @Column(name = "APPROVAL_INDICATOR")
    private String approvalIndicator;

    @Column(name = "NOTES")
    private String writeOffNotes;
 

    @Column(name = "WRITE_OFF_REASON")
    private String writeOffReason;
    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private DebtCaseDetails debtCaseDetails;

    public DebtCaseWriteOff() {
    }


    public String getApprovalIndicator() {
        return approvalIndicator;
    }

    public void setApprovalIndicator(String approvalIndicator) {
        this.approvalIndicator = approvalIndicator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getWriteOffReason() {
        return writeOffReason;
    }

    public void setWriteOffReason(String writeOffReason) {
        this.writeOffReason = writeOffReason;
    }


    public void setDebtCaseDetails(DebtCaseDetails debtCaseDetails) {
        this.debtCaseDetails = debtCaseDetails;
    }

    public DebtCaseDetails getDebtCaseDetails() {
        return debtCaseDetails;
    }

    public void setWriteOffAmount(BigDecimal writeOffAmount) {
        this.writeOffAmount = writeOffAmount;
    }

    public BigDecimal getWriteOffAmount() {
        return writeOffAmount;
    }

    public void setWriteOffNotes(String writeOffNotes) {
        this.writeOffNotes = writeOffNotes;
    }

    public String getWriteOffNotes() {
        return writeOffNotes;
    }
}
