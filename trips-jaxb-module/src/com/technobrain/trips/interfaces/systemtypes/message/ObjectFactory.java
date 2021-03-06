//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.12-b141219.1637 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.01 at 11:40:08 AM GMT 
//


package com.technobrain.trips.interfaces.systemtypes.message;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.technobrain.trips.interfaces.systemtypes.message package. 
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

    private final static QName _ReferenceDataRequest_QNAME = new QName("http://trips.technobrain.com/interfaces/systemtypes/message", "ReferenceDataRequest");
    private final static QName _ReferenceDataResponse_QNAME = new QName("http://trips.technobrain.com/interfaces/systemtypes/message", "ReferenceDataResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.technobrain.trips.interfaces.systemtypes.message
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReferenceDataRequest }
     * 
     */
    public ReferenceDataRequest createReferenceDataRequest() {
        return new ReferenceDataRequest();
    }

    /**
     * Create an instance of {@link ReferenceDataResponse }
     * 
     */
    public ReferenceDataResponse createReferenceDataResponse() {
        return new ReferenceDataResponse();
    }

    /**
     * Create an instance of {@link RefDataType }
     * 
     */
    public RefDataType createRefDataType() {
        return new RefDataType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceDataRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trips.technobrain.com/interfaces/systemtypes/message", name = "ReferenceDataRequest")
    public JAXBElement<ReferenceDataRequest> createReferenceDataRequest(ReferenceDataRequest value) {
        return new JAXBElement<ReferenceDataRequest>(_ReferenceDataRequest_QNAME, ReferenceDataRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trips.technobrain.com/interfaces/systemtypes/message", name = "ReferenceDataResponse")
    public JAXBElement<ReferenceDataResponse> createReferenceDataResponse(ReferenceDataResponse value) {
        return new JAXBElement<ReferenceDataResponse>(_ReferenceDataResponse_QNAME, ReferenceDataResponse.class, null, value);
    }

}
