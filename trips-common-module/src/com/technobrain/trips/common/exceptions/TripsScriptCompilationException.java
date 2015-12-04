package com.technobrain.trips.common.exceptions;

public class TripsScriptCompilationException extends TripsScriptException {
    public TripsScriptCompilationException() {
    }

    public TripsScriptCompilationException(String msg) {
        super(msg);
    }
    
    public TripsScriptCompilationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
