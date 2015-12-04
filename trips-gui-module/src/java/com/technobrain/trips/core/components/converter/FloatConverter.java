package com.technobrain.trips.core.components.converter;

import com.technobrain.trips.util.FacesUtil;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.validator.ValidatorException;

public class FloatConverter implements Converter{
    public FloatConverter() {
    }

    public Object getAsObject(FacesContext facesContext, 
                              UIComponent uiComponent, String string) {
        
        if(string == null || string.equalsIgnoreCase(""))
            return Float.valueOf("0");
        if(string.equals("0.0"))
            return Float.valueOf("0.0");
        try {
            BigDecimal decimal = new BigDecimal(string);  // TODO it has to be new BigDecimal(string).setScale(2,BigDecimal.ROUND_HALF_UP);
            decimal.setScale(2,BigDecimal.ROUND_HALF_UP);
        }
        catch (Exception e) {
            FacesMessage message = new FacesMessage();
            String detail = FacesUtil.getStringFromBundle("Global.converter.Float");
            String summary = FacesUtil.getStringFromBundle("Global.converter.FloatSummary");
            
            String fieldName = (String)uiComponent.getAttributes().get("fieldRef");
            if(null != fieldName){
               message.setSummary(fieldName + " " + summary);
            }else{
                message.setSummary(summary);
            }
            
            message.setDetail(detail);
            
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);  
        }
        
        return Float.valueOf(string);
    }

    public String getAsString(FacesContext facesContext, 
                              UIComponent uiComponent, Object object) {
        if(object == null || object == "" )
            return "0";
        else if((object).equals(Float.valueOf("0.0")))
            return "0.0";
        else
            return object.toString();
    }
}
