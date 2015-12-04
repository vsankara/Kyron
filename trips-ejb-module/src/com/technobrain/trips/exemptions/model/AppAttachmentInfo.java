package com.technobrain.trips.exemptions.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppAttachmentInfo.findAll", 
    query = "select o from AppAttachmentInfo o")
@Table(name = "APP_ATTACHMENT_INFO")
public class AppAttachmentInfo extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_ATTACHMENT_INFO_SEQ")
    @SequenceGenerator(name = "APP_ATTACHMENT_INFO_SEQ", sequenceName = "APP_ATTACHMENT_INFO_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;    
    @ManyToOne
    @JoinColumn(name = "ECR_ID", referencedColumnName = "ID")
    private AppEcr appEcr;

    public AppAttachmentInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setAppEcr(AppEcr appEcr) {
        this.appEcr = appEcr;
    }

    public AppEcr getAppEcr() {
        return appEcr;
    }
}
