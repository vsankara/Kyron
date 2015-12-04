package com.technobrain.trips.dto.tax.compliance;

import com.technobrain.trips.dto.DataTransferObject;

import java.math.BigDecimal;

import java.util.Calendar;

public class ShortPayWrapper implements DataTransferObject{

    private BigDecimal amount;
    private Long period;
    private String regimeNumber;
    private Calendar paymentDate;
    private String regimeType;
    
    
    public ShortPayWrapper() {
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Long getPeriod() {
        return period;
    }

    public void setRegimeNumber(String regimeNumber) {
        this.regimeNumber = regimeNumber;
    }

    public String getRegimeNumber() {
        return regimeNumber;
    }

    public void setPaymentDate(Calendar paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Calendar getPaymentDate() {
        return paymentDate;
    }

    public void setRegimeType(String regimeType) {
        this.regimeType = regimeType;
    }

    public String getRegimeType() {
        return regimeType;
    }
}
