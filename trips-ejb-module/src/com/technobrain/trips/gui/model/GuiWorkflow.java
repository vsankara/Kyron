package com.technobrain.trips.gui.model;


import com.technobrain.trips.core.model.BaseModelObject;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = "GuiWorkflow.findAll", 
        query = "select o from GuiWorkflow o"),
    @NamedQuery(name ="GuiWorkflow.findAllActiveByType",
        query="select o from GuiWorkflow o where o.modeType = :aModeType and o.status = :aStatus order by o.description")})
@Table(name = "GUI_WORKFLOW")
public class GuiWorkflow extends BaseModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String description;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @Column(name = "MODE_TYPE",nullable = false,insertable=false,updatable=false)
    private String modeType;
    @ManyToOne
    @JoinColumn(name = "MODE_TYPE", referencedColumnName = "CODE")
    private GuiModeType guiModeType;
    @OneToMany(mappedBy = "guiWorkflow")
    private List<GuiPageMode> guiPageModeList;

    public GuiWorkflow() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GuiModeType getGuiModeType() {
        return guiModeType;
    }

    public void setGuiModeType(GuiModeType guiModeType) {
        this.guiModeType = guiModeType;
    }

    public List<GuiPageMode> getGuiPageModeList() {
        return guiPageModeList;
    }

    public void setGuiPageModeList(List<GuiPageMode> guiPageModeList) {
        this.guiPageModeList = guiPageModeList;
    }

    public GuiPageMode addGuiPageMode(GuiPageMode guiPageMode) {
        getGuiPageModeList().add(guiPageMode);
        guiPageMode.setGuiWorkflow(this);
        return guiPageMode;
    }

    public GuiPageMode removeGuiPageMode(GuiPageMode guiPageMode) {
        getGuiPageModeList().remove(guiPageMode);
        guiPageMode.setGuiWorkflow(null);
        return guiPageMode;
    }

    public void setModeType(String modeType) {
        this.modeType = modeType;
    }

    public String getModeType() {
        return modeType;
    }
    
   
    public final boolean equals(Object other) {
        if(other instanceof GuiWorkflow){
            final GuiWorkflow refModel = (GuiWorkflow)other;
    
            if (getCode() != null && refModel.getCode() != null) {
                return getCode().equals(refModel.getCode());
            }
        }
        return false;
    }
    
    
    public final int hashCode() {
        if(this.getCode() != null) {
            return this.getCode().hashCode();
        } 
        else   
            return super.hashCode();
    }
}
