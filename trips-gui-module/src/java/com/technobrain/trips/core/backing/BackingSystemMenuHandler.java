package com.technobrain.trips.core.backing;

import java.util.Iterator;
import java.util.Map;

import javax.faces.context.FacesContext;


import com.technobrain.trips.util.WebConstants;
import org.primefaces.context.RequestContext;

public class BackingSystemMenuHandler extends BackingBase {
	private String reportLink;
	private String navigation;
	private String processScopePageConfig, processScopeGuiMode,
	processScopeShowSaveSearch, staticSearchInjection,
	processScopeGenericSearchModeKey, processScopeSearchKey,
	processScopeNavigation, withinCaseTabs, currentMenuId;
        
        private boolean processScopeGenericLookUpRequired, processScopeGenericDialog, processScopeRenderCloseButton;

    public void setProcessScopeGenericDialog(boolean processScopeGenericDialog) {
        this.processScopeGenericDialog = processScopeGenericDialog;
    }

    public boolean isProcessScopeGenericDialog() {
        return processScopeGenericDialog;
    }

    public void setProcessScopeRenderCloseButton(boolean processScopeRenderCloseButton) {
        this.processScopeRenderCloseButton = processScopeRenderCloseButton;
    }

    public boolean isProcessScopeRenderCloseButton() {
        return processScopeRenderCloseButton;
    }

    public void setProcessScopeGenericLookUpRequired(boolean processScopeGenericLookUpRequired) {
        this.processScopeGenericLookUpRequired = processScopeGenericLookUpRequired;
    }

    public boolean isProcessScopeGenericLookUpRequired() {
        return processScopeGenericLookUpRequired;
    }
    private String searchHeading;
	private String makeRegRegimeBtnDisable, makeRegimeTabDefault,
	shouldAutoNavigate, hideOnRegInd, hideOnReversePayment,
	receivePaymentListener, reversePaymentListener,
	supressCreateNewButton,caseWorkBasket,hideOnInstalmentAgreement,receiveInstalmentAgreement,
	reverseInstalmentAgreement,instalmentAgreement;

	public BackingSystemMenuHandler() {
//		reportLink = refDelegate.findSystemParameter("TRIPS_REPORT_LINK");
		//reportLink = "https://trips-cas:8443/cas/login?service=http%3A%2F%2Ftrips-reports%3A8080%2Fjasperserver-pro%2Fj_spring_cas_security_check";
	}

	public String menuChange() {

		// remove all session.
		sessionManager.cleanUpSystem();
		searchHeading = null;

		// remove all messages
		Iterator messages = FacesContext.getCurrentInstance().getMessages();
		while (messages.hasNext()) {
			messages.next();
			messages.remove();
		}

		// remove all session scoped messages
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		sessionMap.remove(WebConstants.Messages.CONFIRMATION_MESSAGE);
		sessionMap.remove(WebConstants.Messages.FATAL_ERROR);
		sessionMap.remove(WebConstants.Messages.GENERIC_ERROR);
		sessionMap.remove(WebConstants.Messages.NO_RECORD_SELECTED);
		sessionMap.remove(WebConstants.Messages.NO_RECORD_FOUND);

		// move parameter
		RequestContext requestContext = RequestContext.getCurrentInstance();
//		requestContext.getPageFlowScope().put("processScopePageConfig",
//				processScopePageConfig);
//		requestContext.getPageFlowScope().put("processScopeShowSaveSearch",
//				processScopeShowSaveSearch);
//		requestContext.getPageFlowScope().put("processScopeGuiMode",
//				processScopeGuiMode);
//		requestContext.getPageFlowScope().put("staticSearchInjection",
//				staticSearchInjection);
//		requestContext.getPageFlowScope().put(
//				"processScopeGenericSearchModeKey",
//				processScopeGenericSearchModeKey);
//		requestContext.getPageFlowScope().put("processScopeSearchKey",
//				processScopeSearchKey);
//		requestContext.getPageFlowScope().put("processScopeNavigation",
//				processScopeNavigation);
//		requestContext.getPageFlowScope().put("currentMenuId", currentMenuId);
//		if (makeRegRegimeBtnDisable != null)
//			requestContext.getPageFlowScope().put("makeRegRegimeBtnDisable",
//					(makeRegRegimeBtnDisable == "true" ? true : false));
//		if (makeRegimeTabDefault != null)
//			requestContext.getPageFlowScope().put("makeRegimeTabDefault",
//					(makeRegimeTabDefault == "true" ? true : false));
//		if (shouldAutoNavigate != null)
//			requestContext.getPageFlowScope().put("shouldAutoNavigate",
//					(shouldAutoNavigate == "true" ? true : false));
//		if (hideOnRegInd != null)
//			requestContext.getPageFlowScope().put("HideOnRegInd",
//					(hideOnRegInd == "true" ? true : false));
//		if (hideOnReversePayment != null)
//			requestContext.getPageFlowScope().put("hideOnReversePayment",
//					(hideOnReversePayment == "true" ? true : false));
//		if (withinCaseTabs != null)
//			requestContext.getPageFlowScope().put("isWithinCaseTabs",
//					(withinCaseTabs == "true" ? true : false));
//		if (receivePaymentListener != null)
//			requestContext.getPageFlowScope().put("receivePaymentListener",
//					(receivePaymentListener == "true" ? true : false));
//		if (supressCreateNewButton != null)
//			requestContext.getPageFlowScope().put("supressCreateNewButton",
//					(supressCreateNewButton == "true" ? true : false));
////		if(manualPenulty!=null)
////			requestContext.getPageFlowScope().put("manualPenulty", 
////					(manualPenulty== "true" ? true : false));
//		if(instalmentAgreement!=null)
//			requestContext.getPageFlowScope().put("instalmentAgreement", 
//					(instalmentAgreement== "true" ? true : false));
//		if(caseWorkBasket!=null)
//		{
////			HashMap allocateInitVars = new HashMap();
////			String loggedUserName=SecurityContextHolder.getContext().getAuthentication().getName();
////			System.out.println("name:"+loggedUserName);
////			allocateInitVars.put("CreatedBy", loggedUserName);
////			FacesUtil.getProcessScope().put(WebConstants.ProcessScopeVariable.DYNAMIC_SEARCH_CRITERIA_SETUP, allocateInitVars);
//			requestContext.getPageFlowScope().put("caseWorkBasket", 
//					(caseWorkBasket== "true" ? true : false));
//			
//		}
//		if(hideOnInstalmentAgreement!=null)
//			requestContext.getPageFlowScope().put("hideOnInstalmentAgreement", 
//					(hideOnInstalmentAgreement== "true" ? true : false));
//		if (receiveInstalmentAgreement != null)
//			requestContext.getPageFlowScope().put("receiveInstalmentAgreement",
//					(receiveInstalmentAgreement == "true" ? true : false));
//		if (reversePaymentListener != null)
//			requestContext.getPageFlowScope().put("reversePaymentListener",
//					(reversePaymentListener == "true" ? true : false));
//		
//                requestContext.getPageFlowScope().put("processScopeGenericLookUpRequired",
//	                            (processScopeGenericLookUpRequired  ? true : false));
//
//	    requestContext.getPageFlowScope().put("processScopeGenericDialog",
//	                        (processScopeGenericDialog  ? true : false));
//
//	    requestContext.getPageFlowScope().put("processScopeRenderCloseButton",
//	                        (processScopeRenderCloseButton  ? true : false));
//                
//                
//		if (reverseInstalmentAgreement != null)
//				requestContext.getPageFlowScope().put("reverseInstalmentAgreement",
//						(reverseInstalmentAgreement == "true" ? true : false));
//			
//			    requestContext.getPageFlowScope().put("isWithinCaseTabs",
//					withinCaseTabs);
			    
		getSearchHeading();

		return navigation;
	}

	public String getNavigation() {
		return navigation;
	}

	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}

	public String getProcessScopePageConfig() {
		return processScopePageConfig;
	}

	public void setProcessScopePageConfig(String processScopePageConfig) {
		this.processScopePageConfig = processScopePageConfig;
	}

	public String getProcessScopeGuiMode() {
		return processScopeGuiMode;
	}

	public void setProcessScopeGuiMode(String processScopeGuiMode) {
		this.processScopeGuiMode = processScopeGuiMode;
	}

	public String getStaticSearchInjection() {
		return staticSearchInjection;
	}

	public void setStaticSearchInjection(String staticSearchInjection) {
		this.staticSearchInjection = staticSearchInjection;
	}

	public String getProcessScopeGenericSearchModeKey() {
		return processScopeGenericSearchModeKey;
	}

	public void setProcessScopeGenericSearchModeKey(
			String processScopeGenericSearchModeKey) {
		this.processScopeGenericSearchModeKey = processScopeGenericSearchModeKey;
	}

	public String getProcessScopeSearchKey() {
		return processScopeSearchKey;
	}

	public void setProcessScopeSearchKey(String processScopeSearchKey) {
		this.processScopeSearchKey = processScopeSearchKey;
	}

	public String getProcessScopeNavigation() {
		return processScopeNavigation;
	}

	public void setProcessScopeNavigation(String processScopeNavigation) {
		this.processScopeNavigation = processScopeNavigation;
	}

	public String getWithinCaseTabs() {
		return withinCaseTabs;
	}

	public void setWithinCaseTabs(String withinCaseTabs) {
		this.withinCaseTabs = withinCaseTabs;
	}

	public String getMakeRegRegimeBtnDisable() {
		return makeRegRegimeBtnDisable;
	}

	public void setMakeRegRegimeBtnDisable(String makeRegRegimeBtnDisable) {
		this.makeRegRegimeBtnDisable = makeRegRegimeBtnDisable;
	}

	public String getMakeRegimeTabDefault() {
		return makeRegimeTabDefault;
	}

	public void setMakeRegimeTabDefault(String makeRegimeTabDefault) {
		this.makeRegimeTabDefault = makeRegimeTabDefault;
	}

	public String getShouldAutoNavigate() {
		return shouldAutoNavigate;
	}

	public void setShouldAutoNavigate(String shouldAutoNavigate) {
		this.shouldAutoNavigate = shouldAutoNavigate;
	}

	public String getHideOnRegInd() {
		return hideOnRegInd;
	}

	public void setHideOnRegInd(String hideOnRegInd) {
		this.hideOnRegInd = hideOnRegInd;
	}

//	public String getManualPenulty() {
//		return manualPenulty;
//	}
//
//	public void setManualPenulty(String manualPenulty) {
//		this.manualPenulty = manualPenulty;
//	}

	public String getHideOnReversePayment() {
		return hideOnReversePayment;
	}

	public void setHideOnReversePayment(String hideOnReversePayment) {
		this.hideOnReversePayment = hideOnReversePayment;
	}

	public String getReceivePaymentListener() {
		return receivePaymentListener;
	}

	public void setReceivePaymentListener(String receivePaymentListener) {
		this.receivePaymentListener = receivePaymentListener;
	}

	public String getReversePaymentListener() {
		return reversePaymentListener;
	}

	public void setReversePaymentListener(String reversePaymentListener) {
		this.reversePaymentListener = reversePaymentListener;
	}

	public String getSupressCreateNewButton() {
		return supressCreateNewButton;
	}

	public void setSupressCreateNewButton(String supressCreateNewButton) {
		this.supressCreateNewButton = supressCreateNewButton;
	}

	public String getProcessScopeShowSaveSearch() {
		return processScopeShowSaveSearch;
	}

	public void setProcessScopeShowSaveSearch(String processScopeShowSaveSearch) {
		this.processScopeShowSaveSearch = processScopeShowSaveSearch;
	}

	public String getCurrentMenuId() {
		return currentMenuId;
	}

	public void setCurrentMenuId(String currentMenuId) {
		this.currentMenuId = currentMenuId;
	}

	public String getSearchHeading() {
//		if (sessionManager.getFlowOfPages().size() != 0) {
//			if(sessionManager.getFlowOfPages().get(0) != null){
//				if(sessionManager.getFlowOfPages().get(0).getBackingBeanName()!= null){
//					if(sessionManager.getFlowOfPages().get(0).getBackingBeanName().equals("backingGenericSearch"))
//					{
//						BackingGenericSearch backingBean = (BackingGenericSearch) sessionManager
//								.getFlowOfPages().get(0).getBackingBean();
//						if (backingBean.getPreviousSearchId() != null) {
//							searchHeading = "SearchConfig."
//									+ backingBean.getPreviousSearchId() + ".SectionHeading";
//						}
//					}
//				}
//			}
//		}
		return searchHeading;
	}

	public void setSearchHeading(String searchHeading) {
		this.searchHeading = searchHeading;
	}

	public String getCaseWorkBasket() {
		return caseWorkBasket;
	}

	public void setCaseWorkBasket(String caseWorkBasket) {
		this.caseWorkBasket = caseWorkBasket;
	}

	public String getHideOnInstalmentAgreement() {
		return hideOnInstalmentAgreement;
	}

	public void setHideOnInstalmentAgreement(String hideOnInstalmentAgreement) {
		this.hideOnInstalmentAgreement = hideOnInstalmentAgreement;
	}

	public String getReceiveInstalmentAgreement() {
		return receiveInstalmentAgreement;
	}

	public void setReceiveInstalmentAgreement(String receiveInstalmentAgreement) {
		this.receiveInstalmentAgreement = receiveInstalmentAgreement;
	}

	public String getReverseInstalmentAgreement() {
		return reverseInstalmentAgreement;
	}

	public void setReverseInstalmentAgreement(String reverseInstalmentAgreement) {
		this.reverseInstalmentAgreement = reverseInstalmentAgreement;
	}

	public String getInstalmentAgreement() {
		return instalmentAgreement;
	}

	public void setInstalmentAgreement(String instalmentAgreement) {
		this.instalmentAgreement = instalmentAgreement;
	}
	
	public String getReportLink() {
		return reportLink;
	}

}
