package com.technobrain.trips.security.service;

//package com.crownagents.trips.security.service;
//
//import com.crownagents.trips.identity.exceptions.RecordAlreadyExist;
//import com.crownagents.trips.identity.ldap.LDAPContext;
//import com.crownagents.trips.identity.ldap.dao.LDAPSecurityDAO;
//import com.crownagents.trips.identity.model.CasRole;
//import com.crownagents.trips.identity.model.CasUser;
//import com.crownagents.trips.identity.model.UserType;
//import com.crownagents.trips.reference.model.RefPermissionRole;
//import com.crownagents.trips.security.model.CasSecRolePageRel;
//import com.crownagents.trips.security.model.WfisUserT;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import javax.ejb.Local;
//import javax.ejb.SessionContext;
//import javax.ejb.Stateless;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.apache.log4j.Logger;
//
//
///**
// * ? Crown Agents 2008
// *
// * 
// * @since	$Date: 8/18/2009 2:45:41 AM$
// * @version 	$Revision: 9$
// * @author 	$Author: Howard Hill$
// * 
// * $Log[1]:
// *  9    TRIPS2 etis.bir.gov.ph1.7.1.0     8/18/2009 2:45:41 AM   Howard Hill  
// *         update with core changes
// * $
// */
//@Stateless(name = "LDAPSecurityService", mappedName = "test-Project1-LDAPSecurityFacadeBean")
//@Local
//public class LDAPSecurityFacadeBean implements LDAPSecurityFacadeLocal{
//    public static final Logger log = Logger.getLogger(LDAPSecurityFacadeBean.class);
//   
//    @PersistenceContext(unitName = "trips-ejb-module")
//    private EntityManager em;
//    
//    @Resource SessionContext sessionContext;
//    
//    public LDAPContext getLDAPContext(){
//        LDAPContext ldapContext = LDAPContext.getInstance();
//       
//        ldapContext.setLdapServer((String)sessionContext.lookup("oracle.security.jaas.ldap.provider.url"));
//        ldapContext.setLdapType("simple");
//        ldapContext.setLdapUser((String)sessionContext.lookup("oracle.security.jaas.ldap.provider.user"));
//        log.debug("password " + (String)sessionContext.lookup("oracle.security.jaas.ldap.provider.credential"));
//        ldapContext.setLdapPwd((String)sessionContext.lookup("oracle.security.jaas.ldap.provider.credential"));
//        ldapContext.setUserNameAttr((String)sessionContext.lookup("oracle.security.jaas.ldap.user.name.attribute"));
//        ldapContext.setRoleNameAttr((String)sessionContext.lookup("oracle.security.jaas.ldap.role.name.attribute"));
//        ldapContext.setMemberAttr((String)sessionContext.lookup("oracle.security.jaas.ldap.member.attribute"));
//        ldapContext.setUserSearchBase((String)sessionContext.lookup("oracle.security.jaas.ldap.user.searchbase"));
//        ldapContext.setRoleSearchBase((String)sessionContext.lookup("oracle.security.jaas.ldap.role.searchbase"));
//     
//        return ldapContext;
//    }
//
//    public LDAPSecurityFacadeBean() {
//    }
//
//    public CasUser assignMenuRolesForUser(CasUser casUser, 
//                                          String[] selectedMenuItems) {
//        return null;
//    }
//
//    public List<CasRole> findAllMenuRoles() {
//        return null;
//    }
//
//    public List<CasRole> findAllGroupRoles() {
//        return new LDAPSecurityDAO(getLDAPContext()).findAllGroups();
//    }
//
//    public CasUser findCasUser(CasUser casUser) {
//        return new LDAPSecurityDAO(getLDAPContext()).findUser(casUser);
//    }
//
//    public CasUser assignGroupRolesForUser(CasUser user, 
//                                           String[] selectedGroupItems) {
//        return new LDAPSecurityDAO(getLDAPContext()).assignGroupRolesToUser(user,selectedGroupItems);
//    }
//
//    public CasUser createUser(CasUser user) {
//        LDAPSecurityDAO dao = new LDAPSecurityDAO(getLDAPContext());
//        try {
//           user = dao.createUser(user);
//           dao.assignGroupRolesToUser(user,new String[]{"UserGroup"});
//        }
//        catch (RecordAlreadyExist e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        return user;
//    }
//
//    public List<CasRole> findAllGroupsRoles() {
//        return null;
//    }
//
//    public List<CasUser> findAllUsers(UserType userType) {
//        return new LDAPSecurityDAO(getLDAPContext()).findAllUserOfType(userType);
//    }
//
//    public CasUser updateUser(CasUser casUser) {
//        return new LDAPSecurityDAO(getLDAPContext()).updateUser(casUser);
//    }
//
//    public boolean changePassword(CasUser casUser, String oldPassword, 
//                               String newPassword, boolean isAdministrator) {
//       return  new LDAPSecurityDAO(getLDAPContext()).changePassword(casUser.getUsername(),oldPassword,newPassword,isAdministrator);
//    }
//
//    public CasRole assignMenuRolesToGroup(CasRole role, 
//                                          String[] selectedMenuItems) {
//        return  new LDAPSecurityDAO(getLDAPContext()).assignMenuRolesToGroup(role,selectedMenuItems);
//    }
//
//    public CasRole findGroup(CasRole group) {
//        return new LDAPSecurityDAO(getLDAPContext()).findGroup(group);
//    }
//
//    public CasRole createGroup(CasRole casRole) {
//        try {
//            return new LDAPSecurityDAO(getLDAPContext()).createGroup(casRole);
//        } catch (RecordAlreadyExist e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        return null;
//    }
//
//    public CasRole updateGroup(CasRole casRole) {
//        return new LDAPSecurityDAO(getLDAPContext()).updateGroup(casRole);
//    }
//
//    public List<CasRole> findGroupMembership(CasRole casRole) {
//        return new LDAPSecurityDAO(getLDAPContext()).findGroupsAssociatedWithGroup(casRole.getRoleName());
//    }
//
//    public void assignGroupToBeMemberOf(CasRole casRole, 
//                                           String[] selectedMemberGroupItems) {
//        new LDAPSecurityDAO(getLDAPContext()).assignGroupToBeMemberOfGroups(casRole,selectedMemberGroupItems);
//    }
//
//    public List<String> findUsersInGroup(CasRole casRole) {
//        return new LDAPSecurityDAO(getLDAPContext()).findUsersInGroup(casRole.getRoleName());
//    }
//
//    public List<CasRole> searchGroup(CasRole searchAbleGroup) {
//        return new LDAPSecurityDAO(getLDAPContext()).searchGroup(searchAbleGroup);
//    }
//
//    public List<CasUser> searchUser(CasUser searchAbleUser) {
//        return new LDAPSecurityDAO(getLDAPContext()).searchUser(searchAbleUser);
//    }
//
//    public String getPassword(String username) {
//        return null;
//    }
//
//
//    public CasUser saveFunctionalRolesForUser(CasUser casUser, 
//                                              String[] selectedFunctionalRoles) {
//        //TODO : Should be implemented
//        return null;
//    }
//
//    public List<CasRole> findFunctionalRolesOfUser(CasUser casUser) {
//        //TODO : Should be implemented
//        return null;
//    }
//
//    public List<CasUser> findUsersOfFunctionalRole(String functionalRole) {
//        //TODO : Should be implemented
//        return null;
//    }
//
//    public List<RefPermissionRole> findAllPermissionRoles(String category) {
//        return null;
//    }
//
//    public CasRole assignPermissionRolesToGroup(CasRole group, 
//                                                String[] selectedPermissionItems) {
//        return null;
//    }
//
//    public void syncOfficeForUser(CasUser user, String[] office) {
//        CasRole officeRole = new CasRole();        
//        officeRole.setRoleName(office[0]);
//        officeRole.setGroupRole(true);
//        if(null == this.findGroup(officeRole)){
//            this.createGroup(officeRole);
//        }
//    }
//
//    public List<CasRole> filterRoles(List<CasRole> allRoles, 
//                                     String[] roleTypes) {
//        return null;
//    }
//
//    public List queryAssociatedRoles(String roleName, String policyType) {
//        return null;
//    }
//
//    public CasRole assignTaskRoles(CasRole group, String[] selectedTaskItems) {
//        return null;
//    }
//	
//	public List<String> findRolesHavingUser(String username) {
//        //TODO : Should be implemented
//        return null;
//    }
//
//	public List<WfisUserT> findAllLogedInUsers(String filter) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void userLogedIn(String username) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void userLogedOut(String username) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void kickUserOut(String username) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public boolean isUserKickedOut(String username) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//	public void restartAllUsersLoginStatus(){
//		
//	}
//        
//    public List<CasSecRolePageRel> getPageRolesByPageURL(String pageURL){        
//        return null;
//    }
//    
//    public List<CasSecRolePageRel> getPageRolesByPageURLAndLoggedInUserRoles(String pageURL, String[] roles){
//        return null;
//    }
//    
//    public List<String> getPageAccessList(){
//        return null;
//    }
//    
//    public List<CasSecRolePageRel> getPageSecurityRolesRelByLoggedInUserRoles(String[] roles) {
//        return null;
//    }
//}
