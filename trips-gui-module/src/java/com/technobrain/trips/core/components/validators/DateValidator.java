package com.technobrain.trips.core.components.validators;

import com.technobrain.trips.core.components.AbstractStateholder;
import com.technobrain.trips.util.FacesUtil;

import java.util.GregorianCalendar;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * The Validator validates date for maximum date that can be input to the system
 */
public class DateValidator  extends AbstractStateholder implements Validator {

       	/**
	 * 
	 */
	public DateValidator() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
        @Override
	public void validate(FacesContext context, UIComponent component, Object value)
		throws ValidatorException {
		GregorianCalendar dateString =(GregorianCalendar) value;
	        FacesMessage errMsg = null;
                int year = Integer.parseInt(FacesUtil.getResource("Trips.Validator.Date.Year"));
	        int month = Integer.parseInt(FacesUtil.getResource("Trips.Validator.Date.Month"));
	        int day = Integer.parseInt(FacesUtil.getResource("Trips.Validator.Date.Day"));
                if(dateString.after(new GregorianCalendar(year,month,day))) {
                    errMsg = new FacesMessage(FacesUtil.getResource("Trips.Validator.Date.Msg")+" "+year);
                    throw new ValidatorException(errMsg);
                } else {
                    //todo
                }
	}
}
