package com.technobrain.trips.common.messagehelpers;

import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.model.BaseModelObject;


public abstract class ComplexAssociationHelper {
    
    /**
     * Adds the child EJB Pojo to the list of children in parent EJB Pojo.
     * 
     * @param parent the parent EJB Pojo.
     * @param child the child EJB Pojo that will be added
     */
    public abstract void add(BaseModelObject parent, BaseModelObject child);
    
    /**
     * Removes the child EJB Pojo from the list of children in parent EJB Pojo.
     * 
     * @param parent the parent EJB Pojo
     * @param child the child EJB Poho that will be removed
     */
    public abstract void remove(BaseModelObject parent, BaseModelObject child);
    
    /**
     * Returns the class name of the child EJB Pojo. It will be used while creating a new child EJB Pojo.
     * 
     * @return
     */
    public abstract Class getChildPojoClass();
    
    /**
     * It will be overriden by the related association helper whenever we need an info from input type.
     * 
     * @param type
     * @return
     */
    public Class getChildPojoClass(InputType type) {
        return null;
    }
    
    /**
     * Returns the Message Helper class name which will be used for setting the data of the child EJB Pojo.
     * 
     * @return
     */
    public abstract Class getMessageHelperClass();
    
    /**
     * Fills the data of the child EJB Pojo with the information that is gained by the child Input Type object 
     * via using the message helper.
     * 
     * @param messageChild the child Input Type object
     * @param newChildPojo the child EJB Pojo
     * @param messageHelper the Message Helper class which contains the setData method for the child EJB pojo.
     */
    public abstract void setData(InputType messageChild, BaseModelObject newChildPojo, MessageHelper messageHelper);
    
    /**
     * Checks if the primary key of the InputType object is the same with the primary key of the child EJB Pojo.
     * If it is, returns true.
     * 
     * @param messageChild
     * @param pojo
     * @return
     */
    public abstract Boolean compare(InputType messageChild, BaseModelObject pojo);
   
 
}
