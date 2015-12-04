package com.technobrain.trips.common.helpers.search;

import java.io.Serializable;

import java.util.Comparator;

public class ColumnOrderComparator implements Comparator, Serializable {
    public int compare(Object o1, Object o2) {

        if (((SearchResultFieldInfo)o1).getColumnOrderNbr() < ((SearchResultFieldInfo)o2).getColumnOrderNbr()) {
            return -1;
        }

        if (((SearchResultFieldInfo)o1).getColumnOrderNbr() > ((SearchResultFieldInfo)o2).getColumnOrderNbr()) {
            return 1;
        }

        if (((SearchResultFieldInfo)o1).getColumnOrderNbr() == ((SearchResultFieldInfo)o2).getColumnOrderNbr()) {
            return 0;
        }

        throw new IllegalAccessError("Eroor");
    }
}
