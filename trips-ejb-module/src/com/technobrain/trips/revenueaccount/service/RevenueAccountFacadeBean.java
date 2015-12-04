package com.technobrain.trips.revenueaccount.service;

//import com.crownagents.trips.entity.service.EntityFacadeLocal;
//import com.crownagents.trips.regimeaccountcompliance.message.ComplianceConfigurationInputType;
//import com.crownagents.trips.revenueaccount.messagehelper.ComplianceConfigurationMessageHelper;
//import com.crownagents.trips.transaction.message.TransactionInputType;
import com.technobrain.trips.account.model.Account;
//import com.crownagents.trips.collection.message.BatchPaymentInputType;
//import com.crownagents.trips.collection.message.PaymentInputType;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.document.model.DfinRevCollInstrument;
import com.technobrain.trips.document.model.DfinRevCollReceipt;
import com.technobrain.trips.dto.tax.accounting.GenericRegimePeriodSummaryBean;
import com.technobrain.trips.dto.tax.accounting.GenericTransactionPeriodBean;
import com.technobrain.trips.dto.tax.accounting.RegimeSummary;
import com.technobrain.trips.reference.model.RefDocTypeReturnTypeRel;
import com.technobrain.trips.reference.model.RefRevType;
import com.technobrain.trips.revenueaccount.model.AccChartOfAccounts;
import com.technobrain.trips.revenueaccount.model.AccRevLedAccount;
import com.technobrain.trips.revenueaccount.model.AccRevLedBusSect;
import com.technobrain.trips.revenueaccount.model.AccRevLedDocType;
import com.technobrain.trips.revenueaccount.model.RevComplianceConfiguration;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;


@Stateless(name = "RevenueAccountFacade",mappedName="RevenueAccountFacade")
public class RevenueAccountFacadeBean extends FacadeBean implements RevenueAccountFacadeLocal, RevenueAccountFacadeRemote {
    @PersistenceContext(unitName = "trips-ejb-module")
    private EntityManager em;

//    @EJB
//    EntityFacadeLocal entityFacade;

    
    public RevenueAccountFacadeBean() {
    }

    public List<RegimeSummary> findEntityRegimeSummaryFor(Long entityPrimaryKey) {
        List<RegimeSummary> perioadAccList = null; //TODO - RevAccCleanup
        //TODO - RevAccCleanup
        //            findEntityAccountSummaryByDtype(entityPrimaryKey, 
        //                                            Constants.DType.ENTACC);
        //List<RegimeSummary> custAccList = findEntityAccountSummaryByDtype(entityPrimaryKey, Constants.DType.CUSTACC);
        //List<RegimeSummary> entAccList = findEntityAccountSummaryByDtype(entityPrimaryKey, Constants.DType.ENTACC);

        List<RegimeSummary> regimeSummaryList = new ArrayList<RegimeSummary>();
        regimeSummaryList.addAll(perioadAccList);
        //regimeSummaryList.addAll(custAccList);
        //regimeSummaryList.addAll(entAccList);

        return regimeSummaryList;
    }

    public DfinRevCollReceipt findPaymentReceipt(Long receiptId) {
        DfinRevCollReceipt dfinRevCollReceipt = null;
        try {
            dfinRevCollReceipt = 
                    (DfinRevCollReceipt)em.createQuery("select dr from DfinRevCollReceipt dr where dr.id = ?1").setParameter(1, 
                                                                                                                             receiptId).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return dfinRevCollReceipt;
    }

    public Long findEntityAccountIdByAccountNbr(String acctNo) {
        try {
            return (Long)(em.createQuery("select r.id from RevEntityAcc r where r.taxpayerCode=?1 or r.acctNo = ?1").setParameter(1, 
                                                                                                                                  acctNo).getSingleResult());
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public List findPossibleRevenueAccountIds(Long entityID, String revType) throws NoSuchMethodException {
        List<Long> resultList = 
            em.createQuery("select rte.id from RegTaxpayerEntity rte, " + "RegTaxpayerRevenue rtr where rte.id = rtr.id AND rte.entId = ?1 " + 
                           "AND rtr.revenueType = ?2").setParameter(1, entityID).setParameter(2, 
                                                                                              revType).getResultList();
        return resultList;
    }


    public Long findEntityIdByAccountID(Long accountId) {
        try {
            Long result = 
                (Long)em.createQuery("select ra.entId from RegTaxpayerEntity ra where ra.id=?1").setParameter(1, 
                                                                                                              accountId).getSingleResult();
            return result;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    /**
     * 
     * @param revType
     * @param complianceType
     * @return
     */
    public RevComplianceConfiguration findActionFromComplianceConfiguration(String revType, String complianceType, 
                                                                            String legalStatus, 
                                                                            boolean isToAddLegalStatus) {

        try {
            if (isToAddLegalStatus) {
                return (RevComplianceConfiguration)em.createQuery("select Object(o) from RevComplianceConfiguration o " + 
                                                                  "where o.revenueType = ?1 and o.complianceType = ?2 and o.taxpayerType = ?3").setParameter(1, 
                                                                                                                                                             revType).setParameter(2, 
                                                                                                                                                                                   complianceType).setParameter(3, 
                                                                                                                                                                                                                legalStatus).getSingleResult();
            } else {
                return (RevComplianceConfiguration)em.createQuery("select Object(o) from RevComplianceConfiguration o " + 
                                                                  "where o.revenueType = ?1 and o.complianceType = ?2").setParameter(1, 
                                                                                                                                     revType).setParameter(2, 
                                                                                                                                                           complianceType).getSingleResult();
            }
        } catch (javax.persistence.NoResultException e) {
            return null;
        }

    }

    /**
     * This method returns the ComplianceConfigurationInputType object based on the id provided 
     * with its related child objects. 
     * 
     * @param id
     * @return
     */
//    public ComplianceConfigurationInputType findComplianceConfigurationInputType(Long id) {
//        RevComplianceConfiguration compConf = 
//            (RevComplianceConfiguration)em.createNamedQuery("RevComplianceConfiguration.findComplianceConfigurationById").setParameter(1, 
//                                                                                                                                       id).getSingleResult();
//
//        MessageHelper helper = new ComplianceConfigurationMessageHelper();
//        ComplianceConfigurationInputType compConfInputType = 
//            (ComplianceConfigurationInputType)helper.getData(compConf);
//        return compConfInputType;
//    }

    public boolean checkExistingComplianceConfiguration(String complianceType, String taxpayerType, String revType) {
        try {

            RevComplianceConfiguration compConf = 
                (RevComplianceConfiguration)em.createQuery("select conf from RevComplianceConfiguration conf where conf.complianceType = ?1 and conf.revenueType = ?2 and conf.taxpayerType = ?3").setParameter(1, 
                                                                                                                                                                                                                complianceType).setParameter(2, 
                                                                                                                                                                                                                                             revType).setParameter(3, 
                                                                                                                                                                                                                                                                   taxpayerType).getSingleResult();

            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    /**
     * Determies if the regime selected is periodic
     * @param regime
     * @return
     */
    public boolean isPeriodicRegime(String regime) {
        try {
            RefRevType revRefType = em.find(RefRevType.class, regime);
            if (null == revRefType) {
                return false;
            } else if (Constants.RevenueAcc.REV_PERIODIC.equals(revRefType.getRefRevMode().getCode())) {
                return true;
            }
        } catch (NoResultException e) {
            return false;
        }

        return false;
    }

    public String findRevenueMode(String regime) {
        try {
            RefRevType revRefType = em.find(RefRevType.class, regime);
            if (null == revRefType) {
                return null;
            } else {
                return revRefType.getRefRevMode().getCode();
            }
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean isReceiptNumberAlreadyUsed(String receiptNumber) {
        return !em.createNamedQuery("DfinRevCollReceipt.findAllWithReceiptNumber").setParameter("receiptNumber", 
                                                                                                receiptNumber).getResultList().isEmpty();
    }

//    public void updateReceiptWithEntity(Long entityID, PaymentInputType paymentInputType) {
//
//        DfinRevCollReceipt receipt = em.find(DfinRevCollReceipt.class, paymentInputType.getId());
//        Long acdtId = null; //TODO - RevAccCleanup
//        //TODO - RevAccCleanup
//        //       findAcctIDByEntityID(entityID);
//        receipt.setAccAccount(acdtId);
//        em.merge(receipt);
//    }

    public DfinRevCollReceipt findReceiptIdByTrans(Long transactionId) {
        List<DfinRevCollReceipt> dfinRevCollReceipts = null;
        try {
            dfinRevCollReceipts = 
                    em.createQuery("select di.dfinRevCollReceipt from DfinRevCollInstrument di where di.id in " + 
                                   "(select t.ddocDocument from RevledTransaction t where t.id = ?1)").setParameter(1, 
                                                                                                                    transactionId).getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return dfinRevCollReceipts.isEmpty() ? null : dfinRevCollReceipts.get(0);
    }


//    public boolean isBatchAlreadyUsed(BatchPaymentInputType batchPaymentInputType) {
//        return !em.createNamedQuery("DfinRevCollBatch.findAllWithBatchNumberAndAgent").setParameter("batchNumber", 
//                                                                                                    batchPaymentInputType.getBatchNumber()).setParameter("collectionAgent", 
//                                                                                                                                                         batchPaymentInputType.getCollectionAgent().getAgentCode()).getResultList().isEmpty();
//    }

    public List<DfinRevCollInstrument> findCollInstrumentsdByTdmNumber(String tdmNumber) {
        List<DfinRevCollInstrument> results = new ArrayList<DfinRevCollInstrument>();
        try {
            results = 
                    (List<DfinRevCollInstrument>)em.createQuery("select dr from DfinRevCollInstrument dr where dr.tdmNumber = ?1").setParameter(1, 
                                                                                                                                                tdmNumber).getResultList();
        } catch (NoResultException e) {
            return results;
        }
        return results;
    }

    public Object findRevAccByFormType(Long entityId, String formType) {
        return null;
    }

     public List<GenericRegimePeriodSummaryBean> findPeriodsOnRegimeandEntityId(String regime, Long entityId, String returnType) {
         List<GenericRegimePeriodSummaryBean> results = null;
         try{
                                                                                                             
         results = 
                                 em.createQuery("select new com.technobrain.trips.dto.tax.accounting." + "GenericRegimePeriodSummaryBean(accPeriod.id,accPeriod.periodNo,accPeriod.periodYear,accPeriod.balance) from AccountPeriod accPeriod, RegTaxpayerStatusView r where " +
                                 "accPeriod.accAccountId = r.taxpayerAccountId " + 
                             "and r.revenueType=?1 and r.entEntity.id=?2 and accPeriod.returnType=?3 order by accPeriod.periodYear,accPeriod.periodNo")
                                                 .setParameter(1, regime).setParameter(2,entityId).setParameter(3,returnType).getResultList();
         

         }catch(Exception e){
             
         }
         return results;
     }
     
    public List<GenericRegimePeriodSummaryBean> findActivePeriodsOnRegimeandEntityId(String regime, Long entityId, String returnType) {
        List<GenericRegimePeriodSummaryBean> results = null;
        try{
                                                                                                            
        results = 
                                em.createQuery("select new com.technobrain.trips.dto.tax.accounting." + "GenericRegimePeriodSummaryBean(accPeriod.id,accPeriod.periodNo,accPeriod.periodYear,accPeriod.balance) from AccountPeriod accPeriod, RegTaxpayerStatusView r where " +
                                "accPeriod.accAccountId = r.taxpayerAccountId and accPeriod.status = 'A'" + 
                            "and r.revenueType=?1 and r.entEntity.id=?2 and accPeriod.returnType=?3 order by accPeriod.periodYear,accPeriod.periodNo")
                                                .setParameter(1, regime).setParameter(2,entityId).setParameter(3,returnType).getResultList();
        

        }catch(Exception e){
                
                }
                 return results;
    }
    
    public List<GenericRegimePeriodSummaryBean> findPeriodsOnRegimeandEntityIdUptoCurrentDate(String regime, Long entityId, String returnType) {
        List<GenericRegimePeriodSummaryBean> results = null;
        try{
                                                                                                            
        results = 
                                em.createQuery("select new com.technobrain.trips.dto.tax.accounting." + "GenericRegimePeriodSummaryBean(accPeriod.id,accPeriod.periodNo,accPeriod.periodYear,accPeriod.balance) from AccountPeriod accPeriod, RegTaxpayerStatusView r where " +
                                "accPeriod.accAccountId = r.taxpayerAccountId " + 
                            "and r.revenueType=?1 and r.entEntity.id=?2 and accPeriod.returnType=?3 and accPeriod.periodEndDate < CURRENT_DATE order by accPeriod.periodYear,accPeriod.periodNo")
                                                .setParameter(1, regime).setParameter(2,entityId).setParameter(3,returnType).getResultList();
        

        }catch(Exception e){
            
        }
        return results;
    }

    /**
     * code block needed for Ghana--Start
     */
    public List<GenericRegimePeriodSummaryBean> findRegimePeriodSummaryList(final Long accountId) {
        try {
             List<GenericRegimePeriodSummaryBean> results = 
                  em.createQuery("select new com.technobrain.trips.dto.tax.accounting." + 
                  "GenericRegimePeriodSummaryBean(accPeriod.id,accPeriod.periodNo,accPeriod.periodYear," +
                  "accPeriod.balance,accPeriod.returnType,accPeriod.periodStatus, accPeriod.status," +
                  "accPeriod.periodDueDate,accPeriod.paymentDue,refReturnType.description) from " +
                  "AccountPeriod accPeriod left outer join accPeriod.refReturnType refReturnType " +
                  "where accPeriod.account.id =" + 
                  "?1  order by accPeriod.periodYear desc,accPeriod.periodNo asc")
                                  .setParameter(1, accountId).getResultList();
                  
              List<Long> periodIds = new ArrayList<Long>();            
              for (GenericRegimePeriodSummaryBean summary: results) {
                periodIds.add(summary.getPeriodId())  ;
              }
              
              List<GenericTransactionPeriodBean> periodDataList = loadPeriodTransactions(periodIds);
              List<GenericTransactionPeriodBean> docDataList = loadDocumentTransactions(periodIds);                 
              
              for (GenericRegimePeriodSummaryBean summary: results) {
                  List<GenericTransactionPeriodBean> finalPeriodDataList = new ArrayList<GenericTransactionPeriodBean>();
                 for(GenericTransactionPeriodBean periodData: periodDataList){
                     if(summary.getPeriodId().equals(periodData.getPeriodId())){
                         finalPeriodDataList.add(periodData);
                     }
                 }
                 summary.setPeriodTransactionList(finalPeriodDataList);
                  List<GenericTransactionPeriodBean> finalDocDataList = new ArrayList<GenericTransactionPeriodBean>();
                  for(GenericTransactionPeriodBean docData: docDataList){
                      if(summary.getPeriodId().equals(docData.getPeriodId())){
                          finalDocDataList.add(docData);
                      }
                  }
                  summary.setDocumentDataList(finalDocDataList);
              }                  
              return results;
          } catch (javax.persistence.NoResultException e) {
              log.error(e.getLocalizedMessage(), e);
              return new ArrayList<GenericRegimePeriodSummaryBean>();
          } catch (Exception e) {
              log.error(e.getLocalizedMessage(), e);
              return null;
          }
    }
    
    private List<GenericTransactionPeriodBean> loadPeriodTransactions(List<Long> periodIds){
        String queryStr ="select new com.technobrain.trips.dto.tax.accounting." + "GenericTransactionPeriodBean(accTran.transId," +
        "accTran.transReference,accTran.transDate,accTran.transDescription,accTran.transType,accTran.transAmount," +
        "accTran.transBalance,accTran.chargeType,accTran.ledgerCode,accTran.doctypeDescription,accTran.docId, accTran.docType," +
        "accTran.docStatus,accTran.docReference,accTran.revenueMode,accTran.docEventId,accTran.refEventCategoryType, " +
        "accTran.eventDate,accTran.refEventDescription, accTran.subTaxType, accTran.doctypeDescription,accTran.periodId) " + 
        "from TransactionSummaryView accTran " +
        "where accTran.periodId in (";       
        if (periodIds != null && periodIds.size() > 0) {
            queryStr = queryStr + periodIds.get(0);
            for(int i=1;i<periodIds.size();i++){
                queryStr = queryStr + "," + periodIds.get(i);
            }
            queryStr = queryStr + ") order by accTran.docEventId asc";
            
            Query query = em.createQuery(queryStr); 
            try{
                return query.getResultList();
            }catch (javax.persistence.NoResultException e) {
                return null;
            }
        }
        return null;
    }
    
    private List<GenericTransactionPeriodBean> loadDocumentTransactions(List<Long> periodIds){
        String queryStr ="select new com.technobrain.trips.dto.tax.accounting." + "GenericTransactionPeriodBean(accTran.periodId," +
        "accTran.docType,accTran.docStatus,accTran.docReference,sum(accTran.transBalance),accTran.docId,accTran.submissionDate, " +
        "accTran.doctypeDescription) " +
        "from TransactionSummaryView accTran " +
        "where accTran.periodId in (";
        
        if (periodIds != null && periodIds.size() > 0) {
            queryStr = queryStr + periodIds.get(0);
            for(int i=1;i<periodIds.size();i++){
                queryStr = queryStr + "," + periodIds.get(i);
            }
            queryStr = queryStr + ") group by accTran.periodId, accTran.docType,accTran.docStatus,accTran.docReference," +
            "accTran.docId,accTran.submissionDate,accTran.doctypeDescription  order by accTran.submissionDate desc";
            
            Query query = em.createQuery(queryStr); 
            try{
                return query.getResultList();
            }catch (javax.persistence.NoResultException e) {
                return null;
            }
        }
        return null;
    }

    /** code block needed for Ghana --End*/

//    public TransactionInputType findTransactionInputType(Long id) {
//        return null;
//    }
    
    /**
     * This method is used to load all AccChartOfAccounts from db.
     * @return
     */
    public List<AccChartOfAccounts> findAllAccChartOfAccounts() {
        //return em.createNamedQuery("AccChartOfAccounts.findAll").getResultList();
         List<AccRevLedAccount> accRevLedList =  new ArrayList<AccRevLedAccount>();
         List<AccChartOfAccounts> accList = new ArrayList<AccChartOfAccounts>();
         accList = em.createNamedQuery("AccChartOfAccounts.findAllAccChartOfAccounts").getResultList();
         for(AccChartOfAccounts accAccount : accList) {
             accRevLedList= em.createNamedQuery("AccRevLedAccount.findByChartOfAccountId").setParameter(1, accAccount.getId()).getResultList();
             if(null!=accRevLedList && accRevLedList.size()>0) {
                accAccount.setAccRevLedAccountList(accRevLedList);
                for(AccRevLedAccount accRevLed: accRevLedList) {
                    List<AccRevLedBusSect> accRevLedBusSectList = em.createNamedQuery("AccRevLedBusSect.findByAccRevLedAcc")
                                        .setParameter(1, accRevLed.getId()).getResultList();
                    accRevLed.setAccRevLedBusSectList(accRevLedBusSectList);
                    List<AccRevLedDocType> accRevLedDocTypeList = em.createNamedQuery("AccRevLedDocType.findByAcc")
                                        .setParameter(1, accRevLed.getId()).getResultList();
                    accRevLed.setAccRevLedDocTypeList(accRevLedDocTypeList);
                }
             }
         }
         return accList;
    }
    
    public String removeAccounts(List<AccChartOfAccounts> removalList){
        if (removalList != null){
            // loop through all the accounts and find the one which dont have a parent this is the one which needs saving.
            for (AccChartOfAccounts acc : removalList){
                    // load the object and then remove
                    AccChartOfAccounts obj = em.find(AccChartOfAccounts.class, acc.getId());
                    em.remove(obj);                
            }            
        } 
        return null;
    }
    
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
    

    
    public AccRevLedAccount findLedgerAccountByRevenueType(String revenueType) {
        AccRevLedAccount ledgerAccount = null;
        try {
//            RefDocTypeTaxTypeRel refDocTypeTaxTypeRel = 
//            (RefDocTypeTaxTypeRel)em.createNamedQuery("RefDocTypeTaxTypeRel.findByTaxType")
//                .setParameter(1, revenueType).getSingleResult();
            //if (null != refDocTypeTaxTypeRel) {
                ledgerAccount = 
                        (AccRevLedAccount)em.createNamedQuery("AccRevLedRevenueType.findLedgerAccountByRevenueType")
                            .setParameter(1, revenueType).getSingleResult();
            //} else {
            //    return null;
            //}
            
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
        return ledgerAccount;
    }
    
    public RefDocTypeReturnTypeRel findRefDocTypeRetTypeRelByFormName(String formName) {
        RefDocTypeReturnTypeRel docTaxTypeRel = null;
        try {
            docTaxTypeRel = (RefDocTypeReturnTypeRel)em.createQuery("select docRel from RefDocTypeReturnTypeRel docRel,FlexibleForm ff " +
                           "where docRel.docType = ff.documentType and ff.formName = ?1")
                           .setParameter(1,formName)
                           .getSingleResult();    
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
        return docTaxTypeRel;
    }
    
    public AccRevLedAccount findRevenueLedgerAccount(String accRevLedRevenueType,
                                                        String accRevLedBusSect,
                                                        String accRevLedDocType,
                                                        String accRevLedChargeType,
                                                        String accRevLedTaxpayerType,
                                                        String accRevLedSubTaxCategoryL1,
                                                        String accRevLedSubTaxCategoryL2) {
        //ReadObjectQuery query = new ReadObjectQuery(AccRevLedAccount.class);
        ExpressionBuilder builder = new ExpressionBuilder(); // query.getExpressionBuilder();
        Expression revList, busList, chargeList, taxpayerList, subTaxListL1, subTaxListL2;
        
        Expression criteria = builder.anyOf("accRevLedDocTypeList").get("documentType").equal(accRevLedDocType);
        
        if(accRevLedDocType.equalsIgnoreCase(Constants.DocumentType.PAYMENT) 
            && StringHelper.isNullOrEmptyString(accRevLedChargeType)
            && !StringHelper.isNullOrEmptyString(accRevLedTaxpayerType)) {
            taxpayerList = builder.anyOf("accRevLedTaxpayerTypeList").get("taxpayerType").equal(accRevLedTaxpayerType);
            criteria = criteria.and(taxpayerList);
            chargeList = builder.anyOfAllowingNone("accRevLedChargeTypeList").get("chargeType").isNull();
            criteria = criteria.and(chargeList);
        }
        else {
            if (!StringHelper.isNullOrEmptyString(accRevLedRevenueType)) {
                revList = builder.anyOf("accRevLedRevenueTypeList").get("revenueType").equal(accRevLedRevenueType);
                criteria = criteria.and(revList);
            }
            
            if (!StringHelper.isNullOrEmptyString(accRevLedBusSect)) {
                busList = builder.anyOf("accRevLedBusSectList").get("businessSector").equal(accRevLedBusSect);
                criteria = criteria.and(busList);
            }
            
            if (!StringHelper.isNullOrEmptyString(accRevLedChargeType)) {
                chargeList = builder.anyOf("accRevLedChargeTypeList").get("chargeType").equal(accRevLedChargeType);
                criteria = criteria.and(chargeList);
            }
            
            if (!StringHelper.isNullOrEmptyString(accRevLedTaxpayerType)) {
                taxpayerList = builder.anyOf("accRevLedTaxpayerTypeList").get("taxpayerType").equal(accRevLedTaxpayerType);
                criteria = criteria.and(taxpayerList);
            }
            
            if (!StringHelper.isNullOrEmptyString(accRevLedSubTaxCategoryL1)) {
                subTaxListL1 = builder.anyOf("accRevLedSubTaxCategoryList").get("subTaxCategory").equal(accRevLedSubTaxCategoryL1);
                criteria = criteria.and(subTaxListL1);
            }
            
            if (!StringHelper.isNullOrEmptyString(accRevLedSubTaxCategoryL2)) {
                subTaxListL2= builder.anyOf("accRevLedSubTaxCategoryList").get("subTaxCategory").equal(accRevLedSubTaxCategoryL2);
                criteria = criteria.and(subTaxListL2);
            }
        }            
        
        //query.setSelectionCriteria(criteria);
        //query.prepareForExecution();
//        Session session = ((EntityManager) em.getDelegate()).getActiveSession();
//        
//        Vector accounts = session.readAllObjects(AccRevLedAccount.class, criteria);
//        if (accounts.size()!=1) {
            return null;
//        }
//        else {
//            return (AccRevLedAccount) accounts.get(0);
//        }
        //return (AccRevLedAccount) session.executeQuery(query);
    }
    
    public BigDecimal findAccountBalance(String regimeType, Long entId){
        BigDecimal accBalance = null;
        try{
                Account acc = (Account)em.createQuery("Select a from Account a where a.id in(Select o.taxpayerAccountId from RegTaxpayerStatusView o where o.entEntity.id =?1 and o.revenueType = ?2 )").setParameter(1, entId).setParameter(2, regimeType).getSingleResult();
                
                accBalance = acc.getBalance();
                
        }catch(NoResultException e){
                return null;
        }

        return accBalance;
    }
}
