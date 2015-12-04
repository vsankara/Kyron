package com.technobrain.trips.locator;

import org.apache.commons.lang.exception.NestableRuntimeException;

public class ServiceLocatorException extends NestableRuntimeException {

    /**
     * @param t
     */
    public ServiceLocatorException(Throwable t) {
        super(t);
    }
}
