package com.technobrain.trips.common.helpers;

import com.technobrain.trips.common.constants.Constants;


/**
 *  Crown Agents 2006
 * 
 * Provides static methods for validating different objects.
 * 
 * @since $Date: 2/2/2009 5:23:05 AM$
 * @version $Revision: 6$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  6    TRIPS2    1.5         2/2/2009 5:23:05 AM    Howard Hill     lower the
 *       log to 1 instead of 10
 * $
 */

public class ValidationHelper {
    
    /**
     * This method takes an object as input parameter and checks whether it is 
     * null and throws an exception if the input object is null
     * <br>
     * This is primarily used for Web Service End Points to check whether the 
     * input type is null.
     * <br>
     * @param obj Object
     * @throws NullPointerException
     * @deprecated Use the java language feature <code>assert</code> e.g. '<code>assert</code> myVar != null'
     */
    @Deprecated
    public static void assertForNULL (Object obj) throws NullPointerException {
        if(obj == null) {
            throw new NullPointerException(obj.getClass().getName() + Constants.ExceptionHandling.ISNULL);
        }
    }
}
