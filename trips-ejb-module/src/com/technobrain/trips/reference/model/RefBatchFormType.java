package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries({
    @NamedQuery(name = "RefBatchFormType.findAll", query = "select o from RefBatchFormType o"),
    @NamedQuery(name = "RefBatchFormType.findByCode", query = "select o from RefBatchFormType o where o.code = ?1")
})
@Table(name = "REF_BATCH_FORM_TYPE")
public class RefBatchFormType extends BaseRefModelObject {
    @Column(name="APPROVAL_GROUP")
    private String approvalGroup;
    @Column(name="BACKING_BEAN_USED")
    private String backingBeanUsed;
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="LINK_PAGE")
    private String linkPage;
    @Column(name="SEARCH_ID")
    private String searchId;

    public RefBatchFormType() {
    }

   public String getApprovalGroup() {
        return approvalGroup;
    }

    public void setApprovalGroup(String approvalGroup) {
        this.approvalGroup = approvalGroup;
    }

    public String getBackingBeanUsed() {
        return backingBeanUsed;
    }

    public void setBackingBeanUsed(String backingBeanUsed) {
        this.backingBeanUsed = backingBeanUsed;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getLinkPage() {
        return linkPage;
    }

    public void setLinkPage(String linkPage) {
        this.linkPage = linkPage;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public String getSearchId() {
        return searchId;
    }
}
