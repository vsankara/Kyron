package com.technobrain.trips.security.model;

//package com.crownagents.trips.security.model;
//
//import com.crownagents.trips.core.model.BaseModelObject;
//
//import com.crownagents.trips.identity.model.CasRole;
//
//import com.crownagents.trips.identity.model.CasUser;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//
//@Entity
//@NamedQueries(
//value={
//@NamedQuery(name = "CasDBRoles.findAll", query = "select o from CasDBRoles o"),
//@NamedQuery(name="CasDBRoles.findAllRolesForRoleNames",
//query="select r from CasDBRoles r where r.roleName in(:roles)"),
//@NamedQuery(name="CasDBRoles.findAllMenuRolesForGroup",
//query="select r from CasDBRoles r where r.type = 'MENU' and r.memberRole = ?1 "),
//@NamedQuery(name="CasDBRoles.findAllGroupRoles",
//query="select distinct r from CasDBRoles r where r.type = 'GROUP'"),
//@NamedQuery(name="CasDBRoles.findRole",
//query="select distinct r from CasDBRoles r where r.roleName = ?1")
//})
//@Table(name = "CAS_ROLES")
//@SequenceGenerator(name = "cas_role_seq", sequenceName = "cas_role_seq", initialValue = 1, allocationSize = 1)
//public class CasDBRoles  {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cas_role_seq")
//    @Column(nullable = false)
//    private Long id;
//    @Column(name="ROLE_NAME", nullable = false)
//    private String roleName;
//    @ManyToOne
//    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
//    private CasDBUsers casUsers;
//    @Column(name="USERNAME", nullable = false,insertable=false,updatable=false)
//    private String userName;
//    @Column(name="MEMBER_ROLE", nullable = false)
//    private String memberRole;
//    private String type;
//    
//    public CasDBRoles() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }
//
//
//    public CasDBUsers getCasUsers() {
//        return casUsers;
//    }
//
//    public void setCasUsers(CasDBUsers casUsers) {
//        this.casUsers = casUsers;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public boolean isMenuRole() {
//        return null != this.getType() && this.getType().equals("MENU");
//    }
//
//    public boolean isGroupRole() {
//        return null != this.getType() && this.getType().equals("GROUP");
//    }
//
//    public CasRole getData() {
//        CasRole role = new CasRole();
//        if(this.getCasUsers() != null){
//            CasUser user = new CasUser();
//            user.setId(this.getCasUsers().getId());
//            user.setPasswd(this.getCasUsers().getPasswd());
//            user.setUsername(this.getCasUsers().getUsername());
//            role.setCasUsers(user);
//        }
//        role.setId(this.getId());
//        role.setRoleName(this.getRoleName());
//        role.setMenuRole(isMenuRole());
//        role.setGroupRole(isGroupRole());
//        return role;
//    }
//
//    public void setData(CasRole casRoleDTO) {
//        CasDBUsers casUser = new CasDBUsers();
//        casUser.setData(casRoleDTO.getCasUsers());
//        this.setCasUsers(casUser);
//        this.setId(this.getId());
//        this.setRoleName(this.getRoleName());
//        this.setUserName(this.getUserName());        
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setMemberRole(String memberRole) {
//        this.memberRole = memberRole;
//    }
//
//    public String getMemberRole() {
//        return memberRole;
//    }
//}
