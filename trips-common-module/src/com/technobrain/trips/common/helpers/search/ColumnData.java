package com.technobrain.trips.common.helpers.search;

import java.io.Serializable;

public class ColumnData implements Serializable {
    private int sequenceNbr;
    private String fieldName;
    private String columnName;
    private Object value;
    private Object code;
    private boolean primaryKey;
    private boolean shouldGetValueFromResource;
    private String tableNameForAccessLevelUpdate;
    /**
     * 
     * @param seqNbr
     * @param fieldName
     * @param value
     */
    public ColumnData(int seqNbr,String fieldName,Object value) {
        this.sequenceNbr = seqNbr;
        this.fieldName = fieldName;
        this.value = value;
    }
    
    public ColumnData(int seqNbr,String fieldName,Object value,boolean isPimaryKey) {
        this.sequenceNbr = seqNbr;
        this.fieldName = fieldName;
        this.value = value;
        this.primaryKey = isPimaryKey;
    }
    
    public void setSequenceNbr(int number) {
        this.sequenceNbr = number;
    }

    public int getSequenceNbr() {
        return sequenceNbr;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setPrimaryKey(boolean isPrimaryKey) {
        this.primaryKey = isPrimaryKey;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getCode() {
        return code;
    }

    public void setShouldGetValueFromResource(boolean shouldGetValueFromResource) {
        this.shouldGetValueFromResource = shouldGetValueFromResource;
    }

    public boolean isShouldGetValueFromResource() {
        return shouldGetValueFromResource;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setTableNameForAccessLevelUpdate(String tableNameForAccessLevelUpdate) {
        this.tableNameForAccessLevelUpdate = tableNameForAccessLevelUpdate;
    }

    public String getTableNameForAccessLevelUpdate() {
        return tableNameForAccessLevelUpdate;
    }
}
