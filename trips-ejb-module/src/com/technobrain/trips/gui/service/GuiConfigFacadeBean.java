package com.technobrain.trips.gui.service;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.exceptions.TripsDuplicateFoundException;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.gui.model.CasGroupPageMode;
import com.technobrain.trips.gui.model.CasGroupPageModePK;
import com.technobrain.trips.gui.model.CasMenuPermissions;
import com.technobrain.trips.gui.model.GuiComponentProperty;
import com.technobrain.trips.gui.model.GuiModeType;
import com.technobrain.trips.gui.model.GuiPage;
import com.technobrain.trips.gui.model.GuiPageComponent;
import com.technobrain.trips.gui.model.GuiPageConfig;
import com.technobrain.trips.gui.model.GuiPageConfigPK;
import com.technobrain.trips.gui.model.GuiPageMode;
import com.technobrain.trips.gui.model.GuiPageModeLink;
import com.technobrain.trips.gui.model.GuiPageModeLinkPK;
import com.technobrain.trips.gui.model.GuiPageState;
import com.technobrain.trips.gui.model.GuiWorkflow;
import com.technobrain.trips.security.model.CasDBMenu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;


@Stateless(name = "GuiService",mappedName="GuiService")
@Local
@Remote
public class GuiConfigFacadeBean extends FacadeBean implements GuiConfigFacadeLocal, GuiConfigFacadeRemote {

//    @EJB
//    ValidationFacadeBeanLocal validationService;
    
    @PersistenceContext(unitName = "trips-ejb-module")
    private EntityManager em;

    public GuiConfigFacadeBean() {
    }


    /** <code>select o from GuiComponentProperty o</code> */
    public List<GuiComponentProperty> queryGuiComponentPropertyFindAll() {
        return em.createNamedQuery("GuiComponentProperty.findAll").getResultList();
    }

    public void removeGuiComponentProperty(GuiComponentProperty guiComponentProperty) {
        guiComponentProperty = 
                em.find(GuiComponentProperty.class, guiComponentProperty.getId());
        em.remove(guiComponentProperty);
    }

    /** <code>select o from GuiModeType o</code> */
    public List<GuiModeType> queryGuiModeTypeFindAll() {
        return em.createNamedQuery("GuiModeType.findAll").getResultList();
    }

    public void removeGuiModeType(GuiModeType guiModeType) {
        guiModeType = em.find(GuiModeType.class, guiModeType.getCode());
        em.remove(guiModeType);
    }

    /** <code>select o from GuiPage o</code> */
    public List<GuiPage> queryGuiPageFindAll() {
        List<GuiPage> results = em.createQuery("select o from GuiPage o where o.status = ?1 " +
        "order by o.pageName asc")
        .setParameter(1,Constants.RecordStatus.ACTIVE)
        .getResultList();
        for(GuiPage page :results){
            em.refresh(page);
        }
        return results;
    }

    public void removeGuiPage(GuiPage guiPage) {
        guiPage = em.find(GuiPage.class, guiPage.getCode());
        em.remove(guiPage);
    }

    /** <code>select o from GuiPageComponent o</code> */
    public List<GuiPageComponent> queryGuiPageComponentFindAll() {
        return em.createNamedQuery("GuiPageComponent.findAll").getResultList();
    }

    public void removeGuiPageComponent(GuiPageComponent guiPageComponent) {
        guiPageComponent = 
                em.find(GuiPageComponent.class, guiPageComponent.getId());
        em.remove(guiPageComponent);
    }

    /** <code>select o from GuiPageConfig o</code> */
    public List<GuiPageConfig> queryGuiPageConfigFindAll() {
        return em.createNamedQuery("GuiPageConfig.findAll").getResultList();
    }

    public void removeGuiPageConfig(GuiPageConfig guiPageConfig) {
        guiPageConfig = 
                em.find(GuiPageConfig.class, new GuiPageConfigPK(guiPageConfig.getComponentRefId(), 
                                                                 guiPageConfig.getGuiPageMode().getId()));
        em.remove(guiPageConfig);
    }

    /** <code>select o from GuiPageMode o</code> */
    public List<GuiPageMode> queryGuiPageModeFindAll() {
        return em.createNamedQuery("GuiPageMode.findAll").getResultList();
    }

    public void removeCasGroupPageMode(CasGroupPageMode casGroupPageMode) {
        casGroupPageMode = em.find(CasGroupPageMode.class, new CasGroupPageModePK(casGroupPageMode.getGroupCode(), 
                                                                 casGroupPageMode.getGuiPageMode().getId()));
        em.remove(casGroupPageMode);
    }
    
    public void removeGuiPageMode(GuiPageMode guiPageMode) {
        guiPageMode = em.find(GuiPageMode.class, guiPageMode.getId());
        em.remove(guiPageMode);
    }

    /** <code>select o from GuiPageModeLink o</code> */
    public List<GuiPageModeLink> queryGuiPageModeLinkFindAll() {
        return em.createNamedQuery("GuiPageModeLink.findAll").getResultList();
    }

    public void removeGuiPageModeLink(GuiPageModeLink guiPageModeLink) {
        
        guiPageModeLink = 
                em.find(GuiPageModeLink.class, new GuiPageModeLinkPK(guiPageModeLink.getChildId(), 
                                                                     guiPageModeLink.getParentId()));
        
        if(null != guiPageModeLink)
            em.remove(guiPageModeLink);
    }

    /** <code>select o from GuiPageState o</code> */
    public List<GuiPageState> queryGuiPageStateFindAll() {
        return em.createNamedQuery("GuiPageState.findAll").getResultList();
    }

    public void removeGuiPageState(GuiPageState guiPageState) {
        guiPageState = em.find(GuiPageState.class, guiPageState.getCode());
        em.remove(guiPageState);
    }

    /** <code>select o from GuiWorkflow o</code> */
    public List<GuiWorkflow> queryGuiWorkflowFindAll() {
        return em.createNamedQuery("GuiWorkflow.findAll").getResultList();
    }

    public void removeGuiWorkflow(GuiWorkflow guiWorkflow) {
        guiWorkflow = em.find(GuiWorkflow.class, guiWorkflow.getCode());
        em.remove(guiWorkflow);
    }

    
    public GuiPage queryGuiPageFindByPageUrl(Object aPageName, Object formId) {
        try {
            GuiPage guiPage = null;
            if (null == formId) {
                String code = (String)em.createNamedQuery("GuiPage.findByPageUrl").
                    setHint(QueryHints.REFRESH,HintValues.TRUE).
                    setParameter("aPageUrl", aPageName)
                    .getSingleResult();
                guiPage = em.getReference(GuiPage.class,code);
            } else {                
                guiPage = (GuiPage)em.createNamedQuery("GuiPage.findByPageUrlAndFromId")
                    .setHint(QueryHints.REFRESH,HintValues.TRUE)
                    .setParameter("aPageUrl", String.valueOf(aPageName).trim())                    
                    .setParameter("aFormId", String.valueOf(formId).trim())
                    .getSingleResult();               
            }
            return guiPage;
        }
        catch (javax.persistence.NoResultException e) {
            return null;
        }
    }


    public List<GuiPageMode> queryGuiPageModeFindAllByPageCodeAndModeType(Object aPageCode, 
                                                                          Object aModeType) {
        return em.createNamedQuery("GuiPageMode.findAllByPageCodeAndModeType").setParameter("aPageName", 
                                                                                            aPageCode).setParameter("aModeType", 
                                                                                                                    aModeType).getResultList();
    }

    public List<GuiWorkflow> queryGuiWorkflowFindAllByType(String aModeType) {
        return em.createNamedQuery("GuiWorkflow.findAllActiveByType").setParameter("aModeType", aModeType).getResultList();
    }

    public List<GuiWorkflow> queryGuiWorkflowFindAllByType(String aModeType, 
                                                           String aStatus) {
        return em.createNamedQuery("GuiWorkflow.findAllActiveByType").setParameter("aModeType", 
                                                                                   aModeType).setParameter("aStatus", 
                                                                                                           aStatus).getResultList();
    }

    public GuiPage queryGuiPageFindByPageCode(Object aPageCode) {
        GuiPage guiPage = (GuiPage)em.createQuery("select o from GuiPage o where o.code = :aPageCode").
        setParameter("aPageCode",aPageCode).getSingleResult();
        return guiPage;
    }
    
  
    
    /*
     ***************************************************************************
     *                       BUSINESS METHODS                                  *
     **************************************************************************/ 
    

    
    public void syncValidation(GuiPage guiPage, 
                                             final String mode, 
                                             final String pageConfig, 
                                             final String configType,
                                             final String modeLinkCode,
                                             List<GuiPageComponent> selectedComponentList){
        /*
         * TODO:HHILL look at why the gui config does not delete previous static config
         * and statis configuration needs to be by Mode.
         * eTIS bug 409.
        GuiPageMode guiPageMode = 
            guiPage.findPageMode(mode, pageConfig, configType);                                     
        validationService.syncStaticValidation(guiPageMode.getGuiPageConfigList());                                             
         */
    }
    
    /**
     * 
     * @param guiPage
     * @param mode
     * @param pageConfig
     * @param configType
     * @param modeLinkCode
     * @param selectedComponentList
     */
    public void processGuiPageConfigurations(GuiPage guiPage, 
                                             final String mode, 
                                             final String pageConfig, 
                                             String pageConfigLinkCode,
                                             final String configType,
                                             final String modeLinkCode,
                                             List<GuiPageComponent> selectedComponentList) {
        GuiPageMode guiPageMode = 
            guiPage.findPageMode(mode, pageConfig, configType);
        
        if (null != guiPageMode) {        
            //pageMode has no configuration 
            if (!guiPageMode.hasConfigurations()) {
                //then add new configurations using the selectedComponents
                for(GuiPageComponent guiPageComponent: selectedComponentList){
                   GuiPageConfig guiPageConfig = guiPageComponent.createNewPageConfigFor(guiPageMode);
                   guiPageMode.addGuiPageConfig(guiPageConfig);      
                   em.persist(guiPageConfig);
                }
                
            }else{ //add or remove 
                 int size  = guiPageMode.getGuiPageConfigList().size();
                 List<GuiPageConfig> copyOfGuiPageConfigList = new ArrayList<GuiPageConfig>(guiPageMode.getGuiPageConfigList()); 
                 List existingConfiguredComponentsList = new ArrayList();
                 for(GuiPageConfig aGuiPageConfig: copyOfGuiPageConfigList){
                    boolean alreadyExists = selectedComponentList.contains(aGuiPageConfig.getGuiPageComponent());
                    if(alreadyExists){
                        // do nothing no updates required 
                         existingConfiguredComponentsList.add(aGuiPageConfig.getGuiPageComponent());
                    }else{//not found in selected List add selected to database and remove existing obj
                         removeGuiPageConfig(aGuiPageConfig); // remove from database   
                         guiPageMode.removeGuiPageConfig(aGuiPageConfig);
                         /*
                          * sync the security for configuration removals
                          */
                         List<CasGroupPageMode> casGroupPageModeList = guiPage.getGuiSecurityGroups(guiPageMode);
                         for(CasGroupPageMode entry:casGroupPageModeList){
                            List<GuiPageConfig> securityConfigList = entry.getGuiPageMode().getGuiPageConfigList();
                            GuiPageConfig secConfig = locatePageConfig(securityConfigList,aGuiPageConfig);
                            if(null != secConfig){
                                removeGuiPageConfig(secConfig); 
                                entry.getGuiPageMode().removeGuiPageConfig(secConfig); 
                                mergeEntity(entry.getGuiPageMode());
                            }
                         }
                    }
                 }
                 
                 for(GuiPageComponent aGuiPageComponent: selectedComponentList){
                    boolean alreadyExists = existingConfiguredComponentsList.contains(aGuiPageComponent);
                    if(alreadyExists){
                        // do nothing
                    }else{//not found in selected List add selected to database and remove existing obj
                        GuiPageConfig newGuiPageConfig = aGuiPageComponent.createNewPageConfigFor(guiPageMode); 
                        guiPageMode.addGuiPageConfig(newGuiPageConfig);
//                        validationService.createOrUpdateStaticValidation(newGuiPageConfig);
                    }
                 }
                 
               // guiPageMode = mergeEntity(guiPageMode);
               
            }
            
            if(null == modeLinkCode || modeLinkCode.equalsIgnoreCase("")){//delete all page mode links
                if(!guiPageMode.getGuiPageModeChildLinkList().isEmpty()){
                    
                    for(GuiPageModeLink guiPageModeLink : guiPageMode.getGuiPageModeChildLinkList()){
                        if(null != guiPageModeLink){
                            removeGuiPageModeLink(guiPageModeLink);
                        }
                    }
                    
                    guiPageMode.getGuiPageModeChildLinkList().clear();
                }
            }else{
                pageConfigLinkCode = (null == pageConfigLinkCode || pageConfigLinkCode.equalsIgnoreCase("")) ? pageConfig : pageConfigLinkCode ;
                GuiPageMode parentGuiPageMode = guiPage.findPageMode(modeLinkCode,pageConfigLinkCode,configType);
                
                
                if (null != parentGuiPageMode) {
                    if(guiPageMode.getGuiPageModeChildLinkList().isEmpty()){
                        GuiPageModeLink newGuiPageModeLink = guiPageMode.createNewPageModeLink(parentGuiPageMode);
                        parentGuiPageMode.addGuiPageModeParentLink(newGuiPageModeLink);
                        em.persist(newGuiPageModeLink);
                        guiPageMode.addGuiPageModeChildLink(newGuiPageModeLink);
                    }else{
                        
                        boolean doUpdate = false;
                         /*
                          * Check if is update or Delete the existing gui page mode links for re-creation
                          */
                         for(GuiPageModeLink guiPageModeLink: guiPageMode.getGuiPageModeChildLinkList()){
                             if(!guiPageModeLink.getParentId().equals(parentGuiPageMode.getId())){
                                removeGuiPageModeLink(guiPageModeLink);
                             }else{
                                 doUpdate = true;
                             }
                         }
                         
                        if(doUpdate){
                            //do nothing
                        }else{
                             GuiPageModeLink newGuiPageModeLink = guiPageMode.createNewPageModeLink(parentGuiPageMode);
                             parentGuiPageMode.addGuiPageModeParentLink(newGuiPageModeLink);
                             em.persist(newGuiPageModeLink);
                             guiPageMode.addGuiPageModeChildLink(newGuiPageModeLink);
                        }
                    }
                 }
            }
            
            guiPageMode = (GuiPageMode)mergeEntity(guiPageMode);
        } else {// need to create new page Mode and associated components            
            GuiPageMode newGuiPageMode = guiPage.createNewPageMode(pageConfig, mode,configType);
            guiPage.addGuiPageMode(newGuiPageMode);
            guiPage = (GuiPage)mergeEntity(guiPage);
            processGuiPageConfigurations(guiPage, mode, pageConfig,pageConfigLinkCode, configType,modeLinkCode,
                                         selectedComponentList);
        }
        
    }
  

    /**
     * 
     * @param guiPage
     * @param selectedWorkflowList
     */
    public void processGuiManagerPageModes(GuiPage guiPage, 
                                        List<GuiWorkflow> selectedWorkflowList) {
        
        //iterator the existing guiPageMode list for this guiPage
        Set<GuiPageMode> copy = new HashSet<GuiPageMode>(guiPage.getGuiPageModeSet());
        Set<GuiWorkflow> existingGuiPageWorkflows = new HashSet<GuiWorkflow>();
        for(GuiPageMode existingPageMode:copy){
            boolean alreadyExist  = selectedWorkflowList.contains(existingPageMode.getGuiWorkflow());
            if(alreadyExist){
                //do nothing already exist no update required
                 existingGuiPageWorkflows.add(existingPageMode.getGuiWorkflow());
            }else{//so remove it from the database and list
                removeGuiPageMode(existingPageMode);
                guiPage.removeGuiPageMode(existingPageMode);
            }
        }
       for(GuiWorkflow selectedGuiWorkflow:selectedWorkflowList){
            boolean alreadyExist  = false;
            for(GuiWorkflow existingGuiPageWorkflow:existingGuiPageWorkflows){
                alreadyExist = existingGuiPageWorkflow.equals(selectedGuiWorkflow);
                if(alreadyExist)
                    break;
            }
            
            if(alreadyExist){
                //do nothing already exist no update required
            }else{//so add it from the database and list
                 GuiPageMode newGuiPageMode = new GuiPageMode();
                 newGuiPageMode.setStateCode(GuiPageMode.DEFAULT_MODE);
                 newGuiPageMode.setVersion(Long.valueOf("0"));
                 newGuiPageMode.setModeType(GuiPageMode.WF_CONFIG);
                 newGuiPageMode.setGuiWorkflow(selectedGuiWorkflow);
                 guiPage.addGuiPageMode(newGuiPageMode);
            }
            
        }        

       mergeEntity(guiPage);
   
    }


    public List searchForPage(String pageSearchParamater) {
        List results = 
            em.createQuery("select o from GuiPage o where o.status = ?1 and upper(o.pageName) like :descParameter").
            setParameter("descParameter","%"+pageSearchParamater.toUpperCase()+"%")
            .setParameter(1,Constants.RecordStatus.ACTIVE).getResultList();
       
        return results;
    }
    
    /**
     * 
     * @param workflowSelectedPageConfigComponents
     * @param securityPageConfigComponents
     * @param selectedPageConfiguration
     * @param selectedPageConfigMode
     * @param selectedGroup
     * @param update
     */
    public GuiPage saveOrUpdateSecurity(List<GuiPageConfig> workflowSelectedPageConfigComponents, 
                                     List<GuiPageConfig> securityPageConfigComponents, 
                                     String selectedPageConfiguration, 
                                     String selectedPageConfigMode,
                                     String selectedGroup,GuiPage page) {
        
        
        /*
         * Get the page mode selected 
         */
        GuiPageMode securityMode = 
            page.findSecurityPageMode(selectedGroup,selectedPageConfigMode, 
                                 selectedPageConfiguration);
       
        GuiPageMode workflowMode = 
            page.findPageMode(selectedPageConfigMode, 
                                 selectedPageConfiguration, GuiPageMode.WF_CONFIG);
        CasGroupPageMode groupMode = null;
        if(null == securityMode){
         
            securityMode = page.newSecurityMode(workflowMode);
            groupMode = new CasGroupPageMode();
            groupMode.setGroupCode(selectedGroup);
            groupMode.setStatus(Constants.RecordStatus.ACTIVE);
            securityMode.addCasGroupPageMode(groupMode);
            page.addGuiPageMode(securityMode);
           // page = (GuiPage)mergeEntity(page);
        }else{
            groupMode = securityMode.findGroupMode(selectedGroup);
           if(null == groupMode){//if this is a new group           
                groupMode = new CasGroupPageMode();
                groupMode.setGroupCode(selectedGroup);
                groupMode.setStatus(Constants.RecordStatus.ACTIVE);
                preAuditEntry(groupMode);
                securityMode.addCasGroupPageMode(groupMode);
                //securityMode = (GuiPageMode)mergeEntity(securityMode);
            }
        }
        //search the existing config to find the differences
        for(GuiPageConfig oldSetting:workflowMode.getGuiPageConfigList()){
           // locate the corresponding gui config for the existing record
           GuiPageConfig newSetting = locatePageConfig(securityPageConfigComponents,oldSetting);
   
           if(oldSetting.differenceInAttributes(newSetting)){     
               int found = -1;
               if (null == securityMode.getGuiPageConfigList()) {
                   securityMode.setGuiPageConfigList(new ArrayList<GuiPageConfig>());
               }else{               
                   for (int i = 0; i < securityMode.getGuiPageConfigList().size(); i++) {
                       GuiPageConfig c = securityMode.getGuiPageConfigList().get(i);
                       if (c.getComponentRefId().equals(newSetting.getComponentRefId())) {
                           found = i;
                       }
                   }
               }
               if (found != -1) {
                   securityMode.getGuiPageConfigList().get(found).securityUpdate(newSetting);
                   securityMode = (GuiPageMode)mergeEntity(securityMode);
                   GuiPageConfig newGuiConfig = (GuiPageConfig)mergeEntity( securityMode.getGuiPageConfigList().get(found));
                   securityMode.getGuiPageConfigList().set(found,newGuiConfig);
                   log.debug("db_Update " + newGuiConfig.getComponentRefId());
               } else {
                   
                   GuiPageConfig newGuiConfig  = oldSetting.getGuiPageComponent().createNewPageConfigFor(securityMode);
                   newGuiConfig.securityUpdate(newSetting);
                   securityMode.addGuiPageConfig(newGuiConfig);
                   
               }
           }else{
               log.debug("No defference " + oldSetting.getGuiPageComponent().getComponentId() + " and " + newSetting.getGuiPageComponent().getComponentId());
           }
           
            if(null != securityMode.getId()){//new security mode no merge
                securityMode = (GuiPageMode)mergeEntity(securityMode);
            }
        }
       
       return mergeEntity(page);
    }

    public void removeSecurity(String selectedPageConfiguration, 
                               String selectedPageConfigMode, 
                               String selectedPageGroup, GuiPage guiPage) {
       GuiPageMode secMode = guiPage.
        findSecurityPageMode(selectedPageGroup,selectedPageConfigMode,selectedPageConfiguration);   
       
       guiPage.removeGuiPageMode(secMode);
       removeGuiPageMode(secMode);                        
    }
    
    private GuiPageConfig locatePageConfig(List<GuiPageConfig> securityPageConfigComponents, 
                                           GuiPageConfig existingObject) {
        for(GuiPageConfig guiPageConfig:securityPageConfigComponents){
            if(guiPageConfig.getComponentRefId().equals(existingObject.getComponentRefId())){
                return guiPageConfig;
            }
        }
        
        return null;
    }

    public List<CasMenuPermissions> findCasMenuPermissions(String groupCode) {
        try {
            return em.createQuery("select mp from CasMenuPermissions mp where mp.casGroupCode = ?1").setParameter(1,groupCode).getResultList();
        }
        catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public List findGroupDescriptions(String[] assigneeGroups) {
        return em.createQuery("select g.description from CasGroup g where g.code in(?1)").
            setParameter(1,StringHelper.getInClauseString(assigneeGroups)).getResultList();
    }

    public List<CasDBMenu> findAllMenuPermissions() {
        try {
            return em.createQuery("select o from CasDBMenu o where o.status = ?1 order by o.description")
            .setParameter(1,Constants.RecordStatus.ACTIVE).getResultList();
        }
        catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public List<GuiPageState> queryGuiPageStateFindAll(String pageUrl) {
        try {
            return em.createQuery(
            "select gps from GuiPageState gps where gps.code " +
            "in(select stateGrp.pageState from GuiPageStateGroup stateGrp where stateGrp.code " +
            "in(select gp.pageStateGrp from GuiPage gp where gp.pageUrl = ?1))")
            .setParameter(1,pageUrl)
            .getResultList();
        }
        catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public List<CasDBMenu> findMenuIDsHavingRoles(String[] roles) {
        try {
            return em.createQuery("select menu from CasDBMenu menu where menu.secRole in (?1)").
                setParameter(1,StringHelper.getCommaSeperatedString(roles)).getResultList();
        }
        catch (javax.persistence.NoResultException e) {
            return null;
        }
    }


    public GuiPageConfig saveOrUpdate(GuiPageConfig config) {
        return em.merge(config);
    }
    
    public GuiPage saveOrUpdate(GuiPage guiPage) {
      return super.saveOrUpdate(guiPage);
    }
    
    

     public GuiPage saveOrUpdateGuiPage(GuiPage guiPage) throws TripsDuplicateFoundException {
        if (guiPage.getCreatedDate() == null && em.find(GuiPage.class,  guiPage.getCode()) != null) {
            throw new TripsDuplicateFoundException();
        }
        else {
            return  super.saveOrUpdate(guiPage);
        }
    }
}
