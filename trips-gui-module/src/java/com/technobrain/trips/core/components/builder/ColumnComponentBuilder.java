package com.technobrain.trips.core.components.builder;

import java.lang.reflect.Field;

import java.util.List;

import javax.faces.component.UIComponent;
import org.primefaces.component.column.Column;



public class ColumnComponentBuilder extends ComponentBuilder {

    private Column column;
    protected UIComponent buildComponentSpecifically(Field field, 
                                                     UIComponent component) {
        return null;
    }

    protected String getComponentType() {
        return null;
    }

    protected String getValueBindingStringForValueAttr(Field field, 
                                                       String bindingPath) {
        return null;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    public Column getColumn() {
        return column;
    }

}
