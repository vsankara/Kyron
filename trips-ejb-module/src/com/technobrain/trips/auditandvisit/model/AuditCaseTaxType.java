package com.technobrain.trips.auditandvisit.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

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
 * Model class representing the table AUDIT_CASE_TAX_TYPE. 
 * 
 *@author
 *@version
 *@since   
 *@see AuditCaseDetails
 * 
 */
@Entity
@NamedQuery(name = "AuditCaseTaxType.findAll", 
    query = "select o from AuditCaseTaxType o")
@Table(name = "AUDIT_CASE_TAX_TYPE")
public class AuditCaseTaxType extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "AUDIT_CASE_TAX_TYPE_SEQ")
    @SequenceGenerator(name = "AUDIT_CASE_TAX_TYPE_SEQ", 
                       sequenceName = "AUDIT_CASE_TAX_TYPE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="NOTES")
    private String taxTypeNotes;
    @Column(name="PERIOD_ID")
    private Long periodId;
    @Column(name="RETURN_TYPE")
    private String returnType;
    @Column(name="TAX_TYPE")
    private String taxType;
    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private AuditCaseDetails auditCaseDetails;

    public AuditCaseTaxType() {
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

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
    
    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public AuditCaseDetails getAuditCaseDetails() {
        return auditCaseDetails;
    }
    
    public void setAuditCaseDetails(AuditCaseDetails auditCaseDetails) {
        this.auditCaseDetails = auditCaseDetails;
    }

    public void setTaxTypeNotes(String taxTypeNotes) {
        this.taxTypeNotes = taxTypeNotes;
    }

    public String getTaxTypeNotes() {
        return taxTypeNotes;
    }
}
