package com.technobrain.trips.registration.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "REG_TRANSFER_BATCH_SEQ", 
                   sequenceName = "REG_TRANSFER_BATCH_SEQ", initialValue = 1, 
                   allocationSize = 1)
@NamedQueries (
    {
        @NamedQuery(name = "RegTaxpayerTransferBatch.findAllTINTransferBatch", 
            query = "select o from RegTaxpayerTransferBatch o"),
        @NamedQuery(name = "RegTaxpayerTransferBatch.findTinByStatus",
            query = "SELECT o.tin                   " +
            "        FROM RegTaxpayerTransferBatch o   " +
            "        WHERE o.tinstatus = ?1         "),     
        @NamedQuery(name = "RegTaxpayerTransferBatch.findByTinAndFileId",
            query = "SELECT o " +
            "        FROM RegTaxpayerTransferBatch o   " +
            "        WHERE o.tin = ?1  and o.fileid = ?2"), 
       @NamedQuery(name = "RegTaxpayerTransferBatch.findCountTinByStatus",
            query = "SELECT COUNT(o.tin)                   " +
            "        FROM RegTaxpayerTransferBatch o   " +
            "        WHERE o.tinstatus = ?1         ")
//       @NamedQuery(name = "RegTaxpayerTransferBatch.findAllByRowCountAndStatus",
//            query = "SELECT o FROM RegTaxpayerTransferBatch o where o.tin=?1 and ROWNUM < ?2 ORDER BY o.tin")            
    }
)

@Table(name = "REG_TAXPAYER_TRANSFER_BATCH")
//TODO Remove inheritance and extend basemodel
//@Inheritance

public class RegTaxpayerTransferBatch  extends BaseNormalModelObject{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REG_TRANSFER_BATCH_SEQ")
    @Column(nullable = false)
    private Long id;
    
    @Column(name="FILE_ID")
    private Long fileid; 
    
    @Column(name="TIN", nullable = false)
    private String tin;
    
    @Column(name="EXCEPTION", nullable = false)
    private String exception;
    
    @Column(name="TIN_STATUS", nullable = false)
    private String tinstatus;
    
    @Column(name="NEW_OFFICE", nullable = false)
    private String newOffice;
    
    @Column(name="REASON", nullable = false)
    private String reason;
    
    @Column(name="OLD_OFFICE")
    private String oldOffice;
    

    public RegTaxpayerTransferBatch() {
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFileid(Long fileid) {
        this.fileid = fileid;
    }

    public Long getFileid() {
        return fileid;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getTin() {
        return tin;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }

    public void setTinstatus(String tinstatus) {
        this.tinstatus = tinstatus;
    }

    public String getTinstatus() {
        return tinstatus;
    }

    public void setNewOffice(String newOffice) {
        this.newOffice = newOffice;
    }

    public String getNewOffice() {
        return newOffice;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }


    public void setOldOffice(String oldOffice) {
        this.oldOffice = oldOffice;
    }

    public String getOldOffice() {
        return oldOffice;
    }
}
