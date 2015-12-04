package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * TechnoBrain 2006
 *
 * Entity for table ENT_IDENTIFICATION
 *
 * @since	$Date: 7/13/2009 10:21:27 AM$
 * @version 	$Revision: 18$
 * @author 	$Author: Ashok Dorairaj$
 * 
 * $Log[1]:
 *  18   TRIPS2    1.17        7/13/2009 10:21:27 AM  Ashok Dorairaj 
 *       Context_Search Column Added
 * $
 */
@Entity
@NamedQuery(name = "EntIdentification.findAll", 
    query = "select o from EntIdentification o")
@Table(name = "ENT_IDENTIFICATION")
@SequenceGenerator(name = "ent_identification_seq", sequenceName = "ent_identification_seq", initialValue = 1, allocationSize = 1)
public class EntIdentification extends BaseNormalModelObject   {
     
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_identification_seq")
    @Column(nullable = false)
    private Long id;
    @Column(name="IDENTIFICATION_NUMBER")
    private String identificationNumber;
    @Column(name="IDENTIFICATION_TYPE")
    private String identificationType;
    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity parentEntity;
    @Column(name="FALSE_IDENTIFICATION")
    private String falseIdentification;
    @Column(name="IDENTIFICATION_STATUS")
    private String identificationStatus;
    @Column(name="IDENTIFICATION_ISSUER")
    private String identificationIssuer;
    @Column(name="COUNTRY_OF_ISSUE")
    private String countryOfIssue;
    @Column(name="PLACE_OF_ISSUE")
    private String placeOfIssue;
    @Column(name="CONTEXT_SEARCH")
    private String contextSearch;
    @Column(name="DEC_BY_THUMBPRINT")
    private char decByThumbprint;
    @Column(name="DATE_OF_SIGNATURE")
    private Timestamp dateOfSignature;
    @Column(name="ID_VERIFICATION_CODE")
    private String idVerificationCode;
    
    public EntIdentification() {
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public EntEntity getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(EntEntity entEntity1) {
        this.parentEntity = entEntity1;
    }

    public void setIdentificationStatus(String identificationStatus) {
        this.identificationStatus = identificationStatus;
    }

    public String getIdentificationStatus() {
        return identificationStatus;
    }

    public void setIdentificationIssuer(String identificationIssuer) {
        this.identificationIssuer = identificationIssuer;
    }

    public String getIdentificationIssuer() {
        return identificationIssuer;
    }

    public void setCountryOfIssue(String countryOfIssue) {
        this.countryOfIssue = countryOfIssue;
    }

    public String getCountryOfIssue() {
        return countryOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setFalseIdentification(String falseIdentification) {
        this.falseIdentification = falseIdentification;
    }

    public String getFalseIdentification() {
        return falseIdentification;
    }

    public void setContextSearch(String timeStamp) {
        this.contextSearch = timeStamp;
    }

    public void setDecByThumbprint(char decByThumbprint) {
        this.decByThumbprint = decByThumbprint;
    }

    public char getDecByThumbprint() {
        return decByThumbprint;
    }

    public void setDateOfSignature(Timestamp dateOfSignature) {
        this.dateOfSignature = dateOfSignature;
    }

    public Timestamp getDateOfSignature() {
        return dateOfSignature;
    }

    public void setIdVerificationCode(String idVerificationCode) {
        this.idVerificationCode = idVerificationCode;
    }

    public String getIdVerificationCode() {
        return idVerificationCode;
    }
}
