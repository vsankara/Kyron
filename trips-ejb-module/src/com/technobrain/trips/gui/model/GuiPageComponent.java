package com.technobrain.trips.gui.model;

import com.technobrain.trips.common.constants.Constants;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;

import javax.persistence.CascadeType;
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
@NamedQuery(name = "GuiPageComponent.findAll", 
            query = "select o from GuiPageComponent o")
@Table(name = "GUI_PAGE_COMPONENT")
public class GuiPageComponent extends BaseNormalModelObject   {
    @Column(name = "COMPONENT_ID", nullable = false)
    private String componentId;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gui_page_component_seq")
    @SequenceGenerator(name = "gui_page_component_seq", sequenceName = "gui_page_component_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
     
    @OneToMany(cascade={CascadeType.ALL},mappedBy = "guiPageComponent")
    private List<GuiPageConfig> guiPageConfigList;
    @ManyToOne
    @JoinColumn(name = "PAGE_CODE", referencedColumnName = "CODE")
    private GuiPage guiPage;
    
    @Column(name = "MESSAGE_TYPE")
    private String messageType;
    @Column(name = "MESSAGE_ATTRIBUTE")
    private String messageAttribute;
    private String description;
    
    @Column(name = "TYPE")
    private String componentType;
        
    public GuiPageComponent() {
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GuiPageConfig> getGuiPageConfigList() {
        return guiPageConfigList;
    }

    public void setGuiPageConfigList(List<GuiPageConfig> guiPageConfigList) {
        this.guiPageConfigList = guiPageConfigList;
    }

    public GuiPageConfig addGuiPageConfig(GuiPageConfig guiPageConfig) {
        getGuiPageConfigList().add(guiPageConfig);
        guiPageConfig.setGuiPageComponent(this);
        return guiPageConfig;
    }

    public GuiPageConfig removeGuiPageConfig(GuiPageConfig guiPageConfig) {
        getGuiPageConfigList().remove(guiPageConfig);
        guiPageConfig.setGuiPageComponent(null);
        return guiPageConfig;
    }


    public GuiPage getGuiPage() {
        return guiPage;
    }

    public void setGuiPage(GuiPage guiPage) {
        this.guiPage = guiPage;
    }

    public GuiPageConfig createNewPageConfigFor(GuiPageMode guiPageMode) {
        GuiPageConfig guiPageConfig = new GuiPageConfig();
        guiPageConfig.setGuiPageComponent(this); // component
        guiPageConfig.setGuiPageMode(guiPageMode); // mode
        guiPageConfig.setPageModeId(guiPageMode.getId());
        guiPageConfig.setComponentRefId(this.getId());
        guiPageConfig.setPropertyId(Long.valueOf("1"));
        guiPageConfig.setPropertyValue("x");
        guiPageConfig.setRequired(true); //required
        guiPageConfig.setDisabled(false);
        guiPageConfig.setReadOnly(false);
        guiPageConfig.setOptional(false);
        guiPageConfig.setRendered(true);
        guiPageConfig.setValidateOnSubmission(false);
        guiPageConfig.setStatus(Constants.RecordStatus.ACTIVE);
        guiPageConfig.setVersion(Long.valueOf("0"));
        return guiPageConfig;
    }


    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageAttribute(String messageAttribute) {
        this.messageAttribute = messageAttribute;
    }

    public String getMessageAttribute() {
        return messageAttribute;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    
    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public String getComponentType() {
        return componentType;
    }
}
