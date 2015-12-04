 package com.technobrain.trips.entity.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * TechnoBrain 2006
 *
 * Entity for table ENT_INDIVIDUAL
 *
 * @since	$Date: 1/26/2010 7:45:47 PM$
 * @version 	$Revision: 28$
 * @author 	$Author: Alvin Fernandez$
 * 
 * $Log[1]:
 *  28   TRIPS2 etis.bir.gov.ph1.19.1.7    1/26/2010 7:45:47 PM   Alvin
 *       Fernandez Bug fix for testing
 * $
 */
@Entity
@NamedQueries  ( 
    {
@NamedQuery(name = "EntIndividual.findAll", 
    query = "select o from EntIndividual o"),
@NamedQuery(name = "EntIndividual.findIndividualById", 
    query = "select ind from EntIndividual ind where ind.id = ?1")
    }
)
@Table(name = "ENT_INDIVIDUAL")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("INDIVIDUAL")
public class EntIndividual extends EntEntity    {
    @Column(name="DATE_OF_BIRTH")
    private Timestamp dateOfBirth;

    @Column(name="FIRST_NAME")
    private String firstName;
    private String gender;
    @Column(name="KNOWN_AS")
    private String knownAs;

    @Column(name="REGISTRATION_NUMBER")
    private String registrationNumber;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="MARITAL_STATUS")
    private String maritalStatus;
    @Column(name="MIDDLE_NAME")
    private String middleName;

    private String nationality;

    @Column(name="PLACE_OF_BIRTH")
    private String placeOfBirth;
    @Column(name="PREVIOUS_LAST_NAME")
    private String previousLastName;
    private String title;
    @Column(name="VIP_INDICATOR")
    private String vipIndicator;


    @Column(name="FIRST_NAME_PHONETIC")
    private String firstNamePhonetic;
    @Column(name="MIDDLE_NAME_PHONETIC")
    private String middleNamePhonetic;
    @Column(name="LAST_NAME_PHONETIC")
    private String lastNamePhonetic;
    @Column(name="FULL_NAME_PHONETIC")
    private String fullNamePhonetic;
    @Column(name="COUNTRY_OF_BIRTH")
    private String countryOfBirth;
    @Column(name="PURPOSE_OF_TIN")
    private String purposeOfTin;
    @Column(name="SUFFIX")
    private String suffix;
    @Column(name="INACTIVE_INDICATOR")
    private String inActiveIndicator;
    @Column(name="TAMP_INDICATOR")
    private String tampIndicator;
    @Column(name="COMPANY_REG_NO")
    private String companyRegNo;
    @Column(name="COMPANY_REG_DATE")
    private Timestamp companyRegDate;
    @Column(name="BUSINESS_START_DATE")
    private Timestamp businessStartDate;


  
    @Column(name="MOTHER_FIRST_NAME")
    private String motherFirstName;
    @Column(name="MOTHER_LAST_NAME")
    private String motherLastName;
    @Column(name="MOTHER_MIDDLE_NAME")
    private String motherMiddleName;
    @Column(name="DISTRICT_CODE")
    private String districtCode;
    @Column(name="REGION_CODE")
    private String regionCode;
    @Column(name="RESIDENT_INDICATOR")
    private String residentIndicator;

    @Column(name="ESTIMATED_DOB_INDICATOR")
    private String estimatedDateofBirth;
    @OneToOne(cascade={CascadeType.ALL}, mappedBy="entEntity")
    private EntSoleProprietorInfo solePropDetails;
    
    
    public EntIndividual() {
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKnownAs() {
        return knownAs;
    }

    public void setKnownAs(String knownAs) {
        this.knownAs = knownAs;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getPreviousLastName() {
        return previousLastName;
    }

    public void setPreviousLastName(String previousLastName) {
        this.previousLastName = previousLastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVipIndicator() {
        return vipIndicator;
    }

    public void setVipIndicator(String vipIndicator) {
        this.vipIndicator = vipIndicator;
    }
    
    public void setFirstNamePhonetic(String firstNamePhonetic) {
        this.firstNamePhonetic = firstNamePhonetic;
    }

    public String getFirstNamePhonetic() {
        return firstNamePhonetic;
    }

    public void setMiddleNamePhonetic(String middleNamePhonetic) {
        this.middleNamePhonetic = middleNamePhonetic;
    }

    public String getMiddleNamePhonetic() {
        return middleNamePhonetic;
    }

    public void setLastNamePhonetic(String lastNamePhonetic) {
        this.lastNamePhonetic = lastNamePhonetic;
    }

    public String getLastNamePhonetic() {
        return lastNamePhonetic;
    }

    public void setFullNamePhonetic(String fullNamePhonetic) {
        this.fullNamePhonetic = fullNamePhonetic;
    }

    public String getFullNamePhonetic() {
        return fullNamePhonetic;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setPurposeOfTin(String purposeOfTin) {
        this.purposeOfTin = purposeOfTin;
    }

    public String getPurposeOfTin() {
        return purposeOfTin;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setInActiveIndicator(String inActiveIndicator) {
        this.inActiveIndicator = inActiveIndicator;
    }

    public String getInActiveIndicator() {
        return inActiveIndicator;
    }

    public void setTampIndicator(String tampIndicator) {
        this.tampIndicator = tampIndicator;
    }

    public String getTampIndicator() {
        return tampIndicator;
    }

    public void setCompanyRegNo(String companyRegNo) {
        this.companyRegNo = companyRegNo;
    }

    public String getCompanyRegNo() {
        return companyRegNo;
    }

    public void setCompanyRegDate(Timestamp companyRegDate) {
        this.companyRegDate = companyRegDate;
    }

    public Timestamp getCompanyRegDate() {
        return companyRegDate;
    }

    public void setBusinessStartDate(Timestamp businessStartDate) {
        this.businessStartDate = businessStartDate;
    }

    public Timestamp getBusinessStartDate() {
        return businessStartDate;
    }

    public void setMotherFirstName(String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }

    public String getMotherFirstName() {
        return motherFirstName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherMiddleName(String motherMiddleName) {
        this.motherMiddleName = motherMiddleName;
    }

    public String getMotherMiddleName() {
        return motherMiddleName;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setResidentIndicator(String residentIndicator) {
        this.residentIndicator = residentIndicator;
    }

    public String getResidentIndicator() {
        return residentIndicator;
    }

    public void setEstimatedDateofBirth(String estimatedDateofBirth) {
        this.estimatedDateofBirth = estimatedDateofBirth;
    }

    public String getEstimatedDateofBirth() {
        return estimatedDateofBirth;
    }

    public void setSolePropDetails(EntSoleProprietorInfo solePropDetails) {
        this.solePropDetails = solePropDetails;
    }

    public EntSoleProprietorInfo getSolePropDetails() {
        return solePropDetails;
    }
}
