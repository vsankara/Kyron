package com.technobrain.trips.common.exceptions;

public class TripsScriptException extends Exception {
    public TripsScriptException() {
    }

    public TripsScriptException(String msg) {
        super(msg);
    }
    public TripsScriptException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
