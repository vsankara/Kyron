package com.technobrain.trips.reports.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "ReportStore.findAll", 
    query = "select o from ReportStore o")
@Table(name = "REPORT_STORE")
public class ReportStore extends BaseNormalModelObject {

//    @Column(name="DEFAULT_ASSIGNMENT_GROUP")
//    private String defaultAssignmentGroup;
//    @Column(name="DEFAULT_ASSIGNMENT_USER")
//    private String defaultAssignmentUser;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "REPORT_STORE_SEQ")
    @SequenceGenerator(name = "REPORT_STORE_SEQ", 
                       sequenceName = "REPORT_STORE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    
   
    @Column(name = "DATA")
    private  byte[] data;
    @Column(name = "NO_OF_COPIES_PRINTED")
    private Long noCopiesPrinted;
    @Column(name = "REPORT_NUMBER")
    private Long reportNumber;
    @Column(name = "TIN")
    private String tin;
    @Column(name = "TAXPAYER_NAME")
    private String taxpayerName;
    @Column(name = "TAX_TYPE")
    private String taxType;
    @Column(name = "REPORT_FILE_NAME")
    private String reportFileName;
    
    @Column(name = "REP_DETAILS_ID")
    private Long reportDetailsId;
    
    
//    @ManyToOne(cascade = { CascadeType.ALL })
//    @JoinColumn(name = "REP_DETAILS_ID", referencedColumnName = "ID")
//    private ReportDetails reportDetails;
//    

    @OneToMany(mappedBy = "reportstore", cascade={CascadeType.ALL})
     private List<ReportReprint> reportReprint;


//    @Column(name="OWNER_GROUP")
//    private String ownerGroup;
//    @Column(name="OWNER_USER")
//    private String ownerUser;


    public ReportStore() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



//    public void setNoCopiesPrinted(Long noCopiesPrinted) {
//        this.noCopiesPrinted = noCopiesPrinted;
//    }
//
//   private Long getNoCopiesPrinted() {
//        if (null == this.noCopiesPrinted) {
//            return new Long(1);
//        } else
//            return this.noCopiesPrinted.longValue() + 1;
//    }

    public void setReportNumber(Long reportNumber) {
        this.reportNumber = reportNumber;
    }

    public Long getReportNumber() {
        return reportNumber;
    }
    


    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getTin() {
        return tin;
    }

    public void setTaxpayerName(String taxpayerName) {
        this.taxpayerName = taxpayerName;
    }

    public String getTaxpayerName() {
        return taxpayerName;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportReprint(List<ReportReprint> reportReprint) {
        this.reportReprint = reportReprint;
    }

    public List<ReportReprint> getReportReprint() {
        return reportReprint;
    }

//    public void setReportDetails(String reportDetails) {
//        this.reportDetails = reportDetails;
//    }
//
//    public String getReportDetails() {
//        return reportDetails;
//    }

   

    public void setNoCopiesPrinted(Long noCopiesPrinted) {
        this.noCopiesPrinted = noCopiesPrinted;
    }

    public Long getNoCopiesPrinted() {
        return noCopiesPrinted;
    }
//    public void setReportDetails(ReportDetails reportDetails) {
//        this.reportDetails = reportDetails;
//    }
//
//    public ReportDetails getReportDetails() {
//        return reportDetails;
//    }
  
    public void setReportDetailsId(Long reportDetailsId) {
        this.reportDetailsId = reportDetailsId;
    }

    public Long getReportDetailsId() {
        return reportDetailsId;
    }


    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }
}
