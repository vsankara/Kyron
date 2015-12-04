package com.technobrain.trips.reports.param;

import com.technobrain.trips.common.constants.Constants;

import com.technobrain.trips.common.helpers.StringHelper;

import java.util.Calendar;
import java.util.Date;


public class ScheduleInfo {

    
    private java.util.Date endDate;

    private java.lang.String jobCalendar;

    private java.lang.String jobLocale;

    private java.lang.String jobTZ;

    private java.lang.String notificationTo;

    private boolean notifyWhenFailed;

    private boolean notifyWhenSuccess;

    private boolean notifyWhenWarning;

    private int repeatCount;

    private int repeatInterval;

    private boolean saveDataOption;

    private boolean saveOutputOption;

    private boolean scheduleBurstringOption;

    private boolean schedulePublicOption;

    private java.util.Date startDate;

    private boolean useUTF8Option;

    private java.lang.String userJobName;

    public void setJobCalendar(String jobCalendar) {
        this.jobCalendar = jobCalendar;
    }

    public String getJobCalendar() {
        return jobCalendar;
    }

    public void setJobLocale(String jobLocale) {
        this.jobLocale = jobLocale;
    }

    public String getJobLocale() {
        return jobLocale;
    }

    public void setJobTZ(String jobTZ) {
        this.jobTZ = jobTZ;
    }

    public String getJobTZ() {
        return jobTZ;
    }

    public void setNotificationTo(String notificationTo) {
        this.notificationTo = notificationTo;
    }

    public String getNotificationTo() {
        return notificationTo;
    }

    public void setNotifyWhenFailed(boolean notifyWhenFailed) {
        this.notifyWhenFailed = notifyWhenFailed;
    }

    public boolean isNotifyWhenFailed() {
        return notifyWhenFailed;
    }

    public void setNotifyWhenSuccess(boolean notifyWhenSuccess) {
        this.notifyWhenSuccess = notifyWhenSuccess;
    }

    public boolean isNotifyWhenSuccess() {
        return notifyWhenSuccess;
    }

    public void setNotifyWhenWarning(boolean notifyWhenWarning) {
        this.notifyWhenWarning = notifyWhenWarning;
    }

    public boolean isNotifyWhenWarning() {
        return notifyWhenWarning;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatInterval(int repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public int getRepeatInterval() {
        return repeatInterval;
    }

    public void setSaveDataOption(boolean saveDataOption) {
        this.saveDataOption = saveDataOption;
    }

    public void setSaveDataOption(String saveDataOption) {
         this.saveDataOption = StringHelper.getOptionAsBoolean(saveDataOption);
    }    
    

    public boolean isSaveDataOption() {
        return saveDataOption;
    }

    public void setSaveOutputOption(boolean saveOutputOption) {
        this.saveOutputOption = saveOutputOption;
    }

    public void setSaveOutputOption(String saveOutputOption) {
         this.saveOutputOption = StringHelper.getOptionAsBoolean(saveOutputOption);
    } 

    public boolean isSaveOutputOption() {
        return saveOutputOption;
    }

    public void setScheduleBurstringOption(boolean scheduleBurstringOption) {
        this.scheduleBurstringOption = scheduleBurstringOption;
    }

    public boolean isScheduleBurstringOption() {
        return scheduleBurstringOption;
    }

    public void setSchedulePublicOption(boolean schedulePublicOption) {
        this.schedulePublicOption = schedulePublicOption;
    }

    public boolean isSchedulePublicOption() {
        return schedulePublicOption;
    }

    public void setUseUTF8Option(boolean useUTF8Option) {
        this.useUTF8Option = useUTF8Option;
    }
    
    public void setUseUTF8Option(String useUTF8Option) {
        this.useUTF8Option = StringHelper.getOptionAsBoolean(useUTF8Option);
    }

    public boolean isUseUTF8Option() {
        return useUTF8Option;
    }

    public void setUserJobName(String userJobName) {
        this.userJobName = userJobName;
    }

    public String getUserJobName() {
        return userJobName;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }
}
