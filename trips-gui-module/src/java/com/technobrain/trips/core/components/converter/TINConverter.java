package com.technobrain.trips.core.components.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;

public class TINConverter implements Converter {

    static final Logger log = Logger.getLogger(TINConverter.class);

    public TINConverter() {

    }

    @Override
    public Object getAsObject(FacesContext facesContext,
            UIComponent uiComponent, String string) {
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext,
            UIComponent uiComponent, Object object) {
        String inputValue = null;
        if (object == null) {
            return null;
        }
        try {
            inputValue = (String) object;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }

        String tin = null;

//        tin =  ReferenceCodeDelegate.getInstance().formatTaxIdentificationNumber(inputValue);
        return tin;
    }
}
