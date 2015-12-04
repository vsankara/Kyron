package com.technobrain.trips.common.helpers.search;

import com.technobrain.trips.common.constants.Constants;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class SearchInfo implements Serializable, Cloneable {
    private String searchId;
    private String secionHeading; //This is the section heading of search page
    private String originalSectionHeading; //This is the original section heading of search page, this is not a key to the resources file.
    private String windowHeading;//Window heading of search window
    private String joinQuery;//This is where clause to join multiple tables
    private String queryType; //This filed sets if the query should return distinct records
    
    private String advancedSearchAvailable;//This field has value 'Y'/'YES' if advanced search is available else advanced search is not shown
    private String advancedSearchHeading;//This is the section heading of advanced search page 
    private String supportsMultiQueryInjections;
    
    private String multiAdvancedSearchAvailable;//This field has value 'Y'/'YES' if multi advanced search is available
    private String multiAdvancePanelName;// search panel name
    private String multiSearchFieldColumnName;//Name of the dType column
    private String showCreateNewButton;//This decides if the create new button should be shown on this search page
    private String showCopyNewButton;//This decides if the copying new button should be shown on this search page

    private String partialForFieldList;//This should be a comma seperated list of for fields to be shown ... eg just Organisation or Individual for entity search
    
    private TreeMap searchFields;//(Key=fieldName)This map contains the criteria field list to be displayed on search screen(SearchCriteriaFieldInfo)
    private TreeMap resultFields;//(Key=fieldName)This map contaings the result fields to be displayed in the search result(SearchResultFieldInfo)
    private TreeMap advancedSearchFields;//(Key=fieldName)This map contains the criteria field list to be displayed on advanced search section (SearchCriteriaFieldInfo)
    private TreeMap advancedResultFields;//(Key=fieldName)This map contaings the result fields to be displayed in the advanced search result(SearchResultFieldInfo)
    private TreeMap searchTables;//(Key=tableName)Tables to be looked into for data(String)
    private TreeMap searchTableJoinsList;//In case data to be searched in multiple tables then this stores how to join tables
    private TreeMap searchActions;    //(Key=actionId)How many buttons to be displayed in the search screen.(SearchActionInfo)
    private TreeMap criteriaCase; // Query can be set depends on criteria value.
    private TreeMap orderByFields;//List of fields by which to sort the results. 
    private TreeMap groupByFields; // List of fields by which to group the results.
    
    private ArrayList multiAdvancedPanalNameList;
    private ArrayList searchInjectedQuery;
    private String primaryTableName;
    private TreeMap searchTablesForMiniSpotLight; //(Key=tableName)Tables with same alias for MINI_SPOTLIGHT search
    
    private Map conditions;

    private String username; 

    public SearchInfo(String searchId,String secionHeading,String windowHeading,String joinQuery){
        this.setSearchId(searchId);
        this.setSearchFields(new TreeMap());
        this.setResultFields(new TreeMap());;
        this.setSecionHeading(secionHeading);
        this.setWindowHeading(windowHeading);
        this.setSearchTables(new TreeMap());;
        this.setSearchInjectedQuerys(new ArrayList());
        this.joinQuery=joinQuery;
        this.setSearchTableJoinsList(new TreeMap());    
        this.setSearchTablesForMiniSpotLight(new TreeMap());
    }

    public String getSearchId() {
        return searchId;
    }
    
    public String getPrimaryKeyTableName() {
//        if(isMultiSearchAvailable() && getMultiAdvancePanelName() == null){
//            return this.primaryTableName;
//        }
    
        TreeMap map = getResultFields(getMultiAdvancePanelName());
        Set keySet = map.keySet();
        Iterator itr = keySet.iterator();
        while(itr.hasNext()) {
            Object key = itr.next();
            SearchResultFieldInfo value = (SearchResultFieldInfo)map.get(key);
            if(value.isPrimaryKey()) {
                return value.getTableName();
            }
        }
        return this.primaryTableName;
    }
    
    public String getPrimaryTableName() {
        return primaryTableName;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public TreeMap getSearchFields() {
        return searchFields;
    }
    public ArrayList getSearchFieldsAsList() {
        //TODO Kemal: I think it will be better to hold the list as instance variable so that only first time we will 
        // convert the map to list.
        ArrayList aList = new ArrayList(searchFields.values());
        Collections.sort(aList, new DisplayOrderComparator());
        return  aList ;
    }

    public TreeMap getAdvancedSearchFields(String forField) {
            if (isMultiSearchAvailable()){
                if(advancedSearchFields.size() > 0){
                    TreeMap result =  null;
                    if(forField != null && !forField.equals("")){
                        result =  (TreeMap)advancedSearchFields.get(forField);
                    }else{
                        result =  (TreeMap)advancedSearchFields.get(advancedSearchFields.firstKey());
                    }
                    return result;
                }            
            }        
        return advancedSearchFields;
    }

    public ArrayList getAdvancedSearchFieldsAsList(String forField) {
        TreeMap result = getAdvancedSearchFields(forField);
        if (result != null){
            ArrayList aList = new ArrayList(result.values());
            Collections.sort(aList, new DisplayOrderComparator());
            return  aList ;
        }
        //TODO Kemal: I think it will be better to hold the list as instance variable so that only first time we will 
        // convert the map to list.
        ArrayList aList = new ArrayList(advancedSearchFields.values());
        Collections.sort(aList, new DisplayOrderComparator());
        return aList;
    }



    public void setSearchFields(TreeMap searchFields) {
        this.searchFields = searchFields;
    }

    public TreeMap getResultFields() {
        return resultFields;
    }

    public TreeMap getResultFields(String forField) {
            if (isMultiSearchAvailable()){
                if(advancedResultFields.size() > 0){
                    TreeMap result =  null;
                    if(forField != null && !forField.equals("")){
                        result =  (TreeMap)advancedResultFields.get(forField);
                        if (multiAdvancedSearchAvailable.equalsIgnoreCase(Constants.BOTH)){
                            if (resultFields != null && result != null){
                                result.putAll(resultFields);
                            }
                        }
                    }else{
                        result =  resultFields;
                    }
                    return result;
                }            
            }        
        return resultFields;
    }

    public ArrayList getResultFieldsAsList(String forField) {
        //TODO Kemal: I think it will be better to hold the list as instance variable so that only first time we will 
        // convert the map to list.
        TreeMap result = getResultFields(forField);
        ArrayList list = null;
        if (result != null){
            list = new ArrayList(result.values());
            Collections.sort(list, new ColumnOrderComparator());    
            return list;
        }
        list = new ArrayList(resultFields.values());
        Collections.sort(list, new ColumnOrderComparator());    
        return list;
    }


    public ArrayList getResultFieldsAsList() {
        //TODO Kemal: I think it will be better to hold the list as instance variable so that only first time we will 
        // convert the map to list.
        ArrayList list = new ArrayList(resultFields.values());
        Collections.sort(list, new ColumnOrderComparator());    
        return list;
    }

    public void setResultFields(TreeMap resultFields) {
        this.resultFields = resultFields;
    }

    public String getSecionHeading() {
        return secionHeading;
    }

    public void setSecionHeading(String secionHeading) {
        this.secionHeading = secionHeading;
    }

    public String getWindowHeading() {
        return windowHeading;
    }

    public void setWindowHeading(String windowHeading) {
        this.windowHeading = windowHeading;
    }

    public TreeMap getSearchTables() {
        return searchTables;
    }
    public ArrayList getSearchTablesAsList() {
        return new  ArrayList(searchTables.values());
    }
    
    public ArrayList getSearchTablesForMiniSpotLightAsList() {
        return new  ArrayList(searchTablesForMiniSpotLight.values());
    }

    public void setSearchTables(TreeMap searchTables) {
        this.searchTables = searchTables;
    }

    public TreeMap getSearchTableJoinsList() {
        return searchTableJoinsList;
    }

    public void setSearchTableJoinsList(TreeMap searchTableJoinsList) {
        this.searchTableJoinsList = searchTableJoinsList;
    }

    public TreeMap getSearchActions() {
        return searchActions;
    }

    public void setSearchActions(TreeMap searchActions) {
        this.searchActions = searchActions;
    }
    public String getJoingQuery() {
        return joinQuery;
    }

    public void setSearchActions(String joinQuery) {
        this.joinQuery = joinQuery;
    }

    public void setSearchInjectedQuerys(ArrayList searchInjectedQuery) {
        this.searchInjectedQuery = searchInjectedQuery;
    }

    public ArrayList getSearchInjectedQuery() {
        return searchInjectedQuery;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setAdvancedSearchHeading(String advancedSearchHeading) {
        this.advancedSearchHeading = advancedSearchHeading;
    }

    public String getAdvancedSearchHeading() {
        return advancedSearchHeading;
    }

    public void setAdvancedSearchFields(TreeMap advancedSearchFields) {
        this.advancedSearchFields = advancedSearchFields;
    }

    public TreeMap getAdvancedSearchFields() {
        return advancedSearchFields;
    }
    
    public ArrayList getAdvancedSearchFieldsAsList() {
        //TODO Kemal: I think it will be better to hold the list as instance variable so that only first time we will 
        // convert the map to list.
        ArrayList aList = new  ArrayList(advancedSearchFields.values());
        if(aList != null && aList.size() != 0 && aList.get(0) instanceof TreeMap) {
            return aList;
        }
        Collections.sort(aList, new DisplayOrderComparator());
        return aList;
    }
    
    public TreeMap getCriteriaCase() {
    	return criteriaCase;
    }
    
    public void setCriteriaCase(TreeMap criteriaCase) {
    	this.criteriaCase = criteriaCase;
    }
    
    public ArrayList getCriteriaCaseAsList() {
        return new  ArrayList(criteriaCase.values());
    }
    
    public void setOrderByFields(TreeMap orderByFields) {
        this.orderByFields = orderByFields;
    }

    public TreeMap getOrderByFields() {
        return orderByFields;
    }
    public ArrayList getOrderByFieldsAsList() {
        return new  ArrayList(orderByFields.values());
    }
    
    public void setGroupByFields(TreeMap groupByFields) {
        this.groupByFields = groupByFields;
    }

    public TreeMap getGroupByFields() {
        return groupByFields;
    }
    public ArrayList getGroupByFieldsAsList() {
        return new  ArrayList(groupByFields.values());
    }


	public void setAdvancedSearchAvailable(String advancedSearchAvailable) {
        this.advancedSearchAvailable = advancedSearchAvailable;
    }

    public String getAdvancedSearchAvailable() {
        return advancedSearchAvailable;
    }

    public void setMultiAdvancedSearchAvailable(String multiAdvancedSearchAvailable) {
        this.multiAdvancedSearchAvailable = multiAdvancedSearchAvailable;
    }

    public String getMultiAdvancedSearchAvailable() {
        return multiAdvancedSearchAvailable;
    }

    public boolean isMultiSearchAvailable(){
        if (multiAdvancedSearchAvailable != null && 
            (multiAdvancedSearchAvailable.equalsIgnoreCase("Y") || multiAdvancedSearchAvailable.equalsIgnoreCase("YES") 
            || multiAdvancedSearchAvailable.equalsIgnoreCase(Constants.SPOTLIGHT)
            || multiAdvancedSearchAvailable.equalsIgnoreCase(Constants.BOTH)
            || multiAdvancedSearchAvailable.equalsIgnoreCase(Constants.BASIC))){
            return true;
        }else{
            return false;
        }
    }

    public boolean isSupportForMultiQueryInjectionAvailable(){
        if (supportsMultiQueryInjections != null && (supportsMultiQueryInjections.equalsIgnoreCase("Y") || supportsMultiQueryInjections.equalsIgnoreCase("YES"))){
            return true;
        }else{
            return false;
        }
    }

    public void setMultiAdvancedPanalNameList(ArrayList multiAdvancedPanalNameList) {
        this.multiAdvancedPanalNameList = multiAdvancedPanalNameList;
    }

    public ArrayList getMultiAdvancedPanalNameList() {
        return multiAdvancedPanalNameList;
    }

    public void setMultiAdvancePanelName(String multiAdvancePanelName) {
        this.multiAdvancePanelName = multiAdvancePanelName;
    }

    public String getMultiAdvancePanelName() {
        return multiAdvancePanelName;
    }

    public void setShowCreateNewButton(String showCreateNewButton) {
        this.showCreateNewButton = showCreateNewButton;
    }

    public String getShowCreateNewButton() {        
        return showCreateNewButton==null?"N":showCreateNewButton;
    }

    public String getShowCopyNewButton() {        
        return showCopyNewButton==null?"N":showCopyNewButton;
    }

    /**
     * This method find the search criterias that must be triggered by the given fieldName.
     * @param fieldName
     * @return
     */
    public List<SearchCriteriaFieldInfo> findPartiallyTriggeredFields(String fieldName) {
        if(searchFields == null)
            return null;
        // this list will hold the triggered fields list and will be returned.
        List<SearchCriteriaFieldInfo> triggeredFields = new ArrayList<SearchCriteriaFieldInfo>();
        // iterate over the search fields and examine if the iterated field must be triggered.
        Iterator itr = searchFields.keySet().iterator();
        while(itr.hasNext()) {
            String fn = (String)itr.next();
            // check if the criteria is triggered.
            SearchCriteriaFieldInfo criteria = (SearchCriteriaFieldInfo)searchFields.get(fn);
            SearchTrigger trigger = criteria.findTriggerInfo(fieldName);
            if(trigger == null)
                continue;
            triggeredFields.add(criteria);
        }
        return triggeredFields;
    }

    public void setSupportsMultiQueryInjections(String supportsMultiQueryInjections) {
        this.supportsMultiQueryInjections = supportsMultiQueryInjections;
    }

    public String getSupportsMultiQueryInjections() {
        return supportsMultiQueryInjections;
    }

    public void setAdvancedResultFields(TreeMap advancedResultFields) {
        this.advancedResultFields = advancedResultFields;
    }

    public TreeMap getAdvancedResultFields() {
        return advancedResultFields;
    }

    public void setPartialForFieldList(String partialForFieldList) {
        this.partialForFieldList = partialForFieldList;
    }

    public String getPartialForFieldList() {
        return partialForFieldList;
    }

    public void setPrimaryTableName(String primaryTableName) {
        this.primaryTableName = primaryTableName;
    }

    public void setOriginalSectionHeading(String originalSectionHeading) {
        this.originalSectionHeading = originalSectionHeading;
    }

    public String getOriginalSectionHeading() {
        return originalSectionHeading;
    }

    public void setMultiSearchFieldColumnName(String multiSearchFieldColumnName) {
        this.multiSearchFieldColumnName = multiSearchFieldColumnName;
    }

    public String getMultiSearchFieldColumnName() {
        return multiSearchFieldColumnName;
    }
    
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setSearchTablesForMiniSpotLight(TreeMap searchTablesForMiniSpotLight) {
        this.searchTablesForMiniSpotLight = searchTablesForMiniSpotLight;
    }

    public TreeMap getSearchTablesForMiniSpotLight() {
        return searchTablesForMiniSpotLight;
    }
    
    public void setConditions(Map conditions) {
        this.conditions = conditions;
    }

    public Map getConditions() {
        return conditions;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
}
