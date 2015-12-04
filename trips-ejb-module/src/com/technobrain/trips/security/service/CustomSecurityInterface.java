package com.technobrain.trips.security.service;

//package com.crownagents.trips.security.service;
//
//import com.crownagents.trips.identity.model.CasRole;
//import com.crownagents.trips.identity.model.CasUser;
//import com.crownagents.trips.identity.model.UserType;
//import com.crownagents.trips.reference.model.RefPermissionRole;
//import com.crownagents.trips.security.model.CasSecRolePageRel;
//import com.crownagents.trips.security.model.WfisUserT;
//
//import java.util.List;
//
//
///**
// * ? Crown Agents 2008
// *
// * Security Contract
// * 
// * @since	$Date: 8/18/2009 2:41:08 AM$
// * @version 	$Revision: 10$
// * @author 	$Author: Howard Hill$
// * 
// * $Log[1]:
// *  10   TRIPS2 etis.bir.gov.ph1.8.1.0     8/18/2009 2:41:08 AM   Howard Hill  
// *         update with core changes
// * $
// */
//public interface CustomSecurityInterface {
//
//    public CasUser createUser(CasUser user);
//
//    public CasUser assignMenuRolesForUser(CasUser casUser, 
//                                          String[] selectedMenuItems);
//
//    public List<CasRole> findAllMenuRoles();
//
//    public List<CasRole> findAllGroupRoles();
//
//    public CasUser findCasUser(CasUser casUser);
//
//    public CasUser assignGroupRolesForUser(CasUser user, 
//                                           String[] selectedGroupItems);
//
//
//    public List<CasUser> findAllUsers(UserType userType);
//
//    public CasUser updateUser(CasUser casUser);
//
//    public boolean changePassword(CasUser casUser, String oldPassword, 
//                               String newPassword, boolean isAdministrator);
//
//    public CasRole assignMenuRolesToGroup(CasRole role, 
//                                          String[] selectedMenuItems);
//
//    public CasRole findGroup(CasRole group) ;
//
//    public CasRole createGroup(CasRole casRole);
//
//    public CasRole updateGroup(CasRole casRole);
//
//    public List<CasRole> findGroupMembership(CasRole casRole);
//
//    public void assignGroupToBeMemberOf(CasRole casRole, 
//                                           String[] selectedMemberGroupItems);
//    
//    public CasUser saveFunctionalRolesForUser(CasUser casUser, 
//                                            String[] selectedFunctionalRoles);
//
//    public List<String> findUsersInGroup(CasRole casRole);
//
//    public List<CasRole> searchGroup(CasRole searchAbleGroup);
//
//    public List<CasUser> searchUser(CasUser searchAbleUser);
//
//    public String getPassword(String username);
//    
//    public List<CasRole> findFunctionalRolesOfUser(CasUser casUser);
//    
//    public List<CasUser> findUsersOfFunctionalRole(String functionalRole);
//
//    public List<RefPermissionRole> findAllPermissionRoles(String permissionCatgeory) ;
//
//    public CasRole assignPermissionRolesToGroup(CasRole group, 
//                                                String[] selectedPermissionItems);
//
//    public void syncOfficeForUser(CasUser user, String[] office);
//
//    public List<CasRole> filterRoles(List<CasRole> allRoles, 
//                                     String[] roleTypes);
//    
//    public List<CasRole> queryAssociatedRoles(String roleName, String policyType);
//
//    public CasRole assignTaskRoles(CasRole group, String[] selectedTaskItems) ;
//	
//	public List<String> findRolesHavingUser(String username);
//	
//	List<WfisUserT> findAllLogedInUsers(String filter);
//    
//    void userLogedIn(String username);
//    
//    void userLogedOut(String username);
//    
//    void kickUserOut(String username);
//    
//    boolean isUserKickedOut(String username);
//    
//    void restartAllUsersLoginStatus();
//    
//    public List<CasSecRolePageRel> getPageRolesByPageURL(String pageURL);
//    
//    public List<CasSecRolePageRel> getPageRolesByPageURLAndLoggedInUserRoles(String pageURL, String[] roles);
//    
//    public List<String> getPageAccessList();
//    
//    public List<CasSecRolePageRel> getPageSecurityRolesRelByLoggedInUserRoles(String[] roles);
//    
//}
