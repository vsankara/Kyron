package com.technobrain.trips.workflow.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.flexforms.model.FlexibleForm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "WfFormWorkflow.findAll", query = "select o from WfFormWorkflow o")
@Table(name = "WF_FORM_WORKFLOW")
public class WfFormWorkflow extends BaseNormalModelObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WF_FORM_WORKFLOW_SEQ")
    @SequenceGenerator(name = "WF_FORM_WORKFLOW_SEQ", sequenceName = "WF_FORM_WORKFLOW_SEQ", allocationSize = 1)
    @Column(nullable = false)  
    private Long id;
    
    @Column(name="WORKFLOW_NAME")
    private String workflowName;
    @Column(name="FORM_NAME")
    private String formName;
    
    @OneToOne
    @JoinColumn(name = "FORM_NAME", referencedColumnName = "FORM_NAME",insertable=false,updatable=false) 
    private FlexibleForm flexibleForm;



    public WfFormWorkflow() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setFlexibleForm(FlexibleForm flexibleForm) {
        this.flexibleForm = flexibleForm;
        flexibleForm.setWfFormWorkflow(this);
    }

    public FlexibleForm getFlexibleForm() {
        return flexibleForm;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormName() {
        return formName;
    }
}
