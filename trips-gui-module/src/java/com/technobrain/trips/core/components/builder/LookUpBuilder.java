package com.technobrain.trips.core.components.builder;

import com.technobrain.trips.util.FacesUtil;

import java.lang.reflect.Field;

import javax.el.MethodExpression;
import javax.faces.component.ActionSource;
import javax.faces.component.UIComponent;

import javax.faces.el.MethodBinding;



//import oracle.adfinternal.view.faces.taglib.listener.SetActionListener;

public class LookUpBuilder extends ComponentBuilder {
	public LookUpBuilder() {
	}

	protected String getComponentType() {
		//to:do:currently commented for testing for 11g migration
//		return CoreInputListOfValues.COMPONENT_TYPE;
		return "test";
	}

	protected UIComponent buildComponentSpecifically(Field field, UIComponent component) {
		//        Object value = component.getValueBinding("value").getValue(FacesUtil.getFacesContext());
		//        ((CoreInputListOfValues)component).setSubmittedValue(value);
		//        String methodBindingString = "#{backingSessionManager.goToGenericSearch}";
		//        MethodBinding methodBinding = FacesUtil.getFacesContext().getApplication().
		//                                        createMethodBinding(methodBindingString,null);
		//        ((CoreInputListOfValues)component).setAction(methodBinding);
//		Object value = component.getValueExpression("value").getValue(FacesUtil.getELContext());
//		((CoreInputListOfValues)component).setSubmittedValue(value);
//		String methodBindingString = "#{backingSessionManager.goToGenericSearch}";
//		MethodExpression methodExprs = FacesUtil.getMethodExpression(methodBindingString, new Class[]{Object.class});
//		((CoreInputListOfValues)component).setActionExpression(methodExprs);    	
//		((CoreInputListOfValues)component).setWindowHeight(525);
//		((CoreInputListOfValues)component).setWindowWidth(750);
//		((CoreInputListOfValues)component).setOnfocus("blur();");
//		ActionSource actionSource = (ActionSource)component;
//		SetActionListener navigation = new SetActionListener();


		//        navigation.setValueBinding(SetActionListener.FROM_KEY,FacesUtil.getFacesContext().getApplication().
		//                                            createValueBinding("#{webconstants.fromGenericSearchToTableManagement}"));
		//        navigation.setValueBinding(SetActionListener.TO_KEY,FacesUtil.getFacesContext().getApplication().
		//                                            createValueBinding("#{processScope.processScopeNavigation}"));
		//        actionSource.addActionListener(navigation);
		//        SetActionListener lookUpRequired = new SetActionListener();
		//        lookUpRequired.setValueBinding(SetActionListener.FROM_KEY,FacesUtil.getFacesContext().getApplication().
		//                                            createValueBinding("#{true}"));
		//        lookUpRequired.setValueBinding(SetActionListener.TO_KEY,FacesUtil.getFacesContext().getApplication().
		//                                            createValueBinding("#{processScope.processScopeGenericLookUpRequired}"));
		//        actionSource.addActionListener(lookUpRequired);
		//        SetActionListener dialog = new SetActionListener();
		//        dialog.setValueBinding(SetActionListener.FROM_KEY,FacesUtil.getFacesContext().getApplication().
		//                                            createValueBinding("#{true}"));
		//        dialog.setValueBinding(SetActionListener.TO_KEY,FacesUtil.getFacesContext().getApplication().
		//                                            createValueBinding("#{processScope.processScopeGenericDialog}"));
		//        actionSource.addActionListener(dialog);
		//        SetActionListener searchModeKey = new SetActionListener();
		//        searchModeKey.setValueBinding(SetActionListener.FROM_KEY,FacesUtil.getFacesContext().getApplication().
		//                                            createValueBinding("#{webconstants.addMode}"));
		//        searchModeKey.setValueBinding(SetActionListener.TO_KEY,FacesUtil.getFacesContext().getApplication().
		//                                            createValueBinding("#{processScope.processScopeGenericSearchModeKey}"));
		//        actionSource.addActionListener(searchModeKey);
		//        SetActionListener closeButton = new SetActionListener();
		//        closeButton.setValueBinding(SetActionListener.FROM_KEY,FacesUtil.getFacesContext().getApplication().
		//                                            createValueBinding("#{true}"));
		//        closeButton.setValueBinding(SetActionListener.TO_KEY,FacesUtil.getFacesContext().getApplication().
		//                                            createValueBinding("#{processScope.processScopeRenderCloseButton}"));
		//        actionSource.addActionListener(closeButton);
		
//		navigation.setFrom(FacesUtil.getValueExpression("#{webconstants.fromGenericSearchToTableManagement}"));
//		navigation.setValueExpression("to", FacesUtil.getValueExpression("#{pageFlowScope.processScopeNavigation}"));
//		actionSource.addActionListener(navigation);
//		
//		SetActionListener lookUpRequired = new SetActionListener();
//		lookUpRequired.setFrom(FacesUtil.getValueExpression("#{true}"));
//		lookUpRequired.setValueExpression("to", FacesUtil.getValueExpression("#{pageFlowScope.processScopeGenericLookUpRequired}"));
//		actionSource.addActionListener(lookUpRequired);
//		
//		SetActionListener dialog = new SetActionListener();
//		dialog.setFrom(FacesUtil.getValueExpression("#{true}"));
//		dialog.setValueExpression("to",FacesUtil.getValueExpression("#{pageFlowScope.processScopeGenericDialog}"));
//		actionSource.addActionListener(dialog);
//		
//		SetActionListener searchModeKey = new SetActionListener();
//		searchModeKey.setFrom(FacesUtil.getValueExpression("#{webconstants.addMode}"));
//		searchModeKey.setValueExpression("to",FacesUtil.getValueExpression("#{pageFlowScope.processScopeGenericSearchModeKey}"));
//		actionSource.addActionListener(searchModeKey);
//		
//		SetActionListener closeButton = new SetActionListener();
//		closeButton.setFrom(FacesUtil.getValueExpression("#{true}"));
//		closeButton.setValueExpression("to",FacesUtil.getValueExpression("#{pageFlowScope.processScopeRenderCloseButton}"));
//		actionSource.addActionListener(closeButton);
		return component;
	}

	protected String getValueBindingStringForValueAttr(Field field, String bindingPath) {
		if(field.getType().getName().equals(String.class.getName())) {
			return "#{"+bindingPath+"."+field.getName()+"}";
		}
		else {
			Field[] fields = field.getType().getDeclaredFields();
			String primaryKey=null;
			for(int i=0; i<fields.length; i++){
				Field f = fields[i];
				if(f.isAnnotationPresent(javax.persistence.Id.class))
					primaryKey = f.getName();
			}
			return "#{"+bindingPath+"."+field.getName()+"."+ primaryKey+"}";
		}
	}
}
