package com.technobrain.trips.common.exceptions;


/**
 * Crown Agents 2007
 * <br>
 * Represents the run time error in the application,
 * this is handled by the view layer to return an 
 * appropiate message to the user or client.
 * @since $Date: 2/2/2009 5:23:05 AM$
 * @version $Revision: 5$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  5    TRIPS2    1.4         2/2/2009 5:23:05 AM    Howard Hill     lower the
 *       log to 1 instead of 10
 * $
 */
public class TripsNestableRuntimeException extends RuntimeException {
    
    public TripsNestableRuntimeException() {
        super();
    }
    public TripsNestableRuntimeException(Throwable cause) {
        super(cause);
    }
}
