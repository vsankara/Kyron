package com.technobrain.trips.dto.tax.compliance;

import com.technobrain.trips.dto.DataTransferObject;

import java.math.BigDecimal;

public class RevAccWrapper implements DataTransferObject {
    
    private String entityAccountNo;
    private BigDecimal nonComplianceAmount;
    private String complianceType;
    
    public RevAccWrapper() {
    }

    public RevAccWrapper(String _entityAccountNo, BigDecimal _nonComplianceAmount) {
        this.entityAccountNo = _entityAccountNo;
        this.nonComplianceAmount = _nonComplianceAmount;
    }

    public void setNonComplianceAmount(BigDecimal nonComplianceAmount) {
        this.nonComplianceAmount = nonComplianceAmount;
    }

    public BigDecimal getNonComplianceAmount() {
        return nonComplianceAmount;
    }

    public void setEntityAccountNo(String entityAccountNo) {
        this.entityAccountNo = entityAccountNo;
    }

    public String getEntityAccountNo() {
        return entityAccountNo;
    }

    public void setComplianceType(String complianceType) {
        this.complianceType = complianceType;
    }

    public String getComplianceType() {
        return complianceType;
    }
}
