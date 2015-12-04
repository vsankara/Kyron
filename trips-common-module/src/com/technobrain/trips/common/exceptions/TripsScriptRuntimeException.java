package com.technobrain.trips.common.exceptions;

public class TripsScriptRuntimeException  extends TripsScriptException{
    public TripsScriptRuntimeException() {
    }

    public TripsScriptRuntimeException(String msg) {
        super(msg);
    }
    public TripsScriptRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
