package com.technobrain.trips.compliance.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefEntityType;

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

@Entity(name="TaxCompTaxpayerType")
@NamedQueries (
    {
        @NamedQuery(name = "TaxCompTaxpayerType.findAll", query = "select o from TaxCompTaxpayerType o") 
    }    
)
@Table(name = "TAX_COMP_TAXPAYER_TYPE")
public class TaxCompTaxpayerType extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAX_COMP_TAXPAYER_TYPE_SEQ")
    @SequenceGenerator(name = "TAX_COMP_TAXPAYER_TYPE_SEQ", sequenceName = "TAX_COMP_TAXPAYER_TYPE_SEQ", allocationSize = 1)
    @Column(name="TAXPAYER_TYPE_ID", nullable = false)
    private Long id;
        
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="COMPLIANCE_CONF_ID", referencedColumnName="ID")
    private TaxComplianceConf complianceConfId;
    
    @Column(name="TAXPAYER_TYPE_CODE")
    private String taxpayerEntityType;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="TAXPAYER_TYPE_CODE", referencedColumnName="CODE", nullable=false, updatable=false, insertable=false)
    private RefEntityType taxpayerType;
    
    public TaxCompTaxpayerType() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTaxpayerType(RefEntityType taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public RefEntityType getTaxpayerType() {
        return taxpayerType;
    }

    public void setComplianceConfId(TaxComplianceConf complianceConfId) {
        this.complianceConfId = complianceConfId;
    }

    public TaxComplianceConf getComplianceConfId() {
        return complianceConfId;
    }

    public void setTaxpayerEntityType(String taxpayerEntityType) {
        this.taxpayerEntityType = taxpayerEntityType;
    }

    public String getTaxpayerEntityType() {
        return taxpayerEntityType;
    }
}
