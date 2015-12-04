package com.technobrain.trips.dto.ratemanagement;

import com.technobrain.trips.dto.DataTransferObject;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.Calendar;


/**
 * This is a DTO for bank rate and it is used to transfer bank rate data 
 */
public class BankRate implements DataTransferObject{
    
    private String rateTypeCode;
    private String rateTypeDesc;
    private BigDecimal rate;
    private Calendar rateExpiryDate;
    private Calendar rateEffectiveDate;
    private Long rateId;
    private Calendar rateCreatedDate;
    private String rateCreatedBy;
    private String rateStatus;
    private boolean valueChanged;
   
    public BankRate() {
    }
    
    public BankRate(String rateTypeCode,String rateTypeDesc, BigDecimal rate,Timestamp rateExpiryDate,Timestamp rateEffectiveDate,Long rateId,
                    Timestamp rateCreatedDate,String rateCreatedBy,String rateStatus) {
        this.rateTypeCode = rateTypeCode;
        this.rateTypeDesc = rateTypeDesc;
        this.rate = rate;
        this.rateExpiryDate = toDate(rateExpiryDate);
        this.rateEffectiveDate = toDate(rateEffectiveDate);
        this.rateId = rateId;
        this.rateCreatedDate = toDate(rateCreatedDate);
        this.rateCreatedBy = rateCreatedBy;
        this.rateStatus = rateStatus;
    }
    
    public BankRate(String rateTypeCode,BigDecimal rate,Timestamp rateExpiryDate,Timestamp rateEffectiveDate,Long rateId) {
        this.rateTypeCode = rateTypeCode;
        this.rate = rate;
        this.rateExpiryDate = toDate(rateExpiryDate);
        this.rateEffectiveDate = toDate(rateEffectiveDate);
        this.rateId = rateId;
    }
    
    /**
     * Converts to a Calendar
     * @param timeStamp
     * @return Calendar
     */
    private Calendar toDate(Timestamp timeStamp) {
        if(timeStamp == null)
            return null;
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(timeStamp.getTime()));
        return c;
    }

    public void setRateTypeCode(String rateTypeCode) {
        this.rateTypeCode = rateTypeCode;
    }

    public String getRateTypeCode() {
        return rateTypeCode;
    }

    public void setRateTypeDesc(String rateTypeDesc) {
        this.rateTypeDesc = rateTypeDesc;
    }

    public String getRateTypeDesc() {
        return rateTypeDesc;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRateExpiryDate(Calendar rateExpiryDate) {
        this.rateExpiryDate = rateExpiryDate;
    }

    public Calendar getRateExpiryDate() {
        return rateExpiryDate;
    }

    public void setRateEffectiveDate(Calendar rateEffectiveDate) {
        this.rateEffectiveDate = rateEffectiveDate;
    }

    public Calendar getRateEffectiveDate() {
        return rateEffectiveDate;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateCreatedDate(Calendar rateCreatedDate) {
        this.rateCreatedDate = rateCreatedDate;
    }

    public Calendar getRateCreatedDate() {
        return rateCreatedDate;
    }

    public void setRateCreatedBy(String rateCreatedBy) {
        this.rateCreatedBy = rateCreatedBy;
    }

    public String getRateCreatedBy() {
        return rateCreatedBy;
    }

    public void setRateStatus(String rateStatus) {
        this.rateStatus = rateStatus;
    }

    public String getRateStatus() {
        return rateStatus;
    }

    public void setValueChanged(boolean valueChanged) {
        this.valueChanged = valueChanged;
    }

    public boolean isValueChanged() {
        return valueChanged;
    }
}
