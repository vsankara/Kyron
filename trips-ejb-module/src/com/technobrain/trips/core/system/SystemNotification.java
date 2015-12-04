package com.technobrain.trips.core.system;

import java.io.Serializable;
import java.sql.Timestamp;

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

@Entity

@NamedQueries({
    @NamedQuery(name = "SystemNotification.findAll", 
    query = "select o from SystemNotification o order by o.createdDate desc"),
    @NamedQuery(
    name="SystemNotification.findAllNotDismissed",
    query="select o from SystemNotification o where o.notificationState = 0 order by o.notificationState, o.createdDate desc"
    ),
    @NamedQuery(
    name="SystemNotification.findAllNotDismissedByNotificationName",
    query="select o from SystemNotification o where o.notificationState = 0 and o.name=?1 order by o.notificationState, o.createdDate desc"
    )
}) 
@Table(name = "SYS_NOTIFICATIONS")
public class SystemNotification extends BaseNormalModelObject implements Serializable {
	public static final String NOTIFICATION_TYPE_INFO = "INFO";
	public static final String NOTIFICATION_TYPE_WARN = "WARN";
	public static final String NOTIFICATION_TYPE_ERROR = "ERROR";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SYS_NOTIFICATIONS_SEQ")
	@SequenceGenerator(name = "SYS_NOTIFICATIONS_SEQ", sequenceName = "SYS_NOTIFICATIONS_SEQ", allocationSize = 1)
    @Column(name="ID", nullable = false)
	private Long id;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	/**
	 * 0: new 
	 * <p>1: dismissed
	 */
	@Column(name="NOTIFICATION_STATE")
	private Integer notificationState;
	
	@Column(name="NOTIFICATION_SOURCE")
	private String source;
	
	@Column(name="NOTIFICATION_NAME")
	private String name;
	
	@Column(name="VALID_FROM")
	private Timestamp validFrom;
	
	@Column(name="VALID_TO")
	private Timestamp validTo;
	
	
	
	

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	
	public boolean isDismissed(){
		return getNotificationState() == 1 ? true : false;
	}
	public void setDismissed(boolean dismiss){
		if(dismiss){
			setNotificationState(1);
		} else {
			setNotificationState(0);
		}
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Integer getNotificationState() {
		return notificationState;
	}

	public void setNotificationState(Integer notificationState) {
		this.notificationState = notificationState;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getName() {
		if(name == null || name.length() == 0){
			return getDescription().substring(0, getDescription().length() > 27 ? 27 : getDescription().length()) 
			+ (getDescription().length() > 27 ? "..." : "");
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Timestamp validFrom) {
		this.validFrom = validFrom;
	}

	public Timestamp getValidTo() {
		return validTo;
	}

	public void setValidTo(Timestamp validTo) {
		this.validTo = validTo;
	}
	
	
	

}
