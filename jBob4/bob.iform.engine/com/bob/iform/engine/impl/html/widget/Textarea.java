package com.bob.iform.engine.impl.html.widget;

import com.bob.iform.engine.impl.html.ui.Component;
import com.bob.iform.engine.impl.html.ui.TextareaUI;
import com.bob.iform.engine.impl.html.ui.UIBean;
import com.bob.iform.fvm.FvmContext;
import com.bob.iform.fvm.runtime.FvmFormInstance;

public class Textarea extends AbstractHtm{
	private static final long serialVersionUID = 1L;
	protected UIBean getBean(FvmFormInstance formInstance, FvmContext context){
		return new TextareaUI(context);
	}

	protected void evaluateParams(FvmFormInstance formInstance, FvmContext context, Component component) {
		super.evaluateParams(formInstance, context, component);
	}
}