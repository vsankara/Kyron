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
@NamedQuery(name = "RevComplianceTaxpayerType.findAll", 
    query = "select o from RevComplianceTaxpayerType o")
@Table(name = "REV_COMPL_TAXPAYER_TYPE")
public class RevComplianceTaxpayerType extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REV_COMPL_TAXPAYER_TYPE_SEQ")
    @SequenceGenerator(name = "REV_COMPL_TAXPAYER_TYPE_SEQ", sequenceName = "REV_COMPL_TAXPAYER_TYPE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
        
    @Column(name="TAXPAYER_TYPE")
    private String taxpayerType;
    
    @ManyToOne
    @JoinColumn(name = "COMPLIANCE_CONF_ID", referencedColumnName = "ID")
    private RevComplianceConfiguration complianceConfiguration;

    public RevComplianceTaxpayerType() {
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

    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getTaxpayerType() {
        return taxpayerType;
    }
}
