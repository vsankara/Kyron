package com.technobrain.trips.dto.portal;

import java.math.BigDecimal;

import java.sql.Timestamp;


/**
 * Data transfer object for TransactionService.extractPaymentTransactions() service
 * 
 * @author Emmanuel Comia
 */
public class PaymentDTO {
    public PaymentDTO() {
    }

    public PaymentDTO(String currency, BigDecimal paymentAmount, 
                      Timestamp paymentDate, String till, 
                      BigDecimal exchangeRate, Long id) {
        this.currency = currency;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.till = till;
        this.exchangeRate = exchangeRate;
        this.id = id;
    }

    private String currency;
    private BigDecimal paymentAmount;
    private Timestamp paymentDate;
    private String till;
    private BigDecimal exchangeRate;
    private Long id;

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

    public String getTill() {
        return till;
    }

    public void setTill(String till) {
        this.till = till;
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
