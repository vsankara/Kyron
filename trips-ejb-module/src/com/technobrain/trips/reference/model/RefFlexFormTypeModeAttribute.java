package com.technobrain.trips.reference.model;

import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefFlexFormTypeModeAttribute.findAll", query = "select o from RefFlexFormTypeModeAttribute o")
@Table(name = "REF_FLEX_FORMTYPE_MODE_ATT")
public class RefFlexFormTypeModeAttribute extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="RETURN_TYPE")
    private String returnType;    
    @Column(name="FIELD_ATTRIBUTE_INDICATOR")
    private String fieldAttributeIndicator;
    @Column(name="RUN_AFTER_FIELD_GEN")
    private String runAfterFieldGeneration;

    public RefFlexFormTypeModeAttribute() {
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

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }
    
    public boolean getFieldAttributeIndicatorInBool() {
        return StringHelper.getIndicatorAsBoolean(getFieldAttributeIndicator());
    }
    
    public boolean getRunAfterFieldGenerationInBool() {
        return StringHelper.getIndicatorAsBoolean(getRunAfterFieldGeneration());
    }

    public void setFieldAttributeIndicator(String fieldAttributeIndicator) {
        this.fieldAttributeIndicator = fieldAttributeIndicator;
    }

    public String getFieldAttributeIndicator() {
        return fieldAttributeIndicator;
    }

    public void setRunAfterFieldGeneration(String runAfterFieldGeneration) {
        this.runAfterFieldGeneration = runAfterFieldGeneration;
    }

    public String getRunAfterFieldGeneration() {
        return runAfterFieldGeneration;
    }
}
