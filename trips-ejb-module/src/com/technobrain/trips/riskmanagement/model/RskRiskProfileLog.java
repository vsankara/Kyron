package com.technobrain.trips.riskmanagement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@NamedQueries({
    @NamedQuery(name = "RskRiskProfileLog.findAll", 
        query = "select o from RskRiskProfileLog o") ,
    @NamedQuery(name = "RskRiskProfileLog.findRiskProfileLogByProfileId", 
        query = "select o from RskRiskProfileLog o where o.riskProfileId = ?1 ")
})
@Table(name = "RSK_RISK_PROFILE_LOG")
public class RskRiskProfileLog  extends BaseNormalModelObject{  
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                 generator = "RSK_RISK_PROFILE_LOG_SEQ")
    @SequenceGenerator(name = "RSK_RISK_PROFILE_LOG_SEQ", sequenceName = "RSK_RISK_PROFILE_LOG_SEQ", 
                    allocationSize = 1)   
    @Column(nullable = false)
    private Long id;

    @Column(name="DESK_AUDIT_THRESHOLD", nullable = false)
    private Long deskAuditThreshold;    
    private String office;
    @Column(name="RISK_PROFILE_ID", nullable = false)
    private Long riskProfileId;
    @Column(name="RISK_SCORE")
    private Long riskScore;    
    @ManyToOne
    @JoinColumn(name = "RSK_RISK_PROCESS_ID", referencedColumnName = "ID")
    private RskRiskProcess rskRiskProcess;
    @Column(name="PROFILE_HIT_INDICATOR" , nullable = false)
    private String profileHitIndicator;
    @OneToMany(mappedBy = "rskRiskProfileLog", fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    private List<RskRiskCriteriaLog> rskRiskCriteriaLogList;

    public RskRiskProfileLog() {
    }

    public Long getDeskAuditThreshold() {
        return deskAuditThreshold;
    }

    public void setDeskAuditThreshold(Long deskAuditThreshold) {
        this.deskAuditThreshold = deskAuditThreshold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Long getRiskProfileId() {
        return riskProfileId;
    }

    public void setRiskProfileId(Long riskProfileId) {
        this.riskProfileId = riskProfileId;
    }

    public Long getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Long riskScore) {
        this.riskScore = riskScore;
    }

    public RskRiskProcess getRskRiskProcess() {
        return rskRiskProcess;
    }

    public void setRskRiskProcess(RskRiskProcess rskRiskProcess) {
        this.rskRiskProcess = rskRiskProcess;
    }

    public void setProfileHitIndicator(String profileHitIndicator) {
        this.profileHitIndicator = profileHitIndicator;
    }

    public String getProfileHitIndicator() {
        return profileHitIndicator;
    }

    public void setRskRiskCriteriaLogList(List<RskRiskCriteriaLog> rskRiskCriteriaLogList) {
        this.rskRiskCriteriaLogList = rskRiskCriteriaLogList;
    }

    public List<RskRiskCriteriaLog> getRskRiskCriteriaLogList() {
        return rskRiskCriteriaLogList;
    }
    public RskRiskCriteriaLog addRskRiskCriteriaLog(RskRiskCriteriaLog rskRiskCriteriaLog) {
        getRskRiskCriteriaLogList().add(rskRiskCriteriaLog);
        rskRiskCriteriaLog.setRskRiskProfileLog(this);
        return rskRiskCriteriaLog;
    }

    public RskRiskCriteriaLog removeRskRiskCriteriaLog(RskRiskCriteriaLog rskRiskCriteriaLog) {
        getRskRiskCriteriaLogList().remove(rskRiskCriteriaLog);
        rskRiskCriteriaLog.setRskRiskProfileLog(null);
        return rskRiskCriteriaLog;
    }

}
