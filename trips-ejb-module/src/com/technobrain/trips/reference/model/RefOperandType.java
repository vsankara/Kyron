package com.technobrain.trips.reference.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@NamedQuery(name = "RefOperandType.findAll", 
    query = "select o from RefOperandType o")
@Table(name = "REF_OPERAND_TYPE")
public class RefOperandType extends BaseRefModelObject   {
    @Id
    @Column(name="CODE", nullable = false)
    private String code;
     
     
     
     
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="OPERAND_CATEGORY")
    private String operandCategory; 
     
     
     
     
     

    public RefOperandType() {
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

    public void setOperandCategory(String operandCategory) {
        this.operandCategory = operandCategory;
    }

    public String getOperandCategory() {
        return operandCategory;
    }
}
