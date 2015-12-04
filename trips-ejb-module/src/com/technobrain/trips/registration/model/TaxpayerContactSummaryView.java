package com.technobrain.trips.registration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@NamedQueries( {
@NamedQuery(name = "TaxpayerContactSummaryView.findAll", 
    query = "select o from TaxpayerContactSummaryView o"),
@NamedQuery(name = "TaxpayerContactSummaryView.findTaxpayerContactDetailsByTin", 
    query = "select o from TaxpayerContactSummaryView o where o.tin=?1")})
@Table(name = "TAXPAYER_CONTACT_SUMMARY")
public class TaxpayerContactSummaryView implements Serializable {
    @Column(nullable = false)
    private String dtype;
    private String email;
    @Column(name="ENTITY_NAME")
    private String entityName;
    @Column(name="ENTITY_TYPE", nullable = false)
    private String entityType;
    @Id
    private Long id;
    private String phone;
    @Column(name="POSTAL_ADDRESS")
    private String postalAddress;
    @Column(name="RESIDENTIAL_ADDRESS")
    private String residentialAddress;
    @Column(nullable = false)
    private String tin;

    public TaxpayerContactSummaryView() {
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }
}
