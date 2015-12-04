package com.technobrain.trips.core.service;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.AnnotationHelper;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.helpers.ReflectionHelper;
import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.common.messagehelpers.MessageHelperMapper;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.annotation.Resource;

import javax.ejb.SessionContext;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import org.eclipse.persistence.config.CacheUsage;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
//import oracle.toplink.essentials.config.CacheUsage;
//import oracle.toplink.essentials.config.HintValues;
//import oracle.toplink.essentials.config.TopLinkQueryHints;
//import oracle.toplink.essentials.internal.ejb.cmp3.EntityManagerImpl;


//import com.crownagents.trips.returns.messagehelper.DummyTaxReturnMessageHelper;
//import com.crownagents.trips.returns.model.DummyTaxReturn;


/**
 * TechnoBrain 2006
 *
 * Generic facade bean that all package specific facade beans will inherit from.
 * 
 * Implements standard functionality like generic lookups, default column settings etc.
 *
 * @since	$Date: 1/28/2010 4:06:33 AM$
 * @version 	$Revision: 40$
 * @author 	$Author: Linesh Mali$
 * 
 * $Log[10]:
 *  40   TRIPS2 etis.bir.gov.ph1.30.1.8    1/28/2010 4:06:33 AM   Linesh Mali  
 *         Performance related changes for Flexible form and saveorupdate in
 *       general
 *  39   TRIPS2 etis.bir.gov.ph1.30.1.7    1/5/2010 10:39:40 AM   Kemal Ediz   
 *         Kemal:changed findInputType to resolve the deployment error about
 *       generics
 *  38   TRIPS2 etis.bir.gov.ph1.30.1.6    1/5/2010 10:24:08 AM   Kemal Ediz   
 *         code changes from r & d branch
 *  37   TRIPS2 etis.bir.gov.ph1.30.1.5    12/21/2009 2:20:15 AM  Ken Turner   
 *         Kemal:changed findInputType to resolve the deployment error about
 *       generics
 *  36   TRIPS2 etis.bir.gov.ph1.30.1.4    12/16/2009 3:37:43 AM  Howard Hill  
 *         updated as per flexi
 *  35   TRIPS2 etis.bir.gov.ph1.30.1.3    12/15/2009 12:16:36 AM Howard Hill  
 *         updated as per lastest flexi form
 *  34   TRIPS2 etis.bir.gov.ph1.30.1.2    12/2/2009 10:58:04 PM  Howard Hill  
 *         part 1 of flexi form merge
 *  33   TRIPS2 etis.bir.gov.ph1.30.1.1    12/1/2009 10:39:18 PM  Howard Hill  
 *         Merge from FacadeBean.java, Revision 1.39.1.0 
 *  32   TRIPS2 etis.bir.gov.ph1.30.1.0    8/18/2009 2:44:41 AM   Howard Hill  
 *         update with core changes
 *  31   TRIPS2    1.30        7/14/2009 1:29:14 AM   Howard Hill     removed
 *       the object not found exception
 * $
 */

public class FacadeBean implements FacadeLocal,FacadeRemote {

    @PersistenceContext(unitName = "trips-ejb-module")
    protected EntityManager em;
//    @Resource(name = JndiConstants.DATA_SOURCE_JNDI)
//    protected DataSource ds;
    @Resource 
    protected SessionContext sessionContext;
    
    public static final Logger log = Logger.getLogger(FacadeBean.class);
    public static final String USER_ID_PARAM = "userId";
    
     
    /**
     * Merge the state of the input object back into the persistence context, 
     * performing any default processing as necessary.
     * 
     * @param entity
     * @return
     */
    //@Interceptors({UserAuditInterceptor.class})
    public <T extends BaseModelObject> T mergeEntity(T entity) {
        sendParamsToTransaction();
        return (T)em.merge(entity);
        
    }
    
   
    
    
    public <T extends BaseModelObject> T removeEntity(T entity){
        em.remove(entity);
        return null;
    }
    
    
    private void sendParamsToTransaction() {
        String username = sessionContext.getCallerPrincipal().getName();
        EntityManagerImpl obj = (EntityManagerImpl)em.getDelegate();
        obj.getActiveSession().getActiveUnitOfWork().setProperty(USER_ID_PARAM, username);
    }
    
    //@Interceptors({UserAuditInterceptor.class})
    public Object preAuditEntry(Object entity){
        return entity;
    }
    
    /**
     * Persist the input entity to the DB, setting any default fields on it first
     * 
     * @param entity
     * @return
     */
     
    //@Interceptors({UserAuditInterceptor.class}) 
    public <T extends BaseModelObject> T persistEntity(T entity) {
//        sendParamsToTransaction();
        em.persist((Object)entity);
        return entity;
    }

    /**
     * Finds a entity by whatever field
     * @param entity
     * @param serializable
     * @param field
     * @return
     */
    protected Object queryFindByField(Class entity, Object serializable, 
                                    final String field)  {
        try {
            String entityName = entity.getName();
            entityName = entityName.substring(entityName.lastIndexOf(".") + 1);
            StringBuffer query = new StringBuffer("select object(o) from ");
            query.append(entityName).append(" o where o.").append(field).append(" = ?1");
            Query queryFinal = 
                em.createQuery(query.toString()).setParameter(1, serializable);
            queryFinal.setHint(QueryHints.CACHE_USAGE, 
                               CacheUsage.DoNotCheckCache);
            queryFinal.setHint("refresh", new Boolean(true));

            return queryFinal.getSingleResult();
        } catch (NoResultException e) {
            log.error(e.getLocalizedMessage(), e);
            
        }

        return null;
    }

    /**
     * @see com.crownagents.trips.core.service.FacadeLocal#queryFindById(entity,serializable)
     */
    public Object queryFindById(Class entity, 
                                Object serializable)  {
        Object result = em.find(entity,serializable);
      
        return result;
    }

    /**
     * Queries the inner objects from db by looking at the parent object's id.
     * 
     * @param foreignKeyValue parent object's id
     * @param foreignKeyName parent object's foreign key attribute name
     * @param clazz class of the inner object
     * @return list of inner objects
     */
    public List queryFindAllByForeignKey(Long foreignKeyValue, 
                                         String foreignKeyName, Class clazz) {

        List innerObjects = null;
        try {
            innerObjects = 
                    em.createQuery("select d from " + clazz.getSimpleName() + 
                                   " d where d." + foreignKeyName + 
                                   " = ?1").setHint(QueryHints.REFRESH, 
                                                    HintValues.TRUE).setParameter(1, 
                                                                                  foreignKeyValue).getResultList();


        } catch (javax.persistence.NoResultException e) {
            log.error(e.getLocalizedMessage(), e);
            return innerObjects;
        }

        return innerObjects;
    }

    /**
     * Lookup the input entity type using the input value for the id attribute
     * @see com.crownagents.trips.core.service.FacadeLocal#queryFindById(entity,serializable)
     * @param entity
     * @param id
     * @return
     */
    public Object queryFindById(Object entity, 
                                Object id)  {
        return queryFindById(entity.getClass(), id); 
    }

    /**
     * Lookup the input entity type using the input value for the code attribute
     * 
     * @param entity
     * @param code
     * @return
     */
    public Object queryFindByCode(Object entity, 
                                  Object code)  {
        return queryFindByField(entity.getClass(), code, "code");
    }
    
    /**
     * Lookup the input entity type using the input value for the code attribute
     * 
     * @param entity
     * @param code
     * @return
     */
    public Object queryFindByCode(Class entity, 
                                  Object code)  {
        return queryFindByField(entity, code, "code");
    }

    //    /**
    //     * Wrapper to the call to the underlying recursing setDefaultFields
    //     * 
    //     * @param entity
    //     */
    //    private void setDefaultFields(Object entity) {
    //        setDefaultFields(entity, new LinkedList<Object>());
    //    }
    //
    //    /**
    //     * Set the default DB fields on the input object, and all contained objects
    //     * @param entity
    //     */
    //    private void setDefaultFields(Object entity, List<Object> processedObjs) {
    //        // CA types in these packages will have defaults set
    //        final String TRIPS_PREFIX = "com.crownagents.trips";
    //
    //        // if we've already processed this object, then return so we don't get into an infinite recursion
    //        if (processedObjs.contains(entity))
    //            return;
    //
    //        // Add this object to the list that's been processed, as it's not there
    //        processedObjs.add(entity);
    //
    //        // just quietly bomb out if the input entity's null
    //        if (null == entity)
    //            return;
    //
    //        // Iterate through all of the crownagents objects and set the defaults
    //        Field[] fields = entity.getClass().getDeclaredFields();
    //        for (int i = 0; i < fields.length; i++) {
    //
    //            // Check if this is a TRIPS type to set defaults on
    //            if (fields[i].getType().getName().startsWith(TRIPS_PREFIX)) {
    //                // first do the depth-first search for other objects to set
    //                try {
    //                    setDefaultFields(ReflectionHelper.invokeGetter(entity, 
    //                                                                   fields[i].getName()), 
    //                                     processedObjs);
    //                } catch (NoSuchMethodException e) {
    //                    // TODO (MS) Log properly
    //                    log.error(e.getLocalizedMessage(), e);
    //                }
    //
    //            }
    //            // Then check if it's a list type, containing TRIPS types to set defaults on
    //            else if (fields[i].getType().getName().equals("java.util.List"))
    //                try {
    //                    Object preCastList = 
    //                        ReflectionHelper.invokeGetter(entity, fields[i].getName());
    //                    if (null != preCastList) {
    //                        List currList = (List)preCastList;
    //                        // if the list is not empty, and contains a value in the correct package, process the elements
    //                        if (!currList.isEmpty() && 
    //                            (currList.get(0).getClass().getName().startsWith(TRIPS_PREFIX))) {
    //                            Iterator it = currList.iterator();
    //                            while (it.hasNext()) {
    //                                setDefaultFields(it.next(), processedObjs);
    //                            }
    //                        }
    //                    }
    //                } catch (NoSuchMethodException e) {
    //                    // TODO
    //                    log.error(e.getLocalizedMessage(), e);
    //                }
    //        }
    //
    //        // After recursing into the member objects, set the default fields on this object
    //        try {
    //            // TODO (MS) read the default fields and values to set from config somewhere
    //
    //            ReflectionHelper.setFieldIfNull(entity, "status", "A");
    //            ReflectionHelper.setFieldIfNull(entity, "createdBy", 
    //                                            "TRIPS Default");
    //            ReflectionHelper.setFieldIfNull(entity, "updatedBy", 
    //                                            "TRIPS Default");
    //            ReflectionHelper.setFieldIfNull(entity, "createdDate", 
    //                                            new Timestamp(new GregorianCalendar().getTimeInMillis()));
    //            ReflectionHelper.setFieldIfNull(entity, "updatedDate", 
    //                                            new Timestamp(new GregorianCalendar().getTimeInMillis()));
    //        } catch (NoSuchMethodException e) {
    //            //TODO better logging here
    //            log.error(e.getLocalizedMessage(), e);
    //        }
    //    }

    /**
     * for a query with named values i.e :firstname set the coresponding
     * values via this data. This method also fetches data from Identification tab('identificationNumber').
     * @param data
     * @param query
     * @return
     */
    public List findByExampleWithIdentification(final Object data, 
                                                final String query) {

        Query eql = em.createQuery(query);

        StringTokenizer st = new StringTokenizer(query);
        String param = null;
        Object value = null;
        while (st.hasMoreTokens()) {
            param = st.nextToken(":").split(" ", 0)[0];

//            if (isInIgnoreList(param)) {
//                continue;
//            }
//            try {
//                if (param.equals(Constants.IDENTIFICATION_NUMBER)) {
//                    List<EntIdentification> entIden = 
//                        ((EntIndividual)data).getEntIdentificationList();
//                    if (!entIden.isEmpty() && entIden.size() == 1) {
//                        //I belive Identification number can't be null.
//                        value = entIden.get(0).getIdentificationNumber();
//                    }
//                } else {
//                    value = ReflectionHelper.invokeGetter(data, param);
                }
//            } catch (NoSuchMethodException e) {
//                log.error(e.getLocalizedMessage(), e);
//            }
//            eql.setParameter(param, value);
//        }

//        return eql.getResultList();
        return null;
    }

    /**
     * for a query with named values i.e :firstname set the coresponding
     * values via this data.
     * @param data
     * @param query
     * @return
     */
    public List findByExample(final Object data, final String query) {

        Query eql = em.createQuery(query);

        StringTokenizer st = new StringTokenizer(query);
        String param = null;
        Object value = null;
        while (st.hasMoreTokens()) {
            param = st.nextToken(":").split(" ", 0)[0];

            if (isInIgnoreList(param)) {
                continue;
            }
            try {
                value = ReflectionHelper.invokeGetter(data, param);
            } catch (NoSuchMethodException e) {
                log.error(e.getLocalizedMessage(), e);
            }
            eql.setParameter(param, value);
        }

        return eql.getResultList();
    }
    /**
     * Ignore selected paramters from this parm
     * @param param
     * @return
     */
    private boolean isInIgnoreList(String param) {
        if (param.equalsIgnoreCase("select")) {
            return true;
        }

        return false;
    }

    /**
     * 
     * @param typeOfEntity
     * @param selectFields
     * @param entityBeanName
     * @param comparableFields
     * @return
     * @throws NoSuchMethodException
     */
    protected List findEntityBeanByExample(Object typeOfEntity, 
                                           String selectFields, 
                                           String entityBeanName, 
                                           Map comparableFields) throws NoSuchMethodException {
        StringBuffer queryString = 
            new StringBuffer("select " + selectFields + " from " + 
                             entityBeanName + " obj where ");
        Iterator i = comparableFields.entrySet().iterator();
        //boolean first = false;
        while (i.hasNext()) {
            Map.Entry entry = (Map.Entry)i.next();
            String field = (String)entry.getKey();
            String expression = (String)entry.getValue();

            CharSequence param = ":";
            if (expression.indexOf(String.valueOf(param)) > 0) {
                queryString.append("obj.").append(field).append(" ").append(expression);
                if (i.hasNext())
                    queryString.append(" AND ");
            } else {
                Object value = null;
                value = ReflectionHelper.invokeGetter(typeOfEntity, field);

                if (null != value) {
                    queryString.append("obj.").append(field).append(" ").append(expression);
                    if (i.hasNext())
                        queryString.append(" AND ");
                }
            }
        }

        Query query = em.createQuery(queryString.toString());

        Iterator queryBuildIter = comparableFields.entrySet().iterator();
        while (queryBuildIter.hasNext()) {
            Map.Entry entry = (Map.Entry)queryBuildIter.next();
            String field = (String)entry.getKey();
            String expression = (String)entry.getValue();
            CharSequence param = ":";

            if (!expression.contains(param)) {
                //do nothing
            } else {

                Object value = null;
                CharSequence param1 = ".";
                if (field.contains(param1)) {
                    int indexOfDot = field.indexOf(".");
                    String beforeDot = field.substring(0, indexOfDot);
                    String afterDot = 
                        field.substring(indexOfDot + 1, field.length());
                    Object entityTypeBeforeDot = 
                        ReflectionHelper.invokeGetter(typeOfEntity, beforeDot);
                    value = 
                            ReflectionHelper.invokeGetter(entityTypeBeforeDot, afterDot);
                } else {
                    value = ReflectionHelper.invokeGetter(typeOfEntity, field);
                }
                if (null != value) {
                    query.setParameter(expression.substring(expression.indexOf(":") + 
                                                            1), value);
                }
            }
        }
        return query.getResultList();
    }

    /**
     * Removes an entity using ita input type
     * 
     * @param inputType
     * @param entityClass
     */
    public<T extends Serializable> void removeEntity(InputType inputType, Class<T> entityClass) {
        Object entity = em.find((Class)entityClass, inputType.getId());
        em.remove(entity);
    }

    public <T extends BaseModelObject> T saveOrUpdate(T entity) {
        return saveOrUpdate(entity, 
                            false); // this is done to ensure that the code works for the string primary keys as well
    }
    
    /**
     * Finds the primary key value and execute a query in order to find the entity with that primary key. If the record
     * exists, returns the primary key value, otherwise returns null.
     */
    protected Object getPrimaryKeyValueIfRecordExists(Serializable entity, boolean checkForIdZero) {
        Object value = 
            AnnotationHelper.getValueByAnnotation((Serializable)entity, javax.persistence.Id.class);
        Serializable recordExist = null;
        if (checkForIdZero) {
            if (value != null && Long.parseLong(value.toString()) != 0)
                recordExist = (Serializable)em.find(entity.getClass(), value);
        } else {
            if (value != null)
                recordExist = (Serializable)em.find(entity.getClass(), value);
        }
        if(recordExist != null) {
            return value;
        }
        else {
            return null;
        }
        
    }

    public <T extends BaseModelObject> T saveOrUpdate(T entity, 
                                     boolean checkForIdZero) {        

        if (getPrimaryKeyValueIfRecordExists(entity, checkForIdZero) != null) {
            //Commented as removed entities are not considered part of the current persistence context
            //if(em.contains(entity)){ 
            if (log.isDebugEnabled()) {
                log.debug("Merging record");
            }
            entity = mergeEntity(entity);
        } else {
            if (log.isDebugEnabled()) {
                log.debug("Saving record " + entity.getClass());
            }
            //            setDefaultFields(entity);
            entity = persistEntity(entity);
        }
        return entity;
    }
    

    public <T extends BaseModelObject> T saveOrUpdate(InputType type, Class<T> entityClass, 
                                     Class messageHelperClass) {
        return saveOrUpdate(type, entityClass, messageHelperClass,null);
    }
    
    
    
    
   
    /**
     * Searchs this businessobject for this associationHelper.
     * <p>
     * This allows reuse of an instance of an businessobject
     * @param businessObjectClass
     * @param businessObjects
     * @return
     */
    private BaseModelObject getBusinessObject(Class businessObjectClass,
                                           BaseModelObject[] businessObjects) {
        if(null == businessObjects){
            return null;
        }else{
            for(BaseModelObject mh:businessObjects){
                if(mh.getClass().getName().equals(businessObjectClass.getName())){
                    return mh;
                }
            }

            return null;
        }
    }
    
    /**
     * 
     * @param type The inputtype that will be used for saving/updating.
     * @param entityClass The class of the EJB pojo which will be used for saving/updating.
     * @param messageHelperClass The messagehelper class that will be used to fill the data in the EJB pojo.
     * @return
     */
    public <T extends BaseModelObject> T saveOrUpdate(InputType type, Class<T> entityClass, 
                                     Class messageHelperClass,BaseModelObject[] businessObjects) {
        return saveOrUpdate(type, entityClass, messageHelperClass, businessObjects, null);
    }
    
    public <T extends MessageHelper> T initializeMessageHelper(Class<T> messageHelperClass) {
        MessageHelper helper = null;
        try {
            helper = (MessageHelper)messageHelperClass.newInstance();
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        } catch (InstantiationException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
        helper.setEm(em);
        helper.setFacade(this);
        return (T)helper;
    }
    
    /**
     * 
     * @param type The inputtype that will be used for saving/updating.
     * @param entityClass The class of the EJB pojo which will be used for saving/updating.
     * @param messageHelperClass The messagehelper class that will be used to fill the data in the EJB pojo.
     * @param primaryIdType to indicate the type of primary key .
     * @return
     */
    public <T extends BaseModelObject> T saveOrUpdate(InputType type, Class<T> entityClass, 
                                     Class messageHelperClass, BaseModelObject[] businessObjects, String primaryIdType) {
        
        if(entityClass != null && messageHelperClass != null) {
            BaseModelObject entity = null;
            entity = getBusinessObject(entityClass,businessObjects);
            
            MessageHelper helper = initializeMessageHelper(messageHelperClass);
            
            if (type.getId() != null && type.getId().longValue() != 0) {
                if (primaryIdType != null && primaryIdType.equals(Constants.STRING)){
                    entity = (BaseModelObject)em.find((Class)entityClass, type.getId().toString());
                }else{
                    entity = (BaseModelObject)em.find((Class)entityClass, type.getId());
                }
                helper.setCommonFieldsFromInputTypeToPojo(entity, type);
                entity = helper.setData(entity, type);//helper.callSetDataMethod(entity, type);                
//                AuditUtil.getInstance().userAudit(entity, type);
            } else {
                try {
                    entity = null == entity ?  (BaseModelObject)entityClass.newInstance() : entity;
                } catch (IllegalAccessException e) {
                    log.error(e.getLocalizedMessage(), e);
                    return null;
                } catch (InstantiationException e) {
                    log.error(e.getLocalizedMessage(), e);
                    return null;
                }
                entity = helper.setData(entity, type);

                // AuditUtil.getInstance().userAudit(entity, type);
            }
            
            T obj = saveOrUpdate((T)entity, true);  
            // if the entity is used for batch processing, save the necessary batch attributes.
            if(entity instanceof BaseNormalModelObject) {
                saveBatchAttributes(getTableName(entity), ((BaseNormalModelObject)entity).getId(), type);
            }
            return obj;
        }
        return null;
    }
    
    private String getTableName(Object entity) {
        Table tableAnnotation = entity.getClass().getAnnotation(Table.class);
        if(tableAnnotation == null)
            return null;
        return tableAnnotation.name();
    }

    /**
     * If there is a batch details object which is not null, we assume that this record will be used in batch processing,
       So we need to bind this record to the related batch id so that it can be used in batch processing.
     * @param tableName
     * @param id
     * @param type
     */
    public void saveBatchAttributes(String tableName, Object id, InputType type) {
        // The batch details object within InputType is also used for Batch Details page as well as other entry pages.
        // We should not process if we are coming from Batch Details page. So
        // if we are saving this record from the Batch Details module, it means there is no Dln, because that number is
        // used when we want to save a batch entry.
//        if(type.getBatchDetails() != null && type.getBatchDetails().getDln() != null) {
//            StringBuffer sqlClause = new StringBuffer("");            
//            sqlClause = sqlClause.append("UPDATE ").append(tableName).append(" SET ");
//            sqlClause = sqlClause.append(" BATCH_ID = ").append(type.getBatchDetails().getId());
//            sqlClause = sqlClause.append(", DLN = '").append(type.getBatchDetails().getDln()).append("'");
//            sqlClause = sqlClause.append(" WHERE ID =").append(id);
//            
//            Query query = em.createNativeQuery(sqlClause.toString());
//            query.executeUpdate();
//        }
    }
    
    public Serializable saveOrUpdate(InputType type) {
        MessageHelperMapper mapper = MessageHelper.messageHelpers.get(type.getClass());
        Class<MessageHelper> messageHelperClass = null;
        Class<BaseModelObject> pojoClass = null;
        if(mapper != null) {
            messageHelperClass = mapper.getMessageHelperClass();
            pojoClass = mapper.getPojoClass();
        }
        Serializable model = saveOrUpdate(type, pojoClass, messageHelperClass);
        return model;
    }

    public void flush() {
        em.flush();
    }

    /**
     * This method saves or updates the given entity having combined primary key.
     * As of now this method can be used in updating or saving WfWorkflowMapping
     * and WfWorkflow entities.
     * @param entity
     * @return
     */
    public <T extends BaseModelObject> T saveOrUpdateHavingCombinedPK(T entity) {
        List<Field> fields = 
            AnnotationHelper.getFieldsByAnnotation(entity.getClass(), 
                                                   javax.persistence.Id.class);
        List values = 
            AnnotationHelper.getValuesByAnnotation(entity, javax.persistence.Id.class);
        Serializable recordExist = null;

        if (values != null) {
//            if (entity.getClass().getName().equalsIgnoreCase("com.crownagents.trips.workflow.model.WfWorkflowMapping")) {
//                WfWorkflowMapping workflow = new WfWorkflowMapping();
//                for (int com = 0; com < fields.size(); com++) {
//                    if (fields.get(com).getName().equals("docStatus"))
//                        workflow.setDocStatus((String)values.get(com));
//                    else if (fields.get(com).getName().equals("docRegime"))
//                        workflow.setDocRegime((String)values.get(com));
//                    else if (fields.get(com).getName().equals("action"))
//                        workflow.setAction((String)values.get(com));
//                } 
//                WfWorkflowMappingPK workflowPK = new WfWorkflowMappingPK(workflow.getAction(), workflow.getDocRegime(), workflow.getDocStatus());
//                recordExist = 
//                        (Serializable)em.find(entity.getClass(), workflowPK);
//            } else if (entity.getClass().getName().equalsIgnoreCase("com.crownagents.trips.workflow.model.WfWorkflow")) {
//                WfWorkflow workflow = new WfWorkflow();
//                for (int com = 0; com < fields.size(); com++) {
//                    if (fields.get(com).getName().equals("workflow"))
//                        workflow.setWorkflow((String)values.get(com));
//                    else if (fields.get(com).getName().equals("operation"))
//                        workflow.setOperation((String)values.get(com));
//                    else if (fields.get(com).getName().equals("runOrder"))
//                        workflow.setRunOrder((Long)values.get(com));
//                }
//                WfWorkflowPK workflowPK = new WfWorkflowPK(workflow.getOperation(), workflow.getRunOrder(), workflow.getWorkflow());
//                recordExist = 
//                        (Serializable)em.find(entity.getClass(), workflowPK);
//            }
        }

        if (recordExist != null) {
            entity = mergeEntity(entity);
        } else {
            entity = persistEntity(entity);
        }
        return entity;
    }
    
    /**
     * Method queries a single entity mentioned as entityBeanName paramter using 
     * comparable fields as in the comparableFields Map. The Map contains fields and 
     * values to be compared in a key value pair.
     * Used for searching list entities for given search conditions
     * @param entityBeanName
     * @param comparableFields
     * @return
     * @throws NoSuchMethodException
     */
    protected List searchEntityBeanBySeachParamters(String entityBeanName, 
                                           Map comparableFields) throws NoSuchMethodException {
        StringBuffer queryString = 
            new StringBuffer("SELECT obj FROM " + 
                             entityBeanName + " obj ");
        Iterator i = comparableFields.entrySet().iterator();
        int temp = 1;
        while (i.hasNext()) {
            Map.Entry entry = (Map.Entry)i.next();
            String field = (String)entry.getKey();
            String expression = (String)entry.getValue();
           
            if (expression != null && !expression.equals("")) {
                if(temp == 1) {
                    queryString.append("WHERE ");
                    temp++;
                } else {
                    queryString.append(" AND ");
                }
                queryString.append("obj.").append(field).append(" LIKE '").append(expression).append("'");
            } 
        }
        Query query = em.createQuery(queryString.toString());
        return query.getResultList();
    }

    public InputType getInputTypeWithoutCommonFieldsSetup(Long id, Class entityClass, MessageHelper helper) {
        BaseModelObject pojo = (BaseModelObject)em.find(entityClass,id);
        InputType inputType = helper.getData(pojo);   
        return inputType;
    }
   
    public InputType getInputType(Long id, Class entityClass, MessageHelper helper) {
        BaseModelObject pojo = (BaseModelObject)em.find(entityClass,id);
//        em.refresh(pojo);
        return getInputType(pojo, helper);
    }
    
    public <T extends BaseModelObject> InputType getInputType( T pojo, MessageHelper helper) {
        InputType inputType = helper.getData(pojo);   
        helper.setCommonFieldsDataToInputType(pojo, inputType);
        return inputType;
    }
    
    /**
     * There is a list in InputType object called associated data. This holds the lazly fetched association lists 
     * for the input type object. In this method, we are adding an association list (onetomany, manytomany) to the 
     * associated data of the inputtype object.
     * 
     * @param type
     * @param associatedClassName
     */
    public void configureAssociation(InputType type, Class associatedClassName) {
        
        List<String> associatedData = null;
        associatedData = new ArrayList<String>();
        if(type.getAssociatedData() != null)
            associatedData.addAll(type.getAssociatedData());
        if(!associatedData.contains(associatedClassName.getSimpleName()))
            associatedData.add(associatedClassName.getSimpleName());
        type.getAssociatedData().addAll(associatedData);
        type.setLazyFetch(true);
    }
    
    public InputType findInputType(Class<? extends InputType> typeClassStr, Long id) {
    
        MessageHelperMapper mapper = MessageHelper.messageHelpers.get(typeClassStr);
        Class messageHelperClass = mapper.getMessageHelperClass();
        Class pojoClass = mapper.getPojoClass();
        BaseModelObject model = null;
        MessageHelper helper = null;
        try {
            helper = (MessageHelper)messageHelperClass.newInstance();
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        } catch (InstantiationException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
        InputType type = null;
        
        if(id != null) {
            model = (BaseModelObject)em.find(pojoClass, id);
            type = helper.getData(model);
        }
        else {
            type = (InputType)MessageHelper.init(typeClassStr);
        }
        return type;
    }
    
    public static void main(String[] args) {
        Date d = new Date();
        String s = DateHelper.getDate(d, "dd/MM/yyyy");
//        log.debug(s);    
    
//        List<String> associatedData = null;
//        associatedData = new ArrayList<String>();
//        String[] arr = new String[3];
//        arr[0]="1";
//        arr[1]="1";
//        arr[2]="1";
//        associatedData.addAll(Arrays.asList(arr));
//        associatedData.add("2");
//        log.debug(associatedData);
    }

    public SessionContext getSessionContext() {
        return sessionContext;
    }
    
    /**
     * Is used to determine if the record is new, because in the bpel
     * and zeio is sent for the id to indicate a new record
     * @param inputTypeId
     * @return
     */
    public boolean isNewRecord(Long inputTypeId) {
        if(null == inputTypeId){
            return true;
        }else
            if(inputTypeId.equals(0L)){
                return true;
            }
        
        return false;
    }
}
