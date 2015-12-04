package com.technobrain.trips.revenueaccount.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RevComplianceHistory.findAll", 
    query = "select o from RevComplianceHistory o")
@Table(name = "REV_COMPLIANCE_HISTORY")
@SequenceGenerator(name = "REV_COMPLIANCE_HISTORY_SEQ", sequenceName = "REV_COMPLIANCE_HISTORY_SEQ", initialValue = 1, allocationSize = 1)
public class RevComplianceHistory extends BaseNormalModelObject   {
    @Column(name="COMPLIANCE_ACTION")
    private String complianceAction;
    @Column(name="COMPLIANCE_BREACH_COUNTER")
    private Long complianceBreachCounter;
    @Column(name="COMPLIANCE_TYPE")
    private String complianceType;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REV_COMPLIANCE_HISTORY_SEQ")
    @Column(nullable = false)
    private Long id;
    @Column(name="REVENUE_PERIOD")
    private Long revenuePeriod;
    @Column(name="REV_ACC_ID")
    private Long revAccId;
    @Column(name="COMP_CASE_STATUS")
    private String compCaseStatus;

    public RevComplianceHistory() {
    }

    public String getComplianceAction() {
        return complianceAction;
    }

    public void setComplianceAction(String complianceAction) {
        this.complianceAction = complianceAction;
    }

    public Long getComplianceBreachCounter() {
        return complianceBreachCounter;
    }

    public void setComplianceBreachCounter(Long complianceBreachCounter) {
        this.complianceBreachCounter = complianceBreachCounter;
    }

    public String getComplianceType() {
        return complianceType;
    }

    public void setComplianceType(String complianceType) {
        this.complianceType = complianceType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRevenuePeriod() {
        return revenuePeriod;
    }

    public void setRevenuePeriod(Long revenuePeriod) {
        this.revenuePeriod = revenuePeriod;
    }

    public Long getRevAccId() {
        return revAccId;
    }

    public void setRevAccId(Long revAccId) {
        this.revAccId = revAccId;
    }

    public String getCompCaseStatus() {
        return compCaseStatus;
    }

    public void setCompCaseStatus(String compCaseStatus) {
        this.compCaseStatus = compCaseStatus;
    }
}
