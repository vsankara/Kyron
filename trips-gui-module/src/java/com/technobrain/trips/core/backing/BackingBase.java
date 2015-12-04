package com.technobrain.trips.core.backing;

import com.technobrain.trips.admin.delegate.WorkflowDelegate;
import com.technobrain.trips.core.ICallBackHandler;
import com.technobrain.trips.core.backing.tableHandler.BackingTableHandler;
import com.technobrain.trips.core.delegate.ReferenceCodeDelegate;
import com.technobrain.trips.core.sessionmanager.SessionPage;
import com.technobrain.trips.core.sessionmanager.annotation.SessionWorker;
import com.technobrain.trips.core.sessionmanager.backing.BackingSessionManager;
import com.technobrain.trips.gui.GuiConfiguration;
import com.technobrain.trips.gui.GuiConfigurationKey;
import com.technobrain.trips.gui.exception.GuiConfigurationException;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.util.WebConstants;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.message.OutputType;
import com.technobrain.trips.gui.model.GuiPageComponent;
import com.technobrain.trips.gui.model.GuiPageConfig;
import com.technobrain.trips.security.model.CasSecRolePageConfig;
import com.technobrain.trips.security.model.CasSecRolePageRel;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.IOException;
import java.io.Serializable;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.el.ValueExpression;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.security.auth.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;


/**
 * � Crown Agents 2007
 * <p>
 * Provides the implementation for common functionallity for all backing beans.
 * <p>
 * Functions as the controller for the GUI configuration, where the configuration
 * is loaded and applied to the components on the page before being
 * rendered on the screen.
 * @since $Date: 2/1/2010 9:33:29 AM$
 * @version $Revision: 130$
 * @author $Author: Kemal Ediz$
 *
 * $Log[1]:
 *  130  TRIPS2 etis.bir.gov.ph1.119.1.9   2/1/2010 9:33:29 AM    Kemal Ediz
 *         cpv and scv implemented.
 * $
 * $Log[1]:
 *  130  TRIPS2 etis.bir.gov.ph1.119.1.9   2/1/2010 9:33:29 AM    Kemal Ediz
 *         cpv and scv implemented.
 * $
 * $Log[1]:
 *  130  TRIPS2 etis.bir.gov.ph1.119.1.9   2/1/2010 9:33:29 AM    Kemal Ediz
 *         cpv and scv implemented.
 * $
 * $Log[1]:
 *  130  TRIPS2 etis.bir.gov.ph1.119.1.9   2/1/2010 9:33:29 AM    Kemal Ediz
 *         cpv and scv implemented.
 * $
 * $Log[1]:
 *  130  TRIPS2 etis.bir.gov.ph1.119.1.9   2/1/2010 9:33:29 AM    Kemal Ediz
 *         cpv and scv implemented.
 * $
 * $Log[1]:
 *  130  TRIPS2 etis.bir.gov.ph1.119.1.9   2/1/2010 9:33:29 AM    Kemal Ediz
 *         cpv and scv implemented.
 * $
 * $Log[1]:
 *  130  TRIPS2 etis.bir.gov.ph1.119.1.9   2/1/2010 9:33:29 AM    Kemal Ediz
 *         cpv and scv implemented.
 * $
 * $Log[1]:
 *  130  TRIPS2 etis.bir.gov.ph1.119.1.9   2/1/2010 9:33:29 AM    Kemal Ediz
 *         cpv and scv implemented.
 * $
 */
public abstract class BackingBase implements Serializable {
    
    public static final Logger log = Logger.getLogger(BackingBase.class);
    GuiConfigurationKey key = null;
    String defaultJavascript ="";
    GuiConfiguration guiConfig = null;
    String guiFormID;
    String something;
    protected BackingSessionManager sessionManager;
    protected Boolean isFromPortal = null;
    
//    protected SecurityControlDelegate securityDelegate;
//    protected ScriptOperationsDelegate scriptOperationsDelegate;
//    protected RegistrationDelegate regDelegate;
//    protected UserAccount userAccount;
    protected ReferenceCodeDelegate refDelegate;
    
    protected String performAccessControl;
    protected List<String> pageAccessList;
    
    protected List<CasSecRolePageRel> securityRolesPageRelList;
    
    private static final String PAGE_SECURITY_ROLES_LIST = "PageSecurityRolesList";
    
    protected static final String SUBJECT_PERMISSIONS_LIST = "SubjectPermissionsList";
    
    protected Boolean discardChanges = false;

    public BackingBase() {
        this(null);
//        securityDelegate = new SecurityControlDelegate();
//        scriptOperationsDelegate = new ScriptOperationsDelegate();
//        regDelegate = new RegistrationDelegate();
        refDelegate = new ReferenceCodeDelegate();
    }
    
    private boolean isDefaultResource(String path) {
        boolean isDefaultResource = false;
        if ((-1 == path.indexOf("faces/index.jspx") ? false : true) || 
            (-1 == path.indexOf("login/LogOut.jspx") ? false : true) ||
            (-1 == path.indexOf("login/ConfigurationError.jspx") ? false : true) ||
            (-1 == path.indexOf("core/GenericSearch.jspx") ? false : true) ||
            (-1 == path.indexOf("login/Welcome.jspx") ? false : true) 
           ) {
            isDefaultResource = true;

        }
        return isDefaultResource;
    }
    
   /** 
    *  This is the method called when any .jspx page loads. 
    *  This loads all the parameters from application/session scope if available, if not retrieves and loads them into 
    *  appropriate scope to be used across to avoid loading multiple times for each page load
    **/
    public String getAccessControl(){
//        if(getPerformAccessControl()==null) {
//            performAccessControl = refDelegate.findSystemParameter(Constants.SystemParameterCode.PERFORM_ACCESS_CONTROL);
//            FacesUtil.storeOnSession(Constants.SystemParameterCode.PERFORM_ACCESS_CONTROL, 
//                                     performAccessControl);
//        } else {
//            performAccessControl = (String)getPerformAccessControl();
//        }
//        
//        if(getPageAccessList()==null){
//            pageAccessList = securityDelegate.getPageAccessList();
//            FacesUtil.storeOnApplicationScope(WebConstants.ApplicationScopeVariables.PAGE_ACCESS_LIST, 
//                                     pageAccessList);
//            log.debug("*** PageAccessList Loaded ***");
//        } else {
//            pageAccessList = (List<String>)getPageAccessList();
//            log.debug("*** PageAccessList already Available ***");
//        }
//        
//        if(getSecurityRolesPageRelList()==null){
////            securityRolesPageRelList = securityDelegate.getPageSecurityRolesRelByLoggedInUserRoles(getSubjectPermissions());
//            //TODO (VP) Following line will be enabled after enabling getSubjectPermissionsList() method
//            //securityRolesPageRelList = securityDelegate.getPageSecurityRolesRelByLoggedInUserRoles(getSubjectPermissionsList());
//            FacesUtil.storeOnSession(PAGE_SECURITY_ROLES_LIST, 
//                                     securityRolesPageRelList);
//            log.debug("*** PageSecurityRolesList Loaded for User *** "); 
//        } else {
//            securityRolesPageRelList = (List<CasSecRolePageRel>)getSecurityRolesPageRelList();
//            log.debug("*** PageSecurityRolesList already Available ***"); 
//        }
//        
//        if(performAccessControl!=null && Constants.YES.equalsIgnoreCase(performAccessControl)) {
//            log.debug("*** Access Control is to be performed ***");
//            checkAccess();    
//        } else {
//            log.debug("*** Access Control turned off ***");
//        }
        
        return null;
    }
    
    /** 
      * The method that performs the access control for the page being accessed. 
      * Retrieves all the security configurations from the session for the page being accessed.   
      * If no page relationship/configuration information is stored in the system, the access is granted. 
      * If the page access parameters from the presentation doesn't match with the stored configuration, then redirect the user to Authorization error page. 
     **/
    private void checkAccess(){
//        HttpServletResponse resp = (HttpServletResponse)FacesUtil.getFacesContext().getExternalContext().getResponse();
//        HttpServletRequest httpServletRequest = (HttpServletRequest)FacesUtil.getFacesContext().getExternalContext().getRequest();
//        String pageURL =  null;
//        String guiMode=null;
//        String config=null;
//        guiMode=getPageMode();
//        config=getPageConfig();
//        pageURL = FacesUtil.getFacesContext().getExternalContext().getRequestServletPath();
//        Map sessionMap = FacesUtil.getSessionScope();
//        Map processMap = FacesUtil.getProcessScope();
//        Map requestMap = FacesUtil.getRequestScope();
//        
//        if(!isDefaultResource(pageURL)) {
//        
//            if(guiMode==null ||config==null) {
//                if(guiMode==null &&  processMap!=null){
//                    guiMode = (String)processMap.get(WebConstants.ProcessScopeVariable.GUI_MODE);
//                    config = (String)processMap.get(WebConstants.ProcessScopeVariable.PAGE_CONFIG);    
//                }
//                if((guiMode==null || config==null) && requestMap!=null){
//                    if(guiMode==null){
//                        guiMode = (String)requestMap.get("GUI_MODE");    
//                    }
//                    if(config==null){
//                        config = (String)requestMap.get("CONFIG");    
//                    }
//                }
//            
//                if((guiMode==null || config==null) && sessionMap!=null){
//                    if(guiMode==null){
//                        guiMode = (String)sessionMap.get("GUI_MODE");
//                    }
//                    if(config==null){
//                        config = (String)sessionMap.get("CONFIG");    
//                    }
//                }
//                
//                if((guiMode==null || config==null) && httpServletRequest!=null){
//                    if(guiMode==null){
//                        guiMode = httpServletRequest.getParameter("GUI_MODE");
//                    }
//                    if(config==null){
//                       config = httpServletRequest.getParameter("CONFIG");    
//                    }
//                }
//                    
//              }
//        
//            boolean isUserPageAccessGranted = false;
//            boolean isPageAvailable=false;
//            boolean isUserKickedOut = false;
//            if( getUserAccount()!=null) {
//                List<CasSecRolePageRel> pageSecurityRoles = new ArrayList<CasSecRolePageRel>();
//                String pageRelativePath = pageURL;
//                log.debug(" ** Page Relative Path --> "+pageRelativePath);
//                log.debug(" ** Parameter GUI Mode = "+guiMode+", Config  = "+config);
//                
//                // Below loop is to add the roles specific to the page being accessed to a list to be used by the access logic below
//                for(CasSecRolePageRel securityRolesPageRel:securityRolesPageRelList){
//                    if(pageURL.equalsIgnoreCase(securityRolesPageRel.getPageURL())){
//                        pageSecurityRoles.add(securityRolesPageRel);
//                    }
//                } 
//
//                if(pageSecurityRoles!=null && pageSecurityRoles.size()>0) {
//                    for(CasSecRolePageRel pageSecurityRole:pageSecurityRoles) {
//                       if(pageURL.equalsIgnoreCase(pageSecurityRole.getPageURL())) {
//                           if( (pageSecurityRole.getSecRolePageConfigList()==null || 
//                               (pageSecurityRole.getSecRolePageConfigList()!=null && 
//                                pageSecurityRole.getSecRolePageConfigList().size()==0) ) &&
//                                pageSecurityRoles.indexOf(pageSecurityRole)==(pageSecurityRoles.size()-1) ) {
//                                    /* This is to allow the users to proceed further if the configurations for the page aren't available 
//                                     * even after reaching the end of the list of configurations */
//                                    isUserPageAccessGranted=true; 
//                                    log.debug(" *** No Page Configuration entry Provided  *** ");
//                                    break;
//                                } else {
//                                    for(CasSecRolePageConfig secRolePageConfig:pageSecurityRole.getSecRolePageConfigList()) {
//                                        isUserPageAccessGranted = false;
//                                        isUserKickedOut = false;
//                                        
//                                        if(config==null && guiMode==null){
//                                            isUserKickedOut = true;
//                                        }
//                                        /* 
//                                         * The below if block is to check if the config and gui mode information is available, 
//                                         * if yes then check if these are acceptible configurations for the logged in user
//                                         * */
//                                         if(secRolePageConfig.getPageConfig()!=null) {
//                                             if(config==null){
//                                                 // The config isn't available, redirect the user to Authorization Error page
//                                                 isUserPageAccessGranted=false;
//                                                 log.debug(" *** Config Not Provided  *** ");
//                                             } else {
//                                                 if(secRolePageConfig.getPageConfig().equalsIgnoreCase(config)){
//                                                     // valid configuration, set flag=true
//                                                      isUserPageAccessGranted=true; 
//                                                 } else {
//                                                     // redirect the user to Authorization Error page
//                                                      isUserPageAccessGranted=false; 
//                                                 }
//                                             }
//                                         } else {
//                                              // valid configuration, set flag=true as there is no configuration sent for this page from menu
//                                              isUserPageAccessGranted=true;
//                                         }
//                                         
//                                        if(secRolePageConfig.getPageMode()!=null) {
//                                            if(guiMode==null) {
//                                              // The gui mode isn't available, redirect the user to Authorization Error page 
//                                               isUserPageAccessGranted=false; 
//                                               log.debug(" *** Mode Not Provided  *** ");
//                                            } else {
//                                                if(secRolePageConfig.getPageMode().equalsIgnoreCase(guiMode) && isUserPageAccessGranted){
//                                                    // valid configuration, set flag=true
//                                                     isUserPageAccessGranted=true;
//                                                     log.debug(" ** 1. Breaking out of CasSecRolePageConfig loop, role used for access *** "+pageSecurityRole.getSecurityRole() );
//                                                     break;
//                                                } else {
//                                                    // redirect to login page, invalid page
//                                                     isUserPageAccessGranted=false; 
//                                                }
//                                            }
//                                        } else {
//                                              // valid page mode, set flag=true as there is no mode sent for this page from menu
//                                              isUserPageAccessGranted=true;
//                                              break;
//                                        }    
//                                    }
//                                }
//                            if(isUserPageAccessGranted){
//                                log.debug(" ** 2. Access to the page granted, breaking out of CasSecRolePageRel (first for) loop  --> "+pageRelativePath);
//                                break;
//                            } 
//                            if(isUserKickedOut){
//                                log.debug(" *** User is kicked out  *** ");
//                                break;
//                            }
//                       }
//                    }
//                } else {
//                    if(pageAccessList!=null && pageAccessList.size()>0){
//                        for(String page : pageAccessList){
//                            if(page.equalsIgnoreCase(pageURL)){
//                                isPageAvailable=true;
//                                break;
//                            }
//                        }
//                        if(!isPageAvailable){
//                            // This is to allow the users to proceed further if the relationship entry for the page isn't available
//                            isUserPageAccessGranted=true;     
//                            log.debug(" *** No Page Relationship entry Provided  *** ");    
//                        }
//                    } else {
//                        // No page entries available so proceed as usual.
//                        isUserPageAccessGranted=true; 
//                    }
//                    
//                }
//            }
//               if( (getUserAccount()!=null && !isUserPageAccessGranted) ) {
//                   try {
//                       log.debug(" ** Access to the page denied --> "+pageURL);
//                       resp.sendRedirect(FacesUtil.getFacesContext().getExternalContext().getRequestContextPath()+"/faces/login/AuthorizationError.jspx");
//                   } catch (IOException e) {
//                       e.printStackTrace();
//                       log.error(e.getLocalizedMessage(), e);
//                   }               
//               }
//        }
        
    }
    
    public BackingBase(String viewId) {
//        if(getLoggedInUser() == null && !isLoginPages(FacesContext.getCurrentInstance())){
//            FacesUtil.navigateViaNavigationString("globalLogout");           
//        }
        configureScopeVariablesAndStoreBackingBean(viewId);
    }
    
    private boolean isLoginPages(FacesContext facesContext) {
        boolean isLoginPages = false;
        final String viewId = facesContext.getViewRoot().getViewId();
        isLoginPages =  viewId.endsWith("index.jspx"); if(isLoginPages)return true;
        isLoginPages =  viewId.endsWith("login.jspx"); if(isLoginPages)return true;
        isLoginPages =  viewId.endsWith("Welcome.jspx"); if(isLoginPages)return true;
        isLoginPages =  viewId.endsWith("LogOut.jspx"); if(isLoginPages)return true;
        
         return isLoginPages;
    }
    

//    public UserAccount getUserAccount() {
//        return (UserAccount)FacesUtil.getFromSession(UserAccount.class.getName());
//    }
    
    /**
     * If there is any change to the scope variables that must be done before storing the backing bean to the stored backing beans list in the
     * session manager, first this method makes the changes. (like changing any variable value in the process scope)
     * Then stores all the backing bean information like process scopes, session scopes, the backing bean itself.
     * Then Create the worker for the backing bean and stores it.
     * @param viewId
     */
    protected void configureScopeVariablesAndStoreBackingBean(String viewId) {
        SessionWorker worker = getSessionWorker();
        sessionManager = 
            (BackingSessionManager)FacesUtil.getCreateOrGetManagedBeanValue(WebConstants.ManagedBean.BACKING_SESSION_MANAGER);
        if(worker != null) {
            if(viewId == null)
                sessionManager.addWorker(FacesUtil.getRootViewId(), worker, this); 
            else
                sessionManager.addWorker(viewId, worker, this); 
            sessionManager.storeBackingBeanInfoInSessionPage(this);
        }
        
        /*
         * Caller and CallbackHandler functionallity
         */
        if(getCaller() != null){
            getCaller().consume(this);
        }
    }
    

    
    public RequestContext getAdfFacesContext(){
        return RequestContext.getCurrentInstance();
    }
    
    /**
     * Allow to end its own job or work
     */
    public final void endWork(){
        sessionManager.getCurrentPage().setForcedEndState(true);
    }
    
    public SessionWorker getSessionWorker() {
        if(this.getClass().isAnnotationPresent(SessionWorker.class)){
            SessionWorker worker = this.getClass().getAnnotation(SessionWorker.class);
            return worker;
        }
        return null;
    }
    
    public List doGetData(String methodName, BackingBase backingBean, 
                          Map paramters) {
        return Collections.EMPTY_LIST;
    }

    public boolean doCondition(String methodName, BackingBase backingBean, 
                               Map paramters) {
        return false;
    }


    /**
     * Stub not to be implemeted
     * @param valueChangeEvent
     */
    public void dummyChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }
    
     /**
      * This method is invoked on by the caller 
      * @param methodName
      * @param output
      * @param called
      * @return
      */
     public String invokeHandler(String methodName, Serializable output, 
                                 BackingBase called) {
        return null;
     }
         
    /**
     * Expected format backingBean.methodName of the caller
     */
    protected ICallBackHandler getCaller(){
//        String proxyCallBackHandler;
//        proxyCallBackHandler = (String)RequestContext.getCurrentInstance().
//                getPageFlowScope().get("proxyCallBackHandler");
//       if(null == proxyCallBackHandler){
//           return null;
//       }else{
//        return (ICallBackHandler)FacesUtil.getManagedBeanValue(proxyCallBackHandler.substring(0,proxyCallBackHandler.indexOf(".")));
//       }
     return null;
    }
    
    /**
     * Handles the processing for business objects
     * @param _businessObject
     * @param _onSucessMessage
     * @param _outcome
     * @return
     */
    protected String handleProcessing(Serializable _businessObject, FacesMessage _onSucessMessage, String _outcome){
//        String proxyNavigation = null;
//        String proxyCallBackHandler = (String)RequestContext.getCurrentInstance().
//                    getPageFlowScope().get("proxyCallBackHandler");
//        
//        if(null != proxyCallBackHandler && !(_businessObject instanceof OutputType)){
//            ICallBackHandler caller = getCaller();
//            /*
//             * gets the method to invoke
//             */
//            proxyNavigation = caller.invokeHandler(
//                                        proxyCallBackHandler.substring(proxyCallBackHandler.indexOf(".")+1,
//                                        proxyCallBackHandler.length()),_businessObject,this);
//            
//            if(null != proxyNavigation){
//                RequestContext.getCurrentInstance().getPageFlowScope().put("proxyCallBackHandler",null);
//                RequestContext.getCurrentInstance().getPageFlowScope().remove("proxyCallBackHandler");
//            }
//        }
//        
//        if(null == _businessObject){
//            FacesUtil.addFacesErrorMessage(WebConstants.Messages.INVALID_BPEL_REPLY);
//            return navigateBack(null == proxyNavigation ? WebConstants.Navigation.SELF : proxyNavigation);
//        }else{
//            if(_businessObject instanceof OutputType){
//                return handleProcessing((OutputType)_businessObject);
//            }else{
//                FacesContext.getCurrentInstance().addMessage(WebConstants.Messages.CONFIRMATION,_onSucessMessage);
//                return null == proxyNavigation ? navigateBack(_outcome) : proxyNavigation;
//            }
//        }
        return null;
    }
    
    
    /**
     * Handles the processing for message objects for bpel processing
     * @param outputType
     * @return
     */
    protected String handleProcessing(OutputType outputType ){
        boolean isSuccessful = false;
        String proxyNavigation = null;
        String proxyCallBackHandler = null;
//        proxyCallBackHandler = (String)RequestContext.getCurrentInstance().
//                    getPageFlowScope().get("proxyCallBackHandler");
//        
//        if(null != proxyCallBackHandler){
//            if(log.isDebugEnabled()){
//                log.debug("proxyCallBackHandler listener session active");
//            }
//         
//            ICallBackHandler caller = getCaller();
//            if(null != caller){
//            /*
//             * gets the method to invoke
//             */
//            proxyNavigation = caller.invokeHandler(
//                                        proxyCallBackHandler.substring(proxyCallBackHandler.indexOf(".")+1,
//                                        proxyCallBackHandler.length()),
//                                         (Serializable) outputType, this);
//            }
//            if (log.isDebugEnabled()){
//                log.debug("proxyCallBackHandler: navigation " + proxyNavigation);
//            }
//            
//            if(log.isDebugEnabled()){
//                log.debug("proxyCallBackHandler listener session closed");
//            }
//            
//            if(null != proxyNavigation){
//                RequestContext.getCurrentInstance().getPageFlowScope().put("proxyCallBackHandler",null);
//                RequestContext.getCurrentInstance().getPageFlowScope().remove("proxyCallBackHandler");
//            }
//        }
//       
//        
//        
//        
//        if (null != outputType) {
//            
//            if( isSuccess(outputType) ){
//                isSuccessful = true;
//            }else{
//                if(outputType.getReturnStatus() == null || outputType.getReturnStatus().equalsIgnoreCase(Constants.BLANK)){
//                    FacesUtil.addFacesErrorMessage(WebConstants.Messages.INVALID_BPEL_REPLY);
//                    return null == proxyNavigation ? WebConstants.Navigation.SELF : proxyNavigation;
//                }
//            }
//        } else {
//            FacesUtil.addFacesErrorMessage(WebConstants.Messages.INVALID_BPEL_REPLY);
//            return null == proxyNavigation ? WebConstants.Navigation.SELF : proxyNavigation;
//        }
//
//        if(isSuccessful){
//            FacesUtil.addFacesInfoMessageForType(WebConstants.Messages.CONFIRMATION,outputType);
//            return null == proxyNavigation ? WebConstants.Navigation.CONFIRMATION : proxyNavigation;             
//        }else{
//            FacesUtil.addFacesErrorMessage(outputType);
//            return null == proxyNavigation ? WebConstants.Navigation.SELF : proxyNavigation;
//        }
        return null;
    }
    
    /**
     * Determines if the outputType was successfull
     * @param outputType
     * @return
     */
    protected boolean isSuccess(OutputType outputType) {
        if(null == outputType){
            return false;
        }else
        if(null == outputType.getReturnStatus()){
            return false;
        }else
            if(outputType.getReturnStatus() != null && outputType.getReturnStatus().equalsIgnoreCase(Constants.FAIL)){
                return false;
            }
        
        return true;
    }
    
    /**
     * Apply configuration rules to a jspx page by accessing the GuiConfiguration class.
     * The configuration object is accessed via the GuiConfigurationManager and takes two parameters, the
     * page name and the mode.
     * 
     * Two public methods are exposed by the class, getComponents() and getRules(componentName).
     * 
     * getComponents returns a list of components contained on the page (the pagename that was passed through
     * when call the GuiConfiguration instance).
     * getRules returns a list of configuration rules, in a name-data format, that apply to the 
     * component name that was passed through.
     * 
     * Each component is 'located' on the jspx page that is being configured and the rules applied.
     * The HtmlBody is then returned to the onload event of the page.
     * 
     * @return
     */
    public String getRun() {
        return getRun(null);
    }
    
    /**
     * Apply configuration rules to a jspx page by accessing the GuiConfiguration class.
     * The configuration object is accessed via the GuiConfigurationManager and takes two parameters, the
     * page name and the mode.
     * 
     * Two public methods are exposed by the class, getComponents() and getRules(componentName).
     * 
     * getComponents returns a list of components contained on the page (the pagename that was passed through
     * when call the GuiConfiguration instance).
     * getRules returns a list of configuration rules, in a name-data format, that apply to the 
     * component name that was passed through.
     * 
     * Each component is 'located' on the jspx page that is being configured and the rules applied.
     * The HtmlBody is then returned to the onload event of the page.
     * 
     * @return
     */
    public String getRun(String formId) {
        HttpServletResponse resp = (HttpServletResponse)FacesUtil.getFacesContext().getExternalContext().getResponse();
        HttpSession session = (HttpSession)FacesUtil.getFacesContext().getExternalContext().getSession(false);
        
//        if(getUserAccount() == null){
//            try {
//                resp.sendRedirect(FacesUtil.getFacesContext().getExternalContext().getRequestContextPath()+"/ExpiryNotice");
//                return null;
//            } catch (IOException e) {
//                log.error(e.getLocalizedMessage(), e);
//            }
//        }
        try {
           return shouldRunConfiguration() ? runGuiConfiguration(formId) : defaultJavascript;           
        } catch (GuiConfigurationException e) {
                
            log.error("Error found when running gui configuration: ",e);
            
           
            FacesUtil.getFacesContext().getExternalContext().getSessionMap().put(WebConstants.ProcessScopeVariable.GUI_MODE,getPageMode());
            FacesUtil.getFacesContext().getExternalContext().getSessionMap().put(WebConstants.ProcessScopeVariable.PAGE_CONFIG,getPageConfig());
            
            try {
                 resp.sendRedirect(FacesUtil.getFacesContext().getExternalContext().getRequestContextPath()+"/faces/login/ConfigurationError.jspx");
            } catch (IOException f) {
                FacesUtil.addFacesErrorMessage(WebConstants.Messages.FATAL_ERROR,e.getMessage());
                log.error(f.getLocalizedMessage(), f);
            }
            
            try {
                if(null == getLoggedInUser()){
                 FacesUtil.removeFromSession("jaas.subject");
                 resp.sendRedirect(FacesUtil.getFacesContext().getExternalContext().getRequestContextPath()+"/faces/index.jspx");
                     
                }
            } catch (IOException f) {
                FacesUtil.addFacesErrorMessage(WebConstants.Messages.FATAL_ERROR,f.getMessage());
                log.error(f.getLocalizedMessage(), f);
            }
            return defaultJavascript;
            
        } catch (NoSuchMethodException e) {
            FacesUtil.addFacesErrorMessage(WebConstants.Messages.FATAL_ERROR,e.getMessage());
            log.error(e.getLocalizedMessage(), e);
            return null;
        }catch(Exception e){
            FacesUtil.addFacesErrorMessage(WebConstants.Messages.FATAL_ERROR,e.getMessage());
            log.error(e.getLocalizedMessage(), e);
        }
        
        
        try {
            if(null == getLoggedInUser()){
             FacesUtil.removeFromSession("jaas.subject");
             resp.sendRedirect(FacesUtil.getFacesContext().getExternalContext().getRequestContextPath()+"/faces/index.jspx");
            }
        } catch (IOException f) {
            FacesUtil.addFacesErrorMessage(WebConstants.Messages.FATAL_ERROR,f.getMessage());
            log.error(f.getLocalizedMessage(), f);
        }
        
        return null;
    }
    
    private boolean isSessionInvalid(HttpServletRequest httpServletRequest) 
    { 
      
    boolean sessionInValid = (httpServletRequest.getRequestedSessionId() != null)  
      
    && !httpServletRequest.isRequestedSessionIdValid();  
    
        
        String requestedSession = httpServletRequest.getRequestedSessionId();
        String currentWebSession = httpServletRequest.getSession().getId();
        boolean sessionOk = 
            currentWebSession.equalsIgnoreCase(requestedSession);
                  
    return sessionInValid && !sessionOk;  
      
    }  
    
    protected boolean shouldRunConfiguration(){
       return true;
    }
    
    /**
     * Runs the GUI Confiuration for this viewRootId and this formId 
     * on the page.
     * <p>
     * The viewRootId is required, the formId is optional.
     * <br>The formId is used when a single page has different parent forms 
     * which requires advanced configuration. This was specifically created for the
     * Table Management Screen.
     *
     * @return a javascript string
     * @throws NoSuchMethodException
     * @throws GuiConfigurationException
     */
    protected String runGuiConfiguration(String formId) throws NoSuchMethodException, 
                                                GuiConfigurationException { 
//        if(log.isDebugEnabled()){
//            log.debug("Accessing configuration parameters......");
//        
//            log.debug("Loading..... "  + "\n" +
//                      "Faces ViewRoot_Id:" + getViewRootId() + "\n" +
//                      "Page Mode: " + getPageMode()  + "\n" +
//                      "Page Configuration: " + getPageConfig()); 
//        
//            log.debug("Accessing Gui-Configuration from repository ......");
//        }
//            
//        /*
//         * Loads the configuration based on paramters 
//         */
//         guiConfig = 
//            new GuiConfiguration(getViewRootId(),getPageConfig(),getPageMode(), formId);
//            
//        
//        /*
//         * each user has its own security which is apply to the configuration
//         */
//        List<GuiPageConfig> configurationList = guiConfig.applySecurity(getSubjectPermissions());
//        
//        return applyConfiguration(configurationList,guiConfig.getFormID());  //apply the gui configuration to the page      
        return null;
    }
    
    /**
     * Validates the gui configured fields
     * @return
     */
    protected boolean validateBeforeSubmission() {
        boolean passValidation = true;
//        ArrayList<FacesMessage> messages = new ArrayList<FacesMessage>();
//        JsfReferencedObject jro = null;
//        if(guiConfig == null) {
//                // we should run the gui configuration again because in this page, there can be two or more different backing beans
//                // representing the page and while opening the page, the gui configuration may have run in one of the backing beans
//                // but the validation can be done in another backing bean. So we should obtain the gui configuration again, so that
//                // we can go on the validation.
//                try {
//                        runGuiConfiguration(getUIViewRoot().getId());
//                } catch (NoSuchMethodException e) {
//                        return true;// if there is no gui configuration, return true do not continue on validation
//                } catch (GuiConfigurationException e) {
//                        return true;// if there is no gui configuration, return true do not continue on validation
//                }
//                if(guiConfig == null)
//                        return true;
//        }
//
//        String ParentId=null;
//
//        for( GuiPageConfig guiPageConfig: guiConfig.getConfigList()){
//
//                GuiPageComponent component = guiPageConfig.getGuiPageComponent();
//                String componentId = component.getComponentId();
//                String formId = getProxyFormId();
//                formId = null == formId ? guiFormID : formId;
//                String componentName = formId+":"+componentId;
//                // get the component to be configured using the formId and component id
//                UIComponent comp = getUIViewRoot().findComponent(componentName);
//                if(log.isDebugEnabled())log.debug(" Component not found " + formId +":"+componentId + " -- " + comp);
//                //if component was found the warn the developer     
//                if (comp == null) {
//                        log.warn(" Component not found " + formId +":"+componentId);
//                        if(log.isDebugEnabled()){
//                                //  FacesUtil.addFacesErrorMessage(" Component not found " + formId +":"+componentId);
//                        }
//                }else{            
//                        /*
//                         * Wrapper class for jsf/adf component
//                         */
//                        jro = new JsfReferencedObject(comp);
//                        if(ParentId == null){
//                                ParentId = comp.getParent().getId();
//                        }
//                    List<FacesMessage> compValidationMsg =  new ArrayList<FacesMessage>();
//                    getValidationMessages(jro, guiPageConfig, compValidationMsg);
//                        if(compValidationMsg.isEmpty() ){
//                                //do nothing  
//                        }else{
//                                messages.addAll(compValidationMsg);
//                                passValidation = false;  
//                        }               
//                }
//        }
//       
//
//        FacesUtil.addFacesErrorMessageList(messages);
        return passValidation;
    }
    
    


    public boolean checkComponent(UIComponent checkComp){
            boolean result =false;
            for( GuiPageConfig guiPageConfig: guiConfig.getConfigList()){
                    GuiPageComponent component = guiPageConfig.getGuiPageComponent();
                    if (component.getComponentId().equals(checkComp.getId())){
                            result = true;
                            break;
                    }


            }

            return result;
    }

    
    
     /**
      * @return a array of permission the user has
      */
     public final String[] getSubjectPermissions() {
         /*
          * Get the subject and it roles
          */
         String[] permissions = null;
//         Subject subject = (Subject)FacesUtil.getSessionScope().get("jaas.subject");
//         if(null == subject){
//             String username = getLoggedInUser(); 
//             permissions = null;
//             if(username != null){
//                 List<String> roles = 
//                     securityDelegate.findRolesHavingUser(username);
//                 if(roles != null){
//                    permissions = roles.toArray(new String[roles.size()] );
//                 }
//             }
//             return permissions;
//         }else{
//             Set<TripsSSOPrincipal> principals = subject.getPrincipals(TripsSSOPrincipal.class);
//             String[] permissions = new String[principals.size()];
//             /*
//              * Grant access to the menu item for which this subject has permission
//              */
//             int count = 0; 
//             for(TripsSSOPrincipal principal:principals){
//                 permissions[count] = principal.getName();
//                 count++;
//             }
//             return permissions;
//         }
           return permissions;
     }
    
     private String applyConfiguration(List<GuiPageConfig> _configList, final String _guiFormID) {
         // loop through the components
         this.guiFormID = _guiFormID;
//         for( GuiPageConfig guiPageConfig: _configList){
//         
//             GuiPageComponent component = guiPageConfig.getGuiPageComponent();
//             String componentId = component.getComponentId();
//             String formId = getProxyFormId();
//             formId = null == formId ? _guiFormID : formId;
//             String componentName = formId+":"+componentId;
//             // get the component to be configured using the formId and component id
//              UIComponent comp = null;
//             try {
//                 comp = getUIViewRoot().findComponent(componentName);
//             }
//             catch (Exception e) {
//                 log.warn(" Component not found " + componentName);
//             }
//             
//             //if component was found the warn the developer     
//             if (comp == null) {
//                 log.warn(" Component not found " + formId +":"+componentId);
//                 FacesUtil.addFacesErrorMessage(" Component not found " + formId +":"+componentId);
//             }else{
//             
//                if(log.isDebugEnabled()){
//                     log.debug("Applying configuration for component: " + componentName 
//                     + " Disabled: " + guiPageConfig.getDisabled()
//                     + " ReadOnly: " + guiPageConfig.getReadOnly()
//                     + " Rendered: " + guiPageConfig.getRendered()
//                     + " Optional: " + guiPageConfig.getOptional());
//                }
//                
//                /*
//                 * Wrapper class for jsf/adf component
//                 */
//                JsfReferencedObject jro = new JsfReferencedObject(comp);
//                
//                if(guiPageConfig.getRequired()){
//                    if(setUpValidateOnSubmission()){
//                        jro.setRequired(false);
//                        jro.setShowRequired(true);
//                    }else{
//                        jro.setRequired(guiPageConfig.getRequired() == true && guiPageConfig.getOptional() == false); 
//                    }
//                }
//                
//                jro.setDisabled(guiPageConfig.getDisabled());
//
//                if (guiPageConfig.getDisabled()) {
//                     setComponentsInlineStyle(jro);                                       
//                }
//                
//                jro.setReadOnly(guiPageConfig.getReadOnly());
//                jro.setRendered(guiPageConfig.getRendered());
//                
//                jro.setOptional(guiPageConfig.getOptional() == true);
//                     
//
////                 jro.applyValidation(guiPageConfig);
//             }
//         }
         
         return defaultJavascript;
     }
     
    /**
     * Method adds inline style to display disabled components clearly.
     * @param jro
     */
//     private void setComponentsInlineStyle(JsfReferencedObject jro){
////         if (((UIComponent)jro.getJsfComponent()) instanceof CoreInputText ||                        
////             ((UIComponent)jro.getJsfComponent()) instanceof CoreInputDate || 
////             ((UIComponent)jro.getJsfComponent()) instanceof CoreSelectBooleanCheckbox || 
////             ((UIComponent)jro.getJsfComponent()) instanceof CoreSelectBooleanRadio || 
////             ((UIComponent)jro.getJsfComponent()) instanceof CoreInputListOfValues || 
////             ((UIComponent)jro.getJsfComponent()) instanceof CoreSelectItem || 
////             ((UIComponent)jro.getJsfComponent()) instanceof CoreSelectManyCheckbox || 
////             ((UIComponent)jro.getJsfComponent()) instanceof CoreSelectManyShuttle || 
////             ((UIComponent)jro.getJsfComponent()) instanceof CoreSelectOneChoice || 
////             ((UIComponent)jro.getJsfComponent()) instanceof CoreSelectOneRadio || 
////             ((UIComponent)jro.getJsfComponent()) instanceof CoreSelectOneListbox || 
////             ((UIComponent)jro.getJsfComponent()) instanceof CoreSelectManyListbox) {             
////
////                 Object typeClass =((UIComponent)jro.getJsfComponent()).getValueBinding("value").getValue(FacesUtil.getFacesContext());
////                 if(typeClass instanceof Number){
////                     jro.setProperty("inlineStyle", 
////                                     "background-color:rgb(255,255,255);font-weight: bold;text-align:right;");
////                 }else{
////                     jro.setProperty("inlineStyle", 
////                                     "background-color:rgb(255,255,255);font-weight: bold;");
////                 }
////         } 
//     } 
         
    /**
     * Validations are the show Required fields on form submission
     * @return true if the showRequired fields show be validated
     */
    protected boolean setUpValidateOnSubmission(){
        return false;
    }
    protected final String getLoggedInUser(){
//        HomeControlPanel home = (HomeControlPanel)FacesUtil.getFromSession("homeController");
//        if(null == home)
//            return null;
//        else
//        return null != home.getUserAccount() ? home.getUserAccount().getUserName() : null;
return null;
    }
    
    
    protected final Long findLoggedInUserId() {
       
        String userName = getLoggedInUser();
//        RefOffStaff staff = 
//            regDelegate.findOfficeStaff(userName);
//        
//        if(staff != null) {
//            return staff.getId();
//        }
        return null;
        
    }
    
    protected final Timestamp getCurrentTime(){
        return new Timestamp(System.currentTimeMillis());
    }
    
    protected Calendar getCurrentDate(){
        Calendar now = Calendar.getInstance();
        return now;
    }
    
    /**
     * Service Locator looks up the validate facade SLSB.
     * @return
     * @throws ServiceLocatorException
     */
//    public ValidationFacadeBeanLocal getValidationService() throws ServiceLocatorException {
//        ValidationFacadeBeanLocal validationService = null;
//            validationService = 
//                (ValidationFacadeBeanLocal)new ServiceLocator().
//                            getLocalEJB(ServiceLocator.Services.VALIDATION_FACADE);    
//        
//        return validationService;
//    }
  
    /**
     * Acts on behalf of the any form Id, the form must have a 
     * static form id
     * @return
     */
    protected String getProxyFormId(){
        return null;
    }
    
    public String configurationRequired(){
        return WebConstants.Navigation.CONFIGURATION_ERROR;
    }
    
    private UIComponent getUIViewRoot(){
        return FacesUtil.getFacesContext().getViewRoot();
    }
    private String getViewRootId() {
       return  FacesUtil.getFacesContext().getViewRoot().getViewId();
    }
    
    public String getPageMode() {
       String guiMode = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(WebConstants.ProcessScopeVariable.GUI_MODE);
       if(guiMode == null)
          guiMode = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("GUI_MODE"); 
       return guiMode;
    }

    protected String getFormId() {
        return null;
    }
    
    protected String getPageConfig() {
       String pageConfig = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(WebConstants.ProcessScopeVariable.PAGE_CONFIG);
       if(pageConfig == null)
           pageConfig = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("CONFIG");
       return pageConfig;
    }
    
    public boolean isViewMode(){
       return getPageMode() != null ? Constants.Modes.VIEW.equalsIgnoreCase(getPageMode()) : false;
    }
    
    protected String getPageModeForReturn() {
        return (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(WebConstants.ProcessScopeVariable.GUI_MODE_FOR_RETURN);
    }
    
    protected String getPageConfigForReturn() {
       return (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(WebConstants.ProcessScopeVariable.PAGE_CONFIG_FOR_RETURN);
    }
    
    public boolean isAddMode(){
        return getPageMode() != null ? Constants.Modes.ADD.equalsIgnoreCase(getPageMode()) : false;
    }
    
    public boolean isEditMode(){
        return getPageMode() != null ? Constants.Modes.EDIT.equalsIgnoreCase(getPageMode()) : false;
    }

    public boolean isInTransitMode(){
        return getPageMode() != null ? Constants.Modes.INTRAN.equalsIgnoreCase(getPageMode()) : false;
    }
    
    public boolean isBatchMode(){
        return getPageMode() != null ? Constants.Modes.BATCH.equalsIgnoreCase(getPageMode()) : false;
    }
    
    public String getCurrentPageMode(){
        RequestContext adfContext = RequestContext.getCurrentInstance();
        String pageMode = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(WebConstants.ProcessScopeVariable.GUI_MODE);
       
        return "Global.GuiMode."+pageMode;
    }

    //TODO (VP) This method needs to be removed as we have goCancelNav and this method just calls goCancelNav but need to
    //find the usage of goPrevious and replace with goCancelNav. 
    public String goPrevious() {     
//        String prevNav = (String)AdfFacesContext.getCurrentInstance().getProcessScope().get("processScopePreviousPage");
//        return null == prevNav ? WebConstants.Navigation.HOME : prevNav;
        return goCancelNav();
    }
    
    /**
     * Used to indicate which navigation should be taken on a cancel button operation
     * @return
     */
    public String goCancelNav(){
       goPreviousByLookingAtTheFlowOfPages();
       return null;
    }
    
    /**
     * Contains the general things that must be done while closing a popup. 
     * i.e. Deleting the pop up variable from the session scope which indicates that we are in a pop up page.
     */
    protected void returnFromDialog(Object returnValue, Map returnParameters) {
       try{ 
        // Also clear the pop up related flow variables in the session manager because we are closing the pop-up,
        // and they will not be used anymore, so we should clear them.
        
        // basic return operation in order to close the pop-up.
        RequestContext.getCurrentInstance().closeDialog(returnValue);
        
        if(sessionManager != null) {
            try{
                // we should remove this backing bean from the session scope, because we are leaving the page now. If we come
                // this page later from the previous page, and if we dont remove this backing bean from the session scope now,
                // the page will not be opened with the new values, page will be opened with the old values. Because of that,
                // we should remove this backing bean from the session scope.
                if(sessionManager.getPopupCurrentPage() != null && sessionManager.getPopupCurrentPage().size() != 0){//HH added to not cause index outof bounds
                    endPageStateForcibly(sessionManager.getPopupCurrentPage().get(sessionManager.getPopupCurrentPage().size() - 1));                
                    sessionManager.getPopupCurrentPage().remove(sessionManager.getPopupCurrentPage().size() - 1);
                 
                    if(sessionManager.getPopupFlowOfPages() != null && sessionManager.getPopupFlowOfPages().size() > 0) {
                        List<SessionPage> removablePages = 
                            sessionManager.getPopupFlowOfPages().get(sessionManager.getPopupFlowOfPages().size() - 1);
                        for(SessionPage removablePage:removablePages) {
                            endPageStateForcibly(removablePage);
                        }
                        sessionManager.getPopupFlowOfPages().remove(sessionManager.getPopupFlowOfPages().size() - 1);                                    
                    }                   
                }                
            }catch(Exception e){
                //TODO: check why fail on invalid index hhill
                log.error(e.getLocalizedMessage(), e);
                return;
            }
            if(sessionManager.getPopupFlowOfPages() !=null && sessionManager.getPopupFlowOfPages().isEmpty()) {
                // Delete the pop up variable from the session scope which indicates that we are in a pop up page if there is
                // no popup left open.
                FacesUtil.getSessionScope().remove(WebConstants.SessionVariable.IN_POP_UP_FLOW);
            }
        }
       }catch(Exception e){
           log.error(e.getLocalizedMessage(), e);
           return;
       }         
    }
    
    /**
     * Cleans ups the session object used to manage the link
     * between the parent table and table's row in the next page.
     */
    protected void cleanUpSessionObjects() {
        // put back the original session scope variables that are used for this backing bean.
        sessionManager.putBackSessionScopeVarsToSessionScope();
    }
    
    /**
     * Looks at the flow of pages beginning from the menu click and finds the previous flow which is the previous page. Using the previous page url,
     * navigates to the previous page. If no previous page can be found, then defaultly returns to the welcome page.
     */
    public void goPreviousByLookingAtTheFlowOfPages() {
        
        
        String previousPageUrl = WebConstants.ViewId.WELCOME_VIEW_ID;
        SessionPage removedPage = null;
        if(sessionManager != null){        
            ArrayList<SessionPage> flowOfP = sessionManager.getCorrectFlowOfPages();            
            if(flowOfP != null && flowOfP.size() > 1) {
                // take the 2nd last view id which will be navigated.
                SessionPage previousPage = flowOfP.get(flowOfP.size() - 2);
                previousPageUrl = previousPage.getViewId();
                
                // delete the last one which will not be important because we are leaving that page.
                removedPage = flowOfP.remove(flowOfP.size() - 1);
                
                // we should remove this backing bean from the session scope, because we are leaving the page now. If we come
                // this page later from the previous page, and if we dont remove this backing bean from the session scope now,
                // the page will not be opened with the new values, page will be opened with the old values. Because of that,
                // we should remove this backing bean from the session scope.
                 endPageStateForcibly(removedPage);
                
                sessionManager.setCorrectCurrentPage(previousPage);
                // if there is backing bean stored for that page, put that backing bean(s) 
                // to the session scope in order to use that backing bean again.
                previousPage.putBackingBeansToSessionScope();
                previousPage.putScopeVariablesToBack();
                
            }
        }
        //cleanUpSessionObjects();
        
        if(previousPageUrl.contains(WebConstants.ViewId.WELCOME_VIEW_ID)){
            Map sessionMap = 
                FacesUtil.getFacesContext().getExternalContext().getSessionMap();
            BackingSessionManager backingSessionManager = 
                (BackingSessionManager)sessionMap.get(WebConstants.ManagedBean.BACKING_SESSION_MANAGER);

            if (null != backingSessionManager) {
                backingSessionManager.cleanUpSystem();
            }
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            Enumeration<String> en = session.getAttributeNames();
            while(en.hasMoreElements()){
                    String name = en.nextElement();
                    if(name.contains("oracle.adfinternal.view.faces.application.ProcessSope")){
                            session.removeAttribute(name);
                    }
            }
        }
        
        // navigate to the previous page.
        FacesUtil.navigate(previousPageUrl);
    }
    
    public void passDataToBackingTableHandler(String backingTableHandlerName, Object[] data, String shortDesc) {
        BackingTableHandler tableHandler = new BackingTableHandler(data, shortDesc);
        FacesUtil.setManagedBeanValue(backingTableHandlerName, tableHandler);
    }
    
    public void passDataToBackingTableHandler(String backingTableHandlerName, Object[] data) {
        BackingTableHandler tableHandler = new BackingTableHandler(data);
        FacesUtil.setManagedBeanValue(backingTableHandlerName, tableHandler);
    }
    
    public void passDataToBackingTableHandler(String key, String backingTableHandlerName, Object[] data) {
        BackingTableHandler tableHandler = (BackingTableHandler)FacesUtil.getManagedBeanValue(backingTableHandlerName);
        if(tableHandler == null) {
            tableHandler = new BackingTableHandler();
            FacesUtil.setManagedBeanValue(backingTableHandlerName, tableHandler);   
        }
        tableHandler.putData(key, data);
    }
    
    public void passDataToBackingTableHandler(String backingTableHandlerName, List data) {
        BackingTableHandler tableHandler = new BackingTableHandler(data);
        FacesUtil.setManagedBeanValue(backingTableHandlerName, tableHandler);
    }
    
    public void passDataToBackingTableHandler(String backingTableHandlerName, List data, String shortDesc) {
        BackingTableHandler tableHandler = new BackingTableHandler(data, shortDesc);
        FacesUtil.setManagedBeanValue(backingTableHandlerName, tableHandler);
    }
    
    public Object[] getDataFromBackingTableHandler(String backingTableHandlerName) {
        
        BackingTableHandler tableHandler = (BackingTableHandler)FacesUtil.getManagedBeanValue(backingTableHandlerName);
        if(tableHandler == null)
            return null;
        return tableHandler.getTableHandler().getData();
    }
    
    public Object[] getDataFromBackingTableHandler(String backingTableHandlerName, String key) {
        
        BackingTableHandler tableHandler = (BackingTableHandler)FacesUtil.getManagedBeanValue(backingTableHandlerName);
        if(tableHandler == null)
            return null;
        return tableHandler.getTableHandler(key).getData();
    }

    public Object getSelectedRowDataFromBackingTableHandler(String backingTableHandlerName) {
        
        BackingTableHandler tableHandler = (BackingTableHandler)FacesUtil.getManagedBeanValue(backingTableHandlerName);
        if(tableHandler == null)
            return null;
        return tableHandler.getTableHandler().getTable().getSelection();
    }
 
 
    
    /**
     * Return back to generic search and refresh by searching again after addding or editing an item
     * 
     * @return
     */
    public String navigateBackToGenericSearchAndRefreshSearch(){
        
        if(sessionManager != null){
        
//            BackingGenericSearch  backingGenericSearch 
//                        = (BackingGenericSearch)sessionManager.getBackingBeanInPageFlow(WebConstants.ManagedBean.GENERIC_SEARCH);
//                        
//            if(backingGenericSearch != null 
//                            && backingGenericSearch.getResultList()!= null 
//                            && backingGenericSearch.getResultList().size() != 0 ){
//                // search was made before coming this page so search again.
//                backingGenericSearch.search();
//            }
        }

        return navigateBack(WebConstants.ViewId.GENERIC_SEARCH_ID); 
    }
    
    
    /**
      * Before navigating back to the page url given, this method finds the page that we want to navigate to, and delete the 
      * other pages after this page from the flow of pages list. Then it stores the corresponding page information to the scope.
      * After that it navigates to the page. 
      * 
      * The only difference of this method and goPreviousByLookingAtTheFlowOfPages method is : 
      * 
      * goPreviousByLookingAtTheFlowOfPages method just returns to the previous page, but this method can return back to any
      * page that is in the flow and can configure the flow of pages.
      * 
      * @param pageUrl
      */
     public String navigateBack(String pageUrl) {
         if(pageUrl == null)
             return null;
         // If it is welcome page, there is no need to do anything, just navigation.
         if(pageUrl.equals(WebConstants.ViewId.WELCOME_VIEW_ID)) {
             return WebConstants.Navigation.HOME;
         }
         if(sessionManager != null){        
             ArrayList<SessionPage> flowOfP = sessionManager.getCorrectFlowOfPages();            
             if(flowOfP != null && flowOfP.size() > 1) {
                 // the index of the page url that we want to navigate to.
                 int indexofPageUrl = 0;
                 for (indexofPageUrl = 0; indexofPageUrl < flowOfP.size(); indexofPageUrl++)  {
                     SessionPage page = flowOfP.get(indexofPageUrl);
                     if(page.getViewId() != null && page.getViewId().equals(pageUrl)) {
                         break;
                     }
                 }
                 if(indexofPageUrl >= flowOfP.size() - 1)
                     return null;
                 // delete the ones which will not be important because we skipping these pages.                    
                 for (int i = indexofPageUrl + 1; i < flowOfP.size(); )  {
                     // we should remove this backing bean from the session scope, because we are leaving the page now. If we come
                     // this page later from the previous page, and if we dont remove this backing bean from the session scope now,
                     // the page will not be opened with the new values, page will be opened with the old values. Because of that,
                     // we should remove this backing bean from the session scope.
                     endPageStateForcibly(flowOfP.get(i));
                     flowOfP.remove(i);
                 }
                 
                 SessionPage page = flowOfP.get(flowOfP.size() - 1);
                 
                 sessionManager.setCorrectCurrentPage(page);
                 // if there is backing bean stored for that page, put that backing bean(s) 
                 // to the session scope in order to use that backing bean again.
                 page.putBackingBeansToSessionScope();
                 page.putScopeVariablesToBack();
                 
             }
         }
         
         cleanUpSessionObjects();
         // navigate to the previous page.
         FacesUtil.navigate(pageUrl);
         return null;
     }
     
     /**
     * Ends page forcibly and remove its backing bean and all of its variables.
     * @param removablePage
     */
     private void endPageStateForcibly(SessionPage removablePage) {
         // we should remove this backing bean from the session scope, because we are leaving the page now. If we come
         // this page later from the previous page, and if we dont remove this backing bean from the session scope now,
         // the page will not be opened with the new values, page will be opened with the old values. Because of that,
         // we should remove this backing bean from the session scope.
         SessionWorker worker = getSessionWorker();
         if(worker != null) {
             String backingBeanName = worker.managedBeanName();
             if(backingBeanName != null) {
                 // force to delete.
                 removablePage.setForcedEndState(true);
             }
         }
         sessionManager.trackEndState(removablePage, null);
     }
    
//    public void getValidationMessages(JsfReferencedObject jro,GuiPageConfig guiPageConfig,List<FacesMessage> validationMessages){
////            ValMessageStatic valMessageStatic  = null;
//           
//            String workflow = null;
//            String messageType = null;
//            String property = null;
//            Object message = null;
//            jro.isValidDateComponet(validationMessages);
//            if( jro.isRendered() && jro.isShowRequired() && jro.hasNoValue() && 
//                            (guiPageConfig.getDisabled()!=null && !guiPageConfig.getDisabled())){//validate as required
//               FacesMessage fm = jro.validateRequired();
//               if(null != fm && noDuplicate(validationMessages,fm)){
//                validationMessages.add(fm);
//               }else{
//                   if(log.isDebugEnabled())log.debug("jro " + jro);
//               }
//            }//else
////              if(jro.isValueBindingPresent()){
////                /*
////                 * The validation service requires a field to be message bound
////                 * for the message type
////                 */
////                String backingBeanName = jro.getBackingBeanName();
////                
////                Object backingBean = FacesUtil.getManagedBeanValue(backingBeanName);
////                
////                String messageTypeEL =  jro.getValueOfValueBinding();
////                if(-1 == messageTypeEL.indexOf(".")){
////                  log.warn("Could not find member variable for EL " + messageTypeEL);
////                }else{
////                    String messageTypeWithOutEL = messageTypeEL.substring(0,messageTypeEL.indexOf("."));
////                    
////                    String messageTypeMemberName = messageTypeEL.substring(messageTypeEL.indexOf(".")+1,messageTypeEL.length());
////                     
////                    
////                    try {
////                        message = 
////                                ReflectionHelper.invokeGetter(backingBean,messageTypeWithOutEL);
////                    } catch (NoSuchMethodException e) {
////                        FacesUtil.addFacesErrorMessage("Validation",e);
////                    }
////                    if(null == message) {
////                        //do nothing
////                    }else{
////                        workflow = getPageConfig();
////                        messageType = message.getClass().getSimpleName();
////                        property = messageTypeMemberName;
////                        
//////                       valMessageStatic  =  getValidationService().queryValMessageForGui(getPageConfig(),messageType,property);
////                       
////                    }
////                }
////            }
//           
//               
//           /*
//            * Based on the validation set the component required attribute
//            */
////           if(null == valMessageStatic){
////                log.warn("Validation not found for component ");     
////           }else{                    
//                
//               /*
//                * appy the validation to the adf/jsf component
//                */
////              jro.applyValidation(valMessageStatic,FacesUtil.getFacesContext(),message);
//             
////           } 
//           
////           return validationMessages;
//    }
    
    /**
     * When we navigate to a page and return back to the original page, if we have tabs in the original page,
     * we were losing the previously opened tab and after returning back, always the first tab became disclosed.
     * In order to solve that, we have a generic method which helps remaining the state of the disclosed property of
     * the tabs. This method will be called while navigating back to the original page, and the id of the disclosed tab
     * will be given to the request scope in order to protect the state of the tabs.
     * @param showOneTab
     */
//    public void setRespectiveTabOnTop(CorePanelTabbed showOneTab){
//        if (FacesUtil.getFromRequest(WebConstants.RequestVariable.DISCLOSE_TAB_ID) != null) {
//            String tabId = (String)FacesUtil.getFromRequest(WebConstants.RequestVariable.DISCLOSE_TAB_ID);
//            if (tabId != null && !tabId.equals(Constants.BLANK)){
//                for(Object obj:showOneTab.getChildren()){
//                    CoreShowDetailItem tab = (CoreShowDetailItem)obj;
//                    if (tab.getId().equals(tabId)){
//                        tab.setDisclosed(true);
//                    }else{
//                        tab.setDisclosed(false);
//                    }
//                }
//            }
//            FacesUtil.getRequestScope().remove(WebConstants.RequestVariable.DISCLOSE_TAB_ID);
//        }       
//    }
    
    /**
     * Checks whether we are in a popup page for this backing bean or not.
     * @return
     */
    public boolean isPopUp() {
        if(FacesUtil.getFromSession(WebConstants.SessionVariable.IN_POP_UP_FLOW) != null)
            return true;
        return false;
        
    }

    public String getCurrencyCode(){
        ReferenceCodeDelegate ref = new ReferenceCodeDelegate();
        return ref.findSystemParameter(Constants.SystemParameterCode.BASE_CURRENCY);
    }

    public void setIsFromPortal(Boolean isFromPortal) {
        this.isFromPortal = isFromPortal;
    }

    public Boolean getIsFromPortal() {
        return isFromPortal;
    }    


//    public void applyRequestOverride(ReturnEvent returnEvent) {
//        String requestOverrideValue = (String)returnEvent.getReturnValue();
//        RequestContext.getCurrentInstance().getPageFlowScope().put(WebConstants.ProcessScopeVariable.PAGE_CONFIG,requestOverrideValue);
//        getRun();
//        FacesUtil.navigate(FacesUtil.getFacesContext().getExternalContext().getRequestContextPath());
//    }
//
//    public boolean isAccessAllowed(String functionalRole,SecurityControlDelegate secDelegate) {
//        
//            List<CasRole> roles = secDelegate.findFunctionalRolesOfUser(getLoggedInUser());
//            for(CasRole role:roles) {
//                if(role.getRoleName().equals(functionalRole)) {
//                    return true;
//                }
//            }
//            
//            return false;
//        
//    }

    public ReferenceCodeDelegate getRefDelegate() {
        return ReferenceCodeDelegate.getInstance();
    }
    
    private void addMessageToMessages(Object message, List<FacesMessage> messages) {
        if(null != message ){  
            String msg = String.valueOf(message);
            String[] rule = msg.split(":");
            FacesMessage errMsg = null;
            if(rule.length > 1){
               errMsg = new FacesMessage(rule[0],rule[1]);
            }else{
                errMsg = new FacesMessage(msg);
            } 
            messages.add(errMsg);
        }
    }
    
//    private void executeValidation(String name, String script,List<FacesMessage> messages) {
//        Object message = runGroovyScript(script);
//        addMessageToMessages(message, messages);
//    }
//
//    private void executeValidation(String name, ScrCommScript script,List<FacesMessage> messages) {
//        Object message = runGroovyScript(script);
//        addMessageToMessages(message, messages);
//    }
    
    /**
     * Run the groovy script
     * @param script
     * @return
     */
    private Object runGroovyScript(String script) {
//        ClassLoader parent = JsfReferencedObject.class.getClassLoader();
//        GroovyClassLoader loader = new GroovyClassLoader(parent);
//
//        Class groovyClass = loader.parseClass(script);
//
//        GroovyObject groovyObject = null;
//
//        try {
//            groovyObject = (GroovyObject)groovyClass.newInstance();
//        } catch (IllegalAccessException e) {
//            log.error(e.getLocalizedMessage(), e);
//        } catch (InstantiationException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
////        groovyObject.setProperty("pageFlowScope", 
////                                 RequestContext.getCurrentInstance().getPageFlowScope());
//        groovyObject.setProperty("session", 
//                                 FacesContext.getCurrentInstance().getExternalContext().getSessionMap());
//        groovyObject.setProperty("context", this);
//        Object[] argz = { };
//
//        Object value = groovyObject.invokeMethod("run", argz);
//        return value;
return null;
    }
    
    /**
     * Run the groovy script
     * @param script
     * @return
     */
//    private Object runGroovyScript(ScrCommScript script) {
//        Map parameterMap = new HashMap();
//        parameterMap.put("backingBean", this);
//        parameterMap.put("processScope", AdfFacesContext.getCurrentInstance().getProcessScope());
//        parameterMap.put("session", FacesContext.getCurrentInstance().getExternalContext().getSessionMap());
//
//        Object retVal = null;
//        try {
//            retVal = scriptOperationsDelegate.callScript(script,parameterMap);
//        } catch (TripsScriptCompilationException e) {
//            // TODO
//        } catch (TripsScriptRuntimeException e) {
//            // TODO
//        }
//        
//        return retVal;
//    }

/**
     * WORKFLOW RELATED JOB.
     */
//    protected CorePanelButtonBar workflowButtonsBar;
    protected boolean workflowButtonsVisible = true;
    
    public void workflowActionListener(ActionEvent event) {
        // will be overriden if workflow buttons are generated dynamically    
    }
    
     public String workflowAction() {
         // will be overriden if workflow buttons are generated dynamically    
         return workflowAction(true);
     }
     
    public String workflowAction(boolean showSuccessMessages) {
        // will be overriden if workflow buttons are generated dynamically    
        return null;
    } 
    
    //TODO (VP) Line(s) below need to removed after integrating ConfigSet - Start      
//    public void generateWorkflowButtonsBar(String workflowType) {
//        WorkflowDelegate delegate = new WorkflowDelegate();
//        Map<String, String> buttonInfo =  delegate.findPossibleActionsByUsingMode(getPageMode(), workflowType);
//        Iterator<String> itr = buttonInfo.keySet().iterator();
//        workflowButtonsBar = (CorePanelButtonBar)FacesUtil.createComponent(CorePanelButtonBar.COMPONENT_TYPE);
//        ValueBinding vb = FacesUtil.getFacesContext().getApplication().createValueBinding(
//            "#{" + getSessionWorker().managedBeanName()  +".workflowButtonsVisible}");
//        workflowButtonsBar.setValueBinding("rendered", vb);
//        while(itr.hasNext()) {
//            String buttonId = itr.next();
//            String buttonLabel = buttonInfo.get(buttonId);
//            CoreCommandButton button = (CoreCommandButton)FacesUtil.createComponent(CoreCommandButton.COMPONENT_TYPE);
//            button.setId(buttonId);
//            button.setText(buttonLabel);
//            MethodBinding mb = FacesUtil.getFacesContext().getApplication().createMethodBinding(
//                "#{" + getSessionWorker().managedBeanName()  +".workflowActionListener}", new Class[]{ActionEvent.class});
//            button.setActionListener(mb);
//            MethodBinding mb2 = FacesUtil.getFacesContext().getApplication().createMethodBinding(
//                "#{" + getSessionWorker().managedBeanName()  +".workflowAction}", null);
//            button.setAction(mb2);
//            workflowButtonsBar.getChildren().add(button);
//            CoreObjectSpacer objectSpacer = new CoreObjectSpacer();
//            objectSpacer.setWidth("10px");
//            workflowButtonsBar.getChildren().add(objectSpacer);
//        }
//    }
//    End
    public void generateFormButtonsBar() {
//        WorkflowDelegate delegate = new WorkflowDelegate();
//        Long configSetModeId = (Long)FacesUtil.getFromSession(WebConstants.SessionVariable.CONFIG_SET_MODE_ID);
//        Map<String, String> buttonInfo =  delegate.findPossibleActionsByConfigSetModeId(configSetModeId);
//        Iterator<String> itr = buttonInfo.keySet().iterator();
//        workflowButtonsBar = (CorePanelButtonBar)FacesUtil.createComponent(CorePanelButtonBar.COMPONENT_TYPE);
////        ValueBinding vb = FacesUtil.getFacesContext().getApplication().createValueBinding(
////            "#{" + getSessionWorker().managedBeanName()  +".workflowButtonsVisible}");
//        ValueExpression vb = FacesUtil.getValueExpression(
//            "#{" + getSessionWorker().managedBeanName()  +".workflowButtonsVisible}");
//        workflowButtonsBar.setValueExpression("rendered", vb);
//        while(itr.hasNext()) {
//            String buttonId = itr.next();
//            String buttonLabel = buttonInfo.get(buttonId);
//            CoreCommandButton button = (CoreCommandButton)FacesUtil.createComponent(CoreCommandButton.COMPONENT_TYPE);
//            button.setId(buttonId);
//            button.setBlocking(true);
//            button.setText(buttonLabel);
//            if(Constants.CANCEL_RETURN_LABEL.equalsIgnoreCase(buttonLabel)) {
//                button.setOnclick("return confirm('Do you really wish to cancel the return?');");
//            } else {
//                button.setOnclick("disableAllButtonsAfterSubmit(this);");
//            }
//
//            MethodBinding mb = FacesUtil.getFacesContext().getApplication().createMethodBinding(
//                "#{" + getSessionWorker().managedBeanName()  +".workflowActionListener}", new Class[]{ActionEvent.class});
//            button.setActionListener(mb);
//            MethodBinding mb2 = FacesUtil.getFacesContext().getApplication().createMethodBinding(
//                "#{" + getSessionWorker().managedBeanName()  +".workflowAction}", null);
//            button.setAction(mb2);
//            workflowButtonsBar.getChildren().add(button);
//            CoreSpacer objectSpacer = new CoreSpacer();
//            objectSpacer.setWidth("10px");
//            workflowButtonsBar.getChildren().add(objectSpacer);
//        }
    }

//    public CorePanelButtonBar getWorkflowButtonsBar() {
//        return workflowButtonsBar;
//    }

    public void setWorkflowButtonsVisible(boolean workflowButtonsVisible) {
        this.workflowButtonsVisible = workflowButtonsVisible;
    }

    public boolean isWorkflowButtonsVisible() {
        return workflowButtonsVisible;
    }

    /**
     * Represents the base input type used within the page. Will be overriden by the backing bean.
     * @return
     */
    public InputType getBaseType() {
        return null;
    }

//    public void setWorkflowButtonsBar(CorePanelButtonBar workflowButtonsBar) {
//        this.workflowButtonsBar = workflowButtonsBar;
//    }
//    
    /**
     * TODO: check why message are being duplicated
     * this is a work around
     * @param validationMessages
     */
    private boolean noDuplicate(List<FacesMessage> validationMessages, FacesMessage nextMessage) {
        for(FacesMessage fm : validationMessages){
            if(fm.getSummary().equalsIgnoreCase(nextMessage.getSummary())){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean validateAttachmentType(String fileName){
        boolean validFormat = false;
        String fType = fileName.substring(fileName.lastIndexOf("."));
        ReferenceCodeDelegate ref = new ReferenceCodeDelegate();
//        List<CodeAndDescription> codeAndDescList = ref.findAllAttachmentTypes(Constants.SystemParameterCode.BASE_CURRENCY);
        
//        for(CodeAndDescription codeDesc : codeAndDescList){
//            if(codeDesc.getDescription().equalsIgnoreCase(fType)){
//                validFormat = true;
//                break;
//            }
//        }
        if(!validFormat){
            FacesUtil.addFacesErrorMessage("Attachment.errorMessage.ZIPFile");
        }
        return validFormat;
    }

    public Object getPerformAccessControl() {
        return FacesUtil.getFromSession(Constants.SystemParameterCode.PERFORM_ACCESS_CONTROL);
    }
    
    public Object getPageAccessList() {
        return FacesUtil.getApplicationScope().get(WebConstants.ApplicationScopeVariables.PAGE_ACCESS_LIST);
    }
    
    public Object getSecurityRolesPageRelList() {
        return FacesUtil.getSessionScope().get(PAGE_SECURITY_ROLES_LIST);
    }
    
    /*
     * TODO (VP) This will be enabled later as it require more testing. This method will be used instead of calling getSubjectPermissions()
     */
//    public String[] getSubjectPermissionsList(){
//        String[] subjectPermission = (String[])FacesUtil.getSessionScope().get(SUBJECT_PERMISSIONS_LIST);
//        if(subjectPermission == null){
//            subjectPermission = getSubjectPermissions();
//        }
//        return subjectPermission;
//    }
    
    public void setDiscardChanges(Boolean discardChanges) {
        this.discardChanges = discardChanges;
    }

    public Boolean getDiscardChanges() {
        return discardChanges;
    }
    
}
