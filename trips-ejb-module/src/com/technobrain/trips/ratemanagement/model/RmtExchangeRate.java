package com.technobrain.trips.ratemanagement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefCurrency;

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


/**
 * Entity Model class for table RMT_EXCHANGE_RATE. 
 * 
 *@author
 *@version
 *@since   
 *@see RefCurrency
 * 
 */

@Entity
@NamedQueries( { @NamedQuery(name = "RmtExchangeRate.findAll", 
                             query = "select o from RmtExchangeRate o") , 
        @NamedQuery(name = "RmtExchangeRate.findAllExchangeRates", query = "select new com.technobrain.trips.dto.ratemanagement.ExchangeRateDTO" + 
                    "(currency.code,currency.description,exchangeRate.exchangeRate,exchangeRate.expiryDate,exchangeRate.effectiveDate,exchangeRate.id) " + 
                    "from RefCurrency currency left outer join " + 
                    "currency.exchangeRateList exchangeRate where exchangeRate.expiryDate is null and currency.code <> 'GHS' and currency.status=?1 " +
                    "and (currency.expiryDate is NULL or currency.expiryDate >= CURRENT_TIMESTAMP) " + 
                    "and (currency.effectiveDate is NULL or currency.effectiveDate <= CURRENT_TIMESTAMP) order by currency.code asc " ), 
        @NamedQuery(name = "RmtExchangeRate.findAllExchangeRatesByCurrency", query = "select new com.technobrain.trips.dto.ratemanagement.ExchangeRateDTO" + 
                    "(currency.code,currency.description,exchangeRate.exchangeRate,exchangeRate.expiryDate,exchangeRate.effectiveDate,exchangeRate.id) " + 
                    "from RefCurrency currency left outer join " + 
                    "currency.exchangeRateList exchangeRate where exchangeRate.currency.code=?1 order by exchangeRate.expiryDate desc")
        } )
@Table(name = "RMT_EXCHANGE_RATE")
public class RmtExchangeRate extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "RMT_EXCHANGE_RATE_SEQ")
    @SequenceGenerator(name = "RMT_EXCHANGE_RATE_SEQ", sequenceName = "RMT_EXCHANGE_RATE_SEQ", 
                       allocationSize = 1) 
    @Column(nullable = false)
    private Long id;
    
    @Column(name="BASE_CURRENCY")
    private String baseCurrency;
    
    @ManyToOne
    @JoinColumn(name = "CURRENCY", referencedColumnName = "CODE")
    private RefCurrency currency;
    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXCHANGE_RATE")
    private BigDecimal exchangeRate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public RmtExchangeRate() {
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
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

    public void setCurrency(RefCurrency currency) {
        this.currency = currency;
    }

    public RefCurrency getCurrency() {
        return currency;
    }
}
