package com.technobrain.trips.workflow.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "FormPossibleActions.findAll", 
    query = "select o from FormPossibleActions o")
@Table(name = "FORM_POSSIBLE_ACTIONS")

public class FormPossibleActions extends BaseNormalModelObject {
    @Column(name="FORM_ACTION")
    private String formAction;
    @Column(name="ACTION_DESCRIPTION")
    private String actionDescription;
    @Column(name="WORKFLOW_NAME", nullable = false)
    private String workflowName;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FORM_POSSIBLE_ACTIONS_SEQ")
    @SequenceGenerator(name = "FORM_POSSIBLE_ACTIONS_SEQ", sequenceName = "FORM_POSSIBLE_ACTIONS_SEQ", allocationSize = 1)
    @Column(nullable = false)
    
    private Long id;
    @Column(name="FORM_MODE")
    private String formMode;

    public FormPossibleActions() {
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFormAction(String formAction) {
        this.formAction = formAction;
    }

    public String getFormAction() {
        return formAction;
    }

    public void setFormMode(String formMode) {
        this.formMode = formMode;
    }

    public String getFormMode() {
        return formMode;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public String getWorkflowName() {
        return workflowName;
    }
}
