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
 * Model class representing the table DEBT_CASE_TAX_TYPE. 
 * 
 *@author
 *@version
 *@since   
 *@see DebtCaseDetails
 * 
 */
@Entity
@NamedQuery(name = "DebtCaseTaxType.findAll", 
            query = "select o from DebtCaseTaxType o")
@Table(name = "DEBT_CASE_TAX_TYPE")
public class DebtCaseTaxType extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "DEBT_CASE_TAX_TYPE_SEQ")
    @SequenceGenerator(name = "DEBT_CASE_TAX_TYPE_SEQ", 
                       sequenceName = "DEBT_CASE_TAX_TYPE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name = "NOTES")
    private String taxTypeNotes;
    @Column(name = "PERIOD_ID")
    private Long periodId;
    @Column(name = "TAX_TYPE")
    private String taxType;
    @Column(name = "RETURN_TYPE")
    private String returnType;
    @Column(name="DEBT_VALUE")
    private BigDecimal debtValue;

    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private DebtCaseDetails debtCaseDetails;

    public DebtCaseTaxType() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }


    public void setDebtCaseDetails(DebtCaseDetails debtCaseDetails) {
        this.debtCaseDetails = debtCaseDetails;
    }

    public DebtCaseDetails getDebtCaseDetails() {
        return debtCaseDetails;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setDebtValue(BigDecimal debtValue) {
        this.debtValue = debtValue;
    }

    public BigDecimal getDebtValue() {
        return debtValue;
    }

    public void setTaxTypeNotes(String taxTypeNotes) {
        this.taxTypeNotes = taxTypeNotes;
    }

    public String getTaxTypeNotes() {
        return taxTypeNotes;
    }
}
