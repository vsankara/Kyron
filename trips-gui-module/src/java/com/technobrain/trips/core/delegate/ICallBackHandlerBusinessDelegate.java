package com.technobrain.trips.core.delegate;


public interface ICallBackHandlerBusinessDelegate {
    
    /**
     * Calls the handler with this _inputType and this args.
     * <p>
     * The function is defined by its methodName
     * @param args
     * @param methodName
     * @return
     */
     public Object callFunction(Object[] args, 
                                              String methodName);
}
