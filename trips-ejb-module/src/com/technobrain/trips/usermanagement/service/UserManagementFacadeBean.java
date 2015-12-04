package com.technobrain.trips.usermanagement.service;

import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.reference.model.RefOffStaff;
import com.technobrain.trips.reference.model.RefOffice;
import com.technobrain.trips.reference.service.ReferenceFacadeLocal;
import com.technobrain.trips.usermanagement.model.WfisUserPrinter;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="UserManagementFacade",mappedName="UserManagementFacade")
@Local
public class UserManagementFacadeBean extends FacadeBean implements UserManagementFacadeLocal {

    @PersistenceContext(unitName = "trips-ejb-module")
    private EntityManager em;

    @Resource
    SessionContext sessionContext;
    
    @EJB(name = "ReferenceFacade",mappedName="ReferenceFacade")
    ReferenceFacadeLocal refFacadeLocal; 
    
    public UserManagementFacadeBean() {
    }
    
    /**
     * Returns the printer for the user. The printer would have been setup 
     * by the user using the User Access Controls Screen. 
     * 
     * Null when there is no printer configured for the user.
     * 
     * @param userName
     * @return String
     */
     
    public WfisUserPrinter findPrinterByUserName(String userName) {
        if (userName == null) return null;
        String printerName = null;
        WfisUserPrinter printer = null;
        // changed the query from getSingleResult() to getResultList() to avoid javax.persistence.NoResultException.
        try{
        List<WfisUserPrinter> printers  = em.createNamedQuery("WfisUserPrinter.findPrinterByUserName").setParameter(1,userName).getResultList();
        List<WfisUserPrinter>  wfisUserPrinterList = em.createQuery("select o from WfisUserPrinter o where o.userName=?1").setParameter(1, userName).getResultList();
        if(printers!=null && printers.size()>0){
            printer = printers.get(0);            
        }
        if(wfisUserPrinterList!=null && wfisUserPrinterList.size()>0){
            return wfisUserPrinterList.get(0);
        }
        }catch(Exception ex){
            
        }
        return printer;
    }
    
    public String findOfficeFor(String username) {
//        RefOffStaff staff = refFacadeLocal.findOfficeStaff(username);
        
        RefOffStaff staff = null;
        
        if (null != staff) {
            RefOffice office = staff.getRefOffice();
            if (null != office) {
                return office.getCode();                
            }
        }
        return null;
    }
    
    public WfisUserPrinter saveUserPrinter(WfisUserPrinter wfisUserPrinter){
        if (getPrimaryKeyValueIfRecordExists(wfisUserPrinter, false) != null) {
            //Commented as removed entities are not considered part of the current persistence context
            //if(em.contains(entity)){ 
            if (log.isDebugEnabled()) {
                log.debug("Merging record");
            }
            wfisUserPrinter = em.merge(wfisUserPrinter);
        } else {
            if (log.isDebugEnabled()) {
                log.debug("Saving record " + wfisUserPrinter.getClass());
            }
            //            setDefaultFields(entity);
            em.persist(wfisUserPrinter);
        }
        return wfisUserPrinter;
        
    }

}
