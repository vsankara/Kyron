package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

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
@NamedQuery(name = "RefDateCfgHist.findAll", 
            query = "select o from RefDateCfgHist o")
@Table(name = "REF_DATE_CFG_HIST")
public class RefDateCfgHist extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REF_DATE_CFG_HISTORY_SEQ")
    @SequenceGenerator(name = "REF_DATE_CFG_HISTORY_SEQ", sequenceName = "REF_DATE_CFG_HISTORY_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="REMARKS")
    private String remarks;
    
    @ManyToOne
    @JoinColumn(name = "REF_REASON", referencedColumnName = "CODE", insertable=false, updatable=false)
    private RefReason refReason;
    
    @Column(name="REF_REASON")
    private String reasonCode;
    
    @Column(name="REF_DATE_CFG")
    private String refDateCfgCode;
    
    @ManyToOne
    @JoinColumn(name = "REF_DATE_CFG", referencedColumnName = "CODE", insertable=false, updatable=false)
    private RefDateCfg refDateCfg;
    
    public RefDateCfgHist() {
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }
    
    public void setRefReason(RefReason refReason) {
        this.refReason = refReason;
    }

    public RefReason getRefReason() {
        return refReason;
    }

    
    public void setRefDateCfg(RefDateCfg refDateCfg) {
        this.refDateCfg = refDateCfg;
    }

    public RefDateCfg getRefDateCfg() {
        return refDateCfg;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getRefDateCfgCode() {
        return refDateCfgCode;
    }

    public void setRefDateCfgCode(String refDateCfgCode) {
        this.refDateCfgCode = refDateCfgCode;
    }
}