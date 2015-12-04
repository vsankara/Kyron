package com.technobrain.trips.compliance.model;

//import com.crownagents.trips.core.configuration.model.PAndIConfiguration;
import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.entity.model.EntIdentification;
import com.technobrain.trips.reference.model.RefComplianceType;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="TaxComplianceConf")
@NamedQueries (
    {
        @NamedQuery(name = "TaxComplianceConf.findAll", query = "select o from TaxComplianceConf o"),
        @NamedQuery(name = "TaxComplianceConf.findTaxComplianceById", query = "select o from TaxComplianceConf o where o.id=?1")
    }    
)
@Table(name = "TAX_COMPLIANCE_CONF")
public class TaxComplianceConf extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAX_COMPLIANCE_CONF_SEQ")
    @SequenceGenerator(name = "TAX_COMPLIANCE_CONF_SEQ", sequenceName = "TAX_COMPLIANCE_CONF_SEQ", allocationSize = 1)
    @Column(name="ID", nullable = false)
    private Long id;
    
    @Column(name="COMPLIANCE_TYPE")
    private String complianceType; 

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="COMPLIANCE_TYPE", referencedColumnName="CODE", nullable=false, updatable=false, insertable=false)
    private RefComplianceType refComplianceType;
    
    @OneToMany(mappedBy = "complianceConfId", fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    private List<TaxCompTaxpayerCategory> categories = new ArrayList<TaxCompTaxpayerCategory>();
    
    @OneToMany(mappedBy = "complianceConfId", fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    private List<TaxCompTaxpayerType> taxpayerTypes = new ArrayList<TaxCompTaxpayerType>();
    
    @OneToMany(mappedBy = "complianceConfId", fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    private List<TaxCompTaxType> taxTypes = new ArrayList<TaxCompTaxType>();
    
    @OneToMany(mappedBy = "complianceConfId", fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    private List<TaxComplianceAction> actions = new ArrayList<TaxComplianceAction>();
    
//    @OneToMany(mappedBy = "complianceId", fetch = FetchType.EAGER, cascade={CascadeType.ALL})
//    private List<PAndIConfiguration> pAndIConfigs = new ArrayList<PAndIConfiguration>();
    
    @OneToMany(mappedBy = "configId", fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    private List<TaxComplianceProcess> processes = new ArrayList<TaxComplianceProcess>();
    
    @Column(name="GRACE_PERIOD")
    private Integer gracePeriod;
    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    public TaxComplianceConf() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setGracePeriod(Integer gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setRefComplianceType(RefComplianceType refComplianceType) {
        this.refComplianceType = refComplianceType;
    }

    public RefComplianceType getRefComplianceType() {
        return refComplianceType;
    }

    public void setCategories(List<TaxCompTaxpayerCategory> categories) {
        this.categories = categories;
    }

    public List<TaxCompTaxpayerCategory> getCategories() {
        return categories;
    }
    
    public TaxCompTaxpayerCategory addCategories(TaxCompTaxpayerCategory taxCompTaxpayerCategory) {
        getCategories().add(taxCompTaxpayerCategory);
        taxCompTaxpayerCategory.setComplianceConfId(this);
        return taxCompTaxpayerCategory;
    }

    public TaxCompTaxpayerCategory removeCategories(TaxCompTaxpayerCategory taxCompTaxpayerCategory) {
        getCategories().remove(taxCompTaxpayerCategory);
        //taxComplianceAction.setParentEntity(null);
        return taxCompTaxpayerCategory;
    }

    public void setTaxpayerTypes(List<TaxCompTaxpayerType> taxpayerTypes) {
        this.taxpayerTypes = taxpayerTypes;
    }

    public List<TaxCompTaxpayerType> getTaxpayerTypes() {
        return taxpayerTypes;
    }
    
    public TaxCompTaxpayerType addTaxCompTaxpayerType(TaxCompTaxpayerType taxCompTaxpayerType) {
        getTaxpayerTypes().add(taxCompTaxpayerType);
        taxCompTaxpayerType.setComplianceConfId(this);
        return taxCompTaxpayerType;
    }

    public TaxCompTaxpayerType removeTaxCompTaxpayerType(TaxCompTaxpayerType taxCompTaxpayerType) {
        getTaxpayerTypes().remove(taxCompTaxpayerType);
        //taxComplianceAction.setParentEntity(null);
        return taxCompTaxpayerType;
    }

    public void setTaxTypes(List<TaxCompTaxType> taxTypes) {
        this.taxTypes = taxTypes;
    }

    public List<TaxCompTaxType> getTaxTypes() {
        return taxTypes;
    }
    
    public TaxCompTaxType addTaxTypes(TaxCompTaxType taxCompTaxType) {
        getTaxTypes().add(taxCompTaxType);
        taxCompTaxType.setComplianceConfId(this);
        return taxCompTaxType;
    }

    public TaxCompTaxType removeTaxTypes(TaxCompTaxType taxCompTaxType) {
        getTaxTypes().remove(taxCompTaxType);
        //taxComplianceAction.setParentEntity(null);
        return taxCompTaxType;
    }
    
    
    public void setActions(List<TaxComplianceAction> actions) {
        this.actions = actions;
    }

    public List<TaxComplianceAction> getActions() {
        return actions;
    }
    
    public TaxComplianceAction addActions(TaxComplianceAction taxComplianceAction) {
        getActions().add(taxComplianceAction);
        taxComplianceAction.setComplianceConfId(this);
        return taxComplianceAction;
    }

    public TaxComplianceAction removeActions(TaxComplianceAction taxComplianceAction) {
        getActions().remove(taxComplianceAction);
        //taxComplianceAction.setParentEntity(null);
        return taxComplianceAction;
    }
    
//    public void setPAndIConfigs(List<PAndIConfiguration> pAndIConfigs) {
//        this.pAndIConfigs = pAndIConfigs;
//    }
//
//    public List<PAndIConfiguration> getPAndIConfigs() {
//        return pAndIConfigs;
//    }
//    
//    public PAndIConfiguration addPandIConfiguration(PAndIConfiguration pAndIConfiguration) {
//        getPAndIConfigs().add(pAndIConfiguration);
//        pAndIConfiguration.setComplianceId(this);
//        return pAndIConfiguration;
//    }
//
//    public PAndIConfiguration removePandIConfiguration(PAndIConfiguration pAndIConfiguration) {
//        getPAndIConfigs().remove(pAndIConfiguration);
//        //taxComplianceAction.setParentEntity(null);
//        return pAndIConfiguration;
//    }

    public void setProcesses(List<TaxComplianceProcess> processes) {
        this.processes = processes;
    }

    public List<TaxComplianceProcess> getProcesses() {
        return processes;
    }

    public void setComplianceType(String complianceType) {
        this.complianceType = complianceType;
    }

    public String getComplianceType() {
        return complianceType;
    }
}
