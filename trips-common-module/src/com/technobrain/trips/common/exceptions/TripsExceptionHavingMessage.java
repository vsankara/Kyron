package com.technobrain.trips.common.exceptions;

public class TripsExceptionHavingMessage extends Exception {
    // stores the message that will be used in ui.
    String message = null;

    public TripsExceptionHavingMessage() {
    }
    
    public TripsExceptionHavingMessage(String message) {
        super();
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
