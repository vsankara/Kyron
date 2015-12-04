package com.technobrain.trips.entity.model;

import com.technobrain.trips.application.model.AppApplication;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.model.CommAttachment;
import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.document.model.DdocEntityDocRel;
import com.technobrain.trips.document.model.DfinBadChequeRegister;
import com.technobrain.trips.entity.model.EntTaxpayerTurnover;
import com.technobrain.trips.registration.model.RegTaxpayer;
import com.technobrain.trips.registration.model.RegTaxpayerEntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * © Crown Agents 2006
 *
 * Entity for table ENT_ENTITY
 *
 * @since	$Date: 10/6/2009 2:17:40 AM$
 * @version 	$Revision: 54$
 * @author 	$Author: Alvin Fernandez$
 *
 * $Log[1]:
 *  54   TRIPS2 etis.bir.gov.ph1.49.1.3    10/6/2009 2:17:40 AM   Alvin
 *       Fernandez added post transaction methods
 * $
 */
@Entity
@NamedQueries (
    {
        @NamedQuery(name = "EntEntity.findAll", query = "select o from EntEntity o"),
        @NamedQuery(name = "EntEntity.findTaxpayerEntity", query = "select o from EntEntity o where o.id=?1")
    }
)    
@Table(name = "ENT_ENTITY")
@SequenceGenerator(name = "ent_entity_seq", sequenceName = "ent_entity_seq", initialValue = 1, allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@DiscriminatorValue("ENTITY")
public class EntEntity extends BaseNormalModelObject   {

    @Column(name="ENTITY_NAME")
    private String entityName;
    @Column(name="ENTITY_TYPE")
    private String entityType;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_entity_seq")
    @Column(nullable = false)
    private Long id;
    private String dtype;

    @Column(name="ORIGIN")
    private String origin;
    
    @Column(name="LEGAL_STATUS")
    private String legalStatus;
    
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="COMM_ATTACHMENT_ENT_ENTITY",
        joinColumns={@JoinColumn(name = "ENTITY_ID",
                referencedColumnName = "ID")},
        inverseJoinColumns = {@JoinColumn(name = "ATTACHMENT_ID",
                referencedColumnName = "ID")}
    )
    private List<CommAttachment> commAttachmentList;
    @OneToMany(cascade={CascadeType.ALL}, mappedBy = "parentEntity")
    private List<EntContactMethod> entContactMethodList;
    @OneToMany(cascade={CascadeType.ALL}, mappedBy = "parentEntity")
    private List<EntNotes> entNotesList;
    @OneToMany(cascade={CascadeType.ALL}, mappedBy = "sourceEntity")
    private List<EntRelationship> outgoingRelationshipList;
    @OneToMany(cascade={CascadeType.ALL},mappedBy = "targetEntity")
    private List<EntRelationship> incomingRelationshipList;
    @OneToMany(cascade={CascadeType.ALL},mappedBy = "parentEntity")
    private List<EntIdentification> entIdentificationList;
    @OneToMany(mappedBy = "parentEntity", cascade={CascadeType.ALL})
    private List<EntSite> entSiteList;
    @OneToMany(mappedBy = "entEntity")
    private List<DdocEntityDocRel> ddocEntityDocRelList;
    @OneToMany(mappedBy = "entEntity")
    private List<DfinBadChequeRegister> DfinBadChequeRegisterList;
    @OneToMany(cascade={CascadeType.ALL},mappedBy = "entity")
    private List<EntAttributeMapping> entAttributeMappingList;
    @OneToMany(mappedBy = "parentEntity",cascade={CascadeType.ALL})
    private List<EntBankDetails> bankDetailsList;
    @OneToMany(mappedBy = "parentEntity",cascade={CascadeType.ALL})
    private List<EntPayCardDetails> payCardDetailsList;
    @OneToMany(cascade={CascadeType.ALL},mappedBy="entEntity")
    private List<EntVehicle> entCommercialVehicleList;

    @OneToMany(mappedBy = "entEntity",cascade={CascadeType.ALL})
    private List<EntReasonHistory> reasonHistories;

    @OneToMany(mappedBy = "entity", cascade={CascadeType.ALL})
    private List<EntLocation> entLocationList;
    
    @OneToMany(cascade={CascadeType.ALL},mappedBy = "parentEntity")
    private List<EntIndustryOccupation> entIndustryOccupationList;
    
    @OneToOne(cascade={CascadeType.ALL}, mappedBy="entity")
    private EntRegistrationDocument regDocument;
        
    @OneToMany(mappedBy = "entEntity",cascade={CascadeType.ALL})
    private List<EntOtherLegalStatus> otherLegalStatus;
    
    @OneToMany(mappedBy = "entEntity", cascade = { CascadeType.ALL })
    private List<EntProperty> propertyDetails;
    
    @OneToOne(cascade={CascadeType.ALL}, mappedBy="entEntity")
    private EntOccupation entOccupation;
    
    @OneToMany(mappedBy = "entEntity", cascade={CascadeType.ALL})
    private List<EntBusinessSector> entBusinessSectorList;
    
    @OneToMany(mappedBy="entEntity", cascade={CascadeType.ALL})
    private List<EntTradingAs> entTradingAsList;
    
    @OneToMany(mappedBy="entEntity", cascade={CascadeType.ALL})
    private List<RegTaxpayerEntity> regTaxpayerEntityList;
    
    @OneToMany(cascade={CascadeType.ALL}, mappedBy = "entEntity")
    private List<EntTaxpayerTurnover> entTaxpayerTurnoverList = new ArrayList<EntTaxpayerTurnover>();

    @Column(name="EREG_NEW")
    private String eregNew; 
    @Column(name="EREG_UPDATE")
    private String eregUpdate; 
    @Column(name="EREG_PROCESSED")
    private String eregProcessed; 

    @Column(name="IMPORT_INDICATOR")
    private String importIndicator;
    @Column(name="EXPORT_INDICATOR")
    private String exportIndicator;
    @Column(name="TAX_CONSULTANT_INDICATOR")
    private String taxConsultantIndicator;
    
    
    @Column(name="ENT_STATUS")
    private String entStatus;

    @OneToMany(mappedBy = "entity", cascade={CascadeType.ALL})
    private List<AppApplication> applicationList;
    
    public EntEntity() {
    }
    
    public String getExportIndicator() {
        return exportIndicator;
    }

    public void setExportIndicator(String exportIndicator) {
        this.exportIndicator = exportIndicator;
    }

    public String getImportIndicator() {
        return importIndicator;
    }

    public void setImportIndicator(String importIndicator) {
        this.importIndicator = importIndicator;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CommAttachment> getCommAttachmentList() {
        return commAttachmentList;
    }

    public void setCommAttachmentList(List<CommAttachment> commAttachmentList) {
        this.commAttachmentList = commAttachmentList;
    }

    public CommAttachment addCommAttachment(CommAttachment commAttachment) {
        getCommAttachmentList().add(commAttachment);
        return commAttachment;
    }

    public CommAttachment removeCommAttachment(CommAttachment commAttachment) {
        getCommAttachmentList().remove(commAttachment);
        return commAttachment;
    }

    public List<EntContactMethod> getEntContactMethodList() {
        return entContactMethodList;
    }

    public void setEntContactMethodList(List<EntContactMethod> entContactMethodList) {
        this.entContactMethodList = entContactMethodList;
    }

    public EntContactMethod addEntContactMethod(EntContactMethod entContactMethod) {
        getEntContactMethodList().add(entContactMethod);
        entContactMethod.setParentEntity(this);
        return entContactMethod;
    }

    public EntContactMethod removeEntContactMethod(EntContactMethod entContactMethod) {
        getEntContactMethodList().remove(entContactMethod);
        //entContactMethod.setParentEntity(null);
        return entContactMethod;
    }

    public List<EntRelationship> getOutgoingRelationshipList() {
        return outgoingRelationshipList;
    }

    public void setOutgoingRelationshipList(List<EntRelationship> entRelationshipList) {
        this.outgoingRelationshipList = entRelationshipList;
    }

    public EntRelationship addEntRelationship(EntRelationship entRelationship) {
        getOutgoingRelationshipList().add(entRelationship);
        entRelationship.setSourceEntity(this);
        return entRelationship;
    }

    public EntRelationship removeEntRelationship(EntRelationship entRelationship) {
        getOutgoingRelationshipList().remove(entRelationship);
        return entRelationship;
    }

    public List<EntNotes> getEntNotesList() {
        return entNotesList;
    }

    public void setEntNotesList(List<EntNotes> entNotesList) {
        this.entNotesList = entNotesList;
    }

    public EntNotes addEntNotes(EntNotes entNotes) {
        getEntNotesList().add(entNotes);
        entNotes.setParentEntity(this);
        return entNotes;
    }

    public EntNotes removeEntNotes(EntNotes entNotes) {
        getEntNotesList().remove(entNotes);
        return entNotes;
    }

    public List<EntRelationship> getIncomingRelationshipList() {
        return incomingRelationshipList;
    }

    public void setIncomingRelationshipList(List<EntRelationship> entRelationshipList1) {
        this.incomingRelationshipList = entRelationshipList1;
    }

    public EntRelationship addEntRelationship1(EntRelationship entRelationship) {
        getIncomingRelationshipList().add(entRelationship);
        entRelationship.setTargetEntity(this);
        return entRelationship;
    }

    public EntRelationship removeEntRelationship1(EntRelationship entRelationship) {
        getIncomingRelationshipList().remove(entRelationship);
        entRelationship.setTargetEntity(null);
        return entRelationship;
    }

    public List<EntIdentification> getEntIdentificationList() {
        return entIdentificationList;
    }

    public void setEntIdentificationList(List<EntIdentification> entIdentificationList) {
        this.entIdentificationList = entIdentificationList;
    }
    
    public EntOtherLegalStatus addEntOtherLegalStatus(EntOtherLegalStatus entOtherLegalStatus) {
        getOtherLegalStatus().add(entOtherLegalStatus);
        entOtherLegalStatus.setEntEntity(this);
        return entOtherLegalStatus;
    }

    public EntOtherLegalStatus removeEntOtherLegalStatus(EntOtherLegalStatus entOtherLegalStatus) {
        getOtherLegalStatus().remove(entOtherLegalStatus);
        entOtherLegalStatus.setEntEntity(null);
        return entOtherLegalStatus;
    }

    public EntIdentification addEntIdentification(EntIdentification entIdentification) {
        getEntIdentificationList().add(entIdentification);
        entIdentification.setParentEntity(this);
        return entIdentification;
    }

    public EntIdentification removeEntIdentification(EntIdentification entIdentification) {
        getEntIdentificationList().remove(entIdentification);
        entIdentification.setParentEntity(null);
        return entIdentification;
    }

    public void setEntSiteList(List<EntSite> entSiteList) {
        this.entSiteList = entSiteList;
    }

    public List<EntSite> getEntSiteList() {
        return entSiteList;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getDtype() {
        return dtype;
    }

    public void setBankDetailsList(List<EntBankDetails> bankDetailsList) {
        this.bankDetailsList = bankDetailsList;
    }

    public List<EntBankDetails> getBankDetailsList() {
        return bankDetailsList;
    }

    public EntBankDetails removeEntNotes(EntBankDetails entBankDetails) {
        getBankDetailsList().remove(entBankDetails);
        entBankDetails.setParentEntity(null);
        return entBankDetails;
    }

    public void setPayCardDetailsList(List<EntPayCardDetails> payCardDetailsList) {
        this.payCardDetailsList = payCardDetailsList;
    }

    public List<EntPayCardDetails> getPayCardDetailsList() {
        return payCardDetailsList;
    }

    /*************************************************************************
     *                      BUSINESS LOGIC                                   *
     *************************************************************************/

    /**
     * @return the primary address i.e EntSite
     */
    public EntLocation getPrimaryAddress() {
      for(EntLocation entLocation: getEntLocationList()){
         if( entLocation.isPrimaryAddress() ){
             return entLocation;
         }
      }

      return null;
    }

    public void setDdocEntityDocRelList(List<DdocEntityDocRel> ddocEntityDocRelList) {
        this.ddocEntityDocRelList = ddocEntityDocRelList;
    }

    public List<DdocEntityDocRel> getDdocEntityDocRelList() {
        return ddocEntityDocRelList;
    }

    public void setDfinBadChequeRegisterList(List<DfinBadChequeRegister> dfinBadChequeRegisterList) {
        this.DfinBadChequeRegisterList = dfinBadChequeRegisterList;
    }

    public List<DfinBadChequeRegister> getDfinBadChequeRegisterList() {
        return DfinBadChequeRegisterList;
    }

    public void setEntAttributeMappingList(List<EntAttributeMapping> entAttributeMappingList) {
        this.entAttributeMappingList = entAttributeMappingList;
    }

    public List<EntAttributeMapping> getEntAttributeMappingList() {
        return entAttributeMappingList;
    }

    public EntAttributeMapping addEntAttributeMapping(EntAttributeMapping entAttributeMapping) {
        getEntAttributeMappingList().add(entAttributeMapping);
        entAttributeMapping.setEntity(this);
        return entAttributeMapping;
    }

    public EntAttributeMapping removeEntAttributeMapping(EntAttributeMapping entAttributeMapping) {
        getEntAttributeMappingList().remove(entAttributeMapping);
        return entAttributeMapping;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public EntPayCardDetails addEntPayCardDetails(EntPayCardDetails entPayCardDetails) {
        entPayCardDetails.setParentEntity(this);
        getPayCardDetailsList().add(entPayCardDetails);
        return entPayCardDetails;
    }

    public EntPayCardDetails removeEntPayCardDetails(EntPayCardDetails entPayCardDetails) {
        getPayCardDetailsList().remove(entPayCardDetails);
        return entPayCardDetails;
    }
    
    public EntBankDetails addEntBankDetails(EntBankDetails bankDetails) {
        bankDetails.setParentEntity(this);
        getBankDetailsList().add(bankDetails);
        return bankDetails;
    }

    public EntBankDetails removeEntBankDetails(EntBankDetails bankDetails) {
        getBankDetailsList().remove(bankDetails);
        return bankDetails;
    }
    
    public EntSite addEntSite(EntSite entSite) {
        entSite.setParentEntity(this);        
        getEntSiteList().add(entSite);
        return entSite;
    }

    public EntSite removeEntSite(EntSite entSite) {
        getEntSiteList().remove(entSite);
        return entSite;
    }
    
    public EntProperty addEntProperty(EntProperty property) {
        property.setEntEntity(this);
        getPropertyDetails().add(property);
        return property;
    }

    public EntProperty removeEntProperty(EntProperty property) {
        getPropertyDetails().remove(property);
        return property;
    }

    public void setReasonHistories(List<EntReasonHistory> reasonHistories) {
        this.reasonHistories = reasonHistories;
    }

    public List<EntReasonHistory> getReasonHistories() {
        return reasonHistories;
    }

    public void setLegalStatus(String legalStatus) {
        this.legalStatus = legalStatus;
    }

    public String getLegalStatus() {
        return legalStatus;
    }
    
    /**
     * Add a site to the list of this entities site
     * @param entEntity
     * @param siteType
     */
    public void addSite(EntEntity entEntity, String siteType,String siteCode) {
        if(null == entSiteList) 
            this.entSiteList = new ArrayList<EntSite>();
            
        EntSite site =  new EntSite();
        site.setEntitySiteType(siteType);
        site.setParentEntity(this);
//        site.setRelatedEntity(entEntity);
        site.setSiteCode(siteCode);
        this.entSiteList.add(site);
    }

    public void setEntLocationList(List<EntLocation> entLocationList) {
        this.entLocationList = entLocationList;
    }

    public List<EntLocation> getEntLocationList() {
        return entLocationList;
    }
    
    public EntLocation addEntLocation(EntLocation entLocation) {
        entLocation.setEntity(this);
        getEntLocationList().add(entLocation);
        return entLocation;
    }

    public EntLocation removeEntLocation(EntLocation entLocation) {
        getEntLocationList().remove(entLocation);
        return entLocation;
    }
    
    /**
     * Find the number of sites by site type
     */
    public int getNumberOfSites(String siteType) {
        int count = 0;
        if(null != this.getEntSiteList())
        for(EntSite site:this.getEntSiteList()){
            if(site.getEntitySiteType().equals(siteType)){
                count++;
            }
        }
        
        return count;
    }

    public void setEntIndustryOccupationList(List<EntIndustryOccupation> entIndustryOccupationList) {
        this.entIndustryOccupationList = entIndustryOccupationList;
    }

    public List<EntIndustryOccupation> getEntIndustryOccupationList() {
        return entIndustryOccupationList;
    }
    
    public EntIndustryOccupation addEntIndustryOccupation(EntIndustryOccupation entIndustryOccupation) {
        getEntIndustryOccupationList().add(entIndustryOccupation);
        entIndustryOccupation.setParentEntity(this);
        return entIndustryOccupation;
    }

    public EntIndustryOccupation removeEntIndustryOccupation(EntIndustryOccupation entIndustryOccupation) {
        getEntIndustryOccupationList().remove(entIndustryOccupation);
        return entIndustryOccupation;
    }

    public void setRegDocument(EntRegistrationDocument regDocument) {
        this.regDocument = regDocument;
    }

    public EntRegistrationDocument getRegDocument() {
        return regDocument;
    }

    public List<EntOtherLegalStatus> getOtherLegalStatus() {
        return otherLegalStatus;
    }
	
	public void setEntCommercialVehicleList(List<EntVehicle> entCommercialVehicleList) {
        this.entCommercialVehicleList = entCommercialVehicleList;
    }

    public List<EntVehicle> getEntCommercialVehicleList() {
        return entCommercialVehicleList;
    }

    public void setOtherLegalStatus(List<EntOtherLegalStatus> otherLegalStatus) {
        this.otherLegalStatus = otherLegalStatus;
    }

    public void setEregNew(String eregNew) {
        this.eregNew = eregNew;
    }

    public String getEregNew() {
        return eregNew;
    }

    public void setEregUpdate(String eregUpdate) {
        this.eregUpdate = eregUpdate;
    }

    public String getEregUpdate() {
        return eregUpdate;
    }

    public void setEregProcessed(String eregProcessed) {
        this.eregProcessed = eregProcessed;
    }

    public String getEregProcessed() {
        return eregProcessed;
    }
    
    public void setEntOccupation(EntOccupation entOccupation) {
        this.entOccupation = entOccupation;
    }

    public EntOccupation getEntOccupation() {
        return entOccupation;
    }
    
    public void setEntBusinessSectorList(List<EntBusinessSector> entBusinessSectorList) {
        this.entBusinessSectorList = entBusinessSectorList;
    }

    public List<EntBusinessSector> getEntBusinessSectorList() {
        return entBusinessSectorList;
    }
    
    public EntBusinessSector addEntBusinessSector(EntBusinessSector entBusinessSector) {
        entBusinessSector.setEntEntity(this);
        getEntBusinessSectorList().add(entBusinessSector);
        return entBusinessSector;
    }

    public EntBusinessSector removeEntBusinessSector(EntBusinessSector entBusinessSector) {
        getEntBusinessSectorList().remove(entBusinessSector);
        return entBusinessSector;
    }

    public void setTaxConsultantIndicator(String taxConsultantIndicator) {
        this.taxConsultantIndicator = taxConsultantIndicator;
    }

    public String getTaxConsultantIndicator() {
        return taxConsultantIndicator;
    }

    public void setPropertyDetails(List<EntProperty> propertyDetails) {
        this.propertyDetails = propertyDetails;
    }

    public List<EntProperty> getPropertyDetails() {
        return propertyDetails;
    }
	
    public EntVehicle addCommercialVehicle(EntVehicle entVehicle) {
        getEntCommercialVehicleList().add(entVehicle);
        entVehicle.setEntEntity(this);
        return entVehicle;
    }

    public EntVehicle removeCommercialVehicle(EntVehicle entVehicle) {
        getEntCommercialVehicleList().remove(entVehicle);
        return entVehicle;
    }
    public List<EntTaxpayerTurnover> getEntTaxpayerTurnoverList() {
        return entTaxpayerTurnoverList;
    }

    public void setEntTaxpayerTurnoverList(List<EntTaxpayerTurnover> entTaxpayerTurnoverList) {
        this.entTaxpayerTurnoverList = entTaxpayerTurnoverList;
    }

    public EntTaxpayerTurnover addEntTaxpayerTurnover(EntTaxpayerTurnover entTaxpayerTurnover) {
        getEntTaxpayerTurnoverList().add(entTaxpayerTurnover);
        entTaxpayerTurnover.setEntEntity(this);
        return entTaxpayerTurnover;
    }

    public EntTaxpayerTurnover removeEntTaxpayerTurnover(EntTaxpayerTurnover entTaxpayerTurnover) {
        getEntTaxpayerTurnoverList().remove(entTaxpayerTurnover);
        entTaxpayerTurnover.setEntEntity(null);
        return entTaxpayerTurnover;
    }

    public void setEntTradingAsList(List<EntTradingAs> entTradingAsList) {
        this.entTradingAsList = entTradingAsList;
    }

    public List<EntTradingAs> getEntTradingAsList() {
        return entTradingAsList;
    }
    
    public EntTradingAs addEntTradingAs(EntTradingAs entTradingAs) {
        getEntTradingAsList().add(entTradingAs);
        entTradingAs.setEntEntity(this);
        return entTradingAs;
    }

    public EntTradingAs removeEntTradingAs(EntTradingAs entTradingAs) {
        getEntTradingAsList().remove(entTradingAs);
        return entTradingAs;
    }

    public void setRegTaxpayerEntityList(List<RegTaxpayerEntity> regTaxpayerEntityList) {
        this.regTaxpayerEntityList = regTaxpayerEntityList;
    }

    public List<RegTaxpayerEntity> getRegTaxpayerEntityList() {
        return regTaxpayerEntityList;
    }

    public void setApplicationList(List<AppApplication> applicationList) {
        this.applicationList = applicationList;
    }

    public List<AppApplication> getApplicationList() {
        return applicationList;
    }
    
    public AppApplication addAppApplication(AppApplication application) {
        getApplicationList().add(application);
        application.setEntity(this);
        return application;
    }

    public AppApplication removeAppApplication(AppApplication application) {
        getApplicationList().remove(application);
        return application;
    }

    public void setEntStatus(String entStatus) {
        this.entStatus = entStatus;
    }

    public String getEntStatus() {
        return entStatus;
    }

    public String getTin(){
        if (getRegTaxpayerEntityList() != null && getRegTaxpayerEntityList().size() > 0){
            for(RegTaxpayerEntity regEnt : getRegTaxpayerEntityList()){
                if(regEnt != null && regEnt.getRegistrationType() != null && regEnt.getRegistrationType().equals(Constants.Regimes.TAXPAYER)){
                    return ((RegTaxpayer)regEnt).getTin();
                }
            }        
        }  
        return null;
    }


}
