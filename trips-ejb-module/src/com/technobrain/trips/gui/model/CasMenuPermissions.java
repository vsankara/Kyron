package com.technobrain.trips.gui.model;

import com.technobrain.trips.core.model.BaseCompositeModelObject;
import com.technobrain.trips.dto.menu.MenuPermissionDTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "CasMenuPermissions.findAll", 
    query = "select o from CasMenuPermissions o")
@Table(name = "CAS_MENU_PERMISSIONS")
public class CasMenuPermissions extends BaseCompositeModelObject   {
    @Column(name="CAS_GROUP_CODE", nullable = false)
    private String casGroupCode;
    @Id
    @Column(name="MENU_ID", nullable = false)
    private String menuId;

    public CasMenuPermissions() {
    }

    public String getCasGroupCode() {
        return casGroupCode;
    }

    public void setCasGroupCode(String casGroupCode) {
        this.casGroupCode = casGroupCode;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
    
    public MenuPermissionDTO getData(){
        MenuPermissionDTO dto = new MenuPermissionDTO();
        dto.setMenuID(this.getMenuId());
        return dto;
    }
    
    @Override
    public final boolean equals(Object other) {
        if (other == this)
            return true;
        if ((other == null) || !(other instanceof BaseCompositeModelObject))
            return false;

        final CasMenuPermissions normalModel = (CasMenuPermissions)other;

        if (menuId != null  && normalModel.getMenuId() != null) {
            return menuId.equals(normalModel.getMenuId());
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if(menuId == null)
            return super.hashCode();
        else    
        return menuId.toString().hashCode();
    }
}
