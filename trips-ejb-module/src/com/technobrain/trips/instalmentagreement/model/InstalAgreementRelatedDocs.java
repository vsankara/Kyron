package com.technobrain.trips.instalmentagreement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

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


@Entity
@NamedQuery(name = "InstalAgreementRelatedDocs.findAll", 
    query = "select o from InstalAgreementRelatedDocs o")
@Table(name = "INST_AGREEMENT_REL_DOCS")
public class InstalAgreementRelatedDocs extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "INST_AGREEMENT_REL_DOCS_SEQ")
    @SequenceGenerator(name = "INST_AGREEMENT_REL_DOCS_SEQ", 
                       sequenceName = "INST_AGREEMENT_REL_DOCS_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    @Column(name="DOCUMENT_ID")
    private Long documentId;
    
    @Column(name="DOCUMENT_BALANCE")
    private BigDecimal documentBalance;
    
    @Column(name="PERIOD_DISPLAY")
    private String periodDisplay;
    
    @ManyToOne
    @JoinColumn(name = "AGREEMENT_ID", referencedColumnName = "ID")
    private DfinInstalmentAgreement instalmentAgreement;

    public InstalAgreementRelatedDocs() {
    }


    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getDocumentId() {
        return documentId;
    }
    
    public void setDocumentBalance(BigDecimal documentBalance) {
        this.documentBalance = documentBalance;
    }
    
    public BigDecimal getDocumentBalance() {
        return documentBalance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
     public DfinInstalmentAgreement getInstalmentAgreement() {
         return instalmentAgreement;
     }

     public void setInstalmentAgreement(DfinInstalmentAgreement instalmentAgreement) {
         this.instalmentAgreement = instalmentAgreement;
     }

    public void setPeriodDisplay(String periodDisplay) {
        this.periodDisplay = periodDisplay;
    }

    public String getPeriodDisplay() {
        return periodDisplay;
    }
}
