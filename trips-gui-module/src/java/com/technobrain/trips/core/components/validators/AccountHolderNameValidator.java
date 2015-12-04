package com.technobrain.trips.core.components.validators;

import com.technobrain.trips.core.components.AbstractStateholder;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.common.helpers.StringHelper;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class AccountHolderNameValidator extends AbstractStateholder implements Validator {

    public AccountHolderNameValidator() {
    }

    public void validate(FacesContext facesContext, UIComponent uiComponent,
            Object value) {
        String str = (String) value;
        FacesMessage errMsg = null;
        if (!StringHelper.isValidAccountHolderName(str)) {
            errMsg = new FacesMessage(FacesUtil.getResource("Trips.Validator.NotValidAccountHolderName"));
            throw new ValidatorException(errMsg);
        } else {
            // nothing
        }
    }
}
