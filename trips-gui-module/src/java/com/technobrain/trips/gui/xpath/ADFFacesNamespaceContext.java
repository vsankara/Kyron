package com.technobrain.trips.gui.xpath;

import java.util.Iterator;
import javax.xml.*;
import javax.xml.namespace.NamespaceContext;

/**
 * Allows the xpath api to find xml elements of namespace
 * http://xmlns.oracle.com/adf/faces e.g 
 * <code> af:inputText </code>
 * @author hhill
 */
public class ADFFacesNamespaceContext implements NamespaceContext {

    public String getNamespaceURI(String prefix) {
        if (prefix == null) throw new NullPointerException("Null prefix");
        else if ("af".equals(prefix)) return "http://xmlns.oracle.com/adf/faces";
        else if ("xml".equals(prefix)) return XMLConstants.XML_NS_URI;
        return XMLConstants.NULL_NS_URI;
    }

    // This method isn't necessary for XPath processing.
    public String getPrefix(String uri) {
        throw new UnsupportedOperationException();
    }

    // This method isn't necessary for XPath processing either.
    public Iterator getPrefixes(String uri) {
        throw new UnsupportedOperationException();
    }
 
}
