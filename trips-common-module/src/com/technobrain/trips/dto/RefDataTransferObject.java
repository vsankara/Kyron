package com.technobrain.trips.dto;

import com.technobrain.trips.dto.DataTransferObject;

/**
 * DTO for reference data
 * 
 * @author i_yildiz
 */
public class RefDataTransferObject implements DataTransferObject {

    private String code;
    
    private String description;
    
    public RefDataTransferObject() {
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    /**
     * Override equals for checking right equality
     * 
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        RefDataTransferObject refDataTransferObject = (RefDataTransferObject)obj;
        if(code.equals(refDataTransferObject.getCode())){
            return true;
        } else return false;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode(){
    	return super.hashCode();
    	// hashcode depends to the code  !!!
    }
}
