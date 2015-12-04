package com.technobrain.trips.common.helpers.search;

import java.io.Serializable;

public class SearchOrderByInfo implements Serializable {
    private String columnName;
    private String order;
    
    public SearchOrderByInfo() {
    }

    public SearchOrderByInfo(String column) {
        this.columnName = column;
        this.order = "ASC";
    }

    public SearchOrderByInfo(String column, String order) {
        this.columnName = column;
        this.order = order;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }
}
