package com.technobrain.trips.search.exception;

public class CriteriaRequiredException extends Throwable {
    public CriteriaRequiredException() {
    }
    
    public CriteriaRequiredException(Throwable t){
        super(t);
    }
}
