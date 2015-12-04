package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefFlexFormTypeModeAttribute;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "FlexModeAttrValues.findAll", 
    query = "select o from FlexModeAttrValues o")
    @Table(name = "FLEX_MODE_ATTR_VALUES")
public class FlexModeAttrValues  extends BaseNormalModelObject {
    public FlexModeAttrValues() {
    }
    
    @Id    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "FLEX_MODE_ATTR_VALUES_SEQ")
    @SequenceGenerator(name = "FLEX_MODE_ATTR_VALUES_SEQ", sequenceName = "FLEX_MODE_ATTR_VALUES_SEQ", 
                       allocationSize = 1)    
    @Column(nullable = false)
    private Long id;
    
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "ATTRIBUTE_NAME", referencedColumnName = "CODE", insertable=false, updatable=false)
    private RefFlexFormTypeModeAttribute attibute;
    
    @Column(name="ATTRIBUTE_NAME")
    private String attributeName;
    
    @Column(name="ATTRIBUTE_VALUE")
    private String attibuteValue;
    
    @ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "FORM_TYPE_MODE_ID", referencedColumnName = "ID")
    private FlexFormTypeModeRel formTypeMode;
    
    @Column(name="FORM_MODE_CODE")
    private String formMode;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setAttibute(RefFlexFormTypeModeAttribute attibute) {
        this.attibute = attibute;
    }

    public RefFlexFormTypeModeAttribute getAttibute() {
        return attibute;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setFormMode(String formMode) {
        this.formMode = formMode;
    }

    public String getFormMode() {
        return formMode;
    }
}
