package com.technobrain.trips.reports.param;

import java.io.Serializable;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReportResult implements Serializable{
    private byte[] reportBytes;
    private Long id;
    private java.lang.String reportContentType;
    private Object reference;
    private String template;
    private String reportName;
    private String reportStatus;
    private String attempts;
    List<ReportResult> ReportResult;
    private Date issueDate;
    private String documnetType;
    private java.lang.String reportLocale;
    private Long revAcc;
    private Long noOfCopies;

    public void setReportBytes(byte[] reportBytes) {
        this.reportBytes = reportBytes;
    }

    public byte[] getReportBytes() {
        return reportBytes;
    }

    public void setReportContentType(String reportContentType) {
        this.reportContentType = reportContentType;
    }

    public String getReportContentType() {
        return reportContentType;
    }

    public void setReportLocale(String reportLocale) {
        this.reportLocale = reportLocale;
    }

    public String getReportLocale() {
        return reportLocale;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setReference(Object reference) {
        this.reference = reference;
    }

    public Object getReference() {
        return reference;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setAttempts(String attempts) {
        this.attempts = attempts;
    }

    public String getAttempts() {
        return attempts;
    }

    public void setReportResult(List<ReportResult> reportResult) {
        this.ReportResult = reportResult;
    }

    public List<ReportResult> getReportResult() {
        return ReportResult;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setDocumnetType(String documnetType) {
        this.documnetType = documnetType;
    }

    public String getDocumnetType() {
        return documnetType;
    }

    public void setRevAcc(Long revAcc) {
        this.revAcc = revAcc;
    }

    public Long getRevAcc() {
        return revAcc;
    }

    public void setNoOfCopies(Long noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    public Long getNoOfCopies() {
        return noOfCopies;
    }
}
