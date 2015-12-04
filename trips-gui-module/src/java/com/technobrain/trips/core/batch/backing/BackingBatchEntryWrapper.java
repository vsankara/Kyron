package com.technobrain.trips.core.batch.backing;


import com.technobrain.trips.core.backing.BackingBase;
import com.technobrain.trips.core.delegate.ReferenceCodeDelegate;
import com.technobrain.trips.core.sessionmanager.annotation.SessionWorker;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.util.WebConstants;

import java.util.Comparator;
import java.util.List;

import javax.faces.event.ActionEvent;


//import com.crownagents.trips.core.flexforms.generation.delegate.FormGenerationDelegate;
//import com.crownagents.trips.flexforms.helper.FlexFormsConstants;
//import com.crownagents.trips.flexforms.helper.FlexibleFormsHelper;
//import com.crownagents.trips.flexforms.model.FlexibleForm;
//import com.crownagents.trips.taxreturns.message.TaxReturnFlexibleFormInputType;


@SessionWorker(managedBeanName = "backingBatchEntryWrapper", 
                absoluteBackingBean=true,
               stayAlive = "/batch/BatchEntryWrapper.jspx")
public class BackingBatchEntryWrapper extends BackingBase  {
//    private BatchDetailsInputType batchDetails;    
////    private RefBatchFormType batchFormTypeInfoBag;
//    private ReferenceCodeDelegate refDelegate;
//    private BackingBase currentEntryBean = null;
//    private String linkPageUrl;
////    private SearchDelegate searchDelegate;
////    private BatchDelegate batchDelegate;
////    private FormGenerationDelegate formGenDelegate;
//    private List<SearchResultInfo> batchEntries = null;
//    private Integer batchCount = 0;
//    private String dln;
//    private boolean qualityCheck;
//    private Integer itemNumber;
//    public static final String DONT_INITIALIZE_PAGE = "DONT_INITALIZE_PAGE";
//
//    public void setDln(String strDln) {
//        this.dln = strDln;
//    }
//
//    public String getDln() {
//        return dln;
//    }
//
//
//    public void setQualityCheck(boolean qualityCheck) {
//        this.qualityCheck = qualityCheck;
//    }
//
//    public boolean isQualityCheck() {
//        return qualityCheck;
//    }
//
//    private boolean doQualityChecks(FlexibleFormsInputType inputType) {
////        OutputType outputType = formGenDelegate.validateForm(inputType);
////        if(null == outputType){
////            return false;
////        }else
////        if(null != outputType.getReturnStatus() && !outputType.getReturnStatus().equalsIgnoreCase(Constants.PASS)){
////            FacesUtil.addFacesSeverityMessage(FacesMessage.SEVERITY_ERROR,outputType);
////            return false;
////        }
//        return true;
//    }
//
//    private enum NEXT_ITEM_STATE {NEWITEM, EXISTINGITEM, NOPREVIOUSITEM_NEWITEM, NOPREVIOUSITEM_EXISTINGITEM, SAMEITEMASPREVIOUS};
//    private NEXT_ITEM_STATE nextItemState;
//    
//    public BackingBatchEntryWrapper() {
//        refDelegate = new ReferenceCodeDelegate();
////        searchDelegate = new SearchDelegate();
////        batchDelegate = new BatchDelegate();
////        formGenDelegate = new FormGenerationDelegate();
////        String formType = getBatchDetails().getBatchDetails().getFormType();
////        FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.FORM_TYPE, formType);
////        batchFormTypeInfoBag = refDelegate.findBatchFormTypeInfoBag(formType);
////        linkPageUrl = batchFormTypeInfoBag.getLinkPage();
////        qualityCheck = Boolean.valueOf(true);
////        initializeForNewEntry(true);
//    }
//
//    private Long getConfigSetModeIdForMode(){
//        //String pageMode = getPageMode();
////        FlexibleForm form = formGenDelegate.getFlexibleFormByName(getBatchDetails().getBatchDetails().getFormType());
////        if (form != null ){
////            // get the configsetmode id for the pageMode ... corresponding to the BATCH
////            return formGenDelegate.getConfigSetModeIdForMode(form, (String)FacesUtil.getFromProcessScope(WebConstants.ProcessScopeVariable.GUI_MODE));
////        }
////        else {
////            FacesUtil.addFacesErrorMessage("Batch.msg.NoFormFound");
////        }
//        return null;         
//    }
//    
//    private void initializeForNewEntry(boolean initializePage) {
//        boolean calculateDlnRecordNumber = true;
//        qualityCheck = true;
//        
//        // if the item size is same as the needed item number, then it means we can submit all the records.
//        if(getBatchDetails().getBatchDetails().getNumberOfItems().equals(getBatchEntries().size()) 
//        ) {
////            calculateDlnRecordNumber = false;
//            //workflow only can submit if created i.e saved
//            FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.GUI_MODE, Constants.Modes.BATCH_SUBMIT);
//            FacesUtil.storeOnSession(WebConstants.SessionVariable.CONFIG_SET_MODE_ID, getConfigSetModeIdForMode());
//            
//        }
//        else {
//            // we need to change the gui mode to batch so that the gui configuration can be made with batch mode.
//            FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.GUI_MODE, Constants.Modes.BATCH);
//            FacesUtil.storeOnSession(WebConstants.SessionVariable.CONFIG_SET_MODE_ID, getConfigSetModeIdForMode());
//        }
//        calculateAndSetBatchCount();
//        initializeFormEntryBean(initializePage);
////        if(calculateDlnRecordNumber) {
//            calculateDlnAndRecordNumber();   
////        }
////        generateFormButtonsBar();
//    }
//    
//    private void calculateAndSetBatchCount() {
//        List batchEntries = getBatchEntries();
//        if(batchEntries == null) {
//            batchCount = 0;
//        }else{
//            batchCount = batchEntries.size();
//        }
//    }
//    
//    private void initializeFormEntryBean(boolean initializePage) {
//        InputType previousType = null;
//        if(currentEntryBean != null) {
//            previousType = getBaseType();
//        }
//        if(initializePage) {
//            // we need to generate the related backing bean for batch entry and put the instance to the session scope with
//            // its backing bean name used in sessionscope.
////            currentEntryBean = (BackingBase)refDelegate.getInstance(batchFormTypeInfoBag.getBackingBeanUsed());
//        }
//        else {
//            FacesUtil.storeOnRequestScope(DONT_INITIALIZE_PAGE, true);
//        }
//        // if the mode changes to batch submit, then the page should be initialized with the last batch entry record,
//        // not with a new one. So we need to send the last records primary key as a search result to the related backing
//        // bean.
//        if(previousType != null &&
//            FacesUtil.getFromProcessScope(WebConstants.ProcessScopeVariable.GUI_MODE).equals(Constants.Modes.BATCH_SUBMIT) 
////            &&
////            FacesUtil.getFromRequest(SearchDelegate.CURRENT_ROW_KEY) == null // we should not execute this if statement at 
//                                                                             // submit button action, so we need to check for that.
//        ) {
//            SearchResultInfo info = new SearchResultInfo();
//            info.setPrimaryKey(previousType.getId());
////            FacesUtil.storeOnRequestScope(SearchDelegate.CURRENT_ROW_KEY, info);
//            nextItemState = NEXT_ITEM_STATE.SAMEITEMASPREVIOUS;
//        }
//        else if(previousType != null) {
//            // if the previous one wasnot the last item, then the next one can be an existing input type which was saved before.
//            if(itemNumber.equals(batchCount) && !getBatchEntries().isEmpty()) {
//                //select the next one.
//                SearchResultInfo info = getBatchEntries().get(itemNumber);//the next one.
////                FacesUtil.storeOnRequestScope(SearchDelegate.CURRENT_ROW_KEY, info);
//                nextItemState = NEXT_ITEM_STATE.EXISTINGITEM;
//                
//            }
//            else {
//                // then there is no next item, we will open a fresh page.
//                nextItemState = NEXT_ITEM_STATE.NEWITEM;
//            }
//        }
//        else {
//            // previous type is null.
////             Object selectedRecord = FacesUtil.getFromRequest(SearchDelegate.CURRENT_ROW_KEY);
////             if(selectedRecord == null) {
////                 if(batchCount == 0){
////                    nextItemState = NEXT_ITEM_STATE.NOPREVIOUSITEM_NEWITEM;
////                }else{
////                    nextItemState = NEXT_ITEM_STATE.NEWITEM;
////                }                    
////             }else {
////                 nextItemState = NEXT_ITEM_STATE.NOPREVIOUSITEM_EXISTINGITEM;
////             }
//        }
//        
//        // the workflow buttons will not be visible for the inner frame bean because the batch details (outer frame)
//        // will have its own workflow buttons which will delegate the action to the inner frame.
//        currentEntryBean.setWorkflowButtonsVisible(false);
//        String beanName = currentEntryBean.getSessionWorker().managedBeanName();
//        FacesUtil.storeOnSession(beanName, currentEntryBean);
//    }
//
//    public void setBatchDetails(BatchDetailsInputType batchDetails) {
//        this.batchDetails = batchDetails;
//    }
//
//    public BatchDetailsInputType getBatchDetails() {
//        if(batchDetails == null) {
//            BackingBatchDetails batchDetailsBean = (BackingBatchDetails)FacesUtil.getManagedBeanValue("backingBatchDetails");
////            batchDetails = batchDetailsBean.getBatchInputType();
//        }
//        return batchDetails;
//    }
//
//    public void setLinkPageUrl(String linkPageUrl) {
//        this.linkPageUrl = linkPageUrl;
//    }
//
//    public String getLinkPageUrl() {
//        return linkPageUrl;
//    }
//    
//    /**
//     * The search results which were previously entered within this batch are found.
//     * @return
//     */
////    public List<SearchResultInfo> retrieveBatchEntries() {
////        List<SearchResultInfo> infos = null;
////        // the search results which were previously entered within this batch are found.
////        infos = batchDelegate.retrieveBatchEntries(
////            batchFormTypeInfoBag.getSearchId(),"BatchId", batchDetails.getId());
////        Collections.sort(infos, pkComparator);
////        return infos;
////    }
//    
//    static final Comparator<SearchResultInfo> pkComparator = 
//        new Comparator<SearchResultInfo>() {
//            public int compare(SearchResultInfo o1, SearchResultInfo o2) {
//                return ((Long)o1.getPrimaryKey()).compareTo((Long)o2.getPrimaryKey());
//                }
//        };
//    
//    /**
//     * If all the batch entries has been filled, then the page mode should change to submit so that the related buttons is visible.
//     */
//    public void changePageModeIfNecessary() {
//        
//        if(getBatchEntries() == null ||
//        !getBatchDetails().getBatchDetails().getNumberOfItems().equals(getBatchEntries().size())) {
//            //workflow only can submit if created i.e saved
//            if(getBatchDetails().getBatchDetails().getBatchStatus().equalsIgnoreCase(Constants.BatchStatus.RECEIVED)){
//                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.GUI_MODE, Constants.Modes.BATCH_SUBMIT);
//                initializeFormEntryBean(false);
////                generateFormButtonsBar();
//            }
//        }
//    }
//    
//    public List<SearchResultInfo> getBatchEntries() {
////        if(batchEntries == null) {
////            batchEntries = retrieveBatchEntries();
////        }
//        return batchEntries;
//    }
//    
//    private String buttonId;    
//    public void workflowActionListener(ActionEvent event) {
//        buttonId = event.getComponent().getId();
//        // button id is the action that we are performing. if it is "SUBMIT", we will find all the related input types
////        if(buttonId.equals(FlexFormsConstants.GeneralFormActions.SUBMIT)) {
////            List<SearchResultInfo> infos = getBatchEntries();
////            calculateAndSetBatchCount();
////            // for earch result, we will reinitialize the related backing bean and call their workflowaction method, so
////            // that for each result, their dedicated bpel will work in order to submit.
////            for(SearchResultInfo info:infos) {
////                FacesUtil.storeOnRequestScope(searchDelegate.CURRENT_ROW_KEY,info); 
////                initializeFormEntryBean(false);
////                // we need to set the action and mode to the input type used in the backing bean.
////                getBaseType().setPageAction(buttonId);
////                getBaseType().setPageMode(getPageMode());
////                getBaseType().setPageMode(getPageMode());
////                getBaseType().setStatus(Constants.BatchStatus.SUBMITTED);
////                getBaseType().setCreatedBy(getLoggedInUser());
////                getBaseType().setUpdatedBy(getLoggedInUser());
////                currentEntryBean.workflowAction(false);
////                batchDelegate.updateRecordStatus(((TaxReturnFlexibleFormInputType)getBaseType()).getBaseTable(),(Long)info.getPrimaryKey(),Constants.BatchStatus.SUBMITTED);
////            }
////            // we have to remove the current row key from the request scope because it will create inconsistincies in
////            // initializeNewEntry method.
////            FacesUtil.storeOnRequestScope(searchDelegate.CURRENT_ROW_KEY, null);
////            getBatchDetails().getBatchDetails().setBatchStatus(Constants.BatchStatus.SUBMITTED);
////            batchDelegate.tiggerNextWorkflowState(getBatchDetails().getBatchDetails());
////            Object[] args = new Object[]{getBatchDetails().getBatchDetails().getBatchReference()};
////            
////            FacesUtil.addFacesMessage(FacesMessage.SEVERITY_WARN, 
////                            WebConstants.Messages.CONFIRMATION, 
////                            "Global.message.Batch",
////                            "Global.message.BatchSubmitted",
////                            args);  
////        }
////        else {
////            // we need to set the action and mode to the input type used in the backing bean.
////            getBaseType().setPageAction(buttonId);
////            getBaseType().setPageMode(getPageMode());
////            // we need to send the batch related attributes to map the batch entry with the actual data.
////            getBaseType().setBatchDetails(getBatchDetails().getBatchDetails());
////            getBaseType().getBatchDetails().setDln(dln);
////            getBaseType().getBatchDetails().setId(batchDetails.getId());
////            getBaseType().setStatus(Constants.BatchStatus.RECEIVED);
////            getBaseType().setCreatedBy(getLoggedInUser());
////            getBaseType().setUpdatedBy(getLoggedInUser());
////         
////            // for all the other button actions, we will delegate the workflow action to the dedicated backing bean.
////            String actionString = currentEntryBean.workflowAction(false);
////            // if there is a validation error, do not go to the next batch entry, stay in the same page.
////            if(actionString == null || actionString.equals(WebConstants.Navigation.SELF)) {
////                return;
////            }else{
////                /*
////                 * Introduced to reduce error fixing by error holder in the next
////                 * stage of this batch procesing workflow
////                 */
////                if(qualityCheck){
////                    if(!doQualityChecks((FlexibleFormsInputType)getBaseType())){
////                        return;
////                    }
////                }
////                
////                Object[] args = new Object[]{dln};
////                FacesUtil.addFacesMessage(FacesMessage.SEVERITY_INFO,
////                                "Global.message.Record",
////                                "Global.message.BatchDetailRecordSaved",
////                                args);  
////            }
////            batchEntries = retrieveBatchEntries();
////        }
//        initializeForNewEntry(false);
//        FacesUtil.refreshCurrentPage();       
//    }
//    
//    public String workflowAction() {
////        if(buttonId.equals(FlexFormsConstants.GeneralFormActions.SUBMIT)) {
////            return WebConstants.Navigation.HOME;    
////        }
//        return null;        
//    }
//    
//    private void calculateDlnAndRecordNumber() {
//        String dlnSeqLength = refDelegate.findSystemParameter(Constants.SystemParameterCode.DLN_SEQUENCE_LENGTH);
//        int seqLength = Integer.valueOf(dlnSeqLength);
//        if(nextItemState.equals(NEXT_ITEM_STATE.SAMEITEMASPREVIOUS)) {
//            // do nothing.
//        }
////        else if(nextItemState.equals(NEXT_ITEM_STATE.EXISTINGITEM)) {
////            dln = FlexibleFormsHelper.getNextDLNNumber(dln, seqLength);
////            itemNumber += 1;
////        }
////        else if(nextItemState.equals(NEXT_ITEM_STATE.NEWITEM)) {
////            Integer totalRecordsSoFar = getBatchEntries().size();
////            String dlnRangeFrom = batchDetails.getBatchDetails().getDlnRangeFrom();
////            dln = FlexibleFormsHelper.getDLNNumberByAdding(dlnRangeFrom, seqLength, totalRecordsSoFar);
////            itemNumber = totalRecordsSoFar + 1;
////        }
//        else if(nextItemState.equals(NEXT_ITEM_STATE.NOPREVIOUSITEM_EXISTINGITEM)) {
//            if(getBaseType() != null){
//                dln = getBaseType().getBatchDetails().getDln();
////            itemNumber = dln - batchDetails.getBatchDetails().getDlnRangeFrom() + 1;
//            //TODO check with Kemal on this logic...
//                itemNumber = getItemNumber(batchDetails.getBatchDetails().getDlnRangeFrom(), dln, seqLength);
//            }
//        }
//        else if(nextItemState.equals(NEXT_ITEM_STATE.NOPREVIOUSITEM_NEWITEM)) {
//            dln = batchDetails.getBatchDetails().getDlnRangeFrom();
//            itemNumber = 1;
//        }
//
////        if(getBaseType() != null) { 
////            // if the next item is a new item.
////            if(getBaseType().getId() == null || "CALCULATE_DLN_AND_OTHERS".equals(getBaseType().getStatus())) {
////                Integer totalRecordsSoFar = getBatchEntries().size();
////                Integer dlnRangeFrom = batchDetails.getBatchDetails().getDlnRangeFrom();
////                dln = dlnRangeFrom+totalRecordsSoFar;
////                itemNumber = totalRecordsSoFar + 1;
////                return;
////            }
////            // if the next item is an existing item.
////            else if(itemNumber != batchCount) {
////                dln += 1;
////                itemNumber += 1;
////                return;
////            }
////        }
////        // if there is no previous item, this is the first time we are entering the page in update or add mode.
////        dln = getBaseType().getBatchDetails().getDln();
////        itemNumber = dln - batchDetails.getBatchDetails().getDlnRangeFrom() + 1;
//    }
//    
////    private BatchDetails findBatchDetails() {
////        BatchDetails bd = batchDelegate.findBatchDetails((FlexibleFormsInputType)currentEntryBean.getBaseType());
////        return  bd;
////    }
//    
//    /**
//     * Wrapper method for getting the base type from the current entry bean.
//     * @return
//     */
//    public InputType getBaseType() {
//        InputType baseType = currentEntryBean.getBaseType();
////        if(baseType != null && baseType.getId() != null && baseType.getBatchDetails() == null) {
////            baseType.setBatchDetails(findBatchDetails());
////        }
//        return baseType;
//    }
//    
//    /**
//     * This method is used for initializing this backing bean initially. In BatchEntryWrapper page, this backing bean
//     * should be initialized first instead of the entry backing bean. So I bind the title component value to this backing
//     * bean and it will initialize this backing bean first, because af:title component is the first component in the page.
//     * @return
//     */
//    public String getTitle() {
//        return (String)FacesUtil.resolveExpression("#{resources['BatchEntryWrapper.pageTitle']}");
//    }
//
//    public void setBatchCount(Integer batchCount) {
//        this.batchCount = batchCount;
//    }
//
//    public Integer getBatchCount() {
//        return batchCount;
//    }
//
////    public void setDln(Integer dln) {
////        this.dln = dln;
////    }
////
////    public Integer getDln() {
////        return dln;
////    }
//
//    public void setItemNumber(Integer itemNumber) {
//        this.itemNumber = itemNumber;
//    }
//
//    public Integer getItemNumber() {
//        return itemNumber;
//    }
//    
//    public int getItemNumber(String start, String current, int lengthOfSequence){
//        if (start == null || current == null || lengthOfSequence == 0) return 0;
//        Integer startSeq = Integer.valueOf(start.substring( start.length() - lengthOfSequence )) ;
//        Integer currentSeq = Integer.valueOf(current.substring( current.length() - lengthOfSequence )) ;
//        
//        return currentSeq - startSeq;
//    }

}
