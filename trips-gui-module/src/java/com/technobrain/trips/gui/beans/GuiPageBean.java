package com.technobrain.trips.gui.beans;

import com.technobrain.trips.util.Updateable;

import java.util.Collection;


public class GuiPageBean implements Updateable{
    private String pageCode;
    private String pageName;
    private String pageUrl;
    private String formId;
    private Collection pageModes;
    
    public GuiPageBean(){}
    
    /**
     * 
     * @param pageCode
     * @param pageName
     * @param pageUrl
     * @param formId
     */
    public GuiPageBean(String pageCode, String pageName,String pageUrl,String formId){
        this.pageCode = pageCode;
        this.pageName = pageName;
        this.pageUrl = pageUrl;
        this.formId = formId;
    }
    
    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getFormId() {
        return formId;
    }

    public void update(Object newData) {
       GuiPageBean obj = (GuiPageBean) newData;
        this.setPageCode(obj.getPageCode());
        this.setFormId(obj.getFormId());
        this.setPageName(obj.getPageName());
        this.setPageUrl(obj.getPageUrl());
    }

    public void setPageModes(Collection associatedWorkflows) {
        this.pageModes = associatedWorkflows;
    }

    public Collection getPageModes() {
        return pageModes;
    }
}
