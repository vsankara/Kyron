package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;
//import com.crownagents.trips.reporting.model.ReportDeliveryConfig;
//import com.crownagents.trips.reporting.model.ReportPathInfo;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefDocType.findAll", query = "select o from RefDocType o")
@Table(name = "REF_DOC_TYPE")
public class RefDocType extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;     
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate; 
    @Column(name="CORRES_CODE")
    private String reportCorresCode;
    @Column(name="LIABILITY_INDICATOR")
    private String liabilityIndicator;
    
    @ManyToOne
    @JoinColumn(name = "DOC_CATEGORY", referencedColumnName = "CODE") 
    private RefDocCategory refDocCategory;
    
//    @ManyToOne
//    @JoinColumn(name = "REPORT_CODE", referencedColumnName = "CODE")
//    private ReportPathInfo reportPathInfo;
//    
//    @OneToMany(mappedBy = "documentType", cascade={CascadeType.ALL})
//    private List<ReportDeliveryConfig> deliveryConfigurations;

    public RefDocType() {
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

    public void setRefDocCategory(RefDocCategory refDocCategory) {
        this.refDocCategory = refDocCategory;
    }

    public RefDocCategory getRefDocCategory() {
        return refDocCategory;
    }
    

//    public void setDeliveryConfigurations(List<ReportDeliveryConfig> deliveryConfigurations) {
//        this.deliveryConfigurations = deliveryConfigurations;
//    }
//
//    public List<ReportDeliveryConfig> getDeliveryConfigurations() {
//        return deliveryConfigurations;
//    }
//    
//    public ReportDeliveryConfig addReportDeliveryConfig(ReportDeliveryConfig reportDeliveryConfig) {
//        getDeliveryConfigurations().add(reportDeliveryConfig);
//        reportDeliveryConfig.setDocumentType(this);
//        return reportDeliveryConfig;
//    }
//
//    public ReportDeliveryConfig removeReportDeliveryConfig(ReportDeliveryConfig reportDeliveryConfig) {
//        getDeliveryConfigurations().remove(reportDeliveryConfig);
//        reportDeliveryConfig.setDocumentType(null);
//        return reportDeliveryConfig;
//    }
//
//
//        public void setReportPathInfo(ReportPathInfo reportPathInfo) {
//            this.reportPathInfo = reportPathInfo;
//        }
//
//        public ReportPathInfo getReportPathInfo() {
//            return reportPathInfo;
//        }

    public String getReportCorresCode() {
        return reportCorresCode;
    }

    public void setReportCorresCode(String reportCorresCode) {
        this.reportCorresCode = reportCorresCode;
    }

    public void setLiabilityIndicator(String liabilityIndicator) {
        this.liabilityIndicator = liabilityIndicator;
    }

    public String getLiabilityIndicator() {
        return liabilityIndicator;
    }
}
