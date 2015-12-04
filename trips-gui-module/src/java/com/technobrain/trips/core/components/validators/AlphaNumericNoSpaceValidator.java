package com.technobrain.trips.core.components.validators;

import com.technobrain.trips.core.components.AbstractStateholder;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.common.helpers.StringHelper;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;

/**
 * Class for alphanumeric validation. Reg ex: /^[A-Za-z0-9]+$/
 */
public class AlphaNumericNoSpaceValidator extends AbstractStateholder implements Validator {

    public AlphaNumericNoSpaceValidator() {
        super();
    }

    public void validate(FacesContext facesContext, UIComponent uiComponent,
            Object value) {
        String str = (String) value;
        //FacesMessage errMsg = null;

        if (!StringHelper.isAlphaNumeric(str)) {
            String label = (String) uiComponent.getAttributes().get("label");
            Object[] obj = new String[]{label};
            FacesUtil.addFacesErrorMessage("Trips.Validator.NotAlphanumericNoSpace", obj);
        } else {
            // do nothing
        }

    }
}
