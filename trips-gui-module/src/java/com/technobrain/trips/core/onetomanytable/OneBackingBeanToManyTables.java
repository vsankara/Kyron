package com.technobrain.trips.core.onetomanytable;


import com.technobrain.trips.core.backing.BackingBase;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.util.WebConstants;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.component.commandbutton.CommandButton;


import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
//import com.sun.faces.util.ConstantMethodBinding;

//import org.apache.myfaces.trinidadinternal.taglib.ConstantMethodBinding;
//import com.sun.faces.util.ConstantMethodBinding;

/**
 * �?��Crown Agents 2006
 * <p>
 * Allows backing-beans with one or more tables to be managed easily and
 * hopefully effectively.
 * <p>
 * Note these backend-beans should be sessionScope to allow for easy table
 * management.
 * 
 * @since $Date: 19/08/2009 12:20:29$
 * @version $Revision: 31$
 * @author $Author: Idris Yildiz$
 * 
 *         $Log[1]: 31 TRIPS2 1.30 19/08/2009 12:20:29 Idris Yildiz process
 *         delete no record selection check added $
 */
public class OneBackingBeanToManyTables extends BackingBase {

	public static Logger logger = Logger
			.getLogger(OneBackingBeanToManyTables.class.getName());

	/**
	 * Maps to the jspx commandButton f:param data which is sent via the http
	 * request when the user clicks the Add or Edit or Delete buttons for a
	 * table. <b>The f:param data indicates the tableHandler bound to the
	 * table.</b>
	 * 
	 * <code>
	 * <f:param  name="tableHandlerName" data="singleSelectionTableHandler"  />
	 * </code>
	 */
	private static final String TABLE_HANDLER_NAME = "tableHandlerName";
	private static final String TABLE_HANDLER_KEY = "tableHandlerKey";

	public static final String TABLE_BUTTON_ACTION = "tableButtonAction";

	public static final String BACKING_BEAN_NAME = "backingBeanName";

	public static final String DATA_TYPE = "dataType";
	/**
	 * Represents the constant used to tag an action expression string that is
	 * used to be unique.
	 */
	public static final String TAG_ACTION_AS_SELF = "TagSelfSelfTagTrips";

	// the concrete backing bean is filled when we extend the concrete backing
	// bean with OneBackingBeanToTableRowAndTables, not with
	// OneBackingBeanToManyTables. We need to have a reference to that concrete
	// backing bean, because sometimes in this class,
	// we need to find an attribute (tablehandler) by reflection from that
	// concrete backing bean class.
	private OneBackingBeanToTableRowAndTables callerBackingBean;
	private List removingDataList;
	private List addDataList;
	
	
	
	
	public List getAddDataList() {
		if(addDataList == null){
			addDataList = new ArrayList();
		}
		return addDataList;
	}

	public void setAddDataList(List addDataList) {
		this.addDataList = addDataList;
	}

	public List getRemovingDataList() {
		if(removingDataList == null){
			removingDataList = new ArrayList();
		}
		return removingDataList;
	}

	public void setRemovingDataList(List removingDataList) {
		this.removingDataList = removingDataList;
	}

	public OneBackingBeanToManyTables() {

	}

	public OneBackingBeanToManyTables(String viewId) {
		super(viewId);
	}

	public OneBackingBeanToManyTables(
			OneBackingBeanToTableRowAndTables callerBackingBean) {
		this.callerBackingBean = callerBackingBean;
	}


	
	/**
	 * use actionListener="#{backingDeclarationDetails.launchAddDialog}" for
	 * command button
	 */
	
	
	public void launchAddDialog(ActionEvent evt) {
//		((CommandButton) evt.getComponent()).setBlocking(true);
		((CommandButton) evt.getComponent()).setPartialSubmit(true);

		String tableName = (String) evt.getComponent().getAttributes()
				.get(TABLE_HANDLER_NAME);
		FacesUtil.getProcessScope().put(TABLE_HANDLER_NAME, tableName);

		String tableButton = (String) evt.getComponent().getAttributes()
				.get(TABLE_BUTTON_ACTION);
		FacesUtil.getProcessScope().put(TABLE_BUTTON_ACTION, tableButton);

		Object datatype = (Object) evt.getComponent().getAttributes()
				.get(DATA_TYPE);
		if (datatype != null) {
			FacesUtil.getProcessScope().put(DATA_TYPE, datatype);
		}
		processAdd();
	}

	/**
	 * use actionListener="#{backingDeclarationDetails.launchCreateDialog}" for
	 * command button
	 */
	public void launchCreateDialog(ActionEvent evt) {
//		((CommandButton) evt.getComponent()).setBlocking(true);
		((CommandButton) evt.getComponent()).setPartialSubmit(true);

		String tableName = (String) evt.getComponent().getAttributes()
				.get(TABLE_HANDLER_NAME);
		FacesUtil.getProcessScope().put(TABLE_HANDLER_NAME, tableName);

		String tableButton = (String) evt.getComponent().getAttributes()
				.get(TABLE_BUTTON_ACTION);
		FacesUtil.getProcessScope().put(TABLE_BUTTON_ACTION, tableButton);

		String datatype = (String) evt.getComponent().getAttributes()
				.get(DATA_TYPE);
		if (datatype != null) {
			FacesUtil.getProcessScope().put(DATA_TYPE, datatype);
		}
		processCreate();
	}

	/**
	 * use actionListener="#{backingDeclarationDetails.launchEditDialog}" for
	 * command button
	 */
	public void launchEditDialog(ActionEvent evt) {
//		((CommandButton) evt.getComponent()).setBlocking(true);
		((CommandButton) evt.getSource()).setPartialSubmit(true);

		String tableName = (String) evt.getComponent().getAttributes()
				.get(TABLE_HANDLER_NAME);
		FacesUtil.getProcessScope().put(TABLE_HANDLER_NAME, tableName);

		String tableButton = (String) evt.getComponent().getAttributes()
				.get(TABLE_BUTTON_ACTION);
		FacesUtil.getProcessScope().put(TABLE_BUTTON_ACTION, tableButton);

		String datatype = (String) evt.getComponent().getAttributes()
				.get(DATA_TYPE);
		if (datatype != null) {
			FacesUtil.getProcessScope().put(DATA_TYPE, datatype);
		}

		String tableHandlerKey = (String) FacesUtil.getProcessScope().get(
				WebConstants.ProcessScopeVariable.MULTI_TABLE_HANDLERS_MAP_KEY);
		if (tableHandlerKey != null && !tableHandlerKey.equals("")) {
			//selectionRequiredBeforeDialog(processEdit(evt), evt);
		} else {
			selectionRequiredBeforeDialog(processEdit(), evt);
		}
	}

	public void launchViewDialog(ActionEvent evt) {
//		((CommandButton) evt.getComponent()).setBlocking(true);
		((CommandButton) evt.getSource()).setPartialSubmit(true);

		String tableName = (String) evt.getComponent().getAttributes()
				.get(TABLE_HANDLER_NAME);
		FacesUtil.getProcessScope().put(TABLE_HANDLER_NAME, tableName);

		String tableButton = (String) evt.getComponent().getAttributes()
				.get(TABLE_BUTTON_ACTION);
		FacesUtil.getProcessScope().put(TABLE_BUTTON_ACTION, tableButton);

		String datatype = (String) evt.getComponent().getAttributes()
				.get(DATA_TYPE);
		if (datatype != null) {
			FacesUtil.getProcessScope().put(DATA_TYPE, datatype);
		}

		selectionRequiredBeforeDialog(processView(), evt);
	}

	/**
	 * Checks if the dialog process should launch based on this _Navigation
	 * <p>
	 * This is done by updating the component action to be one not defined in
	 * the faces config so that it may navigate back to itself
	 * 
	 * @param _Navigation
	 * @param evt
	 */
	public void selectionRequiredBeforeDialog(String _Navigation,
			ActionEvent evt) {
		/**
		 * <f:param> not working in
		 * <tr:commandButton>
		 * 
		 * */

		/*
		 * MethodBinding constantMethodBinding =
		 * ((CoreCommandButton)evt.getSource()).getAction(); String
		 * desiredNavigation =
		 * (String)constantMethodBinding.invoke(FacesContext.
		 * getCurrentInstance(),null); String nav =
		 * desiredNavigation.concat(TAG_ACTION_AS_SELF);
		 * 
		 * ConstantMethodBinding cmb = null;
		 */

		MethodExpression constantMethodExpr = ((CommandButton) evt
				.getSource()).getActionExpression();
		String desiredNavigation = (String) constantMethodExpr.invoke(
				FacesUtil.getELContext(), null);
		String nav = (desiredNavigation == null) ? TAG_ACTION_AS_SELF
				: desiredNavigation.concat(TAG_ACTION_AS_SELF);

//		ConstantMethodBinding cmb = null;
//
//		if (_Navigation.equalsIgnoreCase(FacesUtil.FAILURE_OUTCOME)) {
//			cmb = new ConstantMethodBinding(nav);
//			CoreCommandButton button = (CoreCommandButton) evt.getSource();
//			button.setAction(cmb);
//			button.setUseWindow(false);
//
//		} else if (nav.endsWith(TAG_ACTION_AS_SELF)) {// reverse changes
//			CoreCommandButton button = (CoreCommandButton) evt.getSource();
//			nav = nav.substring(0, nav.indexOf(TAG_ACTION_AS_SELF));
//			cmb = new ConstantMethodBinding(nav);
//			button.setAction(cmb);
//			button.setUseWindow(true);
//		}

	}

	/**
	 * Linked to a acction on the page to launch a Dialog in Add Mode
	 * <p>
	 * On the add button event for the table access the tableHandlerName to
	 * determine which table is active and put in in the session to be accessed
	 * by the selected Table row page.
	 */
	public String processAdd() {

		String tableType = retrieveTableHandlerName();
		// String tableType =
		// FacesUtil.getProcessScope().get("tableHandlerName").toString();
		// store the original session scope variables that are used for this
		// backing bean. Because we will overwrite them.
		sessionManager.backupSessionScopeVars();
		FacesUtil.storeOnSession(OneBackingBeanToOneTableRow.TABLE_MODE_KEY,
				OneBackingBeanToOneTableRow.TABLE_ADD_MODE);
		FacesUtil.storeOnSession(OneBackingBeanToOneTableRow.TABLE_HANDLER_KEY,
				determineTableHandler(tableType));

		if (logger.isLoggable(Level.FINER)) {
			logger.fine("launchAddDialog() for table " + tableType);
		}

		return retrieveCurrentTableAction();
	}

	public String processCreate() {

		String tableType = retrieveTableHandlerName();
		// String tableType =
		// FacesUtil.getProcessScope().get("tableHandlerName").toString();
		// store the original session scope variables that are used for this
		// backing bean. Because we will overwrite them.
		sessionManager.backupSessionScopeVars();
		FacesUtil.storeOnSession(OneBackingBeanToOneTableRow.TABLE_MODE_KEY,
				OneBackingBeanToOneTableRow.TABLE_CREATE_MODE);
		FacesUtil.storeOnSession(OneBackingBeanToOneTableRow.TABLE_HANDLER_KEY,
				determineTableHandler(tableType));

		if (logger.isLoggable(Level.FINER)) {
			logger.fine("launchCreateDialog() for table " + tableType);
		}

		return retrieveCurrentTableAction();
	}

	public void backupSessionScopeVars() {
		sessionManager.backupSessionScopeVars();
	}

	/**
	 * Linked to a action on the page to launch a Dialog in Edit Mode
	 * <p>
	 * On the edit button event for the table access the tableHandlerName to
	 * determine which table is active and put in in the session to be accessed
	 * by the selected Table row page.
	 */
	public String processEdit() {
		if (tableHandler != null) {
			return processEdit(tableHandler.getTable());
		} else {
			String tableType = retrieveTableHandlerName();
			GenericSingleSelectionTableHandler handler = determineTableHandler(tableType);
			return processEdit(handler.getTable());
		}
	}

	public String processEdit(ActionEvent evt) {
		DataTable table = (DataTable) FacesUtil.findFirstWrapperComponent(
				evt.getComponent(), "CoreTable");
		processEdit(table);
		return null;
	}

	private String processEdit(DataTable table) {
		String tableType = retrieveTableHandlerName();
		GenericSingleSelectionTableHandler handler = determineTableHandler(tableType);
		handler.settable(table);
		if (handler.isARowSelected()) {
			// store the original session scope variables that are used for this
			// backing bean. Because we will overwrite them.
			sessionManager.backupSessionScopeVars();
			FacesUtil.storeOnSession(
					OneBackingBeanToOneTableRow.TABLE_MODE_KEY,
					OneBackingBeanToOneTableRow.TABLE_EDIT_MODE);
			FacesUtil.storeOnSession(
					OneBackingBeanToOneTableRow.TABLE_HANDLER_KEY, handler);

			if (logger.isLoggable(Level.FINER)) {
				logger.fine("launchEditDialog() for table " + tableType);
			}

			return retrieveCurrentTableAction();

		} else {

			if (logger.isLoggable(Level.FINER)) {
				logger.fine("failed launchEditDialog() for table " + tableType
						+ " reason no row selected");
			}

			// test way do not do it this way
			FacesUtil.addFacesErrorMessage("TableErrorNoRowSelected");

			return FacesUtil.FAILURE_OUTCOME;
		}

	}

	/**
	 * TODO:Needs to be modified to use GuiConfiguration to open the table at
	 * readonly mode- VP
	 */
	public String processView() {
		if (tableHandler != null) {
			return processView(tableHandler.getTable());
		} else {
			String tableType = retrieveTableHandlerName();
			GenericSingleSelectionTableHandler handler = determineTableHandler(tableType);
			return processView(handler.getTable());
		}
	}

	public String processView(ActionEvent evt) {
		DataTable table = (DataTable) FacesUtil.findFirstWrapperComponent(
				evt.getComponent(), "CoreTable");
		processView(table);
		return null;
	}

	private String processView(DataTable table) {
		String tableType = retrieveTableHandlerName();
		GenericSingleSelectionTableHandler handler = determineTableHandler(tableType);
		handler.settable(table);
		if (handler.isARowSelected()) {
			// store the original session scope variables that are used for this
			// backing bean. Because we will overwrite them.
			sessionManager.backupSessionScopeVars();
			FacesUtil.storeOnSession(
					OneBackingBeanToOneTableRow.TABLE_MODE_KEY,
					OneBackingBeanToOneTableRow.TABLE_VIEW_MODE);
			FacesUtil.storeOnSession(
					OneBackingBeanToOneTableRow.TABLE_HANDLER_KEY, handler);

			if (logger.isLoggable(Level.FINER)) {
				logger.fine("launchEditDialog() for table " + tableType);
			}

			return retrieveCurrentTableAction();

		} else {

			if (logger.isLoggable(Level.FINER)) {
				logger.fine("failed launchEditDialog() for table " + tableType
						+ " reason no row selected");
			}

			// test way do not do it this way
			FacesUtil.addFacesErrorMessage("TableErrorNoRowSelected");
			return FacesUtil.FAILURE_OUTCOME;
		}

	}

	/**
	 * Method which allows to delete records without confirmation message for
	 * one or many tables
	 * 
	 * @return
	 */
	public String processDelete() {

		if (tableHandler != null) {
			deleteFromTable(tableHandler.getTable());
		} else {
			String tableType = retrieveTableHandlerName();
			GenericSingleSelectionTableHandler handler = determineTableHandler(tableType);
			
			deleteFromTable(handler.getTable());
		}
		return null;
	}

	public String processDelete(ActionEvent evt) {
		DataTable table = (DataTable) FacesUtil.findFirstWrapperComponent(
				evt.getComponent(), "CoreTable");
		deleteFromTable(table);
		return null;
	}

	private void deleteFromTable(DataTable table) {

		String tableType = retrieveTableHandlerName();
		GenericSingleSelectionTableHandler tableHandler = determineTableHandler(tableType);
		tableHandler.settable(table);
		if (tableHandler.isARowSelected()) {
			//barkhas
			if(table.getSelection()!= null){
				this.getRemovingDataList().add(table.getSelection());
			}
			tableHandler.deleteSelectedIndividualRow();
//			RequestContext.getCurrentInstance().addPartialTarget(table);
		} else {
			if (logger.isLoggable(Level.FINER)) {
				logger.fine("failed deleting for table " + tableType
						+ " reason no row selected");
			}

			// test way do not do it this way
			FacesUtil.addFacesErrorMessage("TableErrorNoRowSelected");
		}
		// TODO Kemal-Piraba: WE are not sure where the below code is used. For
		// now, it is commented. It will be deleted later.
		// else {
		// FacesContext ctx = FacesContext.getCurrentInstance();
		// GenericSingleSelectionTableHandler handler =
		// (GenericSingleSelectionTableHandler)ctx.getExternalContext().getSessionMap().get(OneBackingBeanToOneTableRow.TABLE_HANDLER_KEY);
		// if (null != handler) {
		// handler.deleteSelectedIndividualRow();
		// AdfFacesContext.getCurrentInstance().addPartialTarget(handler.getTable());
		// }
		// }
		// }
	}

	/**
	 * Method which allows to delete records with confirmation message for one
	 * or many tables
	 * 
	 * @return
	 */
	public String processDeleteConfirmation() {
		String tableType = retrieveTableHandlerName();
		GenericSingleSelectionTableHandler handler = determineTableHandler(tableType);
		if (handler.isARowSelected()) {
			// store the original session scope variables that are used for this
			// backing bean. Because we will overwrite them.
			sessionManager.backupSessionScopeVars();

			FacesUtil.storeOnSession(
					OneBackingBeanToOneTableRow.TABLE_MODE_KEY,
					OneBackingBeanToOneTableRow.TABLE_DELETE_MODE);
			FacesUtil.storeOnSession(
					OneBackingBeanToOneTableRow.TABLE_HANDLER_KEY, handler);
			FacesUtil.storeOnSession(BACKING_BEAN_NAME, this);

			if (logger.isLoggable(Level.FINER)) {
				logger.fine("launchDeleteDialog() for table " + tableType);
			}
			return retrieveCurrentTableAction();
		} else {
			FacesUtil.addFacesErrorMessage("Global.msg.NoRowSelected");
			return null;
		}
	}

	/**
	 * Indicates the user selected 'Yes'
	 * 
	 * @return
	 */
	public String acceptDeleteConfirmation() {
		RequestContext adfContext = RequestContext.getCurrentInstance();
//		returnFromDialog(Constants.YES, null);
		return null;
	}

	/**
	 * Indicates the user selected 'No'
	 * 
	 * @return
	 */
	public String rejectDeleteConfirmation() {
		cleanUpSessionObjects();
//		returnFromDialog(Constants.NO, null);
		return null;
	}

	public void processReturnFromTableEvent(SelectEvent evt) {
		processReturnFromTableEvent(evt, null);
	}


	protected void processReturnFromTableEvent(SelectEvent evt,
			String checkDuplicateColName) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		DataTable table = (DataTable) FacesUtil.findFirstWrapperComponent(
				evt.getComponent(), "CoreTable");
		Object bean = evt.getObject();
		evt.getComponent();

		GenericSingleSelectionTableHandler handler = (GenericSingleSelectionTableHandler) ctx
				.getExternalContext().getSessionMap()
				.get(OneBackingBeanToOneTableRow.TABLE_HANDLER_KEY);

		if (null == handler) {
			if (logger.isLoggable(Level.WARNING))
				logger.warning("Table Handler not in session");
			return;
		}

		int mode = getMode();

		switch (mode) {
		case OneBackingBeanToOneTableRow.TABLE_ADD_MODE:
			if (checkDuplicateColName == null) {
				createNewRow(handler, bean);
			} else {
				createNewRow(handler, bean, checkDuplicateColName);
			}
			break;
		case OneBackingBeanToOneTableRow.TABLE_CREATE_MODE:
			if (checkDuplicateColName == null) {
				createNewRow(handler, bean);
			} else {
				createNewRow(handler, bean, checkDuplicateColName);
			}
			break;

		case OneBackingBeanToOneTableRow.TABLE_EDIT_MODE:
			if (null != handler.getRowToUpdate() && bean != null)
				editSelectedRow(handler.getRowToUpdate(), bean);
			else if (logger.isLoggable(Level.WARNING))
				logger.warning("No row to update or no handler");
			break;

		case OneBackingBeanToOneTableRow.TABLE_DELETE_MODE:
			if (null != table.getSelection()) {
				if (Constants.YES.equals(evt.getObject())) {
					deleteSelectedRow(table.getSelection(), handler);

				}
			}
			break;
		}

		// cleans up all seesion var for this active table
		cleanUpSessionObjects();

		// And we need to add the table as a partial trigger to
		// ourselves since we just changed the items in the list.
		RequestContext adfContext = RequestContext.getCurrentInstance();
//		adfContext.addPartialTarget(table);
	}

	/**
	 * Accesses the updated return data from the table's row which was modified
	 * in another page.
	 * 
	 * @param evt
	 */

	/**
	 * Uses the f:param data via the commandButton to determine the table
	 * selected.Once determined this will be used to find the selected row and
	 * other data specific to that table.
	 * 
	 * @param tableHandlerName
	 *            - accessed via the request parameters
	 * @return a GenericSingleSelectionTableHandler of the table selected
	 */
	public final GenericSingleSelectionTableHandler determineTableHandler(
			String tableHandlerName) {
		String methodName = null;
		GenericSingleSelectionTableHandler tableHandler = null;
		if (tableHandlerName != null && tableHandlerName.length() != 0) {

			char firstCharacter = tableHandlerName.charAt(0);
			String upperCaseChar = String.valueOf(firstCharacter).toUpperCase();
			methodName = upperCaseChar + tableHandlerName.substring(1);
			// find the method using the table handler Name
			tableHandler = (GenericSingleSelectionTableHandler) invokeAttributeOn(
					this, "get".concat(methodName), null, null);
		}

		if (tableHandler == null) {
			// if the table handler cannot be found, may be it is used as a
			// generic table handler. Look at the generic
			// table handler.
			FacesContext ctx = FacesContext.getCurrentInstance();
			String tableHandlerKey = (String) ctx.getExternalContext()
					.getRequestParameterMap().get(TABLE_HANDLER_KEY);
			if (tableHandlerKey == null
					|| (tableHandlerKey != null && tableHandlerKey.equals("")))
				tableHandlerKey = (String) FacesUtil
						.getProcessScope()
						.get(WebConstants.ProcessScopeVariable.MULTI_TABLE_HANDLERS_MAP_KEY);

			if (tableHandlerKey == null) {
				tableHandler = this.tableHandler;
			} else {
				tableHandler = this.tableHandlers.get(tableHandlerKey);
			}

		}
		log.debug("tableHandler [" + tableHandler + "]");
		System.out.println("handler name iji: " + tableHandlerName);
		tableHandler.setHandlerName(tableHandlerName);

		return tableHandler;
	}

	/**
	 * Uses this selected row in this table and the trasient data bean in the
	 * child page.
	 * <p>
	 * This selectedRow represented in the table is expected implement
	 * com.crownagents.trips.declaration.beans.Updateble in order to call the
	 * update method on the interface.
	 * 
	 * @param selectedRow
	 * @param transientDataBean
	 */
	protected void editSelectedRow(Object selectedRow, Object transientDataBean) {
		OneBackingBeanToManyTableUtil.defaultCopyFunction(selectedRow,
				transientDataBean);
		if(!this.getAddDataList().contains(selectedRow))
		{
			this.getAddDataList().add(transientDataBean);
		}
	}

	protected void deleteSelectedRow(Object selectedRow,
			GenericSingleSelectionTableHandler handler) {
		handler.deleteSelectedIndividualRow();
	}

	/**
	 * Uses this handler to create a new row with this transientDataBean
	 * 
	 * @param handler
	 * @param transientDataBean
	 */
	protected void createNewRow(GenericSingleSelectionTableHandler handler,
			Object transientDataBean) {

		if (null != transientDataBean){
			handler.createRow(transientDataBean);
			this.getAddDataList().add(transientDataBean);
		}
			
	}

	/**
	 * Uses this handler to create a new row with this transientDataBean
	 * 
	 * @param handler
	 * @param transientDataBean
	 */
	protected void createNewRow(GenericSingleSelectionTableHandler handler,
			Object transientDataBean, String checkDuplicateColName) {
		System.out.println("createNewRow");
		if (transientDataBean == null) {
			return;
		}
		if (findDuplicateRow(handler, transientDataBean, checkDuplicateColName) != null) {
			FacesUtil.addInfoMessage("Global.errorMessage.RecordExists");
			return;
		} else {
			handler.createRow(transientDataBean);
			this.getAddDataList().add(transientDataBean);
		}
	}

	protected Object findDuplicateRow(
			GenericSingleSelectionTableHandler handler,
			Object transientDataBean, String checkDuplicateColName) {
		Object duplicateRow = null;
		if (null != transientDataBean) {

                    try {
                        Object valToCompare = null;
                        valToCompare = ReflectionHelper.invokeGetter(transientDataBean,
                                checkDuplicateColName);
                        if (valToCompare != null) {
                            int count = handler.getTableModel().size();
                            if (count > 0) {
                                for (int i = 0; i < count; i++) {
                                    Object obj = handler.getTableModel().get(i);
                                    if (obj != null) {
                                        Object o = ReflectionHelper.invokeGetter(obj,
                                                checkDuplicateColName);
                                        if (o != null && valToCompare.equals(o)) {
                                            duplicateRow = obj;
                                            break;
                                            
                                        }
                                        
                                    }
                                }
                            }
                            
                        }
                    } catch (NoSuchMethodException ex) {
                        Logger.getLogger(OneBackingBeanToManyTables.class.getName()).log(Level.SEVERE, null, ex);
                    }

		}
		return duplicateRow;
	}

	/**
	 * @return the mode of the current process i.e ADD_MODE, EDIT_MODE , etc
	 */
	public int getMode() {
		Object mode = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap()
				.get(OneBackingBeanToOneTableRow.TABLE_MODE_KEY);

		if (mode != null) {
			return ((Integer) mode).intValue();
		} else {
			return 0;
		}
	}

	/**
	 * Utility to invoke the getter on the tableHandlerName.
	 * <p>
	 * This will allow for the clazz to manage the correct table
	 * 
	 * @param obj
	 * @param methodName
	 * @param clazzes
	 * @param value
	 */
	private Object invokeAttributeOn(Object obj, String methodName,
			Class[] clazzes, Object[] value) {

		Class[] cArray = clazzes;
		Object[] oArray = value;
		Object returnValue = null;
		try {
			returnValue = obj.getClass().getMethod(methodName, cArray)
					.invoke(obj, oArray);
			return returnValue;
		} catch (NoSuchMethodException e) {
			// if the method cannot be found, this class is not extended by the
			// concrete backing bean, it is used via composition
			// within a concrete backing bean. So if the caller Backing bean is
			// not null, find the value
			// of the attribute within the caller.
			try {
				if (callerBackingBean != null)
					returnValue = callerBackingBean.getClass()
							.getMethod(methodName, cArray)
							.invoke(callerBackingBean, oArray);
			} catch (IllegalAccessException f) {
				e.printStackTrace();
			} catch (InvocationTargetException f) {
				e.printStackTrace();
			} catch (NoSuchMethodException f) {
				e.printStackTrace();
			}
			return returnValue;

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * Get the table handler name from the param tag for the command button
	 * 
	 * @return the table handler name
	 */
	public final String retrieveTableHandlerName() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		// return
		// (String)ctx.getExternalContext().getRequestParameterMap().get(TABLE_HANDLER_NAME);

		if (FacesUtil.getProcessScope().get(TABLE_HANDLER_NAME) != null)
			return FacesUtil.getProcessScope().get(TABLE_HANDLER_NAME)
					.toString();
		else
			return null;

	}

	/**
	 * Get the faces outcome specified for the command button using the f:param
	 * tag
	 * 
	 * @return
	 */
	protected String retrieveCurrentTableAction() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		// return
		// (String)ctx.getExternalContext().getRequestParameterMap().get(TABLE_BUTTON_ACTION);
		return FacesUtil.getProcessScope().get(TABLE_BUTTON_ACTION).toString();
	}

	// Generic table handler which will be used for generic table handlers in
	// regions.
	protected GenericSingleSelectionTableHandler tableHandler;
	protected Map<String, GenericSingleSelectionTableHandler> tableHandlers = new HashMap<String, GenericSingleSelectionTableHandler>();

	public void setTableHandler(GenericSingleSelectionTableHandler tableHandler) {
		this.tableHandler = tableHandler;
	}

	public GenericSingleSelectionTableHandler getTableHandler() {
		if (tableHandlers != null && tableHandlers.size() > 0) {
			Object value = FacesUtil
					.resolveExpression("#{rgFlexibleAttributesTableHandler.tableHandlerKey}");
			if (value == null) {
				return tableHandler;
			} else {
				return tableHandlers.get(value.toString());
			}
			// if (tableHandlers.keySet().iterator().hasNext()){
			// return
			// tableHandlers.get(tableHandlers.keySet().iterator().next());
			// }else{
			// return tableHandlers.get(0);
			// }
		} else {
			return tableHandler;
		}
	}

	public GenericSingleSelectionTableHandler getTableHandler(String key) {
		if (key != null && tableHandlers != null && tableHandlers.size() > 0) {
			return tableHandlers.get(key);
		} else {
			return tableHandler;
		}
	}

	public Map<String, GenericSingleSelectionTableHandler> getTableHandlers() {
		return tableHandlers;
	}

	/**
	 * called before processDelete
	 * */

	public void processDeletePre(ActionEvent evt) {
		String tableName = (String) evt.getComponent().getAttributes()
				.get(TABLE_HANDLER_NAME);
		FacesUtil.getProcessScope().put(TABLE_HANDLER_NAME, tableName);
		String tableButton = (String) evt.getComponent().getAttributes()
				.get(TABLE_BUTTON_ACTION);
		FacesUtil.getProcessScope().put(TABLE_BUTTON_ACTION, tableButton);
	}

	public void discardChanges(ActionEvent event) {
		String val = (String) event.getComponent().getAttributes()
				.get("discardChanges");
		discardChanges = Boolean.valueOf(val);
	}

}
