package com.technobrain.trips.exemptions.model;

import com.technobrain.trips.application.model.AppApplication;
import com.technobrain.trips.core.annotation.ReferenceNumber;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@NamedQueries( { @NamedQuery(name = "AppExemption.findAll", query = "select o from AppExemption o"),
                 @NamedQuery(name = "AppExemption.findById", 
    query = "select o from AppExemption o where o.id = ?1 and o.status=?2"),
     @NamedQuery(name = "AppExemption.findExemptionApplicationByCodeAndStatus", 
    query = "select o from AppExemption o,AppEcr appEcr where o.appEcr.id=appEcr.id and appEcr.code = ?1 and o.docStatus in (?2) and appEcr.periodFrom <= CURRENT_TIMESTAMP and (appEcr.periodTo is NULL or appEcr.periodTo >= CURRENT_TIMESTAMP)")
    } )
@Table(name = "APP_EXEMPTION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "APP_TYPE")
@DiscriminatorValue("APP_EXMPN")
public class AppExemption extends AppApplication {
    
   
    @ReferenceNumber(format="EASQL", sql="SELECT LTRIM(TO_CHAR(MOD(ECR_CODE_SEQ.nextval,00000000),'00000099')) as generatedId FROM dual")
    @Column
    private String reference;
    @Column(name="TAXPAYER_TIN")
    private String taxPayerTin;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "APPECR_ID", referencedColumnName = "ID")
    private AppEcr appEcr;
    @Column(name="DECLARANT_NAME")
    private String declarantName;
    @Column(name="TASK_TITLE")
    private String taskTitle;
    @Column(name="DECLARANT_POSITION")
    private String declarantPosition;
    @Column(name="DECLARANT_TIN")
    private String declarantTin;
    @Column(name="VETTING_OFF_NAME")
    private String vettingOfficerName;
    @Column(name="ON_BEHALF_OF_TAXPAYER")
    private String isMakOnBehalfOfTaxPayer;
    @Column(name="CANCEL_REJ_REASON")
    private String cancelRejReason;
    @Column(name="CANCEL_REASON")
    private String cancelReason;
    @Column(name="CANCEL_NOTES")
    private String cancelNotes;
    
    public AppExemption() {
    }

    public void setAppEcr(AppEcr appEcr) {
        this.appEcr = appEcr;
    }

    public AppEcr getAppEcr() {
        return appEcr;
    }

    public void setTaxPayerTin(String taxPayerTin) {
        this.taxPayerTin = taxPayerTin;
    }

    public String getTaxPayerTin() {
        return taxPayerTin;
    }

  

    public void setDeclarantName(String declarantName) {
        this.declarantName = declarantName;
    }

    public String getDeclarantName() {
        return declarantName;
    }

    public void setDeclarantPosition(String declarantPosition) {
        this.declarantPosition = declarantPosition;
    }

    public String getDeclarantPosition() {
        return declarantPosition;
    }

    public void setDeclarantTin(String declarantTin) {
        this.declarantTin = declarantTin;
    }

    public String getDeclarantTin() {
        return declarantTin;
    }

    public void setVettingOfficerName(String vettingOfficerName) {
        this.vettingOfficerName = vettingOfficerName;
    }

    public String getVettingOfficerName() {
        return vettingOfficerName;
    }

    public void setIsMakOnBehalfOfTaxPayer(String isMakOnBehalfOfTaxPayer) {
        this.isMakOnBehalfOfTaxPayer = isMakOnBehalfOfTaxPayer;
    }

    public String getIsMakOnBehalfOfTaxPayer() {
        return isMakOnBehalfOfTaxPayer;
    }

    public void setCancelRejReason(String cancelRejReason) {
        this.cancelRejReason = cancelRejReason;
    }

    public String getCancelRejReason() {
        return cancelRejReason;
    }


    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelNotes(String cancelNotes) {
        this.cancelNotes = cancelNotes;
    }

    public String getCancelNotes() {
        return cancelNotes;
    }
}
