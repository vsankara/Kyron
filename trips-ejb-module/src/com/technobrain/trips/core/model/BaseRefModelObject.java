package com.technobrain.trips.core.model;

public abstract class BaseRefModelObject extends BaseModelObject {
    public BaseRefModelObject() {
    }
    
    private Long orderSeq;
        
    public abstract void setCode(String code);

    public abstract String getCode();
    
    @Override
    public final boolean equals(Object other) {
        if(other instanceof BaseRefModelObject){
            final BaseRefModelObject refModel = (BaseRefModelObject)other;
    
            if (getCode() != null && refModel.getCode() != null) {
                return getCode().equals(refModel.getCode());
            }
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if(this.getCode() != null) {
            return this.getCode().hashCode();
        } 
        else   
            return super.hashCode();
    }

    public void setOrderSeq(Long orderSequence) {
        this.orderSeq = orderSequence;
    }

    public Long getOrderSeq() {
        return orderSeq;
    }
}
