package com.technobrain.trips.core.toplinkconfiguration;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.ReflectionHelper;
import com.technobrain.trips.core.annotation.manager.ReferenceNumberGenerator;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.service.FacadeBean;

import java.sql.Timestamp;

import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.eclipse.persistence.descriptors.DescriptorEventAdapter;


public class TripsDescriptorEventListener extends DescriptorEventAdapter {
    public TripsDescriptorEventListener() {
    }
    
    public void aboutToUpdate(DescriptorEvent event) {
        Date sysdate = new Timestamp(new GregorianCalendar().getTimeInMillis());
        updateAttributeWithObject(event, Constants.EntityDefaultValues.UPDATED_DATE, sysdate);
    
        // get the real user id from session.
        String userId = (String)event.getSession().getActiveUnitOfWork().getProperty(FacadeBean.USER_ID_PARAM);
        updateAttributeWithObject(event, Constants.EntityDefaultValues.UPDATED_BY, userId);
        
    }
    /**
     * We should use prepersist method instead of aboutToInsert method because aboutToInsert method is called just before
     * committing the transaction which means that aboutToInsert method is called after exiting from the container
     * managed ejb method. Sometimes we can want to see the changes that we are doing after calling the 
     * em.persist method within the ejb method. 
     * 
     * Prepersist method is called just inside the em.persist method.
     * @param event
     */
    public void prePersist(DescriptorEvent event) {
        ReferenceNumberGenerator.generateNumber(event, false);
    }
    
    public void aboutToInsert(DescriptorEvent event) {
        
        Date sysdate = new Timestamp(new GregorianCalendar().getTimeInMillis());
        updateAttributeWithObject(event, Constants.EntityDefaultValues.UPDATED_DATE, sysdate);
        updateAttributeWithObject(event, Constants.EntityDefaultValues.CREATED_DATE, sysdate);
        updateAttributeWithObject(event, Constants.EntityDefaultValues.STATUS, Constants.RecordStatus.ACTIVE);
        
        // get the real user id from session.
        String userId = (String)event.getSession().getActiveUnitOfWork().getProperty(FacadeBean.USER_ID_PARAM);
        updateAttributeWithObject(event, Constants.EntityDefaultValues.UPDATED_BY, userId);
        updateAttributeWithObject(event, Constants.EntityDefaultValues.CREATED_BY, userId);
        
        ReferenceNumberGenerator.generateNumber(event, true);
    }
    
    private void updateAttributeWithObject(DescriptorEvent event, String fieldName, Object fieldValue)
    {
        try {
            if(null == ReflectionHelper.invokeGetter(event.getObject(), fieldName)){
                event.updateAttributeWithObject(fieldName, fieldValue);
                ReflectionHelper.invokeSetter(event.getObject(), fieldName, fieldValue);
            }
        }
        catch(Exception e) {
            // when there are no fields like that, it will throw an exception but we will not do anything.   
        }
    }
    
//    private void updateAttributeWithObjectByReflection(DescriptorEvent event, String fieldName, Object fieldValue)
//    {
//        try {
//            ReflectionHelper.invokeSetter(event.getObject(), fieldName, fieldValue);
//        }
//        catch(Exception e) {
//            // when there are no fields like that, it will throw an exception but we will not do anything.   
//        }
//    }
}
