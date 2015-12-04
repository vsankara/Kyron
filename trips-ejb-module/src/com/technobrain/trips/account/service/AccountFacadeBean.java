package com.technobrain.trips.account.service;

import com.technobrain.trips.account.handler.BasePostingHandler;
import com.technobrain.trips.account.handler.IPostingHandler;
import com.technobrain.trips.account.handler.ManualPenaltyPostingHandler;
import com.technobrain.trips.account.ledger.IRevnueLedgerAccessor;
import com.technobrain.trips.account.ledger.RevLedgerAccessor;
import com.technobrain.trips.account.messagehelper.AccountMessageHelper;
import com.technobrain.trips.account.model.Account;
import com.technobrain.trips.account.model.AccountEnquiryView;
import com.technobrain.trips.account.model.AccountPeriod;
import com.technobrain.trips.account.model.AccountTransaction;
import com.technobrain.trips.account.model.RevenueAccount;
import com.technobrain.trips.account.model.SuspenseAccount;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.document.model.DdocBalananceView;
import com.technobrain.trips.document.model.DdocCharges;
import com.technobrain.trips.document.model.DdocDocument;
import com.technobrain.trips.document.model.DdocTransaction;
import com.technobrain.trips.document.model.DfinManualPenalty;
import com.technobrain.trips.entity.model.EntBusinessSector;
import com.technobrain.trips.entity.model.EntEntity;
import com.technobrain.trips.flexforms.model.FlexibleForm;
import com.technobrain.trips.reference.model.RefDocRevLedCodeParams;
import com.technobrain.trips.reference.model.RefDocTypeReturnTypeRel;
import com.technobrain.trips.reference.model.RefReturnType;
import com.technobrain.trips.reference.model.RefRevType;
import com.technobrain.trips.revenueaccount.model.AccRevLedAccount;
import com.technobrain.trips.revenueaccount.service.RevenueAccountFacadeLocal;
import com.technobrain.trips.transaction.service.TransactionFacadeLocal;
import com.technobrain.trips.core.message.EntityAccountType;
import com.technobrain.trips.core.message.OutputType;
import com.technobrain.trips.core.message.RegimeAccountType;
import com.technobrain.trips.core.message.ReturnsInputType;
import com.technobrain.trips.entityandregimeaccounting.message.AccountType;
import com.technobrain.trips.entityandregimeaccounting.message.PeriodType;
import com.technobrain.trips.entityandregimeaccounting.message.RevenueAccountType;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Crown Agents 2012
 *
 * AccountFacadeBean
 *
 * @since       Date: 01/01/2012 11:29:15 AM
 * @author      Author: Hilal Celep
 *
 */
@Stateless(name = "AccountFacadeBean",mappedName="AccountFacade")
public class AccountFacadeBean extends FacadeBean implements AccountFacadeRemote, 
                                                             AccountFacadeLocal {
    @PersistenceContext(unitName = "trips-ejb-module")
    private EntityManager em;
    
    @EJB
    TransactionFacadeLocal transactionFacade;
    
    @EJB
    RevenueAccountFacadeLocal revenueAccFacade;
    
    public List<AccountEnquiryView> findAccountEnquiryByTinNumber(String tinNumber) {
        List<AccountEnquiryView> listOfAccounts = 
            em.createNamedQuery("AccountEnquiryView.findAccountEnquiryByTinNumber").setParameter(1, 
                                                                                                 tinNumber).getResultList();
        return listOfAccounts;
    }
    
        /**
     * This method defines to fetch periodType based on EntityAccountType
     * @param eat
     * @return PeriodType
     */
    public PeriodType getPeriodType(EntityAccountType eat) {
        PeriodType pt = new PeriodType();
        if (eat != null) {
            pt.setRevenueType(Constants.Regimes.TAXPAYER);
            pt.setRevenueReturnType(Constants.Regimes.TAXPAYER);
            pt.setRegistrationDate(eat.getEDR());
            pt.setRegimeAccountId(eat.getId());
            pt.setFilingFrequency(Constants.PeriodCycleFrequency.INDEFINITE);
            pt.setCreatedBy(eat.getCreatedBy());
            pt.setUpdatedBy(eat.getUpdatedBy());
        }
        return pt;
    }
    
        public void autoGeneratePeriod(List<PeriodType> periodTypes) throws Exception{
            System.out.println(" **** Auto Generate Periods ***** ");
        
//        boolean isHoidaysForThisReturnTaxCycle= calendarManagementFacade.isMinimumNumberOfHolidaysConfiguredForNextTwoTaxcyclesPeriod();
//                      
//        if(isHoidaysForThisReturnTaxCycle){     
//            for(PeriodType  periodType: periodTypes  ){
//                if(!checkForAdhoc(periodType)){
//                   generatePeriod(periodType, true);
//                }
//            }
//        }else{
//            taskServiceFacade.createAdminNotificationForBusinessHolidays();
//        }
                                        
    }
    
        public List<PeriodType> getPeriodTypes(RegimeAccountType regimeAccountType) {
        
         List<PeriodType> periodTypes = new ArrayList<PeriodType>();
             
         if (regimeAccountType != null) {
            List<ReturnsInputType> revenueTypes = null;
             revenueTypes = regimeAccountType.getReturnTypes();
            for(int i=0;i<revenueTypes.size();i++){
                PeriodType periodType = new PeriodType(); 
                periodType.setRevenueType(regimeAccountType.getRevenueType());
                periodType.setRevenueReturnType(revenueTypes.get(i).getReturnTypeCode());
                periodType.setRegistrationDate(regimeAccountType.getEDR());
                periodType.setRegimeAccountId(regimeAccountType.getRevenueAccountID());
                periodType.setCreatedBy(regimeAccountType.getCreatedBy());
                periodType.setUpdatedBy(regimeAccountType.getUpdatedBy());
                
                RefRevType refRevType = (RefRevType)queryFindByCode(RefRevType.class, regimeAccountType.getRevenueType());
//                CfgGenPeriodConfig cfgMatrix = null;
//                try {
//                    cfgMatrix =  findPeriodGenerationConfig(regimeAccountType.getRevenueType(),  revenueTypes[i].getReturnTypeCode());
//                } catch (Exception ex) {
//                    log.error(ex.getLocalizedMessage(), ex);
//                }                                           
                 
//                 if(cfgMatrix!=null){                               
//                    periodType.setFilingFrequency(cfgMatrix.getRefCfgCycleFrequency());
//    
//                    if (refRevType.getFiscalIndicator().equalsIgnoreCase(Constants.TRUE)) {
//                        EntOrganization entOrg = (EntOrganization)queryFindById(EntOrganization.class, regimeAccountType.getOwnerId());
//                        int acctYearEndMonth =0;
//                        int acctYearEndDay = 0;
//                        if (entOrg != null && entOrg.getAccountYearEndMonth() != null) {
//                            acctYearEndMonth = Integer.valueOf(entOrg.getAccountYearEndMonth());
//                            periodType.setAccountEndMonth(acctYearEndMonth - 1);
//                        }else{
//                            periodType.setAccountEndMonth(cfgMatrix.getCycleEndMonth()-1);
//                        }
//                        
//                        if (entOrg != null && entOrg.getAccountYearEndDay() != null) {
//                            acctYearEndDay = Integer.valueOf(entOrg.getAccountYearEndDay());
//                            periodType.setAccountEndDay(acctYearEndDay);
//                        }else{
//                            periodType.setAccountEndDay(cfgMatrix.getCycleEndDay());
//                        }
//                       
//                        if (entOrg != null && entOrg.getAccountYearEndMonth() != null && entOrg.getAccountYearEndDay() != null){
//                            periodType.setFiscalIndicator(true);
//                        }
//                    }
//                    else{
//                        periodType.setAccountEndMonth(cfgMatrix.getCycleEndMonth()-1);
//                        periodType.setAccountEndDay(cfgMatrix.getCycleEndDay());
//                    }
//                    
//                    periodTypes.add(periodType);
//                 }
            }
                
         }
         
         return periodTypes;
     }
    
        /**
     * 
     * @param accountType
     * @return OutputType
     */
    public OutputType persistAccount(AccountType accountType) {
        if (accountType instanceof RevenueAccountType) {
            return new AccountMessageHelper().getOutputTypeData(saveOrUpdate(accountType, 
                                                                             RevenueAccount.class, 
                                                                             AccountMessageHelper.class));
        } else {
            return new AccountMessageHelper().getOutputTypeData(saveOrUpdate(accountType, 
                                                                             SuspenseAccount.class, 
                                                                             AccountMessageHelper.class));
        }
    }
    
    private BasePostingHandler getHandlerForDocumentType(DdocDocument document) {
        if (document != null && document.getDocType() != null) {
            if (document.getDocType().equals(Constants.DocumentType.MANUAL_PENALTY)) {
                return new ManualPenaltyPostingHandler((DfinManualPenalty)document);
            }
        }
        return null;
    }
    
    public List<DdocCharges> getLatestDocChargesByDocumentId(DdocDocument ddoc){
        List<DdocCharges> ddocCharges = null;
       try{
           Query query =  em.createNamedQuery("DdocCharges.findLatestByDocumentId");
           query.setParameter(1, ddoc.getId());
           query.setParameter(2, ddoc.getAssociatedEvent());
           System.out.println(" ******* Doc Id "+ddoc.getId());
           System.out.println(" ******* Associatd Event Id "+ddoc.getAssociatedEvent());
           ddocCharges = query.getResultList();
           return ddocCharges;
       }catch (javax.persistence.NoResultException e) {
             return null;
         }
        
    }
    
    private void setFlexFormInfoOnHandler(DdocDocument ddoc, 
                                          IPostingHandler postingHandler) {
        if(ddoc != null && ddoc.getId() != null){
//            // The below condition is to handle the WIT Return CREDIT postings for individual taxpayers
//            if(ddoc.getDocType()!=null && ddoc.getDocType().equalsIgnoreCase(Constants.DocumentType.WITHHOLDING_TAXRETURN)){
//                // get the flexibleform definition
//                //FlexibleForm flexFormConfig = (FlexibleForm)queryFindById(FlexibleForm.class,  ddoc.getFlexiForm());
//                FlexibleForm flexFormConfig = (FlexibleForm)formGenerationFacade.getFlexibleFormByName(ddoc.getFlexiFormName());
//                postingHandler.setFlexFormConfig(flexFormConfig);
//                processWITReturnPosting(ddoc,postingHandler,flexFormConfig);
//            }
            
//            // The below condition is to handle the PAYE Return CREDIT postings for individual taxpayers
//            if(ddoc.getDocType()!=null && ddoc.getDocType().equalsIgnoreCase(Constants.DocumentType.PAYERETURN_ANNUAL)){
//                // get the flexibleform definition
//                //FlexibleForm flexFormConfig = (FlexibleForm)queryFindById(FlexibleForm.class,  ddoc.getFlexiForm());
//                FlexibleForm flexFormConfig = (FlexibleForm)formGenerationFacade.getFlexibleFormByName(ddoc.getFlexiFormName());
//                postingHandler.setFlexFormConfig(flexFormConfig);
//                processPAYEAnnualReturnPosting(ddoc,postingHandler,flexFormConfig);
//            }
            
            List<DdocCharges> ddocCharges = getLatestDocChargesByDocumentId(ddoc);
            postingHandler.setAssociatedDocCharges(ddocCharges);
        }
    }
    
    private void setAssociatedDocChargeOnHandler(DdocDocument ddoc, 
                                          IPostingHandler postingHandler) {
        if(ddoc != null){          
            List<DdocCharges> ddocCharges = getLatestDocChargesByDocumentId(ddoc);
            postingHandler.setAssociatedDocCharges(ddocCharges);
        }
    }
    
    /**
     * Will generate Adhoc period
     * @param dDoc
     * @return periodId
     */
    public long createAdhocPeriod(DdocDocument dDoc) {        
        AccountPeriod accountPeriod = new AccountPeriod();
        
        accountPeriod.setPeriodStatus(Constants.PeriodStatuses.CREATED);
        if(dDoc.getSubmissionDate() != null ){
            Calendar subDateCal = DateHelper.getCalendar(dDoc.getSubmissionDate());
            accountPeriod.setPeriodNo(subDateCal.get(Calendar.MONTH)+1);
            accountPeriod.setPeriodYear(subDateCal.get(Calendar.YEAR));
            Timestamp subDateTimestamp = DateHelper.getSqlTimestampWithoutTime(subDateCal);
            accountPeriod.setPeriodStartDate(subDateTimestamp);
            accountPeriod.setPeriodEndDate(subDateTimestamp);
        }else{
            Calendar currentDateCal = Calendar.getInstance();
            accountPeriod.setPeriodNo(currentDateCal.get(Calendar.MONTH)+1);
            accountPeriod.setPeriodYear(currentDateCal.get(Calendar.YEAR));
            Timestamp currentDateTimestamp = DateHelper.getSqlTimestampWithoutTime(currentDateCal);
            accountPeriod.setPeriodStartDate(currentDateTimestamp);
            accountPeriod.setPeriodEndDate(currentDateTimestamp);   
        }        
        accountPeriod.setBalance(new BigDecimal("0.0"));
        accountPeriod.setAccAccountId(dDoc.getAccAccount()); 
        accountPeriod.setReturnDocument(dDoc.getDocType());
        // Set return type for adhoc period
        if (dDoc.getDocType() != null) {
                Query query = em.createNamedQuery("RefDocTypeReturnTypeRel.findByDocType").setParameter(1, dDoc.getDocType());
                List resultList = query.getResultList();
                if(resultList != null && resultList.size() > 0) {
                   RefDocTypeReturnTypeRel refDocTypeReturnType = (RefDocTypeReturnTypeRel)resultList.get(0);
                   accountPeriod.setReturnType(refDocTypeReturnType.getReturnType());
               }
        }

        em.persist(accountPeriod);
        return accountPeriod.getId();
    }
    
//    private Boolean shouldGenerateAdhocPeriod(DdocDocument doc ){
//        if (doc != null && doc.getAccAccount() != null && doc.getAccAccount() != 0) {
//                 RevenueAccount revAcc =  findRevenueAccountById(doc.getAccAccount());
//                 if (revAcc != null && revAcc.getRevenueType() != null) {
//                     RefRevType refRevType = (RefRevType)queryFindByCode(RefRevType.class,revAcc.getRevenueType());
//                     if (refRevType != null && refRevType.getRefRevMode() != null && 
//                         refRevType.getRefRevMode().getCode() != null && 
//                         Constants.RevenueAcc.REV_TRANSACTION.equalsIgnoreCase(refRevType.getRefRevMode().getCode())) {
//                         return Boolean.TRUE;
//                     } else {
//                         if(Constants.RevenueAcc.REV_TRANSACTION.equalsIgnoreCase(referenceFacade.getRefRevModeByDocType(doc.getDocType()))){
//                             return Boolean.TRUE;
//                         }
//                         else return Boolean.FALSE;
//                     }
//                 } else {
//                     return Boolean.FALSE;
//                 }
//             } else {
//                 return Boolean.FALSE;
//             }
//    }
    
        public AccRevLedAccount findLedgerAccountByCode(String accountCode) {
        AccRevLedAccount ledgerAccount = null;
        try {
                ledgerAccount = 
                        (AccRevLedAccount)em.createNamedQuery("AccRevLedAccount.findLedgerAccountByCode")
                            .setParameter(1, accountCode).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
        return ledgerAccount;
    }
        
    /**
     * This method for to post the tansaction along with Document
     * @param accTran
     * @param docId
     * @param eventId
     * @param chargeId
     * @return AccountTransaction
     */
    public AccountTransaction postTransactionAndLinkWithDocument(AccountTransaction accTran, 
                                                                 Long docId, 
                                                                 Long eventId, 
                                                                 Long chargeId, boolean ignoreSuspense, boolean isInstalment) {
        AccountTransaction acctTran = 
            transactionFacade.postTransaction(accTran, ignoreSuspense);
        transactionFacade.createDocumentTransactionLink(docId, eventId, 
                                                        acctTran.getId(), 
                                                        chargeId);
        if(isInstalment)                                                        {
            transactionFacade.createInstalmentTransactionLink(docId, acctTran.getId(), 
                                                            accTran.getInstalmentId());    
        }
        
        return acctTran;
    }
    
        private void postListOfTransactions( DdocDocument ddoc, IPostingHandler postingHandler, List<AccountTransaction> sourceTranList) {
        AccRevLedAccount ledgerAccount;
        if (sourceTranList != null) {
            for (AccountTransaction sourceTran: sourceTranList) {
                ledgerAccount = findLedgerAccountByCode(postingHandler.getRevenueLedgerCode());
                if(ledgerAccount!=null){
                    sourceTran.setAccRevLedId(ledgerAccount.getId());  
                }
                
                postTransactionAndLinkWithDocument(sourceTran, ddoc.getId(), 
                                                   sourceTran.getEventId(), sourceTran.getChargeId(), postingHandler.isIgnoreSuspense(), false);
            }
        }
    }
        
    private boolean isReturnDocument(DdocDocument ddoc){{
        RefDocTypeReturnTypeRel refrel = null;
        String docType = ddoc.getDocType();
        if(docType != null && docType.trim().length() > 0){
            //refrel = em.find(RefDocTypeReturnTypeRel.class, ddoc.getDocType());
            Query query = em.createNamedQuery("RefDocTypeReturnTypeRel.findByDocType").setParameter(1, docType);
            List<RefDocTypeReturnTypeRel> result = query.getResultList();
            if(result != null && result.size() > 0){
                refrel = result.get(0);
            }
        }
        return refrel == null ? false : true;
    }
    }
    
    /**
     * This method will act as the main method to post to accounts, all the services should call this method.
     * @param ddoc
     */
    public void postToAccounts(DdocDocument ddoc) throws Exception {
        // after basic checks load the handler for the input type
        
        System.out.println(" ********* Entering POSTING ********* ");

        IPostingHandler postingHandler = getHandlerForDocumentType(ddoc);
         System.out.println(" ********* Got Handler ********* ");
        boolean isAdhoc = false;
        if (postingHandler == null) {
            // something is wrong .. in practice this will never happen if the handler is present
            // TODO LM - log as error and return - done VP
            throw new Exception("No posting handler defined for document type " + 
                                ddoc.getDocType() + 
                                ", Cannot Post to Accounts.");
        }
        String defautRevLedCode = "1450011";
        Long revLedCode = 373l;
//        if(defautRevLedCode != null){
//            Query query = em.createNamedQuery("AccRevLedAccount.findLedgerAccountByCode");
//            query.setParameter(1, defautRevLedCode);
//            if(query.getResultList() != null && query.getResultList().size() > 0){
//                revLedCode = ((AccRevLedAccount)query.getResultList().get(0)).getId();
//            }
//        }
        //set Up Posting Handler
        postingHandler.setDefaultRevLedCode(revLedCode);
        IRevnueLedgerAccessor revLedgerAccessor = new RevLedgerAccessor(revenueAccFacade);
        postingHandler.setLedgerAccessor(revLedgerAccessor);
        
        if(postingHandler.isFlexibleFormUsed()){
           setFlexFormInfoOnHandler(ddoc,postingHandler);
            if (ddoc.getDocType() != null) {
                Query query = 
                    em.createNamedQuery("RefDocTypeReturnTypeRel.findByDocType").setParameter(1, ddoc.getDocType());
                    List resultList = query.getResultList();
                   if(resultList != null && resultList.size() > 0) {
                       RefDocTypeReturnTypeRel refDocTypeReturnType = (RefDocTypeReturnTypeRel)resultList.get(0);
                       RefReturnType refReturnType = em.find(RefReturnType.class, refDocTypeReturnType.getReturnType());
                       postingHandler.setRefReturnType(refReturnType);
                       RefDocRevLedCodeParams refDocRevLedParams = em.find(RefDocRevLedCodeParams.class, ddoc.getDocType());
                       postingHandler.setRefDocRevLedCodeParams(refDocRevLedParams);
                   }
            }
        }
        
        if(postingHandler.isDocChargeUsed()){
           setAssociatedDocChargeOnHandler(ddoc,postingHandler);            
        }
        
        //set RefdocRelType some documents might not have attached???
        //TODO Code given by Vijay Dabas
        if (ddoc.getDocType() != null) {
           Query query =
                em.createNamedQuery("RefDocTypeReturnTypeRel.findByDocType").setParameter(1, ddoc.getDocType());
                List resultList = query.getResultList();
           if(resultList != null && resultList.size() > 0) {
               RefDocTypeReturnTypeRel refDocTypeReturnType = (RefDocTypeReturnTypeRel)resultList.get(0);
               RefReturnType refReturnType = em.find(RefReturnType.class, refDocTypeReturnType.getReturnType());
               postingHandler.setRefReturnType(refReturnType);
               RefDocRevLedCodeParams refDocRevLedParams = em.find(RefDocRevLedCodeParams.class, ddoc.getDocType());
               postingHandler.setRefDocRevLedCodeParams(refDocRevLedParams);
           }
        }

        //entEntity.get
        
        //Check if posting is required (in case amendment and no change it should not be posted)
        if (!postingHandler.isPostingRequired()) {
            return;
        }
        //check if the period should be generated for the tax type
//        if (postingHandler.isPeriodGenerationRequired() && (ddoc.getAccPeriod()==null && shouldGenerateAdhocPeriod(ddoc))) {
//                Long periodId = createAdhocPeriod(ddoc);
//                ddoc.setAccPeriod(periodId);
//                isAdhoc = true;
//        }
        //determine the ISICCode 
        if(ddoc.getAccAccount() != null) {
            Account account =  em.find(Account.class, ddoc.getAccAccount());
            Long entityId = account.getEntId();
            EntEntity entEntity = em.find(EntEntity.class, entityId);
            postingHandler.setEntity(entEntity);
            if(entEntity != null && entEntity.getEntBusinessSectorList() != null) {
                for(EntBusinessSector businessSector : entEntity.getEntBusinessSectorList()){
                    if(businessSector != null && businessSector.getPrimaryIndicator().equalsIgnoreCase("T")){
                        String divisionCode = businessSector.getBusinessSector();
                        if(divisionCode != null && (divisionCode.trim().length() == 4)){
                            divisionCode = divisionCode.trim().substring(0,2);
                        }
                        postingHandler.setPrimaryBusinessSectorCode(divisionCode);
                        break;
                        
                    }
                }
            }
        }
        //check if revenueAccount is available 
        //TODO LM load revenue account if not available
        //post the transaction
        // check if the transaction should be posted
        List<AccountTransaction> sourceTranList = null;
        List<AccountTransaction> creditTargetTranList = null;
        AccRevLedAccount ledgerAccount = null;
        if (postingHandler.isSourceTransactionPostingRequired()) {
            //TODO check if all the parameters required for posting transaction are available else load
            sourceTranList = postingHandler.prepareSourceAccountTransaction();
            //creditTargetTranList=sourceTranList;
            postListOfTransactions(ddoc, postingHandler, sourceTranList);
        } else {
            //though posting not required but might still needs allocations.
            if(isReturnDocument(ddoc)) {
                sourceTranList = postingHandler.prepareSourceAccountTransaction();
            }
        }
        
        
        //check if allocation is required
        if (postingHandler.isTransactionAllocationRequired()) {
            // get source and target transactions 
            // if the transaction was posted above then it will be the source transaction
            if (sourceTranList == null && 
                postingHandler.getSourceTransactionIdentifier() != null) {
                if (postingHandler.getSourceTransactionIdentifier().equalsIgnoreCase(postingHandler.TRANSACTION_ID)) {
                    List<Long> sourceTranIds = 
                        postingHandler.getSourceTransactionIds();
                    sourceTranList = 
                            transactionFacade.findAccountTransactionsByIds(sourceTranIds);
                } else if (postingHandler.getSourceTransactionIdentifier().equalsIgnoreCase(postingHandler.TRANSACTION_OBJECT)) {
                    sourceTranList = postingHandler.getSourceTransactions();
                } else {
                        
                }
            } else if(sourceTranList == null){
                // For returns when we have just the liabilities to be posted.
                 List<AccountTransaction> targetOnlyTransactionList = null;
                 targetOnlyTransactionList = postingHandler.prepareTargetAccountTransaction();
                 creditTargetTranList = targetOnlyTransactionList;
                 postListOfTransactions(ddoc, postingHandler, targetOnlyTransactionList);
            }
            if (sourceTranList != null) {
                for (AccountTransaction sourceTran: sourceTranList) {
    
                    List<AccountTransaction> targetTransationList = null;
                    
                    if (postingHandler.isTargetTransactionPostingRequired()) {
                        postingHandler.setCurrentSourceTransaction(sourceTran);
                        
                        ArrayList<AccountTransaction> preparedTargetList  = 
                                 (ArrayList<AccountTransaction>)postingHandler.prepareTargetAccountTransaction();
                             // save this list and get the proper objects
                        targetTransationList = new ArrayList<AccountTransaction>();
    
                        if(preparedTargetList!=null && preparedTargetList.size()>0 && !postingHandler.isTargetTransactionPostingCompleted()){
                            for (AccountTransaction targetTran: preparedTargetList) {
                                AccountTransaction postedTransaction = postTransactionAndLinkWithDocument(targetTran, ddoc.getId(), 
                                                                                                     targetTran.getEventId(), targetTran.getChargeId(), postingHandler.isIgnoreSuspense(), false);
                                if(postingHandler.requiresAllocation(targetTran)) {                                                                                               
                                  targetTransationList.add(postedTransaction);
                                }
                            }
    //                            List<AccountTransaction> postedList  = getOtherPostedTransactionForActiveCharges(ddoc);
    //                            if (postedList != null) {
    //                                targetTransationList.addAll(postedList);
    //                            }
                        }
                        em.flush();
                        if(isReturnDocument(ddoc)){
                            // The below flag is set to true so that when multiple source transactions are available to be allocated, 
                            // the target transactions are not posted everytime.
                            postingHandler.setTargetTransactionPostingCompleted(true);
                            
                            creditTargetTranList =  postingHandler.prepareTargetAccountTransaction();
                            //transactions posted so let allocations rule determine this.
                            targetTransationList = null;
                        }
                    }
                    
                    if (postingHandler.getTargetTransactionIdentifier() != null) {
                        if (postingHandler.getTargetTransactionIdentifier().equalsIgnoreCase(postingHandler.TRANSACTION_ID)) {
                            List<Long> targetTranIds = 
                                postingHandler.getTargetTransactionIds();
                            if (targetTranIds != null && targetTranIds.size() > 0) {
                                // Process Adhoc Posting (e.g. VEH-IT, ST-D, TAX-ST) and add DR transaction to be used for allocation 
                                if(targetTransationList !=null && ddoc.getDocType().equals(Constants.DocumentType.PAYMENT)){
                                    targetTransationList.addAll(transactionFacade.findAccountTransactionsByIds(targetTranIds));
                                } else {
                                    targetTransationList = 
                                        transactionFacade.findAccountTransactionsByIds(targetTranIds);
                                }
                            }
                        }else if (postingHandler.getTargetTransactionIdentifier().equalsIgnoreCase(postingHandler.TRANSACTION_REFERENCE)) {
                            List<String> targetTranRefs = 
                                postingHandler.getTargetTransactionReferences();
                            targetTransationList = 
                                    transactionFacade.findAccountTransactionsByReferences(targetTranRefs);
                        }else if (postingHandler.getTargetTransactionIdentifier().equalsIgnoreCase(postingHandler.TRANSACTION_OBJECT)) {
                            targetTransationList = 
                                    postingHandler.getTargetTransactions();
                        } else if (postingHandler.getTargetTransactionIdentifier().equalsIgnoreCase(postingHandler.DOCUMENT_ID)) {
                            List<Long> targetDocumentIds  = 
                                    postingHandler.getTargetDocumentIds();
                            targetTransationList = 
                                    transactionFacade.findTransactionsByDocument(targetDocumentIds,sourceTran.getAccAccount(),sourceTran.getAccountPeriod());
                        } else {
                            //do nothing, this case can happen but taken care in the next if condition
                        }
                        // It is assumed that the module responsible to supply targetTransactionList above, already takes care of 
                        // Allocation rules before returning the list                 
                    } else if (postingHandler.getTargetTransactionIdentifier() == null) {
                             // get transaction payload from the handler
                    }
    
                    if (sourceTran != null && (targetTransationList == null || targetTransationList.size() == 0) ) {
                        if (postingHandler.shouldApplyAllocationRule() || isReturnDocument(ddoc)) {
                            Long periodId = null;
                            if(postingHandler.isPaymentOnPeriod()){
                                periodId = sourceTran.getAccountPeriod();
                            }
                            if(isReturnDocument(ddoc)) {
                                AccountPeriod period =  em.find(AccountPeriod.class,ddoc.getAccPeriod());
                                periodId = period.getId();
                            }
                            if (targetTransationList != null) {
                                targetTransationList.addAll(transactionFacade.applyAllocationRule(ddoc.getAccAccount(),
                                                                                                  periodId,
                                                                                                  sourceTran.getTransactionType()));
                            } else {
                                targetTransationList = 
                                        transactionFacade.applyAllocationRule(ddoc.getAccAccount(), 
                                                                              periodId,
                                                                              sourceTran.getTransactionType());
                            }
                        } else {
                            if (ddoc.getDocType() != null && 
                                ddoc.getDocType().equalsIgnoreCase(Constants.DocumentType.WITHHOLDING_TAXRETURN)) {
                                targetTransationList = 
                                        transactionFacade.getAllOffsetTransactionsByAccountAndType(sourceTran.getAccAccount(), 
                                                                                                   sourceTran.getTransactionType(), 
                                                                                                   postingHandler.getChargeType(),null);
                            } else {
                                if (ddoc.getDocType().equalsIgnoreCase(Constants.DocumentType.REFUND_CLAIM)) {
                                    if (!isAdhoc) {
                                        targetTransationList = 
                                                transactionFacade.getAllOffsetTransactionsByAccountAndType(ddoc.getAccAccount(), 
                                                                                                           sourceTran.getTransactionType(), 
                                                                                                           postingHandler.getChargeType(), 
                                                                                                           ddoc.getAccPeriod());
                                    } else {
                                        targetTransationList = 
                                                transactionFacade.getAllOffsetTransactionsByAccountAndType(ddoc.getAccAccount(), 
                                                                                                           sourceTran.getTransactionType(), 
                                                                                                           postingHandler.getChargeType(), 
                                                                                                           null);
                                    }
    
    
                                }else  if (ddoc.getDocType().equalsIgnoreCase(Constants.DocumentType.OFFICER_ASSESSMENT)) {
                                    if (!isAdhoc) {
                                        targetTransationList = 
                                                transactionFacade.getAllOffsetTransactionsByAccountAndType(ddoc.getAccAccount(), 
                                                                                                           sourceTran.getTransactionType(), 
                                                                                                           postingHandler.getChargeType(), 
                                                                                                           ddoc.getAccPeriod());
                                    } else {
                                        targetTransationList = 
                                                transactionFacade.getAllOffsetTransactionsByAccountAndType(ddoc.getAccAccount(), 
                                                                                                           sourceTran.getTransactionType(), 
                                                                                                           postingHandler.getChargeType(), 
                                                                                                           null);
                                    }
                                }else {
                                    targetTransationList = 
                                            transactionFacade.getAllOffsetTransactionsByAccountAndType(ddoc.getAccAccount(), 
                                                                                                       sourceTran.getTransactionType(), 
                                                                                                       postingHandler.getChargeType(), 
                                                                                                       null);
                                }
    
                            }
                        }
                     }
    
                    if (targetTransationList != null && 
                        targetTransationList.size() > 0) {
                        // at this point we have the target transactions, filter based on source amount
                        targetTransationList = 
                                transactionFacade.filterTargetTranByAllocationAmount(targetTransationList, 
                                                                                     sourceTran.getAmount());
                        if (sourceTran.getTargetAllocationList() == null || sourceTran.getTargetAllocationList().size() ==0) {
                            transactionFacade.transactionAllocations(sourceTran, 
                                                                 targetTransationList, postingHandler.getAmountAllocated(), postingHandler.isIgnoreSuspense());
                        } else {
                            transactionFacade.transactionAllocations(sourceTran, sourceTran.getTargetAllocationList(), postingHandler.isIgnoreSuspense());
                        }
                        
                        DdocDocument liabilityDoc = null;
                        Long liabilityDocId = null;
                        
                        if(targetTransationList!=null && targetTransationList.size()>0){
                            for(AccountTransaction accTrans : targetTransationList){
                                if( (accTrans!=null && accTrans.getChargeType()!=null) && (accTrans.getChargeType().equals("LIABILITY") || accTrans.getChargeType().equals("PENALTY")) ) {
                                    Query query = 
                                        em.createNamedQuery("DdocTransaction.findByTransactionId").setParameter(1, 
                                                                                                  accTrans.getId());
                                    List<DdocTransaction> dDocTrans = query.getResultList();
                                    if(dDocTrans!=null && dDocTrans.size()>0){
                                        DdocTransaction dDocTr = dDocTrans.get(0);
                                        if(liabilityDocId == null || (liabilityDocId != null && liabilityDocId.compareTo(dDocTr.getDocumentId())!=0)){
                                            liabilityDocId = dDocTr.getDocumentId();
                                            Query query1 = 
                                                em.createNamedQuery("DdocBalananceView.findByDocId").setParameter(1, 
                                                                                                          liabilityDocId);
                                            List<DdocBalananceView> dDocBalList = query1.getResultList();                                                                                                          
                                            
                                            if(dDocBalList != null && dDocBalList.size()>0) {
                                                DdocBalananceView ddocBalananceView  = dDocBalList.get(0);
                                                log.debug("TEST-DATA :"+ddocBalananceView.getTransactionBalance());
                                                BigDecimal balanceAmt = ddocBalananceView.getTransactionBalance();
                                                AccountPeriod accP = null;
                                                try{
                                                accP = 
                                                    (AccountPeriod)em.createNamedQuery("AccountPeriod.findById").setParameter(1, ddocBalananceView.getPeriod()).getSingleResult();
                                                }catch(NoResultException ne){
                                                    
                                                }
                                                if(balanceAmt.compareTo(BigDecimal.ZERO) > 0 ){
                                                    
                                                    accP.setPeriodStatus(Constants.PeriodStatuses.PARTIALLY_PAID);
                                                    em.merge(accP);
                                                }else if(balanceAmt.compareTo(BigDecimal.ZERO) == 0 || balanceAmt.compareTo(BigDecimal.ZERO) < 0) {
                                                    accP.setPeriodStatus(Constants.PeriodStatuses.PAID);
                                                    em.merge(accP);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                    
                    
                }
            }     
        }
        
         
        
         if(postingHandler.isMultiplePostingRequired()){
             sourceTranList = postingHandler.getAdditionalTransactions();;
             for (AccountTransaction sourceTran: sourceTranList) {
                 ledgerAccount = findLedgerAccountByCode(postingHandler.getRevenueLedgerCode());
                 if(ledgerAccount!=null){
                     sourceTran.setAccRevLedId(ledgerAccount.getId());  
                 }
                 postTransactionAndLinkWithDocument(sourceTran, ddoc.getId(), 
                                                    sourceTran.getEventId(), sourceTran.getChargeId(), postingHandler.isIgnoreSuspense(), postingHandler.isMultiplePostingRequired());
             }
         }

        
        // TODO - Credit postings to balance monthly amounts for annual lodgements
        //postMonthlyAmountsForAnnual(ddoc, postingHandler, creditTargetTranList, false, null); //TODO rename this method, it could be quartly as well not just monthly
     }
    
    
    
    
    
    
   
    
   
}
