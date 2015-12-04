package com.technobrain.trips.entity.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * TechnoBrain 2015
 *
 * Entity for table ENT_PLANE
 *
 * @since	$Date: 2/2/2009 5:27:04 AM$
 * @version 	$Revision: 14$
 * @author 	$Author: Howard Hill$
 * 
 * $Log[1]:
 *  14   TRIPS2    1.13        2/2/2009 5:27:04 AM    Howard Hill     change
 *       log[10] to log[1]
 * $
 */
@Entity
@NamedQuery(name = "EntPlane.findAll", query = "select o from EntPlane o")
@Table(name = "ENT_PLANE")
@DiscriminatorColumn(name="DTYPE")
@DiscriminatorValue("PLANE")
public class EntPlane extends EntTransport    {
    public EntPlane() {
    }
}
