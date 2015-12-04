package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQueries (
    {
        @NamedQuery(name = "RefLegalStatusType.findAll", query = "select o from RefLegalStatusType o"),
        @NamedQuery(name = "RefLegalStatusType.findLegalStatusObj", query = "select o from RefLegalStatusType o where o.code=?1")
    }
)    
@Table(name = "REF_LEGAL_STATUS_TYPE")
public class RefLegalStatusType extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="TAXPAYER_TYPE")
    private String taxpayerType;
    @Column(name="HIERARCHY_LEVEL")
    private Long hierarchyLevel;
    @Column(name="RGD_REGISTRATION_REQUIRED")
    private String rgdRegistrationRequired;
    @OneToMany(mappedBy = "refLegalStatus")
    private List<RefLegalTaxTypeRel> refLegalTaxTypeRelList;
    @OneToMany(mappedBy = "legalStatus")
    private List<RefLegalStatusFiscal> refLegalStatusFiscalList;
    @Column(name="MISCELLANEOUS_VERIFICATION")
    private String miscellaneousVerification;

    public RefLegalStatusType() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getTaxpayerType() {
        return taxpayerType;
    }

    public RefLegalTaxTypeRel addRefLegalTaxTypeRel(RefLegalTaxTypeRel refLegalTaxTypeRel) {
        getRefLegalTaxTypeRelList().add(refLegalTaxTypeRel);
        refLegalTaxTypeRel.setRefLegalStatus(this);
        return refLegalTaxTypeRel;
    }

    public RefLegalTaxTypeRel removeRefLegalTaxTypeRel(RefLegalTaxTypeRel refLegalTaxTypeRel) {
        getRefLegalTaxTypeRelList().remove(refLegalTaxTypeRel);
        return refLegalTaxTypeRel;
    }

    public void setRefLegalTaxTypeRelList(List<RefLegalTaxTypeRel> refLegalTaxTypeRelList) {
        this.refLegalTaxTypeRelList = refLegalTaxTypeRelList;
    }

    public List<RefLegalTaxTypeRel> getRefLegalTaxTypeRelList() {
        return refLegalTaxTypeRelList;
    }

    public void setRefLegalStatusFiscalList(List<RefLegalStatusFiscal> refLegalStatusFiscalList) {
        this.refLegalStatusFiscalList = refLegalStatusFiscalList;
    }

    public List<RefLegalStatusFiscal> getRefLegalStatusFiscalList() {
        return refLegalStatusFiscalList;
    }
    
    public RefLegalStatusFiscal addRefLegalStatusFiscal(RefLegalStatusFiscal refLegalStatusFiscal) {
        getRefLegalStatusFiscalList().add(refLegalStatusFiscal);
        refLegalStatusFiscal.setLegalStatus(this);
        return refLegalStatusFiscal;
    }

    public RefLegalStatusFiscal removeRefLegalStatusFiscal(RefLegalStatusFiscal refLegalStatusFiscal) {
        getRefLegalStatusFiscalList().remove(refLegalStatusFiscal);
        return refLegalStatusFiscal;
    }

    public Long getHierarchyLevel() {
        return hierarchyLevel;
    }

    public void setHierarchyLevel(Long hierarchyLevel) {
        this.hierarchyLevel = hierarchyLevel;
    }

    public void setRgdRegistrationRequired(String rgdRegistrationRequired) {
        this.rgdRegistrationRequired = rgdRegistrationRequired;
    }

    public String getRgdRegistrationRequired() {
        return rgdRegistrationRequired;
    }

    public void setMiscellaneousVerification(String miscellaneousVerification) {
        this.miscellaneousVerification = miscellaneousVerification;
    }

    public String getMiscellaneousVerification() {
        return miscellaneousVerification;
    }
}
