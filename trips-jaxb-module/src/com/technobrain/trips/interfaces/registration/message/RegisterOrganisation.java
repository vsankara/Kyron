//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.12-b141219.1637 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.02 at 10:51:10 AM GMT 
//


package com.technobrain.trips.interfaces.registration.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegisterOrganisation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegisterOrganisation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrganisationRegistrationObj" type="{http://trips.technobrain.com/interfaces/registration/message}OrgReg" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisterOrganisation", propOrder = {
    "organisationRegistrationObj"
})
public class RegisterOrganisation {

    @XmlElement(name = "OrganisationRegistrationObj")
    protected OrgReg organisationRegistrationObj;

    /**
     * Gets the value of the organisationRegistrationObj property.
     * 
     * @return
     *     possible object is
     *     {@link OrgReg }
     *     
     */
    public OrgReg getOrganisationRegistrationObj() {
        return organisationRegistrationObj;
    }

    /**
     * Sets the value of the organisationRegistrationObj property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrgReg }
     *     
     */
    public void setOrganisationRegistrationObj(OrgReg value) {
        this.organisationRegistrationObj = value;
    }

}
