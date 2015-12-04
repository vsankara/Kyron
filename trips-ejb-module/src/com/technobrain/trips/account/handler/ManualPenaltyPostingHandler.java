package com.technobrain.trips.account.handler;

import com.technobrain.trips.account.model.AccountTransaction;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.document.model.DdocCharges;
import com.technobrain.trips.document.model.DdocDocument;
import com.technobrain.trips.document.model.DfinManualPenalty;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ManualPenaltyPostingHandler extends BasePostingHandler{
    
    public void postToAccount(DdocDocument doc){
        // do nothing
    }
    
    public ManualPenaltyPostingHandler(DfinManualPenalty dfinManualPenalty) {
        super(dfinManualPenalty);
    }
       
    public boolean isPostingRequired(){
        return true;
    }
    
    public boolean isSourceTransactionPostingRequired(){
        return true;    
    }
    
    public boolean isTransactionAllocationRequired(){
        return false;
    }
    
    public boolean shouldApplyAllocationRule() {
        return false;
    }

    public List<AccountTransaction> prepareSourceAccountTransaction() {
        List<AccountTransaction> accTranList = new ArrayList<AccountTransaction>();
        DfinManualPenalty docToPost = (DfinManualPenalty)getDocToPost();
        Double amount =null;
//        if(docToPost != null){
//            AccountTransaction accTran = new AccountTransaction();
//
//            accTran.setAccAccount(docToPost.getAccAccount());
//            accTran.setAccountPeriod(docToPost.getAccPeriod());
//            accTran.setAmount(docToPost.getAmount());
//            accTran.setBalance(docToPost.getAmount());
//            accTran.setDescription(docToPost.getNotes());
//            accTran.setTransactionType(Constants.TransactionType.DEBIT);
//            accTran.setTransactionDate(DateHelper.getSqlTimestamp(Calendar.getInstance()));
//            accTran.setChargeType(Constants.ChargeType.PENALTY);
//            
//            accTranList.add(accTran);
//        }    
             //The doc charge list will have only one item
             List<DdocCharges> chargeList = getAssociatedDocCharges();
             if (chargeList != null) {
                 for (DdocCharges curr: chargeList) {
                     amount=curr.getAmount();
                     AccountTransaction accTran = new AccountTransaction();
                     accTran.setAccAccount(docToPost.getAccAccount());
                     accTran.setTransactionDate(DateHelper.getSqlTimestamp(Calendar.getInstance()));
                     
                     accTran.setTransactionType(Constants.TransactionType.DEBIT);
                     if(getRevenueLedgerCode() == null){
                         accTran.setAccRevLedId(defaultRevLedCode);
                     } 
                     accTran.setChargeType(Constants.ChargeType.PENALTY);
                     accTran.setAmount(new BigDecimal(amount));
                     accTran.setBalance(new BigDecimal(amount));
                     accTran.setAccountPeriod(docToPost.getAccPeriod());
                     accTran.setEventId(curr.getEventId());
                     accTran.setChargeId(curr.getId());
                     accTran.setDescription(docToPost.getNotes());
                     accTranList.add(accTran);
                 }
             }
        return accTranList;
    }

//    public String getTargetTransactionIdentifier() {
//        return null;
//    }
    
//    public List<String> getTargetTransactionReferences() {
//        DfinAccAdjustment docToPost = (DfinAccAdjustment)getDocToPost();
//        if(docToPost != null && docToPost.getTransactionReference() != null){
//            List<String> targetTranRefs = new ArrayList<String>();
//            targetTranRefs.add(docToPost.getTransactionReference());
//            return targetTranRefs;
//        }else{
//            return null;
//        }
//    }
    
//    public String getChargeType() {
//        DfinAccAdjustment docToPost = (DfinAccAdjustment)getDocToPost();
//        return docToPost.getChargeType();
//    }
    
    public String getRevenueLedgerCode() {
        DfinManualPenalty docToPost = (DfinManualPenalty)getDocToPost();
        return docToPost.getRevenueLedgerCode();
    }
    
    public boolean isDocChargeUsed() {
        return true;
    }
}
