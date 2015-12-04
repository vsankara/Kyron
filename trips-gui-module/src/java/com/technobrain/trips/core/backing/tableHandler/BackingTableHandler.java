package com.technobrain.trips.core.backing.tableHandler;

import com.technobrain.trips.core.delegate.ReferenceCodeDelegate;
import com.technobrain.trips.core.onetomanytable.GenericSingleSelectionTableHandler;
import com.technobrain.trips.core.onetomanytable.OneBackingBeanToManyTables;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.util.WebConstants;
import com.technobrain.trips.common.helpers.ReflectionHelper;

import java.util.List;

import javax.faces.application.NavigationHandler;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;



public class BackingTableHandler extends OneBackingBeanToManyTables{
    public static final String NOTES_BACKING_NAME = "backingNotesTableHandler";
    public static final String JOURNEYS_BACKING_NAME = "backingJourneysTableHandler";
    public static final String INTELLIGENCEINFOS_BACKING_NAME = "backingIntelligenceInfoTableHandler";
    public static final String CONTACTMETHODS_BACKING_NAME = "backingContactMethodTableHandler";
    public static final String ATTACHMENTS_BACKING_NAME = "backingAttachmentTableHandler";
    public static final String ASSOCIATIONS_BACKING_NAME = "backingAssociationsTableHandler";
    public static final String ADDRESSES_BACKING_NAME = "backingAddressTableHandler";
    public static final String BANK_DETAILS_BACKING_NAME = "backingBankDetailsTableHandler";
    public static final String CARD_DETAILS_BACKING_NAME = "backingCardDetailsTableHandler";
    public static final String MANIFEST_CONTAINER_BACKING_NAME = "backingManifestContainerTableHandler";
    public static final String GUARANTEE_USAGE_BACKING_NAME = "backingGuaranteeUsageTableHandler";
    public static final String INCOMING_ASSOCIATIONS_BACKING_NAME = "backingIncomingAssociationsTableHandler";
    public static final String IDENTIFICATION_BACKING_NAME = "backingIdentificationTableHandler";
    public static final String SITE_BACKING_NAME = "backingEntitySiteTableHandler";    
    public static final String FLEXIBLE_ATTRIBUTE_BACKING_NAME = "backingFlexibleAttributesTableHandler";
    public static final String INDUSTRY_OCCUPATION_BACKING_NAME = "backingIndustryOccupationTableHandler";
    public static final String POSSIBLE_DUPLICATE_BACKING_NAME = "backingPossibleDuplicatesTableHandler";    
    public static final String TAXPAYER_TYPE_BACKING_NAME = "backingTaxpayerTypeTableHandler";
    public static final String PARTNERS_BACKING_NAME = "backingPartnersTableHandler";
    public static final String SHAREHOLDERS_BACKING_NAME = "backingShareholdersTableHandler";
    public static final String SUBSIDIARIES_BACKING_NAME = "backingSubsidiariesTableHandler";
    public static final String RELATEDCOMPANIES_BACKING_NAME = "backingRelatedCompaniesTableHandler";
    public static final String COMMERCIAL_VEHICLE_DETAILS_BACKING_NAME = "backingCommercialVehicleDetailsTableHandler";
    public static final String PROPERTY_DETAILS_BACKING_NAME = "backingPropertyDetailsTableHandler";
    public static final String BUSINESS_SECTOR_DETAILS_BACKING_NAME = "backingBusinessSectorDetailsTableHandler";
    public static final String EMPLOYEMNT_DETAILS_BACKING_NAME = "backingEmploymentDetailsTableHandler";
    public static final String RELATIONSHIPS_BACKING_NAME = "backingRelationshipTableHandler";
    public static final String DIRECTORS_BACKING_NAME = "backingDirectorsTableHandler";
    public static final String BRANCHES_BACKING_NAME = "backingBranchesTableHandler"; 
    public static final String TRADINGAS_BACKING_NAME = "backingTradingAsDetailsTableHandler";
    public static final String BUSINESS_SECTOR_DETAILS_SOLEPROP_BACKING_NAME = "backingBusinessSectorDetailsSolePropTableHandler";
    public static final String CREDIT_ALLOCATION_BACKING_NAME = "backingCreditAllocationTableHandler";
    public static final String DEBIT_ALLOCATION_BACKING_NAME = "backingDebitAllocationTableHandler";
    public static final String REPORT_PARAMETERS_BACKING_NAME = "backingReportParametersTableHandler";
    public static final String GROUP_ASSIGNED_BACKING_NAME = "backingGroupAssignedTableHandler";
    public static final String ASSIGNMENT_BACKING_NAME = "backingAssignmentTableHandler";
    public static final String RELATED_DOCUMENTS_BACKING_NAME = "backingRelatedDocumentsTableHandler";
    public static final String LINKED_RELATED_CASES_TABLE = "linkedRelatedCasesTableHandler";
    public static final String GROUP_ASSIGNED_DEBT_CASE_BACKING_NAME = "backingGroupAssignedDebtCasesTableHandler";
    public static final String ASSIGNMENT_DEBT_CASE_BACKING_NAME = "backingAssignmentDebtCasesTableHandler";
    public static final String DEBT_CASE_COURT_ACTION_BACKING_NAME ="backingCourtActionTableHandler";
    public static final String EXEMPTION_ATTACHMENT_BACKING_NAME = "backingExemptionAttachmentTableHandler";
    
    
    private List<SelectItem> containerTypesList, containerStatusList;
    private ReferenceCodeDelegate refDelegate;
    
    private String taxpayerType;
    
    public BackingTableHandler() {
        tableHandler = new GenericSingleSelectionTableHandler();
    }
    
    public BackingTableHandler(Object[] data, String shortDesc) {
        tableHandler = new GenericSingleSelectionTableHandler(data);        
        tableHandler.setShortDesc(shortDesc);
    }
    
    public void putData(String key, Object[] data) {
        GenericSingleSelectionTableHandler tableHandlerInstance = new GenericSingleSelectionTableHandler(data);
        tableHandlers.put(key, tableHandlerInstance);
    }

    public BackingTableHandler(Object[] data) {
        tableHandler = new GenericSingleSelectionTableHandler(data);        
    }

    public BackingTableHandler(List data) {
        tableHandler = new GenericSingleSelectionTableHandler(data);        
    }
    
    public BackingTableHandler(List data, String shortDesc) {
        tableHandler = new GenericSingleSelectionTableHandler(data);      
        tableHandler.setShortDesc(shortDesc);
    }
    
//    public List<SelectItem> getContainerStatusList() {
//        if (null == containerStatusList) {
//            containerStatusList = refDelegate.findAllContainerStatus(null);
//        }
//        return containerStatusList;
//    }
//    
//    public List<SelectItem> getContainerTypesList() {
//        if (containerTypesList == null) {
//            containerTypesList = refDelegate.findAllContainerType(null);
//        }
//        return containerTypesList;
//    }
//    
    public String deleteRecord() {
        if(tableHandler != null && tableHandler.getTableModel() != null && tableHandler.getTableModel().size() == 0){
            FacesUtil.addFacesErrorMessage("Global.msg.NoRecordsFound");
            return null;
        }else{
            if(!tableHandler.isARowSelected()){
                FacesUtil.addFacesErrorMessage("Global.msg.NoRowSelected");
                return null;
            }else{
                String tableHandlerKey = retrieveTableHandlerName();
                
                Object selectedRow = tableHandler.getTable().getSelection();;
                if(selectedRow != null ){
                    String s = super.processDelete();
                }else{
                    FacesUtil.addFacesErrorMessage("Global.msg.NoRowSelected");
                    return null;
                }
            }
        }
        
        return null;
    }


//    public void processReturnFromAssociationEvent(ReturnEvent evt) {
//        processReturnFromTableEvent(evt, "associateReferenceNumber");
//    }
//    
//    public void processReturnFromIndustryOccupationEvent(ReturnEvent evt) {
//        processReturnFromTableEvent(evt, "industryOccupationCode");
//    }

    public void viewPossibleDuplicateDetails(SelectEvent selectionEvent) {
//         String selectedKey = (String)selectionEvent.getRow().getKeySet().toArray()[0];
//         String selectedKey = (String)selectionEvent.SelectedKeys().
//         int index = Integer.parseInt(selectedKey);
         
         boolean isIndividual = false;
//        DuplicateTaxpayerDetails duplicateTaxpayerDetails = 
//            (DuplicateTaxpayerDetails)getSelectedRowDataFromBackingTableHandler(BackingTableHandler.POSSIBLE_DUPLICATE_BACKING_NAME);
//         RequestContext adfContext =  RequestContext.getCurrentInstance();
//         adfContext.getProcessScope().put(WebConstants.ProcessScopeVariable.TRANSITION_ENTITY_ID,duplicateTaxpayerDetails.getId());
//         
//         String nav = null;
//         adfContext.getProcessScope().put("makeRegRegimeBtnDisable",true);
//         adfContext.getProcessScope().put(WebConstants.ProcessScopeVariable.GUI_MODE,Constants.Modes.VIEW);
//         adfContext.getProcessScope().put(WebConstants.ProcessScopeVariable.PAGE_CONFIG,Constants.GuiConfig.CRUD_CONFIG);
         if(isIndividual){
            
         }else{
//             nav = null;//"FromOrganisationSummaryDetailsToGenericSearch";
         }
         
//         NavigationHandler nh = FacesUtil.getFacesContext().getApplication().getNavigationHandler();
//         nh.handleNavigation(FacesUtil.getFacesContext(), null,nav);
             
    }
    

//    public void refreshPossibleDuplicates(ActionEvent actionEvent) {
//        DuplicateTaxpayerDetails[] duplicateTaxpayerDetails = null;
//        BackingOrganisationSummaryDetail backing = (BackingOrganisationSummaryDetail)FacesUtil.
//            getManagedBeanValue("backingOrganisationSummaryDetails");
//        if(null != backing){
//            duplicateTaxpayerDetails = backing.
//                                getEntitySummaryDelegate().
//                                findPossibleDuplicates(backing.getOrgRegMsg());
//        }else{
//            BackingIndividualSummaryDetail backingInd = (BackingIndividualSummaryDetail)FacesUtil.
//                getManagedBeanValue("backingIndividualSummaryDetails");
//            backingInd.getIndivRegMsg().setIdentification((IdentificationType[])getDataFromBackingTableHandler(BackingTableHandler.IDENTIFICATION_BACKING_NAME));
//            duplicateTaxpayerDetails = backingInd.
//                                getEntitySummaryDelegate().
//                                findPossibleDuplicates(backingInd.getIndivRegMsg());
//        }
//        
//        passDataToBackingTableHandler(BackingTableHandler.POSSIBLE_DUPLICATE_BACKING_NAME
//            , duplicateTaxpayerDetails);
//        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTableHandler(BackingTableHandler.POSSIBLE_DUPLICATE_BACKING_NAME).getTable());
//    }
    
    public void processReturnFromFlexibleAttributeEvent(SelectEvent evt) {
//        processReturnFromTableEvent(evt);
//        BackingFlexibleAttributes flexAttributes = 
//            (BackingFlexibleAttributes)FacesUtil.getManagedBeanValue("backingFlexibleAttributes");
//        if (flexAttributes != null) {
//            FacesUtil.removeFromSession("backingFlexibleAttributes");
//        }
    }

    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getTaxpayerType() {
        return (FacesUtil.getFromProcessScope(WebConstants.ProcessScopeVariable.TAXPAYER_TYPE).toString());
    }
	
	public boolean isSavedToDB(){
        Object key = null;
        Object selectedRow = null;
        if(tableHandler != null && tableHandler.getTable() != null){
            selectedRow= tableHandler.getTable().getSelection();
        }
        if(selectedRow != null){
            try {
                key = ReflectionHelper.getFieldValue(selectedRow,"id");
            } catch (NoSuchMethodException e) {
                log.error(e.getLocalizedMessage(), e);
            }
        }
        if(key != null && Long.parseLong(key.toString()) != 0){
            return true;
        }else{
            return false;
        }
    }
}
