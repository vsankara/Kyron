


package com.technobrain.trips.egif;

import java.io.Serializable;


public class RegisterTaxpayerService implements Serializable{

    protected String tin;
    protected String fullname;
    protected String address;
    protected String landtel;
    protected String mobile;
    protected String fax;
    protected String previousTin;

    /**
     * Gets the value of the tin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTin() {
        return tin;
    }

    /**
     * Sets the value of the tin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTin(String value) {
        this.tin = value;
    }

    /**
     * Gets the value of the fullname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Sets the value of the fullname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullname(String value) {
        this.fullname = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the landtel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandtel() {
        return landtel;
    }

    /**
     * Sets the value of the landtel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandtel(String value) {
        this.landtel = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobile(String value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the previousTin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviousTin() {
        return previousTin;
    }

    /**
     * Sets the value of the previousTin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviousTin(String value) {
        this.previousTin = value;
    }

}
