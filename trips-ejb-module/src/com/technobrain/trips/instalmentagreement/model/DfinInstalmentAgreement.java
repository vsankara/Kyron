package com.technobrain.trips.instalmentagreement.model;

import com.technobrain.trips.document.model.DfinDocument;
import com.technobrain.trips.reference.model.RefInstalmentAgreementStatus;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@NamedQueries(
    {
       @NamedQuery(name = "DfinInstalmentAgreement.findAll", 
        query = "select o from DfinInstalmentAgreement o"),
        @NamedQuery(name = "DfinInstalmentAgreement.findApprovedInstalmentAgreements", 
        query = "select o from DfinInstalmentAgreement o where o.agreementStatus = ?1 and o.firstInstallmentDueDate < CURRENT_DATE")
    }
)

@Table(name = "DFIN_INSTALMENT_AGREEMENT")
@DiscriminatorColumn(name = "DTYPE")
@DiscriminatorValue("INSTAL_AGREEMENT")
public class DfinInstalmentAgreement extends DfinDocument {

    @Column(name="AGREEMENT_DATE")
    private Timestamp agreementDate;
    @Column(name="FIRST_INSTALLMENT_DUE_DATE")
    private Timestamp firstInstallmentDueDate;
    @Column(name="CANCELLATION_NOTES")
    private String cancellationNotes;
    @Column(name="CANCEL_DATE")
    private Timestamp cancelDate;
    @Column(name="CANCEL_REASON")
    private String cancelReason;
    @Column(name="AGREEMENT_AMOUNT")
    private BigDecimal agreementAmount;
    
    @Column(name="INTEREST_RATE")
    private BigDecimal interestRate;
    
    @Column(name="INTEREST_TYPE")
    private String interestType;
    @Column(name="NUMBER_OF_INSTALMENTS")
    private Long numberOfInstalments;
    @Column(name="PAYMENT_SPREAD")
    private String paymentSpread;
    
    private String reason;

    private String notes;

    @Column(name="AGREEMENT_STATUS")
    private String agreementStatus;
    
    @JoinColumn(name = "AGREEMENT_STATUS", referencedColumnName = "CODE", insertable=false,updatable=false)
    private RefInstalmentAgreementStatus instalmentAgreementStatus;

    @Column(name="AGREEMENT_NUMBER")
    private String agreementNumber;
    
    @OneToMany(cascade={CascadeType.ALL}, mappedBy="agreement")
    private Collection<InstalAgreementOutstandingDebts> outstandingDebts;

    @OneToMany(cascade={CascadeType.ALL}, mappedBy="agreement")
    @OrderBy("instalmentNumber ASC")
    private Collection<AgreementInstalments> instalmentList;
    
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "instalmentAgreement")
    private List<InstalAgreementRelatedDocs> instalAgreementRelatedDocs;

  
    @Column(name="PAYMENT_STATUS")
    private String paymentStatus;
    
    @Column(name="APPLICATION_DATE") 
    private Timestamp applicationDate;
    
    @Column(name="TOTAL_INTEREST")
    private BigDecimal totalInterest;
    
    @Column(name="RETURN_TYPE")
    private String returnType;
    
    @Column(name="ENTITY_ID")
    private Long entityId;
    
    @Column(name="TOTAL_AMT_PAYABLE")
    private BigDecimal totalAmtPayable;
    
    @Column(name="DT_OF_APPROVAL") 
    private Timestamp dateOfApproval;
    
    @Column(name="AGREEMENT_REJECT_REASON")
    private String agreementRejectionReason;
    
    private String office;
    
    private transient String revenueType;
    
    public DfinInstalmentAgreement() {
    }

    public Timestamp getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(Timestamp agreementDate) {
        this.agreementDate = agreementDate;
    }

    public String getCancellationNotes() {
        return cancellationNotes;
    }

    public void setCancellationNotes(String cancellationNotes) {
        this.cancellationNotes = cancellationNotes;
    }

    public Timestamp getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Timestamp cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }


    public String getInterestType() {
        return interestType;
    }

    public void setInterestType(String interestType) {
        this.interestType = interestType;
    }

    public Long getNumberOfInstalments() {
        return numberOfInstalments;
    }

    public void setNumberOfInstalments(Long numberOfInstalments) {
        this.numberOfInstalments = numberOfInstalments;
    }

    public String getPaymentSpread() {
        return paymentSpread;
    }

    public void setPaymentSpread(String paymentSpread) {
        this.paymentSpread = paymentSpread;
    }


    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



    public void setInstalmentList(Collection<AgreementInstalments> instalmentList) {
        this.instalmentList = instalmentList;
    }

    public Collection<AgreementInstalments> getInstalmentList() {
        return instalmentList;
    }

    public AgreementInstalments addAgreementInstalment(AgreementInstalments revInstalment) {
        revInstalment.setAgreement(this);
        getInstalmentList().add(revInstalment);
        return revInstalment;
    }

    public AgreementInstalments removeAgreementInstalment(AgreementInstalments revInstalment) {
        getInstalmentList().remove(revInstalment);
        return revInstalment;
    }



    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setFirstInstallmentDueDate(Timestamp firstInstallmentDueDate) {
        this.firstInstallmentDueDate = firstInstallmentDueDate;
    }

    public Timestamp getFirstInstallmentDueDate() {
        return firstInstallmentDueDate;
    }


    public void setApplicationDate(Timestamp applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Timestamp getApplicationDate() {
        return applicationDate;
    }


    public void setAgreementAmount(BigDecimal agreementAmount) {
        this.agreementAmount = agreementAmount;
    }

    public BigDecimal getAgreementAmount() {
        return agreementAmount;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setAgreementStatus(String agreementStatus) {
        this.agreementStatus = agreementStatus;
    }

    public String getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementNumber(String agreementNumber) {
        this.agreementNumber = agreementNumber;
    }

    public String getAgreementNumber() {
        return agreementNumber;
    }

    public void setTotalInterest(BigDecimal totalInterest) {
        this.totalInterest = totalInterest;
    }

    public BigDecimal getTotalInterest() {
        return totalInterest;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setTotalAmtPayable(BigDecimal totalAmtPayable) {
        this.totalAmtPayable = totalAmtPayable;
    }

    public BigDecimal getTotalAmtPayable() {
        return totalAmtPayable;
    }

    public void setDateOfApproval(Timestamp dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }

    public Timestamp getDateOfApproval() {
        return dateOfApproval;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOffice() {
        return office;
    }

    public void setInstalAgreementRelatedDocs(List<InstalAgreementRelatedDocs> instalAgreementRelatedDocs) {
        this.instalAgreementRelatedDocs = instalAgreementRelatedDocs;
    }

    public List<InstalAgreementRelatedDocs> getInstalAgreementRelatedDocs() {
        return instalAgreementRelatedDocs;
    }
    
    public InstalAgreementRelatedDocs addInstalmentAgreementRelatedDocument(InstalAgreementRelatedDocs agreementRelatedDocument) {
        agreementRelatedDocument.setInstalmentAgreement(this);
        getInstalAgreementRelatedDocs().add(agreementRelatedDocument);
        return agreementRelatedDocument;
    }

    public InstalAgreementRelatedDocs removeInstalmentAgreementRelatedDocument(InstalAgreementRelatedDocs agreementRelatedDocument) {
        getInstalAgreementRelatedDocs().remove(agreementRelatedDocument);
        return agreementRelatedDocument;
    }

    public void setInstalmentAgreementStatus(RefInstalmentAgreementStatus instalmentAgreementStatus) {
        this.instalmentAgreementStatus = instalmentAgreementStatus;
    }

    public RefInstalmentAgreementStatus getInstalmentAgreementStatus() {
        return instalmentAgreementStatus;
    }

    public void setAgreementRejectionReason(String agreementRejectionReason) {
        this.agreementRejectionReason = agreementRejectionReason;
    }

    public String getAgreementRejectionReason() {
        return agreementRejectionReason;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setOutstandingDebts(Collection<InstalAgreementOutstandingDebts> outstandingDebts) {
        this.outstandingDebts = outstandingDebts;
    }

    public Collection<InstalAgreementOutstandingDebts> getOutstandingDebts() {
        return outstandingDebts;
    }
    
    public InstalAgreementOutstandingDebts addOutstandingDebt(InstalAgreementOutstandingDebts outstandingDebt) {
        outstandingDebt.setAgreement(this);
        getOutstandingDebts().add(outstandingDebt);
        return outstandingDebt;
    }

    public InstalAgreementOutstandingDebts removeOutstandingDebt(InstalAgreementOutstandingDebts outstandingDebt) {
        getOutstandingDebts().remove(outstandingDebt);
        return outstandingDebt;
    }
}
