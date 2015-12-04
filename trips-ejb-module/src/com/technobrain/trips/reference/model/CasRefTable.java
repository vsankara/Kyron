package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseCompositeModelObject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "CasRefTable.findAll", 
    query = "select o from CasRefTable o")
@Table(name = "CAS_REF_TABLE")
public class CasRefTable extends BaseCompositeModelObject  {
    @Column(nullable = false)
    private String description;
    @Id
    @Column(name="ENTITY_CLASS_NAME", nullable = false)
    private String entityClassName;
    @Column(name="REF_TYPE", nullable = false)
    private String refType;
    @Column(name="DISPLAY_SELECTION", nullable = false)
    private String displaySelection;
    @Column(name="DISPLAY_DELIMITER", nullable = false)
    private String displayDelimiter;
    
    @Column(name="ENABLE_TO_MANAGE")
    private String enableToManage;

    public CasRefTable() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntityClassName() {
        return entityClassName;
    }

    public void setEntityClassName(String entityClassName) {
        this.entityClassName = entityClassName;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }
    
    @Override
    public final boolean equals(Object object){
        if (object == this) return true;
        if ( (object == null) || !(object instanceof CasRefTable) ) return false;

        final CasRefTable rel = (CasRefTable) object;
             
        if (entityClassName != null && rel.getEntityClassName() != null){
            if(entityClassName.equals(rel.getEntityClassName()))
                return true;
            else 
                return false;
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if(entityClassName == null)
            return super.hashCode();
        else    
        return entityClassName.toString().hashCode();
    }

    public void setDisplaySelection(String displaySelection) {
        this.displaySelection = displaySelection;
    }

    public String getDisplaySelection() {
        return displaySelection;
    }

    public void setDisplayDelimiter(String displayDelimiter) {
        this.displayDelimiter = displayDelimiter;
    }

    public String getDisplayDelimiter() {
        return displayDelimiter;
    }

    public void setEnableToManage(String enableToManage) {
        this.enableToManage = enableToManage;
    }

    public String getEnableToManage() {
        return enableToManage;
    }
}
