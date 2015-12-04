package com.technobrain.trips.security.model;

import com.technobrain.trips.common.constants.Constants;
//import com.crownagents.trips.identity.model.CasRole;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@NamedQueries({
//    @NamedQuery(name = "WfisRoleT.findAll", query = "select o from WfisRoleT o order by o.description"),
//    @NamedQuery(name = "WfisRoleT.findAllGroups", query = "select o from WfisRoleT o where o.isgroup = 'Y' and o.status = 'A' order by o.description")
//})
//@Table(name = "WFIS_ROLE_T")
//@IdClass(WfisRoleTPK.class)
public class WfisRoleT implements Serializable {
//    private String description;
//    private String displayname;
//    @GeneratedValue(generator = "WfisRoleTSeq")
//    @SequenceGenerator(name = "WfisRoleTeq", 
//                       sequenceName = "WfisRoleT_SEQ", allocationSize = 1)
//    private Long groupid;
//    private String isgroup;
//    private String status;
    @Id
    @Column(nullable = false)
    private String name;
//    private Long ownerid;
//    @Id
//    @Column(nullable = false)
//    private String realm;
//    @OneToMany(mappedBy = "group")
//    private List<WfisPolicyT> wfisPolicyTList;
//    @OneToMany(mappedBy = "wfisRole")
//    private List<WfisOwnershipT> wfisOwnershipTList;
//    
//    @OneToMany(cascade={CascadeType.ALL}, mappedBy="group")
//    private List<WfisGroupCategoryT> wfisGroupCategoryT;
//
//    public WfisRoleT() {
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
//    public Long getGroupid() {
//        return groupid;
//    }
//
//    public void setGroupid(Long groupid) {
//        this.groupid = groupid;
//    }
//
//    public String getIsgroup() {
//        return isgroup;
//    }
//
//    public void setIsgroup(String isgroup) {
//        this.isgroup = isgroup;
//    }
//
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public Long getOwnerid() {
//        return ownerid;
//    }
//
//    public void setOwnerid(Long ownerid) {
//        this.ownerid = ownerid;
//    }
//
//    public String getRealm() {
//        return realm;
//    }
//
//    public void setRealm(String realm) {
//        this.realm = realm;
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
//        wfisPolicyT.setGroup(this);
//        return wfisPolicyT;
//    }
//
//    public WfisPolicyT removeWfisPolicyT(WfisPolicyT wfisPolicyT) {
//        getWfisPolicyTList().remove(wfisPolicyT);
//        wfisPolicyT.setGroup(null);
//        return wfisPolicyT;
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
//        wfisOwnershipT.setWfisRole(this);
//        return wfisOwnershipT;
//    }
//
//    public WfisOwnershipT removeWfisOwnershipT(WfisOwnershipT wfisOwnershipT) {
//        getWfisOwnershipTList().remove(wfisOwnershipT);
//        wfisOwnershipT.setWfisRole(null);
//        return wfisOwnershipT;
//    }
//    
//    public void setWfisGroupCategoryT(List<WfisGroupCategoryT> wfisGroupCategoryT) {
//            this.wfisGroupCategoryT = wfisGroupCategoryT;
//        }
//
//    public List<WfisGroupCategoryT> getWfisGroupCategoryT() {
//        return wfisGroupCategoryT;
//    }
//    
//    public WfisGroupCategoryT addWfisGroupCategoryT(WfisGroupCategoryT wfisGroupCategoryT) {
//        wfisGroupCategoryT.setGroup(this);
//        getWfisGroupCategoryT().add(wfisGroupCategoryT);
//        return wfisGroupCategoryT;
//    }
//
//    public WfisGroupCategoryT removeWfisGroupCategoryT(WfisGroupCategoryT wfisGroupCategoryT) {
//        getWfisGroupCategoryT().remove(wfisGroupCategoryT);
//        return wfisGroupCategoryT;
//    }
//    
//    public boolean isGroupCategoryExisting(String assignedGroupCategory) {
//        for(WfisGroupCategoryT groupCategory:getWfisGroupCategoryT()){
//           if(groupCategory.getCategory().equals(assignedGroupCategory) ){
//             return true;   
//           }
//        }        
//        return false;
//    }
//
//    public boolean isGroupRole() {
//        return null != this.isgroup && this.isgroup.equals("Y") ? true : false;
//    }
//
//    public CasRole getData() {
//        CasRole casRole = new CasRole();
//        casRole.setRoleName(this.getName());
//        casRole.setGroupRole(true);
//        casRole.setMenuRole(false);
//        casRole.setDescription(this.getDescription());
//        casRole.setStatus(this.getStatus());
//        return casRole;
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
//    public void setData(CasRole casRole) {
//
//        this.setRealm("default");
//        if(casRole.getRoleType() != null && casRole.getRoleType().equals(Constants.RoleType.OFFICE)){
//            this.setIsgroup(Constants.YES);
//        }else
//            if(casRole.getRoleType() != null && casRole.getRoleType().equals(Constants.RoleType.TASKS)){
//                this.setIsgroup(Constants.YES);
//            }else
//                if(casRole.getRoleType() != null && casRole.getRoleType().equals(Constants.RoleType.PERMISSION)){
//                    this.setIsgroup(Constants.NO);
//                }else{
//                    this.setIsgroup(Constants.YES);
//                }
//        
//        this.setName(casRole.getRoleName());
//        this.setDisplayname(casRole.getRoleName());
//        this.setDescription(casRole.getDescription());
//        this.setStatus(casRole.getStatus());
//    }
}
