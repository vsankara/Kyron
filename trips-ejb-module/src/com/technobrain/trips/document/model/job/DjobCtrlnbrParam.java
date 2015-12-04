package com.technobrain.trips.document.model.job;

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
@NamedQuery(name = "DjobCtrlnbrParam.findAll", 
    query = "select o from DjobCtrlnbrParam o")
@Table(name = "DJOB_CTRLNBR_PARAM")
public class DjobCtrlnbrParam extends BaseNormalModelObject implements IControlNumberDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DJOB_CTRLNBR_PARAM_seq")
    @SequenceGenerator(name = "DJOB_CTRLNBR_PARAM_seq", sequenceName = "DJOB_CTRLNBR_PARAM_seq", allocationSize = 1)
    @Column(nullable = false)
    Long id;
    @Column(name="DOC_ENDNBR")
    private String docEndnbr;
    @Column(name="DOC_LASTNBR_USED")
    private String docLastnbrUsed;
    @Column(name="DOC_PRV_ENDNBR")
    private String docPrvEndnbr;
    @Column(name="DOC_PRV_STARTNBR")
    private String docPrvStartnbr;
    @Column(name="DOC_TYPE", nullable = false)
    private String docType;
    @ManyToOne
    @JoinColumn(name = "DJOB_CTRLNBR_STRATEGY", referencedColumnName = "CODE")
    private DjobCtrlnbrStrategy djobCtrlnbrStrategy1;

    public DjobCtrlnbrParam() {
    }


    public String getDocEndnbr() {
        return docEndnbr;
    }

    public void setDocEndnbr(String docEndnbr) {
        this.docEndnbr = docEndnbr;
    }

    public String getDocLastnbrUsed() {
        return docLastnbrUsed;
    }

    public void setDocLastnbrUsed(String docLastnbrUsed) {
        this.docLastnbrUsed = docLastnbrUsed;
    }

    public String getDocPrvEndnbr() {
        return docPrvEndnbr;
    }

    public void setDocPrvEndnbr(String docPrvEndnbr) {
        this.docPrvEndnbr = docPrvEndnbr;
    }

    public String getDocPrvStartnbr() {
        return docPrvStartnbr;
    }

    public void setDocPrvStartnbr(String docPrvStartnbr) {
        this.docPrvStartnbr = docPrvStartnbr;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }
    public DjobCtrlnbrStrategy getDjobCtrlnbrStrategy1() {
        return djobCtrlnbrStrategy1;
    }

    public void setDjobCtrlnbrStrategy1(DjobCtrlnbrStrategy djobCtrlnbrStrategy1) {
        this.djobCtrlnbrStrategy1 = djobCtrlnbrStrategy1;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

//    public INumGenStrategy getStrategy(INumGenStrategyDAO dao) {
//       INumGenStrategy gs = this.djobCtrlnbrStrategy1.getImplementation(dao);
//       return gs;
//    }
}
