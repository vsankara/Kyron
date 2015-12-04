package com.technobrain.trips.compliance.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefComplianceActionType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="TaxComplianceAction")
@NamedQueries (
    {
        @NamedQuery(name = "TaxComplianceAction.findAll", query = "select o from TaxComplianceAction o") 
    }    
)
@Table(name = "TAX_COMPLIANCE_ACTION")
public class TaxComplianceAction extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAX_COMPLIANCE_ACTION_SEQ")
    @SequenceGenerator(name = "TAX_COMPLIANCE_ACTION_SEQ", sequenceName = "TAX_COMPLIANCE_ACTION_SEQ", allocationSize = 1)
    @Column(name="ID", nullable = false)
    private Long id;
    
    @Column(name="COMP_ACTION")
    private String complianceAction;
        
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="COMP_ACTION", referencedColumnName="CODE", nullable=false, updatable=false, insertable=false)
    private RefComplianceActionType refComplianceActionType;
    
    @Column(name="BREACH_COUNT")
    private Integer breachCount;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="COMPLIANCE_CONF_ID", referencedColumnName="ID")
    private TaxComplianceConf complianceConfId;
    
    public TaxComplianceAction() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRefComplianceActionType(RefComplianceActionType refComplianceActionType) {
        this.refComplianceActionType = refComplianceActionType;
    }

    public RefComplianceActionType getRefComplianceActionType() {
        return refComplianceActionType;
    }

    public void setBreachCount(Integer breachCount) {
        this.breachCount = breachCount;
    }

    public Integer getBreachCount() {
        return breachCount;
    }

    public void setComplianceConfId(TaxComplianceConf complianceConfId) {
        this.complianceConfId = complianceConfId;
    }

    public TaxComplianceConf getComplianceConfId() {
        return complianceConfId;
    }

    public void setComplianceAction(String complianceAction) {
        this.complianceAction = complianceAction;
    }

    public String getComplianceAction() {
        return complianceAction;
    }
}
