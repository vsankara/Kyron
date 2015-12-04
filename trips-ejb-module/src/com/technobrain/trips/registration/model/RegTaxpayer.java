package com.technobrain.trips.registration.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity

@NamedQueries (
    {
        @NamedQuery(name = "RegTaxpayer.findAll", 
            query = "select o from RegTaxpayer o"),
        @NamedQuery(name = "RegTaxpayer.findEntityIdByTin",
            query = "SELECT o.entId                   " +
            "        FROM RegTaxpayer o   " +
            "        WHERE o.tin = ?1         ")            
    }
)

@Table(name = "REG_TAXPAYER")
@DiscriminatorValue(value="TAXPAYER")
@Inheritance
public class RegTaxpayer extends RegTaxpayerEntity {

    @Column(name="TIN", nullable = false)
    private String tin;
    @Column(name="RGDNO")
    private String rgdNo;
    @Column(name="PREVIOUS_TIN")
    private String previousTin;
    @Column(name="IRS_FILE_NUMBER")
    private String irsFileNumber;
    
    
    
//    @Column(name="REF_OFFICE")
//    private String refOffice;
    
    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

//    public void setRefOffice(String refOffice) {
//        this.refOffice = refOffice;
//    }
//
//    public String getRefOffice() {
//        return refOffice;
//    }

    public void setRgdNo(String rgdNo) {
        this.rgdNo = rgdNo;
    }

    public String getRgdNo() {
        return rgdNo;
    }

    public void setPreviousTin(String previousTin) {
        this.previousTin = previousTin;
    }

    public String getPreviousTin() {
        return previousTin;
    }

    public void setIrsFileNumber(String irsFileNumber) {
        this.irsFileNumber = irsFileNumber;
    }

    public String getIrsFileNumber() {
        return irsFileNumber;
    }
}
