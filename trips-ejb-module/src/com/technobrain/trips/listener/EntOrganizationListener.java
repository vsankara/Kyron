package com.technobrain.trips.listener;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.technobrain.trips.common.constants.JndiConstants;
import com.technobrain.trips.entity.model.EntOrganization;

public class EntOrganizationListener implements Serializable {
	public static final Logger log = Logger
			.getLogger(EntOrganizationListener.class);

	@PrePersist
	@PreUpdate
	public void updateLegalNamePhonetic(Object obj) {
		EntOrganization organizataion = ((EntOrganization) obj);
		organizataion.setLegalNamePhonetic(format(organizataion.getLegalName()));
	}

	private String format(String input) {
		if (StringUtils.isBlank(input)) {
			return null;
		} 
		String result = null;
		Connection connection = null;
		try {
			Context context = new InitialContext();
			DataSource datasource = null;
			datasource = (DataSource) context
					.lookup(JndiConstants.DATA_SOURCE_JNDI);
			connection = datasource.getConnection();
			CallableStatement statement = connection
					.prepareCall("{? = call duplicate_check.get_legal_name_phonetic(?)}");  // TODO change the fucntion name
			statement.registerOutParameter(1, Types.VARCHAR);
			statement.setString(2, input);
			statement.executeQuery();
			result = statement.getString(1);
		} catch (Exception e) {
			log.error("error for " + input, e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					log.error("error for " + input, e);
				}
			}
		}
		return result;
	}

}
