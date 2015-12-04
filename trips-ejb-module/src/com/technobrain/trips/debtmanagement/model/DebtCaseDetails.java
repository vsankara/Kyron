package com.technobrain.trips.debtmanagement.model;

import com.technobrain.trips.casemanagement.model.CaseDetails;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Model class representing the table DEBT_CASE_DETAILS. DEBT_CASE_DETAILS table has a
 * one to one relationship with CASE_DETAILS. Debpt case details will be splint into above two tables.
 * 
 *@since   
 *@see DebtCaseCourtAction, DebtCaseWriteOff, CaseDetails, DebtCaseTaxType, DebtCaseTaxType, DebtCaseRecovery
 * 
 */
@Entity
@NamedQuery(name = "DebtCaseDetails.findAll", 
            query = "select o from DebtCaseDetails o")
@Table(name = "DEBT_CASE_DETAILS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="CTYPE")
@DiscriminatorValue("DEBTCASE")
public class DebtCaseDetails extends CaseDetails {

    @Column(name = "LIABILITY_AMOUNT")
    private BigDecimal liabilityAmount;
    @Column(name="ESCALATION_REASON")
    private String escalationReason;
    @Column(name="ESCALATION_NOTES")
    private String escalationNotes;    
    @OneToMany(cascade = { CascadeType.ALL },mappedBy = "debtCaseDetails")
    private List<DebtCaseCourtAction> debtCaseCourtActionList = new ArrayList<DebtCaseCourtAction>();
    @OneToMany(cascade = { CascadeType.ALL },mappedBy = "debtCaseDetails")
    private List<DebtCaseWriteOff> debtCaseWriteOffList = new ArrayList<DebtCaseWriteOff>();
    @OneToMany(cascade = { CascadeType.ALL },mappedBy = "debtCaseDetails")
    private List<DebtCaseTaxType> debtCaseTaxTypeList = new ArrayList<DebtCaseTaxType>();
    @OneToMany(cascade = { CascadeType.ALL },mappedBy = "debtCaseDetails")
    private List<DebtCaseRecovery> debtCaseRecoveryList = new ArrayList<DebtCaseRecovery>();

    public DebtCaseDetails() {
    }

    public BigDecimal getLiabilityAmount() {
        return liabilityAmount;
    }

    public void setLiabilityAmount(BigDecimal liabilityAmount) {
        this.liabilityAmount = liabilityAmount;
    }

    public void setEscalationReason(String escalationReason) {
        this.escalationReason = escalationReason;
    }

    public String getEscalationReason() {
        return escalationReason;
    }

    public void setEscalationNotes(String escalationNotes) {
        this.escalationNotes = escalationNotes;
    }

    public String getEscalationNotes() {
        return escalationNotes;
    }
    
    public void setDebtCaseCourtActionList(List<DebtCaseCourtAction> debtCaseCourtActionList) {
        this.debtCaseCourtActionList = debtCaseCourtActionList;
    }

    public List<DebtCaseCourtAction> getDebtCaseCourtActionList() {
        return debtCaseCourtActionList;
    }

    public DebtCaseCourtAction addDebtCaseCourtAction(DebtCaseCourtAction caseCourtAction) {
        getDebtCaseCourtActionList().add(caseCourtAction);
        caseCourtAction.setDebtCaseDetails(this);
        return caseCourtAction;
    }
   

    public DebtCaseCourtAction removeDebtCaseCourtAction(DebtCaseCourtAction caseCourtAction) {
        getDebtCaseCourtActionList().remove(caseCourtAction);
        caseCourtAction.setDebtCaseDetails(null);
        return caseCourtAction;
    }

    public void setDebtCaseWriteOffList(List<DebtCaseWriteOff> debtCaseWriteOffList) {
        this.debtCaseWriteOffList = debtCaseWriteOffList;
    }

    public List<DebtCaseWriteOff> getDebtCaseWriteOffList() {
        return debtCaseWriteOffList;
    }
    
    public DebtCaseWriteOff addDebtCaseWriteOff(DebtCaseWriteOff debtCaseWriteOff) {
        getDebtCaseWriteOffList().add(debtCaseWriteOff);
        debtCaseWriteOff.setDebtCaseDetails(this);
        return debtCaseWriteOff;
    }
   
    public DebtCaseWriteOff removeDebtCaseWriteOff(DebtCaseWriteOff debtCaseWriteOff) {
        getDebtCaseWriteOffList().remove(debtCaseWriteOff);
        debtCaseWriteOff.setDebtCaseDetails(null);
        return debtCaseWriteOff;
    }

    public void setDebtCaseTaxTypeList(List<DebtCaseTaxType> debtCaseTaxTypeList) {
        this.debtCaseTaxTypeList = debtCaseTaxTypeList;
    }

    public List<DebtCaseTaxType> getDebtCaseTaxTypeList() {
        return debtCaseTaxTypeList;
    }
    /**
     * 
     * @param debtCaseTaxType
     * @return
     * @since
     */
    public DebtCaseTaxType addDebtCaseTaxType(DebtCaseTaxType debtCaseTaxType) {
        getDebtCaseTaxTypeList().add(debtCaseTaxType);
        debtCaseTaxType.setDebtCaseDetails(this);
        return debtCaseTaxType;
    }

      
    public DebtCaseTaxType removeDebtCaseTaxType(DebtCaseTaxType debtCaseTaxType) {
        getDebtCaseTaxTypeList().remove(debtCaseTaxType);
        debtCaseTaxType.setDebtCaseDetails(null);
        return debtCaseTaxType;
    }
    public void setDebtCaseRecoveryList(List<DebtCaseRecovery> debtCaseRecoveryList) {
        this.debtCaseRecoveryList = debtCaseRecoveryList;
    }

    public List<DebtCaseRecovery> getDebtCaseRecoveryList() {
        return debtCaseRecoveryList;
    }

   
    public DebtCaseRecovery addDebtCaseRecovery(DebtCaseRecovery debtCaseRecovery) {
        getDebtCaseRecoveryList().add(debtCaseRecovery);
        debtCaseRecovery.setDebtCaseDetails(this);
        return debtCaseRecovery;
    }

    public DebtCaseRecovery removeDebtCaseRecovery(DebtCaseRecovery debtCaseRecovery) {
        getDebtCaseRecoveryList().remove(debtCaseRecovery);
        debtCaseRecovery.setDebtCaseDetails(null);
        return debtCaseRecovery;
    }
}
