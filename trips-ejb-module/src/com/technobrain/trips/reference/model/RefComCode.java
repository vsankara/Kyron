package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefComCode.findAll", query = "select o from RefComCode o")
@Table(name = "REF_COM_CODE")
public class RefComCode extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
     
     
     
     
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="LONG_DESCRIPTION")
    private String longDescription;
     
     
     
     
     
// TODO: pja to complete after March 08 demos
//    @OneToMany(mappedBy = "commCode")
//    private List<ExCommodity> exCommodityList;
    @OneToMany(mappedBy = "refComCode")
    private List<RefComProcedure> refComProcedureList;
    @OneToMany(mappedBy = "refComCode")
    private List<RefComTreatment> refComTreatmentList;

    public RefComCode() {
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

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }


//    public void setExCommodityList(List<ExCommodity> exCommodityList) {
//        this.exCommodityList = exCommodityList;
//    }

//    public List<ExCommodity> getExCommodityList() {
//        return exCommodityList;
//    }
    
//    public ExCommodity addExCommodity(ExCommodity exCommodity){
//        getExCommodityList().add(exCommodity);
//        exCommodity.setCommCode(exCommodity.getCommCode());
//        return exCommodity;
//    }
    
//    public ExCommodity removeExCommodity(ExCommodity exCommodity){
//        getExCommodityList().remove(exCommodity);
//        exCommodity.setCommCode(null);
//        return exCommodity;
//    }

    public void setRefComProcedureList(List<RefComProcedure> refComProcedureList) {
        this.refComProcedureList = refComProcedureList;
    }

    public List<RefComProcedure> getRefComProcedureList() {
        return refComProcedureList;
    }
    
    public RefComProcedure addRefComProcedure(RefComProcedure refComProcedure){
        getRefComProcedureList().add(refComProcedure);
        refComProcedure.setRefComCode(this);
        return refComProcedure;
    }
    
    public RefComProcedure removeRefComProcedure(RefComProcedure refComProcedure){
        getRefComProcedureList().remove(refComProcedure);
        refComProcedure.setRefComCode(null);
        return refComProcedure;
    }

    public void setRefComTreatmentList(List<RefComTreatment> refComTreatmentList) {
        this.refComTreatmentList = refComTreatmentList;
    }

    public List<RefComTreatment> getRefComTreatmentList() {
        return refComTreatmentList;
    }
    
    public RefComTreatment addRefComTreatment(RefComTreatment refComTreatment){
        getRefComTreatmentList().add(refComTreatment);
        refComTreatment.setRefComCode(this);
        return refComTreatment;
    }
    
    public RefComTreatment removeRefComTreatment(RefComTreatment refComTreatment){
        getRefComTreatmentList().remove(refComTreatment);
        refComTreatment.setRefComCode(null);
        return refComTreatment;
    }
}
