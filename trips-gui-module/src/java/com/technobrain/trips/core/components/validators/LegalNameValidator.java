package com.technobrain.trips.core.components.validators;

import com.technobrain.trips.core.components.AbstractStateholder;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.common.helpers.StringHelper;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;

public class LegalNameValidator extends AbstractStateholder implements Validator {
    public LegalNameValidator() {
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, 
                         Object value) {
        String str =(String) value;
        
        if(!StringHelper.isValidLegalName(str)) {
            String label = (String) uiComponent.getAttributes().get("label");
            Object[] obj = new String[] {label};
            FacesUtil.addFacesErrorMessage("Trips.Validator.NotValidLegalName", obj);
        } else {
            // do nothing
        }
    }
}
