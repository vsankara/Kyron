package com.technobrain.trips.workflow.model;

import java.io.Serializable;

public class WfWorkflowMappingPK implements Serializable {
    public String action;
    public String docRegime;
    public String docStatus;

    public WfWorkflowMappingPK() {
    }

    public WfWorkflowMappingPK(String action, String docRegime, String docStatus) {this.action = action;
        this.docRegime = docRegime;
        this.docStatus = docStatus;
    }

    public boolean equals(Object other) {
        if (other instanceof WfWorkflowMappingPK) {
            final WfWorkflowMappingPK otherWfWorkflowMappingPK = (WfWorkflowMappingPK) other;
            final boolean areEqual = 
                (otherWfWorkflowMappingPK.action.equals(action) && otherWfWorkflowMappingPK.docRegime.equals(docRegime) && otherWfWorkflowMappingPK.docStatus.equals(docStatus));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
