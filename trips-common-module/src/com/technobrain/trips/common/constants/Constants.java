package com.technobrain.trips.common.constants;


/**
 * Crown Agents 2007
 *
 * This class holds all the constants values used in TRIPS.
 * Please use this class to declare the general constants variables. This class is not ment to
 * declare constants which are only used in local to some method or class.
 *
 * @since $Date: 2/16/2010 9:53:54 PM$
 * @version $Revision: 416$
 * @author $Author: Ariel Balita$
 */
public abstract class Constants {

    public static final String TRIPS_PACKAGE_PREFIX = "com.technobrain.trips";
    public static final String TAXPAYER = "TAXPAYER";
    public static final String REVENUE = "REVENUE";
    
    public static final String EMPTY_STRING = "";
    public static final String MALE = "M";
    public static final String FEMALE = "F";

    public static final String GENDER_LIST = "GENDER_LIST";
    public static final String TITLE_LIST = "TITLE_LIST";
    public static final String COUNTRY_LIST = "COUNTRY_LIST";

    public static final String NOT_AVAILABLE = "N/A";
    public static final String BLANK = "";
    public static final String ACTIVE = "A";
    public static final String YES = "Y";
    public static final String NO = "N";
    public static final String TRUE = "T";
    public static final String FALSE = "F";
    public static final String PASS = "PASS";
    public static final String FAIL = "FAIL";
    public static final String BASIC = "Basic";
    public static final String BOTH = "Both";
    public static final String NUMBER = "number";
    public static final String DATE = "date";
    public static final String FUZZY = "fuzzy";
    public static final String SPOTLIGHT = "spotlight";
    public static final String MINI_SPOTLIGHT = "minispotlight";
    public static final String PERIOD_LABEL_SEPARATOR = "/";
    public static final String PERIOD_QUARTER_LABEL = "Q";
    public static final String PERIOD_ANNUAL_LABEL = "Annual";
    public static final String TAXPAYER_TIN="TaxpayerTIN";
    public static final String OFFICE="OFFICE";
    public static final String ID_MATCH="ID_MATCH";
    public static final String NOTIFICATION_DUPLICATE_TAXPAYER = "NOTIFICATION_DUPLICATE_TAXPAYER";
    public static final String DUPLICATE_FOUND="DUPLICATE_FOUND";
    public static final String USER="USER";
    public static final String DUPLICATELIST="DUPLICATELIST";
    public static final String LIST="LIST";
    public static final char TRP_FILE_SEPARATOR='~';
    
    public static final String String = "string";
    public static final String ERRORS = "ERRORS";
    public static final String NOERRORS = "NOERRORS";
    public static final String SUCCESS = "SUCCESS";
    public static final String EXTERNAL_SUSPICION_ID = "EXTERNAL_SUSPICION_ID";
    public static final String ATTACHMENT_FILE_STORE_LOCATION = 
        "C:/ATTACHMENTSTORE";

    public static final String PRODUCT_ID = "PRODUCT_ID";
    public static final String TAX_TYPE_CODE = "TAX_TYPE_CODE";
    public static final String TAX_BAND_ID = "TAX_BAND_ID";
    public static final String TAX_RATE_ID = "TAX_RATE_ID";
    public static final String TAX_RATE_PERIOD_ID = "TAX_RATE_PERIOD_ID";
    
    public static final String CURRENT_PERIOD = "CP";
    public static final String PREVIOUS_PERIOD = "PP";
    public static final String REVERSED_TRANSACTION_DESC_PREFIX = "Reversal Of Transaction: ";
    

    public static final String RUMMAGE_ID = "RUMMAGE_ID";
    public static final String SUSPICION_ID = "SUSPICION_ID";
    public static final String SEIZURE_ID = "SEIZURE_ID";
    public static final String OFFENCE_ID = "OFFENCE_ID";
    public static final String PANDICONFIG_ID = "PANDICONFIG_ID";
    public static final String FLEXIBLE_FORM_ID = "FLEXIBLE_FORM_ID";
    public static final String LEGISLATIVE_E_FILING_GRACE = "LEGISLATIVE_E_FILING_GRACE";
    
    public static final String REGIME_CONFIGURATION_CODE = 
        "REGIME_CONFIGURATION_CODE";
    public static final String REVENUE_DEFERMENT_ID = "REVENUE_DEFERMENT_ID";
    public static final String REVENUE_DEFERMENT_OBJECT = 
        "REVENUE_DEFERMENT_OBJECT";
    public static final String GUARANTEE_USAGE_ID = "GUARANTEE_USAGE_ID";
    public static final String GUARANTEE_USAGE_OBJECT = 
        "GUARANTEE_USAGE_OBJECT";
    public static final String TAX_CREDIT_REFUND_OBJECT = "TAX_CREDIT_REFUND_OBJECT";

    public static final String STATIC_SEARCH_INJECTION = 
        "STATIC_SEARCH_INJECTION";
    public static final String STATIC_INJECTION_BATCH_ID_NAME = "BatchId";
    public static final String BATCH_ID_COLUMN_NAME = "BATCH_ID";
        
    public static final String STATIC_INJECTION_BATCH_REFERENCE = "BatchReference";
    public static final String EXEMPTION_TASK_TITLE="ExemptionApplicationApproval";
    public static final String EXEMPTION_TASK_CANCEL_TITLE="ExemptionApplicationCancellationApproval";
    
    
    public static final String DEFERMENT = "deferment";
    public static final String RECALCULATE = "recalculate";
    
    public static final String AUTH_TYPE_RECOMMEND = "Recommend";
    public static final String AUTH_TYPE_APPROVE = "Approve";
    public static final String GUIPAGEVAL = "GUIPAGEVAL";
    
    public static final String GRA = "GRA";
    public static final String RGD = "RGD";
    public static final String  SOLPROP ="SOLPROP";
    
    public static final String  StartDate="StartDate";
    public static final String  EndDate="EndDate";
    public static final String  StartDatelabel="Start Date (DD/MM/YYYY)";
    public static final String EndDatelabel="End Date (DD/MM/YYYY)";
    public static final String  FILE_ID="FILE_ID";
    public static final String  STATUS ="STATUS";
    public static final String TAX_PAYER_TIN = "taxpayerTin";
    public static final String TAX_TYPE = "taxType";
    public static final String PERIOD = "period";
    public static final String TAX_TYPE_DESCRIPTION = "taxtypeDescription";    
    public static final String TAX_PAYER_NAME = "taxpayerName";
    public static final String  TAX_OFFICE = "TAX_OFFICE";
    public static final String CASH_TILL_REFERENCE = "cashTillReference";
    public static final String CASE_TYPE = "caseType";
    public static final String LOGGED_IN_USER_OFFICE = "LOGGED_IN_USER_OFFICE";
    public static final String SEPERATOR_COMMA = ",";
    
    public static final String GENERATED_PERIOD = "GeneratedPeriod";
    
    public static final String CANCEL_RETURN_LABEL = "Cancel Return";
    
    public static final String SEPARATOR_SPACE = " ";
    public static final String IDENTIFICATION_NUMBER = "identificationNumber";
    public static final String LINKED_RELATED_CASES_TABLE = "linkedRelatedCasesTable";
    public static final String GROUP_ASSIGNED_TABLE = "groupAssignedTable";
    public static final String TAX_CREDIT_ID = "taxCreditId";
    public static final String LINKED_RELATED_DEBT_CASES_TABLE = "linkedRelatedDebtCasesTable";
    public static final String MANUALLY_CREATED_CASE_TYPE = "MANUALLY_CREATED";
    public static final String SYSTEM_GENERATED_CASE_TYPE = "SYSTEM_GENERATED";
    public static final String BRANCH_MANAGER_REPORT_GROUP = "BranchManagerReportGroup";
    public static final String LINKED_RELATED_DOC_ID = "linkedRelatedDocId";
    public static final String MAIN_CASE_ID = "MAIN_CASE_ID";
    public static final String SYSTEM_APPROVER = "SystemApprover";
    public static final String CASE_INPUT_TYPE = "CASE_INPUT_TYPE";
    public static final String ICST_CODE = "ICST";
    public static final String DUMMY_TAX_TYPE = "Dummy";
  
    
    
    public interface ApplicationDocumentTypes {
        public static final String AppEntityRegistration = "ENT_REG";
        public static final String AppEntityTransfer = "ENT_TRNSFR";
        public static final String AppEntityAmendment = "ENT_AMEND";
        public static final String AppEntityDeregistration = "ENT_DEREG";
        public static final String AppEntityReregistration = "ENT_REREG";
        public static final String AppRegimeReregistration = "REV_REREG";
        public static final String AppRegimeDeregistration = "REV_DEREG";
        public static final String AppRegimeSuspend = "REV_SUSP";
        public static final String AppTaxpayerDeregistration = "ENT_DEREG";
        public static final String AppRegimeRegistration = "REV_REG";
        public static final String AppRegimeReactivation = "REV_REACT";
        
    }
    
    public interface DfinDocumentTypes {
        public static final String DfinCreditAllocation = "CRALLOCATION";
    }

    public interface FlexibleFormTypes {
        public static final String PAYE_MONTHLY_RETURNS = "Employers PAYE Monthly Return";
        public static final String PAYE_ANNUAL_RETURNS = "Employers PAYE Annual Return";
        public static final String RETURNS_WH_DETAILS = "RETURNS_WH_DETAILS";
        public static final String WITHHOLDING_RETURN = "Withholding Return";
        
    }

    public interface propertyDetails {
        public static final String RENTED = "Rented";
        public static final String OWNED = "Owned";
        public static final String OWN_PROPERTY_RENTED = "Owned_Property_Rented";
        public static final String OTHER = "Other";
    }
    
    
    public interface DDocDocumentRoles{
        public static final String DATAENTRYOFF = "DATAENTRYOFF";
        public static final String AUTHOFF = "AUTHOFF";
        public static final String SYSTEM_APPR = "APPR";
       
     }
    
    
    public interface SCRIPT_USAGE_TYPE{
        public static final String PAGE_VALIDATION = "PageValidation";
        public static final String VALIDATION_SERVICE = "ValidationService";
        public static final String FLEXIBLE_FORMS = "FlexibleForms";
        public static final String OTHER = "Other";
    }
    
    public interface RISK_PROFILE {
        public static final String DOCUMENT_TYPE_CUSTOMS = "CUSTDEC";

        public static final String LOW_RISK_SCORE = "LOW_RISK";
        public static final String MED_RISK_SCORE = "MED_RISK";
        public static final String HIGH_RISK_SCORE = "HIGH_RISK";
        
        public static final String NUMBER_TYPE = "NUMBER_TYPE";
        public static final String DATE_TYPE = "DATE_TYPE";
        public static final String STRING_TYPE = "STRING_TYPE";
        public static final String NA = "Not Applicable";
        public static final String CASE_CREATED = "Auto Created Case by Returns Risk Profile Module";
        public static final String RISK_INSTRUCTON = "Risk Profile Instructions";
        public static final String ETIS = "ETIS";
        public static final String CASE_TYPE = "RP_T";
        public static final String CASE_REASON = "W06";
        public static final String HQ = "HQ";
        
        public static final String HIGH_RISK = "HIGH";
        public static final String MEDIUM_RISK = "MEDIUM";
        public static final String LOW_RISK = "LOW";
        public static final String PROFILE_DESCRIPTION = "Profile Description :";
        public static final String PROFILE_SCORE = "Profile Score : ";
        public static final String RISK_CASENOTES_TITLE="Results of risk analysis performed with risk profile: ";
    }

    /**
     * Useful constants for risk criteria analysis.
     *
     * @since 07-May-2008
     * @author Alexei
     */
    public interface RiskCriteria {

        public static final int MIN_RISK_SCORE_DEFAULT = 100;

        public static final int RISK_VALUE_EQUALS = 1;
        public static final int RISK_VALUE_LESS_THAN = 2;
        public static final int RISK_VALUE_GREATER_THAN = 3;
        public static final int RISK_VALUE_LESS_THAN_OR_EQUAL_TO = 4;
        public static final int RISK_VALUE_GREATER_THAN_OR_EQUAL_TO = 5;
        public static final int RISK_VALUE_BETWEEN = 6;

        public static final String RISK_VALUE_STR_LIST_DELIM = SEPERATOR_COMMA;
        public static final String RISK_STATUS_HIT = "HIT";
        public static final String RISK_STATUS_NOHIT = "NOHIT";
        public static final String DATE_PATTERN_STRING = "dd-MMM-yy";
    }
    
    public interface RiskCriteriaTypes {
        public static final String PERC_COMP        = "PERC_COMP";
        public static final String ACTU_VAL_COMP    = "ACTU_VAL_COMP";
        public static final String MULT_COMP        = "MULT_COMP";
    }
    
    public interface EventConstants {
        String CATEGORY = "EVENT_CATEGORY";
        String REGSTATUS = "REGISTRATION_STATUS";
        String ENTID = "ENTITY_ID";
        String WF_TYPE= "WF_TYPE";
        String PENDING_REV_DEREG = "PENDING_REVISION_DEREG";
        String PENDING_REV_REACT = "PENDING_REV_REACT";
        String PENDING_REV_SUSP = "PENDING_REV_SUSP";
        String PENDING_REV_TRANSFER = "PENDING_REV_TRANSFER";
        String RETURNS = "RETURNS";
        String EXEMPTIONS = "EXEMPTIONS";
        String LODGEMENT = "LODGEMENT";
        String RET_CREATE_DOC_CHARG_FILE_RETURNS = "RET_CREATE_DOC_CHARG_FILE_RETURNS";
        String RET_LODGEMENT = "RET_LODGEMENT";
        String COLL_SUBMISSION =  "COLL_SUBMISSION";
        String MANUAL_PENALTY = "MANUAL_PENALTY";
        String REFUND_SUBMISSION = "REFUND_SUBMISSION";
        String CREATE_INSTALMENT = "CREATE_INSTALMENT";
       
    }

    public interface AnnualReturnTypes {
        String CIT_AP = "CIT-AP";
        String RLTY_AG = "RLTY-AG";
        String RLTY_AP = "RLTY-AP";        
        public static final String CIT_QP = "CIT-QP";
        public static final String CIT_FP = "CIT-FP";
    }

    /**
     * @since Feb 5,2006
     * @author hhill
     */
    public interface Regimes {

        public static final String CREDIT_JOURNAL_REALL = 
            "CREDIT_JOURNAL_REALL";
        public static final String SUSPENSE = "SUSPENSE";
        public static final String VAT = "VAT";
        public static final String PTX = "PTX";
        public static final String PTX_IPO = "PTX-IPO";
        public static final String PTX_Q = "PTX-Q";
        public static final String PTX_SL = "PTX-SL";
        public static final String PTX_STK = "PTX-STK";
        public static final String PAYE = "PAYE";
        public static final String CIT = "CIT";
        public static final String WIT = "WIT";
        public static final String CGT_RP = "CGT-RP";
        public static final String CGT_ST_CS = "CGT-ST(CS)";
        public static final String DST = "DST";
        public static final String DST_R = "DST-R";
        public static final String DON = "DON";
        public static final String IAE = "IAE";
        public static final String ESTATE = "EST";
        public static final String EXCISE = "EXCISE";
        public static final String EXC_ANE = "EXC-ANE";
        public static final String EXC_AP = "EXC-AP";
        public static final String EXC_AV = "EXC-AV";
        public static final String EXC_MP = "EXC-MP";
        public static final String EXC_PP = "EXC-PP";
        public static final String EXC_SP = "EXC-SP";
        public static final String EXC_TP = "EXC-TP";
        public static final String WTX_BNK = "WTX-BNK";
        public static final String WTX_COM = "WTX-COM";
        public static final String WTX_EXP = "WTX-EXP";
        public static final String WTX_FB = "WTX-FB";
        public static final String WTX_FIN = "WTX-FIN";
        public static final String WTX_OTH = "WTX-OTH";
        public static final String WTX_PTX = "WTX-PTX";
        public static final String WTX_VAT = "WTX-VAT";
        public static final String IIT = "IIT";
        public static final String FBT = "FBT";
        public static final String VEHIT = "VEH-IT";
        public static final String VATSTD = "V-STD";
        public static final String VATFLATRATE = "V-FR";
        public static final String VATNHILIMP = "VAT-NHIL";
        public static final String RLTY = "RLTY";
        public static final String RLTYP = "RLTYP";
        public static final String PET = "PET";
        
        public static final String CUSTOMS = "CUSTOMS";
        public static final String PERIODIC = "PERIODIC";
        public static final String MISC = "MISC";
        public static final String TAXPAYER = "TAXPAYER";
        public static final String GUARANTEE = "GUA";
        public static final String REG_FEE = "REG-FEE";
        public static final String[] ALL = 
            new String[] { CREDIT_JOURNAL_REALL, SUSPENSE, VAT, PAYE, CIT, WIT, 
                           EXCISE, IIT, FBT, CUSTOMS, MISC };
        public static final String REGISTER = "REG";
        public static final String PENDING_DEREGISTER = "PEND";
        public static final String DEREGISTER = "DE-REG";
        public static final String SUSPEND = "SUSP";
        public static final String RE_REGISTER = "RE-REG";
        public static final String PENDING_REGISTER = "PEND";
        public static final String REV = "REV";
        public static final String PIT = "PIT";
        public static final String CST = "CST";
        
        // 19/09/2007 pja - Why are the following two lines here? I think this is incorrect, remove these
        // lines if the comment out doesn't cause a problem.
        //        public static final String CODE_CUST_DECLARATION = "CUST_DECLARATION";
        //        public static final String DESC_CUST_DECLARATION = "CUST DECLARATION";
        public static final String FOF = "FOF";
        public static final String TAX_STAMP = "TAX-ST";
        public static final String STAMP_DUTY = "ST-D";
        public static final String RENT_INCOME_TAX = "R-IT";
    }

    public interface Entity {
        public static final String INDIVIDUAL_TYPE = "Individual";
        public static final String NON_REG_TP_IND_TYPE = "Non Reg Individual";
        public static final String ORGANIZATION_TYPE = "Organization";
        public static final String ORGANISATION_TYPE = "Organisation";
        public static final String DTYPE_ORGANIZATION = "ORGANIZATION";
        public static final String DTYPE_INDIVIDUAL = "INDIVIDUAL";
        public static final String VEHICLE_TYPE = "VEH";
        public static final String TRANSPORT_TYPE = "Transport";
        public static final String BANK = "Bank";
        public static final String NON_TAXPAYER_INDIVIDUAL = "NON_TAXPAYER_INDIVIDUAL";
        
        
        public static final String ENTITY = "ENTITY";
        public static final String INDIVIDUAL_CLASS = 
            "IndividualTaxpayerInputType";
        public static final String ORGANIZATION_CLASS = 
            "OrganisationTaxpayerInputType";
        public static final String CONTAINER = "Container";
    }

    public interface SEARCH_KEYS {        
        public static final String FIND_ENTITY_FF_GIFT_TAX = "FIND_ENTITY_FF_GIFT_TAX";
        public static final String FIND_ENTITY_FF_EXCISE_DUTY_RETURNS = "FIND_ENTITY_FF_EXCISE_DUTY_RETURNS";
        public static final String FIND_ENTITY = "FIND_ENTITY_REG_TYPE";
        public static final String FIND_ENTITY_FF_WH_ITEMS_POPUP = "FIND_ENTITY_FF_WH_ITEMS_POPUP";
        public static final String FIND_ENTITY_TIN = "FIND_ENTITY_REG_TYPE_TIN";
        public static final String FIND_ENTITY_FF = "FIND_ENTITY_FF";       
        public static final String FIND_ENTITY_GIFT_TAX = "FIND_ENTITY_GIFT_TAX";
        public static final String FIND_ENTITY_GIFT_TAX_DONOR = "FIND_ENTITY_GIFT_TAX_DONOR";
        public static final String FIND_COMPANY_DIRECTORS = "FIND_COMPANY_DIRECTORS";
        public static final String FIND_BATCH_COLLECTION = "FIND_BATCH_COLLECTION";
        public static final String FIND_INSPECTION = "FIND_INSPECTION";
        public static final String FIND_TRANSACTION = "FIND_TRANSACTION";
        public static final String FIND_DECLARATION = "FIND_DECLARATION";
        public static final String FIND_REGIME_ACCOUNT = "FIND_REGIME_ACCOUNT";
        public static final String FIND_COMMODITY = "FIND_COMMODITY";
        public static final String FIND_TRANSACTION_TYPE = 
            "FIND_TRANSACTION_TYPE";
        public static final String FIND_CUST_LOCATION = "FIND_CUST_LOCATION";
        public static final String FIND_PAYMENT = "FIND_PAYMENT";
        public static final String FIND_DECLARATIONS_AWAITING_PAYMENT = 
            "FIND_DECLARATIONS_AWAITING_PAYMENT";
        //        public static final String FIND_ENTITY_WITH_CUSTOMS_ACC = "FIND_ENTITY_WITH_CUSTOMS_ACC";
        public static final String FIND_RISK_INFORMATION = "FIND_RISK_INFORMATION";
        public static final String FIND_SUSPICION = "FIND_SUSPICION";
        public static final String FIND_SUSPECT = "FIND_SUSPECT";
        public static final String FIND_TAS = "FIND_TAS";
        public static final String FIND_TAS_APPROVAL = "FIND_TAS_APPROVAL";
        public static final String FIND_TAXPAYER_LEDGER = 
            "FIND_TAXPAYER_LEDGER";
        public static final String FIND_TRANSFER_PAYMENT_CREDIT = 
            "FIND_TRANSFER_PAYMENT_CREDIT";
        public static final String FIND_RETURN_PERIOD_SUMMARY = 
            "FIND_RETURN_PERIOD_SUMMARY";
        public static final String FIND_TAX_YEAR_SUMMARY = 
            "FIND_TAX_YEAR_SUMMARY";

        public static final String INTEL_SPOTLIGHT = "INTEL_SPOTLIGHT";

        public static final String FIND_MANIFEST_SEARCH = "FIND_MANIFEST";
        public static final String FIND_EXEMPTIONS = "FIND_EXEMPTIONS";
        public static final String FIND_EXEMPTIONS_APPLICATIONS = "FIND_EXEMPTIONS_APPLICATIONS";
        public static final String FIND_ENTITY_EXMN_APP_TAXPAYER = "FIND_ENTITY_EXMN_APP_TAXPAYER";
        public static final String FIND_ENTITY_ORG = "FIND_ENTITY_ORG";
        public static final String FIND_REFUND = "FIND_REFUND";
        public static final String FIND_TAXPAYER_REFUND_APPLICATION = "FIND_TAXPAYER_REFUND_APPLICATION";
        public static final String FIND_REFUND_INQUIRY = "FIND_REFUND_INQUIRY";
        public static final String FIND_ENTITY_FOR_REFUND = "FIND_ENTITY_FOR_REFUND";
        public static final String FIND_AUTHORIZED_REFUND_FOR_CHEQUE = "FIND_AUTHORIZED_REFUND_CHEQUE";
        public static final String FIND_AUTHORIZED_REFUND_FOR_TRN = "FIND_AUTHORIZED_REFUND_TRN";
        public static final String FIND_CASE = "FIND_CASE";
        public static final String FIND_LINKED_CASE = "FIND_LINKED_CASE";
        public static final String FIND_VIEW_CASE = "FIND_VIEW_CASE";
        public static final String FIND_DEBT_CASE = "FIND_DEBT_CASE";
        public static final String FIND_AUDIT_VISIT_CASE = "FIND_AUDIT_VISIT_CASE";
        public static final String FIND_OBJECTION_APPEAL_CASE = "FIND_OBJECTION_APPEAL_CASE";
        public static final String FIND_CASE_DOC = "FIND_CASE_DOC";
        public static final String FIND_RELATED_DOCUMENT = 
            "FIND_RELATED_DOCUMENT";
        public static final String FIND_OBJECTIONS_APPEALS = 
            "FIND_OBJECTIONS_APPEALS";
        public static final String FIND_REVLED_TRANSACTION = 
            "FIND_REVLED_TRANSACTION";
        public static final String FIND_PRODUCTS = "FIND_PRODUCTS";
        public static final String FIND_RUMMAGES = "FIND_RUMMAGES";
        public static final String FIND_SEIZURES = "FIND_SEIZURES";
        public static final String FIND_OFFENCES = "FIND_OFFENCES";
        public static final String FIND_PRODUCT_VALUATION = 
            "FIND_PRODUCT_VALUATION";
        public static final String FIND_FREIGHT_VALUATION = 
            "FIND_FREIGHT_VALUATION";
        public static final String FIND_FREIGHTPRICESEARCHS = 
            "FIND_FREIGHTPRICESEARCHS";

        public static final String FIND_PRODUCT_COMMODITY = 
            "FIND_PRODUCT_COMMODITY";
        public static final String FIND_LOCATION_BY_COUNTRY = 
            "FIND_LOCATION_BY_COUNTRY";

        public static final String FIND_JOURNEY = "FIND_JOURNEY";
        public static final String PORTS = "PORTS";
        public static final String FIND_TRANSPORT = "FIND_TRANSPORT";
        public static final String FIND_PACKAGE = "FIND_PACKAGE";
        public static final String FIND_ENTITY_CONTAINER = 
            "FIND_ENTITY_CONTAINER";
        public static final String FIND_FREE_ZONE = "FIND_FREE_ZONE";
        public static final String FIND_OFFICE = "FIND_OFFICE";
        public static final String FIND_WAREHOUSE = "FIND_WAREHOUSE";
        public static final String FIND_WAREHOUSE_ADDRESS = 
            "FIND_WAREHOUSE_ADDRESS";
        public static final String FIND_PROCEDURE = "FIND_PROCEDURE";
        public static final String FIND_CONTAINER_MEASUREMENTS = 
            "FIND_CONTAINER_MEASUREMENTS";
        public static final String FIND_CONTAINER_TYPE = "FIND_CONTAINER_TYPE";
        public static final String FIND_APP_CONFIGURATION = 
            "FIND_APP_CONFIGURATION";
        public static final String FIND_PANDICONFIGURATIONS = 
            "FIND_PANDICONFIGURATIONS";
        public static final String FIND_PRINTER = "FIND_PRINTER";
        public static final String FIND_APPLICATION = "FIND_APPLICATION";
        public static final String FIND_USERS = "FIND_USERS";
        public static final String FIND_DOCREPORTS = "FIND_DOCREPORTS";
        public static final String FIND_GUARANTEE_WITH_STATUS_NEW = 
            "FIND_GUARANTEE_WITH_STATUS_NEW";
        public static final String FIND_REVENUEDEFERMENTS = 
            "FIND_REVENUEDEFERMENTS";
        public static final String FIND_TRANSACTION_FOR_INSTALLMENT_AGREEMENT = "FIND_TRANSACTION_FOR_INSTALLMENT_AGREEMENT";
        public static final String FIND_TRANSACTION_FOR_PAYMENT_ALLOCATION="FIND_TRANSACTION_FOR_PAYMENT_ALLOCATION";
        public static final String FIND_DOCTYPES = "FIND_DOCTYPES";
        public static final String FIND_COMPLIANCE_CONFIGURATION = 
            "FIND_COMPLIANCE_CONFIGURATION";
        public static final String FIND_REF_PERIOD = "FIND_REF_PERIOD";
        
        public static final String FIND_CREDIT_ALLOCATION = "FIND_CREDIT_ALLOCATION";
        public static final String FIND_CREDIT_ALLOCATION_TRANSACTIONS = "FIND_CREDIT_ALLOCATION_TRANSACTIONS";
        
        public static final String USER_OFFICE_LIST = "USER_OFFICE_LIST";
        public static final String FIND_DEFERMENT_CASE = "FIND_DEFERMENT_CASE";
        public static final String FIND_GUARANTEE = "FIND_GUARANTEE";
        public static final String FIND_GUARANTEEUSAGES = 
            "FIND_GUARANTEEUSAGES";
        public static final String FIND_CUSTOMSREGIMETAXS = 
            "FIND_CUSTOMSREGIMETAXS";

        public static final String FIND_TAXBANDCONFIGS = "FIND_TAXBANDCONFIGS";
        public static final String FIND_TAXTYPECONFIGS = "FIND_TAXTYPECONFIGS";
        public static final String FIND_TAXRATECONFIGS = "FIND_TAXRATECONFIGS";
        public static final String FIND_TAXALLOCATION = "FIND_TAXALLOCATION";

        public static final String FIND_TAX_ACCOUNT_FOR_GUARANTEE = 
            "FIND_TAX_ACCOUNT_FOR_GUARANTEE";
        public static final String FIND_JOB_DEFINITIONS = "FIND_JOB_DEFINITIONS";

        public static final String FIND_GUARANTEE_FOR_USAGES = 
            "FIND_GUARANTEE_FOR_USAGES";

        String FIND_HANDLING_OPERATION = "FIND_HANDLING_OPERATION";
        String FIND_GOODS_TRANSFER_METHOD = "FIND_GOODS_TRANSFER_METHOD";
        String FIND_OFFICE_IN_COUNTRY = "FIND_OFFICE_IN_COUNTRY";
        String FIND_ACTIVITY_LOG = "FIND_ACTIVITY_LOG";
        public static final String FIND_FLEXIBLE_FORM_TYPES = 
            "FIND_FLEXIBLE_FORM_TYPES";
        public static final String FIND_DOCUMENT_TYPE = "FIND_DOCUMENT_TYPE";
        public static final String FIND_FLEXIBLEFORMS = "FIND_FLEXIBLEFORMS";
        public static final String FIND_REGIME_CONFIGURATIONS = 
            "FIND_REGIME_CONFIGURATIONS";
        public static final String FIND_FORM_APPLICATION = 
            "FIND_FORM_APPLICATION";
        public static final String FIND_FLEXIBLE_DB_TABLES = 
            "FIND_FLEXIBLE_DB_TABLES";
        String FIND_BATCH_DETAILS = "FIND_BATCH_DETAILS";
        public static final String FIND_DATE_MANAGEMENT = "FIND_DATE_MANAGEMENT";
        public static final String FIND_DATE_HOLIDAY = "FIND_DATE_HOLIDAY";
        public static final String FIND_DATE_LEGISLATIVE = "FIND_DATE_LEGISLATIVE";
        public static final String FIND_CASE_EVENTS="FIND_CASE_EVENTS";
        
        public static final String FIND_TAXPAYER_TCC = "FIND_TAXPAYER_TCC";
        public static final String FIND_INSTALLMENT_AGREEMENT = "FIND_INSTALLMENT_AGREEMENT";
        public static final String ACQUIRED_ASSETS_SUMMARY = "ACQUIRED_ASSETS_SUMMARY";
        
        public static final String FIND_PAYMENT_REVERSAL = "FIND_PAYMENT_REVERSAL";
        public static final String FIND_CONFIGURATION_SET = "FIND_CONFIGURATION_SET";
        public static final String ERROR_IN_SEARCH_CONF = "ERROR_IN_SEARCH_CONF";
        public static final String FIND_FLEX_FORMS_MINI_SPOT_LIGHT ="FIND_FLEX_FORMS_MINI_SPOT_LIGHT";
        
        public static final String FIND_DATE_HOLIDAY_VIEW = "FIND_DATE_HOLIDAY_VIEW";
        public static final String FIND_DATE_LEGISLATIVE_VIEW = "FIND_DATE_LEGISLATIVE_VIEW";
        
        public static final String FIND_ENTITY_TCC_ISSUANCE="FIND_ENTITY_TCC_ISSUANCE";
        public static final String FIND_ENTITY_ACQUIRED_ASSETS = "FIND_ENTITY_ACQUIRED_ASSETS";
        public static final String FIND_SELECTION_PROFILE = "FIND_SELECTION_PROFILE";
        public static final String FIND_SELECTION_PROFILE_TO_RUN = "FIND_SELECTION_PROFILE_TO_RUN";
        public static final String FIND_SELECTION_PROFILE_BUSINESS="FIND_SELECTION_PROFILE_BUSINESS";
        public static final String FIND_SELECTION_REPORT = "FIND_SELECTION_REPORT";
        public static final String FIND_AUDIT_LOG = "FIND_AUDIT_LOG";
        public static final String FIND_TAMPLIST_SELECTION = "FIND_TAMPLIST_SELECTION";
        public static final String FIND_TCR_CONFIGURATION = "FIND_TCR_CONFIGURATION";
        public static final String FIND_JOB_STREAMS = "FIND_JOB_STREAMS";
        public static final String FIND_SCHEDULABLE_JOB_SET = "FIND_SCHEDULABLE_JOB_SET";
        public static final String FIND_DEPOSIT_SLIP = "FIND_DEPOSIT_SLIP";
        public static final String FIND_CANCEL_APPLICATION = "FIND_APPLICATION_CANCEL";
        public static final String FIND_EXPIRED_APPLICATION = "FIND_APPLICATION_EXPIRED";
        public static final String FIND_RENEW_APPLICATION = "FIND_APPLICATION_RENEW";
        public static final String FIND_AUTHORIZE_APPLICATION = "FIND_APPLICATION_AUTHORIZE";
        public static final String FIND_VIEW_APPLICATION = "FIND_APPLICATION_VIEW";
        public static final String FIND_GUI_PAGE = "FIND_GUI_PAGE";
        public static final String FIND_SCRIPT = "FIND_SCRIPT";
        public static final String FIND_MESSAGE_TYPE = "FIND_MESSAGE_TYPE"; 
        public static final String FIND_PERIOD_FORMULA = "FIND_PERIOD_FORMULA";
        public static final String FIND_PERIOD_GENERATION = "FIND_PERIOD_GENERATION";
        public static final String FIND_REPORT_CONFIGURATION = "FIND_REPORT_CONFIGURATION";
        public static final String FIND_REPORTREPRINTS = "FIND_REPORTREPRINTS";
        public static final String FIND_ENT_ACC_PERIOD = "FIND_ENT_ACC_PERIOD";        
        public static final String FIND_RECEIPT= "FIND_RECEIPT";
        public static final String FIND_DOCUMENT= "FIND_DOCUMENT";
        public static final String FIND_CASE_RELATED_DOCUMENT= "FIND_CASE_RELATED_DOCUMENT";
        public static final String FIND_DOCUMENT_OUTSTANDING_BALANCE= "FIND_DOCUMENT_OUTSTANDING_BALANCE"; 
        public static final String FIND_ALLOC_CONFIG = "FIND_ALLOC_CONFIG";
        public static final String FIND_REV_COLL_CASH_OFFICE = "FIND_REV_COLL_CASH_OFFICE";
        public static final String FIND_RETURN_DOCUMENT = "FIND_RETURN_DOCUMENT";
        public static final String FIND_EXTEND_RETURN_DOCUMENT = "FIND_EXTEND_RETURN_DOCUMENT";
        public static final String FIND_RETURNS_PAYE_MONTHLY = "FIND_RETURNS_PAYER_MONTHLY";
        public static final String FIND_RETURNS_PAYER_ANNUAL = "FIND_RETURNS_PAYER_ANNUAL";
        public static final String FIND_ENTITY_QOQ_LIFTED_DETAILS_POPUP = "FIND_ENTITY_QOQ_LIFTED_DETAILS_POPUP";        
        public static final String FIND_PENALTY_RULE_CONFIGURATION = "FIND_PENALTY_RULE_CONFIGURATION";
        public static final String FIND_MANUAL_PENALTY = "FIND_MANUAL_PENALTY";
        public static final String FIND_CONFIGURE_DEFAULT_OFFICE = "FIND_CONFIGURE_DEFAULT_OFFICE";
        public static final String FIND_ENTITY_FOR_CREATE_CASE="FIND_ENTITY_FOR_CREATE_CASE";
        public static final String FIND_TAX_CASE = "FIND_TAX_CASE";
        public static final String FIND_ENTITY_RESI_POST_ADDRESS = "FIND_ENTITY_RESI_POST_ADDRESS";
        public static final String FIND_DESK_AUDIT_CONFIGURATION = "FIND_DESK_AUDIT_CONFIGURATION";
        public static final String FIND_RISK_PROFILE= "FIND_RISK_PROFILE";
        public static final String FIND_VISIT_SELECTION_REPORT="FIND_VISIT_SELECTION_REPORT";
        public static final String FIND_BUSINESS_TRANSACTION_FOR_OBJECTION = "FIND_BUSINESS_TRANSACTION_FOR_OBJECTION";
        public static final String FIND_MAINTAIN_TAXTYPE_STRUCTURE = "FIND_MAINTAIN_TAXTYPE_STRUCTURE";
        public static final String FIND_TAX_RATE_CONFIGURATION = "FIND_TAX_RATE_CONFIGURATION";
        public static final String FIND_PARAMETERS_CONFIGURATION="FIND_SYS_PARAMETER";
        public static final String FIND_CASH_OFFICER = "FIND_CASH_OFFICER";
        public static final String FIND_ENTITY_INCLUDING_GRA = "FIND_ENTITY_INCLUDING_GRA";
    }

    public interface RecordStatus {
        public static final String ACTIVE = "A";
        public static final String INACTIVE = "I";
        public static final String DELETED = "D";
        public static final String SAVED = "S";
        public static final String POSTED = "P";
        public static final String CANCELLED = "C";
    }
    public static final String STRING = "string";
    public static final String FORFIELD = "forField";
    public static final String CASTOR_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
    public static final String PERIOD_GEN_REG_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_REFUND_MODE_OF_CLAIM =  "TAX_R";

    public interface RevenueAcc {
        /* Tells whether the account is a transaction account. The value should
         * reflect the code of the REF_REV_MODE table
         */
        public static final String REV_TRANSACTION = "TRA";
        /* Tells whether the account is a revenue customs account. This is a type of Transaction account
         * The value should reflect the code of the REF_REV_MODE table
         * */
        public static final String REV_CUSTOMS = "CUST";
        /* Tells whether the account is a revenue periodic account. The value should
         * reflect the code of the REF_REV_MODE table
         */
        public static final String REV_PERIODIC = "PER";
        /* Tells whether the account is a regime account */
        public static final String REGIME_ACC = "REGIME_ACC";
        /* Defines Account Status of an Revenue Account as REGISTERED
           This value of the constant is the same as in database*/
        public static final String REV_GUARANTEE = "GUAR";
        public static final String REGISTERED = "2";
    }
    /* Tells whether the String is a relationship account */
    public static final String ACC_RELATIONSHIP = "ACC_RELATIONSHIP";
    public static final String MODULUS_10 = "MODULUS_10";
    public static final String MODULUS_11 = "MODULUS_11";
    public static final String MODULUS_13 = "MODULUS_13";
    public static final String TRIPS_PROPERTIES = "trips";

    public interface ServiceManagerConstants {
        public static final String ERR_SERVER_ALREADY_STARTED = 
            "The server has already been started!";
        public static final String ERR_SERVER_NOT_STARTED = 
            "The server hasn't been started yet.";
        public static final String ERR_STARTING_SERVER = 
            "An error occurred starting the service: {0}";
        public static final String ERR_STOPPING_SERVER = 
            "An error occurred stopping the service: {0}";
        public static final String INFO_RESOURCE_BUNDLE_LOADED = 
            "Resource Bundle {0} loaded";
        public static final String LOG_RESOURCE_BUNDLE_LOADED = 
            "Resource bundle loaded: {0}.properties";
        public static final String LOG_SERVICE_MANAGER_STARTED = 
            "ServiceManager has started";
        public static final String LOG_SERVICE_MANAGER_STOPPED = 
            "ServiceManager has stopped";
        public static final String LOG_SERVER_STOPPED = 
            "The server was stopped successfully.";
        public static final String LOG_SERVER_STARTED = 
            "The server was started successfully.";
        public static final String STRING_SERVICE_MANAGER = "ServiceManager";
    }

    public interface RuleManagerConstants {
        public static final String CMD_RESET = "reset";
        public static final String CMD_CLEARRULESETSTACK = "clearRulesetStack";
        public static final String CMD_PUSHRULESET = "pushRuleset";
        public static final String KEY_REPOSITORY_NAME = "trips-rules";
        public static final String KEY_DICTIONARY_NAME = "dictionary-name";
        public static final String KEY_DICTIONARY_VERSION = 
            "dictionary-version";
        public static final String LOG_RULES_REPOSITORY_LOADED = 
            "Rules repository loaded: {0}";
        public static final String LOG_DICTIONARY_LOADED = 
            "Dictionary loaded: {0}({1})";
        public static final String LOG_CLASS_RULES_MANAGER = "RulesManager";
        public static final String LOG_METHOD_START = "start";
        public static final String LOG_RULES_MANAGER_STARTED = 
            "RulesManager has started";
        public static final String LOG_METHOD_LOAD_REPOSITORY = 
            "loadRepository";
        public static final String LOG_METHOD_LOAD_DICTIONARY = 
            "loadDictionary";
        public static final String RULES_PATH = 
            "oracle.rules.sdk.store.jar.path";
        public static final String RULES_FILE_STORE = 
            "oracle.rules.sdk.store.jar";
        public static final String ANALYSIS_DICTIONARY = "Analysis";
        public static final String VALIDATION_DICTIONARY = "VALIDATION";
        public static final String COMPUTE_DICTIONARY = "Compute";
        public static final String DEFAULT_DICTIONARY_VERSION = "INITIAL";
    }

    public interface ValidationServiceManagerConstants {
        public static final String STRING_TRIPS_VALIDATION = 
            "trips-validation";
        public static final String STRING_VALIDATION_SERVICE_MANAGER = 
            "ValidationServiceManager";
        public static final String LOG_METHOD_VALIDATE = "validate";
        public static final String LOG_CLASS_VALIDATION_SERVICE_MANAGER = 
            "ValidationServiceManager";
        public static final String ERR_VALIDATING_OBJECT = 
            "Error validating object";
        public static final String ERR_RELOADING = "Error reloading: ";
        public static final String LOG_METHOD_START = "start";
        public static final String LOG_VALIDATION_SERVICE_MANAGER_STARTED = 
            "Validation Service successfully started.";
        public static final String ERR_PLEASE_CONFIRM_START_REQUEST = 
            "Please confirm the request to start the server!";
        public static final String LOG_METHOD_GET_PROVIDER = "getProvider";
        public static final String LOG_METHOD_RELEASE_PROVIDER = 
            "releaseProvider";
        public static final String CMD_START = "START";
        public static final String CMD_STOP = "STOP";
        public static final String CMD_RELOAD = "RELOAD";
        public static final String INFO_COMMAND_NOT_RECOGNISED = 
            "Command not recognised.";
        public static final String INFO_ADMIN_PROMPT = "Admin:> ";
        public static final String SUFFIX_DOT_PROVIDER = ".provider";
    }

    public interface Rules {
        public static final String CHECK_ENTITY_DUPLICATE[] = 
            new String[] { "checkNewIndividualEntityDuplicate", 
                           "checkNewOrganizationEntityDuplicate" };
        public static final String ADVISORY_VISIT_REQUIRES_DECISION[] = 
            new String[] { "advisoryVisitRequiredDecision" };
        public static final String CHECK_DECLARATION_DUPLICATE[] = 
            new String[] { "checkDeclarationDuplicate" };
        public static final String CALCULATE_INSTALMENTS[] = 
            new String[] { "calculateInstalments" };
        public static final String CALCULATE_ETIS_INSTALMENTS[] = 
            new String[] { "calculateETISInstalments" };
        public static final String COMPUTE_REGIME_REGISTRATION_COMPLIANCE[] = 
            new String[] { "computeRegimeRegistrationCompliance" };
        public static final String GENERATE_AUTO_ASSESMENT[] = 
            new String[] { "generateEstimatedAssessment" };
        public static final String COMPUTE_NON_FILE_COMPLIANCE[] = 
            new String[] { "computeNonfileCompliance" };
        public static final String COMPUTE_NON_PAY_COMPLIANCE[] = 
            new String[] { "computeNonPayCompliance" };
        public static final String COMPUTE_TP_REGISTRATION_COMPLIANCE[] = 
            new String[] { "computeTPRegistrationCompliance" };
        public static final String CHECK_REGIMEACCOUNT_DUPLICATE[] = 
            new String[] { "checkRegimeAccountDuplicate" };
        public static final String VALIDATE_DECLARATION_INPUT[] = 
            new String[] { "validateDeclarationInput" };
        public static final String CHECK_SUSPECT_DUPLICATE[] = 
            new String[] { "checkNewSuspectAircraftDuplicate", 
                           "checkNewSuspectContainerDuplicate", 
                           "checkNewSuspectIndividualDuplicate", 
                           "checkNewSuspectOrganisationDuplicate", 
                           "checkNewSuspectVehicleDuplicate", 
                           "checkNewSuspectVesselDuplicate", 
                           "checkNewSuspectOtherDuplicate" };
        public static final String CALCULATE_INTEREST[] = 
            new String[] { "calculateInterest" };
    }

    public interface RulesFunctions {
        public static final String ENTITY_DUPLICATE_CHECK = 
            "DM.getEntityMatch";
        public static final String ANALYSIS_VISIT_REQUIRES_DECISION = 
            "DM.advisoryVisitRequiredDecision";
        public static final String PERFORM_AUTO_ASSESMENT_DECISION = 
            "DM.performAutoAssesmentDecision";
        public static final String IMPLICIT_REGIME_REGISTRATION_DECISION = 
            "DM.implicitRegimeRegistrationDecision";
        public static final String CANCEL_INSTALLMENT_AGREEMENET_DECISION = 
            "DM.cancelInstalmentAgreementDecision";
        public static final String CHECK_REGIME_REGISTRATION_COMPLIANCE = 
            "DM.checkRegimeRegistrationCompliance";
        public static final String PERFORM_TP_AUDIT_SELECTION = 
            "DM.performTPAuditSelectiion";
        public static final String CHECK_TP_REGISTRATION_COMPLIANCE = 
            "DM.checkTPRegistrationCompliance";
        public static final String CHECK_LATE_PAY_COMPALIANCE = 
            "DM.checkLatePayCompliance";
        public static final String GET_IMPLICIT_REGIMES = 
            "DM.getImplicitRegimes";
        public static final String GET_COMPLIANCE_ACTION_LIST = 
            "DM.getComplianceActionList";
        public static final String CHECK_LATE_FILE_COMPALIANCE = 
            "DM.checkLatefileCompliance";
        public static final String ANALYSIS_REFULD_CLAIMS = 
            "DM.analyseRefundClaims";
        public static final String COMPUTE_LATE_COMPALIANCE = 
            "DM.checkLatefileCompliance";
        public static final String CALCULATE_INSTALMENTS = 
            "DM.calculateInstalments";
        public static final String CALCULATE_ETIS_INSTALMENTS = 
            "DM.calculateETISInstalments";
        public static final String CALCULATE_INTEREST = "DM.calculateInterest";
        public static final String COMPUTE_REGIME_REGISTRATION_COMPLIANCE = 
            "DM.computeRegimeRegistrationCompliance";
        public static final String GENERATE_AUTO_ASSESMENT = 
            "DM.generateEstimatedAssessment";
        public static final String COMPUTE_NON_FILE_COMPLIANCE = 
            "DM.computeNonfileCompliance";
        public static final String COMPUTE_NON_PAY_COMPLIANCE = 
            "DM.computeNonPayCompliance";
        public static final String COMPUTE_TP_REGISTRATION_COMPLIANCE = 
            "DM.computeTPRegistrationCompliance";
        public static final String VALIDATE_DOCUMENT = "DM.validate";
        public static final String REGIME_DUPLICATE_CHECK = 
            "DM.checkRegimeAccountDuplicate";
        public static final String DECLARATION_ITEM_COUNT = "DM.itemCount";
    }

    public interface DType {
        public static final String ENTACC = "ENTACC";
        public static final String CUSTACC = "CUSTACC";
        public static final String REVACC = "REVACC";
        public static final String PERIODACC = "PERIODACC";
        public static final String REFUNDCLAIM = "REFUNDCLAIM";
        public static final String DOCUMENT = "DOCUMENT";
    }
    
    public interface RegistrationStatus {
            public static String DE_REGISTRATION = "DE-REG";
            public static String PENDING_DE_REGISTRATION = "PEND-DEREG";
            public static String RE_ACTIVATION = "REACT";
            public static String REGISTRATION = "REG";
            public static String RE_REGISTRATION = "RE-REG";
            public static String SUSPENSION = "SUSP";
    }

     // all of the document types (On the ddoc_document table)
    public interface EventTypes {
      public static final String AMEND = "EVT_AMND";
      public static final String APPROVE = "EVT_APPR";
      public static final String AWAIT_INSPECTION = "EVT_AWT_INSPCTN";
      public static final String CALCULATE_TAX = "EVT_CALC_TAX";
      public static final String CANCEL = "EVT_CANCEL";
      public static final String CHECK_ITEM = "EVT_CHK_ITM";
      public static final String CREATE_CASE = "EVT_CREATE_CASE";
      public static final String DEREGISTER = "EVT_DEREG";
      public static final String GEN_AAR = "EVT_GEN_AAR";
      public static final String GEN_ATR = "EVT_GEN_ATR";
      public static final String GEN_MRN = "EVT_GEN_MRN";
      public static final String GOODS_RELEASE = "EVT_GOODS_RLSD";
      public static final String GOODS_SIZED = "EVT_GOODS_SZD";
      public static final String HUMAN_INTERVENTION = "EVT_HUMAN";
      public static final String GUARANTEE_LOCKED = "EVT_LCK_GUA";
      public static final String LEDGER_POSTED = "EVT_POST_LDGR";
      public static final String PAYMENT_ACCEPTED = "EVT_PYMNT_ACC";
      public static final String RAISE_OFFENCE = "EVT_RAISE_OFNCE";
      public static final String REGISTER = "EVT_REG";
      public static final String RELEASE = "EVT_REL";
      public static final String RISK_ANAL = "EVT_RISK_ANAL";
      public static final String REJECT = "EVT_RJCT";
      public static final String RUN_TAD_REPORT = "EVT_RUN_TAD_RPT";
      public static final String SAVE = "EVT_SAVE";
      public static final String SAVE_WITH_ERR = "EVT_SAVE_ERR";
      public static final String SUBMIT = "EVT_SUB";
      public static final String UPDATE = "EVT_UPD";
      public static final String UPLIFT = "EVT_UPLIFT";
      public static final String VALIDATE = "EVT_VAL";
      public static final String WITHDRAWN = "EVT_WITHDRAWN";
      public static final String ADJUSTMENT = "EVT_ADJ";
     public static final String CREATE_DOC_CHARG_FILE_RETURNS = "CREATE_DOC_CHARG_FILE_RETURNS";
     public static final String LODGEMENT = "LODGEMENT";
     public static final String MANUAL_PENALTY = "MANUAL_PENALTY";
     public static final String EXEMPTIONS = "EXEMPTIONS";
    public static final String APPROVE_EXEMPTION = "APPROVE_EXEMPTION";
    public static final String CANCEL_EXEMPTION = "CANCEL_EXEMPTION";
    public static final String REJECT_EXEMPTION = "REJECT_EXEMPTION";
    public static final String SUSPEND_EXEMPTION = "SUSPEND_EXEMPTION";
    public static final String REACTIVATE_EXEMPTION = "REACTIVATE_EXEMPTION";
    public static final String CREATE_INSTALMENT = "CREATE_INSTALMENT";
    public static final String CANCEL_INSTALMENT = "CANCEL_INSTALMENT";
    public static final  String OFFICER_ASSESSMENT = "OFFICER_ASSESSMENT";
        
    
    }
    
    public interface EventCategoryTypes {
        public static final String RET_SAVE_WITH_ERRORS = "RET_SAVE_WITH_ERRORS";
        public static final String RET_ADJUST_RETURNS = "RET_ADJUST_RETURNS";
        public static final String RET_FILE_RETURNS = "RET_FILE_RETURNS"; //CHECK_LATEFILE
        public static final String COMP_CHECK_LATEFILE = "COMP_CHECK_LATEFILE";
        public static final String COMP_CHECK_LATEPAY = "COMP_CHECK_LATEPAY";
        public static final String COMP_CHECK_NONFILE = "COMP_CHECK_NONFILE";
        public static final String COMP_CHECK_NONPAY = "COMP_CHECK_NONPAY";
        public static final String RET_LODGEMENT = "RET_LODGEMENT";
        public static final String RET_CANCELLATION = "RET_CANCELLATION";
        public static final String COLL_RECEIVE_PAYMENT ="COLL_RECEIVE_PAYMENT";
        public static final String ACC_ACCOUNT_ADJUSTMENT ="ACC_ACCOUNT_ADJUSTMENT";
        public static final String ACC_CREDIT_ALLOCATION ="ACC_CREDIT_ALLOCATION";
        public static final String COLL_REVERSE_PAYMENT = "COLL_REVERSE_PAYMENT";
        public static final String ACC_DISHONOUR_PAYMENT = "ACC_DISHONOUR_PAYMENT";
        
    }
    public interface CategoryTypes {
     public static final String EVTDOC = "EVT_DOC";
     public static final String EVTREG = "EVT_REG";
    }

    public interface DocumentDTypes {
        public static final String ACCADJUSTMENT = "ACCADJUSTMENT";
        public static final String CARGOMANIFEST = "CARGOMANIFEST";
        public static final String DECLARE = "DECLARE";
        public static final String DOM_EXC = "DOM_EXC";
        public static final String REFUNDCLAIM = "REFUNDCLAIM";
        public static final String REVENUECOLLECTIONRECEIPT = 
            "REVENUECOLLECTIONRECEIPT";
        public static final String CIT = Regimes.CIT;
        public static final String FOF = Regimes.FOF;
        public static final String IIT = Regimes.IIT;
        public static final String PAYE = Regimes.PAYE;
        public static final String VAT = Regimes.VAT;
        public static final String WIT = Regimes.WIT;
        public static final String FBT = Regimes.FBT;
        public static final String INSTAL_AGREEMENT = "INSTAL_AGREEMENT";
    }

    public static final long MILI_SEC_PER_DAY = 1000 * 60 * 60 * 24;
    public static final String PERCENTAGE = "Percentage";
    public static final String FIXED_AMOUNT = "FIXED_AMOUNT";    

    public interface ContactType {
        public static final String PHONE = "Phone";
        public static final String FAX = "Fax";
        public static final String MOBILE = "Mobile";
        public static final String EMAIL = "Email";
        public static final String LETTER = "Letter";
        public static final String WEBSITE = "Website";
    }
    
    public interface ContactPurpose {
        public static final String BUSINESS = "BUSINESS";
        public static final String HOME = "HOME";
        public static final String PERSONAL = "PERSONAL";
    }

    public interface GuiModes {
        public static final String ADD = "ADD";
        public static final String EDIT = "EDIT";
        public static final String VIEW = "VIEW";
        public static final String DELETE = "DELETE";
    }

    public interface DocumentType {
        public static final String INDIVIDUAL_REGISTRATION = 
            "Individual registration";
        public static final String ORGANISATION_REGISTRATION = 
            "Organisation registration";
        public static final String ACCOUNT_ADJUSTMENT = "ACCOUNT_ADJUSTMENT";
        public static final String CREDIT_ALLOCATION = "CREDIT_ALLOCATION";
        public static final String RETURN = "RETURN";
        public static final String PAYMENT = "RECEIPT";
        public static final String EMPLOYERPAYEMONTHLYRETURN = "EmployersPAYEMonthlyReturn";
        public static final String PAYERETURNANNUAL = "PAYEReturn-Annual";
        public static final String WITHHOLDING_TAXRETURN = "WithholdingTaxReturn";
        public static final String PROVISIONAL = "Provisional";
        public static final String FINAL = "Final";
        public static final String PROVISIONAL_FORMTYPE = "(Provisional)";
        public static final String QUARTERLYPETROLEUMINCOMETAXRETURN = "QuarterlyPetroleumIncomeTaxReturn";
        public static final String MONTHLYGASROYALTYRETURN = "MonthlyGasRoyaltyReturn";
        public static final String MONTHLYPETROLEUMROYALTYRETURN = "MonthlyPetroleumRoyalyReturns";
        public static final String COMMUNICATIONSERVICERETURN = "CommunicationServiceReturn";
        public static final String EXCISEDUTYRETURN = "ExciseDutyReturn";
        public static final String VATNHILSTANDARDRATE = "VATNHILStandardRate";
        public static final String PAYERETURN_ANNUAL = "PAYEReturn-Annual";
        public static final String VATNHILANDCSTRETURN = "VATNHILAndCSTReturnForImportedServices";
        public static final String INSTALMENT_AGREEMENT = "INSTALMENT_AGREEMENT";
        public static final String MANUAL_PENALTY = "MANUAL_PENALTY";
	public static final String EXEMPTION_APPLICATION = "ExemptionApplication";
        public static final String REFUND_CLAIM = "REFUND_CLAIM";
        public static final String OFFICER_ASSESSMENT = "OFFICER_ASSESSMENT";
        public static final String COMP_EST_ASSESS = "COMP_EST_ASSESS";
    }

    public interface DocumentCategory {
        public static final String DEBTMGMT = "DEBTMGMT";
        public static final String RETURN = "RET";
    }

    public interface TransactionClass {
        public static final String INVOICE = "Invoice";
        public static final String DM = "Dm";
        public static final String CM = "Cm";
        public static final String COLLECTION = "Collection";
        public static final String REV = "Rev";
    }

    public interface ExceptionHandling {
        public static final String ISNULL = "is NULL";
        public static final String NORESULT = "No results found for ";
        public static final String WHERE = " where ";
        public static final String EQUAL = " = ";
        public static final String SEARCH_CRITERIA = " the search criteria";
        public static final String OBJECT_NOT_FOUND = "Object Not Found";
        public static final String REMOTE_FAULT = "REMOTE_FAULT";
        public static final String TRIPS_CATCHALL = "TRIPS_CATCHALL";
        public static final String TRIPS_GENERIC_NOTIFICATION = "Generic.bpel.Notification";
        public static final String GLOBAL_BPEL_GENERIC_NOTIFICATION = "Global.bpel.GenericNotification";

        public static final String PARSE_EXCEPTION = "PARSE_EXCEPTION";
    }

    public interface TranLinkType {
        public static final String POSTPAY = "POSTPAY";
        public static final String POSTDM = "POSTDM";
        public static final String POSTCM = "POSTCM";
        public static final String REVERSEREC = "REVERSEREC";
    }

    public interface TableColumn {
        public static final String CUSTOMS_REFERENCE = "CUSTOMS_REFERENCE";
        public static final String REVENUE_TYPE = "REVENUE_TYPE";
        public static final String REVENUE_DESC = "REVENUE_DESC";
        public static final String ACCT_NO = "ACCT_NO";
        public static final String PERIOD_NO = "PERIOD_NO";
        public static final String PERIOD_YEAR = "PERIOD_YEAR";
        public static final String TRANSACTION_TYPE = "TRANSACTION_TYPE";
        public static final String ID = "ID";
        public static final String PRODUCT_ID = "PRODUCT_ID";
        public static final String COMMODITY_DESCRIPTION = 
            "COMMODITY_DESCRIPTION";
        public static final String REVENUE_ACCOUNT_ID = "REVENUE_ACCOUNT_ID";
        public static final String AMOUNT = "AMOUNT";
        public static final String ENTITY_ID = "ENTITY_ID";
        public static final String DOCUMENT_REFERENCE = "DOCUMENT_REFERENCE";
        public static final String DOCUMENT_TYPE = "dType";
        public static final String DOC_TYPE = "DOC_TYPE";
        public static final String DOC_STATUS="DOC_STATUS";
        public static final String SUBMISSION_DATE="SUBMISSION_DATE";
        public static final String STATUS="STATUS";
        public static final String DOCUMENT_ID="DOCUMENT_ID";
        public static final String FORM_TYPE="FORM_TYPE";
        public static final String EFFECTIVE_DATE="EFFECTIVE_DATE";
        public static final String ASSIGNED_BY="FORM_TYPE";
        public static final String CASE_TYPE_CODE="CASE_TYPE_CODE";
        public static final String CASE_NUMBER="CASE_NUMBER";
        public static final String CASE_TITLE="CASE_TITLE";
        public static final String OFFICE_DESC="OFFICE_DESC";
        public static final String CASE_STATUS_CODE="CASE_STATUS_CODE";
        public static final String CASE_OUTCOME_CODE="CASE_OUTCOME_CODE";
        public static final String CASE_CREATED_DATE="CASE_CREATED_DATE";
        public static final String BALANCE="BALANCE";
        public static final String USERNAME="USERNAME";
    }

    public interface Bpels {
        public static final String REGISTER_INDIVIDUAL = "TripsRegIndividual";
        public static final String REGISTER_INDIVIDUAL_NF = "TripsRegIndividualNF";
                
        public static final String REGISTER_ORGANIZATION = "TripsRegOrg";
        public static final String REGISTER_ORGANIZATION_NF = "TripsRegOrgNF";
        public static final String UPDATE_INDIVIDUAL = 
            "TripsUpdIndividualEntity";
        public static final String UPDATE_INDIVIDUAL_NF = 
            "TripsUpdIndividualEntityNF";    
        public static final String UPDATE_ORGANIZATION = 
            "TripsUpdateOrganisation";
        public static final String REGISTER_REGIME = "TripsRegisterRegimeAcct";
                public static final String REGISTER_REGIME_NF = "TripsRegisterRegimeAcctNF";
        public static final String DEREGISTER_REGIME = "TripsDeregisterRegime";
       // public static final String DEREGISTER_TAXPAYER_ACCOUNT = "TripsDeregisterAcct";
       // public static final String DEREGISTER_TAXPAYER_ACCOUNT = "TripsDeregister";
        public static final String DEREGISTER_TAXPAYER_ACCOUNT = "TripsDeregisterTaxpayer";  
        public static final String RE_REGISTER_REGIME = "TripsReRegRegimeNF";
        public static final String RE_REGISTER_TAXPAYER = "TripsReRegTaxpayer";
        public static final String RE_ACTIVATE_REGIME = 
            "TripsReactivateRegime";
        public static final String RE_ACTIVATE_REGIME_NF = "TripsReactivateRegimeNF";    
        public static final String SUSPEND_REGIME = "TripsSuspendRegimeNF";
        //        public static final String TRANSFER_TAXPAYER = "TripsTransferTaxpayer";
        public static final String TRANSFER_TAXPAYER = 
            "TripsTransferTaxpayerAndRelatedEntities";
        public static final String TRANSFER_TAXPAYER_NF = "TripsTransferTaxpayerAndRelatedEntitiesNF";
        public static final String TRANSFER_PAYMENT = 
            "TripsTPTransferPaymentCredit";
        public static final String DEREGISTER_TAX_ACCOUNT = 
            "TripsDeRegisterRegimeNF";


        public static final String TAX_RETURNS = "TripsFlexiTaxReturn";
        public static final String FOF = "TripsFOfEntry";
        public static final String PROCESS_INSPECTION = 
            "TripsProcessInspection";
        public static final String PROCESS_DECLARATION = 
            "TripsProcessDeclaration";
        public static final String WITHDRAW_DECLARATION = "TripsWithdrawDecl";
        public static final String ENTER_AMEND_DECLARATION = 
            "TripsEnterAmendDecl";
        public static final String RELEASE_GOODS = "TripsPerformClearance";
        public static final String PROCESS_OFFENCE = "TripsProcessOffence";
        public static final String PROCESS_AUCTION = "TripsProcessAuction";
        public static final String RECEIVE_PAYMENTS = "TripsRecievePayments";
        public static final String REVERSE_PAYMENTS = "TripsReversePayment";
        public static final String TAX_PAYER_ACCT_ADJ = 
            "TripsTPAccountAdjustments";
        public static final String TAX_PAYER_ITEM_ADJ = "TripsItemAdjustment";
        public static final String MULTIPLE_TAX_COMPLIANCE = 
            "TripsPerformMultipleTaxCompliance";
        public static final String PERFORM_NONCOMPLIANCE = 
            "TripsPerformNonCompliance";
        public static final String PROCESS_TAX_REFUND = "TripsTaxRefund";
        public static final String GENEDARE_PERIOD = "TripsGeneratePeriods";
        public static final String AUTHORISE_TAX_REFUND = 
            "TripsAuthoriseRefundClaims";
        public static final String ENTER_TAX_REFUND = "TripsEnterRefundClaim";
        public static final String INTELLIGENCE = "TripsIntelligence";
        public static final String VALUATION = "TripsMaintainValuation";
        public static final String INTELLIGENCE_SUSPECT = 
            "TripsMaintainSuspectEntity";
        public static final String MAINTAIN_INSPECTION = 
            "TripsMaintainInspection";
        public static final String CARGO_MANIFEST = "TripsSubmitManifest";
        public static final String PROCESS_EXEMPTION = 
            "TripsMaintainExemption";
        public static final String ASSIGN_CASE = "TripsAssignCase";
        public static final String PROCESS_CASE_MANAGEMENT = 
            "TripsCreateMaintainCase";
        public static final String PROCESS_OBJECTIONS_APPEALS = 
            "TripsObjectionsAndAppeals";
        public static final String RECONCILE_MANIFEST = 
            "TripsReconcileManifest";
        public static final String MAINTAIN_APPLICATION = 
            "TripsMaintainApplication";
        public static final String MAINTAIN_GUARANTEE = 
            "TripsMaintainGuarantee";
        public static final String PROCESS_INSTALMENT_AGREEMENT = 
            "TripsProcessInstalmentAgreement";
        public static final String CALCULATE_INSTALMENT_AMOUNT = 
            "TripsCalculateInstalments";
        public static final String CALCULATE_PENALTY_AND_INTEREST = 
            "TripsCalculatePenaltyAndInterest";
        public static final String PROCESS_CANCEL_INSTALMENT_AGREEMENT = 
            "TripsCancelInstalmentAgreement";
        public static final String PROCESS_GUARANTEE_USAGE = 
            "TripsProcessGuaranteeUsage";
        public static final String PROCESS_GUARANTEE_RELEASE = 
            "TripsReleaseGuarantee";
        public static final String RECEIVE_BATCH_PAYMENTS = 
            "TripsBatchPayment";
        public static final String TAX_RETURN_BATCH = 
            "TripsBatchTaxReturn";
        public static final String UPDATE_DATE_JOB = 
            "TripsJobInitiator";
        public static final String TRIPS_PERFORM_TP_REG_COMPLIANCE = 
                    "TripsPerformTPRegCompliance";
                    
        public static final String BATCH_TRANSFER = 
            "TripsSynBatchTransfer";
        public static final String BATCH_TRANSFER_Asyn = 
            "TripsAsynBatchTransfer";
        public static final String ACCOUNTING_ADJUSTMENTS = 
            "TripsAccountAdjustment";
        public static final String CREDIT_ALLOCATION = "TripsCreditAllocation";
        public static final String CASH_TILL_ALLOCATION = "TripsCashTillAllocation";
        public static final String LODGMENT_PROCESSING_NF = "TripsLodgementProcessingNF";
        public static final String RETURNS_PAYE_PROCESSING_NF = "TripsReturnsPAYEProcessingNF";
//      public static final String CASE_TASK = "TripsCaseTask";
        public static final String CASE_CREATE_UPDATE = "TripsCreateMaintainCaseNF";
        public static final String EXEMPTION_APPLICATION_PROCESSING_NF = "TripsExemptionAppProcessingNF";
        public static final String MANUAL_PENALTY = "TripsManualPenalty";
        public static final String TRIPS_REFUNDS_PROCESS = "TripsRefundsProcess";
        public static final String DEBT_CASE_CREATE_UPDATE = "TripsDeptManagementNF";
        
    }

    public static final String CASTOR_MAPPING_FILE = "castor.mapping.xml";

    public interface TypesPackages {
        public static final String REGISTRATION = "registration";
        public static final String TAX_RETURN = "taxreturns";
        public static final String CORE = "core";
        public static final String DECLARATION = "declaration";
        public static final String CUSTOMSCONTROL = "customscontrol";
        public static final String OFFENCE = "offence";
        public static final String AUCTION = "auction";
        public static final String RELEASE_GOODS = "releasegoods";
        public static final String COLLECTION = "collection";
        public static final String ENTITY_REGIME_ACCT = 
            "entityandregimeaccounting";
        public static final String TAX_COMPLIANCE = "multipletaxcompliance";
        public static final String TAX_REFUND = "taxrefund";
        public static final String RISKANDINTELLIGENCE = "riskandintelligence";
        public static final String GENERIC = "generic";
        public static final String CARGO_MANIFEST = "manifest";
        public static final String EXEMPTION = "exemption";
        public static final String CASE_MANAGEMENT = "casemanagement";
        public static final String OBJECTIONS_APPEALS = "objectionsandappeals";
        public static final String REGIME_ACCOUNT_COMPLIANCE = 
            "regimeaccountcompliance";
        public static final String CUSTOMS_SUPPORT = "customssupport";
        public static final String APPLICATION = "application";
        public static final String GUARANTEE = "guarantee";
        public static final String REVENUE_DEFERMENT = "revenuedeferment";
        public static final String CONFIGURATION = "configuration";

    }

    public interface DropDownListType {
        public static final String FUNCTIONAL_ROLE = "FUNCTIONAL_ROLE";
    }

    public interface DropDownOnGenericSearch {

        public static final String MESSAGE_TYPE_ACT_LOG = 
            "MESSAGE_TYPE_ACT_LOG";
        public static final String REVENUE_TYPE = "POPULATE_REVENUE_TYPE";
        public static final String TRANSACTION_TYPE = 
            "POPULATE_TRANSACTION_TYPE";
        public static final String DOCUMENT_STATUS = 
            "POPULATE_DOCUMENT_STATUS";
        public static final String DECLARATION_REGIME = 
            "POPULATE_DECLARATION_REGIME";
        public static final String TAXPAYER_TYPE = "POPULATE_TAXPAYER_TYPE";
        public static final String CASE_TYPE = "POPULATE_CASE_TYPE";

        public static final String CASE_OFFICER = "CASE_OFFICER";
        public static final String DETECTING_OFFICER = "DETECTING_OFFICER";
        public static final String OFFENCE_OFFICER = "OFFENCE_OFFICER";
        public static final String REQUESTING_OFFICER = "REQUESTING_OFFICER";

        public static final String SUSPECT_TYPE = "SUSPECT_TYPE";
        public static final String RUMMAGE_OUTCOME = "RUMMAGE_OUTCOME";

        public static final String GOODS_LOCATION = "GOODS_LOCATION";
        public static final String OFFENCE_STATUS = "OFFENCE_STATUS";
        public static final String COUNTRY_LIST = "COUNTRY_LIST";

        public static final String SUSP_OUTCOME = "SUSP_OUTCOME";
        public static final String SUSP_REASON = "SUSP_REASON";

        public static final String LEGAL_STATUS = "LEGAL_STATUS";
        public static final String LINE_OF_BUSINESS = "LINE_OF_BUSINESS";

        public static final String AIRCRAFT_TYPE = "AIRCRAFT_TYPE";
        public static final String SHIPPING_LINE = "SHIPPING_LINE";
        public static final String CONTAINER_TYPE = "CONTAINER_TYPE";
        public static final String MEASUREMENT = "MEASUREMENT";
        public static final String VEHICLE_TYPE = "VEHICLE_TYPE";
        public static final String VESSEL_TYPE = "VESSEL_TYPE";
        public static final String PORT_OF_REGISTRATION = 
            "PORT_OF_REGISTRATION";
        public static final String YES_NO_DROPDOWN = "YES_NO_DROPDOWN";
        public static final String TRANSPORT_MODE = "TRANSPORT_MODE";
        public static final String CURRENCIES = "CURRENCIES";
        public static final String PORTS = "PORTS";
        public static final String CARRIER_LIST_AIR = "CARRIER_LIST_AIR";
        public static final String CARRIER_LIST_SEA = "CARRIER_LIST_SEA";
        public static final String FIND_LOCATIONS = "FIND_LOCATIONS";
        public static final String NATIONALITY_LIST = "NATIONALITY_LIST";
        public static final String SEIZURE_REASON_LIST = "SEIZURE_REASON_LIST";
        public static final String SOURCE_LIST = "SOURCE_LIST";
        public static final String TRANSPORT_MODE_LIST = "TRANSPORT_MODE_LIST";
        public static final String AIRLINE_STATUS_LIST = "AIRLINE_STATUS_LIST";
        public static final String AIRLINE_LIST = "AIRLINE_LIST";
        public static final String CONTAINER_STATUS = "CONTAINER_STATUS";
        public static final String FREE_ZONE_CONTROL_TYPE = 
            "FREE_ZONE_CONTROL_TYPE";
        public static final String WAREHOUSE_TYPE_LIST = "WAREHOUSE_TYPE_LIST";
        public static final String APPLICATION_TYPE_LIST = 
            "APPLICATION_TYPE_LIST";
        public static final String OFFENCE_TYPE_LIST = "OFFENCE_TYPE_LIST";
        public static final String MODULES_LIST = "MODULES_LIST";
        public static final String COMPUTATION_METHOD_LIST = 
            "COMPUTATION_METHOD_LIST";
        public static final String COMPUTATION_TYPE_LIST = 
            "COMPUTATION_TYPE_LIST";
        public static final String DOC_TYPE_LIST = "DOC_TYPE_LIST";
        public static final String DOC_CATEGORY_LIST = "DOC_CATEGORY_LIST";
        public static final String GUARANTEE_TYPE_LIST = "GUARANTEE_TYPE_LIST";
        public static final String COMPLIANCE_TYPE_LIST = 
            "COMPLIANCE_TYPE_LIST";
        public static final String NPORNF_COMPLIANCE_TYPE_LIST = 
            "NPORNF_COMPLIANCE_TYPE_LIST";
        public static final String USER_OFFICE_LIST = "USER_OFFICE_LIST";
        public static final String CREATED_BY = "CREATED_BY";
        public static final String DJOB_BATCH_LIST = "DJOB_BATCH_LIST";
        public static final String GUARANTEE_USAGE_TYPE = 
            "GUARANTEE_USAGE_TYPE";
        public static final String COMMODITY_LIST = "COMMODITY_LIST";
        public static final String DOC_CATG_LIST = "DOC_CATG_LIST";
        public static final String DOC_TEMPLATE_LIST = "DOC_TEMPLATE_LIST";
        public static final String TAX_RATE_TABLE_LIST = "TAX_RATE_TABLE_LIST";
        public static final String FLEXIBLE_FORM_TYPE_LIST = 
            "FLEXIBLE_FORM_TYPE_LIST";
        public static final String BATCH_FORM_TYPE = "BATCH_FORM_TYPE";
        public static final String TAX_TYPE_WITHOUT_TAXPAYER = 
            "TAX_TYPE_WITHOUT_TAXPAYER";
        public static final String LEGAL_STATUS_TYPE_ORGANISATION 
                                            = "LEGAL_STATUS_TYPE_ORGANISATION";
        public static final String LEGAL_STATUS_TYPE_INDIVIDUAL 
                                            = "LEGAL_STATUS_TYPE_INDIVIDUAL";
        public static final String TAX_TYPE_BY_TAXPAYER = "TAX_TYPE_BY_TAXPAYER";
        public static final String PERIOD_BY_TAXPAYER = "PERIOD_BY_TAXPAYER";
        public static final String TRANSACTION_TYPE_FOR_PAYMENT_ALLOCATION 
                                = "TRANSACTION_TYPE_FOR_PAYMENT_ALLOCATION";
        public static final String CASE_TYPE_LIST = "CASE_TYPE_LIST";
        public static final String CASE_TYPE_LIST_FOR_CASE_GENERAL = "CASE_TYPE_LIST_FOR_CASE_GENERAL";
        public static final String OFFICE_LIST = "OFFICE_LIST";
        public static final String CASE_OUTCOME_LIST = "CASE_OUTCOME_LIST";
        public static final String CASE_RELATED_DOC_TYPE = "CASE_RELATED_DOC_TYPE";
        public static final String CASE_OUTCOME_LIST_FIND_CASE = "CASE_OUTCOME_LIST_FIND_CASE";
        public static final String CASE_STATUS_LIST = "CASE_STATUS_LIST";
		public static final String REF_FREQUENCY_LIST = 
            "REF_FREQUENCY_LIST";
        public static final String BUSINESS_SECTOR_LIST = "BUSINESS_SECTOR_LIST";
    }
    public static final String PAYLOAD = "payload";

    public interface ReasonCategory {
        public static final String ENT_DE_REGISTER = "ENT_DE_REGISTER";
        // 21/04/2011 - for de-registration reason dropdown (TRGHA-1333)        
        public static final String ORG_DE_REGISTER = "ORG_DE_REGISTER";
        public static final String IND_DE_REGISTER = "IND_DE_REGISTER";
        public static final String MISC_DE_REGISTER = "MISC_DE_REGISTER";
        //TRGHA-12196 - for de-registration reason dropdown    
        public static final String ORG_LEGAL_STATUS_DE_REGISTER = "ORG_LEGAL_STATUS_DE_REGISTER";
        public static final String IND_SOLE_DE_REGISTER = "IND_SOLE_DE_REGISTER";
        
        public static final String ENT_RE_REGISTER = "ENT_RE_REGISTER";
        public static final String REG_RE_ACTIVATE = "REG_RE_ACTIVATE";
        public static final String REG_SUSPEND = "REG_SUSPEND";
        public static final String REG_RE_REGISTER = "REG_RE_REGISTER";
        public static final String PAY_REVERSAL = "PAY_REVERSAL";
        public static final String DEC_WITHDRAWAL = "DEC_WITHDRAWAL";
        public static final String REJECT_REFUND = "REJECT_REFUND";
        public static final String REMIT_OFFENCE = "REMIT_OFFENCE";
        public static final String REJECT_GUARANTEE = "REJECT_GUARANTEE";
        public static final String CANCEL_GUARANTEE = "CANCEL_GUARANTEE";
        public static final String TAXPAYER_TRANSFER = "TAXPAYER_TRANSFER";
        public static final String TAXPAYER_UPDATE = "TAXPAYER_UPDATE";
        public static final String ACCOUNTING_ADJUSTMENT = 
            "ACCOUNTING_ADJUSTMENT";
        public static final String RECEIVE_PAY = "RECEIVE_PAY";
        public static final String REFUND_REASON = "REFUND_REASON";
        public static final String ACQUIRED_ASSETS = "ACQUIRED_ASSETS";
        public static final String TAX_CLR_CERT = "TAX_CLR_CERT";
        public static final String DATE_MANAGEMENT_REASON_HOLIDAY = "DATE_MGT_REASON_HD";
        public static final String DATE_MANAGEMENT_REASON_LEGISLATIVE = "DATE_MGT_REASON_LD";
        public static final String REFUND_DISAPPROVAL_CASES = "REFUND_DISAPPROVAL_CASES";
        public static final String APP_REASON_SUSP = "APP_REASON_SUSP";
        public static final String REG_DE_REGISTER_REVISION = "REG_DE_REGISTER_REVISION";
        public static final String TAXPAYER_TRANSFER_IND = "TAXPAYER_TRANSFER_IND";
        public static final String TAXPAYER_TRANSFER_ORG = "TAXPAYER_TRANSFER_ORG";
        
        public static final String REG_SUSPENTION = "REG_SUSPENTION";
        
        // 26/04/2011 - for amendmend reason dropdown (TRGHA-1284)        
        public static final String SP_AMENDMENT = "SP_AMENDMENT";
        public static final String IND_AMENDMENT = "IND_AMENDMENT";
        public static final String REG_SUSPEND_IND = "REG_SUSPEND_IND";
        public static final String REG_SUSPEND_ORG = "REG_SUSPEND_ORG";
        public static final String MISCELLANEOUS_ORGANIZATION = "MISCELLANEOUS_ORGANIZATION";
        public static final String ORGANIZATION_UPDATE = "ORGANIZATION_UPDATE";
        public static final String ORG_AND_MISC = "ORG_AND_MISC";
        
        public static final String ACC_ADJUSTMENT_REVISE = "ACC_ADJUSTMENT_REVISE";
        public static final String ACC_ADJUSTMENT_REJECT = "ACC_ADJUSTMENT_REJECT";
        public static final String CREDIT_ALLOCATION_REJECT = "CREDIT_ALLOCATION_REJECT";
        public static final String CREDIT_ALLOCATION_REVISE = "CREDIT_ALLOCATION_REVISE";
        public static final String TILL_ALLOCATION_REJECT = "TILL_ALLOCATION_REJECT";
        public static final String TILL_ALLOCATION_REJECT_SUSPEND = "TILL_ALLOCATION_REJECT_SUSPEND";
        public static final String TAX_RETURN_REJECT = "TAX_RETURN_REJECT";
        public static final String EXEMPTION_APP_CANCEL="EXEMPTION_APP_CANCEL";
        public static final String EXEMPTION_APP_REJECT="EXEMPTION_APP_REJECT";
        public static final String EXEMPTION_APP_SUSPEND="EXEMPTION_APP_SUSPEND";
        public static final String EXEMPTION_APP_REACTIVE="EXEMPTION_APP_REACTIVE";
        public static final String INSTAL_AGREEMENT_REASON="INSTAL_AGREEMENT_REASON";
        public static final String MANUAL_PENALTY_REJECT="MANUAL_PENALTY_REJECT";
        public static final String REFUND_REJECT_REASON="REFUND_REJECT";
        public static final String INSTAL_AGEEMENT_REJECT_REASON="INSTAL_AGEEMENT_REJECT";
        public static final String COMPLIANCE_BREACH =  "COMPLIANCE_BREACH";
        public static final String OBJECTION_REJECTION_REASON =  "OBJECTION_REJECTION_REASON";
        public static final String APPEAL_REJECTION_REASON =  "APPEAL_REJECTION_REASON";
        public static final String AUDIT_CASE_CLOSURE_REJECTION_REASON="AUDIT_CASE_CLOSURE_REJECTION_REASON";
        public static final String CASE_CLOSURE_REJECTION_REASON="CASE_CLOSURE_REJECTION_REASON";
        public static final String CASE_CLOSE_REASON="CASE_CLOSE_REASON";
        public static final String AUDIT_CASE_CLOSURE_REASON="AUDIT_CASE_CLOSURE_REASON";
        public static final String ESCALATION_REASON="ESCALATION_REASON";
        public static final String WRITEOFF_REASON="WRITEOFF_REASON";  
       }

    public interface TransactionTypeCategory {
        public static final String ACCOUNT_ADJUSTMENT = "ACCADJ";
    }

    public interface SystemParameterCode {
        //Local currency of a country
        public static final String CURRENCY = "CURRENCY";
        public static final String DEFAULT_CASE_STATUS = "DEFAULT_CASE_STATUS";
        //Base currency of a country
        public static final String BASE_CURRENCY = "BASE_CURRENCY";
        public static final String BUILD = "BUILD";
        public static final String REPORT_LOCATION = "REPORT_LOC_TETS";
        public static final String OFFICE_CODE = "OFFICE_CODE";
        public static final String REPORT_SERVER_ADMIN_USER = 
            "REPORT_SERVER_ADMIN_USER";
        public static final String REPORT_SERVER_ADMIN_PASSWORD = 
            "REPORT_SERVER_ADMIN_PASSWORD";
        public static final String SQL_FETCH_SIZE = "SQL_FETCH_SIZE";
        public static final String IDENTIFICATION_VALIDATION = 
            "IDENTIFICATION_VALIDATION";
        public static final String ENABLE_OFFICE_SECURITY = 
            "ENABLE_OFFICE_SECURITY";
        public static final String BASE_COUNTRY = "BASE_COUNTRY";
        public static final String GRA_REVENUE_SUSPENSE_ACCOUNT = "GRA Revenue Suspense Account";
        public static final String BASE_COUNTRY_DESC = "BASE_COUNTRY_DESC";
        public static final String DEV_BUILD = "DEV_BUILD";
        public static final String TIN_PATTERN_DIGIT_COUNT = 
            "TIN_PATTERN_DIGIT_COUNT";
        public static final String TIN_PATTERN_SEPARATOR = 
            "TIN_PATTERN_SEPARATOR";
        public static final String TIN_NUMBER_OF_CHARACTERS = 
            "TIN_NUMBER_OF_CHARACTERS";
        public static final String DEFAULT_DATE_FORMAT = 
            "DEFAULT_DATE_FORMAT";
        public static final String TIN_BRANCH_SEPARATOR = 
            "TIN_BRANCH_SEPARATOR";
        public static final String LOAD_GENERIC_SEARCH_FROM_DB = "LOAD_GENERIC_SEARCH_FROM_DB";
        public static final String LOAD_MENU_FROM_DB = "LOAD_MENU_FROM_DB";
        public static final String PRODUCT_VERSION = "PRODUCT_VERSION";
        String FLEXI_BATCH_LIMIT = "FLEXI_BATCH_LIMIT";
        public static final String DLN_SEQUENCE_LENGTH = "DLN_SEQUENCE_LENGTH";
        public static final String PASSWORD_PATTERN = "PASSWORD_VALID";
        
        //Code from Cayman
        public static final String AUTO_ALLOCATION_PAYMENT = "AUTO_ALLOCATION_PAYMENT";
        public static final String AUTO_ALLOCATION_DEBT = "AUTO_ALLOCATION_DEBT";
        //Code from Cayman
         public static final String GHANA = "GH";
         
        public static final String FISCAL_END_MONTH = "FISCAL_END_MONTH";  
        public static final String FISCAL_END_DAY = "FISCAL_END_DAY"; 
        public static final String REPORT_SHOULD_PRINT = "REPORT_SHOULD_PRINT";  
        public static final String SHOULD_ADD_DAY_IF_DUE_ON_HOLIDAY = "SHOULD_ADD_DAY_IF_DUE_ON_HOLIDAY";
        public static final String ALLOWABLE_ATTACHMENT_SIZE = "ALLOWABLE_ATTACHMENT_SIZE";
        public static final String CHAR_OF_ACCOUNTS_MAX_LEVELS = "CHAR_OF_ACCOUNTS_MAX_LEVELS";
        public static final String SCALE_OF_DECIMAL = "SCALE_OF_DECIMAL";
        
        public static final String GRA_ACCOUNT = "GRA_ACCOUNT";
        public static final String GRA_RL_SUSPENSE = "GRA_RL_SUSPENSE";
        public static final String NOTIFICATION_INTERVAL = "NOTIFICATION_INTERVAL";
        public static final String PRINT_NOTIFICATION = "PRINT_NOTIFICATION";
        public static final String SCHEDULE_COMPLIANCE_INTERVAL = "SCHEDULE_COMPLIANCE_INTERVAL";
        public static final String SCHEDULE_REPORT_PRINT = "SCHEDULE_REPORT_PRINT";
        public static final String REPORT_DEFAULT_DELAY = "REPORT_DEFAULT_DELAY";
        public static final String SCHEDULE_PERIOD_INTERVAL = "SCHEDULE_PERIOD_INTERVAL";
        public static final String CAN_PERIOD_SCHEDULER_RUN = "CAN_PERIOD_SCHEDULER_RUN";
        public static final String CAN_MISSING_PERIOD_SCHEDULER_RUN = "CAN_MISSING_PERIOD_SCHEDULER_RUN";
        public static final String SCHEDULE_MISSING_PERIOD_INTERVAL = "SCHEDULE_MISSING_PERIOD_INTERVAL";
        public static final String NO_OF_BACK_DATES = "NO_OF_BACK_DATES";
        public static final String RETURNS_TOLERANCE_LIMIT = "RETURNS_TOLERANCE_LIMIT";
        public static final String GRA_CYCLE_START_DAY = "GRA_CYCLE_START_DAY";
        public static final String GRA_CYCLE_END_DAY = "GRA_CYCLE_END_DAY";
        public static final String GRA_CYCLE_START_MONTH = "GRA_CYCLE_START_MONTH";
        public static final String GRA_CYCLE_END_MONTH = "GRA_CYCLE_END_MONTH";
        
        public static final String NUMERICAL_FIELD_LENGTH = "NUMERICAL_FIELD_LENGTH";
        
        public static final String NO_OF_EXTENSION_DAYS = "NO_OF_EXTENSION_DAYS";
        public static final String CURRENCY_POINT = "CURRENCY_POINT";
        public static final String PENALTY_POINT = "PENALTY_POINT";
        public static final String DOCUMENT_CATEGORY_LIST = "DOCUMENT_CATEGORY_LIST";
        
        public static final String CHEQUE_PRINT_FILE_PATH = "CHEQUE_PRINT_FILE_PATH";
        
        public static final String MAX_EXEM_PER_TAX_YEAR = "MAX_EXEM_PER_TAX_YEAR";
        public static final String CAN_INSTALMENT_AGREEMNET_COMPLIANCE_SCHEDULER_RUN = "CAN_INSTALMENT_AGREEMNET_COMPLIANCE_SCHEDULER_RUN";
        public static final String SCHEDULE_INSTALMENT_AGREEMNET_COMPLIANCE_INTERVAL = "SCHEDULE_INSTALMENT_AGREEMNET_COMPLIANCE_INTERVAL";
        public static final String DESK_AUDIT_THRESHOLD_MINIMUM = "DESK_AUDIT_THRESHOLD_MINIMUM";
        public static final String DESK_AUDIT_THRESHOLD_MAXIMUM = "DESK_AUDIT_THRESHOLD_MAXIMUM";
        public static final String SCHEDULE_REPORT_MAX_PRINT_ATTEMPTS="SCHEDULE_REPORT_MAX_PRINT_ATTEMPTS";
        public static final String DEBT_CASE_MINIMUM_VALUE ="DEBT_CASE_MINIMUM_VALUE";
        public static final String DEFAULT_COMPLIANCE_INDICATOR = "DEFAULT_COMPLIANCE_INDICATOR";
        public static final String OBJECTION_TIMESCALE_FOR_ESTIMATED_ASSESSMENT = "OBJECTION_TIMESCALE_FOR_ESTIMATED_ASSESSMENT";
        public static final String OBJECTION_TIMESCALE_FOR_NON_ESTIMATED_ASSESSMENT = "OBJECTION_TIMESCALE_FOR_NON_ESTIMATED_ASSESSMENT";
        
        public static final String APPEAL_LODGE_TIME_LIMIT = "APPEAL_LODGE_TIME_LIMIT";
        
        public static final String MAX_NO_OF_HITS = "MAX_NO_OF_HITS";
        public static final String MAX_NO_OF_AUDIT_REC_TO_DISPLAY = "MAX_NO_OF_AUDIT_REC_TO_DISPLAY";
        public static final String CAN_AUDIT_VIST_CASE_SCHEDULER_RUN = "CAN_AUDIT_VIST_CASE_SCHEDULER_RUN";
        public static final String SCHEDULE_AUDIT_VIST_CASE_CREATION_INTERVAL = "SCHEDULE_AUDIT_VIST_CASE_CREATION_INTERVAL";
        public static final String MAX_NO_OF_AUDIT_SYS_CASES_TO_CREATE = "MAX_NO_OF_AUDIT_SYS_CASES_TO_CREATE";
        public static final String MIN_NUM_HOLIDAYS_IN_TAXCYCLE = "MIN_NUM_HOLIDAYS_IN_TAXCYCLE";
        public static final String PRINT_QUEUE_SAVE_DAY_INTERVAL = "PRINT_QUEUE_SAVE_DAY_INTERVAL";
        public static final String PRINT_QUEUE_CLEAN_SCHEDULE_INTERVAL = "PRINT_QUEUE_CLEAN_SCHEDULE_INTERVAL";
        public static final String DB_MAINTENANCE_SCHEDULE_INTERVAL = "DB_MAINTENANCE_SCHEDULE_INTERVAL";
        public static final String SYS_USER_LOGIN_SAVE_DAY_INTERVAL = "SYS_USER_LOGIN_SAVE_DAY_INTERVAL";
        public static final String UPLOAD_FILE_SIZE = "UPLOAD_FILE_SIZE";
        public static final String UPLOAD_MAX_MEMORY  = "UPLOAD_MAX_MEMORY";
        public static final String UPLOAD_TEMP_DIR  = "UPLOAD_TEMP_DIR";
        public static final String REFUND_BACKDATED_CLAIM_DAYS = "REFUND_BACKDATED_CLAIM_DAYS";
        public static final String SHOW_FLEXIBLE_FORM_DISPLAY_NAME = "SHOW_FLEX_FORM_DISPLAY_NAME";
        public static final String CONFIGURE_FLEXIBLE_FORM_DISPLAY_NAME = "CONFIGURE_FLEXIBLE_FORM_DISPLAY_NAME";
        public static final String SCHEDULED_JOB_LOG_COUNT = "SCHEDULED_JOB_LOG_COUNT";
        public static final String PERFORM_OBJECT_COMPARISON_FOR_REGISTRATION = "PERFORM_OBJECT_COMPARISON_FOR_REGISTRATION";
        public static final String OBJECTION_DUE_DAYS = "OBJECTION_DUE_DAYS";
        public static final String CAN_GCMS_SCHEDULER_RUN = "CAN_GCMS_SCHEDULER_RUN";
        public static final String SCHEDULE_GCMS_INTERVAL = "SCHEDULE_GCMS_INTERVAL";
        public static final String CAN_GEREG_SCHEDULER_RUN = "CAN_GEREG_SCHEDULER_RUN";
        public static final String SCHEDULE_GEREG_INTERVAL = "SCHEDULE_GEREG_INTERVAL";
        public static final String PERFORM_ACCESS_CONTROL = "PERFORM_ACCESS_CONTROL";

    }

    public interface AddOrSubtract{
        public static final String ADD = "ADD";
        public static final String SUBTRACT = "SUBTRACT";
        public static final String NONE = "NONE";
    }
    
    public interface RelationshipType {
        public static final String DIRECTOR = "DIRECTOR";
        public static final String CONTACT = "CONTACT";
        public static final String  SHAREHOLDERS= "Shareholder";   
        public static final String  PARTNERS= "Partner";
        public static final String  SUBSIDIARIES= "Subsidiary";
        public static final String  RELATED_COMPANIES= "RelatedCompanies";
        public static final String  DIRECTORS= "Directors";
        public static final String  RELATIONSHIPS= "Relationships";
        public static final String  CHILD = "Child";
        public static final String  RELATION_IND = "RELATION_IND";
        public static final String  SIMPLIFIED = "SIMPLIFIED";
        public static final String  RELATION_COMMON = "RELATION_COMMON";
        public static final String  RELATION_ORG = "RELATION_ORG";
        public static final String  EMPLOYMENT = "Employer";
        public static final String  PREVIOUS_BUSINESS = "PreviousBusiness";
        public static final String  AUDITOR = "Auditor";
        public static final String  LANDLORD = "Landlord";
        public static final String  TAX_CONSULTANT = "OtherBusinessnsultant";
        public static final String  OTHER_BUSINESS = "OtherBusiness";
        public static final String  SPOUSE = "Spouse";
        public static final String  TAX_AGENT = "TaxAgent";
        public static final String  TRUSTEE = "Trustee";
        public static final String Director = "Director";
        public static final String[] otherTypesForInd = new String[]{PREVIOUS_BUSINESS, AUDITOR, LANDLORD,
            TAX_CONSULTANT, OTHER_BUSINESS, SPOUSE, TAX_AGENT, CHILD};
        public static final String[] otherTypesForOrg = new String[]{PREVIOUS_BUSINESS, AUDITOR, LANDLORD,
            TAX_CONSULTANT, TRUSTEE};
    }

    public interface EBS {
        public static final String TRANS_SUCCESS = "SUCCESS";
        public static final String TRANS_FAILURE = "FAILURE";
    }

    public interface RevAccRoleType {
        public static final String REGISTRATION = "REG";
        public static final String RE_REGISTRATION = "RE-REG";
    }

    public interface DocStatus {
        public static final String SUB = "SUB"; // Submitted
        public static final String NEW = "NEW"; // New
        public static final String SER = "SER"; // Saved with Errors
        public static final String SAV = "SAV"; // Saved
        public static final String AIN = "AIN"; // Awaiting Inspection
        public static final String APA = "APA"; // Awaiting Payment
        public static final String AAM = "AAM"; // Awaiting Amendment
        public static final String AOF = "AOF"; // Awaiting Offence
        public static final String ARE = "ARE"; // Awaiting Release
        public static final String REL = "REL"; // Released
        public static final String REJ = "REJ"; // Rejected
        public static final String APR = "APR"; // Approved Part Refund
        public static final String AFR = "AFR"; // Approved Full Refund
        public static final String WIT = "WIT"; // Withdraw
        public static final String APP = "APP"; // Approved
        public static final String CUA = "CUA"; // Claim Under Audit
        public static final String REC = "REC"; // Recommended
        public static final String CLAIMED = "CLAIMED"; // Claimed
        public static final String ALL = "ALL"; // Allocated
        public static final String RAL = "RAL"; // Reallocated
        public static final String VALIDATION_FAILED = "VALF";
        public static final String PENDING_AUTHORISATION = "PAU";
        public static final String CANCELLED = "CAN"; // Cancelled
        public static final String ADJUSTMENT = "ADJUSTMENT"; // Cancelled
        public static final String PROVISIONALLY_LOCKED = 
            "PLD"; // Provisionally  Locked
        public static final String LOCKED = "LCD"; // Locked
        public static final String USED = "USED";
        public static final String AMENDED = "AMENDED"; // Amended
        public static final String AGU = "AGU"; // Awaiting Guarantee
        public static final String POSTED = "POSTED"; // Awaiting Guarantee
        public static final String REVERSED = "REVR"; // Awaiting Guarantee
        public static final String PENDING_REVERSAL = "PREVR"; // Awaiting Guarantee
        public static final String TRANSFERRED="TRANSFERRED";
        public static final String PENDING_APPROVAL="PENDAPPR";
        public static final String PENDING_REVISION="PENDREV";
        public static final String BATCH_APPR="APPR";
        public static final String FILED = "FILED";
        public static final String LODGED = "LODGED";
        public static final String AUTHORISED = "AUTH";
        public static final String SAVWE = "SAVWE";
        public static final String SUBMITTED = "SUBMITTED";
        public static final String REA = "REA";
        public static final String APPROVE = "APPROVE";
        public static final String APPR = "APPR";
        public static final String APP_ACTIVE = "Active";
        public static final String SWES = "SWES";
        public static final String SWEP = "SWEP";
        public static final String PEND_CAN = "PENCAN";
        public static final String CREATED = "CREATED";
    }

    public interface ManifestReturnData {
        public static final String CODE_MAN_NO = 
            "CODE_MAN_NO"; // Manifest number code
    }

    public interface ManifestStatus {
        public static final String CREATED = "CRE";
        public static final String RECONCILED = "REC";
        public static final String PARTIALLY_RECONCILED = 
            "PARTIALLY_RECONCILED";
        public static final String SUBMITTED = "SUBMITTED";
        public static final String AWAITING_APPROVAL = "AWAITING APPROVAL";
        public static final String ON_ALERT = "ON ALERT";
        public static final String APPROVED = "APPROVED";
        public static final String WITHDRAWN = "WITHDRAWN";
        public static final String AMEND = "AMEND";
    }

    public interface ManifestReconciliationResult {
        public static final String MATCHED = "MATCHED";
        public static final String NOTMATCHED = "NOTMATCHED";
        public static final String ERROR = "ERROR";
    }

    public interface OwnerType {
        public static final String ACCOUNT = "ACCOUNT";
        public static final String ACCOUNT_ID = "ACCOUNT_ID";
        public static final String ENTITY = "ENTITY";
    }
    public static final String ALL = "ALL";

    public interface MaritalStatus {
        public static final String MARRIED = "Married";

    }

    public interface Security {
        public static final String GROUP_KEY = "Group";
        public static final String SECURITY_TYPE_KEY = "SECURITY_TYPE";
        public static final String ORADB_SEC_TYPE = "DATABASE";
        public static final String LDAP_SEC_TYPE = "LDAP";
        public static final String JAZN_SEC_TYPE = "JAZN";
    }

    public static final String PAYMENT = "PAYMENT";

    public interface TaskManager {
        public static final String DUPLICATE_MATCH_STATUS = "DM";
        public static final String NOT_DUPLICATE_MATCH_STATUS = "ND";
    }

    public interface GuiConfig {
        public static final String CRUD_CONFIG = "CRUD";
        public static final String TASK_CONFIG = "TASK";
        public static final String REGISTER_BRANCH_CONFIG = "REGBRANCH";
        public static final String REGISTER_FACILITY_CONFIG = "REG_FACILITY";
        public static final String REG_REN_BUSS_CONFIG = "REG_REN_BUSS";
        public static final String BACK_DATE_REG_CONFIG = "BACK_DATE_REG";
        public static final String BACK_DATE_LODGE = "BACK_DATE_LODGE";
        public static final String CASE_GENERAL_CONFIG = "CASE_GENERAL";
        public static final String CASE_DEBT_CONFIG = "CASE_DEBT";
        public static final String CASE_DEBT_ESCALATED_CONFIG = "CASE_DEBT_ESCALATED";
        public static final String CASE_DEBT_SYSTEM_GENERATED = "CASE_DEBT_SYSTEM_GENERATED";
        public static final String CASE_AUDIT_CONFIG = "CASE_AUDIT";
        public static final String RISK_PROF_UPDATE = "RISK_PROF_UPDATE"; 
        
        public static final String LODGE_OBJECTION_CONFIG = "LODGE_OBJECTION";
        public static final String RECORD_ADDITIONAL_DETAILS_CONFIG = "RECORD_ADDITIONAL_DETAILS_CONFIG";
        public static final String REVIEW_OBJECTION_CONFIG = "REVIEW_OBJECTION_CONFIG";
        public static final String FINALISE_OBJECTION_CONFIG = "FINALISE_OBJECTION_CONFIG";
        public static final String LODGE_APPEAL_CONFIG = "LODGE_APPEAL_CONFIG";
        public static final String REVIEW_APPEAL_CONFIG = "REVIEW_APPEAL_CONFIG";
        public static final String FINALISE_APPEAL_CONFIG = "FINALISE_APPEAL_CONFIG";
        public static final String CASE_OBJECTION_APPEAL_CONFIG = "CASE_OBJECTION_APPEAL";

    }

    public interface Modes {
        public static final String ADD = "ADD";
//        public static final String NEW_CASE_OPEN = "NCO";        
        public static final String RESOLVE_SUSPENDED = "RESOLVE_SUSPENDED";
        public static final String CREATE = "CREATE";
        public static final String EDIT = "EDIT";
        public static final String VIEW = "VIEW";
        public static final String COPY = "COPY";
        public static final  String BATCH =  "BATCH";
        public static final  String FORM_PROCESS =  "FORM_PROCESS";
        public static final  String BATCH_SUBMIT =  "BATCH_SUBMIT";
        public static final  String ADJUST =  "ADJUST";
        public static final  String CANCEL =  "CANCEL";
        public static final  String SHOW_CPV =  "SHOW_CPV";
        public static final  String SHOW_SCV =  "SHOW_SCV";
        public static final  String SHOW_SCV_AND_CPV =  "SHOW_SCV_AND_CPV";
        public static final String POPUPANDRETURN = "POPUPANDRETURN";
        public static final String AMEND = "AMEND";
        public static final String WITHDRAW = "WITHDRAW";
        public static final String ADDTOLIST = "ADDTOLIST";
        public static final String INTRAN = "INTRAN";
        public static final String CANCEL_TRANSACTION="CANCEL";
        public static final String IDENTIFY_VERIFICATION="IDV";//This mode is used to open Page in EDIT mode from Task Manager
        public static final String SAVWE = "SAVWE";
        public static final String SAVWE_ON_ADJUST = "SAVWE_ON_ADJUST";
        public static final String POP_UP_UPDATE = "POP_UP_UPDATE";
        public static final String SUSPEND = "SUSPEND";
        public static final String REACTIVATE = "REACTIVATE";
      
    }


    public interface SuspectType {
        public static final String AIRCRAFT = "Aircraft";
        public static final String CONTAINER = "Container";
        public static final String INDIVIDUAL = "Individual";
        public static final String ORGANISATION = "Organisation";
        public static final String ORGANIZATION = "Organization";
        public static final String OTHER = "Other";
        public static final String VEHICLE = "Vehicle";
        public static final String VESSEL = "Vessel";
        public static final String GOODS = "Goods";

        public static final String AIRCRAFT_CLASS = "IntelAircraftInputType";
        public static final String CONTAINER_CLASS = "IntelContainerInputType";
        public static final String INDIVIDUAL_CLASS = 
            "IntelIndividualInputType";
        public static final String ORGANISATION_CLASS = 
            "IntelOrganisationInputType";
        public static final String OTHER_CLASS = "IntelOtherInputType";
        public static final String VEHICLE_CLASS = "IntelVehicleInputType";
        public static final String VESSEL_CLASS = "IntelVesselInputType";
        public static final String GOODS_CLASS = "IntelGoodsInputType";
    }

    // REF_EXEMPTION_TYPE

    public interface ExemptionTypeCodes {
        public static final String TAXPAYER = "TP";
        public static final String EXE_USAGE_TYPE_TS = "TS";
    }

    public interface ExemptionType {
        public static final String COMMODITY = "EX_COMM";
        public static final String TARIC = "EX_TARIC";
        public static final String TAXPAYER = "EX_TAXPAYER";
    }

    public interface ReturnTo {
        public static final String MAIN_MENU = "mainMenu";
        public static final String SUSPICION_PAGE = "suspicionPage";
        public static final String REVENUE_DEFERMENT = "revenueDeferment";

    }

    public interface CaseTypes {
        public static final String AUDIT_VISIT = "AUDIT_VISIT" ;
        public static final String REFUNDS = "REFUNDS";
        public static final String REGISTRATION="REGISTRATION";
        public static final String OBJECTION_AND_APPEAL = "OBJECTION_AND_APPEAL";
        public static final String DEBT_MANAGEMENT = "DEBT_MANAGEMENT";
        public static final String REVENUE_COLLECTION = "REVENUE_COLLECTION";
        public static final String RETURNS_PROCESS = "RETURNS_PROCESS";
        public static final String EXEMPTIONS_MANAGEMENT = "EXEMPTIONS_MANAGEMENT";        
        public static final String COMPLIANCE_ENFORCEMENT = "COMPLIANCE_ENFORCEMENT";
        public static final String REVENUE_ACCOUNTING = "REVENUE_ACCOUNTING";
        public static final String RISK_MANAGEMENT = "RISK_MANAGEMENT";
        public static final String TAXPAYER_COMPLAINT_OTHER = "TAXPAYER_COMPLAINT_OTHER";
        public static final String TAXPAYER_COMPLAINT_STAFF = "TAXPAYER_COMPLAINT_STAFF";
        public static final String TAXPAYER_QUERY_ACCOUNT = "TAXPAYER_QUERY_ACCOUNT";
        public static final String TAXPAYER_QUERY_PAYMENT ="TAXPAYER_QUERY_PAYMENT";
        public static final String TAXPAYER_QUERY_REFUND = "TAXPAYER_QUERY_REFUND";
        public static final String TAXPAYER_QUERY_REGISTRATION = "TAXPAYER_QUERY_REGISTRATION";
        public static final String TAXPAYER_QUERY_RETURN = "TAXPAYER_QUERY_RETURN";
        public static final String TAX_ACCOUNTING = "TAX_ACCOUNTING";
        public static final String VALIDATION_ERROR_EXEMPTION = "VALIDATION_ERROR_EXEMPTION";
        public static final String VALIDATION_ERROR_REFUND = "VALIDATION_ERROR_REFUND";            
    }
    
    public interface CaseTitles {                   
        public static final String EXEMP_MGT_TITLE="Exemption Application Form - Saved With Errors";
        public static final String RTN_PROCESS_TITLE="Returns Processing - Saved With Errors";
        public static final String RVN_PROCESS_TITLE="Non-Registered Taxpayer Requires Registering";
        public static final String PAYE_RTN_PROCESS_TITLE=" PAYE Return Processing - Saved With Errors";
        public static final String INSTALMENT_AGMT_CASE_TITLE="Instalment Agreement Details";
        public static final String INSTALMENT_AGMT_CASE_NOTES_TITLE="Instalment Agreement Number";
        public static final String RISK_ANALYSIS_CASE_TITLE="Risk analysis of return: {0} with document reference: {1}";
        public static final String AUDIT_AND_VISIT_CASE_TITLE="Audit and Visit";
    }
    
    public interface CaseTitleSuffix {                   
        public static final String OBA_OBJECTION_LODGED="Objection Received";
        public static final String OBA_OBJECTION_RECORD_ADDNL_DTLS="Objection Review";
        public static final String OBA_OBJECTION_REVIEW="Objection Finalisation";
        public static final String OBA_APPEAL_LODGED="Appeal Review";
        public static final String OBA_APPEAL_REVIEW="Appeal Finalisation";      
        public static final String OBA_APPEAL_FINALISED="Appeal Finalised";
        public static final String OBA_OBJECTION_FINALISED="Objection Finalised";
        public static final String OBA_APPEAL_REJECTED="Appeal Rejected";
        public static final String OBA_OBJECTION_REJECTED="Objection Rejected";
    }
    
    
    public interface CaseCategory {
        public static final String GENERAL = "GENERAL";
        public static final String DEBT_MANAGEMENT = "DEBT_MANAGEMENT" ;
        public static final String AUDIT_AND_VISIT = "AUDIT_AND_VISIT" ;
        public static final String OBJECTION_AND_APPEAL = "OBJECTION_AND_APPEAL" ;
    }

    public interface ObjAppFlowMode {
        public static final String LODGE_OBJECTION_FLOW = "LODGE_OBJECTION_FLOW";
        public static final String RECORD_ADD_DETAILS_FLOW = "RECORD_ADD_DETAILS_FLOW";
        public static final String REVIEW_OBJECTION_FLOW = "REVIEW_OBJECTION_FLOW";
        public static final String FINALISE_OBJECTION_FLOW = "FINALISE_OBJECTION_FLOW";
        public static final String LODGE_APPEAL_FLOW = "LODGE_APPEAL_FLOW";
        public static final String REVIEW_APPEAL_FLOW = "REVIEW_APPEAL_FLOW";
        public static final String FINALISE_APPEAL_FLOW = "FINALISE_APPEAL_FLOW";
        public static final String VIEW_OBJECTION_APPEAL_CASE_FLOW = "VIEW_OBJECTION_APPEAL_CASE_FLOW";
    }

    public interface CaseStatus {
        public static final String NEW = "NEW";
        public static final String PENDOPEN = "PENDOPEN";
        public static final String OPEN = "OPEN";
        public static final String CLOSED = "CLOSED";
        public static final String INPROGRESS = "INPROGRESS";
        public static final String PENDCLOSE = "PENDCLOSE";
        public static final String ONHOLD = "ONHOLD";
        public static final String WRITE_OFF = "WRITE_OFF";
        public static final String COURT_ACTION = "COURT_ACTION";
        public static final String DEBT_RECOVERY = "DEBT_RECOVERY";
        public static final String LODGED = "LODGED";
        public static final String OBJECTION_REJECTED = "OBJECTION_REJECTED";
        public static final String AWAITING_REVIEW = "AWAITING_REVIEW";
        public static final String AWAITING_FINALISATION = "AWAITING_FINALISATION";
        public static final String OBJECTION_FINALISED = "OBJECTION_FINALISED";
        public static final String APPEAL_LODGED = "APPEAL_LODGED";
        public static final String APPEAL_REJECTED = "APPEAL_REJECTED";
        public static final String APPEAL_AWAITING_FINALISATION = "APPEAL_AWAITING_FINALISATION";
        public static final String APPEAL_FINALISED = "APPEAL_FINALISED";
    }
        
    public interface DebtCaseEscalation {
        public static final String NONE = "";
        public static final String WRITE_OFF = "WRITE_OFF";        
        public static final String DEBT_RECOVERY = "DEBT_RECOVERY";        
        public static final String COURT_ACTION = "COURT_ACTION";        
    }

    public interface RevPeriodStatus {
        public static final String CREATED = "Created";
        public static final String FILED = "Filed";
        public static final String FULLY_PAID = "FullyPaid";
        public static final String PARTIALLY_PAID = "PartiallyPaid";
        public static final String EXCESS_PAID = "ExcessPaid";
        public static final String NON_FILE = "NonFile";
        public static final String NON_PAY = "NonPay";
        public static final String LATE_FILE = "LateFile";
        public static final String LATE_PAY = "LatePay";
        public static final String DEFERRED = "Deferred";
        public static final String CANCELED = "Canceled";
    }

    public interface ComplianceType {
        public static final String NON_FILE = "NonFile";
        public static final String NON_PAY = "NonPay";
        public static final String LATE_FILE = "LateFile";
        public static final String LATE_PAY = "LatePay";
        public static final String SHORT_PAY = "ShortPay";
        public static final String LATE_REG = "LateReg";
        public static final String LATE_RENEW = "LateRenew";
        public static final String NON_REG = "NonReg";
        public static final String NON_REN_REG = "NonRenReg";
        public static final String SHORT_FILE = "ShortFile";
        public static final String COMPLIANCE = "COMPLIANCE";
        
    }

    public interface ComplianceAction {
        public static final String NO_ACTION = "NoAction";
        public static final String NOTICE = "Notice";
        public static final String DEMAND_NOTICE = "DemandNotice";
        public static final String CHARGE = "Charge";
    }

    public interface CaseOperations {
        public static final String PROCESS_CASE = "PROCESS_CASE";
        public static final String PROCESS_OBJECTIONS_APPEALS = 
            "PROCESS_OBJECTIONS_APPEALS";
        public static final String AUDIT_ASSESSMENT_OPS = 
            "PROCESS_AUDIT_ASSESSMENT";
        public static final String CREATE_OFFENCE_OPS = "CREATE_OFFENCE";
        public static final String REMIT_OFFENCE_OPS = "REMIT_OFFENCE";
        public static final String POST_AUDIT_CLEARANCE = 
            "POST_CLEARANCE_AUDIT";

    }

    public interface TaxpayerIndicators {
        public static final String TURNOVER_IND = "Turnover";
        public static final String COMPLIANCE_IND = "Compliance";
        public static final String COMPLEXITY_IND = "Complexity";
    }
    
    public interface DefaultTaxpayerIndicatorsValue {
        public static final Long TURNOVER_IND_MIN_VALUE = 0L;
        public static final Long COMPLIANCE_IND_MIN_VALUE = 0L;
        public static final Long COMPLEXITY_IND_MIN_VALUE = 1L;
    }
    
    public interface MessageType {
        public static final String DECLARATION_INPUT_TYPE = 
            "DeclarationInputType";
        public static final String REFUND_CLAIM_INPUT_TYPE = 
            "RefundClaimInputType";
        public static final String TAX_RETURN_INPUT_TYPE = 
            "TaxReturnInputType";
    }

    public interface EntityDefaultValues {
        public static final String CREATED_BY = "createdBy";
        public static final String CREATED_DATE = "createdDate";
        public static final String UPDATED_BY = "updatedBy";
        public static final String UPDATED_DATE = "updatedDate";
        public static final String STATUS = "status";
        public static final String VERSION = "version";
        public static final String ACCESS_LEVEL = "accessLevel";
        public static final String ID = "id";
        public static final String DOCUMENT_ID = "docId";
        public static final String CODE = "code";
        public static final String ORDER_SEQ = "orderSeq";
        public static final String PARENT_ID = "parentId";
        public static final String FORM_TYPE = "formType";
        public static final String FORM_NAME = "formName";
        public static final String SUBMISSION_MODE = "submissionMode";
        public static final String PERIOD = "Period";
        public static final String PERIOD_START_DATE = "periodFrom";
        public static final String PERIOD_END_DATE = "periodTo";
        public static final String ATTACHMENT = "Attachment";
        
        public static final String ENTITY_NAME = "taxpayerName";
        public static final String CURRENCY = "currency";
        public static final String NIL_RETURN = "nilReturn";
        public static final String TIN = "tin";
        public static final String PERIOD_FROM_HIDDEN = "PeriodFrom";
        

        
        
        public static final String DB_CREATED_BY = "CREATED_BY";
        public static final String DB_CREATED_DATE = "CREATED_DATE";
        public static final String DB_UPDATED_BY = "UPDATED_BY";
        public static final String DB_UPDATED_DATE = "UPDATED_DATE";
        public static final String DB_FORM_TYPE = "FORM_TYPE";
        
        public static final String DB_STATUS = "STATUS";
        public static final String DB_VERSION = "VERSION";
        public static final String DB_ACCESS_LEVEL = "ACCESS_LEVEL";
        public static final String DB_ID = "ID";
        public static final String DB_CODE = "CODE";
        public static final String DB_ORDER_SEQ = "ORDER_SEQ";
        public static final String DB_PARENT_ID = "PARENT_ID";
        public static final String DB_SUBMISSION_MODE = "SUBMISSION_MODE";
        public static final String DB_DOCUMENT_ID = "DOCUMENT_ID";
        public static final String DB_PERIOD_FROM = "PERIOD_FROM";
        public static final String DB_PERIOD_TO = "PERIOD_TO";
        public static final String DB_NILL_RETURN = "NIL_RETURN";
        public static final String DB_ENTITY_NAME = "TAXPAYER_NAME";
        public static final String DB_CURRENCY = "CURRENCY";
        public static final String DB_NIL_RETURN = "NILRETURN_INDICATOR";
    }

    public interface EntityEventDefaultValues {
        public static final String EFFECTIVE_DATE = "effectiveDate";
        public static final String EVENT_DATE = "eventDate";
        public static final String EXPIRY_DATE = "expiryDate";
        public static final String INITIATED_BY = "initiatedBy";
        public static final String PARENT_EVENT = "parentEvent";
        public static final String REF_EVT_TYPE_CAT = "refEvtTypeCat";
        public static final String RELATED_MODULE_ID = "relatedModuleId";
        public static final String WORKFLOW_TYPE = "workflowType";
        public static final String REASON = "reason";
        public static final String NOTES = "notes";
        
        public static final String DB_WORKFLOW_TYPE = "WORKFLOW_TYPE";
        public static final String DB_EFFECTIVE_DATE = "EFFECTIVE_DATE";
        public static final String DB_EVENT_DATE = "EVENT_DATE";
        public static final String DB_EXPIRY_DATE = "EXPIRY_DATE";
        public static final String DB_INITIATED_BY = "INITIATED_BY";
        public static final String DB_PARENT_EVENT = "PARENT_EVENT";
        public static final String DB_REF_EVT_TYPE_CAT = "REF_EVT_TYPE_CAT";
        public static final String DB_RELATED_MODULE_ID = "RELATED_MODULE_ID";
        
        public static final String DB_REASON = "REASON";
        public static final String DB_NOTES = "NOTES";
        
        public static final String DB_REF_EVT_TYPE_CAT_TABLE = "H_REF_EVT_TYPE_CAT"; //TODO change this table name.
        public static final String DB_REF_EVT_TYPE_CAT_PK = "CODE";
    }
        
    public interface RunMethodsAfterGenericSearch {
        public static final String SUSPECT_SELECTION = 
            "runMethodForSuspectSelection";
    }

    public interface TableHandlerType {
        public static final String SUSPECT_TABLE_HANDLER_KEY = 
            "SUSPECT_TABLE_HANDLER_KEY";
        public static final String SEIZURE_TABLE_HANDLER_KEY = 
            "SEIZURE_TABLE_HANDLER_KEY";
        public static final String RUMMAGE_TABLE_HANDLER_KEY = 
            "RUMMAGE_TABLE_HANDLER_KEY";
        public static final String OFFENCE_TABLE_HANDLER_KEY = 
            "OFFENCE_TABLE_HANDLER_KEY";
        public static final String SUSPICION_TABLE_HANDLER_KEY = 
            "SUSPICION_TABLE_HANDLER_KEY";

        public static final String FLEXIBLE_FORM_TABLE_HANDLER_KEY = 
            "FLEXIBLE_FORM_TABLE_HANDLER_KEY";
    }

    public interface IntelligenceTabNames {
        public static final String GOODS_TAB = "GOODS_TAB";
        public static final String SUSPICION_TAB = "SUSPICION_TAB";
        public static final String SUSPECT_TAB = "SUSPECT_TAB";
        public static final String SEIZURE_TAB = "SEIZURE_TAB";
        public static final String RUMMAGE_TAB = "RUMMAGE_TAB";
        public static final String OFFENCE_TAB = "OFFENCE_TAB";
        public static final String ATTACHMENT_TAB = "ATTACHMENT_TAB";
        public static final String DETAILS_TAB = "DETAILS_TAB";
    }

    public interface IntelSpotlight {
        public static final String SUSPICION = "Suspicion";
        public static final String SEIZURE = "Seizure";
        public static final String RUMMAGE = "Rummage";
        public static final String OFFENCE = "Offence";
    }


    public interface ReportParameterTypes {
        public static final String TEXT = "TEXT";
        public static final String DROPDOWN = "DROPDOWN";
        public static final String CALENDAR = "CALENDAR";
        public static final String CALENDAR_FROM_TO = "CALENDAR_FROM_TO";
        
    }

    public interface ValuationStatus {
        public static final String CURRENT = "CURRENT";
        public static final String EXPIRED = "EXPIRED";
    }


    public interface ValuationTypes {
        public static final String PRODUCT = "Product";
        public static final String FREIGHT = "Freight";
    }

    public interface ValuationModes {
        public static final String SAVE = "SAVE";
        public static final String CREATE_COPY = "CREATE_COPY";
    }

    public interface CommodityCategory {
        public static final String VEHICLE = "VEH";
        public static final String SHIP = "SHIP";
    }

    public interface IncoTerms {
        public static final String COST_AND_FREIGHT = "CFR";
        public static final String COST_INSURANCE_FREIGHT = "CIF";
        public static final String CARRIAGE_AND_INSURANCE_PAID_TO = "CIP";
        public static final String CARRIAGE_PAID_TO = "CPT";
        public static final String DELIVERED_AT_FRONTIER = "DAF";
        public static final String DELIVERED_DUTY_PAID = "DDP";
        public static final String DELIVERED_DUTY_UNPAID = "DDU";
        public static final String DELIVERED_EX_QUAY = "DEQ";
        public static final String DELIVERED_EX_SHIP = "DES";
        public static final String EX_WORKER = "EXW";
        public static final String FREE_ALONGSIDE_SHIP = "FAS";
        public static final String FREE_CARRIER = "FCA";
        public static final String FREIGHT_ON_BOARD = "FOB";
    }

    public interface TransportType {
        public static final String AIRCRAFT = "Aircraft";
        public static final String VESSEL = "Vessel";
        public static final String VEHICLE = "Vehicle";
        public static final String WAGON = "Wagon";
        public static final String COACH = "Coach";
        public static final String ZEPPELIN = "Zeppelin";
        public static final String BALOON = "Baloon";
        public static final String TRAIN = "Train";
        // Add more transport types here...

        public static final String AIRCRAFT_ID = "AIRCRAFT_ID";
        public static final String VESSEL_ID = "VESSEL_ID";
        public static final String VEHICLE_ID = "VEHICLE_ID";
        public static final String TRAIN_ID = "TRAIN_ID";

    }


    public interface TransportModeType {
        // this fields values corresponds to the TYPE column of the REF_CUST_TRAN_MODE table.
        public static final String MARITIME = "1";
        public static final String RAIL = "2";
        public static final String ROAD = "3";
        public static final String AIR = "4";

        // Add more transport mode types here...
    }

    public interface TransportMode {
        public static final String MARITIME_TRANSPORT = "1";
        public static final String TRAILER_ON_SEA_GOING_VESSEL = "2";
        public static final String INLAND_WATERWAY_ON_SEA_GOING_VESSEL = "3";
        public static final String RAILWAY_WAGON_ON_SEA_GOING_VESSEL = "4";
        public static final String POWERED_ROAD_VEH_ON_SEA_GOING_VESSEL = "5";
        public static final String RAIL_TRANSPORT = "6";
        public static final String ROAD_VEH_ON_RAIL_WAGON = "7";
        public static final String ROAD_TRANSPORT = "8";
        public static final String AIR_TRANSPORT = "9";
        public static final String POSTAL_CONSIGNMENTS = "10";
        public static final String FIXED_TRANSPORT_INSTALLATION = "11";
        public static final String INLAND_WATERWAY_TRANSPORT = "12";
        public static final String OWN_PROPULSION = "13";

    }

    public interface ReportFormat {
        public static final String PDF = "pdf";
        public static final String HTML = "html";
        public static final String EXCEL = "excel";
        public static final String RTF = "rtf";
        public static final String PRINTER = "PRINTER";
    }
    
    public interface ReportName {
        public static final String REG_CERT = "TAXPAYER_CERTIFICATE" ;
        public static final String TAXPAYER_REGISTRATION_AMENDMENT_NOTIFICATION = 
            "TAXPAYER_REGISTRATION_AMENDMENT_NOTIFICATION";
        public static final String TAXTYPEREGISTRATION_AMENDMENT_NOTIFICATION = 
            "TAXTYPEREGISTRATION_AMENDMENT_NOTIFICATION";
        public static final String REV_DEREG = "REV_DEREG";
        public static final String TAX_TYPE_CERTIFICATE = 
            "TAX_TYPE_CERTIFICATE";
        public static final String TAXPAYER_REJECTION_NOTIFICATION = 
            "TAXPAYER_REJECTION_NOTIFICATION";
        public static final String TAXTYPE_REJECTION_NOTIFICATION = 
            "TAXTYPE_REJECTION_NOTIFICATION";
       // TaxpayerAccounting Module     
        public static final String DISHONOURED_PAYEMENT_NOTIFICATION = 
            "DISHONOURED_PAYEMENT_NOTIFICATION";

        public static final String PAYMENT_REVERSAL_NOTICE = "PAYMENT_REVERSAL_NOTICE";
        public static final String PAYMENT_RECEIPT = "PAYMENT_RECEIPT";
        
        public static final String ADJUSTMENT_NOTIFICATION = 
            "ADJUSTMENT_NOTIFICATION";  
        public static final String LODGEMENT_NOTIFICATION = 
            "LODGEMENT_NOTIFICATION";  
        public static final String RETURN_CANCELLATION = 
            "RETURN_CANCELLATION";
        public static final String RETURN_ADJUST_NOTIFICATION = 
            "RETURN_ADJUST_NOTIFICATION";
        public static final String NON_PAY_NOTIFICATION = "NON_PAY_NOTIFICATION";
        
        public static final String NON_FILE_NOTIFICATION = "NON_FILE_NOTIFICATION";
        
        public static final String LATE_PAY_NOTIFICATION = "LATE_PAY_NOTIFICATION";
        
        public static final String LATE_FILE_NOTIFICATION = "LATE_FILE_NOTIFICATION";
        public static final String MANUAL_PENALTY_NOTIFICATION ="MANUAL_PENALTY_NOTIFICATION"; 
        public static final String EXEM_APPL_LODGEMENT_NOTIFICATION =  "EXEM_APPL_LODGEMENT_NOTIFICATION";
        public static final String EXEM_APPL_APPROVE_NOTIFICATION = "EXEM_APPL_APPROVE_NOTIFICATION";
        public static final String EXEM_APPL_REJECT_NOTIFICATION = "EXEM_APPL_REJECT_NOTIFICATION";
        public static final String EXEM_APPL_CANCELORSUSPENDORREACTIVATE_NOTIFICATION = "EXEM_APPL_CANCELORSUSPENDORREACTIVATE_NOTIFICATION";
        public static final String REFUND_ACKNOWLEDGEMENT_NOTIFICATION = "REFUND_ACKNOWLEDGEMENT_NOTIFICATION";
        public static final String REFUND_REJECTION_NOTIFICATION = "REFUND_REJECTION_NOTIFICATION";
        public static final String REFUND_PAYMENT_NOTIFICATION = "REFUND_PAYMENT_NOTIFICATION";
        public static final String FILE_RETURN_NOTIFICATION = "FILE_RETURN_NOTIFICATION";
        public static final String INSTALMENT_AGREEMENT_NOTIFICATION = "INSTALMENT_AGREEMENT_NOTIFICATION";
        public static final String INSTALMENT_AGREEMENT_CANCEL_NOTIFICATION = "INSTALMENT_AGREEMENT_CANCEL_NOTIFICATION";
        public static final String  ACCOUNT_ADJUSTMENT_NOTIFICATION = "ACCOUNT_ADJUSTMENT_NOTIFICATION";
        public static final String  AUDIT_NOTIFICATION = "AUDIT_NOTIFICATION";
        public static final String  OFFICER_ASSESSMENT_NOTIFICATION = "OFFICER_ASSESSMENT_NOTIFICATION";
        
        public static final String  APPEAL_ACKNOWLEDGEMENT_NOTIFICATION = "APPEAL_ACKNOWLEDGEMENT_NOTIFICATION";
        public static final String  APPEAL_REJECTION_NOTIFICATION = "APPEAL_REJECTION_NOTIFICATION";
        public static final String  APPEAL_FINALISATION_NOTIFICATION = "APPEAL_FINALISATION_NOTIFICATION";
        public static final String  OBJECTION_ACKNOWLEDGEMENT_NOTIFICATION = "OBJECTION_ACKNOWLEDGEMENT_NOTIFICATION";
        public static final String  OBJECTION_ACCEPTANCE_NOTIFICATION = "OBJECTION_ACCEPTANCE_NOTIFICATION";
        public static final String  OBJECTION_REJECTION_NOTIFICATION = "OBJECTION_REJECTION_NOTIFICATION";
        public static final String  OBJECTION_FINALISATION_NOTIFICATION = "OBJECTION_FINALISATION_NOTIFICATION";
        public static final String  REVISED_TAX_ASSESSMENT="REVISED_TAX_ASSESSMENT";
    }
    
    public interface ReportTemplate {
        public static final String REGCERT = "certificate_of_registration";
        public static final String TAX_TYPE_CERTIFICATE = 
            "certificate_of_Tax_type_registration";
        public static final String TAXTYPEREGISTRATION_AMENDMENT_NOTIFICATION = 
            "Certificate_of_Reg_Amend_Notification";
        public static final String TAXPAYER_REGISTRATION_AMENDMENT_NOTIFICATION = 
            "Certificate_of_TaxPayer_Reg_Amend_Notification";
        public static final String STATEMENT_OF_ACCOUNTS = 
            "Statement of Accounts";
        public static final String TAXPAYER_REJECTION_NOTIFICATION = 
            "Taxpayer Rejection Notification";
        public static final String TAXTYPE_REJECTION_NOTIFICATION = 
            "Taxtype Rejection Notification";
       // TaxpayerAccounting Module     
        public static final String DISHONOURED_PAYEMENT_NOTIFICATION = 
            "Dishonoured Payment Notification";
   } 
    
    public interface ReportParameterName {
        public static final String OCN = "SYS_OCN";
        // 06/05/2011 for Taxpayer TIN certificate
        public static final String TIN = "TIN";
        public static final String TAXTYPE = "REGIMETYPE";
        public static final String DTYPE = "DTYPE";
        public static final String DDOC_DOCUMENT_DTYPE = "DDOC_DOCUMENT_DTYPE";
        public static final String ENTITY_ID = "ENTITY_ID";
        public static final String DOC_ID = "DOCID";
        public static final String INSTRUMENT_ID = "INSTRUMENTID";
        public static final String REPORT_ABSOLUTE_PATH = "REPORT_ABSOLUTE_PATH";
        public static final String REPORT_ID = "REPORT_ID";
        public static final String ACC_PERIOD = "ACC_PERIOD";
        public static final String CANCEL_REASON_CODE = "REASON_CODE";
        public static final String COLL_RECEIPT_ID = "COLL_RECEIPT_ID";
        public static final String HISTORY_ID = "HISTORY_ID";
        public static final String FLEXIBLE_FORM_ID="FLEXIBLE_FORM_ID";
        public static final String EVENT_ID="EVENTID";        
        public static final String LODGED_AMOUNT="LODGED_AMOUNT";
        public static final String FILING_AMOUNT="FILING_AMOUNT";
        public static final String CURRENCY_TO_WORDS="CURRENCY_TO_WORDS";
        public static final String AUDIT_CASE_DETAILS_ID="AUDIT_CASE_DETAILS_ID";
        public static final String OFFICER_ASSESSMENT_ID="OFFICER_ASSESSMENT_ID";
        public static final String OBJECTION_CASE_DETAILS_ID="OBJECTION_CASE_DETAILS_ID";
        
       }

    public interface ConsignmentStatus {
        public static final String MANIFESTED = "MAN";
        public static final String ACQUITED = "ACQUITED";
        public static final String NOTACQUITED = "NOTACQUITED";
    }

    public interface ManifestSource {
        public static final String MANUAL = "MAN";
    }

    public interface CustomsRegimeTypes {
        public static final String IMPORT_DECLARATION = "IM1";
        public static final String EXPORT_DECLARATION = "EX1";
        public static final String TRANSIT_DECLARATION = "TR1";
        public static final String FREE_ZONE_IMPORT_DECLARATION = "FI1";
    }

    public interface MeasurementTypes {
        public static final String NUMBER = "NUM";
        public static final String LENGTH = "LEN";
        public static final String WEIGHT = "WT_GROSS";
        public static final String VOLUME = "VOL";
        public static final String AREA = "AREA";
    }

    public interface HumanTaskOutcomes {
        public static final String APPROVE = "APPROVE";
        public static final String REJECT = "REJECT";
        public static final String REFER = "REFER";
        public static final String REVISION = "REVISION";
        public static final String CONTROLAPPLIED = "CONTROLAPPLIED";
        public static final String COMPLETED = "COMPLETED";
        public static final String OPENCASE = "OPENCASE";
        
    }

    public interface Modules {
        public static final String VAT_PAYMENTS = "VAT Payments";
        public static final String COMPLIANCE = "Compliance";
        public static final String LATE_REG_FORCED = "LateRegForced";
    }

    public interface PAndIComputationType {
        public static final String INTEREST = "Interest";
        public static final String INTEREST_AND_PENALTY = 
            "Interest and Penalty";
        public static final String PENALTY = "Penalty";
        public static final String PENALTY_AND_INTEREST = 
            "Penalty and Interest";
    }

    public interface PAndIComputationMethod {
        public static final String ONE_OFF = "One-Off";
        public static final String DAILY = "Daily";
        public static final String MONTHLY = "Monthly";
        public static final String QUARTERLY = "Quarterly";
        public static final String ANNUAL = "Annual";
    }

    public interface PAndIPeriodBasis {
        public static final String ONE_OFF = "One-Off";
        public static final String DAILY = "Daily";
        public static final String WEEKLY = "Weekly";
        public static final String MONTHLY = "Monthly";
        public static final String BI_MONTHLY = "Bi-Monthly";
        public static final String QUARTERLY = "Quarterly";
        public static final String ANNUAL = "Annual";
    }

    public interface InstalmentPeriodBasis {
        public static final String DAILY = "Daily";
        public static final String WEEKLY = "Weekly";
        public static final String FORTNIGHTLY = "Fortnightly";
        public static final String MONTHLY = "Monthly";
        public static final String QUARTERLY = "Quarterly";
        public static final String BI_ANNUALLY = "Bi-Annual";
        public static final String ANNUAL = "Annually";
        public static final String BI_MONTHLY = "Bi-Monthly";
    }

    public interface InterestMethods {
        public static final String SIMPLE = "Simple";
        public static final String COMPOUND = "Compound";
    }

    public interface PenaltyMethods {
        public static final String FIXED = "Fixed";
        public static final String FIXED_WITH_LIMITS = "Fixed With Limits";
        public static final String VARYING_WITHOUT_LIMITS = 
            "Varying Without Limits";
        public static final String VARYING_WITH_LIMITS = "Varying With Limits";        
        public static final String  FIX="FIX";
        public static final String VARIABLE = "VAR";
        public static final String FIXED_PLUSE_VARIABLE = "BOTH";
    }


    public interface ApplicationTypes {
        String TAXPAYER_EXEMPTION = "TAX_EX";
        String SIMPLIFIED_PROCEDURES = "SIMP_PROC";
        String WAREHOUSE = "WH";
        String PERMIT_TO_USE = "PERMIT_TO_USE";
        String ACCREDICATION = "ACCRED";
    }

    public interface GuaranteeTypes {
        //TODO (VP) Need to check guarantee types with VM
        public static final String CODE_0 = "0";
        public static final String CODE_1 = "1";
        public static final String CODE_2 = "2";
        public static final String CODE_3 = "3";
        public static final String CODE_4 = "4";
        public static final String CODE_5 = "5";
        public static final String CODE_6 = "6";
        public static final String CODE_7 = "7";
        public static final String CODE_8 = "8";
        public static final String CODE_9 = "9";
    }

    public interface OperationType {
        public static final String CREATE_NEW = "CREATE_NEW";
        public static final String CREATE_NEW_FROM_COPY = 
            "CREATE_NEW_FROM_COPY";
        public static final String UPDATE = "UPDATE";
        public static final String CANCEL = "CANCEL";
        public static final String SUBMIT = "SUBMIT";
        public static final String SAVE = "SAVE";
        public static final String RE_REG_TAX = "RE_REG_TAX";
        public static final String RENEW = "RENEW";
        public static final String AMEND = "AMEND";
        public static final String SAVE_WITH_ERROR = "SAVE_WITH_ERROR";
        public static final String RESET = "RESET";
    }

    public interface ApplicationModes {
        public static final String SAVE = "SAVE_APP";
        public static final String SAVE_WITH_ERRORS = "SAVE_APP_WITH_ERRORS";
        public static final String SUBMIT_WITH_CASE = "SUBMIT_APP_WITH_CASE";
        public static final String SUBMIT = "SUBMIT_APP";
        public static final String APPROVE = "APPROVE";
        public static final String REJECT = "REJECT";
    }

    public interface WorkflowTypes {
        String GENERAL_APPLICATION = "GEN_APP";
        public static final String FLEXIBLE_FORM = "FLEXIBLE_FORM";
    }

    public interface ReportOutputs {
        public static final String HTML="html";
        public static final String PDF="pdf";
        public static final String SYSTEM="xml";
        public static final String RTF="rtf";
        public static final String EXCEL="excel";
    }

    public interface Scales {
        public static final int CURRENCY = 2;
        public static final int NORMAL = 3;
        public static final int TEN = 10;
    }

    public interface PrintStatus {
        public static final String PRINTED = "PRINTED";
        
        
    }
    public interface PrinterTypeConfig {
        public static final String TAXPAYER_OFFICE_DEFAULT = "TAXPAYER_OFFICE_DEFAULT";
        public static final String TAXPAYER_OFFICE_SECURE = "TAXPAYER_OFFICE_SECURE";
        public static final String USERS_OFFICE_DEFAULT = "USERS_OFFICE_DEFAULT";
        public static final String USERS_OFFICE_SECURE = "USERS_OFFICE_SECURE";
        public static final String USER_PREFERRED = "USER_PREFERRED";
           }

    public interface RevTypes {
        String CUSTOMS = "CUSTOMS";
    }

    public interface ApplicationPageModes {
        String PENDING_AUTHORISATION = DocStatus.PENDING_AUTHORISATION;
        String CASE_PENDING_AUTHORISATION = "CASE_PAU";
    }

    public interface AccountStatus {
        public static final String REGISTER = "REG";
        public static final String PENDING_DEREGISTER = "PEND-DEREG";
        public static final String DEREGISTER = "DE-REG";
        public static final String SUSPEND = "SUSP";
        public static final String RE_REGISTER = "RE-REG";
        public static final String PENDING_REGISTER = "PEND";
    }

    public interface Jobs {
        public static final String PRINTED = "PRINTED";
        public static final String MANUAL = "MANUAL";
        public static final String SYSTEM = "SYSTEM";
        public static final String REPRINTED = "RPRINTED";
        public static final String COMPLETED = "SUCCESS";
        public static final String FAILED = "FAILED";
        public static final String IMMEDIATE = "IMMEDIATE";
    }

    public interface EventCodes {
        public static final String AMENDED = "AMEND";
    }

    public interface GuaranteeUsageType {
        public static final String DECLARATION = "DECL";
        public static final String TAX = "TAX";
        public static final String WAREHOUSE_APPLICATION = "WHAPP";
        public static final String REVENUE_DEFERMENT = "REVDEF";
    }

    public interface ReleaseMode {
        public static final String AUTO = "AUTO";
        public static final String MANUAL = "MANUAL";
    }

    public interface TempRemovalAuthType {
        String GENERAL = "GEN";
    }

    public interface ProcedureType {
        String SIMP_PROC = "SIMP_PROC";
    }

    public interface TaxAllocationConfigType {
        String PROCEDURE = "PROCEDURE";
        String COMMODITY = "COMMODITY";
        String REGIME = "REGIME";
        String VALUE = "VALUE";
    }

    public interface StaticSearchInjection {
        public static final String FIND_GUARANTEE_FOR_USAGE_DECLARATION = 
            "FIND_GUARANTEE_FOR_USAGE_DECLARATION";
        public static final String FIND_GUARANTEE_FOR_USAGE_TAX = 
            "FIND_GUARANTEE_FOR_USAGE_TAX";
        public static final String FIND_GUARANTEE_FOR_USAGE_WAREHOUSE = 
            "FIND_GUARANTEE_FOR_USAGE_WAREHOUSE";
        public static final String FIND_GUARANTEE_FOR_USAGE_REV_DEF = 
            "FIND_GUARANTEE_FOR_USAGE_REV_DEF";
        public static final String FIND_GUARANTEE_FOR_STATUS_NEW = 
            "FIND_GUARANTEE_FOR_STATUS_NEW";
        public static final String FIND_GUARANTEE_FOR_STATUS_NOT_NEW = 
            "FIND_GUARANTEE_FOR_STATUS_NOT_NEW";
        public static final String AMOUNT_GREATER_THAN_ZERO = 
            "AMOUNT_GREATER_THAN_ZERO";
        public static final String FIND_ENTITY_ENTITIES = 
            "FIND_ENTITY_ENTITIES";
        public static final String FIND_ENTITY_WITH_CUSTOMS_ACCOUNT = 
            "FIND_ENTITY_WITH_CUSTOMS_ACCOUNT";
        public static final String FIND_ENTITY_ENTITIES_WITH_TIN = 
            "FIND_ENTITY_ENTITIES_WITH_TIN";
        public static final String FIND_ENTITY_ENTITIES_CANBE_SUSPENDED = 
            "FIND_ENTITY_ENTITIES_CANBE_SUSPENDED";
        public static final String FIND_ENTITY_ENTITIES_CANBE_REACTIVATED = 
            "FIND_ENTITY_ENTITIES_CANBE_REACTIVATED";
        public static final String FIND_ENTITY_ENTITIES_CANBE_DEREGISTERED = 
            "FIND_ENTITY_ENTITIES_CANBE_DEREGISTERED";
        public static final String FIND_ENTITY_ENTITIES_CANBE_REREGISTERED = 
            "FIND_ENTITY_ENTITIES_CANBE_REREGISTERED";
        public static final String FIND_ENTITY_ENTITIES_CAN_BRANCH = 
            "FIND_ENTITY_ENTITIES_CAN_BRANCH";  
        public static final String NON_SUBMITTED_BATCH = 
            "NON_SUBMITTED_BATCH";
        public static final String FIND_TRANSACTIONS_FOR_DEFRMENT = 
            "FIND_TRANSACTIONS_FOR_DEFRMENT";
        public static final String FIND_TRANSACTIONS_FOR_PAYMENT = 
            "FIND_TRANSACTIONS_FOR_PAYMENT";
            
        public static final String FIND_NOT_CANCELLED_DEFERMENTS = "FIND_NOT_CANCELLED_DEFERMENTS";
        
        public static final String FIND_DECLARATION_AWAITING_PAYMENT = 
            "FIND_DECLARATION_AWAITING_PAYMENT";
        public static final String FIND_DECLARATION_FOR_AMENDMENT = 
            "FIND_DECLARATION_FOR_AMENDMENT";
        public static final String FIND_DECLARATION_OFFENCE = 
            "FIND_DECLARATION_OFFENCE";
        public static final String FIND_DECLARATION_FOR_CLEARANCE = 
            "FIND_DECLARATION_FOR_CLEARANCE";
        public static final String FIND_DECLARATION_WITHDRAWAL = 
            "FIND_DECLARATION_WITHDRAWAL";
        public static final String FIND_DECLARATION_SAVED = 
            "FIND_DECLARATION_SAVED";
        public static final String FIND_DECLARATION_AWAITING_GUARANTEE = 
            "FIND_DECLARATION_AWAITING_GUARANTEE";

        public static final String VIEW_MANIFEST = "VIEW_MANIFEST";
        public static final String RECONCILE_MANIFEST = "RECONCILE_MANIFEST";
        public static final String AMEND_MANIFEST = "AMEND_MANIFEST";
    
        public static final String FIND_PAYMENTS_TO_RESOLVE = 
            "FIND_PAYMENTS_TO_RESOLVE";
        public static final String FIND_CASE_DOC_TIN = 
            "FIND_CASE_DOC_TIN";
        public static final String FIND_ENTITY_ENTITIES_TRANSFER_TAXPAYER = 
            "FIND_ENTITY_ENTITIES_TRANSFER_TAXPAYER";        
        public static final String FIND_APPROVED_EXEMPTIONS = "FIND_APPROVED_EXEMPTIONS"; 
        public static final String FIND_SUSPEND_EXEMPTIONS = "FIND_SUSPEND_EXEMPTIONS"; 
        public static final String FIND_CRED_ALLOC_TRAN_BY_REVENUE_TYPE = 
            "FIND_CRED_ALLOC_TRAN_BY_REVENUE_TYPE";  
        public static final String FIND_CRED_ALLOC_TRAN_BY_SUSPENSE = 
            "FIND_CRED_ALLOC_TRAN_BY_SUSPENSE";
        public static final String FIND_RETURNS_FOR_CANCEL = 
            "FIND_RETURNS_FOR_CANCEL";
        public static final String FIND_RETURNS_FOR_ADJUST = 
            "FIND_RETURNS_FOR_ADJUST";
            
        public static final String FIND_RETURNS_FOR_FILING = 
            "FIND_RETURNS_FOR_FILING";        
            
        public static final String FIND_RETURNS_FOR_FINAL_ADD = 
            "FIND_RETURNS_FOR_FINAL_ADD";
        public static final String FIND_RETURNS_FOR_PROVISIONAL_ADD = 
            "FIND_RETURNS_FOR_PROVISIONAL_ADD";
        public static final String FIND_RETURNS_FOR_PROVISIONAL_CANCEL = 
            "FIND_RETURNS_FOR_PROVISIONAL_CANCEL";
        public static final String FIND_RETURNS_FOR_FINAL_CANCEL = 
            "FIND_RETURNS_FOR_FINAL_CANCEL";
        public static final String FIND_RETURNS_FOR_ADJUST_FOR_FINAL = 
            "FIND_RETURNS_FOR_ADJUST_FOR_FINAL"; 
        public static final String FIND_CASES_BY_STATUS = "FIND_CASES_BY_STATUS";
        public static final String FIND_REFUNDS_FOR_PROCESS = "FIND_REFUNDS_FOR_PROCESS";
	public static final String FIND_TAX_COMPLIANCE_RULES = "FIND_TAX_COMPLIANCE_RULES";
        public static final String FIND_MAITAIN_AUTOMATIC_COMPLIANCE_SCHEDULING = "FIND_MAITAIN_AUTOMATIC_COMPLIANCE_SCHEDULING";
        public static final String FIND_CASES_FOR_REVIEW_OBJECTION = "FIND_CASES_FOR_REVIEW_OBJECTION";
        public static final String FIND_CASES_FOR_FINALISE_OBJECTION = "FIND_CASES_FOR_FINALISE_OBJECTION";
        public static final String FIND_CASES_FOR_LODGE_APPEAL = "FIND_CASES_FOR_LODGE_APPEAL";
        public static final String FIND_CASES_FOR_REVIEW_APPEAL = "FIND_CASES_FOR_REVIEW_APPEAL";
        public static final String FIND_CASES_FOR_FINALISE_APPEAL = "FIND_CASES_FOR_FINALISE_APPEAL";
        public static final String FIND_DOCUMENT_BY_PERIODS = "FIND_DOCUMENT_BY_PERIODS";
    }

    public interface SearchActionButtons {
        public static final String ADD_BUTTON = "ADD_BUTTON";
        public static final String NEXT_BUTTON = "NEXT_BUTTON";
        public static final String VIEW_BUTTON = "VIEW_BUTTON";
        public static final String EDIT_BUTTON = "EDIT_BUTTON";
        public static final String COPY_BUTTON = "COPY_BUTTON";
    }


    public interface TransactionStatus {
        public static final String CREATED = "CREATED";
        public static final String POSTED = "P";
        public static final String SUSPENDED = "SUSPEND";
        public static final String OFFSET = "OFFSET";
        public static final String REVERSED = "R";
        public static final String CANCELLED = "C";
        public static final String PENDING_REVERSAL = "X";
        public static final String TRANSFERRED_PAYMENT = "TP";
    }

    public interface TransactionLinkType {
        public static final String OFFSET_TRANS = "OFFSET";
        public static final String ACCOUNT_ADJUSTMENT = "ACCADJ";
    }

    public interface TransactionType {
        public static final String PAYMENT = "PAYMENT";
        public static final String CUSTOMS = "CUSDEC";
        public static final String DEFERMENT = "DEFERMENT";
        public static final String INTEREST = "INTEREST";
        public static final String SURCHARGE = "SURCHARGE";
        public static final String PENALTY = "PENALTY";
        public static final String LIABILITY = "LIABILITY";
        public static final String OFFSET = "OFFSET";
        public static final String REVERSE = "REVERSE";
        public static final String GUARANTEE_USAGE = "GUARANTEE_USAGE";
        public static final String REFUND = "REFUND";
        public static final String REGISTRATION = "REG";
        public static final String TRANSFER_PAYMENT = "TRANS_PYMT";
        public static final String PENALTY_IMPOSITION = "PEI";
        public static final String PENALTY_REMISSION = "PER";
        public static final String RETURN="RETURN";
        public static final String WRITEOFF = "WOF";
        public static final String CANCEL_INSTALLMENT = "CANCEL_INSTALLMENT";
        public static final String CANCEL_INTEREST = "CANCEL_INTEREST";
        public static final String CANCEL_SURCHARGE = "CANCEL_SURCHARGE";
        public static final String RETURN_CANCEL = "RETURN_CANCEL";
        public static final String CANCEL_RETURN = "CANCEL_RETURN";
        public static final String ODR = "ODR";
        public static final String OCR = "OCR";
        public static final String CREDIT = "CREDIT";
        public static final String DEBIT = "DEBIT";
    }


    public interface InstalmentAgreementStatus {
        public static final String SAVE = "SAVE";
        public static final String PENDING_APPROVAL = "PENDING_APPROVAL";
        public static final String POST = "POST";
        public static final String CANCEL = "CANCELLED";
        public static final String REJECTED = "REJECTED";
        public static final String APPROVED = "APPROVED";
        
    }
    
    public interface InstalmentStatus {
        public static final String DUE = "DUE";
        public static final String PAID= "PAID";
    }
    
    public interface RevenueDefermentPaymentStatus {
        public static final String PENDING = "PENDING";
        public static final String OPEN = "OPEN";
        public static final String CLOSED = "CLOSED";
        public static final String DEFAULTED = "DEFAULTED";
        public static final String REFUSED = "REFUSED";
        public static final String APPROVED = "APPROVED";
        public static final String REJECTED = "REJECTED";
        public static final String ACTIVE = "ACTIVE";
        public static final String INACTIVE = "INACTIVE";
        public static final String RELEASED = "RELEASED";
        public static final String ACQUIRED = "ACQUIRED";
        public static final String CANCELLED = "CANCELLED";
        public static final String DISAPPROVED = "DISAPPROVED";
        public static final String FULLY_PAID = "FULLY PAID";
    }
    
    public interface AcquiredAssetsStatus {
        public static final String SEIZED = "SEIZED";
        public static final String RELEASED = "RELEASED";
    }

    public interface CustomsControlPoint {
        String SUPERVISING = "SV";
    }

    public interface TaxCalculationSegments {
        public static final String HEADER = "H";
        public static final String ITEM = "I";
    }

    public interface TaxTypes {
        public static final String HEADER = "H";
        public static final String ITEM = "I";        
    }

    public interface AuthorisationStatus {
        String AUTHORISED = "AUTH";
    }

    //REF_INSP_OUTCOME

    public interface InspectionOutcomes {
        String CONTINUE = "NOIRREGULARITY";
    }

    //REF_INSP_STATUS

    public interface InspectionStatus {
        String OPEN = "OPEN";
        String CLOSED = "CLOSED";
    }

    public interface ConfigurationParameters {
        String CONTAINER_NUMBER_FORMAT = "CONTAINER_NUMBER_FORMAT";
        String VEHICLE_REG_NUMBER_FORMAT = "VEHICLE_REG_NUMBER_FORMAT";
        String AIRCRAFT_REG_NUMBER_FORMAT = "AIRCRAFT_REG_NUMBER_FORMAT";
        String REL_TYPE_OF_ENTITIES_TO_BE_TRANSFERED = 
            "REL_TYPE_OF_ENTITIES_TO_BE_TRANSFERED";
        String FREQUENT_TRANSFER_TAXPAYER_IDENTITY_FACTOR = 
            "FREQUENT_TRANSFER_TAXPAYER_IDENTITY_FACTOR";
        String MAX_TABLE_NAME_LENGTH = "MAX_TABLE_NAME_LENGTH";
        String FIELD_NAME_FORMAT = "FIELD_NAME_FORMAT";
    }

    public interface RouteIndicator {
        String CURRENT = "CUR";
        String PREVIOUS = "PRE";
        String FORWARD = "FOR";
    }


    public interface LogMessageType {
        String INFO = "INFO";
        String ERROR = "ERROR";
    }

    public interface FunctionalRole {

        String ADMINISTRATOR = "Administrator";
        String SUPERUSER = "Superuser";
        String OFFICER = "Officer";
        String CASEOFFICER = "CaseOfficer";
        String DETECTINGOFFICER = "DetectingOfficer";
        String REQUESTINGOFFICER = "RequestingOfficer";
        String OFFENCEOFFICER = "OffenceOfficer";
        String CANCELLATIONOFFICER = "CancellationOfficer";
        String SEARCHADMIN = "SearchAdmin";
        public static final String DECLARANT = "Declarant";
        public static final String VETTING_OFF = "Vetting Officer";
    }

    public interface ModuleName {
        String CASE_MANAGEMENT = "CASE_MANAGEMENT";
        String ACTIVITY_LOG = "ACTIVITY_LOG";
        String GENERIC_SEARCH = "GENERIC_SEARCH";
    }

    public interface NavigationIdConstants {
        String FLEX_TYPE_ID = "FLEX_TYPE_ID";
    }

    public interface SessionScopeVariables {
        String FLEXIBLE_FIELD = "FLEXIBLE_FIELD";
    }

    public interface Fault {
        public final String RULE_FAULT = "RULE_FAULT";

    }

    public interface OperatingAs {
        public static final String HEAD_OFFICE = "HEAD";
        public static final String BRANCH_OFFICE = "BRANCH";
        public static final String FACILITY = "FACILITY";
    }

    public interface FieldType {
        public static final String TIN_FORMAT = "tinformat";
    }


    public interface SecurityGroup{
        //if(role.equals("RevenueOfficer") || role.equals("RevenueSupervisor")){
         public static final String REVENUE_OFFICER = "RevenueOfficer";
         public static final String REVENUE_SUPERVISER = "RevenueSupervisor";
         public static final String ADMIN = "AdministratorGroup";
    }

    public interface RoleType {
        public static final String FUNCTIONAL = "F";
        public static final String MENU = "M";
        public static final String PERMISSION = "P";
        public static final String TASKS = "T";
        public static final String OFFICE = "O";
    }

    public interface ProcessConfig {
        public static final String TAXPAYER = "TAXPAYER";
        public static final String EMPLOYEE = "Employee";
    }
    
    public interface ReferenceIdentifier {
        public static final String REF_IDENTIFIER = "TripsUI";
    }

    public interface AttachmentType {
        public static final String TRANSFER_COMMITMENT_FORM = "TCF";
    }

    public interface IndustryOccupation {
        public static final String INDUSTRIAL = "Industrial";
        public static final String OCCUPATIONAL = "Occupational";
    }

    public interface TransferType {
        public static final String TAX_TYPE = "Tax Type";
        public static final String RETURN_PERIOD = "Return Period";
        public static final String TAXPAYER = "Taxpayer";
    }

    public interface AccountingType {
        public static final String DEBIT = "DEBIT";
        public static final String CREDIT = "CREDIT";
    }

    public interface ReconciliationStatus {
        public static final String CLAIMED = "Claimed";
        public static final String UNCLAIMED = "Unclaimed";
        public static final String PRECON = "Ignored";
        public static final String RECON = "Reconciled";
        public static final String UNRECON = "UnReconciled";
        public static final String NOT_FOUND = "Does not exist";
    }

    /**
     * The values in this set of constants must match the values from RefStagger entity
     */
    public interface PeriodCycleFrequency {
        public static final String MONTHLY = "Monthly";
        public static final String QUARTERLY = "Quarterly";
        public static final String ANNUALLY = "Annually";
        public static final String INDEFINITE = "Indefinite";
        public static final String TRANSACTIONAL = "Transactional";
        public static final String MULTIPLE = "Multiple";
    }
    
    public interface CaseEventStatus {
        public static final String NEW = "NEW";
        public static final String IN_PROGRESS = "IN PROGRESS";
        public static final String COMPLETED = "COMPLETED";
    }
    
    public interface AccountingTypePeriod {
        public static final String FISCAL = "FISCAL";
        public static final String CALENDAR = "CALENDAR";
    }
    
    public interface FilingMode {
        public static final String MANUAL="Manual";
        public static final String EFILING="e-Filing";
    }
    
    public interface PeriodType {
        public static final String CONSISTENT = "CONSISTENT";
        public static final String INCONSISTENT = "INCONSISTENT";
    }
    
    public interface DateCategory {
        public static final String HOLIDAY = "HD";
        public static final String LEGISLATIVE_DATE = "LD";
    }
    
    public interface DateSubCategory {
        public static final String NATIONAL_HOLIDAY = "N";
        public static final String LOCAL_HOLIDAY = "L";
    }
    
    public interface ColumnType {
        public static final String VARCHAR2 = "VARCHAR2";
        public static final String NUMBER = "NUMBER";
        public static final String DATE = "DATE";
    }
    
    public interface CaseManagementConstants{
        
        public static final String TRUE = "TRUE";
        public static final String FALSE = "FALSE";        
        public static final String OPEN = "OPEN";
        public static final String CLOSED = "CLOSED";  
        public static final String SUSPENDED = "SUSPENDED";  
        public static final String END_DATE = "12/31/9999";
        public static final String CASE_STATUS_CREATE_CATEGORY = "CMS_CASE_STATUS_CREATE";
        public static final String CASE_STATUS_SUSPEND_CATEGORY = "CMS_CASE_STATUS_SUSPEND";
        public static final String CASE_STATUS_CLOSE_CATEGORY = "CMS_CASE_STATUS_CLOSE";
        public static final String CASE_STATUS_RELEASE_CATEGORY = "CMS_CASE_RELEASE";
        public static final String CASE_STATUS_TRANSFER_CATEGORY = "CMS_CASE_TRANSFER";
        public static final String CASE_ASSIGNMENT_CATEGORY = "CMS_CASE_ASSIGNMENT";
        public static final String NEW = "NEW";
        public static final String PENDING = "PENDING";
        public static final String IN_PROGRESS = "IN PROGRESS";
        public static final String NOT_PERFORMED = "NOT PERFORMED";
        public static final String NOT_APPLICABLE = "NOT APPLICABLE";//TRPHL 1460
        public static final String COMPLETED = "COMPLETED";
        public static final String YES = "Y";
        public static final String NO = "N";
        public static final String UP = "UP";
        public static final String DOWN = "DOWN";
        public static final String AIRT = "AIR-T";
        public static final String ZERO ="0";
        public static final String MODE = "mode";
        public static final String ADD = "ADD";
        public static final String EDIT = "EDIT";
        public static final String REASON_AUDIT = "SREG01";
        public static final String DESIGNATION_LEAD = "DESIGNATION_LEAD";
        public static final String DESIGNATION_GS = "DESIGNATION_GS";
        public static final String DESIGNATION_RO = "DESIGNATION_RO";
        public static final String DESIGNATION_LEAD_CODE = "LEAD";
        public static final String DESIGNATION_GS_CODE = "GS";
        public static final String DESIGNATION_RO_CODE = "RO";
        public static final String CASE_DOC_INFILE = "In File";
        public static final String CASE_DOC_BORROWED = "Borrowed";
        
    }
    
    public interface AccountAdjustmentPenaltyTypes {
        public static final String COMPROMISE_PENALTY_IMPOSITION = "COMPEI";
        public static final String INTEREST_PENALTY_IMPOSITION = "INTPEI";
        public static final String SURCHARGE_PENALTY_IMPOSITION = "SURPEI";
        public static final String ALL_PENALTY_REMISSION = "ALLPER";
        public static final String COMPROMISE_PENALTY_REMISSION = "COMPER";
        public static final String INTEREST_PENALTY_REMISSION = "INTPER";
        public static final String SURCHARGE_PENALTY_REMISSION = "SURPER";
    }

    public interface JobParameters{
        final String NUMBER_OF_MONTHS_LEFT_BEFORE_LAST_PERIOD_RUNS_OUT = "NUMBER_OF_MONTHS_LEFT_BEFORE_LAST_PERIOD_RUNS_OUT";
        final String RTP_REACTIVATION_REASON = "RTP_REACTIVATION_REASON";
        final String RTP_REACTIVATED_STATUS = "RTP_REACTIVATED_STATUS";
        final String NO_OF_DAYS_LOGS_TO_BE_SHOWN = "NO_OF_DAYS_LOGS_TO_BE_SHOWN";
        final String NUMBER_OF_RECORDS_TO_BE_PROCESSED_AT_A_TIME = "NUMBER_OF_RECORDS_TO_BE_PROCESSED_AT_A_TIME";
    }
    
    public interface BatchJobs{
        final String PERIODS_GENERATION_JOB = "PERIODS_GENERATION_JOB";
        final String UPDATE_DUE_DATE_JOB = "UPDATE_DUE_DATE_JOB";
        final String REACTIVATE_TAXPAYERS_JOB = "REACTIVATE_TAXPAYERS_JOB";
    }

    public interface BatchStatus{
        final String SUBMITTED = "Submitted";
        final String CREATED = "Created";
        final String RECEIVED = "Received";
        final String PROCESSED = "Processed";
        final String PROCESSING = "Processing";
        final String PASS = "PASS";
        final String FAIL = "FAIL";
        final String NEW = "NEW";
        final String COMPLAINT = "Complaint";
    }
    
    public interface ReportEngine {
        public static final String JASPER = "JASPER_SERVER";
        public static final String XMLPUBLISHER = "XMLPUBLISHER";
    }  
    
    public interface ContentType{
        public static final String APPLICATION_EXCEL="application/vnd.ms-excel";
        public static final String APPLICATION_PDF="application/pdf";
        public static final String APPLICATION_HTML="text/html";
        public static final String APPLICATION_RTF="application/rtf";
    }
    
    public interface PaymentSuspensionErrorCodes {
         public static final String NO_TIN_FOUND = "IT"; 
         public static final String INVALID_TIN_CHECK_DIGIT = "IC" ;
         public static final String TIN_UNREGISTERED_IN_RDO = "UR";
         public static final String MISMATCH_INDIVIDUAL_NAME = "MI";
         public static final String MISMATCH_NONINDIVIDUAL_NAME = "MN";
         public static final String INVALID_TAX_TYPE = "UT";
         public static final String INVALID_RETURN_PERIOD = "IP";
         public static final String NO_RETURN_PERIOD = "NP";
         public static final String INVALID_FORM_TYPE = "IFT";
         public static final String NULL_RETURN_PERIOD_COMPONENT = "NC";
         public static final String UNREGISTERED_ACCOUNTING_TYPE = "NF";
         public static final String ACCOUNTING_TYPE_MISMATCH = "NM";
         public static final String NULL_TCC_NUMBER = "NT";
         public static final String OUT_OF_DISTRICT_TIN = "ODT";
         public static final String TAXTYPE_NOTFOR_BRANCH_FILER = "NB";
         public static final String DIFFERENT_BRANCH_EXISTS = "DB";
         public static final String INVALID_DRAWEE_BANK = "LID";
         public static final String NULL_CHECK_NUMBER = "NCN";
         public static final String DUPLICATE_TDM = "DTDM";
    }
    
    public interface CollectionAgentTypes {
         public static final String DRAWEE_BANK = "DBK"; 
         public static final String GOVERNMENT_BANK = "GOVBANK";
         public static final String REVENUE_COLLECTION_OFFICER = "R";
    }
    
    public interface RefundAuthorizationTypes{
        public static final String APPROVE = "Approve"; 
        public static final String RECOMMEND = "Recommend"; 
    }
    
    public interface OfficeType{
        public static final String RDO = "OFFICE";
        public static final String REGIONAL_OFFICE = "RR";
        public static final String NATIONAL_OFFICE = "NO";
    }
    
    public interface MannerOfIssuance{
        public static final String ORIGINALLY_ISSUED = "ORG_ISS";
    }
    
    public interface ComplianceCaseStatus{
        public static final String CREATED = "C";
        public static final String FOR_CLOSURE = "FC";
        public static final String CASE_CLOSE= "CC";
    }

    
    public interface ReasonForFilingTaxCreditRefund {
        public static final String OVER_PAY = "OVER_PAY";
        public static final String CLAIM_EPT = "CLAIM_EPT";
    }
    
    public interface ValidateFlagsForTaxCreditRefund {
        public static final String VALIDATE_SUBMISSION = "VALIDATE_SUBMISSION";
        public static final String VALIDATE_FRAUD_CASES = "VALIDATE_FRAUD_CASES";
        public static final String VALIDATE_REASON_FOR_FILING = "VALIDATE_REASON_FOR_FILING";
    }
    
    public interface CasesForDisapprovalOfRefund {
        public static final String NOT_QUALIFIED = "NOT_QUAL";
        public static final String NO_DOCUMENTATION = "NO_DOC";
        public static final String OUT_OF_PERIOD = "OUT_PER";
    }
    
    public interface TaxCreditRefundModeOfClaim{
        public static final String TAX_REFUND = "TAX_R";
        public static final String TAX_CREDIT_CERTIFICATE = "TAX_TCC";
    }
    
    public interface RelationshipCategory {
        public static final String EMPLOYER = "Employer";
        public static final String EMPLOYEE = "Employee";
        public static final String BASIC = "Basic";
    }
    
    public interface TaxCreditRefundPaymentMode {
        public static final String CHEQUE = "CHEQUE";
        public static final String TRN = "TRN";
    }
    
    public interface AuditCommonColumnCodes {
        public static final String ENT_ENTITY_ID = "ENT_ENTITY_ID";
        public static final String TAX_TYPE = "TAX_TYPE";
        public static final String PERIOD_START="PERIOD_START";
        public static final String PERIOD_END="PERIOD_END";
        public static final String DERIVED_PERIOD_START = "DERIVED_PERIOD_START";
        public static final String DERIVED_PERIOD_END = "DERIVED_PERIOD_END";
        public static final String CASES_TO_ADD_EXCEPTIONS = "CASES_TO_ADD_EXCEPTIONS";
        public static final String FOR_CONSOLIDATION = "FOR_CONSOLIDATION";
        public static final String AUDIT_PROFILE_ID_PREFIX = "AP";
    }
    
    public interface PaymentChequeStatus{
        public static final String BAD = "BAD";
    }
    
    public interface LegalStatus{
        public static final String EO98 = "EO98";
        public static final String SoleProprietor = "SOLPROP";
        public static final String LIMITED_LIABILITY_COMPANY = "LLC";
        public static final String PUBLIC_LIMITED_LIABILITY = "PLLC";
        public static final String UNLIMITED_LIABILITY_COMPANY = "ULC";
        public static final String PARTNERSHIP = "PARTS";
        public static final String[] COMPANY_REG_REQUIRED_LIST = 
            new String[]{LIMITED_LIABILITY_COMPANY};
        public static final String DIPLOMATIC = "REGORG";
        public static final String GOVERNMENT_MDA_MMDA = "GOV";
        public static final String INDIVIDUAL_DIPLOMAT = "DIPLOMAT";
        public static final String MDA = "MDA";
        public static final String MMDA = "MMDA";
        public static final String SOLE_PROPRIETOR = "SOLPROP";
        public static final String FOREIGN_MISSION = "FRGN";
        public static final String EMPLOYEE = "EMP";
        public static final String SELF_EMPLOYED = "SELFEMP";
        public static final String OTHER = "OTHER";
        public static final String DIPLOMAT = "DIPLOMAT";
    }
    
    public interface RefundAssessment {
        public static final String FAVORABLE = "FAVORABLE";
        public static final String UNFAVORABLE = "UNFAVORABLE";
    }
    
    public interface ScriptManager {
        public static final String CLASS_TYPE_FUNCTIONS = "Functions";
        public static final String CLASS_TYPE_SERVICE_CLASS = "Service Class";
    }
    
    public interface ScriptNames {
        public static final String GET_NEW_IND_DUPL_CHECK_CRITERIAS = "getNewIndDuplCheckCriterias";
        public static final String GET_IND_UNIQUE_ID_CHECK_CRITERIAS = "checkIndEntityUniqueId";
        public static final String GET_NEW_ORG_DUPL_CHECK_CRITERIAS = "getNewOrgDuplCheckCriterias";
        public static final String CHECK_NEW_INDIVIDUAL_ENTITY_DUPLICATE = "checkNewIndividualEntityDuplicate";
        public static final String CHECK_NEW_ORGANIZATION_ENTITY_DUPLICATE = "checkNewOrganizationEntityDuplicate";
        public static final String GET_MATCH_THRESHOLD_FOR_IND_DUP_CHECK = "getMatchThresholdForIndDupCheck";
        public static final String GET_MATCH_THRESHOLD_FOR_ORG_DUP_CHECK = "getMatchThresholdForOrgDupCheck";
        public static final String GET_IMPLICIT_REGIMES = "getImplicitRegimes";
        public static final String GET_TIN_NUMBER_SEQUENCE = "getTinNumberSequence";
        public static final String GET_EXISTING_IND_DUPL_CHECK_CRITERIAS = "getExistingIndDuplCheckCriterias";
        public static final String GET_EXISTING_ORG_DUPL_CHECK_CRITERIAS = "getExistingOrgDuplCheckCriterias";
        public static final String CHECK_EXISTING_INDIVIDUAL_ENTITY_DUPLICATE = "checkExistingIndividualEntityDuplicate";
        public static final String CHECK_EXISTING_ORGANIZATION_ENTITY_DUPLICATE = "checkExistingOrganizationEntityDuplicate";
    }
    
    public interface ScriptContext {
        public static final String DATA_OBJECT = "dataObject";
        public static final String EXISTING_TYPE = "existingType";
        public static final String LEGAL_STATUS = "legalStatus";
        public static final String RGD_REGISTRATION = "rgdRegistration";
    }
    
    public interface ShareholdersPartners{
        public static final String TELEPHONE = "Telephone";
        public static final String EMAIL_ADDRESS = "EmailAddress";
        public static final String ADDRESS = "Address";
        public static final String TIN = "tin";
        public static final String ENTITY_NAME = "entityName";
    }
    

    
    public interface SearchColumnNames {
        String ADDRESS = "ADDRESS";
        String CONTACTDETAILS = "ContactDetails";
        String ENTITY_NAME = "entityName";
        String TIN = "tin";
        String ID = "ID";
    }
   
    public interface AccountTypes {
        public static final String SUSPENSE = "SUSPENSE";
        public static final String REVENUE = "REVENUE";
        public static final String GUARANTEE = "GUARANTEE";
        public static final String TRANSACTIONAL = "TRA";
        public static final String PERIODIC = "PER";
        public static final String ENTITY = "ENT";
    }
    
    public interface Address{
        public static final String LOCAL_BUSINESS_ADDRESS="LBA";
        public static final String LOCAL_RESIDENCE_ADDRESS="LRA";
        public static final String FOREIGN_BUSINESS_ADDRESS="FBA";
        public static final String FOREIGN_RESIDENCE_ADDRESS="FRA";
        public static final String LOCAL_POSTAL_ADDRESS="LPA";
        public static final String LOCATION_ADDRESS="LOA";
    }
    
    /**
     * for the Notes.JSPX
     * 
     * **/
     public interface NotesType{
         public static final String  PHYADD_CODE = "PHY_ADDR";
         public static final String  NBUSSL_CODE = "NAT_BUSS";
         public static final String  RGDSTU_CODE = "RGD_STAT";
         public static final String  OTHERS_CODE = "OTHERS";
     
     }
     
     public interface MandatoryFields{
         public static final int RGD_Length = 11;
     }
     
    public interface OccupationDetails{
        public static final String OCCUPATION_EMPLOYED="Employed";
    }
    
    public interface UniqueDataVerification {
        public static final String EMPLOYER_TIN = "employerTIN";
    }
    public interface EntTaxpayerTurnoverRefData{
         public static final String TURNOVER_TYPE_TOT_TO = "TOT_TO";
        public static final String TURNOVER_TYPE_TAX_TO = "TAX_TO";
    }

    public interface MiscellaneousEntity{
        public static final String MDA = "MDA";
        public static final String C0_OPERATIVE = "COOP";
        public static final String FOREIGN_MISSION = "FRGN";
        public static final String TRUST = "TRUST";
        public static final String MMDA = "MMDA";
        public static final String  PUBLIC_INSTITUTION= "PBLI";
        public static final String  GOV= "GOV";
        public static final String  OTHER= "OTHER";
    }

    public interface TinFormate {
        public static final String INDIVIDUAL_ENTITY_TYPES ="P";
        public static final String FROM_RGD="C";
        public static final String GOVERNMENT_MDA_MMDA="G";
        public static final String FOREIGN_MISSION="Q";
        public static final String FOR_ALL_OTHERS="V";
        public static final int MAX_PADDING=9;
        public static final String PADDING_CHAR="0";
    }
    
    public interface TaskDetails {
        public static final String REDIRECTED_TO_NOTIFICATION = "REDIRECTED_TO_NOTIFICATION";
        public static final String REDIRECTED_FROM_NOTIFICATION = "REDIRECTED_FROM_NOTIFICATION";
        public static final String REVISION = "REVISION";
        public static final String VERIFY_IDENTITY = "VerifyIdentification";
        public static final String OPEN = "OPEN"; 
        public static final String CLOSE = "CLOSE";     
        public static final String MISCELLANEOUS_VERIFIACTION = "MiscellaneousVerification";        
    }
    
    public interface BusinessLogicValidatorType {
        String ENTITY_VALIDATOR = "ENTITY_VALIDATOR";
    }
    
    
    public interface SearchSpecialOperator{
        String PURIFY_FIELD_REMOVE_CHARS = "PURIFY_FIELD_REMOVE_CHARS";
    }
    
    public interface CodesList {
        String RGD_LEGAL_STATUSES = ",LLC,PARTS,EXTORG,SUBS,CLG,ULC,PLLC,";
        String MISCELLANEOUS_ENTITY = ",MDA,COOP,FRGN,TRUST,MMDA,PBLI,";
    }

    
    public interface BusinessSectorDataVerification {
        public static final String CODE = "code";
    }
    
    public interface PrimaryDataVerification {
        public static final String CODE = "code";
        public static final String DESCRIPTION = "description";
        public static final String PRIMARY = "primaryIndicator";
    }

    
    public interface DeRegistration {
        public static final String REGIME_DEREGISTRATION = "RegimeDeregistration";
    }
    
    public interface TaskDefinitions {
        public static final String APPROVE_AMEND_TAXPAYER = "ApproveAmendTaxpayer";
        public static final String AMEND_TAXPAYER_REVISION = "AmendTaxpayerRevision";
        public static final String APPROVE_AMEND_ORGANISATION = "ApproveOrganization";
    }

    public interface DescriptionColumnName{
        String DESCRIPTION = "description";
    }

    
    public interface TransferTaxpayerBatch {
    public static final String TIN_STATUS_PENDING = "PENDING";
    public static final String TIN_STATUS_PROCESSING = "PROCESSING";
    public static final String TIN_STATUS_PROCESSED = "PROCESSED";
    public static final String TIN_STATUS_FAILED = "FAILED";
    public static final String TIMEOUT_COMPARE_STRING = "timed out";
    }


    
    public interface TaxpayerEntities{
        public static String REG_SIMPLIFIED_KEY       = "SIMPLIFIED";
        public static String REG_TAXPAYER_KEY         = "TAXPAYER";
        public static String REG_TAXPAYER_REVENUE_KEY = "REVENUE";
    }
    
    public interface TaxpayerTypes{
        public static String BUSINESS       = "BUS";
        public static String INDIVIDUAL     = "IND";
    }
    
    //Code copied from Cayman start
    public interface Users {
        public static final String DEF_SYS_CREATED_BY = "SYSTEM";
        public static final String DEF_SYS_UPDATED_BY = DEF_SYS_CREATED_BY;
    }
    
    public interface AllocationMethods{
        public static final String REVENUE = "REVENUE";
        public static final String TAX = "TAX";
        public static final String AMOUNT = "AMOUNT";
        public static final String TIME = "TIME";
        public static final String REVENUE_TYPE = "RET";
    }
    public interface AllocationTypes{
        public static final String DEBT = "DEBT";
        public static final String PAYMENT = "PAYMENT";
        public static final String CREDIT = "CREDIT";
        public static final String DEBIT = "DEBIT";
        public static final String CREDIT_ALLOCATION = "Credit Allocation";
        public static final String DEBIT_ALLOCATION = "Debit Allocation";
    }
    
    public interface AllocationCriterias{
        public static final String HIGH = "HIGH";
        public static final String LOW = "LOW";
        public static final String FIFO = "FIFO";
        public static final String LIFO = "LIFO";
    }
    
   
     public interface ReasonCodes{
         public static final String REV_COLL_PAYMENT_MADE = "REV_COLL_PAYMENT_MADE";
         public static final String REV_COLL_PAYMENT_REVERSED = "REV_COLL_PAYMENT_REVERSED";
     }
     
    public interface PaymentInstrumentStatuses{
        public static final String SUBMITTED = "SUBMITTED";
        public static final String REVERSED = "REVERSED";
        public static final String PENDING_REVERSAL = "PENDING_REVERSAL";
        public static final String NEW = "NEW";
    }
     
    public interface ReceiptStatuses{
        public static final String PAID = "PAID";
        public static final String REVERSED = "REVERSED";
        public static final String PENDING_REVERSAL = "PENDING_REVERSAL";
    }
    public interface DfinRevenueCollectionInstruments{
        public static final String CASH = "DFIN_REV_COLL_INSTR_CASH";
        public static final String CHEQUE = "CHQ";
        public static final String BANKERS_DRAFT = "DRAFT";
        public static final String CARD = "DFIN_REV_COLL_INSTR_CARD";
        public static final String DEBIT_CARD = "DBTCRD";
        public static final String CREDIT_CARD = "CCRD";
    }
    
    public interface PaymentMethod {
        public static final String CHEQUE = "CHQ";
        public static final String CASH = "CASH";
        public static final String BANKERS_DRAFT = "DRAFT";
        public static final String CARD = "4";
        public static final String CREDIT_CERTIFICATE = "CRED CERT";
        public static final String TDM = "TDM";
        public static final String TRA = "TRA";
        public static final String SARO = "SARO";
        public static final String TSDM = "TSDM";
    }
    
    public interface PaymentSource {
        public static final String WEB_PORTAL = "PORTAL";
    }
     //Code copied from cayman end
    public interface IdentificationType {
        public static final String PASSPORT="PASS";
        public static final String EXT_AUTH="EXT_AUTH";
        public static final String DRV="DRV";
        public static final String NID="NID";
    }
    
    public interface IdVerificationType {
        public static final String AUTO="AUTO";
        public static final String MANUAL="MANUAL";
    }
    
    public interface SearchCriteriaFields {
        public static final String FIRST_NAME = "firstName";
        public static final String MIDDLE_NAME = "middleName";
        public static final String LAST_NAME = "lastName";
        public static final String DATE_OF_BIRTH = "dateOfBirth";
        public static final String IDENTIFICATION_NUMBER = "identificationNumber";
        public static final String COMPANY_NAME = "companyName";
        public static final String FLEXIBLE_FORM_TYPE_ID = "flexibleFormTypeId";
    }

    public interface IdentificationErrorMessages {
        public static final String IDENTIFICATION_CODE = "Identification";
        public static final String IDENTIFICATION_MESSAGE = 
            "Invalid Identification Details";
        public static final String EXT_AUTH = 
            "The verification of the unique identity for Taxpayer with Voters Card Number ";
        public static final String PASSPORT = 
            "The verification of the unique identity for Taxpayer with Passport Number ";
        public static final String DRV = 
            "Verification of the unique identity for Taxpayer with Driving License Number ";
        public static final String NID = 
            "Verification of the unique id for Taxpayer with National Id Number ";
        public static final String UNSUCCESSFUL = " is unsuccessful";
        public static final String PASSPORT_ALREADY_INUSE = 
            "Duplicate Passport ID: Already exist in trips";
        public static final String DRV_ALREADY_INUSE = 
            "Duplicate Driving License ID: Already exist in trips";
        public static final String NID_ALREADY_INUSE = 
            "Duplicate National Id Number : Already exist in trips";
        public static final String EXT_AUTH_ALREADY_INUSE = 
            "Duplicate Voters Card Number: Already exist in trips";
        public static final String CONNECTION_FAILED = "CONNECTION_FAILED";
        public static final String EXT_AUTH_CF = 
            "Unable to connect to the Electoral Register web service";
        public static final String DRV_CF = 
            "Unable to connect to the DVLA web service";
        public static final String NID_CF = 
            "Unable to connect to the NIA web service";
    }

    public interface PeriodConfiguration {
        public static final String APPPLY_YES = "Y";
        public static final String APPPLY_NO = "N";
        public static final String EMPTY_STRING = "";
        public static final String FORMULA_DELIMITERS = ",";
        public static final String STATUS_YES = "A";
        public static final String STATUS_NO = "I";
        public static final String FILING_FREQUENCY[] = {"Monthly","Quarterly","Annually"};
    }
    
    public interface MaintainAllocationRules {
        public static final String PRIORITY = "priority";
        public static final String METHOD = "allocationMethod";
    }
    
    public interface AdjustmentTypes {
        public static final String DEBIT="DEBIT";
        public static final String CREDIT="CREDIT";
    }

    public interface AccountAdjustment{
        public static final String TIN="tin";
        public static final String ENTITY_NAME="entityName";
        public static final String ENT_ID="entId";
        public static final String PERIOD_NO="periodNo";
        public static final String PERIOD_YEAR="periodYear";
        public static final String ACC_ACCOUNT="accAccount";
        public static final String PERIOD_ID="periodId";
        public static final String TAX_TYPE_CODE="taxTypeCode";
        public static final String TRANSACTION_REFERENCE="transactionRef";
        public static final String CHART_OF_ACCOUNT_ID="chartOfAccountId";
    }


    public interface CreditAllocation {
        public static final String ID = "Id";
        public static final String PERIOD_MONTH = "PeriodMonth";
        public static final String PERIOD_YEAR = "PeriodYear";
        public static final String DOCUMENT_TYPE = "DocumentType";
        public static final String DOC_TYPE = "DocType";
        public static final String PERIOD_ID = "PeriodId";
        public static final String TRANSACTION_DATE = "TransactionDate";
        public static final String TRANSACTION_REF = "TransactionRef";
        public static final String BALANCE = "Balance";
        
        // Variables used when Credit Allocation is searched for View 
         public static final String CR_DOC_TYPE = "CrDocType";
         public static final String DR_DOC_TYPE = "DrDocType";

        }


    public interface ReceiptType {
        public static final String TIN = "tin";
        public static final String NAME = "name";
        public static final String RECEIPT_NO = "receipt_no";
        public static final String RECEIPT_DATE = "receipt_date";
        public static final String PAYMENT_INSTRUMENT = "payment_instrument";
        public static final String INSTRUMENT_NUMBER = "instrument_number";
        public static final String BANK_NAME = "bank_name";
        public static final String ACCOUNT_NUMBER = "account_number";
        public static final String PAYMENT_AMOUNT = "payment_amount";
    }
    
    public interface DueDateSpan {
        public static final String MONTH = "MONTH";
        public static final String DAY = "DAY";
        public static final String YEAR = "YEAR";
    }
	 public interface DuePeriod {
		public static final String CURRENT_PERIOD = "CP";
        public static final String PREVIOUS_PERIOD = "PP";
        public static final String NEXT_PERIOD = "NP";
    }
    
    public interface DayType {
        public static final String WORKING = "WORK";
        public static final String CALENDER = "CAL";
        public static final String FIXED_DATE = "FD";
    }
    
    
    public interface MaintainChartOfAccounts {
        public static final String CATEGORY_BASE = "";
    }
    public interface RefStatus {
        public static final String ACTIVE = "Active";
        public static final String INACTIVE = "Inactive";
        public static final String DELETED = "DELETED";
        public static final String ACTIVE_CODE = "A";
        public static final String INACTIVE_CODE = "I";
        public static final String DELETED_CODE = "D";
    }
    public interface ImportType {
        public static final String FLEX = "FLEX";
        public static final String GUI = "GUI";
        public static final String SEARCH = "SEARCH";
    }
    public interface ReturnsLodgement{
            public static final String TIN="tin";
            public static final String ENTITY_NAME="TaxpayerName";
            public static final String DOC_TYPE="DocumentType";
            public static final String PERIOD_NO="PeriodNumber";
            public static final String PERIOD_YEAR="PeriodYear";
            public static final String PERIOD_START_DATE="PeriodStart";
            public static final String PERIOD_END_DATE="PeriodEnd";
            public static final String PERIOD_DUE_DATE="PeriodDueDate";
            public static final String ACCOUNT_NUMBER="AccountNumber";
            public static final String D_Type="dType";
        }
    public interface ExemptionApplication{
    public static final String TIN="tin";
    public static final String ENTITY_NAME="TaxpayerName";
    public static final String POSTAL_ADDRESS="PostalAddress";
    public static final String RESIDENTIAL_ADDRESS="ResidentialAddress";
    public static final String PERIOD_YEAR="PeriodYear";
    public static final String TEL="Tel";
    public static final String EMAIL="Email";
    public static final String EntityID="EntityID";
    public static final String ExemptionId="ExemptionId";
    public static final String ENTITY_TYPE="entityType";
    public static final String APP_STATUS="applicationStatus";
    }
    
    public interface ExtendReturnDueDate{
        public static final String TIN="tin";
        public static final String ENTITY_NAME="TaxpayerName";
    }
        
    public interface SubmissionModes {
        public static final String PAPER = "PAPER";
        public static final String WEB = "WEB";
        public static final String EDI = "EDI";
    }
    
    public interface TillStatus {
        public static final String REQUESTED = "REQUESTED";
        public static final String OPEN = "OPEN";
        public static final String SUSPENDED = "SUSPENDED";
        public static final String CLOSED = "CLOSED";
        public static final String UNRECONCILED = "UNRECONCILED";
        public static final String APPROVED = "APPROVED";
        public static final String PEND = "PEND";
        
    }

    public interface PortalConstants{
    
        public static final String IND_AMEND_CEO = "IND_AMEND_CEO";
        public static final String PORTAL_USER = "PORTAL_USER";
        public static final String OFFICER_PREFIX = "Portal";
        public static final String IND_AMEND_CON = "IND_AMEND_CON";
        public static final String IND_AMEND_CPD = "IND_AMEND_CPD";
        public static final String SP_AMEND_CCD = "SP_AMEND_CCD";
        public static final String IND_AMEND_CCD = "IND_AMEND_CCD";
        public static final String SP_AMEND_CON = "SP_AMEND_CON";
        public static final String IND_AMEND_TTR = "IND_AMEND_TTR";
        public static final String ORG_AMEND_CPD = "ORG_AMEND_CPD";
        public static final String IND_AMEND_COP = "IND_AMEND_COP";
        public static final String ORGUPD_TT = "ORGUPD_TT";
        public static final String CON = "CON";
        public static final String PAGE_CONFIG = "CRUD";
        public static final String CASH = "CASH";
        public static final String PORTAL = "PORTAL";
        public static final String GHS = "GHS";
        public static final String CREDIT = "CREDIT";
        public static final String  SUBMITTED ="SUBMITTED";
        public static final String  EPAYMENT ="E-PAYMENT";
     
     
        public static final String SUBMISSION_MODE = "submissionMode";
         public static final String CREATED_BY = "createdBy";
         public static final String UPDATED_BY = "updatedBy";
         public static final String CREATED_DATE = "createdDate";
         public static final String DOC_ID = "docId";
         public static final String TIN = "tin";
         public static final String ATTACHMENT = "Attachment";
         
         public static final String FORM_RETURN_TYPE = "Return Type";
         public static final String FORM_TAX_TYPE = "Tax Type";
         public static final String FORM_PAGE_MODE = "Page Mode";
         public static final String CURRENCY = "Currency";
         public static final String NILRETURN = "nilReturn";
         public static final String NIL_RETURN = "NIL_RETURN";
         public static final String TOTAL_AMOUNT_TO_POST = "TOTAL_AMOUNT_TO_POST";
         public static final String NEGATIVE = "Negative";
         
        public static final String UPDATE_SUCCESS_CODE = "IND_AMEND_SUCCESS";
        public static final String UPDATE_FAILURE_CODE = "IND_AMEND_FAIL";
        
        
        public static final String INV_DOC_TYPE_CODE = "INV_DOC_TYPE";
        public static final String INV_DOC_TYPE_DESC = "Invalid doc type given.";
        
        public static final String INV_FORM_NAME_CODE = "1033";
        public static final String INV_FORM_NAME_DESC = "Invalid form name.";
        
        public static final String INV_FIELD_NAME_CODE = "1034";
        public static final String INV_FIELD_NAME_DESC = "The field names in the given list not matching with the flexible form fields requested: %s.";
         
        public static final String SERVER_ERROR_CODE = "1035";
        public static final String SERVER_ERROR_DESC = "Internal server error. Please contact system administrator.";
        
        public static final String REMOTE_FAULT_CODE = "1049";
        public static final String REMOTE_FAULT_DESC = "Please ensure the entered data is correct to avoid table constraints violations";
        
        public static final String DDOC_CODE = "1036";
        public static final String DDOC_DESC = "Please ensure the correct Ddoc ID.";
        
        
        public static final String  INV_PERIOD_DETAILS_CODE = "1050";
        public static final String  INV_PERIOD_DETAILS_DESC = "Invalid Period number or Period year or doc type associated with the TIN. ";       
       
        
        public static final String  INV_CLIAM_DATE_CODE = "1051";
        public static final String  INV_CLIAM_DATE_DESC = "Claim Date cannot be future date.";  
        
        public static final String  INV_PERIOD_FORMAT_CODE = "1052";
        public static final String  INV_PERIOD_FORMAT_DESC = "Please enter the the period in the given format ??/????";   
         
        public static final String  NOT_ENOUGH_CREDIT_CODE = "1053";
        public static final String  NOT_ENOUGH_CREDIT_DESC = "There is not enough credit available for the refunds transaction.";
        
         public static final String NO_CREDIT_AVAILABLE_CODE = "1054";
         public static final String NO_CREDIT_AVAILABLE_DESC = "There is no credit available for the refunds transaction.";
         
         public static final String DUPLICATE_REFUNDS_APP_CODE = "1055";
         public static final String DUPLICATE_REFUNDS_APP_DESC = "Duplicate Refunds Application found for the same taxpayer.";
         
         public static final String  DUPLICATE_FIELD_NAME_CODE= "1056";
         public static final String  DUPLICATE_FIELD_NAME_DESC= "Duplicate field name %s found.";
         
         public static final String INV_DECLARANT_TIN_CODE = "1057";
         public static final String INV_DECLARANT_TIN_DESC = "Declarant TIN is not valid or does not exist.";
         
         public static final String  EXEMPTION_REJECTED_CODE= "1058";
         public static final String  EXEMPTION_REJECTED_DESC= "Exemption application - Rejected.";
          
         public static final String   INV_EXEMPTION_DETAILS_CODE = "1060";
         public static final String   INV_EXEMPTION_DETAILS_DESC = "Wrong Exemption Code or tax type or return type. Please check extract exemption codes for the details";
        public static final String DATA_REF_CODE = "1014";
        public static final String DATA_REF_DESC = "Input code %s is not a valid choice for property %s. Please ensure your code listing is up to date.";
        
         
        
        public static final String INV_TIN_CODE = "1009";
        public static final String INV_TIN_DESC ="Search for Taxpayer with TIN %s was unsuccessful.";
        
        
   
         public static final String  TAX_TYPE_NOT_REGISTERED_CODE= "1068";
         public static final String  TAX_TYPE_NOT_REGISTERED_DESC= "Tax type %s is not registered with the TIN %s.";
        
        public static final String REC_NOT_FOUND_CODE = "1023";
        public static final String REC_NOT_FOUND_DESC = "Data to be updated or deleted cannot be found.";
        
        public static final String REC_ALREADY_EXISTS_CODE = "1022";
        public static final String REC_ALREADY_EXISTS_DESC = "Data to be created or updated already exists.";
		       
        public static final String INV_TRUE_PRIMARY_INDICATORS_CODE = "1025";
        public static final String INV_TRUE_PRIMARY_INDICATORS_DESC = "One item (and only one) in the list must be marked 'primary'";
        
        public static final String CREATE = "Create";
        public static final String UPDATE = "Update";
        public static final String DELETE = "Delete";
        public static final String EMPLOYER = "Employer";
        
        public static final String  TAX_TYPE_NOT_ACTIVE_CODE= "1071";
        public static final String  TAX_TYPE_NOT_ACTIVE_DESC= "Tax type %s is not Active to update.";
         
        public static final String  NO_TAX_TYPE_ASSOCIATED_CODE= "1073";
        public static final String  NO_TAX_TYPE_ASSOCIATED_DESC= "No Tax Type is registered with the TIN.";
		public static final String  DEREG_DATE_GREATER_THAN_REG_DATE_CODE= "1074";
        public static final String  DEREG_DATE_GREATER_THAN_REG_DATE_DESC= "Deregistration date must be greater than date of registration.";
		public static final String  EDD_GREATER_THAN_PERIOD_END_DATE_CODE= "1075";
        public static final String  EDD_GREATER_THAN_PERIOD_END_DATE_DESC= "EDD should be greater than the period end date of the latest transaction.";
		public static final String  TAX_TYPE_ACTIVE_CODE= "1076";
        public static final String  TAX_TYPE_ACTIVE_DESC= "Only 'Active' Tax Types are eligible for de-registration.";
		public static final String  TAX_TYPE_PENDING_STATUS_CODE= "1077";
        public static final String  TAX_TYPE_PENDING_STATUS_DESC= "Taxpayer with pending approval for tax type cannot be deregistered.";
		public static final String  TAX_TYPE_DEREG_CODE= "1078";
        public static final String  TAX_TYPE_DEREG_DESC= "The Tax type has already deregistered.";
		public static final String  TAX_TYPE_LIABILITY_EXISTS_CODE= "1079";
        public static final String  TAX_TYPE_LIABILITY_EXISTS_DESC= "%s - Liability exists; the tax type cannot be de-registered.";
		public static final String  TAX_TYPE_NOT_ASSOCIATED_CODE= "1080";
        public static final String  TAX_TYPE_NOT_ASSOCIATED_DESC= "Tax type %s is not associated with the TIN.";
		
			
         public static final String  NO_TAX_TYPE_SUSPENDED_CODE= "1081";
         public static final String  NO_TAX_TYPE_SUSPENDED_DESC= "No Tax Type is to be Reactivated with the TIN.";	
         
         public static final String  REACTIVATION_DATE_GREATER_THAN_REG_DATE_CODE= "1082";
         public static final String  REACTIVATION_DATE_GREATER_THAN_REG_DATE_DESC= "Re-Activation date cannot be less than date of tax type registration.";
         
         public static final String  REACTIVATION_DATE_GREATER_THAN_SUSPENSION_DATE_CODE= "1083";
         public static final String  REACTIVATION_DATE_GREATER_THAN_SUSPENSION_DATE_DESC= "Re-Activation date cannot be less than date of suspension.";
         
         public static final String  REACTIVATION_DATE_GREATER_THAN_TAXPAYER_REG_DATE_CODE= "1084";
         public static final String  REACTIVATION_DATE_GREATER_THAN_TAXPAYER_REG_DATE_DESC= "Re-Activation date cannot be less than date of taxpayer registration.";
         
         public static final String  TAX_TYPE_NOT_REACTIVATE_CODE= "1085";
         public static final String  TAX_TYPE_NOT_REACTIVATE_DESC= "Tax type %s is not associated/reactivated with the TIN.";       
	
         public static final String POSTED_LIABILITY_NOT_FOUND_CODE = "1087";
         public static final String POSTED_LIABILITY_NOT_FOUND_DESC ="Please ensure that the posted liability field(s) %s is given as an additional field in the request.";    
         public static final String OFF_STAFF_NOT_EXISTS_CODE = "1090";
         public static final String OFF_STAFF_NOT_EXISTS_DESC = "Office must be configured with the user '%s'. Please contact system administrator.";
        
        
         public static String ACM_INV_ATT_LENGTH_CODE = "1088";
         public static String ACM_INV_ATT_LENGTH_DESC = "The file size is too large. The file size should not exceed %s bytes.";
                 
         public static final String RETURN_ALREADY_SUBMITTED_CODE = "1093";
         public static final String RETURN_ALREADY_SUBMITTED_DESC = "The return has already been submitted with the given details.";
         
          public static final String CASH_TILL_NOT_AVAILABLE_CODE = "1094"; 
           public static final String CASH_TILL_NOT_AVAILABLE_DESC = "Cash Till not Available. Please open a Cash Till";
          
          
          public static final String AMOUNT_ALLOCATED_CODE = "1095";
           public static final String AMOUNT_ALLOCATED_DESC = "Payment Amount is not matching with %s balance on return document.";
         
         public static final String PAYMENT_DISHONOURED_CODE = "1096";
          public static final String PAYMENT_DISHONOURED_DESC = "Payments Dishonoured.";
          

          
         public static final String PAYMENT_SUCCESS_CODE = "1097";
         public static final String PAYMENT_SUCCESS_DESC = "Payment has been successfully received with the reference %s.";
        
//         public static final String PAYMENT_SUCCESS_CASH_TILL_CODE = "1099"; 
//         public static final String PAYMENT_SUCCESS_CASH_TILL_DESC = "Payment has been successfully received. \n Your Cash Till amount has crossed the Cash Till limit. You must reconcile it.";
//          
         public static final String PAYMENT_FAILURE_CODE = "1098"; 
         public static final String PAYMENT_FAILURE_DESC = "Payment Transaction is not Successful.";
         
         public static final String INVALID_DOC_REF_CODE = "1099"; 
         public static final String INVALID_DOC_REF_DESC = "Please enter valid document number."; 
         
         public static final String INVALID_CHARGE_TYPE_CODE = "1100"; 
         public static final String INVALID_CHARGE_TYPE_DESC = "Please enter charge Type which is balance greater than zero."; 

         public static final String REP_GEN_FAILED_CODE = "1109"; 
         public static final String REP_GEN_FAILED_DESC = "Report generation failed."; 
         
         public static final String INVALID_RETURN_DATE_CODE = "1110"; 
         public static final String INVALID_RETURN_DATE_DESC = "Invalid doc type or period from date associated with the TIN. "; 
         
        public static final String  GROOVY_SCRIPT_CODE = "1116";
         
        //  private static final String updateValidationCode = "AMENDNAME_VALIDATION";
        public static final String UPDATE_SUCCESS_DESC = 
            "Your request has been received successfully and sent for processing. Thank You.";
        //public static final String UPDATE_FAILURE_DESC = "We are sorry, we are having a few technical problems. We are working to fix them so please try again later.";
         public static final String UPDATE_FAILURE_DESC = "There has been an error, please see additional error details for information.";
         
         public static final String LODGEMENT_ALREADY_SUBMITTED_CODE = "1118";
         public static final String LODGEMENT_ALREADY_SUBMITTED_DESC = "The lodgement has already been submitted with the given details.";
     
         public static final String INVALID_ALLOCATED_AMOUNT_CODE = "1119";
         public static final String INVALID_ALLOCATED_AMOUNT_DESC = "Allocated amount can't be greater than balance(%s) ";
         
         public static final String PAYMENT_FULL_AMOUNT_CODE = "1120";
         public static final String PAYMENT_FULL_AMOUNT_DESC = "Please enter allocated amount same as balance(%s) for full allocation.";
        
         public static final String  FLEX_MANDATORY_FIELD_CODE= "1121";
         public static final String  FLEX_MANDATORY_FIELD_DESC= "Please enter the %S mandatory field(s).";
         
         public static final String  FLEX_MANDATORY_FIELD_VALUE_CODE= "1122";
         public static final String  FLEX_MANDATORY_FIELD_VALUE_DESC= "Please enter a value for mandatory field %s.";
        
         public static final String  LODGEMENT_FAILURE_CODE= "1123";
         public static final String  LODGEMENT_FAILURE_DESC= "Lodgement is not successful.";  
         
         public static final String  READ_ONLY_INV_VALUE_CODE= "1124";
         public static final String  READ_ONLY_INV_VALUE_DESC= "Read only %s value given is not match with the saved value."; 
         
         public static final String PAYMENT_AMOUNT_INV_CODE = "1125";
         public static final String PAYMENT_AMOUNT_INV_DESC = "Allocated amount can't be greater than payment amount.";
         
         public static final String INV_FORMAT_CODE = "1126";
         public static final String INV_FORMAT_DESC = "Please provide valid format for the field %s.";
         
         public static final String NEGATIVE_NUMBER_CODE = "1127";
         public static final String NEGATIVE_NUMBER_DESC = "Negative entered for the field %s.";
         
         public static final String DUPLICATE_TAXTYPE_ERR_CODE = "1128";
         public static final String DUPLICATE_TAXTYPE_ERR_DESC = 
             "%s already exists or in pending approval.";
     }
    
    public interface PayeReturnTypes{
        public static final String MONTHLY = "PAYE-M";
        public static final String ANNUAL = "PAYE-A";
    }
    public interface ReturnTypes{
        public static final String PIT_PROVISIONAL_FINAL = "PIT-FP";
    }
    
    public interface PayeReturnSubTypes{
        public static final String RESIDENT = "PRES";
        public static final String NONRESIDENT = "PNON";
        public static final String OVERTIME_HIGHER_RATE = "PRESOHR";
        public static final String OVERTIME_LOWER_RATE = "PRESOLR";
        public static final String PAYE_TAX_RESIDENT = "PRESPT";
        public static final String PAYE_TAX_NON_RESIDENT = "PNONPT";
    }
    
    public interface SubTaxCategoryLevel{
        public static final Long LEVEL_1 = 1L;
        public static final Long LEVEL_2 = 2L;
    }
    
    public interface RefTypeCodes {
        public static final String PAYE = "PAYE";
        public static final String CIT = "CIT";
        public static final String PIT = "PIT";
    }
    
    public interface RefReasonCodes{
        public static final String INDDEREG_DEC = "INDDEREG_DEC";
    }
    
    public interface PeriodStatuses {
        public static final String FILED="FILED";
        public static final String NON_PAY_ACTIONED = "Non-Pay Actioned";
        public static final String PARTIALLY_PAID = "PARTIALLY_PAID";
        public static final String CREATED = "Created";
        public static final String NON_FILE_ACTIONED = "Non-File Actioned";
        public static final String LODGED = "LODGED";
        public static final String PAID	= "PAID";
        public static final String CLOSED = "CLOSED";
        public static final String PARTIALLYPAID = "PARTIALLY PAID";
        public static final String RETURN_UNPAID = "RETURN_UNPAID";
    }
    
    public interface ReportPathInfo {
        public static final String NON_FILE_NOTIFICATION = "NON_FILE_NOTIFICATION";
        public static final String NON_PAY_NOTIFICATION = "NON_PAY_NOTIFICATION";
    }
    
    public interface ChargeType {
        public static final String LIABILITY = "LIABILITY";
        public static final String INTEREST = "INTEREST";
        public static final String PENALTY = "PENALTY";
    }
    public interface ExemptionAppStatus {
        public static final String CAN = "CAN";
        public static final String PEN = "PEN";
        public static final String REA = "REA";
        public static final String SER = "SER";
        public static final String APP_ACTIVE = "Active";
        public static final String REJECT = "REJ";
        public static final String TAXPAYER_STATUS = " Taxpayer Status : ";
        public static final String TAX_TYPE_STATUS = " Tax Type Status : ";
        public static final String TAX_TYPE_NOT_REGISTERED = "Tax Type not registered";
        public static final String RETURN_TYPE_NOT_REGISTERED = "Return Type not registered";
        
    }
    
    public interface ComplianceUnitType {
        public static final String LOCAL_CURRENCY = "LC";
        public static final String CURRENCY_POINTS = "CP";
        public static final String PENALTY_POINTS = "PP";
    }
    
    
    public interface CType {
        public static final String CASE = "CASE";
        public static final String DEBT_CASE = "DEBTCASE";
    }
    
    public interface ComputationBasis {
        public static final String AMOUNT = "A";
        public static final String TIME = "T";
    }
    
    public interface ComputationTypes {
        public static final String PENALTY = "PENALTY";
        public static final String INTEREST = "INTEREST";
        public static final String PENALTY_PLUSE_INTEREST = "BOTH";
    }
    public interface AuditandVisit {
    public static final String COMPLEXITY = "Complexity";
    public static final String COMPLIANCE = "Compliance";
    public static final String TURNOVER = "Turnover";
    }
    
    public interface OperandCat {
          public static final String RISK = "RISK";
          public static final String EXEMPTIONS = "EXEMPTIONS";
      }
      
      public interface ExemptionsUsageType {
          public static final String TAXPAYER_SPECIFIC = "TS";
          public static final String ON_FORM = "OF";
          public static final String GENERIC = "Generic";
      }
      
    public interface ExemptionsDataType {
        public static final String TEXT_DATA_TYPE = "text";
        public static final String BOOLEAN_DATA_TYPE= "boolean";
        public static final String INTEGER_DATA_TYPE = "integer";
        public static final String BIG_DECIMAL_DATA_TYPE= "Big Decimal";
        public static final String DATE_DATA_TYPE = "date";
            
        }
                
    public interface NotificationTypes {    
        public static final int GENERATE_OBJ_LODGEMENT_NOTICE = 1;
        public static final int GENERATE_OBJ_ACCEPT_NOTICE = 2;
        public static final int GENERATE_OBJ_REJECT_NOTICE = 3;
        public static final int GENERATE_OBJ_FINALISED_NOTICE = 4;
        public static final int GENERATE_APPEAL_LODGEMENT_NOTICE = 5;
        public static final int GENERATE_APPEAL_REJECTION_NOTICE = 6;
        public static final int GENERATE_APPEAL_FINALISED_NOTICE = 7;
}
    public interface CurrencyErrorMessages {
        public static final String CURRENCY_RATE_NOT_CONFIGURED_CODE = "Currency ";
        public static final String CURRENCY_RATE_NOT_CONFIGURED_MESSAGE = "No Exchange Rate is configured for this currency";

    }
    
    public interface GroupCategories {
        public static final String OBJECTION_AND_APPEAL = "OBJECTION_AND_APPEAL";
        public static final String REPORT_GROUP = "REPORT_GROUP";

    }
    
    public interface IgnoreCategories {
        public static final String GENERAL = "GENERAL";
        public static final String INDIVIDUALTAXPAYERINPUTTYPE = "INDIVIDUALTAXPAYERINPUTTYPE";
        public static final String ORGANISATIONTAXPAYERINPUTTYPE = "ORGANISATIONTAXPAYERINPUTTYPE";

    }
    
    public interface SearchConfigConstants {
         public String DOCUMENT_TYPE = "DocumentType";
         public String PERIOD_NUMBER = "PeriodNumber";
         public String PERIOD_YEAR = "PeriodYear";
         public String TIN = "TIN";
         public String SEARCH_PATH_PREFIX = "/search";
         public String ID = "id";
         public String SEARCH_CONFIG_PREFIX = "SearchConfig.";
         public String SECTION_HEADING_POSTFIX = ".SectionHeading";
         public String WINDOW_HEADING = "windowHeading";
         public String ADVANCE_SEARCH_AVAILABLE = "advancedSearchAvailable";
         public String MULTI_ADVANCE_SEARCH_AVAILABLE = 
             "multiAdvancedSearchAvailable";
         public String ADVANCE_SECTION_HEADING = "advancedSectionHeading";
         public String PRIMARY_TABLE_NAME = "primaryTableName";
         public String JOIN_QUERY = "joinQuery";
         public String QUERY_TYPE = "queryType";
         public String SHOW_CREATE_NEW_BUTTON = "showCreateNewButton";
         public String SUPPORTS_MULTI_QUERY_INJECTIONS = 
             "supportsMultiQueryInjections";
         public String MULTI_SEARCH_FIELD_COLUMN_NAME = 
             "multiSearchFieldColumnName";
         public String YES = "YES";
         public String ADVANCE_SEARCH = "Advanced Search";
         public String VALUE = "value";
         public String TEXT = "text";
         public String TRIGGER_FIELD_NAME = "triggeringFieldName";
         public String RESULT_FIELD_NAME = "resultFieldName";
         public String COLUMN_NAME = "columnName";
         public String ORDER = "order";
         public String ACTION_LABEL = "actionLabel";
         public String ACTION_CALL_BACK = "actionCallBack";
         public String ALLOWABLE_MODES = "allowableModes";
         public String USE_DIALOG = "useDialog";
         public String NAME = "name";
         public String REPLACE_TABLE = "replaceTable";
         public String ACTION_ID = "actionId";
         public String FIELD_NAME = "fieldName";
         public String FIELD_TYPE = "fieldType";
         public String CRITERIA_FIELDS = ".CriteriaFields.";
         public String FIELD_LABEL = "fieldLabel";
         public String REQUIRED = "required";
         public String FIELD_LINK = "fieldLink";
         public String DISPLAY_ORDER = "displayOrder";
         public String DISABLED = "disbled";
         public String FIRST_ITEM_SELECTED = "firstItemSelected";
         public String IS_VISIBLE = "isVisible";
         public String FIELD_FUNCTION = "fieldFunction";
         public String ALTERNATE_PARAMETER = "alternateParameter";
         public String ALTERNATE_OPERATOR = "alternateOperator";
         public String ALTERNATE_COLUMN = "alternateColumn";
         public String FIELD_VALUES_STATICALLY_GIVEN = 
             "fieldValuesStaticallyGiven";
         public String OPERATOR = "operator";
         public String LIST_ID = "listId";
         public String LIST_TYPE = "listType";
         public String MULTIPLE_LINES = "multipleLines";
         public String DECIMAL_LENGTH = "decimalLength";
         public String PUT_THOUSAND_SEPARATOR = "putThousandSeparator";
         public String WILD_CARD = "wildCard";
         public String SEARCH_ID = "searchId";
         public String COLUMN_HEADING = "columnHeading";
         public String RESULT_FIELD = ".ResultField.";
         public String NAVIGATION_CONTROLLING_FIELD = 
             "navigationControllingField";
         public String GET_VALUES_FROM_RESOURCES = "getValueFromResources";
         public String IS_ID_FIELD = "isIdField";
         public String COLUMN_ORDER_NBR = "columnOrderNbr";
     }
    
    public static final String DEFAULT_ENCODING = "UTF-8";
    
    
    public interface SubmissionType {
        public static final String PORTAL = "PORTAL";
        public static final String RGD =  "RGD";
        public static final String TRIPS = "TRIPS";
    }  
    
    public interface Origin {
        public static final String PORTAL = "PORTAL";
        public static final String RGD =  "RGD";
        public static final String TRIPS = "TRIPS";
    }  
    
    
    public interface DBOrigin {
        public static final String PORTAL = "PRT";
        public static final String RGD =  "RGD";
        public static final String TRIPS = "GRA";
        // keeping db origins as it was before.
    }

    public interface FrequencyCategory {
        public static final String FILING = "Filing";
        public static final String COMPUTATION = "Computation";
        public static final String INSTALMENT =  "Instalment";
        public static final String COMPOUNDING = "Compounding";
             // keeping db origins as it was before.
    } 

     public interface SearchConstants {
         //Indicates the filter keys to apply to the generic search -- START --
         public static final String ID_FILITER = ":idfilter";
         public static final String PERIOD_FILTER = ":periodfilter";
         //Indicates the filter keys to apply to the generic search -- END --
     } 
    
    public interface RejectionCodeCategory {
        public static final String OBJECTION_REJECTION_CODE = "OBJECTION_REJECTION_CODE";
        public static final String APPEAL_REJECTION_CODE = "APPEAL_REJECTION_CODE";
    }
    
    public interface RefWithholdingTypeCategory {
        public static final String NRPermanentEstb = "NRPermanentEstb";
        public static final String NonResident = "NonResident";
        public static final String Resident = "Resident";
    }
    
    public interface RefSubTaxCategory {
        public static final String NRPermanentEstb = "WNRP";
        public static final String NonResident = "WNON";
        public static final String Resident = "WRES";
    }
    
}