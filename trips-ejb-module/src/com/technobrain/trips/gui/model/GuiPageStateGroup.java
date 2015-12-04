package com.technobrain.trips.gui.model;

import com.technobrain.trips.core.model.BaseCompositeModelObject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "GuiPageStateGroup.findAll", 
    query = "select o from GuiPageStateGroup o")
@Table(name = "GUI_PAGE_STATE_GROUP")
public class GuiPageStateGroup extends BaseCompositeModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    @Id
    @Column(name="PAGE_STATE", nullable = false)
    private String pageState;

    public GuiPageStateGroup() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPageState() {
        return pageState;
    }

    public void setPageState(String pageState) {
        this.pageState = pageState;
    }
    
    @Override
    public final boolean equals(Object other) {
        if (other == this)
            return true;
        if ((other == null) || !(other instanceof BaseCompositeModelObject))
            return false;

        final GuiPageStateGroup normalModel = (GuiPageStateGroup)other;

        if (code != null && pageState != null && normalModel.getCode() != null && normalModel.getPageState() != null) {
            return code.equals(normalModel.getCode()) && pageState.equals(normalModel.getPageState());
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if(code == null || pageState == null)
            return super.hashCode();
        else    
        return code.toString().concat(pageState.toString()).hashCode();
    }
}
