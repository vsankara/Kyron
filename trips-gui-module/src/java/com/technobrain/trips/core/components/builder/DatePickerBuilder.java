package com.technobrain.trips.core.components.builder;

import java.lang.reflect.Field;

import javax.faces.component.UIComponent;
import org.primefaces.component.calendar.Calendar;



public class DatePickerBuilder extends ComponentBuilder {
    public DatePickerBuilder() {
    	
    }

    protected String getComponentType() {
        return Calendar.COMPONENT_TYPE;
        //to:do:currently commented for testing for 11g migration
        //return "test";
    }

    protected UIComponent buildComponentSpecifically(Field field, UIComponent component) {
        return component;
    }

    protected String getValueBindingStringForValueAttr(Field field, String bindingPath) {
        return "#{"+bindingPath+"."+field.getName()+"}";
    }
}
