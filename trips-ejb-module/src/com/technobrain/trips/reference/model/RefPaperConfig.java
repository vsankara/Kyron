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
@NamedQuery(name = "RefPaperConfig.findAll", 
    query = "select o from RefPaperConfig o")
@Table(name = "REF_PAPER_CONFIG")
public class RefPaperConfig extends BaseRefModelObject  {
    
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    

    public RefPaperConfig() {
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

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }
}
