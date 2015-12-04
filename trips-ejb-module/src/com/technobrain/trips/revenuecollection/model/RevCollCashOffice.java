package com.technobrain.trips.revenuecollection.model;

import com.technobrain.trips.core.annotation.ReferenceNumber;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries(
    {
    @NamedQuery(name = "RevCollCashOffice.findAll", 
    query = "select o from RevCollCashOffice o"),
    @NamedQuery(name = "RevCollCashOffice.findById", 
    query = "select o from RevCollCashOffice o where o.id = ?1"),
    @NamedQuery(name = "RevCollCashOffice.findByStatus", 
    query = "select o from RevCollCashOffice o where o.status = ?1")
    }
)
@Table(name = "REV_COLL_CASH_OFFICE")
public class RevCollCashOffice extends BaseNormalModelObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REV_COLL_CASH_OFFICE_SEQ")
    @SequenceGenerator(name = "REV_COLL_CASH_OFFICE_SEQ", sequenceName = "REV_COLL_CASH_OFFICE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="REF_OFFICE_CODE", nullable = false)
    private String refOfficeCode;
    
    @Column(name="CASH_LIMIT", nullable = false)
    private BigDecimal cashLimit;
    
    @ReferenceNumber(format="CSQL", sql="SELECT LTRIM(TO_CHAR(MOD(CASH_OFFICE_CODE_SEQ.nextval,000000000),'000000099')) as generatedId FROM dual")
    @Column
    private String code;
    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    @Column(nullable = false)
    private String name;
    
    @Column(name="OFFICE_STATUS", nullable = false)
    private String officeStatus;
    
    @Column(name="SESSION_ID")
    private Long sessionID;
    
    @OneToMany(mappedBy = "revCollCashOffice" , cascade={CascadeType.ALL})
    private List<RevCollCashOfficeUsers> revCollCashOfficeUsersList;
    
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "revCollCashOffice")
    private List<RevCollCashOfficeHistory> revCollCashOffHistoryList;
    public RevCollCashOffice() {
    }
   
    public BigDecimal getCashLimit() {
        return cashLimit;
    }

    public void setCashLimit(BigDecimal cashLimit) {
        this.cashLimit = cashLimit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeStatus() {
        return officeStatus;
    }

    public void setOfficeStatus(String officeStatus) {
        this.officeStatus = officeStatus;
    }

    public String getRefOfficeCode() {
        return refOfficeCode;
    }

    public void setRefOfficeCode(String refOfficeCode) {
        this.refOfficeCode = refOfficeCode;
    }  

    public List<RevCollCashOfficeUsers> getRevCollCashOfficeUsersList() {
        if(revCollCashOfficeUsersList == null){
            revCollCashOfficeUsersList = new ArrayList<RevCollCashOfficeUsers>();
        }
        return revCollCashOfficeUsersList;
    }

    public void setRevCollCashOfficeUsersList(List<RevCollCashOfficeUsers> revCollCashOfficeUsersList) {
        this.revCollCashOfficeUsersList = revCollCashOfficeUsersList;
    }

    public RevCollCashOfficeUsers addRevCollCashOfficeUsers(RevCollCashOfficeUsers revCollCashOfficeUsers) {
        getRevCollCashOfficeUsersList().add(revCollCashOfficeUsers);
        revCollCashOfficeUsers.setRevCollCashOffice(this);
        return revCollCashOfficeUsers;
    }

    public RevCollCashOfficeUsers removeRevCollCashOfficeUsers(RevCollCashOfficeUsers revCollCashOfficeUsers) {
        getRevCollCashOfficeUsersList().remove(revCollCashOfficeUsers);
        revCollCashOfficeUsers.setRevCollCashOffice(null);
        return revCollCashOfficeUsers;
    }

    public void setRevCollCashOffHistoryList(List<RevCollCashOfficeHistory> revCollCashOffHistoryList) {
        this.revCollCashOffHistoryList = revCollCashOffHistoryList;
    }

    public List<RevCollCashOfficeHistory> getRevCollCashOffHistoryList() {
        return revCollCashOffHistoryList;
    }

    public void setSessionID(Long sessionID) {
        this.sessionID = sessionID;
    }

    public Long getSessionID() {
        return sessionID;
    }
}
