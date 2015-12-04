package com.technobrain.trips.dto.tax;

import com.technobrain.trips.dto.DataTransferObject;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Calendar;

/**
 * Crown Agents 2007
 * <br>
 * Represents the Tax Refunds Transfer Object.
 * @since $Date: 2/11/2009 3:47:43 AM$
 * @version $Revision: 9$
 * @author $Author: Idris Yildiz$
 * 
 * $Log[1]:
 *  9    TRIPS2    1.8         2/11/2009 3:47:43 AM   Idris Yildiz    Column
 *       formatType changed to number and converter added for decimal
 *       formatting. Null values for periods converted to empty string.
 * $
 */
public class TaxRefunds implements DataTransferObject{
    private Calendar refundDate;
    private String regimeType;
    private String regimeNumber;
    private String period;
    private BigDecimal acctBalance;
    private BigDecimal amountClaimed;
    private Long documentID;
    private String status;
    private BigDecimal startPeriodNo;
    private String startPeriodYear;
    private BigDecimal endPeriodNo;
    private String endPeriodYear;
    
    public TaxRefunds() {
    }

    public TaxRefunds(Long documentID,Timestamp refundDate,String regimeType,String regimeNumber,String period,BigDecimal acctBalance,BigDecimal amountClaimed) {
            this.documentID = documentID;
            Calendar c = Calendar.getInstance();
            if(refundDate != null){
                c.setTimeInMillis(refundDate.getTime());
                this.refundDate = c; 
            }
            
            this.regimeType = regimeType;
            this.regimeNumber = regimeNumber;
            this.period = period;
            this.acctBalance = acctBalance;
            this.amountClaimed = amountClaimed;
       }

    
    public TaxRefunds(Long documentID,Timestamp refundDate,String regimeType,
                        String regimeNumber,String period,BigDecimal acctBalance,BigDecimal amountClaimed, String status,
                        BigDecimal startPeriodNo, String startPeriodYear, BigDecimal endPeriodNo, String endPeriodYear) {
                        
        this.documentID = documentID;
        Calendar c = Calendar.getInstance();
        if(refundDate != null){
            c.setTimeInMillis(refundDate.getTime());
            this.refundDate = c; 
        }
        
        this.regimeType = regimeType;
        this.regimeNumber = regimeNumber;
        this.period = period;
        this.acctBalance = acctBalance;
        this.amountClaimed = amountClaimed;
        
        this.status = status;
        
        this.startPeriodNo = startPeriodNo;
        this.startPeriodYear = startPeriodYear;
        this.endPeriodNo = endPeriodNo;
        this.endPeriodYear = endPeriodYear;
    }
    
    public void setRefundDate(Calendar refundDate) {
        this.refundDate = refundDate;
    }
    
    public Calendar getRefundDate() {
        return refundDate;
    }

    public void setRegimeType(String regimeType) {
        this.regimeType = regimeType;
    }

    public String getRegimeType() {
        return regimeType;
    }

    public void setRegimeNumber(String regimeNumber) {
        this.regimeNumber = regimeNumber;
    }

    public String getRegimeNumber() {
        return regimeNumber;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public void setAcctBalance(BigDecimal acctBalance) {
        this.acctBalance = acctBalance;
    }

    public BigDecimal getAcctBalance() {
        return acctBalance;
    }

    public void setAmountClaimed(BigDecimal amountClaimed) {
        this.amountClaimed = amountClaimed;
    }

    public BigDecimal getAmountClaimed() {
        return amountClaimed;
    }

    public void setDocumentID(Long documentID) {
        this.documentID = documentID;
    }

    public Long getDocumentID() {
        return documentID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStartPeriodNo(BigDecimal startPeriodNo) {
        this.startPeriodNo = startPeriodNo;
    }

    public BigDecimal getStartPeriodNo() {
        return startPeriodNo;
    }

    public void setStartPeriodYear(String startPeriodYear) {
        this.startPeriodYear = startPeriodYear;
    }

    public String getStartPeriodYear() {
        return startPeriodYear;
    }

    public void setEndPeriodNo(BigDecimal endPeriodNo) {
        this.endPeriodNo = endPeriodNo;
    }

    public BigDecimal getEndPeriodNo() {
        return endPeriodNo;
    }

    public void setEndPeriodYear(String endPeriodYear) {
        this.endPeriodYear = endPeriodYear;
    }

    public String getEndPeriodYear() {
        return endPeriodYear;
    }

    public String getEndPeriod() {
        if(endPeriodNo==null && endPeriodYear==null){
            return "";
        } else {
            return endPeriodNo + "/" + endPeriodYear;
        }
    }

    public String getStartPeriod() {

        if(startPeriodNo==null && startPeriodYear==null){
            return "";
        } else {
            return startPeriodNo + "/" + startPeriodYear;
        }
    }
    
}
