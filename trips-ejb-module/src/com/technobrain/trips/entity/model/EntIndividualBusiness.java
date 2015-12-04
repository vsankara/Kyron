package com.technobrain.trips.entity.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "EntIndividualBusiness.findAll", 
    query = "select o from EntIndividualBusiness o")
@Table(name = "ENT_INDV_BUSINESS")
@DiscriminatorColumn(name="DTYPE")
@DiscriminatorValue("INDVBUSINESS")
public class EntIndividualBusiness extends EntOrganization   {
    public EntIndividualBusiness() {
    }
   
    @OneToOne
    @JoinColumn(name = "ENT_INDIVIDUAL", table="ENT_INDV_BUSINESS",referencedColumnName = "ID")    
    private EntIndividual entIndividual;
    
    public void setEntIndividual(EntIndividual entIndividual) {
        this.entIndividual = entIndividual;
    }

    public EntIndividual getEntIndividual() {
        return entIndividual;
    }
}
