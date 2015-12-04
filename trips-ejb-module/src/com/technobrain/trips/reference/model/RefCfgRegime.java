package com.technobrain.trips.reference.model;

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
@NamedQuery(name = "RefCfgRegime.findAll", 
    query = "select o from RefCfgRegime o")
@Table(name = "REF_CFG_REGIME")
public class RefCfgRegime extends BaseRefModelObject   {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "REF_CFG_REGIME_SEQ")
    @SequenceGenerator(name = "REF_CFG_REGIME_SEQ", sequenceName = "REF_CFG_REGIME_SEQ", 
                       allocationSize = 1)    
    @Column(nullable = false)
    
    private String code;

    @Column(nullable = false)
    private String decision;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(nullable = false)
    private String parameter;
    @Column(name="PROCESS_NAME", nullable = false)
    private String processName;
     
     
    @Column(name="REGIME_CODE")
    private String regimeCode;     
     
     
    @ManyToOne
    @JoinColumn(name = "REGIME_CODE", referencedColumnName = "CODE", nullable=false,insertable=false, updatable=false)
    private RefRevType refRevType;

    public RefCfgRegime() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
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

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public RefRevType getRefRevType() {
        return refRevType;
    }

    public void setRefRevType(RefRevType refRevType) {
        this.refRevType = refRevType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setRegimeCode(String regimeCode) {
        this.regimeCode = regimeCode;
    }

    public String getRegimeCode() {
        return regimeCode;
    }
}
