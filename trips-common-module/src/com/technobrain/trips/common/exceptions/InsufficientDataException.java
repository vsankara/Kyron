package com.technobrain.trips.common.exceptions;

public class InsufficientDataException extends Exception {
    public InsufficientDataException() {
    }

    public InsufficientDataException(String msg) {
        super(msg);
    }
    public InsufficientDataException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
