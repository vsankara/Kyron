package com.technobrain.trips.dto.ratemanagement;

import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.dto.DataTransferObject;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Calendar;
import java.util.Date;

/**
 * DTO class to capture the Exchange Rate values. 
 * This is used in presentation layer to bind the values in the screen.
 * 
 *@author
 *@version
 *@since   
 * 
 */

public class ExchangeRateDTO implements DataTransferObject 
{
    
    private Long exchangeRateId;
    private String currencyCode;
    private String currencyDescription;
    private String baseCurrencyCode;
    private String baseCurrencyDescription;
    private BigDecimal exchangeRate;
    private Date effectiveDate;
    private Calendar effectiveDateCalendar;

    public Calendar getEffectiveDateCalendar() {
        return effectiveDateCalendar;
    }

    public void setEffectiveDateCalendar(Calendar effectiveDateCalendar) {
        this.effectiveDateCalendar = effectiveDateCalendar;
    }

    public Calendar getExpiryDateCalendar() {
        return expiryDateCalendar;
    }

    public void setExpiryDateCalendar(Calendar expiryDateCalendar) {
        this.expiryDateCalendar = expiryDateCalendar;
    }
    private Date expiryDate;
    private Calendar expiryDateCalendar;
    private String exchangeRateForDisplay;

    public String getEffectiveDateForDisplay() {
        return effectiveDateForDisplay;
    }

    public void setEffectiveDateForDisplay(String effectiveDateForDisplay) {
        this.effectiveDateForDisplay = effectiveDateForDisplay;
    }

    public String getExpiryDateForDisplay() {
        return expiryDateForDisplay;
    }

    public void setExpiryDateForDisplay(String expiryDateForDisplay) {
        this.expiryDateForDisplay = expiryDateForDisplay;
    }
    private boolean valueChanged;
    private String effectiveDateForDisplay;
    private String expiryDateForDisplay;

    public ExchangeRateDTO() {
    }
    
    public ExchangeRateDTO(String currencyCode,String currencyDescription, BigDecimal exchangeRate,Timestamp expiryDate,Timestamp effectiveDate,Long exchangeRateId) {
        this.currencyCode = currencyCode;
        this.currencyDescription = currencyDescription;
        this.exchangeRate = exchangeRate;
        this.expiryDate = DateHelper.getCalendar(expiryDate)==null? null:DateHelper.getCalendar(expiryDate).getTime();
        this.expiryDateCalendar=DateHelper.getCalendar(expiryDate);
        this.expiryDateForDisplay=DateHelper.getFormattedDateWithoutTime(this.expiryDate);
        this.effectiveDate = DateHelper.getCalendar(effectiveDate)==null? null:DateHelper.getCalendar(effectiveDate).getTime();
        this.effectiveDateCalendar=DateHelper.getCalendar(effectiveDate);
        this.effectiveDateForDisplay=DateHelper.getFormattedDateWithoutTime(this.effectiveDate);
        this.exchangeRateId = exchangeRateId;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyDescription(String currencyDescription) {
        this.currencyDescription = currencyDescription;
    }

    public String getCurrencyDescription() {
        return currencyDescription;
    }

    public void setBaseCurrencyCode(String baseCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    public String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }

    public void setBaseCurrencyDescription(String baseCurrencyDescription) {
        this.baseCurrencyDescription = baseCurrencyDescription;
    }

    public String getBaseCurrencyDescription() {
        return baseCurrencyDescription;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getEffectiveDate() {
        if(effectiveDateCalendar!=null){
            return effectiveDateCalendar.getTime();
        }
        return null;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate() {
         if(expiryDateCalendar!=null){
            return expiryDateCalendar.getTime();
        }
        return null;
    }

    public void setExchangeRateId(Long exchangeRateId) {
        this.exchangeRateId = exchangeRateId;
    }

    public Long getExchangeRateId() {
        return exchangeRateId;
    }

    public void setExchangeRateForDisplay(String exchangeRateForDisplay) {
        this.exchangeRateForDisplay = exchangeRateForDisplay;
    }

    public String getExchangeRateForDisplay() {
        if(getExchangeRate()!=null){
          // This is to display the currency with 4 decimal places on screen.
          exchangeRateForDisplay = StringHelper.formatBigDecimalByMinMaxFraction(this.exchangeRate,6,4);
        }
        return exchangeRateForDisplay;
    }

    public void setValueChanged(boolean valueChanged) {
        this.valueChanged = valueChanged;
    }

    public boolean isValueChanged() {
        return valueChanged;
    }
}
