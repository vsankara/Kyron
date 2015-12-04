package com.technobrain.trips.core.validation;

import com.technobrain.trips.common.constants.Constants;

public abstract class BusinessLogicValidator {
    protected BusinessLogicValidator() {
    
    }
    public static BusinessLogicValidator getInstance(String type) {
        
        if(type.equals(Constants.BusinessLogicValidatorType.ENTITY_VALIDATOR)) {
            BusinessLogicValidator val = new EntityBusLogicValidator();
            return val;
        }
        
        return null;
    }
   
}
