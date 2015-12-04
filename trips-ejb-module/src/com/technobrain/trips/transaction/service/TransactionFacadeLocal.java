package com.technobrain.trips.transaction.service;

import com.technobrain.trips.account.model.AccountTransaction;
import com.technobrain.trips.core.service.FacadeLocal;

import com.technobrain.trips.dto.tax.accounting.PostingAllocationObject;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.Local;


@Local
public interface TransactionFacadeLocal extends FacadeLocal {

    public List<AccountTransaction> findAccountTransactionsByIds(List<Long> tranIds);
    public boolean transactionAllocations(AccountTransaction sourceTran, List<PostingAllocationObject> targetAllocations, boolean isSuspense);
    public boolean transactionAllocations(AccountTransaction sourceTran, List<AccountTransaction> targetTranList, BigDecimal amountAllocated, boolean isSuspense);
    public List<AccountTransaction> findAccountTransactionsByReferences(List<String> tranRefs);
    public List<AccountTransaction> findTransactionsByDocument(List<Long> docIds, Long accountId, Long periodId);
    public List<AccountTransaction> applyAllocationRule(Long accountId, Long periodId, String typeToOffset);
    public List<AccountTransaction> getAllOffsetTransactionsByAccountAndType(Long accountId, String typeToOffset,String chargeType, Long periodId);
    public List<AccountTransaction> filterTargetTranByAllocationAmount(List<AccountTransaction> targetTranList, BigDecimal amountToAllocate);
    public AccountTransaction postTransaction (AccountTransaction accTran, boolean ignoreSuspense) ;
    public boolean createDocumentTransactionLink(Long docId, Long eventId, Long tranId, Long chargeId );
    public void createInstalmentTransactionLink(Long docId, Long tranId, Long instalmentId );

    
}
