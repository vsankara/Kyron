package com.technobrain.trips.riskmanagement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity

    
@NamedQueries (
    {
        @NamedQuery(name = "RskRiskProcess.findAll", 
            query = "select o from RskRiskProcess o"),
        @NamedQuery(name = "RskRiskProcess.findRiskProcessByDocument",
            query = "select o from RskRiskProcess o where o.documentId = ?1 and o.documentEventId = ?2 ")            
    }
)    
    
@Table(name = "RSK_RISK_PROCESS")
public class RskRiskProcess extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "RSK_RISK_PROCESS_SEQ")
    @SequenceGenerator(name = "RSK_RISK_PROCESS_SEQ", sequenceName = "RSK_RISK_PROCESS_SEQ", 
                       allocationSize = 1)   
    @Column(nullable = false)
    private Long id;
 
    @Column(name="ACTION_DATE")
    private Timestamp actionDate;
    @Column(name="CASE_ID")
    private Long caseId;
    @Column(name="DOCUMENT_ID", nullable = false)
    private Long documentId;
    private String tin;
    @Column(name="DOCUMENT_EVENT_ID", nullable = false)
    private Long documentEventId;
    @OneToMany(mappedBy = "rskRiskProcess", fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    private List<RskRiskProfileLog> rskRiskProfileLogList;
    
    public RskRiskProcess() {
    }

    public Timestamp getActionDate() {
        return actionDate;
    }

    public void setActionDate(Timestamp actionDate) {
        this.actionDate = actionDate;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public List<RskRiskProfileLog> getRskRiskProfileLogList() {
        return rskRiskProfileLogList;
    }

    public void setRskRiskProfileLogList(List<RskRiskProfileLog> rskRiskProfileLogList) {
        this.rskRiskProfileLogList = rskRiskProfileLogList;
    }

    public RskRiskProfileLog addRskRiskProfileLog(RskRiskProfileLog rskRiskProfileLog) {
        getRskRiskProfileLogList().add(rskRiskProfileLog);
        rskRiskProfileLog.setRskRiskProcess(this);
        return rskRiskProfileLog;
    }

    public RskRiskProfileLog removeRskRiskProfileLog(RskRiskProfileLog rskRiskProfileLog) {
        getRskRiskProfileLogList().remove(rskRiskProfileLog);
        rskRiskProfileLog.setRskRiskProcess(null);
        return rskRiskProfileLog;
    }

    public void setDocumentEventId(Long documentEventId) {
        this.documentEventId = documentEventId;
    }

    public Long getDocumentEventId() {
        return documentEventId;
    }

}
