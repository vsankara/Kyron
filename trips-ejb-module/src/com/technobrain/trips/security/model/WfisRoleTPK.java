package com.technobrain.trips.security.model;

import java.io.Serializable;

public class WfisRoleTPK implements Serializable {
    public String name;
    public String realm;

    public WfisRoleTPK() {
    }

    public WfisRoleTPK(String name, String realm) {
        this.name = name;
        this.realm = realm;
    }

    public boolean equals(Object other) {
        if (other instanceof WfisRoleTPK) {
            final WfisRoleTPK otherWfisRoleTPK = (WfisRoleTPK) other;
            final boolean areEqual = (otherWfisRoleTPK.name.equals(name) && otherWfisRoleTPK.realm.equals(realm));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
