package com.technobrain.trips.reports.exception;

import org.apache.log4j.Logger;

public class ReportException extends Exception{
    static final Logger log = Logger.getLogger(ReportException.class);
    private Exception originalException;
    
    protected ReportException() {
        
    }
    
    public ReportException(Exception _originalException) {
        this.originalException =_originalException;
    }

    public void setOriginalException(Exception originalException) {
        this.originalException = originalException;
    }

    public Exception getOriginalException() {
        return originalException;
    }

    public void printStackTrace() { 
        log.error(originalException.getLocalizedMessage(), originalException);
    }    
    
}
