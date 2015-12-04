package com.technobrain.trips.gui.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "GuiPageState.findAll", 
    query = "select o from GuiPageState o")
@Table(name = "GUI_PAGE_STATE")
public class GuiPageState extends BaseModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
     
//    @OneToMany(mappedBy = "guiPageState")
//    private List<GuiPageMode> guiPageModeList;

    public GuiPageState() {
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
//
//    public List<GuiPageMode> getGuiPageModeList() {
//        return guiPageModeList;
//    }
//
//    public void setGuiPageModeList(List<GuiPageMode> guiPageModeList) {
//        this.guiPageModeList = guiPageModeList;
//    }

//    public GuiPageMode addGuiPageMode(GuiPageMode guiPageMode) {
//        getGuiPageModeList().add(guiPageMode);
//        //guiPageMode.setGuiPageState(this);
//        return guiPageMode;
//    }
//
//    public GuiPageMode removeGuiPageMode(GuiPageMode guiPageMode) {
//        getGuiPageModeList().remove(guiPageMode);
//       // guiPageMode.setGuiPageState(null);
//        return guiPageMode;
//    }

 @Override
 public final boolean equals(Object other) {
     if(other instanceof GuiPageState){
         final GuiPageState refModel = (GuiPageState)other;
 
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
