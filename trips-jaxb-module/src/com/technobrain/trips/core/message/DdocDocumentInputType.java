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
import com.technobrain.trips.application.message.ApplicationInputType;


/**
 * <p>Java class for DdocDocumentInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DdocDocumentInputType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://trips.technobrain.com/core/message}InputType">
 *       &lt;sequence>
 *         &lt;element name="Attachments" type="{http://trips.technobrain.com/core/message}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="IssueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="IssuePlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IssueOffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="AccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="PeriodId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SubmissionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DmsId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocTax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FelxiForm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrintCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="PrintStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReportType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Template" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DdocDocumentRoles" type="{http://trips.technobrain.com/core/message}DDocDocumentRoleInputType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PortalUsername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DdocDocumentInputType", propOrder = {
    "attachments",
    "issueDate",
    "issuePlace",
    "issueOffice",
    "itemCount",
    "accountId",
    "periodId",
    "submissionDate",
    "dmsId",
    "docStatus",
    "docType",
    "dtype",
    "docTax",
    "felxiForm",
    "printCount",
    "printStatus",
    "reference",
    "reportType",
    "template",
    "ddocDocumentRoles",
    "portalUsername"
})
@XmlSeeAlso({
    ApplicationInputType.class
})
public class DdocDocumentInputType
    extends InputType
{

    @XmlElement(name = "Attachments")
    protected List<AttachmentType> attachments;
    @XmlElement(name = "IssueDate")
    @XmlSchemaType(name = "date")
    protected Calendar issueDate;
    @XmlElement(name = "IssuePlace")
    protected String issuePlace;
    @XmlElement(name = "IssueOffice")
    protected String issueOffice;
    @XmlElement(name = "ItemCount")
    protected Long itemCount;
    @XmlElement(name = "AccountId")
    protected Long accountId;
    @XmlElement(name = "PeriodId")
    protected Long periodId;
    @XmlElement(name = "SubmissionDate")
    @XmlSchemaType(name = "date")
    protected Calendar submissionDate;
    @XmlElement(name = "DmsId")
    protected String dmsId;
    @XmlElement(name = "DocStatus")
    protected String docStatus;
    @XmlElement(name = "DocType")
    protected String docType;
    @XmlElement(name = "Dtype")
    protected String dtype;
    @XmlElement(name = "DocTax")
    protected String docTax;
    @XmlElement(name = "FelxiForm")
    protected String felxiForm;
    @XmlElement(name = "PrintCount")
    protected Long printCount;
    @XmlElement(name = "PrintStatus")
    protected String printStatus;
    @XmlElement(name = "Reference")
    protected String reference;
    @XmlElement(name = "ReportType")
    protected String reportType;
    @XmlElement(name = "Template")
    protected String template;
    @XmlElement(name = "DdocDocumentRoles")
    protected List<DDocDocumentRoleInputType> ddocDocumentRoles;
    @XmlElement(name = "PortalUsername")
    protected String portalUsername;

    /**
     * Gets the value of the attachments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<AttachmentType>();
        }
        return this.attachments;
    }

    /**
     * Gets the value of the issueDate property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getIssueDate() {
        return issueDate;
    }

    /**
     * Sets the value of the issueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setIssueDate(Calendar value) {
        this.issueDate = value;
    }

    /**
     * Gets the value of the issuePlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuePlace() {
        return issuePlace;
    }

    /**
     * Sets the value of the issuePlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuePlace(String value) {
        this.issuePlace = value;
    }

    /**
     * Gets the value of the issueOffice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssueOffice() {
        return issueOffice;
    }

    /**
     * Sets the value of the issueOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssueOffice(String value) {
        this.issueOffice = value;
    }

    /**
     * Gets the value of the itemCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getItemCount() {
        return itemCount;
    }

    /**
     * Sets the value of the itemCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setItemCount(Long value) {
        this.itemCount = value;
    }

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountId(Long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the periodId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPeriodId() {
        return periodId;
    }

    /**
     * Sets the value of the periodId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPeriodId(Long value) {
        this.periodId = value;
    }

    /**
     * Gets the value of the submissionDate property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getSubmissionDate() {
        return submissionDate;
    }

    /**
     * Sets the value of the submissionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setSubmissionDate(Calendar value) {
        this.submissionDate = value;
    }

    /**
     * Gets the value of the dmsId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDmsId() {
        return dmsId;
    }

    /**
     * Sets the value of the dmsId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDmsId(String value) {
        this.dmsId = value;
    }

    /**
     * Gets the value of the docStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocStatus() {
        return docStatus;
    }

    /**
     * Sets the value of the docStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocStatus(String value) {
        this.docStatus = value;
    }

    /**
     * Gets the value of the docType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocType() {
        return docType;
    }

    /**
     * Sets the value of the docType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocType(String value) {
        this.docType = value;
    }

    /**
     * Gets the value of the dtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtype() {
        return dtype;
    }

    /**
     * Sets the value of the dtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtype(String value) {
        this.dtype = value;
    }

    /**
     * Gets the value of the docTax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocTax() {
        return docTax;
    }

    /**
     * Sets the value of the docTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocTax(String value) {
        this.docTax = value;
    }

    /**
     * Gets the value of the felxiForm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFelxiForm() {
        return felxiForm;
    }

    /**
     * Sets the value of the felxiForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFelxiForm(String value) {
        this.felxiForm = value;
    }

    /**
     * Gets the value of the printCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrintCount() {
        return printCount;
    }

    /**
     * Sets the value of the printCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrintCount(Long value) {
        this.printCount = value;
    }

    /**
     * Gets the value of the printStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrintStatus() {
        return printStatus;
    }

    /**
     * Sets the value of the printStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrintStatus(String value) {
        this.printStatus = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
    }

    /**
     * Gets the value of the reportType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportType() {
        return reportType;
    }

    /**
     * Sets the value of the reportType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportType(String value) {
        this.reportType = value;
    }

    /**
     * Gets the value of the template property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplate(String value) {
        this.template = value;
    }

    /**
     * Gets the value of the ddocDocumentRoles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ddocDocumentRoles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDdocDocumentRoles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DDocDocumentRoleInputType }
     * 
     * 
     */
    public List<DDocDocumentRoleInputType> getDdocDocumentRoles() {
        if (ddocDocumentRoles == null) {
            ddocDocumentRoles = new ArrayList<DDocDocumentRoleInputType>();
        }
        return this.ddocDocumentRoles;
    }

    /**
     * Gets the value of the portalUsername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortalUsername() {
        return portalUsername;
    }

    /**
     * Sets the value of the portalUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortalUsername(String value) {
        this.portalUsername = value;
    }

}
