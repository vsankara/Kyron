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
 * <p>Java class for PartnerAddInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartnerAddInfoType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://trips.technobrain.com/core/message}InputType">
 *       &lt;sequence>
 *         &lt;element name="PastPersonalSavingsInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PartnersShareOfCapital" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="PartnersShareOfProfit" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartnerAddInfoType", propOrder = {
    "pastPersonalSavingsInd",
    "partnersShareOfCapital",
    "partnersShareOfProfit"
})
public class PartnerAddInfoType
    extends InputType
{

    @XmlElement(name = "PastPersonalSavingsInd")
    protected Boolean pastPersonalSavingsInd;
    @XmlElement(name = "PartnersShareOfCapital")
    protected Long partnersShareOfCapital;
    @XmlElement(name = "PartnersShareOfProfit")
    protected Long partnersShareOfProfit;

    /**
     * Gets the value of the pastPersonalSavingsInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPastPersonalSavingsInd() {
        return pastPersonalSavingsInd;
    }

    /**
     * Sets the value of the pastPersonalSavingsInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPastPersonalSavingsInd(Boolean value) {
        this.pastPersonalSavingsInd = value;
    }

    /**
     * Gets the value of the partnersShareOfCapital property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPartnersShareOfCapital() {
        return partnersShareOfCapital;
    }

    /**
     * Sets the value of the partnersShareOfCapital property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPartnersShareOfCapital(Long value) {
        this.partnersShareOfCapital = value;
    }

    /**
     * Gets the value of the partnersShareOfProfit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPartnersShareOfProfit() {
        return partnersShareOfProfit;
    }

    /**
     * Sets the value of the partnersShareOfProfit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPartnersShareOfProfit(Long value) {
        this.partnersShareOfProfit = value;
    }

}