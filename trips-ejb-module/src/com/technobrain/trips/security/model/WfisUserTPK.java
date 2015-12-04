package com.technobrain.trips.security.model;

import java.io.Serializable;

public class WfisUserTPK implements Serializable {
    public String name;
    public String realm;

    public WfisUserTPK() {
    }

    public WfisUserTPK(String name, String realm) {
        this.name = name;
        this.realm = realm;
    }

    public boolean equals(Object other) {
        if (other instanceof WfisUserTPK) {
            final WfisUserTPK otherWfisUserTPK = (WfisUserTPK) other;
            final boolean areEqual = (otherWfisUserTPK.name.equals(name) && otherWfisUserTPK.realm.equals(realm));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
