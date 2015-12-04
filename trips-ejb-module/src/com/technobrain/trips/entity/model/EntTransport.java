package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.annotation.ReferenceNumber;

import java.sql.Timestamp;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * TechnoBrain 2015
 *
 * Entity for table ENT_TRANSPORT
 *
 * @since	$Date: 3/24/2009 10:09:36 AM$
 * @version 	$Revision: 26$
 * @author 	$Author: Ashok Dorairaj$
 *
 * $Log[1]:
 *  26   TRIPS2    1.25        3/24/2009 10:09:36 AM  Ashok Dorairaj  Adding a
 *       reference number field to Transport table
 * $
 */
@Entity
@NamedQuery(name = "EntTransport.findAll", query = "select o from EntTransport o")
@Table(name = "ENT_TRANSPORT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="DTYPE")
@DiscriminatorValue("TRANSPORT")
@NamedQueries(
    @NamedQuery(
        name="findTransportById",
        query="select et from EntTransport et where et.id = ?1"
    )
)
public class EntTransport extends EntEntity {

    private String markings;

    @Column(name="COLOUR")
    private String colour;

    @Column(name="OTHER_DISTINGUISHING_FEATURES")
    private String otherDistinguishingFeatures;
    @Column(name="OWNER_NAME")
    private String ownerName;
    @Column(name="PRODUCTION_DATE")
    private Timestamp productionDate;
    @Column(name="REGISTERED_ADDRESS")
    private String registeredAddress;
    @Column(name="REGISTRATION_COUNTRY")
    private String registrationCountry;
    @Column(name="REGISTRATION_DATE")
    private Timestamp registrationDate;

    @Column(name="REGISTRATION_NUMBER")
    private String registrationNumber;
    @Column(name="TRANSPORT_TYPE")
    private String transportType;
    @Column(name="TRANSPORT_NAME")
    private String transportName;
    
    @ReferenceNumber(format="TRN/SQL", sql="SELECT LTRIM(TO_CHAR(MOD(TRANSPORT_REF_NO_SEQ.nextval,100000),'000099'))||'/'||to_char(sysdate,'YYYY') as generatedId FROM dual")
    @Column(name="REFERENCE_NUMBER")
    private String referenceNumber;
    
    @OneToMany(cascade={CascadeType.ALL}, mappedBy="entTransport")
    private Collection<EntContainer> entContainerCollection;
    
    public EntTransport() {
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getMarkings() {
        return markings;
    }

    public void setMarkings(String markings) {
        this.markings = markings;
    }

    public String getOtherDistinguishingFeatures() {
        return otherDistinguishingFeatures;
    }

    public void setOtherDistinguishingFeatures(String otherDistinguishingFeatures) {
        this.otherDistinguishingFeatures = otherDistinguishingFeatures;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Timestamp getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Timestamp productionDate) {
        this.productionDate = productionDate;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getRegistrationCountry() {
        return registrationCountry;
    }

    public void setRegistrationCountry(String registrationCountry) {
        this.registrationCountry = registrationCountry;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setEntContainerCollection(Collection<EntContainer> entContainerCollection) {
        this.entContainerCollection = entContainerCollection;
    }

    public Collection<EntContainer> getEntContainerCollection() {
        return entContainerCollection;
    }

    public EntContainer addEntContainer(EntContainer entContainer) {
        getEntContainerCollection().add(entContainer);
        entContainer.setEntTransport(this);
        return entContainer;
    }

    public EntContainer removeEntContainer(EntContainer entContainer) {
        getEntContainerCollection().remove(entContainer);
        entContainer.setEntTransport(null);
        return entContainer;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }
}
