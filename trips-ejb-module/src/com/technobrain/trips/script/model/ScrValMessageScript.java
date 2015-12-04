package com.technobrain.trips.script.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

 /**
  * @ Crown Agents 2010
  *
  * Model class representing the table "SCR_VAL_MESSAGE_SCRIPT". It also represents one 
  * of the usage types for Script Manager
  * 
  * @since       $Date: $
  * @version     $Revision: $
  * @author      $Author: Uma shankar kathinokkula$
  * 
  */
@Entity
@NamedQueries( { @NamedQuery(name = "ScrValMessageScript.findAll", 
                             query = "select o from ScrValMessageScript o")
        , 
        @NamedQuery(name = "ScrValMessageScript.findAllByMessageType", query = 
                    "select o from ScrValMessageScript o where o.messageType = ?1")
        } )
@Table(name = "SCR_VAL_MESSAGE_SCRIPT")
@DiscriminatorColumn(name = "USAGE_TYPE")
@DiscriminatorValue("ValidationService")
public class ScrValMessageScript extends ScrCommScript {
    @Column(name = "MESSAGE_TYPE", nullable = false)
    private String messageType;

    public ScrValMessageScript() {
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
