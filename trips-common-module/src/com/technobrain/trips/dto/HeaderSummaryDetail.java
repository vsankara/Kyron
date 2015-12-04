package com.technobrain.trips.dto;

import java.sql.Timestamp;

/**
 * � Crown Agents 2007
 * This is a DTO for individual and organisation header details. It is used to transfer
 * the (read only)header details.
 * 
 * @since $Date: 2/1/2010 7:22:33 AM$
 * @version $Revision: 11$
 * @author $Author: Vythilingam Pirabaharan$
 * 
 * $Log[1]:
 *  11   TRIPS2 etis.bir.gov.ph1.8.1.1     2/1/2010 7:22:33 AM    Vythilingam
 *       Pirabaharan Added entity office to the header regions of individual
 *       and organisation. 
 * $
 */
public class HeaderSummaryDetail implements DataTransferObject{
    
    private Long id;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String status;
    private Timestamp dateOfRegistration;
    private Timestamp dateOfDeRegistration;
    private String accountNumber;
    private String legalName;
    private String legalStatus;
    private String tradingName;
    private long entityAccountId;
    private String entityType;
    private String entityOffice;
    private String tin;
    private String displayStatus;
    
    /**
     * @param title
     * @param firstName
     * @param lastName
     * @param accountNumber
     * @param dateOfRegistration
     * @param status
     * This is a constructor that represents individual header details
     */
    public HeaderSummaryDetail(Long id,String title,String firstName,String middleName,String lastName,String suffix,String accountNumber,Timestamp dateOfRegistration, Timestamp dateOfDeRegistration ,String status, String entityOffice,String displayStatus) {
        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.accountNumber = accountNumber;
        this.dateOfRegistration = dateOfRegistration;
        this.dateOfDeRegistration = dateOfDeRegistration;
        this.status = status;
        this.entityOffice = entityOffice;
        this.displayStatus = displayStatus;
    }

    /**
     * @param legalName
     * @param tradingName
     * @param accountNumber
     * @param dateOfRegistration
     * @param status
     * This is a constructor that represents organisation header details
     */
    public HeaderSummaryDetail(Long id, String legalName,String tradingName,String accountNumber,Timestamp dateOfRegistration, Timestamp dateOfDeRegistration, String status,String legalStatus,String entityOffice,String displayStatus) {
        this.id = id;
        this.legalName = legalName;
        this.tradingName = tradingName;
        this.accountNumber = accountNumber;
        this.dateOfRegistration = dateOfRegistration;
        this.dateOfDeRegistration = dateOfDeRegistration;
        this.status = status;
        this.legalStatus = legalStatus;
        this.entityOffice = entityOffice;
        this.displayStatus = displayStatus;
    }
    
    public HeaderSummaryDetail() {
        
    }
    
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

    public void setDateOfRegistration(Timestamp dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Timestamp getDateOfRegistration() {
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

    public void setLegalStatus(String legalStatus) {
        this.legalStatus = legalStatus;
    }

    public String getLegalStatus() {
        return legalStatus;
    }

    public void setDateOfDeRegistration(Timestamp dateOfDeRegistration) {
        this.dateOfDeRegistration = dateOfDeRegistration;
    }

    public Timestamp getDateOfDeRegistration() {
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
