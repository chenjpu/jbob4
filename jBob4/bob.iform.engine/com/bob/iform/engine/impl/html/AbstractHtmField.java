package com.bob.iform.engine.impl.html;

import com.bob.iform.fvm.FvmException;
import com.bob.iform.fvm.field.FieldBehavior;
import com.bob.iform.fvm.field.FieldExecution;

public class AbstractHtmField implements FieldBehavior {

	protected HtmlFieldBehavior htmlFieldBehavior = new HtmlFieldBehavior();

	@Override
	public void execute(FieldExecution execution) throws FvmException {

	}

	/**
	 * Default way of leaving a BPMN 2.0 activity: evaluate the conditions on
	 * the outgoing sequence flow and take those that evaluate to true.
	 */
	protected void render(FieldExecution execution) {
		htmlFieldBehavior.performDefaultBehavior(execution);
	}

	protected void renderIgnoreSecruitys(FieldExecution execution) {
		htmlFieldBehavior.performIgnoreSecurityBehavior(execution);
	}

}
