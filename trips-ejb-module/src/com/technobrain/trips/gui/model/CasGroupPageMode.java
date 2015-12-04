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
@NamedQuery(name = "CasGroupPageMode.findAll", 
    query = "select o from CasGroupPageMode o")
@Table(name = "CAS_GROUP_PAGE_MODE")
@IdClass(CasGroupPageModePK.class)
public class CasGroupPageMode extends BaseCompositeModelObject   {
    @Id
    @Column(name="GROUP_CODE", nullable = false)
    private String groupCode;
    @Id
    @Column(name="PAGE_MODE_ID", nullable = false, insertable = false, 
        updatable = false)
    private Long pageModeId;
     
    @ManyToOne
    @JoinColumn(name = "PAGE_MODE_ID", referencedColumnName = "ID")
    private GuiPageMode guiPageMode;


    public CasGroupPageMode() {
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public Long getPageModeId() {
        return pageModeId;
    }

    public void setPageModeId(Long pageModeId) {
        this.pageModeId = pageModeId;
    }

    public GuiPageMode getGuiPageMode() {
        return guiPageMode;
    }

    public void setGuiPageMode(GuiPageMode guiPageMode) {
        this.guiPageMode = guiPageMode;
    }
    
    @Override
    public final boolean equals(Object other) {
        if (other == this)
            return true;
        if ((other == null) || !(other instanceof BaseCompositeModelObject))
            return false;
        
        if(other instanceof CasGroupPageMode){
            final CasGroupPageMode normalModel = (CasGroupPageMode)other;
    
            if (groupCode != null && pageModeId != null && normalModel.getGroupCode() != null && normalModel.getPageModeId() != null) {
                return groupCode.equals(normalModel.getGroupCode()) && pageModeId.equals(normalModel.getPageModeId());
            }
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if (groupCode == null)
            return super.hashCode();
        else
            return groupCode.hashCode();
    }
//
//    public CasGroup getCasGroup() {
//        return casGroup;
//    }
//
//    public void setCasGroup(CasGroup casGroup) {
//        this.casGroup = casGroup;
//    }
}
