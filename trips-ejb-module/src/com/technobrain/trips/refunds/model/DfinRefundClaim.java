package com.technobrain.trips.refunds.model;

import com.technobrain.trips.document.model.DfinDocument;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries( { @NamedQuery(name = "DfinRefundClaim.findAll", 
    query = "select o from DfinRefundClaim o"),
    @NamedQuery(name = "DfinRefundClaim.findRefundsByTaxType", 
            query = "select o from DfinRefundClaim o where o.entEntity=?1 and o.taxType=?2 " +
            "and upper(o.refundClaimStatus) not in ('REJECT','PAID')"),
    @NamedQuery(name = "DfinRefundClaim.findRefundsByEntTaxtypePeriod", 
    query = "select o from DfinRefundClaim o where o.entEntity=?1 and o.taxType=?2 and o.returnType=?3 and o.period=?4 " +
            "and upper(o.refundClaimStatus) not in ('REJECT','PAID')")
})
@Table(name = "DFIN_REFUND_CLAIM")
public class DfinRefundClaim extends DfinDocument {
    
    @Column(name="ACTUAL_REFUND_AMOUNT")
    private BigDecimal actualRefundAmount;
    @Column(name="APPROVAL_NOTE")
    private String approvalNote;    
    @Column(name="CASE_ID")
    private Long caseId;
    @Column(name="CHEQUE_ISSUE_DATE")
    private Timestamp chequeIssueDate;
    @Column(name="CHEQUE_NUMBER")
    private String chequeNumber;
    @Column(name="CLAIM_AMOUNT")
    private BigDecimal claimAmount;
    @Column(name="CLAIM_DATE")
    private Timestamp claimDate;
    @Column(name="CLAIM_NOTE")
    private String claimNote;
    @Column(name="DATE_OF_PAYMENT")
    private Timestamp dateOfPayment;
    @Column(name="ENT_ENTITY")
    private Long entEntity;
    @Column(name="INTEREST_AMOUNT")
    private BigDecimal interestAmount;
    @Column(name="MODE_OF_CLAIM")
    private String modeOfClaim;
    @Column(name="PAYMENT_MODE")
    private String paymentMode;
    @Column(name="PAYMENT_PROCESSING_NOTES")
    private String paymentProcessingNotes;
    @Column(name="PAYMENT_REFERNCE_NO")
    private String paymentRefernceNo;
    private Long period;    
    @Column(name="REFUND_CLAIM_NO", nullable = false)
    private String refundClaimNo;
    @Column(name="REFUND_CLAIM_STATUS")
    private String refundClaimStatus;
    @Column(name="REFUND_DUE_DATE")
    private Timestamp refundDueDate;
    @Column(name="REFUND_PAYMENT_METHOD")
    private String refundPaymentMethod;
    private String regime;
    @Column(name="REJECTION_NOTES")
    private String rejectionNotes;
    @Column(name="REJECTION_REASON")
    private String rejectionReason;    
    private String remarks;    
    @Column(name="TAX_TYPE")
    private String taxType;
    @Column(name="TOTAL_REFUND_AMOUNT")
    private BigDecimal totalRefundAmount;
    @Column(name="RETURN_TYPE")
    private String returnType;
    @Column(name="AVAILABLE_CREDIT")
    private String availableCredit;
    @Column(name="CLAIM_ORIGINATOR")
    private String claimOriginator;
    @Column(name="CLAIM_OFFICER")
    private String claimOfficer;
    
    private transient Long eventId;


    public DfinRefundClaim() {
    }

    public String getApprovalNote() {
        return approvalNote;
    }

    public void setApprovalNote(String approvalNote) {
        this.approvalNote = approvalNote;
    }   

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Timestamp getChequeIssueDate() {
        return chequeIssueDate;
    }

    public void setChequeIssueDate(Timestamp chequeIssueDate) {
        this.chequeIssueDate = chequeIssueDate;
    }

    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public Timestamp getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Timestamp claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimNote() {
        return claimNote;
    }

    public void setClaimNote(String claimNote) {
        this.claimNote = claimNote;
    }

    public Timestamp getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Timestamp dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public Long getEntEntity() {
        return entEntity;
    }

    public void setEntEntity(Long entEntity) {
        this.entEntity = entEntity;
    }

    public String getModeOfClaim() {
        return modeOfClaim;
    }

    public void setModeOfClaim(String modeOfClaim) {
        this.modeOfClaim = modeOfClaim;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentProcessingNotes() {
        return paymentProcessingNotes;
    }

    public void setPaymentProcessingNotes(String paymentProcessingNotes) {
        this.paymentProcessingNotes = paymentProcessingNotes;
    }

    public String getPaymentRefernceNo() {
        return paymentRefernceNo;
    }

    public void setPaymentRefernceNo(String paymentRefernceNo) {
        this.paymentRefernceNo = paymentRefernceNo;
    }    

    public String getRefundClaimNo() {
        return refundClaimNo;
    }

    public void setRefundClaimNo(String refundClaimNo) {
        this.refundClaimNo = refundClaimNo;
    }

    public String getRefundClaimStatus() {
        return refundClaimStatus;
    }

    public void setRefundClaimStatus(String refundClaimStatus) {
        this.refundClaimStatus = refundClaimStatus;
    }

    public Timestamp getRefundDueDate() {
        return refundDueDate;
    }

    public void setRefundDueDate(Timestamp refundDueDate) {
        this.refundDueDate = refundDueDate;
    }

    public String getRefundPaymentMethod() {
        return refundPaymentMethod;
    }

    public void setRefundPaymentMethod(String refundPaymentMethod) {
        this.refundPaymentMethod = refundPaymentMethod;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public String getRejectionNotes() {
        return rejectionNotes;
    }

    public void setRejectionNotes(String rejectionNotes) {
        this.rejectionNotes = rejectionNotes;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public void setActualRefundAmount(BigDecimal actualRefundAmount) {
        this.actualRefundAmount = actualRefundAmount;
    }

    public BigDecimal getActualRefundAmount() {
        return actualRefundAmount;
    }

    public void setClaimAmount(BigDecimal claimAmount) {
        this.claimAmount = claimAmount;
    }

    public BigDecimal getClaimAmount() {
        return claimAmount;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public void setTotalRefundAmount(BigDecimal totalRefundAmount) {
        this.totalRefundAmount = totalRefundAmount;
    }

    public BigDecimal getTotalRefundAmount() {
        return totalRefundAmount;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Long getPeriod() {
        return period;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setAvailableCredit(String availableCredit) {
        this.availableCredit = availableCredit;
    }

    public String getAvailableCredit() {
        return availableCredit;
    }

    public void setClaimOriginator(String claimOriginator) {
        this.claimOriginator = claimOriginator;
    }

    public String getClaimOriginator() {
        return claimOriginator;
    }

    public void setClaimOfficer(String claimOfficer) {
        this.claimOfficer = claimOfficer;
    }

    public String getClaimOfficer() {
        return claimOfficer;
    }
}
