package com.technobrain.trips.common.constants;


public class BpelConstants {
    public BpelConstants() {
    }
    
    
    public interface WorkflowTypes {
        public static final String REG_IND = "REG_IND";
        public static final String REREG_TAXPAYER = "REREG_TP";
        public static final String REREG_REGIME = "REREG_REGIME";
        public static final String REG_ORG = "REG_ORG";
        public static final String GEN_PER = "GEN_PER";
        public static final String TAX_RETURNS = "TAX_RETURNS";
        public static final String CRED_ALLOC = "CRED_ALLOC";
        public static final String ACC_ADJUST = "ACC_ADJUST";
        public static final String EXEMPTION_APP = "EXEMPTION_APP";
        public static final String MANUAL_PENALTY = "MANUAL_PENALTY";
        public static final String CASE_MGMT = "CASE_MGMT";        
        public static final String DEBT_MANAGEMENT = "DEBT_MANAGEMENT";
        public static final String AUDIT_VISIT = "AUDIT_VISIT";
        public static final String OBJECTION_AND_APPEAL = "OBJECTION_AND_APPEAL";
        public static final String REGIMENF_ACCT = "REGIMENF_ACCT";
        public static final String TRANSFER_TAXPAYER = "ENT_TRNSFR";
        public static final String AMEND_ORG = "AMEND_ORG";
        
        public static final String REGIMENF_DEREG = "REGIMENF_DEREG";
        public static final String REGIME_SUSPEND = "REGIME_SUSPEND";
        
        public static final String DEREG_TAXPAYER = "DEREG_TP";
        public static final String REACTIVATE_REGIME = "REACTIVATE_REGIME";
    }
    
    public interface Actions {
        public static final String SAVE = "SAVE";
        public static final String ADJUST = "ADJUST";
        public static final String CANCEL = "CANCEL";
    }
    
    public interface DocStatuses {
        public static final String SAV = "SAV";
        public static final String SAVWE = "SAVWE";
    }
    
    public interface OperationTypes {
        public static final String CALCTAXES = "CALCTAXES";
        public static final String SAVEDECL = "SAVEDECL";
        public static final String SAVE_APP = "SAVE_APP";
        public static final String RISKANALYSIS = "RISKANALYSIS";
        public static final String APPROVE = "APPROVE";
        public static final String REJECT = "REJECT";
        public static final String VALIDATE_APP = "VALIDATE_APP";
        public static final String VALIDATEGUA = "VALIDATEGUA";
        public static final String SAVE_APP_WITH_ERRORS = "SAVE_APP_WITH_ERRORS";
        public static final String CREATE_APP_CASE = "CREATE_APP_CASE";
        public static final String AMENDDECL = "AMENDDECL";
        public static final String CHECKITEMS = "CHECKITEMS";
        public static final String GENAAR = "GENAAR";
        public static final String GENATR = "GENATR";
        public static final String GENMRN = "GENMRN";
        public static final String GOODSRELEASED = "GOODSRELEASED";
        public static final String GOODSSEIZED = "GOODSSEIZED";
        public static final String HUMAN = "HUMAN";
        public static final String INSPECT = "INSPECT";
        public static final String LOCGUA = "LOCGUA";
        public static final String PAYDECL = "PAYDECL";
        public static final String POSTLEDGER = "POSTLEDGER";
        public static final String RAISEOFFENCE = "RAISEOFFENCE";
        public static final String RELEASE = "RELEASE";
        public static final String RELGUA = "RELGUA";
        public static final String RUN_TAD_REPORT = "RUN_TAD_REPORT";
        public static final String UPLIFTSAD = "UPLIFTSAD";
        public static final String WITHDRAW = "WITHDRAW";
       
        
        
        // trips reg 
        public static final String VALIDATE_SUBMISSION = "VALIDATE_SUBMISSION";
        public static final String UNIQUE_ID_VALIDATION = "UNIQUE_ID_VALIDATION";
        public static final String CHECK_ENTITY_EXIST = "CHECK_ENTITY_EXIST";
        public static final String INTERVIEW_REQUIRED_DECISION = "INTERVIEW_REQUIRED_DECISION";
        public static final String CHECK_DUPLICATE = "CHECK_DUPLICATE";
        public static final String NOTIFY_ID_MATCH = "NOTIFY_ID_MATCH";
        public static final String NOTIFICATION_DUPLICATE_TAXPAYER = "NOTIFICATION_DUPLICATE_TAXPAYER";
        public static final String CREATE_INDIVIDUAL_ENTITY = "CREATE_INDIVIDUAL_ENTITY";
        public static final String REGISTER_TP_ACCOUNT_DECISION = "REGISTER_TP_ACCOUNT_DECISION";
        public static final String GENERATE_ID_DECISION = "GENERATE_ID_DECISION";
        public static final String GET_DECISION = "GET_DECISION";
        public static final String GENERATE_TIN = "GENERATE_TIN";
        public static final String REGISTER_TAXPAYER_ACCOUNT = "REGISTER_TAXPAYER_ACCOUNT";
        public static final String FORMAT_TIN = "FORMAT_TIN";
        public static final String GENERATE_REPORT_DECISION = "GENERATE_REPORT_DECISION";
        public static final String GENERATE_TAXPAYER_CERTIFICATE = "GENERATE_TAXPAYER_CERTIFICATE";
        public static final String GENERATE_PERIODS = "GENERATE_PERIODS";
        public static final String REGISTRATION_COMPLIANCE_DECISION = "REGISTRATION_COMPLIANCE_DECISION";
        public static final String PERFORM_REGISTRATION_COMPLIANCE = "PERFORM_REGISTRATION_COMPLIANCE";
        public static final String IMPLICIT_REGIME_REGISTRATION_DECISION = "IMPLICIT_REGIME_REGISTRATION_DECISION";
        public static final String GET_IMPLICIT_REGIMES = "GET_IMPLICIT_REGIMES";
        public static final String REGISTER_REGIME_ACCOUNT = "REGISTER_REGIME_ACCOUNT";
        public static final String POST_INDIVIDUAL_REG_FEE = "POST_INDIVIDUAL_REG_FEE";
        public static final String CHECK_TAXPAYER_ACCOUNT_DUPLICATE = "CHECK_TAXPAYER_ACCOUNT_DUPLICATE";
        public static final String UPDATE_DUPLICATE_ENTITY = "UPDATE_DUPLICATE_ENTITY";
        public static final String UPDATE_ENTITY = "UPDATE_ENTITY";
        public static final String UPDATE_ENTITY_STATUS = "UPDATE_ENTITY_STATUS";
        public static final String UPDATE_DOCUMENT_STATUS = "UPDATE_DOCUMENT_STATUS"; 
        public static final String GENERATE_REJECT_LETTER = "GENERATE_REJECT_LETTER";
        public static final String REMOVE_PENDING_RECORD = "REMOVE_PENDING_RECORD";
        public static final String GENERATE_REGIME_ID = "GENERATE_REGIME_ID"; 
        public static final String SAVE_PENDING_REGIME_ACCOUNT = "SAVE_PENDING_REGIME_ACCOUNT"; 
        public static final String NOTIFY_OFFICER_PENDING_REGIME = "NOTIFY_OFFICER_PENDING_REGIME";
        public static final String GENERATE_REGIME_CERTIFICATE = "GENERATE_REGIME_CERTIFICATE";   
        public static final String ADVISORY_INTERVIEW_DECISION = "ADVISORY_INTERVIEW_DECISION"; 
        public static final String SAVE_APPROVE_REGIME_ACCOUNT = "SAVE_APPROVE_REGIME_ACCOUNT";
        public static final String SAVE_PENDING_REVISION = "SAVE_PENDING_REVISION";
        public static final String NOTIFY_PENDING_REVISION = "NOTIFY_PENDING_REVISION";
        public static final String NOTIFY_OFFICER_ACCEPT_REGIME = "NOTIFY_OFFICER_ACCEPT_REGIME";
        public static final String PEND = "PEND";
        public static final String REG = "REG";
        public static final String REV = "REV";
        public static final String IDENTITY_CHECK_DECISION = "IDENTITY_CHECK_DECISION";
        public static final String CREATE_DOCUMENT = "CREATE_DOCUMENT";
        public static final String UPDATE_DOCUMENT = "UPDATE_DOCUMENT";
        public static final String UPDATE_DOCUMENT_AFTER_APPROVAL = "UPDATE_DOCUMENT_AFTER_APPROVAL";
        public static final String UPDATE_REGIME_DATA = "UPDATE_REGIME_DATA";
        public static final String AUTO_APPROVAL_DECISION = "AUTO_APPROVAL_DECISION";
        public static final String NOTIFY_FOR_APPROVAL = "NOTIFY_FOR_APPROVAL";
        public static final String NOTIFY_FOR_REVISION = "NOTIFY_FOR_REVISION";
        public static final String UPDATE_DATA_GCMS = "UPDATE_DATA_GCMS";
        public static final String UPDATE_RGD_DECISION = "UPDATE_RGD_DECISION";
        public static final String UPDATE_RGD_DATA = "UPDATE_RGD_DATA";
        public static final String ERROR_RGD_INSTRUCTIONS = "ERROR_RGD_INSTRUCTIONS";
        public static final String RESOLUTION_OF_RGD_REG = "RESOLUTION_OF_RGD_REG";
        public static final String REVISION_ENTRY_DECISION = "REVISION_ENTRY_DECISION";
        public static final String CHECK_DUPLICATE_DECISION = "CHECK_DUPLICATE_DECISION";
        public static final String MISCELLANEOUS_ENTITY_CHECK_DECISION = "MISCELLANEOUS_ENTITY_CHECK_DECISION";
        public static final String MISCELLANEOUS_ENTITY_VERIFICATION = "MISCELLANEOUS_ENTITY_VERIFICATION";
        public static final String REVISION_NOTIFICATION = "REVISION_NOTIFICATION";
        public static final String UPDATE_ENTITY_STATUS_DUPLICATE = "UPDATE_ENTITY_STATUS_DUPLICATE";
        public static final String UPDATE_ENTITY_STATUS_REJECT = "UPDATE_ENTITY_STATUS_REJECT";
        public static final String UPDATE_ENTITY_STATUS_POSSIBLE_DUPLICATE = "UPDATE_ENTITY_STATUS_POSSIBLE_DUPLICATE";
        public static final String UPDATE_ENTITY_STATUS_ACTIVE = "UPDATE_ENTITY_STATUS_ACTIVE";
        public static final String UPDATE_DOCUMENT_STATUS_PENDING_APPROVAL = "UPDATE_DOCUMENT_STATUS_PENDING_APPROVAL";
        public static final String UPDATE_DOCUMENT_STATUS_PENDING_CANCELLATION = "UPDATE_DOCUMENT_STATUS_PENDING_CANCELLATION";
        public static final String UPDATE_DOCUMENT_STATUS_REJECT = "UPDATE_DOCUMENT_STATUS_REJECT";
        public static final String UPDATE_DOCUMENT_STATUS_PENDING_REVISION = "UPDATE_DOCUMENT_STATUS_PENDING_REVISION";
        public static final String UPDATE_DOCUMENT_STATUS_APPROVED = "UPDATE_DOCUMENT_STATUS_APPROVED";
        public static final String UPDATE_DOCUMENT_DUPLICATE_REJECT = "UPDATE_DOCUMENT_DUPLICATE_REJECT"; 
        public static final String UPDATE_DOCUMENT_STATUS_SUBMITTED = "UPDATE_DOCUMENT_STATUS_SUBMITTED";
        public static final String UPDATE_ENTITY_STATUS_NULL = "UPDATE_ENTITY_STATUS_NULL";
        public static final String UPDATE_ENTITY_STATUS_PENDING_REVISION = "UPDATE_ENTITY_STATUS_PENDING_REVISION";
        public static final String TERMINATE_PROCESS = "TERMINATE_PROCESS";
        public static final String SETUP_DOCUMENT = "SETUP_DOCUMENT";
        public static final String NOTIFY_OFFICER = "NOTIFY_OFFICER";
        public static final String UPDATE_DOC_PENDREVI = "UPDATE_DOC_PENDREVI";
        public static final String CREATE_REVI_HUM_TASK = "CREATE_REVI_HUM_TASK";
        public static final String UPDATE_TP_ACCOUNT = "UPDATE_TP_ACCOUNT";
        public static final String UPDATE_DOC_APPR = "UPDATE_DOC_APPR";
        public static final String REREG_REGIMES = "REREG_REGIMES";
        public static final String PROCESS_RETURN_TYPES = "PROCESS_RETURN_TYPES";
        public static final String GENERATE_CERT_DECISION = "GENERATE_CERT_DECISION";
        public static final String UPDATE_DOC_REJECT = "UPDATE_DOC_REJECT";
        public static final String GENERATE_REJECTION_LETTER = "GENERATE_REJECTION_LETTER";
        public static final String MISCELLANEOUS_ENTITY_DOCUMENT_REJECT = "MISCELLANEOUS_ENTITY_DOCUMENT_REJECT";
        public static final String GENERATE_CERTIFICATE = "GENERATE_CERTIFICATE";
        public static final String COMMIT = "COMMIT";
        public static final String UPDATE_PERIOD_STATUS_FILED = "UPDATE_PERIOD_STATUS_FILED";
        public static final String GET_REJECT_REPORT_DECISION = "GET_REJECT_REPORT_DECISION";
        public static final String REGIME_CERTIFICATE_DECISION="REGIME_CERTIFICATE_DECISION";
        public static final String UPDATE_REGISTRATION_STATUS_SUSPEND="UPDATE_REGISTRATION_STATUS_SUSPEND";
        
        
        public static final String GENERATE_PERIOD_DECISION="GENERATE_PERIOD_DECISION";
        public static final String ID_VERIFICATION_ENTITY_REJECT = "ID_VERIFICATION_ENTITY_REJECT";
        public static final String ID_VERIFICATION_DOCUMENT_REJECT = "ID_VERIFICATION_DOCUMENT_REJECT";
        public static final String MISCELLANEOUS_ENTITY_REJECT = "MISCELLANEOUS_ENTITY_REJECT";
        public static final String GENERATE_REJECT_REPORT_DECISION = "GENERATE_REJECT_REPORT_DECISION";
        public static final String UPDATE_DOCUMENT_ACC_DETAILS = "UPDATE_DOCUMENT_ACC_DETAILS";
        
        public static final String UPDATE_REGIME_ACCOUNT = "UPDATE_REGIME_ACCOUNT";
        public static final String GENERATE_REGISTRATION_AMENDMENT_NOTIFICATION = "GENERATE_REGISTRATION_AMENDMENT_NOTIFICATION";
        public static final String GENERATE_TAXTYPE_CERTIFICATE_DECISION = "GENERATE_TAXTYPE_CERTIFICATE_DECISION";
        public static final String GENERATE_TAXTYPE_CERTIFICATE = "GENERATE_TAXTYPE_CERTIFICATE";
        
        public static final String DEREG_TAXPAYER_DECISION = "DEREG_TAXPAYER_DECISION";
        public static final String DEREGISTER_TAXPAYER_ACCOUNT = "DEREGISTER_TAXPAYER_ACCOUNT";
        public static final String FIND_LAST_DOC_INFO_FOR_DOC_ROLE = "FIND_LAST_DOC_INFO_FOR_DOC_ROLE";
        public static final String UPDATE_DOCUMENT_ROLE = "UPDATE_DOCUMENT_ROLE";
        public static final String PENAPPR = "PENAPPR";

        
        
        
        
        //registration
        public static final String UPDATE_REGISTRATION_STATUS_PENDING_DEREG = "UPDATE_REGISTRATION_STATUS_PENDING_DEREG";
        public static final String NOTIFY_OFFICER_FOR_APPROVAL = "NOTIFY_OFFICER_FOR_APPROVAL";
        public static final String NOTIFY_OFFICER_FOR_REVISION = "NOTIFY_OFFICER_FOR_REVISION";
        public static final String UPDATE_REGISTRATION_STATUS_REG = "UPDATE_REGISTRATION_STATUS_REG";
        public static final String UPDATE_REGISTRATION_STATUS_DEREG = "UPDATE_REGISTRATION_STATUS_DEREG";
        public static final String INACTIVATE_PERIODS = "INACTIVATE_PERIODS";
        
        
        
        
        
        
        //Case Management
         public static final String VALIDATE_CASE = "VALIDATE_CASE";
        public static final String UPDATE_CASE = "UPDATE_CASE";         
        public static final String UPDATE_CASE_STATUS_NEW = "UPDATE_CASE_STATUS_NEW"; 
        public static final String UPDATE_CASE_STATUS_PENDING_OPEN = "UPDATE_CASE_STATUS_PENDING_OPEN";   
        public static final String UPDATE_CASE_STATUS_OPEN = "UPDATE_CASE_STATUS_OPEN";
        public static final String NOTIFY_OFFICER_UPDATE_DECISION = "NOTIFY_OFFICER_UPDATE_DECISION";
        public static final String NOTIFY_OFFICER_CLOSE = "NOTIFY_OFFICER_CLOSE";
        public static final String UPDATE_CASE_STATUS_PENDING_CLOSE = "UPDATE_CASE_STATUS_PENDING_CLOSE";
        public static final String UPDATE_CASE_STATUS_CLOSE = "UPDATE_CASE_STATUS_CLOSE"; 
        public static final String UPDATE_CASE_STATUS_INPROGRESS = "UPDATE_CASE_STATUS_INPROGRESS"; 
        public static final String UPDATE_CASE_STATUS_ONHOLD = "UPDATE_CASE_STATUS_ONHOLD"; 
        
        //Debt Management
         public static final String UPDATE_DEBT_CASE = "UPDATE_DEBT_CASE";   
         
        //Audit and Visit
        public static final String UPDATE_AUDIT_CASE = "UPDATE_AUDIT_CASE"; 
        public static final String DETECT_TAXPAYER_NOTICE = "DETECT_TAXPAYER_NOTICE"; 
        public static final String GENERATE_AUDIT_NOTIFICATION = "GENERATE_AUDIT_NOTIFICATION"; 
        public static final String POST_TO_ACCOUNTS = "POST_TO_ACCOUNTS"; 
        public static final String GROUP_CHANGE_CHECK = "GROUP_CHANGE_CHECK";
        
        //Objection and Appeal
        public static final String GENERATE_OBJ_LODGEMENT_NOTICE  = "GENERATE_OBJ_LODGEMENT_NOTICE"; 
        public static final String GENERATE_OBJ_ACCEPT_NOTICE  = "GENERATE_OBJ_ACCEPT_NOTICE"; 
        public static final String UPDATE_OBA_CASE  = "UPDATE_OBA_CASE";
        public static final String CREATE_OBA_CASE  = "CREATE_OBA_CASE";
        public static final String UPDATE_CASE_STATUS_LODGED  = "UPDATE_CASE_STATUS_LODGED";        
        public static final String GENERATE_OBJ_REJECT_NOTICE  = "GENERATE_OBJ_REJECT_NOTICE";
        public static final String GENERATE_OBJ_FINALISED_NOTICE  = "GENERATE_OBJ_FINALISED_NOTICE";
        
        public static final String UPDATE_CASE_STATUS_APPEAL_LODGED  = "UPDATE_CASE_STATUS_APPEAL_LODGED";
        public static final String GENERATE_APPEAL_LODGEMENT_NOTICE  = "GENERATE_APPEAL_LODGEMENT_NOTICE";
        public static final String GENERATE_APPEAL_REJECTION_NOTICE  = "GENERATE_APPEAL_REJECTION_NOTICE";
        public static final String GENERATE_APPEAL_FINALISED_NOTICE  = "GENERATE_APPEAL_FINALISED_NOTICE";        
        
        //returns
        public static final String GET_PAGE_MODE = "GET_PAGE_MODE";
        public static final String CREATE_RETURN = "CREATE_RETURN";
        public static final String VALIDATE_RETURN = "VALIDATE_RETURN";
        public static final String GET_SUBMISSION_MODE = "GET_SUBMISSION_MODE";
        public static final String GET_PAGE_ACTION = "GET_PAGE_ACTION";
        public static final String CREATE_RETURN_WITH_ERROR = "CREATE_RETURN_WITH_ERROR";
        public static final String UPDATE_DOCUMENT_STATUS_FILED_WITH_ERROR = "UPDATE_DOCUMENT_STATUS_FILED_WITH_ERROR";
        public static final String UPDATE_DOCUMENT_STATUS_ADJUSTED_WITH_ERROR = "UPDATE_DOCUMENT_STATUS_ADJUSTED_WITH_ERROR";
        public static final String LOG_ERROR = "LOG_ERROR";
        public static final String CREATE_CASE = "CREATE_CASE";
        public static final String CREATE_TASK = "CREATE_TASK";
        public static final String CHECK_LIABILITY ="CHECK_LIABILITY";
        public static final String PERFORM_COMPLIANCE_DECISION = "PERFORM_COMPLIANCE_DECISION";
        public static final String PERFORM_COMPLIANCE_DECISION_NO_POSTING = "PERFORM_COMPLIANCE_DECISION_NO_POSTING";
        public static final String PERFORM_COMPLIANCE = "PERFORM_COMPLIANCE";
        public static final String PERFORM_COMPLIANCE_NO_POSTING = "PERFORM_COMPLIANCE_NO_POSTING";
        public static final String DOCUMENT_TRANSACTION_NO_POSTING = "DOCUMENT_TRANSACTION_NO_POSTING";
        public static final String PERFORM_RISK_ANALYSIS = "PERFORM_RISK_ANALYSIS";
        public static final String NOTIFY_OFFICER_DECISION = "NOTIFY_OFFICER_DECISION";
        
        //accounting
        public static final String POST_TO_ACCOUNT = "POST_TO_ACCOUNT";
        public static final String UPDATE_DOC_POSTED = "UPDATE_DOC_POSTED";
        public static final String REVRSE_LODGEMENT = "REVERSE_LODGEMENT";
        public static final String RECALCULATE_PENALTY = "RECALCULATE_PENALTY";
        
        //lodgement
        
        public static final String CALCULATEANDCREATE_DOC_CHARGES = "CALCULATEANDCREATE_DOC_CHARGES";
        public static final String CREATE_DOCUMENTEVENT = "CREATE_DOCUMENTEVENT";
        public static final String CREATE_DOCUMENT_CHARGES = "CREATE_DOCUMENT_CHARGES";
        public static final String SAVE_LODGEMENT = "SAVE_LODGEMENT";
        public static final String UPDATE_DOCUMENT_LODGED = "UPDATE_DOCUMENT_LODGED";
        public static final String VALIDATE_DOCUMENT = "VALIDATE_DOCUMENT";
        public static final String GENERATE_LODGEMENT_NOTICE = "GENERATE_LODGEMENT_NOTICE";
        public static final String GET_FLEXIBLE_FORM_INPUT_TYPE = "GET_FLEXIBLE_FORM_INPUT_TYPE";
        public static final String CAL_TAX_AND_CHARGES = "CAL_TAX_AND_CHARGES";
        
        public static final String VALIDATE_EXEMPTION = "VALIDATE_EXEMPTION";
        public static final String CREATE_EXEMPTION_APPLICATION = "CREATE_EXEMPTION_APPLICATION";
        public static final String GENERATE_EXEMPTION_NOTIFICATION = "GENERATE_EXEMPTION_NOTIFICATION";
        
        public static final String GENERATE_FILE_NOTIFICATION = "GENERATE_FILE_NOTIFICATION";
        public static final String RETURN_ADJUSTMENT_NOTIFICATION = "RETURN_ADJUSTMENT_NOTIFICATION";
        public static final String GENERATE_EXEMPTION_CANCEL_NOTIFICATION="GENERATE_EXEMPTION_CANCEL_NOTIFICATION";
        public static final String GENERATE_EXEM_LOD_NOTIFICATION = "GENERATE_EXEM_LOD_NOTIFICATION";
        public static final String GENERATE_EXEM_APP_NOTIFICATION = "GENERATE_EXEM_APP_NOTIFICATION";
        public static final String GENERATE_EXEM_REJ_NOTIFICATION = "GENERATE_EXEM_REJ_NOTIFICATION";
        public static final String UPDATE_DOCUMENT_STATUS_CANCELLED = "UPDATE_DOCUMENT_STATUS_CANCELLED";
        public static final String CREATE_DOCUMENT_EVENT_APPROVED = "CREATE_DOCUMENT_EVENT_APPROVED";
        public static final String CREATE_DOCUMENT_EVENT_REJECT = "CREATE_DOCUMENT_EVENT_REJECT";
        public static final String CREATE_DOCUMENT_EVENT_CANCELLED = "CREATE_DOCUMENT_EVENT_CANCELLED";
        public static final String UPDATE_DOC_NOT_POSTED = "UPDATE_DOC_NOT_POSTED";
        
        //transfer taxpayer
        public static final String APPROVE_TRANSFER_TAXPAYER = "APPROVE_TRANSFER_TAXPAYER";
        public static final String APPROVE_TRANSFER_TRIPSGUI = "APPROVE_TRANSFER_TRIPSGUI";
        public static final String UPDATE_DOCUMENT_APPROVE = "UPDATE_DOCUMENT_APPROVE";
        public static final String GENERATE_TRANSFER_REPORT_DECISION = "GENERATE_TRANSFER_REPORT_DECISION";
        public static final String GENERATE_TRANSFER_REPORT = "GENERATE_TRANSFER_REPORT";
        public static final String UPDATE_DOCUMENT_REJECT = "UPDATE_DOCUMENT_REJECT";
        public static final String TRANSFER_REJ_REPORT_DECISION = "TRANSFER_REJ_REPORT_DECISION";
        public static final String  GENERATE_TRANSFER_REJ_REPORT = "GENERATE_TRANSFER_REJ_REPORT";
        public static final String UPDATE_DOCUMENT_REVISION = "UPDATE_DOCUMENT_REVISION";
        public static final String DEO_TRANSFER_CHANGE_REVISION = "DEO_TRANSFER_CHANGE_REVISION";
        public static final String REACTIVATE_REGIME_ACCOUNT = "REACTIVATE_REGIME_ACCOUNT";
        
        
    }
    
    
    public interface Outcomes {
        public static final String FAIL = "FAIL";
        public static final String PASS = "PASS";
        public static final String ADJUST = "ADJUST";
        public static final String SUCCESS = "SUCCESS";
        public static final String YES = "YES";
        public static final String NO = "NO";
        public static final String EXCEPTION = "EXCEPTION";
        public static final String REJECT = "REJECT";
        public static final String RGD = "RGD";
        public static final String POSTING_REQUIRED = "POSTING_REQUIRED";
        public static final String POSTING_NOT_REQUIRED = "POSTING_NOT_REQUIRED";
        public static final String RECALCULATE_PENALTY = "RECALCULATE_PENALTY";
        public static final String INPROGRESS = "INPROGRESS";
        public static final String ONHOLD = "ONHOLD";
        public static final String CLOSE = "CLOSE";
        public static final String GRPCHG = "GRPCHG";    
        public static final String NOGRPCHG = "NOGRPCHG";  

        public static final String AWAITING_REVIEW = "AWAITING_REVIEW";          
        public static final String OBJECTION_REJECTED = "OBJECTION_REJECTED";
        public static final String AWAITING_FINALISATION = "AWAITING_FINALISATION";
        public static final String OBJECTION_FINALISED = "OBJECTION_FINALISED";
        public static final String APPEAL_LODGED = "APPEAL_LODGED";
        public static final String APPEAL_AWAITING_FINALISATION = "APPEAL_AWAITING_FINALISATION";
        public static final String APPEAL_FINALISED = "APPEAL_FINALISED";
        public static final String APPEAL_REJECTED = "APPEAL_REJECTED";
        
    }
    
    
    
    public interface EventTypes {
        public static final String CALCTAXES = OperationTypes.CALCTAXES;
        public static final String SAVEDECL = OperationTypes.SAVEDECL;
        public static final String SAVE_APP = OperationTypes.SAVE_APP;
        public static final String RISKANALYSIS = OperationTypes.RISKANALYSIS;
        public static final String APPROVE = OperationTypes.APPROVE;
        public static final String REJECT = OperationTypes.REJECT;
        public static final String VALIDATE_APP = OperationTypes.VALIDATE_APP;
        public static final String VALIDATEGUA = OperationTypes.VALIDATEGUA;
        public static final String SAVE_APP_WITH_ERRORS = OperationTypes.SAVE_APP_WITH_ERRORS;
        public static final String CREATE_APP_CASE = OperationTypes.CREATE_APP_CASE;
        public static final String AMENDDECL = OperationTypes.AMENDDECL;
        public static final String CHECKITEMS = OperationTypes.CHECKITEMS;
        public static final String GENAAR = OperationTypes.GENAAR;
        public static final String GENATR = OperationTypes.GENATR;
        public static final String GENMRN = OperationTypes.GENMRN;
        public static final String GOODSRELEASED = OperationTypes.GOODSRELEASED;
        public static final String GOODSSEIZED = OperationTypes.GOODSSEIZED;
        public static final String HUMAN = OperationTypes.HUMAN;
        public static final String INSPECT = OperationTypes.INSPECT;
        public static final String LOCGUA = OperationTypes.LOCGUA;
        public static final String PAYDECL = OperationTypes.PAYDECL;
        public static final String POSTLEDGER = OperationTypes.POSTLEDGER;
        public static final String RAISEOFFENCE = OperationTypes.RAISEOFFENCE;
        public static final String RELEASE = OperationTypes.RELEASE;
        public static final String RELGUA = OperationTypes.RELGUA;
        public static final String RUN_TAD_REPORT = OperationTypes.RUN_TAD_REPORT;
        public static final String UPLIFTSAD = OperationTypes.UPLIFTSAD;
        public static final String WITHDRAW = OperationTypes.WITHDRAW;
    }
    
    
    public interface DocumentTypes {
        public static final String APPLICATION = "APPLICATION";
//        public static final String CDEBTNOTICE = "CDEBTNOTICE";
        public static final String DECLARE = "DECLARE";
//        public static final String ACCADJUSTMENT = "ACCADJUSTMENT";
//        public static final String DFINBADCHEQUE = "DFINBADCHEQUE";
//        public static final String REFUNDCLAIM = "REFUNDCLAIM";
//        public static final String REVCOLLINST = "REVCOLLINST";
//        public static final String REVENUECOLLECTIONRECEIPT = "REVENUECOLLECTIONRECEIPT";
//        public static final String TRANSFERPAYMENT = "TRANSFERPAYMENT";
//        public static final String REG = "REG";
//        public static final String GUARANTEE = "GUARANTEE";
//        public static final String CARGOMANIFEST = "CARGOMANIFEST";
//        public static final String PERIODIC = "PERIODIC";
//        public static final String DECRELEASE = "DEC-RELEASE";
        public static final String REGISTRATION = "REGISTRATION";
        public static final String RETURNS = "RETURNS";
        public static final String ACCOUNTING = "ACCOUNTING";
        public static final String EXEMPTIONS = "EXEMPTIONS";
        public static final String ENFORCEMENT = "ENFORCEMENT";
        public static final String CASEMANAGEMENT = "CASEMANAGEMENT";   
        public static final String TRANSFERTAXPAYER = "TRANSFERTAXPAYER"; 
    }
    
    
     public interface EventCategoryTypes {
         public static final String APPLICATION = DocumentTypes.APPLICATION;
//        public static final String CDEBTNOTICE = DocumentTypes.CDEBTNOTICE;
         public static final String DECLARE = DocumentTypes.DECLARE;
//        public static final String ACCADJUSTMENT = DocumentTypes.ACCADJUSTMENT;
//        public static final String DFINBADCHEQUE = DocumentTypes.DFINBADCHEQUE;
//        public static final String REFUNDCLAIM = DocumentTypes.REFUNDCLAIM;
//        public static final String REVCOLLINST = DocumentTypes.REVCOLLINST;
//        public static final String REVENUECOLLECTIONRECEIPT = DocumentTypes.REVENUECOLLECTIONRECEIPT;
//        public static final String TRANSFERPAYMENT = DocumentTypes.TRANSFERPAYMENT;
//        public static final String REG = DocumentTypes.REG;
//        public static final String GUARANTEE = DocumentTypes.GUARANTEE;
//        public static final String CARGOMANIFEST = DocumentTypes.CARGOMANIFEST;
//        public static final String PERIODIC = DocumentTypes.PERIODIC;
//        public static final String DECRELEASE = DocumentTypes.DEC-RELEASE;
        public static final String REGISTRATION = DocumentTypes.REGISTRATION;
        public static final String RETURNS = DocumentTypes.RETURNS;        
        public static final String ACCOUNTING = DocumentTypes.ACCOUNTING;
        public static final String EXEMPTIONS = DocumentTypes.EXEMPTIONS;
        public static final String ENFORCEMENT = DocumentTypes.ENFORCEMENT;
        public static final String CASEMANAGEMENT = DocumentTypes.CASEMANAGEMENT; 
        public static final String TRANSFERTAXPAYER = DocumentTypes.TRANSFERTAXPAYER; 
     }
     
     
    public interface NextActions {
        public static final String END = "END";
        
    }
    
    
    
    public interface InputTypes {
        public static final String INDIVIDUAL = "IndividualTaxpayerInputType";
        public static final String REREGTAXPAYER = "ReregisterAccountInputType";
        public static final String ORGANISATION = "OrganisationTaxpayerInputType";
        public static final String REGIMEACC = "RegimeAccountType"; 
        public static final String SUSPENSION = "SuspensionInputType";
        public static final String REREGREGIME = "ReregisterRegimeInputType";
        public static final String DEREGREGIME = "DeregisterRegimeInputType";
        public static final String DEREGTAXPAYER = "DeRegisterAccountInputType";
        public static final String TRANSFER = "TransferTaxpayerInputType";
        public static final String REACTIVATEREGIME = "ReactivateRegimeInputType";
        public static final String TAXRETURNFLEXIBLEFORM = "TaxReturnFlexibleFormInputType";
        public static final String CRED_ALLOC = "DfinCreditAllocationInputType";
        public static final String ACC_ADJ_TYPE = "AccountAdjustmentInputType";
        public static final String RETURNSLODGEMENT = "ReturnsLodgementInputType";
        public static final String UPDATE_ORGANISATION = "UpdateOrganisationInputType";
        public static final String REACTIVATE_REGIME = "ReactivateRegime";
        

        public static final String TAXRETURNFLEXIBLEFORMFORADJUST = "TaxReturnFlexibleFormInputTypeForAdjust";
        

        public static final String RETURNSPAYE = "ReturnsPAYEInputType";
        public static final String EXEMPTIONAPPLICATION = "ExemptionInputType";
        public static final String PENALTY_INPUT_TYPE = "PenaltyInputType";
        public static final String CASEMANAGEMENT = "CaseInputType";
        public static final String DEBTMANAGEMENT = "DebtCaseInputType";
        public static final String AMEND_INDIVIDUAL = "AMEND_INDIVIDUAL";
        

    }
    
    public interface ExtraInfo {
    
        public static final String DUPLICATE_LIST = "DUPLICATE_LIST";
        public static final String DUPLICATE_ACC_LIST = "DUPLICATE_ACC_LIST";
        public static final String GENERATE_ID_DECISION = "GenerateIDDecision";
        public static final String YES = "Y";
        public static final String NO = "N";
        public static final String DEFAULT = "D";
        public static final String ENTITY_ACCOUNT = "ENTITY_ACCOUNT";
        public static final String GENERATE_REPORT_DECISION = "GenerateReportDecision";
        public static final String GENERATE_COMPLIANCE_DECISION = "TPRegistrationComplianceDecision";
        public static final String GENERATE_IMPLICIT_REGIME_REGISTRATION_DECISION = "ImplicitRegimeRegistrationDecision";
        public static final String LIST_OF_REGIMES = "LIST_OF_REGIMES";
        public static final String CREATE_ENTITY = "CREATE_ENTITY";
        public static final String FORMATTED_TIN = "FORMATTED_TIN";
        public static final String CORRECT_SUFFIX = "CORRECT_SUFFIX";
        public static final String DUPLICATE_CHECK_DECISION_FOR_BRACH = "DuplicateCheckDecisionForBranch";
        public static final String DUPLICATE_CHECK_DECISION_FOR_HEAD_OFFICE = "DuplicateCheckDecisionForHeadOffice";
        public static final String DUPLICATE_CHECK_DECISION = "DuplicateCheckDecision";
        public static final String ACCOUNT_NUMBER = "AccountNumber";
        public static final String ADVISORY_VISIT_REQUIRED = "AdvisoryVisitRequired";
        public static final String INTERVIEW_VISIT_REQUIRED = "InterviewVisitRequiredDecision";
        public static final String IDENTITY_CHECK_DECISION = "IdentityCheckDecision";
        public static final String AUTO_APPROVAL_DECISION = "AutoApprovalDecision";
        public static final String ERROR_RGD_INSTRUCTIONS = "ErrorInRGDInstructions";
        public static final String REVISION_ENTRY_DECISION = "revisionEntryDecision";
        public static final String MISCELLANEOUS_ENTITY_CHECK_DECISION = "miscellaneousEntityDecision";
        public static final String REVISON_ENTRY = "REVISONENTRY";
        public static final String GENERATE_CERTIFICATE_DECISION = "GenerateCertificateDecision";
        public static final String GENERATE_REJECTLETTER_DECISION = "GenerateRejectionLetterDecision";
        public static final String GENERATE_PERIOD_DECISION = "GeneratePeriodDecision";
        public static final String NOTIFY_OFFICER_DECISION = "NotifyOfficerDecision";
        public static final String TAXPAYER_TIN = "taxpayerTin";
        
    }
    
    public interface Constants {
    
        public static final String GENERATE_REJECT_LETTER = "GENERATE_REJECT_LETTER";
    }
    
    public interface RegimeCode{
        public static final String TAXPAYER = "TAXPAYER";
        public static final String ALL = "ALL";
    }
    
    
    public interface ProcessName{
        public static final String REGINDIVIDUAL = "TripsRegIndividual";
        public static final String REREGTAXPAYER = "TripsReRegTaxpayer";
        public static final String REREGREGIME = "TripsReRegRegime";
        public static final String REGORG = "TripsRegOrg";
        public static final String REGIMEACCT = "TripsRegisterRegimeAcct";
        public static final String REGIMEDEREG = "TripsDeregisterRegime";
        public static final String REGIMESUSPEND = "TripsSuspendRegime";
        public static final String RETURNS = "TripsReturnsProcessingNF";
        public static final String  RETURNS_LODGEMENT= "TripsLodgementProcessingNF";
        public static final String CRED_ALLOC = "TripsCreditAllocation";
        public static final String ACCOUNTING_ADJUSTMENT = "TripsAccountAdjustment";
        public static final String RETURNS_PAYE = "TripsReturnsPAYEProcessingNF";
        public static final String EXEMPTION_APP = "TripsExemptionAppProcessingNF";
        public static final String MANUAL_PENALTY = "TripsManualPenalty";
        public static final String CASE_MANAGEMENT = "TripsCreateMaintainCaseNF";
        public static final String TRANSFER_TAXPAYER = "TripsTransferTaxpayerAndRelatedEntities";
        public static final String TRANSFER_TAXPAYER_NF ="TripsTransferTaxpayerAndRelatedEntitiesNF";
        public static final String AMENDORG = "TripsUpdateOrganization";
        public static final String DEREGTAXPAYER = "TripsDeregisterTaxpayer";
        public static final String REACTIVATE_REGIME_NF ="TripsReactivateRegimeNF";
    }

    public interface Status {
        public static final String ACTIVE = "REG";
        public static final String PEND_REVISION = "PENDREV";
        public static final String REJECT = "REJ";
        public static final String PEND_APPROVE = "PENDAPPR";
        public static final String DUPLICATE = "DUPLICATE";
        public static final String POSSIBLE_DUP = "POSSDUP";
        public static final String REVISION = "REVISION";
        public static final String APPROVE = "APPROVE";
        public static final String APPR = "APPR";
        public static final String POSTED = "POSTED";
        public static final String AUTHORISED = "AUTH";
        public static final String FILED = "FILED";
        public static final String SUBMITTED = "SUBMITTED";
        public static final String ERROR= "ERROR";
        public static final String LODGED= "LODGED";
        public static final String SAVE_WITH_ERROR= "SAVWE";
        public static final String ADJUSTMENT= "ADJUSTMENT";
        public static final String CREATED= "Created";
        public static final String APP_ACTIVE = "Active";
        public static final String CANCELLED = "Cancelled";
        public static final String CAN = "CAN";
        public static final String REA = "REA";
        public static final String SWES = "SWES";
        public static final String SWEP = "SWEP";
        public static final String SER = "SER";
        public static final String NEW = "NEW";
        public static final String PEND_OPEN = "PENDOPEN";
        public static final String OPEN = "OPEN"; 
        public static final String INPROGRESS = "INPROGRESS"; 
        public static final String PEND_CLOSE = "PENDCLOSE";
        public static final String CLOSED = "CLOSED"; 
        public static final String CLOSE = "CLOSE"; 
        public static final String ONHOLD = "ONHOLD";
        public static final String PEND_APPR = "PEN";
        public static final String PEND_CAN = "PENCAN";
        public static final String PEN_APPR = "PENAPPR";
    }
}
