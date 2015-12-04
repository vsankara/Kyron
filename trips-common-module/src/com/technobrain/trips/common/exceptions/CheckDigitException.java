package com.technobrain.trips.common.exceptions;

/**
 * Crown Agents 2007
 * <br>.
 * 
 * @since $Date: 2/2/2009 5:23:02 AM$
 * @version $Revision: 4$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  4    TRIPS2    1.3         2/2/2009 5:23:02 AM    Howard Hill     lower the
 *       log to 1 instead of 10
 * $
 */
public class CheckDigitException extends Exception {
      public CheckDigitException() {}
      public CheckDigitException(String msg) {
          super(msg);
      }
      public CheckDigitException(String msg, Throwable cause) {
          super(msg, cause);
      }
  
  }
