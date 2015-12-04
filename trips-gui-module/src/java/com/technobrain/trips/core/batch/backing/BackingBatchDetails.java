package com.technobrain.trips.core.batch.backing;

import com.technobrain.trips.core.backing.BackingBase;
import com.technobrain.trips.core.sessionmanager.annotation.SessionWorker;


@SessionWorker(
     managedBeanName="backingBatchDetails", 
     stayAlive = "/batch/BatchDetails.jspx,/core/GenericSearch.jspx, /batch/BatchEntryWrapper.jspx" 
 )
 
public class BackingBatchDetails extends BackingBase{
    
//    private List<SelectItem> formTypeList,batchStatusList;
//    private BatchDetailsInputType batchInputType;
//    private ReferenceCodeDelegate refDelegate;
//    RefBatchFormType refBatchFormType = null;
//    private BatchDelegate batchDelegate;
//    SearchResultInfo selectedRow;;
//    private boolean disableBatchStatus;
//    private CoreInputText dlnRangeToInput;
//    int seqLength;
//    String generatedDlnTo = null;
//    
//    private boolean dlnRangeFromDisabled= false;
    
//    public BackingBatchDetails() {
//        refDelegate = 
//                refDelegate == null ? new ReferenceCodeDelegate() : refDelegate;
//        batchDelegate = 
//                batchDelegate == null ? new BatchDelegate() : batchDelegate;
//        String dlnSeqLength = refDelegate.findSystemParameter(Constants.SystemParameterCode.DLN_SEQUENCE_LENGTH);
//        seqLength = Integer.valueOf(dlnSeqLength);
//        // This should be hidden in new mode and readonly in edit mode
//        if(getBatchInputType().getId() == null) {
//            disableBatchStatus = false;
//        }
//        else {
//            disableBatchStatus = true;
//            
//            //For edit mode check if already some records are added then DLN From should be disabled
//            List<SearchResultInfo> recordsAlreadyAdded = batchDelegate.retrieveBatchEntries(getBatchInputType());
//            if(recordsAlreadyAdded != null && recordsAlreadyAdded.size() > 0){
//                dlnRangeFromDisabled = true;
//            }
//        }
//    }
//
//    public void setFormTypeList(List<SelectItem> formTypeList) {
//        this.formTypeList = formTypeList;
//    }
//
//    public List<SelectItem> getFormTypeList() {
//        if (formTypeList == null) {
//            formTypeList = new ArrayList<SelectItem>();
//            formTypeList = 
//                    refDelegate.findAllBatchFormType(getBatchInputType().getBatchDetails().getFormType());
//        }
//        return formTypeList;
//    }
//    
//    public String processBatch() {
//            if(!super.validateBeforeSubmission())
//            return null;
//
//        boolean validationFailed = false;
//        // validations first
//        if(getBatchInputType() != null && getBatchInputType().getBatchDetails() !=null &&
//            getBatchInputType().getBatchDetails().getFormType() != null){
//            refBatchFormType = (RefBatchFormType)refDelegate.find
//                                (getBatchInputType().getBatchDetails().getFormType(),DataReference.BATCH_FORM_TYPE);
//        }else{
//            FacesUtil.addFacesErrorMessage("Batch.msg.SelectFormType");
//            return null;
//        }
//        
//        // Batch Entry Limit should be enforced
//        String flexibleBatchLimitStr = refDelegate.findSystemParameter(Constants.SystemParameterCode.FLEXI_BATCH_LIMIT);        
//        if(flexibleBatchLimitStr != null) {
//            Integer flexibleBatchLimit = null;
//            try {
//                flexibleBatchLimit =  new Integer(flexibleBatchLimitStr);
//            }
//            catch(Exception ex) {
//                log.error(ex.getLocalizedMessage(), ex);
//                FacesUtil.addFacesErrorMessage("Batch.msg.error.FlexibleBatchLimitFormatError");
//                return null;
//            }
//            if(getBatchInputType() != null && getBatchInputType().getBatchDetails().getNumberOfItems() > flexibleBatchLimit) {
//                FacesUtil.addFacesErrorMessage("Batch.msg.error.FlexibleBatchLimitExceededError", new Object[]{flexibleBatchLimit});
//                validationFailed = true;
//            }
//        }
//        // Batch Entry Date should not allow future dates
//        if(getBatchInputType().getBatchDetails().getBatchDate() != null && 
//            DateHelper.compareDates(getBatchInputType().getBatchDetails().getBatchDate(), Calendar.getInstance()) == 1) {
//            FacesUtil.addFacesErrorMessage("Batch.msg.error.BatchDateFutureNotAllowed");
//            validationFailed = true;
//        }
//        // Batch Entry should not Allow Zero Items
//        if(getBatchInputType().getBatchDetails().getNumberOfItems() != null &&
//            getBatchInputType().getBatchDetails().getNumberOfItems() == 0) {
//            FacesUtil.addFacesErrorMessage("Batch.msg.error.BatchEntryShouldNotAllowZeroItems");    
//            validationFailed = true;
//        }
//
//        String enteredDlnTo = getBatchInputType().getBatchDetails().getDlnRangeTo();
//        if(generatedDlnTo != null && !generatedDlnTo.equalsIgnoreCase(enteredDlnTo)){
//            FacesUtil.addFacesErrorMessage("Batch.msg.error.InvalidDlnRangeTo");    
//            validationFailed = true;
//        }
//        if(validationFailed) {
//            return null;
//        }
//        
//        //Create new mode
//        if(getBatchInputType().getId() == null || getBatchInputType().getId()== 0){
//            // check if the reference number is not already present
//            if(batchDelegate.isBatchReferenceNumberPresent(getBatchInputType())){
//                FacesUtil.addFacesErrorMessage("Batch.msg.RefAlreadyPresent");
//                return null;            
//            }        
//            
//            if(batchDelegate.isBatchDLNAlreadyPresent(getBatchInputType())){
//                FacesUtil.addFacesErrorMessage("Batch.msg.DLNAlreadyPresent");
//                return null;            
//            }       
//            //save batch header
//            if(null == getBatchInputType().getBatchDetails().getBatchStatus()){
//                getBatchInputType().getBatchDetails().setBatchStatus(Constants.BatchStatus.RECEIVED);
//            }
//
//            OutputType outputType= batchDelegate.saveOrUpdateBatch(getBatchInputType());
//            //load batch header
//            if(outputType != null && !outputType.isHasErrors())
//                batchInputType = batchDelegate.loadBatchDetailsInputType(outputType.getId());
//            if(refBatchFormType != null && refBatchFormType.getLinkPage() != null)
//                return "ToBatchEntryWrapper";
//            else{
//                FacesUtil.addFacesErrorMessage("Batch.msg.NoNavigationDefined");
//                return null;
//            }
//        }else{ //Edit mode
//             if(refBatchFormType != null && refBatchFormType.getSearchId() != null){
//             
//                 if(isValidForUpdate()){   
//                    batchDelegate.saveOrUpdateBatch(getBatchInputType());
//                     //Inject BatchId dynamically to list the data entered only via batch entry screen.
//                     Map batchIdAsDynamicSearchCriteria = new HashMap();
//                     //batchIdAsDynamicSearchCriteria.put(Constants.STATIC_INJECTION_BATCH_ID_NAME, batchInputType.getId());
//                     batchIdAsDynamicSearchCriteria.put(Constants.STATIC_INJECTION_BATCH_REFERENCE, 
//                                                        batchInputType.getBatchDetails().getBatchReference());
//                     
//                     FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.DYNAMIC_SEARCH_CRITERIA_SETUP,
//                                        batchIdAsDynamicSearchCriteria);
//                     
//                     
//                     FacesUtil.storeOnProcessScope(WebConstants.GenericSearchProcessScopeVars.SEARCH_KEY,
//                                        refBatchFormType.getSearchId());
//                     FacesUtil.storeOnProcessScope(WebConstants.GenericSearchProcessScopeVars.SEARCH_MODE_KEY,
//                                        getPageMode());
//                     FacesUtil.storeOnProcessScope(WebConstants.GenericSearchProcessScopeVars.POST_SEARCH_NAV_KEY,
//                                        "ToBatchEntryWrapper");
//                     FacesUtil.navigate(WebConstants.ViewId.GENERIC_SEARCH_ID);
//                 }
//             }else{
//                 FacesUtil.addFacesErrorMessage("Batch.msg.NoSearchDefined");
//                 return null;
//             }
//        }
//        return null;
//    }
//
//    private boolean isValidForUpdate(){
//        boolean validationDone = true;
//        
//        //Check if the number of items is bigger than the items already saved
//         //For edit mode check if already some records are added then DLN From should be disabled
//         List<SearchResultInfo> recordsAlreadyAdded = batchDelegate.retrieveBatchEntries(getBatchInputType());
//         if(recordsAlreadyAdded != null 
//            && getBatchInputType().getBatchDetails().getNumberOfItems() < recordsAlreadyAdded.size()){
//            
//             FacesUtil.addFacesErrorMessage("Batch.msg.error.InvalidNumberOfRecords");    
//             validationDone = false;
//             
//         }
//        
//        return validationDone;
//    }
//    
//    
//    public void setBatchInputType(BatchDetailsInputType batchInputType) {
//        this.batchInputType = batchInputType;
//    }
//
//    public BatchDetailsInputType getBatchInputType() {
//        if(batchInputType == null){
//            selectedRow = SearchDelegate.getSelectedRow();
//            if(selectedRow == null){
//                batchInputType = MessageHelper.init(batchInputType,BatchDetailsInputType.class);
//                batchInputType.getBatchDetails().setBatchDate(Calendar.getInstance()); //default to current date
//            }else{
//                batchInputType = batchDelegate.loadBatchDetailsInputType((Long)selectedRow.getPrimaryKey());
//            }
//        }
//        return batchInputType;
//    }
//
//    public void setBatchStatusList(List<SelectItem> batchStatusList) {
//        this.batchStatusList = batchStatusList;
//    }
//
//    public List<SelectItem> getBatchStatusList() {
//        if (batchStatusList == null) {
//            batchStatusList = new ArrayList<SelectItem>();
//            batchStatusList = 
//                    refDelegate.findAllBatchStatus(getBatchInputType().getBatchDetails().getBatchStatus());
//        }
//        return batchStatusList;
//    }
//
//    public BatchDelegate getBatchDelegate() {
//        return batchDelegate;
//    }
//
//    public void setDisableBatchStatus(boolean disableBatchStatus) {
//        this.disableBatchStatus = disableBatchStatus;
//    }
//
//    public boolean isDisableBatchStatus() {
//        return disableBatchStatus;
//    }
//    
//    /**
//     * It captures the 'DLN Range From' entered and set it onto the message 
//     * type in order to generate DLN Range To
//     * @param event
//     */
//    public void dlnFromChangeListener(ValueChangeEvent event) {
//        String dlnFrom = (String)event.getNewValue();
//        getBatchInputType().getBatchDetails().setDlnRangeFrom(dlnFrom);
//        generatedDlnTo = generateDlnTo();
//        dlnRangeToInput.setValue(generatedDlnTo);
//        dlnRangeToInput.setSubmittedValue(generatedDlnTo);
//        AdfFacesContext.getCurrentInstance().addPartialTarget(dlnRangeToInput);
//    }
//    
//     /**
//      * It captures the 'No. of Items' entered and set it onto the message 
//      * type in order to generate DLN Range To
//      * @param event
//      */
//     public void noOfItemChangeListener(ValueChangeEvent event) {
//         Integer noOfItems = (Integer)event.getNewValue();
//         getBatchInputType().getBatchDetails().setNumberOfItems(noOfItems);
//         generatedDlnTo = generateDlnTo();
//         dlnRangeToInput.setValue(generatedDlnTo);
//         dlnRangeToInput.setSubmittedValue(generatedDlnTo);
//         AdfFacesContext.getCurrentInstance().addPartialTarget(dlnRangeToInput);
//     }
//    
//    public String generateDlnTo(){
//        String dlnTo = FlexibleFormsHelper.getDLNNumberByAdding(getBatchInputType().getBatchDetails().getDlnRangeFrom(),
//                            seqLength,getBatchInputType().getBatchDetails().getNumberOfItems()-1);
//        getBatchInputType().getBatchDetails().setDlnRangeTo(dlnTo);
//        return dlnTo;
//    }
//
//    public void setDlnRangeToInput(CoreInputText dlnRangeToInput) {
//        this.dlnRangeToInput = dlnRangeToInput;
//    }
//
//    public CoreInputText getDlnRangeToInput() {
//        return dlnRangeToInput;
//    }
//
//    protected boolean setUpValidateOnSubmission() {
//        return true;
//    }
//
//
//    public void setDlnRangeFromDisabled(boolean dlnRangeFromDisabled) {
//        this.dlnRangeFromDisabled = dlnRangeFromDisabled;
//    }
//
//    public boolean isDlnRangeFromDisabled() {
//        return dlnRangeFromDisabled;
//    }
}
