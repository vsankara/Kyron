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

@Entity
@NamedQuery(name = "RefGracePeriod.findAll", 
            query = "select o from RefGracePeriod o")
@Table(name = "REF_GRACE_PERIOD")
public class RefGracePeriod extends BaseRefModelObject {

    @Id
    @Column(nullable = false)
    private String code;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    @ManyToOne
    @JoinColumn(name = "REF_STAGGER", referencedColumnName = "CODE")
    private RefStagger refStagger;
    
    @Column(name="NUM_OF_DAYS")
    private Integer numOfDays;
    
    public RefGracePeriod() {
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

    public void setRefStagger(RefStagger refStagger) {
        this.refStagger = refStagger;
    }

    public RefStagger getRefStagger() {
        return refStagger;
    }

    public void setNumOfDays(Integer numOfDays) {
        this.numOfDays = numOfDays;
    }

    public Integer getNumOfDays() {
        return numOfDays;
    }
}
