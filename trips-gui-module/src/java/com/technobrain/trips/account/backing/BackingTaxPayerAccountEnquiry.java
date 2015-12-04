package com.technobrain.trips.account.backing;

//package com.crownagents.trips.account.backing;
//
//import com.crownagents.trips.account.delegate.TaxpayerAccountDelegate;
//import com.crownagents.trips.core.backing.BackingBase;
//import com.crownagents.trips.core.backing.BackingProcessScopeConstants;
//import com.crownagents.trips.core.bean.HeaderSummaryDetailsBean;
//import com.crownagents.trips.core.delegate.ReferenceCodeDelegate;
//import com.crownagents.trips.core.searchframework.delegate.SearchDelegate;
//import com.crownagents.trips.core.searchframework.rowWrapper.EntityInputTypeRowWrapper;
//import com.crownagents.trips.core.sessionmanager.annotation.SessionWorker;
//
//import com.crownagents.trips.registration.delegate.RegistrationDelegate;
//
//import com.crownagents.trips.util.FacesUtil;
//import com.crownagents.trips.util.WebConstants;
//import com.technobrain.trips.common.constants.Constants;
//import com.technobrain.trips.common.helpers.search.SearchResultInfo;
//import com.technobrain.trips.document.model.DfinRevCollInstrument;
//import com.technobrain.trips.document.model.DfinRevCollReceipt;
//import com.technobrain.trips.dto.document.DocEventDetails;
//import com.technobrain.trips.dto.tax.accounting.GenericRegimePeriodSummaryBean;
//import com.technobrain.trips.dto.tax.accounting.GenericTransactionPeriodBean;
//import com.technobrain.trips.dto.tax.accounting.RegimeSummary;
//import com.technobrain.trips.reference.model.RefDocType;
//import com.technobrain.trips.search.exception.InvalidSearchCriteria;
//
//import java.io.IOException;
//
//import java.math.BigDecimal;
//
//import java.text.DecimalFormat;
//import java.text.NumberFormat;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//
//import javax.faces.context.FacesContext;
//import javax.faces.model.SelectItem;
//
//import javax.servlet.http.HttpServletResponse;
//
//
//import org.apache.commons.collections.comparators.NullComparator;
//import org.primefaces.context.RequestContext;
//
//
//@SessionWorker(
//    managedBeanName="backingTaxPayerAccEnquiry", 
//    stayAlive = "/account/AccountEnquiry.jspx," +
//    "/tax/returns/*.jspx," +
//    "/revenuecollection/PaymentSummary.jspx,/revenuecollection/PaymentDetails.jspx" +
//    "/customs/declaration/DeclarationDetails.jspx,/casemanagement/*.jspx,",
//    processScopeVariables=""+WebConstants.ProcessScopeVariable.REGIME_TYPE+","+WebConstants.ProcessScopeVariable.ENTITY_ID
//) 
//public class BackingTaxPayerAccountEnquiry extends BackingBase {
//    
//    HeaderSummaryDetailsBean headerSummaryBean;    
//    boolean individualType ;
//    
//    private ReferenceCodeDelegate refDelegate;
//    private TaxpayerAccountDelegate  accountEnquiryDelegate;
//    private CorePanelTabbed accountEnquirySelectOneTab;
//    
//    private CoreShowDetailItem showDetailItemOne,showDetailItemFour;
//    
//    private CoreShowDetailItem showDetailItemCustoms;
//    
//    private CoreTable summaryTable;
//                              
//    private List<RegimeSummary> summaryList;
//    private List<RegimeSummary> revenueList;
//    private List<RegimeSummary> adhocRevenueList;
//      
//    private List<DfinRevCollReceipt> dfinRevCollReceiptList;
//    
//    
//    private CoreTable genericPeriodicDetailsTable;
//
//    private RegistrationDelegate regDelegate;
//    private DfinRevCollInstrument currentSelectedInstrumentBean;
//    private GenericTransactionPeriodBean currentSelectedPeriodTrans;
//    private DocEventDetails currentSelectedDocEventDetails;
//    /*
//     * DROP DOWNS
//     */
//    private List <SelectItem> accountStatusList;
//    private List <SelectItem> legalStatusList;
//    private String tinNumber;
//    private String entityName;
//    
//    Boolean isFromPortal = null; 
//
//
//    public BackingTaxPayerAccountEnquiry() {
//        RequestContext ctx = RequestContext.getCurrentInstance();
//        refDelegate = refDelegate == null ? new ReferenceCodeDelegate() : refDelegate;
//        regDelegate = regDelegate == null ? new RegistrationDelegate() : regDelegate;
//        accountEnquiryDelegate = accountEnquiryDelegate == null ? new TaxpayerAccountDelegate() : accountEnquiryDelegate;
//        isFromPortal = Boolean.valueOf((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("IS_FROM_PORTAL"));
//        getHeaderSummaryBean();
//        if(headerSummaryBean != null){
//            individualType = headerSummaryBean.isIndividual();
//            summaryList = accountEnquiryDelegate.findAccountEnquirySummaryDetails(headerSummaryBean.getTin());
//                      
//            /*
//             * Filters the regimes to be displayed
//             */
//            String regimeFilter = (String) ctx.getPageFlowScope().get(WebConstants.ProcessScopeVariable.REGIME_TYPE);
//            if(regimeFilter != null){
//                Iterator listTobeFiltered = summaryList.iterator();
//                while(listTobeFiltered.hasNext()){
//                    RegimeSummary rs = (RegimeSummary)listTobeFiltered.next();
//                    if(!rs.getAccountType().equalsIgnoreCase(regimeFilter)){
//                        listTobeFiltered.remove();
//                    }
//                }
//            }
//            
//            getTotalSummaryBalance();
//            if(summaryList == null) {
//                summaryList = new ArrayList();
//                
//            }else{
//               RegimeSummary suspense = null;
//               Collections.sort(summaryList, RegimeTypeComparator);
//               Iterator listTobeFiltered = summaryList.iterator();
//               while (listTobeFiltered.hasNext()) {
//                   RegimeSummary rs = (RegimeSummary)listTobeFiltered.next();
//                   if (rs.getRegimeDescription()!=null && rs.getRegimeDescription().equalsIgnoreCase(Constants.Regimes.SUSPENSE)) {
//                       suspense=rs;
//                       listTobeFiltered.remove();
//                   }
//               }
//               if(suspense!=null){
//                   summaryList.add(0, suspense);
//               }
//                
//            }
//           
//        }else{
//          
//        }
//        
//    }
//    
////    public void paymentTabListener(DisclosureEvent event){
////        if(null == dfinRevCollReceiptList){
////            this.dfinRevCollReceiptList = accountEnquiryDelegate.findPayments(getHeaderSummaryBean().getTin());
////        }
////    }
//    
//    public void adhocTabListener(DisclosureEvent event){
//        CoreShowDetailItem detailItem = (CoreShowDetailItem)event.getComponent();
//        String regimeNumber=null;
//        for(RegimeSummary regimeSummary:adhocRevenueList){
//            if(regimeSummary.getRegimeNumber().equalsIgnoreCase(detailItem.getShortDesc())){
//                regimeNumber=detailItem.getShortDesc();
//                if(regimeSummary.getDocumentDataList()==null || regimeSummary.getDocumentDataList().size()==0){
//                    loadAdhocAccountDetails(regimeSummary);
//                }
//                break;
//            }
//        }        
//    }
//
//    public void periodicTabListener(DisclosureEvent event){    
//        CoreShowDetailItem detailItem = (CoreShowDetailItem)event.getComponent();
//        String regimeNumber=null;
//        for(RegimeSummary regimeSummary:revenueList){
//            if(regimeSummary.getRegimeNumber().equalsIgnoreCase(detailItem.getShortDesc())){
//                regimeNumber=detailItem.getShortDesc();
//                if(regimeSummary.getPeriodInfo()==null || regimeSummary.getPeriodInfo().size()==0){
//                    loadPeriodicAccountDetails(regimeSummary);
//                }
//                break;
//            }
//        }        
//    }
//
//    private void loadAdhocAccountDetails(RegimeSummary regimeSumamry) {
//        String docBalForDisplay = null;
//        BigDecimal sumOfCrAmounts = null;
//        BigDecimal sumOfDrAmounts = null;
//        BigDecimal balanceDueAmount = null;
//    
//        List<GenericRegimePeriodSummaryBean> periodTransSummary = 
//            accountEnquiryDelegate.findRegimePeriodSummaries(regimeSumamry.getAccountId());
//    
//        if (periodTransSummary != null && periodTransSummary.size() != 0) {
//            List<GenericTransactionPeriodBean> adhocTransactionList = null;
//            List<GenericTransactionPeriodBean> documentDataList = null;
//
//            if (periodTransSummary != null && periodTransSummary.size() > 0) {
//                for (GenericRegimePeriodSummaryBean result: periodTransSummary) {
//                    balanceDueAmount = new BigDecimal(0);
//                    documentDataList = new ArrayList<GenericTransactionPeriodBean>();
//                    for (GenericTransactionPeriodBean docBean: result.getDocumentDataList()) {
//                        sumOfCrAmounts = new BigDecimal(0);
//                        sumOfDrAmounts = new BigDecimal(0);
//                        adhocTransactionList = new ArrayList<GenericTransactionPeriodBean>();
//                        for (GenericTransactionPeriodBean trnBean: result.getPeriodTransactionList()) {
//                            if (trnBean.getDdocDocument() != null && 
//                                docBean.getDdocDocument() != null) {
//                                trnBean.setPeriodStatusActive(Constants.RecordStatus.ACTIVE.equalsIgnoreCase(result.getRecordStatus()));
//                                if (trnBean.getDdocDocument().longValue() == 
//                                    docBean.getDdocDocument().longValue()) {
//                                    if (trnBean.getTransactionType() != null && 
//                                        trnBean.getTransactionType().equals("DEBIT")) {
//                                        sumOfDrAmounts = sumOfDrAmounts.add(trnBean.getBalanceDue());
//                                    }
//                                    if (trnBean.getTransactionType() != null && trnBean.getTransactionType().equals("CREDIT")) {
//                                        sumOfCrAmounts = sumOfCrAmounts.add(trnBean.getBalanceDue());
//                                    }
//                                    adhocTransactionList.add(trnBean);
//                                }
//                            }
//                        }
//                        docBean.setPeriodStatusActive(Constants.RecordStatus.ACTIVE.equalsIgnoreCase(result.getRecordStatus()));
//                        docBean.setDocumentTransactionList(adhocTransactionList);
//                        balanceDueAmount = sumOfDrAmounts.subtract(sumOfCrAmounts);
//                        docBalForDisplay = getDocBalForDisplay(balanceDueAmount);
//                        docBean.setDocBalForDisplay(docBalForDisplay);
//                        groupTransactionsByEvent(docBean);
//                        documentDataList.add(docBean);
//                    }
//                    if (regimeSumamry.getDocumentDataList() != null && 
//                        regimeSumamry.getDocumentDataList().size() > 0) {
//                        regimeSumamry.getDocumentDataList().addAll(documentDataList);
//                    } else {
//                        regimeSumamry.setDocumentDataList(documentDataList);
//                    }
//
//                }
//                if (regimeSumamry.getDocumentDataList() != null) {
//                    Collections.sort(regimeSumamry.getDocumentDataList(), new DocumentComparator());
//                }
//            }
//        } else {
//            // do nothing  
//        }
//        
//    }
//    
//     private void loadPeriodicAccountDetails(RegimeSummary regimeSumamry) {
//         String docBalForDisplay = null;
//         BigDecimal sumOfCrAmounts = null;
//         BigDecimal sumOfDrAmounts = null;
//         BigDecimal balanceDueAmount = null;
//         
//         List<GenericRegimePeriodSummaryBean> periodTransSummary = 
//             accountEnquiryDelegate.findRegimePeriodSummaries(regimeSumamry.getAccountId());
//         if (periodTransSummary != null && periodTransSummary.size() != 0) {
//             List<GenericTransactionPeriodBean> transactionList = null;
//             List<GenericTransactionPeriodBean> documentDataList = null;
//             if (periodTransSummary != null && periodTransSummary.size() > 0) {
//                 for (GenericRegimePeriodSummaryBean result: periodTransSummary) {
//                     documentDataList = new ArrayList<GenericTransactionPeriodBean>();
//                     balanceDueAmount = new BigDecimal(0);
//                     for (GenericTransactionPeriodBean docBean: result.getDocumentDataList()) {
//                         sumOfCrAmounts = new BigDecimal(0);
//                         sumOfDrAmounts = new BigDecimal(0);
//                         transactionList = new ArrayList<GenericTransactionPeriodBean>();
//                         for (GenericTransactionPeriodBean trnBean: result.getPeriodTransactionList()) {
//                             if (trnBean.getDdocDocument() != null && docBean.getDdocDocument() != null) {
//                                 if (trnBean.getDdocDocument().longValue() == docBean.getDdocDocument().longValue()) {
//                                     if (trnBean.getTransactionType() != null && 
//                                         trnBean.getTransactionType().equals("DEBIT")) {
//                                         sumOfDrAmounts = sumOfDrAmounts.add(trnBean.getBalanceDue());
//                                     }
//                                     if (trnBean.getTransactionType() != null && 
//                                         trnBean.getTransactionType().equals("CREDIT")) {
//                                         sumOfCrAmounts = sumOfCrAmounts.add(trnBean.getBalanceDue());
//                                     }
//                                     transactionList.add(trnBean);
//                                 }
//                             }
//                         }
//                         docBean.setDocumentTransactionList(transactionList);
//                         balanceDueAmount = sumOfDrAmounts.subtract(sumOfCrAmounts);
//                         docBalForDisplay = getDocBalForDisplay(balanceDueAmount);
//                         docBean.setDocBalForDisplay(docBalForDisplay);
//                         documentDataList.add(docBean);
//                         groupTransactionsByEvent(docBean);
//                     }
//                     result.setDocumentDataList(documentDataList);
//                 }
//             }
//         }
//         regimeSumamry.setPeriodInfo(periodTransSummary);
//     }
//
//
//    public String getRun() {
//        String result = super.getRun(null);       
//        return result;
//    }
//    /**
//     * Caluclates the total balance of all accounts for given taxpayer.
//     * @return String
//     */
//    public String getTotalSummaryBalance(){
//        BigDecimal totalBalance = BigDecimal.ZERO;
//        totalBalance = totalBalance.setScale(2,BigDecimal.ROUND_HALF_UP);
//        String totalBalanceForDisplay =null;
//        String transactionType = null;
//        
//        if(summaryList != null){            
//            for(int i=0; i<summaryList.size(); i++){
//                RegimeSummary regimeSummary = (RegimeSummary)summaryList.get(i);
//               if(regimeSummary.getBalance() != null){
//                    if(log.isDebugEnabled())log.debug("regimeSummary.getBalance() "  + regimeSummary.getBalance());
//                    totalBalance = totalBalance.add(regimeSummary.getBalance());
//                   if(log.isDebugEnabled())log.debug("totalBalance "+ totalBalance);
//               }
//            }
//        }
//        
//        if (totalBalance.doubleValue()<0){
//            transactionType = "CR";
//        }else
//            transactionType = "";
//        totalBalance = totalBalance.abs();
//        DecimalFormat decimalFormat = getDecimalFormat(FacesUtil.getLocale());
//        decimalFormat.setMaximumFractionDigits(2);
//        decimalFormat.setMinimumFractionDigits(2);
//        decimalFormat.setGroupingUsed(true);   
//        String formatted = decimalFormat.format(totalBalance);
//        totalBalanceForDisplay = formatted+ " "+transactionType;
//        
//        
//        return totalBalanceForDisplay;
//    }
//    
//    private DecimalFormat getDecimalFormat(Locale locale){
//        DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getInstance(locale);
//        
//        return decimalFormat;
//    }
//    
//   
//    public void setGenericPeriodicDetailsTable(CoreTable genericPeriodicDetailsTable) {
//        this.genericPeriodicDetailsTable = genericPeriodicDetailsTable;
//    }
//
//    public CoreTable getGenericPeriodicDetailsTable() {
//        return genericPeriodicDetailsTable;
//    }
//
//
//    /**
//     * Shows the regime tabe for the record selected
//     * @return
//     */
//    public String activateTab() {
//        RegimeSummary regimeSummaryBean = null;
//        
//        if(summaryTable == null){
//            FacesUtil.addFacesErrorMessage("Global.msg.NoRecordsFound");
//            return null; 
//        }
//        
//        regimeSummaryBean = (RegimeSummary)summaryTable.getSelectedRowData();
//        
//        // no row selected return error message
//        if(regimeSummaryBean == null){
//            FacesUtil.addFacesErrorMessage("Global.msg.AtLeastOneFieldIsRequired");
//            return null; 
//        }
//           
//        
//        manageAllTabs(false); // first close all the tabs show we can determine which to open
//        
//         if(log.isDebugEnabled())log.debug("regimeType " + regimeSummaryBean.getAccountType());
//         
//        determineCorrespondingTab(regimeSummaryBean.getAccountType()).setDisclosed(true);
//       
//        return null;
//    }
//    
//    
//    private void manageAllTabs(boolean disclosed){    
//        showDetailItemOne.setDisclosed(disclosed);
//        showDetailItemFour.setDisclosed(disclosed);
//        showDetailItemCustoms.setDisclosed(disclosed);
//    }
//
//    private CoreShowDetailItem determineCorrespondingTab(String regimeType){
//       
//        
//        if(regimeType.equalsIgnoreCase(Constants.Regimes.SUSPENSE)){
//            return  showDetailItemFour == null ? showDetailItemFour = new CoreShowDetailItem(): showDetailItemFour;
//        }
//        
//        if(regimeType.equalsIgnoreCase(Constants.Regimes.CUSTOMS)){
//            return  showDetailItemCustoms == null ? showDetailItemCustoms = new CoreShowDetailItem(): showDetailItemCustoms;
//        }
//       
//        
//      throw new IllegalAccessError("No corresponding tab");
//    }
//    
//    private CoreShowDetailItem updateTabRenderedAttr(boolean rendered, CoreShowDetailItem tab){
//        if(null == tab){
//            tab = new CoreShowDetailItem();
//        }
//        
//            tab.setRendered(rendered);
//        return tab;
//    }        
//
//
//    public void setAccountStatusList(List<SelectItem> accountStatusList) {
//        this.accountStatusList = accountStatusList;
//    }
//    /**
//     * return the list of account statuses from ref table 
//     * @return
//     */
//    public List<SelectItem> getAccountStatusList() {
//        if(accountStatusList == null){
//            accountStatusList = new ArrayList <SelectItem>();
//            accountStatusList = refDelegate.findAllRevenueAccountStatus(headerSummaryBean.getStatus());
//        }
//        return accountStatusList;
//    }
//
//
//    public void setAccountEnquirySelectOneTab(CorePanelTabbed accountEnquirySelectOneTab) {
//        this.accountEnquirySelectOneTab = accountEnquirySelectOneTab;
//    }
//
//    public CorePanelTabbed getAccountEnquirySelectOneTab() {
//        return accountEnquirySelectOneTab;
//    }
//
//    public void setShowDetailItemOne(CoreShowDetailItem showDetailItemOne) {
//        this.showDetailItemOne = showDetailItemOne;
//    }
//
//    public CoreShowDetailItem getShowDetailItemOne() {
//        return showDetailItemOne;
//    }
//
//   
//
//    public void setShowDetailItemFour(CoreShowDetailItem showDetailItemFour) {
//        this.showDetailItemFour = showDetailItemFour;
//    }
//
//    public CoreShowDetailItem getShowDetailItemFour() {
//        return showDetailItemFour;
//    }
//
//    
//    public void setSummaryTable(CoreTable summaryTable) {
//        this.summaryTable = summaryTable;
//    }
//
//    public CoreTable getSummaryTable() {
//        return summaryTable;
//    }
//
//
//    public String showTransactionScreen() {
//        // Add event code here...
//        return null;
//    }
//    
//    public void setSummaryList(List<RegimeSummary> summaryList) {
//        this.summaryList = summaryList;
//    }
//
//    public List getSummaryList() {
//        return summaryList;
//    }
//
//
//    public String showTransactionDetailsScreen() {
//        // Add event code here...
//        return null;
//    }
//
//    public void detailTableAttrChangeListener(AttributeChangeEvent attributeChangeEvent) {
//       if(log.isDebugEnabled())log.debug("" + attributeChangeEvent.getComponent().getClass() );
//        if(log.isDebugEnabled())log.debug("getAttribute " + attributeChangeEvent.getAttribute() );
//        if(log.isDebugEnabled())log.debug("getNewValue " + attributeChangeEvent.getNewValue() );
//        if(log.isDebugEnabled())log.debug("getSource " + attributeChangeEvent.getSource().getClass() );
//        // Add event code here...
//    }
//
//     public String detailTableGetRecord() {
//        
//        if(null != getCaller()){
//         Map parameters = new HashMap();
//         getCaller().doAction("detailTableGetRecord",this,parameters);
//         return goCancelNav();
//        }else{
//            return null;
//        }
//     }
//      //docEvenetTableListener   
//    
//    public void docEventTableListener(SelectionEvent selectionEvent) {
//           CoreTable table = (CoreTable)selectionEvent.getComponent();
//           Object row =  table.getSelectedRowData();
//           currentSelectedDocEventDetails = (DocEventDetails)row;
//           if(currentSelectedDocEventDetails != null && currentSelectedDocEventDetails.getAssociatedTransactions() != null && currentSelectedDocEventDetails.getAssociatedTransactions().size() > 0){
//               currentSelectedPeriodTrans = currentSelectedDocEventDetails.getAssociatedTransactions().get(0);
//           }
////           currentSelectedPeriodTrans = (GenericTransactionPeriodBean)row; 
//    }
//    public void detailTableSelectionListener(SelectionEvent selectionEvent) {
//        CoreTable table = (CoreTable)selectionEvent.getComponent();
//        Object row = table.getSelectedRowData();
//        currentSelectedPeriodTrans = (GenericTransactionPeriodBean)row; 
//    }
//    
//    public void setHeaderSummaryBean(HeaderSummaryDetailsBean headerSummaryBean) {
//        this.headerSummaryBean = headerSummaryBean;
//    }
//    /**
//     *  returns the header details for taxpayer 
//     * @return
//     */
//    public HeaderSummaryDetailsBean getHeaderSummaryBean() {
//        if(null == headerSummaryBean){
//           if(SearchDelegate.getSelectedRow() != null){
//            EntityInputTypeRowWrapper rowWrapper = new EntityInputTypeRowWrapper(SearchDelegate.getSelectedRow());
//            headerSummaryBean = 
//                    regDelegate.findHeaderDetails((Long)rowWrapper.getPrimaryKey());
//			setTinNumber(rowWrapper.getTinNumber());
//            setEntityName(rowWrapper.getEntityName());
//           }else{
//               RequestContext ctx = RequestContext.getCurrentInstance();
//               Long entityId = (Long)ctx.getPageFlowScope().get(WebConstants.ProcessScopeVariable.ENTITY_ID);
//               if(isFromPortal != null && isFromPortal.booleanValue()==true){ // Vietnam demo
//                   entityId = Long.valueOf((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("ENTITY_ID"));
//               }
//               if(null != entityId){ 
//                   headerSummaryBean = 
//                           regDelegate.findHeaderDetails(entityId);
//               }
//           }
//        }
//        return headerSummaryBean;
//    }
//
//    public void setIndividualType(boolean individualType) {
//        this.individualType = individualType;
//    }
//
//    public boolean isIndividualType() {
//        return individualType;
//    }
//
//    public void selectPaymentSummaryTab(SelectionEvent selectionEvent) throws InvalidSearchCriteria {
//    
//        CoreTable table = (CoreTable)selectionEvent.getComponent();
//        Object row = table.getSelectedRowData();
//        currentSelectedInstrumentBean = (DfinRevCollInstrument)row;
//        
//    }
//    /**
//     *  This method forwards the request to payment summary page.
//     * @return
//     * @throws InvalidSearchCriteria
//     */
//    public String navigateToPaymentSummary() throws InvalidSearchCriteria {
//         
//        if(currentSelectedInstrumentBean!=null){
////            FacesUtil.storeOnSession(WebConstants.RequestVariable.ACC_ENQ_ENT_ID_TO_PAYMENT,currentSelectedReceiptBean.getPayerEntId());
//            FacesUtil.storeOnRequestScope(WebConstants.RequestVariable.ACC_ENQ_TRANS_ID_TO_PAYMENT,currentSelectedInstrumentBean.getReceipt().getId());
//            FacesUtil.storeOnRequestScope("fromAccountEnquiryScreen",true);
//            FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.GUI_MODE, Constants.Modes.VIEW);
//              
//            return "FromAccountEnquiryToPaymentSummary";
//        }
//          
//        return null;
//         
//    }
//
//    public void setShowDetailItemCustoms(CoreShowDetailItem showDetailItemCustoms) {
//        this.showDetailItemCustoms = showDetailItemCustoms;
//    }
//
//    public CoreShowDetailItem getShowDetailItemCustoms() {
//        return showDetailItemCustoms;
//    }
//
//    public String goCancelNav() {
//        if(isFromPortal != null && isFromPortal.booleanValue()==true){ // Vietnam demo
//            HttpServletResponse resp = (HttpServletResponse)FacesUtil.getFacesContext().getExternalContext().getResponse();
//            try {
//                resp.sendRedirect("/gdt/myTaxPortal.jsp");
//                //FacesUtil.removeFromSession("backingTaxPayerAccEnquiry",true);
//            } catch (IOException e) {
//                 log.error(e.getLocalizedMessage(), e);
//            }
//            return null;
//        }
//        return super.goCancelNav();
//    }
//
//    public void setRevenueList(List<RegimeSummary> revenueList) {
//        this.revenueList = revenueList;
//    }
//    /**
//     * List the revenue accounts created for given taxpayer.
//     * @return
//     */
//    public List<RegimeSummary> getRevenueList() {
//        revenueList = new ArrayList<RegimeSummary>();
//        if(summaryList==null){
//            summaryList = accountEnquiryDelegate.findAccountEnquirySummaryDetails(headerSummaryBean.getTin());
//        }
//        if(summaryList!=null){
//            for (RegimeSummary regimeSummary: summaryList) {
//                if ((regimeSummary.getModeType() != null && 
//                      regimeSummary.getModeType().equals(Constants.AccountTypes.PERIODIC))) {
//                     revenueList.add(regimeSummary);
//                }
//            }    
//        }
//        return revenueList;
//    }
//
//    private void groupTransactionsByEvent(GenericTransactionPeriodBean document){
//        if(document != null && document.getDocumentTransactionList() != null){
//            Map<Long, DocEventDetails> eventMap = new HashMap<Long, DocEventDetails>();
//            for(GenericTransactionPeriodBean trnBean:document.getDocumentTransactionList()){
//                DocEventDetails eventDetails = null;
//                  if(eventMap.containsKey(trnBean.getDocEventId())) {
//                      eventDetails =  eventMap.get(trnBean.getDocEventId());
//                      eventDetails.getAssociatedTransactions().add(trnBean);
//                  } else {
//                      eventDetails  = new DocEventDetails(FacesUtil.getLocale());
//                      eventDetails.getAssociatedTransactions().add(trnBean);
//                      eventMap.put(trnBean.getDocEventId(), eventDetails);
//                  }
//                eventDetails.setPeriodStatusActive(document.isPeriodStatusActive());
//                eventDetails.setDocEvent(trnBean.getDocEventId());
//                eventDetails.setEventDate(trnBean.getEventDate());
//                eventDetails.setEventDesciption(trnBean.getRefEventDescription());
//                eventDetails.setEventTypeCategory(trnBean.getRefEventCategoryType());
//            }
//            ArrayList valuesList = new ArrayList<DocEventDetails>(eventMap.values());
//            Collections.sort(valuesList, new DocEventComparator());
//            document.setDocEventsList(valuesList);
//        }
//    }
//    public String navigateToEntryAction() {
//        // prepare the related process scope variables so that in the form generation they will be used to generate the page.
//        GenericTransactionPeriodBean currentTransaction = this.currentSelectedPeriodTrans;
//        BackingProcessScopeConstants backingProcessScopeConstants = new BackingProcessScopeConstants();
//       
//        if(currentTransaction!=null){
//            String docTypeCode = currentTransaction.getDocTypeCode();
//            RefDocType refDocType = (RefDocType)refDelegate.findRefEntityByCode(RefDocType.class,currentTransaction.getDocTypeCode());
//            if(Constants.DocumentType.RETURN.equalsIgnoreCase(currentTransaction.getDocTypeCode())){
//                //for tax return i.e flexi form
//                String documnentType = accountEnquiryDelegate.findDocumentType(currentTransaction.getDdocDocument());
//                if(null == documnentType){
//                    FacesUtil.addFacesErrorMessage("Global.BadData.Code","Global.BadData.Message");
//                    return null;
//                }
//                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.FORM_TYPE, documnentType);
//                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.GUI_MODE, Constants.Modes.VIEW);
//                
//                //ConfigSetMode mode = new ConfigurationDelegate().findConfigSetMode("DefaultWithBatch", Constants.Modes.VIEW);
//                //if(mode != null) {
//                    FacesUtil.storeOnSession(WebConstants.SessionVariable.CONFIG_SET_MODE_ID, 6L); //6L for view Mode
//                //} else {
//                //    FacesUtil.addFacesErrorMessage("Configuration set mode cannot be found.");
//                //    return null;
//                //}
//                SearchResultInfo info = new SearchResultInfo();
//                Long flexiFormId = accountEnquiryDelegate.findFlexibleFormId(currentTransaction.getDdocDocument());
//                info.setPrimaryKey(flexiFormId);
//                FacesUtil.storeOnRequestScope(SearchDelegate.CURRENT_ROW_KEY, info);
//                return "ToFlexibleFormEntry";
//            }
//            else
//            if(Constants.DocumentType.PAYMENT.equalsIgnoreCase(currentTransaction.getDocTypeCode())){
//                FacesUtil.storeOnProcessScope("hideOnReversePayment", true);
//                FacesUtil.storeOnProcessScope("reversePaymentListener", false);
//                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.GUI_MODE, Constants.Modes.VIEW);
//                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.GUI_CONFIG_KEY, Constants.GuiConfig.CRUD_CONFIG);
//                FacesUtil.storeOnProcessScope(backingProcessScopeConstants.getFromPaymentSummaryToAccountEnquiry(), "processScopePreviousPage");
//              
//                   
//                FacesUtil.storeOnRequestScope(WebConstants.RequestVariable.ACC_ENQ_TRANS_ID_TO_PAYMENT,currentTransaction.getDdocDocument());
//                FacesUtil.storeOnRequestScope("fromAccountEnquiryScreen",true);
//                
//                
//                return "FromAccountEnquiryToPaymentSummary";
//            }  else  if(Constants.DocumentType.ACCOUNT_ADJUSTMENT.equalsIgnoreCase(currentTransaction.getDocTypeCode())){
//                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.GUI_MODE, Constants.Modes.VIEW);
//                FacesUtil.storeOnProcessScope("docIdFromAccountEnquiryScreen", currentTransaction.getDdocDocument());
//                return "FromInquiryToAccountingAdjustment";
//            } else if(Constants.DocumentType.CREDIT_ALLOCATION.equalsIgnoreCase(currentTransaction.getDocTypeCode())){
//                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.GUI_MODE, Constants.Modes.VIEW);
//                FacesUtil.storeOnProcessScope("docIdFromAccountEnquiryScreen", currentTransaction.getDdocDocument());
//                return "FromInquiryToCreditAllocation";
//            }else  if(Constants.DocumentType.MANUAL_PENALTY.equalsIgnoreCase(currentTransaction.getDocTypeCode())){
//                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.GUI_MODE, Constants.Modes.VIEW);
//                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.DOC_ID, currentTransaction.getDdocDocument());
//                return "FromInquiryToManualPenalty";
//            }else if(Constants.DocumentType.REFUND_CLAIM.equalsIgnoreCase(currentTransaction.getDocTypeCode())){
//                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.GUI_MODE, Constants.Modes.VIEW);
//                FacesUtil.storeOnProcessScope("docIdFromAccountEnquiryScreen", currentTransaction.getDdocDocument());
//                return "FromInquiryToRefundDetails";
//            } else  if(Constants.DocumentType.INSTALMENT_AGREEMENT.equalsIgnoreCase(currentTransaction.getDocTypeCode())){
//                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.GUI_MODE, Constants.Modes.VIEW);
//                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.DOC_ID, currentTransaction.getDdocDocument());
//                return "FromInquiryToInstalmentAgreement";
//            }else if(refDocType.getRefDocCategory()!=null && 
//                        refDocType.getRefDocCategory().getCode().equalsIgnoreCase(Constants.DocumentCategory.RETURN)){
//                           
//                Long docId = currentTransaction.getDdocDocument();
//                Long eventId = currentSelectedPeriodTrans.getDocEventId();
//                String eventType =   currentSelectedPeriodTrans.getRefEventCategoryType();
//                String ddocStatus = accountEnquiryDelegate.findByDocumentID(docId);
//                if (eventId != null && !(eventType.equals(Constants.EventCategoryTypes.COMP_CHECK_LATEFILE) || eventType.equals(Constants.EventCategoryTypes.COMP_CHECK_NONFILE)
//                                                   || eventType.equals(Constants.EventCategoryTypes.COMP_CHECK_NONPAY) || eventType.equals(Constants.EventCategoryTypes.COMP_CHECK_LATEPAY)|| eventType.equals(Constants.EventCategoryTypes.ACC_DISHONOUR_PAYMENT) || eventType.equals(Constants.EventCategoryTypes.COLL_REVERSE_PAYMENT))) {
//                    if((ddocStatus != null  && ddocStatus.equals(Constants.DocStatus.LODGED)) || Constants.EventCategoryTypes.RET_LODGEMENT.equalsIgnoreCase(eventType)){
//                        FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.GUI_MODE, Constants.Modes.VIEW);
//                        FacesUtil.storeOnProcessScope("docIdFromAccountEnquiryScreen", currentTransaction.getDdocDocument());
//                        FacesUtil.storeOnProcessScope("eventIdFromAccountEnquiryScreen", eventId);
//                        return "FromInquiryToLodgementDoc";
//                    }else if (eventType != null) {
////                             TaxReturnDelegate taxReturnDelegate = new TaxReturnDelegate();
////                             String viewMode = Constants.Modes.VIEW;
////                             if(eventType.equals(Constants.EventCategoryTypes.RET_CANCELLATION)) {
////                                 viewMode = Constants.Modes.CANCEL;
////                             } else if(eventType.equals(Constants.EventCategoryTypes.RET_ADJUST_RETURNS)){
////                                 viewMode = Constants.Modes.ADJUST;
////                             }
////                             taxReturnDelegate.setTaxReturnParamForNavigation(currentTransaction.getDdocDocument(),viewMode, eventId);
////                            
////                            FacesUtil.storeOnProcessScope("requestFromAccountEnquiryScreen","Y");//To disable all fields in account enquiry "view"
//                            return "null";
//                        } else {
//                        	FacesUtil.addFacesInfoMessage("AccountEnquiry.assessmentDetails.ViewNotAvailable");
//                            return null;
//                        
//                        }
//                        
////                    }
//                } else {
//                     FacesUtil.addFacesInfoMessage("AccountEnquiry.assessmentDetails.ViewNotAvailable");
//                    return null;
//                }
//               
//            }   
//            else {
//                FacesUtil.addFacesInfoMessage("AccountEnquiry.assessmentDetails.ViewNotAvailable");
//                return null;
//            }
//                
//        } else {
//            FacesUtil.addFacesInfoMessage("AccountEnquiry.assessmentDetails.ViewNotAvailable");
//            return null;
//        }
//    }
//   
//    public void setDfinRevCollReceiptList(List<DfinRevCollReceipt> dfinRevCollReceiptList) {
//        this.dfinRevCollReceiptList = dfinRevCollReceiptList;
//    }
//
//    public List<DfinRevCollReceipt> getDfinRevCollReceiptList() {
//        return dfinRevCollReceiptList;
//    }
//
//    public void setCurrentSelectedReceiptBean(DfinRevCollInstrument currentSelectedInstrumentBean) {
//        this.currentSelectedInstrumentBean = currentSelectedInstrumentBean;
//    }
//
//    public DfinRevCollInstrument getCurrentSelectedReceiptBean() {
//        return currentSelectedInstrumentBean;
//    }
//     
//       
//    public void setCurrentSelectedPeriodTrans(GenericTransactionPeriodBean currentSelectedPeriodTrans) {
//        this.currentSelectedPeriodTrans = currentSelectedPeriodTrans;
//    }
//
//    public GenericTransactionPeriodBean getCurrentSelectedPeriodTrans() {
//        return currentSelectedPeriodTrans;
//    }
//
//    public void setLegalStatusList(List<SelectItem> legalStatusList) {
//        this.legalStatusList = legalStatusList;
//    }
//
//    public List<SelectItem> getLegalStatusList() {
//        if(legalStatusList == null){
//            legalStatusList = new ArrayList <SelectItem>();
//            legalStatusList = refDelegate.findAllLegalStatus(headerSummaryBean.getLegalStatus());
//        }
//        return legalStatusList;
//    }
//
//    public void setAdhocRevenueList(List<RegimeSummary> adhocRevenueList) {
//        this.adhocRevenueList = adhocRevenueList;
//    }
//
//    public List<RegimeSummary> getAdhocRevenueList() {
//        adhocRevenueList = new ArrayList<RegimeSummary>();
//        for (RegimeSummary regimeSummary: summaryList) {
//            if ((regimeSummary.getModeType() != null && 
//                  regimeSummary.getModeType().equals(Constants.AccountTypes.TRANSACTIONAL)) || 
//                 regimeSummary.getModeType() == null) {
//                adhocRevenueList.add(regimeSummary);
//            }
//        }
//        return adhocRevenueList;
//    }
//
//    public void setTinNumber(String tinNumber) {
//        this.tinNumber = tinNumber;
//    }
//
//    public String getTinNumber() {
//        return tinNumber;
//    }
//
//    public void setEntityName(String entityName) {
//        this.entityName = entityName;
//    }
//
//    public String getEntityName() {
//        return entityName;
//    }
//    
//    class DocEventComparator implements Comparator<DocEventDetails>{
//        public int compare(DocEventDetails event1, DocEventDetails event2) {
//            if(event1 != null && event2 != null && event1.getEventDate() != null && event2.getEventDate() != null) {
//                int result =  event1.getEventDate().before(event2.getEventDate()) ? -1 : event1.getEventDate().after(event2.getEventDate()) ? 1 : 0;
//                return result;
//            }
//            return 0;
//        }
//    }
//    
//    class DocumentComparator implements Comparator<GenericTransactionPeriodBean> {
//
//        public int compare(GenericTransactionPeriodBean doc1, 
//           GenericTransactionPeriodBean doc2) {
//           if(doc1.getSubmissionDate() != null && doc2.getSubmissionDate() != null){
//               return doc1.getSubmissionDate().before(doc2.getSubmissionDate()) ? -1 : 1;
//           }
//           return 0;
//        }
//    }
//
//    private String getDocBalForDisplay(BigDecimal valueToFormat){
//        BigDecimal totalBalance = BigDecimal.ZERO;
//        totalBalance = totalBalance.setScale(2,BigDecimal.ROUND_HALF_UP);
//       
//        String docBalForDisplay =null;
//        String transactionType = null;
//        totalBalance = totalBalance.add(valueToFormat);
//        if (totalBalance.doubleValue()<0){
//            transactionType = "CR";
//        }else
//            transactionType = "";
//        totalBalance = totalBalance.abs();
//        DecimalFormat decimalFormat = getDecimalFormat(FacesUtil.getLocale());
//        decimalFormat.setMaximumFractionDigits(2);
//        decimalFormat.setMinimumFractionDigits(2);
//        decimalFormat.setGroupingUsed(true);   
//        String formatted = decimalFormat.format(totalBalance);
//        docBalForDisplay = formatted+ " "+transactionType;
//               
//        return docBalForDisplay;
//    }
//    //TRGHA-10811
//    private  Comparator<RegimeSummary> RegimeTypeComparator = new Comparator<RegimeSummary>() {
//        private NullComparator delegate = new NullComparator(false); 
//        public int compare(RegimeSummary regimeSummary1, RegimeSummary regimeSummary2) {
//            return delegate.compare(regimeSummary1.getRegimeDescription(),regimeSummary2.getRegimeDescription());
//     }
//    };
//    
//}
