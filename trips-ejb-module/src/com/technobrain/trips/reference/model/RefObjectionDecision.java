package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Model class representing the table REF_OBJECTION_DECISION. 
 * 
 *@author
 *@version
 *@since   
 * 
 */
@Entity
@NamedQuery(name = "RefObjectionDecision.findAll", 
    query = "select o from RefObjectionDecision o")
@Table(name = "REF_OBJECTION_DECISION")
public class RefObjectionDecision extends BaseRefModelObject {
   
    @Id
    @Column(nullable = false)
    private String code;     
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public RefObjectionDecision() {
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
}
