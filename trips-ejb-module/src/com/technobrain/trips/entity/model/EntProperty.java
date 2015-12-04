package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * TechnoBrain 2015
 *
 * Entity for table ENT_PROPERTY
 *
 * @since	$Date: 2/2/2009 5:27:03 AM$
 * @version 	$Revision: 11$
 * @author 	$Author: Howard Hill$
 * 
 * $Log[1]:
 *  11   TRIPS2    1.10        2/2/2009 5:27:03 AM    Howard Hill     change
 *       log[10] to log[1]
 * $
 */
@Entity
@NamedQuery(name = "EntProperty.findAll", 
            query = "select o from EntProperty o")
@Table(name = "ENT_PROPERTY")
@SequenceGenerator(name = "ent_property_seq", 
                   sequenceName = "ent_property_seq", initialValue = 1, 
                   allocationSize = 1)
public class EntProperty extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "ent_property_seq")
    @Column(nullable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity entEntity;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "ENT_LOCATION", referencedColumnName = "ID")
    private EntLocation entLocation;

    @Column(name = "PROPERTY_TYPE")
    private String propertyType;

    @Column(name = "OWNERSHIP_TYPE")
    private String ownershipType;

    @Column(name = "DIRECTION_TO_PREMISES")
    private String directionToPremises;

    @Column(name = "LANDLORD_ENTITY_ID")
    private Long landlordEntityId;

    @Column(name = "LANDLORD_NAME")
    private String landlordName;

    @Column(name = "LANDLORD_ADDRESS")
    private String landlordAddress;
    
    @Column(name = "PROPERTY_TYPE_INDICATOR")
    private String propertyTypeIndicator;

    public EntProperty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }

    public EntEntity getEntEntity() {
        return entEntity;
    }

    public void setEntLocation(EntLocation entLocation) {
        this.entLocation = entLocation;
    }

    public EntLocation getEntLocation() {
        return entLocation;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setDirectionToPremises(String directionToPremises) {
        this.directionToPremises = directionToPremises;
    }

    public String getDirectionToPremises() {
        return directionToPremises;
    }

    public void setLandlordEntityId(Long landlordEntityId) {
        this.landlordEntityId = landlordEntityId;
    }

    public Long getLandlordEntityId() {
        return landlordEntityId;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordAddress(String landlordAddress) {
        this.landlordAddress = landlordAddress;
    }

    public String getLandlordAddress() {
        return landlordAddress;
    }

    public void setPropertyTypeIndicator(String propertyTypeIndicator) {
        this.propertyTypeIndicator = propertyTypeIndicator;
    }

    public String getPropertyTypeIndicator() {
        return propertyTypeIndicator;
    }
}
