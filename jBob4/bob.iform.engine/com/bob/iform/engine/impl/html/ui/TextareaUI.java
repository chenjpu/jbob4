package com.bob.iform.engine.impl.html.ui;

import com.bob.iform.fvm.FvmContext;

public class TextareaUI extends UIBean {

	public TextareaUI(FvmContext context) {
		super(context);
	}

	protected String getDefaultTemplate() {
		return "textarea";
	}
}
