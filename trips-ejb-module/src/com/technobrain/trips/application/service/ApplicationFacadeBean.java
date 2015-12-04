package com.technobrain.trips.application.service;

import com.technobrain.trips.application.messagehelper.ApplicationMessageHelper;
import com.technobrain.trips.application.model.AppEntity;
import com.technobrain.trips.application.model.AppRevenueType;
import com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBLocal;
import com.technobrain.trips.core.service.FacadeBean;

import com.technobrain.trips.application.message.EntityAppInputType;
import com.technobrain.trips.application.message.RevenueTypeAppInputType;

import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless(name="ApplicationFacade",mappedName = "ApplicationFacade")
public class ApplicationFacadeBean extends FacadeBean implements ApplicationFacadeLocal, ApplicationFacadeRemote {

//    @PersistenceContext(unitName = "trips-ejb-module")
//    private EntityManager em;
    
    @EJB
    RefCodeAssemblerSessionEJBLocal refFacadeBean;

    public ApplicationFacadeBean() {
    }
    
    @Override
    public EntityAppInputType findEntityAppInputType(Long id) {
        return (EntityAppInputType)getInputType(id, AppEntity.class, initializeMessageHelper(ApplicationMessageHelper.class));
    }
    
    @Override
    public RevenueTypeAppInputType findRevenueAppInputType(Long id) {
        return (RevenueTypeAppInputType)getInputType(id, AppRevenueType.class, initializeMessageHelper(ApplicationMessageHelper.class));
    }
}
