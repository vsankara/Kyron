package com.technobrain.trips.util;

public class ColumnDecorator {
    String inlineStyle;
    Object value;

    public void setInlineStyle(String style) {
        this.inlineStyle = style;
    }

    public String getInlineStyle() {
        return inlineStyle;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
