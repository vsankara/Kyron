package com.technobrain.trips.gui.model;

import java.io.Serializable;

public class GuiPageModeLinkPK implements Serializable {
    public Long childId;
    public Long parentId;

    public GuiPageModeLinkPK() {
    }

    public GuiPageModeLinkPK(Long childId, Long parentId) {
        this.childId = childId;
        this.parentId = parentId;
    }

    public boolean equals(Object other) {
        if (other instanceof GuiPageModeLinkPK) {
            final GuiPageModeLinkPK otherGuiPageModeLinkPK = (GuiPageModeLinkPK) other;
            final boolean areEqual = 
                (otherGuiPageModeLinkPK.childId.equals(childId) && otherGuiPageModeLinkPK.parentId.equals(parentId));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
