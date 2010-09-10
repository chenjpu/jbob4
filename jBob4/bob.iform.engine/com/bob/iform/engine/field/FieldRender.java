package com.bob.iform.engine.field;

import java.io.Serializable;

import com.bob.iform.engine.Form;

public interface FieldRender extends Serializable {

	//void setBehaviour(InitialValueBehaviour behaviour);

	//void setBehaviour(PermissionBehaviour behaviour);

	void execute(Form form) throws Exception;
}