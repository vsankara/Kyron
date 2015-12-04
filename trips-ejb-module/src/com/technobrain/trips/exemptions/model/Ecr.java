package com.technobrain.trips.exemptions.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQueries(
    {
    @NamedQuery(name = "Ecr.findAll", query = "select o from Ecr o"),
    @NamedQuery(name = "Ecr.findById", 
    query = "select o from Ecr o where o.id = ?1"),
    @NamedQuery(name = "Ecr.findByCode", 
    query = "select o from Ecr o where o.code = ?1")
    
    }
)
@Table(name = "ECR")
public class Ecr extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ECR_SEQ")
    @SequenceGenerator(name = "ECR_SEQ", sequenceName = "ECR_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="APPLN_BASIS")
    private String applnBasis;
    private String category;
//    @ReferenceNumber(format="ESQL", sql="SELECT LTRIM(TO_CHAR(MOD(ECR_CODE_SEQ.nextval,000000000),'000000099')) as generatedId FROM dual")
//    @Column
    private String code;
    private String description;
    @Column(name="ECR_STATUS")
    private String ecrStatus;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="LEGAL_REFERENCE")
    private String legalReference;
    @Column(name="PERIOD_GRANTED")
    private String periodGranted;
    @Column(name="SINGLE_USAGE")
    private String singleUsage;
    private String title;
    @Column(name="USAGE_TYPE")
    private String usageType;
    @Column(name="EXEMPTION_TYPE")
    private String exemptionType;
    @OneToMany(mappedBy = "ecr" , cascade={CascadeType.ALL})
    private List<AttachmentInfo> attachmentInfoList;
    @OneToMany(mappedBy = "ecr" , cascade={CascadeType.ALL})
    private List<ExemBusSector> exemBusSectorList;
    @OneToMany(mappedBy = "ecr" , cascade={CascadeType.ALL})
    private List<ExemptionValue> exemptionValueList;
    @OneToMany(mappedBy = "ecr" , cascade={CascadeType.ALL})
    private List<ExemTaxType> exemTaxTypeList;
    @OneToMany(mappedBy = "ecr" , cascade={CascadeType.ALL})
    private List<ExemptionQualificationAttribute> qualificationAttributeList;
    
    public Ecr() {
    }

    public String getApplnBasis() {
        return applnBasis;
    }

    public void setApplnBasis(String applnBasis) {
        this.applnBasis = applnBasis;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getEcrStatus() {
        return ecrStatus;
    }

    public void setEcrStatus(String ecrStatus) {
        this.ecrStatus = ecrStatus;
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

    public String getLegalReference() {
        return legalReference;
    }

    public void setLegalReference(String legalReference) {
        this.legalReference = legalReference;
    }

    public String getPeriodGranted() {
        return periodGranted;
    }

    public void setPeriodGranted(String periodGranted) {
        this.periodGranted = periodGranted;
    }

    public String getSingleUsage() {
        return singleUsage;
    }

    public void setSingleUsage(String singleUsage) {
        this.singleUsage = singleUsage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    public void setExemptionType(String exemptionType) {
        this.exemptionType = exemptionType;
    }

    public String getExemptionType() {
        return exemptionType;
    }

    public void setAttachmentInfoList(List<AttachmentInfo> attachmentInfoList) {
        this.attachmentInfoList = attachmentInfoList;
    }

    public List<AttachmentInfo> getAttachmentInfoList() {
        return attachmentInfoList;
    }

    public void setExemBusSectorList(List<ExemBusSector> exemBusSectorList) {
        this.exemBusSectorList = exemBusSectorList;
    }

    public List<ExemBusSector> getExemBusSectorList() {
        return exemBusSectorList;
    }

    public void setExemptionValueList(List<ExemptionValue> exemptionValueList) {
        this.exemptionValueList = exemptionValueList;
    }

    public List<ExemptionValue> getExemptionValueList() {
        return exemptionValueList;
    }

    public void setExemTaxTypeList(List<ExemTaxType> exemTaxTypeList) {
        this.exemTaxTypeList = exemTaxTypeList;
    }

    public List<ExemTaxType> getExemTaxTypeList() {
        return exemTaxTypeList;
    }

    public void setQualificationAttributeList(List<ExemptionQualificationAttribute> qualificationAttributeList) {
        this.qualificationAttributeList = qualificationAttributeList;
    }

    public List<ExemptionQualificationAttribute> getQualificationAttributeList() {
        return qualificationAttributeList;
    }
}
