package com.technobrain.trips.core.components.converter;

import com.technobrain.trips.util.FacesUtil;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;


public class DateConverter implements Converter {
    
    DateTimeConverter converter;

    public DateConverter() {
    }

    public Object getAsObject(FacesContext facesContext, 
                              UIComponent uiComponent, String string) {
                              
        initPattern();
        
        return converter.getAsString(facesContext, uiComponent, string);
    }

    public String getAsString(FacesContext facesContext, 
                              UIComponent uiComponent, Object object) {  
                              
        initPattern();
        
        return converter.getAsString(facesContext, uiComponent, object);
    }

    private void initPattern() {
        converter = (DateTimeConverter)FacesContext.getCurrentInstance().getApplication().createConverter(DateTimeConverter.CONVERTER_ID);
        converter.setPattern(FacesUtil.getStringFromBundle("Global.dateformat"));
    }
    
    public void setPattern(String pattern){
        
        if(converter !=null ){
            converter.setPattern(pattern);
        }
    }
}
