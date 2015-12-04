package com.technobrain.trips.registration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries (
    {
        @NamedQuery(name = "RegTaxpayerConfigView.findByEntId", 
            query = "select o from RegTaxpayerConfigView o where o.id = ?1"),
        @NamedQuery(name = "RegTaxpayerConfigView.findAll", 
            query = "select o from RegTaxpayerConfigView o")
    }
)
@Table(name = "REG_TAXPAYER_CONFIG_VW")
public class RegTaxpayerConfigView implements Serializable {
    private String address;
    @Column(name="CONTACT_DETAILS")
    private String contactDetails;
    
    @Id
    private Long id;
    
    private String nationality;
    private String tin;

    public RegTaxpayerConfigView() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }
}
