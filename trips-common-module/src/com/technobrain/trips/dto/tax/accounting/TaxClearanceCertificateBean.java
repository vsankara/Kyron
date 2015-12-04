package com.technobrain.trips.dto.tax.accounting;

import java.sql.Timestamp;

public class TaxClearanceCertificateBean {

    private Long entityID;
    private String classificationType;
    private String taxpayerType;
    private String TIN;
    private String firstName;
    private String lastName;
    private String maidenName;
    private String middleName;
    private Timestamp dateOfBirth;
    private String registeredName;
    private String tradeName;
    private String registeringOffice;
    private String suffix;
    private Timestamp dateOfRegistration;

    public TaxClearanceCertificateBean() {
    }
    
    public TaxClearanceCertificateBean(Long entityID, String TIN, String firstName, String lastName, String suffix, Timestamp dateOfRegistration) {
        this.entityID = entityID;
        this.TIN = TIN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.dateOfRegistration = dateOfRegistration;
    }
    
    public TaxClearanceCertificateBean(Long entityID, String TIN, String registeredName, String tradeName, Timestamp dateOfRegistration, String registeringOffice) {
        this.entityID = entityID;
        this.TIN = TIN;
        this.registeredName = registeredName;
        this.tradeName = tradeName;
        this.dateOfRegistration = dateOfRegistration;
        this.registeringOffice = registeringOffice;
    }

    public void setClassificationType(String classificationType) {
        this.classificationType = classificationType;
    }

    public String getClassificationType() {
        return classificationType;
    }

    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getTaxpayerType() {
        return taxpayerType;
    }

    public void setTIN(String tIN) {
        this.TIN = tIN;
    }

    public String getTIN() {
        return TIN;
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

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setDateOfRegistration(Timestamp dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Timestamp getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setEntityID(Long entityID) {
        this.entityID = entityID;
    }

    public Long getEntityID() {
        return entityID;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setRegisteringOffice(String registeringOffice) {
        this.registeringOffice = registeringOffice;
    }

    public String getRegisteringOffice() {
        return registeringOffice;
    }
}
