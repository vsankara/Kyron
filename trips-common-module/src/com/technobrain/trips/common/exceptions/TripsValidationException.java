package com.technobrain.trips.common.exceptions;

public class TripsValidationException extends Exception {
    // stores the message that will be used in ui.
    String message = null;
    String[] messageParameters;
    
    public TripsValidationException() {
    }

    public TripsValidationException(String message, String messageParameter) {
        super();
        this.message = message;
        this.messageParameters = new String[1];
        messageParameters[0] = messageParameter;
    }

    public TripsValidationException(String message, String[] messageParameters) {
        super();
        this.message = message;
        this.messageParameters = new String[1];
        this.messageParameters = messageParameters;
    }
    
    public TripsValidationException(String message) {
        super();
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessageParameters(String[] messageParameters) {
        this.messageParameters = messageParameters;
    }

    public String[] getMessageParameters() {
        return messageParameters;
    }
}
