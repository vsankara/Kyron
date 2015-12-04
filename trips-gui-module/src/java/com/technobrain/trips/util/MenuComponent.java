package com.technobrain.trips.util;

//package com.crownagents.trips.util;
//
//
//import com.crownagents.trips.common.helpers.StringHelper;
//import com.crownagents.trips.menu.model.AppMenuActionListener;
//import com.crownagents.trips.menu.model.AppMenuChildCommands;
//import com.crownagents.trips.menu.model.AppMenuCommand;
//import com.crownagents.trips.menu.model.AppMenuParent;
//
//import java.util.Collections;
//import java.util.List;
//
//import javax.faces.el.MethodBinding;
//import javax.faces.el.ValueBinding;
//
//import org.apache.myfaces.trinidad.component.core.layout.CorePanelGroupLayout;
//import org.apache.myfaces.trinidad.component.core.layout.CorePanelHorizontalLayout;
//import org.apache.myfaces.trinidad.component.core.nav.CoreCommandLink;
//import org.apache.myfaces.trinidad.component.core.output.CoreImage;
//
////import oracle.adfinternal.view.faces.taglib.listener.SetActionListener;
//
//import org.apache.log4j.Logger;
//import org.apache.myfaces.trinidad.event.SetActionListener;
//
///**
// * This Menu Component class moves the functionality of the Menu from the static Jspx file to the DataBase.
// * It Creates a Panel Group and does a binding to the web page which is "/login/Welcome.jspx"
// */
//public class MenuComponent {
//   
//    public MenuComponent() {
//    }
//    
//    
//    static final Logger log = Logger.getLogger(MenuComponent.class);
//    final static String PARENT_PANEL_GROUP_STYLE = "expandedMenu";
//    final static String CHILD_PANEL_GROUP_STYLE = "submenu";
//    
//    final static String PANEL_GROUP_LAYOUT = "vertical";
//    
//    final static String PANEL_HORIZONTAL_V_ALIGN = "top";
//    
//    final static String IMAGE_SOURCE = "../../skins/etis/skin_images/arrow.gif";
//    
//    final static String BACKING_BEAN_NAME = "webconstants";
//    
//    
//    /**
//     * The Panel Group object is constructed here to be added to the page
//     * @param coreParentMenusList
//     * @return The panel group to be binded to the page
//     */
//    public CorePanelGroupLayout addToPagePanelGroup(List<AppMenuParent> coreParentMenusList) {
//        CorePanelGroupLayout menuParentPanelGroup = new CorePanelGroupLayout();
//        menuParentPanelGroup.getChildren().clear();
//        
//        if(coreParentMenusList ==null || coreParentMenusList.size()==0 ) {
//            log.error("There is no menu  to display");
//            return menuParentPanelGroup;
//        }
//        Collections.sort(coreParentMenusList);
//        for(AppMenuParent coreParentMenu:coreParentMenusList) {
//            menuParentPanelGroup.getChildren().add(getCoreCommandLink(null,coreParentMenu.getText(),"button",null,"true",null,null));
//            menuParentPanelGroup.getChildren().add(addPGToParentPanelGroup(coreParentMenu.getAppMenuCommands()));
//        }
//       return menuParentPanelGroup;
//        
//    }
//    
//    /**
//     * This contains the menu Batch
//     * @param coreCommandsList
//     * @return the menu Batch
//     */
//    private CorePanelGroupLayout addPGToParentPanelGroup(List<AppMenuCommand> coreCommandList) {
//        CorePanelGroupLayout menuChildPanelGroup = new CorePanelGroupLayout();
//        menuChildPanelGroup.getChildren().clear();
////        Collections.sort(coreCommandsList);
//        menuChildPanelGroup.setStyleClass(PARENT_PANEL_GROUP_STYLE);
//        menuChildPanelGroup.setLayout(PANEL_GROUP_LAYOUT);
////        Integer processingCommandIndex =0;
//        if(coreCommandList ==null || coreCommandList.size()==0 ) {
//            log.error("There are no menu Items to display");
//            return menuChildPanelGroup;
//        }
//        Collections.sort(coreCommandList);
//        for(AppMenuCommand currentCommand:coreCommandList) {
//            if(currentCommand.getAppMenuCommandList()!=null && currentCommand.getAppMenuCommandList().size()>0) {
//                menuChildPanelGroup.getChildren().add(addPHToCommandPanelGroup(currentCommand));
////                processingCommandIndex++;
//                menuChildPanelGroup.getChildren().add(addPGToChildPanelGroup(currentCommand.getAppMenuCommandList()));
////                i=processingCommandIndex;
//            } else {
//                menuChildPanelGroup.getChildren().add(addPHToCommandPanelGroup(currentCommand));
////                processingCommandIndex++;
//            }
//            
//        }
//        
//        return menuChildPanelGroup;
//    }
//    
//    /**
//     * This construct the sub menu batch.
//     * @param coreCommandsList
//     * @param currentCommand
//     * @return the panel Group for Submenu batch
//     */
//    private CorePanelGroupLayout addPGToChildPanelGroup(List<AppMenuChildCommands> coreCommandsList) {
//        CorePanelGroupLayout menuChildPanelGroup = new CorePanelGroupLayout();
////        Collections.sort(coreCommandsList);
//        menuChildPanelGroup.getChildren().clear();
//        menuChildPanelGroup.setStyleClass(CHILD_PANEL_GROUP_STYLE);
//        menuChildPanelGroup.setLayout(PANEL_GROUP_LAYOUT);
//    
//        if(coreCommandsList ==null || coreCommandsList.size()==0 ) {
//            log.error("There are no menu Items to display");
//            return menuChildPanelGroup;
//        }
//        
//        
//        for(AppMenuChildCommands coreCommands:coreCommandsList) {
//            menuChildPanelGroup.getChildren().add(addPHToChildPanelGroup(coreCommands));
//        }
//        
//        return menuChildPanelGroup;
//    }
//    
//    /**
//     * This constructs the menu Item with the image and the Command
//     * @param currentCommands
//     * @return the Horizontal Panel 
//     */
//    private CorePanelHorizontalLayout addPHToChildPanelGroup(AppMenuChildCommands currentCommands ) {
//        CorePanelHorizontalLayout corePanelHorizontal = new CorePanelHorizontalLayout();
//        corePanelHorizontal.setValign(PANEL_HORIZONTAL_V_ALIGN);
//        if(currentCommands ==null ) {
//            log.error("There is no menu Links for navigation");
//            return corePanelHorizontal;
//        }
//        corePanelHorizontal.getChildren().clear();
//        corePanelHorizontal.getChildren().add(getCommandLink(currentCommands));
//        return corePanelHorizontal;
//        
//    }
//    
//    /**
//     * This constructs the menu Item with the image and the Command
//     * @param currentCommands
//     * @return the Horizontal Panel 
//     */
//    private CorePanelHorizontalLayout addPHToCommandPanelGroup(AppMenuCommand currentCommands ) {
//        CorePanelHorizontalLayout corePanelHorizontal = new CorePanelHorizontalLayout();
//        corePanelHorizontal.setValign(PANEL_HORIZONTAL_V_ALIGN);
//        if(currentCommands ==null ) {
//            log.error("There is no menu Links for navigation");
//            return corePanelHorizontal;
//        }
//        corePanelHorizontal.getChildren().clear();
//        corePanelHorizontal.getChildren().add(getCoreObjectImage());
//        corePanelHorizontal.getChildren().add(getCommandLink(currentCommands));
//        return corePanelHorizontal;
//        
//    }
//    
//    /**
//     * This retruns the default image which are added by default for any menu item
//     * @return image object
//     */
//    private CoreImage getCoreObjectImage() {
//        CoreImage coreObjectImage = new CoreImage();
//        coreObjectImage.setSource(IMAGE_SOURCE);
//        
//        coreObjectImage.setRendered(true);
//
//        return coreObjectImage;
//    }
//    
//    /**
//     * The Menu Item as a command link
//     * @param currentCommands
//     * @return the command link
//     */
//    private CoreCommandLink getCommandLink(AppMenuCommand currentCommands) {
//        if(currentCommands ==null ) {
//            log.error("There is no menu Links for navigation");
//            return  getCoreCommandLink(null, 
//                                  null, 
//                                  null,
//                                  null,
//                                  null,
//                                  null,
//                                  null);
//        }
//        return getCoreCommandLink(currentCommands.getName(), 
//                                  currentCommands.getText(), 
//                                  currentCommands.getStyle(),
//                                  currentCommands.getAction(),
//                                  currentCommands.getDisabled(),
//                                  currentCommands.getBlocking(),
//                                  currentCommands.getAppMenuActionListeners());
//    }
//    
//    /**
//     * The Menu Item as a command link
//     * @param currentCommands
//     * @return the command link
//     */
//    private CoreCommandLink getCommandLink(AppMenuChildCommands currentCommands) {
//        if(currentCommands ==null ) {
//            log.error("There is no menu Links for navigation");
//            return  getCoreCommandLink(null, 
//                                  null, 
//                                  null,
//                                  null,
//                                  null,
//                                  null,
//                                  null);
//        }
//        return getCoreCommandLink(currentCommands.getName(), 
//                                  currentCommands.getText(), 
//                                  currentCommands.getStyle(),
//                                  currentCommands.getAction(),
//                                  currentCommands.getDisabled(),
//                                  currentCommands.getBlocking(),
//                                  currentCommands.getAppMenuActionListeners());
//    }
//    
//    /**
//     * Constructs  the Command Link based on the attributes 
//     * @param name
//     * @param label
//     * @param styleClass
//     * @param action
//     * @param disabled
//     * @param blocking
//     * @param setActionListeners
//     * @return command Links
//     */
//    private CoreCommandLink getCoreCommandLink(String name, String label, 
//                                               String styleClass, 
//                                               String action, 
//                                               String disabled,
//                                               String blocking,
//                                               List<AppMenuActionListener> setActionListeners) {
//        CoreCommandLink coreCommandLink = new CoreCommandLink();
//        if (!StringHelper.isNullOrEmptyString(name)) {
//            coreCommandLink.setId(name);
//            //            coreCommandLink.setRendered(getMenuAccessStatus(name));
//            
//        }
//        // TODO
//        coreCommandLink.setRendered(true);
//        if (!StringHelper.isNullOrEmptyString(disabled))
//            coreCommandLink.setDisabled(Boolean.parseBoolean(disabled));
//            
//        if (!StringHelper.isNullOrEmptyString(blocking))
//            coreCommandLink.setBlocking(Boolean.parseBoolean(blocking));
//
//
//        if (!StringHelper.isNullOrEmptyString(label)) {
//            if(label.startsWith("#")) {
//                label = label.substring(1);
//                coreCommandLink.setText(FacesUtil.getStringFromBundle(label));
//            } else {
//                coreCommandLink.setText(label);
//            }
//        }
//            
//        if (!StringHelper.isNullOrEmptyString(styleClass))
//            coreCommandLink.setStyleClass(styleClass);
//
//        if (!StringHelper.isNullOrEmptyString(action)) {
//            MethodBinding methodBinding = 
//                FacesUtil.getFacesContext().getApplication().createMethodBinding(getActionString(action), 
//                                                                                 null);
//            coreCommandLink.setAction(methodBinding);
//        }
//
//        if (setActionListeners != null && setActionListeners.size() > 0) {
//            for (AppMenuActionListener setActionListener: setActionListeners) {
//                coreCommandLink.addActionListener(getActionListener(setActionListener.getFromValue(), 
//                                                                    setActionListener.getToValue()));
//            }
//        } else {
//            String text = "-nolabel-";
//            if (!StringHelper.isNullOrEmptyString(label)) text = coreCommandLink.getText();
//            log.warn("Action Listeners were not present for the Menu "+text+" and Id "+name);
//        }
//        return coreCommandLink;
//    }
//    
//    /**
//     * Returns the method name to be called for any action
//     * @param action
//     * @return the method name to be called.
//     */
//    private String getActionString(String action) {
//        if(!StringHelper.isNullOrEmptyString(action)) {
//            if(action.startsWith("#")) {
//                return action;
//            }
//            else {
//                action = action.substring(0,1).toUpperCase() + action.substring(1);
//                return "#{"+BACKING_BEAN_NAME+".get"+action+"}";
//            }
//        } else {
//            return null;
//        }
//    }
//    
//    /**
//     * Returns the method name to be called for any action
//     * @param action
//     * @return the method name to be called.
//     */
//    private String getValueString(String key) {
//        if(!StringHelper.isNullOrEmptyString(key)) {
//            return "#{"+key+"}";
//        } else {
//            return null;
//        }
//    }
//    
//    /**
//     * The Action Listener that has to be aded to the command link
//     * @param fromKey
//     * @param toKey
//     * @return the action listener
//     */
//    private SetActionListener getActionListener(String fromKey, String toKey) {
//        SetActionListener setactionListener = new SetActionListener();
//        if(!StringHelper.isNullOrEmptyString(fromKey)&& !StringHelper.isNullOrEmptyString(toKey)) {
////            setactionListener.setValueBinding(SetActionListener.FROM_KEY, 
////                                              getValueBinding(fromKey));
////            setactionListener.setValueBinding(SetActionListener.TO_KEY, 
////                                              getValueBinding(toKey));
//        }
//       
//        return setactionListener;
//    }
//    
//    /**
//     * Return a Value Binding Object
//     * @param valueKey
//     * @return ValueBinding
//     */
//    private ValueBinding getValueBinding(String valueKey) {
//        if(!StringHelper.isNullOrEmptyString(valueKey)) 
//        return FacesUtil.getFacesContext().getApplication().createValueBinding(getValueString(valueKey));
//        else 
//        
//        return null;
//        
//    }
//    
//}
