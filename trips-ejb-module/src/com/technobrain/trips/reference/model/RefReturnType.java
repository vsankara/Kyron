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
@NamedQuery(name = "RefReturnType.findAll", 
    query = "select o from RefReturnType o")
@Table(name = "REF_RETURN_TYPE")
public class RefReturnType extends BaseRefModelObject {
    
    @Id
    @Column(nullable = false)
    private String code;
    private String description;   
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="REF_REV_TYPE")
    private String refRevType;
    @Column(name="RETURN_CURRENCY")
    private String returnCurrency;
    @Column(name="NIL_RETURN_APPLICABLE")
    private String nillReturnApplicable;
    @ManyToOne
    @JoinColumn(name = "REF_REV_MODE", referencedColumnName = "CODE")    
    private RefRevMode refRevMode; 
    
    public RefReturnType() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRefRevType() {
        return refRevType;
    }

    public void setRefRevType(String refRevType) {
        this.refRevType = refRevType;
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

    public void setRefRevMode(RefRevMode refRevMode) {
        this.refRevMode = refRevMode;
    }

    public RefRevMode getRefRevMode() {
        return refRevMode;
    }

    public void setReturnCurrency(String returnCurrency) {
        this.returnCurrency = returnCurrency;
    }

    public String getReturnCurrency() {
        return returnCurrency;
    }

    public void setNillReturnApplicable(String nillReturnApplicable) {
        this.nillReturnApplicable = nillReturnApplicable;
    }

    public String getNillReturnApplicable() {
        return nillReturnApplicable;
    }
}
