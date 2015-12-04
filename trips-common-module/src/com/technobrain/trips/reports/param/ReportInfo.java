package com.technobrain.trips.reports.param;

import com.technobrain.trips.reports.conf.DeliveryConfiguration;

public class ReportInfo {

    private DeliveryConfiguration deliveryConfiguration;
    private ReportDefInfo reportDefInfo;
    private ReportRequestInfo reportRequestInfo;
    private ReportResult reportResult;
    private ScheduleInfo scheduleInfo;

    public void setDeliveryConfiguration(DeliveryConfiguration deliveryConfiguration) {
        this.deliveryConfiguration = deliveryConfiguration;
    }

    public DeliveryConfiguration getDeliveryConfiguration() {
        return deliveryConfiguration;
    }

    public void setReportDefInfo(ReportDefInfo reportDefInfo) {
        this.reportDefInfo = reportDefInfo;
    }

    public ReportDefInfo getReportDefInfo() {
        return reportDefInfo;
    }

    public void setReportRequestInfo(ReportRequestInfo reportRequestInfo) {
        this.reportRequestInfo = reportRequestInfo;
    }

    public ReportRequestInfo getReportRequestInfo() {
        return reportRequestInfo;
    }

    public void setReportResult(ReportResult reportResult) {
        this.reportResult = reportResult;
    }

    public ReportResult getReportResult() {
        return reportResult;
    }

    public void setScheduleInfo(ScheduleInfo scheduleInfo) {
        this.scheduleInfo = scheduleInfo;
    }

    public ScheduleInfo getScheduleInfo() {
        return scheduleInfo;
    }
}
