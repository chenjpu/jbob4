package com.bob.iform.engine.impl;

import com.bob.iform.engine.FormEngine;
import com.bob.iform.engine.FormService;
import com.bob.iform.fvm.widget.Widget;

public class FormEngineImpl implements FormEngine {

	@Override
	public FormService getFormService() {
		return null;
	}

	@Override
	public <T> T get(Class<T> type) {
		return null;
	}

	@Override
	public Object get(String name) {
		return null;
	}

	@Override
	public Widget getWidget(String type) {
		return null;
	}

	@Override
	public FormEngine setAuthenticatedUserId(String authenticatedUserId) {
		return null;
	}

	@Override
	public void close() {
		
	}

}
