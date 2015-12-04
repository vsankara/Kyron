package com.technobrain.trips.gui.model;

import com.technobrain.trips.core.model.BaseCompositeModelObject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "GuiPageModeLink.findAll", 
    query = "select o from GuiPageModeLink o")
@Table(name = "GUI_PAGE_MODE_LINK")
@IdClass(GuiPageModeLinkPK.class)
public class GuiPageModeLink extends BaseCompositeModelObject   {
    @Id
    @Column(name="CHILD_ID", nullable = false, insertable = false, 
        updatable = false)
    private Long childId;
    @Id
    @Column(name="PARENT_ID", nullable = false, insertable = false, 
        updatable = false)
    private Long parentId;
    @ManyToOne
    @JoinColumn(name = "CHILD_ID", referencedColumnName = "ID")
    private GuiPageMode childMode;
    @ManyToOne
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
    private GuiPageMode parentMode;

    public GuiPageModeLink() {
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public GuiPageMode getChildMode() {
        return childMode;
    }

    public void setChildMode(GuiPageMode guiPageMode) {
        this.childMode = guiPageMode;
    }

    public GuiPageMode getParentMode() {
        return parentMode;
    }

    public void setParentMode(GuiPageMode guiPageMode1) {
        this.parentMode = guiPageMode1;
    }
    
    @Override
    public final boolean equals(Object other) {
        if (other instanceof GuiPageModeLink){
         GuiPageModeLink normalModel = (GuiPageModeLink)other;
            if (childId != null && parentId != null && normalModel.getChildId() != null && normalModel.getParentId() != null) {
                return childId.equals(normalModel.getChildId()) && parentId.equals(normalModel.getParentId());
            }
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if(childId == null || parentId == null)
            return super.hashCode();
        else    
        return childId.toString().concat(parentId.toString()).hashCode();
    }
}
