package com.technobrain.trips.security.model;

//package com.crownagents.trips.security.model;
//
//import com.crownagents.trips.common.helpers.DateHelper;
//import com.crownagents.trips.core.model.BaseModelObject;
//
//import com.crownagents.trips.identity.model.CasRole;
//import com.crownagents.trips.identity.model.CasUser;
//
//import java.sql.Timestamp;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//
//@Entity
//@NamedQuery(name = "CasDBUsers.findAll", query = "select o from CasDBUsers o")
//@Table(name = "CAS_USERS")
//public class CasDBUsers    {
//    @Column(nullable = true)
//    private Long id;
//    @Column(nullable = false)
//    private String passwd;
//    @Id
//    @Column(nullable = false)
//    private String username;
//    @OneToMany(mappedBy = "casUsers")
//    private Set<CasDBRoles> casRolesSet;
//    @Column(name="FIRST_NAME")
//    private String firstName;
//    @Column(name="LAST_NAME")
//    private String lastName;
//    @Column(name="MAIL")
//    private String mail;
//    @Column(name="ACCOUNT_IS_LOCKED")
//    private String accountIsLocked;
//    @Column(name="CHANGE_PASSWORD_ON_LOGIN")
//    private String changePasswordOnNextLogin;
//    @Column(name="PASSWORD_EXPIRY_DATE")    
//    private Timestamp passwordExpiryDate;
//    @Column(name="STATUS")    
//    private String status;
//
//    public CasDBUsers() {
//    }
//
//    public String getPasswd() {
//        return passwd;
//    }
//
//    public void setPasswd(String passwd) {
//        this.passwd = passwd;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Set<CasDBRoles> getCasRolesList() {
//        return casRolesSet;
//    }
//
//    public void setCasRolesSet(Set<CasDBRoles> casRolesSet) {
//        this.casRolesSet = casRolesSet;
//    }
//
//    public CasDBRoles addCasRoles(CasDBRoles casRoles) {
//        getCasRolesList().add(casRoles);
//        casRoles.setCasUsers(this);
//        casRoles.setUserName(this.getUsername());
//        return casRoles;
//    }
//
//    public CasDBRoles removeCasRoles(CasDBRoles casRoles) {
//        getCasRolesList().remove(casRoles);
//        casRoles.setCasUsers(null);
//        return casRoles;
//    }
//
//
//
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public boolean containsRole(String assignedMenuRole) {
//        for(CasDBRoles role:getCasRolesList()){
//           if(role.getRoleName().equals(assignedMenuRole) ){
//             return true;   
//           }
//        }        
//        return false;
//    }
//    
//    public Set<CasDBRoles> getMenuRolesSet() {
//        Set<CasDBRoles> menuRoles = new HashSet<CasDBRoles>();
//        if(casRolesSet == null){
//         //do nothing   
//        }else{
//            for(CasDBRoles role:casRolesSet){
//                if(role.isMenuRole()){
//                    menuRoles.add(role);
//                }else{
//                    //do nothing
//                }
//            }
//        }
//        return menuRoles;
//    }
//
//
//    public Set<CasDBRoles> getGroupRolesSet() {
//        Set<CasDBRoles> groupRoles = new HashSet<CasDBRoles>();
//        if(casRolesSet == null){
//         //do nothing   
//        }else{
//            for(CasDBRoles role:casRolesSet){
//                if(role.isGroupRole()){
//                    groupRoles.add(role);
//                }else{
//                    //do nothing
//                }
//            }
//        }
//        return groupRoles;
//    }
//
//    public CasUser getData() {
//        CasUser user = new CasUser();
//        user.setCasRolesList(new ArrayList<CasRole>());
//             for(CasDBRoles role:this.getCasRolesList()){
//               user.getCasRolesList().add(role.getData());   
//             }
//        user.setFirstName(this.getFirstName());
//        user.setLastName(this.getLastName());
//        user.setPasswd(this.getPasswd());
//        user.setUsername(this.getUsername());
//        user.setPasswordExpiryDate(DateHelper.getCalendar(this.getPasswordExpiryDate()));
//        user.setAccountIsLocked( null != this.getAccountIsLocked() && this.getAccountIsLocked().equals("T") ? true : false);
//        user.setChangePasswordOnNextLogin(null != this.getChangePasswordOnNextLogin() && this.getChangePasswordOnNextLogin().equals("T") ? true : false);
//        user.setStatus(this.getStatus());
//        return user;
//    }
//
//    public void setData(CasUser user) {
//      
//        this.setId(user.getId());
//        this.setPasswd(user.getPasswd());
//        this.setUsername(user.getUsername());
//        this.setFirstName(user.getFirstName());
//        this.setLastName(user.getLastName());
//        this.setAccountIsLocked( user.isAccountIsLocked() == false ? "F" : "T" );
//        this.setChangePasswordOnNextLogin(user.isChangePasswordOnNextLogin() == false ? "F" : "T");
//        this.setStatus(user.getStatus());
//        this.setPasswordExpiryDate(DateHelper.getSqlTimestamp(user.getPasswordExpiryDate()));
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setMail(String mail) {
//        this.mail = mail;
//    }
//
//    public String getMail() {
//        return mail;
//    }
//
//    public void setAccountIsLocked(String accountIsLocked) {
//        this.accountIsLocked = accountIsLocked;
//    }
//
//    public String getAccountIsLocked() {
//        return accountIsLocked;
//    }
//
//    public void setChangePasswordOnNextLogin(String changePasswordOnNextLogin) {
//        this.changePasswordOnNextLogin = changePasswordOnNextLogin;
//    }
//
//    public String getChangePasswordOnNextLogin() {
//        return changePasswordOnNextLogin;
//    }
//
//    public void setPasswordExpiryDate(Timestamp passwordExpiryDate) {
//        this.passwordExpiryDate = passwordExpiryDate;
//    }
//
//    public Timestamp getPasswordExpiryDate() {
//        return passwordExpiryDate;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//}
