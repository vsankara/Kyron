package com.technobrain.trips.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Crown Agents 2007
 * <br>
 * Allows indirection for the Table Management screen to 
 * find drop downs for a field dynamically.
 * <br>
 * e.g. RefCountry field on RefOffice will be the indirection.
 * The reference Code Delegate will use this indirection i.e reference
 * to match the field and invoke the method to return the list of results.
 * @since $Date: 2/2/2009 5:34:58 AM$
 * @version $Revision: 2$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  2    TRIPS2    1.1         2/2/2009 5:34:58 AM    Howard Hill     change
 *       log10 to log1
 * $
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ReferenceEntity {
    
    Class reference();
}
