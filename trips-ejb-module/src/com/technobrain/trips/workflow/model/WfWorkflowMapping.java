package com.technobrain.trips.workflow.model;

import com.technobrain.trips.core.model.BaseCompositeModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "WfWorkflowMapping.findAll", 
    query = "select o from WfWorkflowMapping o")
@Table(name = "WF_WORKFLOW_MAPPING")
@IdClass(WfWorkflowMappingPK.class)
public class WfWorkflowMapping extends BaseCompositeModelObject   {
    @Column(nullable = false)
    private String workflow;
    @Id
    @Column(name="DOC_STATUS", nullable = false)
    private String docStatus;
    @Id
    @Column(name="DOC_REGIME", nullable = false)
    private String docRegime;
    @Id
    @Column(nullable = false)
    private String action;
    
    @Column(name="ACTION_DESCRIPTION")
    private String actionDescription;
   
    public WfWorkflowMapping() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDocRegime() {
        return docRegime;
    }

    public void setDocRegime(String docRegime) {
        this.docRegime = docRegime;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }
    
    @Override
    public final  boolean equals(Object other) {
        if (other == this)
            return true;
        if ((other == null) || !(other instanceof BaseCompositeModelObject))
            return false;

        final WfWorkflowMapping normalModel = (WfWorkflowMapping)other;

        if (docStatus != null && docRegime != null && action != null && 
            normalModel.getDocStatus() != null && normalModel.getDocRegime() != null && normalModel.getAction() != null) {
            return docStatus.equals(normalModel.getDocStatus()) && docRegime.equals(normalModel.getDocRegime())
                && action.equals(normalModel.getAction());
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if(docStatus == null || docRegime == null || action == null)
            return super.hashCode();
        else 
        return docStatus.toString().concat(docRegime.toString().concat(action.toString())).hashCode();
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public String getActionDescription() {
        return actionDescription;
    }
}
