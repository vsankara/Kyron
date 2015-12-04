package com.technobrain.trips.dto.core;

import com.technobrain.trips.dto.DataTransferObject;
import com.technobrain.trips.dto.RefDataTransferObject;

import java.util.ArrayList;
import java.util.List;

public class FormAppWrapper  implements DataTransferObject {

    private String code;
    
    private String description;
    
    private List<RefDataTransferObject> requiredAttachments = new ArrayList<RefDataTransferObject>();

    public FormAppWrapper() {
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setRequiredAttachments(List<RefDataTransferObject> requiredAttachments) {
        this.requiredAttachments = requiredAttachments;
    }

    public List<RefDataTransferObject> getRequiredAttachments() {
        return requiredAttachments;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
