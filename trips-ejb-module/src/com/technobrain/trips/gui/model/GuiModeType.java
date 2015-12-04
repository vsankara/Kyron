package com.technobrain.trips.gui.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "GuiModeType.findAll", 
    query = "select o from GuiModeType o")
@Table(name = "GUI_MODE_TYPE")
public class GuiModeType extends BaseModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String description;
     
    @OneToMany(mappedBy = "guiModeType")
    private List<GuiWorkflow> guiWorkflowList;
//    @OneToMany(mappedBy = "guiModeType")
//    private List<GuiPageMode> guiPageModeList;

    public GuiModeType() {
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

    public List<GuiWorkflow> getGuiWorkflowList() {
        return guiWorkflowList;
    }

    public void setGuiWorkflowList(List<GuiWorkflow> guiWorkflowList) {
        this.guiWorkflowList = guiWorkflowList;
    }

    public GuiWorkflow addGuiWorkflow(GuiWorkflow guiWorkflow) {
        getGuiWorkflowList().add(guiWorkflow);
        guiWorkflow.setGuiModeType(this);
        return guiWorkflow;
    }

    public GuiWorkflow removeGuiWorkflow(GuiWorkflow guiWorkflow) {
        getGuiWorkflowList().remove(guiWorkflow);
        guiWorkflow.setGuiModeType(null);
        return guiWorkflow;
    }

//    public List<GuiPageMode> getGuiPageModeList() {
//        return guiPageModeList;
//    }
//
//    public void setGuiPageModeList(List<GuiPageMode> guiPageModeList) {
//        this.guiPageModeList = guiPageModeList;
//    }
//
//    public GuiPageMode addGuiPageMode(GuiPageMode guiPageMode) {
//        getGuiPageModeList().add(guiPageMode);
//        //guiPageMode.setGuiModeType(this);
//        return guiPageMode;
//    }
//
//    public GuiPageMode removeGuiPageMode(GuiPageMode guiPageMode) {
//        getGuiPageModeList().remove(guiPageMode);
//        //guiPageMode.setGuiModeType(null);
//        return guiPageMode;
//    }

 @Override
 public final boolean equals(Object other) {
     if(other instanceof GuiModeType){
         final GuiModeType refModel = (GuiModeType)other;
 
         if (getCode() != null && refModel.getCode() != null) {
             return getCode().equals(refModel.getCode());
         }
     }
     return false;
 }
 
 @Override
 public final int hashCode() {
     if(this.getCode() != null) {
         return this.getCode().hashCode();
     } 
     else   
         return super.hashCode();
 }
}
