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
@NamedQuery(name = "RevComplianceTaxType.findAll", 
    query = "select o from RevComplianceTaxType o")
@Table(name = "REV_COMPLIANCE_TAX_TYPE")
public class RevComplianceTaxType extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REV_COMPLIANCE_TAX_TYPE_SEQ")
    @SequenceGenerator(name = "REV_COMPLIANCE_TAX_TYPE_SEQ", sequenceName = "REV_COMPLIANCE_TAX_TYPE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
        
    @Column(name="TAX_TYPE")
    private String taxType;
    
    @ManyToOne
    @JoinColumn(name = "COMPLIANCE_CONF_ID", referencedColumnName = "ID")
    private RevComplianceConfiguration complianceConfiguration;

    public RevComplianceTaxType() {
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

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxType() {
        return taxType;
    }
}
