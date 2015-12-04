package com.technobrain.trips.workflow.model;

import com.technobrain.trips.core.model.BaseCompositeModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "WfWorkflow.findAll", query = "select o from WfWorkflow o")
@Table(name = "WF_WORKFLOW")
@IdClass(WfWorkflowPK.class)
public class WfWorkflow extends BaseCompositeModelObject   {
    @Id
    @Column(nullable = false)
    private String workflow;
    @Id
    @Column(nullable = false)
    private String operation;
    @Id
    @Column(name="RUN_ORDER", nullable = false)
    private Long runOrder;
    @Column(nullable = false)
    private String outcome;
    @Column(name="NEXT_ACTION", nullable = false)
    private String nextAction;
    @Column(name="END_DOC_STATUS")
    private String endDocStatus;
    @Column(name="WORKFLOW_CONDITION")
    private String workflowCondition;
     
     
     
     
     
     
     
     
     

    public WfWorkflow() {
    }

    public String getEndDocStatus() {
        return endDocStatus;
    }

    public void setEndDocStatus(String endDocStatus) {
        this.endDocStatus = endDocStatus;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public Long getRunOrder() {
        return runOrder;
    }

    public void setRunOrder(Long runOrder) {
        this.runOrder = runOrder;
    }

    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }

    public void setWorkflowCondition(String workflowCondition) {
        this.workflowCondition = workflowCondition;
    }

    public String getWorkflowCondition() {
        return workflowCondition;
    }
    
    @Override
    public final  boolean equals(Object other) {
        if (other == this)
            return true;
        if ((other == null) || !(other instanceof BaseCompositeModelObject))
            return false;

        final WfWorkflow normalModel = (WfWorkflow)other;

        if (runOrder != null && workflow != null && operation != null && 
            normalModel.getRunOrder() != null && normalModel.getWorkflow() != null && normalModel.getOperation() != null) {
            return runOrder.equals(normalModel.getRunOrder()) && workflow.equals(normalModel.getWorkflow())
                && operation.equals(normalModel.getOperation());
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if(runOrder == null || workflow == null || operation == null)
            return super.hashCode();
        else 
        return runOrder.toString().concat(workflow.toString().concat(operation.toString())).hashCode();
    }
}
