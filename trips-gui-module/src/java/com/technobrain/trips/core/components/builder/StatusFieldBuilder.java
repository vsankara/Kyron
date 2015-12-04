package com.technobrain.trips.core.components.builder;



import com.technobrain.trips.common.helpers.ReflectionHelper;
import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

/**
 * WE ARE NOT USING THIS CLASS. IT WILL BE DELETED IN FUTURE. KEMAL
 */
public class StatusFieldBuilder extends DropDownBuilder {
    public StatusFieldBuilder() {
    }
    
    protected List<SelectItem> getReferenceData(Field field, Object value) {    
//        List<SelectItem> refData = new ArrayList<SelectItem>();
//        refData.add(new SelectItem("ACTIVE", "ACTIVE"));
//        refData.add(new SelectItem("", "INACTIVE"));
        return new ArrayList();
    }
    
    protected List<Field> getFields(Class clazz) {
        return ReflectionHelper.getDeclaredFieldsWithInheritance(clazz);
    }
}



