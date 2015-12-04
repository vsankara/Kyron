package com.technobrain.trips.common.helpers.xml;

/** @author Lokesh Paliwal
 * @version 1.0
 */

public class XMLHelper {
  private static final String ENTITY_AND="&amp;";
  private static final String ENTITY_GREATER_THAN="&gt;";
  private static final String ENTITY_LESS_THAN="&lt;";
  private static final String ENTITY_SINGLE_QUOTE="&apos;";
  private static final String ENTITY_DOUBLE_QUOTE="&quot;";

  private static String getStartTag(String tagName){
    if (tagName==null)
      return null;
    String startTag="<"+tagName+">";
    return startTag;
  }

  private static String getEndTag(String tagName){
    if (tagName==null)
      return null;
    String startTag="</"+tagName+">";
    return startTag;
  }
  public static String getXMLElement(String tagName,String value){
    if (tagName==null)
      return null;
    if(value==null){
      value="";
    }
    String strXMlElement=getStartTag(tagName)+value+getEndTag(tagName);
    return strXMlElement;
  }

  public static String encodeXML(String value){
    if(value==null){
      return null;
    }
    int andPos=value.indexOf('&');
    int gtPos=value.indexOf('>');
    int ltPos=value.indexOf('<');
    int singleQuotePos=value.indexOf('\'');
    int doubleQuotePos=value.indexOf('\"');
    if(andPos<0 && gtPos<0 && ltPos<0 && singleQuotePos<0 && doubleQuotePos<0){
      return value;
    }
    StringBuffer returnValue=new StringBuffer(); ;
    for(int count=0;count<value.length();count++){
      char tempChar=value.charAt(count);
      String encodedChar=getEncodedChar(tempChar);
      returnValue.append(encodedChar);
    }
    return returnValue.toString();
  }

  private static String getEncodedChar(char value){
    if(value=='&'){
      return ENTITY_AND;
    }
    if(value=='<'){
      return ENTITY_LESS_THAN;
    }
    if(value=='>'){
      return ENTITY_GREATER_THAN;
    }
    if(value=='\''){
      return ENTITY_SINGLE_QUOTE;
    }
    if(value=='\"'){
      return ENTITY_DOUBLE_QUOTE;
    }
    return String.valueOf(value);
  }
}

