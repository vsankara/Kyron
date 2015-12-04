package com.technobrain.trips.gui.beans;

import org.apache.log4j.Logger;

public class FieldDetailsBean {
    static final Logger log = Logger.getLogger(FieldDetailsBean.class);
    private String binding;
    private String backingBean;
    private String messageType;
    private String messageTypeField;
    private String min;
    private String max;
    private String mask;
    private String label;
    private String fieldName;
    private String defaultValue;
    private String validationScript;
    private String accessKey;
    
    public FieldDetailsBean() {}
    
    public FieldDetailsBean(String binding) {
            if(null == binding){
                //donothing
            }else{
                String expressionString = binding;
                int indexOfMessageType = expressionString.indexOf(".");   
                String  backingBeanName = expressionString.substring(1,indexOfMessageType);
                backingBeanName = backingBeanName.substring(1,backingBeanName.length());
                
        
                String messageTypeEL = expressionString.substring(indexOfMessageType+1,expressionString.length()-1);
                String messageTypeMemberName = messageTypeEL.substring(messageTypeEL.indexOf(".")+1,messageTypeEL.length());
                String messageTypeWithOutEL = messageTypeEL.substring(0,messageTypeEL.indexOf("."));
                    
            
//                ValueBinding bind = FacesUtil.getFacesContext().getApplication().createValueBinding("#{"+backingBeanName+"}");
//                this.binding = binding;
//                try {
//                    this.messageType = bind.getType(FacesUtil.getFacesContext()).getDeclaredField(messageTypeWithOutEL).getType().getSimpleName();
//                } catch (NoSuchFieldException e) {
//                    log.error(e.getLocalizedMessage(), e);
//                }
                if(this.messageType==null) {
                	this.messageType = messageTypeWithOutEL;
                }
                this.backingBean = backingBeanName; 
                this.messageTypeField = messageTypeMemberName;
            }
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getBinding() {
        return binding;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageTypeField(String messageTypeField) {
        this.messageTypeField = messageTypeField;
    }

    public String getMessageTypeField() {
        return messageTypeField;
    }

    public void setBackingBean(String backingBean) {
        this.backingBean = backingBean;
    }

    public String getBackingBean() {
        return backingBean;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMin() {
        return min;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMax() {
        return max;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getMask() {
        return mask;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setValidationScript(String validationScript) {
        this.validationScript = validationScript;
    }

    public String getValidationScript() {
        return validationScript;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessKey() {
        return accessKey;
    }
}
