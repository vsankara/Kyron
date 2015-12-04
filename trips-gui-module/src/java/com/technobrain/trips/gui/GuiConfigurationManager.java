package com.technobrain.trips.gui;

import com.technobrain.trips.gui.exception.GuiConfigurationException;

//import oracle.security.jazn.JAZNException;


public class GuiConfigurationManager {
    static GuiConfiguration guiConfiguration = null;
    public GuiConfigurationManager() {  
    }

    /**
     * Manage the accessing of the GuiConfiguration class.
     * 
     * @param aPageUrl - the jspx page name
     * @param aConfig - the config (basic,IM2,DEC,etc)
     * @param aMode - the user mode (view, edit)
     * @return
     */
    public static GuiConfiguration load(String aPageUrl,String formId,String aConfig, String aMode,String aRole) throws GuiConfigurationException {
//        guiConfiguration = new GuiConfiguration();
//       
//        try {
//            guiConfiguration.loadConfiguration(aPageUrl,formId,aConfig, aMode,aRole);
//        } catch (JAZNException e) {
//            throw new GuiConfigurationException(e.getMessage());
//        }
//        
//        return guiConfiguration;
            return null;
    }

}
