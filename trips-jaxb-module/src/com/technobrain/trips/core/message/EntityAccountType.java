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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.util.Calendar;


/**
 * <p>Java class for EntityAccountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EntityAccountType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://trips.technobrain.com/core/message}InputType">
 *       &lt;sequence>
 *         &lt;element name="RGDNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeRegistrationReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EDC" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EDD" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EDR" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EDS" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EDRenewal" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ForcedRegistrationIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Office" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreviousAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EntityAcctStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BranchCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperatingAs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ParentEntityAccount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ManualAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HeadOfficeAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IRSFileNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntityAccountType", propOrder = {
    "rgdNo",
    "accountNumber",
    "deRegistrationReason",
    "edc",
    "edd",
    "edr",
    "eds",
    "edRenewal",
    "forcedRegistrationIndicator",
    "office",
    "previousAccountNumber",
    "entityAcctStatus",
    "branchCode",
    "operatingAs",
    "parentEntityAccount",
    "manualAccountNumber",
    "headOfficeAccountNumber",
    "irsFileNumber"
})
public class EntityAccountType
    extends InputType
{

    @XmlElement(name = "RGDNo")
    protected String rgdNo;
    @XmlElement(name = "AccountNumber")
    protected String accountNumber;
    @XmlElement(name = "DeRegistrationReason")
    protected String deRegistrationReason;
    @XmlElement(name = "EDC")
    @XmlSchemaType(name = "date")
    protected Calendar edc;
    @XmlElement(name = "EDD")
    @XmlSchemaType(name = "date")
    protected Calendar edd;
    @XmlElement(name = "EDR")
    @XmlSchemaType(name = "date")
    protected Calendar edr;
    @XmlElement(name = "EDS")
    @XmlSchemaType(name = "date")
    protected Calendar eds;
    @XmlElement(name = "EDRenewal")
    @XmlSchemaType(name = "date")
    protected Calendar edRenewal;
    @XmlElement(name = "ForcedRegistrationIndicator")
    protected Boolean forcedRegistrationIndicator;
    @XmlElement(name = "Office")
    protected String office;
    @XmlElement(name = "PreviousAccountNumber")
    protected String previousAccountNumber;
    @XmlElement(name = "EntityAcctStatus")
    protected String entityAcctStatus;
    @XmlElement(name = "BranchCode")
    protected String branchCode;
    @XmlElement(name = "OperatingAs")
    protected String operatingAs;
    @XmlElement(name = "ParentEntityAccount")
    protected Long parentEntityAccount;
    @XmlElement(name = "ManualAccountNumber")
    protected String manualAccountNumber;
    @XmlElement(name = "HeadOfficeAccountNumber")
    protected String headOfficeAccountNumber;
    @XmlElement(name = "IRSFileNumber")
    protected String irsFileNumber;

    /**
     * Gets the value of the rgdNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRGDNo() {
        return rgdNo;
    }

    /**
     * Sets the value of the rgdNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRGDNo(String value) {
        this.rgdNo = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the deRegistrationReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeRegistrationReason() {
        return deRegistrationReason;
    }

    /**
     * Sets the value of the deRegistrationReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeRegistrationReason(String value) {
        this.deRegistrationReason = value;
    }

    /**
     * Gets the value of the edc property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getEDC() {
        return edc;
    }

    /**
     * Sets the value of the edc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setEDC(Calendar value) {
        this.edc = value;
    }

    /**
     * Gets the value of the edd property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getEDD() {
        return edd;
    }

    /**
     * Sets the value of the edd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setEDD(Calendar value) {
        this.edd = value;
    }

    /**
     * Gets the value of the edr property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getEDR() {
        return edr;
    }

    /**
     * Sets the value of the edr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setEDR(Calendar value) {
        this.edr = value;
    }

    /**
     * Gets the value of the eds property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getEDS() {
        return eds;
    }

    /**
     * Sets the value of the eds property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setEDS(Calendar value) {
        this.eds = value;
    }

    /**
     * Gets the value of the edRenewal property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getEDRenewal() {
        return edRenewal;
    }

    /**
     * Sets the value of the edRenewal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setEDRenewal(Calendar value) {
        this.edRenewal = value;
    }

    /**
     * Gets the value of the forcedRegistrationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isForcedRegistrationIndicator() {
        return forcedRegistrationIndicator;
    }

    /**
     * Sets the value of the forcedRegistrationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setForcedRegistrationIndicator(Boolean value) {
        this.forcedRegistrationIndicator = value;
    }

    /**
     * Gets the value of the office property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffice() {
        return office;
    }

    /**
     * Sets the value of the office property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffice(String value) {
        this.office = value;
    }

    /**
     * Gets the value of the previousAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviousAccountNumber() {
        return previousAccountNumber;
    }

    /**
     * Sets the value of the previousAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviousAccountNumber(String value) {
        this.previousAccountNumber = value;
    }

    /**
     * Gets the value of the entityAcctStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityAcctStatus() {
        return entityAcctStatus;
    }

    /**
     * Sets the value of the entityAcctStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityAcctStatus(String value) {
        this.entityAcctStatus = value;
    }

    /**
     * Gets the value of the branchCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * Sets the value of the branchCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchCode(String value) {
        this.branchCode = value;
    }

    /**
     * Gets the value of the operatingAs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatingAs() {
        return operatingAs;
    }

    /**
     * Sets the value of the operatingAs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatingAs(String value) {
        this.operatingAs = value;
    }

    /**
     * Gets the value of the parentEntityAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentEntityAccount() {
        return parentEntityAccount;
    }

    /**
     * Sets the value of the parentEntityAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentEntityAccount(Long value) {
        this.parentEntityAccount = value;
    }

    /**
     * Gets the value of the manualAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManualAccountNumber() {
        return manualAccountNumber;
    }

    /**
     * Sets the value of the manualAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManualAccountNumber(String value) {
        this.manualAccountNumber = value;
    }

    /**
     * Gets the value of the headOfficeAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeadOfficeAccountNumber() {
        return headOfficeAccountNumber;
    }

    /**
     * Sets the value of the headOfficeAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeadOfficeAccountNumber(String value) {
        this.headOfficeAccountNumber = value;
    }

    /**
     * Gets the value of the irsFileNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIRSFileNumber() {
        return irsFileNumber;
    }

    /**
     * Sets the value of the irsFileNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIRSFileNumber(String value) {
        this.irsFileNumber = value;
    }

}
