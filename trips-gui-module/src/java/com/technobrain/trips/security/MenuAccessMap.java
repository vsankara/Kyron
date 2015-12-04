package com.technobrain.trips.security;

import java.util.HashMap;

/**
 * @ Crown Agents 2008
 *
 * Checks if the map contain the menu id
 * and returns true if present, false otherwise
 * @since       $Date: 2/2/2009 5:34:57 AM$
 * @version     $Revision: 9$
 * @author      $Author: Howard Hill$
 * 
 * $Log[1]:
 *  9    TRIPS2    1.8         2/2/2009 5:34:57 AM    Howard Hill     change
 *       log10 to log1
 * $
 */
public class MenuAccessMap extends HashMap {
    
    public MenuAccessMap(int size){
        super(size);
    }
    
    public Object get(Object key) {
       return null == super.get(key) ? false : true;
    }
}
