package com.technobrain.trips.dto.tax.period;

import com.technobrain.trips.dto.DataTransferObject;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.Calendar;

/**
 * TechnoBrain 2015
 * This is a DTO for period. It is used to transfer
 * the period details for Period pages.
 * 
 * @since $Date: 2/4/2009 11:31:30 AM$
 * @version $Revision: 3$
 * @author $Author: Idris Yildiz$
 * 
 * $Log[1]:
 *  3    TRIPS2    1.2         2/4/2009 11:31:30 AM   Idris Yildiz    Maintain
 *       period screen and business logic changes
 * $
 */
public class PeriodDetail implements DataTransferObject{
    
    private String regimeType;
    private Long periodNo;
    private Long periodYear;
    private Calendar periodStart;
    private Calendar periodEnd;
    private Calendar periodDue;
    private Calendar paymentDue;

    /**
     * @param regimeType
     * @param periodNo
     * @param periodYear
     * @param periodStart
     * @param periodEnd
     * This is a constructor that represents period details on PeriodReferenceDetails.jspx
     */
    public PeriodDetail(String regimeType,Long periodNo,Long periodYear,Timestamp periodStart,Timestamp periodEnd,Timestamp periodDue,Timestamp paymentDue){
        this.regimeType = regimeType;
        this.periodNo = periodNo;
        this.periodYear = periodYear;
        this.periodStart = toDate(periodStart);
        this.periodEnd = toDate(periodEnd);
        this.periodDue = toDate(periodDue);
        this.paymentDue = toDate(paymentDue);
    }
    public PeriodDetail() {
    }
    
    private Calendar toDate(Timestamp timeStamp) {
        if(timeStamp == null)
            return null;
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(timeStamp.getTime()));
        return c;
    }

    public void setRegimeType(String regimeType) {
        this.regimeType = regimeType;
    }

    public String getRegimeType() {
        return regimeType;
    }

    public void setPeriodNo(Long periodNo) {
        this.periodNo = periodNo;
    }

    public Long getPeriodNo() {
        return periodNo;
    }

    public void setPeriodYear(Long periodYear) {
        this.periodYear = periodYear;
    }

    public Long getPeriodYear() {
        return periodYear;
    }

    public void setPeriodStart(Calendar periodStart) {
        this.periodStart = periodStart;
    }

    public Calendar getPeriodStart() {
        return periodStart;
    }

    public void setPeriodEnd(Calendar periodEnd) {
        this.periodEnd = periodEnd;
    }

    public Calendar getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodDue(Calendar periodDue) {
        this.periodDue = periodDue;
    }

    public Calendar getPeriodDue() {
        return periodDue;
    }


    public void setPaymentDue(Calendar paymentDue) {
        this.paymentDue = paymentDue;
    }

    public Calendar getPaymentDue() {
        return paymentDue;
    }
}
