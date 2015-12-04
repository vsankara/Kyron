package com.technobrain.trips.reporting.service;

import com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBLocal;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;

import com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBRemote;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.locator.ServiceLocator;
import com.technobrain.trips.reference.service.ReferenceFacadeLocal;

public class DBMaintenanceBeanBean extends AbstractTRIPSJob implements DBMaintenanceBeanLocal {
    public static final Logger log = Logger.getLogger(DBMaintenanceBeanBean.class);

    public DBMaintenanceBeanBean() {
    }

	@Override
	public String executeJob(JobExecutionContext jobExecutionContext) throws Exception {
//        ReportingFacadeLocal report = (ReportingFacadeLocal) ServiceLocator.getInstance().getLocalEJB("ReportingFacade");
        RefCodeAssemblerSessionEJBLocal refCodeFacade = (RefCodeAssemblerSessionEJBLocal) ServiceLocator.getInstance().getLocalEJB("RefCodeAssemblerSessionEJB");
        ReferenceFacadeLocal  referenceFacade = (ReferenceFacadeLocal) ServiceLocator.getInstance().getLocalEJB("ReferenceFacade");
        
        long saveIntervalPrintQueue = Long.valueOf(refCodeFacade.findSystemParameter(Constants.SystemParameterCode.PRINT_QUEUE_SAVE_DAY_INTERVAL));
        long saveIntervalUserLogin = Long.valueOf(refCodeFacade.findSystemParameter(Constants.SystemParameterCode.SYS_USER_LOGIN_SAVE_DAY_INTERVAL));
        
        log.debug(DBMaintenanceBeanBean.class.getSimpleName() + " is starting with day saveIntervalPrintQueue " + saveIntervalPrintQueue);
        log.debug(DBMaintenanceBeanBean.class.getSimpleName() + " is starting with day saveIntervalUserLogin " + saveIntervalUserLogin);
//        	List<PrintQueue> jobs = null; 
//        	do{
//        		jobs = report.listSuccessfullyPrintedJobs(100, new Date(System.currentTimeMillis() - keepInterval * 24 * 60 * 60 * 1000));
//        		log.debug(jobs.size() + " PrintQueue(s) was found to be deleted");
//        		for(PrintQueue pq : jobs){
//        			log.debug("PrintQueue " + pq.getId() + " is being deleted. last update time:" + pq.getUpdatedDate());
//        			report.deltePrintQueue(pq);
//        		}
//        	} while (jobs.size() > 0);
//    	int rowCount1 = report.deleteSuccessfullyPrintedJobs(new Date(System.currentTimeMillis() - saveIntervalPrintQueue * 24L * 60L * 60L * 1000L));
//    	log.debug("PRINT_QUEUE table, clear process has been done for " + rowCount1 + " row(s)");
    	
    	int rowCount2 = referenceFacade.deleteOldUserSession(new Date(System.currentTimeMillis() - saveIntervalUserLogin * 24L * 60L * 60L * 1000L));
    	log.debug("SYS_USER_LOGIN table, clear process has been done for " + rowCount2 + " row(s)");
    	
    	return "SUCCESS for " + rowCount2 + " row(s) at PRINT_QUEUE, " + rowCount2 + " row(s) at SYS_USER_LOGIN";
    }
}
