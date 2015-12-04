package com.technobrain.trips.compliance.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefLegalStatusType;

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

@Entity(name="TaxCompTaxpayerCategory")
@NamedQueries (
    {
        @NamedQuery(name = "TaxCompTaxpayerCategory.findAll", query = "select o from TaxCompTaxpayerCategory o") 
    }    
)
@Table(name = "TAX_COMP_TAXPAYER_CATEGORY")
public class TaxCompTaxpayerCategory extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAX_COMP_TAXPAYER_CATEGORY_SEQ")
    @SequenceGenerator(name = "TAX_COMP_TAXPAYER_CATEGORY_SEQ", sequenceName = "TAX_COMP_TAXPAYER_CATEGORY_SEQ", allocationSize = 1)
    @Column(name="TAXPAYER_CATEGORY_ID", nullable = false)
    private Long id;
        
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="COMPLIANCE_CONF_ID", referencedColumnName="ID")
    private TaxComplianceConf complianceConfId;    
    
    @Column(name="TAXPAYER_CATEGORY_CODE")
    private String taxpayerLegalStatus;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="TAXPAYER_CATEGORY_CODE", referencedColumnName="CODE", nullable=false, updatable=false, insertable=false)
    private RefLegalStatusType taxpayerCategory;
    
    public TaxCompTaxpayerCategory() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setComplianceConfId(TaxComplianceConf complianceConfId) {
        this.complianceConfId = complianceConfId;
    }

    public TaxComplianceConf getComplianceConfId() {
        return complianceConfId;
    }

    public void setTaxpayerCategory(RefLegalStatusType taxpayerCategory) {
        this.taxpayerCategory = taxpayerCategory;
    }

    public RefLegalStatusType getTaxpayerCategory() {
        return taxpayerCategory;
    }

    public void setTaxpayerLegalStatus(String taxpayerLegalStatus) {
        this.taxpayerLegalStatus = taxpayerLegalStatus;
    }

    public String getTaxpayerLegalStatus() {
        return taxpayerLegalStatus;
    }
}
