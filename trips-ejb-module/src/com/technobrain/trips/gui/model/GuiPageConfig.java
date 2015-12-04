package com.technobrain.trips.gui.model;

import com.technobrain.trips.core.model.BaseCompositeModelObject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PostPersist; 
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "GuiPageConfig.findAll", 
    query = "select o from GuiPageConfig o")
@Table(name = "GUI_PAGE_CONFIG")
@IdClass(GuiPageConfigPK.class)
public class GuiPageConfig extends BaseCompositeModelObject  implements Cloneable {
    @Id
    @Column(name="COMPONENT_REF_ID", nullable = false, insertable = false, 
        updatable = false)
    private Long componentRefId;
    @Id
    @Column(name="PAGE_MODE_ID", nullable = false, insertable = false, 
        updatable = false)
    private Long pageModeId;
   
    @Column(name="REQUIRED")
    private Boolean required;
    
    @Column(name="DISABLED")
    private Boolean disabled;
    
    @Column(name="RENDERED")
    private Boolean rendered;
    
    @Column(name="READONLY")
    private Boolean readOnly;
    
    @Column(name="MANDATORY")
    private Boolean optional;
    
    @Column(name="VALIDATE_ON_SUBMISSION")
    private Boolean validateOnSubmission;
    
    @Column(name="PROPERTY_ID")
    private Long propertyId;
    @Column(name="PROPERTY_VALUE", nullable = false)
    private String propertyValue;
     
     
    @ManyToOne
    @JoinColumn(name = "PROPERTY_ID", referencedColumnName = "ID" , nullable = false, insertable = false, 
        updatable = false)
    private GuiComponentProperty guiComponentProperty;
    @ManyToOne
    @JoinColumn(name = "COMPONENT_REF_ID", referencedColumnName = "ID")
    private GuiPageComponent guiPageComponent;
    @ManyToOne
    @JoinColumn(name = "PAGE_MODE_ID", referencedColumnName = "ID" )
    private GuiPageMode guiPageMode;
    
    @Column(name="MAX_LENGTH")
    private Long maxLength;
    @Column(name="MIN_LENGTH")
    private Long minLength;
    @Column(name="REG_EXPRESSION")
    private String regExpression;
    @Column(name="DEFAULT_VALUE")
    private String defaultValue;
    @Column(name="VAL_SCRIPT")
    private String validationScript;
    
    @PostPersist
    public Long getPrimaryKey(){
        log.debug("Primary Key = " + pageModeId);
        return pageModeId;
    }
    
    public GuiPageConfig() {
    }
      
    public Long getComponentRefId() {
        return componentRefId;
    }

    public void setComponentRefId(Long componentRefId) {
        this.componentRefId = componentRefId;
    }

    public Long getPageModeId() {
        return pageModeId;
    }

    public void setPageModeId(Long pageModeId) {
        this.pageModeId = pageModeId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
    
    public GuiComponentProperty getGuiComponentProperty() {
        return guiComponentProperty;
    }

    public void setGuiComponentProperty(GuiComponentProperty guiComponentProperty) {
        this.guiComponentProperty = guiComponentProperty;
    }

    public GuiPageComponent getGuiPageComponent() {
        return guiPageComponent;
    }

    public void setGuiPageComponent(GuiPageComponent guiPageComponent) {
        this.guiPageComponent = guiPageComponent;
    }

    public GuiPageMode getGuiPageMode() {
        return guiPageMode;
    }

    public void setGuiPageMode(GuiPageMode guiPageMode) {
        this.guiPageMode = guiPageMode;
    }
//
//    public boolean equals(Object obj) {
//        if(obj instanceof GuiPageConfig ){
//            GuiPageConfig objInst = (GuiPageConfig)obj;
//            
//            if(objInst.getPageModeId() == null)
//                return super.equals(obj);
//            
//            if( objInst.getPageModeId().equals(this.getPageModeId()) ){ // page mode id
//             if( objInst.getComponentRefId().equals(this.getComponentRefId()) ){ // comp ref id
//                  return true;    
//             }                  
//            }
//        }
//        
//        return false;       
//    }
////
//    public int hashCode() {
//    
//        if(this.getPageModeId() != null){
//        return this.getPageModeId().hashCode() * this.getComponentRefId().hashCode() ;
//        }else
//            return super.hashCode();
//    }

 

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean getRequired() {
        return required;
    }
    
    public boolean getRequiredAsBoolean() {
        return Boolean.valueOf(required);
    }
    

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setRendered(Boolean rendered) {
        this.rendered = rendered;
    }

    public Boolean getRendered() {
        return rendered;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setOptional(Boolean mandatory) {
        this.optional = mandatory;
    }

    public Boolean getOptional() {
        return optional;
    }
    

    @PreUpdate    
    @PrePersist
    public void setPresistDefaults(){
        
         if(null == this.getDisabled())
             this.setDisabled(false);
         
         if(null == this.getOptional())
             this.setOptional(false);
         
         if(null == this.getReadOnly())
             this.setReadOnly(false);
    }


    public boolean differenceInAttributes(GuiPageConfig updatedObject) {
        boolean equal = false;
       
        if(this.disabled != null && !this.disabled.equals(updatedObject.getDisabled())){
            return true;
        }else        
        if(this.readOnly != null && !this.readOnly.equals(updatedObject.getReadOnly())){
            return true;
        }else        
        if(this.optional != null && !this.optional.equals(updatedObject.getOptional())){
            return true;
        }else
        if(this.rendered != null && !this.rendered.equals(updatedObject.getRendered())){
            return true;
        }else
        if(this.required != null && !this.required.equals(updatedObject.getRequired())){
            return true;
        }
        
        return equal;
    }

    public Object clone() throws CloneNotSupportedException {    
        try {
              return super.clone();
        }catch (CloneNotSupportedException e) {
             throw new InternalError(e.toString());
        }
    }
    
    @Override
    public final boolean equals(Object other) {
        if(other instanceof GuiPageConfig){
         GuiPageConfig normalModel = (GuiPageConfig)other;

            if (pageModeId != null && componentRefId != null && normalModel.getPageModeId() != null && normalModel.getComponentRefId() != null) {
                return pageModeId.equals(normalModel.getPageModeId()) && componentRefId.equals(normalModel.getComponentRefId());
            }
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if(pageModeId == null || componentRefId == null)
            return super.hashCode();
        else    
        return pageModeId.toString().concat(componentRefId.toString()).hashCode();
    }

    public void securityUpdate(GuiPageConfig newSetting) {
        this.disabled = newSetting.getDisabled();
        this.readOnly = newSetting.getReadOnly();
        this.rendered = newSetting.getRendered();
    }

    public void setValidateOnSubmission(Boolean validateOnSubmission) {
        this.validateOnSubmission = validateOnSubmission;
}

    public Boolean getValidateOnSubmission() {
        return validateOnSubmission;
    }

    public void setMaxLength(Long maxLength) {
        this.maxLength = maxLength;
    }

    public Long getMaxLength() {
        return maxLength;
    }

    public void setMinLength(Long minLength) {
        this.minLength = minLength;
    }

    public Long getMinLength() {
        return minLength;
    }

    public void setRegExpression(String regExpression) {
        this.regExpression = regExpression;
    }

    public String getRegExpression() {
        return regExpression;
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
}
