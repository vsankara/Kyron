package com.technobrain.trips.common.exceptions;

public class TripsInvalidParameterException extends Exception {
    public TripsInvalidParameterException() {
    }
    
    public TripsInvalidParameterException(String message) {
        super(message);
    }
}
