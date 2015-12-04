/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technobrain.trips.registration;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.interfaces.registration.common.message.AddressInfoType;
import com.technobrain.trips.interfaces.registration.common.message.ContactMethodType;
import com.technobrain.trips.interfaces.registration.common.message.PhoneTypes;
import com.technobrain.trips.interfaces.registration.message.OrgReg;
import com.technobrain.trips.interfaces.registration.message.OrgRegOutput;
import com.technobrain.trips.interfaces.registration.message.TaxpayerStatusType;
import com.technobrain.trips.interfaces.registration.viewtaxpayer.message.OrganisationDetailsType;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.stream.JsonParser;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.rpc.encoding.DeserializationContext;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.node.IntNode;



public class RestClient {

    
        
        
        
    public static void main(String[] args) {
        
        registerOrganisation();
//        viewOrganisation();
//        getRegistrationStatus();        
//        appoveRegistrationCRM();

    }
    
    private static void registerOrganisation() {

        int minimum = 1;
        int maximum = 10000;
        int randomNumber = minimum + (int)(Math.random()*maximum);

        String REST_URI = "http://localhost:7001/trips-rest-services/tripsrest/registration/viewOrganisation";

        OrgReg orgReg = new OrgReg();
        orgReg.setAccountYearEndDay(BigInteger.valueOf(30));
        orgReg.setAccoutYearEndMonth(BigInteger.valueOf(12));
        orgReg.setBusinessName( randomNumber + " - TBEL" );
        orgReg.setLegalStatusType("C");
        orgReg.setIsicCodes("1001");
        orgReg.setOffice("HQ");
        orgReg.setCommencementDate(Calendar.getInstance());
        orgReg.setIncorporationDate(Calendar.getInstance());
        orgReg.setRegistrationDate(Calendar.getInstance());
        orgReg.setReferenceNumber("Test/2015/001");
        AddressInfoType address = new AddressInfoType();
        address.setBuildingName("St. Nicholas House");
        address.setCity("Sutton");
        address.setCountry("United Kingdom");
        address.setDistrict("District 27");
        address.setHouseNumber("134");
        address.setPoBox("POBOX:100");
        address.setStreetName("St. Nicholas Way");
        address.setPostOfficeLocation("High Street");
        address.setPostalCode("SM1 1EH");
        address.setRegion("London");
        address.setEffectiveAddressDate(Calendar.getInstance());
        orgReg.setPrincipalBusinessAddress(address);
        
        ContactMethodType contact = new ContactMethodType();
        contact.setPhoneType(PhoneTypes.MOBILE);
        contact.setPhoneNumber("07838263690");
        contact.setEmail("test@technobrain.com");
        
        orgReg.setOrgContactDetails(contact);
        
    	ClientConfig config = new DefaultClientConfig();   
        Client client = Client.create(config);
        
        WebResource service1 = client.resource("http://10.50.10.133:7001/trips-rest-services/tripsrest/registration/registerOrganisation");
        
        ClientResponse resp = service1.accept(MediaType.APPLICATION_JSON)
                                  .type(MediaType.APPLICATION_JSON)
                                  .post(ClientResponse.class, orgReg);
        OrgRegOutput regOutput = resp.getEntity(OrgRegOutput.class);
        System.out.println("******** registerOrganisation *************");
        System.out.println(regOutput.getReferenceNumber()+regOutput.getTin());
            
    }
    
    private static void viewOrganisation() {
    	ClientConfig config = new DefaultClientConfig();   
        Client client = Client.create(config);
        WebResource service = client.resource("http://10.50.10.133:7001/trips-rest-services/tripsrest/registration/viewOrganisation");

        ClientResponse response = service
                            .queryParam("tin", "AK01/TEST/001")
                            .accept(MediaType.APPLICATION_JSON)
                            .type(MediaType.APPLICATION_JSON)
                            .get(ClientResponse.class);
        
        OrganisationDetailsType msg = response.getEntity(OrganisationDetailsType.class);
        System.out.println("******** viewOrganisation *************");
        System.out.println(msg.getTradingAs() + " - " + msg.getTin());
            
    }
    
    private static void getRegistrationStatus() {
    	ClientConfig config = new DefaultClientConfig();   
        Client client = Client.create(config);
        WebResource service = client.resource("http://localhost:7001/trips-rest-services/tripsrest/registration/checkRegistrationStatus");

        ClientResponse response = service
                            .queryParam("referenceNumber", "REF/TEST/001")
                            .accept(MediaType.APPLICATION_JSON)
                            .type(MediaType.APPLICATION_JSON)
                            .get(ClientResponse.class);
        
        TaxpayerStatusType msg = response.getEntity(TaxpayerStatusType.class);
                
        System.out.println("******** getRegistrationStatus *************");
        System.out.println(msg.getTaxpayerName()+ " - " + msg.getRegistrationStatus());
    }
    
    private static void appoveRegistrationCRM() {

        OrgReg orgReg = new OrgReg();
        orgReg.setAccountYearEndDay(BigInteger.valueOf(30));
        orgReg.setAccoutYearEndMonth(BigInteger.valueOf(12));
        orgReg.setBusinessName("Techno Brain Europe Limited");
        orgReg.setLegalStatusType("C");
        orgReg.setIsicCodes("1001");
        orgReg.setOffice("HQ");
        orgReg.setCommencementDate(Calendar.getInstance());
        orgReg.setIncorporationDate(Calendar.getInstance());
        orgReg.setRegistrationDate(Calendar.getInstance());
        orgReg.setReferenceNumber("Test/2015/001");
        AddressInfoType address = new AddressInfoType();
        address.setBuildingName("St. Nicholas House");
        address.setCity("Sutton");
        address.setCountry("United Kingdom");
        address.setDistrict("District 27");
        address.setHouseNumber("134");
        address.setPoBox("POBOX:100");
        address.setStreetName("St. Nicholas Way");
        address.setPostOfficeLocation("High Street");
        address.setPostalCode("SM1 1EH");
        address.setRegion("London");
        address.setEffectiveAddressDate(Calendar.getInstance());
        orgReg.setPrincipalBusinessAddress(address);
        
        ContactMethodType contact = new ContactMethodType();
        contact.setPhoneType(PhoneTypes.MOBILE);
        contact.setPhoneNumber("07838263690");
        contact.setEmail("test@technobrain.com");
        
        orgReg.setOrgContactDetails(contact);
        
        
//        ClientConfig config = new DefaultClientConfig();   
        Client client = Client.create();

        WebResource service1 = client.resource("http://10.50.20.6/CRMREST/ServiceAccount.svc/create");
        
        OrgReg resp = service1.accept(MediaType.APPLICATION_JSON)
                                  .type(MediaType.APPLICATION_JSON)
                                  .post(OrgReg.class, orgReg);
//        OrgReg regOutput = resp.getEntity(OrgReg.class);
        System.out.println("******** appoveRegistrationCRM *************");
        System.out.println(resp.getOutcome() + " - " + resp.getReferenceNumber());
//        System.out.println(resp.getCommencementDate());
        
    }
    
//    public static XMLGregorianCalendar getCurrentDate() {
//        GregorianCalendar gcal = (GregorianCalendar) GregorianCalendar.getInstance();
//        gcal.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
//        
//            XMLGregorianCalendar xgcal;
//        try {
//            xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
//            return xgcal;
//        } catch (DatatypeConfigurationException ex) {
//            java.util.logging.Logger.getLogger(DateHelper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    
    
    
}
