package com.technobrain.trips.gui.service;

import com.technobrain.trips.common.exceptions.TripsDuplicateFoundException;
import com.technobrain.trips.core.service.FacadeRemote;
import com.technobrain.trips.gui.model.CasMenuPermissions;
import com.technobrain.trips.gui.model.GuiComponentProperty;
import com.technobrain.trips.gui.model.GuiModeType;
import com.technobrain.trips.gui.model.GuiPage;
import com.technobrain.trips.gui.model.GuiPageComponent;
import com.technobrain.trips.gui.model.GuiPageConfig;
import com.technobrain.trips.gui.model.GuiPageMode;
import com.technobrain.trips.gui.model.GuiPageModeLink;
import com.technobrain.trips.gui.model.GuiPageState;
import com.technobrain.trips.gui.model.GuiWorkflow;
import com.technobrain.trips.security.model.CasDBMenu;

import java.util.List;

import javax.ejb.Remote;


@Remote
public interface GuiConfigFacadeRemote extends FacadeRemote{
 
    List<GuiComponentProperty> queryGuiComponentPropertyFindAll();

    void removeGuiComponentProperty(GuiComponentProperty guiComponentProperty);

    List<GuiModeType> queryGuiModeTypeFindAll();

    void removeGuiModeType(GuiModeType guiModeType);

    List<GuiPage> queryGuiPageFindAll();

    void removeGuiPage(GuiPage guiPage);

    List<GuiPageComponent> queryGuiPageComponentFindAll();

    void removeGuiPageComponent(GuiPageComponent guiPageComponent);

    List<GuiPageConfig> queryGuiPageConfigFindAll();

    void removeGuiPageConfig(GuiPageConfig guiPageConfig);

    List<GuiPageMode> queryGuiPageModeFindAll();
    
    List<GuiPageMode> queryGuiPageModeFindAllByPageCodeAndModeType(Object pageCode, Object modeType);
    
    void removeGuiPageMode(GuiPageMode guiPageMode);

    List<GuiPageModeLink> queryGuiPageModeLinkFindAll();

    void removeGuiPageModeLink(GuiPageModeLink guiPageModeLink);

    List<GuiPageState> queryGuiPageStateFindAll();

    void removeGuiPageState(GuiPageState guiPageState);

    List<GuiWorkflow> queryGuiWorkflowFindAll();
    
    List<GuiWorkflow> queryGuiWorkflowFindAllByType(String aModeType);
    
    List<GuiWorkflow> queryGuiWorkflowFindAllByType(String aModeType,String aStatus);

    void removeGuiWorkflow(GuiWorkflow guiWorkflow);

    GuiPage queryGuiPageFindByPageUrl(Object aPageName, Object formId);

    GuiPage queryGuiPageFindByPageCode(Object aPageCode);
   
   
    /***************************************************************************
     *                       BUSINESS METHODS                                  *
     **************************************************************************/ 
 
    /**
     * 
     * @param guiPage
     * @param pageGuiWorkflows
     */
    public void processGuiManagerPageModes(GuiPage guiPage, 
                                List<GuiWorkflow> pageGuiWorkflows);
    
    
    public void syncValidation(GuiPage guiPage, 
                                             final String mode, 
                                             final String pageConfig, 
                                             final String configType,
                                             final String modeLinkCode,
                                             List<GuiPageComponent> selectedComponentList);
                                             
    /**
     * 
     * @param guiPage
     * @param mode
     * @param pageConfig
     * @param configType
     * @param modeLinkCode
     * @param selectedGuiComponents
     */
    public void processGuiPageConfigurations(GuiPage guiPage, final String mode, 
                                               final String pageConfig, 
                                               String pageConfigLinkCode,
                                               final String configType,
                                               final String modeLinkCode,
                                               List<GuiPageComponent> selectedGuiComponents);
    
    /**
     * 
     * @param pageSearchParamater
     * @return
     */
    public List searchForPage(String pageSearchParamater);

    public GuiPage saveOrUpdateSecurity(List<GuiPageConfig> workflowSelectedPageConfigComponents, 
                                     List<GuiPageConfig> securityPageConfigComponents, 
                                     String selectedPageConfiguration, 
                                     String selectedPageConfigMode,
                                     String selectedGroup,GuiPage page);

    public List<CasMenuPermissions> findCasMenuPermissions(String groupCode);

    public List findGroupDescriptions(String[] assigneeGroups);

    public List<CasDBMenu> findAllMenuPermissions();

    public List<GuiPageState> queryGuiPageStateFindAll(String pageUrl);

    public List<CasDBMenu> findMenuIDsHavingRoles(String[] roles);

    public void removeSecurity(String selectedPageConfiguration, 
                               String selectedPageConfigMode, 
                               String selectedPageGroup, GuiPage guiPage);

    public GuiPageConfig saveOrUpdate(GuiPageConfig config);

    public GuiPage saveOrUpdate(GuiPage guiPage);
    
    public GuiPage saveOrUpdateGuiPage(GuiPage guiPage) throws TripsDuplicateFoundException;
}
