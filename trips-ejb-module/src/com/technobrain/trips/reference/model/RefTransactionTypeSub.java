package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NamedQuery(name = "RefTransactionTypeSub.findAll", query = "select o from RefTransactionTypeSub o")
@Table(name = "REF_TRANSACTION_TYPE_SUB")
public class RefTransactionTypeSub extends BaseRefModelObject {

    @Id
    @Column(nullable = false)
    private String code;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    @Column(name="GL_ACC_SUB")
    private String glAccSub;
    
    @ManyToOne
    @JoinColumn(name = "TRANSACTION_TYPE_CODE", referencedColumnName = "CODE")
    private RefTransactionType refTransactionType;
    
    @ManyToOne
    @JoinColumn(name="TAX_TYPE_CODE" , referencedColumnName="CODE")
    private RefRevType refRevType;

    public RefTransactionTypeSub() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setGlAccSub(String glAccSub) {
        this.glAccSub = glAccSub;
    }

    public String getGlAccSub() {
        return glAccSub;
    }

    public void setRefTransactionType(RefTransactionType refTransactionType) {
        this.refTransactionType = refTransactionType;
    }

    public RefTransactionType getRefTransactionType() {
        return refTransactionType;
    }

    public void setRefRevType(RefRevType refRevType) {
        this.refRevType = refRevType;
    }

    public RefRevType getRefRevType() {
        return refRevType;
    }
}
