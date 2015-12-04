package com.technobrain.trips.assembler.service;

import com.technobrain.trips.assembler.DataReference;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.common.model.FileStore;
import com.technobrain.trips.core.model.BaseRefModelObject;
import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.dto.CodeAndDescription;
import com.technobrain.trips.reference.model.RefEvtTypeCat;
import com.technobrain.trips.reference.model.RefLegalStatusType;
import com.technobrain.trips.reference.model.RefReason;
import com.technobrain.trips.reference.model.RefReturnType;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.Query;

import org.eclipse.persistence.config.CacheUsage;
import org.eclipse.persistence.config.QueryHints;

/**
 * ? Crown Agents 2007
 * <br>
 * Assembles the reference codes needed by the view tier. These mainly consitute
 * CodeAndDescription.
 *
 * @since $Date: 2/16/2010 7:39:56 PM$
 * @version $Revision: 149$
 * @author $Author: Ariel Balita$
 *
 * $Log[1]: 149 TRIPS2 etis.bir.gov.ph1.111.1.36 2/16/2010 7:39:56 PM Ariel
 * Balita added methods for CMS $ $Log[1]: 149 TRIPS2 etis.bir.gov.ph1.111.1.36
 * 2/16/2010 7:39:56 PM Ariel Balita added methods for CMS $
 */
@Stateless(name = "RefCodeAssemblerSessionEJB", mappedName = "RefCodeAssemblerSessionEJB")
public class RefCodeAssemblerSessionEJBBean extends FacadeBean implements RefCodeAssemblerSessionEJBRemote, RefCodeAssemblerSessionEJBLocal {
//    @PersistenceContext(unitName = "trips-ejb-module")
//    private EntityManager em;

    public RefCodeAssemblerSessionEJBBean() {
    }

    /**
     * Gets cleaned up when the user logs out of the system
     */
    public //@Remove
            void disAssemble() {

    }

    public List<BaseRefModelObject> findAllRefPojos(Object code, Class referenceClazz, String descFieldName) {
        List<BaseRefModelObject> result = loadRefPojoList(referenceClazz, descFieldName);
        if (!refModelObjectExist(result, code)) {
            BaseRefModelObject cad = loadRefPojo(referenceClazz, code);
            if (cad != null) {
                result.add(cad);
            }
        }
        return result;
    }

    public List<CodeAndDescription> findAllCodeAndDescription(Object code, Class referenceClazz, String descFieldName) {
        return findAllCodeAndDescription(code, referenceClazz, descFieldName, null);
    }

    public List<CodeAndDescription> findAllCodeAndDescription(Object code, Class referenceClazz, String descFieldName, String condition) {
        String JOIN = null, CODE = null;
        String delimiter = null;
//        CasRefTable refTable = em.find(CasRefTable.class,referenceClazz.getName());
//        if(null != refTable){
//            if(null != refTable.getDisplaySelection() && refTable.getDisplaySelection().equalsIgnoreCase("JOIN")){
//                delimiter = refTable.getDisplayDelimiter();
//                JOIN = "JOIN";
//            }else
//                if(null != refTable.getDisplaySelection() && refTable.getDisplaySelection().equalsIgnoreCase("CODE")){
//                    CODE = "CODE";
//                }
//        }

        List<CodeAndDescription> result = executeGenericDropDownQueryList(referenceClazz, descFieldName, condition);
        if (!codeExist(result, code)) {
            CodeAndDescription cad = executeGenericDropDownQuery(referenceClazz, code, descFieldName);
            if (cad != null) {
                result.add(cad);
            }
        }

        for (CodeAndDescription cd : result) {
            if (JOIN != null) {
                cd.setDescription(cd.getCode() + delimiter + cd.getDescription());
            } else if (CODE != null) {
                cd.setDescription(String.valueOf(cd.getCode()));
            }
        }
        return result;
    }

    public List<CodeAndDescription> findAllMonthsOfYear() {
        List<CodeAndDescription> result = null;

        try {
            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(o.code,o.description) "
                    + " from RefMonthOfYear o where o.status = ?1 ").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
        } catch (Exception nre) {
            log.error(nre.getLocalizedMessage(), nre);
            return null;
        }
        Collections.sort(result, new CodeAndDescriptionOrderByCodeAndNumber());
        return result;
    }

    public class CodeAndDescriptionOrderByCodeAndNumber implements Comparator<CodeAndDescription> {

        public int compare(CodeAndDescription o1, CodeAndDescription o2) {
            return (new Integer(o1.getCode().toString())).compareTo((new Integer(o2.getCode().toString())));
        }
    }

    private final List<CodeAndDescription> executeGenericDropDownNamedQueryList(String namedQuery, Object parameter) {
        List<CodeAndDescription> result = null;
        try {
            result
                    = em.createNamedQuery(namedQuery).setParameter(1, parameter).getResultList();
        } catch (javax.persistence.NoResultException e) {
            return new ArrayList<CodeAndDescription>();
        }
        return result;
    }

    /**
     * The method return a list of valid(Active) code and description for
     * dropdowns. The description is based on the parameter fieldName.
     *
     * @param entity
     * @return List of code and description
     */
    private final List<BaseRefModelObject> loadRefPojoList(Class entity, String fieldName) {
        try {
            int lastIndexOf = entity.getName().lastIndexOf(".");
            String entityName = entity.getName().substring(lastIndexOf + 1);
            List<BaseRefModelObject> result
                    = em.createQuery("select obj " + "from " + entityName
                            + " obj "
                            + "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) "
                            + "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj."
                            + fieldName + " asc").setParameter(1,
                            Constants.RecordStatus.ACTIVE).setHint(QueryHints.CACHE_USAGE,
                            CacheUsage.CheckCacheThenDatabase).getResultList();
            return result;
        } catch (javax.persistence.NoResultException e) {
            return new ArrayList<BaseRefModelObject>();
        }
    }

    private List<CodeAndDescription> executeGenericDropDownQueryList(Class entity,
            String fieldName) {

        return executeGenericDropDownQueryList(entity, fieldName, null);
    }

    /**
     * The method return a list of valid(Active) code and description for
     * dropdowns. The description is based on the parameter fieldName.
     *
     * @param entity
     * @return List of code and description
     */
    private List<CodeAndDescription> executeGenericDropDownQueryList(Class entity,
            String fieldName, String condition) {
        try {
            int lastIndexOf = entity.getName().lastIndexOf(".");
            String entityName = entity.getName().substring(lastIndexOf + 1);
            List<CodeAndDescription> result = new ArrayList<CodeAndDescription>();;

            Query query
                    = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.code,obj." + fieldName
                            + ") from " + entityName + " obj "
                            + "where " + (condition == null ? "" : condition + " and ")
                            + " (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) "
                            + "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj." + fieldName
                            + " asc")
                    // .setHint(TopLinkQueryHints.CACHE_USAGE,CacheUsage.CheckCacheThenDatabase);
                    .setHint(QueryHints.CACHE_USAGE, CacheUsage.NoCache);

            int i = 1;
            List aList = query.getResultList();

            log.debug("executeGenericDropDownQueryList size [" + aList.size() + "]");

            CodeAndDescription tmpCode = null;
            for (int j = 0, len = aList.size(); j < len; j++) {
                tmpCode
                        = new CodeAndDescription(((CodeAndDescription) aList.get(j)).getCode(),
                                ((CodeAndDescription) aList.get(j)).getDescription());
                result.add(tmpCode);
            }

//            if(null != condition){
//                result =
//                    em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj." +
//                                   fieldName + ") " + "from " + entityName +
//                                   " obj " +
//                                   "where " + condition + " AND " +
//                                   "obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                                   "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.orderSeq , obj." +
//                                   fieldName + " asc").setParameter(1,
//                                                                    Constants.RecordStatus.ACTIVE).setHint(QueryHints.CACHE_USAGE,
//                                                                                                           CacheUsage.CheckCacheThenDatabase).getResultList();
//            }else{
//              result =
//                em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj." +
//                               fieldName + ") " + "from " + entityName +
//                               " obj " +
//                               "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                               "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.orderSeq , obj." +
//                               fieldName + " asc").setParameter(1,
//                                                                Constants.RecordStatus.ACTIVE).setHint(QueryHints.CACHE_USAGE,
//                                                                                                       CacheUsage.CheckCacheThenDatabase).getResultList();
//            }
            return result;
        } catch (javax.persistence.NoResultException e) {
            return new ArrayList<CodeAndDescription>();
        }
    }

    private final CodeAndDescription executeGenericDropDownQuery(Class entity,
            Object code) {
        try {
            return executeGenericDropDownQuery(entity, code, null);
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    /**
     * The method return a code and description pair which was active and made
     * inactive now and this record is still required at edit and view mode.
     *
     * @param entity
     * @return List of code and description
     */
    private final BaseRefModelObject loadRefPojo(Class entity, Object code) {
        try {
            int lastIndexOf = entity.getName().lastIndexOf(".");
            String entityName = entity.getName().substring(lastIndexOf + 1);
            if (code != null) {
                BaseRefModelObject result
                        = (BaseRefModelObject) em.createQuery("select obj "
                                + "from " + entityName
                                + " obj "
                                + "where obj.code = ?1").setParameter(1,
                                ((BaseRefModelObject) code).getCode()).setHint(QueryHints.CACHE_USAGE,
                                CacheUsage.CheckCacheThenDatabase).getSingleResult();
                return result;
            }
        } catch (javax.persistence.NoResultException e) {
            return null;
        }

        return null;
    }

    /**
     * The method return a code and description pair which was active and made
     * inactive now and this record is still required at edit and view mode.
     *
     * @param entity
     * @return List of code and description
     */
    private final CodeAndDescription executeGenericDropDownQuery(Class entity,
            Object code,
            String fieldName) {
        try {
            int lastIndexOf = entity.getName().lastIndexOf(".");
            String entityName = entity.getName().substring(lastIndexOf + 1);
            if (fieldName == null) {
                fieldName = "description";
            }
            if (code != null) {
                CodeAndDescription result
                        = (CodeAndDescription) em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.code,obj."
                                + fieldName + ")"
                                + "from " + entityName
                                + " obj "
                                + "where obj.code = ?1 order by obj."
                                + fieldName
                                + " asc").setParameter(1,
                                code).setHint(QueryHints.CACHE_USAGE,
                                CacheUsage.CheckCacheThenDatabase).getSingleResult();
                return result;
            }
        } catch (javax.persistence.NoResultException e) {
            return null;
        }

        return null;
    }

    private boolean codeExist(List<CodeAndDescription> activeResult,
            Object code) {
        if (code == null) {
            return true;
        }
        boolean found = false;
        for (int i = 0; i < activeResult.size(); i++) {
            found = (activeResult.get(i)).getCode().equals(code);
            if (found == true) {
                break;
            }
        }
        return found;
    }

    private boolean refModelObjectExist(List<BaseRefModelObject> activeResult,
            Object code) {
        if (code == null) {
            return true;
        }
        boolean found = false;
        for (int i = 0; i < activeResult.size(); i++) {
            found = (activeResult.get(i)).getCode().equals(code);
            if (found == true) {
                break;
            }
        }
        return found;
    }

//    public List<CodeAndDescription> findWarehouseId(Object code) {
//        // TODO (MS) find where the warehouses are stored now
//        List<CodeAndDescription> result =
//            null; // = executeGenericDropDownQueryList(RefWarehouse.class);
//        //        if(!codeExist(result,code) ){
//        //            CodeAndDescription cad = executeGenericDropDownQuery(RefWarehouse.class,code);
//        //            if(cad != null){
//        //                result.add(cad);
//        //            }
//        //        }
//        return result;
//    }
//
//    public List<CodeAndDescription> findAllTransportModes(Object code) {
//        List<CodeAndDescription> result = findAll(code, DataReference.CUST_TRAN_MODE);
//        
//        ArrayList<CodeAndDescription> displayOrder = 
//            new ArrayList<CodeAndDescription>(result.size());
//        /*
//         * Link related mode via tree look
//         */
//        for(CodeAndDescription cd:result){
//           
//            RefCustTranMode transMode = em.find(RefCustTranMode.class,cd.getCode());
//            
//            if(null != transMode.getType()){
//              
//                    String desc = cd.getDescription();
//                   // desc = .concat(desc);
//                    cd.setDescription(desc);                
//            }
//            displayOrder.add(cd);
//        }
//        return displayOrder;
//    }
//
//    public List<CodeAndDescription> findAllReasons(Object code,
//                                                   String filter) {
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefReason obj " +
//                           "where obj.status = ?1 and obj.category.code = ?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.description Asc").setParameter(1,
//                                                                                                                     Constants.RecordStatus.ACTIVE).setParameter(2,
//                                                                                                                                                         filter).getResultList();
//
//        if (!codeExist(result, code)) {
//            CodeAndDescription cad =
//                executeGenericDropDownQuery(RefReason.class, code);
//            if (cad != null) {
//                result.add(cad);
//            }
//        }
//        
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllDeactivateReasons(Object code,
//                                                   String filter) {
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefReason obj " +
//                           "where obj.status = ?1 and obj.category.code = ?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1,
//                                                                                    Constants.RecordStatus.ACTIVE).setParameter(2,
//                                                                                     filter).getResultList();
//    
//        return result;
//    }
//    /**
//     * This method will give us list of business sectors in the form of code and description.
//     * Here description is the combination of code and description.
//     * @param code
//     * @return
//     */
//    public List<CodeAndDescription> findAllBusinessSectors(Object code) {
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefBusinessSector obj " +
//                           "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.code ").setParameter(1,
//                                                                                                                     Constants.RecordStatus.ACTIVE).getResultList();
//                                                                                                                                                                 
//        if (!codeExist(result, code)) {
//            CodeAndDescription cad =
//                executeGenericDropDownQuery(RefBusinessSector.class, code);
//            if (cad != null) {
//                result.add(cad);
//            }
//        }
//        return result;
//    }
    public List<CodeAndDescription> findAllTransactionTypes(Object code,
            String filter) {

        List<CodeAndDescription> result
                = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.code,obj.description) "
                        + "from RefTransactionType obj "
                        + "where obj.status = ?1 and obj.refTransactionTypeCategory.code = ?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) "
                        + "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1,
                        Constants.RecordStatus.ACTIVE).setParameter(2,
                        filter).getResultList();

//        if (!codeExist(result, code)) {
//            
//            CodeAndDescription cad =
//                executeGenericDropDownQuery(RefTransactionType.class, code);
//            if (cad != null) {
//                result.add(cad);
//            }
//        }
        return result;
    }

//    public List<CodeAndDescription> findAllExemptionTypes(Object code, 
//                                                          String dType) {
//        List<CodeAndDescription> codeAndDesc = null;
//        try {
//            List<RefExemptionType> result = 
//                em.createNativeQuery("SELECT DISTINCT ret.code,ret.description FROM ECR ecr,  EXEM_TAX_TYPE et, REF_EXEMPTION_TYPE ret,REF_REV_TYPE rrt " + 
//                " WHERE ecr.id           =et.ecr_id " + 
//                " AND ecr.exemption_type =ret.code " + 
//                " AND rrt.code           = et.tax_type " + 
//                " AND rrt.status         =?1 " + 
//                " AND (rrt.taxpayer_type =?2 OR rrt.taxpayer_type =?3) " + 
//                " AND (ret.EXPIRY_DATE is NULL or ret.EXPIRY_DATE >= CURRENT_TIMESTAMP) and ret.status=?1 and (ret.EFFECTIVE_DATE is NULL or ret.EFFECTIVE_DATE <= CURRENT_TIMESTAMP)",RefExemptionType.class).setParameter(1, 
//                                                                                                  Constants.ACTIVE).setParameter(2, 
//                                                                                                  dType).setParameter(3, 
//                                                                                                                      Constants.BOTH).getResultList();
//            if (result != null && result.size() > 0) {
//                codeAndDesc = 
//                        new ArrayList<CodeAndDescription>(result.size() + 1);
//                for (RefExemptionType exCode: result) {
//                    CodeAndDescription obj = 
//                        new CodeAndDescription(exCode.getCode(), 
//                                               exCode.getDescription());
//                    codeAndDesc.add(obj);
//                }
//            }
//            return codeAndDesc;
//        } catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//            return null;
//        }
//    }
//
//    public List<CodeAndDescription> findAllBanks(Object code, String filter) {
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(ent.id,ent.entityName) " +
//                           "from EntEntity ent " +
//                           "where ent.status = ?1 and ent.entityType = ?2 ").setParameter(1,
//                                                                                          Constants.RecordStatus.ACTIVE).setParameter(2,
//                                                                                                                                      filter).getResultList();
//        if (!codeExist(result, code)) {
//            CodeAndDescription cad =
//                (CodeAndDescription)em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(ent.id,ent.entityName) " +
//                                                   "from EntEntity ent " +
//                                                   "where ent.entityType = ?1 and ent.id = ?2 ").setParameter(1,
//                                                                                                              filter).setParameter(2,
//                                                                                                                                   code).getSingleResult();
//            if (cad != null) {
//                result.add(cad);
//            }
//        }
//        return result;
//    }
    public String findTransactionTypeDescByID(Long transactionID) {
        try {
            //            Long transType =
            //                (Long)em.createQuery("select t.transactionType from RevledTransaction t where t.id = ?1").setParameter(1,
            //                                                                                                                       transactionID).getSingleResult();
            //            String tranTypeDesc =
            //                (String)em.createQuery("select t.description from RefTransactionType t where t.id = ?1").setParameter(1,
            //                                                                                                                      transType).getSingleResult();
            // Converted to single query.                                                                                                                      
            String tranTypeDesc
                    = (String) em.createQuery("select distinct rtt.description from RevledTransaction rt, RefTransactionType rtt "
                            + " where rt.transactionType = rtt.code and rt.id = ?1").setParameter(1, transactionID).getSingleResult();

            return tranTypeDesc;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public String findSystemParameter(String code) {
        try {
            String value
                    = (String) em.createQuery("select s.value from SystemParameters s where s.code = ?1").setParameter(1,
                    code).getSingleResult();
            return value;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public String findConfParameter(String code) {
        try {
            String value
                    = (String) em.createQuery("select s.value from ConfParameters s where s.code = ?1").setParameter(1,
                    code).getSingleResult();
            return value;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public String findCommodityCategory(String comCode) {
        try {
            String value
                    = (String) em.createQuery("select cc.refComCategory.code from RefComCodeCategory cc where cc.comCode = ?1").setParameter(1,
                    comCode).getSingleResult();
            return value;
        } catch (javax.persistence.NoResultException e) {
            return "null";

        }
    }
//TODO - RevAccCleanup
//    public List<CodeAndDescription> findAllRegimeAccountByTin(String tin,
//                                                              String regType) {
//        try {
//            Long entEntity =
//                (Long)em.createQuery("select ra.entEntity from RevAcc ra where ra.acctNo = ?1 and ra.dType = 'ENTACC' ").setParameter(1,
//                                                                                                                                      tin).getSingleResult();
//            List<CodeAndDescription> result =
//                em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.id,obj.acctNo) " +
//                               "from RevAcc obj join obj.revType rrt " +
//                               "where obj.status = ?1 and obj.entEntity = ?2 and rrt.code = ?3 and obj.dType <> 'ENTACC' ").setParameter(1,
//                                                                                                                                         Constants.RecordStatus.ACTIVE).setParameter(2,
//                                                                                                                                                                                     entEntity).setParameter(3,
//                                                                                                                                                                                                             regType).getResultList();
//            return result;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//TODO - RevAccCleanup
//    public List<CodeAndDescription> findAllRegimeAccountByTinAndRegimeType(String tin,
//                                                                           String regType) {
//        try {
//            Long entEntity =
//                (Long)em.createQuery("select ra.entEntity from RevAcc ra where ra.acctNo = ?1 and ra.dType = 'ENTACC' ").setParameter(1,
//                                                                                                                                      tin).getSingleResult();
//            
//            List<CodeAndDescription> result =
//                            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.acctNo,obj.acctNo) " +
//                                           "from RevAcc obj join obj.revType rrt " +
//                                           "where obj.status = ?1 and obj.entEntity = ?2 and rrt.code = ?3 and obj.dType <> 'ENTACC' ").
//                                           setParameter(1, Constants.RecordStatus.ACTIVE).
//                                           setParameter(2, entEntity).
//                                           setParameter(3, regType).getResultList();
//            
//            return result;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
    //TODO - RevledRevPeriod/RevledTransactionCleanup
//    public List<CodeAndDescription> findAllPeriodByRegAcc(Long acctId) {
//        //        Long revAccID = (Long)em.createQuery("select ra.id from RevAcc ra where ra.acctNo = ?1")
//        //            .setParameter(1,acctNo).getSingleResult();
//        List<CodeAndDescription> result = null;
//        List row =
//            em.createQuery("select rrp.id,rrp.periodNo,rrp.periodYear,rrp.periodLabel " +
//                           "from RevledRevPeriod rrp " +
//                           "where rrp.status = ?1 and rrp.revAcc = ?2 order by rrp.periodYear asc")
//                           .setParameter(1,Constants.RecordStatus.ACTIVE)
//                           .setParameter(2,acctId)
//                           .getResultList();
//
//        return wrapPeriodValues(row,true);
//        
//    }

    //TODO - RevledRevPeriod/RevledTransactionCleanup
//    public List<CodeAndDescription> findAllNonFiledPeriodByRegAcc(Long acctId) {
//            
//        List<CodeAndDescription> l = findAllPeriodByRegAccFilterByStatus(acctId, RevledRevPeriod.nonFilePeriods);   
//        return l;
//    }
    //TODO - RevledRevPeriod/RevledTransactionCleanup
//    public List<CodeAndDescription> findAllFiledPeriodByRegAcc(Long acctId) {
//            
//        List<CodeAndDescription> l = findAllPeriodByRegAccFilterByStatus(acctId, RevledRevPeriod.filePeriods);   
//        return l;
//    }
    //TODO - RevledRevPeriod/RevledTransactionCleanup
//    public List<CodeAndDescription> findAllPeriodByRegAccFilterByStatus(Long acctId, String [] statusFilterStatus){
//        
//        List<CodeAndDescription> row = new ArrayList<CodeAndDescription>();
//        
//        try {
//            String valueForINClause = StringHelper.getSQLInClauseString(statusFilterStatus);
//            
//            valueForINClause = "(" + valueForINClause + ")";
//            
//            Query query = em.createQuery("select rrp.id,rrp.periodNo,rrp.periodYear,rrp.periodLabel " +
//                               "from RevledRevPeriod rrp " +
//                               "where rrp.status = ?1 and rrp.revAcc = ?2" +
//                               " and rrp.periodstatus in " + valueForINClause +
//                               " order by rrp.periodYear asc ")
//                               .setParameter(1,Constants.RecordStatus.ACTIVE)
//                               .setParameter(2,acctId);
//            row = query.getResultList();
//            
//            return wrapPeriodValues(row,true);
//        }
//        catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        
//        return row;
//        
//    }
    private List<CodeAndDescription> wrapPeriodValues(List periodRow, boolean descAsCode) {

        List<CodeAndDescription> result = new ArrayList<CodeAndDescription>(periodRow.size());

        for (int i = 0; i < periodRow.size(); i++) {

            Object[] columns = (Object[]) periodRow.get(i);

            /*
             * Changed to use Period lable for the second if where column length is 2 
             * need to investigate HH
             */
            if (columns.length == 3) {
                String desc = columns[1] + "/" + columns[2];
                String codedDesc = columns[1] + "/" + columns[2];
                Long periodId = (Long) columns[0];
                CodeAndDescription codeAndDescription = null;
                if (descAsCode) {
                    codeAndDescription = new CodeAndDescription(codedDesc, desc);
                } else {
                    codeAndDescription = new CodeAndDescription(periodId, desc);
                }
                codeAndDescription.setAuxillaryId(periodId);
                result.add(codeAndDescription);
            } else {
                if (columns.length == 4) {
                    String desc = columns[2] + " " + columns[3];
                    String codedDesc = columns[1] + "/" + columns[2];
                    Long periodId = (Long) columns[0];
                    CodeAndDescription codeAndDescription = null;
                    if (descAsCode) {
                        codeAndDescription = new CodeAndDescription(codedDesc, desc);
                    } else {
                        codeAndDescription = new CodeAndDescription(periodId, desc);
                    }
                    codeAndDescription.setAuxillaryId(periodId);
                    result.add(codeAndDescription);
                } else if (columns.length == 2) {
                    String desc = columns[0] + "/" + columns[1];
                    CodeAndDescription codeAndDescription = new CodeAndDescription(desc, desc);
                    result.add(codeAndDescription);
                }
            }
        }

        return result;
    }

//TODO - RevAccCleanup
//    public List<CodeAndDescription> findAllPeriodByRegimeTypeAndAcctNo(String acctNo,
//                                                                       String regimeType) {
//        try {
//            Long revAccID =
//                (Long)em.createQuery("select ra.id from RevAcc ra where ra.acctNo = ?1 and ra.revType.code =?2").setParameter(1,
//                                                                                                                              acctNo).setParameter(2,
//                                                                                                                                                   regimeType).getSingleResult();
//            List<CodeAndDescription> result = null;
//            List row =
//                em.createQuery("select rrp.id,rrp.periodNo,rrp.periodYear,rrp.periodLabel " +
//                               "from RevledRevPeriod rrp " +
//                               "where rrp.status = ?1 and rrp.revAcc = ?2 order by rrp.periodYear asc ").setParameter(1,
//                                                                                          Constants.RecordStatus.ACTIVE).setParameter(2,
//                                                                                                                                      revAccID).getResultList();
//            return wrapPeriodValues(row,true);
//            
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
    //TODO - RevAccCleanup
//    public List<CodeAndDescription> findAllPeriodByRegimeTypeAndAcctNo(String acctNo,
//                                                                       String regimeType,
//                                                                       boolean descAsCode) {
//        try {
//            Long revAccID =
//                (Long)em.createQuery("select ra.id from RevAcc ra where ra.acctNo = ?1 and ra.revType.code =?2").setParameter(1,
//                                                                                                                              acctNo).setParameter(2,
//                                                                                                                                                   regimeType).getSingleResult();
//            List<CodeAndDescription> result = null;
//            List row =
//                em.createQuery("select rrp.id,rrp.periodNo,rrp.periodYear,rrp.periodLabel " +
//                               "from RevledRevPeriod rrp " +
//                               "where rrp.status = ?1 and rrp.revAcc = ?2 order by rrp.periodYear asc,rrp.periodNo asc ").setParameter(1,
//                                                                                          Constants.RecordStatus.ACTIVE).setParameter(2,
//                                                                                                                                      revAccID).getResultList();
//            return wrapPeriodValues(row,descAsCode);
//            
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
    public String findPeriod(Long periodID) {
        try {
            Object[] row
                    = (Object[]) em.createQuery("select rrp.periodNo,rrp.periodYear "
                            + "from AccountPeriod rrp "
                            + "where rrp.status = ?1 and rrp.id = ?2 ").setParameter(1,
                            Constants.RecordStatus.ACTIVE).setParameter(2,
                            periodID).getSingleResult();
            String desc = row[0] + "/" + row[1];
            return desc;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }
//TODO - RevledRevPeriod/RevledTransactionCleanup
//    public String findPeriodLabel(Long periodID){
//        try {
//            String row =
//                (String)em.createQuery("select rrp.periodLabel " +
//                                         "from RevledRevPeriod rrp " +
//                                         "where rrp.status = ?1 and rrp.id = ?2 ").setParameter(1,
//                                                                                                Constants.RecordStatus.ACTIVE).setParameter(2,
//                                                                                                                                            periodID).getSingleResult();
//            
//            return row;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }

    public String findDeclarationByCustRef(String referenceNumber) {

        try {
            String value
                    = (String) em.createQuery("select cd.customsReference from DdecCargoDeclaration cd where cd.customsReference = ?1").setParameter(1,
                    referenceNumber).getSingleResult();
            return value;
        } catch (javax.persistence.NoResultException e) {
            return "null";

        }
    }
//TODO - RevAccCleanup
//    public List<CodeAndDescription> findAllPeriodByRegimeAndEntity(String regimeType,
//                                                                   Long entEntityId,
//                                                                   boolean useDescAsCode) {
//        if (null == regimeType || null == entEntityId) {
//            return new ArrayList<CodeAndDescription>();
//        } else {
//            try {
//                List data =
//                    em.createQuery("select ra.id from RevAcc ra where ra.revType.code = ?1 and ra.entEntity = ?2 and ra.accStatus=?3").setParameter(1,
//                                                                                                                                                    regimeType).setParameter(2,
//                                                                                                                                                                             entEntityId).setParameter(3,
//                                                                                                                                                                                                       Constants.Regimes.REGISTER).getResultList();
//                if (data == null || data.isEmpty()) {
//                    return new ArrayList<CodeAndDescription>();
//                } else {
//                    Long revAccID = (Long)data.get(0);
//                    List<CodeAndDescription> result = null;
//                    List row =
//                        em.createQuery("select rrp.id, rrp.periodNo,rrp.periodYear  " +
//                                       "from RevledRevPeriod rrp " +
//                                       "where rrp.status = ?1 and rrp.revAcc = ?2 order by rrp.periodYear, rrp.periodNo asc").setParameter(1,
//                                                                                                  Constants.RecordStatus.ACTIVE).setParameter(2,
//                                                                                                                                              revAccID).getResultList();
//                    result = new ArrayList(row.size());
//                    for (int i = 0; i < row.size(); i++) {
//                        Object[] columns = (Object[])row.get(i);
//                        String desc = columns[1] + "/" + columns[2];
//                        Long code = (Long)columns[0];
//                        if (useDescAsCode) {
//                            result.add(new CodeAndDescription(desc, desc));
//                        } else {
//                            //use the period id
//                            result.add(new CodeAndDescription(code, desc));
//                        }
//
//                    }
//                    return result;
//                }
//            } catch (javax.persistence.NoResultException e) {
//                return null;
//            }
//        }
//    }

//    public List<CodeAndDescription> findAllPeriodByRegime(String regimeType) {
//        List row =
//            em.createQuery("select rrp.taxPeriod,rrp.taxYear " + "from RevPeriodPool rrp " +
//                           "where rrp.revenueType = ?1 ").setParameter(1,
//                                                                       regimeType).getResultList();
//        return wrapPeriodValues(row,true);
//    }
//
//    public List<CodeAndDescription> findAllPeriodByPeriodFrom(Long accId,
//                                                              Long periodId,
//                                                              boolean isDescAsCode) {
//        try {
//            List<CodeAndDescription> result = null;
//            Integer month = null;
//            Integer year = null;
//            AccountPeriod period = null;
//            
//                period =
//                        (AccountPeriod)queryFindById(AccountPeriod.class,
//                                                       periodId);
//          
//            if (period != null) {
//                month = period.getPeriodNo();
//                year = period.getPeriodYear();
//            }
//            List row =
//                em.createQuery("select rrp.id,rrp.periodNo,rrp.periodYear " +
//                               "from AccountPeriod rrp " +
//                               "where rrp.accAccountId = ?1 and " +
//                               "rrp.periodYear >= ?2 and " +
//                               "(rrp.periodYear > ?2 or (rrp.periodYear = ?2 and rrp.periodNo >= ?3)) ")
//                               .setParameter(1,accId)
//                               .setParameter(2,year)
//                               .setParameter(3,month)
//                               .getResultList();
//                               
//            result = new ArrayList(row.size());
//            for (int i = 0; i < row.size(); i++) {
//                Object[] columns = (Object[])row.get(i);
//                Long code = (Long)columns[0];
//                String desc = columns[1] + "/" + columns[2];
//                if (isDescAsCode)
//                    result.add(new CodeAndDescription(desc, desc));
//                else
//                    result.add(new CodeAndDescription(code, desc));
//            }
//            return result;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//
//    public List<CodeAndDescription> findAllPeriodStart(Object code) {
//        return null;
//    }
    /**
     * It returns all the revenue account type registered for a taxpayer if
     * acctStatus is null, otherwise a list of revenue account type with the
     * status passed.
     *
     * @param entityID
     * @param acctStatus
     * @return
     */
    //TODO - RevAccCleanup     
//    public List<CodeAndDescription> findAllRevenueTypeByEntityIdAndAcctStatus(Long entityID,String acctStatus) {
//            try {
//                if(acctStatus == null){
//                    List<CodeAndDescription> result =
//                        em.createQuery("select distinct new com.crownagents.trips.dto.CodeAndDescription(r.revType.code,r.revType.description) " +
//                                       "from RevAcc r " +
//                                       "where r.entEntity = ?1 ").setParameter(1,
//                                                                               entityID).getResultList();
//                    return result;
//                }else{
//                    List<CodeAndDescription> result =
//                              em.createQuery("select distinct new com.crownagents.trips.dto.CodeAndDescription(r.revType.code,r.revType.description) " +
//                                           "from RevAcc r where r.entEntity = ?1 and r.accStatus = ?2 ")
//                                           .setParameter(1, entityID)
//                                           .setParameter(2,acctStatus)
//                                           .getResultList();
//                    return result;
//                }
//            } catch (javax.persistence.NoResultException e) {
//                return null;
//            }
//        }
    public List<CodeAndDescription> findAllRevenueTypeByTin(String tin) {
        try {
            List<CodeAndDescription> result
                    = em.createQuery("select distinct new com.technobrain.trips.dto.CodeAndDescription(r.revenueType, r.revenueDescription) "
                            + "from RegTaxpayerStatusView r "
                            + "where r.tin = ?1 and r.registrationType='REVENUE' and r.displayStatus='Active'").setParameter(1, tin).getResultList();
            return result;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public List<CodeAndDescription> findAllRevenueTypeWithReturnsByTin(String tin) {
        try {
            List<CodeAndDescription> result
                    = em.createQuery("select distinct new com.technobrain.trips.dto.CodeAndDescription(r.revenueType, r.revenueDescription) "
                            + "from RegTaxpayerStatusView r "
                            + "where r.tin = ?1 and r.registrationType='REVENUE' and r.noReturnIndicator='F' and r.displayStatus='Active'").setParameter(1, tin).getResultList();
            return result;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    /**
     * This query shall return all registered tax type for a taxpayer, including
     * the default taxpayer account on the boolean value set.
     *
     * @param entityID
     * @param isWithTaxpayer
     * @return
     */
//TODO - RevAccCleanup     
//    public List<CodeAndDescription> findAllRevenueTypeByEntityIdAndAcctStatus(Long entityID, boolean isWithTaxpayer) {
//            try {
//                if(isWithTaxpayer){
//                    List<CodeAndDescription> result =
//                        em.createQuery("select distinct new com.crownagents.trips.dto.CodeAndDescription(r.revType.code,r.revType.description) " +
//                                       "fro1m RevAcc r " +
//                                       "where r.entEntity = ?1 and r.accStatus = 'REG' ").setParameter(1,
//                                                                               entityID).getResultList();
//                    return result;
//                }else{
//                    List<CodeAndDescription> result =
//                               em.createQuery("select distinct new com.crownagents.trips.dto.CodeAndDescription(r.revType.code,r.revType.description) " +
//                                            "from RevAcc r where r.entEntity = ?1 and r.revType.code <> ?2 and ( r.accStatus = ?3 or r.accStatus = ?4 ) ")
//                                            .setParameter(1, entityID)
//                                            .setParameter(2,"TAXPAYER")
//                                            .setParameter(3,Constants.Regimes.REGISTER)
//                                            .setParameter(4,Constants.Regimes.SUSPEND)
//                                            .getResultList();
//                    return result;
//                }
//            } catch (javax.persistence.NoResultException e) {
//                return null;
//            }
//        }
//
    //TODO - RevAccCleanup        
//    public List<CodeAndDescription> findRevenueIDByEntityID(Long entityID) {
//        try {
//            List<CodeAndDescription> result =
//                em.createQuery("select distinct new com.crownagents.trips.dto.CodeAndDescription(r.revType.id,r.revType.description) " +
//                               "from RevAcc r " +
//                               "where r.entEntity = ?1 ").setParameter(1,
//                                                                       entityID).getResultList();
//            return result;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
// public List<CodeAndDescription> findAllOperandList(Object code, 
//                                                          String operandCat) {
//        try {
//            List<CodeAndDescription> result = 
//                em.createQuery("SELECT new com.crownagents.trips.dto.CodeAndDescription(ref.code,ref.description) FROM RefOperandType ref " +
//                " WHERE ref.status =?1 " + 
//                " AND ref.operandCategory =?2 AND (ref.expiryDate is NULL or ref.expiryDate >= CURRENT_TIMESTAMP) and (ref.effectiveDate is NULL or ref.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, 
//                                                                                                  Constants.ACTIVE).setParameter(2, 
//                                                                                                  operandCat).getResultList();
//            if (!codeExist(result, code)) {
//            
//            CodeAndDescription cad =
//            executeGenericDropDownQuery(RefOperandType.class, code);
//            if (cad != null) {
//            result.add(cad);
//            }
//            }
//            
//            return result;
//        } catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//            return null;
//        }
//    }
//    public List<CodeAndDescription> findAllRefTables() {
//        try {
//            List<CodeAndDescription> result =
//                em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(r.entityClassName,r.description) " +
//                               "from CasRefTable r where r.refType = 'BASIC' order by r.description asc").getResultList();
//            return result;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    // Gets the List of Table for Ref Table Manager
//    public List<CodeAndDescription> findAllRefTablesToManage() {
//        try {
//            List<CodeAndDescription> result =
//                em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(r.entityClassName,r.description) " +
//                               "from CasRefTable r where r.refType = 'BASIC' and r.enableToManage = 'Y' order by r.description asc").getResultList();
//            return result;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    
    public List<CodeAndDescription> findAllReturnTypes(Object code) {

        List<CodeAndDescription> result
                = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.code,obj.description) "
                        + "from RefReturnType obj "
                        + "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) "
                        + "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1,
                        Constants.RecordStatus.ACTIVE).getResultList();

        if (!codeExist(result, code)) {

            CodeAndDescription cad
                    = executeGenericDropDownQuery(RefReturnType.class, code);
            if (cad != null) {
                result.add(cad);
            }
        }

        return result;
    }

    public List<CodeAndDescription> findRegReturnTypesByRevenueType(Long entityId, String revenueType) {
        List<CodeAndDescription> result = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.code,obj.description) "
                + "from RefReturnType obj, RegRevenueReturns rrr, RegTaxpayerRevenue rtr, RegTaxpayerEntity rte "
                + "where rtr.id=rrr.regRevenueId.id and rte.id=rtr.id and obj.code=rrr.returnType and rte.registrationStatus='REG' "
                + "and  rte.entId= ?1 and  rtr.revenueType= ?2 and obj.status = ?3 ")
                .setParameter(1, entityId).setParameter(2, revenueType).setParameter(3, Constants.RecordStatus.ACTIVE).getResultList();

        return result;
    }

    public List<CodeAndDescription> findAllExemptionCodes(String exemptionType, Object code) {
        try {
            List<CodeAndDescription> result
                    = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.code,obj.code) "
                            + "from Ecr obj "
                            + "where  obj.ecrStatus = ?1 and obj.exemptionType = ?2 and obj.usageType=?3 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) "
                            + "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).setParameter(2, exemptionType).setParameter(3, Constants.ExemptionTypeCodes.EXE_USAGE_TYPE_TS).getResultList();
            return result;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public List<CodeAndDescription> findExemptionTaxtypesByExemptionId(Long id) {
        try {
            List<CodeAndDescription> result
                    = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.code,obj.description) "
                            + "from ExemTaxType et, RefRevType obj  "
                            + "where et.ecr.id = ?1 and et.taxType=obj.code and obj.status = ?2 ").setParameter(2, Constants.RecordStatus.ACTIVE).setParameter(1, id).getResultList();
            return result;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public List findRefData(String entityBean, String code,
            String description) {
        try {
            int lastIndexOf = entityBean.lastIndexOf(".");
            String entityName = entityBean.substring(lastIndexOf + 1);
            List result = null;
            if (code == null || code.trim().equalsIgnoreCase("")) {
                code = null;
            }
            if (description == null
                    || description.trim().equalsIgnoreCase("")) {
                description = null;
            }
            if (code == null && description == null) {
                result
                        = em.createQuery("select r " + "from " + entityName + " r ").getResultList();
            } else if (code == null && description != null) {
                result
                        = em.createQuery("select r " + "from " + entityName + " r where r.description like ?1 ").setParameter(1,
                        description).getResultList();
            } else if (code != null && description == null) {
                result
                        = em.createQuery("select r " + "from " + entityName + " r where r.code like ?1 ").setParameter(1,
                        code).getResultList();
            } else {
                result
                        = em.createQuery("select r " + "from " + entityName + " r where r.code like ?1 and r.description like ?2 ").setParameter(1,
                        code).setParameter(2,
                                description).getResultList();
            }
            return result;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    /**
     * This metod gets list of elements based on the listType passed
     *
     * @param listType
     * @return
     */
    public List<CodeAndDescription> findAllListItemsByListType(String listType) {
        try {

            List<CodeAndDescription> result = null;
            List row
                    = em.createQuery("select obj.elementId, obj.elementName  "
                            + " FROM StaticList obj"
                            + " WHERE obj.listType = ?1 AND obj.status = 'A' "
                            + " AND obj.effectiveDate <= CURRENT_TIMESTAMP AND CURRENT_TIMESTAMP < obj.expiryDate ORDER BY obj.displayOrder ").setParameter(1,
                            listType).getResultList();
            result = new ArrayList(row.size());
            for (int i = 0; i < row.size(); i++) {
                Object[] columns = (Object[]) row.get(i);
                String elementId = (String) columns[0];
                String elementName = (String) columns[1];
                result.add(new CodeAndDescription(elementId, elementName));
            }
            return result;

        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public List<CodeAndDescription> findAllOperandList(String listType) {
        try {

            List<CodeAndDescription> result = null;
            List row
                    = em.createQuery("select obj.elementId, obj.elementName  "
                            + " FROM StaticList obj"
                            + " WHERE obj.listType = ?1 AND obj.status = 'A' "
                            + " AND obj.effectiveDate <= CURRENT_TIMESTAMP AND CURRENT_TIMESTAMP < obj.expiryDate ORDER BY obj.displayOrder ").setParameter(1,
                            listType).getResultList();
            result = new ArrayList(row.size());
            for (int i = 0; i < row.size(); i++) {
                Object[] columns = (Object[]) row.get(i);
                String elementId = (String) columns[0];
                String elementName = (String) columns[1];
                result.add(new CodeAndDescription(elementId, elementName));
            }
            return result;

        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

//    public List<CodeAndDescription> findAllSectionList(String msgTypeName) {
//        // first get the MsgType
//        try{
//            MsgType msgType = (MsgType)em.createNamedQuery("MsgType.queryFindByCode").setParameter(1, msgTypeName).getSingleResult();
//            if (msgType == null) return null;
//            // check if the msgType is Flexible Form if so load all the flexible form fields in the list
//             List<CodeAndDescription> l = null;
//            if(msgType.getIsFlexibleForm() != null && msgType.getIsFlexibleForm().equals(Constants.TRUE)){
//                // get details of the form being used... load all the defined sections
//                return findAllRiskAllowedSectionsInFlexibleForm(msgTypeName);
//            }else{
//                l = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.id, obj.description) FROM MsgSection obj" +
//                       " WHERE obj.msgType=?1 ORDER BY obj.description").setParameter(1, msgTypeName).getResultList();
//                List<CodeAndDescription> result = new ArrayList<CodeAndDescription>();
//                for (CodeAndDescription cd : l) {
//                    result.add(new CodeAndDescription(String.valueOf(cd.getCode()), cd.getDescription()));
//                }                       
//                       
//                return result;
//            }        
//        }catch(Exception ex){
//            log.error(ex.getLocalizedMessage(), ex);
//        }
//        return null;
//    }
//    /**
//     * The method list all message sections based on the message type
//     * @param msgType
//     * @return
//     */
//    public List<CodeAndDescription> findAllSectionList(String msgType) {
//        List<CodeAndDescription> result = null;
//        try {
//            result =
//                em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.id, obj.description) FROM MsgSection obj" +
//                               " WHERE obj.msgType=?1 ORDER BY obj.description").setParameter(1,
//                                                                                              msgType).getResultList();
//            return result;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    public List<CodeAndDescription> findAllSectionListByCode(Object code) {
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.id, obj.description) FROM MsgSection obj").getResultList();
//        if (!codeExist(result, code)) {
//            CodeAndDescription cad =
//                executeGenericDropDownQuery(MsgSection.class, code);
//            if (cad != null) {
//                result.add(cad);
//            }
//        }
//        return result;
//    }
//
//    public List<CodeAndDescription> findAllFieldListByCode(Object code) {
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.id, obj.description) FROM MsgField obj").getResultList();
//        //            if(!codeExist(result,code) ){
//        //                CodeAndDescription cad = executeGenericDropDownQuery(MsgField.class, code);
//        //                if(cad != null){
//        //                    result.add(cad);
//        //                }
//        //            }
//        return result;
//    }
    /**
     * The method list all message fields based on the section
     *
     * @param section
     * @return
     */
    public List<CodeAndDescription> findAllFieldList(Long section) {
        List<CodeAndDescription> result = null;
        try {

            List row = null;
            if (section != null) {
                row = em.createQuery("select obj.id, obj.description  " + " FROM MsgField obj"
                        + " WHERE obj.section=?1 ORDER BY obj.description")
                        .setParameter(1, section).getResultList();
            } else {
                row = em.createQuery("select obj.id, obj.description  " + " FROM MsgField obj"
                        + " ORDER BY obj.description").getResultList();
            }
            result = new ArrayList(row.size());
            for (int i = 0; i < row.size(); i++) {
                Object[] columns = (Object[]) row.get(i);
                Long elementId = (Long) columns[0];
                String elementName = (String) columns[1];
                result.add(new CodeAndDescription(String.valueOf(elementId), elementName));
            }
            return result;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

//    public List<CodeAndDescription> findAllPortsInCountry(String countryCode) {
//        List<CodeAndDescription> result = null;
//        try {
//            result =
//                    em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code, obj.description)" +
//                                   " FROM RefPort obj WHERE obj.countryCode=?1 ORDER BY obj.description").setParameter(1,
//                                                                                                                       countryCode).getResultList();
//            return result;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//
//    public List<CodeAndDescription> findAllVesselTypeList() {
//        List<CodeAndDescription> result = null;
//        try {
//            result =
//                    em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code, obj.description)" +
//                                   " FROM RefVesselType obj ORDER BY obj.description").getResultList();
//            return result;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//
//    public Double findInterestRate() {
//        try {
//            Double rate =
//                (Double)em.createQuery("select rir.rate from RefInterestRate rir where rir.status = ?1 and rir.expiryDate >= CURRENT_TIMESTAMP " +
//                                       " and rir.effectiveDate <= CURRENT_TIMESTAMP").setParameter(1,
//                                                                                                   Constants.RecordStatus.ACTIVE).getSingleResult();
//            return rate;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//
//    /**
//     * This method returns list of all workflow mapping from WfWorkflowMapping entity.
//     * @param workflow
//     * @param status
//     * @param regime
//     * @param action
//     * @return
//     */
//    public List<WfWorkflowMapping> findWorkflowMappingList(String workflow, String status,
//                                        String regime, String action) {
//        List<WfWorkflowMapping> workflowMappingList = null;
//        try {
//            workflowMappingList =
//                    em.createQuery("select work from WfWorkflowMapping work ").getResultList();
//            return workflowMappingList;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//
    public Long saveToFileStore(FileStore fst) {
        FileStore fstReturn = saveOrUpdate(fst);
        if (fstReturn != null) {
            return fstReturn.getId();
        } else {
            return null;
        }
    }

    public FileStore getFileFromStore(Long id) {
        FileStore fStore = new FileStore();
        return (FileStore) queryFindById(fStore.getClass(), id);

    }

//    /**
//     * Method is called when workflow mapping list is filtered by search fields
//     * contained in the input Map.
//     * @param seachFieldsMap
//     * @return
//     */
//    public List<WfWorkflowMapping> findWorkflowMappingList(Map seachFieldsMap) {
//
//        List<WfWorkflowMapping> workflowMappingList = null;
//        try {
//            workflowMappingList = searchEntityBeanBySeachParamters("WfWorkflowMapping", seachFieldsMap);
//
//
//        } catch (javax.persistence.NoResultException e) {
//            log.error(e.getLocalizedMessage(), e);
//        } catch (NoSuchMethodException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        return workflowMappingList;
//    }
//    
//    /**
//     * Method is called when customs tax type list is filtered by search fields
//     * contained in the input Map.
//     * @param seachFieldsMap
//     * @return
//     */
//    public List<RefCustTaxType> findRefCustTaxTypeList(Map seachFieldsMap) {
//        
//        List<RefCustTaxType> refCustTaxTypeList = null;
//        try {
//            refCustTaxTypeList = searchEntityBeanBySeachParamters("RefCustTaxType", seachFieldsMap);
//        }
//        catch (javax.persistence.NoResultException e) {
//                    log.error(e.getLocalizedMessage(), e);
//                } catch (NoSuchMethodException e) {
//                    log.error(e.getLocalizedMessage(), e);
//                }
//                return refCustTaxTypeList;
//    }
    /**
     * Method returns list of WfWorkflow entities for a given workflow
     *
     * @param workflow
     * @return
     */
//    public List<WfWorkflow> findWorkflowList(String workflow) {
//        List<WfWorkflow> workflowList = null;
//        try {
//            workflowList =
//                    em.createQuery("select work from WfWorkflow work  where work.workflow=?1 order by work.runOrder asc").setParameter(1,
//                                                                                                            workflow).getResultList();
//        } catch (javax.persistence.NoResultException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        return workflowList;
//    }
//
//    /**
//     * Method is called when workflow list is filtered by search fields contained
//     * in the input Map.
//     * @param seachFieldsMap
//     * @return
//     */
//    public List<WfWorkflow> findWorkflowListAfterSearch(Map seachFieldsMap) {
//        List<WfWorkflow> workflowList = null;
//        try {
//            workflowList = searchEntityBeanBySeachParamters("WfWorkflow", seachFieldsMap);
//        } catch (javax.persistence.NoResultException e) {
//            log.error(e.getLocalizedMessage(), e);
//        } catch (NoSuchMethodException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        return workflowList;
//    }
//    public ProductInputType getProductInputType(Long productId){
//        ProductInputType productInputType = null;
//
//        RefProducts refProduct =
//            em.getReference(RefProducts.class, productId);
//        em.refresh(refProduct);
//        if(refProduct != null){
//            ProductMessageHelper pMH = new ProductMessageHelper();
//            productInputType = (ProductInputType)pMH.getData(refProduct);
//        }
//        return productInputType;
//    }
//
//    public Long saveProduct(ProductInputType productInputType){
//        RefProducts refProduct = saveOrUpdate(productInputType, RefProducts.class, ProductMessageHelper.class);
//        if (refProduct !=  null){
//            return refProduct.getId();
//        }else{
//            return null;
//        }
//    }
//
//    public List<RefCustTaxBand> findRefCustTaxCalcList(String code) {
//        List<RefCustTaxBand> refCustTaxCalcList = null;
//        Query qryTaxCalcList = null;
//        try {
//            qryTaxCalcList = em.createQuery("select o from RefCustTaxBand o " +
//                                                  "where o.refCustTaxType.code = ?1").setParameter(1,code);
//            refCustTaxCalcList = qryTaxCalcList.getResultList();                                                  
//        }  catch (javax.persistence.NoResultException e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        return refCustTaxCalcList;
//    }  
//        
//    public String findLocationInCountry(Long locationId) {
//        return em.find(RefLocationByCountry.class,locationId).getDescription();
//    }
//    
//    public List<CodeAndDescription> findAllMeasurementUnitsByMeasurement(String code) {
//        if(code == null)
//            return null;
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefMeasurementUnits obj " +
//                           "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) " +
//                           "and obj.measurement = '" + code + "' order by obj.description Asc").setParameter(
//                            1, Constants.RecordStatus.ACTIVE).setHint(TopLinkQueryHints.CACHE_USAGE,
//                            CacheUsage.CheckCacheThenDatabase).getResultList();
//        return result;
//    }
//    
//    public List<CodeAndDescription> findProductTypeOnCommodityCode(String code) {
//         if(code == null)
//             return null;
//         List<CodeAndDescription> result =
//             em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                            "from RefProductType obj " +
//                            "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) " +
//                            "and obj.commodityCode = '" + code + "' order by obj.description Asc").setParameter(
//                             1, Constants.RecordStatus.ACTIVE).setHint(TopLinkQueryHints.CACHE_USAGE,
//                             CacheUsage.CheckCacheThenDatabase).getResultList();
//    
//         return result;
//     }
//     
    public List<CodeAndDescription> findCurrencyByCode(String code) {
        if (code == null) {
            return null;
        }
        List<CodeAndDescription> result
                = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.code,obj.description) "
                        + "from RefCurrency obj "
                        + "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) "
                        + "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) "
                        + "and obj.code = '" + code + "' order by obj.description Asc").setParameter(
                        1, Constants.RecordStatus.ACTIVE).setHint(QueryHints.CACHE_USAGE,
                        CacheUsage.CheckCacheThenDatabase).getResultList();

        return result;
    }

//    public List<CodeAndDescription> findAllMeasurementUnitsByFormType(String formType) {
//        if(formType == null)
//            return null;
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefMeasurementUnits obj " +
//                           "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) " +
//                           "and obj.formType = '" + formType + "' order by obj.description Asc").setParameter(
//                            1, Constants.RecordStatus.ACTIVE).setHint(TopLinkQueryHints.CACHE_USAGE,
//                            CacheUsage.CheckCacheThenDatabase).getResultList();
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllMeasurementUnitsByMineralFormType() {
//          List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefMeasurementUnits obj " +
//                           "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) " +
//                           "and obj.formType is not NULL  order by obj.description Asc").setParameter(
//                            1, Constants.RecordStatus.ACTIVE).setHint(TopLinkQueryHints.CACHE_USAGE,
//                            CacheUsage.CheckCacheThenDatabase).getResultList();
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllFreeZone() {
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,loc.description) " +
//                           "from FzFreeZone obj, RefLocationByCountry loc " +
//                           "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) " +
//                           "and loc.id = obj.locationCode").getResultList();
//        return result;
//    }
//    
//    public List<RefCustomsProcCode> findAllCustomsProcCode() {
//            try {
//                return em.createNamedQuery("RefCustomsProcCode.findAll").getResultList();
//        } catch (javax.persistence.NoResultException e) {
//                return null;
//        }
//    }
//    public List<CodeAndDescription> findAllGender(Object code) {
//        if (genderList == null) {
//            genderList = new ArrayList<CodeAndDescription>();
//            genderList.add(new CodeAndDescription("1", Constants.MALE));
//            genderList.add(new CodeAndDescription("2", Constants.FEMALE));
//        }
//        return genderList;
//    }
    public List<CodeAndDescription> findAllPeriodTypes(Object code) {
        return Collections.emptyList();
    }

    /**
     * Finds the reference codes for this dataSetType
     *
     * @param code
     * @param dataSetType
     * @return
     */
    public List<CodeAndDescription> findAll(Object code,
            DataReference dataSetType) {
        return findAllCodeAndDescription(code, dataSetType.getDataType(), dataSetType.getDescriptionFieldName(), dataSetType.getCondition());
    }

//    public List<CodeAndDescription> findAllPreciseCategoryByMainCategory(Object code, 
//                                            DataReference dataSetType) {
//        return findAllCodeAndDescription(code, dataSetType.getDataType(), dataSetType.getDescriptionFieldName(), dataSetType.getCondition() );
//    }
//    
//    public List<CodeAndDescription> findAllApplicationTypeByIndicator(String indicatorType) {
//        if(indicatorType == null)
//            return null;
//        return executeGenericDropDownNamedQueryList("RefApplicationType.findAllApplicationTypeByIndicator", indicatorType);
//    }
//    
//    public List<CodeAndDescription> findAllDocTypeByCategory(String docType, 
//                                                              String category) {
//         try {
//              return em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) from RefDocType obj " +
//              "where obj.refDocCategory.code =?1").
//              setParameter(1,category).getResultList();
//          } catch (javax.persistence.NoResultException e) {
//              return null;
//          }
//     }  
//    
//    public List<CodeAndDescription> findAllProductNameById(Object productId) {
//            List<CodeAndDescription> result = null;
//            try {
//                result =
//                        em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.id, obj.commonName)" +
//                                       " FROM RefProducts obj WHERE obj.id=?1 ORDER BY obj.commonName").setParameter(1,
//                                                                                                                           productId).getResultList();
//                return result;
//            } catch (javax.persistence.NoResultException e) {
//                return null;
//            }
//    }
//    
//    public List<CodeAndDescription> findAllSensitiveProductNameByComCode(Object comCode) {
//        List<CodeAndDescription> result = null;
//        try {
//            result =
//                    em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.id, obj.commonName)" +
//                                   " FROM RefProducts obj WHERE obj.commodityCode=?1 and obj.sensitive='Y' ORDER BY obj.commonName").setParameter(1,
//                                                                                                                       comCode).getResultList();
//            return result;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
    public List<CodeAndDescription> findAllSuspendedProductNameByComCode(Object comCode) {
        List<CodeAndDescription> result = null;
        try {
            result
                    = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.id, obj.commonName)"
                            + " FROM RefProducts obj WHERE obj.commodityCode=?1 and obj.discontinued='Y' ORDER BY obj.commonName").setParameter(1,
                            comCode).getResultList();
            return result;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public List<CodeAndDescription> findAllProductNameByComCode(Object comCode) {
        List<CodeAndDescription> result = null;
        try {
            result
                    = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.id, obj.commonName)"
                            + " FROM RefProducts obj WHERE obj.commodityCode=?1 ORDER BY obj.commonName").setParameter(1,
                            comCode).getResultList();
            return result;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public List<CodeAndDescription> findAllOfficesForUser(Object code,
            String userID) {

        List<CodeAndDescription> result = null;
        try {

            result
                    = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.code, obj.description)"
                            + " FROM RefOffice obj join obj.officerUsers ou WHERE UPPER(ou.username) = ?1"
                            + " AND ou.status =?2"
                            + " ORDER BY obj.description")
                    .setParameter(1, userID.toUpperCase())
                    .setParameter(2, Constants.RecordStatus.ACTIVE)
                    .getResultList();
            return result;
        } catch (javax.persistence.NoResultException e) {
            result = new ArrayList<CodeAndDescription>();
            result.add(new CodeAndDescription("NONE", "NONE"));
            return result;
        }

    }

    public List<CodeAndDescription> findOfficesByOfficeType(Object code,
            String officeType) {

        List<CodeAndDescription> result = null;
        try {
            result
                    = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.code, obj.description)"
                            + " FROM RefOffice obj WHERE obj.officeType=?1 ORDER BY obj.description").setParameter(1,
                            officeType).getResultList();
            return result;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public List<CodeAndDescription> findAllTaxRateTablePeriod(Object code) {

        List<CodeAndDescription> result
                = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.id,obj.taxType) "
                        + "from TaxRateTable obj "
                        + "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) "
                        + "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.taxType Asc").setParameter(1,
                        Constants.RecordStatus.ACTIVE).setHint(QueryHints.CACHE_USAGE,
                        CacheUsage.CheckCacheThenDatabase).getResultList();
        return result;

    }

    public List<CodeAndDescription> findAllTaxBand(Object code) {
        return null;
    }

//    public RefBusinessSector findBusinessSector(String businessSectorCode) {
//        RefBusinessSector result = null;
//        try {
//            result = 
//                (RefBusinessSector)em.createNamedQuery("RefBusinessSector.findByCode").setParameter(1,businessSectorCode).getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//        return result;
//    }
//
//    public RefOffice findOfficeDetails(String officeCode) {
//        RefOffice result = null;
//        try {
//            result = 
//                (RefOffice)em.createNamedQuery("RefOffice.findOfficeByCode").setParameter(1,officeCode).getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//        
////        if(result!=null){
////           List<RefOffStaff> officeStaff = findOfficeStaffByOffice(officeCode);
////           result.setOfficerUsers(officeStaff);
////        }
////        
//        return result;
//    }
//    public RefOffice findOfficeDetails1(String officeCode) {
//        RefOffice result = null;
//        try {
//            result = 
//                (RefOffice)em.createNamedQuery("RefOffice.findOfficeByCode1").setParameter(1,officeCode).getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//        return result;
//    }
//    
    public String findRefDescription(String code, DataReference dataReference) {
        if (code == null || code.equals("")) {
            return null;
        }
        try {
            String value
                    = (String) em.createQuery("select cc." + dataReference.getDescriptionFieldName() + " from "
                            + dataReference.getDataType().getSimpleName() + " cc where cc.code = ?1").setParameter(1,
                            code).getSingleResult();
            return value;

        } catch (javax.persistence.NoResultException e) {
            return "null";

        }
    }

//    public List<CodeAndDescription> findAllApplicationRoleByRoleType(String roleType) {
//        return executeGenericDropDownNamedQueryList("RefApplicationRole.findAllApplicationRoleByRoleType", roleType);
//    }
//    
//    public List<CodeAndDescription> findAllAppAttachmentTypesByAppType(String appType, Object code) {
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) from RefAppAttType obj " +
//                           "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and obj.appType = ?2 " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.description asc").
//                            setParameter(1,Constants.RecordStatus.ACTIVE).
//                            setParameter(2,appType).
//                            setHint(TopLinkQueryHints.CACHE_USAGE,CacheUsage.CheckCacheThenDatabase).getResultList();        
//        if (!codeExist(result, code)) {
//            CodeAndDescription cad =
//                executeGenericDropDownQuery(RefAppAttType.class, code);
//            if (cad != null) {
//                result.add(cad);
//            }
//        }
//        return result;
//    }
//
//    public List<CodeAndDescription> findAllRevenueTypeByLegalStatus(Object code,
//                                                    String legalStatus) {
//       try{
//            List<CodeAndDescription> result =
//                        em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(refRev.code,refRev.description) " +
//                            "from RefRevType refRev,RefLegalTaxTypeRel revLegalRel " + 
//                            "where refRev.code=revLegalRel.refRevType.code " + 
//                            "and refRev.status = ?1 " + 
//                            "and revLegalRel.status = ?2 " +
//                            "and revLegalRel.refLegalStatus.code = ?3 " + 
//                            "and (revLegalRel.expiryDate is NULL or revLegalRel.expiryDate >= CURRENT_TIMESTAMP) " +
//                            "and (revLegalRel.effectiveDate is NULL or revLegalRel.effectiveDate <= CURRENT_TIMESTAMP) " +
//                            "and (refRev.expiryDate is NULL or refRev.expiryDate >= CURRENT_TIMESTAMP) " + 
//                            "and (refRev.effectiveDate is NULL or refRev.effectiveDate <= CURRENT_TIMESTAMP) ")
//                            .setParameter(1,Constants.RecordStatus.ACTIVE)
//                            .setParameter(2,Constants.RecordStatus.ACTIVE)
//                            .setParameter(3,legalStatus)
//                            .getResultList();
//    
//            if (!codeExist(result, code)) {
//                CodeAndDescription cad = (CodeAndDescription)em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(refRev.code,refRev.description) " +
//                                "from RefRevType refRev,RefLegalTaxTypeRel revLegalRel " +
//                                "where refRev.code=revLegalRel.refRevType.code " +
//                                "and refRev.code = ?1 " +
//                                "and revLegalRel.refLegalStatus.code = ?2 " )
//                                .setParameter(1,code)
//                                .setParameter(2,legalStatus)
//                                .getSingleResult();
//                if (cad != null) {
//                    result.add(cad);
//                }
//            }
//           Collections.sort(result, new CodeAndDescriptionOrderDesc());
//           return result;
//       }catch (javax.persistence.NoResultException e) {
//            return null;
//       }
//    }
    public List<CodeAndDescription> findAllRevenueTypeByTaxPayerType(String taxpayerType,
            Object code) {

        try {
            List<CodeAndDescription> result
                    = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(refRev.code,refRev.description) from RefRevType refRev where refRev.status= ?1 "
                            + "and (refRev.expiryDate is NULL or refRev.expiryDate >= CURRENT_TIMESTAMP) and "
                            + "(refRev.effectiveDate is NULL or refRev.effectiveDate <= CURRENT_TIMESTAMP) and "
                            + "(refRev.taxpayerType = ?2  or refRev.taxpayerType = 'Both')  and refRev.implicitRegime = 'N'  order by refRev.description ").setParameter(1,
                            Constants.RecordStatus.ACTIVE).setParameter(2,
                            taxpayerType).getResultList();

//            if (!codeExist(result, code)) {
//                CodeAndDescription cad = 
//                    executeGenericDropDownQuery(RefRevType.class, code);
//                if (cad != null) {
//                    result.add(cad);
//                }
//            }
            return result;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    /**
     * Finds the guarantee amount percentage code from description. If there are
     * more than 1, it returns the first one.
     *
     * @param description
     * @return
     */
    public String findRefGuaranteeAmountPercCode(String description) {
        if (description == null || description.equals("")) {
            return null;
        }
        List<CodeAndDescription> result
                = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.code,obj.description) "
                        + "from RefGuaranteeAmountPerc obj "
                        + "where obj.status = ?1 and obj.description = ?2 "
                        + "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) "
                        + "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
                .setParameter(1, Constants.RecordStatus.ACTIVE)
                .setParameter(2, description).getResultList();
        if (result == null || result.size() == 0) {
            return null;
        }
        return (String) result.get(0).getCode();
    }

    public List<CodeAndDescription> findAllFlexibleFormTypes(Object code) {
        List<CodeAndDescription> result
                = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.id, obj.formType) "
                        + "from FlexibleFormType obj "
                        + "where obj.status = ?1 ")
                .setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
        return result;
    }

    public List<CodeAndDescription> findAllFlexibleForms(Object code) {
        List<CodeAndDescription> result
                = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.id, obj.formName) "
                        + "from FlexibleForm obj "
                        + "where obj.status = ?1 ")
                .setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
        return result;
    }

    public List<CodeAndDescription> findAllFlexibleFieldsForForm(Long formId) {
        List<CodeAndDescription> result
                = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.fieldName, obj.fieldName) "
                        + "from FlexibleFormField obj "
                        + "where obj.status = ?1 and obj.flexibleForm.id = ?2")
                .setParameter(1, Constants.RecordStatus.ACTIVE)
                .setParameter(2, formId).getResultList();
        return result;
    }

//    public List<CodeAndDescription> findAllRiskAllowedFieldsInForm(String formName) {
//        List<CodeAndDescription> result = null;
//        MsgType msgType = (MsgType)em.createNamedQuery("MsgType.queryFindByCode").setParameter(1, formName).getSingleResult();
//        if (msgType == null){
//            result = findAllFieldList(null);
//        } else {
//            // check if the msgType is Flexible Form if so load all the flexible form fields in the list
//            if(msgType.getIsFlexibleForm() != null && msgType.getIsFlexibleForm().equals(Constants.TRUE)){
//                result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.fieldName, obj.fieldName) " +
//                               "from FlexibleFormField obj " +
//                               "where obj.fieldDefinition.specialPurpose = ?1 and obj.status = ?2 and obj.flexibleForm.formName = ?3")
//                           .setParameter(1,FlexFormsConstants.SpecialPurpose.ALLOW_IN_RISK)
//                           .setParameter(2,Constants.RecordStatus.ACTIVE)
//                           .setParameter(3,formName).getResultList();
//            }else{
//                result = findAllFieldList(null);
//            }
//        }
//        return result;
//    }    
    public List<CodeAndDescription> findAllFlexibleFieldTypes(Object code) {
        List<CodeAndDescription> result
                = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.code, obj.description) "
                        + "from FlexibleFieldDefinition obj "
                        + "where obj.status = ?1 ")
                .setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
        return result;
    }

//    public Serializable find(Object code, DataReference dataReference) {
//        
//        try {
//           return (Serializable)em.createQuery("select obj from "
//                    +dataReference.getDataType().getSimpleName()+ " obj where obj.code = ?1").setParameter(1,
//                    code).getSingleResult();
//            //return value;
//
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//
//        }
//    }
//    
//    public List<CodeAndDescription> findAllSubTaxTypeByTaxType(Object code,
//                                                   String filter) {
//        
//        String JOIN = null,CODE = null;
//        String delimiter = null;
//        CasRefTable refTable = em.find(CasRefTable.class,RefRevSubType.class.getName());
//        if(null != refTable){
//            if(null != refTable.getDisplaySelection() && refTable.getDisplaySelection().equalsIgnoreCase("JOIN")){
//                delimiter = refTable.getDisplayDelimiter();
//                JOIN = "JOIN";
//            }else
//                if(null != refTable.getDisplaySelection() && refTable.getDisplaySelection().equalsIgnoreCase("CODE")){
//                    CODE = "CODE";
//                }
//        }
//        
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefRevSubType obj " +
//                           "where obj.status = ?1 and obj.refRevType.code = ?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.description").setParameter(1,
//                                                                                                                     Constants.RecordStatus.ACTIVE).setParameter(2,
//                                                                                                                                                                 filter).getResultList();
//        if (!codeExist(result, code)) {
//            CodeAndDescription cad =
//                executeGenericDropDownQuery(RefRevSubType.class, code);
//            if (cad != null) {
//                result.add(cad);
//            }
//        }
//        
//        
//        for(CodeAndDescription cd:result){
//            if(JOIN != null){
//                cd.setDescription(cd.getCode() + delimiter + cd.getDescription());
//            }else{
//                if(CODE != null){
//                    cd.setDescription(String.valueOf(cd.getCode()));
//                }
//            }
//        }
//        
//        Collections.sort(result, new CodeAndDescriptionOrderDesc());
//        return result;
//    }
//  
    @Override
    public List<CodeAndDescription> findAllLegalStatusByTaxpayerType(Object code, String taxpayerType, String mode) {

        List<CodeAndDescription> result = null;
        if (mode != null && !Constants.Modes.ADD.equals(mode)) {

            result
                    = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) "
                            + "from RefLegalStatusType obj "
                            + "where obj.status = ?1 and (obj.taxpayerType = ?2 or obj.taxpayerType = 'Both') "
                            + "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) "
                            + "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.description")
                    .setParameter(1, Constants.RecordStatus.ACTIVE)
                    .setParameter(2, taxpayerType).getResultList();

        } else if (mode != null && Constants.Modes.ADD.equals(mode)) {
            result
                    = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) "
                            + "from RefLegalStatusType obj "
                            + "where obj.status = ?1 and (obj.taxpayerType = ?2 or obj.taxpayerType = 'Both') "
                            + "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) "
                            + "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) and obj.rgdRegistrationRequired = ?3 order by obj.description")
                    .setParameter(1, Constants.RecordStatus.ACTIVE)
                    .setParameter(2, taxpayerType).setParameter(3, "N").getResultList();

        }
        if (mode != null && Constants.Modes.ADD.equals(mode)
                || (!Constants.Modes.ADD.equals(mode) && !Constants.LegalStatus.SoleProprietor.equals(code))) {
            CodeAndDescription temp = null;
            for (CodeAndDescription res : result) {
                if (Constants.LegalStatus.SoleProprietor.equals(res.getCode())) {
                    temp = res;
                    break;
                }
            }
            if (temp != null) {
                result.remove(temp);
            }
        }
        if (!codeExist(result, code)) {
            CodeAndDescription cad
                    = executeGenericDropDownQuery(RefLegalStatusType.class, code);
            if (cad != null) {
                result.add(cad);
            }
        }
        return result;
    }

//    public List<CodeAndDescription> findFilteredLegalStatusByTaxpayerType(Object code,String taxpayerType) {
//
//        List<CodeAndDescription> result = new ArrayList<CodeAndDescription>();
//        List<RefLegalStatusType> tempList = em.createQuery("select obj " +
//                           "from RefLegalStatusType obj " +
//                           "where obj.status = ?1 and obj.taxpayerType = ?2 or obj.taxpayerType = 'Both' "+
//                           "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.description")
//                           .setParameter(1,Constants.RecordStatus.ACTIVE)
//                           .setParameter(2,taxpayerType).getResultList();
//                           
//       RefLegalStatusType refLegalStatusType =  this.findLegalStatusByCode((String)code);
//       if(null !=refLegalStatusType && null != refLegalStatusType.getHierarchyLevel()){
//            Long level = refLegalStatusType.getHierarchyLevel();
//            switch(level.intValue()){
//                case 1:
//                    for(RefLegalStatusType legalstatus:tempList){
//                        if(legalstatus.getHierarchyLevel()>=1){
//                            result.add(new CodeAndDescription(legalstatus.getCode(), legalstatus.getDescription()));
//                        }
//                    }
//                    break;
//                case 2:
//                    for(RefLegalStatusType legalstatus:tempList){
//                        if(legalstatus.getHierarchyLevel().compareTo(new Long(2))>=0 
//                            && legalstatus.getHierarchyLevel().compareTo(new Long(4))<0){
//                            result.add(new CodeAndDescription(legalstatus.getCode(), legalstatus.getDescription()));
//                        }
//                    }
//                    break;
//                case 3:                
//                    for(RefLegalStatusType legalstatus:tempList){
//                        if(legalstatus.getHierarchyLevel().compareTo(new Long(3))>=0 
//                            && legalstatus.getHierarchyLevel().compareTo(new Long(5))<0){
//                            result.add(new CodeAndDescription(legalstatus.getCode(), legalstatus.getDescription()));
//                        }
//                    }
//                    break;
//                case 4:
//                    for(RefLegalStatusType legalstatus:tempList){
//                        if(legalstatus.getHierarchyLevel().compareTo(new Long(3))>=0 
//                            && legalstatus.getHierarchyLevel().compareTo(new Long(5))<0){
//                            result.add(new CodeAndDescription(legalstatus.getCode(), legalstatus.getDescription()));
//                        }
//                    }
//                    break;
//                case 5:
//                for(RefLegalStatusType legalstatus:tempList){
//                    if(legalstatus.getHierarchyLevel().compareTo(new Long(5))==0 ){
//                        result.add(new CodeAndDescription(legalstatus.getCode(), legalstatus.getDescription()));
//                    }
//                }
//                break;
//            
//            }
//            
//       }else{
//           result = this.findAllLegalStatusByTaxpayerType(code, taxpayerType, null);
//       }
//        return result;
//    }
//
//    public List<CodeAndDescription> findAllFlexibleFormNameList(Object code) {
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.formName, obj.formName) " +
//                           "from FlexibleForm obj " +
//                           "where obj.status = ?1 ")
//                           .setParameter(1,Constants.RecordStatus.ACTIVE).getResultList();
//        return result;
//    }
//
//
//
//    public List<CodeAndDescription> findAllSubdivision(Object code, 
//                                                       String subvisionCode,
//                                                       String userOffice, 
//                                                       String coverageType) {
//        if(null == userOffice){
//            return new ArrayList<CodeAndDescription>();
//        }
//                                                       
//        RefOffice office = em.find(RefOffice.class,userOffice);
//        
//        List<RefOffCoverage> listOfCoverage = office.getOfficeCoverage();
//        List<CodeAndDescription> result = new ArrayList<CodeAndDescription>();
//        CodeAndDescription codeAndDescription = null;
//       
//        for(RefOffCoverage coverage: listOfCoverage){
//            if(coverage.getCoverageType().equals(coverageType)){
//                for(RefLocationByCountry location:coverage.getLocation()){
//                    codeAndDescription = new CodeAndDescription(location.getCode(),location.getDescription());
//                    result.add(codeAndDescription);
//                }
//              
//            }
//        }
//        
//        Collections.sort(result, new CodeAndDescriptionOrderDesc());
//        return result;
//    }
//
//    public List<CodeAndDescription> findAllCollectionAgentNames(String agentName, 
//                                            String agentType) {
//        
//        List<CodeAndDescription> result =
//                em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                               "from RefRevCollectionAgent obj " +
//                               "where obj.status = ?1 and obj.agentType.code = ?2 order by obj.description" 
//                              )
//                               .setParameter(1,Constants.RecordStatus.ACTIVE)
//                               .setParameter(2,agentType).getResultList();
//        return result;
//    }
//
//    public List<CodeAndDescription> findAllTaxpayerTypeFromComplianceConfig(Object code) {
//        try{
//            List<String> taxTypeCodes = 
//                em.createQuery("select distinct refRev.revenueType from RevComplianceConfiguration refRev")
//                                .getResultList();
//            
//            String taxTypeCodeList = null;
//            taxTypeCodeList = getTaxTypeCodeList(taxTypeCodes);
//            if(taxTypeCodeList == null){
//                taxTypeCodeList = " ('') ";
//            }
//            
//            List<CodeAndDescription> result =
//                                    em.createQuery("select distinct new com.crownagents.trips.dto.CodeAndDescription(refLegal.code,refLegal.description) " +
//                                        "from RefLegalStatusType refLegal,RefLegalTaxTypeRel revLegalRel " + 
//                                        "where refLegal.code=revLegalRel.refLegalStatus.code " + 
//                                        "and refLegal.status = ?1 " + 
//                                        "and revLegalRel.status = ?2 " +
//                                        "and revLegalRel.refRevType.code IN " + taxTypeCodeList + 
//                                        "and (revLegalRel.expiryDate is NULL or revLegalRel.expiryDate >= CURRENT_TIMESTAMP) " +
//                                        "and (revLegalRel.effectiveDate is NULL or revLegalRel.effectiveDate <= CURRENT_TIMESTAMP) " +
//                                        "and (refLegal.expiryDate is NULL or refLegal.expiryDate >= CURRENT_TIMESTAMP) " + 
//                                        "and (refLegal.effectiveDate is NULL or refLegal.effectiveDate <= CURRENT_TIMESTAMP) ")
//                                        .setParameter(1,Constants.RecordStatus.ACTIVE)
//                                        .setParameter(2,Constants.RecordStatus.ACTIVE)
//                                        .getResultList();
//            
//            Collections.sort(result, new CodeAndDescriptionOrderDesc());
//            return result;
//        }catch(javax.persistence.NoResultException e) {
//            return null;    
//        }
//        
//    }
//    
//    private String getTaxTypeCodeList(List<String> taxTypeCodes){
//        String taxType = null;
//        int tTypeCodesSize = taxTypeCodes.size();
//        for(int i=0; i<tTypeCodesSize; i++){
//            if(i==0){
//                taxType = "('" + taxTypeCodes.get(i) + "', ";
//            }else if(i!=0 && i!=(tTypeCodesSize-1)){
//                taxType = taxType + "'" + taxTypeCodes.get(i) + "', ";
//            }else if(i==(tTypeCodesSize-1)){
//                taxType = taxType + "'" + taxTypeCodes.get(i) + "') ";
//            }
//        }
//        
//        return taxType;
//    }
//
//    public List<CodeAndDescription> findAllRefDateRecurCfgByFilingFreq(String filter) {
//        List<CodeAndDescription> result = null;
//        
//        try{
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefDateRecurCfg obj " +
//                           "where obj.refStagger.code = ?1 " +
//                           "and obj.status = ?2 and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
//                           .setParameter(1, filter)
//                           .setParameter(2, Constants.RecordStatus.ACTIVE)
//                           .getResultList();
//        } catch (javax.persistence.NoResultException nre){
//            return null;
//        }
//            
//        return result;
//    }
//
//    public RefIdentifierType findRefIdentifierTypeByCode(String code) {
//        RefIdentifierType ref = 
//            (RefIdentifierType)em.createQuery("select rit from RefIdentifierType rit where rit.code = ?1 ")
//                .setParameter(1, code).getSingleResult();
//        return ref;
//    }
//
//    public List<CodeAndDescription> findAllCountriesExceptLocal(String localCountry) {
//        List<CodeAndDescription> result = 
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                            "from RefCountry obj " +
//                            "where obj.status = ?1 and obj.code <> ?2 order by obj.description")
//                            .setParameter(1,Constants.RecordStatus.ACTIVE)
//                            .setParameter(2,localCountry).getResultList();
//        return result;
//    }
//
//    public EntityManager getEntityManager() {
//        return em;
//    }
//
//    public List<RefSubTaxCategory> findRefSubtaxCategory(String revenuType,Long level ) {
//    List<RefSubTaxCategory> parentCodelist = null;
//       try {
//             parentCodelist = (List<RefSubTaxCategory>)em.createNamedQuery("RefSubTaxCategory.revenueType")
//                            .setParameter(1, revenuType).setParameter(2,level).getResultList();
//        } catch (NoResultException e) {
//            return null;
//        } catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//            return null;
//        }
//        return parentCodelist;
//    }
//    
//    public List<RefSubTaxCategory> findRefSubtaxCategory2(String revenuType,String parent) {
//    List<RefSubTaxCategory> categoryList = null;
//       try {
//             categoryList = (List<RefSubTaxCategory>)em.createNamedQuery("RefSubTaxCategory.subTaxCategory2")
//                            .setParameter(1, revenuType).setParameter(2,parent).getResultList();
//        } catch (NoResultException e) {
//            return null;
//        } catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//            return null;
//        }
//        return categoryList;
//    }
//    
//    
//
//    public RefSubTaxCategory findRefSubTaxCategoryWithCode(String code) {
//        RefSubTaxCategory subTaxCategory = null;
//           try {
//                 subTaxCategory = (RefSubTaxCategory)em.createNamedQuery("RefSubTaxCategory.selectedRecord")
//                                .setParameter(1, code).getSingleResult();
//                // TRGHA - 14090 - START --
//                if(Constants.Regimes.WIT.equalsIgnoreCase(subTaxCategory.getRevenueType())){
//                    if(subTaxCategory.getLevel()==2) {
//                        RefWithholdingType refWhType = em.find(RefWithholdingType.class,code);
//                        subTaxCategory.setCreditPostingRequiredFlag(refWhType.getCreditPostingRequired());
//                    }
//                }
//                // TRGHA - 14090 - END --
//            } catch (NoResultException e) {
//                return null;
//            } catch (Exception e) {
//                log.error(e.getLocalizedMessage(), e);
//                return null;
//            }
//            return subTaxCategory;
//    }
//
//
    public class CodeAndDescriptionOrderDesc implements Comparator<CodeAndDescription> {

        public int compare(CodeAndDescription o1, CodeAndDescription o2) {
            return o1.getDescription().compareTo(o2.getDescription());
        }
    }

//    public List<CodeAndDescription> findAllSubdivision(String subvisionCode) {
//        List<CodeAndDescription> result =
//                em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                               "from RefLocationByCountry obj " +
//                               "where obj.status = ?1 and obj.subdivision = ?2 order by obj.description" 
//                              )
//                               .setParameter(1,Constants.RecordStatus.ACTIVE)
//                               .setParameter(2,subvisionCode).getResultList();
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllPenaltyTypes(Object code,
//                                                   String filter) {
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefPenaltyType obj " +
//                           "where obj.status = ?1 and obj.transactionType = ?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1,
//                                                                                                                     Constants.RecordStatus.ACTIVE).setParameter(2,
//                                                                                                                                                                 filter).getResultList();
//        if (!codeExist(result, code)) {
//            CodeAndDescription cad =
//                executeGenericDropDownQuery(RefReason.class, code);
//            if (cad != null) {
//                result.add(cad);
//            }
//        }
//        return result;
//    }
//    //TODO - RevAccCleanup    
////    public List<CodeAndDescription> findRefRevTypesByEntity(Object entityID) {
////        List<CodeAndDescription> result =
////            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
////                           "from RefRevType obj,  RevAcc revAcc " +
////                           "where revAcc.revenueType = obj.code " +
////                           "and revAcc.entEntity = ?1 " +
////                           "and obj.description <> '"+Constants.Regimes.TAXPAYER+"' "+ //added not to fetch TAXPAYER regime
////                           "and obj.status = ?2 and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
////                           .setParameter(1, entityID)
////                           .setParameter(2, Constants.RecordStatus.ACTIVE)
////                           .getResultList();
////        return result;
////    }
//
//    /**
//     * returns period mode for a given code of revenue type
//     * @param code
//     * @return
//     */
//    public String findRefRevTypePeriodByCode(String code) {
//        Query q = em.createQuery("select obj.refRevMode " +
//                            "from RefRevType obj " +
//                            "where obj.code = ?1 ")
//                            .setParameter(1, code);
//        RefRevMode ref = (RefRevMode) q.getResultList().get(0);
//        return ref.getCode();
//    }
//    
////TODO - RevAccCleanup
////public List<CodeAndDescription> findRefRevTypesByEntityAndCode(Object entityID, String code) {
////        List<CodeAndDescription> result =
////            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
////                           "from RefRevType obj,  RevAcc revAcc " +
////                           "where revAcc.revenueType = obj.code " +
////                           "and revAcc.entEntity = ?1 " + 
////                           "and obj.description <> '"+Constants.Regimes.TAXPAYER+"' "+ //added not to fetch TAXPAYER regime
////                           "and obj.status = ?2 and obj.code <> ?3 and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
////                           .setParameter(1, entityID)
////                           .setParameter(2, Constants.RecordStatus.ACTIVE)
////                           .setParameter(3, code)
////                           .getResultList();
////        return result;
////    }
// 
////TODO - RevAccCleanup
////    public List<Long> findEntityByTIN(String accountNumber){
////        
////       List<Long> entEntityID =
////                            em.createQuery("select ra.entEntity from RevAcc ra where ra.acctNo = ?1")
////                                                .setParameter(1,accountNumber)
////                                                .getResultList();
////              
////        return entEntityID;        
////    }
////TODO - RevAccCleanup
////    public List<CodeAndDescription> findRefRevTypesByEntityAndCode(Object entityID, String code) {
////        List<CodeAndDescription> result =
////            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
////                           "from RefRevType obj,  RevAcc revAcc " +
////                           "where revAcc.revenueType = obj.code " +
////                           "and revAcc.entEntity = ?1 " + 
////                           "and obj.description <> '"+Constants.Regimes.TAXPAYER+"' "+ //added not to fetch TAXPAYER regime
////                           "and obj.status = ?2 and obj.code <> ?3 and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
////                           .setParameter(1, entityID)
////                           .setParameter(2, Constants.RecordStatus.ACTIVE)
////                           .setParameter(3, code)
////                           .getResultList();
////        return result; 
////    }
//
//    public List<Long> findEntityByTIN(String accountNumber){
//        
////       List<Long> entEntityID =
////                            em.createQuery("select ra.entEntity from RevAcc ra where ra.acctNo = ?1")
////                                                .setParameter(1,accountNumber)
////                                                .getResultList();
////              
//        List<Long> entEntityID = em.createQuery("select r.entEntity.id from " +
//        "RegTaxpayerStatusView r where r.tin = ?1 and r.registrationType='TAXPAYER' " +
//        "and r.displayStatus='Active'").setParameter(1, accountNumber).getResultList();
//    
//        return entEntityID;        
//    }
//    
//    public List<CodeAndDescription> findAllFormByTaxType(Object code,
//                                                       String taxType) {
//            List<CodeAndDescription> result =
//                em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                               "from RefFormType obj " +
//                               "where obj.status = ?1 and obj.refRevType.code = ?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                               "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1,
//                                                                                                                         Constants.RecordStatus.ACTIVE).setParameter(2,
//                                                                                                                                                                     taxType).getResultList();
//            if (!codeExist(result, code)) {
//                CodeAndDescription cad =
//                    executeGenericDropDownQuery(RefFormType.class, code);
//                if (cad != null) {
//                    result.add(cad);
//                }
//            }
//            
//            Collections.sort(result, new CodeAndDescriptionOrderDesc());
//            return result;
//        }
//        
//    public List<CodeAndDescription> findAllModeOfClaim() {
//        
//        List<CodeAndDescription> result = null;
//        
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefModeOfClaim obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//            
//        }
//        catch (javax.persistence.NoResultException nre) {
//            return null;
//        }
//              
//        return result;
//    }
//
//   public List<SysDbTableDefaultCols> findAllDefaultColumnsForTables() {
//        try {
//            return em.createNamedQuery("SysDbTableDefaultCols.findAll").getResultList();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//         }
//    }
//    
//    public List<CodeAndDescription> findAllRestrictions() {
//        
//        List<CodeAndDescription> result = null;
//        
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefRestrictions obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//            
//        }
//        catch (javax.persistence.NoResultException nre) {
//            return null;
//        }
//              
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllMannerOfIssuance() {
//        
//        List<CodeAndDescription> result = null;
//        
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefMannerOfIssuance obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//            
//        }
//        catch (javax.persistence.NoResultException nre) {
//            return null;
//        }
//              
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllLegalBasis() {
//        
//        List<CodeAndDescription> result = null;
//        
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefLegalBasis obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//            
//        }
//        catch (javax.persistence.NoResultException nre) {
//            return null;
//        }
//              
//        return result;
//    }
////TODO - RevAccCleanup    
////    public Long findEntityIdByRevAcctId(Long revAccountId) { 
////        try {
////            Long entityId = (Long)em.createQuery("select ra.entEntity from RevAcc ra where ra.id = ?1").setParameter(1, revAccountId).getSingleResult();
////                                                                                                                              
////            return entityId;
////        } catch (javax.persistence.NoResultException e) {
////            return null;
////        
////        
////        }
////    }
//  
//    public List<CodeAndDescription> findAllRefDateCategory(){
//        List<CodeAndDescription> result = null;
//        
//        try {
//            //result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) from RefDateCategory obj").getResultList();
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefDateCategory obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllRefDateSubCategory(){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefDateSubCategory obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllRefDateRecurCfg(){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefDateRecurCfg obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//   
//    public List<CodeAndDescription> findAllTaxType(){
//        List<CodeAndDescription> tempresult = null;
//        List<CodeAndDescription> result = new ArrayList<CodeAndDescription>();
//        try {
//            tempresult = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefRevType obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//            
//            for(CodeAndDescription r : tempresult){
//                if(!r.getDescription().equalsIgnoreCase("TAXPAYER")){
//                    result.add(r);
//                }
//            }
//            
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllFormulaList(){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefDateRecurCfg obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
///*    
//    public List<CodeAndDescription> findAllTaxType(){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefCfgGenPeriod obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//*/    
//    public List<CodeAndDescription> findAllFilingMode(){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefFilingMode obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllCaseTypes() {
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefCaseType obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllCaseStatus(){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefCaseStatus obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllCaseTypesByCaseCategory(String caseCategory){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefCaseType obj where obj.status = ?1 and obj.category=?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
//            .setParameter(1, Constants.RecordStatus.ACTIVE)
//            .setParameter(2, caseCategory)
//            .getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllCaseTypesByCaseType(String caseType){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefCaseType obj where obj.status = ?1 and obj.caseType=?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
//            .setParameter(1, Constants.RecordStatus.ACTIVE)
//            .setParameter(2, caseType)
//            .getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllCaseOutComesByCaseType(String caseType){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefCaseOutcome obj where obj.status = ?1 and obj.caseType =?2  and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE)
//            .setParameter(2, caseType).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//        
//    }
//    
//    public List<CodeAndDescription> findAllCaseDocumentStatus(){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefCaseDocStatus obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//    
//    
//    public List<CodeAndDescription> findAllCaseDocumentType(){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefCaseDocType obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllCaseReason(String catergory){
//        List<RefReasonCategory> result = null;
//        List<CodeAndDescription> returnList = new ArrayList<CodeAndDescription>();
//        try {
//             Query query = em.createQuery("select obj " +
//            "from RefReasonCategory obj where obj.status = ?1 and obj.code = ?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)");
//            
//            query.setParameter(1, Constants.RecordStatus.ACTIVE);
//            query.setParameter(2, catergory);
//            result =  query.getResultList();
//            
//            
//            
//            List <RefReason> reasonList =  result.get(0).getRefReasonList();
//            Iterator i = reasonList.iterator();
//            while(i.hasNext()){
//                RefReason reason = (RefReason) i.next();
//                returnList.add(new CodeAndDescription( reason.getCode(), reason.getDescription()));
//            }
//            
//        }
//        catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return returnList;
//    }
//    
//    public List<CodeAndDescription> findAllCaseOffice(){
//        List<RefOffice> result = null;
//        List<CodeAndDescription> offices = new ArrayList<CodeAndDescription>();
//        try{
//            Query query = em.createQuery("select obj from RefOffice obj where obj.status = ?1" 
//            + "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " 
//            + "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)");
//            
//            query.setParameter(1, Constants.RecordStatus.ACTIVE);
//            result =  query.getResultList();
//            
//            for(RefOffice r:result){
//                offices.add(new CodeAndDescription( r.getCode(), r.getDescription()));
//            }
//            
//        }catch(javax.persistence.NoResultException nre){
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;            
//        }
//        
//        return offices;
//    }
//    
//    public List<CodeAndDescription> findAcceptingCaseOffice(String code){
//        //TODO (AE) Ghana Don't have Suboffice concept while doing case assignement. Below code need to modify if suboffice concept will come in future. 
////        List<OfficeSubordinates> parentOffices = new ArrayList<OfficeSubordinates>();
////        List<OfficeSubordinates> peerOffices = new ArrayList<OfficeSubordinates>();
////        List<OfficeSubordinates> childOffices = new ArrayList<OfficeSubordinates>();
//        List<CodeAndDescription> acceptingOffices = new ArrayList<CodeAndDescription>();
//        
//        try{
//            List<RefOffice>  offices = em.createQuery("select obj from RefOffice obj" )
//                                                                    .getResultList();
//            for(RefOffice off:offices){
//                if(!off.getCode().equalsIgnoreCase(code)){
//                    acceptingOffices.add(new CodeAndDescription(off.getCode(), off.getDescription()));
//                }
//            }
//            //TODO (AE) Ghana Don't have Suboffice concept while doing case assignement. Below code need to modify if suboffice concept will come in future. 
////            parentOffices = em.createQuery("select obj from OfficeSubordinates obj where obj.subOffice.code = ?1" )
////                                            .setParameter(1, code)
////                                            .getResultList();
////                                            
////            for(OfficeSubordinates rec:parentOffices){
////                RefOffice  office = (RefOffice) em.createQuery("select obj from RefOffice obj where obj.code = ?1" )
////                                                        .setParameter(1, rec.getRefOffice().getCode())
////                                                        .getSingleResult(); 
////                if(!code.equalsIgnoreCase(office.getCode())){ 
////                    acceptingOffices.add(new CodeAndDescription(office.getCode(), office.getDescription()));
////                }
////            }
////            
////                                            
////            for(OfficeSubordinates pOffice :parentOffices){
////                List<OfficeSubordinates> temp = em.createQuery("select obj from OfficeSubordinates obj where obj.refOffice.code = ?1" )
////                                            .setParameter(1, pOffice.getRefOffice().getCode())
////                                            .getResultList();
////                peerOffices.addAll(temp);            
////            }
////                         
////            for(OfficeSubordinates rec:peerOffices){
////                RefOffice  office = (RefOffice) em.createQuery("select obj from RefOffice obj where obj.code = ?1" )
////                                                        .setParameter(1, rec.getSubOffice().getCode())
////                                                        .getSingleResult(); 
////                if(!code.equalsIgnoreCase(office.getCode())){                                                        
////                    acceptingOffices.add(new CodeAndDescription(office.getCode(), office.getDescription()));
////                }
////            }
////            
////            childOffices = em.createQuery("select obj from OfficeSubordinates obj where obj.refOffice.code = ?1" )
////                                            .setParameter(1, code)
////                                            .getResultList();   
////                                            
////            for(OfficeSubordinates rec:childOffices){
////                RefOffice  office = (RefOffice) em.createQuery("select obj from RefOffice obj where obj.code = ?1" )
////                                                        .setParameter(1, rec.getSubOffice().getCode())
////                                                        .getSingleResult(); 
////                if(!code.equalsIgnoreCase(office.getCode())){                                                         
////                    acceptingOffices.add(new CodeAndDescription(office.getCode(), office.getDescription()));
////                }
////            }
//            
//        }catch(Exception e){
//            log.error(e.getLocalizedMessage(), e);
//        }
//        return acceptingOffices;                 
//    }
//    
//    public List<OfficeSubordinates> findSubOffice(String code){
//    
//        List<OfficeSubordinates> childOffices = new ArrayList<OfficeSubordinates>();
//        try{
//            childOffices = em.createQuery("select obj from OfficeSubordinates obj where obj.refOffice.code = ?1" )
//                                        .setParameter(1, code)
//                                        .getResultList();  
//        }catch(Exception e){
//            log.error(e.getLocalizedMessage(), e);
//        }
//        
//        return childOffices;
//    }
//    
//    public List<CodeAndDescription> findAllOfficeStaff(String officeCode){
//        List<CodeAndDescription> staffs = new ArrayList<CodeAndDescription>();
//        List<RefOffStaff> result = new ArrayList<RefOffStaff>();
//        try{
//            result = em.createQuery("select obj from RefOffStaff obj where obj.refOffice.code = ?1 and obj.status = ?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) ")
//                                            .setParameter(1,officeCode)
//                                            .setParameter(2,Constants.RecordStatus.ACTIVE)
//                                            .getResultList(); 
//                                            
//        }catch(javax.persistence.NoResultException nre){
//            log.error(nre.getLocalizedMessage(), nre);
//            return staffs;
//        } 
//                                            
//        for(RefOffStaff r: result){
//            try{
//                WfisUserT user = (WfisUserT) em.createQuery("select obj from WfisUserT obj where UPPER(obj.description) = ?1")
//                                            .setParameter(1,r.getUsername().toUpperCase())
//                                            .getSingleResult();
//                staffs.add(new CodeAndDescription( r.getUsername(), user.getDisplayname()));
//            }catch(javax.persistence.NoResultException nre){
//                continue;
//            }
//        }
//            
//
//        
//        return staffs;
//    }
//    
//    public List<RefOffStaff> findOfficeStaffByOffice(String officeCode){
//     
//        List<RefOffStaff> result = new ArrayList<RefOffStaff>();
//        try{
//            result = em.createQuery("select obj from RefOffStaff obj where obj.refOffice.code = ?1 and obj.status = ?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) ")
//                                            .setParameter(1,officeCode)
//                                            .setParameter(2,Constants.RecordStatus.ACTIVE)
//                                            .getResultList(); 
//                                            
//        }catch(javax.persistence.NoResultException nre){
//            return null;
//        } 
//                                                  
//        return result;
//    }
//    
//    public List<RefOffStaff> findInactiveOfficeStaffByOffice(String officeCode){
//     
//        List<RefOffStaff> result = new ArrayList<RefOffStaff>();
//        try{
//            result = em.createQuery("select obj from RefOffStaff obj where obj.refOffice.code = ?1 and obj.status = ?2")
//                                            .setParameter(1,officeCode)
//                                            .setParameter(2,Constants.RecordStatus.INACTIVE)
//                                            .getResultList(); 
//                                            
//        }catch(javax.persistence.NoResultException nre){
//            return null;
//        } 
//                                                  
//        return result;
//    }
//    
//    public String findOfficeByUser (String userId){
//        String office =null;
//        
//        try{
//          RefOffStaff  refOffStaff = (RefOffStaff) em.createQuery("select obj from RefOffStaff obj where UPPER(obj.username) = ?1 and obj.status = ?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) ")
//                                            .setParameter(1,userId.toUpperCase())
//                                            .setParameter(2,Constants.RecordStatus.ACTIVE)
//                                            .getSingleResult(); 
//            office = refOffStaff.getRefOffice().getCode();                                            
//            
//        }catch(javax.persistence.NoResultException nre){
//            return null;
//        }
//        catch(Exception e){
//            log.error(e.getLocalizedMessage(), e);
//        }
//        
//        return office;
//    }
//    
    public List<CodeAndDescription> findAllSearchID(Object code) {
        try {
            List<CodeAndDescription> result
                    = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(config.searchId,config.searchId) "
                            + "from SearchConfig config "
                            + "where config.status = ?1 "
                            + "and (config.expiryDate is NULL or config.expiryDate >= CURRENT_TIMESTAMP) "
                            + "and (config.effectiveDate is NULL or config.effectiveDate <= CURRENT_TIMESTAMP) ")
                    .setParameter(1, Constants.RecordStatus.ACTIVE)
                    .getResultList();

            if (!codeExist(result, code)) {
                CodeAndDescription cad = null;
                try {
                    cad = (CodeAndDescription) em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(config.searchId,config.searchId) "
                            + "from SearchConfig config "
                            + "where config.searchId = ?1 ")
                            .setParameter(1, code)
                            .getSingleResult();
                } catch (javax.persistence.NoResultException e) {
                    cad = null;
                }
                if (cad != null) {
                    result.add(cad);
                }
            }
            Collections.sort(result, new CodeAndDescriptionOrderDesc());
            return result;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

//    public List<CodeAndDescription> findAllWorkflowName(Object code,
//                                                   String workflowType) {
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefWorkflowName obj " +
//                           "where obj.status = ?1 and obj.workflowType = ?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1,
//                                                                                                                     Constants.RecordStatus.ACTIVE).setParameter(2,
//                                                                                                                                                                 workflowType).getResultList();
//                                                                                                                                                                 
//        if (!codeExist(result, code)) {
//            CodeAndDescription cad =
//                executeGenericDropDownQuery(RefWorkflowName.class, code);
//            if (cad != null) {
//                result.add(cad);
//            }
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllClassificationOfProperty() {
//            
//            List<CodeAndDescription> result = null;
//            
//            try {
//                result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                "from RefClassificationOfProperty obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//                
//            }
//            catch (javax.persistence.NoResultException nre) {
//                return null;
//            }
//                  
//            return result;
//        }
//        
//        public List<CodeAndDescription> findAllTypeOfProperty() {
//            
//            List<CodeAndDescription> result = null;
//            
//            try {
//                result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                "from RefTypeOfProperty obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//                
//            }
//            catch (javax.persistence.NoResultException nre) {
//                return null;
//            }
//                  
//            return result;
//        }
//        
//        public List<CodeAndDescription> findAllUsers() {
//            List<CodeAndDescription> results = new ArrayList <CodeAndDescription>();                        
//            try{
//                List<WfisUserT> users = em.createNamedQuery("WfisUserT.findAll").getResultList();
//                for(WfisUserT u: users){                    
//                    results.add(new CodeAndDescription( u.getName(), u.getDisplayname()));
//                }
//            }catch (javax.persistence.NoResultException nre) {
//                log.error(nre.getLocalizedMessage(), nre);
//                return null;
//            }                                    
//            return results;
//        }
//        
//    public Timestamp findPeriodStartRangeByPeriodId(Long id) {
//        Timestamp periodStart = null;
//        try {
//            String sql = "select o.periodStartDate from AccountPeriod o where o.id = :id";
//            Query query = em.createQuery(sql);
//            query.setParameter("id", id);
//            periodStart = (Timestamp)query.getSingleResult();
//        } catch (javax.persistence.NoResultException nre) {
//                log.error(nre.getLocalizedMessage(), nre);
//                return null;
//        }    
//        return periodStart;
//    }
//    
////    public Timestamp findPeriodEndRangeByPeriodId(Long id) {
////        Timestamp periodEnd = null;
////        try {
////            String sql = "select o.periodEndDate from AccountPeriod o where o.id = :id";
////            Query query = em.createQuery(sql);
////            query.setParameter("id", id);
////            periodEnd = (Timestamp)query.getSingleResult();
////        } catch (javax.persistence.NoResultException nre) {
////                log.error(nre.getLocalizedMessage(), nre);
////                return null;
////        }    
////        return periodEnd;
////    }
////    
////    public String findCaseTypeByTaxType(String taxType, String moduleLink) {
////        String caseType = null;
////        try {
////            StringBuffer sql = new StringBuffer("select o.caseType from RefCaseModuleLink o where o.taxType = :taxType and o.moduleLink = :moduleLink");
////            Query query = em.createQuery(sql.toString());
////            query.setParameter("taxType", taxType).setParameter("moduleLink", moduleLink);
////            caseType = (String)query.getSingleResult();
////        } catch (javax.persistence.NoResultException nre) {
////                log.error(nre.getLocalizedMessage(), nre);
////                return null;
////        }    
////        return caseType;
////    }
//    
////    public List<CodeAndDescription> findAllRefundAuthType() {
////        
////        List<CodeAndDescription> result = null;
////        
////        try {
////            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
////            "from RefRefundAuthType obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
////            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
////            
////        }
////        catch (javax.persistence.NoResultException nre) {
////            return null;
////        }
////              
////        return result;
////    }
//    
//    public List<CodeAndDescription> findAllUsersByLastName() {
//        List<CodeAndDescription> results = new ArrayList <CodeAndDescription>();                        
//        try{
//            results = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.name,obj.displayname) " +
//            "from WfisUserT obj where obj.status = ?1 order by obj.lastname ").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }catch (javax.persistence.NoResultException nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }                                    
//        return results;
//    }
//    
////    public List<CodeAndDescription> findAllRCOAgents(String rdo) {
////        
////        List<CodeAndDescription> result = null;
////        
////        try {
////            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.code) " +
////            "from RefRevCollectionAgent obj where obj.status = ?1 and obj.refOffice.code = ?2 and obj.agentType.code = ?3 " +
////            "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
////            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
////            .setParameter(1, Constants.RecordStatus.ACTIVE)
////            .setParameter(2, rdo)
////            .setParameter(3, Constants.CollectionAgentTypes.REVENUE_COLLECTION_OFFICER)            
////            .getResultList();
////            
////        }
////        catch (javax.persistence.NoResultException nre) {
////            return null;
////        }
////              
////        return result;
////    }
////    
////    public String findCollAgentByCode(String agentCode) {
////        
////        String result = null;
////        
////        try {
////            result = (String) em.createQuery("select obj.agentName from RefRevCollectionAgent obj where obj.code = ?1 ") 
////            .setParameter(1, agentCode)
////            .getSingleResult();
////            
////        }
////        catch (javax.persistence.NoResultException nre) {
////            return null;
////        }
////              
////        return result;
////    }
//    
////    public List<CodeAndDescription> findAllGovBanks(String currentOffice) {
////        List<CodeAndDescription> result = null;
////        
////        try {
////            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.agentName) " +
////            "from RefRevCollectionAgent obj where obj.status = ?1 and obj.refOffice.code = ?2 and obj.agentType.code = ?3 " +
////            "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
////            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
////            .setParameter(1, Constants.RecordStatus.ACTIVE)
////            .setParameter(2, currentOffice)
////            .setParameter(3, Constants.CollectionAgentTypes.GOVERNMENT_BANK)            
////            .getResultList();
////            
////        }
////        catch (javax.persistence.NoResultException nre) {
////            return null;
////        }
////              
////        return result;
////    }
//    
//    public String findUserByCode(String code){
//    
//        String displayName = null;        
//        try{        
//            List<CodeAndDescription> users = findAllUsers();
//            
//            for(CodeAndDescription user :users){
//                if (user.getCode().equals(code)){
//                    displayName=user.getDescription();
//                }
//            }            
//        }catch (javax.persistence.NoResultException nre) {
//                log.error(nre.getLocalizedMessage(), nre);
//                return displayName;
//        }           
//        return displayName;
//        
//    }
//
////    public List<CodeAndDescription> findAllRiskAllowedSectionsInFlexibleForm(String formName) {
////        List<CodeAndDescription> result = null;
////        
////        try {
////            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(o.id, o.fieldName) " +
////            " from FlexibleFormField o where o.flexibleForm.formName = ?1 and o.specialPurpose = ?2")
////            .setParameter(1, formName)
////            .setParameter(2, FlexFormsConstants.SpecialPurpose.RISK_SECTION)
////            .getResultList();
////        }
////        catch (javax.persistence.NoResultException nre) {
////            result.add(new CodeAndDescription("0", "page"));
////            return result;
////        }
////        result.add(new CodeAndDescription("0", "page"));
////        return result;
////    } 
//    
//    
////    public List<CodeAndDescription> findAllRiskAllowedFieldsForSectionInForm(String formName, String sectionId) {
////        if (sectionId == null) return null;
////        if (formName == null){
////            return findAllFieldList( Long.getLong(sectionId) );
////        }else{
////            try{
////                MsgType msgType = (MsgType)em.createNamedQuery("MsgType.queryFindByCode").setParameter(1, formName).getSingleResult();
////                if (msgType == null) return null;
////                // check if the msgType is Flexible Form if so load all the flexible form fields in the list
////                if(msgType.getIsFlexibleForm() != null && msgType.getIsFlexibleForm().equals(Constants.TRUE)){
////                    // if section is null or is page return all the fields        
////                    if(sectionId == null || (sectionId != null && sectionId.equals("0"))){ //0 - for the page
////                        return findAllRiskAllowedFieldsInForm (formName);
////                    }else{
////                        List<CodeAndDescription> returnList = new ArrayList<CodeAndDescription>();
////                        return returnList;
////                    }
////                }else{
////                    return findAllFieldList (new Long(sectionId)); 
////                }        
////            }catch(Exception ex){
////                log.error(ex.getLocalizedMessage(), ex);
////            }
////        }return null;
////    } 
////    
//    
//    public List<JobDefinition> findAllJobDefinition(JobDefinition jobDefinition){
//        List<JobDefinition> result = new ArrayList<JobDefinition>();
//        try{
//            if(jobDefinition != null && jobDefinition.getId() != null){
//                result = em.createQuery("select obj from JobDefinition obj where obj.id = ?1" )
//                                            .setParameter(1, jobDefinition.getId())
//                                            .getResultList();  
//            }else{
//                result = em.createQuery("select obj from JobDefinition obj" ).getResultList(); 
//            }
//        }catch (javax.persistence.NoResultException ex) {
//            log.error(ex.getLocalizedMessage(), ex);
//            return null;
//        }catch(Exception e){
//            log.error(e.getLocalizedMessage(), e);
//            return null;
//        }
//        return result;
//    }
//    
//    public List<RefJobStream> findAllJobStream(RefJobStream refJobStream){
//       List<RefJobStream> result = new ArrayList<RefJobStream>();
//       try{
//           if(refJobStream != null && refJobStream.getCode() != null){
//               result = em.createQuery("select obj from RefJobStream obj where obj.code = ?1" )
//                                           .setParameter(1, refJobStream.getCode())
//                                           .getResultList();  
//           }else{
//               result = em.createQuery("select obj from RefJobStream obj" ).getResultList(); 
//           }
//       }catch (javax.persistence.NoResultException ex) {
//           log.error(ex.getLocalizedMessage(), ex);
//           return null;
//       }catch(Exception e){
//           log.error(e.getLocalizedMessage(), e);
//           return null;
//       }
//       return result;
//    }
//    
//    //TODO - RevAccCleanup
////    public List<CodeAndDescription> findAllPeriodEndByRegimeAndEntity(String regimeType,
////                                                                   Long entEntityId,
////                                                                   boolean useDescAsCode) {
////        if (null == regimeType || null == entEntityId) {
////            return new ArrayList<CodeAndDescription>();
////        } else {
////            try {
////                List data =
////                    em.createQuery("select ra.id from RevAcc ra where ra.revType.code = ?1 and ra.entEntity = ?2 and ra.accStatus=?3").setParameter(1,
////                                                                                                                                                    regimeType).setParameter(2,
////                                                                                                                                                                             entEntityId).setParameter(3,
////                                                                                                                                                                                                       Constants.Regimes.REGISTER).getResultList();
////                if (data == null || data.isEmpty()) {
////                    return new ArrayList<CodeAndDescription>();
////                } else {
////                    Long revAccID = (Long)data.get(0);
////                    List<CodeAndDescription> result = null;
////                    List row =
////                        em.createQuery("select rrp.id, rrp.periodEnd  " +
////                                       "from RevledRevPeriod rrp " +
////                                       "where rrp.status = ?1 and rrp.revAcc = ?2 order by rrp.periodEnd asc").setParameter(1,
////                                                                                                  Constants.RecordStatus.ACTIVE).setParameter(2,
////                                                                                                                                              revAccID).getResultList();
////                    result = new ArrayList(row.size());
////                    for (int i = 0; i < row.size(); i++) {
////                        Object[] columns = (Object[])row.get(i);
////                        Timestamp desc = (Timestamp)columns[1];
////                        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
////                        Long code = (Long)columns[0];
////                        if (useDescAsCode) {
////                            result.add(new CodeAndDescription(sdf.format(desc.getTime()), sdf.format(desc.getTime())));
////                        } else {
////                            result.add(new CodeAndDescription(code, sdf.format(desc.getTime())));
////                        }
////
////                    }
////                    return result;
////                }
////            } catch (javax.persistence.NoResultException e) {
////                return null;
////            }
////        }
////    }
//    
//    public Timestamp findPeriodDueDateByPeriodId(Long id) {
//        Timestamp periodEnd = null;
//        try {
//            String sql = "select o.periodDueDate from AccountPeriod o where o.id = :id";
//            Query query = em.createQuery(sql);
//            query.setParameter("id", id);
//            periodEnd = (Timestamp)query.getSingleResult();
//        } catch (javax.persistence.NoResultException nre) {
//                log.error(nre.getLocalizedMessage(), nre);
//                return null;
//        }    
//        return periodEnd;
//    }
//
//    public List<CodeAndDescription> findAllLikelihood(){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefLikelihood obj where obj.status = ?1 order by obj.orderSeq asc ").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllFrequency(){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefFrequency obj where obj.status = ?1 order by obj.orderSeq asc ").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllAuditProfileType(){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefAuditProfileType obj where obj.status = ?1 ").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllScale(){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefScale obj where obj.status = ?1 ").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllAuthorisationTypeByApplication(String authorizationType, 
//                                                                  String applicationType) {
//    
//        return findAllCodeAndDescription(authorizationType,RefAuthorisationType.class,"description","obj.applicationType = '" + applicationType + "'");
//    }
//
////TODO - RevAccCleanup    
////    public List<CodeAndDescription> findAllPossiblePeriodByEntityIdAndPeriodStatus(Long entityID,String periodStatus){
////        try {
////            List<RevAcc> revAccList =em.createQuery("select ra from RevAcc ra where ra.entEntity = ?1")
////                                                     .setParameter(1, entityID).getResultList();
////            List<CodeAndDescription> periodList = new ArrayList<CodeAndDescription>();
////            for(int i=0;i<revAccList.size(); i++){
////                List row = null;
////                if(periodStatus == null){
////                    row = em.createQuery("select rrp.id,rrp.periodNo,rrp.periodYear,rrp.periodLabel " +
////                                   "from RevledRevPeriod rrp " +
////                                   "where rrp.revAcc = ?1 order by rrp.periodYear asc ").setParameter(1,revAccList.get(i).getId()).getResultList();
////                }else{
////                    row = em.createQuery("select rrp.id,rrp.periodNo,rrp.periodYear,rrp.periodLabel " +
////                                   "from RevledRevPeriod rrp " +
////                                   "where rrp.revAcc = ?1 and rrp.periodstatus = ?2 order by rrp.periodYear asc ").setParameter(1,revAccList.get(i).getId()).getResultList();
////                }
////                List<CodeAndDescription> period = wrapPeriodValues(row,false);
////                periodList.addAll(period);
////            }
////            return periodList;
////        } catch (javax.persistence.NoResultException e) {
////            return null;
////        }
////    }
//    
// //TODO - RevAccCleanup    
////    public List<CodeAndDescription> findAllPeriodStartByRegimeAndEntity(String regimeType,
////                                                                   Long entEntityId,
////                                                                   boolean useDescAsCode) {
////        if (null == regimeType || null == entEntityId) {
////            return new ArrayList<CodeAndDescription>();
////        } else {
////            try {
////                List data =
////                    em.createQuery("select ra.id from RevAcc ra where ra.revType.code = ?1 and ra.entEntity = ?2 and ra.accStatus=?3").setParameter(1,
////                                                                                                                                                    regimeType).setParameter(2,
////                                                                                                                                                                             entEntityId).setParameter(3,
////                                                                                                                                                                                                       Constants.Regimes.REGISTER).getResultList();
////                if (data == null || data.isEmpty()) {
////                    return new ArrayList<CodeAndDescription>();
////                } else {
////                    Long revAccID = (Long)data.get(0);
////                    List<CodeAndDescription> result = null;
////                    List row =
////                        em.createQuery("select rrp.id, rrp.periodStart  " +
////                                       "from RevledRevPeriod rrp " +
////                                       "where rrp.status = ?1 and rrp.revAcc = ?2 order by rrp.periodEnd asc").setParameter(1,
////                                                                                                  Constants.RecordStatus.ACTIVE).setParameter(2,
////                                                                                                                                              revAccID).getResultList();
////                    result = new ArrayList(row.size());
////                    for (int i = 0; i < row.size(); i++) {
////                        Object[] columns = (Object[])row.get(i);
////                        Timestamp desc = (Timestamp)columns[1];
////                        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
////                        Long code = (Long)columns[0];
////                        if (useDescAsCode) {
////                            result.add(new CodeAndDescription(sdf.format(desc.getTime()), sdf.format(desc.getTime())));
////                        } else {
////                            result.add(new CodeAndDescription(code, sdf.format(desc.getTime())));
////                        }
////
////                    }
////                    return result;
////                }
////            } catch (javax.persistence.NoResultException e) {
////                return null;
////            }
////        }
////    }
//
//    public List<CodeAndDescription> findAllIndustryGroup(){
//    //TRPHL927
//        List<CodeAndDescription> row = null;
//        
//        try {
//            row = em.createQuery("select distinct new com.crownagents.trips.dto.CodeAndDescription(obj.code, obj.industryGroup) from RefIndustClassification obj order by obj.industryGroup asc").getResultList();
//
//            return row;
//        }
//        catch (Exception nre) {
//            return null;
//        }
//        
//    }  
//    public List<CodeAndDescription> findAllIndustryByGroup(String group){
//        List<CodeAndDescription> row = null;
//        
//        try {
//            row = em.createQuery("select distinct new com.crownagents.trips.dto.CodeAndDescription(obj.code, obj.description) " +
//            "from RefIndustClassification obj where obj.industryGroup = ?1 order by obj.industryGroup asc").setParameter(1,group).getResultList();
//            
//            return row;
//        }
//        catch (Exception nre) {
//            return null;
//        }
//    }
//    
//    public List<RefLegalStatusFiscal> findAllRefLegalStatusFiscalByLegalStatus(String legalStatus){
//        try{
//            List<RefLegalStatusFiscal> result =
//                em.createQuery("select obj from RefLegalStatusFiscal obj " +
//                               "where obj.status = ?1 and obj.legalStatus.code = ?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                               "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
//                               .setParameter(1,Constants.RecordStatus.ACTIVE)
//                               .setParameter(2,legalStatus)
//                               .getResultList();
//            return result;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }   
//    }
//    
//    public List<CodeAndDescription> findAllRiskLevels(){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefRiskLevel obj where obj.status = ?1 order by obj.orderSeq asc ").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllAuditSelectItems(String refTable){
//        List<CodeAndDescription> result = null;
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) from "
//                    +  refTable + 
//                    " obj where obj.status = ?1 ").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//        }
//        catch (javax.persistence.NoResultException nre) {
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllRelationshipTypesByCategory(Object code,
//                                                   String[] categoryTypes) {
//        List<CodeAndDescription> result = null;
//        if(categoryTypes != null){
//            String valueForINClause =  "(" + StringHelper.getSQLInClauseString(categoryTypes) + ")";
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefRelationshipType obj " +
//                           "where obj.status = ?1 and obj.category.code in " + valueForINClause + 
//                           "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
//                           .setParameter(1,Constants.RecordStatus.ACTIVE)
//                           .getResultList();
//        }else{
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefRelationshipType obj " +
//                           "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
//                           .setParameter(1,Constants.RecordStatus.ACTIVE)
//                           .getResultList();
//        }
//                                                                                                                                                                 
//        if (!codeExist(result, code)) {
//            CodeAndDescription cad =
//                executeGenericDropDownQuery(RefReason.class, code);
//            if (cad != null) {
//                result.add(cad);
//            }
//        }
//        return result;
//    }
//    
//    public List<RefRelationshipType> findAllRefRelationshipTypeByCategory(String category){
//        List<RefRelationshipType> result = null;
//        try {
//            if(category != null){
//                result = em.createQuery("select o from RefRelationshipType o where o.category.code = ?1")
//                            .setParameter(1,category)
//                            .getResultList();
//            }else{
//                result = em.createQuery("select o from RefRelationshipType o ").getResultList();
//            }
//        } catch (Exception nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllRefundAssessment() {
//        
//        List<CodeAndDescription> result = null;
//        
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefRefundAssessment obj where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, Constants.RecordStatus.ACTIVE).getResultList();
//            
//        }
//        catch (javax.persistence.NoResultException nre) {
//            return null;
//        }
//              
//        return result;
//    }
//    
//    public RefLegalStatusType findLegalStatusByCode(String code){
//        RefLegalStatusType refLegalStatusType = null;
//        try{
//            refLegalStatusType = (RefLegalStatusType)em.createQuery("select o from RefLegalStatusType o where o.code = ?1")
//                                    .setParameter(1, code).getSingleResult();
//        }catch(javax.persistence.NoResultException nre){
//            return null;
//        }
//        
//        return refLegalStatusType;
//    }
//    /*
//    *  This method used to populatevalues for CopyScriptFrom list box.
//    *  @return List of records in format of CodeAndDescription.
//    */
//    public List<CodeAndDescription> findCopyScriptFrom() {
//         List<CodeAndDescription> result = null;
//         try {
//         
//              result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.id,obj.scriptName) from ScrCommScript obj ").getResultList(); 
//             
//          } catch (javax.persistence.NoResultException e) {
//              return null;
//          }
//         return result;
//     } 
//     
//     
    public RefEvtTypeCat findEvtTypeCategory(String eventType, String category) {
        RefEvtTypeCat refEvtTypeCat = null;
        try {
            refEvtTypeCat = (RefEvtTypeCat) em.createQuery("select o from RefEvtTypeCat o where o.refEvtType.code = ?1 and o.refEvtCategories.code = ?2")
                    .setParameter(1, eventType).setParameter(2, category).getSingleResult();
        } catch (javax.persistence.NoResultException nre) {
            return null;
        }

        return refEvtTypeCat;
    }
//    
//    /**
//     * This method either loads list of all Precise categories or Precise categories based on category.
//     * @param category
//     * @return
//     */
//    public List<CodeAndDescription> findAllPreciseCategorys(String category){
//        List<CodeAndDescription> result = null;
//        try {
//            if(category != null){
//                result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(o.code,o.description) "+
//                    " from RefOccPreciseCategory o where o.refOccupationCategory.code = ?1")
//                            .setParameter(1,category)
//                            .getResultList();
//            }
//        } catch (Exception nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//    
//    
//    /**
//     * This method returns a Precise category based on category and precise category code.
//     * @param occupationCode
//     * @param occupationCode
//     * @return
//     */
//     public  List<CodeAndDescription> findAllPreciseCategoryBasedOnMainCategory (String preciseCategory, String mainCategory) {
//        List<CodeAndDescription> result = null;
//        try {
//            if(mainCategory != null && preciseCategory!=null){
//                result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(o.code,o.description) "+
//                    " from RefOccPreciseCategory o where o.code = ?1 and o.refOccupationCategory.code = ?2")
//                            .setParameter(1,preciseCategory)
//                            .setParameter(2,mainCategory)
//                            .getResultList();
//                System.out.println("Result in findAllPreciseCategoryBasedOnMainCategory ============>"+result.toArray());
//            }
//        } catch (Exception nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//    
//    /**
//     * This method either loads list of all Precise categories or Precise categories based on category.
//     * @param category
//     * @return
//     */
//    public List<CodeAndDescription> findAllDistrictByRegionCode(String regCode){
//        List<CodeAndDescription> result = null;
//        try {
//            if(regCode != null){
//                result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(o.code,o.description) "+
//                    " from RefDistrict o where o.refRegion.code = ?1")
//                            .setParameter(1,regCode)
//                            .getResultList();
//            }
//        } catch (Exception nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//
//    /**
//     * This method either loads list of all Precise categories or Precise categories based on category.
//     * @param category
//     * @return
//     */
//    public List<CodeAndDescription> findAllBankBranches(Object bankName){
//        List<CodeAndDescription> result = null;
//        try {
//            if(bankName != null){
//                result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(o.code,o.description) "+
//                    " from RefBankBranch o where o.bank.code = ?1  or o.code=?2 order by o.description " )
//                            .setParameter(1,bankName)
//                            .setParameter(2,bankName)
//                            .getResultList();
//            }/*else{
//                result = new ArrayList<CodeAndDescription>();
//            }*/
//        } catch (Exception nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//        return result;
//    }
//    
//    /**
//     * This method will fetches ref reasons based on category.
//     * This method will accepts multiple categorys and returns all the reasons in refReason table based on category.
//     * @param code
//     * @param categoryTypes
//     * @return
//     */
//    public List<CodeAndDescription> findRefReasonsByCategorys(Object code, String[] categoryTypes) {
//        List<CodeAndDescription> result = null;
//        if (categoryTypes != null) {
//            try{
//                String valueForINClause = "(" + StringHelper.getSQLInClauseString(categoryTypes) + ")";
//                result = 
//                    em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " + 
//                       "from RefReason obj " + "where obj.status = ?1 and obj.category.code in " + 
//                       valueForINClause + 
//                       "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " + 
//                       "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.description Asc").setParameter(1, 
//                        Constants.RecordStatus.ACTIVE).getResultList();
//            }catch (javax.persistence.NoResultException e) {
//                result = new ArrayList<CodeAndDescription>();
//            }
//            if (!codeExist(result, code)) {
//                CodeAndDescription cad =
//                    executeGenericDropDownQuery(RefReason.class, code);
//                if (cad != null) {
//                    result.add(cad);
//                }
//            }
//        }        
//        return result; 
//    }
//    
//    public String findEntityTinByEntId(Long entId) { 
//        try {
//            String entityTin = (String)em.createQuery("select rt.tin " +
//                "from RegTaxpayer rt, RegTaxpayerEntity rte " +
//                "where rt.id = rte.id and rte.entId = ?1 and rte.registrationType = ?2")
//                .setParameter(1, entId).setParameter(2, Constants.TAXPAYER).getSingleResult();
//                                                                                                                              
//            return entityTin;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        
//        
//        }
//    }
//
//    public List<RefIdentifierType> findAllIdentifierTypes(Object code) {
//
//        List<RefIdentifierType> result = null;
//        try {
//
//            result = em.createNamedQuery("RefIdentifierType.findAll").getResultList();
//        } catch (Exception nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//       return result;
//    }
//    
//    public List<CodeAndDescription> findAllWithholdingTypeList() {
//        List<CodeAndDescription> result = null;
//        try {
//            result =
//                    em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code, obj.description)" +
//                                   " FROM RefWithholdingType obj ORDER BY obj.description").getResultList();
//            return result;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    

    public List<CodeAndDescription> findAllReturnType(String revenueType, Object code) {
        try {
            List<CodeAndDescription> result
                    = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(refReturnType.code,refReturnType.description) "
                            + "from RefReturnType refReturnType where refReturnType.status= ?1 and (refReturnType.expiryDate is NULL or "
                            + "refReturnType.expiryDate >= CURRENT_TIMESTAMP) and (refReturnType.effectiveDate is NULL or refReturnType.effectiveDate <= CURRENT_TIMESTAMP) and "
                            + "refReturnType.refRevType = ?2  order by refReturnType.description ").setParameter(1, Constants.RecordStatus.ACTIVE).setParameter(2, revenueType).getResultList();

            if (!codeExist(result, code)) {
                CodeAndDescription cad
                        = executeGenericDropDownQuery(RefReturnType.class, code);
                if (cad != null) {
                    result.add(cad);
                }
            }

            return result;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

//    public List<CodeAndDescription> findAllAttachmentTypesByTaxpayerType(String type) {
//        List<CodeAndDescription> result = null;
//        try {
//            result =
//                    em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code, obj.description)" +
//                                   " FROM RefEntAttType obj where obj.taxpayerType = ?1 ORDER BY obj.description")
//                                   .setParameter(1,type).getResultList();
//            return result;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    
//       
//    public List<CodeAndDescription> findAllFinancialDocumentTypes(Object code, String[] categoryTypes) {
//        List<CodeAndDescription> result = null;
//        if(categoryTypes != null){
//            String valueForINClause =  "(" + StringHelper.getSQLInClauseString(categoryTypes) + ")";
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//            "from RefDocType obj " +
//            "where obj.status = ?1 and obj.refDocCategory.code in " + valueForINClause +
//            "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
//            .setParameter(1,Constants.RecordStatus.ACTIVE)
//            .getResultList();
//        }
//    
//        if (!codeExist(result, code)) {
//            CodeAndDescription cad =
//                executeGenericDropDownQuery(RefDocType.class, code);
//            if (cad != null) {
//                result.add(cad);
//            }
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findAllAllocationTypes(Object code) {
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefAllocationType obj " +
//                           "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.code ").setParameter(1,
//                                                                                                                     Constants.RecordStatus.ACTIVE).getResultList();
//        if (!codeExist(result, code)) {
//            CodeAndDescription cad =
//                executeGenericDropDownQuery(RefAllocationType.class, code);
//            if (cad != null) {
//                result.add(cad);
//            }
//        }
//        return result;
//    }
//    
////    public List<CodeAndDescription> findAllAllocationMethods(Object code){
////        List<CodeAndDescription> result =
////            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
////                           "from RefAllocationMethod obj " +
////                           "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
////                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.code ").setParameter(1,
////                                                                                                                     Constants.RecordStatus.ACTIVE).getResultList();
////        if (!codeExist(result, code)) {
////            CodeAndDescription cad =
////                executeGenericDropDownQuery(RefAllocationMethod.class, code);
////            if (cad != null) {
////                result.add(cad);
////            }
////        }
////        return result;
////    }
//    
//    /**
//     * This method loads the data from REF_ADJUSTMENT_REASON table based on adjustment type.
//     * @param adjustmentType
//     * @return
//     */
//    public List<CodeAndDescription> findAdjustmentReasonsByType(Object adjustmentType) {
//        List<CodeAndDescription> result = 
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " + 
//               "from RefAdjustmentReason obj " + 
//               "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " + 
//               "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) "+
//               "and obj.adjustmentType.code = ?2 order by obj.code ")
//               .setParameter(1, Constants.RecordStatus.ACTIVE)
//               .setParameter(2, adjustmentType)
//               .getResultList();
//        
//        if (!codeExist(result, adjustmentType)) {
//            CodeAndDescription cad =
//                executeGenericDropDownQuery(RefAdjustmentReason.class, adjustmentType);
//            if (cad != null) {
//                result.add(cad);
//            }
//        }       
//        return result;
//    }
//    
////    public RefAllocationMethod getAllocationMethodByCode(String code){
////        RefAllocationMethod result = 
////            (RefAllocationMethod)em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " + 
////                                                "from RefAllocationMethod obj " + 
////                                                "where obj.code = ?1 ").setParameter(1, code).getSingleResult();
////        return result;
////    }
//    
//    public RefAllocationType getAllocationTypeByCode(String code){
//        RefAllocationType result = 
//            (RefAllocationType)em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " + 
//                                                "from RefAllocationType obj " + 
//                                                "where obj.code = ?1 ").setParameter(1, code).getSingleResult();
//        return result;
//    }
//    
//    /**
//     * This method is used to load tax types based on doctypes.
//     * @param docTypes
//     * @return
//     */
//    public List<CodeAndDescription> findTaxTypesByDocTypes(String[] docTypes) {
//        List<CodeAndDescription> result = null;
//        if(docTypes != null){
//            String valueForINClause =  "(" + StringHelper.getSQLInClauseString(docTypes) + ")";
//            result = em.createQuery("select distinct new com.crownagents.trips.dto.CodeAndDescription(obj.taxType.code, obj.taxType.description) " +
//                           "from RefDocTypeTaxTypeRel obj " +
//                           "where obj.status = ?1 and obj.docType.code in " + valueForINClause + 
//                           "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
//                           .setParameter(1,Constants.RecordStatus.ACTIVE)
//                           .getResultList();
////        } else {
////            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.taxType) " +
////                           "from RefDocTypeTaxTypeRel obj " +
////                           "where obj.status = ?1 " + 
////                           "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
////                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
////                           .setParameter(1,Constants.RecordStatus.ACTIVE)
////                           .getResultList();
//        }
//        
//        return result;
//    }
//    
//    public List<CodeAndDescription> findTaxTypesByTaxpayerTypes(String[] taxpayerTypes) {
//        List<CodeAndDescription> result = null;
//        if (taxpayerTypes.length == 2) {
//            result = em.createQuery("Select distinct new com.crownagents.trips.dto.CodeAndDescription(obj.code, obj.description) " +
//                            "from RefRevType obj " +
//                            "where obj.status = ?1 " +
//                            "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
//                            .setParameter(1, Constants.RecordStatus.ACTIVE)
//                            .getResultList();
//        } else if (taxpayerTypes.length == 1 && taxpayerTypes[0].equalsIgnoreCase(Constants.TaxpayerTypes.BUSINESS)) {
//            result = em.createQuery("Select distinct new com.crownagents.trips.dto.CodeAndDescription(obj.code, obj.description) " +
//                            "from RefRevType obj " +
//                            "where obj.status = ?1 " +
//                            "and obj.taxpayerType <> ?2 " +
//                            "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
//                            .setParameter(1, Constants.RecordStatus.ACTIVE)
//                            .setParameter(2, Constants.Entity.INDIVIDUAL_TYPE)
//                            .getResultList();
//        } else if (taxpayerTypes.length == 1 && taxpayerTypes[0].equalsIgnoreCase(Constants.TaxpayerTypes.INDIVIDUAL)) {
//            result = em.createQuery("Select distinct new com.crownagents.trips.dto.CodeAndDescription(obj.code, obj.description) " +
//                            "from RefRevType obj " +
//                            "where obj.status = ?1 " +
//                            "and obj.taxpayerType <> ?2 " +
//                            "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
//                            .setParameter(1, Constants.RecordStatus.ACTIVE)
//                            .setParameter(2, Constants.Entity.ORGANIZATION_TYPE)
//                            .getResultList();
//        }
//        return result;
//    }
//    
//    public List<CodeAndDescription> findEntityTypes(List<String> taxpayerTypes) {
//        List <CodeAndDescription> result = null;
//        String t= "(";
//        for (Iterator<String> it = taxpayerTypes.iterator(); it.hasNext();) {
//            String s = it.next();
//            t = t.concat("'" + s + "'");
//            if (it.hasNext())
//                t += ", ";
//        }
//        t += ")";
//        result = em.createQuery("Select distinct new com.crownagents.trips.dto.CodeAndDescription(obj.code, obj.description) " +
//                            "from RefEntityType obj " +
//                            "where obj.status = 'A' " +
//                            "   and obj.code IN " + t +
//                            "   and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                            "   and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
//                            .getResultList();
//        return result;
//    }
//   
//    public List<CodeAndDescription> loadRefPojoData(String refClass) {
//
//            List<CodeAndDescription> result =
//                em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " + "from " + refClass +
//                               " obj " +
//                               "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                               "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) ").setParameter(1,
//                                                                Constants.RecordStatus.ACTIVE).getResultList();
//            return result;
//     
//    }
//
//    public List<RefOffStaff> findUnallocatedOfficersForCashOffice (String officeId) {
//         List<RefOffStaff> refOffStaffList = null;
//         try{
//             refOffStaffList = (List<RefOffStaff>)em.createQuery("select o from RefOffStaff o where o.id not in (select o1.refOffStaff.id from RevCollCashOfficeUsers o1 where o1.role = 'CashOfficer') and o.status = 'A' and o.refOffice.code = ?1").setParameter(1, officeId).getResultList();
//         } catch (Exception nre) {
//               return null;
//         }
//         
//         return refOffStaffList;       
//     }
//     
//  
//     
//    public List<RefOffStaff> findAllStaff(Object code) {
//
//        List<RefOffStaff> refOffStaffList = null;
//        try {
//            refOffStaffList = 
//                    (List<RefOffStaff>)em.createNamedQuery("RefOffStaff.findAll").getResultList();
//        } catch (Exception nre) {
//            return null;
//        }
//
//        return refOffStaffList;
//    }
//    
//    public List<RefOffStaff> findStaffByName(String name) {
//        List<RefOffStaff> result = new ArrayList<RefOffStaff>();
//        try {
//            result = 
//                    em.createQuery("select obj from RefOffStaff obj where obj.status = ?1 and obj.username =?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) ").setParameter(1, 
//                                                                                                                                                                                                   Constants.RecordStatus.ACTIVE).setParameter(2, 
//                                                                                                                                                                                                                                               name).getResultList();
//
//        } catch (javax.persistence.NoResultException nre) {
//            return null;
//        }
//
//        return result;
//    }
//    
    public List<CodeAndDescription> findReturnTypeByRevType(String revType) {
        List<CodeAndDescription> result = null;
        try {
            result
                    = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.code, obj.description)"
                            + " FROM RefReturnType obj where obj.refRevType =?1 and obj.status = ?2 ORDER BY obj.description").setParameter(1, revType)
                    .setParameter(2, Constants.RecordStatus.ACTIVE)
                    .getResultList();
            return result;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

//    public List<CodeAndDescription> findWithHoldingType(String code) {
//            if(code == null)
//                return null;
//            List<CodeAndDescription> result =
//                em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                               "from RefWithholdingType obj " +
//                               "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                               "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) " +
//                               "and obj.category = ?2 order by obj.description Asc").setParameter(
//                                1, Constants.RecordStatus.ACTIVE).setParameter(
//                                2, code).setHint(TopLinkQueryHints.CACHE_USAGE,
//                                CacheUsage.CheckCacheThenDatabase).getResultList();
//       
//            return result;
//           
//  
//        }
//        
//
//        public List<String> findWithHoldingTypeCodes(String category) {
//                if(category == null)
//                    return null;
//                List<String> result =
//                    em.createQuery("select obj.code " +
//                                   "from RefWithholdingType obj " +
//                                   "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                                   "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) " +
//                                   "and obj.category = ?2 order by obj.description Asc").setParameter(
//                                    1, Constants.RecordStatus.ACTIVE).setParameter(
//                                    2, category).setHint(TopLinkQueryHints.CACHE_USAGE,
//                                    CacheUsage.CheckCacheThenDatabase).getResultList();
//           
//                return result;
//               
//        
//            }
//
//        
//    public String findQuarter(BigDecimal quarterNo) {
//         if(quarterNo == null)
//             return null;
//               List<CodeAndDescription> result =
//             em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                            "from RefQuarters obj " +
//                            "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) " +
//                            "and obj.orderSeq = '"+quarterNo+"' order by obj.description Asc").setParameter(
//                             1, Constants.RecordStatus.ACTIVE).setHint(TopLinkQueryHints.CACHE_USAGE,
//                             CacheUsage.CheckCacheThenDatabase).getResultList();
//    
//         return result.get(0).getCode().toString();
//     }
//	    public  List<RefQuarters> findQuarters(BigDecimal quarterNo) {
//         if(quarterNo == null)
//             return null;
//         List<RefQuarters> result = new ArrayList<RefQuarters>();
//              result =
//             em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                            "from RefQuarters obj " +
//                            "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                            "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) " +
//                            "and obj.orderSeq = '"+quarterNo+"' order by obj.description Asc").setParameter(
//                             1, Constants.RecordStatus.ACTIVE).setHint(TopLinkQueryHints.CACHE_USAGE,
//                             CacheUsage.CheckCacheThenDatabase).getResultList();
//    
//         return result;
//         
//     }
//   
//    /**
//     * This method load users associated to group.
//     * @param groupName
//     * @return
//     */
//    public List<CodeAndDescription> findUsersInGroup(String groupName){
//        List<CodeAndDescription> result = null;
//        try {
//            if(null!=groupName) {
//            result =   em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.grantid, obj.userMember)" +
//                " FROM WfisPolicyT obj where obj.role =?1 and obj.userMember is not null ORDER BY obj.userMember")
//                .setParameter(1,groupName).getResultList();
//            } else {
//                result =   em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.grantid, obj.userMember)" +
//                    " FROM WfisPolicyT obj where obj.userMember is not null ORDER BY obj.userMember").getResultList();
//            }
//            return result;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//
//    public List<CodeAndDescription> findLegalStatusByTaxpayerType(String taxpayerType) {
//
//        List<CodeAndDescription> result = new ArrayList<CodeAndDescription>();
//        List<RefLegalStatusType> tempList = 
//            em.createQuery("select obj " + "from RefLegalStatusType obj " + 
//                           "where obj.status = ?1 and obj.taxpayerType = ?2 or obj.taxpayerType = 'Both' " + 
//                           "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " + 
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.description").
//                           setParameter(1, Constants.RecordStatus.ACTIVE).setParameter(2,taxpayerType).getResultList();
//        for (RefLegalStatusType legalstatus: tempList) {
//            result.add(new CodeAndDescription(legalstatus.getCode(), 
//                                              legalstatus.getDescription()));
//
//        }
//        return result;
//    }
//
//    public List<CodeAndDescription> findAllEvtType(){
//        List<CodeAndDescription> result = null;
//
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(o.code,o.description) "+
//                " from RefEvtType o where o.status = ?1").setParameter(1,Constants.RecordStatus.ACTIVE).getResultList();
//        } catch (Exception nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//
//        return result;
//    }
//    /**
//     * This method returns description based on code from specified reference table.
//     * @param entityName
//     * @param code
//     * @return
//     */
//    public String findDescByCodeFromRefTable(String entityName, String code) {
//        try {
//            String value = (String)em.createQuery("select obj.description from " + entityName +                    
//                   " obj where obj.code = ?1 and obj.status = ?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " + 
//                   " and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP)")
//                   .setParameter(1, code).setParameter(2, Constants.RecordStatus.ACTIVE).getSingleResult();
//            return value;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    
//    public List<RefOffPrinters> findPrintersByOffice(String officeId){
//        
//        return em.createQuery("Select o from RefOffPrinters o where o.refOffice.code=?1").setParameter(1,officeId).getResultList();
//        
//    }
//    public List<CodeAndDescription> findAllMonthsOfYear(){
//		List<CodeAndDescription> result = null;
//
//        try {
//            result = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(o.code,o.description) "+
//                " from RefMonthOfYear o where o.status = ?1 ").setParameter(1,Constants.RecordStatus.ACTIVE).getResultList();
//        } catch (Exception nre) {
//            log.error(nre.getLocalizedMessage(), nre);
//            return null;
//        }
//	    Collections.sort(result, new CodeAndDescriptionOrderByCodeAndNumber());
//        return result;
//	}
//	
//	public class CodeAndDescriptionOrderByCodeAndNumber implements Comparator<CodeAndDescription>{
//
//        public int compare(CodeAndDescription o1, CodeAndDescription o2) {
//            return (new Integer(o1.getCode().toString())).compareTo((new Integer(o2.getCode().toString())));
//        }
//    }
//    public List<CodeAndDescription> findRefOwnerShipDetailsExceptOthers() {
//         List<CodeAndDescription> refOwnerList = null;
//         try{
//             refOwnerList = em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(o.code,o.description) "+
//                " from RefOwnershipType o where o.status = ?1 and o.code not in('Other')").setParameter(1,Constants.RecordStatus.ACTIVE).getResultList();
//         } catch (Exception nre) {
//               return null;
//         }
//         
//         return refOwnerList;       
//     }
//    /**
//     * This method will give us list of business sectors in the form of code and description.
//     * Here description is the combination of code and description.
//     * @param code
//     * @return
//     */
//    public List<CodeAndDescription> findAllRefRiskPoints() {
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefRiskPoints obj " +
//                           "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.orderSeq ").setParameter(1,
//                                                                                                                     Constants.RecordStatus.ACTIVE).getResultList();
//        return result;
//    }
//    
//    /**
//     * This method will give us list of fields to be ignored for comparison in the form of code and description.
//     * @param code
//	 * @param ignoreCategory
//     * @return
//     */
//    public List<CodeAndDescription> findAllIgnoreFieldByCategory(Object code,String ignoreCategory){
//           try {
//               List<CodeAndDescription> result = 
//                   em.createQuery("SELECT new com.crownagents.trips.dto.CodeAndDescription(ref.code,ref.description) FROM RefIgnoreField ref " +
//                   " WHERE ref.status =?1 " + 
//                   " AND ref.category.code =?2 AND (ref.expiryDate is NULL or ref.expiryDate >= CURRENT_TIMESTAMP) and (ref.effectiveDate is NULL or ref.effectiveDate <= CURRENT_TIMESTAMP)").setParameter(1, 
//                                                                                                     Constants.ACTIVE).setParameter(2, 
//                                                                                                     ignoreCategory).getResultList();
//               if (!codeExist(result, code)) {
//               
//               CodeAndDescription cad =
//               executeGenericDropDownQuery(RefIgnoreField.class, code);
//               if (cad != null) {
//               result.add(cad);
//               }
//               }
//               
//               return result;
//           } catch (Exception e) {
//               log.error(e.getLocalizedMessage(), e);
//               return null;
//           }
//       }
//       
//    public List<CodeAndDescription> findGroupsByCategory(String category){
//              List<CodeAndDescription> result = new ArrayList<CodeAndDescription>();
//              List<WfisGroupCategoryT> groupCategoryList = new ArrayList<WfisGroupCategoryT>();
//
//              try {
//                  groupCategoryList = em.createNamedQuery("WfisGroupCategoryT.findGroupsByCategory").setParameter(1,category).getResultList();
//              } catch (Exception nre) {
//                  log.error(nre.getLocalizedMessage(), nre);
//                  return null;
//              }
//              
//              if(groupCategoryList!=null && groupCategoryList.size()>0){
//                  for(WfisGroupCategoryT wfisGroupCategoryT : groupCategoryList){
//                      if(wfisGroupCategoryT.getGroup()!=null){
//                          result.add(new CodeAndDescription(wfisGroupCategoryT.getGroup().getName(), 
//                                                            wfisGroupCategoryT.getGroup().getDescription()));
//                      }
//                  }
//              }
//
//              return result;
//          }
//
//          
//          
//    public List<CodeAndDescription> findAllRefFrequency(Object code, String frequencyCategory){
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefFrequency obj " +
//                           "where obj.status = ?1 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) " +
//                           "and obj.frequencyCategory=?2 order by obj.orderSeq ").setParameter(1,Constants.RecordStatus.ACTIVE).setParameter(2,frequencyCategory).getResultList();
//        return result;
//    }    
//
//          
//    public List<CodeAndDescription> findAllRejectionCode(Object code,
//                                                   String filter) {
//        List<CodeAndDescription> result =
//            em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " +
//                           "from RefRejectionCode obj " +
//                           "where obj.status = ?1 and obj.category.code = ?2 and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " +
//                           "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.description Asc").setParameter(1,
//                                                                                                                     Constants.RecordStatus.ACTIVE).setParameter(2,
//                                                                                                                                                         filter).getResultList();
//
//        if (!codeExist(result, code)) {
//            CodeAndDescription cad =
//                executeGenericDropDownQuery(RefRejectionCode.class, code);
//            if (cad != null) {
//                result.add(cad);
//            }
//        }
//        
//        return result;
//    }
    public Serializable find(Object code, DataReference dataReference) {

        try {
            return (Serializable) em.createQuery("select obj from "
                    + dataReference.getDataType().getSimpleName() + " obj where obj.code = ?1").setParameter(1,
                            code).getSingleResult();
            //return value;

        } catch (javax.persistence.NoResultException e) {
            return null;

        }
    }
    
        /**
     * This method will fetches ref reasons based on category.
     * This method will accepts multiple categorys and returns all the reasons in refReason table based on category.
     * @param code
     * @param categoryTypes
     * @return
     */
    public List<CodeAndDescription> findRefReasonsByCategorys(Object code, String[] categoryTypes) {
        List<CodeAndDescription> result = null;
        if (categoryTypes != null) {
            try{
                String valueForINClause = "(" + StringHelper.getSQLInClauseString(categoryTypes) + ")";
                result = 
                    em.createQuery("select new com.crownagents.trips.dto.CodeAndDescription(obj.code,obj.description) " + 
                       "from RefReason obj " + "where obj.status = ?1 and obj.category.code in " + 
                       valueForINClause + 
                       "and (obj.expiryDate is NULL or obj.expiryDate >= CURRENT_TIMESTAMP) " + 
                       "and (obj.effectiveDate is NULL or obj.effectiveDate <= CURRENT_TIMESTAMP) order by obj.description Asc").setParameter(1, 
                        Constants.RecordStatus.ACTIVE).getResultList();
            }catch (javax.persistence.NoResultException e) {
                result = new ArrayList<>();
            }
            if (!codeExist(result, code)) {
                CodeAndDescription cad =
                    executeGenericDropDownQuery(RefReason.class, code);
                if (cad != null) {
                    result.add(cad);
                }
            }
        }        
        return result; 
    }

}
