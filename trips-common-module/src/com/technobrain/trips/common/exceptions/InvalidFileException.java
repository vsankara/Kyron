package com.technobrain.trips.common.exceptions;

public class InvalidFileException extends Exception {
    public InvalidFileException() {
    }
    
    public InvalidFileException(String msg) {
        super(msg);
    }
    public InvalidFileException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
