package com.technobrain.trips.riskmanagement.model;

import com.technobrain.trips.core.annotation.ReferenceNumber;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RskRiskCriteria.findAll", 
    query = "select o from RskRiskCriteria o")
@Table(name = "RSK_RISK_CRITERIA")
public class RskRiskCriteria extends BaseNormalModelObject{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "RSK_RISK_CRITERIA_SEQ")
    @SequenceGenerator(name = "RSK_RISK_CRITERIA_SEQ", sequenceName = "RSK_RISK_CRITERIA_SEQ", 
                       allocationSize = 1)  
    @Column(nullable = false)
    private Long id;   
    @Column(name="ATTRIBUTE_1", nullable = false)
    private String attribute1;
    @Column(name="ATTRIBUTE_2")
    private String attribute2;
    @ReferenceNumber(format="RCSQL", sql="SELECT LTRIM(TO_CHAR(MOD(RISK_CRITERIA_REFERENCE_NO_SEQ.nextval,000000),'000099')) as generatedId FROM dual")
    @Column(name="CRITERIA_NUMBER", nullable = false)
    private String criteriaNumber;
    @Column(name="CRITERIA_TYPE", nullable = false)
    private String criteriaType;
    @Column(name="HIGH_RISK_INDICATOR", nullable = false)
    private String highRiskIndicator;
    @Column(name="LOWER_VALUE")
    private BigDecimal lowerValue;
    private BigDecimal multiplier;
    @Column(nullable = false)
    private String operator;
    @Column(nullable = false)
    private Integer points;
    @Column(name="UPPER_VALUE")
    private BigDecimal upperValue;
    
    @ManyToOne
    @JoinColumn(name = "RISK_PROFILE", referencedColumnName = "ID",nullable = false)
    private RskRiskProfile riskProfile;
    @OneToMany(mappedBy = "rskRiskCriteria", cascade={CascadeType.ALL})
    private List<RskRiskCriteriaLog> rskRiskCriteriaLogList;
    public RskRiskCriteria() {
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getCriteriaNumber() {
        return criteriaNumber;
    }

    public void setCriteriaNumber(String criteriaNumber) {
        this.criteriaNumber = criteriaNumber;
    }

    public String getCriteriaType() {
        return criteriaType;
    }

    public void setCriteriaType(String criteriaType) {
        this.criteriaType = criteriaType;
    }

    public String getHighRiskIndicator() {
        return highRiskIndicator;
    }

    public void setHighRiskIndicator(String highRiskIndicator) {
        this.highRiskIndicator = highRiskIndicator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setLowerValue(BigDecimal lowerValue) {
        this.lowerValue = lowerValue;
    }

    public BigDecimal getLowerValue() {
        return lowerValue;
    }

    public void setMultiplier(BigDecimal multiplier) {
        this.multiplier = multiplier;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }

    public void setUpperValue(BigDecimal upperValue) {
        this.upperValue = upperValue;
    }

    public BigDecimal getUpperValue() {
        return upperValue;
    }

    public void setRiskProfile(RskRiskProfile riskProfile) {
        this.riskProfile = riskProfile;
    }

    public RskRiskProfile getRiskProfile() {
        return riskProfile;
    }
    public void setRskRiskCriteriaLogList(List<RskRiskCriteriaLog> rskRiskCriteriaLogList) {
        this.rskRiskCriteriaLogList = rskRiskCriteriaLogList;
    }

    public List<RskRiskCriteriaLog> getRskRiskCriteriaLogList() {
        return rskRiskCriteriaLogList;
    }
    public RskRiskCriteriaLog addRskRiskCriteriaLog(RskRiskCriteriaLog rskRiskCriteriaLog) {
        getRskRiskCriteriaLogList().add(rskRiskCriteriaLog);
        rskRiskCriteriaLog.setRskRiskCriteria(this);
        return rskRiskCriteriaLog;
    }

    public RskRiskCriteriaLog removeRskRiskCriteriaLog(RskRiskCriteriaLog rskRiskCriteriaLog) {
        getRskRiskCriteriaLogList().remove(rskRiskCriteriaLog);
        rskRiskCriteriaLog.setRskRiskCriteria(null);
        return rskRiskCriteriaLog;
    }
}
