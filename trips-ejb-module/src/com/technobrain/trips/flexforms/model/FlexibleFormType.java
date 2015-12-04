package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.flexforms.helper.FlexFormsConstants;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQueries({
@NamedQuery(name = "FlexibleFormType.findAll", 
    query = "select o from FlexibleFormType o order by o.formType Asc"),
@NamedQuery(name = "FlexibleFormType.findFormTypeByName", 
    query = "select o from FlexibleFormType o where o.formType = ?1"),
@NamedQuery(name = "FlexibleFormType.findAllMainPageFormType", 
    query = "select distinct o.formType from FlexibleForm o where o.displayType = 'Main' and o.status = 'A' order by o.formType.formType Asc")
})
@Table(name = "FLEXIBLE_FORM_TYPE")
public class FlexibleFormType extends BaseNormalModelObject   {
    @Column(name="BPEL_TO_USE")
    private String bpelToUse;
    @Column(name="FORM_TYPE")
    private String formType;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "FLEXIBLE_FORM_TYPE_SEQ")
    @SequenceGenerator(name = "FLEXIBLE_FORM_TYPE_SEQ", sequenceName = "FLEXIBLE_FORM_TYPE_SEQ", 
                       allocationSize = 1)    
    @Column(nullable = false)
    private Long id;
    @Column(name="MENU_HEADER")
    private String menuHeader;
    @Column(name="MENU_TITLE")
    private String menuTitle;
    @Column(name="SCHEMA_TYPE")
    private String schemaType;
    @Column(name="SEARCH_ID")
    private String searchId;
    @Column(name="MAPPED_TYPE")
    private String mappedType;
    
    @OneToMany(mappedBy="formType", cascade={CascadeType.ALL})
    private List<FlexFormTypeModeRel> modes;
    
    @Column(name="CONFIGURATION_SET")
    private String configurationSet;
    
//    @ManyToMany(cascade={CascadeType.ALL})
//    @JoinTable(name="FLEX_FORM_TYPE_MODE_REL",
//        joinColumns={@JoinColumn(name = "FORM_TYPE_ID",
//                referencedColumnName = "ID")},
//        inverseJoinColumns = {@JoinColumn(name = "MODE_CODE",
//                referencedColumnName = "CODE")}
//    )
//    private List<RefFlexibleFormMode> modes;
    
    public FlexibleFormType() {
    }

    public String getBpelToUse() {
        return bpelToUse;
    }

    public void setBpelToUse(String bpelToUse) {
        this.bpelToUse = bpelToUse;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuHeader() {
        return menuHeader;
    }

    public void setMenuHeader(String menuHeader) {
        this.menuHeader = menuHeader;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getSchemaType() {
        return schemaType;
    }

    public void setSchemaType(String schemaType) {
        this.schemaType = schemaType;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public FlexFormTypeModeRel addMode(FlexFormTypeModeRel flexibleMode) {
        getModes().add(flexibleMode);
        flexibleMode.setFormType(this);
        return flexibleMode;
    }

    public FlexFormTypeModeRel removeMode(FlexFormTypeModeRel flexibleMode) {
        getModes().remove(flexibleMode);
        flexibleMode.setFormType(null);
        return flexibleMode;    
    }

    public void setModes(List<FlexFormTypeModeRel> modes) {
        this.modes = modes;
    }

    public List<FlexFormTypeModeRel> getModes() {
        return modes;
    }
    
    public String getActualMode(String mode) {
        for(FlexFormTypeModeRel modeObj:getModes())   {
            if(modeObj.getMode().equals(mode)) {
                if(modeObj.getModeType().equals(FlexFormsConstants.ModeTypes.EXTENDED)) {
                    return modeObj.getDependentOn();
                }
                else {
                    return modeObj.getMode();
                }
            }
        }
        return null;
    }

    public void setConfigurationSet(String configurationSet) {
        this.configurationSet = configurationSet;
    }

    public String getConfigurationSet() {
        return configurationSet;
    }

    public void setMappedType(String mappedType) {
        this.mappedType = mappedType;
    }

    public String getMappedType() {
        return mappedType;
    }
}
