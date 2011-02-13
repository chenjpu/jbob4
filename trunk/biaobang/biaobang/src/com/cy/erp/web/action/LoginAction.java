package com.cy.erp.web.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import com.cy.erp.daolayer.base.Operatorinfo;
import com.cy.erp.web.common.BaseAction;
import com.cy.erp.web.model.LoginData;

public class LoginAction extends BaseAction {
	private static final long serialVersionUID = -2407572876245484007L;

	private LoginService loginService;
	
	private Operatorinfo operatorinfo;
	
	private InputStream loginStream;
	
	public static Logger logger = Logger.getLogger(LoginAction.class);

	public String login() {	
		LoginData loginData = loginService.getLoginData(operatorinfo);
		request.getSession().setAttribute("loginData", loginData);
		try {
			String tf="true";
			if (loginData == null) {
				tf="false";
			}
			loginStream = new ByteArrayInputStream(tf.getBytes("GBK"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("µÇÂ¼Òì³£!", e);
		}
		return SUCCESS;
	}
	
	public String logout() {
		try {
			loginStream = new ByteArrayInputStream("true".getBytes("GBK"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().invalidate();
		return SUCCESS;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public Operatorinfo getOperatorinfo() {
		return operatorinfo;
	}

	public void setOperatorinfo(Operatorinfo operatorinfo) {
		this.operatorinfo = operatorinfo;
	}

	public InputStream getLoginStream() {
		return loginStream;
	}

	public void setLoginStream(InputStream loginStream) {
		this.loginStream = loginStream;
	}

}
