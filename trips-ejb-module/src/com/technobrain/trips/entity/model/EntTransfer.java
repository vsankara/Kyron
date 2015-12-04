package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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
@NamedQuery(name = "EntTransfer.findAll", 
    query = "select o from EntTransfer o")
@Table(name = "ENT_TRANSFER")
@SequenceGenerator(name = "ent_transfer_seq", sequenceName = "ent_transfer_seq", initialValue = 1, allocationSize = 1)
public class EntTransfer extends BaseNormalModelObject {
    @Column(name="ENT_ENTITY", nullable = false)
    private Long entEntity;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_transfer_seq")
    @Column(nullable = false)
    private Long id;
    @Column(name="NEW_OFFICE")
    private String newOffice;
    private String notes;
    @Column(name="OLD_OFFICE")
    private String oldOffice;
    private String reason;
    @Column(name="OLD_OFFICE_ACCESS_EXPIRY")
    private Timestamp oldOfficeAccessExpiry;
    @Column(name="TCF_REFERENCE")
    private String tcfReference;
    public EntTransfer() {
    }

    public Long getEntEntity() {
        return entEntity;
    }

    public void setEntEntity(Long entEntity) {
        this.entEntity = entEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewOffice() {
        return newOffice;
    }

    public void setNewOffice(String newOffice) {
        this.newOffice = newOffice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getOldOffice() {
        return oldOffice;
    }

    public void setOldOffice(String oldOffice) {
        this.oldOffice = oldOffice;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setOldOfficeAccessExpiry(Timestamp oldOfficeAccessExpiry) {
        this.oldOfficeAccessExpiry = oldOfficeAccessExpiry;
    }

    public Timestamp getOldOfficeAccessExpiry() {
        return oldOfficeAccessExpiry;
    }

    public void setTcfReference(String tcfReference) {
        this.tcfReference = tcfReference;
    }

    public String getTcfReference() {
        return tcfReference;
    }
}
