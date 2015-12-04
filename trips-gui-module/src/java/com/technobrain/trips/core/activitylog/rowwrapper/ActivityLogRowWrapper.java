package com.technobrain.trips.core.activitylog.rowwrapper;


import com.technobrain.trips.util.FacesUtil;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.logging.model.LogActivityLog;


public class ActivityLogRowWrapper {
    private LogActivityLog activityLog;
    private String moduleName, message;
    public ActivityLogRowWrapper() {
    }
    
    public ActivityLogRowWrapper(LogActivityLog activityLog) {
        this.activityLog = activityLog;
        fillRelatedAttributes();
    }

    private void fillRelatedAttributes() {
        if(activityLog.getModuleName() != null) {
//            List<BaseRefModelObject> names = 
//                new ReferenceCodeDelegate().findRefData(
//                    RefTripsModuleName.class.getName(), activityLog.getModuleName(), null);
//            if(names != null && names.size() > 0) {
//                moduleName = ((RefTripsModuleName)names.get(0)).getDescription();
//            }
        }
        message = FacesUtil.getStringFromBundle(activityLog.getMessageCode());
    }

    public void setActivityLog(LogActivityLog activityLog) {
        this.activityLog = activityLog;
    }

    public LogActivityLog getActivityLog() {
        return activityLog;
    }
    
    public void setLogRead(boolean logRead) {
        if(logRead) {
            activityLog.setRead(Constants.TRUE);
        }
        else {
            activityLog.setRead(Constants.FALSE);
        }
    }

    public String getMessageDetail() {
        return activityLog.getMessageDetail();
    }
    
    public String getExceptionDetail() {
        return activityLog.getExceptionDetail();
    }    
    
    public String getBpelInstanceId() {
        return activityLog.getBpelInstanceId();
    }
    
    public String getCreatedDate() {
        return activityLog.getCreatedDate().toString();
    }

    public boolean isLogRead() {
        return activityLog.getRead() == Constants.TRUE;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
