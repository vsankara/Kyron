package com.technobrain.trips.core.components.converter;

import com.technobrain.trips.util.FacesUtil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


public class NumberConverter implements Converter{
    public NumberConverter() {
    }

    public Object getAsObject(FacesContext facesContext, 
                              UIComponent uiComponent, String string) {
        
        
        if(string == null || string.equalsIgnoreCase(""))
            return null;
            
        try {
            new Integer(string);
        }
        catch (Exception e) {
            FacesMessage message = new FacesMessage();
            String detail = FacesUtil.getStringFromBundle("Global.converter.Number");
            String summary = FacesUtil.getStringFromBundle("Global.converter.NumberSummary");
            
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
        
        return Integer.valueOf(string);
    }

    public String getAsString(FacesContext facesContext, 
                              UIComponent uiComponent, Object object) {
        return object.toString();
    }
}
