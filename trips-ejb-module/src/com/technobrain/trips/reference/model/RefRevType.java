package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefRevType.findAll", query = "select o from RefRevType o order by o.code")
@Table(name = "REF_REV_TYPE")
public class RefRevType extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="TAXPAYER_TYPE")
    private String taxpayerType;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @OneToMany(mappedBy = "refRevType")
    private List<RefCfgRegime> refCfgRegimeList;
    @ManyToOne
    @JoinColumn(name = "REF_REV_MODE", referencedColumnName = "CODE")    
    private RefRevMode refRevMode; 
    @OneToMany(mappedBy = "revType")
    private List<RefReport> refReportList;
    @OneToMany(mappedBy = "refRevType")
    private List<RefRevSubType> refRevSubTypeList;
    @OneToMany(mappedBy = "refRevType")
    private List<RefLegalTaxTypeRel> refLegalTaxTypeRelList;
    
    @Column(name="PERIOD_TYPE")
    private String periodType;
    @Column(name="IMPLICIT_REGIME")
    private String implicitRegime;
        
    @ManyToOne
    @JoinColumn(name = "REF_STAGGER", referencedColumnName = "CODE")    
    private RefStagger refStagger; 
    @ManyToOne
    @JoinColumn(name = "REF_SUB_STAGGER", referencedColumnName = "CODE")    
    private RefStaggerSub refStaggerSub; 
    
    @Column(name = "FISCAL_INDICATOR")
    private String fiscalIndicator;
    
    @Column(name= "NO_RETURN_INDICATOR")
    private String noReturnIndicator;

    public RefRevType() {
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

    public List<RefCfgRegime> getRefCfgRegimeList() {
        return refCfgRegimeList;
    }

    public void setRefCfgRegimeList(List<RefCfgRegime> refCfgRegimeList) {
        this.refCfgRegimeList = refCfgRegimeList;
    }

    public RefCfgRegime addRefCfgRegime(RefCfgRegime refCfgRegime) {
        getRefCfgRegimeList().add(refCfgRegime);
        refCfgRegime.setRefRevType(this);
        return refCfgRegime;
    }

    public RefCfgRegime removeRefCfgRegime(RefCfgRegime refCfgRegime) {
        getRefCfgRegimeList().remove(refCfgRegime);
        refCfgRegime.setRefRevType(null);
        return refCfgRegime;
    }
    
    public void setRefRevMode(RefRevMode refRevMode) {
        this.refRevMode = refRevMode;
    }

    public RefRevMode getRefRevMode() {
        return refRevMode;
    }

    public void setRefReportList(List<RefReport> refReportList) {
        this.refReportList = refReportList;
    }

    public List<RefReport> getRefReportList() {
        return refReportList;
    }
    
    public RefReport addRefReport(RefReport refReport) {
        getRefReportList().add(refReport);
        refReport.setRevType(this);
        return refReport;
    }

    public RefReport removeRefReport(RefReport refReport) {
        getRefReportList().remove(refReport);
        refReport.setRevType(null);
        return refReport;
    }

    public void setRefRevSubTypeList(List<RefRevSubType> refRevSubTypeList) {
        this.refRevSubTypeList = refRevSubTypeList;
    }

    public List<RefRevSubType> getRefRevSubTypeList() {
        return refRevSubTypeList;
    }
    
    public RefRevSubType addRefRevSubType(RefRevSubType refRevSubType) {
        getRefRevSubTypeList().add(refRevSubType);
        refRevSubType.setRefRevType(this);
        return refRevSubType;
    }

    public RefRevSubType removeRefRevSubType(RefRevSubType refRevSubType) {
        getRefRevSubTypeList().remove(refRevSubType);
        refRevSubType.setRefRevType(null);
        return refRevSubType;
    }

    public void setRefLegalTaxTypeRelList(List<RefLegalTaxTypeRel> refLegalTaxTypeRelList) {
        this.refLegalTaxTypeRelList = refLegalTaxTypeRelList;
    }

    public List<RefLegalTaxTypeRel> getRefLegalTaxTypeRelList() {
        return refLegalTaxTypeRelList;
    }
    
    public RefLegalTaxTypeRel addRefLegalTaxTypeRel(RefLegalTaxTypeRel refLegalTaxTypeRel) {
        getRefLegalTaxTypeRelList().add(refLegalTaxTypeRel);
        refLegalTaxTypeRel.setRefRevType(this);
        return refLegalTaxTypeRel;
    }

    public RefLegalTaxTypeRel removeRefLegalTaxTypeRel(RefLegalTaxTypeRel refLegalTaxTypeRel) {
        getRefLegalTaxTypeRelList().remove(refLegalTaxTypeRel);
        return refLegalTaxTypeRel;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getTaxpayerType() {
        return taxpayerType;
    }

    public void setRefStagger(RefStagger refStagger) {
        this.refStagger = refStagger;
    }

    public RefStagger getRefStagger() {
        return refStagger;
    }

    public void setRefStaggerSub(RefStaggerSub refStaggerSub) {
        this.refStaggerSub = refStaggerSub;
    }

    public RefStaggerSub getRefStaggerSub() {
        return refStaggerSub;
    }
    
    public void setImplicitRegime(String implicitRegime) {
        this.implicitRegime = implicitRegime;
    }

    public String getImplicitRegime() {
        return implicitRegime;
    }

    public void setFiscalIndicator(String fiscalIndicator) {
        this.fiscalIndicator = fiscalIndicator;
    }

    public String getFiscalIndicator() {
        return fiscalIndicator;
    }

    public void setNoReturnIndicator(String noReturnIndicator) {
        this.noReturnIndicator = noReturnIndicator;
    }

    public String getNoReturnIndicator() {
        return noReturnIndicator;
    }
}
