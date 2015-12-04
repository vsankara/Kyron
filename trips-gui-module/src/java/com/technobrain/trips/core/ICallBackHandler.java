package com.technobrain.trips.core;

import com.technobrain.trips.core.backing.BackingBase;

import java.io.Serializable;

import java.util.List;
import java.util.Map;


/**
 * @ Crown Agents 2008 
 * Provide a contract with a managed bean and it caller.
 * <p>
 * Where a proxy method is provided by the caller in the process scope,
 * the backing base uses this to invoke that method.
 * <p>
 * This method is invoked in the handleProcess, this enables the caller
 * to manage the processing of the called managed bean.
 * @since $Date: 2/2/2009 5:34:55 AM$
 * @version $Revision: 4$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  4    TRIPS2    1.3         2/2/2009 5:34:55 AM    Howard Hill     change
 *       log10 to log1
 * $
 */
public interface ICallBackHandler {
    
    /**
     * Managed bean should implement this to handle different methods
     * which are executed depending on the user action
     * @param methodName
     * @param output
     * @param caller
     * @return
     */
    public String invokeHandler(String methodName, 
                                           Serializable output,BackingBase caller);
    
    /**
     * Allows the caller to consume the manage bean being handle
     * @param managedBean
     */
    public void consume(BackingBase managedBean);

    public String doAction(String methodName,BackingBase backingBean,Map paramters);
    
    public List doGetData(String methodName,BackingBase backingBean,Map paramters);
    
    public boolean doCondition(String methodName,BackingBase backingBean,Map paramters);
}
