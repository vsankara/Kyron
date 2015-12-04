package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefDateSubCategory.findAll", 
            query = "select o from RefDateSubCategory o")
@Table(name = "REF_DATE_SUB_CATEGORY")
public class RefDateSubCategory extends BaseRefModelObject {

    @Id
    @Column(nullable = false)
    private String code;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public RefDateSubCategory() {
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
}
