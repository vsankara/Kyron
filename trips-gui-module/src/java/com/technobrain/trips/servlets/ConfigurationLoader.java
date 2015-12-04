package com.technobrain.trips.servlets;

//import com.crownagents.trips.castor.CastorSerializerDeSerializer;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 * � Crown Agents 2007
 *
 * Loads the configuration for the gui
 * @since       $Date: 1/13/2010 8:44:32 AM$
 * @version     $Revision: 13$
 * @author      $Author: Kemal Ediz$
 *
 * $Log[1]:
 *  13   TRIPS2 etis.bir.gov.ph1.9.1.2     1/13/2010 8:44:32 AM   Kemal Ediz
 *         Moved SearchConfigHelper to ejb-module, changed the getSearchInfo
 *       method of SearchConfigHelper, overriden getBaseType method of
 *       BackingFlexibleFormEntry returns InputType
 * $
 */
public class ConfigurationLoader extends HttpServlet {
    static final Logger log = Logger.getLogger(ConfigurationLoader.class);

//    @EJB
//    private  RefCodeAssemblerSessionEJBLocal ref;
  
    public void init() {
        callLog4JConfigurationFunction();   
        callSearchConfigurationFunction();

//        callCastorConfigurationFunction();
    }


        

    /**
     * Saves 2 seconds of processes loading castor mapping here
     */
    private void callCastorConfigurationFunction() {
        //load on start up to improve performace when submitting bpel
//        CastorSerializerDeSerializer.serializeToInputputSource(new InputType(), false);
    }
    
    private void callSearchConfigurationFunction() {
//        load on start up to improve performace 
//        ReferenceCodeDelegate refCodes = new ReferenceCodeDelegate();
//        String loadFromDB = refCodes.findSystemParameter(Constants.SystemParameterCode.LOAD_GENERIC_SEARCH_FROM_DB);
//        if(loadFromDB != null && loadFromDB.equalsIgnoreCase(Constants.YES)){
//            SearchConfigHelper.loadAllSearchConfig(true);
//        }else{
//            SearchConfigHelper.loadAllSearchConfig(false);
//        }
    }
    
    /**
     * Log4j configuration loader, in production the file can be modified to change logging
     */
    private void callLog4JConfigurationFunction() {
        String prefix = getServletContext().getRealPath("/");
        String file = getInitParameter("log4j-init-file");

        // if the log4j-init-file is not set, then no point in trying
        if (file != null) {
            PropertyConfigurator.configureAndWatch(prefix + file);
        }
    }
    
    

}
