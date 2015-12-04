package com.technobrain.trips.objectcomparison.dto;

import com.technobrain.trips.dto.DataTransferObject;


public class DifferenceDetail implements DataTransferObject{
    
    private boolean existInControlNodeOnly;
    private boolean existInTestNodeOnly;
    private boolean existInBothNode;
    private Object oldValue;
    private Object newValue;
    private String xpathName;
    private String formattedXpathName;
    private String parentClassName;
    private String resourceLabel;
    private String fieldName;
    
    public DifferenceDetail() {
    }

    public void setExistInControlNodeOnly(boolean existInControlNodeOnly) {
        this.existInControlNodeOnly = existInControlNodeOnly;
    }

    public boolean isExistInControlNodeOnly() {
        return existInControlNodeOnly;
    }

    public void setExistInTestNodeOnly(boolean existInTestNodeOnly) {
        this.existInTestNodeOnly = existInTestNodeOnly;
    }

    public boolean isExistInTestNodeOnly() {
        return existInTestNodeOnly;
    }

    public void setExistInBothNode(boolean existInBothNode) {
        this.existInBothNode = existInBothNode;
    }

    public boolean isExistInBothNode() {
        return existInBothNode;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public void setXpathName(String xpathName) {
        this.xpathName = xpathName;
    }

    public String getXpathName() {
        return xpathName;
    }

    public void setFormattedXpathName(String formattedXpathName) {
        this.formattedXpathName = formattedXpathName;
    }

    public String getFormattedXpathName() {
        return formattedXpathName;
    }

    public void setResourceLabel(String resourceLabel) {
        this.resourceLabel = resourceLabel;
    }

    public String getResourceLabel() {
        return resourceLabel;
    }

    public void setParentClassName(String parentClassName) {
        this.parentClassName = parentClassName;
    }

    public String getParentClassName() {
        return parentClassName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
