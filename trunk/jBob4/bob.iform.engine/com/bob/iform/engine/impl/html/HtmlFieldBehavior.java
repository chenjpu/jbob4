package com.bob.iform.engine.impl.html;

import java.util.logging.Logger;

import com.bob.iform.fvm.field.FieldExecution;

public class HtmlFieldBehavior {

	static Logger log = Logger.getLogger(HtmlFieldBehavior.class
			.getName());

	public void performDefaultBehavior(FieldExecution execution) {
		performBehavior(execution, true);
	}

	public void performIgnoreSecurityBehavior(FieldExecution execution) {
		performBehavior(execution, false);
	}

	protected void performBehavior(FieldExecution execution,
			boolean checkSecuritys) {

	}

}
