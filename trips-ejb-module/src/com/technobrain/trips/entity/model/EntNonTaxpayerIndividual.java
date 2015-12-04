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
 * TechnoBrain 2012
 *
 * Entity for table ENT_NON_TAXPAYER_INDIVIDUAL
 *
 * @since	$Date: 01/05/2012 16:45:47 PM$
 * @version 	$Revision: 28$
 * @author 	$Author: Ashok Dorairaj$
 * 
 */
@Entity
@NamedQueries  ( 
    {
@NamedQuery(name = "EntNonTaxpayerIndividual.findAll", 
    query = "select o from EntNonTaxpayerIndividual o"),
@NamedQuery(name = "EntNonTaxpayerIndividual.findIndividualById", 
    query = "select ind from EntNonTaxpayerIndividual ind where ind.id = ?1")
    }
)
@Table(name = "ENT_NON_TP_INDIVIDUAL")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("NON_TAXPAYER_INDIVIDUAL")
public class EntNonTaxpayerIndividual extends EntEntity    {
    @Column(name="DATE_OF_BIRTH")
    private Timestamp dateOfBirth;

    @Column(name="FIRST_NAME")
    private String firstName;
    private String gender;

    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="MIDDLE_NAME")
    private String middleName;

    private String notes;
    private String address;

    @Column(name="COUNTRY_OF_BIRTH")
    private String countryOfBirth;

    @Column(name="MOBILE_NUMBER")
    private String mobileNumber;
    
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
    
    public EntNonTaxpayerIndividual() {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
