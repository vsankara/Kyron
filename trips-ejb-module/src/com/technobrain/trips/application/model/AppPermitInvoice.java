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
@NamedQuery(name = "AppPermitInvoice.findAll", 
    query = "select o from AppPermitInvoice o")
@Table(name = "APP_PERMIT_INVOICE")
public class AppPermitInvoice extends BaseNormalModelObject {
 
    @Column(name="END_SERIAL_NO")
    private String endSerialNo;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_PERMIT_INVOICE_SEQ")
    @SequenceGenerator(name = "APP_PERMIT_INVOICE_SEQ", sequenceName = "APP_PERMIT_INVOICE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="INV_DESCRIPTION")
    private String invDescription;
    @Column(name="LOOSE_INV_FLAG")
    private String looseInvFlag;
    @Column(name="NO_OF_BOOKLETS")
    private Long noOfBooklets;
    @Column(name="NO_OF_BOXES")
    private Long noOfBoxes;
    @Column(name="NO_OF_COPIES")
    private Long noOfCopies;
    @Column(name="NO_OF_SETS")
    private Long noOfSets;
    @Column(name="RELEASE_DATE")
    private Timestamp releaseDate;
    @Column(name="START_SERIAL_NO")
    private String startSerialNo;
    @Column(name="VAT_INV_FLAG")
    private String vatInvFlag;
    
    @ManyToOne
    @JoinColumn(name = "APP_PERMIT_APP_ID", referencedColumnName = "ID")
    private AppPermitToUse appPermitToUse;
    
    public AppPermitInvoice() {
    }

    public String getEndSerialNo() {
        return endSerialNo;
    }

    public void setEndSerialNo(String endSerialNo) {
        this.endSerialNo = endSerialNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvDescription() {
        return invDescription;
    }

    public void setInvDescription(String invDescription) {
        this.invDescription = invDescription;
    }

    public String getLooseInvFlag() {
        return looseInvFlag;
    }

    public void setLooseInvFlag(String looseInvFlag) {
        this.looseInvFlag = looseInvFlag;
    }

    public Long getNoOfBooklets() {
        return noOfBooklets;
    }

    public void setNoOfBooklets(Long noOfBooklets) {
        this.noOfBooklets = noOfBooklets;
    }

    public Long getNoOfBoxes() {
        return noOfBoxes;
    }

    public void setNoOfBoxes(Long noOfBoxes) {
        this.noOfBoxes = noOfBoxes;
    }

    public Long getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(Long noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    public Long getNoOfSets() {
        return noOfSets;
    }

    public void setNoOfSets(Long noOfSets) {
        this.noOfSets = noOfSets;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStartSerialNo() {
        return startSerialNo;
    }

    public void setStartSerialNo(String startSerialNo) {
        this.startSerialNo = startSerialNo;
    }


    public String getVatInvFlag() {
        return vatInvFlag;
    }

    public void setVatInvFlag(String vatInvFlag) {
        this.vatInvFlag = vatInvFlag;
    }

    public void setAppPermitToUse(AppPermitToUse appPermitToUse) {
        this.appPermitToUse = appPermitToUse;
    }

    public AppPermitToUse getAppPermitToUse() {
        return appPermitToUse;
    }
}
