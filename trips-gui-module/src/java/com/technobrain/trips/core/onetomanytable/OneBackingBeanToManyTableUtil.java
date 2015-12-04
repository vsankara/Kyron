package com.technobrain.trips.core.onetomanytable;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

/**
 * � Crown Agents 2006

 * @since $Date: 2/2/2009 5:34:57 AM$
 * @version $Revision: 6$
 * @author $Author: Howard Hill$
 *
 * $Log[1]:
 *  6    TRIPS2    1.5         2/2/2009 5:34:57 AM    Howard Hill     change
 *       log10 to log1
 * $
 */
public class OneBackingBeanToManyTableUtil {
    public static final Logger log = Logger.getLogger(OneBackingBeanToManyTableUtil.class);
    /**
     * 
     * @param destination
     * @param source
     */
    public static void defaultCopyFunction(Object destination, Object source) {
        
        if(destination == null || source == null){
            log.warn("Unable to copy null destination or source object");
            return;
        }
        try {
            PropertyUtils.copyProperties(destination,source);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (InvocationTargetException e) {
            log.error(e.getLocalizedMessage(), e);        
        }
    }
}
