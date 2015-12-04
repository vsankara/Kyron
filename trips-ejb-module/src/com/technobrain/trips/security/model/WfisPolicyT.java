package com.technobrain.trips.security.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries(
{
@NamedQuery(name = "WfisPolicyT.findAll", 
    query = "select o from WfisPolicyT o"),
@NamedQuery(name = "WfisPolicyT.findCashOfficer", 
    query = "select o from WfisPolicyT o where o.role = ?1 and o.userMember = ?2"),
@NamedQuery(name = "WfisPolicyT.findUserCashOfficeRoles", 
    query = "select o from WfisPolicyT o where o.userMember = ?1 and o.role in ('CashOfficer','CashOfficeSupervisor')"),
@NamedQuery(name = "WfisPolicyT.findGroupsForUser", 
    query = "select o.role from WfisPolicyT o where o.userMember = ?1")
}
)
@Table(name = "WFIS_POLICY_T")
public class WfisPolicyT implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(generator = "WfisPolicyTSeq")
    @SequenceGenerator(name = "WfisPolicyTSeq", 
                       sequenceName = "WFIS_POLICY_T_SEQ", allocationSize = 1)
    private Long grantid;
    @Column(name="role")
    private String role;
    private String groupMember;
    private String userMember;    
    private String realm;
    private String isMenu;
    @Column(name="IS_FUNCTIONAL_ROLE")
    private String isFunctionalRole;
    @Column(name="POLICY_TYPE")
    private String policyType;
     
    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumns({
    @JoinColumn(name = "REALM", referencedColumnName = "REALM",insertable=false, updatable=false),
    @JoinColumn(name = "GROUPMEMBER", referencedColumnName = "NAME",insertable=false, updatable=false)
    })
    private WfisRoleT group;
    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumns({
    @JoinColumn(name = "REALM", referencedColumnName = "REALM",insertable=false, updatable=false),
    @JoinColumn(name = "USERMEMBER", referencedColumnName = "NAME",insertable=false, updatable=false)
    })
    private WfisUserT wfisUserT;

    public WfisPolicyT() {
    }

    public Long getGrantid() {
        return grantid;
    }

    public void setGrantid(Long grantid) {
        this.grantid = grantid;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public WfisRoleT getGroup() {
        return group;
    }

    public void setGroup(WfisRoleT wfisRoleT) {
        this.group = wfisRoleT;
        if(null != wfisRoleT){
//            this.groupMember = wfisRoleT.getName();
//            this.realm = wfisRoleT.getRealm();
        }
    }

    public WfisUserT getWfisUserT() {
        return wfisUserT;
    }

    public void setWfisUserT(WfisUserT wfisUserT) {
        this.wfisUserT = wfisUserT;
        if(null != wfisUserT){
//            this.userMember = wfisUserT.getName();
//            this.realm = wfisUserT.getRealm();
        }
    }


    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }

    public String getIsMenu() {
        return isMenu;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getRealm() {
        return realm;
    }

    public void setGroupMember(String groupMember) {
        this.groupMember = groupMember;
    }

    public String getGroupMember() {
        return groupMember;
    }

    public void setUserMember(String userMember) {
        this.userMember = userMember;
    }

    public String getUserMember() {
        return userMember;
    }

    public void setIsFunctionalRole(String isFunctionalRole) {
        this.isFunctionalRole = isFunctionalRole;
    }

    public String getIsFunctionalRole() {
        return isFunctionalRole;
    }


    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getPolicyType() {
        return policyType;
    }
}
