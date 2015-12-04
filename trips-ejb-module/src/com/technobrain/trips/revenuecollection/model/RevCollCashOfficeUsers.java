package com.technobrain.trips.revenuecollection.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefOffStaff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQueries( { @NamedQuery(name = "RevCollCashOfficeUsers.findAll", 
                             query = "select o from RevCollCashOfficeUsers o")
        , 
        @NamedQuery(name = "RevCollCashOfficeUsers.findByStaffID", query = "select o from RevCollCashOfficeUsers o where o.refOffStaff.id = ?1")
        , 
        @NamedQuery(name = "RevCollCashOfficeUsers.findByCashOfficeID", query = 
                    "select o from RevCollCashOfficeUsers o where o.revCollCashOffice.id = ?1 and o.role = 'CashOfficer'")
        , 
        @NamedQuery(name = "RevCollCashOfficeUsers.findSupervisorsByStaffID", query = 
                    "select o from RevCollCashOfficeUsers o where o.refOffStaff.id = ?1 and o.role = 'CashOfficeSupervisor'")
        , 
        @NamedQuery(name = "RevCollCashOfficeUsers.findOfficersByCashOfficeID", query = 
                    "select o from RevCollCashOfficeUsers o where o.revCollCashOffice.id = ?1")
        , 
        @NamedQuery(name = "RevCollCashOfficeUsers.findAllCashiers", query = "select o from RevCollCashOfficeUsers o where o.role = 'CashOfficer'")
        , 
        @NamedQuery(name = "RevCollCashOfficeUsers.findCashOfficeIDs", query = 
                    "select o from RevCollCashOfficeUsers o where o.revCollCashOffice.status='A' and o.refOffStaff.id = ?1")
        } )
@Table(name = "REV_COLL_CASH_OFFICE_USERS")
public class RevCollCashOfficeUsers extends BaseNormalModelObject {


    @ManyToOne
    @JoinColumn(name = "CASH_OFFICE_ID", referencedColumnName = "ID")
    private RevCollCashOffice revCollCashOffice;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "REV_COLL_CASH_OFFICE_USERS_SEQ")
    @SequenceGenerator(name = "REV_COLL_CASH_OFFICE_USERS_SEQ", 
                       sequenceName = "REV_COLL_CASH_OFFICE_USERS_SEQ", 
                       allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    private String role;


    @ManyToOne
    @JoinColumn(name = "STAFF_ID", referencedColumnName = "ID")
    private RefOffStaff refOffStaff;

    public RevCollCashOfficeUsers() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public void setRevCollCashOffice(RevCollCashOffice revCollCashOffice) {
        this.revCollCashOffice = revCollCashOffice;
    }

    public RevCollCashOffice getRevCollCashOffice() {
        return revCollCashOffice;
    }

    public void setRefOffStaff(RefOffStaff refOffStaff) {
        this.refOffStaff = refOffStaff;
    }

    public RefOffStaff getRefOffStaff() {
        return refOffStaff;
    }


}
