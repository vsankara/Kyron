package com.technobrain.trips.listener;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.PostLoad;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.sql.DataSource;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import com.technobrain.trips.common.constants.JndiConstants;
import com.technobrain.trips.document.model.DfinRevCollCard;
import com.technobrain.trips.entity.model.EntBankDetails;

public class EntityFieldEncriptionListener implements Serializable {
	public static final Logger log = Logger.getLogger(EntityFieldEncriptionListener.class);

	public static final String ENCRYPTION_MARK = "{ENC}";

	@PostLoad
	@PostUpdate
	public void decrypt(Object obj) {
		if (obj instanceof DfinRevCollCard) {
			DfinRevCollCard card = ((DfinRevCollCard) obj);
			card.setCardNumber(dc(card.getCardNumberEncrypted()));
			card.setSecurityCode(dc(card.getSecurityCodeEncrypted()));
			card.setPaymentAuthCode(dc(card.getPaymentAuthCodeEncrypted()));
			
		} else if (obj instanceof EntBankDetails) {
			EntBankDetails bank = ((EntBankDetails) obj);
			bank.setBankAccountNo(dc(bank.getBankAccountNoEncrypted()));
			bank.setSortcode(dc(bank.getSortcodeEncrypted()));
			bank.setIban(dc(bank.getIbanEncrypted()));
			bank.setSwiftCode(dc(bank.getSwiftCodeEncrypted()));
		}
	}

	@PrePersist
	@PreUpdate
	public void encrypt(Object obj) {
		if (obj instanceof DfinRevCollCard) {
			DfinRevCollCard card = ((DfinRevCollCard) obj);
			card.setCardNumberEncrypted(en(card.getCardNumber()));
			card.setSecurityCodeEncrypted(en(card.getSecurityCode()));
			card.setPaymentAuthCodeEncrypted(en(card.getPaymentAuthCode()));
		} else if (obj instanceof EntBankDetails) {
			EntBankDetails bank = ((EntBankDetails) obj);
			bank.setBankAccountNoEncrypted(en(bank.getBankAccountNo()));
			bank.setSortcodeEncrypted(en(bank.getSortcode()));
			bank.setIbanEncrypted(en(bank.getIban()));
			bank.setSwiftCodeEncrypted(en(bank.getSwiftCode()));
		}
	}
	

	private String dc(String input) {
		if(StringUtils.isBlank(input)){
			return null;
		} else if(!input.startsWith(ENCRYPTION_MARK)){
			return input;
		}
		String result = null;
		Connection connection = null;
		try {
			Context context = new InitialContext();
			DataSource datasource = null;
			datasource = (DataSource) context.lookup(JndiConstants.DATA_SOURCE_JNDI);
			connection = datasource.getConnection();
			CallableStatement statement = connection.prepareCall("{? = call toolkit.decrypt(?)}");
			statement.registerOutParameter(1, Types.VARCHAR);
			statement.setString(2, input.substring(ENCRYPTION_MARK.length()));
			statement.executeQuery();
			result = statement.getString(1);
		} catch (Exception e) {
			log.error("error for " + input, e);
		} finally {
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					log.error("error for " + input, e);
				}
			}
		}
		return result;
	}

	private String en(String input) {
		if(StringUtils.isBlank(input)){
			return null;
		} else if(input.startsWith(ENCRYPTION_MARK)){
			return input;
		}
		String result = null;
		Connection connection = null;
		try {
			Context context = new InitialContext();
			DataSource datasource = null;
			datasource = (DataSource) context.lookup(JndiConstants.DATA_SOURCE_JNDI);
			connection = datasource.getConnection();
			CallableStatement statement = connection.prepareCall("{? = call toolkit.encrypt(?)}");
			statement.registerOutParameter(1, Types.VARCHAR);
			statement.setString(2, input);
			statement.executeQuery();
			result = statement.getString(1);
		} catch (Exception e) {
			log.error("error for " + input, e);
		} finally {
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					log.error("error for " + input, e);
				}
			}
		}
		return ENCRYPTION_MARK + result;
	}

}
