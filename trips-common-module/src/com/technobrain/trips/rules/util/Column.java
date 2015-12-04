package com.technobrain.trips.rules.util;

public class Column {
    String name;
    Object value;
    public Column() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
