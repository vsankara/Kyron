package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.common.helpers.StringHelper;
//import com.crownagents.trips.flexforms.helper.FieldOrderComparator;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@NamedQueries({
    @NamedQuery(name = "FlexibleFormField.findAll", 
    query = "select o from FlexibleFormField o"),
    
    @NamedQuery(
    name="FlexibleFormField.findFormFieldByNameInForm",
    query="select o from FlexibleFormField o where  o.fieldName = ?1 and o.flexibleForm.formName = ?2"),

    @NamedQuery(
    name="FlexibleFormField.findAllFormFieldByFormNameAndSpecialPurpose",
    query="select o from FlexibleFormField o where o.flexibleForm.formName = ?1 and o.specialPurpose = ?2")

})

@Table(name = "FLEXIBLE_FORM_FIELD")
public class FlexibleFormField extends BaseNormalModelObject   {
    private String description;
    @Column(name="FIELD_LABEL")
    private String fieldLabel;
    @Column(name="FIELD_NAME")
    private String fieldName;
    @Column(name="RETURN_TYPE")
    private String returnType;
    @Column(name="USAGE_TYPE")
    private String usageType;    
    @Column(name="DECIMAL_LENGTH")
    private Integer decimalLength;
    @Column(name="HAS_THOUSAND_OPERATOR")
    private String hasThousandOperator;
    @Column(name="GUI_ORDER")
    private Integer order;
    @Column(name="SPECIAL_PURPOSE")
    private String specialPurpose;
    
    @Column(name="EXTERNAL_REFERENCE_IND")
    private String isExternalReference;
    
    @Column(name="EXTERNAL_REFERENCE_LABEL")
    private String externalReferenceLabel;
    
    @Transient
    private List<FlexibleFormFieldSubTaxType> flexibleFormFieldSubTaxTypes;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "FLEXIBLE_FORM_FIELD_SEQ")
    @SequenceGenerator(name = "FLEXIBLE_FORM_FIELD_SEQ", sequenceName = "FLEXIBLE_FORM_FIELD_SEQ", 
                       allocationSize = 1)    
    @Column(nullable = false)
    private Long id;

    //TODO: Because of a bug which removes all the children unexpectedly after a move operation
    //CascadeType.ALL is not used (CascadeType.REMOVE is not used)
    //@OneToMany(mappedBy = "parentField", cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    @OneToMany(mappedBy = "parentField", cascade={CascadeType.ALL})
    private List<FlexibleFormField> childrenFields;
    
    @ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "PARENT_FIELD_ID", referencedColumnName = "ID")
    private FlexibleFormField parentField;

    @ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "FIELD_DEFINITION_ID", referencedColumnName = "ID", nullable=false,insertable=false, updatable=false)    
    private FlexibleFieldDefinition fieldDefinition;

    @Column(name = "FIELD_DEFINITION_ID")    
    private Long fieldDefinitionId;

    @ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "FORM_ID", referencedColumnName = "ID")
    private FlexibleForm flexibleForm;
    
    @Column(name="SCHEMA_ELEMENT")
    private String schemaElement;
    
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "FIELD_DB_MAP_ID", referencedColumnName = "ID")
    private FlexibleFieldDbMap databaseMap;
    
    @OneToMany(mappedBy = "formField", cascade={CascadeType.ALL})
    private List<FlexibleField> fields;
    
    @Column(name="LIST_REFERENCE")
    private String listReference;

    @OneToMany(mappedBy = "dependentParentField", cascade={CascadeType.ALL})
    private List<FlexibleFormField> dependentFields;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "DEPENDENT_PARENT_ID", referencedColumnName = "ID")
    private FlexibleFormField dependentParentField;    

    @Column(name="ADDITIONAL_SCHEMA_ELEMENT")
    private String additionalSchemaElement;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "ADDITIONAL_FIELD_DB_MAP_ID", referencedColumnName = "ID")
    private FlexibleFieldDbMap additionalDatabaseMap;
    
//    @Column(name="D_TYPE")
//    private String dType;

    public FlexibleFormField() {
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchemaElement() {
        return schemaElement;
    }

    public void setSchemaElement(String schemaElement) {
        this.schemaElement = schemaElement;
    }


    public String getDescription() {
        return description;
    }
    
    public void setParentField(FlexibleFormField parentField, boolean addToChildren) {
        this.parentField = parentField;
        if(addToChildren && parentField != null) {
            parentField.addChildField(this);
        }
    }

    public void setParentField(FlexibleFormField parentField) {
        setParentField(parentField, true);
    }

    public FlexibleFormField getParentField() {
        return parentField;
    }

    public void setChildrenFields(List<FlexibleFormField> childrenFields) {
        this.childrenFields = childrenFields;
    }

    public List<FlexibleFormField> getChildrenFields() {
        return childrenFields;
    }
    
//    public List<FlexibleFormField> getSortedChildrenFields() {
//        Collections.sort(childrenFields, new FieldOrderComparator());
//        return childrenFields;
//    }
    
    public FlexibleFormField addChildField(FlexibleFormField child) {
        getChildrenFields().add(child);
        child.setParentField(this, false);
        return child;
    }

    public FlexibleFormField removeChildField(FlexibleFormField child) {
        getChildrenFields().remove(child);
        child.setParentField(null);
        return child;
    }

    public void setFlexibleForm(FlexibleForm flexibleForm) {
        setFlexibleForm(flexibleForm, true);
    }
    
    public void setFlexibleForm(FlexibleForm flexibleForm, boolean addTo) {
        this.flexibleForm = flexibleForm;
        if(addTo && flexibleForm != null) {
            flexibleForm.addFlexibleFormField(this);
        }
    }

    public FlexibleForm getFlexibleForm() {
        return flexibleForm;
    }

    public void setFieldDefinition(FlexibleFieldDefinition fieldDefinition) {
        this.fieldDefinition = fieldDefinition;
    }

    public FlexibleFieldDefinition getFieldDefinition() {
        return fieldDefinition;
    }

    public void setDatabaseMap(FlexibleFieldDbMap databaseMap) {
        this.databaseMap = databaseMap;
    }

    public FlexibleFieldDbMap getDatabaseMap() {
        return databaseMap;
    }

    public void setListReference(String listReference) {
        this.listReference = listReference;
    }

    public String getListReference() {
        return listReference;
    }

    public void setFields(List<FlexibleField> fields) {
        this.fields = fields;
    }

    public List<FlexibleField> getFields() {
        return fields;
    }
    
    public FlexibleField addFlexibleField(FlexibleField flexibleField) {
        getFields().add(flexibleField);
        flexibleField.setFormField(this, false);
        return flexibleField;
    }

    public FlexibleField removeFlexibleField(FlexibleField flexibleField) {
        getFields().remove(flexibleField);
        flexibleField.setFormField(null);
        return flexibleField;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setDecimalLength(Integer decimalLength) {
        this.decimalLength = decimalLength;
    }

    public Integer getDecimalLength() {
        return decimalLength;
    }

    public void setHasThousandOperator(String hasThousandOperator) {
        this.hasThousandOperator = hasThousandOperator;
    }

    public String getHasThousandOperator() {
        return hasThousandOperator;
    }
    
    public boolean hasThousandOperator() {
        if(hasThousandOperator == null)
            return false;
        return StringHelper.getIndicatorAsBoolean(hasThousandOperator);
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getOrder() {
        return order;
    }

    public void setFieldDefinitionId(Long fieldDefinitionId) {
        this.fieldDefinitionId = fieldDefinitionId;
    }

    public Long getFieldDefinitionId() {
        return fieldDefinitionId;
    }

    public void setAdditionalSchemaElement(String additionalSchemaElement) {
        this.additionalSchemaElement = additionalSchemaElement;
    }

    public String getAdditionalSchemaElement() {
        return additionalSchemaElement;
    }

    public void setAdditionalDatabaseMap(FlexibleFieldDbMap additionalDatabaseMap) {
        this.additionalDatabaseMap = additionalDatabaseMap;
    }

    public FlexibleFieldDbMap getAdditionalDatabaseMap() {
        return additionalDatabaseMap;
    }




//    public void setDType(String dType) {
//        this.dType = dType;
//    }
//
//    public String getDType() {
//        return dType;
//    }

    public void setDependentFields(List<FlexibleFormField> dependentFields) {
        this.dependentFields = dependentFields;
    }

    public List<FlexibleFormField> getDependentFields() {
        return dependentFields;
    }

    public void setDependentParentField(FlexibleFormField dependentParentField) {
        this.dependentParentField = dependentParentField;
    }

    public FlexibleFormField getDependentParentField() {
        return dependentParentField;
    }


    public FlexibleFormField addDependentField(FlexibleFormField dependent) {
        getDependentFields().add(dependent);
        dependent.setDependentParentField(this);
        return dependent;
    }

    public FlexibleFormField removeDependentField(FlexibleFormField dependent) {
        getDependentFields().remove(dependent);
        dependent.setDependentParentField(null);
        return dependent;
    }
    
    public boolean containsModeField(String mode) {
        for(FlexibleField field:this.getFields()) {
            if(field.getModeSelected().equals(mode)) {
                return true;
            }
        }
        return false;
    }



    
    /**
     * This method returns the implementation of the form field object. If the mode parameter does not contain a field
     * implementation, then this mode should be an extended mode, and we will search for the implementation in the parent mode
     * @param mode
     * @return
     */
    public FlexibleField getImplementedFieldForMode(String mode, String actualMode){
//        String actualMode = this.getFlexibleForm().getFormType().getActualMode(mode);
        FlexibleField field = getFieldForMode(mode);
        if(field == null) {
            return getFieldForMode(actualMode);
        }
        return field;
    }

    public FlexibleField getFieldForMode(String mode) {
        for(FlexibleField field:this.getFields()) {
            if(field.getModeSelected().equals(mode)) {
                return field;
            }
        }
        return null;
    }


    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setSpecialPurpose(String specialPurpose) {
        this.specialPurpose = specialPurpose;
    }

    public String getSpecialPurpose() {
        return specialPurpose;
    }


    public void setFlexibleFormFieldSubTaxTypes(List<FlexibleFormFieldSubTaxType> flexibleFormFieldSubTaxTypes) {
        this.flexibleFormFieldSubTaxTypes = flexibleFormFieldSubTaxTypes;
    }

    public List<FlexibleFormFieldSubTaxType> getFlexibleFormFieldSubTaxTypes() {
        return flexibleFormFieldSubTaxTypes;
    }

    public void setIsExternalReference(String isExternalReference) {
        this.isExternalReference = isExternalReference;
    }

    public String getIsExternalReference() {
        return isExternalReference;
    }

    public void setExternalReferenceLabel(String externalReferenceLabel) {
        this.externalReferenceLabel = externalReferenceLabel;
    }

    public String getExternalReferenceLabel() {
        return externalReferenceLabel;
    }
}
