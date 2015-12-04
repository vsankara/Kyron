/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.technobrain.trips.reports.bi;

import com.technobrain.trips.reports.ReportController;
import com.technobrain.trips.reports.conf.DeliveryConfiguration;
import com.technobrain.trips.reports.conf.EMailDeliveryConfiguration;
import com.technobrain.trips.reports.conf.PrintDeliveryConfiguration;
import com.technobrain.trips.reports.exception.ReportException;
import com.technobrain.trips.reports.param.ParameterNameValue;
import com.technobrain.trips.reports.param.ReportDefInfo;
import com.technobrain.trips.reports.param.ReportDirectoryItem;
import com.technobrain.trips.reports.param.ReportInfo;
import com.technobrain.trips.reports.param.ReportRequestInfo;
import com.technobrain.trips.reports.param.ReportResult;
import com.technobrain.trips.reports.param.ScheduleInfo;
import com.technobrain.trips.reports.param.ScheduledJobHistoryInfo;
import com.technobrain.trips.reports.param.TemplateFormatsLabelValueImpl;
import com.technobrain.trips.reports.param.TemplateFormatsLabelValuesImpl;

import com.oracle.xmlns.oxp.service.PublicReportService.DeliveryRequest;
import com.oracle.xmlns.oxp.service.PublicReportService.EMailDeliveryOption;
import com.oracle.xmlns.oxp.service.PublicReportService.ItemData;
import com.oracle.xmlns.oxp.service.PublicReportService.JobHistoryInfo;
import com.oracle.xmlns.oxp.service.PublicReportService.ParamNameValue;
import com.oracle.xmlns.oxp.service.PublicReportService.PrintDeliveryOption;
import com.oracle.xmlns.oxp.service.PublicReportService.PublicReportService;
import com.oracle.xmlns.oxp.service.PublicReportService.PublicReportServiceSoapBindingStub;
import com.oracle.xmlns.oxp.service.PublicReportService.ReportDefinition;
import com.oracle.xmlns.oxp.service.PublicReportService.ReportRequest;
import com.oracle.xmlns.oxp.service.PublicReportService.ReportResponse;
import com.oracle.xmlns.oxp.service.PublicReportService.ScheduleRequest;

import com.oracle.xmlns.oxp.service.PublicReportService.TemplateFormatLabelValue;
import com.oracle.xmlns.oxp.service.PublicReportService.TemplateFormatsLabelValues;

import java.net.URL;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import java.util.Map;

import org.apache.axis.client.Service;


/**
 *
 * @author h_hill
 */
public class XmlPublisherImpl extends ReportController{

    //private static String BIP_SERVER_WS_END_POINT = "http://localhost:8888/xmlpserver/services/PublicReportService?wsdl"; 
    //private static String BIP_SERVER_WS_END_POINT = "http://trips2-accebs.cafogal.local:8888/xmlpserver/services/PublicReportService?wsdl";
     private static String BIP_SERVER_WS_END_POINT = "http://trips-reports:8888/xmlpserver/services/PublicReportService?wsdl"; 
    private static String BIP_NAMESPACE = "http://xmlns.oracle.com/oxp/service/PublicReportService";
    
    private PublicReportService bpPublicReportService; 
    
    public XmlPublisherImpl(String _userName, String _userPassword, String _webServiceEndPoint) throws ReportException{
    
        super(_userName,_userPassword ,BIP_SERVER_WS_END_POINT);
        
        if(_webServiceEndPoint == null) {
            this.webServiceEndPoint = BIP_SERVER_WS_END_POINT;
        }else{
            this.webServiceEndPoint = _webServiceEndPoint;
        }
        
         
         // set up the call object
        try {
        
            //reportService = new CustomSoapBindingSub(BIP_NAMESPACE, webServiceEndPoint);
            
            final URL bipServiceURL = new URL(webServiceEndPoint);
            
            Service service = new Service();
             
             bpPublicReportService = new PublicReportServiceSoapBindingStub(bipServiceURL,service);
             
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            ReportException reportException = new ReportException(e);
            throw reportException;
        }

    }


    /**
     * Validates if a UserID and Password have the privilege to access the report server.
     * This user may different from the current user (user kept in ReportController)
     * 
     * @param userID
     * @param userPassword
     * @return
     */
    protected boolean hasReportServerAccess(String userID, String userPassword) throws ReportException {
        try {
            boolean result = bpPublicReportService.validateLogin(userID,userPassword);
            return result;
        } catch (RemoteException e) {
            log.error(e.getLocalizedMessage(), e);
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
    protected boolean hasReportAccess(String reportAbsolutePath) throws ReportException {
        try {
           boolean result = bpPublicReportService.hasReportAccess(reportAbsolutePath,userID, userPassword);
           return result;
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            ReportException reportException = new ReportException(e);
            throw reportException;
        }
    }


    private ReportDirectoryItem convertToReportDirectoryItem(ItemData itemData) {
        ReportDirectoryItem reportDirectoryItem = new ReportDirectoryItem();
        reportDirectoryItem.setAbsolutePath(itemData.getAbsolutePath());
        
        Date creationDate = itemData.getCreationDate() == null ? itemData.getCreationDate().getTime() : null; 
        reportDirectoryItem.setCreationDate(creationDate);
        
        reportDirectoryItem.setDisplayName(itemData.getDisplayName());
        reportDirectoryItem.setFileName(itemData.getFileName());
        
        Date lastModifiedDate = itemData.getLastModified() == null ? itemData.getLastModified().getTime() : null; 
        reportDirectoryItem.setLastModified(lastModifiedDate);
        
        reportDirectoryItem.setOwner(itemData.getOwner());
        reportDirectoryItem.setParentAbsolutePath(itemData.getParentAbsolutePath());
        reportDirectoryItem.setType(itemData.getType());
        
        return reportDirectoryItem;
    }

    /**
     * Returns the contents of the folder specified by parameter
     * 
     * @param folderAbsolutePath
     * @return
     */
    protected List<ReportDirectoryItem> getDirectoryItems(String folderAbsolutePath)  throws ReportException {
        
        ItemData[] descFolderData =  getFolderContents(folderAbsolutePath);
        
        List<ReportDirectoryItem> descAllData = new ArrayList<ReportDirectoryItem>();
        
        if(descFolderData != null) {
            for(int i=0;i<descFolderData.length;i++) {
                ReportDirectoryItem reportDirectoryItem = convertToReportDirectoryItem(descFolderData[i]);
                descAllData.add(reportDirectoryItem);
            }
        }
        
        return descAllData;
    }

    private ItemData [] getFolderContents(String folderAbsolutePath)  throws ReportException {
        
        try {
            
            return bpPublicReportService.getFolderContents(folderAbsolutePath,userID,userPassword);
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            ReportException reportException = new ReportException(e);
            throw reportException;            
        }
        

    }

    /**
     * Returns the list containing the descendant folders of the folder specified by parameter
     * 
     * 
     * @param folderAbsolutePath
     * @return
     */
    protected List<ReportDirectoryItem> getDescendantFolders(String folderAbsolutePath) throws ReportException {
        
        List<ReportDirectoryItem> descFolderData = getDirectoryItems(folderAbsolutePath);
        
        List<ReportDirectoryItem> descFolders = new ArrayList<ReportDirectoryItem>();
        
        if(descFolderData != null) {
            for(ReportDirectoryItem reportDirectoryItem : descFolderData) {
                if(reportDirectoryItem.isFolder()){
                    descFolders.add(reportDirectoryItem);
                }
            }
        }
        
        return descFolders;
    }

    /**
     * Returns the list containing the reports inside the folder specified by parameter
     * 
     * @param folderAbsolutePath
     * @return
     */
    protected List<ReportDirectoryItem> getDescendantReports(String folderAbsolutePath) throws ReportException {
        
        List<ReportDirectoryItem> descFolderData = getDirectoryItems(folderAbsolutePath);
        
        List<ReportDirectoryItem> descReports = new ArrayList<ReportDirectoryItem>();
        
        if(descFolderData != null) {
            for(ReportDirectoryItem reportDirectoryItem : descFolderData) {
                if(reportDirectoryItem.isReport()){
                    descReports.add(reportDirectoryItem);
                }
            }
        }
        
        return descReports;
    }

    /**
     * Get the information related to the report specified by the path
     * 
     * @param reportAbsolutePath
     * @return
     * @throws ReportException
     */
    public ReportDefInfo getReportDefInfo(String reportAbsolutePath) throws ReportException {
        ReportDefinition  reportDefinition = getReportDefinition(reportAbsolutePath);
        return convertToReportDefInfo(reportDefinition);
         
    }
     
    private ReportDefinition getReportDefinition(String reportAbsolutePath) throws ReportException {
            
        try {
        
            return bpPublicReportService.getReportDefinition(reportAbsolutePath,userID,userPassword);
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            ReportException reportException = new ReportException(e);
            throw reportException;            
        }
    }

    private ParameterNameValue convertToParameterNameValue(ParamNameValue paramNameValue) {
        
        ParameterNameValue parameterNameValue = new ParameterNameValue();
        
        parameterNameValue.setMultiValuesAllowed(paramNameValue.isMultiValuesAllowed());
        parameterNameValue.setName(paramNameValue.getName());
        parameterNameValue.setValues(paramNameValue.getValues());
        
        return parameterNameValue;
    }

    private ParameterNameValue [] convertToParameterNameValue(ParamNameValue [] _paramNameValues) {
        if(null == _paramNameValues){
            return null;
        }else{
            ParameterNameValue[] parameterNameValues = new ParameterNameValue[_paramNameValues.length] ;
            
            for(int i=0;i< _paramNameValues.length;i++ ) {
                parameterNameValues[i] = convertToParameterNameValue(_paramNameValues[i]);
            }
            return parameterNameValues;
        }
    }
    
    private TemplateFormatsLabelValuesImpl [] convertTemplateFormatsLabelValues(TemplateFormatsLabelValues [] _templateFormatsLabelValues) {
        if(null == _templateFormatsLabelValues){
            return null;
        }else{
            TemplateFormatsLabelValuesImpl[] parameterNameValues = new TemplateFormatsLabelValuesImpl[_templateFormatsLabelValues.length] ;
            
            for(int i=0;i< _templateFormatsLabelValues.length;i++ ) {
                parameterNameValues[i] = convertToTemplateFormatsLabelValue(_templateFormatsLabelValues[i]);
            }
            return parameterNameValues;
        }
    }

    private TemplateFormatsLabelValuesImpl convertToTemplateFormatsLabelValue(TemplateFormatsLabelValues templateFormatsLabelValues) {
        
        TemplateFormatsLabelValuesImpl implValue = new TemplateFormatsLabelValuesImpl();
        implValue.setTemplateID(templateFormatsLabelValues.getTemplateID());
        implValue.setTemplateType(templateFormatsLabelValues.getTemplateType());
        implValue.setTemplateURL(templateFormatsLabelValues.getTemplateURL());
        
        TemplateFormatsLabelValueImpl valueImpl = null;
        TemplateFormatsLabelValueImpl[] valueImpls = new TemplateFormatsLabelValueImpl[templateFormatsLabelValues.getListOfTemplateFormatLabelValue().length];
        for(int i=0; i < templateFormatsLabelValues.getListOfTemplateFormatLabelValue().length; i++){
            valueImpl = new TemplateFormatsLabelValueImpl();
            valueImpl.setTemplateFormatLabel(templateFormatsLabelValues.getListOfTemplateFormatLabelValue()[i].getTemplateFormatLabel());
            valueImpl.setTemplateFormatValue(templateFormatsLabelValues.getListOfTemplateFormatLabelValue()[i].getTemplateFormatValue());
            valueImpls[i] = valueImpl;
        }
        implValue.setTemplateFormatsLabelValue(valueImpls);
        return implValue;
    }
    
    private ParamNameValue convertToParamNameValue(ParameterNameValue parameterNameValue) {
        
        ParamNameValue paramNameValue = new ParamNameValue();
        
        paramNameValue.setMultiValuesAllowed(parameterNameValue.isMultiValuesAllowed());
        paramNameValue.setName(parameterNameValue.getName());
        paramNameValue.setValues(parameterNameValue.getValues());
        
        return paramNameValue;
    }
    
    private ParamNameValue [] convertToParamNameValue(ParameterNameValue [] _parameterNameValues) {
        
        ParamNameValue[] paramNameValues = new ParamNameValue[_parameterNameValues.length] ;
        
        for(int i=0;i< _parameterNameValues.length;i++ ) {
            paramNameValues[i] = convertToParamNameValue(_parameterNameValues[i]);
        }
        
        return paramNameValues;
    }


    private ReportDefInfo convertToReportDefInfo(ReportDefinition reportDefinition) {
        
        ReportDefInfo reportDefInfo = new ReportDefInfo();
        reportDefInfo.setDefaultOutputFormat(reportDefinition.getDefaultOutputFormat());
        reportDefInfo.setDefaultTemplateId(reportDefinition.getDefaultTemplateId());
        reportDefInfo.setParameterNames(reportDefinition.getParameterNames());
        reportDefInfo.setReportParameterNameValues( convertToParameterNameValue(reportDefinition.getReportParameterNameValues()));
        reportDefInfo.setTemplateIds(reportDefinition.getTemplateIds());
        reportDefInfo.setTemplateFormatsLabelValuesImpl(convertTemplateFormatsLabelValues( reportDefinition.getListOfTemplateFormatsLabelValues()));
        
        return reportDefInfo;
    }


    private ReportRequest convertToReportRequest(ReportRequestInfo reportRequestInfo) {
        ReportRequest reportRequest = new ReportRequest();
        reportRequest.setReportAbsolutePath(reportRequestInfo.getReportAbsolutePath());
        reportRequest.setAttributeFormat(reportRequestInfo.getReportFormat());
        reportRequest.setAttributeLocale(reportRequestInfo.getReportLocale());
        reportRequest.setAttributeTemplate(reportRequestInfo.getReportTemplate());
        
        if(reportRequestInfo.getParameterNameValues() != null) {
        
            ParamNameValue[] paramNameValues = convertToParamNameValue(reportRequestInfo.getParameterNameValues());
            
            reportRequest.setParameterNameValues(paramNameValues);
        }
        
        return reportRequest;
    }

    private ReportResult convertToReportResult(ReportResponse reportResponse) {
        ReportResult reportResult =  new ReportResult();
        
        reportResult.setReportBytes(reportResponse.getReportBytes());
        reportResult.setReportContentType(reportResponse.getReportContentType());
        reportResult.setReportLocale(reportResponse.getReportLocale());
        
        return reportResult;
    }

    private ScheduleRequest converToScheduleRequest(ReportInfo reportInfo){
        ScheduleRequest scheduleRequest = new ScheduleRequest();
        
        
        fillScheduleInfo(scheduleRequest, reportInfo.getScheduleInfo());
        
        ReportRequest reportRequest = convertToReportRequest(reportInfo.getReportRequestInfo());
        scheduleRequest.setReportRequest(reportRequest);
        
        fillDeliveryConfiguration(scheduleRequest ,reportInfo.getDeliveryConfiguration());
        
        return scheduleRequest;
    }

    private void fillDeliveryConfiguration(ScheduleRequest scheduleRequest , DeliveryConfiguration deliveryConfiguration){
        
        DeliveryRequest  deliveryRequest = new DeliveryRequest();
        scheduleRequest.setDeliveryRequest(deliveryRequest);
        
        if(deliveryConfiguration instanceof PrintDeliveryConfiguration) {
            PrintDeliveryOption printDeliveryOption = convertToPrintDeliveryOption((PrintDeliveryConfiguration)deliveryConfiguration);
            deliveryRequest.setPrintOption(printDeliveryOption);
        }else if(deliveryConfiguration instanceof EMailDeliveryConfiguration) {
            EMailDeliveryOption emailDeliveryOption = convertToEmailDeliveryOption((EMailDeliveryConfiguration)deliveryConfiguration);
            deliveryRequest.setEmailOption(emailDeliveryOption);
        }else {
            //TODO: finish implementing
        }
        
        
        
    }
    
    private PrintDeliveryOption convertToPrintDeliveryOption(PrintDeliveryConfiguration printDeliveryConfiguration) {
        
        PrintDeliveryOption printDeliveryOption = new PrintDeliveryOption();
        printDeliveryOption.setPrinterName(printDeliveryConfiguration.getPrinterName());
        printDeliveryOption.setPrintNumberOfCopy(printDeliveryConfiguration.getPrintNumberOfCopy());
        printDeliveryOption.setPrintRange(printDeliveryConfiguration.getPrintRange());
        printDeliveryOption.setPrintSide(printDeliveryConfiguration.getPrintSide());
        printDeliveryOption.setPrintTray(printDeliveryConfiguration.getPrintTray());
        
        return printDeliveryOption;
        
    }
    
    
    private EMailDeliveryOption convertToEmailDeliveryOption(EMailDeliveryConfiguration emailDeliveryConfiguration) {
        
        EMailDeliveryOption emailDeliveryOption = new EMailDeliveryOption();
        emailDeliveryOption.setEmailBCC(emailDeliveryConfiguration.getEmailBCC());
        //TODO: implement
        
        return emailDeliveryOption;
        
    }
    
    private void fillScheduleInfo(ScheduleRequest scheduleRequest ,ScheduleInfo scheduleInfo){


        Calendar calendar = Calendar.getInstance();
        
        if(scheduleInfo.getEndDate() != null){
            calendar.setTime(scheduleInfo.getEndDate());
            scheduleRequest.setEndDate(calendar);
        }
    
        scheduleRequest.setJobCalendar(scheduleInfo.getJobCalendar());
        scheduleRequest.setJobLocale(scheduleInfo.getJobLocale());
        scheduleRequest.setJobTZ(scheduleInfo.getJobTZ());
        scheduleRequest.setNotificationTo(scheduleInfo.getNotificationTo());
        scheduleRequest.setNotifyWhenFailed(scheduleInfo.isNotifyWhenFailed());
        scheduleRequest.setNotifyWhenSuccess(scheduleInfo.isNotifyWhenSuccess());
        scheduleRequest.setNotifyWhenWarning(scheduleInfo.isNotifyWhenWarning());
        scheduleRequest.setRepeatCount(scheduleInfo.getRepeatCount());
        scheduleRequest.setRepeatInterval(scheduleInfo.getRepeatInterval());
        scheduleRequest.setSaveDataOption(scheduleInfo.isSaveDataOption());
        scheduleRequest.setSaveOutputOption(scheduleInfo.isSaveOutputOption());
        scheduleRequest.setScheduleBurstringOption(scheduleInfo.isScheduleBurstringOption());
        scheduleRequest.setSchedulePublicOption(scheduleInfo.isSchedulePublicOption());

        if(scheduleInfo.getStartDate() != null){
            calendar.setTime(scheduleInfo.getStartDate());
            scheduleRequest.setStartDate(calendar);
        }
        
        calendar = Calendar.getInstance();

        scheduleRequest.setUserJobName(scheduleInfo.getUserJobName());

    }

    private ScheduledJobHistoryInfo converToScheduledJobHistoryInfo(JobHistoryInfo jobHistoryInfo){
        
        ScheduledJobHistoryInfo scheduledJobHistoryInfo = new ScheduledJobHistoryInfo();
        
        Date createdDate = jobHistoryInfo.getCreatedDate() != null ? jobHistoryInfo.getCreatedDate().getTime() : null;
        scheduledJobHistoryInfo.setCreatedDate(createdDate);
        
        scheduledJobHistoryInfo.setDocumentDataAvailable(jobHistoryInfo.isDocumentDataAvailable());
        scheduledJobHistoryInfo.setDocumentDataContentType(jobHistoryInfo.getDocumentDataContentType());
        scheduledJobHistoryInfo.setDocumentOutput(jobHistoryInfo.getDocumentOutput());
        scheduledJobHistoryInfo.setJobID(jobHistoryInfo.getJobID());
        scheduledJobHistoryInfo.setJobMessage(jobHistoryInfo.getJobMessage());
        scheduledJobHistoryInfo.setJobName(jobHistoryInfo.getJobName());
        scheduledJobHistoryInfo.setOutputID(jobHistoryInfo.getOutputID());
        scheduledJobHistoryInfo.setReportData(jobHistoryInfo.getReportData());
        scheduledJobHistoryInfo.setReportDataAvailable(jobHistoryInfo.isReportDataAvailable());
        scheduledJobHistoryInfo.setReportDataContentType(jobHistoryInfo.getReportDataContentType());
        scheduledJobHistoryInfo.setReportName(jobHistoryInfo.getReportName());
        scheduledJobHistoryInfo.setReportURL(jobHistoryInfo.getReportURL());
        scheduledJobHistoryInfo.setStatus(jobHistoryInfo.getStatus());
        scheduledJobHistoryInfo.setStatusDetail(jobHistoryInfo.getStatusDetail());
        scheduledJobHistoryInfo.setUserName(jobHistoryInfo.getUsername());
        
        return scheduledJobHistoryInfo;
    }

    
    /**
     * Runs the report specified
     * 
     * @param reportRequestInfo
     * @return
     * @throws ReportException
     */
    public ReportResult runReport(ReportRequestInfo reportRequestInfo) throws ReportException {
    
        ReportRequest reportRequest = convertToReportRequest(reportRequestInfo);
        
        ReportResponse reportResponse = runReport(reportRequest);
        
        ReportResult reportResult = convertToReportResult(reportResponse);
    
        return reportResult;
    }
    
    private ReportResponse runReport(ReportRequest reportRequest) throws ReportException {

        try {
            //Retrieve all the report data by setting "-1" 
            reportRequest.setSizeOfDataChunkDownload(-1);
            ReportResponse reportResponse = bpPublicReportService.runReport(reportRequest,userID,userPassword);
            
            return reportResponse;
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            ReportException reportException = new ReportException(e);
            throw reportException;           
        }
    }
    
    
    /**
     * Runs the report specified
     * 
     * @param reportRequestInfo
     * @return
     * @throws ReportException
     */
    public ReportResult getReportData(ReportRequestInfo reportRequestInfo) throws ReportException {
    
        ReportRequest reportRequest = convertToReportRequest(reportRequestInfo);
        
        ReportResponse reportResponse = runReport(reportRequest);
        
        ReportResult reportResult = convertToReportResult(reportResponse);
    
        return reportResult;
    }
    
    private ReportResponse getReportData(ReportRequest reportRequest) throws ReportException {

        try {
            //Retrieve all the report data by setting "-1" 
            reportRequest.setSizeOfDataChunkDownload(-1);
            ReportResponse reportResponse = bpPublicReportService.runReport(reportRequest,userID,userPassword);
            
            return reportResponse;
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            ReportException reportException = new ReportException(e);
            throw reportException;           
        }
    }
    

    /**
     * Returns the parameters of the reports according to the information given with reportRequest
     * 
     * 
     * @param _reportRequestInfo
     * @return
     * @throws ReportException
     */
     public List<ParameterNameValue> getReportParameters(ReportRequestInfo _reportRequestInfo) throws ReportException {
     
         ReportRequest reportRequest = convertToReportRequest(_reportRequestInfo);
         
         ParamNameValue params [] = getReportParameters(reportRequest);
         
         List<ParameterNameValue>  parameterNameValues = new ArrayList<ParameterNameValue>();
         
         for(int i=0;i<params.length;i++) {
             ParameterNameValue parameterNameValue = convertToParameterNameValue(params [i]);
             parameterNameValues.add(parameterNameValue);
         }
         
        return parameterNameValues;
     }
     
    private ParamNameValue[] getReportParameters(ReportRequest reportRequest) throws ReportException {
        
        try {
            ParamNameValue params [] = bpPublicReportService.getReportParameters(reportRequest, userID, userPassword);
            
            return params;
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            ReportException reportException = new ReportException(e);
            throw reportException;              
        }
    }

    /**
     * Schedules reports according to the parameters
     * This operation returns JobID upon successfully scheduling the report job
     * 
     * @param reportInfo
     * @return
     * @throws ReportException
     */
    public String scheduleReport(ReportInfo reportInfo) throws ReportException {
    
        ScheduleRequest scheduleRequest = converToScheduleRequest(reportInfo);
        return scheduleReport(scheduleRequest);
    }
    
    private String scheduleReport(ScheduleRequest scheduleRequest) throws ReportException{

        try {

             // issue the request
             String result = bpPublicReportService.scheduleReport(scheduleRequest, userID, userPassword);
             
             return result;
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            ReportException reportException = new ReportException(e);
            throw reportException;                
        }
         
    }

    /**
     * Retirieves historical information about a scheduled report. 
     * Return object contains all the related information including repor result, report result data etc. 
     * 
     * @param scheduledJobID  The job ID of the scheduled report.A selected "view by" category.
     * @param viewByFilter   Valid values are: ScheduledJobHistoryInfo.VIEWBYFILTER_ALL, 
     *                        ScheduledJobHistoryInfo.VIEWBYFILTER_PUBLICHISTORY, or 
     *                        ScheduledJobHistoryInfo.VIEWBYFILTER_MYHISTORY
     * @param downloadReport True indicates to download the report.
     * @return
     * @throws ReportException
     */
    public ScheduledJobHistoryInfo [] retrieveScheduledReportHistoryInfo(String scheduledJobID, String viewByFilter, boolean downloadReport) throws ReportException {
    
        JobHistoryInfo  []  scheduledReportHistories =  getScheduledReportHistoryInfo(scheduledJobID, viewByFilter, downloadReport);
        
        if(scheduledReportHistories != null){
            ScheduledJobHistoryInfo [] scheduledJobHistoryInfos = new ScheduledJobHistoryInfo[scheduledReportHistories.length];
            
           
            for( int i=0;i<scheduledReportHistories.length;i++){
                ScheduledJobHistoryInfo scheduledJobHistoryInfo =  converToScheduledJobHistoryInfo(scheduledReportHistories[i]);
                scheduledJobHistoryInfos[i] = scheduledJobHistoryInfo;
            }
        
            return scheduledJobHistoryInfos;
        }
        
        return null;
    }
    
    private JobHistoryInfo  []  getScheduledReportHistoryInfo(String scheduledJobID, String viewByFilter, boolean downloadReport) throws ReportException{

        try {
             // issue the request
             JobHistoryInfo [] result = bpPublicReportService.getScheduledReportHistoryInfo(scheduledJobID,userID,userPassword,viewByFilter,downloadReport);
             
             return result;
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            ReportException reportException = new ReportException(e);
            throw reportException;                
        }
         
    }

    protected List<ReportDirectoryItem> loadReportsFromJasperServer(String path) {
        return Collections.EMPTY_LIST;
    }

    protected List loadReportParamsFromJasperServer(String path) {
        return Collections.EMPTY_LIST;
    }
}
