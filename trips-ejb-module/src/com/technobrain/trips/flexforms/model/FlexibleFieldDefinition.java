package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefFlexAttributeName;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "FlexibleFieldDefinition.findAll", 
    query = "select o from FlexibleFieldDefinition o")
@Table(name = "FLEXIBLE_FIELD_DEFINITION")
public class FlexibleFieldDefinition extends BaseNormalModelObject   {
    private String code;
    private String description;
    @Column(name="FIELD_TYPE")
    private String fieldType;
    @Id
    @Column(nullable = false)
    private Long id;
    @Column(name="LIST_REFERENCE")
    private String listReference;
    @Column(name="ITEM_GROUP_SORT_MODE")
    private String itemGroupSortMode;

    @Column(name="IS_CONTAINER")
    private String container;

    @Column(name="IS_VALUEHOLDER")
    private String valueHolder;
    
    @Column(name="SPECIAL_PURPOSE")
    private String specialPurpose;
    
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="FLEX_FIELD_DEF_ATTR_REL",
        joinColumns={@JoinColumn(name = "FIELD_DEF_ID",
                referencedColumnName = "ID")},
        inverseJoinColumns = {@JoinColumn(name = "ATTRIBUTE_NAME_CODE",
                referencedColumnName = "CODE")}
    )
    private List<RefFlexAttributeName> attributes;
    
    @OneToMany(mappedBy = "fieldDefinition", cascade={CascadeType.REFRESH})
    private List<FlexibleFormField> flexibleFormFieldsList;

    public FlexibleFieldDefinition() {
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

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListReference() {
        return listReference;
    }

    public void setListReference(String listReference) {
        this.listReference = listReference;
    }

    public void setItemGroupSortMode(String itemGroupSortMode) {
        this.itemGroupSortMode = itemGroupSortMode;
    }

    public String getItemGroupSortMode() {
        return itemGroupSortMode;
    }

    public void setAttributes(List<RefFlexAttributeName> attributes) {
        this.attributes = attributes;
    }

    public List<RefFlexAttributeName> getAttributes() {
        return attributes;
    }

    public void setFlexibleFormFieldsList(List<FlexibleFormField> flexibleFormFieldsList) {
        this.flexibleFormFieldsList = flexibleFormFieldsList;
    }

    public List<FlexibleFormField> getFlexibleFormFieldsList() {
        return flexibleFormFieldsList;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getContainer() {
        return container;
    }

    public void setValueHolder(String valueHolder) {
        this.valueHolder = valueHolder;
    }

    public String getValueHolder() {
        return valueHolder;
    }

    public void setSpecialPurpose(String specialPurpose) {
        this.specialPurpose = specialPurpose;
    }

    public String getSpecialPurpose() {
        return specialPurpose;
    }
}
