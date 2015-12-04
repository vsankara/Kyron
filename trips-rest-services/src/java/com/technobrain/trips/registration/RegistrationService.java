/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technobrain.trips.registration;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.interfaces.registration.common.message.ContactMethodType;
import com.technobrain.trips.interfaces.basetypes.message.BusinessSectorType;
import com.technobrain.trips.interfaces.registration.common.message.AddressInfoType;
import com.technobrain.trips.interfaces.registration.common.message.Outcomes;
import com.technobrain.trips.interfaces.registration.common.message.PhoneTypes;
import com.technobrain.trips.interfaces.registration.common.message.RegStatus;

import com.technobrain.trips.interfaces.registration.message.OrgReg;
import com.technobrain.trips.interfaces.registration.message.OrgRegOutput;
import com.technobrain.trips.interfaces.registration.viewtaxpayer.message.OrganisationDetailsType;
import com.technobrain.trips.interfaces.registration.viewtaxpayer.message.TaxpayerStatusType;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * REST Web Service
 *
 * @author vsankara
 */
@Path("registration")
public class RegistrationService {

    /**
     * Creates a new instance of SampleRest
     */
    public RegistrationService() {
    }
    
    @GET
    @Path("viewOrganisation")
    @Produces(MediaType.APPLICATION_JSON)
    public OrganisationDetailsType viewOrganisation(@QueryParam("tin")String tin) {
        OrganisationDetailsType orgReg = new OrganisationDetailsType();
        
        orgReg.setOrganisationCategory("P");
        orgReg.setOrganisation("Techno Brain Europe Limited");
        orgReg.setTradingAs("Trips+");
        orgReg.setStatus("Registered");
        orgReg.setDateofIncorporation(Calendar.getInstance());
        orgReg.setAccountYearEndDay(BigInteger.valueOf(30));
        orgReg.setAccountYearEndMonth(BigInteger.valueOf(12));
        orgReg.setTaxConsultantStatus(Boolean.TRUE);
        orgReg.setWebsite("www.technobrain.com");
        orgReg.setAssignedTaxOffice("HQ");
        orgReg.setApplicantTIN("APPTIN/001");
        orgReg.setImporter(Boolean.TRUE);
        orgReg.setExporter(Boolean.FALSE);
        orgReg.setTin(tin);
  
        ArrayList<AddressInfoType> addressList = new ArrayList<AddressInfoType>();
        
        AddressInfoType address = new AddressInfoType();
        address.setBuildingName("St. Nicholas House");
        address.setCity("Sutton");
        address.setCountry("United Kingdom");
        address.setDistrict("District 27");
        address.setHouseNumber("134");
        address.setPoBox("POBOX:100");
        address.setStreetName("St. Nicholas Way");
        address.setPostOfficeLocation("High Street");
        address.setRegion("London");
        address.setEffectiveAddressDate(Calendar.getInstance());
        
        addressList.add(address);
        orgReg.getAddress().addAll(addressList);
        
        ArrayList<ContactMethodType> contactList = new ArrayList<ContactMethodType>();
        
        ContactMethodType contact = new ContactMethodType();
        contact.setPhoneType(PhoneTypes.MOBILE);
        contact.setPhoneNumber("07838263690");
        contact.setEmail("test@technobrain.com");
        
        
        contactList.add(contact);
        orgReg.getContactMethod().addAll(contactList);
        
        ArrayList<BusinessSectorType> sectorList = new ArrayList<BusinessSectorType>();
        
        BusinessSectorType businessSector = new BusinessSectorType();
        
        businessSector.setCode("0127");
        businessSector.setDescription("Growing of beverage crops");
        businessSector.setPrimaryBusinessSector(true);
        
        sectorList.add(businessSector);
        orgReg.getBusinessSector().addAll(sectorList);
        return orgReg;
    }
    
    
    @GET
    @Path("checkRegistrationStatus")
    @Produces(MediaType.APPLICATION_JSON)
    public TaxpayerStatusType checkRegistrationStatus(@QueryParam("referenceNumber")String referenceNumber) {
        TaxpayerStatusType taxpayerStatusType = new TaxpayerStatusType();
        taxpayerStatusType.setTin("TIN/2015/001");
        taxpayerStatusType.setTaxpayerName("Techno Brain Europe Limited");
        taxpayerStatusType.setRegistrationStatus(RegStatus.PEND_REG);
        return taxpayerStatusType;
    }
    
    
    @POST
    @Path("registerOrganisation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public OrgRegOutput registerOrganisation(OrgReg orgReg) {
        System.out.println("******** Inside registerOrganisation Service *************");
        System.out.println(orgReg.getBusinessName());
        System.out.println(orgReg.getIsicCodes());
        System.out.println(orgReg.getOffice());
//        System.out.println(orgReg.getIncorporationDate().getTime());
//        System.out.println(orgReg.getCommencementDate().getTime());
        OrgRegOutput orgRegOutput = new OrgRegOutput();
        if (orgReg != null) {
            
            orgReg.setReferenceNumber("REF/2015/" + orgReg.getBusinessName().substring(0, 5).toUpperCase());
            System.out.println("******** Reference Number *************" + orgReg.getReferenceNumber());

            Client client = Client.create();
            WebResource service1 = client.resource("http://10.50.20.6/CRMREST/ServiceAccount.svc/create");
            System.out.println("******** Before Calling CRM *************");
            OrgReg resp = service1.accept(MediaType.APPLICATION_JSON)
                                  .type(MediaType.APPLICATION_JSON)
                                  .post(OrgReg.class, orgReg);
            
            if (resp.getOutcome() != null && resp.getOutcome().equals(Outcomes.PENDING)) {
                orgRegOutput.setTin("Registration awaiting Approval");
                orgRegOutput.setReferenceNumber(orgReg.getReferenceNumber());
            }
            else {
                orgRegOutput.setReferenceNumber("Input is null");
                orgRegOutput.setTin("Not Registered");
            }
            
        } else {
            orgRegOutput.setReferenceNumber("Input is null");
            orgRegOutput.setTin("Not Registered");
        }

        return orgRegOutput;
    }

    
}
