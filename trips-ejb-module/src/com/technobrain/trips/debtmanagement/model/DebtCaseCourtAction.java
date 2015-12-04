package com.technobrain.trips.debtmanagement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Model class representing the table DEBT_CASE_COURT_ACTION. 
 * 
 *@author
 *@version
 *@since   
 *@see DebtCaseDetails
 * 
 */

@Entity
@NamedQuery(name = "CaseCourtAction.findAll", 
            query = "select o from DebtCaseCourtAction o")
@Table(name = "DEBT_CASE_COURT_ACTION")
public class DebtCaseCourtAction extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "DEBT_CASE_COURT_ACTION_SEQ")
    @SequenceGenerator(name = "DEBT_CASE_COURT_ACTION_SEQ", 
                       sequenceName = "DEBT_CASE_COURT_ACTION_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name = "ACTION_DATE")
    private Timestamp actionDate;
    @Column(name = "COURT_ACT_CODE")
    private String courtActionCode;
    @Column(name = "COURT_ACT_OUTCOME_NOTES")
    private String courtActionOutcomeNotes;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private DebtCaseDetails debtCaseDetails;

    public DebtCaseCourtAction() {
    }

    public Timestamp getActionDate() {
        return actionDate;
    }

    public void setActionDate(Timestamp actionDate) {
        this.actionDate = actionDate;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setDebtCaseDetails(DebtCaseDetails debtCaseDetails) {
        this.debtCaseDetails = debtCaseDetails;
    }

    public DebtCaseDetails getDebtCaseDetails() {
        return debtCaseDetails;
    }

    public void setCourtActionCode(String courtActionCode) {
        this.courtActionCode = courtActionCode;
    }

    public String getCourtActionCode() {
        return courtActionCode;
    }

    public void setCourtActionOutcomeNotes(String courtActionOutcomeNotes) {
        this.courtActionOutcomeNotes = courtActionOutcomeNotes;
    }

    public String getCourtActionOutcomeNotes() {
        return courtActionOutcomeNotes;
    }
}
