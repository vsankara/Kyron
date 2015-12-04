package com.technobrain.trips.core.components.builder;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.component.UIComponent;

public class FlexFormPageBuilder extends PageBuilder {
    public FlexFormPageBuilder() {
    }

    protected boolean canGenerateComponentForField(Field field, String entityBindingPath) {
        return true;
    }

    protected List<Field> getEntityFields(Object entity) {
        List<Field> fields = new ArrayList<Field>();
        if(entity != null){
//            fields.addAll(Arrays.asList(((Class)entity).getDeclaredFields()));        

              getFieldsForClass(fields, (Class)entity);
        }
        return fields;
    }

    private void getFieldsForClass(List<Field> fields, Class clazz){
        if(clazz != null){
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));        
            
            if(clazz.getSuperclass() != null && !clazz.getName().endsWith(".InputType")){
                getFieldsForClass(fields, clazz.getSuperclass());
            }
        }
    }


    protected DropDownBuilder generateDropDownBuilder() {
        return new TableManagementDropDownBuilder();
    }
    
    
    
    
    
}
