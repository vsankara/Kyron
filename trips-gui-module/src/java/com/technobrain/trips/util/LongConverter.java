package com.technobrain.trips.util;

import org.apache.commons.beanutils.Converter;

public class LongConverter implements Converter {

    public LongConverter() {
    }

    public Object convert(Class class1, Object object) {
        if(object == null){
            return null;
        }else{
            org.apache.commons.beanutils.converters.LongConverter 
                defaultConverter = new org.apache.commons.beanutils.converters.LongConverter();
            return defaultConverter.convert(class1,object);
        }
    }
}
