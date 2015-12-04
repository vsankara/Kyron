package com.technobrain.trips.dto.riskmanagement;

import com.technobrain.trips.dto.DataTransferObject;

/**
 * TechnoBrain 2015
 * This is a DTO that is used for case creation when the documents hits the risk
 * 
 * @since $Date: 17/11/2012 $
 * @version $Revision: 1$
 * @author $Author: Prasad Jayarathinam$
 * 
 */
public class RiskCaseProfileDetail implements DataTransferObject {
    private Long profileScore;    
    private Long profileId;
    private String profileDescription;
    private String profileRiskLevel;
    private String riskProfileName;
    private String riskProfileNumber;
    private Boolean riskProfileHit;
    
    public RiskCaseProfileDetail(Long profileScore, Long profileId, String profileDescription, String profileRiskLevel, String riskProfileName, String riskProfileNumber, Boolean riskProfileHit) {
        this.profileScore = profileScore;
        this.profileId = profileId;
        this.profileDescription = profileDescription;
        this.profileRiskLevel = profileRiskLevel;
        this.riskProfileName = riskProfileName;
        this.riskProfileNumber = riskProfileNumber;
        this.riskProfileHit = riskProfileHit;
    }

    public void setProfileScore(Long profileScore) {
        this.profileScore = profileScore;
    }

    public Long getProfileScore() {
        return profileScore;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileRiskLevel(String profileRiskLevel) {
        this.profileRiskLevel = profileRiskLevel;
    }

    public String getProfileRiskLevel() {
        return profileRiskLevel;
    }

    public void setRiskProfileName(String riskProfileName) {
        this.riskProfileName = riskProfileName;
    }

    public String getRiskProfileName() {
        return riskProfileName;
    }

    public void setRiskProfileNumber(String riskProfileNumber) {
        this.riskProfileNumber = riskProfileNumber;
    }

    public String getRiskProfileNumber() {
        return riskProfileNumber;
    }

    public void setRiskProfileHit(Boolean riskProfileHit) {
        this.riskProfileHit = riskProfileHit;
    }

    public Boolean getRiskProfileHit() {
        return riskProfileHit;
    }
}
