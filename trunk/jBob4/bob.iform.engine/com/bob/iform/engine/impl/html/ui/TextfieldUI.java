package com.bob.iform.engine.impl.html.ui;

import com.bob.iform.fvm.FvmContext;

public class TextfieldUI extends UIBean {

	public TextfieldUI(FvmContext context) {
		super(context);
	}

	protected String getDefaultTemplate() {
		return "hidden";
	}
}
