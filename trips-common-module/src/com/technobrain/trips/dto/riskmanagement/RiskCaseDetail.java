package com.technobrain.trips.dto.riskmanagement;

import com.technobrain.trips.dto.DataTransferObject;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.Calendar;
import java.util.List;

/**
 * TechnoBrain 2015
 * This is a DTO that is used for case creation when the documents hits the risk
 * 
 * @since $Date: 17/11/2012 $
 * @version $Revision: 1$
 * @author $Author: Prasad Jayarathinam$
 * 
 */
public class RiskCaseDetail implements DataTransferObject {
    private Long docId;    
    private List<RiskCaseProfileDetail> riskCaseProfileDetailList;

    
    public RiskCaseDetail(Long docId, List<RiskCaseProfileDetail> riskCaseProfileDetailList) {
        this.docId = docId;
        this.riskCaseProfileDetailList = riskCaseProfileDetailList;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public Long getDocId() {
        return docId;
    }

    public void setRiskCaseProfileDetailList(List<RiskCaseProfileDetail> riskCaseProfileDetailList) {
        this.riskCaseProfileDetailList = riskCaseProfileDetailList;
    }

    public List<RiskCaseProfileDetail> getRiskCaseProfileDetailList() {
        return riskCaseProfileDetailList;
    }
}
