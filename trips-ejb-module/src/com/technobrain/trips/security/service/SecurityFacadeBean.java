package com.technobrain.trips.security.service;

//package com.crownagents.trips.security.service;
//
//import com.crownagents.trips.common.constants.Constants;
//import com.crownagents.trips.identity.model.CasRole;
//import com.crownagents.trips.identity.model.CasUser;
//import com.crownagents.trips.identity.model.UserType;
//import com.crownagents.trips.security.model.CasSecRolePageRel;
//import com.crownagents.trips.security.model.WfisUserT;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import javax.ejb.EJB;
//import javax.ejb.Local;
//import javax.ejb.Remote;
//import javax.ejb.SessionContext;
//import javax.ejb.Stateless;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//
///**
// * ? Crown Agents 2008
// *
// * Security Factory
// *
// * @since	$Date: 8/18/2009 2:49:49 AM$
// * @version 	$Revision: 11$
// * @author 	$Author: Howard Hill$
// *
// * $Log[1]:
// *  11   TRIPS2 etis.bir.gov.ph1.9.1.0     8/18/2009 2:49:49 AM   Howard Hill
// *         update with core changes
// * $
// */
//// @EJBs( { 
//// @EJB(
////    name = "DBSecurityService/local", 
////    beanInterface = DBSecurityFacadeLocal.class, 
////    beanName = "DBSecurityService")
//// })
//
//@Stateless(name = "SecurityFacade",mappedName="SecurityFacade")
//@Local
//@Remote
//public class SecurityFacadeBean implements SecurityFacadeLocal, SecurityFacadeRemote{
//    
//    @PersistenceContext(unitName = "trips-ejb-module")
//    private EntityManager em;
//    
//    @Resource SessionContext sessionContext;
//    
//    @EJB
//    DBSecurityFacadeRemote dbSecurityFacadeRemote;
//    
//    
//    public SecurityFacadeBean() {
//    }
//
//    private CustomSecurityInterface getCustomSecurity(){
//    
//        String SECURITY_TYPE_KEY = Constants.Security.ORADB_SEC_TYPE;
//               
//        if(SECURITY_TYPE_KEY.equals(Constants.Security.ORADB_SEC_TYPE)){
////                return (CustomSecurityInterface)sessionContext.lookup(ServiceLocator.Services.DB_SECURITY_FACADE);
//            return (CustomSecurityInterface) dbSecurityFacadeRemote;
//        }else
//            if(SECURITY_TYPE_KEY.equals(Constants.Security.LDAP_SEC_TYPE)){
//                return (CustomSecurityInterface)sessionContext.lookup("LDAPSecurityService/local");
//            }
//            else
//                if(SECURITY_TYPE_KEY.equals(Constants.Security.JAZN_SEC_TYPE)){
//                   throw new IllegalAccessError("UnImplemented method"); 
//                }
//                
//        throw new IllegalAccessError("Security type " + SECURITY_TYPE_KEY + " not configured");  
//    }
//    
//    public CasUser createUser(CasUser user) {
//        return getCustomSecurity().createUser(user);
//    }
//
//    public CasUser assignMenuRolesForUser(CasUser casUser, 
//                                          String[] selectedMenuItems) {
//        return getCustomSecurity().assignMenuRolesForUser(casUser,selectedMenuItems);
//    }
//    
//    public CasUser saveFunctionalRolesForUser(CasUser user, 
//                                          String[] selectedFunctionalRoles) {
//        return getCustomSecurity().saveFunctionalRolesForUser(user,selectedFunctionalRoles);
//    }
//
//    public List<CasRole> findAllMenuRoles() {
//        return getCustomSecurity().findAllMenuRoles();
//    }
//
//    public List<CasRole> findAllGroupRoles() {
//        return getCustomSecurity().findAllGroupRoles();
//    }
//
//    public CasUser findCasUser(CasUser casUser) {
//        return getCustomSecurity().findCasUser(casUser);
//    }
//
//    public CasUser assignGroupRolesForUser(CasUser user, 
//                                           String[] selectedGroupItems) {
//        return getCustomSecurity().assignGroupRolesForUser(user,selectedGroupItems);
//    }
//
//    public List<CasUser> findAllUsers(UserType userType) {
//        return getCustomSecurity().findAllUsers(userType);
//    }
//
//    public CasUser updateUser(CasUser casUser) {
//        return getCustomSecurity().updateUser(casUser);
//    }
//
//    public boolean changePassword(CasUser casUser, String oldPassword, 
//                               String newPassword, boolean isAdministrator) {
//       return getCustomSecurity().changePassword(casUser,oldPassword,newPassword,isAdministrator);
//    }
//
//    public CasRole assignMenuRolesToGroup(CasRole role, 
//                                          String[] selectedMenuItems) {
//        return getCustomSecurity().assignMenuRolesToGroup(role,selectedMenuItems);
//        
//    }
//    
//    public CasRole findGroup(CasRole group) {
//        return getCustomSecurity().findGroup(group);
//    }
//
//    public CasRole createGroup(CasRole casRole) {
//        return getCustomSecurity().createGroup(casRole);
//    }
//
//    public CasRole updateGroup(CasRole casRole) {
//        return getCustomSecurity().updateGroup(casRole);
//    }
//
//    public List<CasRole> findGroupMembership(CasRole casRole) {
//        return getCustomSecurity().findGroupMembership(casRole);
//    }
//
//    public void assignGroupToBeMemberOf(CasRole casRole, 
//                                           String[] selectedMemberGroupItems) {
//        getCustomSecurity().assignGroupToBeMemberOf(casRole,selectedMemberGroupItems);
//    }
//
//    public List<String> findUsersInGroup(CasRole casRole) {
//        return getCustomSecurity().findUsersInGroup(casRole);
//    }
//
//    public List<CasRole> searchGroup(CasRole searchAbleGroup) {
//       return getCustomSecurity().searchGroup(searchAbleGroup);
//    }
//
//    public List<CasUser> searchUser(CasUser searchAbleUser) {
//        return getCustomSecurity().searchUser(searchAbleUser);
//    }
//
//    public String getPassword(String username) {
//        return getCustomSecurity().getPassword(username);
//    }
//    
//    public List<CasRole> findFunctionalRolesOfUser(CasUser casUser){
//        return getCustomSecurity().findFunctionalRolesOfUser(casUser);
//    }
//    
//    public List<CasUser> findUsersOfFunctionalRole(String functionalRole){
//        return getCustomSecurity().findUsersOfFunctionalRole(functionalRole);
//    }
//
//    public List findAllPermissionRoles(String permissionCatgeory) {
//        return getCustomSecurity().findAllPermissionRoles(permissionCatgeory);
//    }
//
//    public CasRole assignPermissionRolesToGroup(CasRole group, 
//                                                String[] selectedPermissionItems) {
//        return getCustomSecurity().assignPermissionRolesToGroup(group,selectedPermissionItems);
//    }
//
//    public void syncOfficeForUser(CasUser user, String[] office) {
//        getCustomSecurity().syncOfficeForUser(user,office);
//    }
//
//    public List<CasRole> filterRoles(List<CasRole> allRoles, 
//                                     String[] roleTypes) {
//        return getCustomSecurity().filterRoles(allRoles,roleTypes);
//    }
//
//    public List queryAssociatedRoles(String roleName, String policyType) {
//        return getCustomSecurity().queryAssociatedRoles(roleName,policyType);
//    }
//
//    public CasRole assignTaskRoles(CasRole group, String[] selectedTaskItems) {
//        return getCustomSecurity().assignTaskRoles(group,selectedTaskItems);
//    }
//	
//	public List<String> findRolesHavingUser(String username) {
//        return getCustomSecurity().findRolesHavingUser(username);
//    }
//
//	public List<WfisUserT> findAllLogedInUsers(String filter) {
//		return getCustomSecurity().findAllLogedInUsers(filter);
//	}
//	
//	public void userLogedIn(String username) {
//		getCustomSecurity().userLogedIn(username);
//	}
//
//	public void userLogedOut(String username) {
//		getCustomSecurity().userLogedOut(username);
//	}
//
//	public void kickUserOut(String username) {
//		getCustomSecurity().kickUserOut(username);
//	}
//
//	public boolean isUserKickedOut(String username) {
//		return getCustomSecurity().isUserKickedOut(username);
//	}
//	
//	public void restartAllUsersLoginStatus(){
//		getCustomSecurity().restartAllUsersLoginStatus();
//	}
//        
//    public List<CasSecRolePageRel> getPageRolesByPageURL(String pageURL){        
//        return getCustomSecurity().getPageRolesByPageURL(pageURL);
//    }
//    
//    public List<CasSecRolePageRel> getPageRolesByPageURLAndLoggedInUserRoles(String pageURL, String[] roles){
//        return getCustomSecurity().getPageRolesByPageURLAndLoggedInUserRoles(pageURL,roles);
//    }
//    
//    public List<String> getPageAccessList() {
//        return getCustomSecurity().getPageAccessList();
//    }
//    
//    public List<CasSecRolePageRel> getPageSecurityRolesRelByLoggedInUserRoles(String[] roles){
//        return getCustomSecurity().getPageSecurityRolesRelByLoggedInUserRoles(roles);
//    }
//}
