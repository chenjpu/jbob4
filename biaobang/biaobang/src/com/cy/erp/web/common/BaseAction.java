package com.cy.erp.web.common;

import java.io.PrintStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.cy.erp.web.dataGate.Globe;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Title:BaseAction
 * @Description: 公共action基类
 * @Copyright: Copyright (C) 2002 - 2009 GuangDong Eshore Techonlogy Co. Ltd
 * @Company: Eshore
 * 
 * @author zhengyuanhong
 * @version 1.0
 * @date Jul 7, 2009 4:13:13 PM
 */
public class BaseAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = -2407572876245484007L;
	public ActionContext actionContext;
	public Map session;

	public HttpServletRequest request;


	public int currPageIndex = 0;

	public String msg = "";// 给页面反馈的信息

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCurrPageIndex() {
		return currPageIndex;
	}

	public void setCurrPageIndex(int currPageIndex) {
		this.currPageIndex = currPageIndex;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}

	public ActionContext getActionContext() {
		return actionContext;
	}

	public void setActionContext(ActionContext actionContext) {
		this.actionContext = actionContext;
		setSession(actionContext.getSession());
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public void createFile(String xmlData, String pathFile) {
		String path = (String) Globe.realContextPath.get("realPath");
		try {
			PrintStream ps = new PrintStream(path + pathFile);
			ps.println(xmlData);
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
