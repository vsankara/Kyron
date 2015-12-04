package com.technobrain.trips.workflow.model;

import java.io.Serializable;

public class WfWorkflowPK implements Serializable {
    public String operation;
    public Long runOrder;
    public String workflow;

    public WfWorkflowPK() {
    }

    public WfWorkflowPK(String operation, Long runOrder, String workflow) {
        this.operation = operation;
        this.runOrder = runOrder;
        this.workflow = workflow;
    }

    public boolean equals(Object other) {
        if (other instanceof WfWorkflowPK) {
            final WfWorkflowPK otherWfWorkflowPK = (WfWorkflowPK) other;
            final boolean areEqual = 
                (otherWfWorkflowPK.operation.equals(operation) && otherWfWorkflowPK.runOrder.equals(runOrder) && otherWfWorkflowPK.workflow.equals(workflow));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
