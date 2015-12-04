package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;
import com.technobrain.trips.core.model.FunctionalBusinessObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefAppealDecision.findAll", 
    query = "select o from RefAppealDecision o")
@Table(name = "REF_APPEAL_DECISION")
public class RefAppealDecision implements Serializable {
    @Id
    @Column(nullable = false)
    private String code;     
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;


    private String createdBy;
    private Timestamp createdDate;
    private String updatedBy;
    private Timestamp updatedDate;
    protected String status;
    private Long version;
    private String accessLevel;

    

    public RefAppealDecision() {
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

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveAdte) {
        this.effectiveDate = effectiveAdte;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    public final void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public final String getCreatedBy() {
        return createdBy;
    }

    public final  void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public final String getUpdatedBy() {
        return updatedBy;
    }   
    
//    public abstract boolean equals(Object other);

    public final void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public final Timestamp getCreatedDate() {
        return createdDate;
    }

    public final void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public final Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public final void setStatus(String status) {
        this.status = status;
    }

    public final String getStatus() {
        return status;
    }

    public final void setVersion(Long version) {
        this.version = version;
    }

    public final Long getVersion() {
        return version;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }


//    @Override
    public boolean equals(Object other) {
        // TODO Implement this method
        return false;
    }

//    @Override
//    public boolean equals(Object other) {
//        // TODO Implement this method
//        return false;
//    }
}
