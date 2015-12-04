package com.technobrain.trips.security.service;

//package com.crownagents.trips.security.service;
//
//import com.crownagents.trips.common.constants.Constants;
//import com.crownagents.trips.common.helpers.DateHelper;
//import com.crownagents.trips.core.service.FacadeBean;
//import com.crownagents.trips.identity.model.CasRole;
//import com.crownagents.trips.identity.model.CasUser;
//import com.crownagents.trips.identity.model.UserType;
//import com.crownagents.trips.login.Encryptor;
//import com.crownagents.trips.reference.model.RefPermissionRole;
//import com.crownagents.trips.reference.service.ReferenceFacadeLocal;
//import com.crownagents.trips.security.model.CasDBMenu;
//import com.crownagents.trips.security.model.CasSecRolePageRel;
//import com.crownagents.trips.security.model.SysUserLogin;
//import com.crownagents.trips.security.model.WfisGroupCategoryT;
//import com.crownagents.trips.security.model.WfisPolicyT;
//import com.crownagents.trips.security.model.WfisRoleT;
//import com.crownagents.trips.security.model.WfisRoleTPK;
//import com.crownagents.trips.security.model.WfisUserT;
//import com.crownagents.trips.security.model.WfisUserTPK;
//import com.crownagents.trips.security.model.WfisUserpassT;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Vector;
//
//import javax.ejb.EJB;
//import javax.ejb.Local;
//import javax.ejb.Remote;
//import javax.ejb.Stateless;
//
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//
//import org.apache.commons.lang.StringUtils;
//
//
///**
// * ? Crown Agents 2008
// *
// *
// * @since	$Date: 12/18/2009 7:35:12 PM$
// * @version 	$Revision: 16$
// * @author 	$Author: Howard Hill$
// *
// * $Log[10]:
// *  16   TRIPS2 etis.bir.gov.ph1.13.1.1    12/18/2009 7:35:12 PM  Howard Hill
// *         updated as per merge with Registration UAT branch dec 19
// *  15   TRIPS2 etis.bir.gov.ph1.13.1.0    8/18/2009 2:42:21 AM   Howard Hill
// *         update with core changes
// *  14   TRIPS2    1.13        7/14/2009 2:39:07 AM   Howard Hill     removed
// *       teh set permission role
// *  13   TRIPS2    1.12        7/14/2009 1:49:24 AM   Howard Hill     commented
// *       out policy type
// *  12   TRIPS2    1.11        7/14/2009 1:29:13 AM   Howard Hill     removed
// *       the object not found exception
// *  11   TRIPS2    1.10        3/20/2009 10:33:06 AM  Idris Yildiz    Changes
// *       for Functional Role update
// *  10   TRIPS2    1.9         3/20/2009 2:54:48 AM   Idris Yildiz
// *       functional role addition changes
// *  9    TRIPS2    1.8         1/21/2009 6:35:20 AM   Howard Hill     updated
// *       change password method to validate old password for user
// *  8    TRIPS2    1.7         10/30/2008 9:05:16 AM  Martin Spiers   Set the ?
// *       symbol
// *  7    TRIPS2    1.6         7/3/2008 5:09:00 AM    Howard Hill     added
// *       enhance to allow searching via a group name or its description
// * $
// */
//@Stateless(name = "DBSecurityFacade",mappedName="DBSecurityFacade")
//@Local
//@Remote
//public class DBSecurityFacadeBean extends FacadeBean implements DBSecurityFacadeLocal, DBSecurityFacadeRemote {
//      
//    @PersistenceContext(unitName = "trips-ejb-module")
//    private EntityManager em;
//    
//    @EJB(name = "ReferenceFacade",mappedName="ReferenceFacade")
//    ReferenceFacadeLocal refFacade;
//    
//    private static final String DEFAULT_REALM = "default";
//    
//    public DBSecurityFacadeBean(){
//        
//    }
//    
//    public CasUser assignMenuRolesForUser(CasUser casUserDTO, 
//                                       String[] selectedMenuItems){
//        return null;
//    }
//    //ok
//    public List<CasRole> findAllMenuRoles(){
//        List<CasDBMenu> allRoles = 
//         em.createNamedQuery("CasDBMenu.findAll").getResultList();
//        
//        List<CasRole> roles = new ArrayList(allRoles.size());
//        CasRole casRole = null;
//        for(CasDBMenu casMenu:allRoles){
//            casRole = new CasRole();
//            casRole.setRoleName(casMenu.getId());
//            casRole.setDescription(casMenu.getDescription());
//            casRole.setMenuRole(true);
//            roles.add(casRole);
//        }
//        return roles;
//    }
//
//    //ok
//    public CasUser findCasUser(CasUser casUser) {
//        try {
//          WfisUserT user = (((WfisUserT)em.createQuery("select user from WfisUserT user where upper(user.name) = ?1")
//            .setParameter(1,casUser.getUsername().toUpperCase()).getSingleResult()));
//
//            casUser = user.getData();
//            
//            //Find roles of the user
//            casUser.setCasRolesList(new ArrayList<CasRole>());
//            Iterator i = user.getWfisPolicyTList().iterator();
//             while(i.hasNext()){
//                WfisPolicyT policy = (WfisPolicyT)i.next();
//                WfisRoleTPK pk = new WfisRoleTPK(policy.getRole(),DEFAULT_REALM);
//                WfisRoleT wfisRoleT = em.find(WfisRoleT.class,pk);
//                if(null != wfisRoleT){
//                    casUser.getCasRolesList().add(wfisRoleT.getData());
//                }
//             }
//             
//             //find functional roles of the user
//             List<CasRole> funcRoles = findFunctionalRolesOfUser(casUser);
//             casUser.setFunctionalRoles(funcRoles);
//            try{ 
//            List<SysUserLogin> sysUserLogins = em.
//                createQuery("select sul from SysUserLogin sul where sul.userid = ?1 and sul.status = 'L'")
//                .setParameter(1,casUser.getUsername()).getResultList();
//                if(null !=sysUserLogins && !sysUserLogins.isEmpty() ){
//                    casUser.setAccountIsLocked(true);
//                }
//            }catch (NoResultException e) {
//                return null;
//            }    
//             return casUser;    
//        }
//        catch (NoResultException e) {
//            return null;
//        }
//
//    }
//
//    private List<WfisPolicyT> findFunctionalPolicyOfUser(CasUser casUser){
//        List<WfisPolicyT> wfisPolicyTs = null;
//        try {
//            wfisPolicyTs = em.createQuery(
//               "select p from WfisPolicyT p where p.isFunctionalRole ='Y' and p.wfisUserT.name = ?1")
//              .setParameter(1,casUser.getUsername())
//              .getResultList();
//        }
//        catch (NoResultException e) {
//            wfisPolicyTs = new ArrayList<WfisPolicyT>();
//        }
//        
//        return wfisPolicyTs;
//    }
//    
//    public List<CasRole> findFunctionalRolesOfUser(CasUser casUser){
//
//         List<WfisPolicyT> wfisPolicyTs = findFunctionalPolicyOfUser(casUser);
//         
//         List<CasRole> funcRolesOfUser = new ArrayList<CasRole>();
//         for(WfisPolicyT wfisPolicyT : wfisPolicyTs){
//             CasRole role = new CasRole();
//             role.setRoleName(wfisPolicyT.getRole());
//             role.setIsFunctionalRole(true);
//             
//             funcRolesOfUser.add(role);
//         }
//         
//         return funcRolesOfUser;
//         
//    }
//
//    public List<CasUser> findUsersOfFunctionalRole(String functionalRole){
//
//        List<WfisUserT> usersOfFunctionalRole = null;
//        try {
//            usersOfFunctionalRole = em.createQuery(
//               "select wpt.wfisUserT from WfisPolicyT wpt " +
//               "where wpt.isFunctionalRole ='Y' and wpt.role=?1")
//              .setParameter(1,functionalRole)
//              .getResultList();
//        }
//        catch (NoResultException e) {
//            usersOfFunctionalRole = new ArrayList<WfisUserT>();
//        }
//        
//        //Wrap data in DTO
//        List<CasUser> wrappedUsers = new ArrayList<CasUser>();
//        for(WfisUserT userOfFunctionalRole : usersOfFunctionalRole){
//            wrappedUsers.add(userOfFunctionalRole.getData());
//        }
//        
//        return wrappedUsers;
//        
//    }
//
//    public CasUser assignGroupRolesForUser(CasUser casUserDTO, 
//                                            String[] selectedGroupItems) {
//        
//        WfisUserT casUser = null;
//        
//        if(null == casUserDTO){
//         throw new IllegalAccessError();
//        }else{
//            WfisUserTPK  wfisUserTPK = 
//                new WfisUserTPK(casUserDTO.getUsername(),DEFAULT_REALM);
//            casUser = em.find(WfisUserT.class,wfisUserTPK);
//        }
//        
//        List<String> assignedGroupRoles = Arrays.asList(selectedGroupItems);
//        
//         
//         /*
//          * Deletes any existing role that does'nt exist in the assigned Menu Roles
//          */        
//         List<WfisPolicyT> clone = new ArrayList(casUser.getWfisPolicyTList());
//         for (WfisPolicyT existingGroupRole: clone){
//            if(assignedGroupRoles.contains(existingGroupRole.getRole())){
//                continue;
//            }else{
//                WfisPolicyT deletedRole =  casUser.removeWfisPolicyT(existingGroupRole);
//                em.remove(deletedRole);
//            }
//         }
//         
//         /*
//          * Adds the assigned Group Roles to the user role set
//          */
//         for (String assignedGroupRole: assignedGroupRoles){
//            if(casUser.hasRole(assignedGroupRole)){
//                 continue;
//            }else{
//               WfisPolicyT newAssignedRole = new WfisPolicyT();
//               newAssignedRole.setRole(assignedGroupRole);
//                casUser.addWfisPolicyT(newAssignedRole);
//               em.persist(newAssignedRole);
//            }
//         }
//        
//        casUser = em.merge(casUser);
//        return findCasUser(casUser.getData());
//    }
//
//    public CasUser saveFunctionalRolesForUser(CasUser casUser, String[] selectedFunctionalRoles) {
//        
//        WfisUserT wfisUserT = null;
//        
//        if(null == casUser){
//         throw new IllegalAccessError();
//        }else{
//            WfisUserTPK  wfisUserTPK = 
//                new WfisUserTPK(casUser.getUsername(),DEFAULT_REALM);
//            wfisUserT = em.find(WfisUserT.class,wfisUserTPK);
//        }
//        
//        List<String> assignedFunctionalRoles = Arrays.asList(selectedFunctionalRoles);
//        
//         /*
//          * Deletes any existing role that does'nt exist in the assigned Menu Roles
//          */        
//         List<WfisPolicyT> clone = findFunctionalPolicyOfUser(casUser);
//         for (WfisPolicyT existingGroupRole: clone){
//            if(assignedFunctionalRoles.contains(existingGroupRole.getRole())){
//                continue;
//            }else{
//                WfisPolicyT deletedRole =  wfisUserT.removeWfisPolicyT(existingGroupRole);
//                em.remove(deletedRole);
//            }
//         }
//         
//         /*
//          * Adds the assigned Group Roles to the user role set
//          */
//         for (String assignedFunctionalRole: assignedFunctionalRoles){
//            if(wfisUserT.hasRole(assignedFunctionalRole)){
//                 continue;
//            }else{
//               WfisPolicyT newAssignedRole = new WfisPolicyT();
//               newAssignedRole.setRole(assignedFunctionalRole);
//               newAssignedRole.setIsFunctionalRole("Y");
//               wfisUserT.addWfisPolicyT(newAssignedRole);
//               em.persist(newAssignedRole);
//            }
//         }
//        
//        wfisUserT = em.merge(wfisUserT);
//        return wfisUserT.getData();
//    }
//
//    public CasUser createUser(CasUser user) {
//        WfisUserT newUser = new WfisUserT();
//        newUser.setRealm(DEFAULT_REALM);
//        user.setStatus(Constants.RecordStatus.ACTIVE);
//        if(user.getAccessLevel() == null){
//            user.setAccessLevel("1");  
//        }
//        newUser.setData(user);        
//        String password = new Encryptor().digest(user.getPasswd(),Encryptor.SHA1);
//        WfisUserpassT pass = new WfisUserpassT();
//        pass.setPass(password);
//        pass.setPasswordExpiryDate(DateHelper.getSqlTimestamp(user.getPasswordExpiryDate()));
//        pass.setName(newUser.getName());
//        pass.setRealm(DEFAULT_REALM);
//        pass.setWfisUserT(newUser);
//        newUser.setWfisUserpassT(pass);
//        em.persist(newUser);
//        em.persist(pass);
//        em.flush();
//        
//        user = assignGroupRolesForUser(user,new String[]{"UserGroup"});
//        
//        CasRole role = new CasRole();
//        role.setRoleName("UserGroup");
//        role = findGroup(role);
//        user.setCasRolesList(new ArrayList<CasRole>(1));
//        user.getCasRolesList().add(role);
//        return newUser.getData();
//    }
//
//    public List<CasRole> findAllGroupRoles() {
//        List<WfisRoleT> groups = null;
//        
//         try {
//             groups = em.createNamedQuery("WfisRoleT.findAllGroups").getResultList();
//         }
//         catch (NoResultException e) {
//             return new ArrayList<CasRole>();
//         }
//        
//        List<CasRole> roles = new ArrayList<CasRole>(groups.size());
//        CasRole role = null;
//        for(WfisRoleT group:groups){         
//            role = new CasRole();
//            role.setGroupRole(true); 
//            role.setMenuRole(false);
//            role.setRoleName(group.getName());
//            role.setDescription(group.getDescription());
//            roles.add(role);
//        }
//        
//        return roles;
//    }
//
//    public List<CasUser> findAllUsers(UserType userType) {
//        List<WfisUserT> casDBUser = null;
//        List<CasUser> casUsers = null;
//        try {
//            casDBUser = em.createQuery("select user from WfisUserT user where user.status = ?1").
//            setParameter(1,Constants.RecordStatus.ACTIVE).getResultList();
//        } catch (NoResultException e) {
//            return null;
//        }
//        
//        casUsers = new ArrayList<CasUser>(casDBUser.size());
//        CasUser user = null;
//        for(WfisUserT dbUser: casDBUser){
//            user = new CasUser();
//            user.setUsername(dbUser.getName());
//            user.setFirstName(dbUser.getFirstname());
//            user.setLastName(dbUser.getLastname());
//            user.setStatus(dbUser.getStatus());
//            casUsers.add(user);
//        }
//        return casUsers;
//    }
//
//    public CasUser updateUser(CasUser casUser ) {
//       try{
//          WfisUserT dbUser = ((WfisUserT)em.createQuery("select user from WfisUserT user where user.name = ?1")
//            .setParameter(1,casUser.getUsername()).getSingleResult());
//            log.debug("is this the login place2***************************");
//            dbUser.setData(casUser);
//            CasUser data = em.merge(dbUser).getData();
//            
//            if(!casUser.isAccountIsLocked()){
//                try{
//                List<SysUserLogin> sysUserLogins = (List<SysUserLogin>)em.
//                    createQuery("select sul from SysUserLogin sul where sul.userid = ?1 and sul.status = 'L'")
//                    .setParameter(1,casUser.getUsername()).getResultList();
//                for(SysUserLogin sysUserLogin:sysUserLogins){
//                    sysUserLogin.setStatus("A");
//                    em.merge(sysUserLogin);   
//                }
//               
//                }catch (NoResultException e) {
//                  //  return null;
//                }
//            
//            }
//            return data;
//        }
//        catch (NoResultException e) {
//            return null;
//        }
//    }
//
//    public boolean changePassword(CasUser casUser, String oldPassword, 
//                               String newPassword,boolean isAdministrator) {
//        
//        if(!isAdministrator){
//            if(oldPassword == null || newPassword == null){
//                return false;
//            }else{
//                if(oldPassword.equals(newPassword)){
//                    return false;
//                }else{
//                    String newPass = new Encryptor().digest(newPassword,Encryptor.SHA);
//                    String oldPass = getPassword(casUser.getUsername());
//                    int compared = newPass.compareTo(oldPass);
//                    if(0 == compared){ //pass are same                       
//                        return false;
//                    }else{
//                        //do nothing
//                    }
//                }
//            }
//        }
//        try{
//            Calendar passwordExpiryDate = Calendar.getInstance();
////            int days = Integer.parseInt(refFacade.getSystemParameter("PASSWORD_EXPIRY_DAYS"));
//            int days = 1000;
//            passwordExpiryDate = DateHelper.addDays(passwordExpiryDate,days);
//            
//            WfisUserpassT dbUserPassword = ((WfisUserpassT)em.createQuery("select user from WfisUserpassT user where user.name = ?1")
//              .setParameter(1,casUser.getUsername()).getSingleResult());            
//            dbUserPassword.setPass(new Encryptor().digest(newPassword,Encryptor.SHA1));  
//            dbUserPassword.setPasswordExpiryDate(DateHelper.getSqlTimestamp(passwordExpiryDate));
//            casUser.setPasswordExpiryDate(passwordExpiryDate);
//            return true;
//        }catch (NoResultException e) {
//            return false;
//        }
//        
//    }
//
//    public CasRole assignMenuRolesToGroup(CasRole role, 
//                                          String[] selectedMenuItems) {
//       
//        List<WfisPolicyT> menuRoles = null;
//        try {
//            menuRoles = em.createQuery("select p from WfisPolicyT p where p.isMenu ='Y' and p.group.name = ?1")
//              .setParameter(1,role.getRoleName()).getResultList();
//        }
//        catch (NoResultException e) {
//            menuRoles = new ArrayList<WfisPolicyT>();
//        }
//        
//        List<String> assignedMenuRoles = Arrays.asList(selectedMenuItems);
//        
//        /*
//         * Deletes any existing role that does'nt exist in the assigned Menu Roles
//         */        
//        Iterator i = menuRoles.iterator();
//        while (i.hasNext()){
//           WfisPolicyT existingMenuRole = (WfisPolicyT)i.next();
//           if(assignedMenuRoles.contains(existingMenuRole.getRole())){
//               continue;
//           }else{
//               em.remove(existingMenuRole);
//               i.remove();
//           }
//        }
//       
//        WfisRoleTPK pk = new WfisRoleTPK(role.getRoleName(),DEFAULT_REALM); 
//       WfisRoleT memberGroup = em.find(WfisRoleT.class,pk);
//        /*
//         * Adds the assigned menu Roles to the group
//         */
//        for (String assignedMenuRole: assignedMenuRoles){
//           if(containsRole(menuRoles,assignedMenuRole)){
//                continue;
//           }else{
//              WfisPolicyT newAssignedRole = new WfisPolicyT();
//               newAssignedRole.setRole(assignedMenuRole);
//               newAssignedRole.setGroup(memberGroup);
//               newAssignedRole.setIsMenu(Constants.YES);
//              em.persist(newAssignedRole);
//           }
//        }
//        
//        
//        List<CasRole> casMenuRoles = new ArrayList<CasRole>();
//        CasRole casRole = null;
//        for(String assignMenu:assignedMenuRoles){
//            casRole = new CasRole();
//            casRole.setRoleName(assignMenu);
//            casRole.setDescription(findCasDBMenuDescription(assignMenu));
//            casRole.setMenuRole(true);
//            casMenuRoles.add(casRole);
//        }
//        /*
//         * Existing roles
//         */
//        for(WfisPolicyT casDBRole:menuRoles){
//            casRole = new CasRole();
//            casRole.setRoleName(casDBRole.getRole());
//            casRole.setDescription(findCasDBMenuDescription(casDBRole.getRole()));
//            casRole.setMenuRole(true);
//            casMenuRoles.add(casRole);
//        }
//        role.setMenuRoles(casMenuRoles);
//        return role;
//    }
//    
//    public boolean containsRole(List<WfisPolicyT> roles, String role){
//        for(WfisPolicyT p:roles){
//           if( p.getRole().equals(role)){
//               return true;
//           }
//        }
//        return false;
//    }
//    public CasRole findGroup(CasRole group) {
//        try{
//           if(null == group){
//               return null;
//           }
//            
//            try{
//                WfisRoleTPK pk = new WfisRoleTPK(group.getRoleName(),DEFAULT_REALM);
//                WfisRoleT dbGroup = em.find(WfisRoleT.class,pk);
//                if(dbGroup == null){
//                    return null;
//                }else{
//                    CasRole casRole =  dbGroup.getData();
//                    
//                    //casRole.setPermissionRoles(queryAssociatedRoles(group.getRoleName(),"PERMISSION"));
//                    casRole.setMenuRoles(queryAssociatedRoles(group.getRoleName(),"MENU"));
//                    casRole.setGroupCategories(group.getGroupCategories());
//                    return casRole;
//                }
//            }catch (NoResultException e) {
//                return null;
//            }
//
//           
//        }catch (NoResultException e) {
//            return null;
//        }
//
//    }
//
//    public CasRole createGroup(CasRole casRole) {
//        WfisRoleT dbGroup = new WfisRoleT();
//        List<String> assignedGroupCategories = null;
//            if(casRole.getGroupCategories()!=null && casRole.getGroupCategories().length>0){
//                assignedGroupCategories = Arrays.asList(casRole.getGroupCategories());    
//            }
//        casRole.setStatus(Constants.RecordStatus.ACTIVE);
//        dbGroup.setData(casRole);
//        
//        if(assignedGroupCategories!=null){
//            for(String groupCategory : assignedGroupCategories){
//                WfisGroupCategoryT wfisGroupCategory = new WfisGroupCategoryT();
//                wfisGroupCategory.setCategory(groupCategory);
//                wfisGroupCategory.setGroupName(casRole.getRoleName());
//                wfisGroupCategory.setRealm("default");
//                if(dbGroup.getWfisGroupCategoryT()==null){
//                    dbGroup.setWfisGroupCategoryT(new ArrayList<WfisGroupCategoryT>());
//                }
//                dbGroup.addWfisGroupCategoryT(wfisGroupCategory);
//            }    
//        }
//        
//        em.persist(dbGroup);
//        return casRole;
//    }
//
//    public CasRole updateGroup(CasRole casRole) {
//        try
//        {
//            WfisRoleTPK pk = new WfisRoleTPK(casRole.getRoleName(),DEFAULT_REALM);
//            List<String> assignedGroupCategories = null;
//                if(casRole.getGroupCategories()!=null && casRole.getGroupCategories().length>0){
//                    assignedGroupCategories = Arrays.asList(casRole.getGroupCategories());    
//                }
//            
//            WfisRoleT dbGroup = em.find(WfisRoleT.class,pk);
//            dbGroup.setData(casRole);
//            
//            /*
//             * Removes existing group categories which aren't selected from the screen
//             */        
//            List<WfisGroupCategoryT> clone = new ArrayList(dbGroup.getWfisGroupCategoryT());
//            for (WfisGroupCategoryT existingGroupCategory: clone){
//               if(assignedGroupCategories!=null && 
//                        assignedGroupCategories.contains(existingGroupCategory.getCategory())){
//                   continue;
//               }else{
//                   WfisGroupCategoryT categoryToDelete =  dbGroup.removeWfisGroupCategoryT(existingGroupCategory);
//                   em.remove(categoryToDelete);
//               }
//            }
//            
//            if(assignedGroupCategories!=null){
//                for(String groupCategory : assignedGroupCategories){
//                    if(dbGroup.isGroupCategoryExisting(groupCategory)){
//                        continue;
//                    } else {
//                        WfisGroupCategoryT wfisGroupCategory = new WfisGroupCategoryT();
//                        wfisGroupCategory.setCategory(groupCategory);
//                        wfisGroupCategory.setGroupName(casRole.getRoleName());
//                        wfisGroupCategory.setRealm("default");
//                        if(dbGroup.getWfisGroupCategoryT()==null){
//                            dbGroup.setWfisGroupCategoryT(new ArrayList<WfisGroupCategoryT>());
//                        }
//                        dbGroup.addWfisGroupCategoryT(wfisGroupCategory);    
//                    }
//                }    
//            }
//            
//            em.merge(dbGroup);
//            return casRole;
//        }catch (NoResultException e) {
//            return null;
//        }
//        
//    }
//
//    public List<CasRole> findGroupMembership(CasRole casRole) {
//        List<CasRole> membership = new ArrayList<CasRole>();
//        List<WfisPolicyT> dbRoles = em.createQuery("select p from WfisPolicyT p where p.group.name = ?1 and p.isMenu is null order by p.role")
//          .setParameter(1,casRole.getRoleName()).getResultList();
//        
//        CasRole aRole = null;
//        for(WfisPolicyT dbRole:dbRoles){
//            WfisRoleTPK pk = new WfisRoleTPK(dbRole.getRole(),DEFAULT_REALM);
//            WfisRoleT wfisRoleT = em.find(WfisRoleT.class,pk);
//            if(null != wfisRoleT && wfisRoleT.isGroupRole()){
//                aRole = wfisRoleT.getData();
//                if(!membership.contains(aRole)){
//                    membership.add(aRole);
//                    //findAddGroupMembership(casRole,membership);   
//                }
//            }
//        }
//                
//        return membership;
//    }
//
//    public void assignGroupToBeMemberOf(CasRole _casRole, 
//                                           String[] selectedMemberGroupItems) {
//        List<WfisPolicyT> groupRoles = null;
//        try {
//            groupRoles = em.createQuery("select role from WfisPolicyT role where role.groupMember = ?1 and role.isMenu is null " +
//            "and role.policyType <> ?2 and role.policyType <> ?3 and role.policyType <> ?4 ")
//              .setParameter(1,_casRole.getRoleName())
//              .setParameter(2,Constants.RoleType.TASKS)
//              .setParameter(3,Constants.RoleType.OFFICE)
//              .setParameter(4,Constants.RoleType.PERMISSION).getResultList();
//        }
//        catch (NoResultException e) {
//            groupRoles = new ArrayList<WfisPolicyT>();
//        }
//        
//        List<String> assignedGroupRoles = Arrays.asList(selectedMemberGroupItems);
//        
//        /*
//         * Deletes any existing role that does'nt exist in the assigned Group Roles
//         */        
//        Iterator i = groupRoles.iterator();
//        while (i.hasNext()){
//           WfisPolicyT existingGroupRole = (WfisPolicyT)i.next();
//           if(assignedGroupRoles.contains(existingGroupRole.getRole())){
//               continue;
//           }else{
//               em.remove(existingGroupRole);
//               i.remove();
//           }
//        }
//        
//        /*
//         * Adds the assigned group Roles to the group
//         */
//        for (String assignedGroupRole: assignedGroupRoles){
//           if(containsRole(groupRoles,assignedGroupRole)){
//                continue;
//           }else{
//              WfisPolicyT newAssignedRole = new WfisPolicyT();
//               newAssignedRole.setRealm(DEFAULT_REALM);
//              newAssignedRole.setGroupMember(_casRole.getRoleName());
//              newAssignedRole.setRole(assignedGroupRole);
//              em.persist(newAssignedRole);
//              
//           }
//        }
//        
//       
//        
//    }
//
//    public List<String> findUsersInGroup(CasRole casRole) {
//        List<String> usernames = em.createQuery("select p.wfisUserT.name from WfisPolicyT p where p.role = ?1 and p.isMenu is null")
//          .setParameter(1,casRole.getRoleName()).getResultList();
//        
//        return usernames;
//    }
//    
//    private void findAddGroupMembership(CasRole casRole, 
//                                        List<CasRole> memberRoles) {
//        
//        
//        List<WfisPolicyT> dbRoles = em.createQuery("select p from WfisPolicyT p where p.role = ?1 and p.group is not null and p.isMenu is null")
//          .setParameter(1,casRole.getRoleName()).getResultList();
//        CasRole aRole = null;
//        for(WfisPolicyT dbRole:dbRoles){
//            if(null != dbRole.getGroup()){
//                aRole = dbRole.getGroup().getData();
//                if(dbRole.getGroup().isGroupRole()){
//                    memberRoles.add(aRole);  
//                }      
//            }
//        }
//    }
//
//    private String findCasDBMenuDescription(final String assignMenu) {
//      try {
//          return (String)em.createQuery("select menu.description from CasDBMenu menu where menu.id = ?1")
//              .setParameter(1,assignMenu).getSingleResult();
//      }
//      catch (NoResultException e) {
//          return null;
//      }
//    }
//    
//    
//    public List<CasRole> searchGroup(CasRole searchAbleGroup) {
//        List<WfisRoleT> casDBGroup = null;
//        List<CasRole> casRoles = null;
//        try {
//            Query query = null;
//            if(null != searchAbleGroup.getRoleName()){
//                query = em.createQuery("select grp from WfisRoleT grp where grp.isgroup = 'Y' and UPPER(grp.displayname) like ?1");
//                query.setParameter(1, 
//                            searchAbleGroup.getRoleName().toUpperCase());
//            }else if(null != searchAbleGroup.getDescription()){
//                query = em.createQuery("select grp from WfisRoleT grp where grp.isgroup = 'Y' and UPPER(grp.description) like ?1");
//                query.setParameter(1, 
//                          searchAbleGroup.getDescription().toUpperCase());
//            }else{
//                    return null;
//            }
//            casDBGroup = query.getResultList();
//        } catch (NoResultException e) {
//                return null;
//        }
//        casRoles = new ArrayList<CasRole>(casDBGroup.size());
//        CasRole role = null;
//        for(WfisRoleT dbGroup: casDBGroup){
//            role = new CasRole();
//            String[] groupCategories = null;
//            role.setRoleName(dbGroup.getName());
//            role.setDescription(dbGroup.getDescription());
//            role.setStatus(dbGroup.getStatus());
//            if(dbGroup.getWfisGroupCategoryT()!=null && dbGroup.getWfisGroupCategoryT().size()>0){
//                groupCategories = new String[dbGroup.getWfisGroupCategoryT().size()];
//                for(int i=0;i<dbGroup.getWfisGroupCategoryT().size();i++){
//                    groupCategories[i]=dbGroup.getWfisGroupCategoryT().get(i).getCategory();
//                }
//            }
//            role.setGroupCategories(groupCategories);
//            casRoles.add(role);
//        }
//        return casRoles;
//    }
//
//    public List<CasUser> searchUser(CasUser searchAbleUser) {
//        List<WfisUserT> casDBUser = null;
//        List<CasUser> casUsers = null;
//        try {
//            casDBUser = em.createQuery("select user from WfisUserT user where upper(user.name) like ?1").
//            setParameter(1, 
//                        searchAbleUser.getUsername().toUpperCase()).getResultList();
//        } catch (NoResultException e) {
//            return null;
//        }
//        
//        casUsers = new ArrayList<CasUser>(casDBUser.size());
//        CasUser user = null;
//        for(WfisUserT dbUser: casDBUser){
//            user = new CasUser();
//            user.setUsername(dbUser.getName());
//            user.setFirstName(dbUser.getFirstname());
//            user.setLastName(dbUser.getLastname());
//            user.setStatus(dbUser.getStatus());
//            casUsers.add(user);
//        }
//        return casUsers;
//    }
//
//    public String getPassword(String username) {
//        WfisUserpassT dbUserPassword = ((WfisUserpassT)em.createQuery("select user from WfisUserpassT user where Upper(user.name) = ?1")
//          .setParameter(1,username.toUpperCase()).getSingleResult());       
//          
//        return dbUserPassword.getPass();
//    }
//    
//    public List<RefPermissionRole> findAllPermissionRoles(String permissionCatgeory) {
//        List<RefPermissionRole> roles = null;
//        try {
//            roles = em.createQuery("select p from RefPermissionRole p where p.status = ?1 and p.category.code = ?2")
//              .setParameter(1,Constants.RecordStatus.ACTIVE)
//              .setParameter(2,permissionCatgeory).getResultList();
//        }
//        catch (NoResultException e) {
//            roles = new ArrayList<RefPermissionRole>();
//        }
//        
//        return roles;
//    }
//
//    public CasRole assignPermissionRolesToGroup(CasRole role, 
//                                                String[] selectedPermissionItems) {
//      
//        List<WfisPolicyT> menuRoles = null;
//        try {
//            menuRoles = em.createQuery("select p from WfisPolicyT p where p.policyType ='PERMISSION' and p.group.name = ?1")
//              .setParameter(1,role.getRoleName()).getResultList();
//        }
//        catch (NoResultException e) {
//            menuRoles = new ArrayList<WfisPolicyT>();
//        }
//        
//        List<String> assignedMenuRoles = Arrays.asList(selectedPermissionItems);
//        
//        /*
//         * Deletes any existing role that does'nt exist in the assigned Menu Roles
//         */        
//        Iterator i = menuRoles.iterator();
//        while (i.hasNext()){
//           WfisPolicyT existingMenuRole = (WfisPolicyT)i.next();
//           if(assignedMenuRoles.contains(existingMenuRole.getRole())){
//               continue;
//           }else{
//               em.remove(existingMenuRole);
//               i.remove();
//           }
//        }
//        
//        WfisRoleTPK pk = new WfisRoleTPK(role.getRoleName(),DEFAULT_REALM); 
//        WfisRoleT memberGroup = em.find(WfisRoleT.class,pk);
//        /*
//         * Adds the assigned menu Roles to the group
//         */
//        for (String assignedMenuRole: assignedMenuRoles){
//           if(containsRole(menuRoles,assignedMenuRole)){
//                continue;
//           }else{
//              WfisPolicyT newAssignedRole = new WfisPolicyT();
//               newAssignedRole.setRole(assignedMenuRole);
//               newAssignedRole.setGroup(memberGroup);
//               //newAssignedRole.setPolicyType("PERMISSION");
//              em.persist(newAssignedRole);
//           }
//        }
//        
//        
//        List<CasRole> casMenuRoles = new ArrayList<CasRole>();
//        CasRole casRole = null;
//        for(String assignMenu:assignedMenuRoles){
//            casRole = new CasRole();
//            casRole.setRoleName(assignMenu);
//           // casRole.setDescription(findPermissionRoleDescription(assignMenu));
//            casRole.setRoleType("PERMISSION");
//            casMenuRoles.add(casRole);
//        }
//        /*
//         * Existing roles
//         */
//        for(WfisPolicyT casDBRole:menuRoles){
//            casRole = new CasRole();
//            casRole.setRoleName(casDBRole.getRole());
//            //casRole.setDescription(findCasDBMenuDescription(casDBRole.getRole()));
//            casRole.setRoleType("PERMISSION");
//            casMenuRoles.add(casRole);
//        }
//        role.setPermissionRoles(casMenuRoles);
//        return role;
//    }
//
//    public List<CasRole> queryAssociatedRoles(String roleName, String policyType) {
//        String policyQuery = null;
//        if(policyType.equalsIgnoreCase("PERMISSION")){
//            policyQuery = "p.policyType = 'PERMISSION'";
//        }else
//        if(policyType.equals(Constants.RoleType.TASKS)){
//            policyQuery = "p.policyType = '" + Constants.RoleType.TASKS + "' " ;
//        }else{
//            policyQuery = "p.isMenu = 'Y'";
//        }
//        
//        List<WfisPolicyT> menus = em.createQuery("select p from WfisPolicyT p where " + policyQuery + " and p.group.name = ?1")
//          .setParameter(1,roleName).getResultList();
//        
//        
//        List<CasRole> menuRoles = new ArrayList<CasRole>();
//        CasRole menuRole = null;
//        String menuDesc = null;
//        if(policyType.equals(Constants.RoleType.TASKS)){
//            for(WfisPolicyT casDBRole:menus){
//                menuRole = new CasRole();
//                menuRole.setRoleName(casDBRole.getRole());
//                //menuDesc = findCasDBMenuDescription(casDBRole.getRole());
//                menuRole.setDescription(casDBRole.getRole());
//                menuRole.setRoleType(Constants.RoleType.TASKS);
//                menuRoles.add(menuRole);
//            }
//        }else
//        if(!policyType.equalsIgnoreCase("PERMISSION")){
//            for(WfisPolicyT casDBRole:menus){
//                menuRole = new CasRole();
//                menuRole.setRoleName(casDBRole.getRole());
//                menuDesc = findCasDBMenuDescription(casDBRole.getRole());
//                menuRole.setDescription(menuDesc);
//                menuRole.setMenuRole(true);
//                menuRoles.add(menuRole);
//            }
//        }else{
//            for(WfisPolicyT casDBRole:menus){
//                menuRole = new CasRole();
//                menuRole.setRoleName(casDBRole.getRole());
////                menuDesc = findCasDBMenuDescription(casDBRole.getRole());
////                menuRole.setDescription("fff");
////                menuRole.setMenuRole(true);
//
//                menuRoles.add(menuRole);
//            }
//            
//            
//        }
//
//        return menuRoles;
//    }
//
//    public void syncOfficeForUser(CasUser user, String[] office) {
//       
//        CasRole role = new CasRole();
//        role.setRoleName(office[0]);
//        role.setDescription(office[0]);
//        role.setRoleType(Constants.RoleType.OFFICE);
//        if(null ==  this.findGroup(role)){
//            this.createGroup(role);
//        }
//        
//    }
//
//    public List<CasRole> filterRoles(List<CasRole> allRoles, 
//                                     String[] roleTypes) {
//        
//        for(String roleType:roleTypes){
//            if(roleType.equals(Constants.RoleType.OFFICE)){
////                    filterRoles(allRoles,RefOffice.class);
//            }
//            
//            if(roleType.equals(Constants.RoleType.TASKS)){
////                    filterRoles(allRoles,RefTaskRole.class);
//            }                
//        }
//        
//        return allRoles;
//    }
//
//    private void filterRoles(List<CasRole> allRoles, 
//                             Class entity) {
//        int lastIndexOf = entity.getName().lastIndexOf(".");
//        String entityName = entity.getName().substring(lastIndexOf + 1);   
//        List<String> codes = em.createQuery("select o.code from " + entityName+ " o" ).getResultList();
//        if(codes!=null) {
//            Iterator it = allRoles.iterator();
//            while(it.hasNext()){
//                try {
//                   if(codes.contains(((CasRole)it.next()).getRoleName())) {                                        
//                        it.remove();                                       
//                   } 
//                 } catch(Exception e){                
//                    it.remove();
//                }
//            }
//        }
//        
//        /*for(int i=0; i<allRoles.size(); i++){
//            try {
//               em.createQuery("select o.code from " + entityName + " o where o.code = ?1")
//                            .setParameter(1,allRoles.get(i).getRoleName()).getSingleResult();
//                allRoles.remove(i);
//                
//            }
//            catch (NoResultException e) {
//               //do nothing
//            }catch(Exception e){
//                allRoles.remove(i); 
//            }
//        }*/
//    }
//
//    public CasRole assignTaskRoles(CasRole role, String[] selectedTaskItems) {
//        List<WfisPolicyT> menuRoles = null;
//        try {
//            menuRoles = em.createQuery("select p from WfisPolicyT p where p.policyType = ?1 and p.group.name = ?2")
//              .setParameter(1,Constants.RoleType.TASKS)
//              .setParameter(2,role.getRoleName()).getResultList();
//        }
//        catch (NoResultException e) {
//            menuRoles = new ArrayList<WfisPolicyT>();
//        }
//        
//        List<String> assignedMenuRoles = Arrays.asList(selectedTaskItems);
//        
//        /*
//         * Deletes any existing role that does'nt exist in the assigned Menu Roles
//         */        
//        Iterator i = menuRoles.iterator();
//        while (i.hasNext()){
//           WfisPolicyT existingMenuRole = (WfisPolicyT)i.next();
//           if(assignedMenuRoles.contains(existingMenuRole.getRole())){
//               continue;
//           }else{
//               em.remove(existingMenuRole);
//               i.remove();
//           }
//        }
//        
//        WfisRoleTPK pk = new WfisRoleTPK(role.getRoleName(),DEFAULT_REALM); 
//        WfisRoleT memberGroup = em.find(WfisRoleT.class,pk);
//        /*
//         * Adds the assigned menu Roles to the group
//         */
//        for (String assignedMenuRole: assignedMenuRoles){
//           if(containsRole(menuRoles,assignedMenuRole)){
//                continue;
//           }else{
//              WfisPolicyT newAssignedRole = new WfisPolicyT();
//               newAssignedRole.setRole(assignedMenuRole);
//               newAssignedRole.setGroup(memberGroup);
//               newAssignedRole.setPolicyType(Constants.RoleType.TASKS);
//              em.persist(newAssignedRole);
//           }
//        }
//        
//        
//        List<CasRole> casMenuRoles = new ArrayList<CasRole>();
//        CasRole casRole = null;
//        for(String assignMenu:assignedMenuRoles){
//            casRole = new CasRole();
//            casRole.setRoleName(assignMenu);
//            casRole.setDescription(findCasDBMenuDescription(assignMenu));
//            casRole.setMenuRole(true);
//            casMenuRoles.add(casRole);
//        }
//        /*
//         * Existing roles
//         */
//        for(WfisPolicyT casDBRole:menuRoles){
//            casRole = new CasRole();
//            casRole.setRoleName(casDBRole.getRole());
//            casRole.setDescription(findCasDBMenuDescription(casDBRole.getRole()));
//            casRole.setMenuRole(true);
//            casMenuRoles.add(casRole);
//        }
//        role.setMenuRoles(casMenuRoles);
//        return role;
//    }
//    
//    public List<String> findRolesHavingUser(String username) {
//        List resultSet;
//        try {
//            String userSQL = "select ROLE_NAME from CAS_ROLES_VIEW where UPPER(username)= ?1 union " +
//            "select ROLE_NAME from CAS_ROLES_VIEW where member_role in(select ROLE_NAME from CAS_ROLES_VIEW where UPPER(username)= ?1) ";
//            resultSet = 
//                    em.createNativeQuery(userSQL).setParameter(1,username.toUpperCase()).getResultList();
//            List<String> roles = new ArrayList<String>();
//            String roleName = null;
//            
//            if(resultSet != null){
//                for (Object obj: resultSet) {
//                    Vector vector = (Vector)obj;
//                    roleName = (String)vector.get(0);
//                    roles.add(roleName); 
//                }
//            }                
//            return roles;                
//        } catch (javax.persistence.NoResultException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        return null;
//    }
//
//	public List<WfisUserT> findAllLogedInUsers(String filter) {
//		if(StringUtils.isBlank(filter)){
//			filter = "%";
//		}
//		return em.createQuery("select o from WfisUserT o where o.loginStatus = 1 and o.name like :name order by o.name")
//				.setParameter("name", filter).getResultList();
//	}
//
//	public void userLogedIn(String username) {
//		Query query = em.createQuery("update WfisUserT " +
//        		"set loginStatus=:loginStatus where name=:name") 
//        		.setParameter("loginStatus", WfisUserT.LOGIN_STATUS_LOGGED_IN)
//        		.setParameter("name", username);
//        query.executeUpdate();
//	}
//
//	public void userLogedOut(String username) {
//		Query query = em.createQuery("update WfisUserT " +
//			"set loginStatus=:loginStatus where name=:name") 
//			.setParameter("loginStatus", WfisUserT.LOGIN_STATUS_LOGGED_OUT)
//			.setParameter("name", username);
//		query.executeUpdate();
//	}
//
//	public void kickUserOut(String username) {
//		Query query = em.createQuery("update WfisUserT " +
//			"set loginStatus=:loginStatus where name=:name") 
//			.setParameter("loginStatus", WfisUserT.LOGIN_STATUS_KICKED_OFF)
//			.setParameter("name", username);
//		query.executeUpdate();
//	}
//
//	public boolean isUserKickedOut(String username) {
//		WfisUserT user = (((WfisUserT)em.createQuery("select user from WfisUserT user where upper(user.name) = ?1")
//	            .setParameter(1, username.toUpperCase()).getSingleResult()));
//		return WfisUserT.LOGIN_STATUS_KICKED_OFF.equals(user.getLoginStatus());
//	}
//	
//	public void restartAllUsersLoginStatus(){
//		Query query = em.createQuery("update WfisUserT " +
//			"set loginStatus=:loginStatus") 
//			.setParameter("loginStatus", null);
//		query.executeUpdate();
//	}
//        
//    public List<CasSecRolePageRel> getPageRolesByPageURL(String pageURL){
//        List<CasSecRolePageRel> secRolePageRel = null;
//        try{
//             secRolePageRel = em.createNamedQuery("CasSecRolePageRel.findByPageURL").setParameter(1,pageURL). getResultList();    
//        } catch (Exception e ){
//            return null;
//        }
//        return secRolePageRel;
//    }
//    
//    public List<CasSecRolePageRel> getPageRolesByPageURLAndLoggedInUserRoles(String pageURL, String[] roles) {
//        List<CasSecRolePageRel> secRolePageRel = null;
//        try{
//            String str = null;
//            str = "'"+roles[0]+"'";
//            if(roles!=null && roles.length>0){
//                for (int i = 1; i < roles.length; i++) {
//                    str = str + "," + "'" + roles[i] + "'";
//                }    
//            }
//            
//            String query = "select o from CasSecRolePageRel o where o.pageURL='"+pageURL+"' and o.securityRole in ("+str+")";
//
//            Query q = em.createQuery(query);
//            secRolePageRel = q.getResultList();
//            
//        } catch (Exception e ){
//            return null;
//        }
//        return secRolePageRel;
//    }
//    
//    public List<String> getPageAccessList(){
//        List<String> pageAccessList = new ArrayList<String>();
//        List<Vector> resultList = null;
//        
//        String query = "select distinct(page_url) from CAS_SEC_ROLE_PAGE_REL";
//        Query q = em.createNativeQuery(query);
//        resultList = (List<Vector>)q.getResultList();
//        
//        for (Vector val: resultList){
//            pageAccessList.add((String)val.get(0));
//        }
//        
//        return pageAccessList;
//    }
//    
//    public List<CasSecRolePageRel> getPageSecurityRolesRelByLoggedInUserRoles(String[] roles){
//        List<CasSecRolePageRel> secRolePageRel = null;
//        try{
//            String str = null;
//            str = "'"+roles[0]+"'";
//            if(roles!=null && roles.length>0){
//                for (int i = 1; i < roles.length; i++) {
//                    str = str + "," + "'" + roles[i] + "'";
//                }    
//            }
//            
//            String query = "select o from CasSecRolePageRel o where o.securityRole in ("+str+")";
//
//            Query q = em.createQuery(query);
//            secRolePageRel = q.getResultList();
//            
//        } catch (Exception e ){
//            return null;
//        }
//        return secRolePageRel;
//    }
//}
