package com.technobrain.trips.workflow.model;
/**
 * TechnoBrain 2015
 *
 * Workflow condition entity
 *
 * @since	$Date: 2/2/2009 5:29:32 AM$
 * @version 	$Revision: 6$
 * @author 	$Author: Howard Hill$
 * 
 * $Log[1]:
 *  6    TRIPS2    1.5         2/2/2009 5:29:32 AM    Howard Hill     change
 *       log10 to log1
 * $
 */

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@NamedQuery(name = "WfWorkflowCondition.findAll", query = "select o from WfWorkflowCondition o")
@Table(name = "WF_WORKFLOW_CONDITION")
public class WfWorkflowCondition extends BaseRefModelObject   {
     
     
     
     
     
     
     
     
    @Column(name="PROPERTY")
    private String property;
    @Column(name="PROP_TYPE")
    private Boolean propType; 
    @Column(name="PROP_VAL")
    private String propValue;
    @Id
    @Column(nullable = false)
    private String code;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="EXPIRY_DATE")
    private String expiryDate;
    @Column(name="EFFECTIVE_DATE")
    private String effectiveDate;
    
    public WfWorkflowCondition() {
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public void setPropType(Boolean propType) {
        this.propType = propType;
    }

    public Boolean getPropType() {
        return propType;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    public String getPropValue() {
        return propValue;
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

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }
}
