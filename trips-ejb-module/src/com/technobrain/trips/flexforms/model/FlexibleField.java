package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "FlexibleField.findAll", 
    query = "select o from FlexibleField o")
@Table(name = "FLEXIBLE_FIELD")
public class FlexibleField extends BaseNormalModelObject {

    @Column(name="DEFAULT_VALUE")
    private String defaultValue;
    private String disabled;
    @ManyToOne
    @JoinColumn(name = "FORM_FIELD_ID", referencedColumnName = "ID")
    private FlexibleFormField formField;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "FLEXIBLE_FIELD_SEQ")
    @SequenceGenerator(name = "FLEXIBLE_FIELD_SEQ", sequenceName = "FLEXIBLE_FIELD_SEQ", 
                       allocationSize = 1)    
    @Column(nullable = false)
    private Long id;
    private String mandatory;
    @Column(name="MODE_SELECTED")
    private String modeSelected;
    private String rendered;
    @Column(name="DISABLE_SCRIPT")
    private String disableScript;
    @Column(name="FORCE_RUN_SCRIPT")
    private String forceRunScript;    
    @OneToMany(mappedBy = "field", cascade={CascadeType.ALL})
    private List<FlexibleAttribute> attributes;


    public FlexibleField() {
    }


    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDisabled() {
        return disabled;
    }
    
    public boolean disabled() {
        if(disabled == null)
            return false;
        return StringHelper.getIndicatorAsBoolean(disabled);
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMandatory() {
        return mandatory;
    }
    
    public boolean mandatory() {
        if(mandatory == null)
            return false;
        return StringHelper.getIndicatorAsBoolean(mandatory);
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    public String getModeSelected() {
        return modeSelected;
    }

    public void setModeSelected(String modeSelected) {
        this.modeSelected = modeSelected;
    }

    public String getRendered() {
        return rendered;
    }
    
    public boolean rendered() {
        if(rendered == null)
            return false;
        return StringHelper.getIndicatorAsBoolean(rendered);
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }


    public void setAttributes(List<FlexibleAttribute> attributes) {
        this.attributes = attributes;
    }
    
    public String getAttributeValue(String attrName) {
        for(FlexibleAttribute attr:getAttributes()) {
            if(attrName.equals(attr.getAttributeName())) {
                return attr.getAttributeValue();
            }
        }
        return null;
    }

    public List<FlexibleAttribute> getAttributes() {
        return attributes;
    }

    public FlexibleAttribute addFlexibleAttribute(FlexibleAttribute flexibleAttribute) {
        getAttributes().add(flexibleAttribute);
        flexibleAttribute.setField(this, false);
        return flexibleAttribute;
    }

    public FlexibleAttribute removeFlexibleAttribute(FlexibleAttribute flexibleAttribute) {
        getAttributes().remove(flexibleAttribute);
        flexibleAttribute.setField(null);
        return flexibleAttribute;
    }
    
    public void setFormField(FlexibleFormField formField, boolean addTo) {
        this.formField = formField;
        if(addTo && formField != null) {
            formField.addFlexibleField(this);
        }
    }

    public void setFormField(FlexibleFormField formField) {
        this.formField = formField;
    }

    public FlexibleFormField getFormField() {
        return formField;
    }

    public void setDisableScript(String disableScript) {
        this.disableScript = disableScript;
    }

    public String getDisableScript() {
        return disableScript;
    }

    public void setForceRunScript(String forceRunScript) {
        this.forceRunScript = forceRunScript;
    }

    public String getForceRunScript() {
        return forceRunScript;
    }
}
