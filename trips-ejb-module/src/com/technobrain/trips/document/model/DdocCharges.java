package com.technobrain.trips.document.model;

import com.technobrain.trips.account.model.Account;
import com.technobrain.trips.core.model.BaseNormalModelObject;

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
import java.util.Set;

@Entity
@NamedQueries ({ 
    @NamedQuery(name = "DdocCharges.findAll", 
        query = "select o from DdocCharges o"), 
    @NamedQuery(name = "DdocCharges.findByDocumentId", 
        query = "select o from DdocCharges o where o.documentId = ?1"),
    @NamedQuery(name = "DdocCharges.findLatestByDocumentId", 
    query = "select o from DdocCharges o where o.documentId = ?1 and o.eventId = ?2  and o.docChargeStatus = 'ACTIVE' order by o.id"),
    @NamedQuery(name = "DdocCharges.findLatestByEventId", 
    query = "select o from DdocCharges o where o.eventId = ?1  and o.docChargeStatus = 'ACTIVE' order by o.id"),
    @NamedQuery(name = "DdocCharges.findActiveByDocumentId", 
    query = "select ddci from DdocCharges ddci where ddci.documentId = ?1 and ddci.docChargeStatus='ACTIVE'")
})

@Table(name = "DDOC_CHARGES")
public class DdocCharges extends BaseNormalModelObject {
    @Column(nullable = false)
    private Double amount;
    @Column(name="DOCUMENT_ID", nullable = false)
    private Long documentId;
    @Column(name="EVENT_ID", nullable = false)
    private Long eventId;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ddoc_charges_seq")
    @SequenceGenerator(name = "ddoc_charges_seq", sequenceName = "ddoc_charges_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="TAX_TYPE")
    private String taxType;
    
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "ID", insertable=false,updatable=false)
    private DdocDocument dDocDocument;
    
    @Column(name="DEFFERED")
    private String deffered;
    
    @Column(name="CHARGE_STATUS")
    private String docChargeStatus = "ACTIVE";
    
    @Column(name="SUB_TAX_TYPE")
    private String subTaxType;
    
    @Column(name="SUB_TAX_TYPE1")
    private String subTaxType1;
    
    @Column(name="CHARGE_TYPE")
    private String chargeType;
    
    @Column(name="ENTITY_TYPE")
    private String entityType;
    
    @Column(name="INSTALMENT_ID")
    private Long instalmentId;
    
    @Column(name="PERIOD_ID")
    private Long periodId;
    
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public void setDeffered(String deffered) {
        this.deffered = deffered;
    }

    public String getDeffered() {
        return deffered;
    }

    public void setDocChargeStatus(String docChargeStatus) {
        this.docChargeStatus = docChargeStatus;
    }

    public String getDocChargeStatus() {
        return docChargeStatus;
    }

    public void setSubTaxType(String subTaxType) {
        this.subTaxType = subTaxType;
    }

    public String getSubTaxType() {
        return subTaxType;
    }

    public void setSubTaxType1(String subTaxType1) {
        this.subTaxType1 = subTaxType1;
    }

    public String getSubTaxType1() {
        return subTaxType1;
    }


    public void setDDocDocument(DdocDocument dDocDocument) {
        this.dDocDocument = dDocDocument;
    }

    public DdocDocument getDDocDocument() {
        return dDocDocument;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setInstalmentId(Long instalmentId) {
        this.instalmentId = instalmentId;
    }

    public Long getInstalmentId() {
        return instalmentId;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public Long getPeriodId() {
        return periodId;
    }
}
