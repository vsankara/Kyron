package com.technobrain.trips.objectionandappeal.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefAppealDecision;
import com.technobrain.trips.reference.model.RefReviewType;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "ObaAppealDetails.findAll", 
    query = "select o from ObaAppealDetails o")
@Table(name = "OBA_APPEAL_DETAILS")
public class ObaAppealDetails extends BaseNormalModelObject{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "OBA_APPEAL_DETAILS_SEQ")
    @SequenceGenerator(name = "OBA_APPEAL_DETAILS_SEQ", 
                       sequenceName = "OBA_APPEAL_DETAILS_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="LODGED_BY")
    private String lodgedBy;
    @Column(name="ACCEPT_REJECT_BY")
    private String acceptRejectBy;
    @Column(name="APPEAL_AMOUNT")
    private BigDecimal appealAmount;
    @Column(name="APPEAL_DATE")
    private Timestamp appealDate;
    @Column(name="APPEAL_LODGED_DATE")
    private Timestamp appealLodgedDate;
    @Column(name="REJECT_IND")
    private String rejectIndicator;
    @Column(name="ACCEPT_IND")
    private String acceptIndicator;
    @Column(name="APPEAL_SUMMARY")
    private String appealSummary;
    @Column(name="FINALISATION_AMOUNT")
    private BigDecimal finalisationAmount;
    @Column(name="FINALISATION_NOTES")
    private String finalisationNotes;
    @Column(name="FINALISE_DATE")
    private Timestamp finaliseDate;
    @Column(name="FINALISE_FLAG")
    private String finaliseFlag;
    
    
    @Column(name="REJECTION_REASON")
    private String rejectionReason;    
    @Column(name="REJECTION_CODE")
    private String rejectionCode;
    @Column(name="REJECTION_NOTE")
    private String rejectionNote;
    
    @Column(name="REVIEW_TYPE")
    private String reviewType;
    
    @JoinColumn(name = "REVIEW_TYPE", referencedColumnName = "CODE", insertable=false,updatable=false)
    private RefReviewType refReviewType;
    
    @Column(name="FINALISE_DECISION")
    private String finaliseDecision;
    
    @JoinColumn(name = "FINALISE_DECISION", referencedColumnName = "CODE", insertable=false,updatable=false)
    private RefAppealDecision refAppealDecision;

    public ObaAppealDetails() {
    }

    public String getAcceptRejectBy() {
        return acceptRejectBy;
    }

    public void setAcceptRejectBy(String acceptRejectBy) {
        this.acceptRejectBy = acceptRejectBy;
    }

    public BigDecimal getAppealAmount() {
        return appealAmount;
    }

    public void setAppealAmount(BigDecimal appealAmount) {
        this.appealAmount = appealAmount;
    }

    public Timestamp getAppealDate() {
        return appealDate;
    }

    public void setAppealDate(Timestamp appealDate) {
        this.appealDate = appealDate;
    }

    public Timestamp getAppealLodgedDate() {
        return appealLodgedDate;
    }

    public void setAppealLodgedDate(Timestamp appealLodgedDate) {
        this.appealLodgedDate = appealLodgedDate;
    }

    public String getAppealSummary() {
        return appealSummary;
    }

    public void setAppealSummary(String appealSummary) {
        this.appealSummary = appealSummary;
    }

    public BigDecimal getFinalisationAmount() {
        return finalisationAmount;
    }

    public void setFinalisationAmount(BigDecimal finalisationAmount) {
        this.finalisationAmount = finalisationAmount;
    }

    public String getFinalisationNotes() {
        return finalisationNotes;
    }

    public void setFinalisationNotes(String finalisationNotes) {
        this.finalisationNotes = finalisationNotes;
    }

    public Timestamp getFinaliseDate() {
        return finaliseDate;
    }

    public void setFinaliseDate(Timestamp finaliseDate) {
        this.finaliseDate = finaliseDate;
    }


    public String getFinaliseFlag() {
        return finaliseFlag;
    }

    public void setFinaliseFlag(String finaliseFlag) {
        this.finaliseFlag = finaliseFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public RefReviewType getRefReviewType() {
        return refReviewType;
    }

    public void setRefReviewType(RefReviewType refReviewType) {
        this.refReviewType = refReviewType;
    }

    public RefAppealDecision getRefAppealDecision() {
        return refAppealDecision;
    }

    public void setRefAppealDecision(RefAppealDecision refAppealDecision) {
        this.refAppealDecision = refAppealDecision;
    }

    public void setReviewType(String reviewType) {
        this.reviewType = reviewType;
    }

    public String getReviewType() {
        return reviewType;
    }

    public void setFinaliseDecision(String finaliseDecision) {
        this.finaliseDecision = finaliseDecision;
    }

    public String getFinaliseDecision() {
        return finaliseDecision;
    }

    public void setLodgedBy(String lodgedBy) {
        this.lodgedBy = lodgedBy;
    }

    public String getLodgedBy() {
        return lodgedBy;
    }

    public void setRejectIndicator(String rejectIndicator) {
        this.rejectIndicator = rejectIndicator;
    }

    public String getRejectIndicator() {
        return rejectIndicator;
    }

    public void setAcceptIndicator(String acceptIndicator) {
        this.acceptIndicator = acceptIndicator;
    }

    public String getAcceptIndicator() {
        return acceptIndicator;
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
}
