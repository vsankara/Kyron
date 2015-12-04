//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.16 at 02:38:30 PM GMT 
//


package com.technobrain.trips.core.message;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.util.Calendar;
import com.technobrain.trips.application.message.ApplicationAuthorisationInputType;
import java.io.Serializable;


/**
 * <p>Java class for InputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InputType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://trips.technobrain.com/core/message}BaseType">
 *       &lt;sequence>
 *         &lt;element name="AdditionalFields" type="{http://trips.technobrain.com/core/message}AdditionalField" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CreatedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OwnerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OwnerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UpdatedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UpdatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="AssociatedData" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LazyFetch" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AccessLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Overrided" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OverridedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PageAction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PageMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PageConfig" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputType", propOrder = {
    "additionalFields",
    "createdBy",
    "createdDate",
    "id",
    "ownerId",
    "ownerType",
    "status",
    "updatedBy",
    "updatedDate",
    "associatedData",
    "lazyFetch",
    "accessLevel",
    "overrided",
    "overridedBy",
    "pageAction",
    "pageMode",
    "pageConfig"
})
@XmlSeeAlso({
    SystemMessage.class,
    RelationshipType.class,
    BankDetailsInputType.class,
    EntityClassificationType.class,
    EntitySiteType.class,
    DDocDocumentRoleInputType.class,
    PartnerAddInfoType.class,
    AttachmentType.class,
    CardDetailsInputType.class,
    PropertyInputType.class,
    RegimeAccountType.class,
    CommercialVehicalDetailsInputType.class,
    TradingAsInputType.class,
    OrganisationType.class,
    BusinessSectorInputType.class,
    IdentificationType.class,
    EntityIndustryOccupationType.class,
    ContactMethodType.class,
    NoteType.class,
    ReturnsInputType.class,
    AddressType.class,
    EntityAccountType.class,
    ApplicationAuthorisationInputType.class,
    DdocDocumentInputType.class
})
public class InputType
    extends BaseType implements Serializable
{

    @XmlElement(name = "AdditionalFields")
    protected List<AdditionalField> additionalFields;
    @XmlElement(name = "CreatedBy")
    protected String createdBy;
    @XmlElement(name = "CreatedDate")
    @XmlSchemaType(name = "dateTime")
    protected Calendar createdDate;
    @XmlElement(name = "Id")
    protected Long id;
    @XmlElement(name = "OwnerId")
    protected Long ownerId;
    @XmlElement(name = "OwnerType")
    protected String ownerType;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "UpdatedBy")
    protected String updatedBy;
    @XmlElement(name = "UpdatedDate")
    @XmlSchemaType(name = "dateTime")
    protected Calendar updatedDate;
    @XmlElement(name = "AssociatedData")
    protected List<String> associatedData;
    @XmlElement(name = "LazyFetch")
    protected Boolean lazyFetch;
    @XmlElement(name = "AccessLevel")
    protected String accessLevel;
    @XmlElement(name = "Overrided")
    protected Boolean overrided;
    @XmlElement(name = "OverridedBy")
    protected String overridedBy;
    @XmlElement(name = "PageAction")
    protected String pageAction;
    @XmlElement(name = "PageMode")
    protected String pageMode;
    @XmlElement(name = "PageConfig")
    protected String pageConfig;

    /**
     * Gets the value of the additionalFields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalFields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalField }
     * 
     * 
     */
    public List<AdditionalField> getAdditionalFields() {
        if (additionalFields == null) {
            additionalFields = new ArrayList<AdditionalField>();
        }
        return this.additionalFields;
    }

    /**
     * Gets the value of the createdBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedBy(String value) {
        this.createdBy = value;
    }

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setCreatedDate(Calendar value) {
        this.createdDate = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the ownerId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the value of the ownerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOwnerId(Long value) {
        this.ownerId = value;
    }

    /**
     * Gets the value of the ownerType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * Sets the value of the ownerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerType(String value) {
        this.ownerType = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the updatedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Sets the value of the updatedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdatedBy(String value) {
        this.updatedBy = value;
    }

    /**
     * Gets the value of the updatedDate property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getUpdatedDate() {
        return updatedDate;
    }

    /**
     * Sets the value of the updatedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setUpdatedDate(Calendar value) {
        this.updatedDate = value;
    }

    /**
     * Gets the value of the associatedData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associatedData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssociatedData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAssociatedData() {
        if (associatedData == null) {
            associatedData = new ArrayList<String>();
        }
        return this.associatedData;
    }

    /**
     * Gets the value of the lazyFetch property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLazyFetch() {
        return lazyFetch;
    }

    /**
     * Sets the value of the lazyFetch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLazyFetch(Boolean value) {
        this.lazyFetch = value;
    }

    /**
     * Gets the value of the accessLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessLevel() {
        return accessLevel;
    }

    /**
     * Sets the value of the accessLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessLevel(String value) {
        this.accessLevel = value;
    }

    /**
     * Gets the value of the overrided property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOverrided() {
        return overrided;
    }

    /**
     * Sets the value of the overrided property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOverrided(Boolean value) {
        this.overrided = value;
    }

    /**
     * Gets the value of the overridedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverridedBy() {
        return overridedBy;
    }

    /**
     * Sets the value of the overridedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverridedBy(String value) {
        this.overridedBy = value;
    }

    /**
     * Gets the value of the pageAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageAction() {
        return pageAction;
    }

    /**
     * Sets the value of the pageAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageAction(String value) {
        this.pageAction = value;
    }

    /**
     * Gets the value of the pageMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageMode() {
        return pageMode;
    }

    /**
     * Sets the value of the pageMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageMode(String value) {
        this.pageMode = value;
    }

    /**
     * Gets the value of the pageConfig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageConfig() {
        return pageConfig;
    }

    /**
     * Sets the value of the pageConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageConfig(String value) {
        this.pageConfig = value;
    }

}
