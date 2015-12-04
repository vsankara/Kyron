//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.16 at 02:38:30 PM GMT 
//


package com.technobrain.trips.core.message;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.util.Calendar;
import com.technobrain.trips.application.message.RevenueTypeAppInputType;


/**
 * <p>Java class for RegimeAccountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegimeAccountType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://trips.technobrain.com/core/message}InputType">
 *       &lt;sequence>
 *         &lt;element name="AdvisoryVisitIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AutoRefundIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EDC" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EDR" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EDS" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EntityAccountID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FastTrackAuthorisation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ForcedRegistrationIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="InterviewVisitIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="NonTaxableTurnoverAtRegistration" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Office" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Operation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreviousRegimeNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RefundInhibitIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RegimeNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RevenueMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RevenueType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RevenueSubtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Stagger" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubStagger" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxableTurnoverAtRegistration" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TradeClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TradeClass2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TradeClass3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TradeClass4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TradingAs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TradingEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="TradingStartDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="RevenueAcctStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EDD" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DeregistrationReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RevenueAccountID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="NewLegalStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountingType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegistrationFor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RevenueApplication" type="{http://trips.technobrain.com/application/message}RevenueTypeAppInputType" minOccurs="0"/>
 *         &lt;element name="ApprovalRequiredIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ReturnTypes" type="{http://trips.technobrain.com/core/message}ReturnsInputType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegimeAccountType", propOrder = {
    "advisoryVisitIndicator",
    "autoRefundIndicator",
    "edc",
    "edr",
    "eds",
    "entityAccountID",
    "fastTrackAuthorisation",
    "forcedRegistrationIndicator",
    "interviewVisitIndicator",
    "nonTaxableTurnoverAtRegistration",
    "office",
    "operation",
    "previousRegimeNumber",
    "refundInhibitIndicator",
    "regimeNumber",
    "revenueMode",
    "revenueType",
    "revenueSubtype",
    "stagger",
    "subStagger",
    "taxableTurnoverAtRegistration",
    "tradeClass",
    "tradeClass2",
    "tradeClass3",
    "tradeClass4",
    "tradingAs",
    "tradingEndDate",
    "tradingStartDate",
    "revenueAcctStatus",
    "edd",
    "deregistrationReason",
    "revenueAccountID",
    "newLegalStatus",
    "accountingType",
    "registrationFor",
    "revenueApplication",
    "approvalRequiredIndicator",
    "returnTypes"
})
public class RegimeAccountType
    extends InputType
{

    @XmlElement(name = "AdvisoryVisitIndicator")
    protected Boolean advisoryVisitIndicator;
    @XmlElement(name = "AutoRefundIndicator")
    protected Boolean autoRefundIndicator;
    @XmlElement(name = "EDC")
    @XmlSchemaType(name = "date")
    protected Calendar edc;
    @XmlElement(name = "EDR")
    @XmlSchemaType(name = "date")
    protected Calendar edr;
    @XmlElement(name = "EDS")
    @XmlSchemaType(name = "date")
    protected Calendar eds;
    @XmlElement(name = "EntityAccountID")
    protected String entityAccountID;
    @XmlElement(name = "FastTrackAuthorisation")
    protected Boolean fastTrackAuthorisation;
    @XmlElement(name = "ForcedRegistrationIndicator")
    protected Boolean forcedRegistrationIndicator;
    @XmlElement(name = "InterviewVisitIndicator")
    protected Boolean interviewVisitIndicator;
    @XmlElement(name = "NonTaxableTurnoverAtRegistration")
    protected BigDecimal nonTaxableTurnoverAtRegistration;
    @XmlElement(name = "Office")
    protected String office;
    @XmlElement(name = "Operation")
    protected String operation;
    @XmlElement(name = "PreviousRegimeNumber")
    protected String previousRegimeNumber;
    @XmlElement(name = "RefundInhibitIndicator")
    protected Boolean refundInhibitIndicator;
    @XmlElement(name = "RegimeNumber")
    protected String regimeNumber;
    @XmlElement(name = "RevenueMode")
    protected String revenueMode;
    @XmlElement(name = "RevenueType")
    protected String revenueType;
    @XmlElement(name = "RevenueSubtype")
    protected String revenueSubtype;
    @XmlElement(name = "Stagger")
    protected String stagger;
    @XmlElement(name = "SubStagger")
    protected String subStagger;
    @XmlElement(name = "TaxableTurnoverAtRegistration")
    protected BigDecimal taxableTurnoverAtRegistration;
    @XmlElement(name = "TradeClass")
    protected String tradeClass;
    @XmlElement(name = "TradeClass2")
    protected String tradeClass2;
    @XmlElement(name = "TradeClass3")
    protected String tradeClass3;
    @XmlElement(name = "TradeClass4")
    protected String tradeClass4;
    @XmlElement(name = "TradingAs")
    protected String tradingAs;
    @XmlElement(name = "TradingEndDate")
    @XmlSchemaType(name = "date")
    protected Calendar tradingEndDate;
    @XmlElement(name = "TradingStartDate")
    @XmlSchemaType(name = "date")
    protected Calendar tradingStartDate;
    @XmlElement(name = "RevenueAcctStatus")
    protected String revenueAcctStatus;
    @XmlElement(name = "EDD")
    @XmlSchemaType(name = "date")
    protected Calendar edd;
    @XmlElement(name = "DeregistrationReason")
    protected String deregistrationReason;
    @XmlElement(name = "RevenueAccountID")
    protected Long revenueAccountID;
    @XmlElement(name = "NewLegalStatus")
    protected String newLegalStatus;
    @XmlElement(name = "AccountingType")
    protected String accountingType;
    @XmlElement(name = "RegistrationFor")
    protected String registrationFor;
    @XmlElement(name = "RevenueApplication")
    protected RevenueTypeAppInputType revenueApplication;
    @XmlElement(name = "ApprovalRequiredIndicator")
    protected Boolean approvalRequiredIndicator;
    @XmlElement(name = "ReturnTypes")
    protected List<ReturnsInputType> returnTypes;

    /**
     * Gets the value of the advisoryVisitIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAdvisoryVisitIndicator() {
        return advisoryVisitIndicator;
    }

    /**
     * Sets the value of the advisoryVisitIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAdvisoryVisitIndicator(Boolean value) {
        this.advisoryVisitIndicator = value;
    }

    /**
     * Gets the value of the autoRefundIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoRefundIndicator() {
        return autoRefundIndicator;
    }

    /**
     * Sets the value of the autoRefundIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoRefundIndicator(Boolean value) {
        this.autoRefundIndicator = value;
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
     * Gets the value of the entityAccountID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityAccountID() {
        return entityAccountID;
    }

    /**
     * Sets the value of the entityAccountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityAccountID(String value) {
        this.entityAccountID = value;
    }

    /**
     * Gets the value of the fastTrackAuthorisation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFastTrackAuthorisation() {
        return fastTrackAuthorisation;
    }

    /**
     * Sets the value of the fastTrackAuthorisation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFastTrackAuthorisation(Boolean value) {
        this.fastTrackAuthorisation = value;
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
     * Gets the value of the interviewVisitIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInterviewVisitIndicator() {
        return interviewVisitIndicator;
    }

    /**
     * Sets the value of the interviewVisitIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInterviewVisitIndicator(Boolean value) {
        this.interviewVisitIndicator = value;
    }

    /**
     * Gets the value of the nonTaxableTurnoverAtRegistration property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNonTaxableTurnoverAtRegistration() {
        return nonTaxableTurnoverAtRegistration;
    }

    /**
     * Sets the value of the nonTaxableTurnoverAtRegistration property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNonTaxableTurnoverAtRegistration(BigDecimal value) {
        this.nonTaxableTurnoverAtRegistration = value;
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
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * Gets the value of the previousRegimeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviousRegimeNumber() {
        return previousRegimeNumber;
    }

    /**
     * Sets the value of the previousRegimeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviousRegimeNumber(String value) {
        this.previousRegimeNumber = value;
    }

    /**
     * Gets the value of the refundInhibitIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRefundInhibitIndicator() {
        return refundInhibitIndicator;
    }

    /**
     * Sets the value of the refundInhibitIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRefundInhibitIndicator(Boolean value) {
        this.refundInhibitIndicator = value;
    }

    /**
     * Gets the value of the regimeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegimeNumber() {
        return regimeNumber;
    }

    /**
     * Sets the value of the regimeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegimeNumber(String value) {
        this.regimeNumber = value;
    }

    /**
     * Gets the value of the revenueMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevenueMode() {
        return revenueMode;
    }

    /**
     * Sets the value of the revenueMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevenueMode(String value) {
        this.revenueMode = value;
    }

    /**
     * Gets the value of the revenueType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevenueType() {
        return revenueType;
    }

    /**
     * Sets the value of the revenueType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevenueType(String value) {
        this.revenueType = value;
    }

    /**
     * Gets the value of the revenueSubtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevenueSubtype() {
        return revenueSubtype;
    }

    /**
     * Sets the value of the revenueSubtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevenueSubtype(String value) {
        this.revenueSubtype = value;
    }

    /**
     * Gets the value of the stagger property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStagger() {
        return stagger;
    }

    /**
     * Sets the value of the stagger property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStagger(String value) {
        this.stagger = value;
    }

    /**
     * Gets the value of the subStagger property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubStagger() {
        return subStagger;
    }

    /**
     * Sets the value of the subStagger property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubStagger(String value) {
        this.subStagger = value;
    }

    /**
     * Gets the value of the taxableTurnoverAtRegistration property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxableTurnoverAtRegistration() {
        return taxableTurnoverAtRegistration;
    }

    /**
     * Sets the value of the taxableTurnoverAtRegistration property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxableTurnoverAtRegistration(BigDecimal value) {
        this.taxableTurnoverAtRegistration = value;
    }

    /**
     * Gets the value of the tradeClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeClass() {
        return tradeClass;
    }

    /**
     * Sets the value of the tradeClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeClass(String value) {
        this.tradeClass = value;
    }

    /**
     * Gets the value of the tradeClass2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeClass2() {
        return tradeClass2;
    }

    /**
     * Sets the value of the tradeClass2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeClass2(String value) {
        this.tradeClass2 = value;
    }

    /**
     * Gets the value of the tradeClass3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeClass3() {
        return tradeClass3;
    }

    /**
     * Sets the value of the tradeClass3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeClass3(String value) {
        this.tradeClass3 = value;
    }

    /**
     * Gets the value of the tradeClass4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeClass4() {
        return tradeClass4;
    }

    /**
     * Sets the value of the tradeClass4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeClass4(String value) {
        this.tradeClass4 = value;
    }

    /**
     * Gets the value of the tradingAs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradingAs() {
        return tradingAs;
    }

    /**
     * Sets the value of the tradingAs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradingAs(String value) {
        this.tradingAs = value;
    }

    /**
     * Gets the value of the tradingEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getTradingEndDate() {
        return tradingEndDate;
    }

    /**
     * Sets the value of the tradingEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setTradingEndDate(Calendar value) {
        this.tradingEndDate = value;
    }

    /**
     * Gets the value of the tradingStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getTradingStartDate() {
        return tradingStartDate;
    }

    /**
     * Sets the value of the tradingStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setTradingStartDate(Calendar value) {
        this.tradingStartDate = value;
    }

    /**
     * Gets the value of the revenueAcctStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevenueAcctStatus() {
        return revenueAcctStatus;
    }

    /**
     * Sets the value of the revenueAcctStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevenueAcctStatus(String value) {
        this.revenueAcctStatus = value;
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
     * Gets the value of the deregistrationReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeregistrationReason() {
        return deregistrationReason;
    }

    /**
     * Sets the value of the deregistrationReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeregistrationReason(String value) {
        this.deregistrationReason = value;
    }

    /**
     * Gets the value of the revenueAccountID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRevenueAccountID() {
        return revenueAccountID;
    }

    /**
     * Sets the value of the revenueAccountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRevenueAccountID(Long value) {
        this.revenueAccountID = value;
    }

    /**
     * Gets the value of the newLegalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewLegalStatus() {
        return newLegalStatus;
    }

    /**
     * Sets the value of the newLegalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewLegalStatus(String value) {
        this.newLegalStatus = value;
    }

    /**
     * Gets the value of the accountingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountingType() {
        return accountingType;
    }

    /**
     * Sets the value of the accountingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountingType(String value) {
        this.accountingType = value;
    }

    /**
     * Gets the value of the registrationFor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationFor() {
        return registrationFor;
    }

    /**
     * Sets the value of the registrationFor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationFor(String value) {
        this.registrationFor = value;
    }

    /**
     * Gets the value of the revenueApplication property.
     * 
     * @return
     *     possible object is
     *     {@link RevenueTypeAppInputType }
     *     
     */
    public RevenueTypeAppInputType getRevenueApplication() {
        return revenueApplication;
    }

    /**
     * Sets the value of the revenueApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link RevenueTypeAppInputType }
     *     
     */
    public void setRevenueApplication(RevenueTypeAppInputType value) {
        this.revenueApplication = value;
    }

    /**
     * Gets the value of the approvalRequiredIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isApprovalRequiredIndicator() {
        return approvalRequiredIndicator;
    }

    /**
     * Sets the value of the approvalRequiredIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setApprovalRequiredIndicator(Boolean value) {
        this.approvalRequiredIndicator = value;
    }

    /**
     * Gets the value of the returnTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the returnTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReturnTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReturnsInputType }
     * 
     * 
     */
    public List<ReturnsInputType> getReturnTypes() {
        if (returnTypes == null) {
            returnTypes = new ArrayList<ReturnsInputType>();
        }
        return this.returnTypes;
    }

}
