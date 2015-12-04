package com.technobrain.trips.dto.audit;

import com.technobrain.trips.dto.DataTransferObject;

import java.util.Calendar;

public class VisitReport implements DataTransferObject{
    private String status;
    private String period;
    private String visitType;
    private Calendar startDate;
    private String refNo;
    public VisitReport() {
    }
    public VisitReport(String refNo,Calendar startDate,String period,String visitType,String status) {
        this.refNo = refNo;
        this.startDate = startDate;
        this.period = period;
        this.visitType = visitType;
        this.status = status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getRefNo() {
        return refNo;
    }
}
