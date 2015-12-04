package com.technobrain.trips.gui;

import java.io.Serializable;

/**
 * @ Crown Agents 2008
 *
 * 
 * @since       $Date: 2/2/2009 5:34:54 AM$
 * @version     $Revision: 3$
 * @author      $Author: Howard Hill$
 * 
 * $Log[1]:
 *  3    TRIPS2    1.2         2/2/2009 5:34:54 AM    Howard Hill     change
 *       log10 to log1
 * $
 */
public class GuiConfigurationKey implements Serializable {

    private String aPageUrl;
    private String configCode;
    private String aMode;

    public GuiConfigurationKey(String _aPageUrl,
                               String _configCode, String _aMode) {

        aPageUrl = _aPageUrl;
        configCode = _configCode;
        aMode = _aMode;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GuiConfigurationKey) {
            GuiConfigurationKey objKey = (GuiConfigurationKey)obj;
            return objKey.aPageUrl.equals(this.aPageUrl) && 
                objKey.configCode.equals(this.configCode) && 
                objKey.aMode.equals(this.aMode);
        } else {
            return super.equals(obj);
        }
    }

    public int hashCode() {
        return aPageUrl.hashCode() * configCode.hashCode() * aMode.hashCode() ;
    }

    public String toString() {
        return "GUI-KEY: " + aPageUrl + "," + configCode + "," + aMode ;
    }
}
