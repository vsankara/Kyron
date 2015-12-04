package com.technobrain.trips.document.messagehelper;

import com.technobrain.trips.account.model.AccountPeriod;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.common.messagehelpers.ComplexAssociationHelper;
import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.core.message.DdocDocumentInputType;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.document.model.DfinAccAdjustment;
import com.technobrain.trips.document.model.DfinCrAllocation;
import com.technobrain.trips.document.model.DfinDocument;
import com.technobrain.trips.document.model.DfinManualPenalty;
import com.technobrain.trips.instalmentagreement.model.AgreementInstalments;
import com.technobrain.trips.instalmentagreement.model.DfinInstalmentAgreement;
import com.technobrain.trips.instalmentagreement.model.InstalAgreementOutstandingDebts;
import com.technobrain.trips.instalmentagreement.model.InstalAgreementRelatedDocs;
import com.technobrain.trips.refunds.model.DfinRefundClaim;
//import com.crownagents.trips.revenuedeferment.message.AgreementRelatedDocumentsInputType;
//import com.crownagents.trips.revenuedeferment.message.InstalmentAgreementInputType;
//import com.crownagents.trips.revenuedeferment.message.InstalmentType;
//import com.crownagents.trips.revenuedeferment.message.OutstandingDebtType;
//import com.crownagents.trips.transaction.message.TransactionInputType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class DfinDocumentMessageHelper extends MessageHelper {

    public BaseModelObject setData(BaseModelObject pojo, InputType type) {
        
        DfinDocument doc = pojo == null ? new DfinDocument() : (DfinDocument)pojo;
        
        if(type == null) {
            return null;
        } else {
            DdocDocumentInputType inputType = (DdocDocumentInputType)type;            
            
//            if(type instanceof AccountAdjustmentInputType) {
//                doc = setAccountAdjustmentData(pojo, type);
//            } else if(type instanceof DfinCreditAllocationInputType) {                
//                doc = setCrAllocationData(pojo, inputType);
//            } else if(type instanceof InstalmentAgreementInputType) {                
//                doc = setInstalmentAgreementData(pojo, inputType);
//            }else 
//             
//             if(type instanceof PenaltyInputType) {                
//                doc = setPenaltyData(pojo, inputType);
////            } else if(type instanceof RefundClaimInputType){
////                doc = setRefundClaimData(pojo, type);
//            }
            DocumentMessageHelper docMessageHelper = 
                initMessageHelper(DocumentMessageHelper.class);
            docMessageHelper.setDdocDocumentDataToPojo(doc, inputType);
            return doc;
        }
    }

    public InputType getData(BaseModelObject pojo) {
    
        DfinDocument doc = (DfinDocument)pojo;
        DdocDocumentInputType inputType = null;
        inputType = MessageHelper.init(inputType,DdocDocumentInputType.class);
        
        
        if(pojo instanceof DfinAccAdjustment) {
//            inputType = getAccountAdjustmentData(pojo);
        }
        else if(pojo instanceof DfinCrAllocation) {
//            inputType = getCrAllocationData(pojo);
        } else if(pojo instanceof DfinInstalmentAgreement) {
//            inputType = getInstalmentAgreementData(pojo);
        }
//        else if(pojo instanceof DfinManualPenalty) {
//            inputType = getPenaltyInputTypeData(pojo);
//        }else if(pojo  instanceof DfinRefundClaim){
////            inputType = getDfinRefundClaimData(pojo);
//        }
        
        DocumentMessageHelper docMessageHelper = 
            initMessageHelper(DocumentMessageHelper.class);
        docMessageHelper.setDdocDocumenDateToInputType(doc, inputType);
        
        return inputType;
    }
    
    /**
     * This method takes the parameters of AccountAdjustmentInputType, DfinAccAdjustment
     * sets the data accordingly from the input type to
     * DfinAccAdjustment and returns a populated data of the same. 
     * <br>
     * @param type InputType
     * @param pojo BaseModelObject
     * @return finAdjustment DfinAccAdjustment
     */
//    public  DfinAccAdjustment setAccountAdjustmentData(BaseModelObject pojo, InputType type) {
//                                                             
//       DfinAccAdjustment finAdjustment = pojo == null ? new DfinAccAdjustment() : (DfinAccAdjustment)pojo;
//       AccountAdjustmentInputType adjustment = (AccountAdjustmentInputType)type;
//
//        //setting the properties of the bean
//        finAdjustment.setId(adjustment.getId());
//        finAdjustment.setAdjustmentDate(DateHelper.getSqlTimestamp(adjustment.getAdjustmentDate()));
//        finAdjustment.setAmount(adjustment.getAmount());
//        finAdjustment.setNotes(adjustment.getNotes());
//        finAdjustment.setReason(adjustment.getReason());
//        finAdjustment.setAdjustmentType(adjustment.getAdjustmentType().toUpperCase());
////        finAdjustment.setCreatedBy(type.getCreatedBy());
////        finAdjustment.setUpdatedBy(type.getUpdatedBy());
////        finAdjustment.setCreatedDate(DateHelper.getSqlTimestamp(type.getCreatedDate()));
////        finAdjustment.setUpdatedDate(DateHelper.getSqlTimestamp(type.getUpdatedDate()));
//        finAdjustment.setTin(adjustment.getTin());
//        finAdjustment.setRevenueType(adjustment.getRevenueType());
////        finAdjustment.setAccPeriod(adjustment.getPeriodId());
////        finAdjustment.setDocType(Constants.DocumentType.ACCOUNT_ADJUSTMENT); 
////        finAdjustment.setAccAccount(adjustment.getAccountId());
//        finAdjustment.setChargeType(adjustment.getChargeType());
//        finAdjustment.setTransactionReference(adjustment.getTransactionReference());
//        finAdjustment.setRevenueLedgerCode(adjustment.getRevenueLedgerCode());
//        return finAdjustment;
//    } // end of method setDfinAccAdjustmentData
//    
//    /**
//     * This methods returns AccountAdjustmentInputType object for a provided 
//     * Account Adjustment entity
//     * 
//     * @param pojo
//     * @return
//     */
//     public AccountAdjustmentInputType getAccountAdjustmentData(BaseModelObject pojo) {
//                                                              
//        DfinAccAdjustment finAdjustment = (DfinAccAdjustment)pojo;
//        AccountAdjustmentInputType adjustmentType = new AccountAdjustmentInputType();
//        adjustmentType.setId(finAdjustment.getId());
//        adjustmentType.setAdjustmentDate(DateHelper.getCalendar(finAdjustment.getAdjustmentDate()));
//         //setting the properties of the bean
//        adjustmentType.setAmount(finAdjustment.getAmount());
//        adjustmentType.setNotes(finAdjustment.getNotes());         
//        adjustmentType.setReason(finAdjustment.getReason());
//        adjustmentType.setAdjustmentType(finAdjustment.getAdjustmentType());
//        adjustmentType.setTin(finAdjustment.getTin());
//        adjustmentType.setRevenueType(finAdjustment.getRevenueType());
////        adjustmentType.setPeriodId(finAdjustment.getAccPeriod());
////        adjustmentType.setAccountId(finAdjustment.getAccAccount());
//        if(null!=finAdjustment.getAccountPeriod()) {
//            if(null!=finAdjustment.getAccountPeriod().getPeriodNo()) {
//                adjustmentType.setPeriodMonth(finAdjustment.getAccountPeriod().getPeriodNo());
//            }
//            if(null!=finAdjustment.getAccountPeriod().getPeriodYear()) {
//                adjustmentType.setPeriodYear(finAdjustment.getAccountPeriod().getPeriodYear());
//            }
//        }
//        //TODO:need to get the actual period in dd/mm/yyyy format
//        //adjustment.setPeriod(String.valueOf(finAdjustment.getRevledRevPeriod()));
//        //adjustment.setTransactionReference(finAdjustment.getTransactionRef());
//         adjustmentType.setChargeType(finAdjustment.getChargeType());
//         adjustmentType.setTransactionReference(finAdjustment.getTransactionReference());
//         adjustmentType.setRevenueLedgerCode(finAdjustment.getRevenueLedgerCode());
//        return adjustmentType;
//     } // end of method setDfinAccAdjustmentData
//     
//     public TransactionInputType setTransactionInputTypeData(BaseModelObject pojo, AccountAdjustmentInputType adjustInput) {
//
//         TransactionInputType tranType = new TransactionInputType();
//         DfinAccAdjustment finAdjustment = (DfinAccAdjustment)pojo;
//         //Commented as part of Taxpayer adjustment module.
//         //tranType.setAccountCode(String.valueOf(adjustInput.getRegimeAccountID()));
//         tranType.setDescription(adjustInput.getNotes());
//         tranType.setAmount(adjustInput.getAmount());
//         tranType.setTransactionDate(adjustInput.getAdjustmentDate());
//         tranType.setCreatedBy(adjustInput.getCreatedBy());
//         tranType.setCreatedDate(adjustInput.getCreatedDate());
//         tranType.setUpdatedBy(adjustInput.getUpdatedBy());
//         tranType.setUpdatedDate(adjustInput.getUpdatedDate());
//         tranType.setPeriodID(finAdjustment.getAccPeriod());
//         tranType.setTransactionType(finAdjustment.getAdjustmentType());
//
//         return tranType;
//     }
//     
//     
//    
//    
//    
//    /**
//     * This method takes the parameters of DfinCreditAllocationInputType, DfinCrAllocation
//     * sets the data accordingly from the input type to
//     * DfinCrAllocation and returns a populated data of the same. 
//     * <br>
//     * @param type InputType
//     * @param pojo BaseModelObject
//     * @return crAllocation DfinCrAllocation
//     */
//    public  DfinCrAllocation setCrAllocationData(BaseModelObject pojo, InputType type){
//        if (type == null)
//            return null;
//        
//        DfinCrAllocation crAllocation = pojo == null ? new DfinCrAllocation() : (DfinCrAllocation)pojo;
//        DfinCreditAllocationInputType crAllocationType = (DfinCreditAllocationInputType)type;
//        
//        crAllocation.setId(crAllocationType.getId());
//        
//        crAllocation.setCrAllocationNotes(crAllocationType.getCreditAllocationNotes());
//        crAllocation.setCrDocType(crAllocationType.getCreditDocumentType());
//        crAllocation.setCrPeriod(crAllocationType.getCreditPeriodId());
//        crAllocation.setCrTransactionDate(DateHelper.getSqlTimestamp(crAllocationType.getCreditTransactionDate()));
//        crAllocation.setCrTransactionRef(crAllocationType.getCreditTransactionReference());
//        crAllocation.setCreditBalance(crAllocationType.getUnallocatedCreditBalance());
//        
//        crAllocation.setDrDocType(crAllocationType.getDebitDocumentType());
//        crAllocation.setDrPeriod(crAllocationType.getDebitPeriodId());
//        crAllocation.setDrTransactionDate(DateHelper.getSqlTimestamp(crAllocationType.getDebitTransactionDate()));
//        crAllocation.setDrTransactionRef(crAllocationType.getDebitTransactionReference());
//        crAllocation.setLiabilityBalance(crAllocationType.getOutstandingLiabilityBalance());
//        
//        crAllocation.setAllocatedAmount(crAllocationType.getAllocatedAmount());
//        crAllocation.setCrFromSuspense(StringHelper.getIndicatorAsString(crAllocationType.getMoveCreditFromSuspense()));
//        crAllocation.setCrToSuspense(StringHelper.getIndicatorAsString(crAllocationType.getMoveCreditToSuspense()));
//        crAllocation.setRevenueType(crAllocationType.getRevenueType());
//        crAllocation.setSubmissionDate(DateHelper.getSqlTimestamp(crAllocationType.getSubmissionDate()));
//        crAllocation.setCrTransactionId(crAllocationType.getCreditTransactionId());
//        crAllocation.setDrTransactionId(crAllocationType.getDebitTransactionId());
//        crAllocation.setTin(crAllocationType.getTIN());
//        
////        crAllocation.setCreatedBy(crAllocationType.getCreatedBy());
////        crAllocation.setUpdatedBy(crAllocationType.getUpdatedBy());
////        crAllocation.setCreatedDate(DateHelper.getSqlTimestamp(crAllocationType.getCreatedDate()));
////        crAllocation.setUpdatedDate(DateHelper.getSqlTimestamp(crAllocationType.getUpdatedDate()));
//        
////        crAllocation.setDocType(Constants.DocumentType.CREDIT_ALLOCATION);        
//        return crAllocation;
//    }
//    
//    public DfinRefundClaim setRefundClaimData(BaseModelObject pojo, InputType inputType){
//        DfinRefundClaim dfinRefundClaim = pojo == null ? new DfinRefundClaim() : (DfinRefundClaim)pojo;
//        RefundClaimInputType refundClaimInputType = (RefundClaimInputType)inputType;
//        if(refundClaimInputType.getId() != null){
//            dfinRefundClaim.setId(refundClaimInputType.getId()); 
//        }
//        dfinRefundClaim.setRefundClaimNo(refundClaimInputType.getRefundClaimNumber());
//        dfinRefundClaim.setRefundClaimStatus(refundClaimInputType.getRefundClaimStatus());
//        dfinRefundClaim.setTaxType(refundClaimInputType.getRegimeType());
//        dfinRefundClaim.setPeriod(refundClaimInputType.getPeriod());        
//        dfinRefundClaim.setClaimDate(DateHelper.getSqlTimestamp(refundClaimInputType.getClaimDate()));
//        dfinRefundClaim.setClaimAmount(refundClaimInputType.getClaimAmount());
//        dfinRefundClaim.setRefundDueDate(DateHelper.getSqlTimestamp(refundClaimInputType.getRefundDueDate()));
//        dfinRefundClaim.setActualRefundAmount(refundClaimInputType.getActualRefundAmount());
//        dfinRefundClaim.setClaimNote(refundClaimInputType.getClaimNotes());
//        dfinRefundClaim.setRejectionNotes(refundClaimInputType.getRejectionNotes());
//        dfinRefundClaim.setRejectionReason(refundClaimInputType.getRejectionReason());
//        dfinRefundClaim.setInterestAmount(refundClaimInputType.getInterestAmount());
//        dfinRefundClaim.setTotalRefundAmount(refundClaimInputType.getTotalRefundAmount());
//        dfinRefundClaim.setPaymentMode(refundClaimInputType.getPaymentMode());
//        dfinRefundClaim.setChequeNumber(refundClaimInputType.getChequeNo());
//        dfinRefundClaim.setChequeIssueDate(DateHelper.getSqlTimestamp(refundClaimInputType.getChequeIssueDate()));
//        dfinRefundClaim.setDateOfPayment(DateHelper.getSqlTimestamp(refundClaimInputType.getDateOfPayment()));
//        dfinRefundClaim.setPaymentRefernceNo(refundClaimInputType.getPaymentReferenceNumber());
//        dfinRefundClaim.setEntEntity(refundClaimInputType.getEntityId());
//        dfinRefundClaim.setReturnType(refundClaimInputType.getReturnType());
//        dfinRefundClaim.setPaymentProcessingNotes(refundClaimInputType.getPaymentProcessingNotes());
//        dfinRefundClaim.setAvailableCredit(refundClaimInputType.getAvailableCredit());
//        dfinRefundClaim.setClaimOriginator(refundClaimInputType.getClaimOriginator());
//        dfinRefundClaim.setClaimOfficer(refundClaimInputType.getClaimOfficer());
//        return dfinRefundClaim;
//    }
//    
//    public DfinCreditAllocationInputType getCrAllocationData(BaseModelObject pojo) {
//                                                             
//       DfinCrAllocation crAllocation = (DfinCrAllocation)pojo;
//       DfinCreditAllocationInputType crAllocationType = new DfinCreditAllocationInputType();
//      
//      
//        crAllocationType.setId(crAllocation.getId());
//        crAllocationType.setCreditAllocationNotes(crAllocation.getCrAllocationNotes());
//        
//        if(null != crAllocation.getCrTransactionId()){
//            crAllocationType.setCreditDocumentType(crAllocation.getCrDocType());
//            crAllocationType.setCreditPeriodId(crAllocation.getCrPeriod());
//            AccountPeriod period = em.find(AccountPeriod.class, crAllocation.getCrPeriod());
//            StringBuilder sb = new StringBuilder();
//            sb.append(period.getPeriodNo()).append("/").append(period.getPeriodYear());
//            crAllocationType.setCreditPeriod(sb.toString());
//            crAllocationType.setCreditTransactionDate(DateHelper.getCalendar(crAllocation.getCrTransactionDate()));
//            crAllocationType.setCreditTransactionReference(crAllocation.getCrTransactionRef());
//            crAllocationType.setCreditTransactionId(crAllocation.getCrTransactionId());
//            crAllocationType.setUnallocatedCreditBalance(crAllocation.getCreditBalance());
//        }
//        
////        if(null != crAllocation.getDrTransactionId()){
//            crAllocationType.setDebitDocumentType(crAllocation.getDrDocType());
//            crAllocationType.setDebitPeriodId(crAllocation.getDrPeriod());
//            AccountPeriod period = em.find(AccountPeriod.class, crAllocation.getDrPeriod());
//            StringBuilder sb = new StringBuilder();
//            sb.append(period.getPeriodNo()).append("/").append(period.getPeriodYear());
//            crAllocationType.setDebitPeriod(sb.toString());
//            crAllocationType.setDebitTransactionDate(DateHelper.getCalendar(crAllocation.getDrTransactionDate()));
//            crAllocationType.setDebitTransactionReference(crAllocation.getDrTransactionRef());
//            crAllocationType.setDebitTransactionId(crAllocation.getDrTransactionId());
//            crAllocationType.setOutstandingLiabilityBalance(crAllocation.getLiabilityBalance());
////        }
//        
//        crAllocationType.setAllocatedAmount(crAllocation.getAllocatedAmount());
//        crAllocationType.setMoveCreditFromSuspense(StringHelper.getIndicatorAsBoolean(crAllocation.getCrFromSuspense()));
//        crAllocationType.setMoveCreditToSuspense(StringHelper.getIndicatorAsBoolean(crAllocation.getCrToSuspense()));
//        crAllocationType.setRevenueType(crAllocation.getRevenueType());
//        crAllocationType.setSubmissionDate(DateHelper.getCalendar(crAllocation.getSubmissionDate()));
//        crAllocationType.setTIN(crAllocation.getTin());
//                
//       return crAllocationType;
//    } // end of method getCrAllocationData
//    
//    public RefundClaimInputType getDfinRefundClaimData(BaseModelObject pojo){
//        DfinRefundClaim dfinRefundClaim = (DfinRefundClaim)pojo;
//        RefundClaimInputType refundClaimInputType = new RefundClaimInputType();
//        
//        refundClaimInputType.setId(dfinRefundClaim.getId());
//        refundClaimInputType.setRefundClaimNumber(dfinRefundClaim.getRefundClaimNo());
//        refundClaimInputType.setRegimeType(dfinRefundClaim.getTaxType());
//        refundClaimInputType.setPeriod(dfinRefundClaim.getPeriod());
//        refundClaimInputType.setClaimDate(DateHelper.getCalendar(dfinRefundClaim.getClaimDate()));
//        refundClaimInputType.setClaimAmount(dfinRefundClaim.getClaimAmount());
//        refundClaimInputType.setRefundDueDate(DateHelper.getCalendar(dfinRefundClaim.getRefundDueDate()));
//        refundClaimInputType.setActualRefundAmount(dfinRefundClaim.getActualRefundAmount());
//        refundClaimInputType.setClaimNotes(dfinRefundClaim.getClaimNote());
//        refundClaimInputType.setRejectionNotes(dfinRefundClaim.getRejectionNotes());
//        refundClaimInputType.setInterestAmount(dfinRefundClaim.getInterestAmount());
//        refundClaimInputType.setTotalRefundAmount(dfinRefundClaim.getTotalRefundAmount());
//        refundClaimInputType.setPaymentMode(dfinRefundClaim.getPaymentMode());
//        refundClaimInputType.setChequeNo(dfinRefundClaim.getChequeNumber());
//        refundClaimInputType.setChequeIssueDate(DateHelper.getCalendar(dfinRefundClaim.getChequeIssueDate()));
//        refundClaimInputType.setDateOfPayment(DateHelper.getCalendar(dfinRefundClaim.getDateOfPayment()));
//        refundClaimInputType.setPaymentReferenceNumber(dfinRefundClaim.getPaymentRefernceNo());
//        refundClaimInputType.setEntityId(dfinRefundClaim.getEntEntity());
//        refundClaimInputType.setReturnType(dfinRefundClaim.getReturnType());
//        refundClaimInputType.setRefundClaimStatus(dfinRefundClaim.getRefundClaimStatus());
//        refundClaimInputType.setPaymentProcessingNotes(dfinRefundClaim.getPaymentProcessingNotes());
//        refundClaimInputType.setAvailableCredit(dfinRefundClaim.getAvailableCredit());
//        refundClaimInputType.setRejectionReason(dfinRefundClaim.getRejectionReason());
//        refundClaimInputType.setClaimOriginator(dfinRefundClaim.getClaimOriginator());
//        refundClaimInputType.setClaimOfficer(dfinRefundClaim.getClaimOfficer());
//        return refundClaimInputType;
//        
//    }
//    
//     public InstalmentAgreementInputType getInstalmentAgreementData(BaseModelObject pojo) {
//        if (pojo == null)
//            return null;
//        DfinInstalmentAgreement revDeferment = (DfinInstalmentAgreement)pojo;
//        InstalmentAgreementInputType revenueDefermentInputType = 
//            new InstalmentAgreementInputType();
//        revenueDefermentInputType.setId(revDeferment.getId());
//        revenueDefermentInputType.setAgreementNumber(revDeferment.getAgreementNumber());
//        revenueDefermentInputType.setCreatedBy(revDeferment.getCreatedBy());
//        revenueDefermentInputType.setCreatedDate(DateHelper.getCalendar(revDeferment.getCreatedDate()));
//        revenueDefermentInputType.setCancelDate(DateHelper.getCalendar(revDeferment.getCancelDate()));
//        revenueDefermentInputType.setCancelReason(revDeferment.getCancelReason());
//        revenueDefermentInputType.setCancellationNotes(revDeferment.getCancellationNotes());
//
//        revenueDefermentInputType.setAgreementDate(DateHelper.getCalendar(revDeferment.getAgreementDate()));
//        revenueDefermentInputType.setFirstInstallmentDueDate(DateHelper.getCalendar(revDeferment.getFirstInstallmentDueDate()));
//        revenueDefermentInputType.setAgreementAmount(revDeferment.getAgreementAmount());
//        revenueDefermentInputType.setPeriodId(revDeferment.getAccPeriod());
//        revenueDefermentInputType.setReason(revDeferment.getReason());
//        revenueDefermentInputType.setNotes(revDeferment.getNotes());
//        revenueDefermentInputType.setAccountId(revDeferment.getAccAccount());
//        
//        if(revDeferment.getInstalmentAgreementStatus()!=null){
//            revenueDefermentInputType.setDefermentStatus(revDeferment.getInstalmentAgreementStatus().getDescription());    
//        } else 
//            revenueDefermentInputType.setDefermentStatus(revDeferment.getAgreementStatus());
//        
//        revenueDefermentInputType.setNumberOfInstalments(revDeferment.getNumberOfInstalments());
//        revenueDefermentInputType.setPaymentSpread(revDeferment.getPaymentSpread());
//        revenueDefermentInputType.setInterestTypes(revDeferment.getInterestType());
//        revenueDefermentInputType.setInterestRate(revDeferment.getInterestRate());
//        revenueDefermentInputType.setTotalInterestPayable(revDeferment.getTotalInterest());
//        
//        revenueDefermentInputType.setPaymentStatus(revDeferment.getPaymentStatus());
//        revenueDefermentInputType.setApplicationDate(DateHelper.getCalendar(revDeferment.getApplicationDate()));
//        
//        revenueDefermentInputType.setReturnType(revDeferment.getReturnType());
//        revenueDefermentInputType.setEntityID(revDeferment.getEntityId());
//        revenueDefermentInputType.setTotalPayable(revDeferment.getTotalAmtPayable());
//        
//        revenueDefermentInputType.setDateOfApproval(DateHelper.getCalendar(revDeferment.getDateOfApproval()));
//        revenueDefermentInputType.setOffice(revDeferment.getOffice());
//        revenueDefermentInputType.setAgreementRejectionReason(revDeferment.getAgreementRejectionReason());
//
//        revenueDefermentInputType.setOutstandingDebts(getOutstandingDebtTypeListFromData(revDeferment.getOutstandingDebts()));
//        revenueDefermentInputType.setInstalmentList(getInstalmentTypeListFromData(revDeferment.getInstalmentList()));
//        revenueDefermentInputType.setRelatedDocuments(getInstalmentRelatedDocsFromData(revDeferment.getInstalAgreementRelatedDocs()));
//        
//        
//        return revenueDefermentInputType;
//     }
//
//
//     public DfinInstalmentAgreement setInstalmentAgreementData(BaseModelObject pojo, InputType type) {
//
//         if (type == null)
//             return null;
//         DfinInstalmentAgreement revDeferment = 
//             pojo == null ? new DfinInstalmentAgreement() : (DfinInstalmentAgreement)pojo;
//         InstalmentAgreementInputType revenueDefermentInputType = 
//             (InstalmentAgreementInputType)type;
//         revDeferment.setId(revenueDefermentInputType.getId());
//         revDeferment.setCreatedBy(revenueDefermentInputType.getCreatedBy());
//         revDeferment.setCreatedDate(DateHelper.getSqlTimestamp(revenueDefermentInputType.getCreatedDate()));
//         revDeferment.setCancelDate(DateHelper.getSqlTimestamp(revenueDefermentInputType.getCancelDate()));
//         revDeferment.setCancelReason(revenueDefermentInputType.getCancelReason());
//         revDeferment.setCancellationNotes(revenueDefermentInputType.getCancellationNotes());
//         revDeferment.setAgreementDate(DateHelper.getSqlTimestamp(revenueDefermentInputType.getAgreementDate()));
//         revDeferment.setFirstInstallmentDueDate(DateHelper.getSqlTimestamp(revenueDefermentInputType.getFirstInstallmentDueDate()));
//         revDeferment.setAgreementAmount(revenueDefermentInputType.getAgreementAmount());
//         revDeferment.setAccPeriod(revenueDefermentInputType.getPeriodId());
//         revDeferment.setReason(revenueDefermentInputType.getReason());
//         revDeferment.setNotes(revenueDefermentInputType.getNotes());
//         revDeferment.setAccAccount(revenueDefermentInputType.getAccountId());
//         revDeferment.setAgreementStatus(revenueDefermentInputType.getDefermentStatus());
//         revDeferment.setNumberOfInstalments(revenueDefermentInputType.getNumberOfInstalments());
//         revDeferment.setPaymentSpread(revenueDefermentInputType.getPaymentSpread());
//         revDeferment.setInterestType(revenueDefermentInputType.getInterestTypes());
//         revDeferment.setInterestRate(revenueDefermentInputType.getInterestRate());
//         revDeferment.setTotalInterest(revenueDefermentInputType.getTotalInterestPayable());
//
//         revDeferment.setCreatedBy(revenueDefermentInputType.getCreatedBy());
//         revDeferment.setUpdatedBy(revenueDefermentInputType.getUpdatedBy());
//
//         revDeferment.setPaymentStatus(revenueDefermentInputType.getPaymentStatus());
//         
//         revDeferment.setReturnType(revenueDefermentInputType.getReturnType());
//         revDeferment.setEntityId(revenueDefermentInputType.getEntityID());
//         revDeferment.setTotalAmtPayable(revenueDefermentInputType.getTotalPayable());
//         revDeferment.setDateOfApproval(DateHelper.getSqlTimestamp(revenueDefermentInputType.getDateOfApproval()));
//         revDeferment.setOffice(revenueDefermentInputType.getOffice());
//         revDeferment.setAgreementRejectionReason(revenueDefermentInputType.getAgreementRejectionReason());
//
//         revDeferment.setApplicationDate(DateHelper.getSqlTimestamp(revenueDefermentInputType.getApplicationDate()));
//
//         setAssociationData(revDeferment, revenueDefermentInputType.getOutstandingDebts(),
//                     revDeferment.getOutstandingDebts(), getInstalmentOutstandingDebtsAssociationHelper());
//                     
//         setAssociationData(revDeferment, revenueDefermentInputType.getInstalmentList(),
//                     revDeferment.getInstalmentList(), getInstalmentAgreementInstalmentAssociationHelper());  
//                     
//         setAssociationData(revDeferment, revenueDefermentInputType.getRelatedDocuments(),
//                     revDeferment.getInstalAgreementRelatedDocs(), getInstalmentAgreementRelatedDocsAssociationHelper());  
//
//         return revDeferment;
//     }
//
//
//
//    public OutstandingDebtType getOutstandingDebtTypeData(InstalAgreementOutstandingDebts outstandingDebt){
//        OutstandingDebtType outstandingDebtType = new OutstandingDebtType();
//
//        outstandingDebtType.setId(outstandingDebt.getId());
//        outstandingDebtType.setCreatedBy(outstandingDebt.getCreatedBy());         
//        outstandingDebtType.setCreatedDate(DateHelper.getCalendar(outstandingDebt.getCreatedDate()));
//
//        outstandingDebtType.setReturnType(outstandingDebt.getReturnType());
//        outstandingDebtType.setPeriod(outstandingDebt.getPeriodId());
//        outstandingDebtType.setDebtAmount(outstandingDebt.getDebtAmount());
//        outstandingDebtType.setInterestAmount(outstandingDebt.getInterestAmount());
//        outstandingDebtType.setNotes(outstandingDebt.getNotes());
//        
//        if(outstandingDebt.getRefReturnType()!=null){
//            outstandingDebtType.setReturnForDisplay(outstandingDebt.getRefReturnType().getDescription());
//        }
//        if(outstandingDebt.getAccountPeriod()!=null){
//            outstandingDebtType.setPeriodForDisplay(outstandingDebt.getAccountPeriod().getPeriodNo()+"/"+outstandingDebt.getAccountPeriod().getPeriodYear());
//        }
//
//        return outstandingDebtType;
//    }
//
//     public InstalmentType getInstalmentTypeData(AgreementInstalments revenueDefermentInstalment){
//         InstalmentType instalmentType = new InstalmentType();
//
//         instalmentType.setId(revenueDefermentInstalment.getId());
//         instalmentType.setStatus(revenueDefermentInstalment.getStatus());
//         instalmentType.setCreatedBy(revenueDefermentInstalment.getCreatedBy());         
//         instalmentType.setCreatedDate(DateHelper.getCalendar(revenueDefermentInstalment.getCreatedDate()));
//
//         instalmentType.setDueDate(DateHelper.getCalendar(revenueDefermentInstalment.getDueDate()));
//         instalmentType.setInstalmentAmount(revenueDefermentInstalment.getInstalmentAmount());
//         instalmentType.setInstalmentNumber(revenueDefermentInstalment.getInstalmentNumber());
//         instalmentType.setPeriod(revenueDefermentInstalment.getPeriodId());
//         instalmentType.setInstalmentStatus(revenueDefermentInstalment.getInstalmentStatus());
//
//         instalmentType.setComputedInterest(revenueDefermentInstalment.getInstalmentInterest());
//
//         return instalmentType;
//     }
//     
//    public AgreementRelatedDocumentsInputType getInstalmentRelateDocumentData(InstalAgreementRelatedDocs relatedDocs){
//        AgreementRelatedDocumentsInputType relatedDocumentInputType = new AgreementRelatedDocumentsInputType();
//
//          relatedDocumentInputType.setId(relatedDocs.getId());
//          relatedDocumentInputType.setAgreementId(relatedDocs.getInstalmentAgreement().getId());
//          relatedDocumentInputType.setDocumentId(relatedDocs.getDocumentId());
//          relatedDocumentInputType.setDocumentBalance(relatedDocs.getDocumentBalance());
//          relatedDocumentInputType.setPeriod(relatedDocs.getPeriodDisplay());
//
//        return relatedDocumentInputType;
//    }
//
//     /**
//      * This method takes the parameters of AgreementInstalments, InstalmentType
//      * and sets the data accordingly from the input type to AgreementInstalments entity
//      * and returns the same. 
//      * <br>
//      * @param revenueDefermentInstalment 
//      * @param instalmentType
//      * @return AgreementInstalments revenueDefermentInstalment
//      */
//      
//     public AgreementInstalments setInstalmentAgreementInstalmentData(AgreementInstalments revenueDefermentInstalment, InstalmentType instalmentType) {
//         if (instalmentType==null) return null;
//         if(revenueDefermentInstalment == null) revenueDefermentInstalment = new AgreementInstalments();
//     //        revenueDefermentInstalment.setId(instalmentType.getId());
//         revenueDefermentInstalment.setStatus(instalmentType.getStatus());
//         
//         revenueDefermentInstalment.setDueDate(DateHelper.getSqlTimestamp(instalmentType.getDueDate()));
//         revenueDefermentInstalment.setInstalmentAmount(instalmentType.getInstalmentAmount());
//         revenueDefermentInstalment.setInstalmentNumber(instalmentType.getInstalmentNumber());
//         revenueDefermentInstalment.setInstalmentStatus(instalmentType.getInstalmentStatus());
//         revenueDefermentInstalment.setPeriodId(instalmentType.getPeriod());
//         
//         setCommonFieldsFromInputTypeToPojo(revenueDefermentInstalment,instalmentType); 
//         
//         revenueDefermentInstalment.setInstalmentInterest(instalmentType.getComputedInterest());
//         
//         return revenueDefermentInstalment;
//     }
//     
//    public InstalAgreementOutstandingDebts setInstalmentOutstandingDebtData(InstalAgreementOutstandingDebts outstandingDebt, OutstandingDebtType outstandingDebtType) {
//        if (outstandingDebtType==null) return null;
//        if(outstandingDebt == null) outstandingDebt = new InstalAgreementOutstandingDebts();
//
//        outstandingDebt.setDebtAmount(outstandingDebtType.getDebtAmount());
//        outstandingDebt.setInterestAmount(outstandingDebtType.getInterestAmount());
//        outstandingDebt.setNotes(outstandingDebtType.getNotes());
//        outstandingDebt.setPeriodId(outstandingDebtType.getPeriod());
//        outstandingDebt.setReturnType(outstandingDebtType.getReturnType());
//        
//        setCommonFieldsFromInputTypeToPojo(outstandingDebt,outstandingDebtType); 
//        
//        return outstandingDebt;
//    }
//     
//    public InstalAgreementRelatedDocs setInstalmentAgreementRelatedDocsData(InstalAgreementRelatedDocs instalAgreementRelatedDoc, AgreementRelatedDocumentsInputType relatedDocumentsInputType) {
//        if (relatedDocumentsInputType==null) return null;
//        if(instalAgreementRelatedDoc == null) instalAgreementRelatedDoc = new InstalAgreementRelatedDocs();
//        instalAgreementRelatedDoc.setDocumentId(relatedDocumentsInputType.getDocumentId());
//        instalAgreementRelatedDoc.setDocumentBalance(relatedDocumentsInputType.getDocumentBalance());
//        instalAgreementRelatedDoc.setPeriodDisplay(relatedDocumentsInputType.getPeriod());
//        
//        setCommonFieldsFromInputTypeToPojo(instalAgreementRelatedDoc,relatedDocumentsInputType); 
//        
//        return instalAgreementRelatedDoc;
//    }
//     
//    private OutstandingDebtType[] getOutstandingDebtTypeListFromData(Collection<InstalAgreementOutstandingDebts> objectList) {
//        ArrayList<OutstandingDebtType> listToReturn = new ArrayList<OutstandingDebtType>();
//        if (objectList != null && objectList.size() > 0) {
//            for (InstalAgreementOutstandingDebts obj: objectList) {
//                if (obj != null) {
//                    listToReturn.add(getOutstandingDebtTypeData(obj));
//                }
//            }
//        }
//        return listToReturn.toArray(new OutstandingDebtType[listToReturn.size()]);
//    }
//
//      private InstalmentType[] getInstalmentTypeListFromData(Collection<AgreementInstalments> objectList) {
//          ArrayList<InstalmentType> listToReturn = new ArrayList<InstalmentType>();
//          if (objectList != null && objectList.size() > 0) {
//              for (AgreementInstalments obj: objectList) {
//                  if (obj != null) {
//                      listToReturn.add(getInstalmentTypeData(obj));
//                  }
//              }
//          }
//          return listToReturn.toArray(new InstalmentType[listToReturn.size()]);
//      }
      
//    private AgreementRelatedDocumentsInputType[] getInstalmentRelatedDocsFromData(List<InstalAgreementRelatedDocs> objectList) {
//        ArrayList<AgreementRelatedDocumentsInputType> listToReturn = new ArrayList<AgreementRelatedDocumentsInputType>();
//        if (objectList != null && objectList.size() > 0) {
//            for (InstalAgreementRelatedDocs obj: objectList) {
//                if (obj != null) {
//                     listToReturn.add(getInstalmentRelateDocumentData(obj));
//                }
//            }
//        }
//        return listToReturn.toArray(new AgreementRelatedDocumentsInputType[listToReturn.size()]);
//    }
//    
//    public ComplexAssociationHelper getInstalmentOutstandingDebtsAssociationHelper(){
//       return  new ComplexAssociationHelper(){
//             public void add(BaseModelObject parent, BaseModelObject child){
//                 if(((DfinInstalmentAgreement)parent).getOutstandingDebts() == null){
//                     ((DfinInstalmentAgreement)parent).setOutstandingDebts(new ArrayList<InstalAgreementOutstandingDebts>());
//                 }
//                 
//                 ((DfinInstalmentAgreement)parent).addOutstandingDebt((InstalAgreementOutstandingDebts)child);
//                 
//             }
//             
//             public void remove(BaseModelObject parent,BaseModelObject child){
//                 ((DfinInstalmentAgreement)parent).removeOutstandingDebt((InstalAgreementOutstandingDebts)child);
//             }
//             
//             public Class getChildPojoClass() {
//                 return InstalAgreementOutstandingDebts.class;
//             }
//             
//             public Class getMessageHelperClass(){
//                 return DfinDocumentMessageHelper.class;
//             }
//             
//             public void setData(InputType messageChild, BaseModelObject newChildPojo, MessageHelper messageHelper) {
//                 ((DfinDocumentMessageHelper)messageHelper).
//                     setInstalmentOutstandingDebtData((InstalAgreementOutstandingDebts)newChildPojo, (OutstandingDebtType)messageChild);
//             }
//             
//             public Boolean compare(InputType messageChild, BaseModelObject pojo){                
//                 if(messageChild.getId() == null || ((InstalAgreementOutstandingDebts)pojo).getId() == null){
//                     return null;//return null because cannot compare
//                 }else{
//                     return messageChild.getId().equals(((InstalAgreementOutstandingDebts)pojo).getId());
//                 }
//             }
//         };        
//    }
//
//     public ComplexAssociationHelper getInstalmentAgreementInstalmentAssociationHelper(){
//        return  new ComplexAssociationHelper(){
//              public void add(BaseModelObject parent, BaseModelObject child){
//                  if(((DfinInstalmentAgreement)parent).getInstalmentList() == null){
//                      ((DfinInstalmentAgreement)parent).setInstalmentList(new ArrayList<AgreementInstalments>());
//                  }
//                  
//                  ((DfinInstalmentAgreement)parent).addAgreementInstalment((AgreementInstalments)child);
//                  
//              }
//              
//              public void remove(BaseModelObject parent,BaseModelObject child){
//                  ((DfinInstalmentAgreement)parent).removeAgreementInstalment((AgreementInstalments)child);
//              }
//              
//              public Class getChildPojoClass() {
//                  return AgreementInstalments.class;
//              }
//              
//              public Class getMessageHelperClass(){
//                  return DfinDocumentMessageHelper.class;
//              }
//              
//              public void setData(InputType messageChild, BaseModelObject newChildPojo, MessageHelper messageHelper) {
//                  ((DfinDocumentMessageHelper)messageHelper).
//                      setInstalmentAgreementInstalmentData((AgreementInstalments)newChildPojo, (InstalmentType)messageChild);
//              }
//              
//              public Boolean compare(InputType messageChild, BaseModelObject pojo){                
//                  if(messageChild.getId() == null || ((AgreementInstalments)pojo).getId() == null){
//                      return null;//return null because cannot compare
//                  }else{
//                      return messageChild.getId().equals(((AgreementInstalments)pojo).getId());
//                  }
//              }
//          };        
//     }
//     
//    public ComplexAssociationHelper getInstalmentAgreementRelatedDocsAssociationHelper(){
//       return  new ComplexAssociationHelper(){
//             public void add(BaseModelObject parent, BaseModelObject child){
//                 if(((DfinInstalmentAgreement)parent).getInstalAgreementRelatedDocs() == null){
//                     ((DfinInstalmentAgreement)parent).setInstalAgreementRelatedDocs(new ArrayList<InstalAgreementRelatedDocs>());
//                 }
//                 
//                 ((DfinInstalmentAgreement)parent).addInstalmentAgreementRelatedDocument((InstalAgreementRelatedDocs)child);
//                 
//             }
//             
//             public void remove(BaseModelObject parent,BaseModelObject child){
//                 ((DfinInstalmentAgreement)parent).removeInstalmentAgreementRelatedDocument((InstalAgreementRelatedDocs)child);
//             }
//             
//             public Class getChildPojoClass() {
//                 return InstalAgreementRelatedDocs.class;
//             }
//             
//             public Class getMessageHelperClass(){
//                 return DfinDocumentMessageHelper.class;
//             }
//             
//             public void setData(InputType messageChild, BaseModelObject newChildPojo, MessageHelper messageHelper) {
//                 ((DfinDocumentMessageHelper)messageHelper).
//                     setInstalmentAgreementRelatedDocsData((InstalAgreementRelatedDocs)newChildPojo, (AgreementRelatedDocumentsInputType)messageChild);
//             }
//             
//             public Boolean compare(InputType messageChild, BaseModelObject pojo){                
//                 if(messageChild.getId() == null || ((InstalAgreementRelatedDocs)pojo).getId() == null){
//                     return null;//return null because cannot compare
//                 }else{
//                     return messageChild.getId().equals(((InstalAgreementRelatedDocs)pojo).getId());
//                 }
//             }
//         };        
//    }
    
//    public  DfinManualPenalty setPenaltyData(BaseModelObject pojo, InputType type) {
//                                                                 
//        DfinManualPenalty manualPenalty = pojo == null ? new DfinManualPenalty() : (DfinManualPenalty)pojo;
//        PenaltyInputType penaltyInput = (PenaltyInputType)type;
//
//        manualPenalty.setAmount(penaltyInput.getAmount());
//        manualPenalty.setPenaltyCode(penaltyInput.getPenaltyCode());
//        manualPenalty.setRevenueLedgerCode(penaltyInput.getRevenueLedgerCode());
//        manualPenalty.setEntityId(penaltyInput.getEntityId());
//        manualPenalty.setTaxType(penaltyInput.getTaxType());
//        manualPenalty.setReturnType(penaltyInput.getReturnType());
//        manualPenalty.setNotes(penaltyInput.getNotes());
//        manualPenalty.setPenaltyDate(DateHelper.getSqlTimestamp(penaltyInput.getPenaltyDate()));
//        manualPenalty.setLegalReference(penaltyInput.getLegalReference());
//        manualPenalty.setAuthorisedBy(penaltyInput.getAuthorisedBy());
//        manualPenalty.setTin(penaltyInput.getTin());
//        manualPenalty.setId(penaltyInput.getId());
//        return manualPenalty;
//    } 
//    
//    public PenaltyInputType getPenaltyInputTypeData(BaseModelObject pojo) {                                                             
//        DfinManualPenalty manualPenalty = (DfinManualPenalty)pojo;
//        PenaltyInputType penaltyInputType = new PenaltyInputType();
//       
//        penaltyInputType.setTin(manualPenalty.getTin());
//        penaltyInputType.setTaxType(manualPenalty.getTaxType());
//        penaltyInputType.setReturnType(manualPenalty.getReturnType());
//        penaltyInputType.setPenaltyCode(manualPenalty.getPenaltyCode());
//        penaltyInputType.setLegalReference(manualPenalty.getLegalReference());
//        penaltyInputType.setAmount(manualPenalty.getAmount());
//        penaltyInputType.setNotes(manualPenalty.getNotes());   
//        penaltyInputType.setPenaltyDate(DateHelper.getCalendar(manualPenalty.getPenaltyDate()));
//        penaltyInputType.setAuthorisedBy(manualPenalty.getAuthorisedBy());
//        penaltyInputType.setEntityId(manualPenalty.getEntityId());
//        penaltyInputType.setRevenueLedgerCode(manualPenalty.getRevenueLedgerCode());
//        penaltyInputType.setId(manualPenalty.getId());        
//        return penaltyInputType;
//    } 
    
}
