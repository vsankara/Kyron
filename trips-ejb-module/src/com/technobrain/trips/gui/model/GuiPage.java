package com.technobrain.trips.gui.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * TechnoBrain 2015
 *
 * TODO: Insert class description
 *
 * @since	$Date: 12/18/2009 7:35:22 PM$
 * @version 	$Revision: 22$
 * @author 	$Author: Howard Hill$
 * 
 * $Log[1]:
 *  22   TRIPS2 etis.bir.gov.ph1.19.1.1    12/18/2009 7:35:22 PM  Howard Hill  
 *         updated as per merge with Registration UAT branch dec 19
 * $
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "GuiPage.findAll", 
        query = "select o from GuiPage o"),
    @NamedQuery(name= "GuiPage.findByPageUrl",
        query = "select o.code from GuiPage o where o.pageUrl = :aPageUrl"
    ),
    @NamedQuery(name= "GuiPage.findByPageUrlAndFromId",
        query = "select o from GuiPage o where o.pageUrl = :aPageUrl and o.formId = :aFormId"
    )
})
@Table(name = "GUI_PAGE")
public class GuiPage extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    @Column(name="FORM_ID", nullable = false)
    private String formId;
    @Column(name="PAGE_STATE_GROUP")
    private String pageStateGrp;
    @Column(name="PAGE_URL", nullable = false)
    private String pageUrl;
    @Column(name="PAGE_NAME", nullable = false)
    private String pageName;
     
    @OneToMany(cascade={CascadeType.ALL},mappedBy = "guiPage")
    private List<GuiPageMode> guiPageModeSet;
    @OneToMany(cascade={CascadeType.ALL},mappedBy = "guiPage")
    private List<GuiPageComponent> guiPageComponentList;
    
//    @OneToMany(mappedBy = "guiPage",cascade = { CascadeType.ALL })
//    private List<ScrGuiPageVal> guiPageValList;
 
    
    public GuiPage() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public List<GuiPageMode> getGuiPageModeSet() {
        return guiPageModeSet;
    }

    public void setGuiPageModeSet(List<GuiPageMode> guiPageModeList) {
        this.guiPageModeSet = guiPageModeList;
    }
    
    
    public GuiPageMode addGuiPageMode(GuiPageMode guiPageMode) {
        getGuiPageModeSet().add(guiPageMode);
        guiPageMode.setGuiPage(this);
        return guiPageMode;
    }

    public GuiPageMode removeGuiPageMode(GuiPageMode guiPageMode) {
        getGuiPageModeSet().remove(guiPageMode);
        guiPageMode.setGuiPage(null);
        return guiPageMode;
    }

    public List<GuiPageComponent> getGuiPageComponentList() {
        return guiPageComponentList;
    }

    public void setGuiPageComponentList(List<GuiPageComponent> guiPageComponentList) {
        this.guiPageComponentList = guiPageComponentList;
    }

    public GuiPageComponent addGuiPageComponent(GuiPageComponent guiPageComponent) {
        getGuiPageComponentList().add(guiPageComponent);
        guiPageComponent.setGuiPage(this);
        return guiPageComponent;
    }

    public GuiPageComponent removeGuiPageComponent(GuiPageComponent guiPageComponent) {
        getGuiPageComponentList().remove(guiPageComponent);
        guiPageComponent.setGuiPage(null);
        return guiPageComponent;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

 
     /*
      * *************************************************************************
     *                       Business Methods                                  *
     **************************************************************************/
    
    /**
     * 
     * Finds a list of components for this page using this configuration
     * and this mode. The mode Type is required e.g Workflow or Security , etc.
     * <p>
     * Searchs the associated page modes to get the selected page mode, then
     * find the components for it.
     * @param configCode
     * @param mode
     * @param modeType
     * @return a collection of gui configured components
     */
    public List<GuiPageComponent> findConfiguredComponents(String configCode, 
                                               String mode,String modeType) {
                                               
        log.debug("Searching for configured Components");
        //TODO: add mode type to search criteria
        List<GuiPageComponent> configuredComponents = null;
        GuiPageMode selectedGuiPageMode = findPageMode(mode,configCode,modeType);                               
    
        log.debug("selectedGuiPageMode "  + selectedGuiPageMode);
        if(selectedGuiPageMode == null){
            return Collections.emptyList();
        }
        
        int size = selectedGuiPageMode.getGuiPageConfigList().size();
        configuredComponents = new ArrayList<GuiPageComponent>(size);
        //Now search the config list for the component ref id to build a list of components
        for ( GuiPageConfig guiPageConfig : selectedGuiPageMode.getGuiPageConfigList() ){
            GuiPageComponent guiPageComponent =  guiPageConfig.getGuiPageComponent();
            if(guiPageComponent != null)
                configuredComponents.add(guiPageComponent);
        }
        
        return configuredComponents;
    }

    public GuiPageMode findPageMode(String mode, String configCode, 
                                    String configType) {
        
        //search the list for the page mode that matches the configuration and mode
        for ( GuiPageMode guiPageMode : this.guiPageModeSet ){
            //is equal to configCode 
             
            if(null != guiPageMode.getGuiWorkflow() &&
                configCode.equals(guiPageMode.getGuiWorkflow().getCode())){
                //is equal to mode
                if(mode.equals(guiPageMode.getStateCode())
                   &&
                   configType.equals(guiPageMode.getModeType())
                ){
                    return guiPageMode;
                }
            }
        }
        
        return null;
    }
    
    public GuiPageMode findSecurityPageMode(String _group,String _mode, String _configCode) {
        
        for (GuiPageMode mode: this.getGuiPageModeSet()) {
            if (mode.isSecurityMode()) {
                if (mode.getGuiWorkflow().getCode().equals(_configCode) && 
                    mode.getStateCode().equals(_mode)) {

                    for (CasGroupPageMode casGroupPageMode: mode.getCasGroupPageModeList()) {
                        if(casGroupPageMode.getGroupCode().equals(_group)){
                            return mode;
                        }
                    }
                }
            }
        }


        return null;
    }
    
    public GuiPageMode findPageMode(Long pageModeId) {
    
        GuiPageMode selectedGuiPageMode = null;                               
        //search the list for the page mode that matches the configuration and mode
        for ( GuiPageMode guiPageMode : this.guiPageModeSet ){
            //is equal to pageModeId
            if(guiPageMode.getId().equals(pageModeId)){
                selectedGuiPageMode =  guiPageMode;
                break;
            }
        }
        
        return selectedGuiPageMode;
    
    }


    public GuiWorkflow findGuiWorkflow(String configCode, String configType) {
    
        GuiPageMode selectedGuiPageMode = null;                               
        //search the list for the page mode that matches the configuration and mode
        for ( GuiPageMode guiPageMode : this.guiPageModeSet ){
            //is equal to configCode 
            if(configCode.equals(guiPageMode.getGuiWorkflow().getCode())){
                //is equal to configType
                if(configType.equals(guiPageMode.getModeType())
                ){
                    selectedGuiPageMode = guiPageMode;
                    break;
                }
            }
        }
        
        return selectedGuiPageMode.getGuiWorkflow() == null ? null : selectedGuiPageMode.getGuiWorkflow();
    }

    public GuiPageMode createNewPageMode(final String pageConfig, final String mode, 
                                  final String configType) {
                                  
        GuiWorkflow guiWorkflow =  this.findGuiWorkflow(pageConfig, configType);
        GuiPageMode newGuiPageMode = new GuiPageMode();
        newGuiPageMode.setGuiWorkflow(guiWorkflow);
        newGuiPageMode.setModeType(configType);
        newGuiPageMode.setStateCode(mode);
        newGuiPageMode.setGuiPage(this);
        
        return newGuiPageMode;
        
    }


    public boolean hasConfigurations() {
       return !getGuiPageModeSet().isEmpty();
    }

    public void setPageStateGrp(String pageStateGrp) {
        this.pageStateGrp = pageStateGrp;
    }

    public String getPageStateGrp() {
        return pageStateGrp;
    }
    
    /**
     * 
     * @param wfPageMode
     * @return
     */
    public List<CasGroupPageMode> getGuiSecurityGroups(GuiPageMode wfPageMode) {
        List<CasGroupPageMode> groupModes = new ArrayList<CasGroupPageMode>();

        for (GuiPageMode mode: this.getGuiPageModeSet()) {
            if (mode.isSecurityMode() 
                && mode.getGuiWorkflow().getCode().equals(wfPageMode.getGuiWorkflow().getCode()) 
                && mode.getStateCode().equals(wfPageMode.getStateCode())) {
          
                    for (CasGroupPageMode casGroupPageMode: 
                         mode.getCasGroupPageModeList()) {
                        if (casGroupPageMode.getGuiPageMode().getId().equals(mode.getId())) {
                            if(casGroupPageMode.getGuiPageMode().getGuiPageConfigList().isEmpty()){
                                //do nothing   
                            }else{
                                groupModes.add(casGroupPageMode);
                            }
                        }
                    }
                }
            }
            
            return groupModes; 
    }
    
    /**
     * Using this wfPageMode creates a map of all groups configured for the
     * mode as the key and the configuration has the value
     * @param wfPageMode
     * @return a map consisting of the groups and there configuration
     */
    public Map getGuiSecurityPageConfigList(GuiPageMode wfPageMode) {
        Map groupWithConfig = new HashMap();
        
        for (CasGroupPageMode casGroupPageMode: getGuiSecurityGroups(wfPageMode)) {
            if(!casGroupPageMode.getGuiPageMode().getGuiPageConfigList().isEmpty()){
                groupWithConfig.put(casGroupPageMode.getGroupCode(), 
                                    casGroupPageMode.getGuiPageMode().getGuiPageConfigList());
            }            
        }
            
        return groupWithConfig; 
    }
    /**
     * Find the guiConfiguration for this group and this wfPageMode
     * @param group
     * @param wfPageMode
     * @return
     */
    public List<GuiPageConfig> getGuiSecurityPageConfigList(String group,GuiPageMode wfPageMode) {
        Map groupAndCofig = getGuiSecurityPageConfigList(wfPageMode);
        if(null != groupAndCofig){
            return (List<GuiPageConfig>)groupAndCofig.get(group);
        }
        return null;
    }


    public GuiPageMode newSecurityMode(GuiPageMode pageMode) {
        GuiPageMode securityMode = new GuiPageMode();
        securityMode.setGuiPage(this);
        securityMode.setModeType(GuiPageMode.SEC_CONFIG);
        securityMode.setStateCode(pageMode.getStateCode());
        securityMode.setStatus(pageMode.getStatus());
        securityMode.setGuiWorkflow(pageMode.getGuiWorkflow());
        return securityMode;
    }

//    public void setScrGuiPageValList(List<ScrGuiPageVal> guiPageValList) {
//        this.guiPageValList = guiPageValList;
//    }
//
//    public List<ScrGuiPageVal> getScrGuiPageValList() {
//        return guiPageValList;
//    }
    
   
}
