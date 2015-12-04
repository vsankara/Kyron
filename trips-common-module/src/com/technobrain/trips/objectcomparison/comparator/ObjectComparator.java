package com.technobrain.trips.objectcomparison.comparator;

import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.helpers.ReflectionHelper;
import com.technobrain.trips.objectcomparison.config.ObjectComparatorConfig;
import com.technobrain.trips.objectcomparison.dto.DifferenceDetail;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ObjectComparator {
    public ObjectComparator() {
    }
    
    public static ArrayList<DifferenceDetail> compareObjects(ObjectComparatorConfig config){
        ArrayList<DifferenceDetail> differenceDetails = new ArrayList<DifferenceDetail>();
        ArrayList<DifferenceDetail> differenceDetailsToReturn = new ArrayList<DifferenceDetail>();
        if(config != null){
            if(config.getControlObject() != null && config.getTestObject() != null){
                List<Field> controlFieldList = ReflectionHelper.getDeclaredFieldsWithInheritance(config.getControlObject().getClass());
                List<Field> testFieldList = ReflectionHelper.getDeclaredFieldsWithInheritance(config.getTestObject().getClass());
                if(controlFieldList != null && testFieldList != null && 
                    controlFieldList.size() >0 && testFieldList.size() >0){
                    String objectName = config.getTestObject().getClass().getSimpleName();
                    compareFields(config,controlFieldList,testFieldList,differenceDetails,objectName,null);
                }
            }
        }
        for(DifferenceDetail dd:differenceDetails){
            if((dd.getNewValue()!=null && !dd.getNewValue().equals("")) || (dd.getOldValue()!=null && !dd.getOldValue().equals("")) ){
                differenceDetailsToReturn.add(dd);
            }

        }

        return differenceDetailsToReturn;
    }

    private static boolean isComplexField(Field aField) {
        boolean isComplex = false;
        if(aField != null){
            if(aField.getType() != null && aField.getType().getCanonicalName() != null
                && aField.getType().getCanonicalName().startsWith("com.technobrain.trips")){
                isComplex = true;
            }
        }
        return isComplex;
    }

    private static boolean canBeIgnored(List<String> ignoreFields,String fieldName) {
        if (ignoreFields == null || ignoreFields.size() == 0) {
            return false;
        }
        for (String s: ignoreFields) {
            if (s.equalsIgnoreCase(fieldName)) {
                return true;
            }
        }
        return false;
    }
    
    private static Object formatObject(Object object){
        if (object != null) {
            if (object instanceof Date) {
                object = DateHelper.getFormattedDateWithoutTime((Date)object);
            } else if (object instanceof Calendar) {
                object = DateHelper.getFormattedDateWithoutTime(((Calendar)object).getTime());
            } else {
                object = object.toString().trim();
            }
            
            if(object != null && object.equals("")){
                object = null;
            }
        }
        return object;
    }
    
    public static void compareFields(ObjectComparatorConfig config,List<Field> controlFieldList, List<Field> testFieldList,
                                    List<DifferenceDetail> differenceDetails,String objectName,String complexFieldName){
                                    
        List<String> ignoreFields = config.getIgnoreFields();
        List<String> ignoreXPathFields = config.getIgnoreXpathFields();
        String fieldPath = null;
    
        for(int i=0;i<controlFieldList.size();i++){
            Field controlField = controlFieldList.get(i);            
            for(int j=0;j<testFieldList.size();j++){
                Field testField = testFieldList.get(j);
                if(controlField != null && testField != null){
                    // Below if is to ignore the generic fields like createdDate, updatedDate
                     if(controlField.getName().equals(testField.getName())){
                        if (!canBeIgnored(ignoreFields,controlField.getName())) {
                        
                            // Below if is to ignore the specific fields like registrationFor for the particular object
                            if(config.getControlObject()!=null){
                                if(complexFieldName!=null){
                                    fieldPath = complexFieldName + "/"+ config.getControlObject().getClass().getSimpleName()+"/"+controlField.getName();    
                                } else {
                                    fieldPath = config.getControlObject().getClass().getSimpleName()+"/"+controlField.getName();
                                }
                                    if (canBeIgnored(ignoreXPathFields, 
                                                     fieldPath) ) {
                                        break;
                                    }
                                }                            
                            if(!isComplexField(controlField) && !isComplexField(testField)){
                                try {
                                    Object controlFieldValue = ReflectionHelper.invokeGetter(config.getControlObject(),controlField.getName());
                                    if (controlFieldValue != null) {
                                        controlFieldValue=formatObject(controlFieldValue);
                                    }
                                    Object testFieldValue = ReflectionHelper.invokeGetter(config.getTestObject(),testField.getName());                                
                                    if(testFieldValue != null){
                                        testFieldValue=formatObject(testFieldValue);
                                    }
                                    
                                    if(controlFieldValue != null && testFieldValue == null){
                                        DifferenceDetail dd = new DifferenceDetail();
                                        dd.setExistInControlNodeOnly(true);
                                        dd.setOldValue(controlFieldValue);
                                        dd.setNewValue(testFieldValue);
                                        dd.setFormattedXpathName(fieldPath);
                                        dd.setParentClassName(objectName);
                                        dd.setFieldName(controlField.getName());
                                        differenceDetails.add(dd);
                                    }else if(controlFieldValue == null && testFieldValue != null){
                                        DifferenceDetail dd = new DifferenceDetail();
                                        dd.setExistInTestNodeOnly(true);
                                        dd.setOldValue(controlFieldValue);
                                        dd.setNewValue(testFieldValue);
                                        dd.setFormattedXpathName(fieldPath);
                                        dd.setParentClassName(objectName);
                                        dd.setFieldName(testField.getName());
                                        differenceDetails.add(dd);
                                    }else if(controlFieldValue != null && testFieldValue != null && !controlFieldValue.equals(testFieldValue)){
                                        DifferenceDetail dd = new DifferenceDetail();
                                        dd.setExistInBothNode(true);
                                        dd.setOldValue(controlFieldValue);
                                        dd.setNewValue(testFieldValue);
                                        dd.setFormattedXpathName(fieldPath);
                                        dd.setParentClassName(objectName);
                                        dd.setFieldName(testField.getName());
                                        differenceDetails.add(dd);
                                    }else{
                                        //do nothing
                                    }                                
                                } catch (NoSuchMethodException e) {
                                    // TODO 
                                }
                            }else if(isComplexField(controlField) && isComplexField(testField)){
                                if(controlField.getType().isArray() && testField.getType().isArray()){
                                    try {
                                        Object[] cFieldValueArr = 
                                                (Object[])ReflectionHelper.invokeGetter(config.getControlObject(),controlField.getName());
                                        Object[] tFieldValueArr = (Object[])ReflectionHelper.invokeGetter(config.getTestObject(),testField.getName());
                                        
                                        if(cFieldValueArr != null && tFieldValueArr != null){
                                             if(cFieldValueArr.length > 0 && tFieldValueArr.length > 0){
                                                 for(int l=0;l<cFieldValueArr.length;l++){                                                     
                                                     List<Field> cfListFromArray = ReflectionHelper.getDeclaredFieldsWithInheritance(cFieldValueArr[l].getClass());
                                                     Object cIdFieldValue = null;
                                                     boolean cIdFieldFound = false;
                                                     if(cfListFromArray != null && cfListFromArray.size() >0){
                                                         for(int m=0;m<cfListFromArray.size();m++){
                                                             if(cfListFromArray.get(m) != null && cfListFromArray.get(m).getName() != null &&
                                                                 cfListFromArray.get(m).getName().equalsIgnoreCase("id")){
                                                                 cIdFieldFound = true;
                                                                 cIdFieldValue = ReflectionHelper.invokeGetter(cFieldValueArr[l],cfListFromArray.get(m).getName());
                                                                 break;
                                                             }
                                                         }
                                                     }
                                                     if(cIdFieldFound && cIdFieldValue == null){
                                                         break;
                                                     }
                                                     Set<Object> idsInTestFieldValueArr= new HashSet<Object>();
                                                     for(int n=0;n<tFieldValueArr.length;n++){
                                                         List<Field> tfListFromArray = ReflectionHelper.getDeclaredFieldsWithInheritance(tFieldValueArr[n].getClass());
                                                         Object tIdFieldValue = null;
                                                         boolean tIdFieldFound = false;
                                                         if(tfListFromArray != null && tfListFromArray.size() >0){
                                                             for(int p=0;p<tfListFromArray.size();p++){
                                                                 if(tfListFromArray.get(p) != null && tfListFromArray.get(p).getName() != null &&
                                                                     tfListFromArray.get(p).getName().equalsIgnoreCase("id")){
                                                                     tIdFieldFound = true;
                                                                     tIdFieldValue = ReflectionHelper.invokeGetter(tFieldValueArr[n],tfListFromArray.get(p).getName());
                                                                     if(tIdFieldValue != null){
                                                                         idsInTestFieldValueArr.add(tIdFieldValue);
                                                                     }
                                                                     break;
                                                                 }
                                                             }
                                                         }
                                                         if(cIdFieldValue != null && tIdFieldValue != null && cIdFieldValue.equals(tIdFieldValue)){                                                        
                                                             ObjectComparatorConfig configForArray = new ObjectComparatorConfig();
                                                             configForArray.setControlObject(cFieldValueArr[l]);
                                                             configForArray.setTestObject(tFieldValueArr[n]);  
                                                             configForArray.setIgnoreFields(ignoreFields);
                                                             configForArray.setIgnoreXpathFields(ignoreXPathFields);
                                                             compareFields(configForArray,cfListFromArray,tfListFromArray,differenceDetails,objectName,testField.getName());
                                                         }else if(l==0 && tIdFieldFound && tIdFieldValue == null){// new item added
                                                             readUncommonObject(config,tFieldValueArr[n],false,true,differenceDetails,objectName,testField.getName());
                                                         }
                                                     }
                                                     if(!idsInTestFieldValueArr.contains(cIdFieldValue)){ // item deleted
                                                         readUncommonObject(config,cFieldValueArr[l],true,false,differenceDetails,objectName,controlField.getName());
                                                     }
                                                 }
                                             }else if(cFieldValueArr.length > 0 && tFieldValueArr.length == 0){
                                                 for(Object cObj:cFieldValueArr){
                                                     readUncommonObject(config,cObj,true,false,differenceDetails,objectName,controlField.getName());
                                                 }
                                             }else if(cFieldValueArr.length == 0 && tFieldValueArr.length > 0){
                                                 for(Object tObj:tFieldValueArr){
                                                     readUncommonObject(config,tObj,false,true,differenceDetails,objectName,testField.getName());
                                                 }
                                             }
                                         }else if(cFieldValueArr != null && tFieldValueArr == null){ // item dedeted
                                            for(Object cObj:cFieldValueArr){
                                                readUncommonObject(config,cObj,true,false,differenceDetails,objectName,controlField.getName());
                                            }
                                         }else if(cFieldValueArr == null && tFieldValueArr != null){ // new item added
                                             for(Object tObj:tFieldValueArr){
                                                 readUncommonObject(config,tObj,false,true,differenceDetails,objectName,testField.getName());
                                             }
                                         }
                                     } catch (NoSuchMethodException e) {
                                         // TODO
                                     }
                                }else if(!controlField.getType().isArray() && !testField.getType().isArray()){
                                    try {
                                        Object controlFieldValue = 
                                                ReflectionHelper.invokeGetter(config.getControlObject(),controlField.getName());
                                        Object testFieldValue = ReflectionHelper.invokeGetter(config.getTestObject(),testField.getName());
                                        ObjectComparatorConfig configForNonArray = new ObjectComparatorConfig();
                                        configForNonArray.setControlObject(controlFieldValue);
                                        configForNonArray.setTestObject(testFieldValue);
                                        configForNonArray.setIgnoreFields(ignoreFields);
                                        configForNonArray.setIgnoreXpathFields(ignoreXPathFields);
                                        List<Field> cfListFromNonArray = ReflectionHelper.getDeclaredFieldsWithInheritance(controlField.getType());
                                        List<Field> tfListFromNonArray = ReflectionHelper.getDeclaredFieldsWithInheritance(testField.getType());
                                        compareFields(configForNonArray,cfListFromNonArray,tfListFromNonArray,differenceDetails,objectName,testField.getName());
                                    } catch (NoSuchMethodException e) {
                                        // TODO
                                    }
                                }
                            }
                        }                        
                    }
                }
            }
        }
    }

    private static void readUncommonObject(ObjectComparatorConfig config, Object obj, boolean isInControlObj,boolean isInTestObj,
                                          List<DifferenceDetail> difDetails,String objectName,String complexFieldName) {
        if(obj != null){
            String fieldPath = null;
            List<Field> objFields = ReflectionHelper.getDeclaredFieldsWithInheritance(obj.getClass());
            for (Field f: objFields) {
                // Below if is to ignore the generic fields like createdDate, updatedDate
                if (!canBeIgnored(config.getIgnoreFields(), f.getName())) {
                    // Below if is to ignore the specific fields like registrationFor for the particular object
                    if (obj != null) {
                        
                        if(complexFieldName!=null){
                            fieldPath = complexFieldName + "/"+ obj.getClass().getSimpleName()+"/"+f.getName();    
                        } else {
                            fieldPath = obj.getClass().getSimpleName()+"/"+f.getName();
                        }
                        if (canBeIgnored(config.getIgnoreXpathFields(),fieldPath)) {
                            continue;
                        }
                    }

                    if (!isComplexField(f)) {
                        try {
                            Object objFieldValue =ReflectionHelper.invokeGetter(obj, f.getName());
                            if(objFieldValue != null){
                                objFieldValue = formatObject(objFieldValue);
                            }
                            if (objFieldValue != null) {
                                DifferenceDetail dd = new DifferenceDetail();
                                if (isInControlObj) {
                                    dd.setExistInControlNodeOnly(true);
                                    dd.setOldValue(objFieldValue);
                                }
                                if (isInTestObj) {
                                    dd.setExistInTestNodeOnly(true);
                                    dd.setNewValue(objFieldValue);
                                }
                                dd.setFormattedXpathName(fieldPath);
                                dd.setParentClassName(objectName);
                                dd.setFieldName(f.getName());
                                difDetails.add(dd);
                            }
                        } catch (NoSuchMethodException e) {
                            // TODO
                        }
                    } else if (isComplexField(f)) {
                        if (f.getType().isArray()) {
                            try {
                                Object[] objFieldValueArr = (Object[])ReflectionHelper.invokeGetter(obj,f.getName());
                                if (objFieldValueArr != null && 
                                    objFieldValueArr.length > 0) {
                                    for (int i = 0;i < objFieldValueArr.length; i++) {
                                        readUncommonObject(config,objFieldValueArr[i],isInControlObj, 
                                                           isInTestObj,difDetails,objectName,f.getName());
                                    }
                                }
                            } catch (NoSuchMethodException e) {
                                // TODO
                            }
                        } else if (!f.getType().isArray()) {
                            try {
                                Object objFieldValueArr = ReflectionHelper.invokeGetter(obj, f.getName());
                                if (objFieldValueArr != null) {
                                    readUncommonObject(config,objFieldValueArr,isInControlObj, 
                                                       isInTestObj,difDetails,objectName,f.getName());
                                }
                            } catch (NoSuchMethodException e) {
                                // TODO
                            }
                        }
                    }
                }
            }

        }
    }
}
