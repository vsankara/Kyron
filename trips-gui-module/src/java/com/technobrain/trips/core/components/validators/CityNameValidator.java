package com.technobrain.trips.core.components.validators;

import com.technobrain.trips.core.components.AbstractStateholder;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.common.helpers.StringHelper;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class CityNameValidator extends AbstractStateholder implements Validator {
    public CityNameValidator() {
        super();
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, 
                         Object value) throws ValidatorException {
        String str =(String) value;
        
        if(!StringHelper.isValidCityName(str)) {
            String label = (String) uiComponent.getAttributes().get("label");
            Object[] obj = new String[] {label};
            FacesUtil.addFacesErrorMessage("Trips.Validator.NotValidCityName", obj);
        } else {
            // do nothing
        }
    }
}
