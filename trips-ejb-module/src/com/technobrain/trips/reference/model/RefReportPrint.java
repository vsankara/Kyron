package com.technobrain.trips.reference.model;
/**
 * TechnoBrain 2015
 *
 * This class is used as a reference table for linking reports and printers.
 *
 * @since	$Date: 2/2/2009 5:28:57 AM$
 * @version 	$Revision: 2$
 * @author 	$Author: Howard Hill$
 * 
 * $Log[1]:
 *  2    TRIPS2    1.1         2/2/2009 5:28:57 AM    Howard Hill     change
 *       log10 to log1
 * $
 */
import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(
{
@NamedQuery(name = "RefReportPrint.findAll", 
    query = "select o from RefReportPrint o"),
@NamedQuery(name="RefReportPrint.findPrinterByReportName",
        query="select o from RefReportPrint o where o.reportName = ?1")    
}
)
@Table(name = "REF_REPORT_PRINT")
public class RefReportPrint implements Serializable {
    @Id
    @Column(nullable = false)
    private String code;
    @Column(name="CREATED_BY")
    private String createdBy;
    @Column(name="CREATED_DATE")
    private Timestamp createdDate;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="REPORT_NAME")
    private String reportName;
    private String status;
    @Column(name="UPDATED_BY")
    private String updatedBy;
    @Column(name="UPDATED_DATE")
    private Timestamp updatedDate;
    private Long version;
    @ManyToOne
    @JoinColumn(name = "OFFICE", referencedColumnName = "CODE")
    private RefOffice refOffice;
    @ManyToOne
    @JoinColumn(name = "PRINTER", referencedColumnName = "CODE")
    private RefPrinter refPrinter;

    public RefReportPrint() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public RefPrinter getRefPrinter() {
        return refPrinter;
    }

    public void setRefPrinter(RefPrinter refPrinter) {
        this.refPrinter = refPrinter;
    }

    public void setRefOffice(RefOffice refOffice) {
        this.refOffice = refOffice;
    }

    public RefOffice getRefOffice() {
        return refOffice;
    }
}
