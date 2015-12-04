package com.technobrain.trips.ratemanagement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefBankRateType;

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
@NamedQueries (
    {
    @NamedQuery(name = "RmtBankRate.findAll", 
        query = "select o from RmtBankRate o"),
    @NamedQuery(name = "RmtBankRate.findAllUnexpiredBankRate", 
                query = "select new com.technobrain.trips.dto.ratemanagement.BankRate" +
                "(rateType.code,rateType.description,rate.bankRate,rate.expiryDate,rate.effectiveDate,rate.id,rate.createdDate,rate.createdBy,rate.status) " +
                "from RefBankRateType rateType left outer join " +
                "rateType.rmtBankRateList rate where rate.expiryDate is null and rateType.status = ?1 " +
                "and (rateType.expiryDate is NULL or rateType.expiryDate >= CURRENT_TIMESTAMP) " + 
                "and (rateType.effectiveDate is NULL or rateType.effectiveDate <= CURRENT_TIMESTAMP) " +
                "order by rateType.code asc " ),
    @NamedQuery(name = "RmtBankRate.findAllBankRateByRateType", 
                query = "select new com.technobrain.trips.dto.ratemanagement.BankRate" +
                "(rate.bankRateType.code,rate.bankRate,rate.expiryDate,rate.effectiveDate,rate.id) " +
                "from RmtBankRate rate where rate.bankRateType.code = ?1 " +
                "order by rate.expiryDate desc " )
    }
)
@Table(name = "RMT_BANK_RATE")
public class RmtBankRate extends BaseNormalModelObject{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "RMT_BANK_RATE_SEQ")
    @SequenceGenerator(name = "RMT_BANK_RATE_SEQ", sequenceName = "RMT_BANK_RATE_SEQ", 
                       allocationSize = 1) 
    @Column(nullable = false)
    private Long id;
    @Column(name="BANK_RATE", nullable = false)
    private BigDecimal bankRate;
    @Column(name="EFFECTIVE_DATE", nullable = false)
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    @ManyToOne
    @JoinColumn(name = "BANK_RATE_TYPE", referencedColumnName = "CODE")
    private RefBankRateType bankRateType;

    public RmtBankRate() {
    }

    public BigDecimal getBankRate() {
        return bankRate;
    }

    public void setBankRate(BigDecimal bankRate) {
        this.bankRate = bankRate;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBankRateType(RefBankRateType bankRateType) {
        this.bankRateType = bankRateType;
    }

    public RefBankRateType getBankRateType() {
        return bankRateType;
    }
}
