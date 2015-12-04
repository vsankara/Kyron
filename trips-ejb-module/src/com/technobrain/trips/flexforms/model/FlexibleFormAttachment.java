package com.technobrain.trips.flexforms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.technobrain.trips.core.model.BaseNormalModelObject;

@Entity(name = "FlexibleFormAttachment")
@NamedQueries({
	@NamedQuery(name = "FlexibleFormAttachment.findAll"
		, query = "select o from FlexibleFormAttachment o"),
	@NamedQuery(name="FlexibleFormAttachment.findFlexibleFormAttachmentByFormId"
		, query="select o from FlexibleFormAttachment o where o.flexFromType = ?1 and o.flexFromId = ?2 and (o.status = 'A' or o.status = 'P')"),
	@NamedQuery(name="FlexibleFormAttachment.findFlexibleFormAttachmentByFormReference"
		, query="select o from FlexibleFormAttachment o where o.flexFromType = ?1 and o.flexFromReference = ?2 and (o.status = 'A' or o.status = 'P')")

}) 
@Table(name = "FLEXIBLE_ATTACHMENT")
public class FlexibleFormAttachment extends BaseNormalModelObject {
    @Id    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "FLEXIBLE_ATTACHMENT_SEQ")
    @SequenceGenerator(name = "FLEXIBLE_ATTACHMENT_SEQ", 
                       sequenceName = "FLEXIBLE_ATTACHMENT_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="FILE_NAME", nullable = false)
    private String fileName;
    @Column(name="REFERENCE")
    private String reference;
    @Column(name="NOTES")
    private String notes;
    @Column(name="FILE_STORE_ID")
    private Long fileStoreId;
    @Column(name="FLEX_FROM_TYPE")
    private String flexFromType;
    @Column(name="FLEX_FROM_ID")
    private Long flexFromId;
    @Column(name="FLEX_FROM_REFERENCE")
    private String flexFromReference;
    
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Long getFileStoreId() {
		return fileStoreId;
	}
	public void setFileStoreId(Long fileStoreId) {
		this.fileStoreId = fileStoreId;
	}
	public String getFlexFromType() {
		return flexFromType;
	}
	public void setFlexFromType(String flexFromType) {
		this.flexFromType = flexFromType;
	}
	public Long getFlexFromId() {
		return flexFromId;
	}
	public void setFlexFromId(Long flexFromId) {
		this.flexFromId = flexFromId;
	}
	public String getFlexFromReference() {
		return flexFromReference;
	}
	public void setFlexFromReference(String flexFromReference) {
		this.flexFromReference = flexFromReference;
	}

    

   

        
        
   
    
    
}
