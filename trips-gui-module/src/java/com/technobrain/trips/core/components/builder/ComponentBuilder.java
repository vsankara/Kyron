package com.technobrain.trips.core.components.builder;

import com.technobrain.trips.bundle.ResourceAdapter;
import com.technobrain.trips.util.FacesUtil;


import java.lang.reflect.Field;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.el.ValueBinding;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.convert.DateTimeConverter;






public abstract class ComponentBuilder {

	public UIComponent buildComponent(Field field, String bindingPath) {
		UIComponent component = createComponent();
		if(component == null)
			return null;

		if(field.getName().equalsIgnoreCase("description")){
			InputText description = (InputText)component;
//			description.setRows(2);
		}

		if(field.getName().equalsIgnoreCase("createdBy") || field.getName().equalsIgnoreCase("updatedBy")){
			InputText inputText = (InputText)component;
			inputText.setReadonly(true);
		}
		if(field.getName().equalsIgnoreCase("createdDate") || field.getName().equalsIgnoreCase("updatedDate")){
			Calendar inputDate = (Calendar)component;
			inputDate.setReadonly(true);
		}
		
		//Barkhas 2013-04-16
		
		if(field.getName().equalsIgnoreCase("effectiveDate")){
			Calendar inputDate = (Calendar)component;
			ResourceAdapter resource = (ResourceAdapter) FacesUtil
					.getCreateOrGetManagedBeanValue("resources");
			FacesContext ctx =FacesUtil.getFacesContext();
			DateTimeConverter converter=(DateTimeConverter)ctx.getApplication().createConverter("javax.faces.DateTime");
			converter.setPattern(resource.get("Global.dateformat").toString());
			inputDate.setConverter(converter);
			inputDate.setReadonly(false);
		}
		
		if(field.getName().equalsIgnoreCase("expiryDate")){
			Calendar inputDate = (Calendar)component;
			ResourceAdapter resource = (ResourceAdapter) FacesUtil
					.getCreateOrGetManagedBeanValue("resources");
			FacesContext ctx =FacesUtil.getFacesContext();
			DateTimeConverter converter=(DateTimeConverter)ctx.getApplication().createConverter("javax.faces.DateTime");
			converter.setPattern(resource.get("Global.dateformat").toString());
			inputDate.setConverter(converter);
			inputDate.setReadonly(false);
		}
		

		// Added by Mr.Kim to avoid no firing and no acting to any change once number type of field of a entity was generated to corresponding control in a browser with Mongolian mode.  
		// As a temporary solution, the corresponding control is disabled until find out a solution of it. 
		if( field.getType().getName().equals("java.lang.Number") ){
			InputText numberControl = (InputText)component;
			numberControl.setDisabled(true);
		}
		/*
		if(field.getName().equalsIgnoreCase("refNoNextValue")){
			CoreInputText refNoNextValue = (CoreInputText)component;
			refNoNextValue.setDisabled(true);
			
		}
		*/
		
		
		String resource = "Entity." + field.getDeclaringClass().getSimpleName() + "." + field.getName();
		String label = null;
		        if (FacesUtil.getResource(resource) == null) {           
		            label = "#{resources['Entity." + field.getName() +"']}";
		        }else{
		            label = "#{resources['"+resource+"']}";
		        }
		

		//        ValueBinding valueBinding = FacesUtil.getFacesContext().getApplication().createValueBinding(label);
		//        component.setValueBinding("label",valueBinding);            
		//        
		//        ValueBinding valueBindingValue = 
		//             FacesUtil.getFacesContext().
		//		getApplication().createValueBinding(getValueBindingStringForValueAttr(field, bindingPath));
		//        component.setValueBinding("value",valueBindingValue);
		//        component.setId(field.getName()); 
		//        return buildComponentSpecifically(field, component);
		//        

		component.setValueExpression("label", FacesUtil.getValueExpression(label));
		
		String valueBindingStr = getValueBindingStringForValueAttr(field, bindingPath);		
		component.setValueExpression("value", FacesUtil.getValueExpression(valueBindingStr));

		component.setId(field.getName()); 
		return buildComponentSpecifically(field, component);

	}

	private UIComponent createComponent() {
		UIComponent component = null;
		if(getComponentType() != null){
			component = FacesUtil.getFacesContext().
					getApplication().createComponent(getComponentType());
		}
		return component;
	}

	protected abstract UIComponent buildComponentSpecifically(Field field, UIComponent component);

	protected abstract String getComponentType();

	protected abstract String getValueBindingStringForValueAttr(Field field, String bindingPath);

	public UIComponent getComponent() {
		return null;
	}

	public void buildComponent(FacesContext fc) {
	}
}
