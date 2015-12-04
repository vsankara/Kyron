package com.technobrain.trips.common.helpers.search;

import java.io.Serializable;

public class SearchTrigger implements Serializable{
    private String triggeringFieldName;
    private String resultFieldName;
    
    public SearchTrigger(String triggeringFieldName, String resultFieldName) {
        this.triggeringFieldName = triggeringFieldName;
        this.resultFieldName = resultFieldName;
    }

    public void setTriggeringFieldName(String triggeringFieldName) {
        this.triggeringFieldName = triggeringFieldName;
    }

    public String getTriggeringFieldName() {
        return triggeringFieldName;
    }

    public void setResultFieldName(String resultFieldName) {
        this.resultFieldName = resultFieldName;
    }

    public String getResultFieldName() {
        return resultFieldName;
    }
}
