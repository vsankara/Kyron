package com.technobrain.trips.gui.helper;

import com.technobrain.trips.util.FacesUtil;

import java.net.URL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;

import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class PageComponentManagerInfoBag {

    private static final String WEBINF = "WEB-INF";
    private static final String XMLNS_H_URL = "http://java.sun.com/jsf/html";
    private static final String XMLNS_F_URL = "http://java.sun.com/jsf/core";
    private static final String XMLNS_AF_URL = "http://xmlns.oracle.com/adf/faces";
    private static final String XMLNS_AFH_URL = "http://xmlns.oracle.com/adf/faces/html";
    private static final String XMLNS_JSP_URL = "http://java.sun.com/JSP/Page";
    private static final String XMLNS_H = "h";
    private static final String XMLNS_F = "f";
    private static final String XMLNS_AF = "af";
    private static final String XMLNS_AFH = "afh";
    private static final String XMLNS_JSP = "jsp";
    
    
    List<String> newComponentList = new ArrayList<String>();
    private XPath xPath;
    private String codePath;
    Document regionMetaData;
    
    
    /**
     * This is a small class which will be used to carry information when saving Gui Page / Gui Components to database..
     */
    public PageComponentManagerInfoBag() {
    }
    
    
    /*
     * CodePath of the application..
     */
    public String getcodePath() {
       if(codePath == null || codePath.equals(""))
       {
            URL codePathURL = this.getClass().getProtectionDomain().getCodeSource().getLocation();
            codePath = codePathURL.getPath();
    
            
            if(codePath.indexOf(WEBINF) > 0) {
                codePath = codePath.substring(0,codePath.indexOf(WEBINF) - 1);
            }
            else {
                FacesUtil.addFacesErrorMessage("GuiManager.errorMessage.CodePathError");
                codePath = "";
            }
       }
       return codePath;
    }
    
    /*
     * xPath which contains commonly used namespaces..
     */
    public XPath getxPath() {
        if(xPath == null) {
            XPathFactory factory = XPathFactory.newInstance();
            xPath = factory.newXPath();
            NodeList nodes;
            
            NamespaceContext ns  = new NamespaceContext() {
                public String getNamespaceURI(String prefix) {
                    String uri;
                    if(prefix.equals(XMLNS_H))
                        uri = XMLNS_H_URL;
                    else if(prefix.equals(XMLNS_F))
                        uri = XMLNS_F_URL;
                    else if(prefix.equals(XMLNS_AF))
                        uri = XMLNS_AF_URL;
                    else if(prefix.equals(XMLNS_AFH))
                        uri = XMLNS_AFH_URL;
                    else if(prefix.equals(XMLNS_JSP))
                        uri = XMLNS_JSP_URL;
                    else 
                        uri = null; 
                    return uri;
                }
                
                public Iterator getPrefixes (String val) {
                    return null;
                }
                
                public String getPrefix(String uri) {
                    return null;
                }
            };
        
        
            xPath.setNamespaceContext(ns);
        }
        return xPath;
    }
    public void setxPath(XPath value) {
        xPath = value;
    }

    public void setNewComponentList(List<String> newComponentList) {
        this.newComponentList = newComponentList;
    }

    public List<String> getNewComponentList() {
        return newComponentList;
    }
}
