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

public abstract class BasePostingHandler implements IPostingHandler{
    
    protected RefDocRevLedCodeParams docRevLedParams;
    DdocDocument docToPost = null;
    FlexibleForm flexFormConfig = null;
    String mode = null;    
    AccountTransaction sourceTran = null;
    List<DdocCharges> docCharges;
    protected EntEntity entity;
    protected IRevnueLedgerAccessor ledgerAccessor;
    protected Long  defaultRevLedCode;
    protected String businessSectorISICCode;
    protected RefReturnType refReturnType;
    private HashMap<String,Long> taxAccount;
    private HashMap<String,Long> taxPeriod;
    private HashMap<String,BigDecimal> amountToPost;
    boolean targetTransactionPostingCompleted;
    protected BasePostingHandler(DdocDocument ddoc) {
        setDocToPost(ddoc);
    }
    
    public void postToAccount(DdocDocument doc){
        doc.getDocType(); 
        setDocToPost(doc);
    }

    public boolean isPostingRequired(){
        //DdocDocument docToPost = getDocToPost();
        //TODO need to have generic code based on mode
        
        return true;
    }
    
    
    public boolean isSourceTransactionPostingRequired() {
        return false;
    }
    
    public boolean isTargetTransactionPostingRequired() {
        return false;
    }

    public void setDocToPost(DdocDocument docToPost) {
        this.docToPost = docToPost;
    }

    public DdocDocument getDocToPost() {
        return docToPost;
    }

    public boolean isPeriodGenerationRequired(){
        return true;
    }
    public boolean isPeriodBalanceUpateRequiredDuringAllocation(){
        return false;
    }
    
    public List<AccountTransaction> prepareSourceAccountTransaction() {
        return null;
    }
    
    public List<AccountTransaction> prepareTargetAccountTransaction() {
        return null;
    }
    
    public void setCurrentSourceTransaction(AccountTransaction accTran) {
        this.sourceTran = accTran;
    }
    
    public List<AccountTransaction> getSourceTransactions() {
        return null;
    }
    
    public List<AccountTransaction> getTargetTransactions() {
        return null;
    }

    public List<Long> getSourceTransactionIds() {
        return null;
    }

    public List<Long> getTargetTransactionIds() {
        return null;
    }
    
    public List<String> getTargetTransactionReferences() {
        return null;
    }

    public boolean isFlexibleFormUsed() {
        return false;
    }

    public void setFlexFormConfig(FlexibleForm ff) {
        this.flexFormConfig = ff;
    }

    public FlexibleForm getFlexFormConfig() {
        return flexFormConfig;
    }

    
    public BigDecimal getAmountAllocated() {
        return null;
    }

     public Long getDebitPeriod() {
         return null;
     }

     public Long getCreditPeriod() {
         return null;
     }
     
    public String getChargeType(){
        return null;
    }

    public String getSourceTransactionIdentifier() {
        return null;
    }    
    
    public String getTargetTransactionIdentifier() {
        return null;
    }
    
    public String getRevenueLedgerCode(){
        return null;
    }
    
    public List<PostingAllocationObject> getTargetAllocations() {
        return null;
    }
    

    public void setSourceTran(AccountTransaction sourceTran) {
        this.sourceTran = sourceTran;
    }

    public AccountTransaction getSourceTran() {
        return sourceTran;
    }
    
    public boolean isMultiplePostingRequired(){
        return false;
    }
    
    public void setAssociatedDocCharges(List<DdocCharges> charges){
        this.docCharges = charges;
    }
    public List<DdocCharges> getAssociatedDocCharges(){
        return docCharges;
    }
    
    public void setTaxAccountToPost(HashMap<String,Long> taxAccount) {
        this.taxAccount = taxAccount;
    }

    public HashMap<String,Long> getTaxAccountToPost() {
        return taxAccount;
    }

    public void setTaxPeriodToPost(HashMap<String,Long> taxPeriod) {
        this.taxPeriod = taxPeriod;
    }

    public HashMap<String,Long> getTaxPeriodToPost() {
        return taxPeriod;
    }

    public void setTaxAmountToPost(HashMap<String,BigDecimal> amountToPost) {
        this.amountToPost = amountToPost;
    }

    public HashMap<String,BigDecimal> getTaxAmountToPost() {
        return amountToPost;
    }
    
    public void setPrimaryBusinessSectorCode(String primaryISICCode) {
        this.businessSectorISICCode = primaryISICCode;
    }
    

     public void setRefReturnType(RefReturnType refReturnType){
        this.refReturnType = refReturnType;
    }
    
    public void setDefaultRevLedCode(Long code){
        this.defaultRevLedCode = code;
    }
    public void setLedgerAccessor(IRevnueLedgerAccessor ledgerAccessor){
        this.ledgerAccessor = ledgerAccessor;
    }
    public void setEntity(EntEntity entity) {
        this.entity = entity;
    }
    public boolean isPaymentOnPeriod(){
           return false;
       }

    public void setDocRevLedParams(RefDocRevLedCodeParams docRevLedParams) {
        this.docRevLedParams = docRevLedParams;
    }

    public RefDocRevLedCodeParams getDocRevLedParams() {
        return docRevLedParams;
    }
    public void setRefDocRevLedCodeParams(RefDocRevLedCodeParams refDocRevLedParams) {
        this.docRevLedParams = refDocRevLedParams;
    }
    
    public boolean isIgnoreSuspense(){
        return true;
    }
    
    public boolean isDocChargeUsed() {
        return false;
    }
    
    public List<Long> getTargetDocumentIds() {
        return null;
    }
    
    public List<AccountTransaction> getAdditionalTransactions(){
        return null;
    }
    
    public boolean requiresAllocation(AccountTransaction accTrans) {
        return true;
    }
    
    public void setTargetTransactionPostingCompleted(boolean targetTransactionPostingCompleted) {
        this.targetTransactionPostingCompleted=targetTransactionPostingCompleted;
    }
    
    public boolean isTargetTransactionPostingCompleted() {
        return false;
    }

}
