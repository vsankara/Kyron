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
@NamedQuery(name = "RevComplianceIndCategory.findAll", 
    query = "select o from RevComplianceIndCategory o")
@Table(name = "REV_COMPL_IND_CATEGORY")
public class RevComplianceIndCategory extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REV_COMPL_IND_CATEGORY_SEQ")
    @SequenceGenerator(name = "REV_COMPL_IND_CATEGORY_SEQ", sequenceName = "REV_COMPL_IND_CATEGORY_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
        
    @Column(name="IND_CATEGORY")
    private String individualCategory;
    
    @ManyToOne
    @JoinColumn(name = "COMPLIANCE_CONF_ID", referencedColumnName = "ID")
    private RevComplianceConfiguration complianceConfiguration;

    public RevComplianceIndCategory() {
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

    public void setIndividualCategory(String individualCategory) {
        this.individualCategory = individualCategory;
    }

    public String getIndividualCategory() {
        return individualCategory;
    }
}
