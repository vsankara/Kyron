package com.technobrain.trips.core.activitylog.backing;

//package com.crownagents.trips.core.activitylog.backing;
//
////import com.crownagents.trips.auditandvisit.delegate.AuditAndVisitDelegate;
//import com.crownagents.trips.core.activitylog.rowwrapper.ActivityLogRowWrapper;
//import com.crownagents.trips.core.onetomanytable.GenericSingleSelectionTableHandler;
//import com.crownagents.trips.core.onetomanytable.OneBackingBeanToTableRowAndTables;
//import com.crownagents.trips.util.FacesUtil;
//import com.crownagents.trips.util.RowWrapperConverter;
//import com.crownagents.trips.util.WebConstants;
//
//import java.util.List;
//
//import javax.faces.event.ValueChangeEvent;
//
//import org.apache.myfaces.trinidad.context.RequestContext;
//
//
//public class BackingActivityLog extends OneBackingBeanToTableRowAndTables {
//    private GenericSingleSelectionTableHandler infoLogMessages, errorLogMessages;
////    private AuditAndVisitDelegate auditDelegate;
//    private boolean showUnread = true;
//    private String exceptionDetail;
//    
//    public BackingActivityLog() {
////        auditDelegate = new AuditAndVisitDelegate();
//        initTables();
//    }
//    
//    public void initTables() {
////        infoLogMessages = new GenericSingleSelectionTableHandler(RowWrapperConverter.convertToActivityLogsRowWrappers(
////            auditDelegate.findInfoActivityLogsForUser(showUnread)));
////        errorLogMessages = new GenericSingleSelectionTableHandler(RowWrapperConverter.convertToActivityLogsRowWrappers(
////            auditDelegate.findErrorActivityLogsForUser(showUnread)));
//    }
//    
//    public String saveAction() {
////        auditDelegate.saveOrUpdateActivityLogs(RowWrapperConverter.convertToActivityLogsPojo(
////            (List<ActivityLogRowWrapper>)infoLogMessages.getDataAsList()));
////        auditDelegate.saveOrUpdateActivityLogs(RowWrapperConverter.convertToActivityLogsPojo(
////            (List<ActivityLogRowWrapper>)errorLogMessages.getDataAsList()));
//            
//        FacesUtil.addFacesInfoMessage(WebConstants.Messages.CONFIRMATION, 
//            "moduleName.ActivityLog", "ActivityLog.infoMessage.LogsSaved");
//        RequestContext.getCurrentInstance().returnFromDialog(null, null);
//        return null;
//    }
//    
//    public void showUnreadValueChanged(ValueChangeEvent event) {
//        showUnread = (Boolean)event.getNewValue();
//        initTables();
//        FacesUtil.refreshCurrentPage();
//    }
//
//    public void setErrorLogMessages(GenericSingleSelectionTableHandler errorLogMessages) {
//        this.errorLogMessages = errorLogMessages;
//    }
//
//    public GenericSingleSelectionTableHandler getErrorLogMessages() {
//        return errorLogMessages;
//    }
//
//    public void setInfoLogMessages(GenericSingleSelectionTableHandler infoLogMessages) {
//        this.infoLogMessages = infoLogMessages;
//    }
//
//    public GenericSingleSelectionTableHandler getInfoLogMessages() {
//        return infoLogMessages;
//    }
//
//    public void setShowUnread(boolean showUnread) {
//        this.showUnread = showUnread;
//    }
//
//    public boolean isShowUnread() {
//        return showUnread;
//    }
//
//    protected void onPageLoad(int MODE, Object rowData) {
//    }
//
//    protected Object getBeanRepresentedAsRow() {
//        return null;
//    }
//
//    protected boolean isValidProcess(int currentMode) {
//        return true;
//    }
//
//    public void setExceptionDetail(String exceptionDetail) {
//        this.exceptionDetail = exceptionDetail;
//    }
//
//    public String getExceptionDetail() {
//        return exceptionDetail;
//    }
//}
