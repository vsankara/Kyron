package com.technobrain.trips.account.handler;

import com.technobrain.trips.account.ledger.IRevnueLedgerAccessor;
import com.technobrain.trips.account.model.AccountTransaction;
import com.technobrain.trips.document.model.DdocCharges;
import com.technobrain.trips.document.model.DdocDocument;

import com.technobrain.trips.dto.tax.accounting.PostingAllocationObject;
import com.technobrain.trips.entity.model.EntEntity;
import com.technobrain.trips.flexforms.model.FlexibleForm;
import com.technobrain.trips.reference.model.RefDocRevLedCodeParams;
import com.technobrain.trips.reference.model.RefDocTypeReturnTypeRel;
import com.technobrain.trips.reference.model.RefReturnType;
import com.technobrain.trips.revenueaccount.service.RevenueAccountFacadeLocal;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IPostingHandler {
    public static String TRANSACTION_ID = "TRANSACTION_ID";
    public static String TRANSACTION_OBJECT = "TRANSACTION_OBJECT";
    public static String TRANSACTION_REFERENCE = "TRANSACTION_REFERENCE";
    public static String DOCUMENT_ID= "DOCUMENT_ID";
    
    public void postToAccount(DdocDocument doc);
//    public void postTransaction();
    public boolean isPostingRequired();
    public boolean isSourceTransactionPostingRequired();
    public boolean isTargetTransactionPostingRequired();
    public boolean isTransactionAllocationRequired();
    public boolean isPeriodGenerationRequired();

    public boolean isMultiplePostingRequired();


    public List<AccountTransaction> prepareSourceAccountTransaction();
    public List<AccountTransaction> prepareTargetAccountTransaction();
    public List<AccountTransaction> getSourceTransactions();
    public List<AccountTransaction> getTargetTransactions();
    public List<PostingAllocationObject> getTargetAllocations();
    
    public void setCurrentSourceTransaction(AccountTransaction accTran);
    
    public String getSourceTransactionIdentifier();
    public String getTargetTransactionIdentifier();
    public List<Long> getSourceTransactionIds();
    public List<Long> getTargetTransactionIds();
    public List<String> getTargetTransactionReferences();
    public Long getCreditPeriod();
    public Long getDebitPeriod();
    public BigDecimal getAmountAllocated();
    public boolean shouldApplyAllocationRule();
    
    public boolean isFlexibleFormUsed();
    public void setFlexFormConfig(FlexibleForm ff);
    
    public boolean isPeriodBalanceUpateRequiredDuringAllocation();
    public String getChargeType();
    public String getRevenueLedgerCode();
    public void setAssociatedDocCharges(List<DdocCharges> charges);
    
    public void setTaxAmountToPost(HashMap<String,BigDecimal> amountToPostMap);
    public void setTaxPeriodToPost(HashMap<String,Long> periodToPostMap);
    public void setTaxAccountToPost(HashMap<String,Long> accountToPostMap);
    public void setPrimaryBusinessSectorCode(String primaryISICCode);
    public void setRefReturnType(RefReturnType refReturnType);
    public void setDefaultRevLedCode(Long code);
    public void setLedgerAccessor(IRevnueLedgerAccessor ledgerAccessor);
    public void setEntity(EntEntity entity);
    public boolean isPaymentOnPeriod();

    public void setRefDocRevLedCodeParams(RefDocRevLedCodeParams refDocRevLedParams);

    public boolean isIgnoreSuspense();     
        
    public boolean isDocChargeUsed();
    
    public List<Long> getTargetDocumentIds();
    public List<AccountTransaction> getAdditionalTransactions();
    
    public boolean requiresAllocation(AccountTransaction accTrans);
    
    public void setTargetTransactionPostingCompleted(boolean targetTransactionPostingCompleted);
    
    public boolean isTargetTransactionPostingCompleted();
    

    }
