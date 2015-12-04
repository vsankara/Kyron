package com.technobrain.trips.gui.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;


@Entity
@NamedQueries( { @NamedQuery(name = "GuiPageMode.findAll", 
                             query = "select o from GuiPageMode o", 
                             hints = { @QueryHint(name = 
                                                  QueryHints.REFRESH, 
                                                  value = HintValues.TRUE)
                    } )
        , 
        @NamedQuery(name = "GuiPageMode.findAllByPageCodeAndModeType", query = 
                    "select o from GuiPageMode o where o.pageCode = :aPageCode AND o.modeType = :aModeType", 
                    hints = 
                    { @QueryHint(name = QueryHints.REFRESH, value = 
                                 HintValues.TRUE)
                    } )
        } )
@Table(name = "GUI_PAGE_MODE")
public class GuiPageMode extends BaseNormalModelObject {

    public static final String DEFAULT_MODE = "VIEW";
    public static final String DEFAULT_CONFIG = "CRUD";
    public static final String WF_CONFIG = "WF";
    public static final String SEC_CONFIG = "SEC";

    @Id
    @GeneratedValue(generator = "GuiPageModeSeq")
    @SequenceGenerator(name = "GuiPageModeSeq", 
                       sequenceName = "GUI_PAGE_MODE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    @Column(name = "PAGE_CODE", nullable = false, insertable = false, 
            updatable = false)
    private String pageCode;
    @Column(name = "MODE_TYPE")
    private String modeType;
    @Column(name = "STATE_CODE")
    private String stateCode;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "childMode")
    private List<GuiPageModeLink> guiPageModeChildLinkList;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "parentMode")
    private List<GuiPageModeLink> guiPageModeParentLinkList;
    @ManyToOne
    @JoinColumn(name = "WORKFLOW_CODE", referencedColumnName = "CODE")
    private GuiWorkflow guiWorkflow;
    @ManyToOne
    @JoinColumn(name = "PAGE_CODE", referencedColumnName = "CODE")
    private GuiPage guiPage;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "guiPageMode")
    private List<CasGroupPageMode> casGroupPageModeList;

    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "guiPageMode")
    private List<GuiPageConfig> guiPageConfigList;

    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "guiPageMode")
    private List<GuiPageModeVal> guiPageModeValList;
    
    @PostPersist
    public Long getPrimaryKey() {
        //        log.debug("Primary Key = " + getId());
        return id;
    }

    public GuiPageMode() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //    public GuiPageState getGuiPageState() {
    //        return guiPageState;
    //    }

    //    public void setGuiPageState(GuiPageState guiPageState) {
    //        this.guiPageState = guiPageState;
    //    }

    public List<GuiPageModeLink> getGuiPageModeChildLinkList() {
        return guiPageModeChildLinkList;
    }

    public void setGuiPageModeChildLinkList(List<GuiPageModeLink> guiPageModeLinkList) {
        this.guiPageModeChildLinkList = guiPageModeLinkList;
    }

    public GuiPageModeLink addGuiPageModeChildLink(GuiPageModeLink guiPageModeLink) {
        getGuiPageModeChildLinkList().add(guiPageModeLink);
        guiPageModeLink.setChildMode(this);
        return guiPageModeLink;
    }

    public GuiPageModeLink removeGuiPageModeChildLink(GuiPageModeLink guiPageModeLink) {
        getGuiPageModeChildLinkList().remove(guiPageModeLink);
        guiPageModeLink.setChildMode(null);
        return guiPageModeLink;
    }

    public List<GuiPageModeLink> getGuiPageModeParentLinkList() {
        return guiPageModeParentLinkList;
    }

    public void setGuiPageModeParentLinkList(List<GuiPageModeLink> guiPageModeLinkList1) {
        this.guiPageModeParentLinkList = guiPageModeLinkList1;
    }

    public GuiPageModeLink addGuiPageModeParentLink(GuiPageModeLink guiPageModeLink) {
        getGuiPageModeParentLinkList().add(guiPageModeLink);
        guiPageModeLink.setParentMode(this);
        return guiPageModeLink;
    }

    public GuiPageModeLink removeGuiPageModeParentLink(GuiPageModeLink guiPageModeLink) {
        getGuiPageModeParentLinkList().remove(guiPageModeLink);
        guiPageModeLink.setParentMode(null);
        return guiPageModeLink;
    }

    public GuiWorkflow getGuiWorkflow() {
        return guiWorkflow;
    }

    public void setGuiWorkflow(GuiWorkflow guiWorkflow) {
        this.guiWorkflow = guiWorkflow;
    }

    public GuiPage getGuiPage() {
        return guiPage;
    }

    public void setGuiPage(GuiPage guiPage) {
        this.guiPage = guiPage;
    }

    public List<CasGroupPageMode> getCasGroupPageModeList() {
        return casGroupPageModeList;
    }

    public void setCasGroupPageModeList(List<CasGroupPageMode> casGroupPageModeList) {
        this.casGroupPageModeList = casGroupPageModeList;
    }

    public CasGroupPageMode addCasGroupPageMode(CasGroupPageMode casGroupPageMode) {
        if (getCasGroupPageModeList() == null) {
            setCasGroupPageModeList(new ArrayList<CasGroupPageMode>());
        }
        getCasGroupPageModeList().add(casGroupPageMode);
        casGroupPageMode.setGuiPageMode(this);
        return casGroupPageMode;
    }

    public CasGroupPageMode removeCasGroupPageMode(CasGroupPageMode casGroupPageMode) {
        getCasGroupPageModeList().remove(casGroupPageMode);
        casGroupPageMode.setGuiPageMode(null);
        return casGroupPageMode;
    }


    public List<GuiPageConfig> getGuiPageConfigList() {
        return guiPageConfigList;
    }

    public void setGuiPageConfigList(List<GuiPageConfig> guiPageConfigList) {
        this.guiPageConfigList = guiPageConfigList;
    }

    public GuiPageConfig addGuiPageConfig(GuiPageConfig guiPageConfig) {
        getGuiPageConfigList().add(guiPageConfig);
        guiPageConfig.setGuiPageMode(this);
        return guiPageConfig;
    }

    public GuiPageConfig removeGuiPageConfig(GuiPageConfig guiPageConfig) {
        getGuiPageConfigList().remove(guiPageConfig);
        guiPageConfig.setGuiPageMode(null);
        return guiPageConfig;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setModeType(String modeType) {
        this.modeType = modeType;
    }

    public String getModeType() {
        return modeType;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void addAllGuiPageConfig(List<GuiPageConfig> pageConfigs) {
        for (GuiPageConfig guiPageConfig: pageConfigs) {
            addGuiPageConfig(guiPageConfig);
        }
    }


    public boolean hasConfigurations() {
        return !getGuiPageConfigList().isEmpty();
    }

    public GuiPageModeLink createNewPageModeLink(GuiPageMode parentGuiPageMode) {
        GuiPageModeLink newGuiPageModeLink = new GuiPageModeLink();
        newGuiPageModeLink.setParentId(parentGuiPageMode.getId());
        newGuiPageModeLink.setParentMode(parentGuiPageMode);
        newGuiPageModeLink.setChildMode(this);
        newGuiPageModeLink.setChildId(this.getId());
        return newGuiPageModeLink;
    }

    public boolean hasParentLink(String selectedPageConfigMode,String selectedPageConfiguration) {
        for (GuiPageModeLink link: getGuiPageModeChildLinkList()) {
            if (link.getParentMode().getStateCode().equals(selectedPageConfigMode)
               && link.getParentMode().getGuiWorkflow().getCode().equals(selectedPageConfiguration)) {
                return true;
            }
        }

        return false;
    }



    public boolean isSecurityMode() {
        return this.getModeType() != null && 
            this.getModeType().equalsIgnoreCase(GuiPageMode.SEC_CONFIG);
    }


    public CasGroupPageMode findGroupMode(String selectedGroup) {

//
//        log.debug("$$$$$$$$$$ CasGroupPageMode results " + 
//                           this.getCasGroupPageModeList().size());
        for (CasGroupPageMode groupMode: this.getCasGroupPageModeList()) {
//            log.debug("$groupMode.getGuiPageMode().getModeType() " + 
//                               groupMode.getGuiPageMode().getGuiWorkflow().getCode());
//            log.debug("$groupMode.getGuiPageMode().getStateCode() " + 
//                               groupMode.getGuiPageMode().getStateCode());
            if (groupMode.getGuiPageMode().getGuiWorkflow().equals(this.getGuiWorkflow()) && 
                groupMode.getGroupCode().equals(selectedGroup) && 
                groupMode.getGuiPageMode().getStateCode().equalsIgnoreCase(this.getStateCode())) {
                return groupMode;
            }
        }
        return null;
    }
    
    /**
     * Finds the page configuration for this component id
     * @param componentId
     * @return
     */
    public GuiPageConfig findFieldConfiguration(String componentId) {
        for(GuiPageConfig config: this.guiPageConfigList){
            if(config.getGuiPageComponent().getComponentId().equalsIgnoreCase(componentId)){
                return config;
            }
        }
        
        return null;
    }

    public void setGuiPageModeValList(List<GuiPageModeVal> guiPageModeValList) {
        this.guiPageModeValList = guiPageModeValList;
    }

    public List<GuiPageModeVal> getGuiPageModeValList() {
        return guiPageModeValList;
    }
}
