package com.technobrain.trips.instalmentagreement.model;

import com.technobrain.trips.account.model.AccountPeriod;
import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefReturnType;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "InstalAgreementOutstandingDebts.findAll", 
    query = "select o from InstalAgreementOutstandingDebts o")
@Table(name = "INS_AGR_OUTSTAND_DEBT")
public class InstalAgreementOutstandingDebts extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "INS_AGR_OUTSTAND_DEBT_SEQ")
    @SequenceGenerator(name = "INS_AGR_OUTSTAND_DEBT_SEQ", 
                       sequenceName = "INS_AGR_OUTSTAND_DEBT_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
   
    @ManyToOne
    @JoinColumn(referencedColumnName="ID")
    private DfinInstalmentAgreement agreement;

    @Column(name="AGREEMENT_ID", nullable=false,insertable=false, updatable=false)
    private Long agreementId;
   
    @Column(name="DEBT_AMOUNT")
    private BigDecimal debtAmount;
    
    @Column(name="INTEREST_AMOUNT")
    private BigDecimal interestAmount;
   
    private String notes;
   
    @Column(name="PERIOD_ID")
    private Long periodId;
    
    @JoinColumn(name = "PERIOD_ID", referencedColumnName = "ID", insertable=false,updatable=false)
    private AccountPeriod accountPeriod;
   
    @Column(name="RETURN_TYPE")
    private String returnType;
    
    @JoinColumn(name = "RETURN_TYPE", referencedColumnName = "CODE", insertable=false,updatable=false)
    private RefReturnType refReturnType;
   
    public InstalAgreementOutstandingDebts() {
    }

    public Long getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Long agreementId) {
        this.agreementId = agreementId;
    }

    public BigDecimal getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(BigDecimal debtAmount) {
        this.debtAmount = debtAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public void setAgreement(DfinInstalmentAgreement agreement) {
        this.agreement = agreement;
    }

    public DfinInstalmentAgreement getAgreement() {
        return agreement;
    }

    public void setAccountPeriod(AccountPeriod accountPeriod) {
        this.accountPeriod = accountPeriod;
    }

    public AccountPeriod getAccountPeriod() {
        return accountPeriod;
    }

    public void setRefReturnType(RefReturnType refReturnType) {
        this.refReturnType = refReturnType;
    }

    public RefReturnType getRefReturnType() {
        return refReturnType;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }
}
