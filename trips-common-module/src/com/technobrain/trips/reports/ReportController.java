package com.technobrain.trips.reports;

import com.technobrain.trips.reports.bi.XmlPublisherImpl;
import com.technobrain.trips.reports.exception.ReportException;
import com.technobrain.trips.reports.param.ParameterNameValue;
import com.technobrain.trips.reports.param.ReportDefInfo;
import com.technobrain.trips.reports.param.ReportDirectoryItem;
import com.technobrain.trips.reports.param.ReportInfo;
import com.technobrain.trips.reports.param.ReportRequestInfo;
import com.technobrain.trips.reports.param.ReportResult;
import com.technobrain.trips.reports.jasper.JasperReportImpl;
import com.technobrain.trips.reports.param.ScheduledJobHistoryInfo;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;


public abstract class ReportController {
    public static final Logger log = Logger.getLogger(ReportController.class);
    public enum TYPES{XML_PUBLISHER,JASPER};
    
    protected String userID;
    protected String userPassword;
    
    protected String webServiceEndPoint;
    
    public ReportController(String _userID, String _password, String _webServiceEndPoint){  

        this.userID = _userID;
        this.userPassword = _password;
        this.webServiceEndPoint = _webServiceEndPoint;
    }
        
    protected abstract boolean hasReportServerAccess(String userID, String password) throws ReportException;
    
    protected abstract boolean hasReportAccess(String reportAbsolutePath) throws ReportException;

    protected abstract List<ReportDirectoryItem> getDirectoryItems(String folderAbsolutePath) throws ReportException;
    
    protected abstract List<ReportDirectoryItem> getDescendantFolders(String folderAbsolutePath) throws ReportException;

    protected abstract List<ReportDirectoryItem> getDescendantReports(String folderAbsolutePath) throws ReportException;
    
    protected abstract ReportDefInfo getReportDefInfo(String reportAbsolutePath) throws ReportException;

    protected abstract ReportResult runReport(ReportRequestInfo reportRequestInfo) throws ReportException;

    protected abstract List<ParameterNameValue> getReportParameters(ReportRequestInfo reportRequest) throws ReportException;

    protected abstract String scheduleReport(ReportInfo reportInfo) throws ReportException;
    
    protected abstract ReportResult getReportData(ReportRequestInfo reportRequestInfo) throws ReportException;
    
    protected abstract ScheduledJobHistoryInfo [] retrieveScheduledReportHistoryInfo(String scheduledJobID, 
                                                    String viewByFilter, boolean downloadReport) throws ReportException;
    

    protected static ReportController getInstance(TYPES TYPE, String _userName, String _userPassword ) throws ReportException {
        
        return getInstance(TYPE,_userName, _userPassword, null);
        
    }
    
    protected static ReportController getInstance(TYPES TYPE, String _userName, String _userPassword , String _webServiceEndPoint ) throws ReportException {
                                       
            switch(TYPE){
                case XML_PUBLISHER:
                    return new XmlPublisherImpl(_userName,_userPassword,_webServiceEndPoint);
                case JASPER:
                    return new JasperReportImpl(_userName,_userPassword,_webServiceEndPoint);
                default : return null;
            }
    }
    
    protected abstract List<ReportDirectoryItem> loadReportsFromJasperServer(String absolutePath) throws ReportException;
    
    protected abstract List<ParameterNameValue> loadReportParamsFromJasperServer(String path) throws ReportException;
}
