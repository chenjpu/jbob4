/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bob.iform.fvm;

import java.util.EventListener;
import java.util.Stack;

import com.bob.iform.fvm.field.FieldBehavior;
import com.bob.iform.fvm.impl.form.FieldImpl;
import com.bob.iform.fvm.impl.form.FormDefinitionImpl;
import com.bob.iform.fvm.impl.form.FormElementImpl;
import com.bob.iform.fvm.impl.form.ScopeImpl;

/**
 * @author Tom Baeyens
 */
public class FormDefinitionBuilder {

	protected FormDefinitionImpl formDefinition;
	protected Stack<ScopeImpl> scopeStack = new Stack<ScopeImpl>();
	protected FormElementImpl formElement = formDefinition;

	public FormDefinitionBuilder() {
		this(null);
	}

	public FormDefinitionBuilder(String formDefinitionId) {
		//formDefinition = new FormDefinitionImpl(formDefinitionId);
		scopeStack.push(formDefinition);
	}

	public FormDefinitionBuilder createField(String id) {
		FieldImpl field = scopeStack.peek().createField(id);
		scopeStack.push(field);
		formElement = field;
		return this;
	}

	public FormDefinitionBuilder endField() {
		scopeStack.pop();
		formElement = scopeStack.peek();
		return this;
	}

	/*public FormDefinitionBuilder initial() {
		formDefinition.setInitial(getField());
		return this;
	}*/

	public FormDefinitionBuilder behavior(FieldBehavior fieldBehavior) {
		getField().setFieldBehavior(fieldBehavior);
		return this;
	}

	public FormDefinitionBuilder property(String name, Object value) {
		formElement.setProperty(name, value);
		return this;
	}

	public FormDefinitionImpl buildProcessDefinition() {
		return formDefinition;
	}

	protected FieldImpl getField() {
		return (FieldImpl) scopeStack.peek();
	}


	public FormDefinitionBuilder eventListener(String eventName,
			EventListener eventListener) {
		scopeStack.peek().addEventListener(eventName, eventListener);
		return this;
	}

	/*
	 * public FormDefinitionBuilder variable(String variableName, Object value)
	 * { if (scopeStack.size() > 1) { getActivity().setScope(true); }
	 * VariableDeclarationImpl variableDeclaration = new
	 * VariableDeclarationImpl( variableName, value);
	 * scopeStack.peek().getVariableDeclarations().add(variableDeclaration);
	 * return this; }
	 */
}
