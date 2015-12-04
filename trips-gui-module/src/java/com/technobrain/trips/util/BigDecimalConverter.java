package com.technobrain.trips.util;

import java.math.BigDecimal;

import org.apache.commons.beanutils.Converter;

 /**
  * � Crown Agents 2007
  *
  * Handles null values for BigDecimal Conversions
  * 
  * @since       $Date: 2/2/2009 5:56:03 AM$
  * @version     $Revision: 4$
  * @author      $Author: Howard Hill$
  * 
  * $Log[1]:
  *  4    TRIPS2    1.3         2/2/2009 5:56:03 AM    Howard Hill     changed
  *       to Log1 instead of Log
  * $
  */
public class BigDecimalConverter implements Converter{
    public BigDecimalConverter() {
    }

    public Object convert(Class class1, Object object) {
        if(object == null){
            return null;
        }else{
            org.apache.commons.beanutils.converters.BigDecimalConverter 
                defaultConverter = new org.apache.commons.beanutils.converters.BigDecimalConverter();
            return defaultConverter.convert(class1,object);
        }
    }
}
