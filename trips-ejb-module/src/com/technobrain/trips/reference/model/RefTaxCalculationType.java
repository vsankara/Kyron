package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefTaxCalculationType.findAll", 
    query = "select o from RefTaxCalculationType o")
@Table(name = "REF_TAX_CALCULATION_TYPE")

public class RefTaxCalculationType  extends BaseRefModelObject{
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;  
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public RefTaxCalculationType() {
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

    public void setCode(String code) {
        this.code = code;    
    }

    public String getCode() {
        return code;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
