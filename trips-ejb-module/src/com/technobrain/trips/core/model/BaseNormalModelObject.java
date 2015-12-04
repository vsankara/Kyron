package com.technobrain.trips.core.model;

public abstract class BaseNormalModelObject extends BaseModelObject {

    public BaseNormalModelObject() {
    }

    public abstract void setId(Long id);

    public abstract Long getId();
    
    @Override
    public final boolean equals(Object other) {
    
        if(other == null){
            return false;
        }
        
        if (other instanceof BaseNormalModelObject){
            BaseNormalModelObject normalModel = (BaseNormalModelObject)other;
            if (getId() != null && normalModel.getId() != null) {
                return getId().equals(normalModel.getId());
            }else{
                //For the ones do not have id s look reference equality
                //Otherwise can not remove the newly added records
                return  this == other;
                //return this.hashCode() == other.hashCode();
            }
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if(this.getId() != null) {
            return this.getId().intValue();
        } 
        else   
            return super.hashCode();
    }
}
