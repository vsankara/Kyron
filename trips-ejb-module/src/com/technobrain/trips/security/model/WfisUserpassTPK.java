package com.technobrain.trips.security.model;

import java.io.Serializable;

public class WfisUserpassTPK implements Serializable {
    public String name;
    public String realm;

    public WfisUserpassTPK() {
    }

    public WfisUserpassTPK(String name, String realm) {
        this.name = name;
        this.realm = realm;
    }

    public boolean equals(Object other) {
        if (other instanceof WfisUserpassTPK) {
            final WfisUserpassTPK otherWfisUserpassTPK = (WfisUserpassTPK) other;
            final boolean areEqual = (otherWfisUserpassTPK.name.equals(name) && otherWfisUserpassTPK.realm.equals(realm));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
