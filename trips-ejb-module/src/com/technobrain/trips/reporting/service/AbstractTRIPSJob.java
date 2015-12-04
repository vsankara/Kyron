package com.technobrain.trips.reporting.service;

import com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBLocal;
import com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBRemote;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.core.system.JobLog;
import com.technobrain.trips.core.system.SystemParameters;
import com.technobrain.trips.locator.ServiceLocator;

import java.sql.Timestamp;

import java.util.Vector;

import org.apache.log4j.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;


/**
 * 
 * @author v_demir
 *
 */
public abstract class AbstractTRIPSJob implements Job {
    public static final Logger log = Logger.getLogger(AbstractTRIPSJob.class);
    public static final String JOB_RUNNING_STATE = "1";
    public static final String JOB_IDLE_STATE = "0";
    public static final String JOB_LOCK_SUFFIX = ".RUNNING";
    
//    private ConfigurationFacadeLocal configurationFacade;
//    
//    private TaskServiceFacadeLocal taskServiceFacade;
    
    private Integer keepCount;    

    private static Vector<AbstractTRIPSJob> runningJobs = new Vector<AbstractTRIPSJob>();

    public void execute(JobExecutionContext jobExecutionContext) {
        if(!startJob()){
            log.info("TRIPSJob another instance is  running for " + this.getClass().getSimpleName());
            return;
        }
        try {
            log.debug("TRIPSJob " + this.getClass().getSimpleName() + " is starting ...");
            JobLog joLog = new JobLog();
            joLog.setJobStartTime(new Timestamp(System.currentTimeMillis()));
            String result = null;
     
            runningJobs.add(this);
            result = executeJob(jobExecutionContext);
            //Thread.sleep(1000); // min job interval
                 
            joLog.setJobEndTime(new Timestamp(System.currentTimeMillis()));
            joLog.setRuntimeLog(result);
            joLog.setJobId(this.getClass().getSimpleName());
            log.debug("TRIPSJob " + this.getClass().getSimpleName() + " has finished ...");
//            getTaskServiceFacade().saveOrUpdate(joLog);
//            getTaskServiceFacade().deleteOldJobLogs(joLog.getJobId(), getKeepCount());
                
        } catch (Throwable e) {
            log.error("TRIPSJob Error processing " + this.getClass().getSimpleName() + " jobs, restarting timer and continuing.", e);
        } finally {
            stopJob();
            runningJobs.remove(this);
            try {
                    Thread.sleep(1000); // min job interval
                } catch (InterruptedException e) {
                } 
        }
    }
	
    public synchronized boolean startJob() {
//        if(getConfigurationFacade().lockScheduledJob(getParameterCode()) > 0){
                return true;
//        } else {
//                return false;
//        }
    }
    
    public synchronized void stopJob(){
        String parameterCode = this.getClass().getSimpleName() + JOB_LOCK_SUFFIX;
//        SystemParameters sp = getConfigurationFacade().findSysParameters(parameterCode);
//        sp.setValue(JOB_IDLE_STATE);
//        configurationFacade.saveOrUpdateSysParameters(sp);
    }	

    public boolean isRunning() {
//        if(JOB_RUNNING_STATE.equals(getConfigurationFacade()
//                        .findSysParameters(getParameterCode()).getValue())){
//            return true;
//        } else {
            return false;
//        }
    }    
    
//    public ConfigurationFacadeLocal getConfigurationFacade() {
//    	if(configurationFacade == null){
//            configurationFacade = (ConfigurationFacadeLocal) 
//                                                            ServiceLocator.getInstance().getLocalEJB("ConfigurationFacade");
//    	}
//        return configurationFacade;
//    }
//    
//    public TaskServiceFacadeLocal getTaskServiceFacade() {
//    	if(taskServiceFacade == null){
//            taskServiceFacade = (TaskServiceFacadeLocal) 
//                                                            ServiceLocator.getInstance().getLocalEJB("TaskServiceFacade");
//    	}
//        return taskServiceFacade;
//    }
    
    public int getKeepCount(){
    	if(keepCount == null){
             RefCodeAssemblerSessionEJBLocal refCodeFacade = (RefCodeAssemblerSessionEJBLocal) ServiceLocator.getInstance().getLocalEJB("RefCodeAssemblerSessionEJB");
    	     keepCount = Integer.valueOf(refCodeFacade.findSystemParameter(Constants.SystemParameterCode.SCHEDULED_JOB_LOG_COUNT));
    	}
    	return keepCount;
    }       

    public String getParameterCode() {
        return this.getClass().getSimpleName() + ".RUNNING";
    }

    public abstract String executeJob(JobExecutionContext jobExecutionContext) throws Exception;

    public static Vector<AbstractTRIPSJob> getRunningJobs() {
        return runningJobs;
    }	
}
