package com.technobrain.trips.reports.param;

public class ReportRequestInfo {
    
    private String reportName;
    
    private java.lang.String reportFormat;

    private java.lang.String reportLocale;

    private java.lang.String reportTemplate;

    private ParameterNameValue[] parameterNameValues;
    
    private String reportAbsolutePath;
    
    private String reportSource;
    
    private String printerName;

    private Long noOfCopies;
    
    public void setReportFormat(String reportFormat) {
        this.reportFormat = reportFormat;
    }

    public String getReportFormat() {
        return reportFormat;
    }

    public void setReportLocale(String reportLocale) {
        this.reportLocale = reportLocale;
    }

    public String getReportLocale() {
        return reportLocale;
    }

    public void setReportTemplate(String reportTemplate) {
        this.reportTemplate = reportTemplate;
    }

    public String getReportTemplate() {
        return reportTemplate;
    }

    public void setReportAbsolutePath(String reportAbsolutePath) {
        this.reportAbsolutePath = reportAbsolutePath;
    }

    public String getReportAbsolutePath() {
        return reportAbsolutePath;
    }

    public void setParameterNameValues(ParameterNameValue[] parameterNameValues) {
        this.parameterNameValues = parameterNameValues;
    }

    public ParameterNameValue[] getParameterNameValues() {
        return parameterNameValues;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportSource(String reportSource) {
        this.reportSource = reportSource;
    }

    public String getReportSource() {
        return reportSource;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public String getPrinterName() {
        return printerName;
    }


    public void setNoOfCopies(Long noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    public Long getNoOfCopies() {
        return noOfCopies;
    }
}
