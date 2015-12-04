package com.technobrain.trips.dto.tax.accounting;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.dto.document.DocEventDetails;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;


public class GenericTransactionPeriodBean implements Serializable {
    static final Logger log = Logger.getLogger(GenericTransactionPeriodBean.class);
    private static final String REVERSAL = "Reversal";
    private Long id;
    private boolean periodStatusActive = true;
    private String transReference;
    private String transCurrency;
    private Calendar date;
    private String code;
    private String description;
    private BigDecimal amount;
    private BigDecimal balanceDue;
    private Long revAccId;
    private Long ddocDocument;
    private Calendar dueDate;
    private String revType;
    private String accountNumber;
    private String acctTran;
    private String acctTranSign;
    private String periodLabel;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private GenericRegimePeriodSummaryBean periodSummary;
    private PaymentSummaryInquiry paymentSummaryInquiry;
    private String transactionType;
    private String dtype;
    private String docTypeCode;
    private String chargeType;
    private String docReference;
    private String docStatus;
    private String revenueMode;
    private String transBalForDisplay;
    private BigDecimal balance;
    private List<GenericTransactionPeriodBean> documentTransactionList;
    private String docBalForDisplay;
    private Long periodId;
    private Calendar submissionDate;
    private Long docEventId;
    private String refEventCategoryType;
    private String refEventDescription;
    private String subTaxType;
    private String docTypeDescription;
    private List<DocEventDetails> docEventsList; 
    private Calendar eventDate;
    
    public GenericTransactionPeriodBean() {
    }
   
    public GenericTransactionPeriodBean(Long id,String transReference,String transCurrency,Timestamp transactionDate, String code, BigDecimal amount, BigDecimal balanceDue ,
                                        Long revAccId,Long ddocDocument, String revType, Timestamp paymentDueDate, String accountNumber) {
        try {
            this.id = id;
            this.transCurrency = transCurrency;
            this.transReference = transReference;
            date = toDate(transactionDate);
            this.code = String.valueOf(code);
            description = null;
            this.amount = null != amount ? amount : null;
            this.balanceDue = null != balanceDue ? balanceDue : null;
            this.revAccId = revAccId;
            this.ddocDocument = ddocDocument;
            this.dueDate = DateHelper.getCalendar(paymentDueDate);
            this.revType = revType;
            this.accountNumber = accountNumber;
            
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
    
   
    public GenericTransactionPeriodBean(Long id,String transReference,String transCurrency,Timestamp transactionDate, String code, BigDecimal amount, BigDecimal balanceDue ,
                                        Long revAccId,Long ddocDocument, String revType, Timestamp paymentDueDate, String accountNumber, String acctTran, String acctTranSign) {
        try {
            this.id = id;
            this.transCurrency = transCurrency;
            this.transReference = transReference;
            date = toDate(transactionDate);
            this.code = String.valueOf(code);
            description = null;
            this.amount = null != amount ? amount : null;
            this.balanceDue = null != balanceDue ? balanceDue : null;
            this.revAccId = revAccId;
            this.ddocDocument = ddocDocument;
            this.dueDate = DateHelper.getCalendar(paymentDueDate);
            this.revType = revType;
            this.accountNumber = accountNumber;
            if (acctTran != null) {
                if (acctTran.equalsIgnoreCase(Constants.AccountingType.DEBIT)) {
                    this.debitAmount = amount;
                } else if (acctTran.equalsIgnoreCase(Constants.AccountingType.CREDIT)) {
                    this.creditAmount = amount;
                }
            }
            this.acctTranSign = acctTranSign;
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
    
    
    
    public GenericTransactionPeriodBean(Long id,String transReference,Timestamp transactionDate, String description, String transactionType, 
    BigDecimal amount,BigDecimal balanceDue,String code, String dType, Long ddocId, String docTypeCode,String chargeType) {
    
        try {
            this.id = id;
            this.transReference = transReference;
            date = toDate(transactionDate);
            this.description = description;
            this.amount = null != amount ? amount : null;
            this.balanceDue = null != balanceDue ? balanceDue : null;
            this.transactionType = transactionType;
            this.code = code;
            this.dtype = dType;
            this.ddocDocument=ddocId;
            this.docTypeCode = docTypeCode;
            this.chargeType = chargeType;
        }
        
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
    
    
    
    public GenericTransactionPeriodBean(Long id,String transReference,Timestamp transactionDate, String description, String transactionType, 
    BigDecimal amount,BigDecimal balanceDue,String chargeType,String code, String dType, Long ddocId, String docTypeCode,String docStatus,
    String docReference,String revenueMode, Long eventId, String refEventType, Timestamp eventDate, String refEventDescription, 
    String subTaxType, String docDescription,Long periodId) {
    
        try {
            this.id = id;
            this.transReference = transReference;
            date = toDate(transactionDate);
            this.description = description;
            this.amount = null != amount ? amount : null;
            this.balanceDue = null != balanceDue ? balanceDue : null;
            this.transactionType = transactionType;
            this.code = code;
            this.dtype = dType;
            this.ddocDocument=ddocId;
            this.docTypeCode = docTypeCode;
            this.chargeType = chargeType;
            this.docStatus = docStatus;
            this.docReference = docReference;
            this.revenueMode = revenueMode;
            this.refEventCategoryType = refEventType;
            this.docEventId = eventId;
            this.eventDate=toDate(eventDate);
            this.refEventDescription = refEventDescription;
            this.subTaxType = subTaxType;
            this.docTypeDescription = docDescription;
            this.periodId= periodId;
        }
        
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    
    public GenericTransactionPeriodBean(Long ddocId, String docTypeCode,String docStatus,String docReference,BigDecimal balance,Long periodId) {
    
        try {

            this.ddocDocument=ddocId;
            this.docTypeCode = docTypeCode;
            this.docStatus = docStatus;
            this.docReference = docReference;
            this.balance = balance;
            
        }
        
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
    
    public GenericTransactionPeriodBean(Long periodId, String docTypeCode,String docStatus,String docReference,BigDecimal balanceDue,Long ddocId,Timestamp submissionDate, String docDescription) {
    
        try {
            this.periodId= periodId;
            this.docTypeCode = docTypeCode;
            this.docStatus = docStatus;
            this.docReference = docReference;
            this.balanceDue = balanceDue;
            this.ddocDocument=ddocId;
            this.submissionDate = DateHelper.getCalendar(submissionDate);
            this.docTypeDescription = docDescription;
        }
        
        catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
    /**
     * Converts to a Calendar
     * @param _timestamp
     * @return
     */
    private Calendar toDate(Timestamp _timestamp) {
        if(_timestamp == null)
            return null;
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(_timestamp.getTime()));
        return c;
    }
    
    public void setDate(Calendar date) {
        this.date = date;
    }

    public Calendar getDate() {
        return date;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setBalanceDue(BigDecimal balanceDue) {
        this.balanceDue = balanceDue;
    }

    public BigDecimal getBalanceDue() {
        return balanceDue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRevAccId(Long revAccId) {
        this.revAccId = revAccId;
    }

    public Long getRevAccId() {
        return revAccId;
    }

    public void setDdocDocument(Long ddocDocument) {
        this.ddocDocument = ddocDocument;
    }

    public Long getDdocDocument() {
        return ddocDocument;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setRevType(String revType) {
        this.revType = revType;
    }

    public String getRevType() {
        return revType;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setPeriodSummary(GenericRegimePeriodSummaryBean periodSummary) {
        this.periodSummary = periodSummary;
    }

    public GenericRegimePeriodSummaryBean getPeriodSummary() {
        return periodSummary;
    }

    public void setTransReference(String transReference) {
        this.transReference = transReference;
    }

    public String getTransReference() {
        return transReference;
    }

    public void setTransCurrency(String transCurrency) {
        this.transCurrency = transCurrency;
    }

    public String getTransCurrency() {
        return transCurrency;
    }

    public void setAcctTran(String acctTran) {
        this.acctTran = acctTran;
    }

    public String getAcctTran() {
        return acctTran;
    }

    public void setAcctTranSign(String acctTranSign) {
        this.acctTranSign = acctTranSign;
    }

    public String getAcctTranSign() {
        return acctTranSign;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setPaymentSummaryInquiry(PaymentSummaryInquiry paymentSummaryInquiry) {
        this.paymentSummaryInquiry = paymentSummaryInquiry;
    }

    public PaymentSummaryInquiry getPaymentSummaryInquiry() {
        return paymentSummaryInquiry;
    }

    public void setPeriodLabel(String periodLabel) {
        this.periodLabel = periodLabel;
    }

    public String getPeriodLabel() {
        return periodLabel;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }


    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDocTypeCode(String docTypeCode) {
        this.docTypeCode = docTypeCode;
    }

    public String getDocTypeCode() {
        return docTypeCode;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setDocReference(String docReference) {
        this.docReference = docReference;
    }

    public String getDocReference() {
        return docReference;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getDocStatus() {
        return docStatus;
    }


    public void setRevenueMode(String revenueMode) {
        this.revenueMode = revenueMode;
    }

    public String getRevenueMode() {
        return revenueMode;
    }

    public void setTransBalForDisplay(String transBalForDisplay) {
        this.transBalForDisplay = transBalForDisplay;
    }

    public String getTransBalForDisplay() {
        return transBalForDisplay;
    }

    

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setSubmissionDate(Calendar submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Calendar getSubmissionDate() {
        return submissionDate;
    }

    public void setDocumentTransactionList(List<GenericTransactionPeriodBean> documentTransactionList) {
        this.documentTransactionList = documentTransactionList;
    }

    public List<GenericTransactionPeriodBean> getDocumentTransactionList() {
        return documentTransactionList;
    }

    public void setDocBalForDisplay(String docBalForDisplay) {
        this.docBalForDisplay = docBalForDisplay;
    }

    public String getDocBalForDisplay() {
        return docBalForDisplay;
    }

    public void setDocEventId(Long docEventId) {
        this.docEventId = docEventId;
    }

    public Long getDocEventId() {
        return docEventId;
    }

    public void setRefEventCategoryType(String refEventCategoryType) {
        this.refEventCategoryType = refEventCategoryType;
    }

    public String getRefEventCategoryType() {
        return refEventCategoryType;
    }

    public void setDocEventsList(List<DocEventDetails> docEventsList) {
        this.docEventsList = docEventsList;
    }

    public List<DocEventDetails> getDocEventsList() {
        return docEventsList;
    }

    public void setRefEventDescription(String refEventDescription) {
        this.refEventDescription = refEventDescription;
    }

    public String getRefEventDescription() {
        return refEventDescription;
    }

    public void setSubTaxType(String subTaxType) {
        this.subTaxType = subTaxType;
    }

    public String getSubTaxType() {
        return subTaxType;
    }
    
    public String getChargeSubTaxDescriptionForAccountEnquiry(){
      if(isReversalTransaction()){
          return REVERSAL;
      }
      String formattedChargeType = camelCaseForChargeType(chargeType);
      if(refEventCategoryType != null) {
            if(refEventCategoryType.equals(Constants.EventCategoryTypes.RET_FILE_RETURNS) || refEventCategoryType.equals(Constants.EventCategoryTypes.RET_ADJUST_RETURNS) || Constants.EventCategoryTypes.RET_LODGEMENT.equals(refEventCategoryType)){
                if(transactionType!=null && transactionType.equals("DEBIT")) {
                    String appendedVal = null;
                    if(subTaxType != null && !subTaxType.equalsIgnoreCase("Dummy")){
                        appendedVal = subTaxType;
                    }
                    return  appendedVal == null ? formattedChargeType : formattedChargeType + "/" + subTaxType;
                } else if(transactionType!=null && transactionType.equals("CREDIT") && description != null && description.contains("Reversal")){
                    return REVERSAL;
                } else {
                    return subTaxType  == null ? "" : subTaxType;
                }
            }  else if(refEventCategoryType.equals(Constants.EventCategoryTypes.COMP_CHECK_LATEFILE) || refEventCategoryType.equals(Constants.EventCategoryTypes.COMP_CHECK_NONFILE)
                                               || refEventCategoryType.equals(Constants.EventCategoryTypes.COMP_CHECK_NONPAY) || refEventCategoryType.equals(Constants.EventCategoryTypes.COMP_CHECK_LATEPAY)){
               String appendedVal = null;
               if(subTaxType != null && !subTaxType.equalsIgnoreCase("Dummy")){
                   appendedVal = subTaxType;
               }
                return appendedVal == null ? formattedChargeType : formattedChargeType + "/" + subTaxType;
               } else if (refEventCategoryType.equals(Constants.EventTypes.CREATE_INSTALMENT) && 
                       transactionType != null && 
                       transactionType.equalsIgnoreCase("CREDIT")) {
                return REVERSAL;
            } else if (refEventCategoryType.equals(Constants.EventTypes.OFFICER_ASSESSMENT)) {
                String appendedVal = null;
                if (subTaxType != null && !subTaxType.equalsIgnoreCase("Dummy")) {
                    appendedVal = subTaxType;
                }
                return appendedVal == null ? formattedChargeType :formattedChargeType + "/" + subTaxType;
            }
        }
        return formattedChargeType;
    }

    private String camelCaseForChargeType(String chargeType){
        if(chargeType != null && chargeType.trim().length() > 1) {
            String upperCase = chargeType.substring(0,1);
            String  lowerCase = chargeType.substring(1,chargeType.length());
            return upperCase.toUpperCase() + lowerCase.toLowerCase();
        }
        return chargeType;
    }
    private boolean isReversalTransaction(){
        if(description != null && description.trim().startsWith(Constants.REVERSED_TRANSACTION_DESC_PREFIX)) {
            return true;
        }
        return false;
    }

    public void setDocTypeDescription(String docTypeDescription) {
        this.docTypeDescription = docTypeDescription;
    }

    public String getDocTypeDescription() {
        return docTypeDescription;
    }

    public void setPeriodStatusActive(boolean periodStatusActive) {
        this.periodStatusActive = periodStatusActive;
    }

    public boolean isPeriodStatusActive() {
        return periodStatusActive;
    }


    public void setEventDate(Calendar eventDate) {
        this.eventDate = eventDate;
    }

    public Calendar getEventDate() {
        return eventDate;
    }
}
