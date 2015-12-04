package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;
import com.technobrain.trips.ratemanagement.model.RmtExchangeRate;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefCurrency.findAll", 
    query = "select o from RefCurrency o")
@Table(name = "REF_CURRENCY")
public class RefCurrency extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    private String name;
    private String symbol;
    @Column(name = "REF_COUNTRY")
    private String refCountry;
    
    @OneToMany(mappedBy="currency")
    private List<RmtExchangeRate> exchangeRateList;

    public RefCurrency() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRefCountry() {
        return refCountry;
    }

    public void setRefCountry(String refCountry) {
        this.refCountry = refCountry;
    }

    public void setExchangeRateList(List<RmtExchangeRate> exchangeRateList) {
        this.exchangeRateList = exchangeRateList;
    }

    public List<RmtExchangeRate> getExchangeRateList() {
        return exchangeRateList;
    }
}
