package com.technobrain.trips.core.components.builder;

import com.technobrain.trips.core.delegate.ReferenceCodeDelegate;
import com.technobrain.trips.util.FacesUtil;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.model.SelectItem;
import org.primefaces.component.selectonelistbox.SelectOneListbox;
import org.primefaces.component.selectonemenu.SelectOneMenu;



public abstract class DropDownBuilder extends ComponentBuilder {
    protected ReferenceCodeDelegate refCodeDelegate = new ReferenceCodeDelegate();
//    protected ReportsDelegate reportsdelegate = new ReportsDelegate();
    public DropDownBuilder() { 
    }

    protected String getComponentType() {
        return SelectOneMenu.COMPONENT_TYPE;
    }

    protected UIComponent buildComponentSpecifically(Field field, UIComponent component) {
        //Object value = component.getValueBinding("value").getValue(FacesUtil.getFacesContext());
    	Object value = component.getValueExpression("value").getValue(FacesUtil.getELContext());
        List<SelectItem> refData = getReferenceData(field, value);
        if(refData != null) {
            List<SelectItem> coreSelectItemOfRefData = new ArrayList<>(refData.size());
            for(int i =0;i<refData.size();i++){
                SelectItem items = new SelectItem();
                items.setLabel(refData.get(i).getLabel());
                items.setValue(refData.get(i).getValue());
                coreSelectItemOfRefData.add(items);
            }
//            component.getChildren().addAll(coreSelectItemOfRefData);  
//            ((CoreSelectOneChoice)component).setSubmittedValue(value);
//            ((CoreSelectOneChoice)component).setValue(value);
//            ((CoreSelectOneChoice)component).setLocalValueSet(true);
//            ((CoreSelectOneChoice)component).setValuePassThru(true);
        }
        return component;
    }
    
    protected abstract List<SelectItem> getReferenceData(Field field, Object value);

    protected abstract List<Field> getFields(Class clazz);

    protected String getValueBindingStringForValueAttr(Field field, String bindingPath) {
//        String primaryKey=null;
//        if(field.getName().equalsIgnoreCase("status")){
            return "#{"+bindingPath+"."+field.getName()+"}";
//        }else{ 
//            List<Field> fields = getFields(field.getType());
//            for(int i=0; i<fields.size(); i++){
//                Field f = fields.get(i);
//                if(f.isAnnotationPresent(javax.persistence.Id.class))
//                    primaryKey = f.getName();
//            }
//            if(primaryKey != null)
//                return "#{"+bindingPath+"."+field.getName()+"."+ primaryKey+"}";
//            else
//                return "#{"+bindingPath+"."+field.getName()+"}";
//        }
    }
}
