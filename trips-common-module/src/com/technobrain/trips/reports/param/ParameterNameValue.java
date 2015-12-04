package com.technobrain.trips.reports.param;

import java.util.List;




public class ParameterNameValue {
    private boolean multiValuesAllowed;

    private java.lang.String name;
    
    private java.lang.String label;

    private java.lang.String[] values;
    
    private java.lang.String controlType;
    
    private java.lang.String mandatory;
    
    private java.lang.String defaultValue;
    

    public void setMultiValuesAllowed(boolean multiValuesAllowed) {
        this.multiValuesAllowed = multiValuesAllowed;
    }

    public boolean isMultiValuesAllowed() {
        return multiValuesAllowed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    
    public void setValues(String[] values) {
        this.values = values;
    }

    public String[] getValues() {
        return values;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public String getControlType() {
        return controlType;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }


}
