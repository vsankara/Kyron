package com.technobrain.trips.compliance.model;

import java.io.Serializable;

public class ComplianceJobTo implements Serializable {
    public ComplianceJobTo() {
    }
    
    String errorMessage;
    boolean error;
    long complianceJobId;

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setError(boolean errorOccured) {
        this.error = errorOccured;
    }

    public boolean isError() {
        return error;
    }

    public void setComplianceJobId(long complianceJobId) {
        this.complianceJobId = complianceJobId;
    }

    public long getComplianceJobId() {
        return complianceJobId;
    }
}
