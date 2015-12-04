package com.technobrain.trips.instalmentagreement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@NamedQueries( {
    @NamedQuery(name = "InstalmentTransaction.findAll", 
        query = "select o from InstalmentTransaction o"),
        @NamedQuery(name = "InstalmentTransaction.findAllAgreementsByAccTransaction",
        query = "select o from InstalmentTransaction o where o.transactionId=?1"),
        @NamedQuery(name = "InstalmentTransaction.findAllAgreementsByInstalId",
        query = "select o from InstalmentTransaction o where o.instalmentId=?1")
        
   }
)
@Table(name = "INSTALMENT_TRANSACTION")

public class InstalmentTransaction extends BaseNormalModelObject{
    public InstalmentTransaction() {
    }
    
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSTALMENT_TRANSACTION_SEQ")
    @SequenceGenerator(name = "INSTALMENT_TRANSACTION_SEQ", sequenceName = "INSTALMENT_TRANSACTION_SEQ", allocationSize = 1)        
    private Long id;
    
    @Column(name="DOCUMENT_ID", nullable = false)
    private Long documentId;

    @Column(name="TRANSACTION_ID", nullable = false)
    private Long transactionId;

    @Column(name = "INSTALMENT_ID", nullable = false)
    private Long instalmentId;
    
    @ManyToOne
    @JoinColumn(name = "INSTALMENT_ID", referencedColumnName = "ID", insertable=false,updatable=false)
    private AgreementInstalments agreementInstalment;

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setInstalmentId(Long instalmentId) {
        this.instalmentId = instalmentId;
    }

    public Long getInstalmentId() {
        return instalmentId;
    }

    public void setAgreementInstalment(AgreementInstalments agreementInstalment) {
        this.agreementInstalment = agreementInstalment;
    }

    public AgreementInstalments getAgreementInstalment() {
        return agreementInstalment;
    }
}
