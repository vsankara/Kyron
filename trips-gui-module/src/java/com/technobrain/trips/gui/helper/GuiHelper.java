package com.technobrain.trips.gui.helper;


import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.gui.model.GuiPage;
import com.technobrain.trips.gui.model.GuiPageComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GuiHelper {

    private static final String ID_ATTR = "id";
    private static final String ATTR_LOCAL_NAME = "localName";
    private static final String ATTR_TYPE_TO_SKIP_MESSAGES = "messages";
    private static final String REGION = "REGION";
    private static final String TABLE = "TABLE";
    private static final String REGIONTYPE = "regionType";
    private static final String REGIONTYPE_RGMENUGLOBAL = "RGMENUGLOBAL";
    private static final String REGIONTYPE_RGBRANDING = "RGBRANDING";
    private static final String REGIONTYPE_RGCOPYRIGHT = "RGCOPYRIGHT";
    private static final String REGIONTYPE_RGPRIVACY = "RGPRIVACY";
    private static final String REGIONTYPE_RGABOUT = "RGABOUT";
    private static final String REGIONTYPE_RGINFOUSER = "RGINFOUSER";
    private static final String REGIONMETADATA_FILEPATH = "/WEB-INF/region-metadata.xml";
    private static final String COMPONENTTYPE_NODEPATH = "//component/component-type";
    private static final String COMPONENTEXTENSION_NODENAME = "component-extension";
    private static final String REGIONJSPPATH_NODENAME = "region-jsp-ui-def";
    
    
    public static final Logger log = Logger.getLogger(GuiHelper.class);
    
    public GuiHelper() {
    }
    
    
    
    /**
     * Updates Gui Page components, updates or inserts components - do not delete dummy ones.
     * @param guiPage
     * @param nodes
     * @param parentID
     * @param infoBag
     * @return
     */
    public static boolean configureGuiPageComponents(GuiPage guiPage,
        NodeList nodes, String parentID, PageComponentManagerInfoBag infoBag) {
        
        // check all nodes within the nodelist..
        for(int i = 0; i< nodes.getLength(); i++)            {
            Node tempNode = nodes.item(i);
            // we will be saving this component information if it has an id, if it does not have an id, contunie checking child nodes..
            
            if(tempNode.getAttributes() != null && tempNode.getAttributes().getNamedItem(ID_ATTR) != null) {
                // generate component id which will be saved to db..
                if(tempNode.getLocalName() != null && tempNode.getLocalName().equals(ATTR_TYPE_TO_SKIP_MESSAGES)){
                    continue;
                }
                                
                String newID = parentID + tempNode.getAttributes().getNamedItem(ID_ATTR).getNodeValue();
                                
                GuiPageComponent tempComponent = null;
                if(guiPage.getCreatedDate() != null)
                {
                    // if page is a new page, no need to check components.
                    tempComponent = findGuiPageComponentById(guiPage, newID);
                }
                if(tempComponent != null) {
                    // updating existing GuiPageComponent..
                    tempComponent.setComponentType(tempNode.getLocalName().toUpperCase());
                    infoBag.newComponentList.add(newID);
                    
                }
                else {
                    // a new component
                    tempComponent = new GuiPageComponent();
                    tempComponent.setComponentType(tempNode.getLocalName().toUpperCase());
                    tempComponent.setComponentId(newID);
                    guiPage.addGuiPageComponent(tempComponent);
                    infoBag.newComponentList.add(newID);
                }
               
                if(tempNode.getChildNodes().getLength() > 0 && !tempNode.getLocalName().toUpperCase().equals(REGION)){
                   // if the component is region or table, we should keep their id when saving their children...
                   if(tempNode.getLocalName().toUpperCase().equals(TABLE)) {
                       if(configureGuiPageComponents(guiPage, tempNode.getChildNodes(), newID + ":", infoBag) == false) {
                           return false;
                       }
                   }
                   else {
                       if(configureGuiPageComponents(guiPage, tempNode.getChildNodes(), parentID, infoBag) == false) {
                           return false;
                       }
                   }
                       
                }
                else if(tempNode.getLocalName().toUpperCase().equals(REGION)){
                    if(configureGuiPageRegionComponent(guiPage,tempNode, infoBag, newID) == false)
                        return false;
                }
            }
            else {
                if(tempNode.getChildNodes().getLength() > 0){
                    // if current node(component) does not have id, check child nodes..
                    if(configureGuiPageComponents(guiPage, tempNode.getChildNodes(), parentID, infoBag) == false)
                        return false;
                }
            }
        }
        return true;
    }


    /**
     * Updates Gui Page components, by searching used Region's components.
     * @param guiPage
     * @param regionComponentNode
     * @param infoBag
     * @param newID
     * @return
     */
    public static boolean configureGuiPageRegionComponent(GuiPage guiPage, Node regionComponentNode, PageComponentManagerInfoBag infoBag, String newID) {
        String regionType = regionComponentNode.getAttributes().getNamedItem(REGIONTYPE).getNodeValue();
        // we will not be checking commonly used regions..
        if(!regionType.toUpperCase().equals(REGIONTYPE_RGMENUGLOBAL) && !regionType.toUpperCase().equals(REGIONTYPE_RGBRANDING) 
        && !regionType.toUpperCase().equals(REGIONTYPE_RGCOPYRIGHT) &&  !regionType.toUpperCase().equals(REGIONTYPE_RGPRIVACY) 
        && !regionType.toUpperCase().equals(REGIONTYPE_RGABOUT) && !regionType.toUpperCase().equals(REGIONTYPE_RGINFOUSER))
        {
            // if this node is region, than we need to check region page as well, in order to save components within that region..
            if(infoBag.regionMetaData == null){
                // load region meta data file to infobag once, we do not need to load that everytime when we are checking region component..
                StringBuffer sb = new StringBuffer(infoBag.getcodePath());
                sb.append(REGIONMETADATA_FILEPATH);
                Document regionMetaData;
            try {
                regionMetaData = getDocument(sb.toString());
            } catch (FileNotFoundException e) {
                log.error(e.getLocalizedMessage(), e);
                FacesUtil.addFacesErrorMessage("GuiManager.errorMessage.PageNotFound");
                return false;
            }
            infoBag.regionMetaData = regionMetaData;
            }
            if(infoBag.regionMetaData != null){
                // find current region component's file path..
                NodeList regionNode;
                try {
                    regionNode = 
                            getNodeListFromDocument(infoBag.regionMetaData,infoBag.getxPath(), COMPONENTTYPE_NODEPATH+"[. = '"+regionType+"']");
                } catch (XPathExpressionException e) {
                    log.error(e.getLocalizedMessage(), e);
                    FacesUtil.addFacesErrorMessage("GuiManager.errorMessage.UnableToParseFile");
                    return false;
                }
                if(regionNode != null && regionNode.getLength() == 1 && regionNode.item(0).getParentNode() != null) {
                    Element parentRegionNode = (Element)regionNode.item(0).getParentNode();
                    if(parentRegionNode.getElementsByTagName(COMPONENTEXTENSION_NODENAME).getLength() != 0) {
                        Element elementComponentExt = (Element)parentRegionNode.getElementsByTagName(COMPONENTEXTENSION_NODENAME).item(0);
                        
                        if(elementComponentExt.getElementsByTagName(REGIONJSPPATH_NODENAME).getLength() != 0) {
                            Node regionPathNode = elementComponentExt.getElementsByTagName(REGIONJSPPATH_NODENAME).item(0);
                            if(!regionPathNode.getChildNodes().item(0).getNodeValue().equals("")) {
                                // load current region component's file..
                                StringBuffer sb1 = new StringBuffer(infoBag.getcodePath());
                                sb1.append(regionPathNode.getChildNodes().item(0).getNodeValue());
                                Document regionDoc;
                                try {
                                    regionDoc = getDocument(sb1.toString());
                                } catch (FileNotFoundException e) {
                                    log.error(e.getLocalizedMessage(), e);
                                    FacesUtil.addFacesErrorMessage("GuiManager.errorMessage.PageNotFound");
                                    return false;
                                }
                            if(regionDoc != null) {
                                    // call saveComponents function to save all region - components to db..
                                    if(configureGuiPageComponents(guiPage, regionDoc.getChildNodes(), newID + ":", infoBag) == false) {
                                        return false;    
                                    }
                                }
                                else {
                                    FacesUtil.addFacesErrorMessage("GuiManager.errorMessage.NoRegionFile");
                                    return false;
                                }
                            }
                            else {
                                FacesUtil.addFacesErrorMessage("GuiManager.errorMessage.NoRegionFilePath");
                                return false;
                            }
                        }
                        else {
                            FacesUtil.addFacesErrorMessage("GuiManager.errorMessage.ErrorInRegionMetaData");
                            return false;
                        }
                    }
                    else{
                        FacesUtil.addFacesErrorMessage("GuiManager.errorMessage.ErrorInRegionMetaData");
                        return false;
                    }
                }
                else{
                    FacesUtil.addFacesErrorMessage("GuiManager.errorMessage.ErrorInRegionMetaData");
                    return false;
                }
            }
            else {
                FacesUtil.addFacesErrorMessage("GuiManager.errorMessage.NoRegionMetaDataFile");
                return false;
            }
        }
        return true;
    }



    /**
     * searches Gui Page component list to find component with the specified id.
     * @param guiPage
     * @param newID
     * @return
     */
    public static GuiPageComponent findGuiPageComponentById(GuiPage guiPage, String newID ) {
        List<GuiPageComponent> componentList = guiPage.getGuiPageComponentList();
        for(GuiPageComponent tc: componentList) {
            if(tc.getComponentId().equals(newID)) {
                return tc;
            }
        }
        return null;
    }


    /**
     * deletes dummy components from Gui Page, new components should be send as a list. this method should be called after configureGuiPageComponents method.
     * @param guiPage
     * @param newComponentIdList
     */
    public static void deleteDummyComponentsFromGuiPage(GuiPage guiPage, List<String> newComponentIdList) {
        // remove dummy components from list..
        List<GuiPageComponent> componentListToDelete = 
            new ArrayList<GuiPageComponent>();

        for (GuiPageComponent gpc: guiPage.getGuiPageComponentList()) {

            if (!newComponentIdList.contains(gpc.getComponentId())) {
                componentListToDelete.add(gpc);
            }
        }
        if (componentListToDelete.size() > 0) {
            for (GuiPageComponent componentToDelete: componentListToDelete) {
                guiPage.getGuiPageComponentList().remove(componentToDelete);
            }
        }
        
    }

    /**
     * gets the document which exists in the specified path.
     * @param path
     * @return
     * @throws FileNotFoundException
     */
    public static Document getDocument(String path) throws FileNotFoundException {
        if(path != null && !path.equals(""))
        {

            File f = new File(path);
            FileInputStream fi = null;
        
            fi = new FileInputStream(f);
                
            Document doc = parse(fi);
            
            return doc;
        }
        return null;       
    }
    
    
    /**
     * parse inputstream to document
     * @param is
     * @return
     */
    public static Document parse (InputStream is) {
        Document ret = null;
        DocumentBuilderFactory domFactory;
        DocumentBuilder builder;

        try {
            domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setValidating(false);
            domFactory.setNamespaceAware(true); 
            builder = domFactory.newDocumentBuilder();

            ret = builder.parse(is);
        }
        catch (Exception ex) {
            log.error(ex.getLocalizedMessage(), ex);
           FacesUtil.addFacesErrorMessage("GuiManager.errorMessage.UnableToParseFile");
           return null;
        }
        
        return ret;
    }
        
    
    /**
     * Returns a nodelist from document by checking expression..
     * @param doc
     * @param xPath
     * @param expression
     * @return
     * @throws XPathExpressionException
     */
    public static NodeList getNodeListFromDocument(Document doc, XPath xPath, String expression) throws XPathExpressionException {
        
        NodeList nodes;
        nodes = (NodeList) xPath.evaluate(expression, doc.getDocumentElement(), XPathConstants.NODESET);
        return nodes;
        
    }

    
}
