package com.technobrain.trips.exemptions.model;

import com.technobrain.trips.common.model.CommAttachment;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQueries(
    {
    @NamedQuery(name = "AppEcr.findAll", query = "select o from AppEcr o"),
    @NamedQuery(name = "AppEcr.findById", 
    query = "select o from AppEcr o where o.id = ?1")
    }
)
@Table(name = "APP_ECR")

public class AppEcr  extends BaseNormalModelObject{
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_ECR_SEQ")
    @SequenceGenerator(name = "APP_ECR_SEQ", sequenceName = "APP_ECR_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    private String code;
    @Column(name="TAX_TYPE")
    private String exemTaxType;
    @Column(name="PERIOD_FROM")
    private Timestamp periodFrom;
    @Column(name="PERIOD_TO")
    private Timestamp periodTo;
//    @OneToMany(mappedBy = "appEcr" , cascade={CascadeType.ALL})
   // private List<AppAttachmentInfo> appAttachmentInfoList;
    @OneToMany(mappedBy = "appEcr" , cascade={CascadeType.ALL})
    private List<QualificationAttributes> qualificationAttributesList;
    @Column(name="RETURN_TYPE")
    private String returnType;
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="APP_ATTACHMENT_INFO",
        joinColumns={@JoinColumn(name = "ECR_ID",
                referencedColumnName = "ID")},
        inverseJoinColumns = {@JoinColumn(name = "COMM_ATTACHMENT_ID",
                referencedColumnName = "ID")}
    )
    private List<CommAttachment> commAttachmentList = new ArrayList<CommAttachment>();
   
    public AppEcr() {
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
  
    public void setExemTaxType(String exemTaxType) {
        this.exemTaxType = exemTaxType;
    }

    public String getExemTaxType() {
        return exemTaxType;
    }

   
    public void setQualificationAttributesList(List<QualificationAttributes> qualificationAttributesList) {
        this.qualificationAttributesList = qualificationAttributesList;
    }

    public List<QualificationAttributes> getQualificationAttributesList() {
        return qualificationAttributesList;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }


    public void setPeriodFrom(Timestamp periodFrom) {
        this.periodFrom = periodFrom;
    }

    public Timestamp getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodTo(Timestamp periodTo) {
        this.periodTo = periodTo;
    }

    public Timestamp getPeriodTo() {
        return periodTo;
    }
    
    public QualificationAttributes addQualificationAttributes(QualificationAttributes qualificationAttributesList) {
        getQualificationAttributesList().add(qualificationAttributesList);
        qualificationAttributesList.setAppEcr(this);
        return qualificationAttributesList;
    }

    public QualificationAttributes removeQualificationAttributes(QualificationAttributes qualificationAttributesList) {
        getQualificationAttributesList().remove(qualificationAttributesList);
        qualificationAttributesList.setAppEcr(null);
        return qualificationAttributesList;
    }
    
    public void setCommAttachmentList(List<CommAttachment> commAttachmentList) {
        this.commAttachmentList = commAttachmentList;
    }

    public List<CommAttachment> getCommAttachmentList() {
        return commAttachmentList;
    }
    
    public CommAttachment addCommAttachment(CommAttachment commAttachment) {
        getCommAttachmentList().add(commAttachment);
        return commAttachment;
    }

    public CommAttachment removeCommAttachment(CommAttachment commAttachment) {
        getCommAttachmentList().remove(commAttachment);
        return commAttachment;
    }
    
}
