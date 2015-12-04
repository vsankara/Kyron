package com.technobrain.trips.reports.param;

import java.util.Date;


public class ReportDirectoryItem {
    public static final String DIRECTORYITEM_FOLDER="Folder";
    public static final String DIRECTORYITEM_REPORT="Report";


    private java.lang.String absolutePath;

    private Date creationDate;

    private java.lang.String displayName;

    private java.lang.String fileName;

    private Date lastModified;

    private java.lang.String lastModifier;

    private java.lang.String owner;

    private java.lang.String parentAbsolutePath;

    private java.lang.String type;
    
    private Long reportDetailsId;
    
    
    public boolean isFolder() {
        if(ReportDirectoryItem.DIRECTORYITEM_FOLDER.equals(this.getType())){
            return true;
        }
        
        return false;
    }
    
    
    public boolean isReport() {
        if(ReportDirectoryItem.DIRECTORYITEM_REPORT.equals(this.getType())){
            return true;
        }
        
        return false;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier;
    }

    public String getLastModifier() {
        return lastModifier;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setParentAbsolutePath(String parentAbsolutePath) {
        this.parentAbsolutePath = parentAbsolutePath;
    }

    public String getParentAbsolutePath() {
        return parentAbsolutePath;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setReportDetailsId(Long reportDetailsId) {
        this.reportDetailsId = reportDetailsId;
    }

    public Long getReportDetailsId() {
        return reportDetailsId;
    }
}
