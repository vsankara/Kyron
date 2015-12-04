package com.technobrain.trips.core.components.converter;

import com.technobrain.trips.util.FacesUtil;


import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import java.text.ParsePosition;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import org.apache.log4j.Logger;

public class BigDecimalConverter implements Converter {

    static final Logger log = Logger.getLogger(BigDecimalConverter.class);
    public static final String DECIMAL_LENGTH = "decimalLength";
    public static final String HAS_THOUSAND_SEPARATOR = "hasThousandSeparator";

    /*public static final String PATTERN_MONEY = "##,###,###,##0.00";
    public static final String PATTERN_MONEY_NO_THSEP = "##########0.00";
    
    public static final String PATTERN_PRICE = "#0.00####";
    public static final String PATTERN_PERCENTAGE = "0.00#";
    public static final String PATTERN_CURRENCY = "#0.000000";
    public static final String ATTR_PATTERN = "pattern";
    public static final String ATTR_NUMBER_TYPE = "numberType";
    
    public static final String ATTR_NUMBER_TYPE_MONEY = "money";
    public static final String ATTR_NUMBER_TYPE_PRICE = "price";
    public static final String ATTR_NUMBER_TYPE_CURRENCY = "currency";
    public static final String ATTR_NUMBER_TYPE_PERCENTAGE = "percentage";    
    
    // the patterns that will be used while parsing or formatting.
    public static final String PATTERN_NUM_NO_SCALE = "##,###,###,##0";
    public static final String PATTERN_NUM_1_SCALE = "##,###,###,##0.0";
    public static final String PATTERN_NUM_2_SCALE = "##,###,###,##0.00";
    public static final String PATTERN_NUM_3_SCALE = "##,###,###,##0.000";
    public static final String PATTERN_NUM_4_SCALE = "##,###,###,##0.0000";
    public static final String PATTERN_NUM_5_SCALE = "##,###,###,##0.00000";
    public static final String PATTERN_NUM_6_SCALE = "##,###,###,##0.000000";
    public static final String PATTERN_NUM_7_SCALE = "##,###,###,##0.0000000";
    public static final String PATTERN_NUM_8_SCALE = "##,###,###,##0.00000000";
    public static final String PATTERN_NUM_9_SCALE = "##,###,###,##0.000000000";
    public static final String PATTERN_NUM_10_SCALE = "##,###,###,##0.000000000";    

    public static final String PATTERN_NUM_NO_SCALE_NO_THSEP = "##########0";
    public static final String PATTERN_NUM_1_SCALE_NO_THSEP = "##########0.0";
    public static final String PATTERN_NUM_2_SCALE_NO_THSEP = "##########0.00";
    public static final String PATTERN_NUM_3_SCALE_NO_THSEP = "##########0.000";
    public static final String PATTERN_NUM_4_SCALE_NO_THSEP = "##########0.0000";
    public static final String PATTERN_NUM_5_SCALE_NO_THSEP = "##########0.00000";
    public static final String PATTERN_NUM_6_SCALE_NO_THSEP = "##########0.000000";
    public static final String PATTERN_NUM_7_SCALE_NO_THSEP = "##########0.0000000";
    public static final String PATTERN_NUM_8_SCALE_NO_THSEP = "##########0.00000000";
    public static final String PATTERN_NUM_9_SCALE_NO_THSEP = "##########0.000000000";
    public static final String PATTERN_NUM_10_SCALE_NO_THSEP = "##########0.000000000";   */
    private Integer decimalLength = null;

    public BigDecimalConverter() {
    }

    @Override
    public Object getAsObject(FacesContext facesContext,
            UIComponent uiComponent, String string) {

//        String pattern = (String)uiComponent.getAttributes().get(ATTR_PATTERN);        
//        if(pattern == null) {
//            pattern = findPattern(uiComponent);
//        }
        Number number = BigDecimal.ZERO;
//        if(pattern!=null){
        DecimalFormat decimalFormat = getDecimalFormat(facesContext.getViewRoot().getLocale());
        if ("Dummy 4".equals(uiComponent.getAttributes().get("label"))
                || "Dummy 3".equals(uiComponent.getAttributes().get("label"))
                || "Dummy 2".equals(uiComponent.getAttributes().get("label"))
                || "Dummy 1".equals(uiComponent.getAttributes().get("label"))) {
            log.debug("Dummy labels");
        }
        if (string == null || string.trim().length() == 0) {
            return null;
        }
        try {
            Number num = parseNumber(string, decimalFormat);

            // if the decimal length is null or 0, there is no point to scale the number.
            if (getDecimalLength(uiComponent) != null && getDecimalLength(uiComponent) != 0) {
                number = new BigDecimal(num.toString());
                ((BigDecimal) number).setScale(getDecimalLength(uiComponent), BigDecimal.ROUND_HALF_UP);
            } else {
                // we need to check the bound value type. We definitely know that it should be a number object because
                // this converter works on number objects. But we need to know the concrete type of the number so that
                // we will return exactly the expected number instance from this method. For example, if we had 
                // bound an Integer object and had simply return the bigdecimal object, we would have taken a conversion error
                Object numValueOnObject = FacesUtil.resolveExpression(uiComponent.getValueBinding("value").getExpressionString());
                if (numValueOnObject != null) {
                    if (numValueOnObject instanceof Integer) {
                        number = new Integer(num.toString());
                    } else if (numValueOnObject instanceof Long) {
                        number = new Long(num.toString());
                    } else if (numValueOnObject instanceof BigDecimal) {
                        number = new BigDecimal(num.toString());
                    }
                } else {
                    Class numberClass = FacesUtil.getTypeOfValueBinding(uiComponent);
                    if (numberClass != null) {
                        switch (numberClass.getSimpleName()) {
                            case "Integer":
                                number = new Integer(num.toString());
                                break;
                            case "Long":
                                number = new Long(num.toString());
                                break;
                            case "BigDecimal":
                                number = new BigDecimal(num.toString());
                                break;
                            default:
                                number = new BigDecimal(num.toString());
                                break;
                        }
                    }
                }
            }
        } catch (ParseException e) {

            FacesMessage message = new FacesMessage();
            String detail = FacesUtil.getStringFromBundle("Global.converter.BigDecimal");
            String summary = FacesUtil.getStringFromBundle("Global.converter.BigDecimalSummary");

            String fieldName = (String) uiComponent.getAttributes().get("fieldRef");
            if (null != fieldName) {
                message.setSummary(fieldName + " " + summary);
            } else {
                message.setSummary(summary);
            }

            message.setDetail(detail);

            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
        }
//        }
//        else {
//            return null;
//        }
        return number;
    }

    public Number parseNumber(String value, NumberFormat format) throws ParseException {
        value = value.trim();
        ParsePosition pos = new ParsePosition(0);
        Number number = format.parse(value, pos);
        boolean okay = pos.getIndex() == value.length() && pos.getErrorIndex() == -1;
        if (!okay) {
            throw new ParseException("Could not parse '" + value + "' as a number", pos.getErrorIndex());
        }
        return number;
    }

    @Override
    public String getAsString(FacesContext facesContext,
            UIComponent uiComponent, Object object) {

        BigDecimal number = null;
        if (null == object) {
            return null;
        } else {
            try {
                if (object instanceof BigDecimal) {
                    number = new BigDecimal(String.valueOf(object));
                } else {
                    number = new BigDecimal(String.valueOf(object).trim());
                }
            } catch (NumberFormatException e) {
                return null;
            }
        }
        /*
         * TODO: hhill Pattern not required or have to change pattern to be locale sentive
        String pattern = (String)uiComponent.getAttributes().get(ATTR_PATTERN);
        
        if(pattern == null)  
            pattern = findPattern(uiComponent);
    
         */

        DecimalFormat decimalFormat = getDecimalFormat(facesContext.getViewRoot().getLocale());
        decimalFormat.setMinimumFractionDigits(getDecimalLength(uiComponent));
        decimalFormat.setMaximumFractionDigits(getDecimalLength(uiComponent));
        Boolean hasSeparator = (Boolean) uiComponent.getAttributes().get(HAS_THOUSAND_SEPARATOR);
        if (hasSeparator != null) {
            decimalFormat.setGroupingUsed(hasSeparator);
        }
        String formatted = decimalFormat.format(number);

        return formatted;
    }

    public static String getAsString(Locale locale, Integer decimalLength, Boolean hasThousandSeparator, BigDecimal number) {
        DecimalFormat decimalFormat = getDecimalFormat(locale);
        if (decimalLength == null) {
            decimalLength = 0;
        }
        if (number == null) {
            return null;
        }
        decimalFormat.setMinimumFractionDigits(decimalLength);
        decimalFormat.setMaximumFractionDigits(decimalLength);
        if (hasThousandSeparator != null) {
            decimalFormat.setGroupingUsed(hasThousandSeparator);
        }
        String formatted = decimalFormat.format(number);

        return formatted;
    }

    protected Integer getDecimalLength(UIComponent uiComp) {
        if (decimalLength == null) {
            Object obj = uiComp.getAttributes().get(DECIMAL_LENGTH);
            if (obj != null) {
                decimalLength = new Integer(obj.toString());
            }
            if (decimalLength == null) {
                decimalLength = 2;
            }
        }
        return decimalLength;
    }

//    public String findPattern(UIComponent uIComponent) {
//        String numberType = (String)uIComponent.getAttributes().get(ATTR_NUMBER_TYPE);
//        Integer decimalLength = null;
//        boolean hasThousandSeperator = true;
//        Object obj = uIComponent.getAttributes().get(DECIMAL_LENGTH);
//        if(obj != null) {
//            decimalLength = new Integer(obj.toString());
//        }
//        
//        obj = uIComponent.getAttributes().get(HAS_THOUSAND_SEPARATOR);
//        if(obj != null)
//            hasThousandSeperator = new Boolean(obj.toString());
//            
//        String pattern = null;
//        // if decimallength is set, do not look any another thing, find the pattern with the scale and return it.
//        if(decimalLength != null) {
//            if(decimalLength == 0)
//                if(hasThousandSeperator)
//                    pattern = PATTERN_NUM_NO_SCALE;
//                else
//                    pattern = PATTERN_NUM_NO_SCALE_NO_THSEP;
//            else if(decimalLength == 1) {
//                if(hasThousandSeperator)  
//                    pattern = PATTERN_NUM_1_SCALE;
//                else
//                    pattern = PATTERN_NUM_1_SCALE_NO_THSEP;
//                numOfScales = 1;
//            }
//            else if(decimalLength == 2) {
//                if(hasThousandSeperator)            
//                    pattern = PATTERN_NUM_2_SCALE;
//                else
//                    pattern = PATTERN_NUM_2_SCALE_NO_THSEP;
//                numOfScales = 2;
//            }
//            else if(decimalLength == 3) {
//                if(hasThousandSeperator)            
//                    pattern = PATTERN_NUM_3_SCALE;
//                else
//                    pattern = PATTERN_NUM_3_SCALE_NO_THSEP;
//                numOfScales = 3;
//            }
//            else if(decimalLength == 4) {
//                if(hasThousandSeperator)            
//                    pattern = PATTERN_NUM_4_SCALE;
//                else
//                    pattern = PATTERN_NUM_4_SCALE_NO_THSEP;
//                numOfScales = 4;
//            }
//            else if(decimalLength == 5) {
//                if(hasThousandSeperator)            
//                    pattern = PATTERN_NUM_5_SCALE;
//                else
//                    pattern = PATTERN_NUM_5_SCALE_NO_THSEP;
//                numOfScales = 5;
//            }
//            else if(decimalLength == 6) {
//                if(hasThousandSeperator)            
//                    pattern = PATTERN_NUM_6_SCALE;
//                else
//                    pattern = PATTERN_NUM_6_SCALE_NO_THSEP;
//                numOfScales = 6;
//            }
//            else if(decimalLength == 7) {
//                if(hasThousandSeperator)            
//                    pattern = PATTERN_NUM_7_SCALE;
//                else
//                    pattern = PATTERN_NUM_7_SCALE_NO_THSEP;
//                numOfScales = 7;
//            }
//            else if(decimalLength == 8) {
//                if(hasThousandSeperator)            
//                    pattern = PATTERN_NUM_8_SCALE;
//                else
//                    pattern = PATTERN_NUM_8_SCALE_NO_THSEP;
//                numOfScales = 8;
//            }
//            else if(decimalLength == 9) {
//                if(hasThousandSeperator)            
//                    pattern = PATTERN_NUM_9_SCALE;
//                else
//                    pattern = PATTERN_NUM_9_SCALE_NO_THSEP;
//                numOfScales = 9;
//            }
//            else if(decimalLength == 10) {
//                if(hasThousandSeperator)            
//                    pattern = PATTERN_NUM_10_SCALE;
//                else
//                    pattern = PATTERN_NUM_10_SCALE_NO_THSEP;
//                numOfScales = 10;
//            }
//        }
//        else {
//            if(numberType != null) {
//                if(numberType.equals(ATTR_NUMBER_TYPE_MONEY)) {
//                    if(hasThousandSeperator)
//                        pattern = PATTERN_MONEY;
//                    else
//                        pattern = PATTERN_MONEY_NO_THSEP;
//                    numOfScales = 2;
//                }
//                else if(numberType.equals(ATTR_NUMBER_TYPE_CURRENCY)) {
//                    pattern = PATTERN_CURRENCY;
//                    numOfScales = 6;
//                }
//                else if(numberType.equals(ATTR_NUMBER_TYPE_PRICE)) {
//                    pattern = PATTERN_PRICE;
//                }
//                else if(numberType.equals(ATTR_NUMBER_TYPE_PERCENTAGE)) {
//                    pattern = PATTERN_PERCENTAGE;
//                }                
//            }
//            else {
//                // if number type attribute is not set, then use PATTERN_MONEY for default.
//                pattern = PATTERN_MONEY;
//                numOfScales = 2;
//            }
//        }  
//        return pattern;
//    }   
    public static DecimalFormat getDecimalFormat(Locale locale) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(locale);

        return decimalFormat;
    }
}
