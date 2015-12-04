package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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
@NamedQuery(name = "FlexFormTypeModeAtt.findAll", 
    query = "select o from FlexFormTypeModeAtt o")
    @Table(name = "FLEX_FORM_TYPE_MODE_ATT")
public class FlexFormTypeModeAtt  extends BaseNormalModelObject {
    public FlexFormTypeModeAtt() {
    }
    
    @Id    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "FLEX_FORM_TYPE_MODE_ATT_SEQ")
    @SequenceGenerator(name = "FLEX_FORM_TYPE_MODE_ATT_SEQ", sequenceName = "FLEX_FORM_TYPE_MODE_ATT_SEQ", 
                       allocationSize = 1)    
    @Column(nullable = false)
    private Long id;
    
    @Column(name="ATTRIBUTE_NAME")
    private String attibuteName;
    
    @Column(name="ATTRIBUTE_VALUE")
    private String attibuteValue;
    
    @ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "FORM_TYPE_MODE_ID", referencedColumnName = "ID")
    private FlexFormTypeModeRel formTypeMode;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setAttibuteName(String attibuteName) {
        this.attibuteName = attibuteName;
    }

    public String getAttibuteName() {
        return attibuteName;
    }

    public void setAttibuteValue(String attibuteValue) {
        this.attibuteValue = attibuteValue;
    }

    public String getAttibuteValue() {
        return attibuteValue;
    }

    public void setFormTypeMode(FlexFormTypeModeRel formTypeMode) {
        this.formTypeMode = formTypeMode;
    }

    public FlexFormTypeModeRel getFormTypeMode() {
        return formTypeMode;
    }
}
