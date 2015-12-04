//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.16 at 02:38:30 PM GMT 
//


package com.technobrain.trips.core.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyInputType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://trips.technobrain.com/core/message}InputType">
 *       &lt;sequence>
 *         &lt;element name="PropertyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ownership" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TradersPremises" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LandlordTIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LandlordEntityId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LandlordName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LandlordAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PropertyTypeIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AddressType" type="{http://trips.technobrain.com/core/message}AddressType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyInputType", propOrder = {
    "propertyType",
    "ownership",
    "address",
    "tradersPremises",
    "landlordTIN",
    "landlordEntityId",
    "landlordName",
    "landlordAddress",
    "propertyTypeIndicator",
    "addressType"
})
public class PropertyInputType
    extends InputType
{

    @XmlElement(name = "PropertyType")
    protected String propertyType;
    @XmlElement(name = "Ownership")
    protected String ownership;
    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "TradersPremises")
    protected String tradersPremises;
    @XmlElement(name = "LandlordTIN")
    protected String landlordTIN;
    @XmlElement(name = "LandlordEntityId")
    protected Long landlordEntityId;
    @XmlElement(name = "LandlordName")
    protected String landlordName;
    @XmlElement(name = "LandlordAddress")
    protected String landlordAddress;
    @XmlElement(name = "PropertyTypeIndicator")
    protected Boolean propertyTypeIndicator;
    @XmlElement(name = "AddressType")
    protected AddressType addressType;

    /**
     * Gets the value of the propertyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     * Sets the value of the propertyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyType(String value) {
        this.propertyType = value;
    }

    /**
     * Gets the value of the ownership property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnership() {
        return ownership;
    }

    /**
     * Sets the value of the ownership property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnership(String value) {
        this.ownership = value;
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
     * Gets the value of the tradersPremises property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradersPremises() {
        return tradersPremises;
    }

    /**
     * Sets the value of the tradersPremises property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradersPremises(String value) {
        this.tradersPremises = value;
    }

    /**
     * Gets the value of the landlordTIN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandlordTIN() {
        return landlordTIN;
    }

    /**
     * Sets the value of the landlordTIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandlordTIN(String value) {
        this.landlordTIN = value;
    }

    /**
     * Gets the value of the landlordEntityId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLandlordEntityId() {
        return landlordEntityId;
    }

    /**
     * Sets the value of the landlordEntityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLandlordEntityId(Long value) {
        this.landlordEntityId = value;
    }

    /**
     * Gets the value of the landlordName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandlordName() {
        return landlordName;
    }

    /**
     * Sets the value of the landlordName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandlordName(String value) {
        this.landlordName = value;
    }

    /**
     * Gets the value of the landlordAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandlordAddress() {
        return landlordAddress;
    }

    /**
     * Sets the value of the landlordAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandlordAddress(String value) {
        this.landlordAddress = value;
    }

    /**
     * Gets the value of the propertyTypeIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPropertyTypeIndicator() {
        return propertyTypeIndicator;
    }

    /**
     * Sets the value of the propertyTypeIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPropertyTypeIndicator(Boolean value) {
        this.propertyTypeIndicator = value;
    }

    /**
     * Gets the value of the addressType property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAddressType() {
        return addressType;
    }

    /**
     * Sets the value of the addressType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddressType(AddressType value) {
        this.addressType = value;
    }

}
