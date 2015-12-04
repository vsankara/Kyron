package com.technobrain.trips.revenueaccount.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

import java.sql.Timestamp;

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
@NamedQueries({
    @NamedQuery(
        name = "RevComplianceConfiguration.findAll", 
        query = "select o from RevComplianceConfiguration o"),
    @NamedQuery(
        name="RevComplianceConfiguration.findComplianceConfigurationById",
        query="select conf from RevComplianceConfiguration conf where conf.id = ?1"
    )
})
@Table(name = "REV_COMPLIANCE_CONF")
public class RevComplianceConfiguration extends BaseNormalModelObject   {
    @Column(name="ASSESSMENT_MARKUP_RATE")
    private BigDecimal assessmentMarkupRate;
    @Column(name="COMPLIANCE_TYPE")
    private String complianceType;
    @Column(name="GRACE_PERIOD")
    private Integer gracePeriod;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REV_COMPLIANCE_CONF_SEQ")
    @SequenceGenerator(name = "REV_COMPLIANCE_CONF_SEQ", sequenceName = "REV_COMPLIANCE_CONF_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="INTEREST_METHOD")
    private String interestMethod;
    @Column(name="INTEREST_RATE")
    private BigDecimal interestRate;
    private BigDecimal penalty;
    @Column(name="PENALTY_METHOD")
    private String penaltyMethod;
    @Column(name="REVENUE_TYPE")
    private String revenueType;
    @Column(name="TAXPAYER_TYPE")
    private String taxpayerType;
    
    
    @Column(name="POSTING_LIMIT")
    private BigDecimal postingLimit;
    
    @Column(name="INSTALLMENT_AGREEMENT_EFF")
    private String installmentAgreementEffect;
    
    @Column(name="OBJECTION_APPEAL_EFF")
    private String objectionAppealEffect;
    
    
    @OneToMany(mappedBy = "complianceConfiguration" ,cascade={CascadeType.ALL})
    private List<RevComplianceAction> complianceActions;
    
    @Column(name="TAXPAYER_CATEGORY")
    private String taxPayerCategory;
    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
//    @ManyToMany(cascade={CascadeType.ALL})
//    @JoinTable(name="COLL_TAXTYPE_TAXPAYER",
//        joinColumns={@JoinColumn(name = "COMPLIANCE_ID",
//            referencedColumnName = "ID")},
//        inverseJoinColumns = {@JoinColumn(name = "TAXPAYER_ID",
//                referencedColumnName = "ID")}
//    )
//    private List<RevComplianceTaxpayerType> complianceTaxpayerType;

//    @ManyToMany(cascade={CascadeType.ALL})
//    @JoinTable(name="COLL_TAXTYPE_TAXPAYER",
//        joinColumns={@JoinColumn(name = "COMPLIANCE_ID",
//            referencedColumnName = "ID")},
//        inverseJoinColumns = {@JoinColumn(name = "TAXTYPE_ID",
//                referencedColumnName = "ID")}
//    )
//    private List<RevComplianceTaxType> complianceTaxType;
    @OneToMany(mappedBy = "complianceConfiguration" ,cascade={CascadeType.ALL})
    private List<RevComplianceTaxType> complianceTaxType;
    
    @OneToMany(mappedBy = "complianceConfiguration" ,cascade={CascadeType.ALL})
    private List<RevComplianceIndCategory> complianceIndCategory;
    
    @OneToMany(mappedBy = "complianceConfiguration" ,cascade={CascadeType.ALL})
    private List<RevComplianceTaxpayerType> complianceTaxpayerType;
    

    public RevComplianceConfiguration() {
    }

    public BigDecimal getAssessmentMarkupRate() {
        return assessmentMarkupRate;
    }

    public void setAssessmentMarkupRate(BigDecimal assessmentMarkupRate) {
        this.assessmentMarkupRate = assessmentMarkupRate;
    }

    public String getComplianceType() {
        return complianceType;
    }

    public void setComplianceType(String complianceType) {
        this.complianceType = complianceType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInterestMethod() {
        return interestMethod;
    }

    public void setInterestMethod(String interestMethod) {
        this.interestMethod = interestMethod;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getPenalty() {
        return penalty;
    }

    public void setPenalty(BigDecimal penalty) {
        this.penalty = penalty;
    }

    public String getPenaltyMethod() {
        return penaltyMethod;
    }

    public void setPenaltyMethod(String penaltyMethod) {
        this.penaltyMethod = penaltyMethod;
    }

    public void setComplianceActions(List<RevComplianceAction> complianceActions) {
        this.complianceActions = complianceActions;
    }

    public List<RevComplianceAction> getComplianceActions() {
        return complianceActions;
    }
    
    public RevComplianceAction addRevComplianceAction(RevComplianceAction revComplianceAction) {
        getComplianceActions().add(revComplianceAction);
        revComplianceAction.setComplianceConfiguration(this);
        return revComplianceAction;
    }

    public RevComplianceAction removeRevComplianceAction(RevComplianceAction revComplianceAction) {
        getComplianceActions().remove(revComplianceAction);
        revComplianceAction.setComplianceConfiguration(null);
        return revComplianceAction;
    }


    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setGracePeriod(Integer gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setPostingLimit(BigDecimal postingLimit) {
        this.postingLimit = postingLimit;
    }

    public BigDecimal getPostingLimit() {
        return postingLimit;
    }

    public void setObjectionAppealEffect(String objectionAppealEffect) {
        this.objectionAppealEffect = objectionAppealEffect;
    }

    public String getObjectionAppealEffect() {
        return objectionAppealEffect;
    }

    public void setInstallmentAgreementEffect(String installmentAgreementEffect) {
        this.installmentAgreementEffect = installmentAgreementEffect;
    }

    public String getInstallmentAgreementEffect() {
        return installmentAgreementEffect;
    }

    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getTaxpayerType() {
        return taxpayerType;
    }

    public void setTaxPayerCategory(String taxPayerCategory) {
        this.taxPayerCategory = taxPayerCategory;
    }

    public String getTaxPayerCategory() {
        return taxPayerCategory;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }
    
    public RevComplianceTaxType addRevComplianceTaxType(RevComplianceTaxType revComplianceTaxType) {
        getComplianceTaxType().add(revComplianceTaxType);
        revComplianceTaxType.setComplianceConfiguration(this);
        return revComplianceTaxType;
    }

    public RevComplianceTaxType removeRevComplianceTaxType(RevComplianceTaxType revComplianceTaxType) {
        getComplianceActions().remove(revComplianceTaxType);
        revComplianceTaxType.setComplianceConfiguration(null);
        return revComplianceTaxType;
    }
    
    public RevComplianceIndCategory addRevComplianceIndCategory(RevComplianceIndCategory revComplianceIndCategory) {
        getComplianceIndCategory().add(revComplianceIndCategory);
        revComplianceIndCategory.setComplianceConfiguration(this);
        return revComplianceIndCategory;
    }

    public RevComplianceIndCategory removeRevComplianceIndCategory(RevComplianceIndCategory revComplianceIndCategory) {
        getComplianceIndCategory().remove(revComplianceIndCategory);
        revComplianceIndCategory.setComplianceConfiguration(null);
        return revComplianceIndCategory;
    }

    public void setComplianceTaxType(List<RevComplianceTaxType> complianceTaxType) {
        this.complianceTaxType = complianceTaxType;
    }

    public List<RevComplianceTaxType> getComplianceTaxType() {
        return complianceTaxType;
    }

    public void setComplianceIndCategory(List<RevComplianceIndCategory> complianceIndCategory) {
        this.complianceIndCategory = complianceIndCategory;
    }

    public List<RevComplianceIndCategory> getComplianceIndCategory() {
        return complianceIndCategory;
    }


    public void setComplianceTaxpayerType(List<RevComplianceTaxpayerType> complianceTaxpayerType) {
        this.complianceTaxpayerType = complianceTaxpayerType;
    }

    public List<RevComplianceTaxpayerType> getComplianceTaxpayerType() {
        return complianceTaxpayerType;
    }
    
    public RevComplianceTaxpayerType addRevComplianceTaxpayerType(RevComplianceTaxpayerType complianceTaxpayerType) {
        getComplianceTaxpayerType().add(complianceTaxpayerType);
        complianceTaxpayerType.setComplianceConfiguration(this);
        return complianceTaxpayerType;
    }

    public RevComplianceTaxpayerType removeRevComplianceTaxpayerType(RevComplianceTaxpayerType complianceTaxpayerType) {
        getComplianceTaxpayerType().remove(complianceTaxpayerType);
        complianceTaxpayerType.setComplianceConfiguration(null);
        return complianceTaxpayerType;
    }

}
