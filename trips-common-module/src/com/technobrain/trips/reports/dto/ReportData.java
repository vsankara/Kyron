package com.technobrain.trips.reports.dto;

import com.technobrain.trips.dto.DataTransferObject;

import java.util.ArrayList;
import java.util.List;

public class ReportData implements DataTransferObject{
    public List<RowData> rows = new ArrayList<RowData>();
    
    public ReportData() {
    }

    public void setRows(List<RowData> data) {
        this.rows = data;
    }

    public List<RowData> getRows() {
        return rows;
    }

    public void addRow(RowData dataRow) {
        this.rows.add(dataRow);
    }

    public boolean hasData() {
        return rows != null ? true : false;
    }
}
