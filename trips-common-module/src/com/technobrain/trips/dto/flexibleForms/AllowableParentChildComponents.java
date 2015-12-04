package com.technobrain.trips.dto.flexibleForms;

import com.technobrain.trips.dto.DataTransferObject;

/**
 * Crown Agents 2007
 * <br>
 * Generic class to represent allowable parent and child components for flexible forms.
 * 
 * @since $Date: 7/20/2009 3:50:33 AM$
 * @version $Revision: 1$
 * @author $Author: Linesh Mali$
 * 
 * $Log[1]:
 *  1    TRIPS2    1.0         7/20/2009 3:50:33 AM   Linesh Mali     
 * $
 */
public class AllowableParentChildComponents implements DataTransferObject {
    private Long id;
    private String parentType;
    private String childType;
    private String status;


    public AllowableParentChildComponents (String parentType, String childType){
        this.parentType = parentType;
        this.childType = childType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public String getParentType() {
        return parentType;
    }

    public void setChildType(String childType) {
        this.childType = childType;
    }

    public String getChildType() {
        return childType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
