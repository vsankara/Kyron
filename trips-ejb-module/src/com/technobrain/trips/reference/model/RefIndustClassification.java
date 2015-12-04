package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefIndustClassification.findAll", 
    query = "select o from RefIndustClassification o")
@Table(name = "REF_INDUST_CLASSIFICATION")
public class RefIndustClassification extends BaseRefModelObject {

    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="INDUSTRY_CLASS")
    private String industryClass;
    @Column(name="INDUSTRY_GROUP")
    private String industryGroup;
    @Column(name="ISIC3_1")
    private String isic3_1;
    @Column(name="PSIC_1977")
    private String psic1977;
    @Column(name="PSIC_1994")
    private String psic1994;
   
    public RefIndustClassification() {
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

    public String getIndustryClass() {
        return industryClass;
    }

    public void setIndustryClass(String industryClass) {
        this.industryClass = industryClass;
    }

    public String getIndustryGroup() {
        return industryGroup;
    }

    public void setIndustryGroup(String industryGroup) {
        this.industryGroup = industryGroup;
    }

    public String getIsic3_1() {
        return isic3_1;
    }

    public void setIsic3_1(String isic3_1) {
        this.isic3_1 = isic3_1;
    }

    public String getPsic1977() {
        return psic1977;
    }

    public void setPsic1977(String psic1977) {
        this.psic1977 = psic1977;
    }

    public String getPsic1994() {
        return psic1994;
    }

    public void setPsic1994(String psic1994) {
        this.psic1994 = psic1994;
    }
}
