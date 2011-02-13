package com.cy.erp.web.action.json;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.cy.erp.web.common.BaseAction;

	
public class JsonAction extends BaseAction {
	private static final long serialVersionUID = -2407572876245484007L;

	private JsonService jsonService;
	
	private InputStream inputStream;
	
	private String rId;
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	public JsonService getJsonService() {
		return jsonService;
	}


	public void setJsonService(JsonService jsonService) {
		this.jsonService = jsonService;
	}

	public String getRId() {
		return rId;
	}

	public void setRId(String id) {
		rId = id;
	}
}
