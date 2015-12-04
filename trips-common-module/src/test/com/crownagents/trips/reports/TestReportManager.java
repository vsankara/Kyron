package test.com.crownagents.trips.reports;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.reports.ReportManager;
import com.technobrain.trips.reports.conf.PrintDeliveryConfiguration;
import com.technobrain.trips.reports.param.ParameterNameValue;
import com.technobrain.trips.reports.param.ReportDefInfo;
import com.technobrain.trips.reports.param.ReportDirectoryItem;
import com.technobrain.trips.reports.param.ReportInfo;
import com.technobrain.trips.reports.param.ReportRequestInfo;
import com.technobrain.trips.reports.param.ReportResult;
import com.technobrain.trips.reports.param.ScheduleInfo;
import com.technobrain.trips.reports.param.ScheduledJobHistoryInfo;

import java.util.List;
import java.util.Locale;
import org.apache.log4j.Logger;

public class TestReportManager  {
    static final Logger log = Logger.getLogger(TestReportManager.class);
    
    final static  String sampleReportPath = "/TRIPS/OTHER/GUI Page Field List/GUI Page Field List.xdo";
    //final static  String sampleReportPath = "/Training/TrainSub/AccessCont3/AccessCont3.xdo";
     
    public TestReportManager(){
    }
    
    public static void main(String[] args){
        
       Locale l = new Locale("en","Pd");
       log.debug(" " + l.getDisplayCountry());
        //testPrintReportServer();
        //testGetDirectoryItems();
        //testGetReportDefinition();
       // testRetrieveScheduledReportHistoryInfo();
    
    }

    public static void testRetrieveScheduledReportHistoryInfo() {
        try {
            ReportManager reportManager = new ReportManager("Administrator", "Administrator");
            
            
            ScheduledJobHistoryInfo [] scheduledJobHistoryInfos  = 
                       reportManager.retrieveScheduledReportHistoryInfo("329", ScheduledJobHistoryInfo.VIEWBYFILTER_ALL,true);
            
            log.debug("Job Message" + scheduledJobHistoryInfos[0].getJobMessage());
           
            
        } catch (Exception e) {
            // TODO
            log.error(e.getLocalizedMessage(), e);
        }       
    }

    public static void testRunReport() {
        try {
            ReportManager reportManager = new ReportManager("Administrator", "Administrator");
            
            //ReportInfo reportInfo = new ReportInfo();
            
            ReportRequestInfo requestInfo = new ReportRequestInfo();
            requestInfo.setReportAbsolutePath(sampleReportPath);
            //requestInfo.setReportFormat(Constants.ReportFormat.PDF);
             requestInfo.setReportFormat("xml");
            //requestInfo.setReportLocale("en-US");
            
            ParameterNameValue[] paramNmVals = new ParameterNameValue[1];

            paramNmVals[0] = new ParameterNameValue();

            paramNmVals[0].setName("GUIPageName");

            paramNmVals[0].setValues( new String [] {"ManifestDetails"});

            requestInfo.setParameterNameValues(paramNmVals);
            
            ReportResult reportResult = reportManager.runReport(requestInfo);
            
            log.debug(reportResult.getReportContentType());
           
            
        } catch (Exception e) {
            // TODO
            log.error(e.getLocalizedMessage(), e);
        }       
    }
    

    public static void testPrintReportLocal() {
        try {
            ReportManager reportManager = new ReportManager("Administrator", "Administrator");
            
            ReportInfo reportInfo = new ReportInfo();
            
            ReportRequestInfo requestInfo = new ReportRequestInfo();
            requestInfo.setReportAbsolutePath(sampleReportPath);
            requestInfo.setReportFormat(Constants.ReportFormat.PDF);
            //requestInfo.setReportLocale("en-US");
            
            ParameterNameValue[] paramNmVals = new ParameterNameValue[1];

            paramNmVals[0] = new ParameterNameValue();

            paramNmVals[0].setName("COUNTRY_CODE");

            paramNmVals[0].setValues( new String [] {"TR"});

            requestInfo.setParameterNameValues(paramNmVals);

            
            
            reportInfo.setReportRequestInfo(requestInfo);
            
            PrintDeliveryConfiguration printDeliveryConfiguration = new PrintDeliveryConfiguration();
            printDeliveryConfiguration.setPrinterName("PRINTER2");
            printDeliveryConfiguration.setPrintNumberOfCopy("1");
            printDeliveryConfiguration.setPrintRange("1");
            
            reportInfo.setDeliveryConfiguration(printDeliveryConfiguration);
            
            ScheduleInfo scheduleInfo = new ScheduleInfo();
            scheduleInfo.setUserJobName("Print Try");
            reportInfo.setScheduleInfo(scheduleInfo);
            
            String jobId = reportManager.scheduleReport(reportInfo);
            
            log.debug("Printed Job : " + jobId);
           
            
        } catch (Exception e) {
            // TODO
            log.error(e.getLocalizedMessage(), e);
        }       
    }

    
    public static void testPrintReportServer() {
        try {
            ReportManager reportManager = new ReportManager("Administrator", "Administrator");
            
            ReportInfo reportInfo = new ReportInfo();
            
            ReportRequestInfo requestInfo = new ReportRequestInfo();
            requestInfo.setReportAbsolutePath(sampleReportPath);
            requestInfo.setReportFormat(Constants.ReportFormat.PDF);
            requestInfo.setReportLocale("en-US");
            requestInfo.setReportTemplate("New Template 1");
            
            ParameterNameValue[] paramNmVals = new ParameterNameValue[1];

            paramNmVals[0] = new ParameterNameValue();

            paramNmVals[0].setName("DEC_REF_NO");

            paramNmVals[0].setValues( new String [] {"1009"});

            requestInfo.setParameterNameValues(paramNmVals);

            
            
            reportInfo.setReportRequestInfo(requestInfo);
            
            PrintDeliveryConfiguration printDeliveryConfiguration = new PrintDeliveryConfiguration();
            printDeliveryConfiguration.setPrinterName("HP_PRINTER2");
            printDeliveryConfiguration.setPrintNumberOfCopy("1");
            printDeliveryConfiguration.setPrintSide("1");
            
            reportInfo.setDeliveryConfiguration(printDeliveryConfiguration);
            
            ScheduleInfo scheduleInfo = new ScheduleInfo();
            //scheduleInfo.setUserJobName("Print Try :" + DateHelper.getTodaysDateWithTime().toString());
             scheduleInfo.setUserJobName("Print Try :");
            scheduleInfo.setSaveDataOption(true);
            scheduleInfo.setSaveOutputOption(true);
            scheduleInfo.setUseUTF8Option(true);
            //scheduleInfo.setStartDate(DateHelper.getTodaysDateWithTime());
            
            reportInfo.setScheduleInfo(scheduleInfo);
            
            String jobId = reportManager.scheduleReport(reportInfo);
            
            log.debug("Printed Job : " + jobId);
           
            
        } catch (Exception e) {
            // TODO
            log.error(e.getLocalizedMessage(), e);
        }       
    }
    
    
    public static void testGetDirectoryItems() {
        try {
            ReportManager reportManager = new ReportManager("Administrator", "Administrator");
            
            List<ReportDirectoryItem> directoryContent = reportManager.getDirectoryItems("/TRIPS");
            
            log.debug("testGetDirectoryItems return:" + directoryContent.size());
           
            
        } catch (Exception e) {
            // TODO
            log.error(e.getLocalizedMessage(), e);
        }       
    }
    
    public static void testGetReportDefinition(){
        try {
            ReportManager reportManager = new ReportManager("Administrator", "Administrator");
            
            ReportDefInfo reportDefInfo = reportManager.getReportDefinition(sampleReportPath);
            
            log.debug("testGetDirectoryItems return:" + reportDefInfo.getDefaultTemplateId());
           
            
        } catch (Exception e) {
            // TODO
            log.error(e.getLocalizedMessage(), e);
        }   
    }
}
