package com.technobrain.trips.application.model;

import com.technobrain.trips.common.model.CommAttachment;
import com.technobrain.trips.core.annotation.ReferenceNumber;
import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.document.model.DdocDocument;
import com.technobrain.trips.entity.model.EntEntity;

import java.sql.Timestamp;

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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
    name = "AppApplication.findAll", query = "select o from AppApplication o"
    ),
     @NamedQuery(name = "AppApplication.findById", 
            query = "select o from AppApplication o where o.id=?1"),
    @NamedQuery(
    name="AppApplication.findAppApplicationByReferenceNumber",
    query="select o from AppApplication o where o.applicationReference = ?1"
    ),
    @NamedQuery(
    name="AppApplication.findByEntityIdAndDType",
    query="select o from AppApplication o where o.entity.id = ?1 and o.dtype=?2"
    )
})
@Table(name = "APP_APPLICATION")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="DTYPE")
@DiscriminatorValue("APPLICATION")
public class AppApplication extends DdocDocument {
    @Column(name="APP_TYPE")
    private String appType;
    @Column(name="ACCOUNTS_OFFICES_ADDRESS")
    private String accountsOfficesAddress;
    @Column(name="APPLICATION_DATE")
    private Timestamp applicationDate;
    @Column(name="APPLICATION_FEE_INDICATOR")
    private String applicationFeeIndicator;
    @ReferenceNumber(format="APP/SQL", 
    sql="SELECT LTRIM(TO_CHAR(MOD(APPLICATION_NO_SEQ.nextval,100000),'000099'))||'/'||to_char(sysdate,'YYYY') as generatedId FROM dual")
    @Column(name="APPLICATION_REFERENCE")
    private String applicationReference;
//    @Column(name="APPLICATION_STATUS")
//    private String applicationStatus;
    @Column(name="ATTACHMENT_COUNT")
    private Integer attachmentCount;
    @Column(name="REASON")
    private String reason;
    @Column(name="AUTH_TYPE")
    private String authType;
    @Column(name="COMMERCIAL_ACCOUNTS")
    private String commercialAccounts;
    @Column(name="REJECT_REASON")
    private String rejectReason;
    
    /*@ManyToOne
    @JoinColumn(name = "ENTITY_ID", referencedColumnName = "ID")
    private EntEntity entity;
    
    @ManyToOne
    @JoinColumn(name = "ENTITY_ID", referencedColumnName = "ID")
    private Long entityId;
    */
    
    @Column(name = "ENTITY_ID", nullable = false)
    private Long entityId;
    @ManyToOne
    @JoinColumn(name = "ENTITY_ID", referencedColumnName = "ID", insertable=false,updatable=false)
    private EntEntity entity;
    
    @OneToOne
    @JoinColumn(name = "AUTHORISATION_ID", referencedColumnName = "ID")
    private AppAuthorisation appAuthorisation;
    @Column(name="PREVIOUS_AUTHORISATION_NO")
    private String previousAuthorisationNo;
    @OneToMany(mappedBy = "appApplication",cascade={CascadeType.ALL})
    private List<AppPerson> appPersonList;
    @OneToMany(mappedBy = "appApplication",cascade={CascadeType.ALL})
    private List<AppOffice> appOfficeList;
    @ManyToOne
    @JoinColumn(name = "APP_CONFIGURATION_ID", referencedColumnName = "ID")
    private AppConfiguration appConfiguration;
    
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="APP_AUTHORISED_AGENT_REL",
        joinColumns={@JoinColumn(name = "APPLICATION_ID",
                referencedColumnName = "ID")},
        inverseJoinColumns = {@JoinColumn(name = "ENTITY_ID",
                referencedColumnName = "ID")}
    )
    private List<EntEntity> authorisedAgentList;
    
    public AppApplication() {
    }

    public String getAccountsOfficesAddress() {
        return accountsOfficesAddress;
    }

    public void setAccountsOfficesAddress(String accountsOfficesAddress) {
        this.accountsOfficesAddress = accountsOfficesAddress;
    }

    public Timestamp getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Timestamp applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApplicationFeeIndicator() {
        return applicationFeeIndicator;
    }

    public void setApplicationFeeIndicator(String applicationFeeIndicator) {
        this.applicationFeeIndicator = applicationFeeIndicator;
    }

    public String getApplicationReference() {
        return applicationReference;
    }

    public void setApplicationReference(String applicationReference) {
        this.applicationReference = applicationReference;
    }

//    public String getApplicationStatus() {
//        return applicationStatus;
//    }
//
//    public void setApplicationStatus(String applicationStatus) {
//        this.applicationStatus = applicationStatus;
//    }

    public Integer getAttachmentCount() {
        return attachmentCount;
    }

    public void setAttachmentCount(Integer attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getCommercialAccounts() {
        return commercialAccounts;
    }

    public void setCommercialAccounts(String commercialAccounts) {
        this.commercialAccounts = commercialAccounts;
    }

    public EntEntity getEntity() {
        return entity;
    }

    public void setEntity(EntEntity entity) {
        this.entity = entity;
    }

    public String getPreviousAuthorisationNo() {
        return previousAuthorisationNo;
    }

    public void setPreviousAuthorisationNo(String previousAuthorisationNo) {
        this.previousAuthorisationNo = previousAuthorisationNo;
    }

    public List<AppPerson> getAppPersonList() {
        return appPersonList;
    }

    public void setAppPersonList(List<AppPerson> appPersonList) {
        this.appPersonList = appPersonList;
    }

    public AppPerson addAppPerson(AppPerson appPerson) {
        getAppPersonList().add(appPerson);
        appPerson.setAppApplication(this);
        return appPerson;
    }

    public AppPerson removeAppPerson(AppPerson appPerson) {
        getAppPersonList().remove(appPerson);
        appPerson.setAppApplication(null);
        return appPerson;
    }

    public List<AppOffice> getAppOfficeList() {
        return appOfficeList;
    }

    public void setAppOfficeList(List<AppOffice> appOfficeList) {
        this.appOfficeList = appOfficeList;
    }

    public AppOffice addAppOffice(AppOffice appOffice) {
        getAppOfficeList().add(appOffice);
        appOffice.setAppApplication(this);
        return appOffice;
    }

    public AppOffice removeAppOffice(AppOffice appOffice) {
        getAppOfficeList().remove(appOffice);
        appOffice.setAppApplication(null);
        return appOffice;
    }

    public void setAppConfiguration(AppConfiguration appConfiguration) {
        this.appConfiguration = appConfiguration;
    }

    public AppConfiguration getAppConfiguration() {
        return appConfiguration;
    }

    public void setAppAuthorisation(AppAuthorisation appAuthorisation) {
        this.appAuthorisation = appAuthorisation;
    }

    public AppAuthorisation getAppAuthorisation() {
        return appAuthorisation;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAppType() {
        return appType;
    }

    public void setAuthorisedAgentList(List<EntEntity> authorisedAgentList) {
        this.authorisedAgentList = authorisedAgentList;
    }

    public List<EntEntity> getAuthorisedAgentList() {
        return authorisedAgentList;
    }
    
    public void addAuthorisedAgent(EntEntity authorisedAgent) {
        getAuthorisedAgentList().add(authorisedAgent);
    }

    public void removeAuthorisedAgent(EntEntity authorisedAgent) {
        getAuthorisedAgentList().remove(authorisedAgent);
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getRejectReason() {
        return rejectReason;
    }
}
