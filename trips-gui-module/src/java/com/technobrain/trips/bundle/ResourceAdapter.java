package com.technobrain.trips.bundle;

import com.technobrain.trips.util.FacesUtil;

import java.util.Collection;
import java.util.Map;
import java.util.Set;


/**
 * � Crown Agents 2006
 * <p>
 * Utility class that allows us to expose the specified resource bundle within
 * general EL
 * <br>
 * @since $Date: 2/2/2009 5:34:59 AM$
 * @version $Revision: 4$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  4    TRIPS2    1.3         2/2/2009 5:34:59 AM    Howard Hill     change
 *       log10 to log1
 * $
 */
public class ResourceAdapter implements Map {

    public Object get(Object resourceKey) {
       return FacesUtil.getStringFromBundle((String)resourceKey);
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }


    public Object put(Object key, Object value) {
        return null;
    }

    public Object remove(Object key) {
        return null;
    }

    public void putAll(Map map) {
    }

    public void clear() {
    }

    public Set keySet() {
        return null;
    }

    public Collection values() {
        return null;
    }

    public Set entrySet() {
        return null;
    }
}

