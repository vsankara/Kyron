//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.12-b141219.1637 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.30 at 06:04:18 PM GMT 
//


package com.technobrain.trips.interfaces.basetypes.message;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.technobrain.trips.interfaces.basetypes.message package. 
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

    private final static QName _TripsWSException_QNAME = new QName("http://trips.technobrain.com/interfaces/basetypes/message", "TripsWSException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.technobrain.trips.interfaces.basetypes.message
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TripsWSException }
     * 
     */
    public TripsWSException createTripsWSException() {
        return new TripsWSException();
    }

    /**
     * Create an instance of {@link ErrorType }
     * 
     */
    public ErrorType createErrorType() {
        return new ErrorType();
    }

    /**
     * Create an instance of {@link BusinessSectorType }
     * 
     */
    public BusinessSectorType createBusinessSectorType() {
        return new BusinessSectorType();
    }

    /**
     * Create an instance of {@link ServiceResponseType }
     * 
     */
    public ServiceResponseType createServiceResponseType() {
        return new ServiceResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TripsWSException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trips.technobrain.com/interfaces/basetypes/message", name = "TripsWSException")
    public JAXBElement<TripsWSException> createTripsWSException(TripsWSException value) {
        return new JAXBElement<TripsWSException>(_TripsWSException_QNAME, TripsWSException.class, null, value);
    }

}
