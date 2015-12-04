package com.technobrain.trips.dto.registration;

import com.technobrain.trips.dto.DataTransferObject;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.Calendar;

/**
 * TechnoBrain 2015
 * This is a DTO that is used for regime related functionality such as suspend,
 * re-activate,re-register etc. 
 * 
 * @since $Date: 10/1/2009 1:10:45 AM$
 * @version $Revision: 6$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  6    TRIPS2 etis.bir.gov.ph1.3.1.1     10/1/2009 1:10:45 AM   Howard Hill  
 *         added suspended date
 * $
 */
public class RegimeRelatedActionDetail implements DataTransferObject {
    private Long id;
    private String regimeType;
    private String regimeNumber;
    private Calendar edr;
    private Calendar edd;
    private Calendar eds;
    private Calendar suspendedDate;
    private Calendar suspensionEndDate;
    private String status;
    

    public RegimeRelatedActionDetail(Long id, String regimeType, String regimeNumber, Timestamp edr, Timestamp edd , Timestamp eds , String status, Timestamp suspensionEnd) {
        this.id = id;
        this.regimeType = regimeType;
        this.regimeNumber = regimeNumber;
        this.edr = toDate(edr);
        this.edd = toDate(edd);
        this.eds = toDate(eds);
        this.suspensionEndDate = toDate(suspensionEnd);
        this.status = status;
    }

    public RegimeRelatedActionDetail(Long id,String regimeType,String regimeNumber,Timestamp edr, Timestamp edd , Timestamp eds , String status) {
        this.id = id;
        this.regimeType = regimeType;
        this.regimeNumber = regimeNumber;
        this.edr = toDate(edr);
        this.edd = toDate(edd);
        this.eds = toDate(eds);
        this.status = status;
    }
    
    public RegimeRelatedActionDetail(Long id,String regimeType,String regimeNumber,Timestamp edr,Timestamp edd,String status) {
        this.id = id;
        this.regimeType = regimeType;
        this.regimeNumber = regimeNumber;
        this.edr = toDate(edr);
        this.edd = toDate(edd);
        this.status = status;
    }
    /**
     * Converts to a Calendar
     * @param timeStamp
     * @return
     */
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

    public void setRegimeNumber(String regimeNumber) {
        this.regimeNumber = regimeNumber;
    }

    public String getRegimeNumber() {
        return regimeNumber;
    }

    public void setEdr(Calendar edr) {
        this.edr = edr;
    }

    public Calendar getEdr() {
        return edr;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setEdd(Calendar edd) {
        this.edd = edd;
    }

    public Calendar getEdd() {
        return edd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setEds(Calendar eds) {
        this.eds = eds;
    }

    public Calendar getEds() {
        return eds;
    }

    public void setSuspendedDate(Calendar suspendedDate) {
        this.suspendedDate = suspendedDate;
    }

    public Calendar getSuspendedDate() {
        return suspendedDate;
    }

    public void setSuspensionEndDate(Calendar suspensionEndDate) {
        this.suspensionEndDate = suspensionEndDate;
    }

    public Calendar getSuspensionEndDate() {
        return suspensionEndDate;
    }
}
