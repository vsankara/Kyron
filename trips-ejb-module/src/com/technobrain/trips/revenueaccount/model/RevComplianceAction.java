package com.technobrain.trips.revenueaccount.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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


/**
 * @author i_yildiz
 */
 
@Entity
@NamedQuery(name = "RevComplianceAction.findAll", 
    query = "select o from RevComplianceAction o")
@Table(name = "REV_COMPLIANCE_ACTION")
public class RevComplianceAction extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REV_COMPLIANCE_ACTION_SEQ")
    @SequenceGenerator(name = "REV_COMPLIANCE_ACTION_SEQ", sequenceName = "REV_COMPLIANCE_ACTION_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    @Column(name="BREACH_COUNT")
    private Integer breachCount;
        
    @Column(name="COMP_ACTION_TYPE")
    private String complianceActionType;
    
    @ManyToOne
    @JoinColumn(name = "COMPLIANCE_CONF_ID", referencedColumnName = "ID")
    private RevComplianceConfiguration complianceConfiguration;

    public RevComplianceAction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setComplianceConfiguration(RevComplianceConfiguration complianceConfiguration) {
        this.complianceConfiguration = complianceConfiguration;
    }

    public RevComplianceConfiguration getComplianceConfiguration() {
        return complianceConfiguration;
    }

    public void setBreachCount(Integer breachCount) {
        this.breachCount = breachCount;
    }

    public Integer getBreachCount() {
        return breachCount;
    }

    public void setComplianceActionType(String complianceActionType) {
        this.complianceActionType = complianceActionType;
    }

    public String getComplianceActionType() {
        return complianceActionType;
    }
}
