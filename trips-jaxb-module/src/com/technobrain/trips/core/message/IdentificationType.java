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
 * <p>Java class for IdentificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdentificationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://trips.technobrain.com/core/message}InputType">
 *       &lt;sequence>
 *         &lt;element name="CountryOfIssue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateOfIssue" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ExpiryDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DateOfSignature" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="IdentificationIssuer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdentificationNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IdentificationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PlaceOfIssue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeclarationByThumbPrint" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="FalseIdentification" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IdentificationStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VerificationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AutoApproval" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdVerificationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentificationType", propOrder = {
    "countryOfIssue",
    "dateOfIssue",
    "expiryDate",
    "dateOfSignature",
    "identificationIssuer",
    "identificationNumber",
    "identificationType",
    "placeOfIssue",
    "declarationByThumbPrint",
    "effectiveDate",
    "falseIdentification",
    "identificationStatus",
    "verificationType",
    "autoApproval",
    "idVerificationCode"
})
public class IdentificationType
    extends InputType
{

    @XmlElement(name = "CountryOfIssue")
    protected String countryOfIssue;
    @XmlElement(name = "DateOfIssue")
    @XmlSchemaType(name = "date")
    protected Calendar dateOfIssue;
    @XmlElement(name = "ExpiryDate")
    @XmlSchemaType(name = "date")
    protected Calendar expiryDate;
    @XmlElement(name = "DateOfSignature")
    @XmlSchemaType(name = "date")
    protected Calendar dateOfSignature;
    @XmlElement(name = "IdentificationIssuer")
    protected String identificationIssuer;
    @XmlElement(name = "IdentificationNumber", required = true)
    protected String identificationNumber;
    @XmlElement(name = "IdentificationType", required = true)
    protected String identificationType;
    @XmlElement(name = "PlaceOfIssue")
    protected String placeOfIssue;
    @XmlElement(name = "DeclarationByThumbPrint")
    protected Boolean declarationByThumbPrint;
    @XmlElement(name = "EffectiveDate")
    @XmlSchemaType(name = "date")
    protected Calendar effectiveDate;
    @XmlElement(name = "FalseIdentification")
    protected Boolean falseIdentification;
    @XmlElement(name = "IdentificationStatus")
    protected String identificationStatus;
    @XmlElement(name = "VerificationType")
    protected String verificationType;
    @XmlElement(name = "AutoApproval")
    protected String autoApproval;
    @XmlElement(name = "IdVerificationCode")
    protected String idVerificationCode;

    /**
     * Gets the value of the countryOfIssue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfIssue() {
        return countryOfIssue;
    }

    /**
     * Sets the value of the countryOfIssue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfIssue(String value) {
        this.countryOfIssue = value;
    }

    /**
     * Gets the value of the dateOfIssue property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getDateOfIssue() {
        return dateOfIssue;
    }

    /**
     * Sets the value of the dateOfIssue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setDateOfIssue(Calendar value) {
        this.dateOfIssue = value;
    }

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setExpiryDate(Calendar value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the dateOfSignature property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getDateOfSignature() {
        return dateOfSignature;
    }

    /**
     * Sets the value of the dateOfSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setDateOfSignature(Calendar value) {
        this.dateOfSignature = value;
    }

    /**
     * Gets the value of the identificationIssuer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationIssuer() {
        return identificationIssuer;
    }

    /**
     * Sets the value of the identificationIssuer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationIssuer(String value) {
        this.identificationIssuer = value;
    }

    /**
     * Gets the value of the identificationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Sets the value of the identificationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationNumber(String value) {
        this.identificationNumber = value;
    }

    /**
     * Gets the value of the identificationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationType() {
        return identificationType;
    }

    /**
     * Sets the value of the identificationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationType(String value) {
        this.identificationType = value;
    }

    /**
     * Gets the value of the placeOfIssue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    /**
     * Sets the value of the placeOfIssue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceOfIssue(String value) {
        this.placeOfIssue = value;
    }

    /**
     * Gets the value of the declarationByThumbPrint property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeclarationByThumbPrint() {
        return declarationByThumbPrint;
    }

    /**
     * Sets the value of the declarationByThumbPrint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeclarationByThumbPrint(Boolean value) {
        this.declarationByThumbPrint = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setEffectiveDate(Calendar value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the falseIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFalseIdentification() {
        return falseIdentification;
    }

    /**
     * Sets the value of the falseIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFalseIdentification(Boolean value) {
        this.falseIdentification = value;
    }

    /**
     * Gets the value of the identificationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationStatus() {
        return identificationStatus;
    }

    /**
     * Sets the value of the identificationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationStatus(String value) {
        this.identificationStatus = value;
    }

    /**
     * Gets the value of the verificationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerificationType() {
        return verificationType;
    }

    /**
     * Sets the value of the verificationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerificationType(String value) {
        this.verificationType = value;
    }

    /**
     * Gets the value of the autoApproval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoApproval() {
        return autoApproval;
    }

    /**
     * Sets the value of the autoApproval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoApproval(String value) {
        this.autoApproval = value;
    }

    /**
     * Gets the value of the idVerificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdVerificationCode() {
        return idVerificationCode;
    }

    /**
     * Sets the value of the idVerificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdVerificationCode(String value) {
        this.idVerificationCode = value;
    }

}
