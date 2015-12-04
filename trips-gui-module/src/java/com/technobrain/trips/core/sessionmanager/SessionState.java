package com.technobrain.trips.core.sessionmanager;

import java.io.Serializable;

public class SessionState implements Serializable {
    private String viewId;

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public String getViewId() {
        return viewId;
    }

}
