package com.technobrain.trips.compliance.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefRevType;

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

@Entity(name="TaxCompTaxType")
@NamedQueries (
    {
        @NamedQuery(name = "TaxCompTaxType.findAll", query = "select o from TaxCompTaxType o") 
    }    
)
@Table(name = "TAX_COMP_TAX_TYPE")
public class TaxCompTaxType extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAX_COMP_TAX_TYPE_SEQ")
    @SequenceGenerator(name = "TAX_COMP_TAX_TYPE_SEQ", sequenceName = "TAX_COMP_TAX_TYPE_SEQ", allocationSize = 1)
    @Column(name="TAX_TYPE_ID", nullable = false)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="COMPLIANCE_CONF_ID", referencedColumnName="ID")
    private TaxComplianceConf complianceConfId;
    
    @Column(name="REV_TYPE_CODE")
    private String revType;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="REV_TYPE_CODE", referencedColumnName="CODE", nullable=false, updatable=false, insertable=false)
    private RefRevType revenueType;
    
    public TaxCompTaxType() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRevenueType(RefRevType revenueType) {
        this.revenueType = revenueType;
    }

    public RefRevType getRevenueType() {
        return revenueType;
    }

    public void setComplianceConfId(TaxComplianceConf complianceConfId) {
        this.complianceConfId = complianceConfId;
    }

    public TaxComplianceConf getComplianceConfId() {
        return complianceConfId;
    }

    public void setRevType(String revType) {
        this.revType = revType;
    }

    public String getRevType() {
        return revType;
    }
}
