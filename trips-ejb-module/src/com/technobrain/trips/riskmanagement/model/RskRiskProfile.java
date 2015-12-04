package com.technobrain.trips.riskmanagement.model;

import com.technobrain.trips.core.annotation.ReferenceNumber;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RskRiskProfile.findAll", 
    query = "select o from RskRiskProfile o")
@Table(name = "RSK_RISK_PROFILE")
public class RskRiskProfile extends BaseNormalModelObject{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "RSK_RISK_PROFILE_SEQ")
    @SequenceGenerator(name = "RSK_RISK_PROFILE_SEQ", sequenceName = "RSK_RISK_PROFILE_SEQ", 
                       allocationSize = 1)   
    @Column(nullable = false)
    private Long id;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="RETURN_TYPE", nullable = false)
    private String returnType;
    @Column(name="RISK_LEVEL", nullable = false)
    private String riskLevel;
    @Column(name="RISK_PROFILE_NAME", nullable = false)
    private String riskProfileName;
    @ReferenceNumber(format="RPSQL", sql="SELECT LTRIM(TO_CHAR(MOD(RISK_PROFILE_REFERENCE_NO_SEQ.nextval,000000),'000099')) as generatedId FROM dual")
    @Column(name="RISK_PROFILE_NUMBER", nullable = false)
    private String riskProfileNumber;
    
    @Column(name = "FLEXI_FORM_NAME")
    private String flexiFormName;
      
    @OneToMany(cascade={CascadeType.ALL}, mappedBy = "riskProfile")
    private List<RskRiskCriteria> riskCriteriaList;
    
    @OneToMany(cascade={CascadeType.ALL}, mappedBy = "riskProfile")
    private List<RskRiskProfileBusSect> riskProfileBusSectorList;
    
    @OneToMany(cascade={CascadeType.ALL}, mappedBy = "riskProfile")
    private List<RskRiskProfileOffice> riskProfileOfficeList;
    
    @OneToMany(cascade={CascadeType.ALL}, mappedBy = "riskProfile")
    private List<RskRiskProfileRegion> riskProfileRegionList;

    public RskRiskProfile() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRiskProfileName() {
        return riskProfileName;
    }

    public void setRiskProfileName(String riskProfileName) {
        this.riskProfileName = riskProfileName;
    }

    public String getRiskProfileNumber() {
        return riskProfileNumber;
    }

    public void setRiskProfileNumber(String riskProfileNumber) {
        this.riskProfileNumber = riskProfileNumber;
    }

    public void setRiskCriteriaList(List<RskRiskCriteria> riskCriteriaList) {
        this.riskCriteriaList = riskCriteriaList;
    }

    public List<RskRiskCriteria> getRiskCriteriaList() {
        return riskCriteriaList;
    }
    
    public RskRiskCriteria addRskRiskCriteria(RskRiskCriteria rskRiskCriteria) {
        rskRiskCriteria.setRiskProfile(this);
        getRiskCriteriaList().add(rskRiskCriteria);
        return rskRiskCriteria;
    }

    public RskRiskCriteria removeRskRiskCriteria(RskRiskCriteria rskRiskCriteria) {
        getRiskCriteriaList().remove(rskRiskCriteria);
        return rskRiskCriteria;
    }

    public void setRiskProfileBusSectorList(List<RskRiskProfileBusSect> riskProfileBusSectorList) {
        this.riskProfileBusSectorList = riskProfileBusSectorList;
    }

    public List<RskRiskProfileBusSect> getRiskProfileBusSectorList() {
        return riskProfileBusSectorList;
    }
    
    public RskRiskProfileBusSect addRskRiskProfileBusSect(RskRiskProfileBusSect rskRiskProfileBusSect) {
        rskRiskProfileBusSect.setRiskProfile(this);
        getRiskProfileBusSectorList().add(rskRiskProfileBusSect);
        return rskRiskProfileBusSect;
    }

    public RskRiskProfileBusSect removeRskRiskProfileBusSect(RskRiskProfileBusSect rskRiskProfileBusSect) {
        getRiskProfileBusSectorList().remove(rskRiskProfileBusSect);
        return rskRiskProfileBusSect;
    }

    public void setRiskProfileOfficeList(List<RskRiskProfileOffice> riskProfileOfficeList) {
        this.riskProfileOfficeList = riskProfileOfficeList;
    }

    public List<RskRiskProfileOffice> getRiskProfileOfficeList() {
        return riskProfileOfficeList;
    }
    
    public RskRiskProfileOffice addRskRiskProfileOffice(RskRiskProfileOffice rskRiskProfileOffice) {
        rskRiskProfileOffice.setRiskProfile(this);
        getRiskProfileOfficeList().add(rskRiskProfileOffice);
        return rskRiskProfileOffice;
    }

    public RskRiskProfileOffice removeRskRiskProfileOffice(RskRiskProfileOffice rskRiskProfileOffice) {
        getRiskProfileOfficeList().remove(rskRiskProfileOffice);
        return rskRiskProfileOffice;
    }

    public void setRiskProfileRegionList(List<RskRiskProfileRegion> riskProfileRegionList) {
        this.riskProfileRegionList = riskProfileRegionList;
    }

    public List<RskRiskProfileRegion> getRiskProfileRegionList() {
        return riskProfileRegionList;
    }
    
    public RskRiskProfileRegion addRskRiskProfileRegion(RskRiskProfileRegion rskRiskProfileRegion) {
        rskRiskProfileRegion.setRiskProfile(this);
        getRiskProfileRegionList().add(rskRiskProfileRegion);
        return rskRiskProfileRegion;
    }

    public RskRiskProfileRegion removeRskRiskProfileRegion(RskRiskProfileRegion rskRiskProfileRegion) {
        getRiskProfileRegionList().remove(rskRiskProfileRegion);
        return rskRiskProfileRegion;
    }

    public void setFlexiFormName(String flexiFormName) {
        this.flexiFormName = flexiFormName;
    }

    public String getFlexiFormName() {
        return flexiFormName;
    }
}
