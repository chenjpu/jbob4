package com.bob.iform.engine.impl;

import com.bob.iform.fvm.impl.form.FormDefinitionImpl;
import com.bob.iform.fvm.impl.runtime.ExecutionImpl;

public class HtmlFormDefinitionImpl extends FormDefinitionImpl {

	public HtmlFormDefinitionImpl(String id) {
		super(id);
	}

	@Override
	protected ExecutionImpl newFormInstance() {
		return new HtmlExecutionImpl();
	}
}
