package com.technobrain.trips.common.constants;

/**
 * Crown Agents 2007
 * 
 * This class holds all the jndi constants values used in TRIPS.   
 * 
 * @since $Date: 4/27/2009 7:13:20 AM$
 * @version $Revision: 10$
 * @author $Author: Kemal Ediz$
 * 
 * $Log[1]:
 *  10   TRIPS2    1.9         4/27/2009 7:13:20 AM   Kemal Ediz      reverted
 *       to version 6.
 * $
 */
public class JndiConstants {
    public static final String DATA_SOURCE_JNDI = "jdbc/TripsDBConnectionDS";    
    public static final String JNDI_DROP_DOWN_HELPER = "DropDownHelper"; 
    public static final String EBS_DATA_SOURCE_JNDI = "jdbc/TripsDBConnectionDS";
    public static final String REVENUE_LEDGER_REMOTE = "RevenueLedgerFacade";
    public static final String COMPLIANCE_QUEUE = "tripsQueueRA/Wrap/Queues/COMP_QUEUE";
    public static final String QUEUE_CONNECTION_FACTORY = "tripsQueueRA/QCF";
}
