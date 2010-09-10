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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.bob.iform.fvm.form.FvmFormElement;

/**
 * 
 * @author Tom Baeyens
 */
public class FormElementImpl implements FvmFormElement {

	private static final long serialVersionUID = 1L;

	protected String id;
	protected String name;
	protected FormDefinitionImpl formDefinition;
	protected Map<String, Object> properties;

	public FormElementImpl(String id, FormDefinitionImpl formDefinition) {
		this.id = id;
		this.formDefinition = formDefinition;
	}

	public void setProperty(String name, Object value) {
		if (properties == null) {
			properties = new HashMap<String, Object>();
		}
		properties.put(name, value);
	}

	public FormElementImpl property(String name, Object value) {
		setProperty(name, value);
		return this;
	}

	public Object getProperty(String name) {
		if (properties == null) {
			return null;
		}
		return properties.get(name);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getProperties() {
		if (properties == null) {
			return Collections.EMPTY_MAP;
		}
		return properties;
	}

	// getters and setters
	// //////////////////////////////////////////////////////

	public String getId() {
		return id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public FormDefinitionImpl getFormDefinition() {
		return formDefinition;
	}
}
