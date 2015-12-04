package com.technobrain.trips.document.model.job;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

//import com.crownagents.trips.document.service.INumGenStrategy;
//
//import com.crownagents.trips.document.service.INumGenStrategyDAO;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "DjobCtrlnbrStrategy.findAll", 
    query = "select o from DjobCtrlnbrStrategy o")
@Table(name = "DJOB_CTRLNBR_STRATEGY")
public class DjobCtrlnbrStrategy extends BaseRefModelObject  {
    @Id
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String description;
    @Column(name="STRATEGY_DEFINITION",nullable = false)
    private String strategyDefination;    
    @OneToMany(mappedBy = "djobCtrlnbrStrategy1")
    private List<DjobCtrlnbrParam> djobCtrlnbrParamList;

    public DjobCtrlnbrStrategy() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DjobCtrlnbrParam> getDjobCtrlnbrParamList() {
        return djobCtrlnbrParamList;
    }

    public void setDjobCtrlnbrParamList(List<DjobCtrlnbrParam> djobCtrlnbrParamList) {
        this.djobCtrlnbrParamList = djobCtrlnbrParamList;
    }

    public DjobCtrlnbrParam addDjobCtrlnbrParam(DjobCtrlnbrParam djobCtrlnbrParam) {
        getDjobCtrlnbrParamList().add(djobCtrlnbrParam);
        djobCtrlnbrParam.setDjobCtrlnbrStrategy1(this);
        return djobCtrlnbrParam;
    }

    public DjobCtrlnbrParam removeDjobCtrlnbrParam(DjobCtrlnbrParam djobCtrlnbrParam) {
        getDjobCtrlnbrParamList().remove(djobCtrlnbrParam);
        djobCtrlnbrParam.setDjobCtrlnbrStrategy1(null);
        return djobCtrlnbrParam;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setStrategyDefination(String strategyDefination) {
        this.strategyDefination = strategyDefination;
    }

    public String getStrategyDefination() {
        return strategyDefination;
    }

//    public INumGenStrategy getImplementation(INumGenStrategyDAO dao) {
//        String className =  this.getStrategyDefination();
//        INumGenStrategy genStrategy = null;
//          try {
//              genStrategy = (INumGenStrategy)Class.forName(className).newInstance();
//              genStrategy.setDAO(dao);
//          } catch (IllegalAccessException e) {
//               throw new IllegalAccessError(e.getMessage());
//          } catch (InstantiationException e) {
//              throw new IllegalAccessError(e.getMessage());
//          } catch (ClassNotFoundException e) {
//              throw new IllegalAccessError(e.getMessage());
//          }
//          
//        return genStrategy;
//    }
}
