package com.technobrain.trips.application.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppPermitBkAcct.findAll", 
    query = "select o from AppPermitBkAcct o")
@Table(name = "APP_PERMIT_BK_ACCT")
public class AppPermitBkAcct extends BaseNormalModelObject {
   
    @Column(name="BOOK_OF_ACCT")
    private String bookOfAcct;
    private String computerized;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_PERMIT_BK_SEQ")
    @SequenceGenerator(name = "APP_PERMIT_BK_SEQ", sequenceName = "APP_PERMIT_BK_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="LOOSE_LEAF")
    private String looseLeaf;
    @Column(name="MANUAL_FLAG")
    private String manualFlag;
    @Column(name="NO_OF_PAGES")
    private Long noOfPages;
    private Long quantity;
    @Column(name="VOLUME_FROM")
    private Long volumeFrom;
    @Column(name="VOLUME_TO")
    private Long volumeTo;
    @Column(name="WITH_EINVOICE")
    private String withEinvoice;

    @ManyToOne
    @JoinColumn(name = "APP_PERMIT_APP_ID", referencedColumnName = "ID")
    private AppPermitToUse appPermitToUse;
    
    
    public AppPermitBkAcct() {
    }

    public String getBookOfAcct() {
        return bookOfAcct;
    }

    public void setBookOfAcct(String bookOfAcct) {
        this.bookOfAcct = bookOfAcct;
    }

    public String getComputerized() {
        return computerized;
    }

    public void setComputerized(String computerized) {
        this.computerized = computerized;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLooseLeaf() {
        return looseLeaf;
    }

    public void setLooseLeaf(String looseLeaf) {
        this.looseLeaf = looseLeaf;
    }

    public String getManualFlag() {
        return manualFlag;
    }

    public void setManualFlag(String manualFlag) {
        this.manualFlag = manualFlag;
    }

    public Long getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(Long noOfPages) {
        this.noOfPages = noOfPages;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }


    public Long getVolumeFrom() {
        return volumeFrom;
    }

    public void setVolumeFrom(Long volumeFrom) {
        this.volumeFrom = volumeFrom;
    }

    public Long getVolumeTo() {
        return volumeTo;
    }

    public void setVolumeTo(Long volumeTo) {
        this.volumeTo = volumeTo;
    }

    public String getWithEinvoice() {
        return withEinvoice;
    }

    public void setWithEinvoice(String withEinvoice) {
        this.withEinvoice = withEinvoice;
    }

    public void setAppPermitToUse(AppPermitToUse appPermitToUse) {
        this.appPermitToUse = appPermitToUse;
    }

    public AppPermitToUse getAppPermitToUse() {
        return appPermitToUse;
    }
}
