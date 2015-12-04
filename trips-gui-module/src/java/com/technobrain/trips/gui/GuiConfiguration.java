package com.technobrain.trips.gui;

import com.technobrain.trips.gui.exception.GuiConfigurationException;
import com.technobrain.trips.gui.model.GuiPage;
import com.technobrain.trips.gui.model.GuiPageConfig;
import com.technobrain.trips.gui.model.GuiPageMode;
import com.technobrain.trips.gui.model.GuiPageModeLink;
import com.technobrain.trips.gui.service.GuiConfigFacadeRemote;
import com.technobrain.trips.locator.ServiceLocator;
import com.technobrain.trips.locator.ServiceLocatorException;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
//import oracle.security.jazn.JAZNException;


/**
 * @ Crown Agents 2008
 *
 *
 * @since       $Date: 10/1/2009 1:38:28 AM$
 * @version     $Revision: 26$
 * @author      $Author: Howard Hill$
 *
 * $Log[1]:
 *  26   TRIPS2 etis.bir.gov.ph1.24.1.0    10/1/2009 1:38:28 AM   Howard Hill
 *         added validation feature with groovy
 * $
 */
public class GuiConfiguration implements Serializable {
    
    public static final Logger log = Logger.getLogger(GuiConfiguration.class);
    
    /**
     * Stores the configuration list of this pageUrl , pageConfig, pageMode
     */
    private List<GuiPageConfig> configList;

    /**
     * Stores the page url for this configuration
     */
    private String pageUrl;
    
    /**
     * Stores the page configuration key for this configuration
     */   
    private String pageConfig;
   
    /**
     * Stores the page mode for this configuration
     */
    private String pageMode;    
    
    /**
     * Stores the form id of the page
     */
    private String formID;
    
    private Map groupConfiguration;
   /**
     * Represents the page configuration for this _pageUrl and 
     * _configCode and _pageMode
     * @param _pageUrl
     * @param _configCode
     * @param _pageMode
     */
    public  GuiConfiguration(String _pageUrl, String _configCode, String _pageMode) throws GuiConfigurationException {
        this(_pageUrl, _configCode, _pageMode, null);
    }
    
    public  GuiConfiguration(String _pageUrl, String _configCode, String _pageMode, String _formId) throws GuiConfigurationException {
        this.pageUrl = _pageUrl;
        this.pageConfig = _configCode;
        this.pageMode = null != _pageMode ? _pageMode.toUpperCase() : null;
        if (null == _pageUrl || null == _configCode || null == _pageMode) {
            throw new GuiConfigurationException("No Configuration defined for mode");
        } 
        this.formID = _formId;
        getConfiguration();
    }
    
    public GuiPageMode getConfiguration() throws GuiConfigurationException {
        
        //find the page related to this configuration                   
        GuiPage page = locatePageConfiguration(this.pageUrl,this.pageConfig, this.pageMode);
        
        if (null == page) {
            throw new GuiConfigurationException("No page configuration found");
        } 
        
        GuiPageMode guiPageMode = page.findPageMode(this.pageMode, this.pageConfig, GuiPageMode.WF_CONFIG);

        if (null == guiPageMode) {
            throw new GuiConfigurationException("No Configuration defined for mode");
        } 
        
        Set<GuiPageMode> linkedModes = null;
        
        /*
         * If no page mode link
         */
        if (guiPageMode.getGuiPageModeChildLinkList().isEmpty()) {
            this.configList = new ArrayList<GuiPageConfig>(guiPageMode.getGuiPageConfigList().size());
            this.configList.addAll(guiPageMode.getGuiPageConfigList());
        } else {//do the linkage of page modes
            this.configList = new ArrayList<GuiPageConfig>(guiPageMode.getGuiPageConfigList().size());
            this.configList.addAll(guiPageMode.getGuiPageConfigList());
            
            /*
             * Get the other modes linked to this mode
             */
             linkedModes = new HashSet<GuiPageMode>();
            for (GuiPageModeLink guiPageModeLink: guiPageMode.getGuiPageModeChildLinkList()) {
                GuiPageMode parentMode = guiPageModeLink.getParentMode();
                manageGuiModeLinkage(guiPageMode, linkedModes, parentMode);
            }
        }
        
        this.formID = page.getFormId();
        groupConfiguration = page.getGuiSecurityPageConfigList(guiPageMode);
        
        /*
         * Additional modes
         */
        if(null == linkedModes){
            //do nothing
        }else{
            Map linkedGroupConfiguration = null;
            for(GuiPageMode linkedMode:linkedModes){
                linkedGroupConfiguration = page.getGuiSecurityPageConfigList(linkedMode);
                mergeLinkedSecurity(groupConfiguration,linkedGroupConfiguration);
            }
        }
        
        return guiPageMode;
    }
    /**
     * Merge the child group security configuration with its parent group configuration
     * @param groupConfiguration
     * @param linkedGroupConfiguration
     */
    public void mergeLinkedSecurity(Map groupConfiguration,Map linkedGroupConfiguration){
        Set<Map.Entry> entrySet = linkedGroupConfiguration.entrySet();
        
        for(Map.Entry entry:entrySet){
            boolean merged = false;
            List<GuiPageConfig> guiConfigList = null;
            List<GuiPageConfig> linkedGuiConfigList = null;
            if(groupConfiguration.containsKey(entry.getKey())){
                guiConfigList = (List<GuiPageConfig>)groupConfiguration.get(entry.getKey());
                linkedGuiConfigList = (List<GuiPageConfig>)entry.getValue();
                guiConfigList = mergeGuiConfigurations(guiConfigList,linkedGuiConfigList);
                groupConfiguration.put(entry.getKey(),guiConfigList);
                merged = true;
            }else{
                groupConfiguration.put(entry.getKey(),entry.getValue());  
            }
            
        }
    }
    
    /**
     * Merges the gui configuration.
     * <p>
     * This destGuiConfigList willl act as the master which will be returned after merge
     * is complete.
     * @param destGuiConfigList
     * @param sourceGuiConfigList
     */
    public List<GuiPageConfig> mergeGuiConfigurations(List<GuiPageConfig> destGuiConfigList, List<GuiPageConfig> sourceGuiConfigList){
        for(GuiPageConfig sourceGuiConfig:sourceGuiConfigList){
            boolean found = false;
            for(GuiPageConfig destGuiConfig:destGuiConfigList){
                if(destGuiConfig.getComponentRefId().equals(sourceGuiConfig.getComponentRefId())){
                    found = true;
                    //do nothing should no overwrite changes
                }
            }
            if(!found){
                //add to configuration
                 destGuiConfigList.add(sourceGuiConfig);
            }
        }
        
        return destGuiConfigList;
    }
    
    /**
     * 
     * @param groups
     * @return
     * @throws GuiConfigurationException
     */
    public List<GuiPageConfig> applySecurity(String[] groups) throws GuiConfigurationException{
        boolean applied = false;
        ArrayList<GuiPageConfig> securityConfigList = new ArrayList<GuiPageConfig>();
        ArrayList<GuiPageConfig> clonedConfigList = new ArrayList<GuiPageConfig>(this.configList);
    
        for (String grp:groups) {
            if (null != groupConfiguration && groupConfiguration.containsKey(grp)) {
                securityConfigList.
                    addAll((List<GuiPageConfig>)groupConfiguration.get(grp));
            }
        }

        if (securityConfigList != null) {
            //for(){
            for (GuiPageConfig secGuiPageConfig: securityConfigList) {

                int index = locateGuiConfig(this.configList, secGuiPageConfig, 
                                             new GuiConfigComparator());

                if (index >= 0) {
                    if (log.isDebugEnabled()){
                        log.debug("apply security change on " + index + " for " + 
                                  secGuiPageConfig.getGuiPageComponent().getComponentId());
                    }
                    GuiPageConfig clonedConfig = clonedConfigList.get(index);
                    /*
                     * Only update list item if modes are same
                     */
                    if(clonedConfig.getGuiPageMode().getStateCode().equals(secGuiPageConfig.getGuiPageMode().getStateCode())){
                        clonedConfigList.get(index).securityUpdate(secGuiPageConfig);
                    }
                    applied = true;
                }
            }
        } else {
            if (log.isDebugEnabled())
                log.debug("no security configuration to be added ");

        }
        
        return clonedConfigList;
    }

    public int locateGuiConfig(List<GuiPageConfig> configList,GuiPageConfig secGuiPageConfig,GuiConfigComparator comparator){
          for(int i=0; i<configList.size(); i++){
              GuiPageConfig config = configList.get(i);
              if(config.getComponentRefId().equals(secGuiPageConfig.getComponentRefId())){
                  return i;
              }
          }
          
          return -1;
    }
    
    /**
     * Only adds configuration that do not already exist.
     * @param modes
     * @param parentMode
     */
    private void manageGuiModeLinkage(GuiPageMode mainMode, Set modes, 
                                      GuiPageMode parentMode) {
        if (log.isDebugEnabled()) {
            log.debug("System found " + this.configList.size() + 
                      " existing configurations");
            log.debug("System found mode linkage to mode" + 
                      parentMode.getStateCode());
            log.debug("Adding " + parentMode.getGuiPageConfigList().size() + 
                      " configurations from mode " + 
                      parentMode.getStateCode() + 
                      " to list of configurations");
        }

        List<GuiPageConfig> listOfConfigs = parentMode.getGuiPageConfigList();
     
        /*
         * adds the page configs for each child mode it is mapped to
         */
        for (GuiPageConfig config: this.configList) {

            int index = 
                locateGuiConfig(listOfConfigs, config,null);

            if (log.isDebugEnabled()) {
                log.debug("index " + index + " " + 
                          config.getGuiPageComponent().getComponentId());
            }
            if (index >= 0) {
                if (log.isDebugEnabled()) {
                    log.debug("Ignored configuration for component " + 
                              config.getGuiPageComponent().getComponentId() + 
                              ", it already existed for " + 
                              mainMode.getStateCode());
                }
                listOfConfigs.remove(index);
            } else {
                if (log.isDebugEnabled()) {
                    log.debug("Added configuration for component " + 
                              config.getGuiPageComponent().getComponentId());
                }
                listOfConfigs.add(config);
            }
        }

        this.configList.addAll(listOfConfigs);

        if (!modes.isEmpty() && !modes.contains(parentMode)) {
           //do nothing
        } else {
            if (!parentMode.getGuiPageModeChildLinkList().isEmpty()) {//if parent has another parent
                modes.add(parentMode);
                GuiPageModeLink anotherLink = 
                    parentMode.getGuiPageModeChildLinkList().get(0);
                manageGuiModeLinkage(parentMode, modes, 
                                     anotherLink.getParentMode());
            }else{
                if(null != listOfConfigs && !listOfConfigs.isEmpty()){
                    modes.add(parentMode);
                }
            }
        }

    }

    /**
     * 
     * @param aPageUrl
     * @param pageConfigurationCode
     * @param aMode
     * @return
     * @throws GuiConfigurationException
     */
    public GuiPage locatePageConfiguration(String aPageUrl, 
                                      String pageConfigurationCode, 
                                      String aMode) throws GuiConfigurationException {
        if (aPageUrl == null) {
            throw new IllegalAccessError("Gui Config requires a page url");
        }

        GuiPage page = 
            getGuiConfigService().queryGuiPageFindByPageUrl(aPageUrl, formID);
        
        if (page == null) {
            if (log.isDebugEnabled())
                log.debug(" No page found with url " + aPageUrl);
            return null;
        } else {
            if (log.isDebugEnabled())
                log.debug(" page found with url " + aPageUrl);
        }
    
        if (log.isDebugEnabled())
            log.debug("GUI Page has form id of value: " + page.getFormId());

        if (aMode == null) {
            throw new GuiConfigurationException("Gui Config requires a page mode");
        }

        if (pageConfigurationCode == null) {
            throw new GuiConfigurationException("Gui Config requires a page configuration");
        }

        return page;
    }

    public void setFormID(String formID) {
        this.formID = formID;
    }

    public String getFormID() {
        return formID;
    }

    /**
     * Consider changing implementation to use component refId maybe faster
     */
    protected class GuiConfigComparator implements Comparator {

        public int compare(Object o1, Object o2) {
            GuiPageConfig config1 = (GuiPageConfig)o1;
            GuiPageConfig config2 = (GuiPageConfig)o2;

            return config1.getComponentRefId().compareTo(config2.getComponentRefId());
        }
    }



    private GuiConfigFacadeRemote getGuiConfigService() {

        try {
            return (GuiConfigFacadeRemote)getServiceLocator().getRemoteEJB(ServiceLocator.Services.GUI_MANAGER);
        } catch (ServiceLocatorException e) {
            log.error(e.getLocalizedMessage(), e);
        }

        throw new IllegalAccessError(GuiConfigFacadeRemote.class.getName());
    }


    /**
     * Easy access method to get the service locator 
     * @return Service Locator
     * @throws com.crownagents.trips.locator.ServiceLocatorException
     */
    public ServiceLocator getServiceLocator() throws ServiceLocatorException {
        return new ServiceLocator();
    }

    public String getPageConfig() {
        return pageConfig;
    }


    public List<GuiPageConfig> getConfigList() {
        return this.configList;
    }
}
