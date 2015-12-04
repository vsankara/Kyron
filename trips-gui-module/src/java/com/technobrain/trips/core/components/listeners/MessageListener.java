package com.technobrain.trips.core.components.listeners;

import java.text.MessageFormat;

import java.util.Iterator;
import java.util.Locale;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;


public class MessageListener implements PhaseListener {
    public MessageListener() {
    }

    public void afterPhase(PhaseEvent phaseEvent) {
    }

    public void beforePhase(PhaseEvent phaseEvent) {
//        FacesContext fc = phaseEvent.getFacesContext();
//        UIViewRoot root = fc.getViewRoot();
//        String mbName = fc.getApplication().getMessageBundle();
//        Locale locale = root.getLocale();
//        ResourceBundle rb = ResourceBundle.getBundle(mbName, locale);
//
//        Iterator i = fc.getClientIdsWithMessages();
//        while (i.hasNext()) {
//            String clientId = (String)i.next();
//            UIComponent c = root.findComponent(clientId);
//            String fieldRef = (String)c.getAttributes().get("ref");
//            if (fieldRef != null) {
//                Iterator j = fc.getMessages(clientId);
//                while (j.hasNext()) {
//                    FacesMessage fm = (FacesMessage)j.next();
//                    String detail = fm.getDetail();
//                    if(log.isDebugEnabled())log.debug("detail " + detail);
//                    if ("CONV_ERR_MSG".equals(detail)) {
//                        String custMsgPattern = 
//                            rb.getString("CUST_CONV_ERR_MSG_detail");
//                        Object[] params = new Object[1];
//                        params[0] = 
//                                ((EditableValueHolder)c).getSubmittedValue();
//                        String custMsg = 
//                            MessageFormat.format(custMsgPattern, params);
//                        fm.setDetail(custMsg);
//                    }
//                    fm.setDetail(fieldRef + ": " + fm.getDetail());
//                }
//            }
//        }
    }

    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}
