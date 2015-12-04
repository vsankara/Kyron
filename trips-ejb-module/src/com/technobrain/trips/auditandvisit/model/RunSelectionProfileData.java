package com.technobrain.trips.auditandvisit.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * Model class representing the table RUN_SELECTION_PROFILE_DATA. 
 * 
 *@author
 *@version
 *@since   
 * 
 */
@Entity
@NamedQuery(name = "RunSelectionProfileData.findAll", 
    query = "select o from RunSelectionProfileData o")
@Table(name = "RUN_SELECTION_PROFILE_DATA")
public class RunSelectionProfileData extends BaseNormalModelObject {
    @Id
    @Column(nullable = false)
    private Long id;    
    @Column(name="PROFILE_ID")
    private String profileId;
    @Column(name="RUN_BY_USER")
    private String runByUser;
    @Column(name="RUN_DATE_TIME")
    private Timestamp runDateTime;    
    @Column(name="TAXPAYER_LIST")
    private char[] taxpayerList;   
    


    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getRunByUser() {
        return runByUser;
    }

    public void setRunByUser(String runByUser) {
        this.runByUser = runByUser;
    }

    public Timestamp getRunDateTime() {
        return runDateTime;
    }

    public void setRunDateTime(Timestamp runDateTime) {
        this.runDateTime = runDateTime;
    }

    
    public char[] getTaxpayerList() {
        return taxpayerList;
    }

    public void setTaxpayerList(char[] taxpayerList) {
        this.taxpayerList = taxpayerList;
    }   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
