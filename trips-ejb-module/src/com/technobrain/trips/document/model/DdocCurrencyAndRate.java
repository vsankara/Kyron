package com.technobrain.trips.document.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefCurrency;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQueries( { 
@NamedQuery(name = "DdocCurrencyAndRate.findAll", 
            query = "select o from DdocCurrencyAndRate o where o.status='A'"),
@NamedQuery(name = "DdocCurrencyAndRate.finByDocumentId", 
            query = "select o from DdocCurrencyAndRate o where o.documentId=?1 and o.status='A'")

})
@Table(name = "DDOC_CURRENCY_AND_RATE")
public class DdocCurrencyAndRate extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "ddoc_currency_and_rate_seq")
    @SequenceGenerator(name = "ddoc_currency_and_rate_seq", 
                       sequenceName = "ddoc_currency_and_rate_seq", 
                       allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "DOCUMENT_ID")
    private Long documentId;
    @Column(name = "EXCHANGE_RATE", nullable = false)
    private BigDecimal exchangeRate;

   
    public DdocCurrencyAndRate() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }



   
    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }


    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
