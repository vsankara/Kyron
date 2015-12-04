package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries(
    {
    @NamedQuery(name = "RefCaseType.findAll", 
    query = "select o from RefCaseType o"),
    @NamedQuery(name = "RefCaseType.findByCaseType", 
    query = "select o from RefCaseType o where o.code = ?1")
    }
)
@Table(name = "REF_CASE_TYPE")
public class RefCaseType extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    @Column(name="PREFIX")
    private String Prefix; 
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="CASE_CATEGORY")
    private String category;
    @Column(name="CASE_TYPE")
    private String caseType;
    
         
    public RefCaseType() {
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

    public void setEffectiveDate(Timestamp effectiveAdte) {
        this.effectiveDate = effectiveAdte;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    

    public void setPrefix(String prefix) {
        this.Prefix = prefix;
    }

    public String getPrefix() {
        return Prefix;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseType() {
        return caseType;
    }
}
