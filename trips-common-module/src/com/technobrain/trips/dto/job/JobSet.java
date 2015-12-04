package com.technobrain.trips.dto.job;

import com.technobrain.trips.dto.DataTransferObject;

import java.math.BigDecimal;

public class JobSet implements DataTransferObject{
    
    private String jobSetName;
    private BigDecimal noOfStream;
    private BigDecimal noOfStreamPassed;
    private BigDecimal noOfStreamFailed;
    private String jobSetStatus;
    
    public JobSet(String jobSetName, BigDecimal noOfStream, BigDecimal noOfStreamPassed, BigDecimal noOfStreamFailed, String jobSetStatus){
        this.jobSetName = jobSetName;
        this.noOfStream = noOfStream;
        this.noOfStreamPassed = noOfStreamPassed;
        this.noOfStreamFailed = noOfStreamFailed;
        this.jobSetStatus = jobSetStatus;
    }

    public void setJobSetName(String jobSetName) {
        this.jobSetName = jobSetName;
    }

    public String getJobSetName() {
        return jobSetName;
    }

    public void setNoOfStream(BigDecimal noOfStream) {
        this.noOfStream = noOfStream;
    }

    public BigDecimal getNoOfStream() {
        return noOfStream;
    }

    public void setNoOfStreamPassed(BigDecimal noOfStreamPassed) {
        this.noOfStreamPassed = noOfStreamPassed;
    }

    public BigDecimal getNoOfStreamPassed() {
        return noOfStreamPassed;
    }

    public void setNoOfStreamFailed(BigDecimal noOfStreamFailed) {
        this.noOfStreamFailed = noOfStreamFailed;
    }

    public BigDecimal getNoOfStreamFailed() {
        return noOfStreamFailed;
    }

    public void setJobSetStatus(String jobSetStatus) {
        this.jobSetStatus = jobSetStatus;
    }

    public String getJobSetStatus() {
        return jobSetStatus;
    }
}
