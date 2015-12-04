package com.technobrain.trips.common.helpers.search;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.StringHelper;

import java.io.Serializable;

import java.util.ArrayList;


public class SearchResultFieldInfo implements Serializable {
    private String fieldType;
    private String columnHeading;// this is the column heading from the resources file.
    private String originalColumnHeading;// this is the column heading which is given in the search.config.xml file.
    private String columnName;
    private ArrayList options;
    private String isIdField;
    private int columnOrderNbr;
    private String fieldName;   
    private String visible;
    private Integer decimalLength;
    private boolean putThousandSeparator = false;
    private boolean navigationControllingField;
    private boolean getValueFromResources;
    public static final String CURRENCY_TYPE = "number";
    public static final String FIELD_TYPE_DECIMAL = "decimal";
    public static final String FIELD_TYPE_NUMBER = "number";

    public SearchResultFieldInfo(String fieldName,String fieldType, String columnHeading, 
                                 String columnName, String isIdField, 
                                 int columnOrderNbr) {
        this.setFieldName(fieldName);        
        this.setFieldType(fieldType);
        this.setColumnHeading(columnHeading);
        this.setColumnName(columnName);
        this.setIsIdField(isIdField);
        this.setColumnOrderNbr(columnOrderNbr);        
        setOptions(new ArrayList());
    }

    public ArrayList getOptions() {
        return options;
    }

    public void setOptions(ArrayList options) {
        this.options = options;
    }


    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getColumnHeading() {
        return columnHeading;
    }

    public void setColumnHeading(String columnHeading) {
        this.columnHeading = columnHeading;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getIsIdField() {
        return isIdField;
    }
    public boolean isIdField() {
        return StringHelper.returnBlankIfNull(getIsIdField()).equals(Constants.YES);
    }

    public void setIsIdField(String isIdField) {
        this.isIdField = isIdField;
    }

    public int getColumnOrderNbr() {
        return columnOrderNbr;
    }

    public void setColumnOrderNbr(int columnOrderNbr) {
        this.columnOrderNbr = columnOrderNbr;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getVisible() {
        return visible;
    }

    public void setDecimalLength(Integer decimalLength) {
        this.decimalLength = decimalLength;
    }

    public Integer getDecimalLength() {
        return decimalLength;
    }

    public void setPutThousandSeparator(boolean putThousandSeparator) {
        this.putThousandSeparator = putThousandSeparator;
    }

    public boolean isPutThousandSeparator() {
        return putThousandSeparator;
    }

    public void setNavigationControllingField(boolean navigationControllingField) {
        this.navigationControllingField = navigationControllingField;
    }

    public boolean isNavigationControllingField() {
        return navigationControllingField;
    }

    public void setGetValueFromResources(boolean getValueFromResources) {
        this.getValueFromResources = getValueFromResources;
    }

    public boolean isGetValueFromResources() {
        return getValueFromResources;
    }
    
    public String getTableName() {
        return getTableName(columnName);
    }
    
    public String getTableName(String columnName) {
        if(columnName == null || !columnName.contains("."))
            return null;
        return columnName.substring(0, columnName.indexOf("."));
    }
    
    public boolean isPrimaryKey() {
        return getIsIdField() != null && getIsIdField().equalsIgnoreCase("Y");
    }

    public void setOriginalColumnHeading(String originalColumnHeading) {
        this.originalColumnHeading = originalColumnHeading;
    }

    public String getOriginalColumnHeading() {
        return originalColumnHeading;
    }
}


