package com.technobrain.trips.gui.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "GuiComponentProperty.findAll", 
    query = "select o from GuiComponentProperty o")
@Table(name = "GUI_COMPONENT_PROPERTY")
public class GuiComponentProperty extends BaseNormalModelObject   {
    @Id
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String property;
     
    @Column(nullable = false)
    private String type;
     
    @OneToMany(mappedBy = "guiComponentProperty")
    private List<GuiPageConfig> guiPageConfigList;

    public GuiComponentProperty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public List<GuiPageConfig> getGuiPageConfigList() {
        return guiPageConfigList;
    }

    public void setGuiPageConfigList(List<GuiPageConfig> guiPageConfigList) {
        this.guiPageConfigList = guiPageConfigList;
    }

    public GuiPageConfig addGuiPageConfig(GuiPageConfig guiPageConfig) {
        getGuiPageConfigList().add(guiPageConfig);
        guiPageConfig.setGuiComponentProperty(this);
        return guiPageConfig;
    }

    public GuiPageConfig removeGuiPageConfig(GuiPageConfig guiPageConfig) {
        getGuiPageConfigList().remove(guiPageConfig);
        guiPageConfig.setGuiComponentProperty(null);
        return guiPageConfig;
    }

}
