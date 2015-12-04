package com.technobrain.trips.common.helpers.search;

import java.io.Serializable;

import java.util.Comparator;


public class DisplayOrderComparator implements Comparator, Serializable {
    public int compare(Object o1, Object o2) {
        if (((SearchCriteriaFieldInfo)o1).getDisplayOrder() < ((SearchCriteriaFieldInfo)o2).getDisplayOrder()) {
            return -1;
        }

        if (((SearchCriteriaFieldInfo)o1).getDisplayOrder() > ((SearchCriteriaFieldInfo)o2).getDisplayOrder()) {
            return 1;
        }

        if (((SearchCriteriaFieldInfo)o1).getDisplayOrder() == ((SearchCriteriaFieldInfo)o2).getDisplayOrder()) {
            return 0;
        }

        throw new IllegalAccessError("Eroor");
    }
}
