/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technobrain.trips.taxpayer;

import com.technobrain.trips.interfaces.basetypes.message.ResultCodeType;
import com.technobrain.trips.interfaces.registration.common.message.DocumentType;
import com.technobrain.trips.interfaces.registration.common.message.NonPeriodicAccountType;
import com.technobrain.trips.interfaces.registration.common.message.PeriodType;
import com.technobrain.trips.interfaces.registration.common.message.PeriodicAccountType;
import com.technobrain.trips.interfaces.registration.common.message.RegStatus;
import com.technobrain.trips.interfaces.registration.common.message.ReturnDocumentDetailsType;
import com.technobrain.trips.interfaces.registration.viewtaxpayer.message.AccountDetailsResponse;
import com.technobrain.trips.interfaces.registration.viewtaxpayer.message.ReturnDetailsResponse;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * REST Web Service
 *
 * @author adorairaj
 */
@Path("taxpayer")
public class TaxpayerService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TaxpayerService
     */
    public TaxpayerService() {
    }

    @GET
    @Path("availableReturns")
    @Produces(MediaType.APPLICATION_JSON)
    public ReturnDetailsResponse availableReturns(@QueryParam("tin")String tin) {
        ReturnDetailsResponse returnDetails = new ReturnDetailsResponse();
        returnDetails.setTin("TIN/2015/001");

        ReturnDocumentDetailsType returnType1 = new ReturnDocumentDetailsType();
        returnType1.setDocumentType("VAT");
        returnType1.setPeriodYear("2015");
        returnType1.setPeriodNumber(BigInteger.valueOf(1));
//        returnType.setPeriodDateFrom(getCurrentDate());
        
        ReturnDocumentDetailsType returnType2 = new ReturnDocumentDetailsType();
        returnType2.setDocumentType("VAT");
        returnType2.setPeriodYear("2015");
        returnType2.setPeriodNumber(BigInteger.valueOf(2));
//        returnType.setPeriodDateFrom(getCurrentDate());

        ReturnDocumentDetailsType returnType3 = new ReturnDocumentDetailsType();
        returnType3.setDocumentType("VAT");
        returnType3.setPeriodYear("2015");
        returnType3.setPeriodNumber(BigInteger.valueOf(3));
//        returnType.setPeriodDateFrom(getCurrentDate());
        
        returnDetails.getReturnDocumentDetails().add(returnType1);
        returnDetails.getReturnDocumentDetails().add(returnType2);
        returnDetails.getReturnDocumentDetails().add(returnType3);

        return returnDetails;
    }

    @GET
    @Path("viewAccountDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public AccountDetailsResponse viewAccountDetails(@QueryParam("tin")String tin, 
                                                @QueryParam("taxType")String taxType) {
        AccountDetailsResponse accountDetails = new AccountDetailsResponse();
        accountDetails.setTin(tin);
        accountDetails.setBalance(BigDecimal.valueOf(5000));
        accountDetails.setHasErrors(false);
        accountDetails.setHasWarnings(false);
        accountDetails.setResultCode(ResultCodeType.SUCCESS);
        accountDetails.setResultDescription("Successful");
                
        if (taxType.compareToIgnoreCase("VAT") == 0) {
            PeriodicAccountType periodicAccount = new PeriodicAccountType();
            periodicAccount.setType("VAT");
            periodicAccount.setNumber("VAT/101");
            periodicAccount.setStatus("REG");
            periodicAccount.setBalance(BigDecimal.valueOf(2000));

            PeriodType period = new PeriodType();
            period.setNumber("VAT/101/P1");
            period.setStatus("REG");
            period.setBalance(BigDecimal.valueOf(2000));

            ArrayList<DocumentType> documentList = new ArrayList<DocumentType>();
        
            DocumentType document1 = new DocumentType();
            document1.setNumber("VAT/101/P1/D1");
            document1.setStatus("REG");
            document1.setBalance(BigDecimal.valueOf(1200));
            document1.setDate(Calendar.getInstance());
            document1.setType("VAT");
            documentList.add(document1);

            DocumentType document2 = new DocumentType();
            document2.setNumber("VAT/101/P1/D2");
            document2.setStatus("REG");
            document2.setBalance(BigDecimal.valueOf(800));
            document2.setDate(Calendar.getInstance());
            document2.setType("VAT");
            documentList.add(document2);

            period.getDocuments().addAll(documentList);
            periodicAccount.getPeriods().add(period);

            accountDetails.getPeriodicAccounts().add(periodicAccount);
            
        } else if (taxType.compareToIgnoreCase("GIFT") == 0) {
            NonPeriodicAccountType nonPeriodicAccount = new NonPeriodicAccountType();
            nonPeriodicAccount.setType("GIFT");
            nonPeriodicAccount.setNumber("GFT/201");
            nonPeriodicAccount.setStatus("REG");
            nonPeriodicAccount.setBalance(BigDecimal.valueOf(3000));

            ArrayList<DocumentType> adhocDocumentList = new ArrayList<DocumentType>();

            DocumentType adhocDoc1 = new DocumentType();
            adhocDoc1.setNumber("GFT/201/D1");
            adhocDoc1.setStatus("REG");
            adhocDoc1.setBalance(BigDecimal.valueOf(2000));
            adhocDoc1.setDate(Calendar.getInstance());
            adhocDoc1.setType("GIFT TAX");
            adhocDocumentList.add(adhocDoc1);

            DocumentType adhocDoc2 = new DocumentType();
            adhocDoc2.setNumber("GFT/201/D2");
            adhocDoc2.setStatus("REG");
            adhocDoc2.setBalance(BigDecimal.valueOf(1000));
            adhocDoc2.setDate(Calendar.getInstance());
            adhocDoc2.setType("GIFT TAX");
            adhocDocumentList.add(adhocDoc2);
            nonPeriodicAccount.getDocuments().addAll(adhocDocumentList);

            accountDetails.getNonPeriodicAccounts().add(nonPeriodicAccount);
            
        } else {
            accountDetails.setHasErrors(true);
            accountDetails.setHasWarnings(true);
            accountDetails.setResultCode(ResultCodeType.FAILURE);
            accountDetails.setResultDescription("Invalid TAX Type");
        }
        
        return accountDetails;
    }
}
