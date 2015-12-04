package com.technobrain.trips.compliance.model;

import com.technobrain.trips.account.model.AccountPeriod;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="TaxComplianceHistory")
@NamedQueries (
    {
        @NamedQuery(name = "TaxComplianceHistory.findAll", query = "select o from TaxComplianceHistory o"),
        @NamedQuery(name = "TaxComplianceHistory.getPeriodStatus",
                    query = "select tch.period.periodStatus from TaxComplianceHistory tch" +
                            "   where tch=:hi")
    }    
)
@Table(name = "TAX_COMPLIANCE_HISTORY")
public class TaxComplianceHistory extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAX_COMPLIANCE_HISTORY_SEQ")
    @SequenceGenerator(name = "TAX_COMPLIANCE_HISTORY_SEQ", sequenceName = "TAX_COMPLIANCE_HISTORY_SEQ", allocationSize = 1)
    @Column(name="ID", nullable = false)
    private Long id;
    
    private BigDecimal amount;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PERIOD_ID", referencedColumnName="ID", nullable=false, updatable=false, insertable=false)
    private AccountPeriod period;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PROCESS_ID", referencedColumnName="ID", nullable=false, updatable=false, insertable=false)
    private TaxComplianceProcess processId;
    
    private String tin;
    
    @Column(name="NOTICE_COUNT")
    private Integer noticeCount;
    
    @Column(name="BREACH_COUNT")
    private Integer breachCount;
    
    @OneToMany(mappedBy = "history", fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    private List<TaxComplianceNotice> notices;
    
    public TaxComplianceHistory() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setPeriod(AccountPeriod period) {
        this.period = period;
    }

    public AccountPeriod getPeriod() {
        return period;
    }

    public void setProcessId(TaxComplianceProcess processId) {
        this.processId = processId;
    }

    public TaxComplianceProcess getProcessId() {
        return processId;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getTin() {
        return tin;
    }

    public void setNoticeCount(Integer noticeCount) {
        this.noticeCount = noticeCount;
    }

    public Integer getNoticeCount() {
        return noticeCount;
    }

    public void setBreachCount(Integer breachCount) {
        this.breachCount = breachCount;
    }

    public Integer getBreachCount() {
        return breachCount;
    }

    public void setNotices(List<TaxComplianceNotice> notices) {
        this.notices = notices;
    }

    public List<TaxComplianceNotice> getNotices() {
        return notices;
    }

}
