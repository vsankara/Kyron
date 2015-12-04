package com.technobrain.trips.reference.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefObjectionStatusType.findAll", query = "select o from RefObjectionStatusType o")
@Table(name = "REF_OBJECTION_STATUS_TYPE")
public class RefObjectionStatusType extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
     
     
     
     
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="OBJECTION_STATUS_TYPE")
    private String objectionStatusType;
    @Column(name="TO_STATUS_DATE")
    private Timestamp toStatusDate;
     
     
     
     

    public RefObjectionStatusType() {
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

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getObjectionStatusType() {
        return objectionStatusType;
    }

    public void setObjectionStatusType(String objectionStatusType) {
        this.objectionStatusType = objectionStatusType;
    }

    public Timestamp getToStatusDate() {
        return toStatusDate;
    }

    public void setToStatusDate(Timestamp toStatusDate) {
        this.toStatusDate = toStatusDate;
    }

}
