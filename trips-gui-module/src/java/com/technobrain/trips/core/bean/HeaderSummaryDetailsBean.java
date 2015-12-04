package com.technobrain.trips.core.bean;



import com.technobrain.trips.common.constants.Constants;
import java.util.Calendar;

public class HeaderSummaryDetailsBean {
    private Long id;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String status;
    private Calendar dateOfRegistration;
    private Calendar dateOfDeRegistration;
    private String accountNumber;
    private String legalName;
    private String legalStatus;
    private String tradingName;
    private long entityAccountId;
    private String entityType;
    private String entityOffice;
    private String tin;
    private String displayStatus;
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
    

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDateOfRegistration(Calendar dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Calendar getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setEntityAccountId(long entityAccountId) {
        this.entityAccountId = entityAccountId;
    }

    public long getEntityAccountId() {
        return entityAccountId;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityType() {
        return entityType;
    }

    public boolean isIndividual() {
        return getEntityType().equalsIgnoreCase(Constants.Entity.INDIVIDUAL_TYPE);
    }

    public boolean isOrganisation() {
        return getEntityType().equalsIgnoreCase(Constants.Entity.ORGANIZATION_TYPE);
    }

    public void setLegalStatus(String legalStatus) {
        this.legalStatus = legalStatus;
    }

    public String getLegalStatus() {
        return legalStatus;
    }

    public void setDateOfDeRegistration(Calendar dateOfDeRegistration) {
        this.dateOfDeRegistration = dateOfDeRegistration;
    }

    public Calendar getDateOfDeRegistration() {
        return dateOfDeRegistration;
    }

    public void setEntityOffice(String entityOffice) {
        this.entityOffice = entityOffice;
    }

    public String getEntityOffice() {
        return entityOffice;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getTin() {
        return tin;
    }

    public void setDisplayStatus(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }
}
