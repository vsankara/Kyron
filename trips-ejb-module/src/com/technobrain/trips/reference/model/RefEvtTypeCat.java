package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefEvtTypeCat.findAll", 
    query = "select o from RefEvtTypeCat o")
@Table(name = "REF_EVT_TYPE_CAT")
public class RefEvtTypeCat extends BaseRefModelObject {

    @Id
    @Column(nullable = false)
    private String code;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    @ManyToOne
    @JoinColumn(name = "TYPE_CODE", referencedColumnName = "CODE")
    private RefEvtType refEvtType;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_CODE", referencedColumnName = "CODE")
    private RefEvtCategories refEvtCategories;

    public RefEvtTypeCat() {
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public RefEvtType getRefEvtType() {
        return refEvtType;
    }

    public void setRefEvtType(RefEvtType refEvtType) {
        this.refEvtType = refEvtType;
    }

    public RefEvtCategories getRefEvtCategories() {
        return refEvtCategories;
    }

    public void setRefEvtCategories(RefEvtCategories refEvtCategories) {
        this.refEvtCategories = refEvtCategories;
    }
}
