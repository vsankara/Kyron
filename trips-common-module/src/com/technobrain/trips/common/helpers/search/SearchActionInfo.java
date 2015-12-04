package com.technobrain.trips.common.helpers.search;

import java.io.Serializable;


public class SearchActionInfo implements Serializable {
    private String actionId;
    private String actionLabel;    
    private String actionCallBack;        
    private String allowableModes;
    private boolean useDialog;
    private int windowHeight;
    private int windowWidth;
    
    public SearchActionInfo(String actionId,String actionLabel,String actionCallBack,String allowableModes){
        this.actionId=actionId;
        this.actionLabel=actionLabel;
        this.actionCallBack=actionCallBack;        
        this.allowableModes = allowableModes;
    }
    public String getActionId(){
        return actionId;
    }
    public void setActionId(String actionId){
        this.actionId=actionId;
    }
    public String getActionLabel(){
        return actionLabel;
    }
    public void setActionLabel(String actionLabel){
        this.actionLabel=actionLabel;
    }
    public String getActionCallBack(){
        return actionCallBack;
    }
    public void setActionCallBack(String actionCallBack){
        this.actionCallBack=actionCallBack;
    }

    public void setAllowableModes(String allowableModes) {
        this.allowableModes = allowableModes;
    }

    public String getAllowableModes() {
        return allowableModes;
    }

    public void setUseDialog(boolean useDialog) {
        this.useDialog = useDialog;
    }

    public boolean isUseDialog() {
        return useDialog;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public int getWindowWidth() {
        return windowWidth;
    }
}


