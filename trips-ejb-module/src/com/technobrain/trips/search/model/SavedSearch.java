package com.technobrain.trips.search.model;

import com.technobrain.trips.core.annotation.ReferenceNumber;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "SavedSearch.findAll", query = "select o from SavedSearch o")
@Table(name = "SAVED_SEARCH")
public class SavedSearch extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SAVED_SEARCH_SEQ")
    @SequenceGenerator(name = "SAVED_SEARCH_SEQ", sequenceName = "SAVED_SEARCH_SEQ", allocationSize = 1)       
    @Column(nullable = false)
    private Long id;
    @ReferenceNumber(format="SAVSEARCH/SQL", sql="SELECT LTRIM(TO_CHAR(MOD(SAVED_SEARCH_REF_NO_SEQ.nextval,100000),'000099'))||'/'||to_char(sysdate,'YYYY') as generatedId FROM dual")    
    @Column(name="REFERENCE_NO")
    private String referenceNo;
    @Column(name="SEARCHED_BY")
    private String searchedBy;
    @Column(name="SEARCH_DATE")
    private Timestamp searchDate;
    @Column(name="SEARCH_NAME")
    private String searchName;
    @Column(name="SEARCH_TYPE")
    private String searchType;    
    @OneToMany(mappedBy = "savedSearch", cascade = {CascadeType.ALL})
    private List<SavedSearchField> savedSearchFieldList = new ArrayList<SavedSearchField>();

    public SavedSearch() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getSearchedBy() {
        return searchedBy;
    }

    public void setSearchedBy(String searchedBy) {
        this.searchedBy = searchedBy;
    }

    public Timestamp getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(Timestamp searchDate) {
        this.searchDate = searchDate;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public List<SavedSearchField> getSavedSearchFieldList() {
        return savedSearchFieldList;
    }

    public void setSavedSearchFieldList(List<SavedSearchField> savedSearchFieldList) {
        this.savedSearchFieldList = savedSearchFieldList;
    }

    public SavedSearchField addSavedSearchField(SavedSearchField savedSearchField) {
        getSavedSearchFieldList().add(savedSearchField);
        savedSearchField.setSavedSearch(this);
        return savedSearchField;
    }

    public SavedSearchField removeSavedSearchField(SavedSearchField savedSearchField) {
        getSavedSearchFieldList().remove(savedSearchField);
        savedSearchField.setSavedSearch(null);
        return savedSearchField;
    }
    
    /**
     * Returns true if this saved search contains a fieldname-fieldvalue pair. Otherwise, returns false.
     * @param fieldName
     * @param fieldValue
     * @return
     */
    public boolean containsField(String fieldName, String fieldValue) {
        boolean found = false;
        for (int i = 0; i < savedSearchFieldList.size(); i++)  {
            SavedSearchField sf = savedSearchFieldList.get(i);
            if(sf.getFieldName() == null || sf.getFieldName().equals("") || 
                sf.getFieldValue() == null || sf.getFieldValue().equals(""))
                continue;
            if(sf.getFieldName().equals(fieldName) && sf.getFieldValue().equals(fieldValue)) {
                found = true;
                break;
            }
        }
        return found;
    }
    
    public Map convertToMap() {
        Map m = new HashMap();
        m.put("referenceNo", referenceNo);
        m.put("searchName", searchName);
        m.put("searchDate", searchDate);
        m.put("searchedBy", searchedBy);
        for (int i = 0; i < savedSearchFieldList.size(); i++)  {
            SavedSearchField sf = savedSearchFieldList.get(i);
            m.put(sf.getFieldName(), sf.getFieldValue());
        }
        return m;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchType() {
        return searchType;
    }
}
