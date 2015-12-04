package com.technobrain.trips.core.components.validators;

import com.technobrain.trips.core.components.AbstractStateholder;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.common.helpers.DateHelper;

import javax.faces.validator.Validator;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;


/**
 * The Validator validates date for future date
 */
public class PastDateValidator extends AbstractStateholder implements Validator {

    /**
     * 
     */
    public PastDateValidator() {
        super();
    }

    /* (non-Javadoc)
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */

    @Override
    public void validate(FacesContext context, UIComponent component, 
                         Object value) throws ValidatorException {
        GregorianCalendar dateString = (GregorianCalendar)value;
        FacesMessage errMsg = null;
        if (DateHelper.compareDates(dateString,Calendar.getInstance())<0) {
            errMsg = new FacesMessage(FacesUtil.getResource("Trips.Validator.PastDate.Msg"));
            throw new ValidatorException(errMsg);
        } else {
            //todo
        }
    }
}

