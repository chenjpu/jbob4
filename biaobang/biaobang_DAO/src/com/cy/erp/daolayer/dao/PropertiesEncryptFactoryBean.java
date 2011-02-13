package com.cy.erp.daolayer.dao;
import java.util.Properties;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.FactoryBean;

public class PropertiesEncryptFactoryBean implements FactoryBean {

	private Properties properties;
	
	public Object getObject() throws Exception {
		return getProperties();
	}

	public Class getObjectType() {
		return java.util.Properties.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties inProperties) {
		this.properties = inProperties;
		String originalUsername = properties.getProperty("user");
		String originalPassword = properties.getProperty("password");
		if (originalUsername != null){
//			String newUsername = deEncryptUsername(originalUsername);
			properties.put("user", originalUsername);
		}
		if (originalPassword != null){
			String newPassword = deEncryptPassword(originalPassword);
			properties.put("password", newPassword);
		}
	}
	
	private String deEncryptUsername(String originalUsername){
		return deEncryptString(originalUsername);
	}
	
	private String deEncryptPassword(String originalPassword){
		return deEncryptString(originalPassword);
	}
	//Ω‚√‹
	private String deEncryptString(String originalString){		 
        BasicTextEncryptor textEncryptor2 = new BasicTextEncryptor(); 
        textEncryptor2.setPassword("root"); 
        String oldPassword = textEncryptor2.decrypt(originalString);   
        return oldPassword;
	}

}