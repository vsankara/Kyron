//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.18 at 02:12:08 PM GMT 
//


package com.technobrain.trips.registration.message;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.technobrain.trips.registration.message package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AccountOutputType_QNAME = new QName("http://trips.technobrain.com/registration/message", "AccountOutputType");
    private final static QName _ReasonHistoryInputType_QNAME = new QName("http://trips.technobrain.com/registration/message", "ReasonHistoryInputType");
    private final static QName _OrganisationTaxpayerInputType_QNAME = new QName("http://trips.technobrain.com/registration/message", "OrganisationTaxpayerInputType");
    private final static QName _EntityOutputType_QNAME = new QName("http://trips.technobrain.com/registration/message", "EntityOutputType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.technobrain.trips.registration.message
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReasonHistoryInputType }
     * 
     */
    public ReasonHistoryInputType createReasonHistoryInputType() {
        return new ReasonHistoryInputType();
    }

    /**
     * Create an instance of {@link AccountOutputType }
     * 
     */
    public AccountOutputType createAccountOutputType() {
        return new AccountOutputType();
    }

    /**
     * Create an instance of {@link OrganisationTaxpayerInputType }
     * 
     */
    public OrganisationTaxpayerInputType createOrganisationTaxpayerInputType() {
        return new OrganisationTaxpayerInputType();
    }

    /**
     * Create an instance of {@link EntityOutputType }
     * 
     */
    public EntityOutputType createEntityOutputType() {
        return new EntityOutputType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountOutputType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trips.technobrain.com/registration/message", name = "AccountOutputType")
    public JAXBElement<AccountOutputType> createAccountOutputType(AccountOutputType value) {
        return new JAXBElement<AccountOutputType>(_AccountOutputType_QNAME, AccountOutputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReasonHistoryInputType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trips.technobrain.com/registration/message", name = "ReasonHistoryInputType")
    public JAXBElement<ReasonHistoryInputType> createReasonHistoryInputType(ReasonHistoryInputType value) {
        return new JAXBElement<ReasonHistoryInputType>(_ReasonHistoryInputType_QNAME, ReasonHistoryInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganisationTaxpayerInputType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trips.technobrain.com/registration/message", name = "OrganisationTaxpayerInputType")
    public JAXBElement<OrganisationTaxpayerInputType> createOrganisationTaxpayerInputType(OrganisationTaxpayerInputType value) {
        return new JAXBElement<OrganisationTaxpayerInputType>(_OrganisationTaxpayerInputType_QNAME, OrganisationTaxpayerInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityOutputType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trips.technobrain.com/registration/message", name = "EntityOutputType")
    public JAXBElement<EntityOutputType> createEntityOutputType(EntityOutputType value) {
        return new JAXBElement<EntityOutputType>(_EntityOutputType_QNAME, EntityOutputType.class, null, value);
    }

}
