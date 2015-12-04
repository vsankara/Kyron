package com.technobrain.trips.dto.core;

import com.technobrain.trips.dto.DataTransferObject;

import java.util.Calendar;


public class ComAttachment implements DataTransferObject {
    private Calendar attachmentDate;
    private String attachmentPath;
    private String attachmentType;
    private Long fileStoreId;
    private Long id;
    private String notes;
    private String reference;
    private byte[] fileContents;
    private String fileName;
    private String fileType;
    private String referenceNumber;
    private String referenceType;
    public ComAttachment() {
    }

    public void setAttachmentDate(Calendar attachmentDate) {
        this.attachmentDate = attachmentDate;
    }

    public Calendar getAttachmentDate() {
        return attachmentDate;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setFileStoreId(Long fileStoreId) {
        this.fileStoreId = fileStoreId;
    }

    public Long getFileStoreId() {
        return fileStoreId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public void setFileContents(byte[] fileContents) {
        this.fileContents = fileContents;
    }

    public byte[] getFileContents() {
        return fileContents;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public String getReferenceType() {
        return referenceType;
    }
}
