package com.technobrain.trips.core.components.converter;

import java.math.BigDecimal;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * This class is created to cater the criteria if the bigDecimal being returned is null 
 * in that case it should return zero
 * 
 */
public class BigDecimalConverterFF extends BigDecimalConverter{

    public Object getAsObject(FacesContext facesContext, 
                              UIComponent uiComponent, String string) {
        Object obj = super.getAsObject(facesContext, uiComponent, string);
        if (obj == null){
            obj = BigDecimal.ZERO;
        }
        return obj;
    }

}
