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
 * <p>Java class for ReturnsInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReturnsInputType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://trips.technobrain.com/core/message}InputType">
 *       &lt;sequence>
 *         &lt;element name="ReturnsId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ReturnTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RevType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReturnTypeStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegTaxTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnsInputType", propOrder = {
    "returnsId",
    "returnTypeCode",
    "revType",
    "returnTypeStatus",
    "regTaxTypeId"
})
public class ReturnsInputType
    extends InputType
{

    @XmlElement(name = "ReturnsId")
    protected Long returnsId;
    @XmlElement(name = "ReturnTypeCode")
    protected String returnTypeCode;
    @XmlElement(name = "RevType")
    protected String revType;
    @XmlElement(name = "ReturnTypeStatus")
    protected String returnTypeStatus;
    @XmlElement(name = "RegTaxTypeId")
    protected Long regTaxTypeId;

    /**
     * Gets the value of the returnsId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReturnsId() {
        return returnsId;
    }

    /**
     * Sets the value of the returnsId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReturnsId(Long value) {
        this.returnsId = value;
    }

    /**
     * Gets the value of the returnTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnTypeCode() {
        return returnTypeCode;
    }

    /**
     * Sets the value of the returnTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnTypeCode(String value) {
        this.returnTypeCode = value;
    }

    /**
     * Gets the value of the revType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevType() {
        return revType;
    }

    /**
     * Sets the value of the revType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevType(String value) {
        this.revType = value;
    }

    /**
     * Gets the value of the returnTypeStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnTypeStatus() {
        return returnTypeStatus;
    }

    /**
     * Sets the value of the returnTypeStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnTypeStatus(String value) {
        this.returnTypeStatus = value;
    }

    /**
     * Gets the value of the regTaxTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRegTaxTypeId() {
        return regTaxTypeId;
    }

    /**
     * Sets the value of the regTaxTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRegTaxTypeId(Long value) {
        this.regTaxTypeId = value;
    }

}