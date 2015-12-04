package com.technobrain.trips.dto.job;

import com.technobrain.trips.dto.DataTransferObject;

import java.math.BigDecimal;

public class JobStream implements DataTransferObject{
    
    private String jobStreamName;
    private BigDecimal noOfJobs;
    private BigDecimal noOfJobsPassed;
    private BigDecimal noOfJobsFailed;
    private String jobStreamStatus;
    
    public JobStream(String jobStreamName, BigDecimal noOfJobs, BigDecimal noOfJobsPassed, BigDecimal noOfJobsFailed, String jobStreamStatus){
        this.jobStreamName = jobStreamName;
        this.noOfJobs = noOfJobs;
        this.noOfJobsPassed = noOfJobsPassed;
        this.noOfJobsFailed = noOfJobsFailed;
        this.jobStreamStatus = jobStreamStatus;
    }


    public void setJobStreamName(String jobStreamName) {
        this.jobStreamName = jobStreamName;
    }

    public String getJobStreamName() {
        return jobStreamName;
    }

    public void setNoOfJobs(BigDecimal noOfJobs) {
        this.noOfJobs = noOfJobs;
    }

    public BigDecimal getNoOfJobs() {
        return noOfJobs;
    }

    public void setNoOfJobsPassed(BigDecimal noOfJobsPassed) {
        this.noOfJobsPassed = noOfJobsPassed;
    }

    public BigDecimal getNoOfJobsPassed() {
        return noOfJobsPassed;
    }

    public void setNoOfJobsFailed(BigDecimal noOfJobsFailed) {
        this.noOfJobsFailed = noOfJobsFailed;
    }

    public BigDecimal getNoOfJobsFailed() {
        return noOfJobsFailed;
    }

    public void setJobStreamStatus(String jobStreamStatus) {
        this.jobStreamStatus = jobStreamStatus;
    }

    public String getJobStreamStatus() {
        return jobStreamStatus;
    }
}
