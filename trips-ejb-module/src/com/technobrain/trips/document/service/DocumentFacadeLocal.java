package com.technobrain.trips.document.service;

import com.technobrain.trips.account.model.AccountPeriod;
//import com.crownagents.trips.collection.message.PaymentInputType;
import com.technobrain.trips.core.message.DdocDocumentInputType;
import com.technobrain.trips.core.message.DocumentHeaderType;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.service.FacadeLocal;
import com.technobrain.trips.document.model.DdocBalananceView;
import com.technobrain.trips.document.model.DdocCurrencyAndRate;
import com.technobrain.trips.document.model.DdocDocument;
import com.technobrain.trips.document.model.DdocDocumentError;
import com.technobrain.trips.document.model.DdocDocumentLink;
import com.technobrain.trips.document.model.DdocEntityDocRel;
import com.technobrain.trips.document.model.DdocHistory;
import com.technobrain.trips.document.model.DdocInspection;
import com.technobrain.trips.document.model.DdocInstruction;
import com.technobrain.trips.document.model.DdocItemLink;
import com.technobrain.trips.document.model.DdocNotes;
import com.technobrain.trips.document.model.DdocTransactionSummaryView;
import com.technobrain.trips.document.model.DfinRevCollReceipt;
import com.technobrain.trips.document.model.DitemItem;
import com.technobrain.trips.document.model.DtaxHeader;
import com.technobrain.trips.document.model.DtaxItem;
import com.technobrain.trips.dto.CodeAndDescription;
import com.technobrain.trips.dto.registration.EntityHistory;
import com.technobrain.trips.dto.tax.accounting.GenericRegimeDocumentSummaryBean;
import com.technobrain.trips.dto.tax.accounting.PaymentSummaryInquiry;
import com.technobrain.trips.dto.tax.accounting.TaxCreditRefundSummaryBean;
import com.technobrain.trips.dto.tax.release.ProcessRefundApplyToSummaryBean;
import com.technobrain.trips.reference.model.RefOffice;
//import com.crownagents.trips.reports.message.ReportsInputType;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;

//import com.crownagents.trips.returns.model.DfinAssessment;


@Local
public interface DocumentFacadeLocal extends FacadeLocal {
    List<DdocDocument> queryDdocDocumentFindAll();

    void removeDdocDocument(DdocDocument ddocDocument);

    List<DdocDocumentError> queryDdocDocumentErrorFindAll();

    void removeDdocDocumentError(DdocDocumentError ddocDocumentError);

    List<DdocDocumentLink> queryDdocDocumentLinkFindAll();

    void removeDdocDocumentLink(DdocDocumentLink ddocDocumentLink);

    List<DdocEntityDocRel> queryDdocEntityDocRelFindAll();

    void removeDdocEntityDocRel(DdocEntityDocRel ddocEntityDocRel);

    List<DdocHistory> queryDdocHistoryFindAll();

    void removeDdocHistory(DdocHistory ddocHistory);

    List<DdocInspection> queryDdocInspectionFindAll();

    void removeDdocInspection(DdocInspection ddocInspection);

    List<DdocInstruction> queryDdocInstructionFindAll();

    void removeDdocInstruction(DdocInstruction ddocInstruction);

    List<DdocItemLink> queryDdocItemLinkFindAll();

    void removeDdocItemLink(DdocItemLink ddocItemLink);

    List<DitemItem> queryDitemItemFindAll();

    void removeDitemItem(DitemItem ditemItem);

    List<DtaxHeader> queryDtaxHeaderFindAll();

    void removeDtaxHeader(DtaxHeader dtaxHeader);

    List<DtaxItem> queryDtaxItemFindAll();

    List<DtaxItem> queryDtaxItemByItem(Long dItem);

    void removeDtaxItem(DtaxItem dtaxItem);

    List<CodeAndDescription> findDocumentErrors(Long id);

    List<EntityHistory> findEntityHistory(Long id);

    public DdocInspection findDocumentInspectionById(Long id);

    void deleteHeaderTaxes(Long id);

    void deleteItemTaxes(Long id);
//TODO - RevAccCleanup
//    public RevAcc findRevAccByEntEntityId(Object entEntity,Object accNo) throws ObjectNotFoundException;

//    public PaymentInputType findPaymentReceipt(Long transId);

    public Long findDeclarationIDByRevInvoice(Long revInvoiceId);

    public String findDeclarationByCustRef(String referenceNumber);

//    List<DfinRefundClaim> queryDfinRefundClaimFindAll();

//    void removeDfinRefundClaim(DfinRefundClaim dfinRefundClaim);
//TODO - RevAccCleanup
//    public List<RevAcc> findRevAccByTypeAndStatus(Object revenueType) throws ObjectNotFoundException;

    public List findRevledRevPeriodByRevAccId(Long revAccId, Integer periodNo, 
                                              String periodYear) throws ObjectNotFoundException;

    public Long findArrayIdFromDitemItem(DdocDocument documentId, 
                                         Long ItemRef);

    public List<DdocNotes> findDocumentNotes(Long id);

    public void deleteNotes(DdocNotes docNotes);

    public DocumentHeaderType getDocumentHeaderType(Long periodId, 
                                                    Long accountId);

    //    public List<RevledTransaction> findPaymentSpread(Long docID);

    public String findDeclarationRefByDecId(Long decId);

    //public List<TaxRefunds> findRefundByRefundId(Long refundId);

    //public List<TaxRefunds> findRefundsByEntityIdAndStatus(Long entityId, 
    //                                                       String docStatus);

    public DtaxItem findTaxByItemAndCode(Long itemId, String taxCode);

    public String deleteItemTaxes(Long id, String code);

//TODO - RevledRevPeriod/RevledTransactionCleanup
//    public RevledRevPeriod findApplicablePeriodNumber(Long taxpayerId, 
//                                                      String taxType, 
//                                                      Calendar submissionDate);
//TODO - RevledRevPeriod/RevledTransactionCleanup
//    public ApplyInformationOutputType applyInformation(AccountInputType accountInputType);

    public DdocDocument findDocumentByPeriodAndAccount(Long periodId, 
                                                       Long accountId);

//    public DdocDocument generateDocument(ReportsInputType reportInput, 
//                                 Long documentManagmentId);

    public boolean computeExcessPayments(Long entityId, String taxType, Timestamp startDate, Timestamp endDate);

    public void setErrorToResolved(DdocDocumentError error);

//    public List<DdocDocumentError> findErrorsOn(PaymentInputType paymentInputType);
//
//    public void setReceiptAsNew(PaymentInputType paymentInputType);
//
//    public PaymentInputType findPaymentReceiptByTrans(Long transactionId);

    public Long findEntityIdForReceipt(Long receipt);

    public List<PaymentSummaryInquiry> findPaymentsByEntityIdAndStatus(Long entityId, 
                                                                       String status);

    public List<PaymentSummaryInquiry> findPaymentsByPeriod(Long entityId, 
                                                            String status, 
                                                            Timestamp startDate, 
                                                            Timestamp endDate);

    public boolean isBadCheque(String chequeNumber);

//    public List<DfinRefundClaim> findDfinRefundClaimByRevIDTaxTypeAndReturnPeriod(Long revID, 
//                                                                                  String taxType, 
//                                                                                  Timestamp startDate,
//                                                                                  Timestamp endDate);

//TODO - RevledRevPeriod/RevledTransactionCleanup
//    public String findFormTypeForRefundClaim(Long entityId, String taxType, Timestamp startDate, Timestamp endDate);

    public BaseModelObject saveChequeNote(InputType type);

    public Object queryFindById(Class entity, Object id);

    public TaxCreditRefundSummaryBean findTCCDetails(String transRef);

    

    public List<ProcessRefundApplyToSummaryBean> listSubordinatesOfRegion(String regionCode);
    
    //public RefundClaimInputType queryFindRefundClaimById(Long id);
    
//    public DfinRefundClaim findDfinRefundClaimByDocumentRef(String refundClaimNumber);

    public List<DdocDocumentError> findDocumentErrorsOnForm(Long formId, 
                                                            String formType) ;
                                                            
    //public CaseInputType createAuditRefundCase(RefundClaimInputType refundInputType, String office);
   
    public String validateTaskAuthority(BigDecimal amount, String userName, String permission);
//TODO - RevledRevPeriod/RevledTransactionCleanup    
//    public List<RevledTransaction> getRevledTransactionsByEntityIdTaxTypeAndPeriodRange(Long entityId, String taxType, Timestamp startDate, Timestamp endDate);

    public RefOffice getOfficeByRDO(String selectedRDO);

    public String getOfficeBySubOffice(String selectedRDO);

    public List<CodeAndDescription> getUsersByOfficeByLastName(String rdo); 
                                    
    public boolean checkIfTaxpayerHasFraudCase(Long entityId);
    //TODO - RevledRevPeriod/RevledTransactionCleanup    
//    public boolean checkIfRefundClaimEqualsPayment(Long entityId, BigDecimal claimAmount, String taxType, Timestamp startDate, Timestamp endDate);
    
   // public DfinRefundClaim maintainRefundClaims(RefundClaimInputType refundClaimInputType);
    //TODO - RevledRevPeriod/RevledTransactionCleanup    
//    public boolean checkIfRefundClaimEqualsPaymentMinusReturn(Long entityId, BigDecimal claimAmount, String taxType, Timestamp startDate, Timestamp endDate);
    
    public DdocDocument findDocumentById(Long id);
    
//    public List<DfinAssessment> findAssessmentDetails(Long transId);
    //TODO - RevledRevPeriod/RevledTransactionCleanup
//    public Timestamp getReturnFilingDate(Long entityId, String taxType, Long periodId);
//TODO - RevledRevPeriodCleanup    
//    public List<SystemMessage> validateRefundClaimDetails(RefundClaimInputType refundClaimInputType);
    
   // public OpsCase createAuditRefundCase(CaseInputType caseInputType);
    
   // public OpsCase getCaseDetailsByEntityIdCaseTypeTaxTypeAndPeriodRange(Long entityId, String caseType, String taxType, Timestamp periodFrom, Timestamp periodTo);
    
//    public DfinRefundClaim saveOrUpdateRefundClaims(RefundClaimInputType refundClaimInputType);

    public Long findFlexibleFormId(Long documentId);

    public String findDocumentType(Long documentId);
    
  
    //TODO - RevledRevPeriod/RevledTransactionCleanup
//    public Long findRevIDByEntityIdRevTypeAndPeriodID(Long entityId, String revType, Long periodID);
    
    public Long findRevIDByEntityIdAndRevType(Long entityId, String revType);
    
    public List<AccountPeriod> findPeriodByPeriodRangeAndRevId(Timestamp startDate, Timestamp endDate, Long revId);
//TODO - RevledRevPeriod/RevledTransactionCleanup    
//    public List<RevledTransaction> getRevledTransactionsForErroneousAndDoublePayment(Long entityId, String taxType, Timestamp startDate, Timestamp endDate);
//TODO - RevAccCleanup
//    public Long generatePeriod(PeriodType periodType) throws Exception;
//TODO - RevledRevPeriodCleanup        
//    public Long autoGeneratePeriod(PeriodType periodType);
    
    
    public DdocDocumentInputType findDfinDdocDocumentInputType(Long id);
 
 
    //Copied from Cayman-Start
    List<GenericRegimeDocumentSummaryBean> findGenericRegimeDocumentSummaries(String accountNo);
    
    public DdocDocument findByDocumentID(Long documentID);
    
    public List<DdocBalananceView> findDDocBalanceByAccoundId(Long accountId);
    
    public List<DdocTransactionSummaryView> findDdocTransactionSummaries(String documentId);
    
    public DdocCurrencyAndRate findDdocCurrencyAndRateByDocId(Long ddocId); 
      
    public List<DdocBalananceView> findDDocBalByDocTypeAndPeriodId(String docType,Long periodId);
    
    public List<DdocBalananceView> findDDocBalByDocTypeAndAccountId(String docType,Long accountId);
    
    public List<Long>   findDocumentIdsByPeriodAndEventType(Long periodId, String  eventType);
   //Copied from Cayman-End
    public DfinRevCollReceipt findDfinRevCollReceiptByReference(String reference);
    
    public List<DdocDocument> findDocumentsByFormName(String formName);
}
