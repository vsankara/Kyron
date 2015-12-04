package com.technobrain.trips.admin.delegate;

/**
 * � Crown Agents 2006
 *
 * This class is used as a delegate for workflow management
 *
 * @since	$Date: 12/15/2009 12:53:09 AM$
 * @version 	$Revision: 12$
 * @author 	$Author: Howard Hill$
 *
 * $Log[1]:
 *  12   TRIPS2 etis.bir.gov.ph1.10.2.0    12/15/2009 12:53:09 AM Howard Hill  
 *         updated as per flexi forms
 * $
 */

import com.technobrain.trips.core.delegate.BusinessDelegate;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.common.helpers.ReflectionHelper;

import java.io.Serializable;


import java.util.Map;



public class
WorkflowDelegate extends BusinessDelegate {
    
    public WorkflowDelegate() {
    }
    
    /**
     * Method returns the confirmation message depending on whether entity is
     * created or updated.
     * @param entity
     * @param mode
     * @return
     */
    public String getFormattedMessage(Serializable entity, String mode) {
        StringBuffer message = new StringBuffer();
        try {
            message.append("Record ");
            if(mode.equalsIgnoreCase("UPDATE")) message.append("updated by "); else message.append(" created by  ");
            message.append(ReflectionHelper.invokeGetter(entity,"createdBy").toString().toUpperCase());
            message.append(" on " + ReflectionHelper.invokeGetter(entity,"createdDate"));
        } catch (NoSuchMethodException e) {
//            FacesUtil.addFacesErrorMessage(e.getMessage());
        }
        return message.toString();
    }

    /**
     * Calls saveOrUpdateHavingCombinedPK method of Workflow bean
     * @param entity
     * @return
     * @throws TripsDuplicateFoundException
     */
//    public BaseModelObject saveOrUpdateRecord(BaseModelObject entity) {
//       return getWorkflowService().saveOrUpdateHavingCombinedPK(entity);
//    }

    /**
     * Invokes a method which returns list of workflow mappings based on the workflow,
     * if it is passed.
     * @param seachFieldsMap
     * @return
     */
//    public List<WfWorkflowMapping> findWorkflowMappingList(Map seachFieldsMap) {
//        List<WfWorkflowMapping> workflowMappingList = getRefCodeAssemblerService().findWorkflowMappingList(seachFieldsMap);
//        return workflowMappingList;
//    }
    
    /**
     * Method is called when workflowManagement page is loaded. It returns the list
     * of WfWorkflow entities for a given workflow
     * @param workflow
     * @return
     */
//    public List<WfWorkflow> findWorkflowList(String workflow) {
//        List<WfWorkflow> workflowList = getRefCodeAssemblerService().findWorkflowList(workflow);
//        return workflowList;
//    }
    
    /**
     * Method is called when workflow list is to filtered by search fields present 
     * in the seachFieldsMap paramter
     * @return
     */

}
