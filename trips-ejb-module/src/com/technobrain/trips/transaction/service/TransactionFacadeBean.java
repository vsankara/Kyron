package com.technobrain.trips.transaction.service;

import com.technobrain.trips.account.model.AccTranAllocation;
import com.technobrain.trips.account.model.Account;
import com.technobrain.trips.account.model.AccountPeriod;
import com.technobrain.trips.account.model.AccountTransaction;
import com.technobrain.trips.account.model.RevenueAccount;
import com.technobrain.trips.account.model.TransactionSummaryView;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.document.model.DdocCharges;
import com.technobrain.trips.document.model.DdocDocument;
import com.technobrain.trips.document.model.DdocTransaction;
import com.technobrain.trips.document.model.DfinAccAdjustment;
import com.technobrain.trips.document.model.DfinDocument;
import com.technobrain.trips.dto.portal.InvoiceDTO;
import com.technobrain.trips.dto.portal.PaymentDTO;
import com.technobrain.trips.dto.portal.TransactionDTO;
import com.technobrain.trips.dto.tax.accounting.PostingAllocationObject;
import com.technobrain.trips.instalmentagreement.model.InstalmentTransaction;
import com.technobrain.trips.reference.model.RefRevType;
import com.technobrain.trips.transaction.model.TransactionExtractHistory;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.eclipse.persistence.config.CacheUsage;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;


@Stateless(name = "TransactionFacade",mappedName = "TransactionFacade")
public class TransactionFacadeBean extends FacadeBean implements TransactionFacadeLocal, TransactionFacadeRemote {
    
    public boolean updateTaxAccountBalance(Long accountId, BigDecimal amount, String creditOrDebit) {
         BigDecimal acctBal = BigDecimal.ZERO;
        if (accountId != null) {
        
            Query queryFinal = em.createNamedQuery("Account.findById")
                .setParameter(1,accountId);
            queryFinal.setHint(QueryHints.CACHE_USAGE, 
                               CacheUsage.DoNotCheckCache);
            queryFinal.setHint(QueryHints.REFRESH, HintValues.TRUE);
            
            Account accTaxpayer = (Account)queryFinal.getSingleResult();
        
            if (accTaxpayer != null) {
                
                if(creditOrDebit.equalsIgnoreCase(Constants.TransactionType.CREDIT)){
                  if(amount.signum() != -1) {//if not negative then negate
                    amount = amount.negate();
                  }
                }
                
                acctBal = accTaxpayer.getBalance();
                acctBal = (acctBal == null) ? amount : acctBal.add(amount);
                accTaxpayer.setBalance(acctBal);
                saveOrUpdate(accTaxpayer);
                return true;
            }
        }
        return false;        
    }
    
    
    /**
     * Updates the taxpayer period balance
     * @param periodId
     * @param amount
     * @param creditOrDebit
     * @return
     */
    public boolean updateTaxAccountPeriodBalance(Long periodId, BigDecimal amount, String creditOrDebit,  boolean ignoreSuspense) {
        BigDecimal periodBalance = BigDecimal.ZERO;
        boolean isliable = false;
        if (periodId != null && periodId != 0) {
    //            AccountPeriod accTaxpayerPeriod = em.find(AccountPeriod.class, periodId);
            
            Query queryFinal = em.createNamedQuery("AccountPeriod.findById")
                .setParameter(1,periodId);
            queryFinal.setHint(QueryHints.CACHE_USAGE, 
                               CacheUsage.DoNotCheckCache);
            queryFinal.setHint(QueryHints.REFRESH, HintValues.TRUE);

            AccountPeriod accTaxpayerPeriod = (AccountPeriod)queryFinal.getSingleResult();
            
            if (accTaxpayerPeriod != null) {
                if (creditOrDebit.equalsIgnoreCase("CREDIT")) {
                    amount = amount.negate();
                } 
                if(periodBalance.compareTo(BigDecimal.ZERO)>0){
                    isliable =true;
                }
                periodBalance = accTaxpayerPeriod.getBalance();
                periodBalance = (periodBalance == null) ? amount : periodBalance.add(amount);
                accTaxpayerPeriod.setBalance(periodBalance);
                if(!ignoreSuspense){
                    if(isliable){
                        if(periodBalance.compareTo(BigDecimal.ZERO)>0){
                            accTaxpayerPeriod.setPeriodStatus(Constants.PeriodStatuses.PARTIALLYPAID);
                        }else{
                            accTaxpayerPeriod.setPeriodStatus(Constants.PeriodStatuses.PAID);
                        }
                    }
                }
                saveOrUpdate(accTaxpayerPeriod);
                return true;
            }
        }
        return false;
    }
    
    public boolean transactionAllocations(AccountTransaction sourceTran, List<PostingAllocationObject> targetAllocations, boolean isSuspense) {
        BigDecimal sourceBal = sourceTran.getBalance();
        
            for ( PostingAllocationObject targetTranObj: targetAllocations) {
                BigDecimal targetDue = targetTranObj.getAllocAmount();
                
                    if(targetDue.compareTo(BigDecimal.ZERO)<=0){
                        continue;
                    }
                    AccountTransaction targetTran = null;
                    if (targetTranObj.getTransactionId() != null ) {
                        targetTran = em.find(AccountTransaction.class,targetTranObj.getTransactionId());
                    } 
                    
                    if (targetTran == null) {
                        continue;
                    }
                    
                    AccTranAllocation tranAllocation = new AccTranAllocation();
                    tranAllocation.setSourceTransaction(sourceTran.getId());
                    tranAllocation.setTargetTransaction(targetTran.getId());
                    tranAllocation.setTimeStamp(DateHelper.getSqlTimestamp());

                    tranAllocation.setCreatedBy(Constants.Users.DEF_SYS_CREATED_BY);
                    tranAllocation.setUpdatedBy(Constants.Users.DEF_SYS_UPDATED_BY);
                    tranAllocation.setCreatedDate(DateHelper.getSqlTimestamp());
                    tranAllocation.setUpdatedDate(DateHelper.getSqlTimestamp());
                    // now process depending on how much of the source tran will be allocated
                    if (targetDue.abs().compareTo(sourceBal.abs()) <= 0) {
                        targetTran.setBalance(targetTran.getBalance().subtract(targetDue));
                        tranAllocation.setAllocationValue(targetDue.abs());
                        sourceBal = sourceBal.subtract(targetDue); 
                    } else {
                        tranAllocation.setAllocationValue(sourceBal);
                        targetTran.setBalance(targetDue.subtract(sourceBal));
                        sourceBal = BigDecimal.ZERO; 
                    }
                    saveOrUpdate(targetTran);
                    saveOrUpdate(tranAllocation);
                   
                    
                    if (!targetTran.getAccountPeriod().equals(sourceTran.getAccountPeriod())) {
                        updateTaxAccountPeriodBalance(targetTran.getAccountPeriod(), tranAllocation.getAllocationValue(), sourceTran.getTransactionType(),isSuspense);
                        updateTaxAccountPeriodBalance(sourceTran.getAccountPeriod(), tranAllocation.getAllocationValue(), targetTran.getTransactionType(),isSuspense);
                    }
              
                    if (!targetTran.getAccAccount().equals(sourceTran.getAccAccount())) {
                        updateTaxAccountBalance(targetTran.getAccAccount(), tranAllocation.getAllocationValue(), sourceTran.getTransactionType());
                        updateTaxAccountBalance(sourceTran.getAccAccount(), tranAllocation.getAllocationValue(), targetTran.getTransactionType());
                    }
              
            }
            sourceTran.setBalance(sourceBal);
            saveOrUpdate(sourceTran);
            
        
        return true;
    }
    
    /**
     * This method creates the allocations. if the tranId is not null, then it offsets a particular
     * transaction. otherwise it fetches a list of transactions belonging to the particular account & period
     * and starts offseting them. 
     * @param sourceTran
     * @param tranId
     * @return
     */
    public boolean transactionAllocations(AccountTransaction sourceTran, List<AccountTransaction> targetTranList, BigDecimal amountAllocated, boolean isSuspense) {
        
        BigDecimal sourceBal = sourceTran.getBalance();
      
            for ( AccountTransaction targetTran: targetTranList) {
                BigDecimal targetDue = null == amountAllocated ? targetTran.getBalance() : amountAllocated;
                
                if (targetDue.compareTo(targetTran.getBalance()) > 0) {
                    targetDue = targetTran.getBalance();
                }
                
                    if(targetDue.compareTo(BigDecimal.ZERO)<=0) {
                        continue;
                    }
                    
                    if(sourceTran.getTransactionType().equals(targetTran.getTransactionType())) {
                        continue;
                    }
                    
                
                    AccTranAllocation tranAllocation = new AccTranAllocation();
                    tranAllocation.setSourceTransaction(sourceTran.getId());
                    tranAllocation.setTargetTransaction(targetTran.getId());
                    tranAllocation.setTimeStamp(DateHelper.getSqlTimestamp());

                    tranAllocation.setCreatedBy(Constants.Users.DEF_SYS_CREATED_BY);
                    tranAllocation.setUpdatedBy(Constants.Users.DEF_SYS_UPDATED_BY);
                    tranAllocation.setCreatedDate(DateHelper.getSqlTimestamp());
                    tranAllocation.setUpdatedDate(DateHelper.getSqlTimestamp());
                    // now process depending on how much of the source tran will be allocated
                    if (targetDue.abs().compareTo(sourceBal.abs()) <= 0) {
                        targetTran.setBalance(targetTran.getBalance().subtract(targetDue));
                        tranAllocation.setAllocationValue(targetDue.abs());
                        sourceBal = sourceBal.subtract(targetDue); // sourceTran.setBalance(sourceBal.add(targetDue));
                    } else {
                        tranAllocation.setAllocationValue(sourceBal);
                        targetTran.setBalance(targetDue.subtract(sourceBal));
                        sourceBal = BigDecimal.ZERO; //sourceTran.setBalance(new BigDecimal(0));
                    }
                    saveOrUpdate(targetTran);
                    saveOrUpdate(tranAllocation);
                   
                    
                    if (targetTran.getAccountPeriod()!=null && sourceTran.getAccountPeriod()!=null && targetTran.getAccountPeriod().intValue() != sourceTran.getAccountPeriod().intValue()) {
                        updateTaxAccountPeriodBalance(targetTran.getAccountPeriod(), tranAllocation.getAllocationValue(), sourceTran.getTransactionType(), isSuspense);
                        updateTaxAccountPeriodBalance(sourceTran.getAccountPeriod(), tranAllocation.getAllocationValue(), targetTran.getTransactionType(), isSuspense);
                    } 
              
                    if (targetTran.getAccAccount().intValue() != sourceTran.getAccAccount().intValue()) {
                        updateTaxAccountBalance(targetTran.getAccAccount(), tranAllocation.getAllocationValue(), sourceTran.getTransactionType());
                        updateTaxAccountBalance(sourceTran.getAccAccount(), tranAllocation.getAllocationValue(), targetTran.getTransactionType());
                    } 
              
            }
            sourceTran.setBalance(sourceBal);
            saveOrUpdate(sourceTran);
            
       
       return true;                                 
    }
    
    public List<AccountTransaction> findAccountTransactionsByIds(List<Long> tranIds){
        String queryStr = "select o from AccountTransaction o where o.id in (";
        if (tranIds != null && tranIds.size() > 0) {
            queryStr = queryStr + tranIds.get(0);
            for(int i=1;i<tranIds.size();i++){
                queryStr = queryStr + "," + tranIds.get(i);
            }
            queryStr = queryStr + ")";
            
            Query query = em.createQuery(queryStr); 
            try{
                return query.getResultList();
            }catch (javax.persistence.NoResultException e) {
                return null;
            }
        }
        return null;
    }
    
    public List<AccountTransaction> findAccountTransactionsByReferences(List<String> tranRefs){
        String strTranRefs = StringHelper.getCommaSeperated(tranRefs);
        return em.createNamedQuery("AccountTransaction.findTransactionsByTransactionRefs").setParameter(1, strTranRefs)
                    .getResultList();
    }
    
    public List<AccountTransaction> findTransactionsByDocument(List<Long> docIds, Long accountId, Long periodId){
        
        boolean adhocTaxType = false;
        boolean isDocPresent = false;
        RevenueAccount revenueAccount = 
            (RevenueAccount)em.createNamedQuery("RevenueAccount.findById").setParameter(1, 
                                                                                        accountId).getSingleResult();
        RefRevType refRevType = 
            (RefRevType)queryFindByCode(RefRevType.class,revenueAccount.getRevenueType());
        if (refRevType != null && refRevType.getRefRevMode() != null && 
            Constants.RevenueAcc.REV_TRANSACTION.equalsIgnoreCase(refRevType.getRefRevMode().getCode())) {
            adhocTaxType = true;
        }
        
        List<AccountTransaction> targetTranList = null;
        
        String queryStr = "select o from AccountTransaction o where o.id in ( SELECT view.transId FROM TransactionSummaryView view WHERE ";
       
        
        if (docIds != null && docIds.size() > 0) {
            isDocPresent = true;
            queryStr = queryStr + "view.docId IN (" +docIds.get(0);
            for(int i=1;i<docIds.size();i++){
                queryStr = queryStr + "," + docIds.get(i);
            }
            queryStr = queryStr + ") AND view.transType <>'CREDIT' AND view.transBalance > 0 AND view.docType<>'INSTALMENT_AGREEMENT') ";
        }
        
        if(isDocPresent){
            Query query = em.createQuery(queryStr);
            targetTranList = query.getResultList();
        }
        
        queryStr = "select o from AccountTransaction o where o.id in ( SELECT view.transId FROM TransactionSummaryView view WHERE ";
        
        if(!adhocTaxType){
            queryStr = queryStr+" view.periodId = '" +periodId+ "'  ";    
        } else {
            queryStr = queryStr+" view.accountId = '" +accountId+ "'  ";    
        }
        
        if (isDocPresent) {
            queryStr = queryStr + " AND view.docId NOT IN (" +docIds.get(0);
            for(int i=1;i<docIds.size();i++){
                queryStr = queryStr + "," + docIds.get(i);
            }
            queryStr = queryStr + ") ";
        }
        
        queryStr = queryStr+ " AND view.transType <>'CREDIT' AND view.transBalance > 0 AND view.docType<>'INSTALMENT_AGREEMENT') order by o.transactionDate";
        
        Query query = em.createQuery(queryStr);
        if(targetTranList!=null){
            targetTranList.addAll(query.getResultList());
        } else{
            targetTranList = query.getResultList();    
        }

        return targetTranList;
    }
    
    public List<AccountTransaction> applyAllocationRule(Long accountId, Long periodId, String typeToOffset){
        List<AccountTransaction> targetTranList = null;
        String queryStr = "select accTran from AccountTransaction accTran, Account acc,DdocTransaction dtran, CfgAllocationRule rule " +
                                    "where accTran.accAccount=acc.id and accTran.id=dtran.transactionId " +
                                    " and accTran.chargeType = rule.refChargeType.code and rule.cfgAllocationConfig.status = 'A' " + 
                                    " and (rule.cfgAllocationConfig.expiryDate is NULL or rule.cfgAllocationConfig.expiryDate >= CURRENT_TIMESTAMP) " +
                                    " and (rule.cfgAllocationConfig.effectiveDate is NULL or rule.cfgAllocationConfig.effectiveDate <= CURRENT_TIMESTAMP) ";
        if(accountId != null){
            queryStr = queryStr + " and acc.id = :accountId ";
        }
        if(periodId != null){
            queryStr = queryStr + " and accTran.accountPeriod = :periodId ";
        }
        if(typeToOffset != null){
            queryStr = queryStr + " and accTran.transactionType <> :typeToOffset ";
        }
        
        queryStr = queryStr + " and accTran.balance <> 0 order by rule.priority asc, accTran.accountPeriod asc, accTran.transactionDate asc";
        Query query = em.createQuery(queryStr);
        
        if(accountId != null){
            query .setParameter("accountId",accountId);
        }
        if(periodId != null){
            query.setParameter("periodId",periodId);
        }
        if(typeToOffset != null){
            query .setParameter("typeToOffset",typeToOffset);
        }
        
        targetTranList = query.getResultList();
        return targetTranList;
    }
    
    /**
    * This method fetches a list of transactions belonging to the particular 
    * account and transactionType != passed in transaction type and the balance is not 0
    * @param accountId
    * @param typeToOffset 
    * @return
    */
    public List<AccountTransaction> getAllOffsetTransactionsByAccountAndType(Long accountId, String typeToOffset,String chargeType, Long periodId) {
         List<AccountTransaction> targetTranList = new ArrayList<AccountTransaction>();
         
         if (accountId != null) {        
            String qryStr = "select accTran from AccountTransaction accTran, Account acc where  accTran.accAccount=acc.id " + 
                            " and acc.id = :acctId and accTran.balance <> 0 ";
            
            
            if(typeToOffset != null){
                qryStr = qryStr + " and accTran.transactionType <> :typeToOffset ";
            }
            
            if(chargeType != null){
                qryStr = qryStr + " and accTran.chargeType = :chargeType ";
            }
             if(periodId != null){
                 qryStr = qryStr + " and accTran.accountPeriod = :accountPeriod ";
             }
            Query qry = em.createQuery(qryStr);
            if (accountId != null) { 
                qry.setParameter("acctId",accountId);    
            }
            if(typeToOffset != null){
                qry.setParameter("typeToOffset",typeToOffset);
            }
            if(chargeType != null){
                qry.setParameter("chargeType",chargeType);
            }
             if(periodId != null){
                 qry.setParameter("accountPeriod",periodId);
             }
            try{
                 targetTranList = qry.getResultList();
             }catch(Exception ex){
                log.error(ex.getLocalizedMessage(), ex);
             }
         } 
     return targetTranList;    
    }
    
    public List<AccountTransaction> filterTargetTranByAllocationAmount(List<AccountTransaction> targetTranList, 
                                                                        BigDecimal amountToAllocate) {
        List<AccountTransaction> finalTargetTran = null;
        if(amountToAllocate != null && amountToAllocate.compareTo(BigDecimal.ZERO) > 0){
            if(targetTranList != null && targetTranList.size() >0){
                finalTargetTran = new ArrayList<AccountTransaction>();
                for(AccountTransaction targetTran:targetTranList){
                    if(targetTran.getBalance().compareTo(amountToAllocate) >=0 ){
                        finalTargetTran.add(targetTran);
                        break;
                    }else{
                        finalTargetTran.add(targetTran);
                        amountToAllocate = amountToAllocate.subtract(targetTran.getBalance());
                    }
                }
            }
        }
        return finalTargetTran;
    }
    
    public AccountTransaction postTransaction (AccountTransaction accTran, boolean ignoreSuspense) {
        accTran = saveOrUpdate(accTran);
        
        updateTaxAccountBalance(accTran.getAccAccount(), accTran.getAmount(), accTran.getTransactionType());
        updateTaxAccountPeriodBalance(accTran.getAccountPeriod(), accTran.getAmount(), accTran.getTransactionType(), ignoreSuspense);
        return accTran;
    }
    
    /**
     * Creates the link record in DDOC_TRANSACTION. 
     * @param docId
     * @param eventId
     * @param tranId
     * @param chargeId
     * @return
     */
    public boolean createDocumentTransactionLink(Long docId, Long eventId, Long tranId, Long chargeId ) {
        try 
        {
            DdocTransaction docTransaction = new DdocTransaction();
            docTransaction.setDocumentId(docId);
            docTransaction.setTransactionId(tranId);
            docTransaction.setChargeId(chargeId);
            docTransaction.setEventId(eventId);

            docTransaction.setCreatedBy(Constants.Users.DEF_SYS_CREATED_BY);
            docTransaction.setUpdatedBy(Constants.Users.DEF_SYS_UPDATED_BY);
            
            docTransaction.setCreatedDate(DateHelper.getSqlTimestamp());
            docTransaction.setUpdatedDate(DateHelper.getSqlTimestamp());
            saveOrUpdate(docTransaction);
            return true;
        } catch (javax.persistence.NoResultException e) {
            return false;
        }
     }
    
    /**
     * Creates the link record in INSTALMENT_TRANSACTION. 
     * @param docId
     * @param tranId
     * @param instalmentId
     */
    public void createInstalmentTransactionLink(Long docId, Long tranId, Long instalmentId ) {
        try 
        {
            InstalmentTransaction instalmentTransaction = new InstalmentTransaction();
            instalmentTransaction.setDocumentId(docId);
            instalmentTransaction.setTransactionId(tranId);
            instalmentTransaction.setInstalmentId(instalmentId);
            instalmentTransaction.setCreatedBy(Constants.Users.DEF_SYS_CREATED_BY);
            instalmentTransaction.setUpdatedBy(Constants.Users.DEF_SYS_UPDATED_BY);
            
            instalmentTransaction.setCreatedDate(DateHelper.getSqlTimestamp());
            instalmentTransaction.setUpdatedDate(DateHelper.getSqlTimestamp());
            saveOrUpdate(instalmentTransaction);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
     }


}