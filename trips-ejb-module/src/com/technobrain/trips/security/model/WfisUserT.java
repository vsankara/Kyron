package com.technobrain.trips.security.model;

import com.technobrain.trips.common.helpers.DateHelper;
//import com.crownagents.trips.identity.model.CasRole;
//import com.crownagents.trips.identity.model.CasUser;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@NamedQueries({
//    @NamedQuery(name = "WfisUserT.findAll", 
//    		query = "select o from WfisUserT o"),
//    @NamedQuery(
//    		name="WfisUserT.findAllLoggedIn",
//    		query="select o from WfisUserT o where o.loginStatus = 1 order by o.name"
//    )
//})
@Table(name = "WFIS_USER_T")
//@IdClass(WfisUserTPK.class)
public class WfisUserT implements Serializable {
//	public static final Integer LOGIN_STATUS_LOGGED_IN = 1;
//	public static final Integer LOGIN_STATUS_LOGGED_OUT = 2;
//	public static final Integer LOGIN_STATUS_KICKED_OFF = 3;
//	
//    private String description;
//    private String displayname;
//    private String fax;
//    private String firstname;
//    private String homephone;
//    private String lastname;
//    private String locale;
//    private String mail;
//    private String manager;
//    private String middlename;
//    private String mobile;
//    private String status;
    @Id
    @Column(nullable = false)  
    private String name;
//    private String notificationpref;
//    private Long ownerid;
//    private String pager;
    @Id
    @Column(nullable = false)
    private String realm;
//    private String timezone;
//    private String title;
//    @Column(name="LOGIN_STATUS")
//    private Integer loginStatus;
//    
//    @Column(nullable = false)
//    @GeneratedValue(generator = "WfisUserTSeq")
//    @SequenceGenerator(name = "WfisUserTSeq", 
//                       sequenceName = "WFIS_USER_T_SEQ", allocationSize = 1)
//    private Long userid; 
//    private String workphone;
//    @OneToOne(mappedBy = "wfisUserT")
//    private WfisUserpassT wfisUserpassT;
//    @OneToMany(mappedBy = "wfisUserT")
//    private List<WfisOwnershipT> wfisOwnershipTList;
//    @OneToMany(mappedBy = "wfisUserT")
//    private List<WfisPolicyT> wfisPolicyTList;
//    @Column(name="ACCESS_LEVEL")
//    private String accessLevel;
//    
//    public WfisUserT() {
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getDisplayname() {
//        return displayname;
//    }
//
//    public void setDisplayname(String displayname) {
//        this.displayname = displayname;
//    }
//
//    public String getFax() {
//        return fax;
//    }
//
//    public void setFax(String fax) {
//        this.fax = fax;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getHomephone() {
//        return homephone;
//    }
//
//    public void setHomephone(String homephone) {
//        this.homephone = homephone;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getLocale() {
//        return locale;
//    }
//
//    public void setLocale(String locale) {
//        this.locale = locale;
//    }
//
//    public String getMail() {
//        return mail;
//    }
//
//    public void setMail(String mail) {
//        this.mail = mail;
//    }
//
//    public String getManager() {
//        return manager;
//    }
//
//    public void setManager(String manager) {
//        this.manager = manager;
//    }
//
//    public String getMiddlename() {
//        return middlename;
//    }
//
//    public void setMiddlename(String middlename) {
//        this.middlename = middlename;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
//
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public String getNotificationpref() {
//        return notificationpref;
//    }
//
//    public void setNotificationpref(String notificationpref) {
//        this.notificationpref = notificationpref;
//    }
//
//    public Long getOwnerid() {
//        return ownerid;
//    }
//
//    public void setOwnerid(Long ownerid) {
//        this.ownerid = ownerid;
//    }
//
//    public String getPager() {
//        return pager;
//    }
//
//    public void setPager(String pager) {
//        this.pager = pager;
//    }
//
    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }
//
//    public String getTimezone() {
//        return timezone;
//    }
//
//    public void setTimezone(String timezone) {
//        this.timezone = timezone;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Long getUserid() {
//        return userid;
//    }
//
//    public void setUserid(Long userid) {
//        this.userid = userid;
//    }
//
//    public String getWorkphone() {
//        return workphone;
//    }
//
//    public void setWorkphone(String workphone) {
//        this.workphone = workphone;
//    }
//
//    public WfisUserpassT getWfisUserpassT() {
//        return wfisUserpassT;
//    }
//
//    public void setWfisUserpassT(WfisUserpassT wfisUserpassT) {
//        this.wfisUserpassT = wfisUserpassT;
//    }
//
//    public List<WfisOwnershipT> getWfisOwnershipTList() {
//        return wfisOwnershipTList;
//    }
//
//    public void setWfisOwnershipTList(List<WfisOwnershipT> wfisOwnershipTList) {
//        this.wfisOwnershipTList = wfisOwnershipTList;
//    }
//
//    public WfisOwnershipT addWfisOwnershipT(WfisOwnershipT wfisOwnershipT) {
//        getWfisOwnershipTList().add(wfisOwnershipT);
//        wfisOwnershipT.setWfisUserT(this);
//        return wfisOwnershipT;
//    }
//
//    public WfisOwnershipT removeWfisOwnershipT(WfisOwnershipT wfisOwnershipT) {
//        getWfisOwnershipTList().remove(wfisOwnershipT);
//        wfisOwnershipT.setWfisUserT(null);
//        return wfisOwnershipT;
//    }
//
//    public List<WfisPolicyT> getWfisPolicyTList() {
//        return wfisPolicyTList;
//    }
//
//    public void setWfisPolicyTList(List<WfisPolicyT> wfisPolicyTList) {
//        this.wfisPolicyTList = wfisPolicyTList;
//    }
//
//    public WfisPolicyT addWfisPolicyT(WfisPolicyT wfisPolicyT) {
//        getWfisPolicyTList().add(wfisPolicyT);
//        wfisPolicyT.setWfisUserT(this);
//        return wfisPolicyT;
//    }
//
//    public WfisPolicyT removeWfisPolicyT(WfisPolicyT wfisPolicyT) {
//        getWfisPolicyTList().remove(wfisPolicyT);
//        wfisPolicyT.setWfisUserT(null);
//        return wfisPolicyT;
//    }
//
//    public boolean hasRole(String assignedMenuRole) {
//        for(WfisPolicyT role:getWfisPolicyTList()){
//           if(role.getRole().equals(assignedMenuRole) ){
//             return true;   
//           }
//        }        
//        return false;
//    }
//    public CasUser getData() {
//        CasUser casUser = new CasUser();
//        
//        casUser.setUsername(this.name);
//        casUser.setFirstName(this.getFirstname());
//        casUser.setLastName(this.getLastname());
//        casUser.setStatus(this.getStatus());
//        casUser.setAccessLevel(this.getAccessLevel());
//        casUser.setEmail(this.getMail());
//        casUser.setTelephone(this.getWorkphone());
//        casUser.setFax(this.getFax());
//        casUser.setTitle(this.getTitle());
//        if(null != this.getWfisUserpassT())
//            casUser.setPasswordExpiryDate(DateHelper.getCalendar( 
//            this.getWfisUserpassT().getPasswordExpiryDate()));
//        return casUser;
//    }
//
//    public void setData(CasUser user) {
//        this.name = user.getUsername();
//        this.displayname = user.getLastName() + ", " + user.getFirstName();
//        this.description = user.getUsername();
//        this.firstname = user.getFirstName();
//        this.lastname = user.getLastName();  
//        this.status = user.getStatus();
//        this.accessLevel = user.getAccessLevel();
//        this.mail = user.getEmail();
//        this.workphone = user.getTelephone();
//        this.fax = user.getFax();
//        this.title = user.getTitle();
//        if(null != this.getWfisUserpassT())
//        this.getWfisUserpassT().setPasswordExpiryDate(DateHelper.getSqlTimestamp(user.getPasswordExpiryDate()));
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setAccessLevel(String accessLevel) {
//        this.accessLevel = accessLevel;
//    }
//
//    public String getAccessLevel() {
//        return accessLevel;
//    }
//
//	public Integer getLoginStatus() {
//		return loginStatus;
//	}
//
//	public void setLoginStatus(Integer loginStatus) {
//		this.loginStatus = loginStatus;
//	}
    
    
}
