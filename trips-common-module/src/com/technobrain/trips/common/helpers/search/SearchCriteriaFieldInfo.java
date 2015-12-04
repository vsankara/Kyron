package com.technobrain.trips.common.helpers.search;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class SearchCriteriaFieldInfo implements Serializable, Comparable  {
    private String fieldName;
    private String fieldType;
    private String fieldLabel;
    private String originalFieldLabel;
    private String columnName;
    private ArrayList options;
    private Object fieldValue;
    private String fieldLink;
    private String fieldLinkValue;
    private String operator;    
    private boolean required = false;
    private String listId;
    private String listType;
    private int displayOrder = 0;
    private String searchId;
    private List<SearchTrigger> triggerList;
    private boolean disabled = false;
    private boolean multipleLines = false;
    private boolean visible = true;
    private boolean fieldValuesStaticallyGiven;
    private Integer decimalLength;
    private boolean putThousandSeparator = false;
    private boolean firstItemSelected = false;
    private String description;
    private String fieldFunction;
    private String alternateParameter;
    private String alternateOperator;
    private String alternateColumn;
    private String alternateColumnOperator;
    private boolean fieldValuesDynamicallyGiven;
    private String wildCard; 
    
    public SearchCriteriaFieldInfo(String fieldName, String fieldType, 
                           String fieldLabel, String columnName,String operator) {
        this.fieldType=fieldType;
        this.fieldName=fieldName;
        this.fieldLabel=fieldLabel;
        this.columnName=columnName;
        this.operator=operator;   
        options=new ArrayList();
    }
    
    public SearchCriteriaFieldInfo(String fieldName, String fieldType, 
                           String fieldLabel, String columnName,String operator, String wildCard) {
        this.fieldType=fieldType;
        this.fieldName=fieldName;
        this.fieldLabel=fieldLabel;
        this.columnName=columnName;
        this.operator=operator;   
        this.wildCard = wildCard;
        options=new ArrayList();
    }
    
    public ArrayList getOptions() {
        return options;
    }

    public void setOptions(ArrayList options) {
        this.options = options;
    }
    public String  getOperator() {
        return operator;
    }
    
    public String[] getColumnNames() {
        return getColumnName().replace(" ","").split(",");
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public boolean isDropDown(){
        if(listId != null && !listId.equals("")){
            return true;
        }
        if(options==null){
            return false;
        }
        if(options.size()==0){
            return false;
        }
        return true;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isRequired() {
        return required;
    }

    public void setFieldLink(String fieldLink) {
        this.fieldLink = fieldLink;
    }

    public String getFieldLink() {
        return fieldLink;
    }

    public void setFieldLinkValue(String fieldLinkValue) {
        this.fieldLinkValue = fieldLinkValue;
    }

    public String getFieldLinkValue() {
        return fieldLinkValue;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getListId() {
        return listId;
    }

    public int compareTo(Object fieldIn){
        return this.displayOrder > ((SearchCriteriaFieldInfo)fieldIn).displayOrder?1:0;
    }

    public void setTriggerList(List<SearchTrigger> triggerList) {
        this.triggerList = triggerList;
    }

    public List<SearchTrigger> getTriggerList() {
        return triggerList;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public String getSearchId() {
        return searchId;
    }
    
    public boolean isLookUp() {
        if(searchId == null)
            return false;
        return true;
    }
    
    /**
     * If this criteria must be triggered by the given field, then there must be SearchTrigger found in this criteria.
     * This method finds that SearchTrigger if there is.
     * 
     * @param triggeringFieldName
     * @return
     */
    public SearchTrigger findTriggerInfo(String triggeringFieldName) {
        if(triggerList == null || triggerList.size() == 0 || triggeringFieldName == null)
            return null;
        for (int i = 0; i < triggerList.size(); i++)  {
            SearchTrigger trigger = triggerList.get(i);
            if(trigger.getTriggeringFieldName() != null &&
                trigger.getTriggeringFieldName().equals(triggeringFieldName))
                return trigger;
        }
        return null;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setMultipleLines(boolean multipleLines) {
        this.multipleLines = multipleLines;
    }

    public boolean isMultipleLines() {
        return multipleLines;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setFieldValuesStaticallyGiven(boolean fieldValuesStaticallyGiven) {
        this.fieldValuesStaticallyGiven = fieldValuesStaticallyGiven;
    }

    public boolean isFieldValuesStaticallyGiven() {
        return fieldValuesStaticallyGiven;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }

    public Object getFieldValue() {
        return fieldValue;
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

    public void setFirstItemSelected(boolean firstItemSelected) {
        this.firstItemSelected = firstItemSelected;
    }

    public boolean isFirstItemSelected() {
        return firstItemSelected;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getListType() {
        return listType;
    }
    
    public String getTableName() {
        if(columnName == null || !columnName.contains("."))
            return null;
        return columnName.substring(0, columnName.indexOf("."));
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public void setOriginalFieldLabel(String originalFieldLabel) {
        this.originalFieldLabel = originalFieldLabel;
    }

    public String getOriginalFieldLabel() {
        return originalFieldLabel;
    }

    public void setFieldFunction(String fieldFunction) {
        this.fieldFunction = fieldFunction;
    }

    public String getFieldFunction() {
        return fieldFunction;
    }

    public void setAlternateParameter(String alternateParameter) {
        this.alternateParameter = alternateParameter;
    }

    public String getAlternateParameter() {
        return alternateParameter;
    }

    public void setAlternateOperator(String alternateOperator) {
        this.alternateOperator = alternateOperator;
    }

    public String getAlternateOperator() {
        return alternateOperator;
    }

    public void setFieldValuesDynamicallyGiven(boolean fieldValuesDynamicallyGiven) {
        this.fieldValuesDynamicallyGiven = fieldValuesDynamicallyGiven;
    }

    public boolean isFieldValuesDynamicallyGiven() {
        return fieldValuesDynamicallyGiven;
    }

    public void setAlternateColumn(String alternateColumn) {
        this.alternateColumn = alternateColumn;
    }

    public String getAlternateColumn() {
        return alternateColumn;
    }

    public void setAlternateColumnOperator(String alternateColumnOperator) {
        this.alternateColumnOperator = alternateColumnOperator;
    }

    public String getAlternateColumnOperator() {
        return alternateColumnOperator;
    }
    
    public void setWildCard(String wildCard) {
        this.wildCard = wildCard;
    }

    public String getWildCard() {
        return wildCard;
    }
}


