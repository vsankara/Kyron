package com.technobrain.trips.util;

//package com.crownagents.trips.util;
//
//
//import java.util.Calendar;
//import java.util.List;
//
//import javax.el.ValueExpression;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.validator.LengthValidator;
//import javax.faces.validator.ValidatorException;
//
//
//
///**
// * Allows invoking of Jsf UI Components without knowing
// * there class type.
// *
// * @since November 14,2006
// * @author hhill
// */
//public class JsfReferencedObject {
//	protected Object jsfComponent = null;
//	public static final String REQUIRED_ATTR_FOR_TABLE = "requiredForTable";
//        public static final int MINIMUM_YEAR = 1000;
//
//	public JsfReferencedObject(Object uicom) {
//		jsfComponent = uicom;
//	}
//
//	public Object getJsfComponent() {
//		return jsfComponent;
//	}
//
//	/**
//	 * 
//	 * @param field
//	 * @param value
//	 */
//	public void setProperty(String field, boolean value) {
//		((UIComponent)jsfComponent).getAttributes().put(field,Boolean.valueOf(value));
//	}
//
//
//	/**
//	 * 
//	 * @param field
//	 * @param value
//	 */
//	public void setProperty(String field, String value) {
//		((UIComponent)jsfComponent).getAttributes().put(field,value);              
//	}
//
//	public void setRequired(Boolean boolean1) {
//		if(isRequiredAttributePresent()) {
//			setProperty("required",boolean1);
//			setProperty("ValidateInUI", true);
//		}
//	}
//
//	public void setDisabled(Boolean boolean1) {
//		if(isDisabledAttributePresent()) {
//			//           UIComponent comp = (UIComponent)jsfComponent;
//			//           // if there is already a value for the disabled attribute, we should not override it.
//			//           if(comp.getAttributes().get("disabled") == null || comp.getAttributes().get("disabled").equals(false)) {
//			setProperty("disabled",boolean1);
//			//           }
//		}
//	}
//
//	public void setReadOnly(Boolean boolean1) {
//		if(isReadOnlyAttributePresent()) setProperty("readOnly",boolean1);
//	}
//
//
//	public void setShowRequired(boolean b) {
//		if(isShowRequiredAttributePresent()) setProperty("showRequired",b);
//		if(jsfComponent instanceof CoreTable) {
//			setProperty(REQUIRED_ATTR_FOR_TABLE, b);
//		}
//	}
//
//	public void setOptional(Boolean boolean1){
//		if(isInlineStyleAttributePresent()){
//			if(boolean1){
//				setProperty("styleClass", "OptionalField"); //TODO choose one
//				// setProperty("inlineStyle", "background-color:#FFF380;border : 1px solid #000000;");
//				setProperty("ValidateInUI", false);
//				setProperty("showRequired", boolean1);
//
//			}
//		}
//	}
//
//	public void setRendered(Boolean boolean1) {
//		if(isRenderedAttributePresent()) setProperty("rendered",boolean1);
//	}
//
//	public boolean isRendered() {
//		return !FacesUtil.isCompOrAnyParentNotRendered((UIComponent)jsfComponent);
//	}
//
//	public String getBackingBeanName() {
//		//        ValueBinding valueBinding = ((UIComponent)jsfComponent).getValueBinding("value");
//
//		//        if(null == valueBinding){
//		//            return null;
//		//        }else{
//		//			String expressionString = valueBinding.getExpressionString();
//		//            if(expressionString!=null){
//		//            int indexOfMessageType = expressionString.indexOf(".");   
//		//            String  backingBeanName = expressionString.substring(1,indexOfMessageType);
//		//            backingBeanName = backingBeanName.substring(1,backingBeanName.length());
//		//            return backingBeanName;
//		//            }
//		//            return null;
//		//        }
//		ValueExpression valueExpr = ((UIComponent)jsfComponent).getValueExpression("value");
//		if(valueExpr==null) {
//			return null;
//		} else {
//			String expressionString = valueExpr.getExpressionString();
//			if(expressionString!=null){
//				int indexOfMessageType = expressionString.indexOf(".");   
//				String  backingBeanName = expressionString.substring(1,indexOfMessageType);
//				backingBeanName = backingBeanName.substring(1,backingBeanName.length());
//				return backingBeanName;
//			}
//			return null;
//		}
//	}
//
//	public String getValueOfValueBinding() {
//		//        ValueBinding valueBinding = ((UIComponent)jsfComponent).getValueBinding("value");
//		//        String expressionString = valueBinding.getExpressionString();
//		//        int indexOfMessageType = expressionString.indexOf(".");   
//		//        String value = expressionString.substring(indexOfMessageType+1,expressionString.length()-1);
//		//        return value;
//		ValueExpression valueExpr = ((UIComponent)jsfComponent).getValueExpression("value");
//		String expressionString = valueExpr.getExpressionString();
//		int indexOfMessageType = expressionString.indexOf(".");   
//		String value = expressionString.substring(indexOfMessageType+1,expressionString.length()-1);
//		return value;
//	}
//
//
//	public boolean isRequiredAttributePresent() {
//		if(jsfComponent instanceof CoreShowDetailItem){
//			return false;
//		}else        
//			if(jsfComponent instanceof CoreCommandButton){
//				return false;
//			}
//
//		return true;
//	}
//
//	public boolean isDisabledAttributePresent() {
//		return true;
//	}
//
//	public boolean isReadOnlyAttributePresent() {
//		if(jsfComponent instanceof CoreShowDetailItem){
//			return false;
//		}else        
//			if(jsfComponent instanceof CoreCommandButton){
//				return false;
//			}
//		return true;
//
//	}
//
//
//	public boolean isShowRequired() {
//		Boolean b = null;
//		if(jsfComponent instanceof CoreTable) {
//			b = (Boolean)((UIComponent)jsfComponent).getAttributes().get(REQUIRED_ATTR_FOR_TABLE);
//			if(b != null && b) {
//				System.out.println();
//			}
//		}
//		else if(jsfComponent instanceof UIComponent){
//			b = (Boolean)((UIComponent)jsfComponent).getAttributes().get("showRequired");
//		}
//		if(null ==b){
//			return false;
//		}else{
//			return b;
//		}
//	}
//	
//	public boolean isMultiColumn(){
//		boolean result=false;
//		if(jsfComponent instanceof UIComponent){
//			Object obj = ((UIComponent)jsfComponent).getAttributes().get("rows");
//			if(obj != null){
//				int mm =(Integer)obj;
//				if(mm>1){
//					result=true;
//				}
//			}
//		}
//		return result;
//	}
//
//	public boolean isValidateInUI() {
//
//		Boolean ValidateInUI = (Boolean)((UIComponent)jsfComponent).getAttributes().get("ValidateInUI");
//		if (ValidateInUI == null) {
//			ValidateInUI = true;
//		}
//		return isShowRequired() && ValidateInUI;
//	}
//
//	private boolean isShowRequiredAttributePresent() {
//		return isRequiredAttributePresent();
//	}
//
//	public boolean isRenderedAttributePresent() {
//		return true;
//	}
//
//	public boolean isInlineStyleAttributePresent() {
//		return true;
//	}
//
//	public void setMaxLength(Long length) {
//		if(isUIXInputComponent() && length != null){
//			((CoreInputText)jsfComponent).setMaximumLength(length.intValue());
//		}
//	}
//	//add Barkhas
//	public void setResizeProtect() {
//		setProperty("contentStyle", "resize:vertical;overflow:auto;");
//	}
//
//	public boolean isUIXInputComponent(){
//		if(jsfComponent instanceof UIXInput){
//			return true;
//		}else{
//			return false;
//		}
//	}
//        
////    public void applyValidation(GuiPageConfig guiPageConfig) {
////        applyValidate(guiPageConfig.getMinLength(), 
////                      guiPageConfig.getMaxLength(), 
////                      guiPageConfig.getRegExpression(), 
////                      guiPageConfig.getDefaultValue(), 
////                      guiPageConfig.getValidationScript());
////    }
//    
//    
//
//	/**
//	 * Applys the validation defined to an adf/jsf validation
//	 * @param valMessageStatic
//	 */
//	public boolean applyValidation(ValMessageStatic valMessageStatic,FacesContext fc, Object value, List<FacesMessage> messages) {
//
//		/*
//		 * Add validator if component is of type UIXInputComponent
//		 */
//		if(isUIXInputComponent()){           
//
//
//			/*
//			 * Check length validator
//			 */
//			LengthValidator lengthValidator = null;
//			if(valMessageStatic.getMax() != null || valMessageStatic.getMin() != null ){
//				lengthValidator = new LengthValidator();
//
//				if(valMessageStatic.getMax() != null){
//					lengthValidator.setMaximum(valMessageStatic.getMax().intValue());
//
//					if(jsfComponent instanceof CoreInputText){
//						((CoreInputText)jsfComponent).setMaximumLength(valMessageStatic.getMax().intValue());
//					}
//				}
//
//				if(valMessageStatic.getMin() != null){
//					lengthValidator.setMinimum(valMessageStatic.getMin().intValue());
//
//					if(jsfComponent instanceof CoreInputText){
//						((CoreInputText)jsfComponent).setMaximumLength(valMessageStatic.getMin().intValue());
//					}
//				}
//
//				((UIXInput)jsfComponent).addValidator(lengthValidator);
//				try {
//					lengthValidator.validate(fc,((UIXInput)jsfComponent),((CoreInputText)jsfComponent).getValue());             
//				} 
//				catch(ValidatorException ve) {
//					ve.printStackTrace();
//					messages.add(ve.getFacesMessage());
//				}
//				catch(Exception e) {
//					e.printStackTrace();
//				}
//				finally {
//					((UIXInput)jsfComponent).removeValidator(lengthValidator);
//				}
//			}
//
//			RegExpValidator  regExpValidator = null;
//			if(valMessageStatic.getMask() != null){
//				regExpValidator = new RegExpValidator();
//				regExpValidator.setPattern(valMessageStatic.getMask());
//				String msg = FacesUtil.getStringFromBundle("Global.validation.Mask_"+valMessageStatic.getMask());
//				//to:do:currently commented for testing for 11g migration
//				//  regExpValidator.setNoMatchMessageDetail(msg);
//				((UIXInput)jsfComponent).addValidator(regExpValidator);
//
//				try {
//					regExpValidator.validate(fc,((UIXInput)jsfComponent),((UIXInput)jsfComponent).getValue());             
//				} 
//				catch(ValidatorException ve) {
//					ve.printStackTrace();
//					//					String label = (String)((UIXInput)jsfComponent).getAttributes().get("label");
//					messages.add(ve.getFacesMessage());
//				}
//				catch(Exception e) {
//					e.printStackTrace();
//				}
//				finally {
//					((UIXInput)jsfComponent).removeValidator(regExpValidator);
//				}
//			}
//
//		}
//
//		return false;
//	}
//
//	public boolean isValueBindingPresent() {
//		return getBackingBeanName() == null ? false : true;
//	}
//
//	public FacesMessage validateRequired() {
//		String label = (String)((UIComponent)this.getJsfComponent()).getAttributes().get("label");
//		if(null != label){
//			return FacesUtil.createFacesMessage(FacesMessage.SEVERITY_ERROR, label, "Global.msg.ValueRequired");
//		}
//		else if(this.getJsfComponent() instanceof CoreTable) {
//			// We should learn the name of the table. In order to learn that, recursively, 
//			// we will find the first parent component which is a panel layout component and take the label from that panel.
//			label = findLabelForTable((UIComponent)this.getJsfComponent());
//			if(label != null) {
//				return FacesUtil.createFacesMessage(FacesMessage.SEVERITY_ERROR, label + " table", "Global.msg.AtLeastOneEntry");
//			}
//			else {
//				return FacesUtil.createFacesMessage(FacesMessage.SEVERITY_ERROR, "Table", "Global.msg.AtLeastOneEntry");
//			}
//		}else if(this.getJsfComponent() instanceof CorePanelGroupLayout){
//			label = (String)((UIComponent)this.getJsfComponent()).getAttributes().get("shortDesc");
//			return FacesUtil.createFacesMessage(FacesMessage.SEVERITY_ERROR, label, "Global.msg.ValueRequired");
//		}
//		return null;
//	}
//
//	private String findLabelForTable(UIComponent comp) {
//		if(comp instanceof CoreTable) {
//			if(((CoreTable)comp).getShortDesc() != null) {
//				return ((CoreTable)comp).getShortDesc();
//			}
//		}
//		UIComponent parent = comp.getParent();
//		String label = (String)parent.getAttributes().get("text");
//		if(label == null) {
//			if(parent instanceof CorePanelLabelAndMessage) {
//				label = ((CorePanelLabelAndMessage)parent).getLabel();
//			}
//		}
//		if(label != null)
//			return label;
//		else {
//			return findLabelForTable(parent);
//		}
//	}
//
//	public boolean hasNoValue() {
//		UIComponent input = ((UIComponent)this.getJsfComponent());
//		if(input instanceof CorePanelGroupLayout){
//			CorePanelGroupLayout group = (CorePanelGroupLayout)input;
//			return validatePanelGroup(group);
//		}
//		Object value = null;
//		try{
//			//			ValueBinding vb = input.getValueBinding("value");
//			//			value = null != vb ? vb.getValue(FacesContext.getCurrentInstance()) : null;
//			ValueExpression vb = input.getValueExpression("value");
//			value = null != vb ? vb.getValue(FacesContext.getCurrentInstance().getELContext()) : null;
//		}catch(Exception ex){
//			ex.printStackTrace();
//		}
//		// check if it is a table component. If it is, then look at the number of elements in the table. If there is
//		// no element, return true. Otherwise, return false.
//		if(input instanceof CoreTable) {
//			if(value == null)
//				return true;
//			if(value instanceof List) {
//				List valueList = (List)value;
//				if(valueList.size() == 0) {
//					return true;
//				}
//				else {
//					return false;
//				}
//			}
//			else if(value instanceof SortableModel) {
//				SortableModel valueModel = (SortableModel)value;
//				if(valueModel.getWrappedData() == null ||
//						!(valueModel.getWrappedData() instanceof List))
//					return true;
//				if(((List)valueModel.getWrappedData()).size() == 0)
//					return true;
//				else
//					return false;
//			}
//		}
//		if(value instanceof String){
//			return ((String)value).equalsIgnoreCase(Constants.BLANK);
//		}else
//			return  value == null ? true : false;
//	}
//
//	public String toString() {
//		UIComponent input = ((UIComponent)this.getJsfComponent());
//		Object id = input.getValueExpression("id").getValue(FacesContext.getCurrentInstance().getELContext());
//		String output = "id = " + id;      
//		return output;
//	}
//
//	public boolean validatePanelGroup(UIComponent group){
//		for(Object object:group.getChildren()){
//			UIComponent component = (UIComponent)object;
//			if(component instanceof UIXEditableValue){
//				Object obj = component.getValueExpression("value").getValue(FacesContext.getCurrentInstance().getELContext());
//				if(obj instanceof String){
//					if(((String)obj).equalsIgnoreCase(Constants.BLANK))
//						continue;    
//					else                     
//						return false;
//				}else
//					if(obj == null)
//						continue;
//					else
//						return false;
//			}else{
//				if(!validatePanelGroup(component))   
//					return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean skipReadonlyGuiConfig() {
//
//		try {
//			ValueExpression valueExpr = ((UIComponent)jsfComponent).getValueExpression("readonly");
//			Object val = ((UIComponent)jsfComponent).getAttributes().get("readonly");
//			if(valueExpr!=null) {
//				return true;
//			}
//
//			if(Boolean.valueOf((Boolean)val)) {
//				return true;
//			}
//			//		String expressionString = valueExpr.getExpressionString();
//			//		int indexOfBackingBeanName = expressionString.indexOf(".");   
//			//		String backingBeanName = expressionString.substring(0, indexOfBackingBeanName);
//			//		String value = expressionString.substring(indexOfBackingBeanName+1,expressionString.length()-1);
//			//		if(backingBeanName==null) {
//			//			if(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
//			//				
//			//			} 
//			//		}
//			//		if(backingBeanName.equalsIgnoreCase("true") || backingBeanName.equalsIgnoreCase("false")) {
//			//			
//			//		}
//		} catch(Exception ex) {
//
//		}
//		return false;
//	}
//
//	public boolean skipDisabledGuiConfig() {
//		try {
//			ValueExpression valueExpr = ((UIComponent)jsfComponent).getValueExpression("disabled");
//			Object val = ((UIComponent)jsfComponent).getAttributes().get("disabled");
//			if(valueExpr!=null) {
//				return true;
//			}
//			if(Boolean.valueOf((Boolean)val)) {
//				return true;
//			}
//		} catch(Exception ex) {
//
//		}
//		return false;
//	}
//
//	public boolean skipRenderedGuiConfig() {
//		try {
//			ValueExpression valueExpr = ((UIComponent)jsfComponent).getValueExpression("rendered");
//			Object val = ((UIComponent)jsfComponent).getAttributes().get("rendered");
//			if(valueExpr!=null) {
//				return true;
//			}
//
//			if(!Boolean.valueOf((Boolean)val)) {
//				return true;
//			}
//		} catch(Exception ex) {
//
//		}
//		return false;
//	}
//        
//    /**
//      * In this method we can do date component validation. Currently we are doing whether year is proper or not.
//      * @param validationMessages
//      */
//    public void isValidDateComponet(List<FacesMessage> validationMessages) {
//        UIComponent input = ((UIComponent)this.getJsfComponent());
//        String label = 
//            (String)((UIComponent)this.getJsfComponent()).getAttributes().get("label");
//        if (input.getValueBinding("value") != null) {
//            Object value = 
//                input.getValueBinding("value").getValue(FacesContext.getCurrentInstance());
//            if (value instanceof Calendar) {
//                Calendar cal = (Calendar)value;
//                int year = cal.get(Calendar.YEAR);
//                if (year < MINIMUM_YEAR) {
//                    FacesMessage fm = 
//                        FacesUtil.createFacesMessage(FacesMessage.SEVERITY_ERROR, 
//                            label, "InvalidDate.PleaseEnterCorrectDate");
//                    validationMessages.add(fm);
//                }
//            }
//        }
//    }
//        
//}
