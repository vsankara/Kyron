package com.technobrain.trips.compliance.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefNoticeType;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity(name="TaxComplianceNotice")
@NamedQueries (
    {
        @NamedQuery(name = "TaxComplianceNotice.findAll", query = "select o from TaxComplianceNotice o"),
        @NamedQuery(name = "TaxComplianceNotice.findById", query = "select o from TaxComplianceNotice o where o.id = ?1"),
        @NamedQuery(name = "TaxComplianceNotice.findNoticesByStatus", 
                    query = "select notice " +
                            "from TaxComplianceNotice notice " +
                            "where notice.printStatus=:stat "),
        @NamedQuery(name = "TaxComplianceNotice.updateNotice", 
                    query = "update TaxComplianceNotice notice Set notice.printStatus=:stat where notice=:nid")
    }    
)
@Table(name = "TAX_COMPLIANCE_NOTICES")
public class TaxComplianceNotice extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAX_COMPLIANCE_NOTICES_SEQ")
    @SequenceGenerator(name = "TAX_COMPLIANCE_NOTICES_SEQ", sequenceName = "TAX_COMPLIANCE_NOTICES_SEQ", allocationSize = 1)
    @Column(name="ID", nullable = false)
    private Long id;

    @Column(name="PRINT_STATUS")
    private String printStatus;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="HISTORY_ID", referencedColumnName="ID", nullable=false, updatable=false, insertable=false)
    private TaxComplianceHistory history;
    
    @Column(name="NOTICE_TYPE")
    private String noticeType;
    
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="RPT_PATH_INFO_CODE", referencedColumnName="CODE", nullable=false, updatable=false, insertable=false)
//    private ReportPathInfo rptPathInfoCode;
    
    private String office;
    
    private String secondary;
    
    @Column(name="TASK_DATE")
    private Timestamp taskDate;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="NOTICE_TO_PRINT", referencedColumnName="CODE", nullable=false, updatable=false, insertable=false)
    private RefNoticeType noticeToPrint;
   
    @Column(name="USER_ID") 
    private String userId;
    
    public TaxComplianceNotice() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setPrintStatus(String printStatus) {
        this.printStatus = printStatus;
    }

    public String getPrintStatus() {
        return printStatus;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getNoticeType() {
        return noticeType;
    }

//    public void setRptPathInfoCode(ReportPathInfo rptPathInfoCode) {
//        this.rptPathInfoCode = rptPathInfoCode;
//    }
//
//    public ReportPathInfo getRptPathInfoCode() {
//        return rptPathInfoCode;
//    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOffice() {
        return office;
    }

    public void setTaskDate(Timestamp taskDate) {
        this.taskDate = taskDate;
    }

    public Timestamp getTaskDate() {
        return taskDate;
    }

    public void setNoticeToPrint(RefNoticeType noticeToPrint) {
        this.noticeToPrint = noticeToPrint;
    }

    public RefNoticeType getNoticeToPrint() {
        return noticeToPrint;
    }

    public void setHistory(TaxComplianceHistory history) {
        this.history = history;
    }

    public TaxComplianceHistory getHistory() {
        return history;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
