package com.technobrain.trips.core.system;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = "SystemParameters.findAll", 
    query = "select o from SystemParameters o"),
        @NamedQuery(name = "SystemParameters.findSysParametersByCode", 
    query = "select o from SystemParameters o where o.code=?1")
    
    })
@Table(name = "SYS_PARAMETERS")
public class SystemParameters extends BaseRefModelObject {
    @Id
    private String code; 
    
    private String description;
     
    private String type;
     
    private String value;
    
    @Column(name="LAST_SAVED_VALUE")
    private String lastSavedValue;
    
    @Column(name="DEFAULT_VALUE")
    private String defaultValue;    

    public SystemParameters() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public void setLastSavedValue(String lastSavedValue) {
        this.lastSavedValue = lastSavedValue;
    }

    public String getLastSavedValue() {
        return lastSavedValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
