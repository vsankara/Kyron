package com.technobrain.trips.riskmanagement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RskRiskCriteriaLog.findAll", 
    query = "select o from RskRiskCriteriaLog o")
@Table(name = "RSK_RISK_CRITERIA_LOG")
public class RskRiskCriteriaLog extends BaseNormalModelObject{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                 generator = "RSK_RISK_CRITERIA_LOG_SEQ")
    @SequenceGenerator(name = "RSK_RISK_CRITERIA_LOG_SEQ", sequenceName = "RSK_RISK_CRITERIA_LOG_SEQ", 
                    allocationSize = 1)  
    @Column(nullable = false)
    private Long id;
    @Column(name="ATTRIBUTE_1_VALUE")
    private BigDecimal attribute1Value;
    @Column(name="ATTRIBUTE_2_VALUE")
    private BigDecimal attribute2Value;
    private String breached;
    @ManyToOne
    @JoinColumn(name = "RSK_RISK_PROFILE_LOG_ID", referencedColumnName = "ID")
    private RskRiskProfileLog rskRiskProfileLog;
    @ManyToOne
    @JoinColumn(name = "CRITERION_ID", referencedColumnName = "ID")
    private RskRiskCriteria rskRiskCriteria;

    public RskRiskCriteriaLog() {
    }   

    public BigDecimal getAttribute1Value() {
        return attribute1Value;
    }

    public void setAttribute1Value(BigDecimal attribute1Value) {
        this.attribute1Value = attribute1Value;
    }

    public BigDecimal getAttribute2Value() {
        return attribute2Value;
    }

    public void setAttribute2Value(BigDecimal attribute2Value) {
        this.attribute2Value = attribute2Value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRskRiskProfileLog(RskRiskProfileLog rskRiskProfileLog) {
        this.rskRiskProfileLog = rskRiskProfileLog;
    }

    public RskRiskProfileLog getRskRiskProfileLog() {
        return rskRiskProfileLog;
    }

    public void setRskRiskCriteria(RskRiskCriteria rskRiskCriteria) {
        this.rskRiskCriteria = rskRiskCriteria;
    }

    public RskRiskCriteria getRskRiskCriteria() {
        return rskRiskCriteria;
    }

    public void setBreached(String breached) {
        this.breached = breached;
    }

    public String getBreached() {
        return breached;
    }
}
