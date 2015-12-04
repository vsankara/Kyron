package com.technobrain.trips.dropdownhelper;



import com.technobrain.trips.common.constants.JndiConstants;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import org.apache.log4j.Logger;

public class DropDownHelper  {
    public static final Logger log = Logger.getLogger(DropDownHelper.class);
    private static DropDownHelperLocal dropDownHelperLocal=null;
    static {
        dropDownHelperLocal=getDropDownHelperLocal();
    }
    public static List getList(String listType){
        return dropDownHelperLocal.getDropDownList(listType);
    }
    private static Object getEJB(String $jndiName) {
        Object service = null;
        try {
            Context initial = new InitialContext();
            Object objref = initial.lookup($jndiName);
            service = objref;
        } catch (Exception ex) {
            log.error(ex.getLocalizedMessage(), ex);
        }
        return service;
    }

    public static DropDownHelperLocal getDropDownHelperLocal() {
        try {
            return (DropDownHelperLocal)getEJB(JndiConstants.JNDI_DROP_DOWN_HELPER);
        } catch (Throwable exp) {
            return null;
        }
    }
}
