package com.technobrain.trips.core.sessionmanager.backing;

import com.technobrain.trips.core.backing.BackingBase;
import com.technobrain.trips.core.delegate.ReferenceCodeDelegate;
import com.technobrain.trips.core.onetomanytable.OneBackingBeanToOneTableRow;
import com.technobrain.trips.core.sessionmanager.SessionPage;
import com.technobrain.trips.core.sessionmanager.annotation.SessionWorker;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.util.WebConstants;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.reference.model.RefCurrency;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

//import com.crownagents.trips.core.flexforms.delegate.FlexibleFormsDelegate;
//import com.crownagents.trips.core.flexforms.generation.helper.GuiGenerationConstants;
//import com.crownagents.trips.flexforms.model.FlexMenuHeader;


/**
 * � Crown Agents 2006
 * <p>
 * Manages the session scope backing beans
 * @since $Date: 1/7/2010 5:14:16 AM$
 * @version $Revision: 62$
 * @author $Author: Linesh Mali$
 * 
 * $Log[1]:
 *  62   TRIPS2 etis.bir.gov.ph1.57.1.3    1/7/2010 5:14:16 AM    Linesh Mali  
 *         Flexible forms script operations moved to common and ejb modules
 * $
 */
public class BackingSessionManager implements Serializable{

    public static final Logger log = Logger.getLogger(BackingSessionManager.class);
    
   /**
    * Stores the backing beans temporarily at the session scope.
    */
    private Map<String, BackingBase> storedBackingBeans = new HashMap<String, BackingBase>();
    
    private Map<String, Object> storedProcessScopeVariables = new HashMap<String, Object>();
    
    /**
     * Stores all the users worklow
     */
    private List<SessionPage> workflows = new ArrayList<SessionPage>();
    
    /**
     * Stores all the flows of the pages without looking if it is in the workflow or not.
     */
    private ArrayList<SessionPage> flowOfPages = null;
    
    /**
     * Holds the session pages that will be tracked their end states. This list will be filled before render response phase
     * and used after render response phase and cleared thereafter.
     */
    private List<SessionPage> rubbishPages = new ArrayList<SessionPage>();
    
    /**
     * Stores the current page's information.
     */
    private SessionPage currentPage;
    
    /**
     * Stores all the flows of the popup pages without looking if it is in the workflow or not.
     * It is a list, because multiple pop-ups can be opened at the same time
     * and this list hold every popup opened in order.
     */
    private List<ArrayList<SessionPage>> popupFlowOfPages = null;
    
    /**
     * Stores the current popup page's information. It is a list, because multiple pop-ups can be opened at the same time
     * and this list hold every popup opened in order.
     */
    private List<SessionPage> popupCurrentPage;
    
    private ArrayList<String> sessionConstants;
    
    private ArrayList<String> processScopeConstants;
    
    private ArrayList<String> genericSearchProcessScopeConstants;
    
    private List<String> flexibleFormScopeVariables = new ArrayList<String>();
    
    // if the caller backing bean is not null, this means that we are using the caller backing bean as our concrete backing bean.
    // In that case, that concrete backing bean can have some session scope variables like TABLE_MODE_KEY and TABLE_HANDLER_KEY
    // because actually that concrete backing bean is also used for a table row.
    // If we open a popup or a window by using processAdd method within this page which has the concrete backing bean as the backing bean,
    // the TABLE_MODE_KEY and TABLE_HANDLER_KEY session scope variables can be overriden. So we should take the backup for the
    // concrete backing bean's session scope variables while we are opening a new popup or window from this page and after closing that 
    // popup, we should restore these session scope variables back to the session scope.
    protected List<Map> callerBackingBeanSessionVars = new ArrayList<Map>();

    /**
     * Stores all the users worklow
     */
//    private List<FlexMenuHeader> flexibleMenuHeaders = new ArrayList<FlexMenuHeader>();

     
    public BackingSessionManager() {
        //TODO will be removed later.
        //ScriptManager.emptyCache();
        
        sessionConstants = new ArrayList<String>();
        for(Field field:WebConstants.SessionVariable.class.getDeclaredFields()){
            try {
                sessionConstants.add((String)field.get(null));
            } catch (IllegalAccessException e) {
               log.error(e.getLocalizedMessage(), e);
            }
        }
        processScopeConstants = new ArrayList<String>();
        for(Field field:WebConstants.ProcessScopeVariable.class.getDeclaredFields()){
            try {
                processScopeConstants.add((String)field.get(null));
            } catch (IllegalAccessException e) {
               log.error(e.getLocalizedMessage(), e);
            }
        }
        
        genericSearchProcessScopeConstants = new ArrayList<String>();
        for(Field field:WebConstants.GenericSearchProcessScopeVars.class.getDeclaredFields()){
            try {
                genericSearchProcessScopeConstants.add((String)field.get(null));
            } catch (IllegalAccessException e) {
               log.error(e.getLocalizedMessage(), e);
            }
        }
    }
    
    /**
     * Puts back the original session scope variables that are used for this backing bean if there are any session scope
     * variables that are backuped within the list of backup.
     */
    public void putBackSessionScopeVarsToSessionScope() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        //clean up the mode and the table handler key.
        ctx.getExternalContext().getSessionMap().remove(OneBackingBeanToOneTableRow.TABLE_MODE_KEY);
        ctx.getExternalContext().getSessionMap().remove(OneBackingBeanToOneTableRow.TABLE_HANDLER_KEY);
        if(callerBackingBeanSessionVars.size() != 0) {
            // the list is actually a stack for session scope variables. For every page that are visited before, there are
            // related session scope variables and they were added to this list in the order that the pages were navigated.
            // So in order to navigate back to the previous back, we should find the latest backed-up variables and store
            // them back to the session scope. This means, we should fetch the latest element from the list.
            Map m = callerBackingBeanSessionVars.get(callerBackingBeanSessionVars.size() - 1);
            Iterator itr = m.keySet().iterator();
            while(itr.hasNext()) {
                String key = (String)itr.next();
                Object value = m.get(key);
                // store everything back.
                FacesUtil.storeOnSession(key, value);
            }
            // clear everything that is in the backup map so that we will not use them again.
            callerBackingBeanSessionVars.remove(m);
        }
    }
    
    /**
     * Stores the original session scope variables that are used for this backing bean if this backing bean is used for
     * a table row and containing many tables both.
     */
    public void backupSessionScopeVars() {
            Map m = new HashMap();
            m.put(OneBackingBeanToOneTableRow.TABLE_MODE_KEY, 
                FacesUtil.getFromSession(OneBackingBeanToOneTableRow.TABLE_MODE_KEY));
            m.put(OneBackingBeanToOneTableRow.TABLE_HANDLER_KEY, 
                FacesUtil.getFromSession(OneBackingBeanToOneTableRow.TABLE_HANDLER_KEY));
            callerBackingBeanSessionVars.add(m);
    }
    
    /**
     * Stores the backing bean information into the last session page object in the flow.
     * 
     * @param base the backing bean whose information is stored.
     */
    public void storeBackingBeanInfoInSessionPage(BackingBase base) {
        // now we should add the backing bean name and backing bean reference to the session page that is used for this page.
        List<SessionPage> pages = getCorrectFlowOfPages();
        if(pages != null && pages.size() > 0) {
            SessionPage currentPage = pages.get(pages.size() - 1);
            BackingBase existingBackingBean = currentPage.getBackingBean();
            // if the backing bean stored in the session worker is the main backing bean and should not be changed,
            // then we need to skip storing the new backing bean.
            if(existingBackingBean != null && existingBackingBean.getSessionWorker() != null &&
                existingBackingBean.getSessionWorker().absoluteBackingBean() == true) {
                return;
            }
            currentPage.setBackingBean(base);
            boolean usesSameBackingBean = false;
            if(base.getSessionWorker().managedBeanName() != null &&
               base.getSessionWorker().managedBeanName().equals(currentPage.getBackingBeanName())) {
                usesSameBackingBean = true;      
            }
            currentPage.setBackingBeanName(base.getSessionWorker().managedBeanName());
            // if we use the same backing bean, then we should not clear the worker variables, because the same backing
            // bean uses the same worker variables. If we delete them, they will not be available in the faces scope anymore, which
            // means even if we try to restore them, they will be null.
            if(!usesSameBackingBean) {
                currentPage.cleanUpWorkerScopeVariables();
            }
            // store the session worker scope variables (process scope and session scope). These variables will be 
            // put back when we return back to this page later.
            currentPage.storeSessionWorkerScopeVars();
            // store the processscope variables for the page. When we want to turn back to this page later,
            // we can use this map to put the process scope variables to the process scope that are used for this page.
            currentPage.storeKnownProcessScopeVariables();
        }
    }
    
    /**
     * Adds the session worker and the requested view id to the list of 
     * session worklows
     * @param viewId
     * @param worker
     */
    public void addWorker(String viewId, SessionWorker worker, BackingBase backingBean) {
        /*
         * Determines if the session manager already has this worker
         */
        int index = hasWorkflow(viewId);
        
        if (index == -1) { // if it exist
            
            if(log.isDebugEnabled()){
                log.debug("attached backing bean " + worker.managedBeanName() + " to session manager");
            }
            
            /*
             * Create the session workflow
             */
            SessionPage workflow = new SessionPage(viewId, backingBean, worker.managedBeanName());            
            /*
             * Conditional add, pre-caution
             */
            if(!workflows.contains(workflow)){
                workflow.storeSessionWorkerScopeVars();
                /*
                 * Adds the workflow to the list of workflows
                 */
                workflows.add(workflow);
                
            }else{
                throw new IllegalAccessError();
            }
        }
    
        if(log.isDebugEnabled() && workflows != null){
            log.debug("managing workflows of size now " + workflows.size());
        }
        
    }     
     
     /**
     * Checks if the viewId exist in the workflow
     * @param viewId
     * @return
     */
     private int hasWorkflow(String viewId) {
        if(log.isDebugEnabled())log.debug("viewId for hasWorkflow " + viewId);
        for(int i=0; i<workflows.size();i++){
            SessionPage bsw = workflows.get(i);
            if(log.isDebugEnabled())log.debug("bsw.getStartState().getViewId() " + bsw.getViewId());
            if(bsw.getViewId().equalsIgnoreCase(viewId)){
             return i;        
            }            
        }
        return -1;
     }

    public List<SessionPage> getWorkflows() {
        return workflows;
    }

    public void trackEndState(SessionPage page, String toViewId) {
        if(page.getBackingBean() == null || page.getBackingBeanName() == null)
            return;
        if( page.isEndState(toViewId)){
            page.endState();
            page.cleanUpWorkerScopeVariables();
        }else{
            if(log.isDebugEnabled()){
                log.debug("current workflow is not end state " );            
            }
        }
    }
    
    /**
     * @return
     */
    public boolean canKillJobs() {
      
       if(FacesUtil.getRootViewId().equalsIgnoreCase(WebConstants.ViewId.WELCOME_VIEW_ID) 
            || FacesUtil.getRootViewId().equalsIgnoreCase(WebConstants.ViewId.LOG_OUT)){
           return true;
       }else{
           return false;
       }
    }
    
    /**
     * 
     */
    public void killJobs() {
        if(!workflows.isEmpty()){
            Iterator iter = workflows.iterator();
            while(iter.hasNext()){
                SessionPage sw = (SessionPage)iter.next();
                sw.cleanUpAllScopeVariables();
                Object ref = FacesUtil.removeFromSession(sw.getBackingBeanName());
                if(null != ref){
                    iter.remove();
                    if(log.isDebugEnabled()){
                        log.debug("Removed jsf session scoped managed bean [key/value]: " + "["+ sw.getBackingBeanName() + "]/[" + ref + "]");
                    }
                }
            }            
        }else{
            if(log.isDebugEnabled()){
                log.debug("No jobs found to clean up");
            }  
        }
    }
    
    /**
     * 
     */
    public void cleanUpSystemSessionVariables() {
       for(String constant:sessionConstants){
           FacesUtil.removeFromSession(constant);
       }      
    }
    
    public void cleanUpGenericSearchProcessScopeVars() {
        System.out.println(" ******* INSIDE PAGE FLOW SCOPE CLEAN UP");
        RequestContext ctx = RequestContext.getCurrentInstance();
            
        for(String constant:genericSearchProcessScopeConstants){
//            if(ctx.getPageFlowScope().containsKey(constant)){
//                System.out.println(" ***** CONSTANT CLEANED UP ******** "+constant);
//                ctx.getPageFlowScope().put(constant,null);
//                ctx.getPageFlowScope().remove(constant);
//            }
        }
    }
    
    /**
     * 
     */
    public void cleanUpSystemProcessScopeVariables() {
       RequestContext ctx = RequestContext.getCurrentInstance();
       
//       if( ctx.getPageFlowScope().size() == 0){
//            if(log.isDebugEnabled()){
//                 log.debug("No process variables found to clean up");   
//            }
//       }else{
//           
//           for(String constant:processScopeConstants){
//               if(ctx.getPageFlowScope().containsKey(constant)){
//                   ctx.getPageFlowScope().put(constant,null);
//                   ctx.getPageFlowScope().remove(constant);
//               }
//           }
//       }
//        
//       if(ctx.getPageFlowScope().size() == 0){
//           //do nothing 
//       }else{
//           log.warn("The session manager found process scope variables that where not declared in WebConstants... start cleanup");
//           Iterator iter = ctx.getPageFlowScope().entrySet().iterator();
//           while(iter.hasNext()){
//            Map.Entry entry = (Map.Entry)iter.next();
//              log.warn("processscope object [key/value]: " + "["+ entry.getKey() + "]/[" + entry.getValue() + "]");
//           }
//       }
//       
//        ctx.getPageFlowScope().clear();
    }
    
    private boolean popupFlowJustStarting = false;
    
    /**
     * Adds the information of the page to the flow of pages.
     * 
     * @param viewId
     */
    public void addFlow(String viewId) {
        if(viewId == null)
            return;     
        ArrayList<SessionPage> flowOfP = null;
        // if we are opening the popup right now, then the flowOfP must be null.
        if(!popupFlowJustStarting)
            flowOfP = getCorrectFlowOfPages();
            
        // control if it is added before. If it is added, do not do any operation again.
        if(flowOfP != null && flowOfP.size() != 0 && flowOfP.get(flowOfP.size() - 1).getViewId().equals(viewId))
            return;
        
        if(FacesUtil.getFromRequest("pressedSearch") != null) {
            FacesUtil.getRequestScope().remove("pressedSearch");
            return;
        }
        
        SessionPage page = null;
//        // if it is a generic search and if we are not closing a popup, 
//        // create the instance now, add the managed bean to the session scope and store that instance in the flow.
//        if(viewId != null && viewId.equals(WebConstants.ViewId.GENERIC_SEARCH_ID) && FacesUtil.getFromRequest(BackingGenericSearch.CLOSING_POPUP) == null) {
//            BackingBase backingGenericSearch = new BackingGenericSearch();
//            FacesUtil.storeOnSession(WebConstants.ManagedBean.GENERIC_SEARCH, backingGenericSearch);
//            page = new SessionPage(viewId, backingGenericSearch, WebConstants.ManagedBean.GENERIC_SEARCH);
//        }
//        else {
            page = new SessionPage(viewId);
//        }
        
        // if it is a dialog or it is not a jspx page, do not add it to the flow.
        // if we are opening a pop up, from now on, we should store every page in the popupflowofpages until we close the popup.
        // In order to understand if a page is a popup page or not, we should put a session scope variable to the system, and
        // after we close the popup page with the returnfromdialog, we should delete that variable in the returnfromdialog method.
        if(page.getViewId().contains(WebConstants.ViewId.ADF_DIALOG_VIEW_ID)) {
            // The below if statement will return true only for date pickers. For date pickers, this method is run for ADF_DIALOG_VIEW_ID 
            // twice. For the second entrance to this method, we should clear the popup related variables.
            // For the other normal popups, we again enter the addflow method twice, but for the first time only, we enter for ADF_DIALOG_VIEW_ID,
            // and for the second entrance, we enter to this method for the actual navigation id to the popup page. So for normal popups,
            // the below if statement will not work.
            // TODO What if we open date pickers in a pop-up page with navigation? Then we will enter the below if statement and clear the pop-up
            // variable IN_POP_UP_FLOW which will be wrong. Because we are in a pop-up, we should not delete the IN_POP_UP_FLOW variable.
            if(popupFlowJustStarting) {
                popupFlowJustStarting = false;
                FacesUtil.storeOnSession(WebConstants.SessionVariable.IN_POP_UP_FLOW, null);
            }
            else {
                FacesUtil.storeOnSession(WebConstants.SessionVariable.IN_POP_UP_FLOW, true);
                popupFlowJustStarting = true;
            }
            return;
        }
        else {
            // this must be set back to false, because the pop-up will be opened after this method execution.
            popupFlowJustStarting = false;
            if(!page.getViewId().endsWith(".jspx"))
                return;
        }
        // make this view id, the current view.
        setCorrectCurrentPage(page);
        if(flowOfP == null) {
            flowOfP = new ArrayList<SessionPage>();
            setCorrectFlowOfPages(flowOfP);
        }
        
        // store the processscope variables for the page. When we want to turn back to this page later,
        // we can use this map to put the process scope variables to the process scope that are used for this page.
        page.storeKnownProcessScopeVariables();
        // add the page if the conditions are ok.
        configureFlowOfPagesAndAddPageIfNecessary(flowOfP, page);
    }
    
    
    /**
     * The flow is a->b->c->d and you want to navigate back to c from d. If the user wants to go to previous page in c,
     * after the navigation to c, the system must choose the b page as the previous page and must navigate to b. In order
     * to do that, we should clear the d page when the user wants to navigate back to c from d. So:
     * a->b->c->d
     * User wants to navigate to c:
     * 
     * a->b->c->d->c (wrong)
     * 
     * d must be deleted:
     * 
     * a->b->c
     * 
     * But we will not do this operation if c is the Generic Search Page.
     * 
     * @param flowOfPages
     * @param toPage
     */
    private void configureFlowOfPagesAndAddPageIfNecessary(ArrayList<SessionPage> flowOfPages, SessionPage toPage) {
        if(toPage == null || flowOfPages == null || toPage.getViewId() == null)
            return;
        // If toPage is Generic Search, simply add that page to flow.
//        if(toPage.getViewId().contains(WebConstants.ViewId.GENERIC_SEARCH_ID) && FacesUtil.getFromRequest(BackingGenericSearch.CLOSING_POPUP) == null) {
//            if(flowOfPages.size() > 0) {
//                SessionPage lastPage = flowOfPages.get(flowOfPages.size() - 1);
//                rubbishPages.add(lastPage);
//            }
//            flowOfPages.add(toPage);
//        }
//        else 
        {
            SessionPage page = findLastSessionPageInFlow(toPage.getViewId());
            if(page != null) {
                // delete the pages that are after the page.
                // loop until the last element of the array becomes the page.
                while(!flowOfPages.get(flowOfPages.size() - 1).equals(page)) {
                    SessionPage removedPage = flowOfPages.remove(flowOfPages.size() - 1);   
                    rubbishPages.add(removedPage);
                }
                // do not add the page.
            }
            else {
                if(flowOfPages.size() > 0) {
                    SessionPage lastPage = flowOfPages.get(flowOfPages.size() - 1);
                    rubbishPages.add(lastPage);
                }
                // if we could not find the page, it is the first time that we will pass this page then, we should add it.
                flowOfPages.add(toPage);
            }
        }
    }
    
    /**
     * Finds the recent used page with the viewId given.
     * 
     * @param viewId
     * @return
     */
    private SessionPage findLastSessionPageInFlow(String viewId) {
        ArrayList<SessionPage> flowOfP = getCorrectFlowOfPages();
        if(viewId == null || flowOfP == null)   
            return null;
        for (int i = flowOfP.size() - 1; i > 0; i--)  {
            SessionPage page = flowOfP.get(i);
            if(page.getViewId().equals(viewId)) {
                return page;
            }
        }
        return null;
    }

    public ArrayList<SessionPage> getCorrectFlowOfPages() {
        // if we are in a pop up flow, then we should use the popUp flow of pages.
        if(FacesUtil.getFromSession(WebConstants.SessionVariable.IN_POP_UP_FLOW) != null) {
            if(popupFlowOfPages == null || popupFlowOfPages.size() == 0)
                return null;
            return popupFlowOfPages.get(popupFlowOfPages.size() - 1);
        }
        else {
            return flowOfPages;
        }
    }
    
    public void setCorrectFlowOfPages(ArrayList<SessionPage> flowOfP) {
        // if we are in a pop up flow, then we should use the popUp flow of pages.
        if(FacesUtil.getFromSession(WebConstants.SessionVariable.IN_POP_UP_FLOW) != null) {
            if(popupFlowOfPages == null)
                popupFlowOfPages = new ArrayList();
            this.popupFlowOfPages.add(flowOfP);
        }
        else {
            this.flowOfPages = flowOfP;
        }
    }    

    public void setCorrectCurrentPage(SessionPage currentPage) {
        // if we are in a pop up flow, then we should use the popUp current page.
        if(FacesUtil.getFromSession(WebConstants.SessionVariable.IN_POP_UP_FLOW) != null) {
            if(popupCurrentPage == null)
                popupCurrentPage = new ArrayList();
            this.popupCurrentPage.add(currentPage);
        }
        else {
            this.currentPage = currentPage;
        }
    }

    public SessionPage getCorrectCurrentPage() {
        // if we are in a pop up flow, then we should use the popUp flow of pages.
        if(FacesUtil.getFromSession(WebConstants.SessionVariable.IN_POP_UP_FLOW) != null) {
            if(popupCurrentPage == null || popupCurrentPage.size() == 0)
                return null;
            return popupCurrentPage.get(popupCurrentPage.size() - 1);
        }
        else {
            return currentPage;
        }
    }
    
    /**
     * This method will be used in order to set null values (resetting the flows) to the flows while clicking a #
     * command menu item in the menu.
     * 
     * @param flowOfPages
     */
    public void setAllFlowOfPages(ArrayList flowOfPages) {
        this.flowOfPages = new ArrayList<SessionPage>();
        this.popupFlowOfPages = new ArrayList<ArrayList<SessionPage>>();
    }
    
    public List<ArrayList<SessionPage>> getPopupFlowOfPages() {
        return popupFlowOfPages;
    }

    public List<SessionPage> getPopupCurrentPage() {
        return popupCurrentPage;
    }

    public void cleanUpSystem() {
        this.killJobs();
        this.flowOfPages = new ArrayList<SessionPage>();
        this.popupFlowOfPages = new ArrayList<ArrayList<SessionPage>>();
        this.popupCurrentPage = new ArrayList<SessionPage>();
        this.workflows.clear();
        this.cleanUpSystemSessionVariables();
        this.cleanUpSystemProcessScopeVariables();
        this.cleanUpFlexFormVariables();
        /*
         * removed the backing task details
         */
//        FacesUtil.removeFromSession("backingTaskDetails");
//        FacesUtil.removeFromSession(GuiGenerationConstants.BACKING_BEAN_NAME);
    }
    
    private void cleanUpFlexFormVariables() {
        if(flexibleFormScopeVariables != null) {
            for(String varName:flexibleFormScopeVariables) {
                FacesUtil.removeFromSession(varName);
            }
        }
    }
    
    public String goToGenericSearch() {
        return "dialog:ToGenericSearch";
    }

    public void setStoredBackingBeans(Map<String, BackingBase> storedBackingBeans) {
        this.storedBackingBeans = storedBackingBeans;
    }

    public Map<String, BackingBase> getStoredBackingBeans() {
        return storedBackingBeans;
    }

    public void setStoredProcessScopeVariables(Map<String, Object> storedProcessScopeVariables) {
        this.storedProcessScopeVariables = storedProcessScopeVariables;
    }

    public Map<String, Object> getStoredProcessScopeVariables() {
        return storedProcessScopeVariables;
    }

    public ArrayList<SessionPage> getFlowOfPages() {
        return flowOfPages;
    }

    public SessionPage getCurrentPage() {
        return currentPage;
    }

    public void setRubbishPages(List<SessionPage> rubbishPages) {
        this.rubbishPages = rubbishPages;
    }

    public List<SessionPage> getRubbishPages() {
        return rubbishPages;
    }

    public boolean isPopupFlowJustStarting() {
        return popupFlowJustStarting;
    }
    
//    /**
//     * When we want to navigate to another page, manually we can initialize a backing bean and store it to session scope and
//     * then navigate. This causes a problem because at the constructor of BackingBase we store the backing bean information
//     * into the session page object which is the last entry in the page flow. If we create the backing bean manually in any action method, 
//     * then the last session page object will not be for the newly created backing bean because we create the session page object
//     * at the render response phase and add it to the page flow. 
//     * 
//     * So the below method is called in order to fix this problem. It puts the exact backing bean information for the last session page
//     * object. This method should be called whenever we initialize a backing bean manually and store it to session scope.
//     * 
//     * @param base the current backing bean whose info should be set into the last session page object in the flow.
//     * @param viewId the url that this backing bean refers to.
//     */
//    public void correctSessionPageInformation(BackingBase base, String viewId) {
//        List<SessionPage> pages = getCorrectFlowOfPages();
//        if(pages != null && pages.size() > 0) {
//            SessionPage currentPage = pages.get(pages.size() - 1);
//            if(viewId.equals(currentPage.getViewId())) {
//                storeBackingBeanInfoInSessionPage(base);
//            }
//        }
//    }
    
    public String getUserLocale() {
        return FacesUtil.getFacesContext().getViewRoot().getLocale().toString();
    }
    
    
    public BackingBase getBackingBeanInPageFlow(String backingBeanName){
        
        ArrayList<SessionPage> flowOfP = getCorrectFlowOfPages();
        if(flowOfP != null && flowOfP.size() > 1) {
            // the index of the page url that we want to navigate to.
            int indexofPageUrl = 0;
            for (indexofPageUrl = 0; indexofPageUrl < flowOfP.size(); indexofPageUrl++)  {
                
                SessionPage page = flowOfP.get(indexofPageUrl);
                if(page.getBackingBeanName() != null && page.getBackingBeanName().equals(backingBeanName)) {
                    return page.getBackingBean();
                }
            }
        }
            
        return null;
    }
    
    public SessionPage getParentSessionPage() {
        return flowOfPages.get(flowOfPages.size() - 1);
    }

//    public void setFlexibleFormScopeVariables(List<String> flexibleFormScopeVariables) {
//        this.flexibleFormScopeVariables = flexibleFormScopeVariables;
//    }

    public List<String> getFlexibleFormScopeVariables() {
        return flexibleFormScopeVariables;
    }
//        
//    public List<FlexMenuHeader> getFlexibleMenuHeaders() {
//        if(flexibleMenuHeaders == null || (flexibleMenuHeaders != null && flexibleMenuHeaders.size() == 0 )){
//            FlexibleFormsDelegate flexDelegate = new FlexibleFormsDelegate();
//            flexibleMenuHeaders = flexDelegate.getAllFlexMenuHeaders();        
//        }    
//        return flexibleMenuHeaders;
//    }

    public String getCurrencyCode(){
        String curreny = (String)FacesUtil.getFromSession(Constants.SystemParameterCode.BASE_CURRENCY);;
        if(null == curreny){
            curreny = ReferenceCodeDelegate.getInstance().findSystemParameter(Constants.SystemParameterCode.BASE_CURRENCY);
            FacesUtil.getSessionScope().put(Constants.SystemParameterCode.BASE_CURRENCY,curreny);
        }
        ReferenceCodeDelegate refDelegate = new ReferenceCodeDelegate();
        RefCurrency refCurrency = refDelegate.findRefCurrencyByCode(curreny);
        curreny = refCurrency.getDescription();
        return curreny;
    }
    public String getProductVersion(){
        String version = (String)FacesUtil.getFromSession(Constants.SystemParameterCode.PRODUCT_VERSION);;
        if(null == version){
            version = ReferenceCodeDelegate.getInstance().getSystemParameter(Constants.SystemParameterCode.PRODUCT_VERSION);
            FacesUtil.getSessionScope().put(Constants.SystemParameterCode.PRODUCT_VERSION,version);
        }  
        return version;
    }
    
}
