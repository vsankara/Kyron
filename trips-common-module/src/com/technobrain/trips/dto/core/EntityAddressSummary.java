package com.technobrain.trips.dto.core;

import com.technobrain.trips.core.message.AddressType;
import com.technobrain.trips.dto.DataTransferObject;

public class EntityAddressSummary implements DataTransferObject {

    String streetName;
    String buildingName;
    String houseNumber;
    //String addressLine4;
    String city;
    String country; // represent country code
    String countryName; // represent country name
    String county;
    String postalCode;
    String addressIndicator;
    String entityName;
    String entityTin;

    public EntityAddressSummary(String streetName,String country, String county, String postalCode,String city) {
        this.streetName = null == streetName ? "" : streetName;
        this.country = null == country ? "" : country;
        this.county = null == county ? "" : county;
        this.postalCode = null == postalCode ? "" : postalCode;
        this.buildingName = "";
        this.houseNumber = "";
        //this.addressLine4 = "";
        this.city = null == city ? "" : city;
    }
    
    public EntityAddressSummary(AddressType addressType) {
        this.streetName = null == addressType.getStreetName() ? "" : addressType.getStreetName();
        this.country = null == addressType.getCountry() ? "" : addressType.getCountry();
        this.county = null == addressType.getCounty() ? "" : addressType.getCounty();
        this.postalCode = null == addressType.getPostalCode() ? "" : addressType.getPostalCode();
        this.buildingName = null == addressType.getStreetName() ? "" : addressType.getBuildingName();
        this.houseNumber = null == addressType.getHouseNumber() ? "" : addressType.getHouseNumber();
        this.city = null == addressType.getCity() ? "" : addressType.getCity();
    }

    public EntityAddressSummary(
        String streetName, String buildingName, String houseNumber, String address4, String country, String county, String postalCode,String city) {
        this.streetName = null == streetName ? "" : streetName;
        this.country = null == country ? "" : country;
        this.county = null == county ? "" : county;
        this.postalCode = null == postalCode ? "" : postalCode;
        this.buildingName = null == buildingName ? "" : buildingName;
        this.houseNumber = null == houseNumber ? "" : houseNumber;
        this.city = null == city ? "" : city;
    }
    
    public EntityAddressSummary() {
        
    }

 


    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

//    public void setAddressLine4(String addressLine4) {
//        this.addressLine4 = addressLine4;
//    }
//
//    public String getAddressLine4() {
//        return addressLine4;
//    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCounty() {
        return county;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setAddressIndicator(String addressIndicator) {
        this.addressIndicator = addressIndicator;
    }

    public String getAddressIndicator() {
        return addressIndicator;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getAddress() {
        String address = "";
        if(streetName != null && !streetName.equals("")) {
            address += " "+streetName;
        }
        if(buildingName != null && !buildingName.equals("")) {
            address += " "+buildingName;
        }
        if(houseNumber != null && !houseNumber.equals("")) {
            address += " "+houseNumber;
        }
//        if(addressLine4 != null && !addressLine4.equals("")) {
//            address += " "+addressLine4;
//        }
        return address;
    }

    public String getFullAddress() {
        String address = "";
        if(streetName != null && !streetName.equals("")) {
            address += " "+streetName+ "\n";
        }
        if(buildingName != null && !buildingName.equals("")) {
            address += " "+buildingName+"\n";
        }
        if(houseNumber != null && !houseNumber.equals("")) {
            address += " "+houseNumber+"\n";
        }
//        if(addressLine4 != null && !addressLine4.equals("")) {
//            address += " "+addressLine4+"\n";
//        }
        if(county != null && !county.equals("")) {
            address += " "+county+"\n";
        }
        if(city != null && !city.equals("")) {
            address += " "+city+"\n";
        }
        if(country != null && !country.equals("")) {
            address += " "+countryName;
        }
        return address;
    }
    
    public void setAddress(String address) {
        //Nothing to do. address is used for binding to a inputtext in page. If address has not a setter method, then
        // the inputtext becomes readOnly. But we want it to be disabled, not readOnly. Because of this, I have created
        // this dummy setter method.
    }

    public void setEntityTin(String entityTin) {
        this.entityTin = entityTin;
    }

    public String getEntityTin() {
        return entityTin;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
