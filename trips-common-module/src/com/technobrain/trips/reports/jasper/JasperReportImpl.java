package com.technobrain.trips.reports.jasper;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.StringHelper;
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

import com.jaspersoft.jasperserver.api.metadata.xml.domain.impl.ResourceDescriptor;
import com.jaspersoft.jasperserver.api.metadata.xml.domain.impl.ResourceProperty;
import com.jaspersoft.jasperserver.irplugin.JServer;
import com.jaspersoft.jasperserver.irplugin.wsclient.WSClient;

import com.oracle.xmlns.oxp.service.PublicReportService.DeliveryRequest;
import com.oracle.xmlns.oxp.service.PublicReportService.EMailDeliveryOption;
import com.oracle.xmlns.oxp.service.PublicReportService.ParamNameValue;
import com.oracle.xmlns.oxp.service.PublicReportService.PrintDeliveryOption;
import com.oracle.xmlns.oxp.service.PublicReportService.PublicReportService;
import com.oracle.xmlns.oxp.service.PublicReportService.ReportRequest;
import com.oracle.xmlns.oxp.service.PublicReportService.ScheduleRequest;

import java.io.ByteArrayOutputStream;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;


/**
 *
 * @author 
 */
public class JasperReportImpl extends ReportController {

    //public static final String JASPER_WS_END_POINT="http://trips-reports:8080/jasperserver-pro/services/repository?wsdl";
    // TODO update to actual Jasper Server end point - having problems using "trips-reports" (even if updated in host file)
    public static final String JASPER_WS_END_POINT="http://trips-reports:8080/jasperserver-pro/services/repository?wsdl";        
    private JServer server= null;
    private PublicReportService bpPublicReportService; 
    /**
     * Constructor for the class
     * 
     * @param _userName
     * @param _userPassword
     * @param _webServiceEndPoint
     * @throws ReportException
     */
     
    public JasperReportImpl(String _userName, String _userPassword, String _webServiceEndPoint) throws ReportException{
        super(_userName,_userPassword,JASPER_WS_END_POINT);
        try {
            
            if(_webServiceEndPoint == null) {
                this.webServiceEndPoint = JASPER_WS_END_POINT;
            } else {
                this.webServiceEndPoint = _webServiceEndPoint;
            }
            server = new JServer();
            server.setUsername(_userName);            server.setPassword(_userPassword);
            server.setUrl(webServiceEndPoint);
        } catch(Exception e) {
            log.error(e.getLocalizedMessage(), e);
            ReportException reportException = new ReportException(e);
            throw reportException;            
        }
        
        // set up the call object
//        try {
//        
//           //reportService = new CustomSoapBindingSub(BIP_NAMESPACE, webServiceEndPoint);
//           
//           final URL bipServiceURL = new URL(webServiceEndPoint);
//           
//           Service service = new Service();
//            
//            bpPublicReportService = new PublicReportServiceSoapBindingStub(bipServiceURL,service);
//            
//        } catch (Exception e) {
//           log.error(e.getLocalizedMessage(), e);
//           ReportException reportException = new ReportException(e);
//           throw reportException;
//        }
    } //end of constructor
    
    /**
     * 
     * @param userID
     * @param password
     * @return
     */
    protected boolean hasReportServerAccess(String userID, String password) {
        return true;
    }
    
    /**
     * 
     * @param reportAbsolutePath
     * @return
     */
    protected boolean hasReportAccess(String reportAbsolutePath) {
        return true;
    }
    
    /**
     * This method returns all the reports in a given directory
     * 
     * @param folderAbsolutePath
     * @return
     */
    protected List<ReportDirectoryItem> getDirectoryItems(String folderAbsolutePath) throws ReportException {
        List<ReportDirectoryItem> dirList = null; 
        
        try {
            dirList = new ArrayList<ReportDirectoryItem>();
            ResourceDescriptor rd = new ResourceDescriptor();
            ReportDirectoryItem directoryItem = null;
            rd.setWsType( ResourceDescriptor.TYPE_FOLDER);
            rd.setUriString(folderAbsolutePath);
            WSClient wsClient = server.getWSClient();            
            List l = wsClient.list(rd);
            for(int i = 0; i < l.size();i++) {
                ResourceDescriptor rdRecd = (ResourceDescriptor) l.get(i);
                directoryItem = new ReportDirectoryItem();
                directoryItem.setAbsolutePath(rdRecd.getUriString());
                if(rdRecd.getLabel() == null) {
                   directoryItem.setDisplayName(rdRecd.getName());
                   log.debug(rdRecd.getName());
                } else {
                   directoryItem.setDisplayName(rdRecd.getLabel());
                }
                directoryItem.setFileName(rdRecd.getName());
                directoryItem.setParentAbsolutePath(rdRecd.getParentFolder());
                directoryItem.setType(ReportDirectoryItem.DIRECTORYITEM_REPORT);
                directoryItem.setCreationDate(rdRecd.getCreationDate());
                dirList.add(directoryItem);
            }
        }
        catch (Exception exp) {
            log.error(exp.getLocalizedMessage(), exp);
            ReportException exception = new ReportException(exp);
            throw exception;
        }
        return dirList;
    }
    
    /**
     * 
     * @param folderAbsolutePath
     * @return
     */
    protected List<ReportDirectoryItem> getDescendantFolders(String folderAbsolutePath) {
        return null;
    }
    
    /**
     * 
     * @param folderAbsolutePath
     * @return
     */
    protected List<ReportDirectoryItem> getDescendantReports(String folderAbsolutePath) {
        return null;
    }

    /**
     * Gets the report parameters and set the ReportDefInfo object with the 
     * parameters of the report.
     * 
     * @param reportAbsolutePath
     * @return defInfo
     */
    protected ReportDefInfo getReportDefInfo(String reportAbsolutePath) throws ReportException {
        ReportDefInfo defInfo = null;
        
        try {
            ReportRequestInfo requestInfo = null;
            
            requestInfo = new ReportRequestInfo();
            requestInfo.setReportAbsolutePath(reportAbsolutePath);
           //get the report parameters to a list
            ArrayList parameters = (ArrayList) getReportParameters(requestInfo);
            if(parameters != null) {
                String name[] = new String[parameters.size()];
                String label[] = new String[parameters.size()];
                String controlType[] = new String[parameters.size()];
                String mandatory[] = new String[parameters.size()];
                defInfo = new ReportDefInfo();
                ParameterNameValue[] paramNameVal = new ParameterNameValue[parameters.size()];
                for(int i = 0; i < parameters.size(); i++) {
                    ParameterNameValue paramVal = (ParameterNameValue) parameters.get(i);
                    name[i] = paramVal.getName();
                    label[i] = paramVal.getLabel();
                    controlType[i] = paramVal.getControlType();
                    mandatory[i] = paramVal.getMandatory();
                    defInfo.setParameterNames(name);
                    paramNameVal[i] = new ParameterNameValue();
                    paramNameVal[i].setName(name[i]);
                    paramNameVal[i].setLabel(label[i]);
                    paramNameVal[i].setValues(null);
                    paramNameVal[i].setControlType(controlType[i]);
                    paramNameVal[i].setMandatory(mandatory[i]);
                }
                defInfo.setReportParameterNameValues(paramNameVal);
            }
        }
        catch (Exception exp) {
            log.error(exp.getLocalizedMessage(), exp);
            ReportException exception = new ReportException(exp);
            throw exception;
        }
        return defInfo;
    }
    
    /**
     * This method runs the requested report on the JasperServer and returns a 
     * ReportResult object
     * 
     * @param reportRequestInfo
     * @return
     */
    protected ReportResult runReport(ReportRequestInfo reportRequestInfo) throws ReportException{
        ReportResult result = null;
        String contentType = null;
        
        try {
            ResourceDescriptor rdis = new ResourceDescriptor();
            WSClient wsClient;
              wsClient = server.getWSClient();
              net.sf.jasperreports.engine.JRExporter exporter=null;
            byte [] b = null;
            
            rdis.setWsType(ResourceDescriptor.TYPE_REPORTUNIT);
            rdis.setUriString(reportRequestInfo.getReportAbsolutePath());
            //convert the parameters into Hashmap as required for Jasper            
            ParameterNameValue params[] = reportRequestInfo.getParameterNameValues();
            HashMap datamap = new HashMap();

            if (params != null) {
                for(int i = 0; i < params.length;i++) {
                    String name = params[i].getName();
                    String values[] = params[i].getValues();
                    String value = null;
                    for(int j = 0; j < values.length; j++) {
                        value = values[j];
                    }
                    datamap.put(name,value);
                }
            }
            wsClient = server.getWSClient();
            // This code added for to clear empty string of StarDate Enddate values from Reportdetails screen
            if(datamap.keySet().contains(Constants.StartDate)) {
                String startDateValue = (String)datamap.get(Constants.StartDate);
                if(StringHelper.isNullOrEmptyString(startDateValue))
                    datamap.remove(Constants.StartDate);
            }
            if(datamap.keySet().contains(Constants.EndDate)) {
                String endDateValue = (String)datamap.get(Constants.EndDate);
                if(StringHelper.isNullOrEmptyString(endDateValue))
                    datamap.remove(Constants.EndDate);
            }
            if(datamap.keySet().contains(Constants.FILE_ID)){
                String FeiledId = (String)datamap.get(Constants.FILE_ID);
                if(StringHelper.isNullOrEmptyString(FeiledId))
                    datamap.remove(Constants.FILE_ID);
            }
            JasperPrint reportData = wsClient.runReport(rdis,datamap);
            //determine whether the request originates from GUI or Web Service call            
             
             b = JasperExportManager.exportReportToPdf(reportData);
             contentType = Constants.ContentType.APPLICATION_PDF;
            if(b != null) {
                result = new ReportResult();
                result.setReportName(reportRequestInfo.getReportName());
                result.setReportContentType(contentType);
                result.setReportBytes(b);
                result.setNoOfCopies(reportRequestInfo.getNoOfCopies());
            }

            if (reportRequestInfo.getReportSource().equalsIgnoreCase("GUI")) {
                if(reportRequestInfo.getReportFormat().equalsIgnoreCase(Constants.ReportFormat.HTML)) {
                    // export to HTML
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    exporter = new  net.sf.jasperreports.engine.export.JRHtmlExporter();
                    exporter.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, bos);
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT,reportData);
                    exporter.exportReport();
                    contentType = Constants.ContentType.APPLICATION_HTML;
                    b = bos.toByteArray();
                }
                else if(reportRequestInfo.getReportFormat().equalsIgnoreCase(Constants.ReportFormat.PDF)) {
                    b = JasperExportManager.exportReportToPdf(reportData);
                    contentType = Constants.ContentType.APPLICATION_PDF;
                } else if(reportRequestInfo.getReportFormat().equalsIgnoreCase(Constants.ReportFormat.EXCEL)){
                    exporter = new  net.sf.jasperreports.engine.export.JExcelApiExporter();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, bos);
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT,reportData);
                    exporter.exportReport();
                    contentType = Constants.ContentType.APPLICATION_EXCEL;
                    b = bos.toByteArray();
                } else if(reportRequestInfo.getReportFormat().equalsIgnoreCase(Constants.ReportFormat.RTF)){
                    exporter = new  net.sf.jasperreports.engine.export.JRRtfExporter();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    exporter.setParameter(JRTextExporterParameter.OUTPUT_STREAM, bos);
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT,reportData);
                    exporter.exportReport();
                    contentType = Constants.ContentType.APPLICATION_RTF;
                    b = bos.toByteArray();
                }
                if(b != null) {
                    result = new ReportResult();
                    result.setReportName(reportRequestInfo.getReportName());
                    result.setReportContentType(contentType);
                    result.setReportBytes(b);
                }
            }
            //report request came from web service
            else {
                //lookup for printer 
                PrintService[] pservices =
                                     PrintServiceLookup.lookupPrintServices(null, null);
                PrintService printService = null;
                //assign the PrintService based on configuration 
                for(PrintService ps : pservices) {
             //   log.debug("************** ps.getName() - "+ps.getName() + "---reportRequestInfo.getPrinterName()---" + reportRequestInfo.getPrinterName());
              if ((!StringHelper.isNullOrEmptyString(ps.getName())) && 
                    ps.getName().equalsIgnoreCase(reportRequestInfo.getPrinterName())) {
                                   printService = ps;
                                    break;
                      }
                            }
              //  set the parameters and invoke the Jasper API to print
               if(printService!=null){ 
               PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
                printRequestAttributeSet.add(new Copies(1));
                JRPrintServiceExporter pservexporter = new JRPrintServiceExporter();
                pservexporter.setParameter(JRExporterParameter.JASPER_PRINT,reportData);
                pservexporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE,printService); 
                pservexporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE); 
                pservexporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
                pservexporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
               try {
                    pservexporter.exportReport();
                } catch (JRException e) {
                   log.error(e.getLocalizedMessage(), e);
                }
               if(b != null) { 
               result = new ReportResult();
               result.setReportName(reportRequestInfo.getReportName());
               result.setReportContentType(contentType);
               result.setReportStatus(Constants.PASS);
               result.setNoOfCopies(reportRequestInfo.getNoOfCopies());
               result.setReportBytes(b);
                  }
              }else{  
//                    result = new ReportResult();
//                    result.setReportName(reportRequestInfo.getReportName());
//                    result.setReportContentType(contentType);
                     result.setReportStatus(Constants.FAIL);
                   }                       
                // 09/05/2011 - for testing, remove once done 
//                JasperExportManager.exportReportToPdfFile(reportData, "C:\\JarperReports\\" 
//                    + Calendar.getInstance().getTimeInMillis() + "_" + result.getReportName() + "_" + "_Reports.pdf");
           }
        }
         catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            result.setReportStatus(Constants.FAIL);
            return result;
        }
        return result;
    }
    /**
     * This method runs the requested report on the JasperServer and returns a 
     * ReportResult object
     * 
     * @param reportRequestInfo
     * @return
     */
    protected ReportResult getReportData(ReportRequestInfo reportRequestInfo) throws ReportException{
        ReportResult result = new ReportResult();
        String contentType = null;
        try {
            ResourceDescriptor rdis = new ResourceDescriptor();
            WSClient wsClient;
              wsClient = server.getWSClient();
              net.sf.jasperreports.engine.JRExporter exporter=null;
            byte [] b = null;
            rdis.setWsType(ResourceDescriptor.TYPE_REPORTUNIT);
            rdis.setUriString(reportRequestInfo.getReportAbsolutePath());
            //convert the parameters into Hashmap as required for Jasper            
            ParameterNameValue params[] = reportRequestInfo.getParameterNameValues();
            HashMap datamap = new HashMap();
            if (params != null) {
                for(int i = 0; i < params.length;i++) {
                    String name = params[i].getName();
                    String values[] = params[i].getValues();
                    String value = null;
                    for(int j = 0; j < values.length; j++) {
                        value = values[j];
                    }
                    datamap.put(name,value);
                }
            }
            wsClient = server.getWSClient();
            // This code added for to clear empty string of StarDate Enddate values from Reportdetails screen
            JasperPrint reportData = wsClient.runReport(rdis,datamap);
            //determine whether the request originates from GUI or Web Service call            
            b = JasperExportManager.exportReportToPdf(reportData);
             contentType = Constants.ContentType.APPLICATION_PDF;
            if(b != null) {
                
                result.setReportName(reportRequestInfo.getReportName());
                result.setReportContentType(contentType);
                result.setReportBytes(b);
                result.setNoOfCopies(reportRequestInfo.getNoOfCopies());
                result.setReportStatus(Constants.PASS);
            }
           }catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            result.setReportStatus(Constants.FAIL);
            return result;
        }
        return result;
    }
    
    
    
    /**
     * This method returns the report parameters of the report requested for. 
     * All the parameters will be defaulted to text input types and not to the 
     * exact speciality inout types like check boxes, drop down, date objects 
     * etc
     * 
     * @param reportRequest
     * @return
     */
    protected List<ParameterNameValue> getReportParameters(ReportRequestInfo reportRequest) throws ReportException {
        List paramList = null; 
        
        try {
            ResourceDescriptor rdis = new ResourceDescriptor();
            WSClient wsClient = server.getWSClient();    
            rdis.setWsType(ResourceDescriptor.TYPE_REPORTUNIT);
            rdis.setUriString(reportRequest.getReportAbsolutePath());
            wsClient = server.getWSClient();            
            ResourceDescriptor rdRecd = wsClient.get(rdis,null);
            ParameterNameValue paramVal = null;
                    
            List l = rdRecd.getChildren();
            paramList = new ArrayList<ParameterNameValue>();
            for(int i =0; i < l.size();i++) {
                ResourceDescriptor paramRD = (ResourceDescriptor) l.get(i);
                paramVal = new ParameterNameValue();
                
               
                if(paramRD.getWsType().equals(ResourceDescriptor.TYPE_INPUT_CONTROL)) {
                //TODO: Additional conditions for Checkbox etc
                    //input is a single select drop down from a query
                    if(paramRD.getControlType() == 4) {
                        log.debug("Single Select Query Input Control Type");
                        paramVal.setControlType("IC_TYPE_SINGLE_SELECT_QUERY");
                    }
                    //input is a single input text box
                    if(paramRD.getControlType() == 2) {
                        log.debug("Single Value Input Control Type");
                        paramVal.setControlType("IC_TYPE_SINGLE_VALUE");
                    }
                    //input is a boolean
                    if(paramRD.getControlType() == 1) {
                        log.debug("Boolean Input Control Type");
                        paramVal.setControlType("IC_TYPE_BOOLEAN");
                    }
                    
                    if(paramRD.getControlType() == 3) {
                        log.debug("Boolean Input Control Type");
                        paramVal.setControlType("IC_TYPE_SINGLE_SELECT_LIST_OF_VALUES");
                    }

                    if (paramRD.getChildren() != null && 
                        paramRD.getChildren().size() > 0) {
                        List childList = paramRD.getChildren();
                        ResourceDescriptor childRD = 
                            (ResourceDescriptor)childList.get(0);
                        //if (childRD.getWsType().equals(ResourceDescriptor.TYPE_DATA_TYPE)) {
                            List childListProp = new ArrayList();
                            childListProp = childRD.getProperties();
                            if (childListProp != null &&  childListProp.size() > 0) {
                                for(int j=0;j<childListProp.size();j++){
                                    ResourceProperty properties = 
                                        (ResourceProperty)childListProp.get(j);
                                    if (childRD.getWsType().equals(ResourceDescriptor.TYPE_DATA_TYPE)) {
                                        if (properties.getName().equals("PROP_DATATYPE_TYPE")) {
                                            String value = properties.getValue();
                                            if (value.equals("3")) {
                                                paramVal.setControlType("DT_TYPE_DATE");
                                            }
                                            if (value.equals("1")) {
                                                paramVal.setControlType("DT_TYPE_TEXT");
                                            }
                                            if (value.equals("2")) {
                                                paramVal.setControlType("DT_TYPE_NUMBER");
                                            }
                                        }
                                    }else if(childRD.getWsType().equals(ResourceDescriptor.TYPE_REFERENCE)){
                                        if(properties.getName().equals("PROP_REFERENCE_URI")){
                                            String value = properties.getValue();
                                        }
                                    }
                                                                     
                                }
                           
                            }

                        //}
                       
                    }
                    paramVal.setName(paramRD.getName());
                    paramVal.setLabel(paramRD.getLabel());
                    paramVal.setMultiValuesAllowed(true);
                    paramVal.setValues(null);
                    
                    if(paramRD.getProperties() != null && paramRD.getProperties().size() > 0){
                        List listOfParams =  new ArrayList();
                        listOfParams = paramRD.getProperties();
                        if (listOfParams != null &&  listOfParams.size() > 0) {
                            for(int j=0;j<listOfParams.size();j++){
                                ResourceProperty properties = 
                                    (ResourceProperty)listOfParams.get(j);
                                    if (properties.getName().equals("PROP_INPUTCONTROL_IS_MANDATORY")) {
                                        String mandatoryValue = properties.getValue();
                                        paramVal.setMandatory(mandatoryValue);
                                    }
                                
                            }
                        
                        }
                    }
                        
                    
                    paramList.add(paramVal);
                }
            }
        }
        catch (Exception exp) {
            log.error(exp.getLocalizedMessage(), exp);
            ReportException exception = new ReportException(exp);
            throw exception;
        }

        return paramList;
    }
    
    
    protected List<ParameterNameValue> getReportParametersWithDataTypes(ReportRequestInfo reportRequest) throws ReportException {
        List paramList = null; 
        
        try {
            ResourceDescriptor rdis = new ResourceDescriptor();
            WSClient wsClient = server.getWSClient();    
            rdis.setWsType(ResourceDescriptor.TYPE_REPORTUNIT);
            rdis.setUriString(reportRequest.getReportAbsolutePath());
            wsClient = server.getWSClient();            
            ResourceDescriptor rdRecd = wsClient.get(rdis,null);
            ParameterNameValue paramVal = null;
            String[] strings = {"blah", "blah", "blah"}; 
         
            List l = rdRecd.getChildren();
            paramList = new ArrayList<ParameterNameValue>();
            for(int i =0; i < l.size();i++) {
                ResourceDescriptor paramRD = (ResourceDescriptor) l.get(i);
                paramVal = new ParameterNameValue();
                
                if(paramRD.getWsType().equals(ResourceDescriptor.TYPE_INPUT_CONTROL)) {
                //TODO: Additional conditions for Checkbox etc
                    //input is a single select drop down from a query
                    if(paramRD.getControlType() == 4) {
                        log.debug("Single Select Query Input Control Type");
                        paramVal.setControlType("IC_TYPE_SINGLE_SELECT_QUERY");
                    }
                    //input is a single input text box
                    if(paramRD.getControlType() == 2) {
                        log.debug("Single Value Input Control Type");
                        paramVal.setControlType("IC_TYPE_SINGLE_VALUE");
                    }
                    //input is a boolean
                    if(paramRD.getControlType() == 1) {
                        log.debug("Boolean Input Control Type");
                        paramVal.setControlType("IC_TYPE_BOOLEAN");
                    }
                    
                    
                    if(paramRD.getChildren() != null && paramRD.getChildren().size() > 0){
                        List childList = paramRD.getChildren();
                        ResourceDescriptor childRD = (ResourceDescriptor) l.get(0);
                        if(childRD.getWsType().equals(ResourceDescriptor.TYPE_DATA_TYPE)) {
                            if(paramRD.getControlType() == 3) {
                                log.debug("Date type");
                                paramVal.setControlType("DT_TYPE_DATE");
                            }
                        }
                    }
                    
                    paramVal.setName(paramRD.getName());
                    paramVal.setLabel(paramRD.getLabel());
                    paramVal.setMultiValuesAllowed(true);
                    paramVal.setValues(strings);
                    paramList.add(paramVal);
                }

               

            }
        }
        catch (Exception exp) {
            log.error(exp.getLocalizedMessage(), exp);
            ReportException exception = new ReportException(exp);
            throw exception;
        }

        return paramList;
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
    
             
             private EMailDeliveryOption convertToEmailDeliveryOption(EMailDeliveryConfiguration emailDeliveryConfiguration) {
                 
                 EMailDeliveryOption emailDeliveryOption = new EMailDeliveryOption();
                 emailDeliveryOption.setEmailBCC(emailDeliveryConfiguration.getEmailBCC());
                 //TODO: implement
                 
                 return emailDeliveryOption;
                 
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
    
    private ParamNameValue [] convertToParamNameValue(ParameterNameValue [] _parameterNameValues) {
        
        ParamNameValue[] paramNameValues = new ParamNameValue[_parameterNameValues.length] ;
        
        for(int i=0;i< _parameterNameValues.length;i++ ) {
            paramNameValues[i] = convertToParamNameValue(_parameterNameValues[i]);
        }
        
        return paramNameValues;
    }

    private ParamNameValue convertToParamNameValue(ParameterNameValue parameterNameValue) {
        
        ParamNameValue paramNameValue = new ParamNameValue();
        
        paramNameValue.setMultiValuesAllowed(parameterNameValue.isMultiValuesAllowed());
        paramNameValue.setName(parameterNameValue.getName());
        paramNameValue.setValues(parameterNameValue.getValues());
        
        return paramNameValue;
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
        
    /**
     * 
     * @param scheduledJobID
     * @param viewByFilter
     * @param downloadReport
     * @return
     */
    protected ScheduledJobHistoryInfo[] retrieveScheduledReportHistoryInfo(String scheduledJobID, 
                                                                           String viewByFilter, 
                                                                           boolean downloadReport) {
        return new ScheduledJobHistoryInfo[0];
    }
    
//    public static void main(String a[]) {
//        try {
//            JasperReportImpl test = new JasperReportImpl("trips|trips", "trips", "http://trips-reports:8080/jasperserver-pro/services/repository?wsdl");
//            test.getDirectoryItems("/reports");
//            ReportRequestInfo reportRequestInfo = new ReportRequestInfo();
//            ParameterNameValue[] parameterNameValues = new ParameterNameValue[1];
//            ParameterNameValue param = new ParameterNameValue();
//            param.setName("TIN");
//            String ar[] = new String[1];
//            ar[0] =new String("500003983000");
//            param.setValues(ar);
//            parameterNameValues[0] = param;
//            reportRequestInfo.setReportSource("WS");
//            reportRequestInfo.setParameterNameValues(parameterNameValues);
//            reportRequestInfo.setReportAbsolutePath("/reports/RegistrationCertificate");
//            reportRequestInfo.setReportName("Registration Certificate");//REG-CERT
//            reportRequestInfo.setReportFormat("PDF");
//            ReportResult result = test.runReport(reportRequestInfo);
//        }
//        catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//    }

    public List<ParameterNameValue> loadReportParamsFromJasperServer(String reportAbsolutePath) throws ReportException {
        ParameterNameValue paramVal = null;
        List paramList = new ArrayList();
        ResourceDescriptor rdis = new ResourceDescriptor();
        rdis.setWsType(ResourceDescriptor.TYPE_REPORTUNIT);
        rdis.setUriString(reportAbsolutePath);//"/reports/TaxtypeAmendment"
        try {
            WSClient wsClient = new WSClient(server);
            wsClient.setServer(server);
            ResourceDescriptor rdRecd1 = wsClient.get(rdis, null);
            List l = wsClient.list(rdRecd1);

            for (int i = 0; i < l.size(); i++) {
                ResourceDescriptor paramRD = (ResourceDescriptor)l.get(i);
                paramVal = new ParameterNameValue();
                if (paramRD.getWsType().equals(ResourceDescriptor.TYPE_INPUT_CONTROL)) {
                    //TODO: Additional conditions for Checkbox etc
                    //input is a single select drop down from a query
                    if (paramRD.getControlType() == 4) {
                        log.debug("Single Select Query Input Control Type");
                    }
                    //input is a single input text box
                    if (paramRD.getControlType() == 2) {
                        log.debug("Single Value Input Control Type");
                    }
                    //input is a boolean
                    if (paramRD.getControlType() == 1) {
                        log.debug("Boolean Input Control Type");
                    }
                    paramVal.setName(paramRD.getName());
                    paramVal.setLabel(paramRD.getLabel());
                    paramVal.setMultiValuesAllowed(false);
                    paramVal.setValues(null);
                    paramList.add(paramVal);
                }
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return paramList;
    }

    public List<ReportDirectoryItem> loadReportsFromJasperServer(String absolutePath) throws ReportException {
        List<ReportDirectoryItem> dirList = null;
        ReportDirectoryItem directoryItem = null;
        dirList = new ArrayList<ReportDirectoryItem>();
        try {
            WSClient wsClient = new WSClient(server);
            wsClient.setServer(server);
            ResourceDescriptor rdis = new ResourceDescriptor();
            rdis.setWsType(ResourceDescriptor.TYPE_FOLDER);
            rdis.setUriString(absolutePath);//"/reports"
            ResourceDescriptor rdRecd1 = wsClient.get(rdis, null);
            List l = wsClient.list(rdRecd1);
            for (int i = 0; i < l.size(); i++) {
                ResourceDescriptor rdRecd = (ResourceDescriptor)l.get(i);
                directoryItem = new ReportDirectoryItem();
                directoryItem.setAbsolutePath(rdRecd.getUriString());
                if (rdRecd.getLabel() == null) {
                    directoryItem.setDisplayName(rdRecd.getName());
                    log.debug(rdRecd.getName());
                } else {
                    directoryItem.setDisplayName(rdRecd.getLabel());
                }
                directoryItem.setFileName(rdRecd.getName());
                directoryItem.setParentAbsolutePath(rdRecd.getParentFolder());
                directoryItem.setType(ReportDirectoryItem.DIRECTORYITEM_REPORT);
                directoryItem.setCreationDate(rdRecd.getCreationDate());
                dirList.add(directoryItem);
            }

        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return dirList;
    }

 
}
