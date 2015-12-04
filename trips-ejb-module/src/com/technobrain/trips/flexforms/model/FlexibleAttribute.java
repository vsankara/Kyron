package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.script.model.ScrFlexibleScript;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@NamedQuery(name = "FlexibleAttribute.findAll", 
    query = "select o from FlexibleAttribute o")
@Table(name = "FLEXIBLE_ATTRIBUTE")
public class FlexibleAttribute extends BaseNormalModelObject   {
    @Column(name="ATTACHED_ID")
    private Long attachedId;
    @Column(name="ATTRIBUTE_NAME")
    private String attributeName;
    @Column(name="ATTRIBUTE_TYPE")
    private String attributeType;
    @Column(name="ATTRIBUTE_VALUE")
    private String attributeValue;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "FLEXIBLE_ATTRIBUTE_SEQ")
    @SequenceGenerator(name = "FLEXIBLE_ATTRIBUTE_SEQ", sequenceName = "FLEXIBLE_ATTRIBUTE_SEQ", 
                       allocationSize = 1)       
    @Column(nullable = false)
    private Long id;
    @Column(name="RETURN_TYPE")
    private String returnType;

    @Column(name="PART_OF")
    private String partOf;
    
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "SCRIPT_ID", referencedColumnName = "ID")
    private ScrFlexibleScript script;

    @ManyToOne
    @JoinColumn(name = "FORM_ID", referencedColumnName = "ID")
    private FlexibleForm form;

    @ManyToOne
    @JoinColumn(name = "FIELD_ID", referencedColumnName = "ID")
    private FlexibleField field;


    public FlexibleAttribute() {
    }

    public Long getAttachedId() {
        return attachedId;
    }

    public void setAttachedId(Long attachedId) {
        this.attachedId = attachedId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setForm(FlexibleForm form) {
        setForm(form, true);
    }
    
    public void setForm(FlexibleForm form, boolean addTo) {
        this.form = form;
        if(addTo && form != null) {
            form.addAttribute(this);
        }
    }

    public FlexibleForm getForm() {
        return form;
    }

    public void setField(FlexibleField field) {
        setField(field, true);
    }
    
    public void setField(FlexibleField field, boolean addTo) {
        this.field = field;
        if(addTo && field != null) {
            field.addFlexibleAttribute(this);
        }
    }

    public FlexibleField getField() {
        return field;
    }
    
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }


    public void setPartOf(String partOf) {
        this.partOf = partOf;
    }

    public String getPartOf() {
        return partOf;
    }

    public void setScript(ScrFlexibleScript script) {
        this.script = script;
    }

    public ScrFlexibleScript getScript() {
        return script;
    }
}
