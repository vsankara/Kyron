package com.technobrain.trips.dto.portal;

public class LandLordDetails {
    
    private String ID;
    private String postalAddress;
    private String entityName;
    
    public LandLordDetails() {
    }

    public void setID(String iD) {
        this.ID = iD;
    }

    public String getID() {
        return ID;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityName() {
        return entityName;
    }
}
