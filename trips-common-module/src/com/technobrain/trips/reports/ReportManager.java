package com.technobrain.trips.reports;

import com.technobrain.trips.reports.conf.DeliveryConfiguration;
import com.technobrain.trips.reports.exception.ReportException;
import com.technobrain.trips.reports.param.ParameterNameValue;
import com.technobrain.trips.reports.param.ReportDefInfo;
import com.technobrain.trips.reports.param.ReportDirectoryItem;
import com.technobrain.trips.reports.param.ReportInfo;
import com.technobrain.trips.reports.param.ReportRequestInfo;
import com.technobrain.trips.reports.param.ReportResult;
import com.technobrain.trips.reports.param.ScheduleInfo;
import com.technobrain.trips.reports.param.ScheduledJobHistoryInfo;

import com.jaspersoft.jasperserver.api.metadata.xml.domain.impl.ResourceDescriptor;
import com.jaspersoft.jasperserver.irplugin.wsclient.WSClient;

import java.rmi.RemoteException;

import java.util.List;
import java.util.Map;


public class ReportManager {
    
    ReportController controller;
    
    public ReportManager(String _userName, String _userPassword) throws ReportException {
        
        //this.controller = ReportController.getInstance(ReportController.TYPES.XML_PUBLISHER,_userName,_userPassword, null);
        this.controller = ReportController.getInstance(ReportController.TYPES.JASPER,_userName,_userPassword, null);
    }

    public ReportManager(String _userName, String _userPassword, String  _serviceEndPoint) throws ReportException {
        
      //  this.controller = ReportController.getInstance(ReportController.TYPES.XML_PUBLISHER,_userName,_userPassword, _serviceEndPoint);
        this.controller = ReportController.getInstance(ReportController.TYPES.JASPER,_userName,_userPassword, _serviceEndPoint);
    }   
    
    
    /**
     * Validates if a UserID and Password have the privilege to access the report server
     * 
     * @param userID
     * @param password
     * @return
     */
    public  boolean hasReportServerAccess(java.lang.String userID, java.lang.String password) throws ReportException {
        return controller.hasReportServerAccess(userID,password);
    }
    
    /**
     * Validates that the current user has the privilege to access a specific report.
     * 
     * @param reportAbsolutePath
     * @return
     */
    public boolean hasReportAccess(String reportAbsolutePath) throws ReportException {
        
        return controller.hasReportAccess(reportAbsolutePath);
        
    }

    /**
     * Returns the contents of the folder specified by parameter
     * 
     * @param folderAbsolutePath
     * @return
     */
    public List<ReportDirectoryItem> getDirectoryItems(String folderAbsolutePath) throws ReportException {
        
        return controller.getDirectoryItems(folderAbsolutePath);
    }

    /**
     * Returns the list containing the descendant folders of the folder specified by parameter
     * 
     * 
     * @param folderAbsolutePath
     * @return
     */
    protected List<ReportDirectoryItem> getDescendantFolders(String folderAbsolutePath) throws ReportException {
        
        return controller.getDescendantFolders(folderAbsolutePath);
    }

    /**
     * Returns the list containing the reports inside the folder specified by parameter
     * 
     * @param folderAbsolutePath
     * @return
     */
    public List<ReportDirectoryItem> getDescendantReports(String folderAbsolutePath) throws ReportException {
        
        return controller.getDescendantReports(folderAbsolutePath);
    }

    /**
     * Get the information related to the report specified by the path
     * 
     * @param reportAbsolutePath
     * @return
     */
    public ReportDefInfo getReportDefinition(String reportAbsolutePath) throws ReportException {
        return controller.getReportDefInfo(reportAbsolutePath);
    } 
    
    /**
     * Runs the report with options provided
     * @param reportRequestInfo
     * @return
     * @throws ReportException
     */
    public ReportResult runReport(ReportRequestInfo reportRequestInfo) throws ReportException {
    
        return controller.runReport(reportRequestInfo);
    }
    
    /**
     * Runs the report with options provided
     * @param reportRequestInfo
     * @return
     * @throws ReportException
     */
    public ReportResult getReportData(ReportRequestInfo reportRequestInfo) throws ReportException {
          return controller.getReportData(reportRequestInfo);
    }

    /**
     * Returns the parameters of the reports according to the information given with reportRequest
     * 
     * 
     * @param reportRequestInfo
     * @return
     * @throws RemoteException
     */
    public List<ParameterNameValue> getReportParameters(ReportRequestInfo reportRequestInfo) throws ReportException{
        
        return controller.getReportParameters(reportRequestInfo);
    }

    /**
     * Schedules a report according to the information provided with the reportInfo parameter
     * 
     * @param reportInfo
     * @return Jobid for the scheduled report
     * @throws ReportException
     */
    public String scheduleReport(ReportInfo reportInfo) throws ReportException {
        return controller.scheduleReport(reportInfo);
    }
    
    public DeliveryConfiguration loadDeliveryConfiguration(String reportAbsolutePath ) {
        
        //TODO: implement
        return null;
    }

    public ScheduleInfo loadScheduleInfo(String reportAbsolutePath ) {
        
        //TODO: implement
        return null;
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
    public ScheduledJobHistoryInfo [] retrieveScheduledReportHistoryInfo(String scheduledJobID, 
                                                                      String viewByFilter, 
                                                                    boolean downloadReport) throws ReportException{
        
        return controller.retrieveScheduledReportHistoryInfo(scheduledJobID, viewByFilter, downloadReport);        
    }
    
    public List<ReportDirectoryItem>  loadReportsFromJasperServer(String absolutePath) throws ReportException{
        
        return controller.loadReportsFromJasperServer(absolutePath);  
       
    }
    
    public List<ParameterNameValue>  loadReportParamsFromJasperServer(String path) throws ReportException{
        
        return controller.loadReportParamsFromJasperServer(path);  
       
    }
 
}
