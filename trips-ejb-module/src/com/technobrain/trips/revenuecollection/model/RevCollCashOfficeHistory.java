package com.technobrain.trips.revenuecollection.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.document.model.DdocDocument;

import java.io.Serializable;

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
@NamedQuery(name = "RevCollCashOfficeHistory.findAll", 
    query = "select o from RevCollCashOfficeHistory o")
@Table(name = "REV_COLL_CASH_OFFICE_HIST")
public class RevCollCashOfficeHistory extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REV_COLL_CASH_OFFICE_HIST_SEQ")
    @SequenceGenerator(name = "REV_COLL_CASH_OFFICE_HIST_SEQ", sequenceName = "REV_COLL_CASH_OFFICE_HIST_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="OFFICE_STATUS")
    private String officeStatus;
    @Column(name="SESSION_ID")
    private Long sessionID;
    @ManyToOne
    @JoinColumn(name = "OFFICE_ID", referencedColumnName = "ID")
    private RevCollCashOffice revCollCashOffice;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
  

    public String getOfficeStatus() {
        return officeStatus;
    }

    public void setOfficeStatus(String officeStatus) {
        this.officeStatus = officeStatus;
    }

    public Long getSessionID() {
        return sessionID;
    }

    public void setSessionID(Long sessionID) {
        this.sessionID = sessionID;
    }

    public void setRevCollCashOffice(RevCollCashOffice revCollCashOffice) {
        this.revCollCashOffice = revCollCashOffice;
    }

    public RevCollCashOffice getRevCollCashOffice() {
        return revCollCashOffice;
    }
}
