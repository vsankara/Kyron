package com.technobrain.trips.security;

//package com.crownagents.trips.security;
//
//import com.crownagents.trips.security.delegate.SecurityControlDelegate;
//import com.technobrain.trips.dto.DataTransferObject;
//
//import java.security.Principal;
//
//import java.util.Calendar;
//import java.util.List;
//
//
///**
// * � Crown Agents 2006
// * <p>
// * Represents the user account for the life time of the user session i.e 
// * from log-in to log-out.
// * <br>
// * A User Account consist of mainly the user id, which identifies the user.
// * @since $Date: 8/18/2009 5:15:35 AM$
// * @version $Revision: 9$
// * @author $Author: Howard Hill$
// * 
// * $Log[1]:
// *  9    TRIPS2 etis.bir.gov.ph1.7.1.0     8/18/2009 5:15:35 AM   Howard Hill  
// *         checked in core changes
// * $
// */
//public class UserAccount implements DataTransferObject {
//    private Principal principal;
//    private CasUser casUser;
//    private String reportServerUserPassword;
//    private String workstation;
//    private String office;
//    
//    
//    public UserAccount(Principal _principal) {
//        this.principal = _principal;
//    }
//    
//    public UserAccount(Principal _principal,CasUser user) {
//        this.principal = _principal;
//        this.casUser = user;
//    }
//    
//    public String getUserName(){
//        return this.casUser.getUsername();
//    }
//    
//    public List<CasRole> getUserGroups(){
//        return getCasUser().getGroupRolesList();
//    }
//    
//    public boolean isPasswordExpiryed() {
//    boolean isExpired = false;
//       if(null == getCasUser() || null == getCasUser().getPasswordExpiryDate()){
//           isExpired = false;
//       }else{
//           Calendar currentTime = Calendar.getInstance();
//           
//          if(this.casUser.getPasswordExpiryDate().compareTo(currentTime) < 0){
//              isExpired= true;
//          }          
//       }
//       
//       return isExpired;
//    }
//
//    public CasUser getCasUser() {
//        return casUser;
//    }
//
//    public void setReportServerUserPassword(String reportServerUserPassword) {
//        this.reportServerUserPassword = reportServerUserPassword;
//    }
//
//    public String getReportServerUserPassword() {
//        return reportServerUserPassword;
//    }
//
//
//    public void setWorkstation(String workstation) {
//        this.workstation = workstation;
//    }
//
//    public String getWorkstation() {
//        return workstation;
//    }
//
//    public void setOffice(String office) {
//        this.office = office;
//    }
//
//    public String getOffice() {
//        return office;
//    }
//    
//    public String getAccessLevel(){
//        return this.casUser.getAccessLevel();
//    }
//}
