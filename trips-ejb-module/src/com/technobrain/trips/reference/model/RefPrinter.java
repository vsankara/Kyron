package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * TechnoBrain 2015
 *
 * This class is used as a reference table for all printers
 *
 * @since	$Date: 5/26/2009 10:02:15 AM$
 * @version 	$Revision: 4$
 * @author 	$Author: Howard Hill$
 *
 * $Log[1]:
 *  4    TRIPS2    1.3         5/26/2009 10:02:15 AM  Howard Hill     added
 *       office security
 * $
 */
@Entity
@NamedQuery(name = "RefPrinter.findAll", query = "select o from RefPrinter o")
@Table(name = "REF_PRINTER")
public class RefPrinter extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    @OneToMany(mappedBy = "refPrinter")
    private List<RefReportPrint> refReportPrintList;
    
    //TODO : Printer should have office
    //private RefOffice office;
     @OneToMany(cascade={CascadeType.ALL},mappedBy = "refPrinter") 
     private List<RefOffPrinters> refOffPrinters;
     
    // This is a calculated field, not persisted at DB
    @Transient
    private Integer failedJobCount;
    @Transient
    private boolean defaultPrinter;

    public RefPrinter() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public List<RefReportPrint> getRefReportPrintList() {
        return refReportPrintList;
    }

    public void setRefReportPrintList(List<RefReportPrint> refReportPrintList) {
        this.refReportPrintList = refReportPrintList;
    }

    public RefReportPrint addRefReportPrint(RefReportPrint refReportPrint) {
        getRefReportPrintList().add(refReportPrint);
        refReportPrint.setRefPrinter(this);
        return refReportPrint;
    }

    public RefReportPrint removeRefReportPrint(RefReportPrint refReportPrint) {
        getRefReportPrintList().remove(refReportPrint);
        refReportPrint.setRefPrinter(null);
        return refReportPrint;
    }

	public Integer getFailedJobCount() {
		return failedJobCount;
	}

	public void setFailedJobCount(Integer failedJobCount) {
		this.failedJobCount = failedJobCount;
	}

	public boolean isDefaultPrinter() {
		return defaultPrinter;
	}

	public void setDefaultPrinter(boolean defaultPrinter) {
		this.defaultPrinter = defaultPrinter;
	}


    public void setRefOffPrinters(List<RefOffPrinters> refOffPrinters) {
        this.refOffPrinters = refOffPrinters;
    }

    public List<RefOffPrinters> getRefOffPrinters() {
        return refOffPrinters;
    }
}
