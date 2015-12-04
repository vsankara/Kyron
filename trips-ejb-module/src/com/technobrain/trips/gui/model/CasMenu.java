package com.technobrain.trips.gui.model;

import com.technobrain.trips.core.model.BaseCompositeModelObject;
import com.technobrain.trips.dto.DataTransferObject;

import com.technobrain.trips.dto.menu.MenuPermissionDTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "CasMenu.findAll", query = "select o from CasMenu o order by o.description")
@Table(name = "CAS_MENU")
public class CasMenu extends BaseCompositeModelObject   {
    @Column(name="DESCRIPTION",nullable = false)
    private String description;
    @Id
    @Column(name="ID",nullable = false)
    private String id;
    @Column(name="PARENT")
    private String parent;
    @Column(name="SEC_ROLE", nullable = false)
    private String secRole;

    public CasMenu() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getSecRole() {
        return secRole;
    }

    public void setSecRole(String secRole) {
        this.secRole = secRole;
    }
    
    public MenuPermissionDTO getData(){
        MenuPermissionDTO permissionDTO = new MenuPermissionDTO();
        
        permissionDTO.setMenuID(this.getId());
        permissionDTO.setSecurityRole(this.getSecRole());
        permissionDTO.setParent(this.getParent());
        
        return permissionDTO;
    }
    
    @Override
    public final boolean equals(Object other) {
        if (other == this)
            return true;
        if ((other == null) || !(other instanceof BaseCompositeModelObject))
            return false;

        final CasMenu normalModel = (CasMenu)other;

        if (id != null  && normalModel.getId() != null) {
            return id.equals(normalModel.getId());
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if(id == null)
            return super.hashCode();
        else    
        return id.toString().hashCode();
    }
}
