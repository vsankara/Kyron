package com.technobrain.trips.core.helper;


import com.technobrain.trips.dto.CodeAndDescription;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CodeDescriptionHelper {

    private static Log logger = LogFactory.getLog(CodeDescriptionHelper.class);

    /**
     * Method will transform the passed in List of Objects to a List of 
     * CodeAndDescription type Objects. The fields will be defaulted to
     * Code and Description
     * @param referenceData
     * @return
     */
    public List<CodeAndDescription> transformToCodeAndDescription(List referenceData) {
        return transform(referenceData, "Code", "Description");
    }

    /**
     * Method will transform the passed in List of Objects to a List of 
     * CodeAndDescription type Objects. The fields will be set to
     * code and description parameters
     * @param referenceData
     * @param code
     * @param description
     * @return
     */
    public List<CodeAndDescription> transformToCodeAndDescription(List referenceData, String code, String description) {
        return transform(referenceData, code, description);
    }

    /**
     * 
     * @param refData
     * @param code
     * @param description
     * @return
     */
    private List<CodeAndDescription> transform(List refData, String code, String description) {
        List<CodeAndDescription> cAndDList = new ArrayList<CodeAndDescription>();
        if(refData != null) {
            Iterator iterator = refData.iterator();
            while(iterator.hasNext()) {
                Object obj = iterator.next();
                cAndDList.add(new CodeAndDescription(getFieldContent(obj, code), 
                    getFieldContent(obj, description)));
            }
        }
        return cAndDList;
    }

    /**
     * 
     * @param obj
     * @param field
     * @return
     */
    private String getFieldContent(Object obj, String field) {
        Method[] methodArr = obj.getClass().getDeclaredMethods();
        String returnVal = null;
        try {
            for(int i = 0; i < methodArr.length; i++) {
                if(methodArr[i].getName().indexOf("get" + field) > -1) {
                    returnVal = methodArr[i].invoke(obj, new Object[]{}).toString();
                }
            }
        } catch(IllegalAccessException iae) {
            logger.error(iae);
        } catch(InvocationTargetException ite) {
            logger.error(ite);
        }
        return returnVal;
    }
}
