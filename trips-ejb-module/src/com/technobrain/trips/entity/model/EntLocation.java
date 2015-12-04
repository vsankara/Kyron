package com.technobrain.trips.entity.model;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * TechnoBrain 2006
 *
 * Entity for table ENT_LOCATION
 *
 * @since	$Date: 7/13/2009 10:21:28 AM$
 * @version 	$Revision: 31$
 * @author 	$Author: Ashok Dorairaj$
 * 
 * $Log[1]:
 *  31   TRIPS2    1.30        7/13/2009 10:21:28 AM  Ashok Dorairaj 
 *       Context_Search Column Added
 * $
 */
@Entity
@NamedQuery(name = "EntLocation.findAll", 
            query = "select o from EntLocation o")
@Table(name = "ENT_LOCATION")
@SequenceGenerator(name = "ent_location_seq", 
                   sequenceName = "ent_location_seq", initialValue = 1, 
                   allocationSize = 1)
public class EntLocation extends BaseNormalModelObject   {
    @Column(name = "STREET_NAME")
    private String streetName;
    @Column(name = "BUILDING_NAME")
    private String buildingName;
    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;
    @Column(name = "ADDRESS_EFFECTIVE_DATE")
    private Timestamp addressEffectiveDate;
    @Column(name = "ADDRESS_EXPIRATION_DATE")
    private Timestamp addressExpirationDate;
    private String city;
    private String country;
    private String county;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "ent_location_seq")
    @Column(nullable = false)
    private Long id;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    private String province;
    private String state;
//    @OneToMany(mappedBy = "entLocation", cascade = { CascadeType.ALL })
//    private List<EntSite> entSiteList;
    @Column(name = "FALSE_ADDRESS")
    private String falseAddress;
    @Column(name = "LOCATION_STATUS")
    private String locationStatus;
    @Column(name = "WARNING")
    private String warning;
    @Column(name = "ADDRESS_LINES_PHONETIC")
    private String addressLinesPhonetic;
    @Column(name = "TIME_ZONE_IDENTIFIER")
    private String timeZoneIdentifier;
    @Column(name = "IDENTIFYING_ADDRESS_INDICATOR")
    private String identifyingAddressIndicator;
    @ManyToOne (cascade = {CascadeType.ALL})
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity entity;    
    @Column(name = "ADDRESS_TYPE")
    private String addressType;
    @Column(name = "FOREIGN_ADDRESS_INDICATOR")
    private String foreignAddressIndicator;
    @Column(name="CONTEXT_SEARCH")
    private String contextSearch;
    
    private String district;
    private String municipality;
    @Column(name="POSTAL_REGION")
    private String postalRegion;
    @Column(name="POSTAL_ADDRESS_POBOX")
    private String postalAddressPOBox;
    private String pmb;
    @Column(name="POST_OFFICE_LOCATION")
    private String postOfficeLocation;
    @Column(name="GPS_LONGITUDE")
    private String gPSLongitude;
    @Column(name="GPS_LATITUDE")
    private String gPSLatitude;

    public EntLocation() {
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Timestamp getAddressEffectiveDate() {
        return addressEffectiveDate;
    }

    public void setAddressEffectiveDate(Timestamp addressEffectiveDate) {
        this.addressEffectiveDate = addressEffectiveDate;
    }

    public Timestamp getAddressExpirationDate() {
        return addressExpirationDate;
    }

    public void setAddressExpirationDate(Timestamp addressExpirationDate) {
        this.addressExpirationDate = addressExpirationDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

//    public void setEntSiteList(List<EntSite> entSiteList) {
//        this.entSiteList = entSiteList;
//    }
//
//    public List<EntSite> getEntSiteList() {
//        return entSiteList;
//    }
//
//    public EntSite addEntSite(EntSite entSite) {
//        if (getEntSiteList() == null) entSiteList = new ArrayList<EntSite>();
//        getEntSiteList().add(entSite);
//        entSite.setEntLocation(this);
//        return entSite;
//    }

//    public EntSite removeEntSite(EntSite entSite) {
//        getEntSiteList().remove(entSite);
//        entSite.setEntLocation(null);
//        return entSite;
//    }

  

    public void setLocationStatus(String locationStatus) {
        this.locationStatus = locationStatus;
    }

    public String getLocationStatus() {
        return locationStatus;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getWarning() {
        return warning;
    }

    public void setAddressLinesPhonetic(String addressLinesPhonetic) {
        this.addressLinesPhonetic = addressLinesPhonetic;
    }

    public String getAddressLinesPhonetic() {
        return addressLinesPhonetic;
    }

    public void setTimeZoneIdentifier(String timeZoneIdentifier) {
        this.timeZoneIdentifier = timeZoneIdentifier;
    }

    public String getTimeZoneIdentifier() {
        return timeZoneIdentifier;
    }

    public void setFalseAddress(String falseAddress) {
        this.falseAddress = falseAddress;
    }

    public String getFalseAddress() {
        return falseAddress;
    }

    public void setEntity(EntEntity parentEntity) {
        this.entity = parentEntity;
    }

    public EntEntity getEntity() {
        return entity;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setIdentifyingAddressIndicator(String identifyingAddressIndicator) {
        this.identifyingAddressIndicator = identifyingAddressIndicator;
    }

    public String getIdentifyingAddressIndicator() {
        return identifyingAddressIndicator;
    }
    
    /**
     * Indicates if this site is the primary address
     * @return
     */
    public boolean isPrimaryAddress() {
        return ((identifyingAddressIndicator != null   && identifyingAddressIndicator.equals(Constants.TRUE)) ? true : false);
    }

    public void setForeignAddressIndicator(String foreignAddressIndicator) {
        this.foreignAddressIndicator = foreignAddressIndicator;
    }

    public String getForeignAddressIndicator() {
        return foreignAddressIndicator;
    }
    public void setContextSearch(String timeStamp) {
        this.contextSearch = timeStamp;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrict() {
        return district;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setPostalRegion(String postalRegion) {
        this.postalRegion = postalRegion;
    }

    public String getPostalRegion() {
        return postalRegion;
    }

    public void setPostalAddressPOBox(String postalAddressPOBox) {
        this.postalAddressPOBox = postalAddressPOBox;
    }

    public String getPostalAddressPOBox() {
        return postalAddressPOBox;
    }

    public void setPmb(String pmb) {
        this.pmb = pmb;
    }

    public String getPmb() {
        return pmb;
    }

    public void setPostOfficeLocation(String postOfficeLocation) {
        this.postOfficeLocation = postOfficeLocation;
    }

    public String getPostOfficeLocation() {
        return postOfficeLocation;
    }

    public void setGPSLongitude(String gPSLongitude) {
        this.gPSLongitude = gPSLongitude;
    }

    public String getGPSLongitude() {
        return gPSLongitude;
    }

    public void setGPSLatitude(String gPSLatitude) {
        this.gPSLatitude = gPSLatitude;
    }

    public String getGPSLatitude() {
        return gPSLatitude;
    }
}
