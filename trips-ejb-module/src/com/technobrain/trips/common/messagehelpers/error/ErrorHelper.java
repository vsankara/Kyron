package com.technobrain.trips.common.messagehelpers.error;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.core.message.OutputType;
import com.technobrain.trips.core.message.SubmissionOutputType;
import com.technobrain.trips.core.message.SystemMessage;
import com.technobrain.trips.wsexception.message.WSException;

import java.io.PrintWriter;
import java.io.StringWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * TechnoBrain 2015
 *
 * This class proivdes methods to perform error handling
 *
 * @since       $Date: 2/2/2009 5:29:21 AM$
 * @version     $Revision: 6$
 * @author      $Author: Howard Hill$
 *
 * $Log[1]:
 *  6    TRIPS2    1.5         2/2/2009 5:29:21 AM    Howard Hill     change
 *       log10 to log1
 * $
 */
  
public class ErrorHelper {

    public ErrorHelper() {
    }
    
    /**
     * Helper to save having to declare variable and create instance 
     * all the time
     * @return New instance of ErrorHelper
     */
    public static ErrorHelper getInstance() {
        return new ErrorHelper();
    }
    
    /**
     * Generate a new WSException from the input Exception
     * @param e Exception to read info, stack trace etc. from
     * @return Initialised WSException
     */
    public WSException genWSException(Exception e) {
        WSException ex = new WSException();
        ex.setErrorDescription(e.getMessage());

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        ex.setStack(sw.toString());
        
        return ex;
    }
    
    public static OutputType setExceptionMessage(OutputType outputType, Exception e) {
        SystemMessage sysMsg = null;
        
        List<SystemMessage> msgList = new ArrayList<SystemMessage>();
        sysMsg = new SystemMessage();
        
        //setting the code with the class name
//        sysMsg.setCode(e.getClass().getSimpleName());
        sysMsg.setMessage(e.getMessage());
        msgList.add(sysMsg);
        //setting the Output Type with the required parameters
        outputType.setReturnStatus(Constants.FAIL);
        outputType.setHasErrors(true);
        outputType.setHasWarnings(false);
        outputType.getErrors().addAll(msgList);
        return outputType;
    }
    
    public static SubmissionOutputType setExceptionMessage(SubmissionOutputType outputType, Exception e) {
        SystemMessage sysMsg = new SystemMessage();
        
        List<SystemMessage> msgList = new ArrayList<>();

        //setting the code with the class name
        sysMsg.setCode(e.getClass().getSimpleName());
        sysMsg.setMessage(e.getMessage());
        msgList.add(sysMsg);
        //setting the Output Type with the required parameters
        outputType.setReturnStatus(Constants.FAIL);
        outputType.setHasErrors(true);
        outputType.setHasWarnings(false);
        outputType.getErrors().addAll(msgList);
        return outputType;
    }
}
