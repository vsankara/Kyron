package com.technobrain.trips.common.exceptions;

import java.util.List;

public class TripsRuntimeIllegalAccessError extends IllegalAccessError {
    private List<String> parameters;
    public TripsRuntimeIllegalAccessError(String message) {
        super(message);
    }
    
    public TripsRuntimeIllegalAccessError(String message, List<String> parameters) {
        super(message);
        this.parameters = parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public List<String> getParameters() {
        return parameters;
    }
}
