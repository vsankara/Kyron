package com.technobrain.trips.account.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries( 
    {

@NamedQuery(name = "PaymentTransactionSummaryView.findAll", 
    query = "select o from TransactionSummaryView o"),
@NamedQuery(name = "PaymentTransactionSummaryView.outstandingLiability", 
        query = "select sum(o.transBalance) from TransactionSummaryView o where o.docId=?1 " +
        " and (o.chargeType = 'LIABILITY' or o.chargeType = 'PENALTY') and (o.refEventCategoryType = 'RET_FILE_RETURNS' " +
        "or o.refEventCategoryType='COMP_CHECK_LATEFILE' or o.refEventCategoryType='RET_LODGEMENT') and o.transBalance > 0"),
@NamedQuery(name = "PaymentTransactionSummaryView.findTransactionsByDocumentTypeAndPeriod", 
        query = "select o from TransactionSummaryView o where o.docType=?1 and o.periodId=?2 and o.docStatus='Posted' and o.transType='DEBIT'"),
@NamedQuery(name = "PaymentTransactionSummaryView.findTransactionByIdAndEventType", 
        query = "select o from TransactionSummaryView o where o.transId=?1 ")        
        
    }
)    
@Table(name = "TRANSACTION_SUMMARY")
public class TransactionSummaryView implements Serializable {
    @Id
    @Column(name="TRANS_ID", nullable = false)
    private Long transId;
    
    @Column(name="DOCTYPE_DESCRIPTION")
    private String doctypeDescription;
    @Column(name="DOC_ID")
    private Long docId;
    @Column(name="DOC_TYPE")
    private String docType;
    @Column(name="LEDGER_CODE")
    private String ledgerCode;
    @Column(name="PERIOD_ID")
    private Long periodId;
    @Column(name="TRANS_AMOUNT")
    private BigDecimal transAmount;
    @Column(name="TRANS_BALANCE")
    private BigDecimal transBalance;
    @Column(name="TRANS_DATE")
    private Timestamp transDate;
    @Column(name="TRANS_DESCRIPTION")
    private String transDescription;
    
    @Column(name="TRANS_REFERENCE")
    private String transReference;
    @Column(name="TRANS_TYPE")
    private String transType;
    @Column(name="CHARGE_TYPE")
    private String chargeType;
    
    @Column(name="DOC_REFERENCE")
    private String docReference;
    
    @Column(name="DOC_STATUS")
    private String docStatus;
    
    @Column(name="REV_MODE")
    private String revenueMode;
    
    @Column(name="SUBMISSION_DATE")
    private Timestamp submissionDate;
    
    @Column(name ="EVENT_ID") 
    private Long docEventId;
    
    @Column(name ="REF_EVT_TYPE_CAT")
    private String refEventCategoryType;
    
    @Column(name="EVENT_DATE")
    private Timestamp eventDate;
    
    @Column(name ="DESCRIPTION")
    private String refEventDescription;
    
    @Column(name ="SUB_TAX_TYPE")
    private String subTaxType;
    
    @Column(name="ACC_ACCOUNT")
    private Long accountId;
    
    public TransactionSummaryView() {
    }

    public String getDoctypeDescription() {
        return doctypeDescription;
    }

    public void setDoctypeDescription(String doctypeDescription) {
        this.doctypeDescription = doctypeDescription;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getLedgerCode() {
        return ledgerCode;
    }

    public void setLedgerCode(String ledgerCode) {
        this.ledgerCode = ledgerCode;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public Timestamp getTransDate() {
        return transDate;
    }

    public void setTransDate(Timestamp transDate) {
        this.transDate = transDate;
    }

    public String getTransDescription() {
        return transDescription;
    }

    public void setTransDescription(String transDescription) {
        this.transDescription = transDescription;
    }

    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    public String getTransReference() {
        return transReference;
    }

    public void setTransReference(String transReference) {
        this.transReference = transReference;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransBalance(BigDecimal transBalance) {
        this.transBalance = transBalance;
    }

    public BigDecimal getTransBalance() {
        return transBalance;
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


    public void setSubmissionDate(Timestamp submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Timestamp getSubmissionDate() {
        return submissionDate;
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

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setEventDate(Timestamp eventDate) {
        this.eventDate = eventDate;
    }

    public Timestamp getEventDate() {
        return eventDate;
    }

}
