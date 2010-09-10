
package com.bob.iform.fvm.impl.form;

import com.bob.iform.fvm.field.FieldBehavior;
import com.bob.iform.fvm.form.FvmField;

/**
 * @author Chenb
 */
public class FieldImpl extends ScopeImpl implements FvmField {

	private static final long serialVersionUID = 1L;
	protected FieldBehavior fieldBehavior;
	protected ScopeImpl parent;

	protected String type;

	public FieldImpl(String id, FormDefinitionImpl formDefinition) {
		super(id, formDefinition);
	}

	public String toString() {
		return "Field(" + id + ")";
	}

	public FieldImpl getParentField() {
		if (parent instanceof FieldImpl) {
			return (FieldImpl) parent;
		}
		return null;
	}

	// restricted setters ///////////////////////////////////////////////////////

	protected void setParent(ScopeImpl parent) {
		this.parent = parent;
	}

	// getters and setters //////////////////////////////////////////////////////

	public FieldBehavior getFieldBehavior() {
		return fieldBehavior;
	}

	public void setFieldBehavior(FieldBehavior fieldBehavior) {
		this.fieldBehavior = fieldBehavior;
	}

	public ScopeImpl getParent() {
		return parent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
