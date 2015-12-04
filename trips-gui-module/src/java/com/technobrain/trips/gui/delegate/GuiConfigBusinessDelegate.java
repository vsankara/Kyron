package com.technobrain.trips.gui.delegate;

import com.technobrain.trips.core.delegate.BusinessDelegate;
import com.technobrain.trips.common.exceptions.TripsDuplicateFoundException;
import com.technobrain.trips.gui.model.GuiPage;
import com.technobrain.trips.gui.model.GuiPageComponent;
import com.technobrain.trips.gui.model.GuiPageConfig;
import com.technobrain.trips.gui.model.GuiPageMode;
import com.technobrain.trips.gui.model.GuiPageModeLink;
import com.technobrain.trips.gui.model.GuiPageState;
import com.technobrain.trips.gui.model.GuiWorkflow;
import com.technobrain.trips.gui.service.GuiConfigFacadeLocal;
import com.technobrain.trips.security.model.CasDBMenu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



/**
 * @ Crown Agents 2008
 *
 * Provides the business logic to the gui screen which is accessed
 * by the controller
 * 
 * @since       $Date: 10/1/2009 1:38:27 AM$
 * @version     $Revision: 22$
 * @author      $Author: Howard Hill$
 * 
 * $Log[1]:
 *  22   TRIPS2 etis.bir.gov.ph1.20.1.0    10/1/2009 1:38:27 AM   Howard Hill  
 *         added validation feature with groovy
 * $
 */
public class GuiConfigBusinessDelegate extends BusinessDelegate {


    /**
     * @return a list of gui pages 
     */
    public List<GuiPage> findAllPages() {
        return getGuiConfigService().queryGuiPageFindAll();
    }

    /**
     * @param status
     * @return a list of all Gui Workflows with this status
     */
    public List<GuiWorkflow> findAllGuiWorkflows(String status) {
       return  getGuiConfigService().
                    queryGuiWorkflowFindAllByType(
                        GuiPageMode.WF_CONFIG, 
                        status);
    }

    /**
     * @param guiPage
     * @return a list of gui workflow for this guiPage
     */
    public List<GuiWorkflow> findPageWorkflows(GuiPage guiPage) {

        Collection<GuiPageMode> pageModes = guiPage.getGuiPageModeSet();
        List<GuiWorkflow> pageWorkflows = new ArrayList<GuiWorkflow>();
        for (GuiPageMode pageMode: pageModes) {
            GuiWorkflow workflow = pageMode.getGuiWorkflow();
            if (!pageWorkflows.contains(workflow)){
                pageWorkflows.add(workflow);
            }
        }

        return pageWorkflows;
    }

    /**
     * 
     * @param pageUrl
     * @return
     */
    public List<GuiPageState> findAllPageModes(String pageUrl) {
        GuiConfigFacadeLocal guiConfig = getGuiConfigService();
        return guiConfig.queryGuiPageStateFindAll(pageUrl);
    }


    /*
    ***************************************************************************
    *                     TRANSACTIONS                                        *
    ***************************************************************************/
     
     /**
     * 
     * @param guiPage
     * @param mode
     * @param pageConfig
     * @param modeType
     * @param modeLink
     * @param selectedComponentList
     */
     public synchronized void syncValidation(GuiPage guiPage, 
                                              final String mode, 
                                              final String pageConfig, 
                                              final String modeType,
                                              final String modeLink,
                                              List<GuiPageComponent> selectedComponentList){
                                              
      getGuiConfigService().
            syncValidation(guiPage, mode, 
                             pageConfig, 
                             modeType, modeLink, 
                             selectedComponentList);         
  
     }
    
    /**
     * Save, Update and Delete the changes made on the screen.
     * <br> For a workflow selected for a page then by default the MAIN mode
     * will be associated with this workflow in the table.
     * <br>
     * e.g. WorkFlow - Basic , on saving will create Basic - MAIN
     * @param guiPage
     * @param pageGuiWorkflows
     */
    public void saveOrUpdateOrDeleteGuiPageMode(GuiPage guiPage, 
                                                List<GuiWorkflow> pageGuiWorkflows) {
        getGuiConfigService().processGuiManagerPageModes(guiPage, 
                                                         pageGuiWorkflows);
       
    }

    /**
     * Save, Update Gui Page.
     * @param guiPage
     */
    public void saveOrUpdateGuiPage(GuiPage guiPage) throws TripsDuplicateFoundException {
        getGuiConfigService().saveOrUpdateGuiPage(guiPage);
       
    }



    /**
     * 
     * @param guiPage
     * @param mode
     * @param pageConfig
     * @param modeType
     * @param modeLink
     * @param selectedGuiComponents
     */
    public synchronized void savePageConfiguration(GuiPage guiPage, final String mode, 
                                      final String pageConfig, 
                                      final String pageConfigLinkCode,
                                      final String modeType, 
                                      final String modeLink, 
                                      List<GuiPageComponent> selectedGuiComponents) {

        getGuiConfigService().processGuiPageConfigurations(guiPage, mode, 
                                                           pageConfig, 
                                                            pageConfigLinkCode,
                                                           modeType, modeLink, 
                                                           selectedGuiComponents);
        
    }

    /**
     * TODO: change implement because currently a page mode is linked to one
     * child via the gui but this can change.
     * @param guiPage
     * @param mode
     * @param pageConfig
     * @param modeType
     * @return
     */
    public String findPageModeLinkCode(GuiPage guiPage, final String mode, 
                                      final String pageConfig, 
                                      final String modeType) {
        GuiPageMode guiPageMode = guiPage.findPageMode(mode,pageConfig,modeType);
        if(null == guiPageMode){
            return null;
        }else{
            for(GuiPageModeLink guiPageModeLink : guiPageMode.getGuiPageModeChildLinkList()){
                return guiPageModeLink.getParentMode().getStateCode();
            }
        }        
        return null;
    }
    
    public GuiPageModeLink findPageModeLink(GuiPage guiPage, final String mode, 
                                      final String pageConfig, 
                                      final String modeType) {
        GuiPageMode guiPageMode = guiPage.findPageMode(mode,pageConfig,modeType);
        if(null == guiPageMode){
            return null;
        }else{
            for(GuiPageModeLink guiPageModeLink : guiPageMode.getGuiPageModeChildLinkList()){
                return guiPageModeLink;
            }
        }        
        return null;
    }
    
    /**
     * 
     * @param pageSearchParamater
     * @return
     */
    public List searchForPage(String pageSearchParamater) {
//       return TripsFeature.getInstance().
//            enableGuiConfiguFeature(getGuiConfigService().searchForPage(pageSearchParamater));
return null;
    }

    /**
     * 
     * @param workflowSelectedPageConfigComponents
     * @param securityPageConfigComponents
     * @param selectedPageConfiguration
     * @param selectedPageConfigMode
     * @param selectedGroup
     * @param update
     * @param page
     */
    public GuiPage saveOrUpdateSecurity(List<GuiPageConfig> workflowSelectedPageConfigComponents, 
                                       List<GuiPageConfig> securityPageConfigComponents, 
                                       String selectedPageConfiguration, 
                                       String selectedPageConfigMode,
                                       String selectedGroup,GuiPage page) {
    
        return getGuiConfigService().saveOrUpdateSecurity(workflowSelectedPageConfigComponents,securityPageConfigComponents,
        selectedPageConfiguration,selectedPageConfigMode,selectedGroup,page);
       
    }
    

        public void deleteSecuritySetting(String selectedPageConfiguration, 
                                          String selectedPageConfigMode, 
                                          String selectedPageGroup, 
                                          GuiPage guiPage) {
        
            getGuiConfigService().removeSecurity(
                    selectedPageConfiguration,selectedPageConfigMode,selectedPageGroup,guiPage);
        }
    
    /**
     * @return a list of all trips menus
     */
    public List<CasDBMenu> findAllMenus() {
        return getGuiConfigService().findAllMenuPermissions();
    }
        
    
    /**
     * Save a xml document this was done for demo
     * @param document
     */
    public void saveDocument(String document) {
//        getBpelService().saveDocument(document);
    }

    public GuiPageConfig saveOrUpdate(GuiPageConfig config) 
    {
        return getGuiConfigService().saveOrUpdate(config);
    }
    
    public GuiPage saveOrUpdate(GuiPage guiPage) 
    {
        return getGuiConfigService().saveOrUpdate(guiPage);
    }
}
