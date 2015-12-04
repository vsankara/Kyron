package com.technobrain.trips.reports.dto;

import com.technobrain.trips.dto.DataTransferObject;

public class ColumnData implements DataTransferObject{
    private String fieldName;
    private Object fieldValue;
    private DateRowParameter parameter;
    private boolean internalKey;
    
    public ColumnData() {
    }
    
    public String toString(){
        return "" + fieldName + " " + fieldValue;
    }
    
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setParameter(DateRowParameter parameter) {
        this.parameter = parameter;
    }

    public DateRowParameter getParameter() {
        return parameter;
    }

    public void setInternalKey(boolean internalKey) {
        this.internalKey = internalKey;
    }

    public boolean isInternalKey() {
        return internalKey;
    }
}
