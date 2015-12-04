package com.technobrain.trips.document.service;

import com.technobrain.trips.document.model.DdocDocument;
import com.technobrain.trips.dto.CodeAndDescription;
import com.technobrain.trips.dto.registration.EntityHistory;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Remote;


@Remote
public interface DocumentFacadeRemote {
    
    List <CodeAndDescription> findDocumentErrors(Long id);
    
    List <EntityHistory> findEntityHistory(Long id);
    
    public String findDocumentType(Long documentId);
    
    public Long findFlexibleFormId(Long documentId);
    
    public DdocDocument findByDocumentID(Long documentID);

//TODO - RevledRevPeriod/RevledTransactionCleanup
//    public RevledRevPeriod findApplicablePeriodNumber(Long taxpayerId, String taxType, Calendar submissionDate);
}
