package com.bob.iform.engine.impl.html.ui;

import com.bob.iform.fvm.FvmContext;

public class DateUI extends UIBean {

	public DateUI(FvmContext context) {
		super(context);
	}

	protected String getDefaultTemplate() {
		return "date";
	}
}
