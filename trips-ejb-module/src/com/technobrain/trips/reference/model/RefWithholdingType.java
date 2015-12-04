package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefWithholdingType.findAll", 
    query = "select o from RefWithholdingType o")
@Table(name = "REF_WH_TYPE")
public class RefWithholdingType extends BaseRefModelObject {

    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    private BigDecimal rate;
    private String resident;
    private String category;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    @Column(name="CR_POSTING_REQUIRED")
    private String creditPostingRequired;
    
    public RefWithholdingType() {
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
    
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
    
    public BigDecimal getRate() {
        return rate;
    }
    
    public void setResident(String resident) {
        this.resident = resident;
    }
    
    public String getResident() {
        return resident;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCreditPostingRequired(String creditPostingRequired) {
        this.creditPostingRequired = creditPostingRequired;
    }

    public String getCreditPostingRequired() {
        return creditPostingRequired;
    }
}
