package com.bob.iform.engine.impl.html.ui;

import com.bob.iform.fvm.FvmContext;

public class SelectUI extends UIBean {

	public SelectUI(FvmContext context) {
		super(context);
	}

	protected String getDefaultTemplate() {
		return "select";
	}
}
