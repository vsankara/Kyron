package com.technobrain.trips.reports.dto;

import java.util.ArrayList;
import java.util.List;

public class RowData {
    private List<ColumnData> columns = new ArrayList<ColumnData>();

    public void setColumns(List<ColumnData> columns) {
        this.columns = columns;
    }

    public List<ColumnData> getColumns() {
        return columns;
    }

    public void addColumn(ColumnData columnData) {
        columns.add(columnData);
    }

    public ColumnData getColumn(String fieldName) {
        for(int i=0; i< columns.size(); i++){
            if(fieldName.equalsIgnoreCase(((ColumnData)columns.get(i)).getFieldName())){
                return columns.get(i);
            }
        }
        
        return null;
    }
}
