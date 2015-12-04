package com.technobrain.trips.compliance.service;

import javax.ejb.Stateless;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


@Stateless(mappedName = "test-Project1-BackgroundJobManager")
public class BackgroundJobManager implements ServletContextListener{

//    @EJB
//    private  RefCodeAssemblerSessionEJBLocal ref;
//    
//    @EJB
//    private TestTimerServiceLocal tim;
//    
//    @EJB
//    private AutomaticSchedulerLocal auto;
//    
//    @EJB
//    private ReportPrintBeanLocal print;
//    
//    @EJB
//    private GeneratePeriodsSchedulerLocal generatePeriodsScheduler;
//    
//    @EJB
//    private GenerateMissingPeriodsSchedulerLocal generateMissingPeriodsScheduler;
//    
//    @EJB
//    private InstalmentAgreementComplianceSchedulerLocal instalmentAgreementScheduler;
//    
//    public static final Logger log = Logger.getLogger(BackgroundJobManager.class);
//   
//    public BackgroundJobManager() {
//    }
//
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
////        long schIntervalDuration = Long.valueOf(ref.findSystemParameter(Constants.SystemParameterCode.SCHEDULE_COMPLIANCE_INTERVAL));
////        long intervalDuration = Long.valueOf(ref.findSystemParameter(Constants.SystemParameterCode.NOTIFICATION_INTERVAL));
//        log.debug("Context initialized.");
//        Timer c = null;//tim.createTimer(TestTimerServiceBean.NAME, 0);
//        Timer a = auto.createTimer(AutomaticSchedulerBean.NAME, 0);
//        Timer r = print.createTimer(ReportPrintBean.NAME, 0);
//        Timer periodSchedularTimer = generatePeriodsScheduler.createTimer(GeneratePeriodsSchedulerBean.NAME, 0);
//        Timer periodMissingSchedularTimer = generateMissingPeriodsScheduler.createTimer(GenerateMissingPeriodsSchedulerBean.NAME, 0);
//        Timer instalmentAgreementSchedulerTimer = instalmentAgreementScheduler.createTimer(InstalmentAgreementComplianceSchedulerBean.NAME, 0);
//        log.debug("Timer initialized: " + a.getInfo());
//        log.debug("Timer initialized: " + c.getInfo());
//        log.debug("Timer initialized: " + r.getInfo());
//        log.debug("Timer initialized: " + periodSchedularTimer.getInfo());
//        log.debug("Timer initialized: " + periodMissingSchedularTimer.getInfo());
//        log.debug("Timer initialized: " + instalmentAgreementSchedulerTimer.getInfo());
//        
//    }
//
//    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//        log.debug("Context destroyed.");
//
//        if (tim.getTimer()!=null && tim.killTimer(tim.getTimer())) {
//            log.debug("Print notification timer object is killed.");
//        } else {
//            log.debug("Print notification timer object can not be killed.");
//        }
//        
//        if (auto.getTimer()!=null && auto.killTimer(auto.getTimer())) {
//            log.debug("Auto scheduler timer object is killed.");
//        } else {
//            log.debug("Auto scheduler timer object can not be killed.");
//        }
//        
//        if (print.getTimer()!=null && print.killTimer(print.getTimer())) {
//            log.debug("Print scheduler timer object is killed.");
//        } else {
//            log.debug("Print scheduler timer object can not be killed.");
//        }
//        
//        if (generatePeriodsScheduler.getTimer()!=null && generatePeriodsScheduler.killTimer(generatePeriodsScheduler.getTimer())) {
//            log.debug("Period generation scheduler timer object is killed.");
//        } else {
//            log.debug("Period generation scheduler timer object can not be killed.");
//        }
//        
//        if (generateMissingPeriodsScheduler.getTimer()!=null && generateMissingPeriodsScheduler.killTimer(generateMissingPeriodsScheduler.getTimer())) {
//            log.debug("Period generation scheduler timer object is killed.");
//        } else {
//            log.debug("Period generation scheduler timer object can not be killed.");
//        }
//        
//        if (instalmentAgreementScheduler.getTimer()!=null && instalmentAgreementScheduler.killTimer(instalmentAgreementScheduler.getTimer())) {
//            log.debug("Instalment Agreement Compliance scheduler timer object is killed.");
//        } else {
//            log.debug("Instalment Agreement Compliance scheduler timer object can not be killed.");
//        }
//    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
