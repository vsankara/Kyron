package com.technobrain.trips.search.service;

import com.technobrain.trips.common.exceptions.TripsInvalidParameterException;
import com.technobrain.trips.common.helpers.search.SearchInfo;
import com.technobrain.trips.common.helpers.search.SearchResultInfo;
import com.technobrain.trips.dto.search.SavedSearchDTO;
import com.technobrain.trips.search.exception.CriteriaRequiredException;
import com.technobrain.trips.search.exception.InvalidSearchCriteria;
import com.technobrain.trips.search.model.SearchConfig;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;


@Remote
public interface SearchFacadeRemote {

    public SearchResultInfo getSearchResultForId(SearchInfo searchInfo, Long primaryKey) throws TripsInvalidParameterException;

    public SearchResultInfo getSearchResult(SearchInfo searchInfo, Long primaryKey, String dType) throws TripsInvalidParameterException;

    public List<SearchResultInfo> getSearchResults(SearchInfo searchInfo) throws InvalidSearchCriteria,SQLException;
    
    public boolean hasCriteria(SearchInfo searchInfo);

    public String saveSearch(SearchInfo searchInfo, String saveSearchName) throws CriteriaRequiredException;
    
    public List<String> findOptionalSearchFields(String searchName);
    
    public List<String> findOptionalSearchResultFields(String searchName);

    public List<Map> findSavedSearchResults(SavedSearchDTO searchParams);
    
    public List<SearchResultInfo> filterResultInfoList(List<SearchResultInfo> resultInfos, String accessLevel);
    
    public boolean updateResultsWithNewAccessLevel(List<SearchResultInfo> resultInfos);

    public SearchResultInfo getSearchResultWithMapKey(
        String searchId, Object searchParamValue, String mapKey, SearchInfo searchInfo) 
        throws TripsInvalidParameterException;

    public SearchConfig loadSearchConfigBySearchId(String searchId);
    
    public SearchConfig saveOrUpdateSearchConfig(SearchConfig config);
    
    public List<SearchConfig> loadAllSearchConfig();

    public ArrayList<SearchResultInfo> getSearchResults(String searchId,Map paramNameValue) throws InvalidSearchCriteria, 
                                                                                     SQLException;
    
    //TODO This is a workaround until a solution found for lookup failure issue described on TRGHA-5494, this will be
    //removed/changed based on the solution to TRGHA-5494
    public ArrayList<SearchResultInfo> getSearchResultsDirect(String searchId,Map paramNameValue) throws InvalidSearchCriteria, 
                                                                                     SQLException;


}
