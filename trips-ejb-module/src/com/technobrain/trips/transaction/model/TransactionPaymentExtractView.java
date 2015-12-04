package com.technobrain.trips.transaction.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@NamedQuery(name = "TransactionPaymentExtractView.findAll", 
            query = "select o from TransactionPaymentExtractView o")
@Table(name = "TRANS_PAYMENT_EXTRACT")
public class TransactionPaymentExtractView implements Serializable {
    public TransactionPaymentExtractView() {
    }
    @Id
    @Column(name="ID")
    private Long id;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "PAYMENT_AMOUNT")
    private BigDecimal paymentAmount;
    @Column(name = "PAYMENT_DATE")
    private Timestamp paymentDate;
    @Column(name = "TILL_REFERENCE")
    private String tillReference;
    @Column(name = "EXCHANGE_RATE")
    private BigDecimal exchangeRate;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getTillReference() {
        return tillReference;
    }

    public void setTill(String tillReference) {
        this.tillReference = tillReference;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
