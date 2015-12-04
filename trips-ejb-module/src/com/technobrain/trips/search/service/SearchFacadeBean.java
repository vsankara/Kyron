package com.technobrain.trips.search.service;

//package com.crownagents.trips.search.service;
//
////import com.crownagents.trips.entity.service.EntityFacadeLocal;
////import com.crownagents.trips.search.helpers.SearchConfigHelper;
////import com.crownagents.trips.search.helpers.SearchConfigHelper;
//import com.crownagents.trips.common.constants.Constants;
//import com.crownagents.trips.common.exceptions.TripsInvalidParameterException;
//import com.crownagents.trips.common.helpers.DateHelper;
//import com.crownagents.trips.common.helpers.StringHelper;
//import com.crownagents.trips.common.helpers.search.ColumnData;
//import com.crownagents.trips.common.helpers.search.SearchCriteriaFieldInfo;
//import com.crownagents.trips.common.helpers.search.SearchInfo;
//import com.crownagents.trips.common.helpers.search.SearchOrderByInfo;
//import com.crownagents.trips.common.helpers.search.SearchQueryInjection;
//import com.crownagents.trips.common.helpers.search.SearchResultFieldInfo;
//import com.crownagents.trips.common.helpers.search.SearchResultInfo;
//import com.crownagents.trips.core.service.FacadeBean;
//import com.crownagents.trips.dto.search.SavedSearchDTO;
//import com.crownagents.trips.entity.service.EntityFacadeLocal;
//import com.crownagents.trips.flexforms.helper.FlexFormsConstants;
////import com.crownagents.trips.identity.model.CasUser;
//import com.crownagents.trips.reference.service.ReferenceFacadeLocal;
//import com.crownagents.trips.search.exception.CriteriaRequiredException;
//import com.crownagents.trips.search.exception.InvalidSearchCriteria;
//import com.crownagents.trips.search.helpers.SearchConfigHelper;
//import com.crownagents.trips.search.model.SavedSearch;
//import com.crownagents.trips.search.model.SavedSearchField;
//import com.crownagents.trips.search.model.SearchConfig;
//import com.crownagents.trips.security.service.SecurityFacadeLocal;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.StringTokenizer;
//import java.util.TreeMap;
//
//import javax.annotation.Resource;
//
//import javax.ejb.EJB;
//import javax.ejb.Local;
//import javax.ejb.Remote;
//import javax.ejb.SessionContext;
//import javax.ejb.Stateless;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
////import oracle.jdbc.OracleTypes;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.log4j.Logger;
////import java.util.Date;
//
//
///**
// * Crown Agents 2007
// * <br>
// *
// * @since $Date: 1/29/2010 6:56:13 AM$
// * @version $Revision: 65$
// * @author $Author: Vythilingam Pirabaharan$
// *
// * $Log[1]:
// *  65   TRIPS2 etis.bir.gov.ph1.52.1.11   1/29/2010 6:56:13 AM   Vythilingam
// *       Pirabaharan Bug fixed (bug-74) - sort alphabetically regardless of the
// *       case of column.
// * $
// */
//@Stateless(name = "SearchFacade",mappedName="SearchFacade")
//public class SearchFacadeBean extends FacadeBean implements SearchFacadeLocal, SearchFacadeRemote {
// 
//    @Resource SessionContext sessionContext;
//    @PersistenceContext(unitName = "trips-ejb-module")
//    private EntityManager em;
//    
//    @EJB
//    ReferenceFacadeLocal referenceFacade;
//    
//    @EJB
//    EntityFacadeLocal entityFacade;
//    
//    @EJB
//    SecurityFacadeLocal secFacade;
//    
//    public final static Logger log = Logger.getLogger(SearchFacadeBean.class);
//    private static final String AND = " and ";
//    public SearchFacadeBean() {}
//    
//    
//    
//    /**
//     * 
//     * @param searchId
//     * @param searchParamValue is the value of the search parameter that we will use while generating the query.
//     * @param mapKey is in DType~FieldName format. The query will be generated according to the dtype and field name parameters.
//     * @return
//     */
//    public SearchResultInfo getSearchResultWithMapKey(String searchId, Object searchParamValue, String mapKey, SearchInfo searchInfo) 
//        throws TripsInvalidParameterException {
//        if(mapKey == null || searchParamValue == null) {
//            return null;
//        }
//        if(mapKey.contains(",")) {
//            throw new TripsInvalidParameterException("FlexibleFormGeneration.Error.MapKeyFormatWrong");
//        }
//        
//        String[] splittedMapKey = mapKey.split(FlexFormsConstants.MAP_KEY_DTYPE_SEPARATOR);
//        String fieldName = null;
//        String dType = null;
//        if(splittedMapKey.length == 2) {
//            // inject the forField parameter to the searchInfo.
//            searchInfo.setMultiAdvancePanelName(splittedMapKey[0]);
//            SearchCriteriaFieldInfo field = new SearchCriteriaFieldInfo(
//                FlexFormsConstants.Search.FOR_FIELD, Constants.STRING, "", searchInfo.getMultiSearchFieldColumnName(), "");
//            field.setFieldValue(splittedMapKey[0]);
//            searchInfo.getSearchFields().put(FlexFormsConstants.Search.FOR_FIELD, field);
//            fieldName = splittedMapKey[1];
//            fieldName = splittedMapKey[0];
//        }
//        else {
//            fieldName = splittedMapKey[0];
//        }
//        String type = null;
//        if(searchParamValue instanceof String) {
//            type = Constants.STRING;
//        } else if(searchParamValue instanceof Number) {
//            type = Constants.NUMBER;
//        } else {
//            type = Constants.DATE;
//        }
//        SearchCriteriaFieldInfo fieldInfo = (SearchCriteriaFieldInfo)searchInfo.getSearchFields().get(fieldName);
//        fieldInfo.setFieldValue(searchParamValue);
//        return getSearchResult(searchInfo, null, dType);
//    }
//    
//    // this method takes in search_id and primary key and returns the search result.
//    // this will be used by Flexible Forms module
//    public SearchResultInfo getSearchResultForId(SearchInfo searchInfo, Long primaryKey) throws TripsInvalidParameterException {
//        String dType = null;
//        if (searchInfo != null){
//        // check if multi-advanced search is available
//            if(searchInfo.isMultiSearchAvailable()){
//                String tableName = searchInfo.getPrimaryKeyTableName();
//                String dTypeColumn = searchInfo.getMultiSearchFieldColumnName();
//                dType = referenceFacade.getDTypeForRecord(tableName, "id", dTypeColumn, primaryKey);
//                
//                if(dType != null){
//                  searchInfo.setMultiAdvancePanelName(dType);  
//
//                    SearchCriteriaFieldInfo field = new SearchCriteriaFieldInfo(
//                        FlexFormsConstants.Search.FOR_FIELD, Constants.STRING, "", dTypeColumn, "");
//                    field.setFieldValue(dType);
//                    searchInfo.getSearchFields().put(FlexFormsConstants.Search.FOR_FIELD, field);
//
//                }
//            }           
//        }
//        return getSearchResult(searchInfo, primaryKey, dType);
//    }    
//    
//    public SearchResultInfo getSearchResult(SearchInfo searchInfo, Long primaryKey, String dType) throws TripsInvalidParameterException {
//        ArrayList<SearchResultFieldInfo> results =  searchInfo.getResultFieldsAsList(dType);
//
//        boolean hasError = true;
//        for(SearchResultFieldInfo resultFieldInfo : results){
//            // get the column name of the primary key... check if it is alias or table name
//            if(resultFieldInfo != null && resultFieldInfo.isPrimaryKey()){                    
//                String colName = resultFieldInfo.getColumnName();
//                if (colName != null ){
//                    // check if this column is available in criteria fields if not create one
//                    ArrayList<SearchCriteriaFieldInfo> fields =  null;
//                    if(dType != null){
//                        fields = searchInfo.getAdvancedSearchFieldsAsList(dType);
//                    }else{
//                        fields = searchInfo.getSearchFieldsAsList();
//                    }
//                    boolean fieldFound = false;
//                    for(SearchCriteriaFieldInfo field:fields){
//                        if (field != null && field.getColumnName() != null && field.getColumnName().equals(colName)){
//                            if(primaryKey != null) {
//                                field.setFieldValue(primaryKey.toString());
//                            }
//                            fieldFound = true;
//                            hasError = false;
//                            break;
//                        }
//                    }
//                    if(!fieldFound){
//                        SearchCriteriaFieldInfo field = new SearchCriteriaFieldInfo(FlexFormsConstants.Search.ID_COLUMN, Constants.STRING, "", colName, "");
//                        if(primaryKey != null) {
//                            field.setFieldValue(primaryKey.toString());
//                        }
//                        searchInfo.getSearchFields().put(FlexFormsConstants.Search.ID_COLUMN, field);
//                        hasError = false;
//                    }                    
//                }
//            }
//        }
//        if(!hasError){
//            try {
//                ArrayList searchResults = new ArrayList(); 
//                searchResults = getSearchResults(searchInfo);
//                if(searchResults != null && searchResults.size() > 0) {
//                    if(searchResults.size() == 1){
//                        SearchResultInfo result = (SearchResultInfo)searchResults.get(0);
//                        if(dType != null){
//                            ColumnData colData = new ColumnData(150,  FlexFormsConstants.Search.D_TYPE, dType, false);
//                            colData.setColumnName(FlexFormsConstants.Search.D_TYPE);
//                            result.addColumn(colData);
//                        }                   
//                        
//                        return result;
//                    }
//                    else {
//                        // the query should return only one result. If it returns more than one result, we should throw exception.
//                        throw new TripsInvalidParameterException("GenericSearch.Error.MoreThanOneResultSelectRecordManuallly");
//                    }
//                }
//                
//            } catch (SQLException e) {
//                 log.error(e.getLocalizedMessage(), e);
//            }catch(InvalidSearchCriteria e){
//                log.error(e.getLocalizedMessage(), e);
//            }
//        }
//    
//    return null;
//    }
//    
//
//    /**
//     * This method sets up enviornment for query to be built.
//     * 
//     * @param searchInfo
//     * @return
//     * @throws InvalidSearchCriteria
//     * @throws SQLException
//     */
//     public ArrayList<SearchResultInfo> getSearchResults(SearchInfo searchInfo) throws InvalidSearchCriteria, 
//                                                                                      SQLException {
//                                                                                     
//        ArrayList searchFieldList=searchInfo.getSearchFieldsAsList();
//        ArrayList advancedSearchFieldList = null;
//        
//        String sql = "";     
//        String forField = "";
//        
//        if(searchInfo.getMultiAdvancedSearchAvailable().equals(Constants.SPOTLIGHT)){
//            // loop through all the advanced fields list and get sql query for each one of them            
//
//            TreeMap advancedSearchFieldsMap = searchInfo.getAdvancedSearchFields();
//            // loop through the map and construct the query.
//             Iterator iter = advancedSearchFieldsMap.keySet().iterator();
//             String tempSql = "";
//             while (iter.hasNext()) {
//                forField = (String)iter.next();
//                
//                advancedSearchFieldList = searchInfo.getAdvancedSearchFieldsAsList(forField);
//
//                if (forField != null && !forField.equals("")){         
//                    searchInfo.setMultiAdvancePanelName(forField);                            
//                    tempSql = buildSearchQuery( searchInfo, advancedSearchFieldList, forField);
//                    if (sql == "") {
//                        sql = tempSql;
//                    } else {
//                        sql = sql + " UNION ALL " + tempSql;
//                    }
//                    int paramCount = 0;
//                    char tempStr[] = tempSql.toCharArray();
//                    for (int i=0 ; i<tempStr.length ; i++ ){
//                        if (tempStr[i] == '?') {
//                            paramCount++;
//                        }
//                    }
//
//                    if (advancedSearchFieldList != null && advancedSearchFieldList.size()>0){
//                        for (int i=0 ; i<paramCount ; i++ ){
//                            searchFieldList.addAll(advancedSearchFieldList);
//                        }
//                    }
//                    
//                }
//            }
//                    
//        } else if(searchInfo.getMultiAdvancedSearchAvailable().equals(Constants.MINI_SPOTLIGHT)){
//             
//             TreeMap tableforMiniSpotLight = searchInfo.getSearchTablesForMiniSpotLight();
//             TreeMap tableWithAlias = (TreeMap)tableforMiniSpotLight.get("tablesWithAlias");
//             TreeMap tableWithoutAlias = (TreeMap)tableforMiniSpotLight.get("tablesWithoutAlias");
//             boolean isTableWithoutAliasAdded = false;
//             List newSearchFieldList =new ArrayList();
//             Iterator iter = tableWithAlias.values().iterator();
//             String tempSql = "";
//             while (iter.hasNext()) {
//                String tableName = (String)iter.next();
//                if (tableName != null && !tableName.equals("")){         
//                    searchInfo.getSearchTables().put(tableName, tableName);
//                    if(!isTableWithoutAliasAdded){
//                        searchInfo.getSearchTables().putAll(tableWithoutAlias);
//                        isTableWithoutAliasAdded = true;
//                    }                         
//                    tempSql = buildSearchQuery( searchInfo, searchFieldList, searchInfo.getMultiAdvancePanelName());
//                    if (sql == "") {
//                        sql = tempSql;
//                    } else {
//                        sql = sql + " UNION ALL " + tempSql;
//                    }
//                    //Need to remove the table after generating SQL.
//                    searchInfo.getSearchTables().remove(tableName);
//                    
//                    newSearchFieldList.addAll(searchFieldList);                    
//                }
//            }
//            searchFieldList.clear();
//            //search fields = actual search fields from search config * number of select query
//            searchFieldList.addAll(newSearchFieldList);
//        }else {    
//            if(searchInfo.isMultiSearchAvailable()){
//                 advancedSearchFieldList = searchInfo.getAdvancedSearchFieldsAsList(searchInfo.getMultiAdvancePanelName());
//            }else{
//                advancedSearchFieldList = searchInfo.getAdvancedSearchFieldsAsList();
//            }
//            
//            if (advancedSearchFieldList != null && advancedSearchFieldList.size()>0){
//                searchFieldList.addAll(advancedSearchFieldList);
//            }
//            sql = buildSearchQuery( searchInfo, searchFieldList,searchInfo.getMultiAdvancePanelName()  );
//            forField = searchInfo.getMultiAdvancePanelName();
//        }
//        
//        
//        if(searchInfo.getMultiAdvancedSearchAvailable().equals(Constants.SPOTLIGHT)){ 
//            // in spotlight search, there is 1 static search field. so the first item in the list will be the
//            // static field but when the parameter is passed to the query, the first item is not needed so the
//            // first item is removed. 
//            searchFieldList.remove(0);
//        }
//            
//        
//        return executeQueryGetresult(searchInfo, searchFieldList, sql, forField);
//    }
//
//
//    /**
//     * 
//     * @param searchInfo
//     * @return
//     * @throws InvalidSearchCriteria
//     * @throws SQLException
//     */
//    public String buildSearchQuery(SearchInfo searchInfo, ArrayList searchFieldList, String multiAdvancePanelName) throws InvalidSearchCriteria, 
//                                                                                     SQLException {
//        final String FROM = " from " , WHERE = " where " , AND = " and ";
//
//        StringBuffer whereClause = new StringBuffer("");
//
//        StringBuffer sql = new StringBuffer("select ").append(getQueryType(searchInfo)).append(" ")
//            .append(getCommaSeperatetResultFieldList(searchInfo, multiAdvancePanelName)).append(FROM)
//            .append(getCommaSeperatetTableList(searchInfo.getSearchTablesAsList())).append(WHERE); 
//
//        if (searchInfo.getMultiAdvancedSearchAvailable().equals(Constants.SPOTLIGHT)) {
////            whereClause = whereClause.append("contains(" + multiAdvancePanelName + ".CONTEXT_SEARCH, ?) > 0 ");
//        } else {
//            getWhereClause(searchFieldList, whereClause);
//        }
//
//
//        // code to update where clause in case we have to populate forField List partially
//               String partialForFieldList = searchInfo.getPartialForFieldList();
//                if(partialForFieldList != null && !partialForFieldList.equals(Constants.BLANK)){
//                   SearchCriteriaFieldInfo scfInfo = (SearchCriteriaFieldInfo)searchInfo.getSearchFields().get("forField");
//                   String colName = scfInfo.getColumnName();
//                   if (colName != null && !colName.equals(Constants.BLANK)){
//                       // we check if the partialForFieldList has more than one value            
//                       if(partialForFieldList.indexOf(",") > 0){// this means there are more than one forFields in list
//                           partialForFieldList = "UPPER(" + colName + ") = '" + partialForFieldList.toUpperCase() +"'";
//                       }else{
//                           partialForFieldList = partialForFieldList.toUpperCase();
//                           partialForFieldList = partialForFieldList.replaceAll(" ", "");  // replacing all the blanks
//                           partialForFieldList = partialForFieldList.replaceAll(",", "','");  // replacing all the blanks
//                           partialForFieldList = "UPPER(" + colName + ") IN ('"+partialForFieldList+"')";
//                       }
//                       if(whereClause != null && !whereClause.toString().equals(Constants.BLANK)){
//                           if (!whereClause.toString().trim().endsWith(AND)){
//                               whereClause.append(" ");
//                               whereClause.append(AND);
//                           }
//                           whereClause.append(" ");
//                           whereClause.append(partialForFieldList);
//                       }
//                   }
//                }
//                
//                searchInfo.setPrimaryTableName(multiAdvancePanelName);
//                    //injectAccessLevelQuery(searchInfo, whereClause);
//               
//                  sql=sql.append(whereClause);
//                  
//                  if(log.isDebugEnabled())log.debug("sql " + sql);
//                  /*
//                   * Search the xml for the query injection paramter to replace the existing query
//                   */
//                  SearchQueryInjection injection = null;
//                  if(searchInfo.isSupportForMultiQueryInjectionAvailable()){
//                       // multiquery injection should be used in case we want to add multiple query injections
//                       injection = getMultipleQueryInjections(searchFieldList, searchInfo, multiAdvancePanelName);
//                  }else{
//                       injection = getQueryInjection(searchFieldList, searchInfo);   
//                  }
//                  
//                  if(null == injection){
//                      if(whereClause.toString().equals("")){                   
//                          if(null != searchInfo.getJoingQuery()){
//                            sql.append(searchInfo.getJoingQuery());
//                          }else{
//                            sql=sql.append(" "); 
//                          }
//                      }else{
//                          
//                          if(null != searchInfo.getJoingQuery()){
//                              sql.append(AND).append(searchInfo.getJoingQuery());
//                          }
//                      }
//                  }else{              
//                          int from = sql.indexOf(FROM) + FROM.length();
//                          String injectedTables = "";
//                          if(searchInfo.isSupportForMultiQueryInjectionAvailable()){
//                               injectedTables = injection.getTablesAsString();
//                              if(injectedTables != null && !injectedTables.equals("") && !injectedTables.trim().endsWith(",") &&
//                              !searchInfo.getMultiAdvancedSearchAvailable().equals(Constants.SPOTLIGHT))
//                              injectedTables=injectedTables+",";
//                          }else{
//                              injectedTables = getCommaSeperatetTableList(injection.getTableAsList());
//                          }
//                          //TODO fix hack with comma is not required
//                          sql.insert(from," "+injectedTables+" "  /* +", " */);
//                          if(whereClause.toString().equals("")){     
//                              if(null != searchInfo.getJoingQuery()){
//                                  sql.append(searchInfo.getJoingQuery());
//                                  if(null != injection.getWhere()){
//                                       sql.append(AND).append(injection.getWhere());
//                                  }else{
//                                     sql=sql.append(" ");  
//                                  }                           
//                              }else{
//                                  if(null != injection.getWhere()){
//                                       sql.append(injection.getWhere());
//                                  }else{
//                                     sql=sql.append(" ");  
//                                  }                        
//                              }
//                          }else{                   
//                             if(null != injection.getWhere() && !injection.getWhere().equals(Constants.BLANK)){
//                                 if(null != searchInfo.getJoingQuery() && !searchInfo.getJoingQuery().equals(Constants.BLANK)){
//                                     sql.append(AND).append(searchInfo.getJoingQuery());
//                                 }
//                                 sql.append(AND).append(injection.getWhere());
//                                 String condition = determineQICondition(searchInfo,injection);
//                                 if(null == condition){
//                                     //do nothing
//                                 }else{
//                                     sql.append(" " + condition);
//                                 }
//                             }
//                          }                 
//                          
//                  }
//               String sqlQuery = joinAccessLevelQuery(sql.toString());    
//               
//               
//               sqlQuery = sqlQuery + getCommaSeperatedOrderByList(searchInfo.getOrderByFieldsAsList());
//               
//               return sqlQuery;
//    }
//
//
//
//    /**
//     * 
//     * @param searchInfo
//     * @return
//     * @throws InvalidSearchCriteria
//     * @throws SQLException
//     */
//    public ArrayList<SearchResultInfo> executeQueryGetresult(SearchInfo searchInfo, ArrayList searchFieldList, String sql, String multiAdvancePanelName) throws InvalidSearchCriteria, 
//                                                                                     SQLException {
//             Connection con=null;  
//             PreparedStatement preparedStatement= null;  
//             ResultSet rs= null;
//            try{   
//                con = referenceFacade.getDataSource().getConnection();
//            int totalFieldsInWhere=1;        
//            
//            String primaryKeyTableName = searchInfo.getPrimaryKeyTableName();
//            Boolean primaryTableExists = checkTableExists(primaryKeyTableName,con);
//
//            if(log.isDebugEnabled()){
//                log.debug("Search Query="+sql);    
//            }
//            
//            log.debug("Search Query="+sql);
//            
//            preparedStatement=con.prepareStatement(sql);
//            Object fieldValue = null;
//            String sqlFetchSize = referenceFacade.getSystemParameter(Constants.SystemParameterCode.SQL_FETCH_SIZE);
//            for (int count=0;count<searchFieldList.size();count++){
//                SearchCriteriaFieldInfo searchCriteriaFieldInfo=(SearchCriteriaFieldInfo)searchFieldList.get(count);
//                if(searchCriteriaFieldInfo.getColumnName()!= null &&
//                    searchCriteriaFieldInfo.getColumnName().equalsIgnoreCase("SQLFETCHSIZE")){
//                    sqlFetchSize = String.valueOf(searchCriteriaFieldInfo.getFieldValue());
//                }else if(canAddSearchCriteriaToWhereClause(searchCriteriaFieldInfo)){
//                    if(useCriteria(searchCriteriaFieldInfo, searchFieldList)){ 
//                        if(searchCriteriaFieldInfo.getFieldType().equalsIgnoreCase(Constants.DATE)){
//                            fieldValue = new java.sql.Date(((Date)searchCriteriaFieldInfo.getFieldValue()).getTime());
//                        }else  if(searchCriteriaFieldInfo.getFieldType().equalsIgnoreCase(Constants.STRING) || 
//                                  searchCriteriaFieldInfo.getFieldType().equalsIgnoreCase(Constants.FORFIELD) ||
//                                  searchCriteriaFieldInfo.getFieldType().equalsIgnoreCase(Constants.SPOTLIGHT) ||
//                                  searchCriteriaFieldInfo.getFieldType().equalsIgnoreCase(Constants.FUZZY)){
//                            String strFieldvalue = ( (String)searchCriteriaFieldInfo.getFieldValue()).trim();
//
//                            if(strFieldvalue != null){
//                                // if Alternate operator is provided then, perform operator specific task
//                                if(searchCriteriaFieldInfo.getAlternateOperator() != null && 
//                                        searchCriteriaFieldInfo.getAlternateOperator().equals(Constants.SearchSpecialOperator.PURIFY_FIELD_REMOVE_CHARS) ){
//                                    if(searchCriteriaFieldInfo.getAlternateParameter() != null ){
//                                        String replaceChars = searchCriteriaFieldInfo.getAlternateParameter();
//                                        strFieldvalue = strFieldvalue.replaceAll(replaceChars, "");
//                                    }
//                                }
//                                // in case user tried searching with single quote in the search criteria, 
//                                // convert it so that it passes through the SQL
////                                strFieldvalue = strFieldvalue.replaceAll("'","''") ;
////                                strFieldvalue = strFieldvalue.replaceAll("-","\-") ;
//                            }
//                            fieldValue = strFieldvalue;                           
//                            
//                        }else  if(searchCriteriaFieldInfo.getFieldType().equalsIgnoreCase(Constants.NUMBER)){
//                            fieldValue = searchCriteriaFieldInfo.getFieldValue();//Long.valueOf((String)searchCriteriaFieldInfo.getFieldValue());
//                        }
//                        String[] columnNames = searchCriteriaFieldInfo.getColumnNames();
//                        for(int i = 0; i < columnNames.length; i++) {
//                            // if there is a hypen within the criteria value entered by the user, then we have to remove those hypens from the value
//                            // because in the database the tin number is stored without hypens.
//                            // If there is no hypen, then the following code will not change the user value.
////                            if(columnNames[i].equals("REV_ENTITY_ACC.TP_IDENTIFIER_CODE")){                                                             
////                                searchCriteriaFieldInfo.getAlternateParameter();
////                                searchCriteriaFieldInfo.getAlternateOperator();
////                                //String strTemp = fieldValue.toString().substring(0, (fieldValue.toString().lastIndexOf("-")));
////                                String[] strSplit = fieldValue.toString().split("-"); 
////                                String strNew = "";
////                                int len = 0;
////                                if(strSplit.length > 3){
////                                    len = 3;
////                                }else{
////                                    len = strSplit.length;
////                                }
////                                for(int c = 0;c < len; c++){
////                                    strNew = strNew + strSplit[c];
////                                }
////                                fieldValue = strNew;
////                            }
//                            preparedStatement.setObject(totalFieldsInWhere, fieldValue);
//                            totalFieldsInWhere++;
//                        }
//                        
//                        if(searchCriteriaFieldInfo.getAlternateColumn() != null){
//                            preparedStatement.setObject(totalFieldsInWhere, fieldValue);
//                            totalFieldsInWhere++;
//                        }
//                    }
//                }              
//            }
//
//            if(log.isDebugEnabled())log.debug("sql " + sql);
//            if(sqlFetchSize != null && !sqlFetchSize.equals("null")){
//                preparedStatement.setMaxRows(Integer.parseInt(sqlFetchSize));
//            }
//           
//             rs=preparedStatement.executeQuery();  
//            ArrayList<SearchResultInfo> searchData=new ArrayList<SearchResultInfo>();
//            
//            while(rs.next()){
//                ResultSetMetaData resultSetMetaData=preparedStatement.getMetaData();
//                SearchResultInfo row = new SearchResultInfo(); 
//                for(int count=1;count<resultSetMetaData.getColumnCount()+1;count++){
//                    String columnName=resultSetMetaData.getColumnName(count);
//                    boolean isAccessLevelColumn = false;
//                    if(columnName != null && columnName.equals(Constants.EntityDefaultValues.DB_ACCESS_LEVEL)) {
//                        isAccessLevelColumn = true;
//                    }
//                    SearchResultFieldInfo resultFieldInfo = null;
//                    if(!isAccessLevelColumn) {
//                        resultFieldInfo = getRespectiveSearchResultFieldInfo(searchInfo,columnName, multiAdvancePanelName);
//                    }
//                    int columnType= resultSetMetaData.getColumnType(count);
//                    Object data = null;
//                    switch(columnType){
//                        case 12:
////                            // If "ADDRESS" field contains only "," making data variable to blank
////                            // This fix(TRGHA-567) done in order to display address field as blank instead of "," in generic search result table 
////                            if(columnName != null && columnName.equals("ADDRESS") &&
////                               data != null && data.toString().trim().equals(",")){
////                               data = "";
////                            }
//                                data=rs.getString(columnName);
//                        break;
//                        case 91:
//                            if(rs.getDate(columnName) != null){
//                                data=DateHelper.getCalendar(rs.getDate(columnName));
//                            }else{
//                                data=rs.getDate(columnName);
//                            }
//                        break;
//                        case 2: //TODO: add different check for integer and long and etc
//                            if(resultFieldInfo != null && resultFieldInfo.getFieldType().equals(SearchResultFieldInfo.FIELD_TYPE_DECIMAL)) {
//                                data = rs.getBigDecimal(columnName);
//                            }
//                            else {
//                                data=rs.getLong(columnName);
//                                // This fix(TRGHA-567) done in order to display address field properly with a concatenated string.
//                                if(columnName != null && columnName.equalsIgnoreCase(Constants.SearchColumnNames.ADDRESS)) {
//                                   if(data != null) {
//                                       data = entityFacade.getAddressAsCSV((Long)data);
//                                   }
//                                }
//                            }
//                        break;
//                        case 1:
//                            data=rs.getString(columnName);
//                        break;
//                        
//                        default:if(log.isDebugEnabled())log.debug("Data type not found for generic search framework");
//                            data=rs.getObject(columnName);
//                        break;
//                    }
////                    String tableColumnName = columnName;
//                    
//                    if(isAccessLevelColumn) {
//                        row.setAccessLevel((String)data);
//                    }
//                    else {
//                        ColumnData colData = new ColumnData(
//                            resultFieldInfo.getColumnOrderNbr(), resultFieldInfo.getFieldName(), data);
//                        colData.setColumnName(columnName);
//                        // if the primary key's table name is not an alias name, we can use it for access level update.
//                        // Otherwise, the primary table name that is defined in the xml file should be used.
//                        if(primaryKeyTableName != null && primaryTableExists) {
//                            colData.setTableNameForAccessLevelUpdate(primaryKeyTableName);
//                        }
//                        else {
//                            colData.setTableNameForAccessLevelUpdate(searchInfo.getPrimaryTableName());
//                        }
//                        if(resultFieldInfo.isPrimaryKey()){
//                            row.setPrimaryKey(data);
//                            colData.setPrimaryKey(true);
//                        }
//
//                        colData.setShouldGetValueFromResource(resultFieldInfo.isGetValueFromResources());
//                        row.addColumn(colData);
//                    }
//                }
//                // in order to indicate which panel is selected, we create an indicator column and add it to the row.
//                ColumnData dType = new ColumnData(1000, FlexFormsConstants.Search.D_TYPE, multiAdvancePanelName);
//                row.addColumn(dType);
//                searchData.add(row);
//            }
//            return searchData;
//        }catch(SQLException e){
//            throw new InvalidSearchCriteria(e);
//        }finally{
//            try {
//                if (rs != null) {rs.close();}
//                if (preparedStatement != null) {preparedStatement.close();}
//            } catch (SQLException ex)  {
//                log.error(ex.getLocalizedMessage(), ex);
//            }
//            
//            if ( con != null )
//                 {
//                    try {
//                       con.close();
//                    }
//                    catch( SQLException sqlException ){}
//                 }
//        }
//        
//    }
//
//
//  
//
//
//    /**
//     * 
//     * @param searchInfo
//     * @return
//     * @throws InvalidSearchCriteria
//     * @throws SQLException
//     */
////    public ArrayList<SearchResultInfo> getSearchResultOld(SearchInfo searchInfo) throws InvalidSearchCriteria, 
////                                                                                     SQLException {
////        final String FROM = " from " , WHERE = " where " , AND = " and ";
////        
////        Connection con=null;
////      
////        con=referenceFacade.getDataSource().getConnection();
////        StringBuffer sql=new StringBuffer("select ").append(getQueryType(searchInfo)).append(" ")
////                    .append(getCommaSeperatetResultFieldList(searchInfo)).append(FROM)
////                    .append(getCommaSeperatetTableList(searchInfo.getSearchTablesAsList())).append(WHERE); 
////            
////            ArrayList searchFieldList=searchInfo.getSearchFieldsAsList();
////            ArrayList advancedSearchFieldList = null;
////            
////            if(searchInfo.isMultiSearchAvailable()){
////                advancedSearchFieldList = searchInfo.getAdvancedSearchFieldsAsList(searchInfo.getMultiAdvancePanelName());
////            }else{
////                advancedSearchFieldList = searchInfo.getAdvancedSearchFieldsAsList();
////            }
////            
////            if (advancedSearchFieldList != null && advancedSearchFieldList.size()>0){
////                searchFieldList.addAll(advancedSearchFieldList);
////            }
////            StringBuffer whereClause = new StringBuffer("");
////            getWhereClause(searchFieldList, whereClause);
//////            getFuzzyWhereClause(searchInfo.getFuzzySearchCriteria(), whereClause);
////           /*
////            * Safe guard for bulk queries with no params.
////            * this will only happen when a complex rule for a critiera is no
////            * met see useCritiera method.
////            */
//////           if(whereClause.length() == 0) {
//////              throw new InvalidSearchCriteria(); 
//////           }
////
////
////            String primaryKeyTableName = searchInfo.getPrimaryKeyTableName();
////            Boolean primaryTableExists = checkTableExists(primaryKeyTableName);
////
////
//// // code to update where clause in case we have to populate forField List partially
////        String partialForFieldList = searchInfo.getPartialForFieldList();
////         if(partialForFieldList != null && !partialForFieldList.equals(Constants.BLANK)){
////            SearchCriteriaFieldInfo scfInfo = (SearchCriteriaFieldInfo)searchInfo.getSearchFields().get("forField");
////            String colName = scfInfo.getColumnName();
////            if (colName != null && !colName.equals(Constants.BLANK)){
////                // we check if the partialForFieldList has more than one value            
////                if(partialForFieldList.indexOf(",") > 0){// this means there are more than one forFields in list
////                    partialForFieldList = "UPPER(" + colName + ") = '" + partialForFieldList.toUpperCase() +"'";
////                }else{
////                    partialForFieldList = partialForFieldList.toUpperCase();
////                    partialForFieldList = partialForFieldList.replaceAll(" ", "");  // replacing all the blanks
////                    partialForFieldList = partialForFieldList.replaceAll(",", "','");  // replacing all the blanks
////                    partialForFieldList = "UPPER(" + colName + ") IN ('"+partialForFieldList+"')";
////                }
////                if(whereClause != null && !whereClause.toString().equals(Constants.BLANK)){
////                    if (!whereClause.toString().trim().endsWith(AND)){
////                        whereClause.append(" ");
////                        whereClause.append(AND);
////                    }
////                    whereClause.append(" ");
////                    whereClause.append(partialForFieldList);
////                }
////            }
////         }
////         
////         injectAccessLevelQuery(searchInfo, whereClause);
////        
////           sql=sql.append(whereClause);
////           
////           if(log.isDebugEnabled())log.debug("sql " + sql);
////           /*
////            * Search the xml for the query injection paramter to replace the existing query
////            */
////           SearchQueryInjection injection = null;
////           if(searchInfo.isSupportForMultiQueryInjectionAvailable()){
////                // multiquery injection should be used in case we want to add multiple query injections
////                injection = getMultipleQueryInjections(searchFieldList, searchInfo);
////           }else{
////                injection = getQueryInjection(searchFieldList, searchInfo);   
////           }
////           
////           if(null == injection){
////               if(whereClause.toString().equals("")){                   
////                   if(null != searchInfo.getJoingQuery()){
////                     sql.append(searchInfo.getJoingQuery());
////                   }else{
////                     sql=sql.append(" "); 
////                   }
////               }else{
////                   
////                   if(null != searchInfo.getJoingQuery()){
////                       sql.append(AND).append(searchInfo.getJoingQuery());
////                   }
////               }
////           }else{              
////                   int from = sql.indexOf(FROM) + FROM.length();
////                   String injectedTables = "";
////                   if(searchInfo.isSupportForMultiQueryInjectionAvailable()){
////                        injectedTables = injection.getTablesAsString();
////                       if(injectedTables != null && !injectedTables.equals("") && !injectedTables.trim().endsWith(",")) injectedTables=injectedTables+",";
////                   }else{
////                       injectedTables = getCommaSeperatetTableList(injection.getTableAsList());
////                   }
////                   //TODO fix hack with comma is not required
////                   sql.insert(from," "+injectedTables+" "  /* +", " */);
////                   if(whereClause.toString().equals("")){     
////                       if(null != searchInfo.getJoingQuery()){
////                           sql.append(searchInfo.getJoingQuery());
////                           if(null != injection.getWhere()){
////                                sql.append(AND).append(injection.getWhere());
////                           }else{
////                              sql=sql.append(" ");  
////                           }                           
////                       }else{
////                           if(null != injection.getWhere()){
////                                sql.append(injection.getWhere());
////                           }else{
////                              sql=sql.append(" ");  
////                           }                        
////                       }
////                   }else{                   
////                      if(null != injection.getWhere()){
////                          if(null != searchInfo.getJoingQuery()){
////                              sql.append(AND).append(searchInfo.getJoingQuery());
////                          }
////                          sql.append(AND).append(injection.getWhere());
////                      }
////                   }                 
////                   
////           }
////                
////            int totalFieldsInWhere=1;        
////            sql = sql.append(getCommaSeperatedOrderByList(searchInfo.getOrderByFieldsAsList()));
////            log.debug("Search Query="+sql.toString());
////            PreparedStatement preparedStatement=con.prepareStatement(sql.toString());
////            Object fieldValue = null;
////            String sqlFetchSize = referenceFacade.getSystemParameter(Constants.SystemParameterCode.SQL_FETCH_SIZE);
////            for (int count=0;count<searchFieldList.size();count++){
////                SearchCriteriaFieldInfo searchCriteriaFieldInfo=(SearchCriteriaFieldInfo)searchFieldList.get(count);
////                if(searchCriteriaFieldInfo.getColumnName()!= null &&
////                    searchCriteriaFieldInfo.getColumnName().equalsIgnoreCase("SQLFETCHSIZE")){
////                    sqlFetchSize = (String)searchCriteriaFieldInfo.getFieldValue();
////                }else
////                if(canAddSearchCriteriaToWhereClause(searchCriteriaFieldInfo)){
////                    if(useCriteria(searchCriteriaFieldInfo,searchFieldList)){ 
////                        if(searchCriteriaFieldInfo.getFieldType().equals(Constants.DATE)){
////                            fieldValue = new java.sql.Date(((Date)searchCriteriaFieldInfo.getFieldValue()).getTime());
////                        }else  if(searchCriteriaFieldInfo.getFieldType().equals(Constants.STRING) || 
////                                  searchCriteriaFieldInfo.getFieldType().equalsIgnoreCase(Constants.FORFIELD) ||
////                                  searchCriteriaFieldInfo.getFieldType().equals(Constants.FUZZY)){
////                            fieldValue = ((String)searchCriteriaFieldInfo.getFieldValue()).trim();
////                        }else  if(searchCriteriaFieldInfo.getFieldType().equals(Constants.NUMBER)){
////                            fieldValue = searchCriteriaFieldInfo.getFieldValue();//Long.valueOf((String)searchCriteriaFieldInfo.getFieldValue());
////                        }
////                        String[] columnNames = searchCriteriaFieldInfo.getColumnNames();
////                        for(int i = 0; i < columnNames.length; i++) {
////                            preparedStatement.setObject(totalFieldsInWhere, fieldValue);
////                            totalFieldsInWhere++;
////                        }
////                    }
////                }              
////            }
////
////            if(log.isDebugEnabled())log.debug("sql " + sql);
////            preparedStatement.setMaxRows(Integer.parseInt(sqlFetchSize));
////            log.debug(preparedStatement.toString());
////            ResultSet rs=preparedStatement.executeQuery();  
////            ArrayList<SearchResultInfo> searchData=new ArrayList<SearchResultInfo>();
////            
////            while(rs.next()){
////                ResultSetMetaData resultSetMetaData=preparedStatement.getMetaData();
////                SearchResultInfo row = new SearchResultInfo(); 
////                for(int count=1;count<resultSetMetaData.getColumnCount()+1;count++){
////                    String columnName=resultSetMetaData.getColumnName(count);
////                    int columnType= resultSetMetaData.getColumnType(count);
////                    Object data = null;
////                    switch(columnType){
////                        case OracleTypes.VARCHAR:
////                            data=rs.getString(columnName);
////                        break;
////                        case OracleTypes.DATE:
////                            if(rs.getDate(columnName) != null){
////                                data=DateHelper.getCalendar(rs.getDate(columnName));
////                            }else{
////                                data=rs.getDate(columnName);
////                            }
////                        break;
////                        case OracleTypes.NUMERIC: //TODO: add different check for integer and long and etc
////                            data=rs.getLong(columnName);
////                        break;
////                        case 1:
////                            data=rs.getString(columnName);
////                        break;
////                        
////                        default:if(log.isDebugEnabled())log.debug("Data type not found for generic search framework");
////                            data=rs.getObject(columnName);
////                        break;
////                    }
////                    String tableColumnName = columnName;
////                    
////                    if(tableColumnName != null && tableColumnName.equals(Constants.EntityDefaultValues.DB_ACCESS_LEVEL)) {
////                        row.setAccessLevel((String)data);
////                    }
////                    else {
////                        SearchResultFieldInfo resultFieldInfo = getRespectiveSearchResultFieldInfo(searchInfo,tableColumnName);
////                        ColumnData colData = new ColumnData(
////                            resultFieldInfo.getColumnOrderNbr(), resultFieldInfo.getFieldName(), data);
////                        colData.setColumnName(tableColumnName);
////                        // if the primary key's table name is not an alias name, we can use it for access level update.
////                        // Otherwise, the primary table name that is defined in the xml file should be used.
////                        if(primaryKeyTableName != null && primaryTableExists) {
////                            colData.setTableNameForAccessLevelUpdate(primaryKeyTableName);
////                        }
////                        else {
////                            colData.setTableNameForAccessLevelUpdate(searchInfo.getPrimaryTableName());
////                        }
////                        if(resultFieldInfo.isPrimaryKey()){
////                            row.setPrimaryKey(data);
////                            colData.setPrimaryKey(true);
////                        }
////
////                        colData.setShouldGetValueFromResource(resultFieldInfo.isGetValueFromResources());
////                        row.addColumn(colData);
////                    }
////                }
////                searchData.add(row);
////            }
////            return searchData;
////        
////    }
//
//  private boolean checkTableExists(String tableName,Connection connection) throws InvalidSearchCriteria {
//        String statementCheckTableStr = "select count(*) from  user_tables where table_name= ?";
//        PreparedStatement statementCheckTable = null;
//        ResultSet set = null;
//        try {
//            statementCheckTable = connection.prepareStatement(statementCheckTableStr);
//            statementCheckTable.setObject(1, tableName);
//            set = statementCheckTable.executeQuery();        
//            set.next();
//            Number count = (Number)set.getObject(1);
//           
//            if(count.intValue() > 0)
//                return true;
//            else
//                return false;
//        } catch (SQLException e) {
//            throw new InvalidSearchCriteria(e);
//        }finally{
//            try {
//                if (set != null) {set.close();}
//                if (statementCheckTable != null) {statementCheckTable.close();}
//                
//            } catch (SQLException ex)  {
//                log.error(ex.getLocalizedMessage(), ex);
//            }
//        }
//        
//        
//    }
//
//    private String getCommaSeperatetResultFieldList(SearchInfo searchInfo, String multiAdvancePanelName){
//        ArrayList resultFields=null;
//        if (searchInfo.isMultiSearchAvailable()){
//            resultFields = searchInfo.getResultFieldsAsList(multiAdvancePanelName);
//        }else{
//            resultFields=searchInfo.getResultFieldsAsList();        
//        }
//
//        StringBuffer columnList=new StringBuffer("");
//        for (int count=0;count<resultFields.size();count++){
//            SearchResultFieldInfo searchResultFieldInfo=(SearchResultFieldInfo)resultFields.get(count);
//            if(count != (resultFields.size()-1))
//                columnList=columnList.append(searchResultFieldInfo.getColumnName()).append(",");
//            else
//                columnList=columnList.append(searchResultFieldInfo.getColumnName());
//        }
//        
//        appendAccessLevelToResultFieldList(searchInfo, columnList);
//        
//        return columnList.toString();
//    }
//    
//    private void appendAccessLevelToResultFieldList(SearchInfo searchInfo, StringBuffer columnList) {
//    
//        // prepare the access level column that will be used as a result field and should return us the value.
//        String accessLevelColumn = null;
//        String primaryKeyTableName = searchInfo.getPrimaryKeyTableName();
//        // we should add the table name to the beginning of the column name. TABLE_NAME.COLUMN_NAME.
//        if(primaryKeyTableName != null) {
//            accessLevelColumn = primaryKeyTableName + "." + 
//                Constants.EntityDefaultValues.DB_ACCESS_LEVEL; 
//        }
//        else {
//            accessLevelColumn = Constants.EntityDefaultValues.DB_ACCESS_LEVEL;
//        }            
//        if(accessLevelColumn != null) {
//            columnList.append(", " + accessLevelColumn);
//        }   
//    }
//    private String getCommaSeperatetTableList(ArrayList tables){
//        StringBuffer tableList= new StringBuffer("");
//        for (int count=0;count<tables.size();count++){
//            String table=(String)tables.get(count);
//            
//            if(count != (tables.size()-1))
//                tableList=tableList.append(table).append(",");
//            else
//                tableList=tableList.append(table);
//        }
//        
//        return tableList.toString();
//    }
//    
//    private SearchResultFieldInfo getRespectiveSearchResultFieldInfo(SearchInfo searchInfo,String columnName, String multiAdvancePanelName){
//        ArrayList resultFields=null;
//        if (searchInfo.isMultiSearchAvailable())        {
//            if (searchInfo.getMultiAdvancedSearchAvailable().equals(Constants.SPOTLIGHT)) {
//            resultFields = searchInfo.getResultFieldsAsList(multiAdvancePanelName);
//            }
//            else {
//                resultFields = searchInfo.getResultFieldsAsList(searchInfo.getMultiAdvancePanelName());
//            }
//        }else{
//            resultFields = searchInfo.getResultFieldsAsList();
//        }        
//
//        for (int count=0;count<resultFields.size();count++){
//            SearchResultFieldInfo searchResultFieldInfo=(SearchResultFieldInfo)resultFields.get(count);
//            String v = getColumnName(searchResultFieldInfo);           
//            if(searchResultFieldInfo != null && (v.equalsIgnoreCase(columnName)  || isColName(v, columnName)))
//                return searchResultFieldInfo;
//                
//        }
//        
//        throw new IllegalAccessError("logic error");
//    }
//    
//    
//    private String getColumnName(SearchResultFieldInfo searchResultFieldInfo) {
//        String v = searchResultFieldInfo.getColumnName().substring(searchResultFieldInfo.getColumnName().indexOf(".")+1) ;
//        if(v != null) {
//            if(v.contains(" as ")) {
//                v = v.substring(v.indexOf(" as ") + 4);
//            }
//            else if(v.contains(" AS ")) {
//                v = v.substring(v.indexOf(" AS ") + 4);
//            }
//        }            
//        return v;
//    }
//    
//    private int isConfiguredOfQueryInjection(ArrayList queryInjectionParams,Map queryInjectionFieldsMap) {
//        
//        String configuredInjectionFields = (String)queryInjectionFieldsMap.keySet().iterator().next();
//        String configuredInjectionFieldValues = (String)queryInjectionFieldsMap.values().iterator().next();
//        for(int i=0; i <queryInjectionParams.size(); i++){
//            SearchQueryInjection queryInjection = (SearchQueryInjection)queryInjectionParams.get(i);
//            
//            boolean a = isValidInjectionParam(queryInjection.getForField(),configuredInjectionFields);
//            boolean b = tokenizerMatchValue((String)queryInjection.getWithValue(),configuredInjectionFieldValues,",");
//            if(log.isDebugEnabled())log.debug(queryInjection.getForField() + " - a = " + configuredInjectionFields + " => " + a);
//            if(log.isDebugEnabled())log.debug(queryInjection.getWithValue() + " - b = " + configuredInjectionFieldValues + " => " +b);
//            if(a && b)
//            {                
//                if(log.isDebugEnabled())log.debug("Injection Found");
//                return i; 
//            }
//        }
//        
//        return -1;
//        
//    }
//    
//    private boolean tokenizerMatch(final String x, final String y,String token){
//        String[] xArray = x.split(token);
//        String[] yArray = y.split(token);
//        int matchTest = yArray.length;
//        int matchsFound = 0;
//        for(int i=0; i<xArray.length; i++){
//            for(int j=0; j<yArray.length; j++){
//               if(  xArray[i].equalsIgnoreCase(yArray[j]) ){
//                   matchsFound = matchsFound + 1;
//                   yArray[i] = null;
//               }
//            }
//        }
//        
//        return (matchTest == matchsFound);
//    }
//    
//
//        private static String[] reverse(String[] value2Array) {
//            String[] v = new String[value2Array.length];
//            int index = 0;
//            for(int i=value2Array.length-1; i>=0; i--){
//                v[i]= value2Array[index];
//                index++;
//            }
//            return v;
//        }
//    /**
//       * Checks if the query injection values are equal
//       * @param value1
//       * @param value2
//       * @param token
//       * @return
//       */
//      public boolean  tokenizerMatchValue(final String configuredInjectionFieldValues, final String value2, String token) {
//          boolean isMatched = false;
//
//          /*
//           * decode values
//           */
//          String[] configuredInjectionFieldValueArray = configuredInjectionFieldValues.split(token);
//          String[] value2Array = value2.split(token);
//          configuredInjectionFieldValueArray = decodeInjectionQueryValues(configuredInjectionFieldValueArray);
//          value2Array = decodeInjectionQueryValues(value2Array);
//          String[] backup = Arrays.asList(value2Array).toArray(new String[value2Array.length]);
//          /*
//           * First equality one way
//           */
//          isMatched = Arrays.equals(configuredInjectionFieldValueArray, value2Array);
//          if (!isMatched && (value2Array.length == configuredInjectionFieldValueArray.length)) {//try on different permutations
//              for(int i=0; i<configuredInjectionFieldValueArray.length; i++){
//                  if(configuredInjectionFieldValueArray[i].equals("ANY")){
//                      value2Array[i] = configuredInjectionFieldValueArray[i];
//                  }
//              }
//              int hashCodeConst = Arrays.deepHashCode(configuredInjectionFieldValueArray);           
//              int hashCode = Arrays.deepHashCode(value2Array);
//              
//              isMatched = (hashCodeConst == hashCode);
//              if(!isMatched){//try the reverse
//              for(String x:backup){
////                  log.debug("x2 " +x );
//              }
//                  backup =  reverse(backup);
//                  for(String x:backup){
////                      log.debug("x2 " +x );
//                  }
//                  for(int i=0; i<configuredInjectionFieldValueArray.length; i++){
//                      if(configuredInjectionFieldValueArray[i].equals("ANY")){
//                          backup[i] = configuredInjectionFieldValueArray[i];
//                      }
//                  }
//                  hashCodeConst = Arrays.deepHashCode(configuredInjectionFieldValueArray);           
//                  hashCode = Arrays.deepHashCode(backup);
//                  
//                  isMatched = (hashCodeConst == hashCode);
//              }
//          }
//          return isMatched;
//      }
//      
//      /**
//       * Decodes the injection values i.e the % to ANY
//       * @param values
//       * @return
//       */
//      public  String[] decodeInjectionQueryValues(String[] values) {
//          for (int i = 0; i < values.length; i++) { //encode the values    
//              if (values[i].contains("%")) {
//                  values[i] = values[i].replace("%", "ANY");
//              }
//          }
//          return values;
//      }    
//  
//    private Map getSearchCriteriaFieldsViaSelection(ArrayList queryInjectionParams,SearchCriteriaFieldInfo criteriaInfo){
//       
//        HashMap map =  null;
//        for(int i=0; i <queryInjectionParams.size(); i++){
//            SearchQueryInjection queryInjection = (SearchQueryInjection)queryInjectionParams.get(i);
//           
//            if(queryInjection.getForField().equalsIgnoreCase(criteriaInfo.getFieldName()) 
//                && criteriaInfo.getFieldValue() != null
//                && !criteriaInfo.getFieldValue().toString().equalsIgnoreCase("")){
//              if(log.isDebugEnabled())log.debug("^Match Found ForField:" + queryInjection.getForField() + " with criteriaInfo field Name " + criteriaInfo.getFieldName());
//              
//                map = new HashMap();
//                map.put(queryInjection.getForField(),criteriaInfo.getFieldValue());
//                break;
//            }
//        }
//        
//       
//        return map;
//    }
//   
//    /**
//     * Gets the query injection from the search info
//     * @param searchFieldList
//     * @param searchInfo
//     * @return
//     */
//    private SearchQueryInjection getQueryInjection(ArrayList searchFieldList,SearchInfo searchInfo) {
//        Map injectionFieldsMap = null;
//        StringBuilder injectionFields = new StringBuilder();
//        StringBuilder injectionFieldValues = new StringBuilder();
//        /*
//         * Examine all the search fields
//         */
//        for (int count=0;count<searchFieldList.size();count++){
//            SearchCriteriaFieldInfo searchCriteriaFieldInfo=(SearchCriteriaFieldInfo)searchFieldList.get(count);
//            
//            injectionFieldsMap = getSearchCriteriaFieldsViaSelection(searchInfo.getSearchInjectedQuery(),searchCriteriaFieldInfo);
//            
//            if(null != injectionFieldsMap){
//                
//                injectionFields.append(searchCriteriaFieldInfo.getFieldName());
//                injectionFieldValues.append(injectionFieldsMap.values().iterator().next());
//                if(log.isDebugEnabled())log.debug("append " + injectionFields);
//                if(count!=searchFieldList.size()-1){
//                    injectionFields.append(",");
//                    injectionFieldValues.append(",");
//                }                
//                injectionFieldsMap = null;
//            }
//        }
//        
//        if( injectionFields.toString().endsWith(",")){
//           injectionFields = injectionFields.delete(injectionFields.length()-1,injectionFields.length());
//        }
//        
//        if( injectionFieldValues.toString().startsWith(",")){
//           injectionFields = injectionFields.delete(0,1);
//        }
//        
//        if( injectionFieldValues.toString().endsWith(",")){
//           injectionFieldValues = injectionFieldValues.delete(injectionFieldValues.length()-1,injectionFieldValues.length());
//        }
//        
//        if( injectionFieldValues.toString().startsWith(",")){
//           injectionFieldValues = injectionFieldValues.delete(0,1);
//        }
//        
//        injectionFieldsMap = new HashMap();
//        injectionFieldsMap.put(injectionFields.toString(),injectionFieldValues.toString());
//         
//      
//        if(log.isDebugEnabled())log.debug("Number of query injections " + searchInfo.getSearchInjectedQuery().size());
//        SearchQueryInjection injection = null;
//        for (int count=0;count<searchFieldList.size();count++){
//            SearchCriteriaFieldInfo searchCriteriaFieldInfo=(SearchCriteriaFieldInfo)searchFieldList.get(count);            
//            if(searchCriteriaFieldInfo.getFieldValue()!=null && !searchCriteriaFieldInfo.getFieldValue().toString().equals(Constants.BLANK)){            
//                int index = -1;
//                
//                 if(log.isDebugEnabled())log.debug("Checking field for injection configuration:" + injectionFieldsMap);
//                   index = isConfiguredOfQueryInjection(searchInfo.getSearchInjectedQuery(),
//                            injectionFieldsMap);
//              
//                
//                if(index >= 0 ){
//                   // injectionFound = true;
//                    injection = (SearchQueryInjection)searchInfo.getSearchInjectedQuery().get(index);
//                    break;
//               }else{
//                   if(log.isDebugEnabled())log.debug("rejected -> " + searchCriteriaFieldInfo.getFieldValue());
//               }
//            }
//            
//        }   
//        
//        return injection;
//    }
//    
//    
//    private SearchQueryInjection getQueryInjectionIfAvailable(ArrayList<SearchQueryInjection> injections, SearchCriteriaFieldInfo criteriaField, String advancedCriteriaForField){
//    
//        if(criteriaField.getFieldType().equals(Constants.SPOTLIGHT) && advancedCriteriaForField != null && !advancedCriteriaForField.equals(Constants.BLANK)){
//            // here we have to get the injection with the value equal to advancedCriteriaForField
//             if(injections != null){
//                 for (SearchQueryInjection injection: injections){
//                     // if injection is present for "forField" and the value mathces then return
//                     if (injection != null && injection.getWithValue().equals(advancedCriteriaForField)){
//                         return injection;
//                     }
//                     
//                 }
//             }
//        }else{
//            if(injections != null){
//                for (SearchQueryInjection injection: injections){
//                    // if injection is present for "forField" and the value mathces then return
//                    if (injection != null && injection.getForField().equals(criteriaField.getFieldName()) 
//                            && (criteriaField.getFieldValue() !=null && 
//                                    injection.getWithValue().equals(criteriaField.getFieldValue().toString()))){
//                        return injection;
//                    }
//                    
//                }
//            }
//        }
//        return null;
//    }
//    
//    
///**
//     * This method is used to get multiple query injections, assuming that it will not have "," seperated values
//     * @param searchFieldList
//     * @param searchInfo
//     * @return
//     */
//    private SearchQueryInjection getMultipleQueryInjections(ArrayList<SearchCriteriaFieldInfo> searchFieldList, SearchInfo searchInfo, String advancedCriteriaForField) {
//
//        StringBuilder injectionTables = new StringBuilder();
//        StringBuilder injectionWhere = new StringBuilder();
//        // loop through the search fields and see which all fields have value
//        // for each of the field if the value is provided than lookup for the injection
//        // if injection is available get table and where clause and add it to the list
//        String value = "";
//        if(searchInfo.getMultiAdvancedSearchAvailable().equals(Constants.SPOTLIGHT)){
//            if(searchInfo.getSearchFieldsAsList() != null && searchInfo.getSearchFieldsAsList().size() > 0){
//                SearchCriteriaFieldInfo criteriaFieldInfo = (SearchCriteriaFieldInfo)searchInfo.getSearchFieldsAsList().get(0);
//                if(criteriaFieldInfo != null){
//                    value = (String)criteriaFieldInfo.getFieldValue();
//                }
//            }
//        }
//
//
//        for (SearchCriteriaFieldInfo criteriaFieldInfo : searchFieldList){
//            // check if the value is provided for the field
//            
//            if (criteriaFieldInfo != null && ((criteriaFieldInfo.getFieldValue() != null && 
//                    !criteriaFieldInfo.getFieldValue().toString().equals(Constants.BLANK)) || value != null )){
//                    if(searchInfo.getMultiAdvancedSearchAvailable().equals(Constants.SPOTLIGHT) && value != null) {
//                        criteriaFieldInfo.setFieldValue( value );
//                    }
//                    
//                // field has value so check if the injection is available
//                 SearchQueryInjection injection = getQueryInjectionIfAvailable(searchInfo.getSearchInjectedQuery(), criteriaFieldInfo, advancedCriteriaForField);        
//                 if(injection != null){
//                    // injection is available so add it to the fields to return
//                     String tables = getCommaSeperatetTableList(injection.getTableAsList());
//                     if(tables != null){
//                         if (!injectionTables.toString().equals(Constants.BLANK) &&
//                                !injectionTables.toString().endsWith(",")){
//                             injectionTables.append(",");
//                         }
//                         injectionTables.append(tables);
//                     }
//
//                    // append where clause
//                     if(injection.getWhere() != null){
//                         if (!injectionWhere.toString().equals(Constants.BLANK)){
//                             injectionWhere.append(" AND ");
//                         }
//                         injectionWhere.append(injection.getWhere());
//                         String condition = determineQICondition(searchInfo,injection);
//                         if(null == condition){
//                             //do nothing
//                         }else{
//                             injectionWhere.append(" " + condition);
//                         }
//                     }
//                 }            
//            }
//        }
//        
//        if (!injectionTables.toString().equals(Constants.BLANK) || !injectionWhere.toString().equals(Constants.BLANK)){
//            SearchQueryInjection injection = new SearchQueryInjection("","",injectionWhere.toString());
//            injection.setTablesAsString(injectionTables.toString());
//            return injection;
//        }
//        return null;
//    }
//
//
//    /**
//     * Checks if this searchCriteriaFieldInfo has a fieldLink and that link is connected
//     * <br> then check if the fieldLinkValue is valid. i.e the link is valid
//     * @param searchCriteriaFieldInfo
//     * @param searchFieldList
//     * @return
//     */
//    private boolean useCriteria(SearchCriteriaFieldInfo searchCriteriaFieldInfo, 
//                                ArrayList searchFieldList) {
//      ArrayList  copy = new ArrayList(searchFieldList);     
//      
//      String fieldLink =  searchCriteriaFieldInfo.getFieldLink();
//      String fieldLinkValue =  searchCriteriaFieldInfo.getFieldLinkValue();
//     
//      boolean isLinked = false;
//      boolean isValid = false;
//      
//      if(fieldLink == null && fieldLinkValue == null){
//          isLinked = true; isValid = true;
//      }else{
//          for (int count=0;count<copy.size();count++){
//              SearchCriteriaFieldInfo aCriteria = (SearchCriteriaFieldInfo)copy.get(count);
//              if(aCriteria.getFieldName().equalsIgnoreCase(fieldLink)){
//                  isLinked = true;
//                  
//                  if(aCriteria.getFieldValue() != null &&
//                        aCriteria.getFieldValue().toString().equalsIgnoreCase(fieldLinkValue)){
//                      isValid = true;
//                      break;
//                  }
//              }
//          }
//      }      
//      
//      return isLinked && isValid;
//    }
//
//    private String getQueryType(SearchInfo searchInfo) {
//        if(null == searchInfo.getQueryType()){
//            return "";
//        }else{
//            return searchInfo.getQueryType();
//        }        
//    }
//
//    private String getCommaSeperatedOrderByList(ArrayList orderByColumns){
//        String strOrderBy = " order by ";
//        StringBuffer orderByList= new StringBuffer("");
//        if (orderByColumns != null){
//            for (int count=0;count< orderByColumns.size();count++){
//                SearchOrderByInfo orderByInfo = (SearchOrderByInfo)orderByColumns.get (count);
//                if (orderByInfo != null){
//                    if(count > 0){ //column is already added so add a ","
//                        orderByList=orderByList.append(",");
//                    } 
//                    
//                    orderByList=orderByList.append("UPPER(" + orderByInfo.getColumnName() + ")" );
//                    
//                    if (orderByInfo.getOrder() != null && !orderByInfo.getOrder().equals("")){
//                        orderByList=orderByList.append(" ").append(orderByInfo.getOrder());
//                    } else {
//                        orderByList=orderByList.append(" DESC "); // by default the order by is done in desc order
//                    }                
//                }
//            }        
//        }
//         
//        if (orderByList.length() > 0)
//            return strOrderBy + orderByList.toString();
//        else
//            return "";
//    }
//    
//    private boolean canAddSearchCriteriaToWhereClause(SearchCriteriaFieldInfo searchCriteriaFieldInfo) {
//        boolean tested = searchCriteriaFieldInfo.getFieldValue() != null && 
//                            !searchCriteriaFieldInfo.getFieldValue().toString().equals(Constants.BLANK) &&
//                             searchCriteriaFieldInfo.getColumnName() != null && 
//                             !searchCriteriaFieldInfo.getColumnName().equals("");
//    
//        if(tested){
//            if(searchCriteriaFieldInfo.getColumnName().equalsIgnoreCase("SQLFETCHSIZE")  ||
//                searchCriteriaFieldInfo.getColumnName().equalsIgnoreCase(Constants.STATIC_SEARCH_INJECTION)){
//                tested = false;
//            }
//        }
//        
//        return tested;
//    }
//    
//    private String getFuzzyWhereClause(SearchCriteriaFieldInfo fuzzyInfo) {
//        return (fuzzyInfo == null || fuzzyInfo.getFieldValue() == null) ? null : "contains("+fuzzyInfo.getColumnName()+", ?) > 0 ";
//    }
//
//    private StringBuffer  getWhereClause(ArrayList searchFieldList, StringBuffer whereClause){
//        for (int count=0;count<searchFieldList.size();count++){
//            SearchCriteriaFieldInfo searchCriteriaFieldInfo=(SearchCriteriaFieldInfo)searchFieldList.get(count);
//                            
//            if(canAddSearchCriteriaToWhereClause(searchCriteriaFieldInfo)){
//                
//                if(useCriteria(searchCriteriaFieldInfo,searchFieldList)){ 
//                    String operator="=";
//                    if(!StringHelper.returnBlankIfNull(searchCriteriaFieldInfo.getOperator()).equals(Constants.BLANK) ){
//                        operator=searchCriteriaFieldInfo.getOperator();
//                    }
//                    if(whereClause.length() > 0){
//                        whereClause=whereClause.append(AND);
//                    }
//                
//                    String[] columnNames = searchCriteriaFieldInfo.getColumnNames();
//                    for(int i = 0; i < columnNames.length; i++) {
//                        String columnName = columnNames[i];
//                        String clauseForCol = null;
//                        String alternateClauseForCol = null;
//                        clauseForCol = buildWhereClauseForCriteria(searchCriteriaFieldInfo, columnName, operator);
//                        if(searchCriteriaFieldInfo.getAlternateColumn() != null){
//                            alternateClauseForCol = buildWhereClauseForCriteria(searchCriteriaFieldInfo, searchCriteriaFieldInfo.getAlternateColumn(), operator);
//                            whereClause.append("(").append(clauseForCol).append(" OR ").append(alternateClauseForCol).append(")");
//                        }else{
//                            whereClause.append(clauseForCol);
//                        }
//                       
//                        if(i != columnNames.length - 1) {
//                            whereClause = whereClause.append(AND);
//                        }
//                    }
//                    if(log.isDebugEnabled())log.debug("whereClause " + whereClause);
//                }
//            }
//        }
//        return whereClause;
//    }
//    
//    private String buildWhereClauseForCriteria(SearchCriteriaFieldInfo searchCriteriaFieldInfo, 
//                                                                String columnName, String operator) {
//        //TODO Kemal: Using upper in search criterias on the left hand side creates a performance problem when the data is big, the query
//        // becomes very slow, we should consider that. May be every data should be entered in upper case to the database.
//
//        StringBuffer whereClauseX = new StringBuffer();
//        
//        if( searchCriteriaFieldInfo.getFieldType().equals(Constants.FORFIELD) ){           
//            if (columnName != null){
//                whereClauseX.append("(");
//                whereClauseX.append("UPPER("+columnName+")").append(" like UPPER(?) "); 
//                if(isFunction("SOUNDEX",searchCriteriaFieldInfo.getFieldFunction()) && searchCriteriaFieldInfo.getFieldValue() != null)                
//                whereClauseX.append(" OR SOUNDEX("+columnName+")").append(" = SOUNDEX('"+((String)searchCriteriaFieldInfo.getFieldValue()).replaceAll("'","''")+"') ");
//                whereClauseX.append(")");
//            }else{
//                whereClauseX.append("(");
//                whereClauseX.append("'"+searchCriteriaFieldInfo.getFieldValue().toString().trim().toUpperCase() + "'").append(" = UPPER(?)");    
//                if(isFunction("SOUNDEX",searchCriteriaFieldInfo.getFieldFunction()) && searchCriteriaFieldInfo.getFieldValue() != null)
//                whereClauseX.append(" OR SOUNDEX('"+((String)searchCriteriaFieldInfo.getFieldValue()).replaceAll("'","''").toString().trim().toUpperCase() + "')").append(" = SOUNDEX('"+searchCriteriaFieldInfo.getFieldValue()+"')"); 
//                whereClauseX.append(")");
//            }
//        // if the field is not a dropdown and if the field is not a date component, we should put a "like" check into the criteria because
//        // the user may have entered a "%" to the field in order to see every result according to that field. 
//        // If it is a dropdown, we don't need to put "like" check because the user will select the value which will be an exact value always.            
//        }else if((searchCriteriaFieldInfo.getFieldType().equalsIgnoreCase(Constants.STRING)) && 
//            (searchCriteriaFieldInfo.getListId() == null || searchCriteriaFieldInfo.getListId().equals(""))){
//            
//            if(searchCriteriaFieldInfo.getFieldValue() != null && searchCriteriaFieldInfo.getFieldValue().toString().contains("%")) {
//                if(searchCriteriaFieldInfo.getFieldValue() != null && searchCriteriaFieldInfo.getFieldValue().toString().equals("%")) {
//                    whereClauseX.append("("+columnName+"").append(" like ? OR "+ columnName+" is null)");
//                }
//                else {
//                    whereClauseX.append("(");
//                    whereClauseX.append("UPPER("+columnName+")").append(" like UPPER(?) "); // TRGHA-2865 : Oracle works case insensitive, right side UPPER violates indexes
//                    //whereClauseX.append(columnName).append(" like UPPER(?) ");   // TRGHA-11239 we need this uppercase
//                    if(isFunction("SOUNDEX",searchCriteriaFieldInfo.getFieldFunction()) && null != searchCriteriaFieldInfo.getFieldValue())
//                        whereClauseX.append(" OR SOUNDEX("+columnName+")").append(" = SOUNDEX('"+((String)searchCriteriaFieldInfo.getFieldValue()).replaceAll("'","''")+"')");
//                    whereClauseX.append(")");
//                }
//                
//            }else{
//                whereClauseX.append("(");
//                whereClauseX.append(columnName).append(" = ? ");
//                if(isFunction("SOUNDEX",searchCriteriaFieldInfo.getFieldFunction()) && null != searchCriteriaFieldInfo.getFieldValue()){
//                    whereClauseX.append(" OR SOUNDEX("+columnName+")").append(" = SOUNDEX('"+((String)searchCriteriaFieldInfo.getFieldValue()).replaceAll("'","''")+"')");
//                }
//                whereClauseX.append(")");
//            }
//        }else if(searchCriteriaFieldInfo.getFieldType().equals(Constants.DATE)){                        
//            whereClauseX.append("TRUNC("+columnName+")").append(operator).append(" TRUNC(?) ");
//        }else if(searchCriteriaFieldInfo.getFieldType().equalsIgnoreCase(Constants.NUMBER)){
//            whereClauseX.append(columnName).append(operator).append(" ? ");
//        }else if(searchCriteriaFieldInfo.getFieldType().equals(Constants.FUZZY)) {
//            whereClauseX.append( getFuzzyWhereClause(searchCriteriaFieldInfo));
//        }
//        else{
//            whereClauseX.append(columnName).append(operator).append(" ? ");                            
//        }
//        return whereClauseX.toString();
//    }
//
//
//    private boolean isColName(String columnName, String resultFieldName){
//        if (resultFieldName == null || columnName == null){
//            return false;
//        }
//        resultFieldName = resultFieldName.toUpperCase();
//        columnName = columnName.toUpperCase();
//        return columnName.indexOf("' "+resultFieldName) > -1?true:false;        
//    }
//
//    private boolean isValidInjectionParam(String firstString,String secondString){
//       boolean matchFound = false;
//       int numberOfMatch = 0;
//       if(firstString != null && firstString.length() !=0 && secondString != null && secondString.length() !=0){
//           firstString = firstString.trim();
//           secondString = secondString.trim();
//           int wordsInfirstString = StringHelper.numberOfWords(firstString);
//           int wordsInsecondString = StringHelper.numberOfWords(secondString);
//           if(wordsInfirstString != wordsInsecondString){
//               return matchFound;
//           }else{
//               if(wordsInfirstString ==1){
//                   if(secondString.equalsIgnoreCase(firstString))
//                       numberOfMatch++;
//               }else{
//                   if(firstString.length() == secondString.length()){
//                       int prevPos=0;
//                       Character c= ',';
//                       for(int i=0;i<firstString.length();i++){
//                           if(firstString.charAt(i) ==c){
//                               String word = firstString.substring(prevPos,i);
//                               prevPos =i;
//                               firstString = firstString.substring(prevPos,firstString.length());
//                               if(secondString.contains(word))
//                                   numberOfMatch++;
//                           }
//                       }
//                       if(prevPos != 0){
//                           String word = firstString.substring(1,firstString.length());
//                           if(secondString.contains(word))
//                               numberOfMatch++;
//                       }
//                   } 
//               }
//               if(numberOfMatch == wordsInfirstString)
//                   matchFound = true;
//               return matchFound;
//           }
//       }else{
//           return matchFound;
//       }
//    }
//    
//    public static void main(String[] args) {
//        String zzz = "adfdffadfad";
//        String[] array = zzz.split(",");
////        log.debug(array);
////        String searchStr =  "select o from SavedSearch o where adfadf and ";
////        // make the query string correct.
////        if(searchStr.endsWith("where ")) {
////            searchStr = searchStr.substring(0, searchStr.indexOf("where "));
////        }
////        else if(searchStr.endsWith("and ")) {
////            searchStr = searchStr.substring(0, searchStr.lastIndexOf("and "));
////        }
////        log.debug(searchStr);
//    }
//    
//    
//    /**
//     * Checks if there is a criteria value entered by the user.
//     * 
//     * @param searchInfo
//     * @return
//     */
//    public boolean hasCriteria(SearchInfo searchInfo) {
//        boolean hasCriteria = false;    
//        TreeMap treeMap = searchInfo.getSearchFields(); //;
//        Iterator iter = treeMap.entrySet().iterator();
//        while (iter.hasNext()) {
//              Map.Entry entry = (Map.Entry)iter.next();
//              SearchCriteriaFieldInfo criteriaField = 
//                  (SearchCriteriaFieldInfo)entry.getValue();
//             if(null != criteriaField.getFieldValue() && !criteriaField.getFieldValue().toString().equalsIgnoreCase("") ){
//                 hasCriteria = true;
//                 break;
//             }
//          }     
//          TreeMap advTreeMap = null;
//          if(searchInfo.isMultiSearchAvailable()){
//          
//              if (searchInfo.getMultiAdvancedSearchAvailable().equals(Constants.SPOTLIGHT)) {
//                advTreeMap =  (TreeMap)searchInfo.getAdvancedSearchFields().get(searchInfo.getAdvancedSearchFields().firstKey());
//                  hasCriteria = true;
//              } 
//              if(searchInfo.getMultiAdvancePanelName() != null && 
//                  !searchInfo.getMultiAdvancePanelName().equals("")){
//                        advTreeMap = searchInfo.getAdvancedSearchFields(searchInfo.getMultiAdvancePanelName() ); 
//                  }else{ 
//                      advTreeMap = searchInfo.getAdvancedSearchFields(); 
//                  }
//          }else{
//              advTreeMap = searchInfo.getAdvancedSearchFields(); 
//          }
//          
//          iter = advTreeMap.entrySet().iterator();
//          while (iter.hasNext()) {
//              Map.Entry entry = (Map.Entry)iter.next();
//              SearchCriteriaFieldInfo criteriaField = null;
//              if(entry.getValue() instanceof SearchCriteriaFieldInfo){    
//                  criteriaField = (SearchCriteriaFieldInfo)entry.getValue();    
//              }
//              if(criteriaField != null && null != criteriaField.getFieldValue() && !criteriaField.getFieldValue().toString().equalsIgnoreCase("") ){
//                  hasCriteria = true;
//                  break;
//              }
//          }  
//        return hasCriteria;
//    }
//
//    /**
//     * Persists the search criteria values to the database.
//     * 
//     * @param searchInfo
//     * @return reference no of the saved search.
//     * @throws CriteriaRequiredException
//     */
//    public String saveSearch(SearchInfo searchInfo, String saveSearchName) throws CriteriaRequiredException {
//        // if the user did not enter any criteria, throw an exception.
//        boolean hasCriteria = hasCriteria(searchInfo);
//        if(!hasCriteria)
//            throw new CriteriaRequiredException();
//        // there can be search criterias and advanced search criterias. So we should merge these two criteria values within
//        // a list.
//        ArrayList searchFieldList=searchInfo.getSearchFieldsAsList();    
//        ArrayList advancedList = searchInfo.getAdvancedSearchFieldsAsList();
//        if(advancedList != null)
//            searchFieldList.addAll(searchInfo.getAdvancedSearchFieldsAsList());
//        // now searchFieldList contains the user inputs that the user entered to the search criterias.
//        // create the saved search pojo, pass the user inputs and persist it.
//        SavedSearch savedSearch = new SavedSearch();
//        savedSearch.setSearchDate(DateHelper.getSqlTimestampWithoutTime(Calendar.getInstance()));
//        // Get the logged in user id.
//        savedSearch.setSearchedBy(sessionContext.getCallerPrincipal().getName());
//        savedSearch.setSearchName(saveSearchName);
//        savedSearch.setSearchType(searchInfo.getSearchId());
//        // create the savedsearchfield pojos which will contain the user inputs.
//        for (int count=0;count<searchFieldList.size();count++){
//            SearchCriteriaFieldInfo searchCriteriaFieldInfo=(SearchCriteriaFieldInfo)searchFieldList.get(count);
//            if(searchCriteriaFieldInfo.getFieldValue() != null &&
//               !StringHelper.returnBlankIfNull(searchCriteriaFieldInfo.getFieldValue().toString()).equals(Constants.BLANK)){        
//                SavedSearchField field = new SavedSearchField();
//                field.setFieldName(searchCriteriaFieldInfo.getFieldName());
//                field.setFieldValue(searchCriteriaFieldInfo.getFieldValue().toString());
//                savedSearch.addSavedSearchField(field);
//            }
//        }
//        // persist it.
//        savedSearch = persistEntity(savedSearch);
//        if(savedSearch != null)
//            // return reference no.
//            return savedSearch.getReferenceNo();
//        else
//            return null;
//    }
//    
//    /**
//     * Finds the field names that will be used as search parameters in search in saved search page.
//     * @param searchName
//     * @return
//     */
//    public List<String> findOptionalSearchFields(String searchName) {
//        List results = em.createQuery("select o.fieldName from RefOptSearchField o where o.searchName = ?1 order by o.fieldOrder")
//        .setParameter(1,String.valueOf(searchName))
//        .getResultList();
//        return results;
//    }
//    
//    /**
//     * Finds the field names that will be used as result field columns of the result table in search in saved search page.
//     * @param searchName
//     * @return
//     */
//    public List<String> findOptionalSearchResultFields(String searchName) {
//        List results = em.createQuery("select o.fieldName from RefOptSearchResultField o where o.searchName = ?1 order by o.fieldOrder")
//        .setParameter(1,String.valueOf(searchName))
//        .getResultList();
//        return results;
//    }
//    
//    /**
//     * Finds the savedsearch results from the database. It returns them as list of map. The key of the map element is 
//     * the attribute name of the savedsearch.
//     * @param searchParams
//     * @return
//     */
//    public List<Map> findSavedSearchResults(SavedSearchDTO searchParams) {
//        if(searchParams == null)
//            return new ArrayList<Map>();
//            
//        // create the search string dynamically by looking at the dto.
//        StringBuffer buffer = new StringBuffer("select o from SavedSearch o where o.searchType = '"+ searchParams.getSearchType() + "' and ");
//        if(searchParams.getReferenceNo() != null && !searchParams.getReferenceNo().equals("")) {
//            buffer.append("o.referenceNo like '"+searchParams.getReferenceNo() + "' and ");
//        }
//        
//        if(searchParams.getSearchedBy() != null && !searchParams.getSearchedBy().equals("")) {
//            buffer.append("o.searchedBy like '"+searchParams.getSearchedBy()+ "' and ");
//        }
//        
//        if(searchParams.getSearchName() != null && !searchParams.getSearchName().equals("")) {
//            buffer.append("o.searchName like '"+searchParams.getSearchName()+ "' and ");
//        }
//        
//        if(searchParams.getSearchDateFrom() != null && searchParams.getSearchDateTo() != null) {
//            buffer.append("o.searchDate >= '"+searchParams.getSearchDateFrom()+ 
//                "' and o.searchDate <= '" +searchParams.getSearchDateTo()+ "' and ");
//        }
//        else if(searchParams.getSearchDateFrom() != null) {
//            buffer.append("o.searchDate >= '"+searchParams.getSearchDateFrom()+ "' and ");
//        }
//        else if(searchParams.getSearchDateTo() != null) {
//            buffer.append("o.searchDate <= '"+searchParams.getSearchDateTo()+ "' and ");
//        } 
//        String searchStr = buffer.toString();
//        // make the query string correct.
//        if(searchStr.endsWith("where ")) {
//            searchStr = searchStr.substring(0, searchStr.indexOf("where "));
//        }
//        else if(searchStr.endsWith("and ")) {
//            searchStr = searchStr.substring(0, searchStr.lastIndexOf("and "));
//        }
//        // make the search.
//        List<SavedSearch> results = em.createQuery(searchStr)
//        .getResultList();
//        if(results == null || results.size() == 0)
//            return new ArrayList<Map>();
//        
//        // if we have additional search fields, narrow the result by looking at them.
//        Iterator itr = searchParams.getAdditionalSearchFields().keySet().iterator();
//        while(itr.hasNext()) {
//            String fieldName = (String)itr.next();
//            // we are looking for the not-null fieldname-fieldvalue pair.
//            if(searchParams.getAdditionalSearchFields().get(fieldName) == null)
//                continue;
//            String fieldValue = searchParams.getAdditionalSearchFields().get(fieldName).toString();
//            if(fieldValue.equals(""))
//                continue;
//            // now check if this fieldname-fieldvalue pair exists in the savedsearch results.
//            // If it does not exist, then remove it from the results.
//            for (int i = 0; i < results.size();)  {
//                SavedSearch ss = results.get(i);
//                if(!ss.containsField(fieldName, fieldValue))
//                    results.remove(ss);
//                else
//                    i++;
//            }
//        }
//        // convert the list of savedsearch results to the list of map results.
//        List<Map> resultsMap = new ArrayList<Map>();
//        for (int i = 0; i < results.size(); i++)  {
//            SavedSearch ss = results.get(i);
//            resultsMap.add(ss.convertToMap());
//        }
//        return resultsMap;
//    }
//    
//    /**
//     * Filters the result list by looking at the access level and returns the filtered list.
//     * @param resultInfos
//     * @param accessLevel
//     * @return
//     */
//    public List<SearchResultInfo> filterResultInfoList(List<SearchResultInfo> resultInfos, String accessLevel) {
//        if(accessLevel == null)
//            return resultInfos;
//        List<SearchResultInfo> filteredList = new ArrayList<SearchResultInfo>();
//        for(SearchResultInfo info:resultInfos) {
//            if(info.getAccessLevel() != null && info.getAccessLevel().equals(accessLevel)) {
//                filteredList.add(info);
//            }
//        }
//        return filteredList;
//    }
//    
//    /**
//     * updates the results with the new access level defined. 
//     * @param resultInfos
//     * @return
//     */
//     public boolean updateResultsWithNewAccessLevel(List<SearchResultInfo> resultInfos) {
//         if(resultInfos == null)
//             return false;
//         PreparedStatement statement = null;
//         Connection connection = null;
//         try {
//             connection = referenceFacade.getDataSource().getConnection();
//             for(SearchResultInfo resultInfo:resultInfos) {
//                 ColumnData data = resultInfo.getSugguestedPrimaryKey();
//                 if(data == null || data.getValue() == null)
//                     continue;
//                 Object primaryKeyValue = data.getValue();
//                 String primaryKeyColName = data.getColumnName();
//                 String accessLevel = resultInfo.getAccessLevel();
//                 String tableName = data.getTableNameForAccessLevelUpdate();
//                 String statementStr = "UPDATE "+tableName + " SET "+ 
//                     Constants.EntityDefaultValues.DB_ACCESS_LEVEL + " = ? " +
//                     "WHERE " + primaryKeyColName + " = ?";
//                 statement = connection.prepareStatement(statementStr);
//                 statement.setString(1, accessLevel);
//                 statement.setObject(2, primaryKeyValue);
//                 statement.execute();
//             }             
//         } catch (SQLException e) {
//             log.error(Constants.ModuleName.GENERIC_SEARCH, e);
//             return false;
//         }finally{
//             try {
//                 if (statement != null) {statement.close();}
//                 
//             } catch (SQLException ex)  {
//                 log.error(ex.getLocalizedMessage(), ex);
//             }
//             
//             if ( connection != null )
//                  {
//                     try {
//                        connection.close();
//                     }
//                     catch( SQLException sqlException ){}
//                  }
//         }
//         return true;
//     }
//    
//    /**
//     * Injects the access level where clause in order to hide some of the rows from the user that he should not see.
//     * @param searchInfo
//     * @param whereClause
//     */
//    private void injectAccessLevelQuery(SearchInfo searchInfo, 
//                                        StringBuffer whereClause) {
////        CasUser user = new CasUser();
////        user.setUsername(sessionContext.getCallerPrincipal().getName());
////        CasUser realUser = secFacade.findCasUser(user);
////        if (realUser != null) {
////            String accessLevel = realUser.getAccessLevel();
////            if (accessLevel != null) {
////                String primaryKeyTableName = "";
////                if (searchInfo.getMultiAdvancedSearchAvailable().equals(Constants.SPOTLIGHT)) {
////                    primaryKeyTableName = searchInfo.getPrimaryTableName();
////                } else {
////                    primaryKeyTableName = searchInfo.getPrimaryKeyTableName();
////                }
////                String accessLevelQuery = 
////                    " (" + primaryKeyTableName + "." + Constants.EntityDefaultValues.DB_ACCESS_LEVEL + 
////                    " <= '" + accessLevel + "' OR " + primaryKeyTableName + 
////                    "." + Constants.EntityDefaultValues.DB_ACCESS_LEVEL + 
////                    " IS NULL ) ";
////                if (whereClause == null || whereClause.toString().equals("")) {
////                    whereClause.append(accessLevelQuery);
////                } else {
////                    whereClause.append(" AND " + accessLevelQuery);
////                }
////            }
////        }
//    }
//    
//    private String joinAccessLevelQuery(String queryOrg) {
//        String query = queryOrg.toUpperCase(); 
//        String s2 = 
//        
//            query.substring((query.toUpperCase().indexOf("FROM") + 4), query.toUpperCase().indexOf("WHERE"));
//        StringTokenizer st = new StringTokenizer(s2, ",");
//        log.debug("*** COUNT **** " + st.countTokens());
//        int count = st.countTokens();
//        if (st.countTokens() == 1) {
//            st = new StringTokenizer(s2, " ");
//        }
//
//        String strForAccess = null;
//
//        while (st.hasMoreElements()) {
//            String str = st.nextToken();
//            log.debug(" TOKEN " + str);
//            if (str.contains("ENT_ENTITY")) {
//                System.out.println(" STR -->  " + str);
//                String nextToken = null;
//                if(st.hasMoreTokens()){
//                    nextToken = st.nextToken();
//                }
//                log.debug(" Next Token -- " + nextToken);
//                if (count == 1) {
//                    if (!nextToken.trim().equalsIgnoreCase("ON") && 
//                        !nextToken.trim().equalsIgnoreCase("JOIN") && 
//                        !nextToken.trim().equalsIgnoreCase("LEFT") 
//                        ) {
//                        strForAccess = nextToken;
//                    } else {
//                        strForAccess = str;
//                    }
//                } else {
//                    str = str.substring(str.indexOf("ENT_ENTITY") + 10);
//                    strForAccess = str;
//                    if(str.trim().equalsIgnoreCase("")){
//                        strForAccess ="ENT_ENTITY";
//                    }
//                }
//
//                break;
//            }
//        }
//        
////        CasUser user = new CasUser();
////        user.setUsername(sessionContext.getCallerPrincipal().getName());
////        CasUser realUser = secFacade.findCasUser(user);
////        String accessLevelQuery = null;
////        boolean accessLevelAdded = false;
////        if (realUser != null){
////            String accessLevel = realUser.getAccessLevel();
////            if(accessLevel != null) {
////            log.debug(" strForAccess --> " + strForAccess);
////            accessLevelQuery = " (" + strForAccess + "."+ 
////                Constants.EntityDefaultValues.DB_ACCESS_LEVEL + " <= '" + accessLevel + "' OR " +
////                strForAccess + "."+ Constants.EntityDefaultValues.DB_ACCESS_LEVEL + " IS NULL ) ";
////                
////                if(strForAccess!=null) {
////                    query = queryOrg + " AND "+accessLevelQuery; 
////                    accessLevelAdded = true;
////                }
////            }
////        }
//        
//        
////        if(whereClause == null || whereClause.toString().equals("")) {
////            whereClause.append(accessLevelQuery);
////        }
////        else {
////            if(accessLevelQuery!=null && accessLevelQuery.length() > 0) {
////                whereClause.append(" AND "+ accessLevelQuery);
////            }
////        }
////        if(accessLevelAdded){
////            return query;
////        }else{
////            return queryOrg;
////        }
//        return queryOrg;
//    }
//    
//    private boolean isFunction(String function, String functionName) {
//        if(null == function || null == functionName)
//            return false;
//        else return function.equalsIgnoreCase(functionName);
//    }
//    
//    public SearchConfig loadSearchConfigBySearchId(String searchId){
//        try{
//            SearchConfig result = (SearchConfig)em.createQuery("select o from SearchConfig o where o.searchId = ?1 ")
//            .setParameter(1,searchId).getSingleResult();
//            return result;
//        }catch (javax.persistence.NoResultException e) {
//            return null;
//        }catch(Exception e){
//            log.error(e.getLocalizedMessage(), e);
//            return null;
//        }
//    }
//    
//    public SearchConfig saveOrUpdateSearchConfig(SearchConfig config){
//        // Search is modified... remove the cache.        
//        config = saveOrUpdate(config);
//        if(config != null && config.getConfiguration() != null){
//            SearchConfigHelper.removeSearchInfo(config.getSearchId());
//        }
//        return config;        
//        
//    }    
//    
//    public List<SearchConfig> loadAllSearchConfig(){
//        try{
//            List<SearchConfig> result = (List<SearchConfig>)em.createQuery("select o from SearchConfig o ").getResultList();
//            return result;
//        }catch (javax.persistence.NoResultException e) {
//            return null;
//        }catch(Exception e){
//            log.error(e.getLocalizedMessage(), e);
//            return null;
//        }
//    }
//    
//    public ArrayList<SearchResultInfo> getSearchResults(String searchId,Map paramNameValue) throws InvalidSearchCriteria, 
//                                                                                     SQLException {
//        ArrayList<SearchResultInfo> searchResult = null;
//        if(searchId != null){
//            SearchInfo searchInfo = SearchConfigHelper.getSearchInfo(searchId);
//            if(paramNameValue != null){
//                Iterator iter = paramNameValue.keySet().iterator();
//                while (iter.hasNext()) {
//                    String key = (String)iter.next();
//                    Object value = paramNameValue.get(key);
//                
//                    String type = null;
//                    if(value instanceof String) {
//                        type = Constants.STRING;
//                    } else if(value instanceof Number) {
//                        type = Constants.NUMBER;
//                    } else {
//                        type = Constants.DATE;
//                    }                        
//                
//                    SearchCriteriaFieldInfo field = new SearchCriteriaFieldInfo(key, type, "", key, "");
//    
//                    field.setFieldValue(value); 
//                    searchInfo.getSearchFields().put(key, field);
//                }
//            }
//            searchResult = getSearchResults(searchInfo);
//        }
//        return searchResult;
//    }
//    //TODO This is a workaround until a solution found for lookup failure issue described on TRGHA-5494, this will be
//    //removed/changed based on the solution to TRGHA-5494
//    public ArrayList<SearchResultInfo> getSearchResultsDirect(String searchId, Map paramNameValue) throws InvalidSearchCriteria, 
//                                                                                     SQLException {
//        ArrayList<SearchResultInfo> searchResult = null;
//        if(searchId != null){
//            SearchInfo searchInfo = SearchConfigHelper.getSearchInfoDirectFromDB(this, searchId);
//            if(paramNameValue != null){
//                Iterator iter = paramNameValue.keySet().iterator();
//                while (iter.hasNext()) {
//                    String key = (String)iter.next();
//                    Object value = paramNameValue.get(key);
//                
//                    String type = null;
//                    if(value instanceof String) {
//                        type = Constants.STRING;
//                    } else if(value instanceof Number) {
//                        type = Constants.NUMBER;
//                    } else {
//                        type = Constants.DATE;
//                    }                        
//                
//                    SearchCriteriaFieldInfo field = new SearchCriteriaFieldInfo(key, type, "", key, "");
//    
//                    field.setFieldValue(value); 
//                    searchInfo.getSearchFields().put(key, field);
//                }
//            }
//            searchResult = getSearchResults(searchInfo);
//        }
//        return searchResult;
//    }
//
//    /**
//     * 
//     * @param searchInfo
//     * @param searchQueryInjection
//     * @return
//     */
//    public String determineQICondition(SearchInfo searchInfo, SearchQueryInjection searchQueryInjection){ 
//           String condition = searchQueryInjection.getCondition(); 
//           Map conditions = searchInfo.getConditions(); 
//            
//           if(null == conditions){ 
//               return null; 
//           } 
//            
//           Iterator i = conditions.entrySet().iterator(); 
//           while(i.hasNext()){ 
//               Map.Entry entry = (Map.Entry)i.next(); 
//               condition = StringUtils.replace(condition,String.valueOf(entry.getKey()),String.valueOf(entry.getValue())); 
//           } 
//           
//           return condition;
//       } 
//
//}
