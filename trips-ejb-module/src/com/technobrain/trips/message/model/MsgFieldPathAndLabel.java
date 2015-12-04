package com.technobrain.trips.message.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "MsgFieldPathAndLabel.findAll", 
    query = "select o from MsgFieldPathAndLabel o")
@Table(name = "MSG_FIELD_PATH_AND_LABEL")
public class MsgFieldPathAndLabel extends BaseNormalModelObject{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "MSG_FIELD_PATH_AND_LABEL_SEQ")
    @SequenceGenerator(name = "MSG_FIELD_PATH_AND_LABEL_SEQ", sequenceName = "MSG_FIELD_PATH_AND_LABEL_SEQ", 
                       allocationSize = 1)   
    @Column(nullable = false)
    private Long id;
    
    @Column(name="FIELD_PATH")
    private String fieldPath;
    
    @Column(name="UIRESOURCE_KEY")
    private String uiresourceKey;
    
    @Column(name="DATA_REFERENCE")
    private String dataReference;
    
    @Column(name="COMPARISON_CATEGORY")
    private String comparisonCategory;
    

    public MsgFieldPathAndLabel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUiresourceKey() {
        return uiresourceKey;
    }

    public void setUiresourceKey(String uiresourceKey) {
        this.uiresourceKey = uiresourceKey;
    }

    public void setDataReference(String dataReference) {
        this.dataReference = dataReference;
    }

    public String getDataReference() {
        return dataReference;
    }

    public void setFieldPath(String fieldPath) {
        this.fieldPath = fieldPath;
    }

    public String getFieldPath() {
        return fieldPath;
    }

    public void setComparisonCategory(String comparisonCategory) {
        this.comparisonCategory = comparisonCategory;
    }

    public String getComparisonCategory() {
        return comparisonCategory;
    }
}
