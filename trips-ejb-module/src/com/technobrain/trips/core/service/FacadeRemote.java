package com.technobrain.trips.core.service;

import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.model.BaseModelObject;

import java.io.Serializable;

import java.util.List;

import javax.ejb.ObjectNotFoundException;
import javax.ejb.SessionContext;


public interface FacadeRemote {

    /**
     * This method forces the creation of this entity when a class should be
     * used. It will also increase the number of objects created when doing a query
     * Deprecate this properly once we're ready to convert existing code:
     * deprecated use queryFindById(Class entity, Object serializable)
     * @param entity
     * @param o
     * @return
     * @throws ObjectNotFoundException
     */
    Object queryFindById(Object entity, Object o);
    
    Object queryFindByCode(Object entity, Object o) ;
    
    Object queryFindByCode(Class entity, Object o) ;
    
    
    public List queryFindAllByForeignKey(Long foreignKeyValue, String foreignKeyName, Class clazz);
    
    /**
     * Generic method to find an this entity using this serializable
     * @param entity
     * @param serializable
     * @return a entity POJO
     */
    Object queryFindById(Class entity, Object serializable) ;
    
    public <T extends BaseModelObject> T mergeEntity(T entity);

    public <T extends BaseModelObject> T persistEntity(T entity);
    
    public <T extends BaseModelObject> T saveOrUpdate(T entity);
    
    public <T extends BaseModelObject> T saveOrUpdate(T entity, boolean checkForIdZero);
    
    public void flush();
    
    /**
     * for a query with named values i.e :firstname set the coresponding
     * values via this data.
     * @param data
     * @param query
     * @return
     */
    public List findByExample(final Object data, final String query);
    
    public <T extends MessageHelper> T initializeMessageHelper(Class<T> messageHelperClass);

    public <T extends BaseModelObject> T saveOrUpdate(InputType type, Class<T> entityClass, 
                                     Class messageHelperClass);

     public <T extends BaseModelObject> T saveOrUpdate(InputType type, Class<T> entityClass, 
                                      Class messageHelperClass,BaseModelObject[] businessObjects, String primaryIdType);
    
    public <T extends BaseModelObject> T saveOrUpdateHavingCombinedPK(T entity);
    
    public Serializable saveOrUpdate(InputType type);
    
    public InputType getInputTypeWithoutCommonFieldsSetup(Long id, Class entityClass, MessageHelper helper);
    
    public InputType getInputType(Long id, Class entityClass, MessageHelper helper);
    
    public void configureAssociation(InputType type, Class associatedClassName);
    
    public<T extends Serializable> void removeEntity(InputType inputType, Class<T> entityClass);
    
    public InputType findInputType(Class<? extends InputType> typeClassStr, Long id);
    
    public SessionContext getSessionContext();
    
    public void saveBatchAttributes(String tableName, Object id, InputType type);
    
}
