package com.technobrain.trips.reports.bi;

import com.technobrain.trips.reports.exception.ReportException;

import com.oracle.xmlns.oxp.service.PublicReportService.*;

import java.net.MalformedURLException;
import java.net.URL;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.log4j.Logger;

public class CustomSoapBindingSub {
    static final Logger log = Logger.getLogger(CustomSoapBindingSub.class);

    private Call call;
    
    private String BIP_NAMESPACE;
    private String webServiceEndPoint;
    
    
    public CustomSoapBindingSub(String _bipNameSpace, String _webServiceEndPoint) throws ReportException {
        BIP_NAMESPACE = _bipNameSpace;
        webServiceEndPoint = _webServiceEndPoint;
        
        initCall();
    }

    private void initOperation() throws ReportException {
        
        //clear call so that a new operation can be executed
        call.clearOperation();
    }

    private void initCall() throws ReportException {
        try {
            // set up the call object
            Service service = new Service();
            call = (Call) service.createCall();
            call.setTargetEndpointAddress(new URL(webServiceEndPoint));

            //Register type mappings
            
            // register the ItemData class
            QName itemData = new QName(BIP_NAMESPACE, "ItemData");
            call.registerTypeMapping(ItemData.class, itemData, BeanSerializerFactory.class, BeanDeserializerFactory.class);
            // register the ParamNameValue class
            QName nmvals = new QName(BIP_NAMESPACE, "ParamNameValue");
            call.registerTypeMapping(ParamNameValue.class, nmvals, BeanSerializerFactory.class, BeanDeserializerFactory.class);

            // register the ReportDefinition class
            QName reportDef = new QName(BIP_NAMESPACE, "ReportDefinition");
            call.registerTypeMapping(ReportDefinition.class, reportDef,
            BeanSerializerFactory.class, BeanDeserializerFactory.class);
            
            // register the ReportRequest class
            QName reportReq = new QName(BIP_NAMESPACE, "ReportRequest");
            call.registerTypeMapping(ReportRequest.class, reportReq, BeanSerializerFactory.class, BeanDeserializerFactory.class);
            
            // register the BIPReportResponse class
            QName reportRespqn = new QName(BIP_NAMESPACE, "ReportResponse");
            call.registerTypeMapping(ReportResponse.class, reportRespqn, BeanSerializerFactory.class, BeanDeserializerFactory.class);
            
            // register the Schedule Request class
            QName scheduleReq = new QName(BIP_NAMESPACE, "ScheduleRequest");
            call.registerTypeMapping(ScheduleRequest.class, scheduleReq, BeanSerializerFactory.class, BeanDeserializerFactory.class);
            
            // register the Delivery Request class
            QName deliveryReq = new QName(BIP_NAMESPACE, "DeliveryRequest");
            call.registerTypeMapping(DeliveryRequest.class, deliveryReq, BeanSerializerFactory.class, BeanDeserializerFactory.class);

            // register the PrintDeliveryOption class
            QName printDeliveryOption = new QName(BIP_NAMESPACE, "PrintDeliveryOption");
            call.registerTypeMapping(PrintDeliveryOption.class, printDeliveryOption, BeanSerializerFactory.class, BeanDeserializerFactory.class);

            // register the JobHistoryInfo class
            QName jobHistoryInfo = new QName(BIP_NAMESPACE, "JobHistoryInfo");
            call.registerTypeMapping(JobHistoryInfo.class, jobHistoryInfo, BeanSerializerFactory.class, BeanDeserializerFactory.class);

            // register the JobInfo class
            QName jobInfo = new QName(BIP_NAMESPACE, "JobInfo");
            call.registerTypeMapping(JobInfo.class, jobInfo, BeanSerializerFactory.class, BeanDeserializerFactory.class);

            // register the JobInfo class
            QName jobStatus = new QName(BIP_NAMESPACE, "JobStatus");
            call.registerTypeMapping(JobStatus.class, jobStatus, BeanSerializerFactory.class, BeanDeserializerFactory.class);

            
            
            //TODO: Register new type mappings
            

        }
        catch (MalformedURLException e) {
            ReportException reportException = new ReportException(e);
            throw reportException;
        }
        catch (ServiceException e) {
            ReportException reportException = new ReportException(e);
            throw reportException;
        }        
    }
    

    public boolean hasReportServerAccess(String userID, String userPassword) throws ReportException {
        try {
            initOperation();
            call.setOperationName(new QName(BIP_NAMESPACE, "validateLogin"));
            call.addParameter("userID", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("password", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.XSD_BOOLEAN);
            // issue the request
            Boolean hasAccess = (Boolean) call.invoke( new Object[] {userID, userPassword});
            return hasAccess;
            
        } catch (RemoteException e) {
            ReportException reportException = new ReportException(e);
            throw reportException;
        }
    }

    /**
     * Validates that the current user has the privilege to access a specific report.
     * 
     * @param reportAbsolutePath
     * @return
     */
    public boolean hasReportAccess(String reportAbsolutePath, String userID, String userPassword) throws ReportException {
        try {
            initOperation();
            call.setOperationName(new QName(BIP_NAMESPACE, "hasReportAccess"));
            call.addParameter("reportAbsolutePath", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("userID", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("password", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.XSD_BOOLEAN);
            
            // issue the request
            Boolean hasAccess = (Boolean) call.invoke( new Object[] {reportAbsolutePath, userID, userPassword});
            return hasAccess;
        }
        catch (RemoteException e) {
            ReportException reportException = new ReportException(e);
            throw reportException;
        }
    }




    public ItemData [] getFolderContents(String folderAbsolutePath ,String userID, String userPassword)  throws ReportException {
        
        try {

            initOperation();
            
            call.setOperationName(new QName(BIP_NAMESPACE, "getFolderContents"));
            call.addParameter("reportAbsolutePath", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("userID", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("password", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnClass(ItemData[].class);
            // issue the request
            ItemData [] descFolderData = (ItemData []) call.invoke( new Object[] { folderAbsolutePath, userID, userPassword});
            
            if(descFolderData!=null){
                for (int i=0; i<descFolderData.length; i++) {
                    log.debug(descFolderData[i].getDisplayName());
                }
            }
            
            log.debug("Success for GetFolderContent");
            
            return descFolderData;
        }
        catch (RemoteException e) {
            ReportException reportException = new ReportException(e);
            throw reportException;            
        }
        

    }


    public ReportDefinition getReportDefinition(String reportAbsolutePath,String userID, String userPassword) throws ReportException {
            
        try {
            initOperation();
            log.debug("BEGIN TESTING getReportDefinition");

            call.setOperationName(new QName(BIP_NAMESPACE, "getReportDefinition"));
            call.addParameter("reportAbsolutePath", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("userID", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("password", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnClass(ReportDefinition.class);
            // issue the request
            ReportDefinition reportDefn = (ReportDefinition) call.invoke( new Object[] { reportAbsolutePath, userID, userPassword});
            
            return reportDefn;
        }
        catch (RemoteException e) {
            ReportException reportException = new ReportException(e);
            throw reportException;            
        }
    }
    
    public ReportResponse runReport(ReportRequest reportRequest, String userID, String userPassword) throws ReportException {

        try {
            initOperation();

            QName reportReq = new QName(BIP_NAMESPACE, "ReportRequest");
            
            // Default return type based on what we expect
            call.setOperationName( new QName(BIP_NAMESPACE, "runReport" ));
            call.addParameter("ReportRequest", reportReq, ParameterMode.IN );
            call.addParameter("userID", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("password", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnClass(ReportResponse.class);
            // issue the reques
            ReportResponse reportResponse = (ReportResponse) call.invoke(new Object[] {reportRequest, userID, userPassword} );
            
            return reportResponse;
        }
        catch (RemoteException e) {
            ReportException reportException = new ReportException(e);
            throw reportException;           
        }
    }


    public ParamNameValue[] getReportParameters(ReportRequest reportRequest, String userID, String userPassword) throws ReportException {
        
        try {
            initOperation();
            
            QName reportReq = new QName(BIP_NAMESPACE, "ReportRequest");

            call.setOperationName(new QName(BIP_NAMESPACE, "getReportParameters"));
            call.addParameter( "ReportRequest", reportReq, ParameterMode.IN );
            call.addParameter("userID", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("password", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnClass(ParamNameValue [].class);
            // issue the request
            ParamNameValue params [] = (ParamNameValue []) call.invoke( new Object[] { reportRequest, userID,userPassword});
            return params;
        }
        catch (RemoteException e) {
            ReportException reportException = new ReportException(e);
            throw reportException;              
        }
    }

    public String scheduleReport(ScheduleRequest scheduleRequest, String userID, String userPassword) throws ReportException{

        try {
            initOperation();

            QName scheduleReq = new QName(BIP_NAMESPACE, "ScheduleRequest");
            // Default return type based on what we expect
            call.setOperationName( new QName(BIP_NAMESPACE, "scheduleReport" ));
            call.addParameter( "ScheduleRequest", scheduleReq, ParameterMode.IN );
            call.addParameter("userID", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("password", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.XSD_STRING);
     
            // Define only email delivery
            //DeliveryRequest delivery = new DeliveryRequest(email, null, null, null, null, null);
        
     
             // issue the request
             String result = (String) call.invoke( new Object[] {scheduleRequest,userID,userPassword} );
             
             return result;
        }
        catch (RemoteException e) {
            ReportException reportException = new ReportException(e);
            throw reportException;                
        }
         
    }


    public JobHistoryInfo getScheduledReportHistoryInfo(String scheduledJobID, String viewByFilter, boolean downloadReport,String userID, String userPassword) throws ReportException{

        try {
            initOperation();

            call.setOperationName( new QName(BIP_NAMESPACE, "getScheduledReportHistoryInfo" ));
            
            call.addParameter("scheduledJobID", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("userID", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("password", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("viewByFilter", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("downloadReport", XMLType.XSD_BOOLEAN, ParameterMode.IN);
            
            call.setReturnClass(JobHistoryInfo.class);
     
        
     
             // issue the request
             JobHistoryInfo result = (JobHistoryInfo) call.invoke( new Object[] {scheduledJobID,userID,userPassword,viewByFilter,downloadReport} );
             
             return result;
        }
        catch (RemoteException e) {
            ReportException reportException = new ReportException(e);
            throw reportException;                
        }
         
    }    



}
