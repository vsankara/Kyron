package com.technobrain.trips.dto.tax.compliance;

import com.technobrain.trips.dto.DataTransferObject;

import java.math.BigDecimal;

public class ComplianceWrapper implements DataTransferObject{
    
    private String entityAccountNo;
    private BigDecimal nonComplianceAmount;
    private Long revAccID;
    private Long periodID;
    private String complianceType;
    private String revenueType;
    private String acctStatus;
    
    public ComplianceWrapper() {
    }
    
    public ComplianceWrapper(String _entityAccountNo, BigDecimal _nonComplianceAmount) {
        this.entityAccountNo = _entityAccountNo;
        this.nonComplianceAmount = _nonComplianceAmount;
    }

//acc.revType.code,acc.id,period.id,acc.acctNo, period.periodBal,acc.accStatus
    
 public ComplianceWrapper(String _revenueType, Long _revAccID,Long _periodId,  String _entityAccountNo, BigDecimal _nonComplianceAmount, String _acctStatus) {
     this.entityAccountNo = _entityAccountNo;
     this.nonComplianceAmount = _nonComplianceAmount;
     this.revenueType = _revenueType;
     this.revAccID = _revAccID;
     this.periodID = _periodId;
     this.acctStatus = _acctStatus;
 }
 
    public void setEntityAccountNo(String entityAccountNo) {
        this.entityAccountNo = entityAccountNo;
    }

    public String getEntityAccountNo() {
        return entityAccountNo;
    }

    public void setNonComplianceAmount(BigDecimal nonComplianceAmount) {
        this.nonComplianceAmount = nonComplianceAmount;
    }

    public BigDecimal getNonComplianceAmount() {
        return nonComplianceAmount;
    }

    public void setRevAccID(Long revAccID) {
        this.revAccID = revAccID;
    }

    public Long getRevAccID() {
        return revAccID;
    }

    public void setPeriodID(Long periodID) {
        this.periodID = periodID;
    }

    public Long getPeriodID() {
        return periodID;
    }

    public void setComplianceType(String complianceType) {
        this.complianceType = complianceType;
    }

    public String getComplianceType() {
        return complianceType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getAcctStatus() {
        return acctStatus;
    }
}
