package com.technobrain.trips.taxreturn.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@NamedQueries( { 

    @NamedQuery(name = "TaxpayerLandlordDetails.findAll", 
                             query = "select o from TaxpayerLandlordDetails o"), 
                             
    @NamedQuery(name = "TaxpayerLandlordDetails.findLandlordAddressByLandlordTin", 
                    query = "SELECT o FROM TaxpayerLandlordDetails o WHERE o.landlordEntityId = ?1"),         
                             
    @NamedQuery(name = "TaxpayerLandlordDetails.findTaxpayerLandlordDetailsByTin", 
                    query = 
                    "SELECT o FROM TaxpayerLandlordDetails o WHERE o.rentorTin = ?1 and o.ownershipType='Rented' order by o.updatedDate desc")
        } )
@Table(name = "TAXPAYER_LANDLORD_DETAILS")
public class TaxpayerLandlordDetails implements Serializable {
    @Column(name = "LANDLORD_ADDRESS")
    private String landlordAddress;
    @Column(name = "LANDLORD_ENTITY_ID")
    private Long landlordEntityId;
    @Column(name = "LANDLORD_NAME")
    private String landlordName;
    @Column(name = "LANDLORD_TELEPHONE")
    private String landlordTelephone;
    @Column(name = "LANDLORD_TIN", nullable = false)
    private String landlordTin;
    @Column(name = "OWNERSHIP_TYPE")
    private String ownershipType;
    @Column(name = "RENTOR_ENTITY_ID", nullable = false)
    private Long rentorEntityId;
    @Column(name = "RENTOR_TIN", nullable = false)
    private String rentorTin;
    @Column(name = "UPDATED_DATE")
    private Timestamp updatedDate;
    

        @Id
        @Column(name="ID")
        private Long id; 

    public TaxpayerLandlordDetails() {
    }

    public String getLandlordAddress() {
        return landlordAddress;
    }

    public void setLandlordAddress(String landlordAddress) {
        this.landlordAddress = landlordAddress;
    }

    public Long getLandlordEntityId() {
        return landlordEntityId;
    }

    public void setLandlordEntityId(Long landlordEntityId) {
        this.landlordEntityId = landlordEntityId;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getLandlordTelephone() {
        return landlordTelephone;
    }

    public void setLandlordTelephone(String landlordTelephone) {
        this.landlordTelephone = landlordTelephone;
    }

    public String getLandlordTin() {
        return landlordTin;
    }

    public void setLandlordTin(String landlordTin) {
        this.landlordTin = landlordTin;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }

    public Long getRentorEntityId() {
        return rentorEntityId;
    }

    public void setRentorEntityId(Long rentorEntityId) {
        this.rentorEntityId = rentorEntityId;
    }

    public String getRentorTin() {
        return rentorTin;
    }

    public void setRentorTin(String rentorTin) {
        this.rentorTin = rentorTin;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
