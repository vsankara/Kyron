package com.technobrain.trips.common.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "FileStore.findAll", query = "select o from FileStore o")
@Table(name = "FILE_STORE")
@SequenceGenerator(name = "FILE_STORE_SEQ", sequenceName = "FILE_STORE_SEQ", initialValue =1, allocationSize = 1)

public class FileStore extends BaseNormalModelObject {
    @Column(name="FILE_CONTENTS")
    private byte[] fileContents;
    @Column(name="FILE_NAME")
    private String fileName;
    @Column(name="FILE_TYPE")
    private String fileType;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FILE_STORE_SEQ")    
    @Column(nullable = false)    
    private Long id; 

    public FileStore() {
    }

    public byte[] getFileContents() {
        return fileContents;
    }

    public void setFileContents(byte[] fileContents) {
        this.fileContents = fileContents;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
