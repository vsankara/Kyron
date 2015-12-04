package com.technobrain.trips.revenueaccount.service;

//import com.crownagents.trips.collection.message.BatchPaymentInputType;
//import com.crownagents.trips.collection.message.PaymentInputType;
import com.technobrain.trips.core.service.FacadeLocal;
import com.technobrain.trips.document.model.DfinRevCollInstrument;
import com.technobrain.trips.document.model.DfinRevCollReceipt;
import com.technobrain.trips.dto.tax.accounting.GenericRegimePeriodSummaryBean;
import com.technobrain.trips.dto.tax.accounting.RegimeSummary;
import com.technobrain.trips.reference.model.RefDocTypeReturnTypeRel;
import com.technobrain.trips.revenueaccount.model.AccChartOfAccounts;
import com.technobrain.trips.revenueaccount.model.AccRevLedAccount;
import com.technobrain.trips.revenueaccount.model.RevComplianceConfiguration;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.Local;


@Local
public interface RevenueAccountFacadeLocal extends FacadeLocal{
    
    /**
     * Finds the regime sumary for an entity
     * @param entityPrimaryKey
     * @return
     */
    public List<RegimeSummary> findEntityRegimeSummaryFor(Long entityPrimaryKey);
    
    public DfinRevCollReceipt findPaymentReceipt(Long receiptId);

    public Long findEntityAccountIdByAccountNbr(String acctNo);
    
    public List findPossibleRevenueAccountIds(Long entityId, String revenueType) throws NoSuchMethodException;
    
    public Long findEntityIdByAccountID(Long accountId);

    public RevComplianceConfiguration findActionFromComplianceConfiguration(String revType, 
                                                      String complianceType, String legalStatus, boolean isToAddLegalStatus) ;    
//    public ComplianceConfigurationInputType findComplianceConfigurationInputType(Long id);
    
    public boolean checkExistingComplianceConfiguration(String complianceType, String taxpayerType, String revType);

    public boolean isPeriodicRegime(String regime);

    public String findRevenueMode(String regime);
    
    public boolean isReceiptNumberAlreadyUsed(String receiptNumber);

//    public void updateReceiptWithEntity(Long entityID, 
//                                        PaymentInputType paymentInputType) ;

    public DfinRevCollReceipt findReceiptIdByTrans(Long transactionId);
    
//    public boolean isBatchAlreadyUsed(BatchPaymentInputType batchPaymentInputType);
    
    public List<DfinRevCollInstrument> findCollInstrumentsdByTdmNumber(String tdmNumber);
    
    public Object findRevAccByFormType(Long entityId, String formType);

    /** Code Block  Needed  for Ghana Start**/
    public List<GenericRegimePeriodSummaryBean> findRegimePeriodSummaryList(Long accountId); 
    
    public List<AccChartOfAccounts> findAllAccChartOfAccounts();
    
    public String removeAccounts(List<AccChartOfAccounts> removalList);
    
    public List<GenericRegimePeriodSummaryBean> findPeriodsOnRegimeandEntityId(String regime, Long entityId, String returnType);
    
    public List<GenericRegimePeriodSummaryBean> findActivePeriodsOnRegimeandEntityId(String regime, Long entityId, String returnType);
    
    
    public List<GenericRegimePeriodSummaryBean> findPeriodsOnRegimeandEntityIdUptoCurrentDate(String regime, Long entityId, String returnType);
                                             
    public AccRevLedAccount findRevenueLedgerAccount(String accRevLedRevenueType,
                                                     String accRevLedBusSect,
                                                     String accRevLedDocType,
                                                     String accRevLedChargeType,
                                                     String accRevLedTaxpayerType,
                                                     String accRevLedSubTaxCategoryL1,
                                                     String accRevLedSubTaxCategoryL2);
    
    /** Code Block  Needed  for Ghana End**/

    public AccRevLedAccount findLedgerAccountByRevenueType(String revenueType);
    public AccRevLedAccount findLedgerAccountByCode(String accountCode);
    
    public RefDocTypeReturnTypeRel findRefDocTypeRetTypeRelByFormName(String formName);
    
    public BigDecimal findAccountBalance(String regimeType, Long entId); 
}