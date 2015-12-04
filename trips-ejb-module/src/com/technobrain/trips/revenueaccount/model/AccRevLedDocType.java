package com.technobrain.trips.revenueaccount.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.revenueaccount.model.AccRevLedAccount;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries (
    {
    @NamedQuery(name = "AccRevLedDocType.findAll", query = "select o from AccRevLedDocType o"),
    @NamedQuery(name = "AccRevLedDocType.findByAcc", query = "select docType from AccRevLedDocType docType where docType.accRevLedAccount.id=?1")
    }
) 
@Table(name = "ACC_REV_LED_DOC_TYPE")
public class AccRevLedDocType extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_REV_LED_DOC_TYPE_SEQ")
    @SequenceGenerator(name = "ACC_REV_LED_DOC_TYPE_SEQ", sequenceName = "ACC_REV_LED_DOC_TYPE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="DOCUMENT_TYPE")
    private String documentType;

    @ManyToOne
    @JoinColumn(name = "REV_LED_ACCOUNT_ID", referencedColumnName = "ID")
    private AccRevLedAccount accRevLedAccount;

    public AccRevLedDocType() {
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccRevLedAccount getAccRevLedAccount() {
        return accRevLedAccount;
    }

    public void setAccRevLedAccount(AccRevLedAccount accRevLedAccount) {
        this.accRevLedAccount = accRevLedAccount;
    }
}
