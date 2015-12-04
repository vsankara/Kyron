package com.technobrain.trips.reference.model;

import com.technobrain.trips.common.constants.Constants.WorkflowTypes;
import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefWorkflowName.findAll", query = "select o from RefWorkflowName o")
@Table(name="REF_WORKFLOW_NAME")
public class RefWorkflowName extends BaseRefModelObject {
    
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name = "WORKFLOW_TYPE")
    private String workflowType;
    @Column(name = "EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name = "EXPIRY_DATE")
    private Timestamp expiryDate;

    public  RefWorkflowName () {
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

    public void setWorkflowType(String workflowType) {
        this.workflowType = workflowType;
    }

    public String getWorkflowType() {
        return workflowType;
    }
}
