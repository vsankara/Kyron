package com.technobrain.trips.core;

import com.technobrain.trips.core.delegate.ReferenceCodeDelegate;
import com.technobrain.trips.core.message.InputType;

public abstract class RowWrapper  {
    protected InputType type;
    protected String temp;
    protected ReferenceCodeDelegate refDelegate;
    public RowWrapper() {
        refDelegate = new ReferenceCodeDelegate();
    }

    public RowWrapper(InputType type) {
        this();
        this.type = type;
        fillRelatedAttributes();
    }
    
    public RowWrapper(InputType type, Object param) {
        this();
        this.type = type;
        fillRelatedAttributes(param);
    }

    public abstract InputType getType();
    
    public void setType(InputType type) {
        this.type = type;
    }
    
    protected abstract void fillRelatedAttributes();
    
    public void setTypeAndFillAttrs(InputType type) {
        this.type = type;
        fillRelatedAttributes();
    }
    
    public void setTypeAndFillAttrs(InputType type, Object param) {
        this.type = type;
        fillRelatedAttributes(param);
    }
    
    protected void fillRelatedAttributes(Object param) {
        // Will be overriden if param will be used.
    }
    
    public String getTemp() {
        return temp;
    }
    
    public void setTemp(String temp) {
        this.temp =  temp;
    }
}
