package com.technobrain.trips.flexforms.helper;

public abstract class FlexFormsConstants {
    public static final String NEW_SCHEMA_ELEMENT = "<<new>>";
    public static final String ADDITIONAL_FIELD_FK_INDICATOR = "_FK";
    public static final String MAP_KEY_DTYPE_SEPARATOR = "~";
    public static final String DUPLICATE_FIELD_NAME_ADDITION = "_copy";
    public static final String PARENT_RECORD_COLUMN_NAME = "PARENT_ID";
    public static final String STATUS_FIELD_NAME = "status";
    public static final String FIELD_LABEL_REASON_FOR_CANCELLATION = "Reason For Cancellation";
    public static final String CANCEL_FILED_RETURN ="CancelFiledReturn";
//    public static final String DEFAULT_FLEXIBLE_FORM_WORKFLOW = "DEFAULT_FLEXIBLE_FORM_WORKFLOW";
    
    public interface FieldReturnTypes {
        String DATE_TYPE = "DATE_TYPE";
        String NUMBER_TYPE = "NUMBER_TYPE";
        String STRING_TYPE = "STRING_TYPE";
        String BOOLEAN_TYPE = "BOOLEAN_TYPE";
        String ALPHANUMERIC_STRING_TYPE = "SPECIAL_CHAR_STRING_TYPE";
        String TABLE = "Table";
    }
    
    public interface AttributeReturnTypes {
        String INTEGER_TYPE = "INTEGER_TYPE";
        String STRING_TYPE = "STRING_TYPE";
        String BOOLEAN_TYPE = "BOOLEAN_TYPE";
    }
    
    public interface ItemGroupSortModes {
        String ASCENDING = "ASC";
        String DESCENDING = "DESC";
        String UNDECLARED = "UNDEC";
    }
    
    public interface AttributeTypes {
        String PROPERTY = "Property";
        String RULE = "Rule";
        String NAVIGATION = "Navigation";
        String VALUE_SETTER = "ValueSetter";
        String DEFAULT_VALUE = "DefaultValue";
        String VALUESETTER_NO_VALIDATION = "ValueSetterNoValidation";
    }
    
    public interface FlexFormAttributeNames {
        String FORM_VALIDATION = "formValidation";
        String FORM_SAVE = "formSave";
        String FORM_INIT = "formInit";
        String FORM_HEADER_PREFIX = "formHeaderPrefix";
    }
    
    public interface FieldTypes {
        String INPUT_TEXT = "InputText";
        String OUTPUT_TEXT = "OutputText";
        String SELECT_INPUT_TEXT = "SelectInputText";
        String INPUT_HIDDEN = "InputHidden";
        String DROP_DOWN = "DropDown";
        String HEADER = "Header";
        String GROUP = "Group";
        String BOX = "Box";
        String SEPARATOR = "Separator";
        String SPACER = "Spacer";
        String FORM = "Form";
        String DATE_PICKER = "DatePicker";
        String LABEL_AND_MESSAGE = "LabelAndMessage";
        String CHECK_BOX = "Checkbox";
        String TABLE = "Table";
        String TABLE_COLUMN = "TableColumn";     
        String TABLE_LAYOUT = "TableLayout";     
        String ROW_LAYOUT = "RowLayout";     
        String SHOW_DETAIL = "ShowDetail"; 
        String SHOW_DETAIL_ITEM = "ShowDetailItem";
        String TASK_SECTION = "TaskSection";     
        String PAGE_SECTION = "PageSection";     
        String CELL_FORMAT = "CellFormat";  
        String SHOW_TAB = "ShowTab";  
        String ATTACHMENT = "Attachment";
        
    }
    
    public interface DropDownItemGroup {
        String VALUE_KEY_NAME = "VALUE";
        String LABEL_KEY_NAME = "LABEL";
    }
    
    public interface FormDisplayTypes{
        String MAIN_PAGE = "MAIN_PAGE";
        String MAIN_POP_UP_PAGE = "MAIN_POPUP";
        String TABLE_ROW_POPUP = "TABLE_ROW_POPUP";
        String PAGE_SECTION = "PAGE_SECTION";
        String POPUP_SECTION = "POPUP_SECTION";
    }
    
    public interface FieldKnownAttributes {
        String LABEL = "label";
        String TEXT = "text";
        String MANDATORY = "showRequired";
        String RENDERED = "rendered";
        String DISABLED = "disabled";
        String VALUE = "value";
        String SIMPLE = "simple";
        String INLINE_STYLE = "inlineStyle";
        String WIDTH = "width";
        String MAX_COLUMNS = "maxColumns"; 
        String ID = "id"; 
        String TIP = "tip";
        String HEIGHT = "height";
        String PATTERN = "pattern";
        String POSITION = "position";
    }
    
    public interface FieldCustomAttributes {
        String FORCE_RENDERED = "FORCE_RENDERED";
        String FIELD_OBJECT = "flexibleField";
        String BASE_GUI_LAYOUT = "baseGuiLayout";        
        String NEXT_ADDITIONAL_FIELD_INDEX = "nextAdditionalFieldIndex";
        String ADDITIONAL_FIELD_INDEX = "additionalFieldIndex";
        String HAS_THOUSAND_OPERATOR = "hasThousandOperator";
        String DECIMAL_LENGTH = "decimalLength";
        String ITEM_GROUP_TRIGGERED_FIELDS = "itemGroupTriggeredFields";
        String ITEM_GROUP = "itemGroup";
        String DISABLED_TRIGGERED_FIELDS = "disabledTriggeredFields";
        String MANDATORY_TRIGGERED_FIELDS = "mandatoryTriggeredFields";
        String RENDERED_TRIGGERED_FIELDS = "renderedTriggeredFields";
        String VALUE_TRIGGERED_FIELDS = "valueTriggeredFields";
        String MAP_KEY = "mapKey";
        String D_TYPE = "dType";
        String DEPENDANT_PARENT_NAME = "dependantParentName";
        String POPUP_FLEXIBLE_FORM = "popupFlexibleForm";
        String FLEXIBLE_FORM = "flexibleForm";
        String VALUE_BINDING = "valueBinding";
        String FORM_MODE = "formMode";
        String SEARCH_ID = SelectInputTextCustomAttributes.SEARCH_ID;
        String DISABLE_SCRIPT = "disableScript";
        String MAXIMUM_LENGTH = "maximumLength";
    }
    
    public interface FormKnownAttributes{
        String LABEL_WIDTH = "labelWidth";
        String FIELD_WIDTH = "fieldWidth";
    }
    
    public interface FormCustomAttributes {
        String FORM_OBJECT = "flexibleForm";
    }
    
    public interface DropDownCustomAttributes {
        String ITEM_GROUP = "itemGroup";
    }
    
    public interface TableCustomAttributes {
        String RENDER_ADD_BUTTON = "renderAddButton";
        String RENDER_UPDATE_BUTTON = "renderUpdateButton";
        String RENDER_DELETE_BUTTON = "renderDeleteButton";
        String RENDER_IMPORT_BUTTON = "renderImportButton";
        String RENDER_VIEW_BUTTON = "renderViewButton";
        String POPUP_FLEXIBLE_FORM = "popupFlexibleForm";
        String MAX_ROWS = "maxRows";
        String DISABLE_ADD_BUTTON = "disableAddButton";
        String DISABLE_UPDATE_BUTTON = "disableUpdateButton";
        String DISABLE_DELETE_BUTTON = "disableDeleteButton";        
        String PASS_PARENT_FORM_ON_ADD_BUTTON = "passParentFormOnAddButton";
        String PASS_PARENT_FORM_ON_EDIT_BUTTON = "passParentFormOnEditButton";
        String DUPLICATE_CHECK_FIELD_NAME = "duplicateCheckFieldName";
    }
    
    public interface SelectInputTextCustomAttributes {
        String SEARCH_ID = "searchId";
        String PASS_BASE_TABLE_TO_SEARCH = "passBaseTableToSearch";
        // the below attribute is internally used.
        String SELECTED_SEARCH_RESULT = "selectedSearchResult";
        String PROCESS_SCOPE_FILTER_OFFICE="processScopeFilterOffice";
    }
    
    public interface GroupLayoutCustomAttributes {
        String LAYOUT = "layout";
    }
    
    public interface FormNames {
        String CIT_TAX_RETURN = "CIT_TAX_RETURN";
    }
    
    public interface GeneralFormActions {
        String SUBMIT = "SUBMIT";        
        String APPROVE = "APPROVE";   
        String REJECT = "REJECT";   
    }

    public interface Search{
        String D_TYPE = FieldCustomAttributes.D_TYPE;
        String ID_COLUMN = "ID_COLUMN";
        String FOR_FIELD = "forField";
        String SEARCH_COL_NAMES_SEPERATOR = "~";
        String DOCUMENT_ID = "DOCUMENT_ID";
        String SUBMISSION_MODE = "SUBMISSION_MODE";
        String DOCUMENT_STATUS = "DOCUMENT_STATUS";
    }

    public interface ModeTypes{
        String BASIC = "Basic";
        String EXTENDED = "Extended";
        String NEGATE = "Negate";
    }
    
    public interface ModeAttributes {
        String SHOW_TASK_SECTION = "showTaskSection";
        String DISABLE_SCRIPTS = "disableScripts";
        String VALIDATE_FORM = "validateForm";
        String OVERWRITE_VALUES_IN_VALIDATION = "overwriteValuesInValidation";
    }

    public interface FieldUsageType{
        String ACCOUNT_LIABILITY = "ACCOUNT_LIABILITY";
//        String TIN = "TIN";
        String PERIOD = "PERIOD";
        String TAX_TYPE = "TAX_TYPE";
        String SUB_TAX_TYPE = "SUB_TAX_TYPE";
        String RECORD_STATUS = "RECORD_STATUS";
        String AMENDMENT_INDICATOR = "AMENDMENT_INDICATOR";
        String OFFICE_INDICATOR = "OFFICE_INDICATOR";
        String TIN_OF_2ND_TAXPAYER = "TIN_OF_2ND_TAXPAYER"; 
        String ASSESSMENT = "ASSESSMENT";
        String TAXPAYER_NAME = "TAXPAYER_NAME";
        String CURRENCY = "CURRENCY";
        
        
        public static final String TIN = "TIN";
        public static final String PERIOD_FROM = "PERIOD_FROM";
        public static final String PERIOD_TO = "PERIOD_TO";
        public static final String SUBMISSION_DATE = "SUBMISSION_DATE";
        public static final String DOCUMENT_TYPE = "DOCUMENT_TYPE";
        public static final String TOTAL_AMOUNT_TO_POST = "TOTAL_AMOUNT_TO_POST";
        public static final String TAX1_AMOUNT_TO_POST = "TAX1_AMOUNT_TO_POST";
        public static final String TAX2_AMOUNT_TO_POST = "TAX2_AMOUNT_TO_POST";
        public static final String SUBMISSION_MODE = "SUBMISSION_MODE";
        public static final String DOCUMENT_ID = "DOCUMENT_ID";
        public static final String NIL_RETURN = "NIL_RETURN";
        public static final String RESIDENT_INDICATOR = "RESIDENT_INDICATOR";
        public static final String OCC_CAT = "OCC_CAT";
        public static final String OCC_PRECISE_CAT = "OCC_PRECISE_CAT";
        public static final String WIT_AMOUNT_TO_POST = "WIT_AMOUNT_TO_POST";
        public static final String PAYE_ANNUAL_AMOUNT_TO_POST = "PAYE_ANNUAL_AMOUNT_TO_POST";
        public static final String WH_TYPE = "WH_TYPE";
        
    }
    
    public interface SpecialPurpose{
        String ALLOW_IN_RISK = "AllowInRisk";
        String RISK_SECTION = "RiskSection";
    }
    public interface FlexibleStatus{
        String CLIENT_PROVIDED_VALUE = "CPV";
        String SYSTEM_CALCULATED_VALUE = "SCV";
    }
	
    public interface FlexCreatedForm {
	final String CREATED_FORM = "createdForm";
	final String CREATED_BY = "createdBy";
	final String CREATED_DATE = "createdDate";
    }
}
