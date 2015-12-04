package com.technobrain.trips.document.model;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TechnoBrain 2015
 *
 * Base class for a payment instrument, e.g. cash, cheque, etc.
 *
 * @since	$Date$
 * @version	$Rev$
 * @author	$Author$
 * 
 */
@Entity
@NamedQuery(name = "DfinRevCollInstrument.findAll", 
    query = "select o from DfinRevCollInstrument o")
@Table(name = "DFIN_REV_COLL_INSTRUMENT")
public class DfinRevCollInstrument extends DfinDocument {
     
    @Column(name="BASE_AMOUNT", nullable = false)
    private BigDecimal baseAmount;
     
    @Column(name="EXCHANGE_RATE", nullable = false)
    private BigDecimal exchangeRate;
     
    @Column(name="INSTRUMENT_NUMBER", nullable = false)
    private String instrumentNumber;

    @Column(name="INSTRUMENT_AMOUNT")
    private BigDecimal instrumentAmount;
     
    @Column(name="INSTRUMENT_CURRENCY", nullable = false)
    private String instrumentCurrency;
    
    @Column(name="PAYMENT_STATUS", nullable = false)
    private String paymentStatus;
    
    @Column(name="PAYMENT_METHOD")
    private String paymentMethod;

    @Column(name="NOTES")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "RECEIPT_ID", referencedColumnName = "ID")
    private DfinRevCollReceipt receipt;

    @OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "instrument")
    private List<DfinPaymentSpread> paymentSpreadList;
    
    public DfinRevCollInstrument() {
        setDocType("INSTR");
    }

    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    public String getBaseCurrency() {
        return instrumentNumber;
    }

    public void setInstrumentNumber(String instrumentNumber) {
        this.instrumentNumber = instrumentNumber;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getInstrumentAmount() {
        return instrumentAmount;
    }

    public void setInstrumentAmount(BigDecimal instrumentAmount) {
        this.instrumentAmount = instrumentAmount;
    }

    public String getInstrumentCurrency() {
        return instrumentCurrency;
    }

    public void setInstrumentCurrency(String instrumentCurrency) {
        this.instrumentCurrency = instrumentCurrency;
    }

    public DfinRevCollReceipt getReceipt() {
        return receipt;
    }

    public void setReceipt(DfinRevCollReceipt receiptId) {
        this.receipt = receiptId;
    }

    public void setPaymentSpreadList(List<DfinPaymentSpread> paymentSpreadList) {
        this.paymentSpreadList = paymentSpreadList;
    }

    public List<DfinPaymentSpread> getPaymentSpreadList() {
        if(paymentSpreadList == null){
            paymentSpreadList = new LinkedList<DfinPaymentSpread>();
    }
        return paymentSpreadList;
    }
        
    public void addPaymentSpread(DfinPaymentSpread paymentSpread){
        getPaymentSpreadList().add(paymentSpread);
        paymentSpread.setInstrument(this);
        }
    
    public void removePaymentSpread(DfinPaymentSpread paymentSpread){
        getPaymentSpreadList().remove(paymentSpread);
        }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getInstrumentNumber() {
        return instrumentNumber;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }
}
