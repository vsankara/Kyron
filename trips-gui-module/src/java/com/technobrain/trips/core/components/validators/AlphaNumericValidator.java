package com.technobrain.trips.core.components.validators;

import com.technobrain.trips.core.components.AbstractStateholder;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.common.helpers.StringHelper;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Class for alphanumeric validation. 
 * Reg ex: /^[A-Za-z0-9 ]+$/
 */
public class AlphaNumericValidator extends AbstractStateholder implements Validator {
    /**
     * 
     */
    public AlphaNumericValidator() {
        super();
    }

    
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, 
                         Object value) throws ValidatorException {
        String str =(String) value;
        //FacesMessage errMsg = null;
        
        if(!StringHelper.isAlphaNumericOrSpace(str)) {
            String label = (String) uiComponent.getAttributes().get("label");
            Object[] obj = new String[] {label};
            FacesUtil.addFacesErrorMessage("Trips.Validator.NotAlphanumeric", obj);
            /*errMsg = new FacesMessage(FacesUtil.getResource("Trips.Validator.NotAlphanumeric"));
            throw new ValidatorException(errMsg);*/
        } else {
            // do nothing
        }

    }
}
