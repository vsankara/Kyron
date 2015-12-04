package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.core.annotation.ReferenceNumber;
import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.workflow.model.WfFormWorkflow;

import java.sql.Timestamp;

import java.util.ArrayList;
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


@Entity    
@NamedQueries({
    @NamedQuery(name = "FlexibleForm.findAll", 
    query = "select o from FlexibleForm o"),
    
    @NamedQuery(
    name="FlexibleForm.findRelatedFlexibleForm",
    query="select o from FlexibleForm o where o.formType = ?1 and o.validFrom <= ?2 and o.validTo >= ?2 and o.status='A'"
    ),

    @NamedQuery(
    name="FlexibleForm.findFlexibleFormByTypeNameAndDate",
    query="select o from FlexibleForm o where o.formType.formType = ?1 and o.validFrom <= ?2 and o.validTo >= ?2 and o.status='A'"
    ),
    
    @NamedQuery(
    name="FlexibleForm.findFlexibleFormByName",
    query="select o from FlexibleForm o where o.formName = ?1"
    ),

    @NamedQuery(
    name="FlexibleForm.findAllFlexibleFormsForType",
    query="select o from FlexibleForm o where o.formType.formType = ?1  and o.status='A'"
    ),  
    @NamedQuery(
    name="FlexibleForm.findFlexibleFormByDocType",
    query="select o from FlexibleForm o where o.documentType = ?1  and o.status='A' order by o.validFrom asc, o.validTo asc"
    )
    
})    
@Table(name = "FLEXIBLE_FORM")
public class FlexibleForm extends BaseNormalModelObject   {
    @Column(name="FORM_NAME")
    private String formName;
    @ManyToOne
    @JoinColumn(name = "FORM_TYPE_ID", referencedColumnName = "ID")
    private FlexibleFormType formType;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "FLEXIBLE_FORM_SEQ")
    @SequenceGenerator(name = "FLEXIBLE_FORM_SEQ", sequenceName = "FLEXIBLE_FORM_SEQ", 
                       allocationSize = 1)    
    @Column(nullable = false)
    private Long id;
    
    @ReferenceNumber(format="FLX/SQL", sql="SELECT LTRIM(TO_CHAR(MOD(FLEXIBLE_FORM_SEQ_REF_NO_SEQ.nextval,100000),'000099'))||'/'||to_char(sysdate,'YYYY') as generatedId FROM dual")
    @Column(name="REFERENCE_NUMBER")
    private String referenceNumber;
    
    @Column(name="PAGE_HEADER")
    private String pageHeader;
    @Column(name="PAGE_TITLE")
    private String pageTitle;
    @Column(name="VALID_FROM")
    private Timestamp validFrom;
    @Column(name="VALID_TO")
    private Timestamp validTo;

    @Column(name="BASE_TABLE")
    private String baseTable;

    @Column(name="DOCUMENT_TYPE")
    private String documentType;
    
    @OneToMany(mappedBy = "flexibleForm",cascade={CascadeType.ALL})
    private List<FlexibleFormField> fields;

    @OneToMany(mappedBy = "form", cascade={CascadeType.ALL})
    private List<FlexibleAttribute> attributes;
    
    @OneToOne(cascade={CascadeType.ALL}, mappedBy="flexibleForm")
    private WfFormWorkflow wfFormWorkflow;
    
    @Column(name="CONFIGURATION_SET")
    private String configurationSet;
    
    @Column(name="DISPLAY_TYPE")
    private String displayType;
    
    @Column(name="FORM_DISPLAY_NAME")
    private String formDisplayName;

    public FlexibleForm() {
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPageHeader() {
        return pageHeader;
    }

    public void setPageHeader(String pageHeader) {
        this.pageHeader = pageHeader;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public Timestamp getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Timestamp validFrom) {
        this.validFrom = validFrom;
    }

    public Timestamp getValidTo() {
        return validTo;
    }

    public void setValidTo(Timestamp validTo) {
        this.validTo = validTo;
    }

    public void setFields(List<FlexibleFormField> fields) {
        this.fields = fields;
    }

    public List<FlexibleFormField> getFields() {
        return fields;
    }

//    public List<FlexibleFormField> getSortedFields() {
//        Collections.sort(fields, new FieldOrderComparator());
//        return fields;
//    }

    public FlexibleFormField addFlexibleFormField(FlexibleFormField flexibleFormField) {
        getFields().add(flexibleFormField);
        flexibleFormField.setFlexibleForm(this, false);
        return flexibleFormField;
    }

    public FlexibleFormField removeFlexibleFormField(FlexibleFormField flexibleFormField) {
        getFields().remove(flexibleFormField);
        flexibleFormField.setFlexibleForm(null);
        return flexibleFormField;
    }

    public FlexibleAttribute addAttribute(FlexibleAttribute flexibleAttributes) {
        getAttributes().add(flexibleAttributes);
        flexibleAttributes.setForm(this, false);
        return flexibleAttributes;
    }

    public FlexibleAttribute removeAttribute(FlexibleAttribute flexibleAttributes) {
        getAttributes().remove(flexibleAttributes);
        flexibleAttributes.setForm(null);
        return flexibleAttributes;
    }


    public void setAttributes(List<FlexibleAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<FlexibleAttribute> getAttributes() {
        if(attributes == null) {
            attributes = new ArrayList<FlexibleAttribute>();
        }
        return attributes;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setFormType(FlexibleFormType formType) {
        this.formType = formType;
    }

    public FlexibleFormType getFormType() {
        return formType;
    }

    public void setBaseTable(String baseTable) {
        this.baseTable = baseTable;
    }

    public String getBaseTable() {
        return baseTable;
    }
    
    public FlexibleFormField getField(String name) {
        for(FlexibleFormField field:this.getFields()) {
            if(field.getFieldName().equals(name)) {
                return field;
            }
        }
        return null;
    }

    public void setWfFormWorkflow(WfFormWorkflow wfFormWorkflow) {
        this.wfFormWorkflow = wfFormWorkflow;
    }

    public WfFormWorkflow getWfFormWorkflow() {
        return wfFormWorkflow;
    }

    public void setConfigurationSet(String configurationSet) {
        this.configurationSet = configurationSet;
    }

    public String getConfigurationSet() {
        return configurationSet;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setFormDisplayName(String formDisplayName) {
        this.formDisplayName = formDisplayName;
    }

    public String getFormDisplayName() {
        return formDisplayName;
    }
}
