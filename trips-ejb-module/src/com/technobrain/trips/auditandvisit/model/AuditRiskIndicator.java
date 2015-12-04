package com.technobrain.trips.auditandvisit.model;

import com.technobrain.trips.core.annotation.ReferenceNumber;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * Model class representing the table AUDIT_RISK_INDICATOR. 
 * 
 *@author
 *@version
 *@since   
 * 
 */
@Entity
@NamedQueries( { @NamedQuery(name = "AuditRiskIndicator.findAll", 
                             query = "select o from AuditRiskIndicator o")
        , 
        @NamedQuery(name = "AuditRiskIndicator.findNonDeletedRiskIndicators", 
                    query = 
                    "select o from AuditRiskIndicator o where o.indicatorStatus NOT IN (?1) ")
        } )
@Table(name = "AUDIT_RISK_INDICATOR")
public class AuditRiskIndicator extends BaseNormalModelObject {
    @Column(name = "AUD_IND_CODE")
    private String audIndCode;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "AUDIT_RISK_INDICATOR_SEQ")
    @SequenceGenerator(name = "AUDIT_RISK_INDICATOR_SEQ", 
                       sequenceName = "AUDIT_RISK_INDICATOR_SEQ", 
                       allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name = "INDICATOR_NAME")
    private String indicatorName;
    @Column(name = "INDICATOR_STATUS")
    private String indicatorStatus;
    @Column(name = "MAX_VALUE")
    private Long maxValue;
    @Column(name = "MIN_VALUE")
    private Long minValue;

    public AuditRiskIndicator() {
    }

    public String getAudIndCode() {
        return audIndCode;
    }

    public void setAudIndCode(String audIndCode) {
        this.audIndCode = audIndCode;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public String getIndicatorStatus() {
        return indicatorStatus;
    }

    public void setIndicatorStatus(String indicatorStatus) {
        this.indicatorStatus = indicatorStatus;
    }

    public Long getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Long maxValue) {
        this.maxValue = maxValue;
    }

    public Long getMinValue() {
        return minValue;
    }

    public void setMinValue(Long minValue) {
        this.minValue = minValue;
    }

}
