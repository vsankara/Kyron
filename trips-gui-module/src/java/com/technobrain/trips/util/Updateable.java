package com.technobrain.trips.util;

/**
 * Used for updating the member variables of
 * a object by delegating the update to the clazz
 * itself.
 * Also provides the fexibility to perform the update without knowing
 * the clazz type.
 * 
 * @since Novemeber 20, 2006.
 * @author hhill
 * @version 1.0
 */
public interface Updateable {
    
    /**
     * Delegates the update of this object's member variables to itself
     * @param newData
     */
    public void update(Object newData);
}
