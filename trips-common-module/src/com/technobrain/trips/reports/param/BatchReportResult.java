package com.technobrain.trips.reports.param;

import com.technobrain.trips.dto.DataTransferObject;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BatchReportResult implements DataTransferObject {
    Long batchID;
    List<ReportResult> batchResult;
    String status;
    Calendar startTime;
    Calendar endTime;
    String message;
    public BatchReportResult() {
        batchResult = new ArrayList<ReportResult>();
    }

    public void setBatchID(Long batchID) {
        this.batchID = batchID;
    }

    public Long getBatchID() {
        return batchID;
    }

    public void setBatchResult(List<ReportResult> batchResult) {
        this.batchResult = batchResult;
    }

    public List<ReportResult> getBatchResult() {
        return batchResult;
    }

    public List<ReportResult> newBatch(int position, int batchSize) {
      List<ReportResult> reportResults =  new ArrayList<ReportResult>(batchSize);
      batchResult.addAll(reportResults);
      return reportResults;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
