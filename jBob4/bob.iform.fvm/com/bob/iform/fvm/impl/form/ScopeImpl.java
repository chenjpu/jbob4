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

package com.bob.iform.fvm.impl.form;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bob.iform.fvm.FvmException;
import com.bob.iform.fvm.form.FvmScope;

/**
 * @author Tom Baeyens
 */
public abstract class ScopeImpl extends FormElementImpl implements FvmScope {

	private static final long serialVersionUID = 1L;

	protected List<FieldImpl> fields = new ArrayList<FieldImpl>();
	protected Map<String, FieldImpl> namedFields = new HashMap<String, FieldImpl>();
	protected Map<String, List<EventListener>> eventListeners = new HashMap<String, List<EventListener>>();
	//protected List<VariableDeclaration> variableDeclarations = new ArrayList<VariableDeclaration>();

	transient protected Object elContext = null;

	public ScopeImpl(String id, FormDefinitionImpl formsDefinition) {
		super(id, formsDefinition);
	}

	public FieldImpl findField(String fieldId) {
		FieldImpl localField = namedFields.get(fieldId);
		if (localField != null) {
			return localField;
		}
		for (FieldImpl field : fields) {
			FieldImpl nestedField = field.findField(fieldId);
			if (nestedField != null) {
				return nestedField;
			}
		}
		return null;
	}

	public FieldImpl createField() {
		return createField(null);
	}

	public FieldImpl createField(String fieldId) {
		FieldImpl field = new FieldImpl(fieldId, formDefinition);
		if (fieldId != null) {
			if (formDefinition.findField(fieldId) != null) {
				throw new FvmException("duplicate field id '" + fieldId + "'");
			}
			namedFields.put(fieldId, field);
		}
		field.setParent(this);
		fields.add(field);
		return field;
	}

	public boolean contains(FieldImpl field) {
		if (namedFields.containsKey(field.getId())) {
			return true;
		}
		for (FieldImpl nestedField : fields) {
			if (nestedField.contains(field)) {
				return true;
			}
		}
		return false;
	}

	// event listeners //////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public List<EventListener> getEventListeners(String eventName) {
		List<EventListener> eventListenerList = getEventListeners().get(eventName);
		if (eventListenerList != null) {
			return eventListenerList;
		}
		return Collections.EMPTY_LIST;
	}

	public void addEventListener(String eventName, EventListener eventListener) {
		List<EventListener> listeners = eventListeners.get(eventName);
		if (listeners == null) {
			listeners = new ArrayList<EventListener>();
			eventListeners.put(eventName, listeners);
		}
		listeners.add(eventListener);
	}

	public Map<String, List<EventListener>> getEventListeners() {
		return eventListeners;
	}

	// getters and setters //////////////////////////////////////////////////////

	public List<FieldImpl> getFields() {
		return fields;
	}

	public Object getElContext() {
		return elContext;
	}

	public void setElContext(Object elContext) {
		this.elContext = elContext;
	}

	/* public List<VariableDeclaration> getVariableDeclarations() {
	   return variableDeclarations;
	 }*/
}
