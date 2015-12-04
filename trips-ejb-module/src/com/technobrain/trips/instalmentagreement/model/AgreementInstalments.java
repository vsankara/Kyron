package com.technobrain.trips.instalmentagreement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQueries(
    {
		@NamedQuery(name = "AgreementInstalments.findAll", 
		query = "select o from AgreementInstalments o"),
        @NamedQuery(name = "AgreementInstalments.findOverDuedInstalmentAgreements", 
        query = "select o from AgreementInstalments o where o.dueDate < CURRENT_DATE and o.instalmentStatus=?1 and o.status=?2 and o.agreementId=?3"),
		@NamedQuery(name = "AgreementInstalments.findAgreementInstamentById", 
		query = "select o from AgreementInstalments o where o.id=?1") 
    }
)

@Table(name = "AGREEMENT_INSTALMENTS")
public class AgreementInstalments extends BaseNormalModelObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "AGREEMENT_INSTALMENTS_SEQ")
    @SequenceGenerator(name = "AGREEMENT_INSTALMENTS_SEQ", 
                       sequenceName = "AGREEMENT_INSTALMENTS_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="DUE_DATE")
    private Timestamp dueDate;
    
    @Column(name="INSTALMENT_AMOUNT")
    private BigDecimal instalmentAmount;
    
    @Column(name="INSTALMENT_NUMBER")
    private Integer instalmentNumber;
    
    @Column(name="PERIOD_ID")
    private Long periodId;
    
    @Column(name="INSTALMENT_STATUS")
    private String instalmentStatus;
    
    @ManyToOne
    @JoinColumn(referencedColumnName="ID")
    private DfinInstalmentAgreement agreement;

    @Column(name="AGREEMENT_ID", nullable=false,insertable=false, updatable=false)
    private Long agreementId;

    @Column(name="INSTALMENT_INTEREST")
    private BigDecimal instalmentInterest;

    public AgreementInstalments() {
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setInstalmentAmount(BigDecimal instalmentAmount) {
        this.instalmentAmount = instalmentAmount;
    }

    public BigDecimal getInstalmentAmount() {
        return instalmentAmount;
    }

    public void setInstalmentNumber(Integer instalmentNumber) {
        this.instalmentNumber = instalmentNumber;
    }

    public Integer getInstalmentNumber() {
        return instalmentNumber;
    }

    public void setInstalmentStatus(String instalmentStatus) {
        this.instalmentStatus = instalmentStatus;
    }

    public String getInstalmentStatus() {
        return instalmentStatus;
    }

    public void setInstalmentInterest(BigDecimal instalmentInterest) {
        this.instalmentInterest = instalmentInterest;
    }

    public BigDecimal getInstalmentInterest() {
        return instalmentInterest;
    }

    public void setAgreementId(Long agreementId) {
        this.agreementId = agreementId;
    }

    public Long getAgreementId() {
        return agreementId;
    }

    public void setAgreement(DfinInstalmentAgreement agreement) {
        this.agreement = agreement;
    }

    public DfinInstalmentAgreement getAgreement() {
        return agreement;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public Long getPeriodId() {
        return periodId;
    }
}
