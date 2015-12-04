package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@NamedQuery(name = "RefExemptionLegalReferences.findAll", 
    query = "select o from RefExemptionLegalReferences o")
@Table(name = "EXEMPTION_LEGAL_REFERENCES")
public class RefExemptionLegalReferences extends BaseRefModelObject {
    private String code;
    private String description;
    @Id
    private Long id;
    
    @Column(name = "EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name = "EXPIRY_DATE")
    private Timestamp expiryDate;
  

    public RefExemptionLegalReferences() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
