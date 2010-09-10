package com.bob.iform.engine.impl.html.ui;

import com.bob.iform.fvm.FvmContext;

public class HiddenUI extends UIBean {

	public HiddenUI(FvmContext context) {
		super(context);
	}

	protected String getDefaultTemplate() {
		return "hidden";
	}
}
