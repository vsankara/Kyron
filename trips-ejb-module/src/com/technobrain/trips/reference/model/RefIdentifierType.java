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
@NamedQuery(name = "RefIdentifierType.findAll", 
    query = "select o from RefIdentifierType o where o.status='A'")
@Table(name = "REF_IDENTIFIER_TYPE")
public class RefIdentifierType extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
     
     
     
     
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="IDENTIFIER_CODE")
    private String identifierCode;
    @Column(name="IDENTIFIER_NAME")
    private String identifierName;
    @Column(name="VERIFICATION_TYPE")
    private String verificationType;
    @Column(name="AUTO_APPROVAL")
    private String autoApproval;
     
     
     

    public RefIdentifierType() {
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

    public String getIdentifierCode() {
        return identifierCode;
    }

    public void setIdentifierCode(String identifierCode) {
        this.identifierCode = identifierCode;
    }

    public String getIdentifierName() {
        return identifierName;
    }

    public void setIdentifierName(String identifierName) {
        this.identifierName = identifierName;
    }

    public void setVerificationType(String verificationType) {
        this.verificationType = verificationType;
    }

    public String getVerificationType() {
        return verificationType;
    }

    public void setAutoApproval(String autoApproval) {
        this.autoApproval = autoApproval;
    }

    public String getAutoApproval() {
        return autoApproval;
    }
}
