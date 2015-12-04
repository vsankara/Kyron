package com.technobrain.trips.objectionandappeal.model;

import com.technobrain.trips.casemanagement.model.CaseDetails;
import com.technobrain.trips.reference.model.RefObjectionDecision;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * Model class representing the table OBA_OBJECTION_DETAILS. 
 * 
 *@author
 *@version
 *@since   
 *@see RefObjectionDecision, ObaDisputedTransaction, ObaAppealDetails
 * 
 */
@Entity
@NamedQuery(name = "ObaObjectionDetails.findAll", 
    query = "select o from ObaObjectionDetails o")
@Table(name = "OBA_OBJECTION_DETAILS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="CTYPE")
@DiscriminatorValue("OBJECTIONANDAPPEAL")
public class ObaObjectionDetails extends CaseDetails {
    
    @Column(name="OBJ_ACCEPT_REJECT_BY")
    private String objAcceptRejectBy;
    @Column(name="DISPUTED_AMOUNT")
    private BigDecimal disputedAmount;
    @Column(name="OBJ_REJECT_IND")
    private String objRejectIndicator;
    @Column(name="OBJ_ACCEPT_IND")
    private String objAcceptIndicator;
    @Column(name="OBJECTION_SUMMARY")
    private String objectionSummary;   
    @Column(name="OBJECTION_DUE_DATE")
    private Timestamp objectionDueDate;
    @Column(name="FINALISATION_AMOUNT")
    private BigDecimal finalisationAmount;
    @Column(name="FINALISATION_DATE")
    private Timestamp finalisationDate;
    @Column(name="FINALISATION_NOTES")
    private String finalisationNotes;
    @Column(name="OBJ_REJECTION_REASON")
    private String rejectionReason;   
    @Column(name="OBJ_REJECTION_CODE")
    private String rejectionCode;
    @Column(name="OBJ_REJECTION_NOTE")
    private String rejectionNote;
    @Column(name="REVIEWED_BY")
    private String reviewedBy;
    @Column(name="REVIEWED_DATE")
    private Timestamp reviewedDate;
    @Column(name="REVIEW_NOTES")
    private String reviewNotes;
    
    @Column(name="FINALISATION_DECISION")
    private String finalisationDecision;
    
    @Column(name="OBJ_REVIEW_REJECT_IND")
    private String objReviewRejectIndicator;
    
    @Column(name="OBJ_REVIEW_ACCEPT_IND")
    private String objReviewAcceptIndicator;
    
    @Column(name="OBJ_REV_REJECTION_REASON")
    private String objReviewRejectionReason;
    
    @Column(name="OBJ_REV_REJECTION_CODE")
    private String objReviewRejectionCode;
    @Column(name="OBJ_REV_REJECTION_NOTE")
    private String objReviewRejectionNote;
    
    @Column(name="OBJ_REV_ACCEPT_REJECT_BY")
    private String objReviewAcceptRejectBy;
    
    @JoinColumn(name = "FINALISATION_DECISION", referencedColumnName = "CODE", insertable=false,updatable=false)
    private RefObjectionDecision refObjectionDecision;
    
    @OneToMany(cascade={CascadeType.ALL}, mappedBy="obaObjectionDetails")
    private List<ObaDisputedTransaction> obaDisputedTransactionList;
    
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "APPEAL_ID", referencedColumnName = "ID")
    private ObaAppealDetails appeal;

    public ObaObjectionDetails() {
    }

    public BigDecimal getDisputedAmount() {
        return disputedAmount;
    }

    public void setDisputedAmount(BigDecimal disputedAmount) {
        this.disputedAmount = disputedAmount;
    }

    public String getObjectionSummary() {
        return objectionSummary;
    }

    public void setObjectionSummary(String objectionSummary) {
        this.objectionSummary = objectionSummary;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public Timestamp getReviewedDate() {
        return reviewedDate;
    }

    public void setReviewedDate(Timestamp reviewedDate) {
        this.reviewedDate = reviewedDate;
    }

    public String getReviewNotes() {
        return reviewNotes;
    }

    public void setReviewNotes(String reviewNotes) {
        this.reviewNotes = reviewNotes;
    }

    public RefObjectionDecision getRefObjectionDecision() {
        return refObjectionDecision;
    }

    public void setRefObjectionDecision(RefObjectionDecision refObjectionDecision) {
        this.refObjectionDecision = refObjectionDecision;
    }

    public List<ObaDisputedTransaction> getObaDisputedTransactionList() {
        return obaDisputedTransactionList;
    }

    public void setObaDisputedTransactionList(List<ObaDisputedTransaction> obaDisputedTransactionList) {
        this.obaDisputedTransactionList = obaDisputedTransactionList;
    }

    public ObaDisputedTransaction addObjAppealDisputedTxn(ObaDisputedTransaction objAppealDisputedTxn) {
        getObaDisputedTransactionList().add(objAppealDisputedTxn);
        objAppealDisputedTxn.setObaObjectionDetails(this);
        return objAppealDisputedTxn;
    }

    public ObaDisputedTransaction removeObjAppealDisputedTxn(ObaDisputedTransaction objAppealDisputedTxn) {
        getObaDisputedTransactionList().remove(objAppealDisputedTxn);
        objAppealDisputedTxn.setObaObjectionDetails(null);
        return objAppealDisputedTxn;
    }

    public void setAppeal(ObaAppealDetails appeal) {
        this.appeal = appeal;
    }

    public ObaAppealDetails getAppeal() {
        return appeal;
    }

    public void setObjAcceptRejectBy(String objAcceptRejectBy) {
        this.objAcceptRejectBy = objAcceptRejectBy;
    }

    public String getObjAcceptRejectBy() {
        return objAcceptRejectBy;
    }

    public void setObjRejectIndicator(String objRejectIndicator) {
        this.objRejectIndicator = objRejectIndicator;
    }

    public String getObjRejectIndicator() {
        return objRejectIndicator;
    }

    public void setObjAcceptIndicator(String objAcceptIndicator) {
        this.objAcceptIndicator = objAcceptIndicator;
    }

    public String getObjAcceptIndicator() {
        return objAcceptIndicator;
    }

    public void setFinalisationAmount(BigDecimal finalisationAmount) {
        this.finalisationAmount = finalisationAmount;
    }

    public BigDecimal getFinalisationAmount() {
        return finalisationAmount;
    }

    public void setFinalisationDate(Timestamp finalisationDate) {
        this.finalisationDate = finalisationDate;
    }

    public Timestamp getFinalisationDate() {
        return finalisationDate;
    }

    public void setFinalisationNotes(String finalisationNotes) {
        this.finalisationNotes = finalisationNotes;
    }

    public String getFinalisationNotes() {
        return finalisationNotes;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setFinalisationDecision(String finalisationDecision) {
        this.finalisationDecision = finalisationDecision;
    }

    public String getFinalisationDecision() {
        return finalisationDecision;
    }

    public void setObjReviewRejectIndicator(String objReviewRejectIndicator) {
        this.objReviewRejectIndicator = objReviewRejectIndicator;
    }

    public String getObjReviewRejectIndicator() {
        return objReviewRejectIndicator;
    }

    public void setObjReviewAcceptIndicator(String objReviewAcceptIndicator) {
        this.objReviewAcceptIndicator = objReviewAcceptIndicator;
    }

    public String getObjReviewAcceptIndicator() {
        return objReviewAcceptIndicator;
    }

    public void setObjReviewRejectionReason(String objReviewRejectionReason) {
        this.objReviewRejectionReason = objReviewRejectionReason;
    }

    public String getObjReviewRejectionReason() {
        return objReviewRejectionReason;
    }

    public void setObjReviewAcceptRejectBy(String objReviewAcceptRejectBy) {
        this.objReviewAcceptRejectBy = objReviewAcceptRejectBy;
    }

    public String getObjReviewAcceptRejectBy() {
        return objReviewAcceptRejectBy;
    }

    public void setRejectionCode(String rejectionCode) {
        this.rejectionCode = rejectionCode;
    }

    public String getRejectionCode() {
        return rejectionCode;
    }

    public void setRejectionNote(String rejectionNote) {
        this.rejectionNote = rejectionNote;
    }

    public String getRejectionNote() {
        return rejectionNote;
    }

    public void setObjReviewRejectionCode(String objReviewRejectionCode) {
        this.objReviewRejectionCode = objReviewRejectionCode;
    }

    public String getObjReviewRejectionCode() {
        return objReviewRejectionCode;
    }

    public void setObjReviewRejectionNote(String objReviewRejectionNote) {
        this.objReviewRejectionNote = objReviewRejectionNote;
    }

    public String getObjReviewRejectionNote() {
        return objReviewRejectionNote;
    }

    public void setObjectionDueDate(Timestamp objectionDueDate) {
        this.objectionDueDate = objectionDueDate;
    }

    public Timestamp getObjectionDueDate() {
        return objectionDueDate;
    }
}
