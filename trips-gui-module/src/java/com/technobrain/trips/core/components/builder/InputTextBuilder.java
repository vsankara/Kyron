package com.technobrain.trips.core.components.builder;

import java.lang.reflect.Field;

import javax.faces.component.UIComponent;
import org.primefaces.component.inputtext.InputText;

public class InputTextBuilder extends ComponentBuilder {
    public InputTextBuilder() {
    }

    protected UIComponent buildComponentSpecifically(Field field, UIComponent component) {
        return component;
    }

    protected String getComponentType() {
        return InputText.COMPONENT_TYPE;
    }

    protected String getValueBindingStringForValueAttr(Field field, String bindingPath) {
        return "#{"+bindingPath+"."+field.getName()+"}";
    }
}
