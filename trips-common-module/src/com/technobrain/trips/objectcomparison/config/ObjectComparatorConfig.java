package com.technobrain.trips.objectcomparison.config;

import java.util.List;


public class ObjectComparatorConfig {
    private Object controlObject;
    private Object testObject;
    private List<String> ignoreFields;
    private List<String> ignoreXpathFields;
    
    public ObjectComparatorConfig() {
    }

    public void setControlObject(Object controlObject) {
        this.controlObject = controlObject;
    }

    public Object getControlObject() {
        return controlObject;
    }

    public void setTestObject(Object testObject) {
        this.testObject = testObject;
    }

    public Object getTestObject() {
        return testObject;
    }


    public void setIgnoreFields(List<String> ignoreFields) {
        this.ignoreFields = ignoreFields;
    }

    public List<String> getIgnoreFields() {
        return ignoreFields;
    }

    public void setIgnoreXpathFields(List<String> ignoreXpathFields) {
        this.ignoreXpathFields = ignoreXpathFields;
    }

    public List<String> getIgnoreXpathFields() {
        return ignoreXpathFields;
    }
}
