package com.technobrain.trips.account.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name="SuspenseAccount")
@Table(name="ACC_SUSPENSE")
@DiscriminatorValue("SUSPENSE")       
@Inheritance
@NamedQuery(name = "SuspenseAccount.findAll", 
    query = "select o from SuspenseAccount o")
public class SuspenseAccount extends Account {
    
}
