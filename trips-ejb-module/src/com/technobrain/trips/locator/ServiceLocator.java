package com.technobrain.trips.locator;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;


/**
 * TODO: Add a map to store lookup for better performance and move to gui layer
 * where it belongs.
 * @see <a href="http://java.sun.com/blueprints/corej2eepatterns/Patterns/ServiceLocator.html">Service Locator</a>
 * @since November 26,2006.
 * @author hhill
 * @version 1.0
 */
public class ServiceLocator {

    public static final char EJB = 'e';
    public static final char REMOTE = 'r';
    public static final char LOCAL = 'l';
    public static final char WEB_SERVICE = 'w';
    public static final Logger log = Logger.getLogger("ServiceLocator");
    InitialContext context = null;

    public ServiceLocator() {
        try {
            context = new InitialContext();
        } catch (NamingException ne) {
            log.error("Error in constructor looking up initial context",ne);
            throw new ServiceLocatorException(ne);
        }
    }

    // returns the Service Locator instance 

    public static ServiceLocator getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
     * or the first access to SingletonHolder.instance , not before.
     */
    private static class SingletonHolder {
        private static final ServiceLocator instance = new ServiceLocator();
    }

    // Services Constants Inner Class - service objects

    public class Services {
        public static final String FORM_GENERATION = "FormGenearationFacade";
        public static final String GUI_MANAGER = "GuiService#com.technobrain.trips.gui.service.GuiConfigFacadeRemote";
        public static final String SECONDARY_COMPLIANCE_TIMER_SERVICE = "SecondaryComplianceTimerService";
        public static final String TIMER_KILL_SERVICE = "TimerKillService";
        public static final String AUTO_SCHEDULER_SERVICE = "AutomaticSchedulerService";
        public static final String REF_CODE_ASS = "RefCodeAssemblerSessionEJB#com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBRemote";
        public static final String REG_IND_TAXPAYER = 
            "RefCodeAssemblerSessionEJB";
        public static final String SEARCH_ASSEM = "SearchAssemblerEJB";
        public static final String SEARCH_SERVICE = "SearchFacade#com.technobrain.trips.search.service.SearchFacadeRemote";
        public static final String ENTITY_FACADE = "EntityFacade#com.technobrain.trips.entity.service.EntityFacadeRemote";
        public static final String REV_ACCOUNT = "RevenueAccountFacade";
        public static final String REGISTRATION_FACADE = "RegTaxpayerFacade#com.technobrain.trips.registration.service.RegTaxpayerFacadeRemote";
        public static final String DOCUMENT_FACADE = "DocumentFacade#com.technobrain.trips.document.service.DocumentFacadeRemote";
        public static final String DECLARATION_FACADE = "DeclarationFacade";
        public static final String REFERENCE_FACADE = "ReferenceFacade#com.technobrain.trips.reference.service.ReferenceFacadeRemote";
        public static final String BPEL_PROVIDER_FACADE = 
            "BpelServiceProviderFacade";
        public static final String REVENUE_LEDGER_FACADE = 
            "RevenueLedgerFacade";
        public static final String REVENUE_LEDGER_BUS_FACADE = 
            "RevenueLedgerBusinessFacade";
        public static final String JOBS_FACADE = "JobsFacade";
        public static final String RETURN_FACADE = "ReturnsFacadeBean";
        public static final String VALIDATION_FACADE = "ValidationFacade";
        public static final String INTELLIGENCE_FACADE = "IntelligenceFacade";
        public static final String CONFIGURATION_FACADE = 
            "ConfigurationFacade";
        public static final String MANIFEST_FACADE = "ManifestFacade";
        public static final String EXEMPTION_FACADE = "ExemptionFacade";
        public static final String DB_SECURITY_FACADE = "DBSecurityFacade#com.technobrain.trips.security.service.DBSecurityFacadeRemote";
        
        public static final String LDAP_SECURITY_FACADE = "LDAPSecurityFacade";
        public static final String SECURITY_FACADE = "SecurityFacade#com.technobrain.trips.security.service.SecurityFacadeRemote";
        public static final String CASE_FACADE = "CaseManagementFacade";
        public static final String DEBT_CASE_FACADE = "DebtMgmtFacade";
        public static final String AUDIT_VISIT_FACADE = "AuditFacade";
        public static final String OBJECTIONS_FACADE = 
            "ObjectionsAppealsFacade";
        public static final String AUDIT_SELECTION = "AuditSelection";
        public static final String WORKFLOW_FACADE = "WorkflowFacade";
        public static final String REPORTING_FACADE = "ReportingFacade";
        public static final String VALUATION_FACADE = "ValuationFacade";
        public static final String APPLICATION_FACADE = "ApplicationFacade";
        public static final String GUARANTEE_FACADE = "GuaranteeFacade";
        public static final String INSTALMENT_AGREEMENT_FACADE = 
            "InstalmentAgreementFacade";
        public static final String SYSTEM_FACADE = "SystemFacade";
        public static final String COMPUTE_FACADE = "ComputeFacade";
        public static final String TAX_MANAGER_FACADE = "TaxManagerFacade";
        public static final String TAX_CALCULATION_FACADE = "TaxCalculationFacade";
        public static final String FLEXIBLE_FORM_FACADE = 
            "FlexibleFormsFacade";
        public static final String ANALYSIS_FACADE = "AnalysisFacade";
        public static final String TASK_FACADE = "TaskServiceFacade";
        public static final String SCRIPT_OPERATIONS_FACADE = 
            "ScriptOperationsFacade";
        public static final String BATCH_FACADE = "BatchFacade";
        public static final String REFUND_RECONCILIATION_FACADE = 
            "RefundReconciliationFacade";
        public static final String CONFIGURATION_SET_FACADE = 
            "ConfigurationSetFacade";
        public static final String REGISTRATION_VALIDATION_FACADE = "RegistrationValidator";
        
        public static final String SCRIPT_MANAGER_FACADE = "ScriptManagerFacade";
        public static final String ACCOUNT_FACADE = "AccountFacade#com.technobrain.trips.account.service.AccountFacadeRemote";
        public static final String CHART_OF_ACCOUNTS_FACADE = "ChartOfAccountsFacade";
        public static final String REVENUE_COLLECTION_FACADE = "RevenueCollectionFacade";
        public static final String EXEMPTIONS_FACADE = "ExemptionsFacade";
        public static final String REVENUE_ACCOUNT_FACADE = "RevenueAccountFacade#com.technobrain.trips.revenueaccount.service.RevenueAccountFacadeRemote";
        public static final String APP_MENU_FACADE = "AppMenuFacade";
        
        public static final String COMPLIANCE_FACADE = "ComplianceFacade";
        public static final String CALENDAR_MANAGEMENT_FACADE = "CalendarManagementFacade";
        public static final String ENFORCEMENT_FACADE = "EnforcementFacade#com.technobrain.trips.enforcement.service.EnforcementFacadeRemote";
        public static final String REFUNDS_FACADE = "RefundsFacade";
        public static final String RISK_MANAGEMENT_FACADE = "RiskManagementFacade";
        public static final String TAX_RATE_FACADE = "TaxRatesFacade";
        public static final String RATE_MANAGEMENT_FACADE = "RateManagementFacade";
        public static final String CREDIT_ALLOCATION_FACADE = "CreditAllocationFacade";
        public static final String USER_MANAGEMENT_FACADE = "UserManagementFacade";
        public static final String MESSAGE_FACADE = "MessageFacade";
        public static final String EGIF_CALLER = "EgifCaller";
    }


    /**
     * Uses this $jndiName and append "/local".
     * <p>
     * Hence in the web.xml the local ref should be
     * the jndiName/local
     * @param $jndiName
     * @return
     * @throws com.technobrain.trips.locator.ServiceLocatorException
     */
    public Object getLocalEJB(String _jndiName) throws ServiceLocatorException {
        return getEJB(_jndiName);
    }

    public Object getRemoteEJB(String $jndiName) throws ServiceLocatorException {
        return getEJB($jndiName);
    }

    /**
     * gets the EJBHome for the given service using the
     * JNDI name 
     * @param $jndiName
     * @return a Local or Remote interface
     * @throws com.technobrain.trips.locator.ServiceLocatorException
     */
    public Object getEJB(String _jndiName) throws ServiceLocatorException {
           return lookup(_jndiName, 10);
//    		try {
//    			// InitialContext is not thread safe
//				return new InitialContext().lookup(_jndiName);
//			} catch (NamingException e) {
//				log.error("jndi lookup error :" + _jndiName, e);
//				throw new ServiceLocatorException(e);	
//			}
    }

    private Object lookup(String _jndiName, int remainingRetryCount){
    	try {
			Object service = context.lookup(_jndiName);
//			if(log.isInfoEnabled()){
//				return ServiceProxy.createProxy(service);	
//			} else {
				return service;
//			}
		} catch (NamingException e) {
			try {
				Thread.sleep(10); // slow down ...
			} catch (InterruptedException e1) {
			} 
			if(remainingRetryCount > 0){
				log.info("retry for " +_jndiName);
				try {
					context = new InitialContext();
				} catch (NamingException e2) {
					throw new ServiceLocatorException(e2);
				}
				Object service = lookup(_jndiName, --remainingRetryCount);
//				if(log.isInfoEnabled()){
//					return ServiceProxy.createProxy(service);	
//				} else {
					return service;
//				}
			} else {
				log.error("max retry failed in NamingException looking up initial context with jndi " + _jndiName, e);
				throw new ServiceLocatorException(e);	
			}
		}
    }
}
