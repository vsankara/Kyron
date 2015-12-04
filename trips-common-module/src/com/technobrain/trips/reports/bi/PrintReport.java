/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technobrain.trips.reports.bi;

/*
import com.oracle.xmlns.oxp.service.PublicReportService.DeliveryRequest;
import com.oracle.xmlns.oxp.service.PublicReportService.EMailDeliveryOption;
import com.oracle.xmlns.oxp.service.PublicReportService.ParamNameValue;
import com.oracle.xmlns.oxp.service.PublicReportService.PrintDeliveryOption;
import com.oracle.xmlns.oxp.service.PublicReportService.ReportRequest;
import com.oracle.xmlns.oxp.service.PublicReportService.ReportResponse;
import com.oracle.xmlns.oxp.service.PublicReportService.ScheduleRequest;

*/

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;


/**
 *
 * @author h_hill
 */
public class PrintReport {

    public static void scheduleReport(String server) throws Exception {
        
        /*
        String serverAndPort = server;
        log.debug("serverAndPort " + serverAndPort);
        final String bipEndpoint = 
            serverAndPort + "/xmlpserver/services/PublicReportService?wsdl";
        final String bipNamespace = 
            "http://xmlns.oracle.com/oxp/service/PublicReportService";
        final String xdofile = "/GUI Page Field List/GUI Page Field List.xdo";

        // set up the call object
        Service service = new Service();
        Call call = (Call)service.createCall();
        call.setTargetEndpointAddress(new URL(bipEndpoint));
        // TEST Run Report
        log.debug("TESTING scheduleReport Service BEGIN");
        // register the ReportRequest class
        QName reportReq = new QName(bipNamespace, "ReportRequest");
        call.registerTypeMapping(ReportRequest.class, reportReq, 
                                 BeanSerializerFactory.class, 
                                 BeanDeserializerFactory.class);
        // register the ParamNameValue class
        QName nmvals = new QName(bipNamespace, "ParamNameValue");
        call.registerTypeMapping(ParamNameValue.class, nmvals, 
                                 BeanSerializerFactory.class, 
                                 BeanDeserializerFactory.class);
        // register the BIPReportResponse class (part of Schedule Request)
        QName reportRespqn = new QName(bipNamespace, "ReportResponse");
        call.registerTypeMapping(ReportResponse.class, reportRespqn, 
                                 BeanSerializerFactory.class, 
                                 BeanDeserializerFactory.class);
        // register the Schedule Request class
        QName scheduleReq = new QName(bipNamespace, "ScheduleRequest");
        call.registerTypeMapping(ReportRequest.class, reportReq, 
                                 BeanSerializerFactory.class, 
                                 BeanDeserializerFactory.class);
        // Default return type based on what we expect
        call.setOperationName(new QName(bipNamespace, "scheduleReport"));
        call.addParameter("ScheduleRequest", scheduleReq, ParameterMode.IN);
        call.addParameter("userID", XMLType.XSD_STRING, ParameterMode.IN);
        call.addParameter("password", XMLType.XSD_STRING, ParameterMode.IN);
        call.setReturnType(XMLType.XSD_STRING);
        // Define Report Request Object
        ParamNameValue[] paramNmVals = new ParamNameValue[2];
        //        paramNmVals[0] = new ParamNameValue(false, "dept", null);
        //        paramNmVals[1] = new ParamNameValue(false, "emp", new String[]{"*"});
        ReportRequest report = 
            new ReportRequest("pdf", "en-US", "Simple", null, xdofile);

        // ipp://myhost:631/printers/myprinter
        String p = "HPLJ4250DTN_PFMIT";
        PrintDeliveryOption print = 
            new PrintDeliveryOption("1", "1", null, null, p);
        // Define only email delivery
        DeliveryRequest delivery = 
            new DeliveryRequest(null, null, null, null, print, null);
        ScheduleRequest req = // delivery options
            // enddate (Calendar.getInstance())
            // job calendar
            // job locale, timezone
            // notifications
            // repeat count, repeat interval
            // Report and Parameters
            // Save Data, Save Output
            // Bursting, Public
            // start date
            // Use UTF-8
            // job name                
            new ScheduleRequest(delivery, null, null, "en-US", null, null, 
                                false, false, false, 1, 1, report, true, true, 
                                false, true, null, true, 
                                "GUI Page Field List - via java");

        // issue the request
        String result = 
            (String)call.invoke(new Object[] { req, "trips", "trips" });
        */
    }
}
