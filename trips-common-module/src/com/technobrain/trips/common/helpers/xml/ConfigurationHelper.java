package com.technobrain.trips.common.helpers.xml;


import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import com.sun.org.apache.xpath.internal.XPathAPI;

import com.sun.org.apache.xpath.internal.objects.XObject;

import java.io.*;

import java.util.*;

import org.w3c.dom.*;

import org.xml.sax.*;

import javax.xml.parsers.*;

import javax.xml.transform.*;
import org.apache.log4j.Logger;

public class ConfigurationHelper {
    static final Logger log = Logger.getLogger(ConfigurationHelper.class);

    XPathAPI xpathAPI;
    Document dom;
    Element currentPath;
    private String pathPrefix = "";

    public ConfigurationHelper() {
    }

    public ConfigurationHelper(String pathPrefix) {
        this.pathPrefix = pathPrefix;
    }

    public void createDom(InputStream in) throws XMLAccessException {

        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = fact.newDocumentBuilder();

            dom = db.parse(in);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new XMLAccessException("Error instantiating XML parser, " + 
                                         ex);
        }
    }


    public void createDomFromFile(String filename) throws XMLAccessException {

        try {
            FileInputStream in = new FileInputStream(filename);

            createDom(in);
        } catch (FileNotFoundException ex) {
            throw new XMLAccessException("Configuration file " + filename + 
                                         " not found");
        } catch (SecurityException ex) {
            throw new XMLAccessException("Security Exception accessing " + 
                                         filename);
        }
    }


    public void createDomFromString(String xml) throws XMLAccessException {

        ByteArrayInputStream in = null;

        try {
            in = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new XMLAccessException(e.getMessage());
        }
        createDom(in);
    }

    public void setDom(Document dom) {
        this.dom = dom;
    }

    /**
     * Accessor method for the DOM variable.
     * Normally, you should use the other public methods of this class to access the DOM.
     *
     * @return org.w3c.dom.Document - The DOM.
     **/
    public Document getDom() {
        return dom;
    }

    /**
     *
     * Initialises the XPath API for use.
     *
     */
    private void initXPath() {

        if (xpathAPI == null) {
            xpathAPI = new XPathAPI();
        }
    }

    /**
     * This method returns the name of the Root element of the XML tree.
     * <p>
     * Use this method to check whether the configuration file contains the right
     * XML document.
     *
     * @return String name- The name of the root node.
     */
    public String getBaseElement() {

        NodeList nodes = dom.getChildNodes();
        Node node = null;

        for (int eachNode = nodes.getLength() - 1; eachNode >= 0; eachNode--) {
            node = nodes.item(eachNode);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                break;
            }
        }

        return node.getNodeName();
    }

    /**
     * Sets the current working node of the ConfigurationHelper
     *
     * @return XObject - an XML object of unknown type.
     */
    private XObject processXPath(String xpath) throws TransformerException {

        initXPath();

        return xpathAPI.eval(dom, xpath);
    }

    public String getElement(String elementName) throws XMLAccessException {

        if (currentPath == null) {
            throw new XMLAccessException("XML get element called before setting path");
        }

        Node elemNode = null;
        NodeList nodes = currentPath.getChildNodes();
        boolean found = false;

        for (int eachNode = nodes.getLength() - 1; eachNode >= 0; eachNode--) {
            elemNode = nodes.item(eachNode);

            if ((elemNode.getNodeType() == Node.ELEMENT_NODE) && 
                elemNode.getNodeName().equals(elementName)) {
                found = true;

                break;
            }
        }

        StringBuffer outStr = new StringBuffer();

        if (found) {
            nodes = elemNode.getChildNodes();

            Node textNode = null;

            for (int eachNode = nodes.getLength() - 1; eachNode >= 0; 
                 eachNode--) {
                textNode = nodes.item(eachNode);

                if (textNode.getNodeType() == Node.TEXT_NODE) {
                    outStr.append(textNode.getNodeValue());
                }
            }
        }

        String resultStr = outStr.toString();

        if ((resultStr != null) && (resultStr.length() == 0)) {
            resultStr = null;
        }

        return resultStr;
    }

    /**
     * Mutator method for setting the current working node.
     * <p>
     * The xpath statement should yield zero or one nodes.
     */
    public void setPath(String xPath) throws XMLAccessException {
        setPath(xPath, null);
    }

    /**
     * Checks if a current working node exists.
     * <p>
     * Use this method after a call to the setPath() method to check whether
     * the xpath yields a node.
     *
     * @return boolean - True or False
     */
    public boolean pathExists() {
        return (currentPath != null);
    }

    /**
     * Mutator method for the configuration of XPath API.
     * <p>
     * Generally used to set a specific node as the current working node and
     * to add new nodes to it.
     */
    public void setPath(String xPath, 
                        String newPath) throws XMLAccessException {
        xPath = pathPrefix + xPath;
        try {
            XObject xObj = processXPath(xPath);
            NodeList nodes = xObj.nodelist();
            Node node = null;

            currentPath = null;

            for (int eachNode = nodes.getLength() - 1; eachNode >= 0; 
                 eachNode--) {
                node = nodes.item(eachNode);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    currentPath = (Element)node;

                    break;
                }
            }

            if ((currentPath != null) && (newPath != null)) {
                StringTokenizer strTok = 
                    new StringTokenizer(newPath, "/", false);
                String elemStr = null;
                Element elemNode;

                while (strTok.hasMoreTokens()) {
                    elemStr = strTok.nextToken();
                    elemNode = dom.createElement(elemStr);

                    currentPath.appendChild(elemNode);

                    currentPath = elemNode;
                }
            }
        } catch (TransformerException ex) {
            throw new XMLAccessException("Transformer Exception");
        }
    }

    public void setElement(String elementName, 
                           String value) throws SAXException, 
                                                XMLAccessException {

        if (currentPath == null) {
            throw new XMLAccessException("XML set element called before setting path");
        }

        Node node = null;
        NodeList nodes = currentPath.getChildNodes();
        Element newNode = null;

        for (int eachNode = nodes.getLength() - 1; eachNode >= 0; eachNode--) {
            node = nodes.item(eachNode);

            if ((node.getNodeType() == Node.ELEMENT_NODE) && 
                node.getNodeName().equals(elementName)) {
                newNode = (Element)node;

                break;
            }
        }

        if (newNode == null) {
            newNode = dom.createElement(elementName);

            currentPath.appendChild(newNode);
        } else {
            nodes = newNode.getChildNodes();

            for (int eachNode = nodes.getLength() - 1; eachNode >= 0; 
                 eachNode--) {
                node = nodes.item(eachNode);

                if (node.getNodeType() == Node.TEXT_NODE) {
                    newNode.removeChild(node);
                }
            }
        }

        Node textNode = dom.createTextNode(value);

        newNode.appendChild(textNode);
    }

    public String getDomAsString() throws IOException {

        StringWriter exportStrWriter = new StringWriter();
        OutputFormat format = new OutputFormat();

        format.setIndenting(false);

        XMLSerializer serializer = new XMLSerializer(exportStrWriter, format);

        serializer.serialize(dom);

        return exportStrWriter.toString();
    }

    public static void main(String[] args) {

        ConfigurationHelper helper = new ConfigurationHelper();

        try {
            helper.createDomFromString("<?xml version=\"1.0\" encoding=\"UTF-8\"?><test-xml><test-text>does this work</test-text><test-text>maybe</test-text></test-xml>");
            helper.setPath("/test-xml");

            helper.setPath("/test-xml", "sprouts/onions");
            helper.setElement("parsley", "Wombat yabba");
            Document dom = helper.getDom();
            StringWriter exportStrWriter = new StringWriter();
            OutputFormat format = new OutputFormat();

            format.setIndenting(false);

            XMLSerializer serializer = 
                new XMLSerializer(exportStrWriter, format);

            serializer.serialize(dom);

        } catch (Exception ex) {
            log.error(ex.getLocalizedMessage(), ex);
        }
    }

    public String getCurrentElementValue() throws XMLAccessException {
        if (currentPath == null) {
            throw new XMLAccessException("XML set element called before setting path");
        }
        return currentPath.getFirstChild().getNodeValue();
    }

    public String getAttribute(String attributeName) throws XMLAccessException {
        if (currentPath == null) {
            throw new XMLAccessException("XML set element called before setting path");
        }
        return currentPath.getAttribute(attributeName);
    }


    public NodeList getChildNodes() throws XMLAccessException {
        if (currentPath == null) {
            throw new XMLAccessException("XML set element called before setting path");
        }
        return currentPath.getChildNodes();
    }


    public void setPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
    }

    public String getPathPrefix() {
        return pathPrefix;
    }
}


