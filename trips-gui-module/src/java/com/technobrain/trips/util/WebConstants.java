package com.technobrain.trips.util;


import com.technobrain.trips.common.constants.Constants;
import java.util.HashMap;
import java.util.Map;


/**
 * @since Novemeber 24,2006
 * @author hhill
 */
public abstract class WebConstants {

//TODO (VP) This hash map need to be removed as it is not used.
//    private static HashMap ACCOUNT_NAVIGATION_BY_REGIME = null;
//    
//    static {
//        ACCOUNT_NAVIGATION_BY_REGIME = new HashMap();
//        ACCOUNT_NAVIGATION_BY_REGIME.put(Constants.Regimes.IIT,"FromScreenToIITReturn");
//        ACCOUNT_NAVIGATION_BY_REGIME.put(Constants.Regimes.FBT,"FromScreenToFBTReturn");
//        ACCOUNT_NAVIGATION_BY_REGIME.put(Constants.Regimes.WIT,"FromScreenToWHTReturn");
//        ACCOUNT_NAVIGATION_BY_REGIME.put(Constants.Regimes.VAT,"FromScreenToVATReturn");
//        ACCOUNT_NAVIGATION_BY_REGIME.put(Constants.Regimes.PAYE,"FromScreenToPAYEReturn");
//        ACCOUNT_NAVIGATION_BY_REGIME.put(Constants.Regimes.CIT,"FromScreenToCITReturn");
//        ACCOUNT_NAVIGATION_BY_REGIME.put(Constants.Regimes.FOF,"FromScreenToFOF");
//        ACCOUNT_NAVIGATION_BY_REGIME.put(Constants.Regimes.EXCISE,"FromScreenToExciseReturn");
//    }
    
    private static HashMap NAVIGATION_TO_RELATED_DOCUMENTS = null;
    
    static {
        NAVIGATION_TO_RELATED_DOCUMENTS = new HashMap();
        NAVIGATION_TO_RELATED_DOCUMENTS.put(Constants.DocumentDTypes.IIT,"FromScreenToIITReturn");
        NAVIGATION_TO_RELATED_DOCUMENTS.put(Constants.DocumentDTypes.VAT,"FromScreenToVATReturn");
        NAVIGATION_TO_RELATED_DOCUMENTS.put(Constants.DocumentDTypes.PAYE,"FromScreenToPAYEReturn");
        NAVIGATION_TO_RELATED_DOCUMENTS.put(Constants.DocumentDTypes.CIT,"FromScreenToCITReturn");
        NAVIGATION_TO_RELATED_DOCUMENTS.put(Constants.DocumentDTypes.DOM_EXC,"FromScreenToExciseReturn");
        NAVIGATION_TO_RELATED_DOCUMENTS.put(Constants.DocumentDTypes.WIT,"FromScreenToWHTReturn");
        NAVIGATION_TO_RELATED_DOCUMENTS.put(Constants.DocumentDTypes.FBT,"FromScreenToFBTReturn");
        NAVIGATION_TO_RELATED_DOCUMENTS.put(Constants.DocumentDTypes.FOF,"FromScreenToFOF");
        NAVIGATION_TO_RELATED_DOCUMENTS.put(Constants.DocumentDTypes.DECLARE,"FromScreenToDeclaration");
    }
    
    public interface RecordStatus{
        public static final String ACTIVE = "A";
        public static final String IN_ACTIVE ="D";
    }
    
    public interface Field{
        public static final String ID = "id";
        public static final String CODE = "code";
        public static final String DESC ="description";
        public static final String COMPANY_NAME ="companyName";
        public static final String FIRST_NAME ="firstName";
        public static final String LAST_NAME ="lastName";
        
    }
    
    /**
     * Session scope variables kept with these keys are removed from session when user goes to the home page
     */
    public interface SessionVariable{
        /**CUSTOMS_REGIME and PERIODIC_REGIME used to render panelForm for custom regime and periodic regime 
          * respectively on Regime.jspx, based on the selection of regime type*/
        public static final String CUSTOMS_REGIME = "customRegime";
        public static final String PERIODIC_REGIME ="periodicRegime";
        
        /**CONTACT_NUMBER and EMAIL used to render inputText for phone code and email address 
         * respectively on ContactMethod.jspx, based on the selection of contact type
         */
        public static final String CONTACT_NUMBER ="contactNumber";
        public static final String EMAIL ="eMail";
        
        /**IND_ENTITY and ORG_ENTITY used to render panelGroup individual entity and organisation entity
          *respectively on CustomsEntity.jspx and FindEntity.jspx, based on the selection of entity type*/
        public static final String IND_ENTITY ="indEntity";
        public static final String ORG_ENTITY ="orgEntity";
       
        public static String KEY_WORKFLOW_CONTEXT = "WorkflowContext";
        public static String KEY_WORKFLOW_CLIENT = "WorkflowClient";
        public static String KEY_WORKFLOW_USER = "WorkflowUser";
        public static String KEY_CURRENT_TASK = "CurrentTask";
		public static String KEY_CURRENT_TASK_ID = "CurrentTaskId";
        
        String IN_POP_UP_FLOW = "IN_POP_UP_FLOW";
        
        public static String FILE_STORE = "FileStore" ;
        
        /**
         * Define the session key used for the single select table handler
         */
        public static final String TABLE_HANDLER_KEY = "SingleSelectionTableHandler";
        
        /**
         * Define the mode used when table rows is to be mananger
         */
        public static final String TABLE_MODE_KEY = "mode";
        public static final String CASE_INPUT_TYPE_KEY = "CaseInputType";
        public static final String REPORT_STORE_KEY = "REPORT_STORE_KEY";
        
        public static final String CONFIG_SET_MODE_ID = "CONFIG_SET_MODE_ID";
        public static final String DYNAMIC_SEARCH_CRITERIA_INSERTION_MAP = "DYNAMIC_SEARCH_CRITERIA_INSERTION_MAP";
        public static final String DECLARATION_DOCUMENT_ID ="DecId";
    }
    
    public interface RequestVariable{
       String ACC_ENQ_TRANS_ID_TO_PAYMENT = "ACC_ENQ_TRANS_ID_TO_PAYMENT";
       String PUT_BACKING_BEANS_BACK = "PUT_BACKING_BEANS_BACK";
       String DISCLOSE_TAB_ID = "DISCLOSE_TAB_ID";
       String ENABLE_MULTI_SELECT="enableMultiSelect";
       String MULTI_TABLE_HANDLERS_MAP_KEY="MULTI_TABLE_HANDLERS_MAP_KEY";
       public static final String DISCARD_CHANGES = "discardChanges";
        String ACC_ENQ_RECEIPT_ID_TO_PAYMENT = "ACC_ENQ_RECEIPT_ID_TO_PAYMENT";
        String REG_IND_INPUT_TYPE = "indInputType";
        String REG_ORG_INPUT_TYPE = "orgInputType";
        String DE_REG_REGIME_TYPE = "DE_REG_REGIME_TYPE";
        String ACC_ENQ_ENT_ID_TO_PAYMENT = "ACC_ENQ_ENT_ID_TO_PAYMENT";
    }
    
    public interface GenericSearchProcessScopeVars {
        public static final String SEARCH_MODE_KEY = "processScopeGenericSearchModeKey";
        public static final String SHOW_SAVE_SEARCH = "processScopeShowSaveSearch";
        public static final String SHOW_LOAD_SEARCH = "processScopeLoadSearch";
        public static final String SEARCH_LOOK_UP_KEY = "processScopeGenericLookUpRequired";
        public static final String SEARCH_KEY = "processScopeSearchKey";
        public static final String GENERIC_DIALOG = "processScopeGenericDialog";
        public static final String POST_SEARCH_NAV_KEY = "processScopeNavigation";
        public static final String RENDER_CLOSE_BUTTON_ON_SEARCH = "processScopeRenderCloseButton";
        public static final String FOR_FIELD_VALUES = "processScopeForFieldValues";
        public static final String RETURN_COLUMN = "processScopeReturnColumn";
        public static final String STATIC_SEARCH_INJECTION = "staticSearchInjection";        
        public static final String PARTIAL_FOR_FIELD_LIST = "partialForFieldList"; 
        public static final String SHOW_ADD_OR_NEXT_BUTTON = "showAddOrNextButton"; 
        public static final String SHOW_COPY_NEW_BUTTON = "showCopyNewButton";

        public static final String VALUE_REQUIRED_ON_RETURN_FROM_DIALOG = "valueRequiredOnReturnFromDialog";
        public static final String REPLACEMENT_TABLE = "processScopeReplacementTable";
        
        public static final String GENERIC_SEARCH_CONDITIONS="GENERIC_SEARCH_CONDITIONS";
        
        public static final String PROCESS_SCOPE_FILTER_OFFICE="processScopeFilterOffice";
        
    }
    
    /**
     * Process scope variables kept with these keys are removed from session when user goes to the home page
     */
    public interface ProcessScopeVariable{
        /**
         * These variable used to store the PaymentSummary header info on process scope and to display them on
         * PaymentDetails.jspx
         */
        public static final String PAYMENT_DATE = "paymentDate";
        public static final String PAYMENT_AMOUNT = "paymentAmount";
        public static final String RECEIPT_NUMBER = "receiptNumber";
        public static final String CURRENCY = "currency";
        
        public static String FORM_TYPE = "FORM_TYPE";
        public static final String DONT_CHANGE_PAGE_MODE = "processScopeDontChangePageMode";
        public static String FORM = "FORM";
        public static String TRANSACTION_ID = "TRANSACTION_ID";
        
        public static final String GUI_MODE = "processScopeGuiMode";
        public static final String PAGE_CONFIG = "processScopePageConfig";
        public static final String GUI_MODE_FOR_RETURN = "processScopeGuiModeForReturn";
        public static final String PAGE_CONFIG_FOR_RETURN = "processScopePageConfigForReturn";
        public static final String RUN_METHOD_AFTER_SEARCH = "runMethodAfterGenericSearchBeforeNavigation";
        public static final String SHOULD_RUN_METHOD_BEFORE_NAVIGATION = "shouldRunMethodBeforeNavigation";
        
        public static final String SEARCH_MODE_KEY = GenericSearchProcessScopeVars.SEARCH_MODE_KEY;
        public static final String SHOW_SAVE_SEARCH = GenericSearchProcessScopeVars.SHOW_SAVE_SEARCH;
        public static final String SHOW_LOAD_SEARCH = GenericSearchProcessScopeVars.SHOW_LOAD_SEARCH;
        public static final String SEARCH_LOOK_UP_KEY = GenericSearchProcessScopeVars.SEARCH_LOOK_UP_KEY;
        public static final String SEARCH_KEY = GenericSearchProcessScopeVars.SEARCH_KEY;
        public static final String RETURN_COLUMN = GenericSearchProcessScopeVars.RETURN_COLUMN;
        public static final String GENERIC_DIALOG = GenericSearchProcessScopeVars.GENERIC_DIALOG;
        public static final String POST_SEARCH_NAV_KEY = GenericSearchProcessScopeVars.POST_SEARCH_NAV_KEY;
//        public static final String IS_INDIVIDUAL_SEARCH = "processScopeIsIndividualSearch";
//        public static final String IS_ORGANIZATION_SEARCH = "processScopeIsOrganizationSearch";
        public static final String RENDER_CLOSE_BUTTON_ON_SEARCH = GenericSearchProcessScopeVars.RENDER_CLOSE_BUTTON_ON_SEARCH;
        public static final String FOR_FIELD_VALUES = GenericSearchProcessScopeVars.FOR_FIELD_VALUES;
        public static final String REPLACEMENT_TABLE = GenericSearchProcessScopeVars.REPLACEMENT_TABLE;
        
        public static final String MULTI_TABLE_HANDLERS_MAP_KEY="multiTableHandlersMapKey";
        public static final String HEADER_SUMMARY = "headerSummary";
        public static final String INDIVIDUAL = "individual";
        public static final String TIN = "tin";
        public static final String MAKE_REGIME_BTN_DISABLE="makeRegRegimeBtnDisable";
        public static final String MAKE_REGIME_TAB_DEFAULT="makeRegimeTabDefault";
        public static final String NOTIFICATION_CONFIGURATION="notificationConfiguration";
        public static final String HIDE_ON_REGINDV="HideOnRegInd";
        public static final String DISCLOSE_ITEM_TAB="discloseItemTab";
        public static final String CANCEL_NAV = "processScopeCancelNav";
        public static final String SKIP_TASK_HANDLER_PAGE_ON_CANCEL = "skipTaskHandlerPageOnCancel";
        public static final String DUP_CHOICE_NAV = "processScopeDupChoiceNav";
        public static final String DUP_CONFIRM_INDICATOR = "DuplicateConfirm";
        public static final String TRANSITION_ENTITY_ID =  "Transition_EntityID";
        public static final String TRANSITION_DUP_LIST =  "Transition_DuplicateList";
        public static final String CONSIGNMENT_ITEM_GOODS_TABLE =  "itemTableInProcessScope";
        public static final String GOODS_ITEM_CONTAINER_TABLE = "goodsItemTableInProcessScope";
        public static final String ADD_MODE = Constants.Modes.ADD;
        public static final String GUI_CONFIG_KEY = "processScopePageConfig"; 
       
        public static final String RETURN_TO_REQUESTED_FROM_PAGE = "returnTorequestedPage";
        public static final String CASE_TYPE = "caseType";
        public static final String ENTITY_ID = "ENTITY_ID_USED_IN_PAGE_TRANSITION";
        public static final String REGIME_TYPE = "REGIME_TYPE_USED_IN_PAGE_TRANSITION";
        public static final String DREF_PERIODIC_ID = "REQUEST_DREF_PERIODIC_ID"; 
        public static final String IS_WITHIN_CASE_TABS = "isWithinCaseTabs";
        public static final String REVENUE_ACC_ID = "Transition_RevenueAccID";
        public static final String REFUND_ID = "REFUND_ID_USED_IN_PAGE_TRANSITION";
        public static final String HAS_RISK = "hasRisk";
        
        public static final String SUPRESS_CREATE_NEW_BUTTON = "supressCreateNewButton";
        public static final String DOC_ID = "DOC_ID_USED_IN_PAGE_TRANSITION";
        public static final String CASE_ID = "CASE_ID_USED_IN_PAGE_TRANSITION";
        
        public static final String SHOULD_AUTO_NAVIGATE = "shouldAutoNavigate";
        
        public static final String COMING_FROM_TABLEROW_AND_TABLES_BACKING_BEAN = "comingFromObeTableRowAndTablesBackingBean";
        public static final String DEC_ID = "DECLARATION_ID_USED_IN_PAGE_TRANSITION";
        
        public static final String REPORT_RESULT_INFO = "REPORT_RESULT_INFO";
        public static final String GUARANTEE_USAGE_TYPE = "GUARANTEE_USAGE_TYPE";
        
        public static final String GUARANTEE_ID = "GUARANTEE_ID_USED_IN_PAGE_TRANSITION";
        public static final String ALREADY_SELECTED_ITEM = "AlreadySelectedItem";
        public static final String AVAILABLE_DATA_FOR_MULTIPLE_SELECTION = "availableDataForMultipleSelection";
        public static final String COMMODITY_CODE = "commodityCode";
        public static final String STATIC_SEARCH_INJECTION = GenericSearchProcessScopeVars.STATIC_SEARCH_INJECTION;
        public static final String DYNAMIC_SEARCH_CRITERIA_SETUP = "DYNAMIC_SEARCH_CRITERIA_SETUP";
        public static final String TAXPAYER_TYPE = "taxpayerType";
        public static final String PARTIAL_FOR_FIELD_LIST = GenericSearchProcessScopeVars.PARTIAL_FOR_FIELD_LIST; 
        public static final String SHOW_ADD_OR_NEXT_BUTTON = GenericSearchProcessScopeVars.SHOW_ADD_OR_NEXT_BUTTON;   
        public static final String SHOW_COPY_NEW_BUTTON = GenericSearchProcessScopeVars.SHOW_COPY_NEW_BUTTON;
        public static final String CREATE_COPY = Constants.OperationType.CREATE_NEW_FROM_COPY;
        public static final String LEGAL_STATUS = "LEGAL_STATUS";
        public static final String ENTITY_TYPE = "ENTITY_TYPE";
        public static final String SHAREHOLDERS_PARTNERS = "processScopeShareholdersPartners";
        public static final String RELATIONSHIP_DETAILS = "processScopeRelationshipDetails";
        public static final String SHAREHOLDERS = "Shareholders";
        public static final String PARTNERS = "Partners";
        public static final String SUBSIDIARY = "Subsidiary";
        public static final String RELATED_COMPANIES = "RelatedCompanies";
        public static final String RELATION_SHIPS = "Relationships";
        public static final String DIRECTORS = "Directors";
        public static final String VERIFY_ID = "VeriftId";
        public static final String MISCELLANEOUS_ENTITY = "MiscellaneousEntity";
        public static final String MAINTAIN_ALLOCATION_DETAILS = "processScopeMaintainAllocationDetails";
        public static final String CREDIT_ALLOCATION = Constants.AllocationTypes.CREDIT;
        public static final String DEBIT_ALLOCATION = Constants.AllocationTypes.DEBIT;
        public static final String REVENUE_ACCOUNT_SHOW_BUSINESS_SECTOR = "REVENUE_ACCOUNT_SHOW_BUSINESS_SECTOR";
        public static final String REVENUE_ACCOUNT_SHOW_BUSINESS_SECTOR_ON_LEVEL = "REVENUE_ACCOUNT_SHOW_BUSINESS_SECTOR_ON_LEVEL";
        public static final String TRANSITION_FLEXIBLE_FORM_RECORD_ID =  "TRANSITION_FLEXIBLE_FORM_RECORD_ID";
        
        public static final String FORM_ID =  "FORM_ID";
        public static String DOCUMENT_TYPE = "DOCUMENT_TYPE";
        public static final String LINKED_CASE_ID =  "LINKED_CASE_ID";
        public static final String PROCESS_REFUND_PAYMENT_NAVIGATION = "processRefundPaymentNavigation";
        public static final String PROCESS_REFUND_VIEW_NAVIGATION = "processRefundViewtNavigation";
        public static final String CASE_CATEGORY="processScopeCaseCategory";
        public static final String OBJ_APP_FLOW_MODE="processScopeObjAppFlowMode";
        
        public static final String COMPLIANCE_TYPE="complianceType";
        public static final String AUDIT_REPORT_RESULT="AUDIT_REPORT_RESULT";
        public static final String FUTURE_RATE_EDIT="FUTURE_RATE_EDIT";
        
        public static final String PROCESS_SCOPE_FILTER_OFFICE=GenericSearchProcessScopeVars.PROCESS_SCOPE_FILTER_OFFICE;
        
    }
    
    public interface ViewIdObjectMapping{
       public static final  String[] REGIME =  
       new String[]{"regimeType",
                    Constants.Regimes.CIT+":FromGenericSearchToCITReturn",
                    Constants.Regimes.CREDIT_JOURNAL_REALL+":goToVatScreen",
                    Constants.Regimes.CUSTOMS+":goToVatScreen",
                    Constants.Regimes.EXCISE+":FromGenericSearchToExciseReturn",
                    Constants.Regimes.FBT+":FromGenericSearchToFBTReturn",
                    Constants.Regimes.IIT+":FromGenericSearchToIITReturn",
                    Constants.Regimes.MISC+":goToVatScreen",
                    Constants.Regimes.PAYE+":FromGenericSearchToPAYEReturn",
                    Constants.Regimes.SUSPENSE+":goToVatScreen",
                    Constants.Regimes.VAT+":FromGenericSearchToVATReturn",
                    Constants.Regimes.WIT+":FromGenericSearchToWHTReturn"};
                    
        public static final  String[] ENTITY =  
        new String[]{"dType",
                     Constants.Entity.DTYPE_INDIVIDUAL+":FromGenericSearchToIndividualSummaryDetails",
                     Constants.Entity.DTYPE_ORGANIZATION+":FromGenericSearchToOrganisationSummaryDetails",
                     Constants.Entity.ORGANISATION_TYPE+":FromGenericSearchToOrganisationSummaryDetails"};

        public static final  String[] SUSPECT =  
        new String[]{"entityType",
                    Constants.SuspectType.AIRCRAFT+":FromGenericSearchToAircraftDetails",
                    Constants.SuspectType.CONTAINER+":FromGenericSearchToSuspectContainerDetails",
                    Constants.SuspectType.INDIVIDUAL+":FromGenericSearchToIndividualDetails",
                    Constants.SuspectType.ORGANISATION+":FromGenericSearchToOrganisationDetails",
                    Constants.SuspectType.ORGANIZATION+":FromGenericSearchToOrganisationDetails",
                    Constants.SuspectType.VESSEL+":FromGenericSearchToVesselDetails",
                    Constants.SuspectType.VEHICLE+":FromGenericSearchToVehicleDetails",
                    Constants.SuspectType.OTHER+":FromGenericSearchToOtherDetails",
                    Constants.SuspectType.GOODS+":FromGenericSearchToGoods"};
                    
                    
        public static final  String[] INTEL_SPOTLIGHT =  
        new String[]{"Type",
                    Constants.SuspectType.AIRCRAFT+":FromGenericSearchToAircraftDetails",
                    Constants.SuspectType.CONTAINER+":FromGenericSearchToSuspectContainerDetails",
                    Constants.SuspectType.INDIVIDUAL+":FromGenericSearchToIndividualDetails",
                    Constants.SuspectType.ORGANISATION+":FromGenericSearchToOrganisationDetails",
                    Constants.SuspectType.ORGANIZATION+":FromGenericSearchToOrganisationDetails",
                    Constants.SuspectType.VESSEL+":FromGenericSearchToVesselDetails",
                    Constants.SuspectType.VEHICLE+":FromGenericSearchToVehicleDetails",
                    Constants.SuspectType.OTHER+":FromGenericSearchToOtherDetails",
                    Constants.SuspectType.GOODS+":FromGenericSearchToGoods",
                    Constants.IntelSpotlight.SUSPICION+":FromGenericSearchToSuspicion",
                    Constants.IntelSpotlight.SEIZURE+":FromGenericSearchToSeizure",
                    Constants.IntelSpotlight.RUMMAGE+":FromGenericSearchToRummage",
                    Constants.IntelSpotlight.OFFENCE+":FromGenericSearchToOffence"};

        public static final  String[] TRANSPORT =  
        new String[]{"entityType",
                    Constants.TransportType.AIRCRAFT+":FromGenericSearchToTransportAircraft",
//                    Constants.TransportType.CONTAINER+":FromGenericSearchToTransportContainer",
                    Constants.TransportType.VESSEL+":FromGenericSearchToTransportVessel",
                    Constants.TransportType.TRAIN+":FromGenericSearchToTransportTrain",
                    Constants.TransportType.VEHICLE+":FromGenericSearchToTransportVehicle"};

        public static final  String[] TAX_ALLOCATION =  
        new String[]{"ALOC_TYPE",
                    Constants.TaxAllocationConfigType.COMMODITY+":FromGenericSearchToTaxAllocation",
                    Constants.TaxAllocationConfigType.PROCEDURE+":FromGenericSearchToTaxAllocation",
                    Constants.TaxAllocationConfigType.REGIME+":FromGenericSearchToTaxAllocation",
                    Constants.TaxAllocationConfigType.VALUE+":FromGenericSearchToTaxAllocation"};

        public static final  String[] EXEMPTION =  
        new String[]{"exemptionType",
                    Constants.ExemptionType.COMMODITY+":FromGenericSearchToCommodityDetails",
                    Constants.ExemptionType.TARIC+":FromGenericSearchToTaricDetails",
                    Constants.ExemptionType.TAXPAYER+":FromGenericSearchToTaxPayerDetails"
        };
        public static final  String[] FLEXIBLE_FORMS_MINI_SPOT_LIGHT =  
        new String[]{"formType",
                     "CIT Tax Return:replaceWithProperNavigationStringForRequiredPages", // TODO (VP) these test values and needs to be replaced with actual nav string
                     "SomeThing:replaceWithProperNavigationStringForRequiredPages"};
        
        public static final String[] RECEIPT = 
            new String[] {
                "receiptType",
                Constants.ReceiptType.TIN+":FromGenericSearchToReceiptDetails",
                Constants.ReceiptType.NAME+":FromGenericSearchToReceiptDetails",
                Constants.ReceiptType.RECEIPT_NO+":FromGenericSearchToReceiptDetails",
                Constants.ReceiptType.RECEIPT_DATE+":FromGenericSearchToReceiptDetails",
                Constants.ReceiptType.PAYMENT_INSTRUMENT+":FromGenericSearchToReceiptDetails",
                Constants.ReceiptType.INSTRUMENT_NUMBER+":FromGenericSearchToReceiptDetails",
                Constants.ReceiptType.BANK_NAME+":FromGenericSearchToReceiptDetails",
                Constants.ReceiptType.ACCOUNT_NUMBER+":FromGenericSearchToReceiptDetails",
                Constants.ReceiptType.PAYMENT_AMOUNT+":FromGenericSearchToReceiptDetails"
            };

    }
    
    public interface Navigation{
        public static final  String LOGOUT =  "logout";    
        public static final  String HOME =  "globalHome";
        public static final  String SELF =  "self";
        public static final  String AUTHORIZATION_ERROR =  "globalAuthorizationError";
        public static final  String CONFIGURATION_ERROR =  "globalConfigurationError";
        public static final  String SYSTEM_UNAVAILABLE =  "globalSystemUnavailable";
        public static final  String CONFIRMATION = "globalConfirmation";
        //public static final  Map SCREEN_TO_ACCOUNT_FOR_REGIME = ACCOUNT_NAVIGATION_BY_REGIME;
        public static final  Map SCREEN_TO_RELATED_DOCUMENTS = NAVIGATION_TO_RELATED_DOCUMENTS;
        public static final  String APPROVE_REACTIVATE_TASK = "ApproveReActivateRegimeTask";
        public static final  String REVISION_REACTIVATE_TASK = "RevisionReactivate";
        public static final  String FROM_TASK_TO_REACTIVATE = "ApproveReactivateTask";
        public static final  String APPROVE_DEREG_REGIME = "ApproveRegimeHumanTask";
        public static final  String APPROVE_DEREG_TAXPAYER = "ApproveHumanTask";

        public static final  String APPROVE_REREG_REGIME = "ApproveReRegRegime";
        public static final  String REVISE_REREG_REGIME = "Revision_RegimeRereg";
        
        
        public static final  String APPROVE_CRED_ALLOC = "CreditAllocationApprovalTask";
        public static final  String REVISE_CRED_ALLOC = "CreditAllocationRevision";
        public static final  String APPROVE_ACC_ADJ = "AccountAdjustmentApprovalTask";
        public static final  String REVISE_ACC_ADJ = "AccountAdjustmentRevision";
        public static final  String APPROVE_CASH_TILL_ALLOC = "CashTillAllocationApprovalTask";
        public static final  String APPROVE_TAX_RETURN = "TaxReturnApproval";
        public static final  String APPROVE_EXEMPTION_APP = "ExemptionApplicationApproval";
        public static final  String APPROVE_INSTAL_AGREEMENT = "InstallmentAgreementTask";
        public static final  String APPROVE_MANUAL_PENALTY = "ManualPenaltyApproval";
        public static final  String APPROVE_REFUNDS = "RefundsApprovalTask";
        public static final  String CASE_CLOSE = "CaseClose";
    }
    
    public interface ViewId{
       String INDEX_VIEW_ID = "/index.jspx";
       String WELCOME_VIEW_ID = "/login/Welcome.jspx";
       String CONFIGURATION_ERROR_VIEW_ID = "/login/ConfigurationError.jspx";
       String ADF_DIALOG_VIEW_ID = "/__ADFv__";
       String GENERIC_SEARCH_ID = "/core/GenericSearch.jspx";
       String LOG_OUT = "/login/LogOut.jspx";
       String AUTHORIZATION_ERROR="/login/AuthorizationError.jspx";
       
       String RUMMAGE_VIEW_ID = "/intelligence/Rummage.jspx";
       String SUSPICION_VIEW_ID = "/intelligence/Suspicion.jspx";
       String OFFENCE_VIEW_ID = "/intelligence/Offence.jspx";
       String SEIZURE_VIEW_ID = "/intelligence/Seizure.jspx";
    }
    
    public interface ManagedBean{
        String LOGIN_MANAGER = "security"; 
        String WORKLIST_MANAGER = "backingWorklistManager"; 
        String BACKING_SESSION_MANAGER = "backingSessionManager";
        String MANIFEST_DETAILS = "backingManifestDetails";
        String CONSIGNMENT_DETAILS = "backingConsignment";
        String GENERIC_SEARCH =  "backingGenericSearch";
        String FLEXIBLE_DB_TABLE="backingFlexibleDBTable";
        String BACKING_OFFICE_MAINTENANCE="backingOfficeMaintenance";
    }
    
    public interface Messages{
        String BPEL_CATCH_ALL="TRIPSCATCHALL";
        String BPEL_REMOTE_FAULT="TRIPSREMOTEFAULT";
        String FATAL_ERROR="Global.error.fatal";
        String INVALID_BPEL_REPLY="Global.bpel.invalidReply";
        String CONFIRMATION = "confirmation";
        String CONFIRMATION_MESSAGE = "tripsConfirmationMessages";
        String GENERIC_ERROR = "Global.msg.Error";
        String NO_RECORD_SELECTED = "Global.msg.NoRowSelected";
        String NO_RECORD_FOUND = "Global.msg.NoRecordsFound";
        String RECORD_SAVED = "Global.message.RecordSaved";
        String RECORD_REJECTED = "Global.message.RecordRejected";
        String RECORD_SUSPENDED = "Global.message.RecordSuspended";
        String RECORD_REACTIVATED = "Global.message.RecordReactivated";
        String RECORD_SAVED_WITH_ERROR = "Global.message.RecordSavedWithError";
    }
    
    public interface CallerMethods{
        String OPEN_REPORT_WINDOW="openReportWindow";
        String RUN_REPORT ="actionRunReport";    
    }
    
    public interface AuditAndVisitConstants {
        public static final String ASC = "Ascending";
        public static final String DESC = "Descending"; 
        public static final String NO_BUSINESS_SECTOR = "NO_BUSINESS_SECTOR";
        public static final String TIN = "Tin";
        public static final String NAME = "Name";    
        public static final String BUSINESSSECTOR = "BusinessSector";
        public static final String RISKBAND = "RiskBand";       
        public static final String BUSINESS_SECTOR = "Business Sector";
        public static final String RISK_BAND = "Risk Band";
        
        public static final String BUSINESSSECTOR_PARAMETER = "businessSector";
        public static final String NAME_PARAMETER ="name";
        public static final String TIN_PARAMETER = "tin";
        public static final String RISKBAND_PARAMETER = "riskBand";        
    }
    
    public interface ApplicationScopeVariables {
        String PAGE_ACCESS_LIST = "PageAccessList";
    }
}
