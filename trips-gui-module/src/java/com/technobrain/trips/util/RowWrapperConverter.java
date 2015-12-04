package com.technobrain.trips.util;

import com.technobrain.trips.core.activitylog.rowwrapper.ActivityLogRowWrapper;

import java.util.ArrayList;
import java.util.List;


public class RowWrapperConverter {
    public RowWrapperConverter() {
    }
    
//    public static <R extends RowWrapper, I extends InputType> List<R> convertToRowWrappers(
//        List<I> segments, Class<R> rowWrapperClass) {
//        
//        if(segments == null)
//            return null;
//        List<R> wrappers = new ArrayList<R>();
//        for (int i = 0; i < segments.size(); i++)  {
//            R rowWrapper = null;
//            try {
//                rowWrapper = rowWrapperClass.newInstance();
//            } catch (IllegalAccessException e) {
//                return null;
//            } catch (InstantiationException e) {
//                return null;
//            }
//            rowWrapper.setTypeAndFillAttrs(segments.get(i));
//            wrappers.add(rowWrapper);
//        }
//        return wrappers;
//    }
//    
//    public static <R extends RowWrapper, I extends InputType> List<R> convertToRowWrappers(
//        I[] segments, Class<R> rowWrapperClass) {
//        
//        if(segments == null)
//            return null;
//        List<R> wrappers = new ArrayList<R>();
//        for (int i = 0; i < segments.length; i++)  {
//            R rowWrapper = null;
//            try {
//                rowWrapper = rowWrapperClass.newInstance();
//            } catch (IllegalAccessException e) {
//                return null;
//            } catch (InstantiationException e) {
//                return null;
//            }
//            rowWrapper.setTypeAndFillAttrs(segments[i]);
//            wrappers.add(rowWrapper);
//        }
//        return wrappers;
//    }
//    
//    public static <R extends RowWrapper, I extends InputType> List<R> convertToRowWrappers(
//        I[] segments, Class<R> rowWrapperClass, Object param) {
//        
//        if(segments == null)
//            return null;
//        List<R> wrappers = new ArrayList<R>();
//        for (int i = 0; i < segments.length; i++)  {
//            R rowWrapper = null;
//            try {
//                rowWrapper = rowWrapperClass.newInstance();
//            } catch (IllegalAccessException e) {
//                return null;
//            } catch (InstantiationException e) {
//                return null;
//            }
//            rowWrapper.setTypeAndFillAttrs(segments[i], param);
//            wrappers.add(rowWrapper);
//        }
//        return wrappers;
//    }
//
//    public static <R extends RowWrapper, I extends InputType> I[] convertToInputTypes(
//        List<R> wrappers) {
//        
//        if(wrappers == null)
//            return null;
//        Object[] segments = new Object[wrappers.size()];
//        for (int i = 0; i < wrappers.size(); i++)  {
//            segments[i] = wrappers.get(i).getType();
//        }
//        return (I[])segments;
//    }

//    public static List<ActivityLogRowWrapper> convertToActivityLogsRowWrappers(
//        List<LogActivityLog> segments) {
//        
//        if(segments == null)
//            return null;
//        List<ActivityLogRowWrapper> wrappers = new ArrayList<ActivityLogRowWrapper>();
//        for (int i = 0; i < segments.size(); i++)  {
//            wrappers.add(new ActivityLogRowWrapper(segments.get(i)));
//        }
//        return wrappers;
//    }
//
//    public static List<LogActivityLog> convertToActivityLogsPojo(
//        List<ActivityLogRowWrapper> wrappers) {
//        
//        if(wrappers == null)
//            return null;
//        List<LogActivityLog> segments = new ArrayList<LogActivityLog>();
//        for (int i = 0; i < wrappers.size(); i++)  {
//            segments.add(wrappers.get(i).getActivityLog());
//        }
//        return segments;
//    }
//  
//    
//    public static List<ApplicationMachineDetailsInputTypeRowWrapper> convertToAppMachineDetailsRowWrappers(ApplicationMachineDetailsInputType[] segments) {
//        if(segments == null)
//            return null;
//        List<ApplicationMachineDetailsInputTypeRowWrapper> wrappers = new ArrayList<ApplicationMachineDetailsInputTypeRowWrapper>();
//        for (int i = 0; i < segments.length; i++)  {
//            wrappers.add(new ApplicationMachineDetailsInputTypeRowWrapper(segments[i]));
//        }
//        return wrappers;
//    }
//    
//    public static List<ApplicationBookOfAccountsInputTypeRowWrapper> convertToAppBookOfAccountsRowWrappers(ApplicationBookOfAccountsInputType[] segments) {
//        if(segments == null)
//            return null;
//        List<ApplicationBookOfAccountsInputTypeRowWrapper> wrappers = new ArrayList<ApplicationBookOfAccountsInputTypeRowWrapper>();
//        for (int i = 0; i < segments.length; i++)  {
//            wrappers.add(new ApplicationBookOfAccountsInputTypeRowWrapper(segments[i]));
//        }
//        return wrappers;
//    }
//    
//    
//    public static List<ApplicationReceiptDetailsInputTypeRowWrapper> convertToAppReceiptDetailsRowWrappers(ApplicationReceiptDetailsInputType[] segments) {
//        if(segments == null)
//            return null;
//        List<ApplicationReceiptDetailsInputTypeRowWrapper> wrappers = new ArrayList<ApplicationReceiptDetailsInputTypeRowWrapper>();
//        for (int i = 0; i < segments.length; i++)  {
//            wrappers.add(new ApplicationReceiptDetailsInputTypeRowWrapper(segments[i]));
//        }
//        return wrappers;
//    }
//
//    public static List<AppCollAgentCoverageRowWrapper> convertToAppCollAgentCoverageRowWrappers(AppCollAgentCoverageDetailsInputType[] segments) {
//        if(segments == null)
//            return null;
//        List<AppCollAgentCoverageRowWrapper> wrappers = new ArrayList<AppCollAgentCoverageRowWrapper>();
//        for (int i = 0; i < segments.length; i++)  {
//            wrappers.add(new AppCollAgentCoverageRowWrapper(segments[i]));
//        }
//        return wrappers;
//    }
//
//    public static List<AppCollAgentEfficiencyDetailsRowWrapper> convertToAppCollAgentEfficiencyRowWrappers(AppCollAgentEfficiencyDetailsInputType[] segments) {
//        if(segments == null)
//            return null;
//        List<AppCollAgentEfficiencyDetailsRowWrapper> wrappers = new ArrayList<AppCollAgentEfficiencyDetailsRowWrapper>();
//        for (int i = 0; i < segments.length; i++)  {
//            wrappers.add(new AppCollAgentEfficiencyDetailsRowWrapper(segments[i]));
//        }
//        return wrappers;
//    }
//
//    public static List<AppSpouseApplicantDetailsRowWrapper> convertToAppSpouseApplicantDetailsRowWrappers(AppSpouseApplicantDetailsInputType[] segments) {
//        if(segments == null)
//            return null;
//        List<AppSpouseApplicantDetailsRowWrapper> wrappers = new ArrayList<AppSpouseApplicantDetailsRowWrapper>();
//        for (int i = 0; i < segments.length; i++)  {
//            wrappers.add(new AppSpouseApplicantDetailsRowWrapper(segments[i]));
//        }
//        return wrappers;
//    }
//
//    public static List<AppDependentDetailsRowWrapper> convertToAppDependentDetailsRowWrappers(AppDependentDetailsInputType[] segments) {
//        if(segments == null)
//            return null;
//        List<AppDependentDetailsRowWrapper> wrappers = new ArrayList<AppDependentDetailsRowWrapper>();
//        for (int i = 0; i < segments.length; i++)  {
//            wrappers.add(new AppDependentDetailsRowWrapper(segments[i]));
//        }
//        return wrappers;
//    }
//    
//    public static ApplicationReceiptDetailsInputType[] convertToAppReceiptDetailsInputTypes(List<ApplicationReceiptDetailsInputTypeRowWrapper> wrappers) {
//        
//        if(wrappers == null)
//            return null;
//        ApplicationReceiptDetailsInputType[] segments = new ApplicationReceiptDetailsInputType[wrappers.size()];
//        for (int i = 0; i < wrappers.size(); i++)  {
//            segments[i] = wrappers.get(i).getType();
//        }
//        return segments;
//    }
//
//    public static ApplicationMachineDetailsInputType[] convertToAppMachineDetailsInputTypes(List<ApplicationMachineDetailsInputTypeRowWrapper> wrappers) {
//            if(wrappers == null)
//                return null;
//            ApplicationMachineDetailsInputType[] segments = new ApplicationMachineDetailsInputType[wrappers.size()];
//            for (int i = 0; i < wrappers.size(); i++)  {
//                segments[i] = wrappers.get(i).getType();
//            }
//            return segments;
//    }
//
//    public static ApplicationBookOfAccountsInputType[] convertToAppBookOfAccountsInputTypes(List<ApplicationBookOfAccountsInputTypeRowWrapper> wrappers) {
//        if(wrappers == null)
//            return null;
//        ApplicationBookOfAccountsInputType[] segments = new ApplicationBookOfAccountsInputType[wrappers.size()];
//        for (int i = 0; i < wrappers.size(); i++)  {
//            segments[i] = wrappers.get(i).getType();
//        }
//        return segments;
//    
//    }
//
//    public static AppDependentDetailsInputType[] convertToAppDependentDetailsInputTypes(List<AppDependentDetailsRowWrapper> wrappers) {
//        if(wrappers == null)
//            return null;
//        AppDependentDetailsInputType[] segments = new AppDependentDetailsInputType[wrappers.size()];
//        for (int i = 0; i < wrappers.size(); i++)  {
//            segments[i] = wrappers.get(i).getType();
//        }
//        return segments;
//    }
//
//    public static AppSpouseApplicantDetailsInputType[] convertToAppSpouseApplicantDetailsInputType(List<AppSpouseApplicantDetailsRowWrapper> wrappers) {
//        if(wrappers == null)
//            return null;
//        AppSpouseApplicantDetailsInputType[] segments = new AppSpouseApplicantDetailsInputType[wrappers.size()];
//        for (int i = 0; i < wrappers.size(); i++)  {
//            segments[i] = wrappers.get(i).getType();
//        }
//        return segments;
//    }
//
//    public static AppCollAgentCoverageDetailsInputType[] convertToAppCollAgentCoverageInputTypes(List<AppCollAgentCoverageRowWrapper> wrappers) {
//        if(wrappers == null)
//            return null;
//        AppCollAgentCoverageDetailsInputType[] segments = new AppCollAgentCoverageDetailsInputType[wrappers.size()];
//        for (int i = 0; i < wrappers.size(); i++)  {
//            segments[i] = wrappers.get(i).getType();
//        }
//        return segments;
//    }
//    
//    public static AppCollAgentEfficiencyDetailsInputType[] convertToAppCollAgentEfficiencyDetailsInputTypes(List<AppCollAgentEfficiencyDetailsRowWrapper> wrappers) {
//        if(wrappers == null)
//            return null;
//        AppCollAgentEfficiencyDetailsInputType[] segments = new AppCollAgentEfficiencyDetailsInputType[wrappers.size()];
//        for (int i = 0; i < wrappers.size(); i++)  {
//            segments[i] = wrappers.get(i).getType();
//        }
//        return segments;
//    }
}
