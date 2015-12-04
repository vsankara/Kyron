package com.technobrain.trips.gui.model;

import java.io.Serializable;
import org.apache.log4j.Logger;

public class GuiPageConfigPK implements Serializable {
//    public static final Logger log = Logger.getLogger(GuiPageConfigPK.class);
    public Long componentRefId;
    public Long pageModeId;

    public GuiPageConfigPK() {
    }

    public GuiPageConfigPK(Long componentRefId, Long pageModeId) {this.componentRefId = componentRefId;
        this.componentRefId = componentRefId;
        this.pageModeId = pageModeId;
//        log.debug("query componentRefId " + componentRefId);
//        log.debug("query pageModeId " + pageModeId);
    }

    public boolean equals(Object other) {
        if (other instanceof GuiPageConfigPK) {
            final GuiPageConfigPK otherGuiPageConfigPK = (GuiPageConfigPK) other;
            final boolean areEqual = 
                (otherGuiPageConfigPK.componentRefId.equals(componentRefId) && otherGuiPageConfigPK.pageModeId.equals(pageModeId) );
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
