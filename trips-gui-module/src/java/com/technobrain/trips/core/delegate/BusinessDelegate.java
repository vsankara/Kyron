package com.technobrain.trips.core.delegate;


import com.technobrain.trips.core.bean.HeaderSummaryDetailsBean;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.account.service.AccountFacadeRemote;
import com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBRemote;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.message.OutputType;
import com.technobrain.trips.core.message.SubmissionOutputType;
import com.technobrain.trips.core.message.SystemMessage;
import com.technobrain.trips.document.service.DocumentFacadeRemote;
import com.technobrain.trips.dto.HeaderSummaryDetail;
import com.technobrain.trips.enforcement.service.EnforcementFacadeRemote;
import com.technobrain.trips.entity.service.EntityFacadeRemote;
import com.technobrain.trips.gui.service.GuiConfigFacadeLocal;
import com.technobrain.trips.locator.ServiceLocator;
import com.technobrain.trips.locator.ServiceLocatorException;
import com.technobrain.trips.menu.service.AppMenuFacadeLocal;
import com.technobrain.trips.ratemanagement.service.RateManagementFacadeRemote;
import com.technobrain.trips.reference.service.ReferenceFacadeRemote;
import com.technobrain.trips.registration.service.RegTaxpayerFacadeRemote;
import com.technobrain.trips.revenueaccount.service.RevenueAccountFacadeRemote;
import com.technobrain.trips.search.service.SearchFacadeRemote;
import com.technobrain.trips.usermanagement.service.UserManagementFacadeLocal;

import java.io.Serializable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.security.Principal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;


//import com.crownagents.trips.worklist.delegate.TaskDelegate;


/**
 * ? Crown Agents 2006
 * <p>
 * Provides the coupling between the view and the business tier.
 * <br>1. Makes the remote calls to BPEL server.
 * <br>2. Provides central access the ejb/business tier
 * <br>3. Provides central business logic of specific or common functionally
 * @see <a href="http://java.sun.com/blueprints/corej2eepatterns/Patterns/BusinessDelegate.html">BusinessDelegate</a> 
 * @since $Date: 01/02/2010 15:21:03$
 * @version $Revision: 86$
 * @author $Author: Vythilingam Pirabaharan$
 * 
 * $Log[1]:
 *  86   TRIPS2 etis.bir.gov.ph1.77.1.7    01/02/2010 15:21:03    Vythilingam
 *       Pirabaharan Added entity office to the header regions of individual
 *       and organisation. 
 * $
 */
public class BusinessDelegate implements Serializable {

    public static final Logger log = Logger.getLogger(BusinessDelegate.class);
    private BusinessDelegate hook;
    
    /**
     * Each delegate can be hooked or linked to another delegate.
     * This allows for this delegate to delegate it process it the hooked or
     * linked delegate.
     * @return
     */
    public boolean isHooked(){
        return hook == null ? false : true;
    }
    
    /**
     * @return the handle to the hooked delegate
     */
    public BusinessDelegate getHandle(){
        return hook;    
    }
    
    /**
     * @return the handle to the hooked delegate
     */    
    public void setHook(BusinessDelegate _hook){
        this.hook = _hook;
    }
 
    
    /**
     * Easy access method to get the service locator 
     * @return Service Locator
     * @throws com.crownagents.trips.locator.ServiceLocatorException
     */
    protected static ServiceLocator getServiceLocator() throws ServiceLocatorException {
        return new ServiceLocator();
    }

    /**
     * Handles_and
     * @param inputType
     */
    protected void process(InputType inputType) {
        Principal principal = 
            FacesUtil.getFacesContext().getExternalContext().getUserPrincipal();
        if (null != inputType && principal != null) {
            if (inputType.getCreatedBy() == null)
                inputType.setCreatedBy(principal.getName());
        } else {
            //do nothing
        }
    }

    /**
     * Add a formatted system message if an exception is thrown
     * @param outputType
     * @param t
     * @return
     */
     protected OutputType handleError(OutputType outputType, Throwable t) {
         List<SystemMessage> systemMessages = new ArrayList<>();
         if (null == outputType)
             outputType = new OutputType();
         else{
             if (outputType.getErrors() != null) {
                 outputType.setHasErrors(true);
             }
             systemMessages = outputType.getErrors();
         }
         
         List<SystemMessage> systemMessageList = new ArrayList<SystemMessage>();
         SystemMessage systemMessage = new SystemMessage();
         systemMessage.setCode("Global.bpel.invalidReply");
         if(t.getMessage().contains("com.oracle.bpel.client.delivery.ReceiveTimeOutException")){
        	 // handleError is used by various consumers. we just mind process timeout error
        	 systemMessage.setMessage(FacesUtil.getStringFromBundle("Global.bpel.processTimeOut"));
//        	 new TaskDelegate().createNotification("TimeOut Error", "BPEL client", "ERROR", systemMessage.getMessage());
         } else if (systemMessages == null) {
             systemMessage.setMessage("Global.msg.ErrorDetails?" + ExceptionUtils.getRootCause(t).getMessage());
         } else {
             systemMessage.setMessage(null);
         }
         systemMessageList.add(systemMessage);
         outputType.getErrors().addAll(systemMessageList);
         outputType.setReturnStatus(Constants.FAIL);
         log.error(t.getLocalizedMessage(), t);
         return outputType;
         
         
//         if(t.getCause() instanceof com.crownagents.trips.common.exceptions.TripsNestableRuntimeException){
//        	 
//         }
         
     }


    /**
     * @return
     */
    protected  RefCodeAssemblerSessionEJBRemote getRefCodeAssemblerService() {
        try {
            
            RefCodeAssemblerSessionEJBRemote refCodeAssemblerSessionEJBRemote =

                (RefCodeAssemblerSessionEJBRemote) getServiceLocator().getRemoteEJB("RefCodeAssemblerSessionEJB#com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBRemote");

            return refCodeAssemblerSessionEJBRemote;
            
        } catch (ServiceLocatorException e) {
            log.error(e.getLocalizedMessage(), e);
        }

        throw new IllegalAccessError(RefCodeAssemblerSessionEJBRemote.class.getName());
    }
    
    /**
     * @return
     */
    protected  GuiConfigFacadeLocal getGuiConfigService() {

        try {
            return (GuiConfigFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.GUI_MANAGER);
        } catch (ServiceLocatorException e) {
            log.error(e.getLocalizedMessage(), e);
        }

        throw new IllegalAccessError(GuiConfigFacadeLocal.class.getName());
    }

    public  SearchFacadeRemote getSearchService() {

        try {
            return (SearchFacadeRemote)getServiceLocator().getLocalEJB(ServiceLocator.Services.SEARCH_SERVICE);
        } catch (ServiceLocatorException e) {
            log.error(e.getLocalizedMessage(), e);
        }

        throw new IllegalAccessError(SearchFacadeRemote.class.getName());
    }
    
    /**
     * @return
     */
    protected  RegTaxpayerFacadeRemote getRegistrationService() {

        try {
            return (RegTaxpayerFacadeRemote)getServiceLocator().getLocalEJB(ServiceLocator.Services.REGISTRATION_FACADE);
        } catch (ServiceLocatorException e) {
            log.error(e.getLocalizedMessage(), e);
        }

        throw new IllegalAccessError(RegTaxpayerFacadeRemote.class.getName());
    }
//    
//    /**
//     * @return
//     */
    protected  EntityFacadeRemote getEntityService() {

        try {
            return (EntityFacadeRemote)getServiceLocator().getLocalEJB(ServiceLocator.Services.ENTITY_FACADE);
        } catch (ServiceLocatorException e) {
            log.error(e.getLocalizedMessage(), e);
        }

        throw new IllegalAccessError(EntityFacadeRemote.class.getName());
    }


    /**
     * @return
     */
//    protected  RevenueAccountFacadeLocal getRevenueService() {
//
//        try {
//            return (RevenueAccountFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.REV_ACCOUNT);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//
//        throw new IllegalAccessError(RevenueAccountFacadeLocal.class.getName());
//    }


    /**
     * @return
     */
//    protected  RevenueCollectionFacadeLocal getRevenueCollectionService() {
//
//        try {
//            return (RevenueCollectionFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.REVENUE_COLLECTION_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//
//        throw new IllegalAccessError(RevenueCollectionFacadeLocal.class.getName());
//    }
//
//    /**
//     * @return
//     */
//    protected  CreditAllocationFacadeLocal getCreditAllocationService() {
//
//        try {
//            return (CreditAllocationFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.CREDIT_ALLOCATION_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//
//        throw new IllegalAccessError(CreditAllocationFacadeLocal.class.getName());
//    }


    /**
     * @return
     */
//    protected  ExemptionsFacadeLocal getExemptionsService() {
//
//        try {
//            return (ExemptionsFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.EXEMPTIONS_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//
//        throw new IllegalAccessError(ExemptionsFacadeLocal.class.getName());
//    }
    /**
     * @return
     */
    protected  DocumentFacadeRemote getDocumentService() {

        try {
            return (DocumentFacadeRemote)getServiceLocator().getRemoteEJB(ServiceLocator.Services.DOCUMENT_FACADE);
        } catch (ServiceLocatorException e) {
            log.error(e.getLocalizedMessage(), e);
        }

        throw new IllegalAccessError(DocumentFacadeRemote.class.getName());
    }

    /**
     * @return
     */
    protected  ReferenceFacadeRemote getReferenceService() {

        try {
            return (ReferenceFacadeRemote)getServiceLocator().getLocalEJB(ServiceLocator.Services.REFERENCE_FACADE);
        } catch (ServiceLocatorException e) {
            log.error(e.getLocalizedMessage(), e);
        }

        throw new IllegalAccessError(ReferenceFacadeRemote.class.getName());
    }

    /**
     * @return
     */
//    protected  BpelServiceProviderLocal getBpelService() {
//
//        try {
//            return (BpelServiceProviderLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.BPEL_PROVIDER_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//
//        throw new IllegalAccessError(BpelServiceProviderLocal.class.getName());
//    }
//    
//    /**
//     * @return
//     */
//    protected final ComplianceFacadeLocal getComplianceService() {
//
//        try {
//            return (ComplianceFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.COMPLIANCE_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//
//        throw new IllegalAccessError(ComplianceFacadeLocal.class.getName());
//    }
//
//    protected final JobsFacadeLocal getJobsBusinessService() {
//        try {
//            return (JobsFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.JOBS_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(JobsFacadeLocal.class.getName());
//    }
    /**
     * @return
     */
//    
    /**
     * @return
     */
//    protected  TaxCalculationFacadeLocal getTaxCalculationService() {
//
//        try {
//            return (TaxCalculationFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.TAX_CALCULATION_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//
//        throw new IllegalAccessError(TaxCalculationFacadeLocal.class.getName());
//    }
//    
    /**
     * @return
     */
     /**
    protected  ApplicationFacadeLocal getApplicationService() {
        try {
            return (ApplicationFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.APPLICATION_FACADE);
        } catch (ServiceLocatorException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        throw new IllegalAccessError(ApplicationFacadeLocal.class.getName());
    }**/
    
    /**
     * @return
     */
//    protected  CaseManagementFacadeLocal getCaseManagementService() {
//        try {
//            return (CaseManagementFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.CASE_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(CaseManagementFacadeLocal.class.getName());
//    }
//    
//    
//    protected AuditFacadeLocal getAuditAndVisitService() {
//        try {
//            return (AuditFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.AUDIT_VISIT_FACADE);            
//        }catch(ServiceLocatorException e){
//            log.error(e.getLocalizedMessage(), e);
//        }
//        
//        throw new IllegalAccessError(AuditFacadeLocal.class.getName());
//    }
    
    /**
     * 
     * @return
     */
//    protected  ReportingFacadeLocal getReportingService() {
//
//        try {
//            return (ReportingFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.REPORTING_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//
//        throw new IllegalAccessError(ReportingFacadeLocal.class.getName());
//    }    
    

    protected AppMenuFacadeLocal getAppMenuService() {
        try {
            return (AppMenuFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.APP_MENU_FACADE);
        } catch (ServiceLocatorException _ex) {
            log.error(_ex.getLocalizedMessage(), _ex);
        }
        
        throw new IllegalAccessError(AppMenuFacadeLocal.class.getName());
    }
    
    /**
     * It takes SearchResultInfo as parameter and returns the header details for an entity 
     * @param selectedRow
     * @return HeaderSummaryDetailsBean
     */
//    public HeaderSummaryDetailsBean findHeaderDetails(SearchResultInfo selectedRow){
//        selectedRow = SearchDelegate.getSelectedRow();
//        EntityInputTypeRowWrapper rowWrap = new EntityInputTypeRowWrapper(selectedRow);
//        return findHeaderDetails(rowWrap.getEntityType(),(Long)rowWrap.getPrimaryKey());
//    }
//    
//    
    /**
     * It takes an entity id as parameter and returns the header details for that entity 
     * @param entityId
     * @return the header summary details bean
     */
    public HeaderSummaryDetailsBean findHeaderDetails(Long entityId) {
        return findHeaderDetails(null, entityId);
    }    
//    
//    
//    
//    public HeaderSummaryDetailsBean findHeaderDetails(VariantType type) {
//        // In individual registration and organisation registration, there will be cases like the entity may not
//        // exist in the database. So we need to implement those cases in the following if statements.
//        if(type.getStoredTypeName().equals(BpelConstants.InputTypes.INDIVIDUAL)) {
//            return findHeaderDetails(type.getIndividualTaxpayerInputType());
//        }
//        else if(type.getStoredTypeName().equals(BpelConstants.InputTypes.ORGANISATION)) {
//            return findHeaderDetails(type.getOrganisationTaxpayerInputType());
//        }
//        return null;
//    }

    
//    public HeaderSummaryDetailsBean findHeaderDetails(OrganisationTaxpayerInputType orgInputType) {
//            HeaderSummaryDetailsBean headerSummaryBean = new HeaderSummaryDetailsBean();
//            headerSummaryBean.setId(orgInputType.getOrganisationDetails().getId());
//            String entityStatus = getRefCodeAssemblerService().findRefDescription(
//                orgInputType.getEntityAccount().getEntityAcctStatus(), DataReference.REF_REV_ACC_STATUS);
//            if(entityStatus != null && !entityStatus.equals("null")){
//                headerSummaryBean.setStatus(orgInputType.getEntityAccount().getEntityAcctStatus());
//                headerSummaryBean.setDisplayStatus(entityStatus);
//            }
//            headerSummaryBean.setEntityType(Constants.Entity.ORGANISATION_TYPE);
//            headerSummaryBean.setLegalName(orgInputType.getOrganisationDetails().getLegalName());
//            headerSummaryBean.setTradingName(orgInputType.getOrganisationDetails().getLegalStatus());//TODO
//            headerSummaryBean.setLegalStatus(orgInputType.getOrganisationDetails().getLegalStatus());
//            if(orgInputType.getEntityAccount()!=null && orgInputType.getEntityAccount().getAccountNumber()!=null)
//                headerSummaryBean.setAccountNumber(orgInputType.getEntityAccount().getAccountNumber());
//            if(orgInputType.getEntityAccount()!=null && orgInputType.getEntityAccount().getEDR()!=null)
//                headerSummaryBean.setDateOfRegistration(orgInputType.getEntityAccount().getEDR());
//            if(orgInputType.getEntityAccount()!=null && orgInputType.getEntityAccount().getOffice()!=null)
//                headerSummaryBean.setEntityOffice(orgInputType.getEntityAccount().getOffice());
//        return headerSummaryBean;
//    }
//    /**
//     * It takes an entity type and id as parameter and returns the header details for that entity 
//     * @param entityType
//     * @param entityID
//     * @return the header summary details bean
//     */
    public HeaderSummaryDetailsBean findHeaderDetails(String entityType, Long entityID){
        
        HeaderSummaryDetail value = null;
        if(null == entityType){
            value = getEntityService().findHeaderDetails(entityID); 
            entityType = value.getEntityType();
        }else{
           value =  getEntityService().findHeaderDetails(entityType,entityID);
        }
        if(value == null){
            return new HeaderSummaryDetailsBean();
        }
        HeaderSummaryDetailsBean header = new HeaderSummaryDetailsBean();
        if(null == value.getDateOfRegistration()){
            //do nothing            
        }else{
            Calendar cal = Calendar.getInstance();
            cal.setTime(value.getDateOfRegistration());
            header.setDateOfRegistration(cal);
        }

        if(null == value.getDateOfDeRegistration()){
            //do nothing            
        }else{
            Calendar cal = Calendar.getInstance();
            cal.setTime(value.getDateOfDeRegistration());
            header.setDateOfDeRegistration(cal);
        }
        
        header.setId(value.getId());
        header.setAccountNumber(value.getAccountNumber());
        header.setStatus(value.getStatus());
        header.setDisplayStatus(value.getDisplayStatus());
        header.setEntityType(entityType);
        header.setEntityAccountId(value.getEntityAccountId());
        header.setEntityOffice(value.getEntityOffice());

        // 21/04/2011 - for de-registration reason dropdown (TRGHA-1333)
        header.setLegalStatus(value.getLegalStatus());
        
        // 02/06/2011 - for task details screen (TRGHA-1485)
        header.setTin(value.getTin());
        
        if(entityType.equalsIgnoreCase(Constants.Entity.INDIVIDUAL_TYPE)){
            header.setTitle(value.getTitle());
            header.setFirstName(value.getFirstName());
            header.setMiddleName(value.getMiddleName());
            header.setLastName(value.getLastName());
            header.setSuffix(value.getSuffix());
            header.setLegalStatus(value.getLegalStatus());
        }
        if(entityType.equalsIgnoreCase(Constants.Entity.ORGANIZATION_TYPE)){
            header.setLegalName(value.getLegalName());
            header.setTradingName(value.getTradingName());
        }
        return header;
    }
//    
//    
//    public boolean isEntityRegistered(long entityID){        
//         EntEntity   value =  getEntityService().getEntEntity(entityID); 
//         if(value != null && value.getDtype() != null && value.getDtype().equalsIgnoreCase(Constants.Entity.NON_TAXPAYER_INDIVIDUAL)){
//             return false;
//         }
//         else{
//             return true;             
//         }
//    }
    
//    public HeaderSummaryDetailsBean findNonRegisteredTaxpayerHeaderDetails(String entityType, Long entityID){
//        
//        HeaderSummaryDetail value = getEntityService().findNonRegisteredTaxpayerHeaderDetails(entityType,entityID);        
//        if(value == null){
//            return new HeaderSummaryDetailsBean();
//        }
//        HeaderSummaryDetailsBean header = new HeaderSummaryDetailsBean();
//        
//        header.setId(value.getId());
//        header.setAccountNumber(value.getAccountNumber());
//        header.setStatus(value.getStatus());
//        header.setDisplayStatus(value.getDisplayStatus());
//        header.setEntityType(entityType);
//        header.setEntityAccountId(value.getEntityAccountId());
//        header.setEntityOffice(value.getEntityOffice());
//        header.setLegalStatus(value.getLegalStatus());    
//        header.setTin(value.getTin());
//        header.setTitle(value.getTitle());
//        header.setFirstName(value.getFirstName());
//        header.setMiddleName(value.getMiddleName());
//        header.setLastName(value.getLastName());
//        header.setSuffix(value.getSuffix());
//        header.setLegalStatus(value.getLegalStatus());
//        header.setLegalName(value.getLegalName());
//        header.setTradingName(value.getTradingName());
//        return header;
//    }
    /**
     * To get access to workflow facade bean
     * @return
     */
//    /**
//     * Invokes private buildComponents method.
//     * @param entity
//     * @param backing
//     * @return
//     * @throws NoSuchMethodException
//     * @throws InstantiationException
//     * @throws IllegalAccessException
//     */
//    public List<UIComponent> constructComponents(Object entity, String backing) throws NoSuchMethodException, 
//                                                                        InstantiationException, 
//                                                                        IllegalAccessException {      
//        List<UIComponent> components = this.buildComponents(entity, backing);
//        return components;
//    }

//    /**
//     * Creates list of UI components for all the fields of a given entity.
//     * @param entity
//     * @param backing
//     * @return
//     * @throws NoSuchMethodException
//     * @throws InstantiationException
//     * @throws IllegalAccessException
//     */
//    private List<UIComponent> buildComponents(Object entity, String backing) throws NoSuchMethodException, 
//                                                                    InstantiationException, 
//                                                                    IllegalAccessException {
//        List<UIComponent> components = new ArrayList<UIComponent>();
//        // Create a list of Fields for a given entity based on the declared fields of that entity
//        List<Field> fields = ReflectionHelper.getDeclaredFieldsWithInheritance(entity.getClass()); 
//         UIComponent component = null;
//        for(int f=0; f < fields.size(); f++){
//            Field field = fields.get(f);
//            //Create a UI component for the field except version
//            if(!field.getName().equalsIgnoreCase("version") && !(field.getName().equalsIgnoreCase("workflow") 
//                && backing.equalsIgnoreCase("backingWorkflowManagement"))) {
//                component = this.buildComponentOfType(entity,field, backing);
//            }
//            if(null != component){
//                // Add created component in to the list
//                components.add(component);
//            }
//        }        
//        return components;
//    }
    
//    /**
//     * Creates a correspoding backing field for each component of the entity based 
//     * on the type or annotations
//     * @param entity
//     * @param field
//     * @param backing
//     * @return
//     */
//    private UIComponent buildComponentOfType(Object entity, Field field, String backing) {
//        Class fieldType = field.getType();     
//        String fieldName = field.getName();
//        String valueBindingString = null;
//        UIComponent component = null;
//        String primaryKey=null;
//        // Create the component
//        component = this.createComponent(entity, field);
//        
//        valueBindingString = "#{"+backing+".entity."+fieldName+"}";
//        if(component != null){  
//            List<Field> fields = ReflectionHelper.getDeclaredFieldsWithInheritance(fieldType); //fieldType.getDeclaredFields();
//            for(int i=0; i<fields.size(); i++){
//                Field f = fields.get(i);
//                // If annotation of the field is Id then add field name as 
//                // primary key to the value binding
//                if(f.isAnnotationPresent(javax.persistence.Id.class))
//                    primaryKey = f.getName();
//            }
//            if(primaryKey != null)
//                valueBindingString = "#{"+backing+".entity."+fieldName+"."+ primaryKey+"}";
//            else
//                valueBindingString = "#{"+backing+".entity."+fieldName+"}";
//        }
//
//        ValueBinding valueBinding = 
//             FacesUtil.getFacesContext().
//             getApplication().createValueBinding(valueBindingString);
//        
//        if(component != null){
//            component.setValueBinding("value",valueBinding);
//            // Set Id of the component to field name. This plays in imp role
//            // in GUI configuration
//            component.setId(fieldName);
//        }
//        return this.applyBuildOfSpecificComponent(field,component);
//    }
    
//    /**
//     * This method handles specific components like drop downs, ex status
//     * @param field
//     * @param component
//     * @return
//     */
//    private UIComponent applyBuildOfSpecificComponent(Field field,UIComponent component){
//        if(component != null){
//            if(component.getClass().equals(CoreSelectOneChoice.class)){
//                ReferenceCodeDelegate refCodeDelegate = new ReferenceCodeDelegate();
//                Object value = component.getValueBinding("value").getValue(FacesUtil.getFacesContext());
//                List<SelectItem> refData = null;
//                // Get list of reference data from entity based on the field
//                if(field.getName().equalsIgnoreCase("status")){
//                    refData = refCodeDelegate.findAllReferenceEntity(RefStatus.class.getSimpleName(),value);
//                } else if(field.getName().equalsIgnoreCase("docStatus") || field.getName().equalsIgnoreCase("endDocStatus")){
//                    refData = refCodeDelegate.findAllReferenceEntity(RefDocStatus.class.getSimpleName(),value);
//                } else if(field.getName().equalsIgnoreCase("docRegime")){
//                    refData = refCodeDelegate.findAllReferenceEntity(RefCustomsRegime.class.getSimpleName(),value);
//                } else if(field.getName().equalsIgnoreCase("operation") || field.getName().equalsIgnoreCase("nextAction")){
//                    refData = refCodeDelegate.findAllReferenceEntity(RefWfOperation.class.getSimpleName(),value);
//                } else if(field.getName().equalsIgnoreCase("workflowCondition")){
//                    refData = refCodeDelegate.findAllReferenceEntity(WfWorkflowCondition.class.getSimpleName(),value);
//                } 
//                
//                // Put list of Values with respective Labels to the select item
//                List<CoreSelectItem> coreSelectItemOfRefData = new ArrayList<CoreSelectItem>(refData.size());
//                for(int i =0;i<refData.size();i++){
//                    CoreSelectItem items = new CoreSelectItem();
//                    items.setLabel(refData.get(i).getLabel());
//                    items.setValue(refData.get(i).getValue());
//                    coreSelectItemOfRefData.add(items);
//                }
//                component.getChildren().addAll(coreSelectItemOfRefData);  
//                // To take more precaution reset the the component values
//                ((CoreSelectOneChoice)component).resetValue();
//                // Setting the SubmittedValue helps in displaying value on the screen
//                // Setting the Value helps in getting value from the the dropdown component
//                // when form is submitted
//                ((CoreSelectOneChoice)component).setSubmittedValue(value);
//                ((CoreSelectOneChoice)component).setValue(value);
//                ((CoreSelectOneChoice)component).setLocalValueSet(true);
//                ((CoreSelectOneChoice)component).setValuePassThru(true);
//            }
//        }
//        return component;    
//    }
    
//    /**
//     * Creates input text, date, drop down components based on the type or 
//     * annotation of the field and there respective labels.
//     * @param entity
//     * @param field
//     * @return
//     */
//    private UIComponent createComponent(Object entity, Field field) {
//        UIComponent component = null;        
//        String componentType = null;
//        String resource = entity.getClass().getSimpleName() + ".column." + field.getName();
//        // Create the resources lable
//        // The label name mentioned in the UIResources.properties file should be like
//        // <entity Name>.column.<element name as in entity>
//        String label = "#{resources['"+resource+"']}";
//
//        if(field.getType().equals(Timestamp.class) || field.getType().equals(Calendar.class)) {
//            // If the field type is Calender then set component type as sSelectInputDate
//            componentType =  CoreSelectInputDate.COMPONENT_TYPE;        
//        } else if(this.checkForGivenAnnotation(field.getAnnotations(),ManyToOne.class)) {
//            // If the field has ManyToOne annotation then set component type to SelectOneChoice 
//               componentType =  CoreSelectOneChoice.COMPONENT_TYPE;   
//        } else if(field.getName().equalsIgnoreCase("status") || field.getName().equalsIgnoreCase("docStatus")
//            || field.getName().equalsIgnoreCase("docRegime") || field.getName().equalsIgnoreCase("operation")
//            || field.getName().equalsIgnoreCase("nextAction") || field.getName().equalsIgnoreCase("endDocStatus")
//            || field.getName().equalsIgnoreCase("workflowCondition")) {
//            // If the filed is Status or docStatus or docRegime (both of WfWorkflowMapping entity) 
//            // then by default component type should be SelectOneChoice
//            componentType =  CoreSelectOneChoice.COMPONENT_TYPE;
//        } else {
//            // Rest other component type will be input text
//            componentType =  CoreInputText.COMPONENT_TYPE;
//        }
//        
//        // Based on the component type, component is created
//        if(componentType != null){
//            component = FacesUtil.getFacesContext().
//                getApplication().createComponent(componentType);
//        }
//        
//        // Value binding is created using label
//        ValueBinding valueBinding = FacesUtil.getFacesContext().getApplication().createValueBinding(label);
//        if(component != null){
//            // createdBy and updatedBy are input texts and made read only
//            if(field.getName().equalsIgnoreCase("createdBy") || field.getName().equalsIgnoreCase("updatedBy")){
//                CoreInputText inputText = (CoreInputText)component;
//                inputText.setReadOnly(true);
//            }
//            // createdDate and updatedDate are input dates and made read only
//            if(field.getName().equalsIgnoreCase("createdDate") || field.getName().equalsIgnoreCase("updatedDate")){
//                CoreSelectInputDate inputDate = (CoreSelectInputDate)component;
//                inputDate.setReadOnly(true);
//            }
//            
//            component.setValueBinding("label",valueBinding);
//        }
//        return component;
//    }
    
//    /**
//     * Iterate the array of Annotations and return true if it is of type of parameter 2
//     * @param annotations
//     * @param annonation
//     * @return
//     */
//    private boolean checkForGivenAnnotation(Annotation[] annotations,Class annonation ){
//        for(int i=0; i<annotations.length; i++){
//           if(annotations[i].annotationType().equals(annonation)){
//               return true;
//           }
//        }
//        return false;
//    }

    public Object callFunction(Object[] args, 
                                             String methodName) {
        
        if(null == args || null == methodName){
            return null;
        }else{
            Class[] clazzes = new Class[args.length];
            for(int i =0; i<args.length; i++){
                clazzes[i] = args[i].getClass();
            }
            
            Method method = null;;

            try {
                method = this.getClass().getMethod(methodName,clazzes);
                return method.invoke(this,args);
            } catch (NoSuchMethodException e) {
                log.error(e.getLocalizedMessage(), e);
            } catch (IllegalAccessException e) {
                 log.error(e.getLocalizedMessage(), e);
            } catch (InvocationTargetException e) {
                log.error(e.getLocalizedMessage(), e);
            }
            
            throw new IllegalAccessError("Unable to call function");
        }
    }

    /**
     * @return
     */
//    protected  ConfigurationFacadeLocal getConfigurationService() {
//        try {
//            return (ConfigurationFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.CONFIGURATION_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(ConfigurationFacadeLocal.class.getName());
//    }
//    
//    /**
//     * @return
//     */
//    protected  ApplicationFacadeLocal getApplicationService() {
//        try {
//            return (ApplicationFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.APPLICATION_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(ApplicationFacadeLocal.class.getName());
//    }
//
//    protected static SystemFacadeLocal getSystemService() {
//        try {
//            return (SystemFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.SYSTEM_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(SystemFacadeLocal.class.getName());
//    }
//    
//    protected  ComputeFacadeLocal getComputeService() {
//        try {
//            return (ComputeFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.COMPUTE_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(ComputeFacadeLocal.class.getName());
//    }

//
//    protected  AnalysisFacadeLocal getAnalysisService() {
//        try {
//            return (AnalysisFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.ANALYSIS_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(AnalysisFacadeLocal.class.getName());
//    }
//

//    protected  TaskServiceFacadeLocal getTaskService() {
//        try {
//            return (TaskServiceFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.TASK_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(TaskServiceFacadeLocal.class.getName());
//    }
//
//    protected  BatchFacadeLocal getBatchService() {
//        try {
//            return (BatchFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.BATCH_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(BatchFacadeLocal.class.getName());
//    }

    public InputType findInputType(Class<? extends InputType> typeClass, Long id) {
        return getRefCodeAssemblerService().findInputType(typeClass, id);
    }
    
    public SubmissionOutputType invokeBpel(Serializable type, String bpelName) {
//        return getBpelService().invokeBpel(type, bpelName);
        return new SubmissionOutputType();
    }
//    

    public static Object getInstance(String className) {
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
        try {
            return clazz.newInstance();
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        } catch (InstantiationException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
    }
	
//
//    protected  RegistrationValidatorLocal getRegistrationValidationService() {
//
//        try {
//            return (RegistrationValidatorLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.REGISTRATION_VALIDATION_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//
//        throw new IllegalAccessError(RegistrationValidatorLocal.class.getName());
//    }    
    
    public MessageHelper initializeMessageHelper(Class messageHelperClass) {
        return getReferenceService().initializeMessageHelper(messageHelperClass);
    }
    
//    public EntityBusLogicValidator getEntityBusLogicValidator() {
//        EntityBusLogicValidator validator = (EntityBusLogicValidator)
//            BusinessLogicValidator.getInstance(Constants.BusinessLogicValidatorType.ENTITY_VALIDATOR);
//        return validator;
//    }
    
    protected final AccountFacadeRemote getAccountService() {
        try {
            return (AccountFacadeRemote)getServiceLocator().getLocalEJB(ServiceLocator.Services.ACCOUNT_FACADE);
        } catch (ServiceLocatorException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        throw new IllegalAccessError(AccountFacadeRemote.class.getName());
    }
//    
    protected final RevenueAccountFacadeRemote  getRevenueAccountService() {
        try {
            return (RevenueAccountFacadeRemote)getServiceLocator().getRemoteEJB(ServiceLocator.Services.REVENUE_ACCOUNT_FACADE);
        } catch (ServiceLocatorException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        throw new IllegalAccessError(RevenueAccountFacadeRemote.class.getName());
    }
       
//    protected final TransactionFacadeLocal getTransactionService() {
//        try {
//            //TODO ServiceLocator.Services.TRANSACTION_FACADE - had a problem hence hardcoded. 
//            return (TransactionFacadeLocal)getServiceLocator().getLocalEJB("TransactionFacade");
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(TransactionFacadeLocal.class.getName());
//    }
//    
//    protected final CalendarManagementFacadeLocal  getCalendarService() {
//        try {
//            return (CalendarManagementFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.CALENDAR_MANAGEMENT_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(CalendarManagementFacadeLocal.class.getName());
//    }

//    protected final RefundsFacadeLocal  getRefundsService() {
//        try {
//            return (RefundsFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.REFUNDS_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(RefundsFacadeLocal.class.getName());
//    }

    protected final EnforcementFacadeRemote getEnforcementService() {
        try {
            return (EnforcementFacadeRemote)getServiceLocator().getRemoteEJB(ServiceLocator.Services.ENFORCEMENT_FACADE);
        } catch (ServiceLocatorException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        throw new IllegalAccessError(EnforcementFacadeRemote.class.getName());
    }
    
//    protected InstalmentAgreementFacadeLocal getInstalmentAgreementService() {
//           try {
//               return (InstalmentAgreementFacadeLocal )getServiceLocator().getLocalEJB(ServiceLocator.Services.INSTALMENT_AGREEMENT_FACADE);
//           } catch (ServiceLocatorException e) {
//               log.error(e.getLocalizedMessage(), e);
//           }
//           throw new IllegalAccessError(InstalmentAgreementFacadeLocal.class.getName());
//    }
//    
//    protected final RiskManagementFacadeLocal getRiskManagementService() {
//        try {
//            return (RiskManagementFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.RISK_MANAGEMENT_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(RiskManagementFacadeLocal.class.getName());
//    }
    
//    protected final TaxRatesFacadeLocal getTaxRateManagementService() {
//        try {
//            return (TaxRatesFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.TAX_RATE_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(TaxRatesFacadeLocal.class.getName());
//    }
    
    protected final UserManagementFacadeLocal getUserManagementService() {
        try {
            return (UserManagementFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.USER_MANAGEMENT_FACADE);
        } catch (ServiceLocatorException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        throw new IllegalAccessError(UserManagementFacadeLocal.class.getName());
    }

    protected final RateManagementFacadeRemote getRateManagementService() {
        try {
//            return (RateManagementFacadeRemote)getServiceLocator().getLocalEJB(ServiceLocator.Services.RATE_MANAGEMENT_FACADE);
            RateManagementFacadeRemote rateManagementFacadeRemote =

                (RateManagementFacadeRemote) getServiceLocator().getRemoteEJB("RateManagementFacade#com.technobrain.trips.ratemanagement.service.RateManagementFacadeRemote");
            
            return  rateManagementFacadeRemote;           
            
        } catch (ServiceLocatorException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        throw new IllegalAccessError(RateManagementFacadeRemote.class.getName());
    }
    
//    protected final MessageFacadeLocal getMessageService() {
//        try {
//            return (MessageFacadeLocal)getServiceLocator().getLocalEJB(ServiceLocator.Services.MESSAGE_FACADE);
//        } catch (ServiceLocatorException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        throw new IllegalAccessError(MessageFacadeLocal.class.getName());
//    }
}
