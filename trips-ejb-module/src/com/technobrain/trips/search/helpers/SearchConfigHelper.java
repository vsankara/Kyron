package com.technobrain.trips.search.helpers;

import com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBRemote;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.CopyHelper;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.common.helpers.search.SearchActionInfo;
import com.technobrain.trips.common.helpers.search.SearchCriteriaFieldInfo;
import com.technobrain.trips.common.helpers.search.SearchInfo;
import com.technobrain.trips.common.helpers.search.SearchOrderByInfo;
import com.technobrain.trips.common.helpers.search.SearchQueryInjection;
import com.technobrain.trips.common.helpers.search.SearchResultFieldInfo;
import com.technobrain.trips.common.helpers.search.SearchTrigger;
import com.technobrain.trips.common.helpers.xml.ConfigurationHelper;
import com.technobrain.trips.common.helpers.xml.XMLAccessException;
import com.technobrain.trips.dto.CodeAndDescription;
import com.technobrain.trips.locator.ServiceLocator;
import com.technobrain.trips.locator.ServiceLocatorException;
import com.technobrain.trips.search.model.SearchConfig;
import com.technobrain.trips.search.service.SearchFacadeRemote;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.ejb.EJB;
import javax.ejb.EJBs;

import org.apache.log4j.Logger;

/**
 * Crown Agents 2007
 * <br>
 * Builds and Manages the critera selected to represent a native sql
 * query.
 * @since $Date: 1/18/2010 7:09:49 AM$
 * @version $Revision: 3$
 * @author $Author: Vythilingam Pirabaharan$
 *
 * $Log[1]:
 *  3    TRIPS2 etis.bir.gov.ph1.2         1/18/2010 7:09:49 AM   Vythilingam
 *       Pirabaharan Updated loadSearchConfig and loadAllSearchConfig
 * $
 */
 @EJBs( { 
 @EJB(   name = "SearchFacade/local", 
         beanInterface = SearchFacadeRemote.class, 
         beanName = "SearchFacade"),
         @EJB(   name = "RefCodeAssemblerSessionEJB/local", 
         beanInterface = RefCodeAssemblerSessionEJBRemote.class,  
         beanName = "RefCodeAssemblerSessionEJB")
 })
public class SearchConfigHelper {
    public static final Logger log = Logger.getLogger(SearchConfigHelper.class);
    private static final String searchFilename = "search.config.xml,core-search-config.xml,registration-search-config.xml," +
                                                 "collection-search-config.xml,tas-search-config.xml,refund-search-config.xml,compliance-search-config.xml,"+
                                                 "script-search-config.xml";
    private static HashMap<String, Object> searchParams = new HashMap<String, Object>();
    

//    static {
//        loadAllSearchConfig(true);
//    }
    
    public static SearchInfo getSearchInfo(String searchId) {
        SearchInfo info = (SearchInfo)searchParams.get(searchId);
        if(info == null) {
            RefCodeAssemblerSessionEJBRemote refCodes = null;
            try {
                refCodes = (RefCodeAssemblerSessionEJBRemote)new ServiceLocator().getRemoteEJB(ServiceLocator.Services.REF_CODE_ASS);
            } catch (ServiceLocatorException e) {
                log.error(e.getLocalizedMessage(), e);
            }        
            String loadFromDB = refCodes.findSystemParameter(Constants.SystemParameterCode.LOAD_GENERIC_SEARCH_FROM_DB);
            
            info = getSearchInfo(searchId, loadFromDB,null);
        }
        return (SearchInfo)CopyHelper.deepCopy(info);
    }
    
    public static SearchInfo getSearchInfo(String searchId,String replacementTable ) {
        SearchInfo info = (SearchInfo)searchParams.get(searchId);
        if(info == null) {
            RefCodeAssemblerSessionEJBRemote refCodes = null;
            try {
                refCodes = (RefCodeAssemblerSessionEJBRemote)new ServiceLocator().getRemoteEJB(ServiceLocator.Services.REF_CODE_ASS);
            } catch (ServiceLocatorException e) {
                log.error(e.getLocalizedMessage(), e);
            }        
            String loadFromDB = refCodes.findSystemParameter(Constants.SystemParameterCode.LOAD_GENERIC_SEARCH_FROM_DB);
            
            info = getSearchInfo(searchId, loadFromDB,replacementTable);
        }
        return CopyHelper.deepCopy(info);
    }
    
    //TODO This is a workaround until a solution found for lookup failure issue described on TRGHA-5494, this will be
    //removed/changed based on the solution to TRGHA-5494
    public static SearchInfo getSearchInfoDirectFromDB(SearchFacadeRemote searchFacade, String searchId) {
        SearchInfo info = (SearchInfo)searchParams.get(searchId);
        if(info == null) {
            loadSearchConfigDirectFromDB(searchFacade, searchId, null);
            info = (SearchInfo)searchParams.get(searchId);
        }
        return CopyHelper.deepCopy(info);
    }    
    
    
    public static void removeSearchInfo(String searchId) {
        searchParams.remove(searchId);
    }
    
    public static void loadSearchConfig(boolean isDBEnabled, String searchId, String replacementTable) {
        if(isDBEnabled){
            // load the search config if not already loaded.. load and then fetch
            SearchFacadeRemote searchFacade =
                (SearchFacadeRemote)new ServiceLocator().getRemoteEJB(ServiceLocator.Services.SEARCH_SERVICE);
            SearchConfig result = searchFacade.loadSearchConfigBySearchId(searchId);
            // check if the search is already loaded if not load in memory.
            if(result != null && result.getConfiguration() != null){
                loadSearchConfig(new String( result.getConfiguration()), replacementTable );
            }            
        }else{
            String[] files = searchFilename.split(",");
            for(int i=0; i<files.length;i++){
                loadSearchConfigFromFile(files[i], searchId, replacementTable);
            }
        }        
    }
    //TODO This is a workaround until a solution found for lookup failure issue described on TRGHA-5494, this will be
    //removed/changed based on the solution to TRGHA-5494
    public static void loadSearchConfigDirectFromDB(SearchFacadeRemote searchFacade, String searchId, String replacementTable) {
            // load the search config if not already loaded.. load and then fetch
            SearchConfig result = searchFacade.loadSearchConfigBySearchId(searchId);
            // check if the search is already loaded if not load in memory.
            if(result != null && result.getConfiguration() != null){
                loadSearchConfig(new String( result.getConfiguration()) , replacementTable);
            }            
    }    
    
    public static void loadSearchConfigFromFile(String searchFilename, String searchId, String replacementTable) {
        try {
            ConfigurationHelper configurationHelper;
            configurationHelper = new ConfigurationHelper("/searchList/search");
            InputStream searchFilenameStream = 
                Thread.currentThread().getContextClassLoader().getResourceAsStream(searchFilename);
            configurationHelper.createDom(searchFilenameStream);
            int eachEntry = 1;
            while (eachEntry > 0) {
                if (configurationHelper.pathExists()) {
                    String id = configurationHelper.getElement("id");
                    if(id.equals(searchId)) {
                        buildSearchInfo(id, eachEntry, configurationHelper, replacementTable);
                    }

                    eachEntry++;
                } else {
                    eachEntry = -1;
                }
            
                configurationHelper.setPath("[" + String.valueOf(eachEntry) + "]");
                if (configurationHelper.pathExists()) {
                    buildSearchInfo(eachEntry,configurationHelper, replacementTable);
                    eachEntry ++;
                }else{
                    eachEntry =-1;
                }
            }
            
        } catch (XMLAccessException exp) {
            log.error(exp.getLocalizedMessage(), exp);
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (NoSuchFieldException nsfe) {
            log.error(nsfe.getLocalizedMessage(), nsfe);
        } catch (ClassNotFoundException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    public static void loadAllSearchConfig(boolean isDBEnabled, String replacementTable) {
        if(isDBEnabled){
            SearchFacadeRemote searchFacade =
                (SearchFacadeRemote)new ServiceLocator().getRemoteEJB(ServiceLocator.Services.SEARCH_SERVICE);
            List<SearchConfig> searchList = searchFacade.loadAllSearchConfig();
            if(searchList != null){
                for(int i=0; i<searchList.size(); i++){
                    SearchConfig search = searchList.get(i);
                    if(search != null && search.getConfiguration() != null){
                        loadSearchConfig(new String(search.getConfiguration()), replacementTable);
                    }    
                }
            }
        }else{
            String[] files = searchFilename.split(",");
            for(int i=0; i<files.length;i++){
                loadAllSearchConfigFromFile(files[i], replacementTable);
            }
        }
    } 

    private static void loadAllSearchConfigFromFile(String searchFilename, String replacementTable) {
        try {
            ConfigurationHelper configurationHelper;
            configurationHelper = new ConfigurationHelper("/searchList/search");
            InputStream searchFilenameStream = 
                Thread.currentThread().getContextClassLoader().getResourceAsStream(searchFilename);
            configurationHelper.createDom(searchFilenameStream);
            int eachEntry = 1;
            while (eachEntry > 0) {
                configurationHelper.setPath("[" + String.valueOf(eachEntry) + "]");
                if (configurationHelper.pathExists()) {
                    buildSearchInfo(eachEntry,configurationHelper, replacementTable);
                    eachEntry ++;
                }else{
                    eachEntry =-1;
                }
            }
            
        } catch (XMLAccessException exp) {
            log.error(exp.getLocalizedMessage(), exp);
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (NoSuchFieldException nsfe) {
            log.error(nsfe.getLocalizedMessage(), nsfe);
        } catch (ClassNotFoundException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
    
    public static SearchInfo getSearchInfoFromXML(String searchId, String searchXML){
        loadSearchConfig(searchXML, null);
        return (SearchInfo)searchParams.get(searchId);
    }
    
    public static SearchInfo getSearchConfigFromFile(String searchId){
        loadSearchConfig(false, searchId, null);
        return (SearchInfo)searchParams.get(searchId);
    }
    
    
    public static void loadSearchConfig(String searchXML, String replacementTable) {
        try {
            ConfigurationHelper configurationHelper;
            configurationHelper = new ConfigurationHelper("/search");
            configurationHelper.createDomFromString(searchXML);
            int eachEntry = 1;
            configurationHelper.setPath("[" + String.valueOf(eachEntry) + "]");
            if (configurationHelper.pathExists()) {
                buildSearchInfo(eachEntry,configurationHelper, replacementTable);
            }
        } catch (XMLAccessException exp) {
            log.error(exp.getLocalizedMessage(), exp);
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (NoSuchFieldException nsfe) {
            log.error(nsfe.getLocalizedMessage(), nsfe);
        } catch (ClassNotFoundException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
    
    private static void buildSearchInfo(int eachEntry, 
                                            ConfigurationHelper configurationHelper, String replacementTable) throws XMLAccessException, 
                                                        ClassNotFoundException, 
                                                        NoSuchFieldException, 
                                                        IllegalAccessException {

        String id = configurationHelper.getElement("id");
        buildSearchInfo(id, eachEntry, configurationHelper, replacementTable);
    }
    
    private static void buildSearchInfo(String id, int eachEntry, 
                                            ConfigurationHelper configurationHelper, String replacementTable) throws XMLAccessException, 
                                                        ClassNotFoundException, 
                                                        NoSuchFieldException, 
                                                        IllegalAccessException {

        String sectionHeading = 
            "SearchConfig." + id + ".SectionHeading";
        //                        configurationHelper.getElement("sectionHeading");
        String windowHeading = 
            configurationHelper.getElement("windowHeading");
        String advancedSearchAvailable = 
            configurationHelper.getElement("advancedSearchAvailable");
        String multiAdvancedSearchAvailable = 
            configurationHelper.getElement("multiAdvancedSearchAvailable");
        
        multiAdvancedSearchAvailable = 
                multiAdvancedSearchAvailable == null ? "N" : 
                multiAdvancedSearchAvailable;
        
        String advancedSectionHeading = 
            configurationHelper.getElement("advancedSectionHeading");
        
        String primaryTableName = 
            configurationHelper.getElement("primaryTableName");
        
        String joinQuery = 
            configurationHelper.getElement("joinQuery");
        String queryType = 
            configurationHelper.getElement("queryType");
        
        String showCreateNewButton = 
            configurationHelper.getElement("showCreateNewButton");
        
        String supportsMultiQueryInjections = 
            configurationHelper.getElement("supportsMultiQueryInjections");
        
        String multiSearchFieldColumnName = 
            configurationHelper.getElement("multiSearchFieldColumnName");
        
        
        SearchInfo searchInfo = 
            new SearchInfo(id, sectionHeading, windowHeading, 
                           joinQuery);
        searchInfo.setMultiSearchFieldColumnName(multiSearchFieldColumnName);
        searchInfo.setAdvancedSearchHeading(advancedSectionHeading == 
                                            null ? 
                                            "Advanced Search" : 
                                            advancedSectionHeading);
        searchInfo.setPrimaryTableName(primaryTableName);
        searchInfo.setAdvancedSearchAvailable(advancedSearchAvailable == 
                                              null ? "N" : 
                                              advancedSearchAvailable);
        searchInfo.setMultiAdvancedSearchAvailable(multiAdvancedSearchAvailable);
        searchInfo.setShowCreateNewButton(showCreateNewButton == 
                                          null ? "N" : 
                                          showCreateNewButton);
        searchInfo.setSupportsMultiQueryInjections(supportsMultiQueryInjections == 
                                                   null ? "N" : 
                                                   supportsMultiQueryInjections);
        searchParams.put(id, searchInfo);
        
        String commonPath = "[" + String.valueOf(eachEntry);
        String criteriaFieldPath = commonPath  + "]/criteriaFields";
        String advancedCriteriaFieldPath = commonPath + "]/advancedCriteriaFields";
        String resultFieldPath = commonPath + "]/resultFields";
        
        if(multiAdvancedSearchAvailable.equalsIgnoreCase(Constants.YES) || 
             multiAdvancedSearchAvailable.equalsIgnoreCase("YES") || 
             multiAdvancedSearchAvailable.equalsIgnoreCase(Constants.SPOTLIGHT) ||
            multiAdvancedSearchAvailable.equalsIgnoreCase(Constants.BOTH) ||
             multiAdvancedSearchAvailable.equalsIgnoreCase(Constants.BASIC)) {
        
            ArrayList multiSearchAttributeList = new ArrayList();
            searchInfo.setAdvancedSearchFields(getMultiAdvancedCriteriaFieldList(commonPath,eachEntry, 
                                                                                 configurationHelper, 
                                                                                 multiSearchAttributeList, 
                                                                                 id));
            searchInfo.setAdvancedResultFields(getMultiResultFields(commonPath,eachEntry, 
                                                                    configurationHelper, 
                                                                    id));
        
            // in case the search results are not available for all the "forFields"
             TreeMap resultFields = 
                 getResultFieldList(resultFieldPath, eachEntry, configurationHelper, 
                                          id);
            searchInfo.setResultFields(resultFields);
        
            if (multiSearchAttributeList != null && 
                multiSearchAttributeList.size() > 0) {
                searchInfo.setMultiAdvancedPanalNameList(multiSearchAttributeList);
            }
        
        
            //TODO change code to accept this value from the search config                        
            //                        SearchCriteriaFieldInfo tempScInfo = new SearchCriteriaFieldInfo("forField_field","string","",multiSearchFieldColumnName,"");
            //                        tempScInfo.setOptions(multiSearchAttributeList);
            //                        tempScInfo.setListId("");
            //
            TreeMap seMap = new TreeMap();
            seMap = getCriteriaFieldList(criteriaFieldPath, eachEntry, configurationHelper, 
                                           "", id);
            //                        seMap.put("entityType",tempScInfo);
            searchInfo.setSearchFields(seMap);
        
            //                        Iterator it = searchInfo.getAdvancedSearchFields().keySet().iterator();
            //                        while (it.hasNext()) log.debug("keys ---" + it.next());
        
            if(searchInfo.getMultiAdvancedSearchAvailable().equals(Constants.SPOTLIGHT)){
                TreeMap criteriaFields = 
                    getCriteriaFieldList(criteriaFieldPath, eachEntry, configurationHelper, 
                                               "", id);
                searchInfo.setSearchFields(criteriaFields);
            }
        
        } else {
            TreeMap criteriaFields = 
                getCriteriaFieldList(criteriaFieldPath, eachEntry, configurationHelper, 
                                           "", id);
            searchInfo.setSearchFields(criteriaFields);
        
            TreeMap advancedCriteriaFields = 
                getCriteriaFieldList(advancedCriteriaFieldPath, eachEntry, configurationHelper, 
                                           "", id);
            searchInfo.setAdvancedSearchFields(advancedCriteriaFields);
            
            TreeMap resultFields = 
                getResultFieldList(resultFieldPath, eachEntry, configurationHelper, 
                                         id);
            searchInfo.setResultFields(resultFields);
            //                        searchInfo.setFuzzySearchCriteria(getFuzzySearchCriteriaFieldByPath(
            //                            eachEntry, configurationHelper));                                             
        }
        
        String actionsPath = commonPath + "]/actions";
        TreeMap actions = getActions(actionsPath,configurationHelper);
        searchInfo.setSearchActions(actions);
        
        String tablePath = commonPath + "]/searchTables";
        
        if(multiAdvancedSearchAvailable != null && multiAdvancedSearchAvailable.equalsIgnoreCase(Constants.MINI_SPOTLIGHT)){
            TreeMap searchTablesWithAlias = getSearchTablesForMiniSpotLight(configurationHelper, tablePath);
            searchInfo.setSearchTablesForMiniSpotLight(searchTablesWithAlias);
        }else{
            TreeMap searchTables = getSearchTables(configurationHelper, tablePath, replacementTable);
            searchInfo.setSearchTables(searchTables);
        }
        
        String dynamicQueryInjectionPath = commonPath + "]/dynamicQueryInjections";
        ArrayList dynamicQueryInjection = getDynamicQueryInjection(dynamicQueryInjectionPath,eachEntry,configurationHelper, replacementTable);
        searchInfo.setSearchInjectedQuerys(dynamicQueryInjection);
        
        String orderByFieldsPath = commonPath + "]/orderByFields";
        TreeMap orderList = getOrderByFieldList(orderByFieldsPath,configurationHelper);
        searchInfo.setOrderByFields(orderList);
        
        searchInfo.setQueryType(queryType);
    }

    /**
     * @param path
     * @param eachEntry
     * @param configurationHelper
     * @param multiSearchAttributeList
     * @param searchFieldId
     * @return
     * @throws XMLAccessException
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static TreeMap getMultiAdvancedCriteriaFieldList(String path,int eachEntry, 
                                                             ConfigurationHelper configurationHelper, 
                                                             ArrayList multiSearchAttributeList, 
                                                             String searchFieldId) throws XMLAccessException, 
                                                                                          ClassNotFoundException, 
                                                                                          NoSuchFieldException, 
                                                                                          IllegalAccessException {
        int eachFieldEntry = 1;
        TreeMap multiCriteriaFields = new TreeMap();
        while (eachFieldEntry > 0) { 
            configurationHelper.setPath(path + 
                                        "]/advancedCriteriaFields[" + 
                                        String.valueOf(eachFieldEntry) + "]");
            if (configurationHelper.pathExists()) {
                String forField = configurationHelper.getAttribute("forField");
                multiSearchAttributeList.add(new CodeAndDescription(forField, 
                                                                    "SearchConfig." + 
                                                                    searchFieldId + 
                                                                    ".CriteriaFields.forField." + 
                                                                    forField));
                String criteriaPath = path+ 
                    "]/advancedCriteriaFields[@forField='" + forField + "']";

                TreeMap criteriaFields = 
                    getCriteriaFieldList(criteriaPath, eachEntry, 
                                               configurationHelper, forField, 
                                               searchFieldId);
                multiCriteriaFields.put(forField, criteriaFields);

                eachFieldEntry++;
            } else {
                eachFieldEntry = -1;
            }
        }
        return multiCriteriaFields;
    }


    /**
     * @param path
     * @param eachEntry
     * @param configurationHelper
     * @param searchFieldId
     * @return
     * @throws XMLAccessException
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static TreeMap getMultiResultFields(String path,int eachEntry, 
                                                ConfigurationHelper configurationHelper, 
                                                String searchFieldId) throws XMLAccessException, 
                                                                             ClassNotFoundException, 
                                                                             NoSuchFieldException, 
                                                                             IllegalAccessException {
        int eachResultFieldEntry = 1;
        TreeMap multiCriteriaFields = new TreeMap();
        ArrayList attributeList = new ArrayList();
        while (eachResultFieldEntry > 0) {
            configurationHelper.setPath(path + 
                                        "]/advancedResultFields[" + 
                                        String.valueOf(eachResultFieldEntry) + 
                                        "]");
            if (configurationHelper.pathExists()) {
                String forField = configurationHelper.getAttribute("forField");
                attributeList.add(forField);

                String resultPath = path + 
                    "]/advancedResultFields[@forField='" + forField + "']";

                TreeMap resultFields = 
                    getResultFieldList(resultPath, eachEntry, 
                                             configurationHelper, 
                                             searchFieldId);
                multiCriteriaFields.put(forField, resultFields);

                eachResultFieldEntry++;
            } else {
                eachResultFieldEntry = -1;
            }
        }
        return multiCriteriaFields;
    }


    /**
     * @param path
     * @param eachFieldEntry
     * @param configurationHelper
     * @return
     * @throws XMLAccessException
     */
    private static ArrayList getOptions(String path,int eachFieldEntry, 
                                        ConfigurationHelper configurationHelper) throws XMLAccessException {
        int eachOptionFieldEntry = 1;
        ArrayList options = new ArrayList();
        
        while (eachOptionFieldEntry > 0) {
            configurationHelper.setPath(path + "/field[" + 
                                        String.valueOf(eachFieldEntry) + 
                                        "]/options/option[" + 
                                        eachOptionFieldEntry + "]");
            if (configurationHelper.pathExists()) {
                String value = configurationHelper.getElement("value");
                String text = configurationHelper.getElement("text");
                CodeAndDescription codeAndDescription = 
                    new CodeAndDescription(value, text);
                options.add(codeAndDescription);
                eachOptionFieldEntry++;
            } else {
                eachOptionFieldEntry = -1;
            }
        }
        return options;
    }

    /**
     * @param path
     * @param eachFieldEntry
     * @param configurationHelper
     * @return
     * @throws XMLAccessException
     */
    private static List<SearchTrigger> getSearchTriggers(String path,
                                                         int eachFieldEntry, 
                                                         ConfigurationHelper configurationHelper) throws XMLAccessException {
        int eachSearchTriggerEntry = 1;
        List<SearchTrigger> searchTriggers = new ArrayList<SearchTrigger>();
        while (eachSearchTriggerEntry > 0) {
            configurationHelper.setPath(path + 
                                        "/field[" + 
                                        String.valueOf(eachFieldEntry) + 
                                        "]/triggers/trigger[" + 
                                        eachSearchTriggerEntry + "]");
            if (configurationHelper.pathExists()) {
                String triggeringFieldName = 
                    configurationHelper.getElement("triggeringFieldName");
                String resultFieldName = 
                    configurationHelper.getElement("resultFieldName");
                SearchTrigger trigger = 
                    new SearchTrigger(triggeringFieldName, resultFieldName);
                searchTriggers.add(trigger);
                eachSearchTriggerEntry++;
            } else {
                eachSearchTriggerEntry = -1;
            }
        }
        return searchTriggers;
    }

    /**
     * @param path
     * @param configurationHelper
     * @return
     * @throws XMLAccessException
     */
    private static TreeMap getOrderByFieldList(String path, 
                                               ConfigurationHelper configurationHelper) throws XMLAccessException {
        int eachResultFieldEntry = 1;
        TreeMap resultFields = new TreeMap();
        while (eachResultFieldEntry > 0) {
            configurationHelper.setPath( path + "/field[" + 
                                        String.valueOf(eachResultFieldEntry) + 
                                        "]");
            if (configurationHelper.pathExists()) {
                String fieldName = 
                    configurationHelper.getElement("columnName");
                String order = configurationHelper.getElement("order");
                SearchOrderByInfo searchOrderByInfo = 
                    new SearchOrderByInfo(fieldName, order);
                resultFields.put(fieldName, searchOrderByInfo);
                eachResultFieldEntry++;
            } else {
                eachResultFieldEntry = -1;
            }
        }
        return resultFields;
    }

    /**
     * @param path
     * @param configurationHelper
     * @return
     * @throws XMLAccessException
     */    
    private static TreeMap getActions(String path, 
                                      ConfigurationHelper configurationHelper) throws XMLAccessException {
        int eachActionFieldEntry = 1;
        TreeMap actions = new TreeMap();
        while (eachActionFieldEntry > 0) {
            configurationHelper.setPath(path + "/action[" + 
                                        String.valueOf(eachActionFieldEntry) + 
                                        "]");
            if (configurationHelper.pathExists()) {
                String actionId = configurationHelper.getElement("actionId");
                String actionLabel = 
                    configurationHelper.getElement("actionLabel");
                String actionCallBack = 
                    configurationHelper.getElement("actionCallBack");
                String allowableModes = 
                    configurationHelper.getElement("allowableModes");
                SearchActionInfo searchActionInfo = 
                    new SearchActionInfo(actionId, actionLabel, actionCallBack, 
                                         allowableModes);
                String useDialog = configurationHelper.getElement("useDialog");
                if (null != useDialog) {
                    searchActionInfo.setUseDialog(Boolean.valueOf(useDialog));
                    searchActionInfo.setWindowHeight(Integer.parseInt(configurationHelper.getElement("windowHeight")));
                    searchActionInfo.setWindowWidth(Integer.parseInt(configurationHelper.getElement("windowWidth")));
                }
                actions.put(actionId, searchActionInfo);
                eachActionFieldEntry++;
            } else {
                eachActionFieldEntry = -1;
            }
        }
        return actions;
    }

    /**
     * @param configurationHelper
     * @param path
     * @return
     * @throws XMLAccessException
     */
    private static TreeMap getSearchTables(ConfigurationHelper configurationHelper, 
                                           String path, String replacementTable) throws XMLAccessException {

        int eachResultFieldEntry = 1;
        String usePath = null;
        TreeMap tables = new TreeMap();
        while (eachResultFieldEntry > 0) {
            usePath = 
                    path + "/table[" + String.valueOf(eachResultFieldEntry) + "]";
            configurationHelper.setPath(usePath);
            if (configurationHelper.pathExists()) {
                String table = configurationHelper.getElement("name");
                String replaceTable = configurationHelper.getElement("replaceTable");
                if(replaceTable != null && replaceTable.equals(Constants.YES) && replacementTable != null){
                    if(table != null){
                        replacementTable = replacementTable + table.substring(table.indexOf(" "), table.length());                        
                    }                
                    tables.put(replacementTable, replacementTable);                
                }else{
                    tables.put(table, table);
                }
                eachResultFieldEntry++;
            } else {
                eachResultFieldEntry = -1;
            }
        }
        return tables;
    }
    
    private static TreeMap getSearchTablesForMiniSpotLight(ConfigurationHelper configurationHelper, 
                                           String path) throws XMLAccessException {

        int eachResultFieldEntry = 1;
        String usePath = null;
        TreeMap tablesWithoutAliasTag = new TreeMap();
        TreeMap tablesWithAliasTag = new TreeMap();
        TreeMap tables = new TreeMap();
        while (eachResultFieldEntry > 0) {
            usePath = 
                    path + "/table[" + String.valueOf(eachResultFieldEntry) + "]";
            configurationHelper.setPath(usePath);
            if (configurationHelper.pathExists()) {
                String table = configurationHelper.getElement("name");
                String aliasName = configurationHelper.getElement("alias");
                if(aliasName != null){
                    String[] tableArray = null;
                    if(table != null && table.contains(",")){
                        tableArray = StringHelper.split(table,",");
                        if(tableArray != null){
                            for (int i = 0; i < tableArray.length; i++)  {
                                String tableNameWithAlias = tableArray[i] + " " + aliasName;
                                tablesWithAliasTag.put(tableNameWithAlias + i, tableNameWithAlias);
                            }
                        }
                    }else{
                        String tableNameWithAlias = table + " " + aliasName;
                        tablesWithAliasTag.put(tableNameWithAlias, tableNameWithAlias);
                    }
                }
                else{
                    tablesWithoutAliasTag.put(table, table);
                }
                eachResultFieldEntry++;
            } else {
                eachResultFieldEntry = -1;
            }
        }
        tables.put("tablesWithAlias",tablesWithAliasTag);
        tables.put("tablesWithoutAlias",tablesWithoutAliasTag);
        return tables;
    }


    public static void main(String[] arg) {
        log.debug("Hello");
    }
    
    /**
     * Searchs the xml file for the dynamicQueryInjections/dynamicQueryInjection
     * path.
     * <br>
     * This allows for injection of query via conditional parameters
     * @param path
     * @param eachEntry
     * @param configurationHelper
     * @return a list of queryInjectionParams of type SearchQueryInjection.class
     * @throws XMLAccessException
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static ArrayList getDynamicQueryInjection(String path, int eachEntry, 
                                                      ConfigurationHelper configurationHelper, String replacementTable) throws XMLAccessException, 
                                                                                                      ClassNotFoundException, 
                                                                                                      NoSuchFieldException, 
                                                                                                      IllegalAccessException {

        String forField, withValue, where, usePath, condition;
        ArrayList queryInjectionParams = new ArrayList();
        SearchQueryInjection sqi = null;
        TreeMap tablesToInject = null;
        int eachResultFieldEntry = 1;
        while (eachResultFieldEntry > 0) { 
            usePath = path +"/dynamicQueryInjection[" + 
                    String.valueOf(eachResultFieldEntry) + "]";
            configurationHelper.setPath(usePath);
            if (configurationHelper.pathExists()) {
                forField = configurationHelper.getElement("forField");
                withValue = configurationHelper.getElement("withValue");
                where = configurationHelper.getElement("where");
                condition = configurationHelper.getElement("condition");

                /*
                 * Use reflection with the class to get interface constant value
                 */
                withValue = getRealWithValue(withValue);

                sqi = new SearchQueryInjection(forField, withValue, where);
                tablesToInject = 
                        getSearchTables(configurationHelper,usePath, replacementTable);
                sqi.setTables(tablesToInject);
                sqi.setCondition(condition);
                queryInjectionParams.add(sqi);

                eachResultFieldEntry++;
            } else {
                eachResultFieldEntry = -1;
            }

        }
        return queryInjectionParams;
    }

    /**
     * Return a formated or different value based on this withValue.
     * <br>e.g.
     * This withValue code be a resource bundle key or a class constant
     * that is to be translated.
     * @param withValue
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static String getRealWithValue(String withValue) throws ClassNotFoundException, 
                                                                    NoSuchFieldException, 
                                                                    IllegalAccessException {
        if (withValue.equalsIgnoreCase("ANY")) {
            return withValue;
        }

        //        String[] classes = withValue.split(":", 3);
        //        Class inTerface = Class.forName(classes[0]);
        //        Field field = inTerface.getField(classes[1]);

        return withValue;
    }

//    private static SearchCriteriaFieldInfo getFuzzySearchCriteriaFieldByPath(int eachEntry, 
//                                                                             ConfigurationHelper configurationHelper) throws XMLAccessException {
//
//        String path = 
//            "/searchList/search[" + String.valueOf(eachEntry) + "]/criteriaFields";
//        configurationHelper.setPath(path + "/fuzzyfield");
//        if (configurationHelper.pathExists()) {
//            String fieldName = configurationHelper.getElement("fieldName");
//            String columnName = configurationHelper.getElement("columnName");
//            String description = configurationHelper.getElement("description");
//            SearchCriteriaFieldInfo searchCriteriaFieldInfo = 
//                new SearchCriteriaFieldInfo(fieldName, "string", null, 
//                                            columnName, null);
//            searchCriteriaFieldInfo.setDescription(description);
//            return searchCriteriaFieldInfo;
//        }
//        return null;
//    }

    /**
     * @param path
     * @param eachEntry
     * @param configurationHelper
     * @param forField
     * @param searchFieldId
     * @return
     * @throws XMLAccessException
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static TreeMap getCriteriaFieldList(String path, 
                                                      int eachEntry, 
                                                      ConfigurationHelper configurationHelper, 
                                                      String forField, 
                                                      String searchFieldId) throws XMLAccessException, 
                                                                                   ClassNotFoundException, 
                                                                                   NoSuchFieldException, 
                                                                                   IllegalAccessException {
        int eachCriteriaFieldEntry = 1;
        TreeMap criteriaFields = new TreeMap();
        int displayOrder = 0;
        while (eachCriteriaFieldEntry > 0) {
            configurationHelper.setPath(path + "/field[" + 
                                        String.valueOf(eachCriteriaFieldEntry) + 
                                        "]");
            if (configurationHelper.pathExists()) {
                String fieldName = 
                    StringHelper.convertStringToID(forField) + configurationHelper.getElement("fieldName");
                //log.debug("fieldid--"+fieldName);                
                String fieldType = configurationHelper.getElement("fieldType");
                String fieldLabel = 
                    "SearchConfig." + searchFieldId + ".CriteriaFields." + 
                    fieldName; //configurationHelper.getElement("fieldLabel");
                String originalFieldLabel = configurationHelper.getElement("fieldLabel");                
                String columnName = 
                    configurationHelper.getElement("columnName");
                String required = configurationHelper.getElement("required");
                String fieldLink = configurationHelper.getElement("fieldLink");
                String displayOrderStr = 
                    configurationHelper.getElement("displayOrder");
                String disabled = configurationHelper.getElement("disabled");
                String firstItemSelected = 
                    configurationHelper.getElement("firstItemSelected");
                String isVisible = configurationHelper.getElement("isVisible");
                String fieldFunction = configurationHelper.getElement("fieldFunction");
                String alternateParameter = configurationHelper.getElement("alternateParameter");
                String alternateOperator = configurationHelper.getElement("alternateOperator");
                String alternateColumn = configurationHelper.getElement("alternateColumn");
                String fieldValuesStaticallyGiven = 
                    configurationHelper.getElement("fieldValuesStaticallyGiven");
                String fieldLinkValue = 
                    configurationHelper.getElement("fieldLinkValue");
                String opertaor = configurationHelper.getElement("operator");
                String listId = 
                    StringHelper.returnBlankIfNull(configurationHelper.getElement("listId"));
                String listType = 
                    StringHelper.returnBlankIfNull(configurationHelper.getElement("listType"));
                String multipleLines = 
                    configurationHelper.getElement("multipleLines");
                String decimalLength = 
                    configurationHelper.getElement("decimalLength");
                String putThousandSeparator = 
                    configurationHelper.getElement("putThousandSeparator");
                String wildCard = configurationHelper.getElement("wildCard");
                SearchCriteriaFieldInfo searchCriteriaFieldInfo = 
                    new SearchCriteriaFieldInfo(fieldName, fieldType, 
                                                fieldLabel, columnName, 
                                                opertaor, wildCard);

                searchCriteriaFieldInfo.setListId(listId);
                searchCriteriaFieldInfo.setListType(listType);
                String searchId = configurationHelper.getElement("searchId");
                searchCriteriaFieldInfo.setSearchId(searchId);

                searchCriteriaFieldInfo.setOriginalFieldLabel(originalFieldLabel);
                
                if (null != required)
                    searchCriteriaFieldInfo.setRequired(Boolean.valueOf(required));

                if (null != fieldLink)
                    searchCriteriaFieldInfo.setFieldLink(fieldLink);

                if (disabled != null) {
                    searchCriteriaFieldInfo.setDisabled(Boolean.valueOf(disabled));
                }

                if (firstItemSelected != null) {
                    searchCriteriaFieldInfo.setFirstItemSelected(Boolean.valueOf(firstItemSelected));
                }

                if (multipleLines != null) {
                    searchCriteriaFieldInfo.setMultipleLines(Boolean.valueOf(multipleLines));
                }

                if (isVisible != null) {
                    searchCriteriaFieldInfo.setVisible(Boolean.valueOf(isVisible));
                }

                if (fieldFunction != null) {
                    searchCriteriaFieldInfo.setFieldFunction(fieldFunction);
                }
                
                if (alternateParameter != null) {
                    searchCriteriaFieldInfo.setAlternateParameter(alternateParameter);
                }
                
                if (alternateOperator != null) {
                    searchCriteriaFieldInfo.setAlternateOperator(alternateOperator);
                }
                                
                if (alternateColumn != null) {
                    searchCriteriaFieldInfo.setAlternateColumn(alternateColumn);
                }
                
                if (fieldValuesStaticallyGiven != null) {
                    searchCriteriaFieldInfo.setFieldValuesStaticallyGiven(Boolean.valueOf(fieldValuesStaticallyGiven));
                }

                if (decimalLength != null) {
                    searchCriteriaFieldInfo.setDecimalLength(Integer.valueOf(decimalLength));
                }

                if (putThousandSeparator != null) {
                    searchCriteriaFieldInfo.setPutThousandSeparator(Boolean.parseBoolean(putThousandSeparator));
                }

                if (displayOrderStr != null) {
                    searchCriteriaFieldInfo.setDisplayOrder(Integer.valueOf(displayOrderStr));
                } else {
                    searchCriteriaFieldInfo.setDisplayOrder(displayOrder);
                }
                displayOrder++;

                if (null != fieldLinkValue) {

                    /*
                         * Use reflection with the class to get interface constant value
                         */
                    fieldLinkValue = getRealWithValue(fieldLinkValue);
                    searchCriteriaFieldInfo.setFieldLinkValue(fieldLinkValue);
                }

                ArrayList options = 
                    getOptions(path,eachCriteriaFieldEntry, 
                               configurationHelper);
                searchCriteriaFieldInfo.setOptions(options);
                List<SearchTrigger> triggers = 
                    getSearchTriggers(path,eachCriteriaFieldEntry, 
                                      configurationHelper);
                searchCriteriaFieldInfo.setTriggerList(triggers);
                criteriaFields.put(fieldName, searchCriteriaFieldInfo);
                eachCriteriaFieldEntry++;
            } else {
                eachCriteriaFieldEntry = -1;
            }
        }
        return criteriaFields;
    }


    /**
     * @param path
     * @param eachEntry
     * @param configurationHelper
     * @param searchFieldId
     * @return
     * @throws XMLAccessException
     */
    private static TreeMap getResultFieldList(String path, int eachEntry, 
                                                    ConfigurationHelper configurationHelper, 
                                                    String searchFieldId) throws XMLAccessException {
        int eachResultFieldEntry = 1;
        TreeMap resultFields = new TreeMap();
        while (eachResultFieldEntry > 0) {
            configurationHelper.setPath(path + "/field[" + 
                                        String.valueOf(eachResultFieldEntry) + 
                                        "]");
            if (configurationHelper.pathExists()) {
                String fieldName = configurationHelper.getElement("fieldName");
                String fieldType = configurationHelper.getElement("fieldType");
                String columnHeading = 
                    "SearchConfig." + searchFieldId + ".ResultField." + 
                    fieldName;
                String originalColumnHeading = configurationHelper.getElement("columnHeading");
                    
                    
                String navigationControllingField = 
                    configurationHelper.getElement("navigationControllingField");
                String getValueFromResources = 
                    configurationHelper.getElement("getValueFromResources");
                String columnName = 
                    configurationHelper.getElement("columnName");
                String isIdField = 
                    StringHelper.returnBlankIfNull(configurationHelper.getElement("isIdField"));
                String strColumnOrderNbr = 
                    StringHelper.returnBlankIfNull(configurationHelper.getElement("columnOrderNbr"));
                String strVisible = 
                    StringHelper.returnBlankIfNull(configurationHelper.getElement("isVisible"));
                String decimalLength = 
                    configurationHelper.getElement("decimalLength");
                String putThousandSeparator = 
                    configurationHelper.getElement("putThousandSeparator");

                int columnOrderNbr = 0;
                if (!strColumnOrderNbr.equals(Constants.BLANK)) {
                    columnOrderNbr = Integer.valueOf(strColumnOrderNbr);
                }
                SearchResultFieldInfo searchResultFieldInfo = 
                    new SearchResultFieldInfo(fieldName, fieldType, 
                                              columnHeading, columnName, 
                                              isIdField, columnOrderNbr);
                searchResultFieldInfo.setVisible(strVisible);
                searchResultFieldInfo.setOriginalColumnHeading(originalColumnHeading);
                searchResultFieldInfo.setNavigationControllingField(navigationControllingField != 
                                                                    null && 
                                                                    navigationControllingField.equals(Constants.YES) ? 
                                                                    true : 
                                                                    false);
                searchResultFieldInfo.setGetValueFromResources(getValueFromResources != 
                                                               null && 
                                                               getValueFromResources.equals(Constants.YES) ? 
                                                               true : false);

                if (decimalLength != null) {
                    searchResultFieldInfo.setDecimalLength(Integer.valueOf(decimalLength));
                }
                if (putThousandSeparator != null) {
                    searchResultFieldInfo.setPutThousandSeparator(Boolean.parseBoolean(putThousandSeparator));
                }
                resultFields.put(fieldName, searchResultFieldInfo);
                eachResultFieldEntry++;
            } else {
                eachResultFieldEntry = -1;
            }
        }
        return resultFields;
    }
    
    public static ArrayList<String> getSearchIds(){
        ArrayList idList = new ArrayList<String>();
        idList.addAll(searchParams.keySet());
        return idList;
    }


//    public static SearchInfo getSearchInfo(String searchId, String loadFromDB){
//        return getSearchInfo(searchId,loadFromDB, null);
//    }

    public static SearchInfo getSearchInfo(String searchId, String loadFromDB, String replacementTable) {
        SearchInfo info = (SearchInfo)searchParams.get(searchId);
        if(info == null) {

            if(loadFromDB != null && loadFromDB.equalsIgnoreCase(Constants.YES)){
                loadSearchConfig(true, searchId,  replacementTable);
            }
            else {
                loadSearchConfig(false, searchId,  replacementTable);
            }
            // the search info is loaded inside the loadsearchconfig method, so we need to get it from searchparams map again.
            info = (SearchInfo)searchParams.get(searchId);
        }
        return CopyHelper.deepCopy(info);
    }
    
    public static String getSearchFileNamesList(){
        return searchFilename;
    }

}
