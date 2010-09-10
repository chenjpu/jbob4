package com.bob.iform.engine.impl.html.ui;

import com.bob.iform.fvm.FvmContext;

public class TextUI extends UIBean {

	public TextUI(FvmContext context) {
		super(context);
	}

	protected String getDefaultTemplate() {
		return "text";
	}
}
