package com.technobrain.trips.common.helpers.jobs;

import java.sql.Timestamp;

public class JobLogSearchCriteria {
    private String jobSet;
    private String status;
    private Timestamp fromDate;
    private Timestamp toDate;
    
    public JobLogSearchCriteria() {
    }

    public void setJobSet(String jobSet) {
        this.jobSet = jobSet;
    }

    public String getJobSet() {
        return jobSet;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }


    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public Timestamp getToDate() {
        return toDate;
    }
}
