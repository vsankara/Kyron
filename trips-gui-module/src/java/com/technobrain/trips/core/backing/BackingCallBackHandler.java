package com.technobrain.trips.core.backing;

import com.technobrain.trips.core.message.OutputType;



public interface BackingCallBackHandler {
    
    String invokeCallBackHandler(String methodName, OutputType outputType);
}
