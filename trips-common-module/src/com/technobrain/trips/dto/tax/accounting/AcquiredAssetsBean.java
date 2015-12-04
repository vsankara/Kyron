package com.technobrain.trips.dto.tax.accounting;

import java.sql.Timestamp;

public class AcquiredAssetsBean {

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
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private Timestamp dateOfRegistration;
    private String status;

    public AcquiredAssetsBean() {
    }

    public AcquiredAssetsBean(Long entityID, String TIN, String firstName, String lastName, String address1, String address2, String address3, String address4, Timestamp dateOfRegistration, String status) {
        this.entityID = entityID;
        this.TIN = TIN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.address4 = address4;
        this.dateOfRegistration = dateOfRegistration;
        this.status = status;
    }
    
    public AcquiredAssetsBean(Long entityID, String TIN, String registeredName, String tradeName, Timestamp dateOfRegistration, String address1, String address2, String address3, String address4, String status) {
        this.entityID = entityID;
        this.TIN = TIN;
        this.registeredName = registeredName;
        this.tradeName = tradeName;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.address4 = address4;
        this.dateOfRegistration = dateOfRegistration;
        this.status = status;
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

    public void setDateOfRegistration(Timestamp dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Timestamp getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAddress4() {
        return address4;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
