package com.technobrain.trips.gui.model;

import java.io.Serializable;

public class CasGroupPageModePK implements Serializable {
    public String groupCode;
    public Long pageModeId;

    public CasGroupPageModePK() {
    }

    public CasGroupPageModePK(String groupCode, Long pageModeId) {
        this.groupCode = groupCode;
        this.pageModeId = pageModeId;
    }

    public boolean equals(Object other) {
        if (other instanceof CasGroupPageModePK) {
            final CasGroupPageModePK otherCasGroupPageModePK = (CasGroupPageModePK) other;
            final boolean areEqual = 
                (otherCasGroupPageModePK.groupCode.equals(groupCode) && otherCasGroupPageModePK.pageModeId.equals(pageModeId));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
