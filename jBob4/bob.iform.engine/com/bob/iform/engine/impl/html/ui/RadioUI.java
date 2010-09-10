package com.bob.iform.engine.impl.html.ui;

import com.bob.iform.fvm.FvmContext;

public class RadioUI extends UIBean {

	public RadioUI(FvmContext context) {
		super(context);
	}

	protected String getDefaultTemplate() {
		return "radio";
	}
}
