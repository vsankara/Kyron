package com.technobrain.trips.core.components.builder;

import com.technobrain.trips.reference.model.RefComCode;
import java.lang.reflect.Field;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.component.UIComponent;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * This class will be used for component generation process. Currently the code under the TableManagement has been used.
 * If some special code is needed for any module, then that module should extend this class and use that PageBuilder class.
 */
public abstract class PageBuilder {
    
    public PageBuilder() {
    }
    
    public List<UIComponent> buildComponents(Object entity, String entityBindingPath) throws NoSuchMethodException, 
                                                                                        InstantiationException, 
                                                                                        IllegalAccessException {
        List<UIComponent> components = new ArrayList<UIComponent>();
        List<Field> fields = getEntityFields(entity);
        for (int f = 0; f < fields.size(); f++) {
            Field field = fields.get(f);
            if(!canGenerateComponentForField(field, entityBindingPath))
                continue;
            ComponentBuilder builder = generateComponentBuilder(field);
            if(builder == null)
                continue;
            UIComponent component = builder.buildComponent(field, entityBindingPath);
            if (null != component) {
//                if (component.getClass().equals(CoreSelectOneChoice.class) || 
//                    component.getClass().equals(CoreSelectInputText.class)) {
//                    if (!field.getName().equals("status")){
//                        ReflectionHelper.invokeSetter(entity, field.getName(), field.getType().newInstance());
//                    }
//                }
                components.add(component);
            }
        }
        // at this point we have all the fields which are defined in the class, 
        // we also require status field which is defined in parent class
        
        return components;
    }
    
    protected abstract boolean canGenerateComponentForField(Field field, String entityBindingPath);
    
    protected abstract List<Field> getEntityFields(Object entity);
    
    protected boolean isDropDownRequired(Field field,Class annonation ){
        for(int i=0; i<field.getAnnotations().length; i++){
           if(field.getAnnotations()[i].annotationType().equals(annonation)){
               return true;
           }
        }
        return false;
    }
    
    protected abstract DropDownBuilder generateDropDownBuilder();
    
    private ComponentBuilder generateComponentBuilder(Field field) {
        ComponentBuilder builder = null;
        if(field.getType().equals(Timestamp.class) || field.getType().equals(Calendar.class)){
            builder = new DatePickerBuilder();        
        }else {
            if(isDropDownRequired(field,ManyToOne.class)){
                if(field.getType().equals(RefComCode.class))
                    builder = new CommodityCodeLookUpBuilder();
                else
                    builder = generateDropDownBuilder();
            }else if(isDropDownRequired(field,OneToMany.class)){
                //Do nothing or do not render any components
            }else if(field.getName().equals("commodityCode")){
                builder = new CommodityCodeLookUpBuilder();
            }else if(field.getName().equals("status")){
                builder = generateDropDownBuilder();
            }else {
                builder = new InputTextBuilder();
            }
        }
        return builder;
    }
}
