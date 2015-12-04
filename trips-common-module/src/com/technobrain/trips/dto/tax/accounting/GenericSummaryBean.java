package com.technobrain.trips.dto.tax.accounting;

import java.math.BigDecimal;

import java.util.Calendar;
import org.apache.log4j.Logger;

public class GenericSummaryBean {
    static final Logger log = Logger.getLogger(GenericSummaryBean.class);
    protected String period;
    protected Calendar date;
    protected String description;
    protected BigDecimal amount;

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
