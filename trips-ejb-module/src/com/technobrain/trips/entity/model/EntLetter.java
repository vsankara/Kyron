package com.technobrain.trips.entity.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EntLetter.findAll", query = "select o from EntLetter o")
@Table(name = "ENT_LETTER")
public class EntLetter extends BaseNormalModelObject   {
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    @Column(name="ADDRESS_EFFECTIVE_DATE")
    private Timestamp addressEffectiveDate;
    @Column(name="ADDRESS_EXPIRATION_DATE")
    private Timestamp addressExpirationDate;
    @Column(name="CERTIFICATE_NO")
    private Long certificateNo;
    private String city;
    private char[] content;
    private String country;
    private String county;
     
     
     
     
    @Column(name="DDOC_DOCU_ID", nullable = false)
    private Long ddocDocuId;
    @Column(name="ENT_ENTITY_ID", nullable = false)
    private Long entEntityId;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_letter_seq")
    @SequenceGenerator(name = "ent_letter_seq", sequenceName = "ent_letter_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="LAST_REPRINT_DATE")
    private Timestamp lastReprintDate;
    @Column(name="LETTER_DATE", nullable = false)
    private Timestamp letterDate;
    @Column(name="LETTER_SEQ_NO", nullable = false)
    private Long letterSeqNo;
    @Column(name="LETTER_TYPE", nullable = false)
    private String letterType;
    private String name;
    @Column(name="OFFICER_ID", nullable = false)
    private Long officerId;
    @Column(name="POSTAL_CODE")
    private String postalCode;
    @Column(nullable = false)
    private String printed;
    @Column(name="PRINT_DATE")
    private Timestamp printDate;
    @Column(name="PRINT_MACHINE")
    private String printMachine;
    private String province;
    @Column(nullable = false)
    private String reprinted;
    @Column(name="REPRINT_COUNT", nullable = false)
    private Long reprintCount;
    @Column(name="REV_LED_TRAN_ID")
    private Long revLedTranId;
    @Column(name="REV_TYPE")
    private String revType;
    private String state;
     
     
     
     
     
     

    public EntLetter() {
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public Timestamp getAddressEffectiveDate() {
        return addressEffectiveDate;
    }

    public void setAddressEffectiveDate(Timestamp addressEffectiveDate) {
        this.addressEffectiveDate = addressEffectiveDate;
    }

    public Timestamp getAddressExpirationDate() {
        return addressExpirationDate;
    }

    public void setAddressExpirationDate(Timestamp addressExpirationDate) {
        this.addressExpirationDate = addressExpirationDate;
    }

    public Long getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(Long certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public char[] getContent() {
        return content;
    }

    public void setContent(char[] content) {
        this.content = content;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Long getDdocDocuId() {
        return ddocDocuId;
    }

    public void setDdocDocuId(Long ddocDocuId) {
        this.ddocDocuId = ddocDocuId;
    }

    public Long getEntEntityId() {
        return entEntityId;
    }

    public void setEntEntityId(Long entEntityId) {
        this.entEntityId = entEntityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getLastReprintDate() {
        return lastReprintDate;
    }

    public void setLastReprintDate(Timestamp lastReprintDate) {
        this.lastReprintDate = lastReprintDate;
    }

    public Timestamp getLetterDate() {
        return letterDate;
    }

    public void setLetterDate(Timestamp letterDate) {
        this.letterDate = letterDate;
    }

    public Long getLetterSeqNo() {
        return letterSeqNo;
    }

    public void setLetterSeqNo(Long letterSeqNo) {
        this.letterSeqNo = letterSeqNo;
    }

    public String getLetterType() {
        return letterType;
    }

    public void setLetterType(String letterType) {
        this.letterType = letterType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOfficerId() {
        return officerId;
    }

    public void setOfficerId(Long officerId) {
        this.officerId = officerId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPrinted() {
        return printed;
    }

    public void setPrinted(String printed) {
        this.printed = printed;
    }

    public Timestamp getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Timestamp printDate) {
        this.printDate = printDate;
    }

    public String getPrintMachine() {
        return printMachine;
    }

    public void setPrintMachine(String printMachine) {
        this.printMachine = printMachine;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getReprinted() {
        return reprinted;
    }

    public void setReprinted(String reprinted) {
        this.reprinted = reprinted;
    }

    public Long getReprintCount() {
        return reprintCount;
    }

    public void setReprintCount(Long reprintCount) {
        this.reprintCount = reprintCount;
    }

    public Long getRevLedTranId() {
        return revLedTranId;
    }

    public void setRevLedTranId(Long revLedTranId) {
        this.revLedTranId = revLedTranId;
    }

    public String getRevType() {
        return revType;
    }

    public void setRevType(String revType) {
        this.revType = revType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
