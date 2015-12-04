package com.technobrain.trips.servlets;

import com.technobrain.trips.util.BigDecimalConverter;
import com.technobrain.trips.util.LongConverter;

import java.sql.Timestamp;

import javax.servlet.http.HttpServlet;

import org.apache.commons.beanutils.ConvertUtils;

 /**
  * � Crown Agents 2007
  *
  * Handles the bean utils copy functions.
  * <p>
  * For example null values 
  * @since       $Date: 2/2/2009 5:56:03 AM$
  * @version     $Revision: 4$
  * @author      $Author: Howard Hill$
  * 
  * $Log[1]:
  *  4    TRIPS2    1.3         2/2/2009 5:56:03 AM    Howard Hill     changed
  *       to Log1 instead of Log
  * $
  */
public class BeanUtilsConverters extends HttpServlet {
    
    static{
        ConvertUtils.register(new BigDecimalConverter(), java.math.BigDecimal.class);
        ConvertUtils.register(new LongConverter(), java.lang.Long.class);
        ConvertUtils.register( 
                new org.apache.commons.beanutils.converters.SqlTimestampConverter(null), Timestamp.class);
    }
    
}
