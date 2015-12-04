package com.technobrain.trips.flexforms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@NamedQueries( 
    {
    @NamedQuery(name = "PortalFlexibleFormDocType.findFormNameByTaxTypeAndReturnType", 
        query = "select o from PortalFlexibleFormDocType o where o.docType=?1 and o.validFrom <=?2 and o.validTo>=?3"),
        @NamedQuery(name = "PortalFlexibleFormDocType.findFormNameByDocType", 
        query = "select o from PortalFlexibleFormDocType o where o.docType=?1")    
    }
)

@Table(name = "FLEXIBLE_FORM_NAME_BY_DOC_TYPE")
public class PortalFlexibleFormDocType {
    @Id
    @Column(name = "DOC_CODE")
    private String docCode;
    @Column(name = "DOC_TYPE")
    private String docType;
    @Column(name = "RETURN_TYPE")
    private String returnType;
    @Column(name = "TAX_TYPE")
    private String taxType;
    @Column(name = "FORM_NAME")
    private String formName;
    @Column(name = "FORM_TYPE")
    private String formType;
    @Column(name = "BASE_TABLE")
    private String baseTable;
    
    @Column(name = "VALID_FROM")
    private String validFrom;
    
    @Column(name = "VALID_TO")
    private String validTo;
    
    
    @Column(name = "PERIOD_TYPE")
    private String periodType;


    

    public PortalFlexibleFormDocType(){
    }

    public void setTaxType(String description) {
        this.taxType = description;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getFormType() {
        return formType;
    }

    public void setBaseTable(String baseTable) {
        this.baseTable = baseTable;
    }

    public String getBaseTable() {
        return baseTable;
    }

   public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }


    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public String getValidTo() {
        return validTo;
    }
}

