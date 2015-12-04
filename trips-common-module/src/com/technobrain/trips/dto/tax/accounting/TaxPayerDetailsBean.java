package com.technobrain.trips.dto.tax.accounting;

import java.sql.Timestamp;

import java.util.Date;

public class TaxPayerDetailsBean {

    private Long id;
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
    private String status;
    private Timestamp returnPeriod;
    private Timestamp dateOfRegistration;
    private String RDO;

    public TaxPayerDetailsBean() {
    }

    public TaxPayerDetailsBean(Long entityID, String TIN, String firstName, String lastName, String status, Timestamp dateOfRegistration, String RDO) {
        this.entityID = entityID;
        this.TIN = TIN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.dateOfRegistration = dateOfRegistration;
        this.RDO = RDO;
    }
    
    public TaxPayerDetailsBean(String TIN, Long entityID, String registeredName, String tradeName, String status, Timestamp dateOfRegistration, String RDO) {
        this.entityID = entityID;
        this.TIN = TIN;
        this.registeredName = registeredName;
        this.tradeName = tradeName;
        this.status = status;
        this.dateOfRegistration = dateOfRegistration;
        this.RDO = RDO;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setEntityID(Long entityID) {
        this.entityID = entityID;
    }

    public Long getEntityID() {
        return entityID;
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

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getMaidenName() {
        return maidenName;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setReturnPeriod(Timestamp returnPeriod) {
        this.returnPeriod = returnPeriod;
    }

    public Timestamp getReturnPeriod() {
        return returnPeriod;
    }

    public void setDateOfRegistration(Timestamp dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Timestamp getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setRDO(String rDO) {
        this.RDO = rDO;
    }

    public String getRDO() {
        return RDO;
    }
}
