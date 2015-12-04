package com.technobrain.trips.cli;

import com.technobrain.trips.locator.ServiceLocator;
import com.technobrain.trips.reference.service.ReferenceFacadeLocal;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;


public class TripsCliInterface implements ServletContextListener {
	public static final Logger log = Logger.getLogger(TripsCliInterface.class);
	
	public static final String ADMIN_TELNET_PORT = "ADMIN_TELNET_PORT";

//	private TelnetManager telnetManager = null;
	
	private ReferenceFacadeLocal referenceFacade = null;
	
	public void contextDestroyed(ServletContextEvent context) {
//		if(telnetManager != null){
//			try {
////				telnetManager.stop();
//			} catch (IOException e) {
//				log.error("Error on TelnetManager stop", e);
//			}
//		}
	}

	public void contextInitialized(ServletContextEvent context) {
//		try {
			referenceFacade =  (ReferenceFacadeLocal) ServiceLocator.getInstance().getLocalEJB("ReferenceFacade");
			
//			TelnetConfiguration telnetConfiguration = new TelnetConfiguration();
//
//			telnetConfiguration.setPort(Integer.parseInt(referenceFacade.getSystemParameter(ADMIN_TELNET_PORT)));
//			telnetConfiguration.setPrompt(">");
//
//			// Register all commands
//			telnetConfiguration.register(CommandCD.class);
//			telnetConfiguration.register(CommandPWD.class);
//			telnetConfiguration.register(CommandExit.class);
//			telnetConfiguration.register(CommandList.class);
//			telnetConfiguration.register(CommandImportFlexForm.class);
//			telnetConfiguration.register(CommandCleanConfiguration.class);
//			
//					
//			telnetManager = new TelnetManager(telnetConfiguration);
//			telnetManager.start();
//		} catch (java.net.BindException e) {
//			// we might use multi jvm. we can ignore this exception....
//		} catch (Exception e) {
//			log.error("Error TelnetManager start", e);
//		}
		
	}

}
