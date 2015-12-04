package com.technobrain.trips.common.helpers;

import com.technobrain.trips.common.constants.Constants;

import java.math.BigDecimal;

import java.text.DecimalFormatSymbols;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

public class StringHelper {
    static final Logger log = Logger.getLogger(StringHelper.class);

  public static String quoted(String val) {

    if ( (val == null) || val.equals("")) {
      return "''";
    }

    String rtnStr = val;
    String pattern = "'";
    String pfx, sfx;
    int pos = rtnStr.indexOf(pattern);

    while (pos >= 0) {
      pfx = rtnStr.substring(0, pos);
      sfx = rtnStr.substring(pos + 1);

      // Double the quote and look for the next one.
      rtnStr = pfx + "''" + sfx;
      pos = rtnStr.indexOf(pattern, pos + 2);
    }

    // Add surrounding quotes.
    rtnStr = "'" + rtnStr + "'";

    return (rtnStr);
  }

  public static String replaceSingleQuotesForSQL(String val) {

    if ( (val == null) || val.equals("")) {
      return "";
    }

    String rtnStr = val;
    String pattern = "'";
    String pfx, sfx;
    int pos = rtnStr.indexOf(pattern);

    while (pos >= 0) {
      pfx = rtnStr.substring(0, pos);
      sfx = rtnStr.substring(pos + 1);

      // Double the quote and look for the next one.
      rtnStr = pfx + "''" + sfx;
      pos = rtnStr.indexOf(pattern, pos + 2);
    }

    return (rtnStr);
  }

    public static String replaceSingleQuotesForJavaScript(String val) {

        if ((val == null) || val.equals("")) {
            return "";
        }

        String rtnStr = val;
        String pattern = "'";
        String pfx, sfx;
        int pos = rtnStr.indexOf(pattern);

        while (pos >= 0) {
            pfx = rtnStr.substring(0, pos);
            sfx = rtnStr.substring(pos + 1);

            rtnStr = pfx + "\\'" + sfx;
            pos = rtnStr.indexOf(pattern, pos + 2);
        }

        return (rtnStr);
    }
  
    // TODO rewrite the following methods with match(String RegEx) method
  
    public static boolean isAlphabetic(final String s) {
        final char[] chars = s.toCharArray();
        for (int x = 0; x < chars.length; x++) {
            final char c = chars[x];
            if ((c >= 'a') && (c <= 'z'))
                continue; // lowercase
            if ((c >= 'A') && (c <= 'Z'))
                continue; // uppercase
            return false;
        }
        return true;
    }
    
    public static boolean isNumeric(final String s) {
        // regex to check whether a string is numeric or not.
        Pattern p = Pattern.compile("(-|\\+)?[0-9]+(\\.[0-9]+)?");
        Matcher m = p.matcher(s);
        return m.matches();
        /*
        final char[] chars = s.toCharArray();
        for (int x = 0; x < chars.length; x++) {
            final char c = chars[x];
            if ((c >= '0') && (c <= '9'))
                continue; // numeric
            if ((c == ','))
                continue; // comma
            if ((c == '.'))
                continue; // dot
            if ((c == '-'))
                continue; // dash
            return false;
        }
        return true;*/
    }

    public static boolean isAlphaNumeric(final String s) {
        if (s.matches("[A-Za-z0-9]*")) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean isAlphaNumericOrSpace(final String s) {
        final char[] chars = s.toCharArray();
        for (int x = 0; x < chars.length; x++) {
            final char c = chars[x];
            if ((c >= 'a') && (c <= 'z'))
                continue; // lowercase
            if ((c >= 'A') && (c <= 'Z'))
                continue; // uppercase
            if ((c >= '0') && (c <= '9'))
                continue; // numeric
            if (c == ' ')
                continue;
            return false;
        }
        return true;
    }
    
    public static boolean isValidHouseNumber(final String s) {
        final char[] chars = s.toCharArray();
        for (int x = 0; x < chars.length; x++) {
            final char c = chars[x];
            if ((c >= 'a') && (c <= 'z'))
                continue; // lowercase
            if ((c >= 'A') && (c <= 'Z'))
                continue; // uppercase
            if ((c >= '0') && (c <= '9'))
                continue; // numeric
            if ((c == '-'))
                continue; // dash
            if ((c == ' '))
                continue; // space
            if ((c == '/'))
                continue; // slash
            return false;
        }
        return true;
    }
    
    public static boolean isValidCityName(final String s) {
        final char[] chars = s.toCharArray();
        for (int x = 0; x < chars.length; x++) {
            final char c = chars[x];
            if ((c >= 'a') && (c <= 'z'))
                continue; // lowercase
            if ((c >= 'A') && (c <= 'Z'))
                continue; // uppercase
            if ((c == '-'))
                continue; // dash
            if ((c == ' '))
                continue; // space
            if ((c == '\''))
                continue; // apostrophe
            return false;
        }
        return true;
    }
    
    public static boolean isValidAccountHolderName(final String s) {
        final char[] chars = s.toCharArray();
        for (int x = 0; x < chars.length; x++) {
            final char c = chars[x];
            if ((c >= 'a') && (c <= 'z'))
                continue; // lowercase
            if ((c >= 'A') && (c <= 'Z'))
                continue; // uppercase
            if ((c >= '0') && (c <= '9'))
                continue; // numeric
            if ((c == '-'))
                continue; // hyphen
            if ((c == ' '))
                continue; // space
            if ((c == '\''))
                continue; // apostrophe
            return false;
        }
        return true;        
    }
    
    public static boolean isValidLegalName(final String s) {
    
        final char[] chars = s.toCharArray();
        for (int x = 0; x < chars.length; x++) {
            final char c = chars[x];
            if ((c >= 'a') && (c <= 'z'))
                continue; // lowercase
            if ((c >= 'A') && (c <= 'Z'))
                continue; // uppercase
            if ((c >= '0') && (c <= '9'))
                continue; // numeric
            if ((c == '-'))
                continue; // hyphen
            if ((c == ' '))
                continue; // space
            if ((c == '\''))
                continue; // apostrophe
            if ((c == '('))
                continue; // ( - Open Brackets
            if ((c == ')'))
                continue; // ) - Close Brackets
            if ((c == '&'))
                continue; // & - Ampersand
            if ((c == '.'))
                continue; // . - Period
            if ((c == ':'))
                continue; // : - Colon
            if ((c == '_'))
                continue; // _ - Underscore
            if ((c == '/'))
                continue; // / - Forward Slash
            if ((c == '+'))
                continue; // + - Plus
            if ((c == ','))
                continue; // , - Comma
            if ((c == '\\'))
                continue; // \ - Backward Slash
            return false;
        }
        return true;        
    }
    
    public static boolean isValidStreetName(final String s) {
        final char[] chars = s.toCharArray();
        for (int x = 0; x < chars.length; x++) {
            final char c = chars[x];
            if ((c >= 'a') && (c <= 'z'))
                continue; // lowercase
            if ((c >= 'A') && (c <= 'Z'))
                continue; // uppercase
            if ((c >= '0') && (c <= '9'))
                continue; // numeric
            if ((c == '-'))
                continue; // hyphen
            if ((c == ' '))
                continue; // space
            if ((c == '\''))
                continue; // apostrophe
            if ((c == '.'))
                continue; // slash 
            if ((c == ','))
                continue; // slash     
            return false;
        }
        return true;        
    }

    public static String replaceEnterForJavaScript(String val) {

    if ( (val == null) || val.equals("")) {
      return "";
    }

    String rtnStr = val;
    String pattern = "\n";
    String pfx, sfx;
    int pos = rtnStr.indexOf(pattern);

    while (pos >= 0) {
      pfx = rtnStr.substring(0, pos);
      sfx = rtnStr.substring(pos + 1);

      rtnStr = pfx + "\n" + sfx;
      pos = rtnStr.indexOf(pattern, pos + 2);
    }

    return (rtnStr);
  }

  public static String formatNumber(double doubleNo) {
    DecimalFormatSymbols dfsymb = new DecimalFormatSymbols();
    dfsymb.setDecimalSeparator('.');
    dfsymb.setGroupingSeparator(',');
    DecimalFormat df = new DecimalFormat();
    df.setDecimalFormatSymbols(dfsymb);
    df.setMinimumFractionDigits(2);
    df.setGroupingUsed(false);
    return df.format(doubleNo);
  }

  public static String groupFormatNumber(double doubleNo, int numberOfFractionDigits) {
    DecimalFormatSymbols dfsymb = new DecimalFormatSymbols();
    dfsymb.setDecimalSeparator('.');
    dfsymb.setGroupingSeparator(',');
    DecimalFormat df = new DecimalFormat();
    df.setDecimalFormatSymbols(dfsymb);
    df.setMaximumFractionDigits(numberOfFractionDigits);
    df.setMinimumFractionDigits(2);
    return df.format(doubleNo);
  }
    
  public static String groupFormatCurrency(double doubleNo, int numberOfFractionDigits) {
    if(doubleNo<0){
      return "-"+groupFormatNumberWithoutSeparator(Math.abs(doubleNo),numberOfFractionDigits);
    }else{
      return groupFormatNumberWithoutSeparator(doubleNo,numberOfFractionDigits);
    }
  }
  public static String groupFormatNumber(double doubleNo, int numberOfFractionDigits,boolean showNAIFZero) {
    if(doubleNo ==0){
      return Constants.NOT_AVAILABLE;
    }
    DecimalFormatSymbols dfsymb = new DecimalFormatSymbols();
    dfsymb.setDecimalSeparator('.');
    dfsymb.setGroupingSeparator(',');
    DecimalFormat df = new DecimalFormat();
    df.setDecimalFormatSymbols(dfsymb);
    df.setMaximumFractionDigits(numberOfFractionDigits);
    df.setMinimumFractionDigits(2);
    return df.format(doubleNo);
  }

  public static String groupFormatNumber(double doubleNo, int numberOfFractionDigits, int minFractionDigits) {
    DecimalFormatSymbols dfsymb = new DecimalFormatSymbols();
    dfsymb.setDecimalSeparator('.');
    dfsymb.setGroupingSeparator(',');
    DecimalFormat df = new DecimalFormat();
    df.setDecimalFormatSymbols(dfsymb);
    df.setMaximumFractionDigits(numberOfFractionDigits);
    df.setMinimumFractionDigits(minFractionDigits);
    return df.format(doubleNo);
  }
  
    public static String formatBigDecimalByMinMaxFraction(BigDecimal decimalNumber, int numberOfFractionDigits, int minFractionDigits) {
      DecimalFormatSymbols dfsymb = new DecimalFormatSymbols();
      dfsymb.setDecimalSeparator('.');
      dfsymb.setGroupingSeparator(',');
      DecimalFormat df = new DecimalFormat();
      df.setDecimalFormatSymbols(dfsymb);
      df.setMaximumFractionDigits(numberOfFractionDigits);
      df.setMinimumFractionDigits(minFractionDigits);
      return df.format(decimalNumber);
    }

  public static String groupFormatNumberWithoutSeparator(double doubleNo, int numberOfFractionDigits) {
    return groupFormatNumberWithoutSeparator(doubleNo,  numberOfFractionDigits, numberOfFractionDigits);
  }
  public static String groupFormatNumberWithoutSeparator(double doubleNo, int numberOfFractionDigits, int minFractionDigits) {
    DecimalFormatSymbols dfsymb = new DecimalFormatSymbols();
    dfsymb.setDecimalSeparator('.');
    DecimalFormat df = new DecimalFormat();
    df.setDecimalFormatSymbols(dfsymb);
    df.setMaximumFractionDigits(numberOfFractionDigits);
    df.setGroupingUsed(false);
    df.setMaximumFractionDigits(numberOfFractionDigits);
    df.setMinimumFractionDigits(minFractionDigits);
    return df.format(doubleNo);
  }

  public static String groupFormatNumber(double doubleNo) {
    DecimalFormatSymbols dfsymb = new DecimalFormatSymbols();
    dfsymb.setDecimalSeparator('.');
    dfsymb.setGroupingSeparator(',');
    DecimalFormat df = new DecimalFormat();
    df.setDecimalFormatSymbols(dfsymb);
    df.setMaximumFractionDigits(2);
    df.setMinimumFractionDigits(2);
    return df.format(doubleNo);
  }

  public static String positiveGroupFormatNumber(double doubleNo) {
    DecimalFormatSymbols dfsymb = new DecimalFormatSymbols();
    dfsymb.setDecimalSeparator('.');
    dfsymb.setGroupingSeparator(',');
    DecimalFormat df = new DecimalFormat();
    df.setDecimalFormatSymbols(dfsymb);
    df.setMaximumFractionDigits(2);
    df.setMinimumFractionDigits(2);
    return df.format(doubleNo*-1);
  }

  public static String groupFormatNumber(double doubleNo,boolean showNa) {
    if(showNa) {
      if(doubleNo ==0) {
	return Constants.NOT_AVAILABLE;
      }
    }
    DecimalFormatSymbols dfsymb = new DecimalFormatSymbols();
    dfsymb.setDecimalSeparator('.');
    dfsymb.setGroupingSeparator(',');
    DecimalFormat df = new DecimalFormat();
    df.setDecimalFormatSymbols(dfsymb);
    df.setMaximumFractionDigits(2);
    df.setMinimumFractionDigits(2);
    return df.format(doubleNo);
  }

  public static String positiveGroupFormatNumber(double doubleNo,boolean showNa) {
    if(showNa) {
      if(doubleNo ==0) {
	return Constants.NOT_AVAILABLE;
      }
    }
    DecimalFormatSymbols dfsymb = new DecimalFormatSymbols();
    dfsymb.setDecimalSeparator('.');
    dfsymb.setGroupingSeparator(',');
    DecimalFormat df = new DecimalFormat();
    df.setDecimalFormatSymbols(dfsymb);
    df.setMaximumFractionDigits(2);
    df.setMinimumFractionDigits(2);
//     df.setGroupingUsed(false);
    return df.format(doubleNo*-1);
  }

  public static String groupFormatNumber(String doubleNo) {
    return groupFormatNumber(Double.parseDouble(doubleNo));
  }

  public static String groupFormatNumber(String doubleNo, int numberOfFractionDigits, int minFractionDigits) {
    return groupFormatNumber(Double.parseDouble(doubleNo), numberOfFractionDigits, minFractionDigits);
  }

  public static String formatNumber(Double doubleNo) {
    return formatNumber(doubleNo.doubleValue());
  }

  public static String getHTMLDisplayString(String inputStr) {
    if (inputStr != null) {
      StringBuffer sb = new StringBuffer(inputStr);
      while (sb.toString().indexOf("\n") != -1) {
        int i = sb.toString().indexOf("\n");
        sb.delete(i, i + 1);
        sb.insert(i, "<BR>");
      }
      return sb.toString();
    }
    return "";
  }

  public static String getHTMLDisplayStringForNewLine(String inputStr) {
   if (inputStr != null) {
     StringBuffer sb = new StringBuffer(inputStr);
     while (sb.toString().indexOf("<BR>") != -1) {
       int i = sb.toString().indexOf("<BR>");
       sb.delete(i, i + 4);
       sb.insert(i, "\n");
     }
     while (sb.toString().indexOf("<br>") != -1) {
          int i = sb.toString().indexOf("<br>");
          sb.delete(i, i + 4);
          sb.insert(i, "\n");
        }

     return sb.toString();
   }
   return "";
 }


  public static String getTextDisplayString(String inputStr) {
    try{
      if (inputStr != null) {
        StringBuffer sb = new StringBuffer(inputStr);
        while (sb.toString().indexOf("<BR>") != -1) {
          int i = sb.toString().indexOf("<BR>");
          sb.delete(i, i + 4);
          sb.insert(i, " ");
        }
        while (sb.toString().indexOf("<br>") != -1) {
          int i = sb.toString().indexOf("<br>");
          sb.delete(i, i + 4);
          sb.insert(i, " ");
        }
        while (sb.toString().indexOf("<Br>") != -1) {
          int i = sb.toString().indexOf("<Br>");
          sb.delete(i, i + 4);
          sb.insert(i, " ");
        }

        while (sb.toString().indexOf("<p>") != -1) {
          int i = sb.toString().indexOf("<p>");
          sb.delete(i, i + 3);
          sb.insert(i, " ");
        }
        while (sb.toString().indexOf("<P>") != -1) {
          int i = sb.toString().indexOf("<P>");
          sb.delete(i, i + 3);
          sb.insert(i, " ");
        }
        while (sb.toString().indexOf("</p>") != -1) {
          int i = sb.toString().indexOf("</p>");
          sb.delete(i, i + 4);
          sb.insert(i, " ");
        }
        while (sb.toString().indexOf("</P>") != -1) {
          int i = sb.toString().indexOf("</P>");
          sb.delete(i, i + 4);
          sb.insert(i, " ");
        }

        while (sb.toString().indexOf(13) != -1) {
          int i = sb.toString().indexOf(13);
          sb.delete(i, i + 1);
          sb.insert(i, " ");
        }
        while (sb.toString().indexOf(10) != -1) {
          int i = sb.toString().indexOf(10);
          sb.delete(i, i + 1);
          sb.insert(i, " ");
        }

        return sb.toString();
      }
    }catch(Exception exp){
      return inputStr;
    }
    return "";
  }

  public static String getStringReplaceAll(String inputStr, String replaceWith, String strFor) {
    StringBuffer outputStr = new StringBuffer();
    if (inputStr != null) {
      StringBuffer sb = new StringBuffer(inputStr);
      while (sb.toString().indexOf(strFor) != -1) {
        int i = sb.toString().indexOf(strFor);
        sb.delete(i, i + strFor.length());
        sb.insert(i, replaceWith);
        outputStr.append(sb.substring(0, i + replaceWith.length()));
        sb = new StringBuffer(sb.substring(i + replaceWith.length()));
      }
      return outputStr.toString() + sb.toString();
    }
    return null;
  }

  public static String returnNAIfNull(String inputStr) {

    if (inputStr == null) {
      return "n/a";
    }
    else {
      return inputStr;
    }
  }

  public static String returnNAIfNullOrBlank(String inputStr) {

    if (returnBlankIfNull(inputStr).trim().equals(Constants.BLANK)) {
      return "n/a";
    }
    else {
      return inputStr;
    }
  }

  public static String returnTodaysDateIfNullOrBlank(String inputStr) {
    if (returnBlankIfNull(inputStr).trim().equals(Constants.BLANK)) {
      return DateHelper.getFormattedDate(new Date());
    }
    else {
      return inputStr;
    }
  }

    public static boolean isNullOrEmptyString(String checkStr) {
        if(null == checkStr || checkStr.length() == 0)
            return true;
        return false;
    }

  /**
     * Takes in a plural string and if the value is less than 2 returns
     * the lower case with the ending 's' removed.
     * @param inputStr
     * @param value
     * @return String
     */
  public static String getSingularString(String inputStr, String value) {
    String singularString = inputStr.toLowerCase();
    double doubleVal = 0;
    if (value != null) {
      doubleVal = Double.parseDouble(value);
    }
    if (doubleVal < 2) {
      singularString = singularString.substring(0, singularString.length() - 1);
    }
    return singularString;
  }

  public static String formatDate(Date date) {
    if (date == null)
      return null;
    // SimpleDateFormat formatter = new SimpleDateFormat(Constants.DEFAULT_DATE_FORMAT);
    // Constants.DEFAULT_DATE_FORMAT removed so that it can pick up the default according to the locale
    // right now it was giving problems for locals which uses "." as seperatior instead of "/"
    SimpleDateFormat formatter = new SimpleDateFormat();   
    String dateString = formatter.format(date);
    return dateString;
  }

  public static String formatDateWithoutTime(Date date) {
    if (date == null)
      return null;
      // SimpleDateFormat formatter = new SimpleDateFormat(Constants.DEFAULT_DATE_FORMAT);
      // Constants.DEFAULT_DATE_FORMAT removed so that it can pick up the default according to the locale
      // right now it was giving problems for locals which uses "." as seperatior instead of "/"
      SimpleDateFormat formatter = new SimpleDateFormat();   
    String dateString = formatter.format(date);
    return dateString;
  }


  public static String[] split(String strInput, String delimiter)
  {
    if (strInput == null || delimiter == null) {
          return null;
        }
        StringTokenizer st = new StringTokenizer(strInput, delimiter);
        String strReturn[] = new String[st.countTokens()];
        int count = 0;

        while (st.hasMoreElements()) {
          String empId = st.nextToken();
          strReturn[count++] = empId;

        }

        return strReturn;
  }

  public static String getSQLInClauseString(String[] strInput) {
    String strReturn = "";
    if (strInput == null)
      return null;
    for (int count = 0; count < strInput.length; count++) {
      String strVal = strInput[count];
      strVal = "'" + strVal + "'";
      strReturn = strReturn + strVal;
      if (count != (strInput.length - 1))
        strReturn = strReturn + ",";
    }
    return strReturn;
  }
  
    public static String getInClauseString(String[] strInput) {
      String strReturn = "";
      if (strInput == null)
        return null;
      for (int count = 0; count < strInput.length; count++) {
        String strVal = strInput[count];
        strReturn = strReturn + strVal;
        if (count != (strInput.length - 1))
          strReturn = strReturn + ",";
      }
      return strReturn;
    }

  public static String getDirecroty(String path) {
    if (path == null) {
      return null;
    }
    int pos = path.lastIndexOf(System.getProperty("file.separator"));
    String root = path.substring(0, pos);
    return root;
  }

  public static String getFileName(String path) {
    if (path == null) {
      return null;
    }
    int pos = path.lastIndexOf(System.getProperty("file.separator"));
    String fileName = path.substring(pos + 1, path.length());
    return fileName;
  }

  public static String replaceAll(String sourceString, String searchFor, String replaceWith) {
    if ( (sourceString == null) || sourceString.equals("")) {
      return "";
    }
    String rtnStr = sourceString;
    String pattern = searchFor;
    String pfx, sfx;
    int pos = rtnStr.indexOf(pattern);

    while (pos >= 0) {
      pfx = rtnStr.substring(0, pos);
      sfx = rtnStr.substring(pos + pattern.length());
      rtnStr = pfx + replaceWith + sfx;
      pos = rtnStr.indexOf(pattern);
    }
    return (rtnStr);
  }

  public static String insertInString(String sourceString, int position, String replaceWith){
    if ( (sourceString == null) || sourceString.equals("")) {
       return "";
     }
     StringBuffer str_test = new StringBuffer(sourceString);
     try{
      str_test.insert(position, replaceWith);

      return str_test.toString();
     }catch (Exception e) {
         log.error(e.getLocalizedMessage(), e);
     }

     return str_test.toString();
  }

  public static String getStringWithFirstLetterCaps(String inputStr) {

    if (inputStr != null) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < inputStr.length(); i++) {
        if (i == 0) {
          sb.append( (inputStr.substring(i, i + 1)).toUpperCase());
        }
        else {
          sb.append( (inputStr.substring(i, i + 1)).toLowerCase());
        }
      }
      return sb.toString();
    }

    return null;
  }

  public static String returnBlankIfNull(String strVal) {
    return strVal == null ? "" : strVal;
  }
  public static String returnDefaultIfNull(String strVal,String defaultValue) {
    return strVal == null ? defaultValue : strVal;
  }

  public static String trimLastChar(String strVal, char characherToBeRemoved) {
    if (strVal == null) {
      return null;
    }
    if (strVal.trim().equals("")) {
      return "";
    }

    char lastChar = strVal.charAt(strVal.length() - 1);
    if (lastChar == characherToBeRemoved) {
      return strVal.substring(0, strVal.length() - 1);
    }
    else {
      return strVal;
    }
  }
  public static String trimFirstAndLastQuote(String strVal) {
    if (strVal == null) {
      return null;
    }
    if (strVal.trim().equals("")) {
      return "";
    }

    char firstChar = strVal.charAt(0);
    if (firstChar == '\'') {
      strVal = strVal.substring(1, strVal.length() - 1);

      String lastChar = strVal.substring(strVal.length() - 1, strVal.length());
      if (lastChar.equals("'")) {
        strVal = strVal.substring(0, strVal.length() - 1);
      }
    }
    return strVal;
  }
  public static String replaceTwoSingleQuotesWithOne(String strVal) {
    if (strVal == null) {
      return null;
    }
    if (strVal.trim().equals("")) {
      return "";
    }

    strVal =  replaceAll(strVal,"''","'");
    return strVal;
  }

  public static String trimLastComma(String strVal) {
    return trimLastChar(strVal, ',');
  }

  
  public static String groupFormatNumber(Double doubleNo, int numberOfFractionDigits, int minFractionDigits) {
     if(doubleNo==null){
       return "0.00";
     }
     return groupFormatNumber(doubleNo.doubleValue(), numberOfFractionDigits, minFractionDigits);
  }
  public static String getYesNo(String value){
    value=returnBlankIfNull(value);
    if(value.equalsIgnoreCase("") ){
      return "No";
    }
    if(value.equalsIgnoreCase(Constants.YES)){
      return "Yes";
    }else if(value.equalsIgnoreCase(Constants.NO)){
      return "No";
    }else{
      return value;
    }
  }
  public static String getTwoDigitNumber(long nbr){
    String strval=String.valueOf(nbr);
    if(strval.length()==1){
      return "0"+nbr;
    }else{
      return String.valueOf(nbr);
    }
  }
  public static String rightPadding(String strInput, int maxlength,String paddingString){
    strInput=StringHelper.returnBlankIfNull(strInput);
    if(strInput.length()>=maxlength){
      return strInput;
    }
    long noOfCharTobePadded=maxlength-strInput.length();
    StringBuffer returnString=new StringBuffer(strInput);
    for(int count=0;count<noOfCharTobePadded;count++){
      returnString.append(paddingString);
    }
    return returnString.toString();
  }
  public static String leftPadding(String strInput, int maxlength,String paddingString){
    strInput=StringHelper.returnBlankIfNull(strInput);
    if(strInput.length()>=maxlength){
      return strInput;
    }
    long noOfCharTobePadded=maxlength-strInput.length();
    StringBuffer returnString=new StringBuffer();
    for(int count=0;count<noOfCharTobePadded;count++){
      returnString.append(paddingString);
    }
    returnString.append(strInput);
    return returnString.toString();
  }


    public static String initCap(String val){
      if(val==null){
        return null;
      }
      String firstChar=val.substring(0,1).toUpperCase() ;
      String remainingChars="";
      if(val.length()>1){
        remainingChars = val.substring(1, val.length());
      }
      return firstChar+remainingChars.toLowerCase();
    }
    public static String getCommaSeperatedString(String val[]){
      return getCharSeperatedString(val,',');
    }
    public static String getCharSeperatedString(String val[],char sepChar){
      if (val ==null){
        return "";
      }
      String delimtedString="";
      for(int count=0;count<val.length;count++){
        delimtedString=delimtedString+val[count]+sepChar;
      }
      delimtedString=trimLastChar(delimtedString,sepChar);
      return delimtedString;
    }
    public static String getCommaSeperatedLong(long val[]){
      return getCharSeperatedLong(val,',');
    }
    public static String getCharSeperatedLong(long val[],char sepChar){
      if (val ==null){
        return "";
      }
      String delimtedString="";
      for(int count=0;count<val.length;count++){
        delimtedString=delimtedString+val[count]+sepChar;
      }
      delimtedString=trimLastChar(delimtedString,sepChar);
      return delimtedString;
    }

  public static double getPoundSymbolAndCommaRemoved(String strInput){
    strInput = returnBlankIfNull(strInput);
    if (!strInput.equals(Constants.BLANK)){
      strInput = strInput.replaceAll("£", "");
      strInput = strInput.replaceAll(",", "");

      try{
        return Double.parseDouble(strInput.trim());
      }catch(Exception e){
        return 0.0;
      }
    }
    return 0.0;
  }

  public static String getCurrencyValue(double inputVal){
    return groupFormatNumber(inputVal,2,2);
  }

  public static String getCurrencyValueFromString(String inputVal){
    inputVal = returnBlankIfNull(inputVal);
    if (inputVal.equals("")) inputVal = "0.00";
    return groupFormatNumber(inputVal,2,2);
  }
    public static String rTrim(String input,String delimeter){
        String arr[]=split(input,delimeter);
        StringBuffer retValue=new StringBuffer();
        if(arr.length>0){
            for(int count=0;count<arr.length;count++){
                retValue.append(arr[count]);
            }
        }
        return retValue.toString();
    }

    /**
     * This method takes an boolean input parameter of the indicator 
     * like isExportIndicator() or isVIPIndicator and returns  
     * a String object after conversion which is inserted into database
     * <br>.
     * @param ind boolean
     * @return indicator java.lang.String
     */
    public static String getIndicatorAsString(Boolean ind) {
        if(ind == null)
            return Constants.FALSE;
        String indicator = Constants.FALSE;
        if (ind == true)
            indicator = Constants.TRUE;
        return indicator;
    }

    /**
     * This method takes an String input parameter of the indicator 
     * like isExportIndicator() or isVIPIndicator and returns  
     * a boolean object to display the data
     * <br>.
     * @param indicator java.lang.String 
     * @return ind boolean
     */
    public static boolean getIndicatorAsBoolean(String indicator) {
        boolean ind = false;
        if (returnBlankIfNull(indicator).equals(Constants.TRUE))
            ind = true;
        return ind;
    }

    /**
     * This method takes an String consisting of "T,Y,F,N" to boolean true, false.
     * Converts T,Y to true and converts F,N to false
     * 
     * @param option java.lang.String 
     * @return ind boolean
     */
    public static boolean getOptionAsBoolean(String option){
        if(Constants.TRUE.equals(option) || Constants.YES.equals(option)){
            return true;
        }else if(Constants.FALSE.equals(option) || Constants.NO.equals(option)){
            return false;
        }
        
        return false;
    }
    
    /**
     * This method takes an String consisting of "T,Y,F,N" to boolean true, false.
     * Converts T,Y to true and converts F,N to false
     * 
     * @param ind java.lang.Boolean 
     * @return indicator String
     */
    public static String getOptionAsString(Boolean ind){
        if(ind == null)
            return Constants.NO;
        String indicator = Constants.NO;
        if (ind == true)
            indicator = Constants.YES;
        return indicator;
    }

    public static String convertStringToID(String inputStr){
        String returnStr = inputStr;
        if (inputStr != null && inputStr.length() > 0){
            returnStr = inputStr.replaceAll(" ","");
        }
        return returnStr;
    }

    public static int numberOfWords(String aString){
        int numberOfWords = 0;
        Character cs= ',';
        if(aString != null){
            for(int i=0;i<aString.length();i++){
                if(aString.charAt(i) ==cs){
                    numberOfWords ++;
                }
            }
        }
        return numberOfWords+1;
    }
    
    /**
     * Puts blank before the capital letters except the first letter.
     * CardType ==> Card Type
     * 
     * @param aString
     * @return
     */
    public static String putBlankBeforeCapitalLetters(String aString){

        StringBuffer blankInsertedString = new StringBuffer();
        for(int i=0;i<aString.length();i++){
            char ch  = aString.charAt(i);
            if(Character.isUpperCase(ch)){
                blankInsertedString.append(" ");
            }
            blankInsertedString.append(ch);
        }
        return blankInsertedString.toString().trim();
    }
    
    /**
     * Returns empty string if the string is null.
     * The use of this reduces the chances of displaying null in the string.
     */
    public static String getEmptyIfNull(String strForCheck){
        if(strForCheck == null){
            return "";
        }else{
            return strForCheck;
        }
    }  
    
    /**
     * The method trims the extra commas that exist in a String. The method also trims 
     * the preceeding and trailing commas.
     * @param strForTrim
     * @return
     */
    public static String trimCommas(String strForTrim){
        if (StringHelper.isNullOrEmptyString(strForTrim)) {
            return strForTrim;
        }
        String strTemp = "";
        String[] trimArr = strForTrim.split(",");
        for(String str:trimArr) {
            if(!str.equals("") && !str.equals(" "))
                strTemp = strTemp + str + ", ";
        }
        if(strTemp.length()>=2 && strTemp.substring(strTemp.length()-2).equals(", "))
            strTemp=strTemp.substring(0, strTemp.length()-2);
        return strTemp;
    }    
    
    /**
     * 
     * @param listOfValues
     * @return
     */
    public static String getCommaSeperated(List listOfValues) {
        if(null == listOfValues){
            return null;   
        }else{
            String[] stringArray = new String[listOfValues.size()];
            for(int i=0; i<listOfValues.size(); i++){
                stringArray[i] = String.valueOf(listOfValues.get(i));
            }
            
            return getCommaSeperatedString(stringArray);
        }
    }

    /**
     * Returns true if s contains alphanumeric and hyphen characters only, else 
     * false
     * 
     * @param s
     */
    public static boolean isAlphaNumericHyphen(final String s) {
        if (s.matches("[A-Za-z0-9-]*")) {
            return true;
        } else {
            return false;
        }
    }
    
    public static String replaceParamsInString(String messageKeyValue, Object[] params) {
        if(params == null) {
            return messageKeyValue;
        }
        int pos = 0;
        for(int i=0; i<params.length; i++){
           pos = i; // holds the real position of the token key
           messageKeyValue = messageKeyValue.replace("{"+pos+"}",String.valueOf(params[i]));
        }
        return messageKeyValue;
    }
}