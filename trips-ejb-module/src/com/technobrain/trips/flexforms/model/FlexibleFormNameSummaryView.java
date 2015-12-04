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
    @NamedQuery(name = "FlexibleFormNameSummaryView.findFormNameByTaxTypeAndReturnType", 
        query = "select o from FlexibleFormNameSummaryView o " +
        "where o.docType=?1 and o.periodNumber=?2 and o.periodYear=?3 and (o.tin=?4 or o.tin is null)")
    }
)

@Table(name = "FLEXIBLE_FORM_NAME_SUMMARY")
public class FlexibleFormNameSummaryView {
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
    @Column(name = "LODGEMENT_ENTITY_ID")
    private String lodgementEntityId;
    @Column(name = "PERIOD_NO")
    private int periodNumber;
    @Column(name = "PERIOD_YEAR")
    private int periodYear;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "TIN")
    private String tin;
    @Column(name = "ENTITY_NAME")
    private String entityName;
    @Column(name = "PERIOD_START_DATE")
    private String periodStartDate;
    @Column(name = "PERIOD_END_DATE")
    private String periodEndDate;
    
    

    public FlexibleFormNameSummaryView(){
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

    public void setLodgementEntityId(String lodgementEntityId) {
        this.lodgementEntityId = lodgementEntityId;
    }

    public String getLodgementEntityId() {
        return lodgementEntityId;
    }

    public void setPeriodNumber(int periodNumber) {
        this.periodNumber = periodNumber;
    }

    public int getPeriodNumber() {
        return periodNumber;
    }

    public void setPeriodYear(int periodYear) {
        this.periodYear = periodYear;
    }

    public int getPeriodYear() {
        return periodYear;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getTin() {
        return tin;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setPeriodStartDate(String periodStartDate) {
        this.periodStartDate = periodStartDate;
    }

    public String getPeriodStartDate() {
        return periodStartDate;
    }

    public void setPeriodEndDate(String periodEndDate) {
        this.periodEndDate = periodEndDate;
    }

    public String getPeriodEndDate() {
        return periodEndDate;
    }
}

