package com.technobrain.trips.reports.param;

import java.util.Date;


public class ScheduledJobHistoryInfo {

    public static final String VIEWBYFILTER_ALL = "All";
    public static final String VIEWBYFILTER_PUBLICHISTORY = "Public History";
    public static final String VIEWBYFILTER_MYHISTORY = "My History";

    private int jobID;

    private java.lang.String jobName;

    private java.lang.String reportName;

    private int outputID;

    private java.util.Date createdDate;

    private java.lang.String userName;

    private java.lang.String jobMessage;

    private java.lang.String statusDetail;

    private java.lang.String status;

    private boolean documentDataAvailable;

    private boolean reportDataAvailable;

    private java.lang.String reportURL;

    private java.lang.String documentDataContentType;

    private java.lang.String reportDataContentType;

    private byte[] reportData;

    private byte[] documentOutput;

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportName() {
        return reportName;
    }

    public void setOutputID(int outputID) {
        this.outputID = outputID;
    }

    public int getOutputID() {
        return outputID;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setJobMessage(String jobMessage) {
        this.jobMessage = jobMessage;
    }

    public String getJobMessage() {
        return jobMessage;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDocumentDataAvailable(boolean documentDataAvailable) {
        this.documentDataAvailable = documentDataAvailable;
    }

    public boolean isDocumentDataAvailable() {
        return documentDataAvailable;
    }

    public void setReportDataAvailable(boolean reportDataAvailable) {
        this.reportDataAvailable = reportDataAvailable;
    }

    public boolean isReportDataAvailable() {
        return reportDataAvailable;
    }

    public void setReportURL(String reportURL) {
        this.reportURL = reportURL;
    }

    public String getReportURL() {
        return reportURL;
    }

    public void setDocumentDataContentType(String documentDataContentType) {
        this.documentDataContentType = documentDataContentType;
    }

    public String getDocumentDataContentType() {
        return documentDataContentType;
    }

    public void setReportDataContentType(String reportDataContentType) {
        this.reportDataContentType = reportDataContentType;
    }

    public String getReportDataContentType() {
        return reportDataContentType;
    }

    public void setReportData(byte[] reportData) {
        this.reportData = reportData;
    }

    public byte[] getReportData() {
        return reportData;
    }

    public void setDocumentOutput(byte[] documentOutput) {
        this.documentOutput = documentOutput;
    }

    public byte[] getDocumentOutput() {
        return documentOutput;
    }
}
