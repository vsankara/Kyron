package com.technobrain.trips.dto.audit;

import com.technobrain.trips.dto.DataTransferObject;

public class EntityRiskIndicator  implements DataTransferObject{
    
    private String indicatorName;
    private String indicatorCode;
    private Long entityId;
    private Long value;
    
    public EntityRiskIndicator() {
    }

    public EntityRiskIndicator(String indicatorName, String indicatorCode, Long entityId, Long value){
        this.indicatorName = indicatorName;
        this.indicatorCode = indicatorCode;
        this.entityId = entityId;
        this.value = value;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorCode(String indicatorCode) {
        this.indicatorCode = indicatorCode;
    }

    public String getIndicatorCode() {
        return indicatorCode;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
