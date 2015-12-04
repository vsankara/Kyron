package com.technobrain.trips.menu.service;

import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.menu.model.AppMenuActionListener;
import com.technobrain.trips.menu.model.AppMenuCommand;
import com.technobrain.trips.menu.model.AppMenuParent;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * TechnoBrain 2011
 *
 * AppMenu facade bean for Application Menu Entities;
 * AppMenuParent
 * AppMenuCommand
 * AppMenuActionListener
 * 
 * Implements standard functionality like finding a database entry according to its ID, 
 * fetching all of the entries on the table, or fetching some of the entries filtered by
 * some constraints..
 *
 * @since	$Date: 7/28/2011 10:00:00 AM$
 * @version 	$Revision: 1$
 * @author 	$Author: Melik Kose$
 * 

 */

@Stateless(name = "AppMenuFacade", mappedName = "test-Project1-AppMenuFacadeBean")
@Local
@Remote
public class AppMenuFacadeBean extends FacadeBean implements AppMenuFacadeLocal, 
                                                             AppMenuFacadeRemote {

    private static Log logger = LogFactory.getLog(AppMenuFacadeBean.class);
    
    @PersistenceContext(unitName = "trips-ejb-module")
    private EntityManager em;
//    @EJB
//    EventFacadeLocal eventFacade;
    
    public AppMenuFacadeBean() {
    }
    
    public AppMenuParent findAppMenuParentById(long id) {
        AppMenuParent appMenuParent = (AppMenuParent) this.queryFindById(AppMenuParent.class, id);
        return appMenuParent;
    }
    
    public AppMenuCommand findAppMenuCommandById(long id) {
        AppMenuCommand appMenuCommand = (AppMenuCommand) this.queryFindById(AppMenuCommand.class, id);
        return appMenuCommand;
    }
    
    public AppMenuActionListener findAppMenuActionListenerById(long id) {
        AppMenuActionListener appMenuActionListener = (AppMenuActionListener) this.queryFindById(AppMenuActionListener.class, id);
        return appMenuActionListener;
    }
    
    /**
     * finds all entities on AppMenuParent.
     * The list returned holds children commands, and actionListeners of each of the commands.
     * @return ordered list of AppMenuParent objects
     */
    public List<AppMenuParent> findAllParents() {
        Query query = em.createNamedQuery("AppMenuParent.findAll");
        List<AppMenuParent> events = query.getResultList();
        return events;
    }
    
    /**
     * finds all entities on AppMenuCommand.
     * The list returned does not hold the actionListeners of the commands.
     * @return ordered list of AppMenuCommand objects
     */
    public List<AppMenuCommand> findAllCommands() {
        Query query = em.createNamedQuery("AppMenuCommand.findAll");
        List<AppMenuCommand> events = query.getResultList();
        return events;
    }
    
    /**
     * finds all entities on AppMenuActionListener.
     * @return list of AppMenuActionListener objects
     */
    public List<AppMenuActionListener> findAllActionListeners() {
        Query query = em.createNamedQuery("AppMenuActionListener.findAll");
        List<AppMenuActionListener> events = query.getResultList();
        return events;
    }
    
    /**
     * finds all entities on AppMenuParent filtered by rendered.
     * The list returned does not hold the actionListeners of the commands.
     * @return ordered list of AppMenuCommand objects
     */
    public List<AppMenuParent> findAllMenuItems(String values) {
        Query query = em.createQuery("select parent " +
                "from AppMenuParent parent " +
//                "   left join parent.appMenuCommands command " +
//                "   left join command.appMenuCommandList subcommands " +
//                "   left join command.appMenuActionListeners action " +
                "where parent.rendered in ("+values+")" +
//                " and command.rendered in ("+values+") and subcommands.rendered in("+values+") " +
//                "   or (parent.rendered in ("+values+") and command.rendered in ("+values+") and Size(command.appMenuCommandList) = 0) " +
//                "   or (parent.rendered in ("+values+") and Size(parent.appMenuCommands) = 0) " +
                "order by" +
//                " command.orderNo," +
                " parent.orderNo");

        List<AppMenuParent> events = query.getResultList();
        return events;
    }
    
}
