package com.technobrain.trips.dto.reports;

import com.technobrain.trips.dto.DataTransferObject;

public class JobControl implements DataTransferObject {
    String startControlNumber;
    String endControlNumber;
    String jobType;
    Long batchSize;
    String documentType;
    Long numberOfRecords;
    public JobControl() {
    }

    public void setStartControlNumber(String startControlNumber) {
        this.startControlNumber = startControlNumber;
    }

    public String getStartControlNumber() {
        return startControlNumber;
    }

    public void setEndControlNumber(String endControlNumber) {
        this.endControlNumber = endControlNumber;
    }

    public String getEndControlNumber() {
        return endControlNumber;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobType() {
        return jobType;
    }

    public void setBatchSize(Long batchSize) {
        this.batchSize = batchSize;
    }

    public Long getBatchSize() {
        return batchSize;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setNumberOfRecords(Long numberOfRecords) {
        this.numberOfRecords = numberOfRecords;
    }

    public Long getNumberOfRecords() {
        return numberOfRecords;
    }
}
