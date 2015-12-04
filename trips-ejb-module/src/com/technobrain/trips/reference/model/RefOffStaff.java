package com.technobrain.trips.reference.model;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;
import com.technobrain.trips.revenuecollection.model.RevCollCashOfficeUsers;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.persistence.Version;


/**
 * TechnoBrain 2015
 *
 * 
 *
 * @since	$Date: 5/26/2009 10:01:35 AM$
 * @version 	$Revision: 1$
 * @author 	$Author: Howard Hill$
 *
 * $Log[1]:
 *  1    TRIPS2    1.0         5/26/2009 10:01:35 AM  Howard Hill     
 * $
 */
@Entity
@NamedQueries(
    {
    @NamedQuery(name = "RefOffStaff.findAll", query = "select o from RefOffStaff o"),
    @NamedQuery(name = "RefOffStaff.findById", query = "select o from RefOffStaff o where o.id = ?1"),
    @NamedQuery(name = "RevCollCashOffice.findOfficersList", 
    query = "select o from RefOffStaff o where o.id not in (select o1.refOffStaff.id from RevCollCashOfficeUsers o1 where o1.role = 'CashOfficer') and o.refOffice.code = ?1"),
    @NamedQuery(name = "RefOffStaff.findOfficersListByOffice", 
    query = "select o from RefOffStaff o where o.refOffice.code = ?1")
    }
)
@Table(name = "Ref_Off_Staff")
public class RefOffStaff extends  BaseNormalModelObject   {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Ref_Off_Staff_seq")
    @SequenceGenerator(name = "Ref_Off_Staff_seq", sequenceName = "Ref_Off_Staff_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id; 
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;    
    @Column(name = "USER_NAME")
    private String username;    
    @ManyToOne
    @JoinColumn(name = "REF_OFFICE", referencedColumnName = "CODE")
    private RefOffice refOffice;
    @Column(name = "ENABLE_LOG_SEARCH")
    private String enableLogOnSearchs;
    @Column(name = "ENABLE_VIEW_OFFICES")
    private String enableViewOffices;
    
    public RefOffStaff() {
    }

    public void setEnableViewOffices(String enableViewOffices){
        this.enableViewOffices = enableViewOffices;
    }
    
    public String getEnableViewOffices(){
        return this.enableViewOffices;
    }
    
    
    public String getEnableLogOnSearchs(){
        return this.enableLogOnSearchs;
    }
    
    public void setEnableLogOnSearchs(String enableLogOnSearchs){
        this.enableLogOnSearchs = enableLogOnSearchs;
    } 
    
    
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String username){
        this.username = username;
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

    public void setRefOffice(RefOffice refOffice) {
        this.refOffice = refOffice;
    }

    public RefOffice getRefOffice() {
        return refOffice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public boolean canViewAllOffices() {
        return this.enableViewOffices == null ? false : this.enableViewOffices.equals(Constants.YES);
    }
}
