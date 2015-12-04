package com.technobrain.trips.dto.menu;

import com.technobrain.trips.dto.DataTransferObject;

/**
 * Holds the menu permissions for the system.
 * <br>
 * A menu permission is a component id, description and JAAS security role
 */
public class MenuPermissionDTO implements DataTransferObject {
    private String menuID;
    private String securityRole;
    private String parent;
    
    public MenuPermissionDTO() {
    }
    
    public MenuPermissionDTO(String menuID) {
        this.menuID = menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getMenuID() {
        return menuID;
    }

    public void setSecurityRole(String securityRole) {
        this.securityRole = securityRole;
    }

    public String getSecurityRole() {
        return securityRole;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getParent() {
        return parent;
    }
}
