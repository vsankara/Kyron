package com.technobrain.trips.common.model;

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
/**
 * Model class representing the table COMM_ATTACHMENT. 
 * 
 *@author
 *@version
 *@since   
 *@see 
 * 
 */
@Entity
@NamedQuery(name = "CommAttachment.findAll", query = "select o from CommAttachment o")
@Table(name = "COMM_ATTACHMENT")
@SequenceGenerator(name = "COMM_ATTACHMENT_SEQ", sequenceName = "COMM_ATTACHMENT_SEQ", initialValue = 1, allocationSize = 1)
public class CommAttachment extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMM_ATTACHMENT_SEQ")
    @Column(nullable = false)
    private Long id;
    @Column(name="ATTACHMENT_DATE")
    private Timestamp attachmentDate;
    @Column(name="ATTACHMENT_PATH")
    private String attachmentPath;
    @Column(name="ATTACHMENT_TYPE", nullable = false)
    private String attachmentType;
    @Column(name="FILE_STORE_ID")
    private Long fileStoreId;
    private String notes;
    private String reference;

    public CommAttachment() {
    }

    public Timestamp getAttachmentDate() {
        return attachmentDate;
    }

    public void setAttachmentDate(Timestamp attachmentDate) {
        this.attachmentDate = attachmentDate;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public Long getFileStoreId() {
        return fileStoreId;
    }

    public void setFileStoreId(Long fileStoreId) {
        this.fileStoreId = fileStoreId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public boolean isHTML() {
        return false;
    }

    public boolean isPDF() {
        return false;
    }

}
