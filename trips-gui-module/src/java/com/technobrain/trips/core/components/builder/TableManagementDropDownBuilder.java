package com.technobrain.trips.core.components.builder;



import com.technobrain.trips.common.constants.Constants.RefStatus;
import java.lang.reflect.Field;

import java.util.Arrays;
import java.util.List;

import javax.faces.model.SelectItem;


public class TableManagementDropDownBuilder extends DropDownBuilder {
    public TableManagementDropDownBuilder() {
    }

    protected List<SelectItem> getReferenceData(Field field, Object value) {
        List<SelectItem> refData;
        if(field.getName().equalsIgnoreCase("status")){
            refData = refCodeDelegate.findAllReferenceEntity(RefStatus.class.getSimpleName(),value);
            for(int i=0; i<refData.size();i++){
                if(refData.get(i).getLabel().equalsIgnoreCase("DELETED")){
                    refData.remove(i);
                }
            }
        }else{
            refData = refCodeDelegate.findAllPojoAndDescription(field.getType().getName(),value);
        }
        return refData;
    }
    
    protected List<Field> getFields(Class clazz) {
        return Arrays.asList(clazz.getDeclaredFields());
    }
}
