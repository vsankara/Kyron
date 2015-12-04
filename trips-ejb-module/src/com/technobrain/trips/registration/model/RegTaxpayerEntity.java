package com.technobrain.trips.registration.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.entity.model.EntEntity;
import com.technobrain.trips.revenuecollection.model.TillHistory;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQueries (
    {
        @NamedQuery(name = "RegTaxpayerEntity.findAll", 
            query = "select o from RegTaxpayerEntity o"),
        @NamedQuery(name = "RegTaxpayerEntity.findByEntityAndRegistrationType",
            query = "SELECT o                   " +
            "        FROM RegTaxpayerEntity o   " +
            "        WHERE o.entId = ?1         " +
            "        AND o.registrationType = ?2"),
        @NamedQuery(name = "RegTaxpayerEntity.updateTaxpayerAccountId",
            query = "UPDATE RegTaxpayerEntity o     " +
                    "SET o.taxpayerAccountId = ?1   " +
                    "WHERE o.id = ?2"),
        @NamedQuery(name = "RegTaxpayerEntity.removeEntity",
            query = "DELETE FROM RegTaxpayerEntity o " +
                    "WHERE o.id = ?1"),
        @NamedQuery(name = "RegTaxpayerEntity.updateOffice",
            query = "UPDATE RegTaxpayerEntity o     " +
                    "SET o.office = ?1   " +
                    "WHERE o.id = ?2"),
        @NamedQuery(name = "RegTaxpayerEntity.findById",
            query = "SELECT o                   " +
            "        FROM RegTaxpayerEntity o   " +
            "        WHERE o.id = ?1         "),
        @NamedQuery(name = "RegTaxpayerEntity.findByEntIdRegTypeRegStatus",
            query = "SELECT o                   " +
            "        FROM RegTaxpayerEntity o   " +
            "        WHERE o.entId = ?1         " +
            "        AND o.registrationType = ?2 " +
            "        AND o.registrationStatus = ?3 "),            
        @NamedQuery(name = "RegTaxpayerEntity.findAccountNumberByEntityIdAndRevenue",
            query = "SELECT t                   " +
            "        FROM RegTaxpayerEntity o, RegTaxpayerRevenue r, RegTaxpayer t  " +
            "        WHERE o.entId = ?1  and o.id = r.id and o.id = t.id and r.revenueType = ?2     ")
    }
)

@Table(name = "REG_TAXPAYER_ENTITY")
@Inheritance(strategy=InheritanceType.JOINED) 
@DiscriminatorColumn(name="REGISTRATION_TYPE", discriminatorType=DiscriminatorType.STRING, length=500)
public abstract class RegTaxpayerEntity extends BaseNormalModelObject {


    @ManyToOne
    @JoinColumn(name = "ENT_ID", referencedColumnName = "ID", nullable = false, insertable=false, updatable=false)
    private EntEntity entEntity;
    
    @Column(name="ENT_ID", nullable = false)
    private Long entId;

    @Id
    @GeneratedValue(generator="regTaxpayerEntity")
    @SequenceGenerator(name="regTaxpayerEntity",sequenceName="REG_TAXPAYER_ENTITY_SEQ", allocationSize = 1)
    @Column(name="ID" ,nullable = false)
    private Long id;
    
    @Column(name="EDD")
    private Timestamp edd;
    
    @Column(name="EDR")
    private Timestamp edr;
    
    @Column(name="EDS")
    private Timestamp eds;
    
    @Column(name="EDA")
    private Timestamp eda;
    
    @Column(name="END_DATE")
    private Timestamp endDate;
    
    @Column(name="EDT")
    private Timestamp edt;

    @Column(name="REGISTRATION_STATUS", nullable = false)
    private String registrationStatus;

    @Column(name="REGISTRATION_TYPE", nullable = false)
    private String registrationType;

    @Column(name="TAXPAYER_ACCOUNT_ID")
    private Long taxpayerAccountId;
    
    @Column(name="OFFICE")
    private String office;
    
    @Column(name="FORCED_REGISTRATION_IND")
    private String forcedRegistrationInd;
    
    @Column(name="REASON")
    private String reason;
    
    @OneToMany(mappedBy = "regRevenueId", cascade={CascadeType.ALL})
    private List<RegRevenueReturns> regRevenueReturnsList;

//    @ManyToOne(cascade={CascadeType.REFRESH})
//    @JoinColumn(name = "REGISTRATION_STATUS", referencedColumnName = "CODE")
//    private String refRevAccStatus;
 

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaxpayerAccountId() {
        return taxpayerAccountId;
    }

    public void setTaxpayerAccountId(Long taxpayerAccountId) {
        this.taxpayerAccountId = taxpayerAccountId;
    }

    public String getRegistrationStatus() {
           return registrationStatus;
      }
    
       public void setRegistrationStatus(String registrationStatus) {
           this.registrationStatus = registrationStatus;
      }

//    public void setRefRevAccStatus(RefRevAccStatus refRevAccStatus) {
//        this.refRevAccStatus = refRevAccStatus;
//    }
//
//    public RefRevAccStatus getRefRevAccStatus() {
//        return refRevAccStatus;
//    }

    public void setEdd(Timestamp edd) {
        this.edd = edd;
    }

    public Timestamp getEdd() {
        return edd;
    }

    public void setEdr(Timestamp edr) {
        this.edr = edr;
    }

    public Timestamp getEdr() {
        return edr;
    }

    public void setEds(Timestamp eds) {
        this.eds = eds;
    }

    public Timestamp getEds() {
        return eds;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEda(Timestamp eda) {
        this.eda = eda;
    }

    public Timestamp getEda() {
        return eda;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOffice() {
        return office;
    }

    public void setEdt(Timestamp edt) {
        this.edt = edt;
    }

    public Timestamp getEdt() {
        return edt;
    }

    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }

    public EntEntity getEntEntity() {
        return entEntity;
    }

    public void setEntId(Long entId) {
        this.entId = entId;
    }

    public Long getEntId() {
        return entId;
    }

    public void setForcedRegistrationInd(String forcedRegistrationInd) {
        this.forcedRegistrationInd = forcedRegistrationInd;
    }

    public String getForcedRegistrationInd() {
        return forcedRegistrationInd;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setRegRevenueReturnsList(List<RegRevenueReturns> regRevenueReturnsList) {
        this.regRevenueReturnsList = regRevenueReturnsList;
    }

    public List<RegRevenueReturns> getRegRevenueReturnsList() {
        return regRevenueReturnsList;
    }
}
