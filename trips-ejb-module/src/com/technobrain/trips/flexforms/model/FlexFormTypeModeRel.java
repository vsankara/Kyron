package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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
@NamedQuery(name = "FlexFormTypeModeRel.findAll", 
    query = "select o from FlexFormTypeModeRel o")
    @Table(name = "FLEX_FORM_TYPE_MODE_REL")
public class FlexFormTypeModeRel  extends BaseNormalModelObject {
    public FlexFormTypeModeRel() {
    }
    
    @Id    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "FLEX_FORM_TYPE_MODE_REL_SEQ")
    @SequenceGenerator(name = "FLEX_FORM_TYPE_MODE_REL_SEQ", sequenceName = "FLEX_FORM_TYPE_MODE_REL_SEQ", 
                       allocationSize = 1)    
    @Column(nullable = false)
    private Long id;
    
    @Column(name="MODE_CODE")
    private String mode;
    
    @Column(name="MODE_TYPE")
    private String modeType;
    
    @Column(name="DEPENDENT_ON")
    private String dependentOn;
    
    
    @ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "FORM_TYPE_ID", referencedColumnName = "ID")
    private FlexibleFormType formType;
    

    @OneToMany(mappedBy="formTypeMode", cascade={CascadeType.ALL})
    private List<FlexModeAttrValues> modeAttributes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    public void setModeType(String modeType) {
        this.modeType = modeType;
    }

    public String getModeType() {
        return modeType;
    }

    public void setDependentOn(String dependentOn) {
        this.dependentOn = dependentOn;
    }

    public String getDependentOn() {
        return dependentOn;
    }

    public void setFormType(FlexibleFormType flexibleFormType) {
        this.formType = flexibleFormType;
    }

    public FlexibleFormType getFormType() {
        return formType;
    }
    
    public FlexModeAttrValues addModeAttribute(FlexModeAttrValues modeAttribute) {
        getModeAttributes().add(modeAttribute);
        modeAttribute.setFormTypeMode(this);
        return modeAttribute;
    }

    public FlexModeAttrValues removeModeAttribute(FlexModeAttrValues modeAttribute) {
        getModeAttributes().remove(modeAttribute);
        modeAttribute.setFormTypeMode(null);
        return modeAttribute;    
    }

    public void setAttributes(List<FlexModeAttrValues> modeAttributes) {
        this.modeAttributes = modeAttributes;
    }

    public List<FlexModeAttrValues> getModeAttributes() {
        return modeAttributes;
    }

}
