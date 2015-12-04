package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;


import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@NamedQueries({
    @NamedQuery(name = "RefOffice.findAll", query = "select o from RefOffice o"),
    @NamedQuery(
    name="RefOffice.findOfficeByCode",
    query="select o from RefOffice o where o.code = ?1"
    )
})
@Table(name = "REF_OFFICE")
public class RefOffice extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @ManyToOne
    @JoinColumn(name = "COUNTRY", referencedColumnName = "CODE")
    private RefCountry refCountry;
    @OneToMany(mappedBy = "refOffice")
    private List<RefReportPrint> refReportPrintList;
    
//    @ManyToMany
//    @JoinTable(name="REF_OFF_PRINTERS",
//        joinColumns={@JoinColumn(name = "REF_OFFICE",
//                referencedColumnName = "CODE")},
//        inverseJoinColumns = {@JoinColumn(name = "REF_PRINTER",
//                referencedColumnName = "CODE")}
//    )
//    private List<RefPrinter> printers = new ArrayList<RefPrinter>();
    // CUSTOMS OR TAX
    @Column(name="OFFICE_TYPE")
    private String officeType;
    
    @OneToMany(cascade={CascadeType.ALL},mappedBy = "refOffice")
    private List<RefOffStaff> officerUsers = new ArrayList<RefOffStaff>();
    
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="REF_OFF_WORKST",
        joinColumns={@JoinColumn(name = "REF_OFFICE",
                referencedColumnName = "CODE")},
        inverseJoinColumns = {@JoinColumn(name = "REF_WORKSTATION",
                referencedColumnName = "CODE")}
    )
    private List<RefWorkstation> officeWorkStations = new ArrayList<RefWorkstation>();
    
    @OneToMany(cascade={CascadeType.ALL},mappedBy = "refOffice")
    private List<RefOffCoverage> officeCoverage;
    
    
    @OneToMany(cascade={CascadeType.ALL},mappedBy = "refOffice")
    private List<OfficeSubordinates> subordinateOffices;
    
    @OneToMany(cascade={CascadeType.ALL},mappedBy = "refOffice") 
    private List<RefOffPrinters> refOffPrinters = new ArrayList<RefOffPrinters>();
    
    @Column(name="SUBNET")
    private String subnet;
    @Column(name="CHECK_ENT_LOC")
    private String checkEntityLocation;
    @Column(name="ENABLE_NET_LINK")
    private String enableNetworkLink;
    
    @OneToOne
    @JoinColumn(name = "DEFAULT_PRINTER_CODE", referencedColumnName = "CODE")
    private RefPrinter defaultPrinter;
    
    public RefOffice() {
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
    
    public RefCountry getRefCountry() {
        return refCountry;
    }

    public void setRefCountry(RefCountry refCountry) {
        this.refCountry = refCountry;
    }
    
    public List<RefReportPrint> getRefReportPrintList() {
        return refReportPrintList;
    }

    public void setRefReportPrintList(List<RefReportPrint> refReportPrintList) {
        this.refReportPrintList = refReportPrintList;
    }

    public RefReportPrint addRefReportPrint(RefReportPrint refReportPrint) {
        getRefReportPrintList().add(refReportPrint);
        refReportPrint.setRefOffice(this);
        return refReportPrint;
    }

    public RefReportPrint removeRefReportPrint(RefReportPrint refReportPrint) {
        getRefReportPrintList().remove(refReportPrint);
        refReportPrint.setRefOffice(null);
        return refReportPrint;
    }
    
    
//    public List<RefPrinter> getPrinters() {
//        return printers;
//    }
//
//    public void setPrinters(List<RefPrinter> printers) {
//        this.printers = printers;
//    }
    
    public void addOfficeStaff(RefOffStaff staff){
        staff.setRefOffice(this);
        this.officerUsers.add(staff);
    }
    
    public void removeOfficeStaff(RefOffStaff staff){
        staff.setRefOffice(null);
         this.officerUsers.remove(staff);
    }
    
//    public RefPrinter addPrinter(RefPrinter printer) {
//        getPrinters().add(printer);
//        //printer.setOffice(this);
//        return printer;
//    }
//
//    public RefPrinter removePrinter(RefPrinter printer) {
//        getPrinters().remove(printer);
//        //printer.setOffice(null);
//        return printer;
//    }

    public void setOfficeType(String officeType) {
        this.officeType = officeType;
    }

    public String getOfficeType() {
        return officeType;
    }

    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    public String getSubnet() {
        return subnet;
    }

    public void setOfficerUsers(List<RefOffStaff> officerUsers) {
        this.officerUsers = officerUsers;
    }

    public List<RefOffStaff> getOfficerUsers() {
        return officerUsers;
    }

    public void setOfficeWorkStations(List<RefWorkstation> officeWorkStations) {
        this.officeWorkStations = officeWorkStations;
    }

    public List<RefWorkstation> getOfficeWorkStations() {
        return officeWorkStations;
    }

    public void setCheckEntityLocation(String checkEntityLocation) {
        this.checkEntityLocation = checkEntityLocation;
    }

    public String getCheckEntityLocation() {
        return checkEntityLocation;
    }

    public void setEnableNetworkLink(String enableNetworkLink) {
        this.enableNetworkLink = enableNetworkLink;
    }

    public String getEnableNetworkLink() {
        return enableNetworkLink;
    }

    public void setOfficeCoverage(List<RefOffCoverage> officeCoverage) {
        this.officeCoverage = officeCoverage;
    }

    public List<RefOffCoverage> getOfficeCoverage() {
        return officeCoverage;
    }

    public void addCoverage(RefOffCoverage refOffCoverage) {
        if(null ==  this.officeCoverage){
            this.officeCoverage = new ArrayList<RefOffCoverage>();
        }
        this.officeCoverage.add(refOffCoverage);
        refOffCoverage.setRefOffice(this);
    }
    
    public void removeCoverage(RefOffCoverage refOffCoverage) {
        refOffCoverage.setRefOffice(null);
        this.officeCoverage.remove(refOffCoverage);
    }
    
    public void addSubordinateOffice(OfficeSubordinates subordinateOffice) {
        if(null ==  this.subordinateOffices){
            this.subordinateOffices = new ArrayList<OfficeSubordinates>();
        }
        this.subordinateOffices.add(subordinateOffice);
        subordinateOffice.setRefOffice(this);
    }
    
    public void removeSubordinateOffice(OfficeSubordinates subordinateOffice) {
        subordinateOffice.setRefOffice(null);
        this.subordinateOffices.remove(subordinateOffice);
    }

    public void setSubordinateOffices(List<OfficeSubordinates> subordinateOffices) {
        this.subordinateOffices = subordinateOffices;
    }

    public List<OfficeSubordinates> getSubordinateOffices() {
        return subordinateOffices;
    }



	public RefPrinter getDefaultPrinter() {
		return defaultPrinter;
	}



	public void setDefaultPrinter(RefPrinter defaultPrinter) {
		this.defaultPrinter = defaultPrinter;
	}


    public void setRefOffPrinters(List<RefOffPrinters> refOffPrinters) {
        this.refOffPrinters = refOffPrinters;
    }

    public List<RefOffPrinters> getRefOffPrinters() {
        return refOffPrinters;
    }
    
    public RefOffPrinters addRefOffPrinter(RefOffPrinters printer) {
        getRefOffPrinters().add(printer);
        //printer.setOffice(this);
        return printer;
    }

    public RefOffPrinters removePrinter(RefOffPrinters printer) {
        getRefOffPrinters().remove(printer);
        //printer.setRefOffice(null);
        return printer;
    }
}
