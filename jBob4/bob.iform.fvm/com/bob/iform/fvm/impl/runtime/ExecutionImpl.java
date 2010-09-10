/* Licensed under the Apache License, ersion 2.0 (the "License");
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

package com.bob.iform.fvm.impl.runtime;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.bob.iform.fvm.FvmException;
import com.bob.iform.fvm.FvmContext;
import com.bob.iform.fvm.field.FieldExecution;
import com.bob.iform.fvm.form.FvmField;
import com.bob.iform.fvm.impl.form.FieldImpl;
import com.bob.iform.fvm.impl.form.FormDefinitionImpl;
import com.bob.iform.fvm.runtime.FvmExecution;
import com.bob.iform.fvm.runtime.FvmFormInstance;

public abstract class ExecutionImpl implements FieldExecution, FvmFormInstance, FvmExecution, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected FormDefinitionImpl formDefinition;

	protected final Map<String, Set<Object>> resourceMap = new HashMap<String, Set<Object>>();

	/** current field */
	protected FieldImpl field;

	private FvmContext webUser;

	public FormDefinitionImpl getFormDefinition() {
		return formDefinition;
	}

	public void setFormDefinition(FormDefinitionImpl formDefinition) {
		this.formDefinition = formDefinition;
	}

	public void setField(FieldImpl field) {
		this.field = field;
	}

	@Override
	public FvmField getField() {
		return field;
	}

	@Override
	public FvmContext getWebUser() {
		return webUser;
	}

	public void setWebUser(FvmContext webUser) {
		this.webUser = webUser;
	}

	@Override
	public boolean hasProperty(String variableName) {
		return false;
	}

	@Override
	public void setProperty(String variableName, Object value) {

	}

	@Override
	public Object getProperty(String variableName) {
		return null;
	}

	@Override
	public Map<String, Object> getProperties() {
		return null;
	}

	public void registerResource(String resourceName, Object resource) {
		Set<Object> resourceSet = this.resourceMap.get(resourceName);
		if (null == resourceSet) {
			resourceSet = new TreeSet<Object>();
			this.resourceMap.put(resourceName, resourceSet);
		}
		resourceSet.add(resource);
	}

	@Override
	public Object form() throws FvmException {
		formStart();
		for (FieldImpl field : formDefinition.getFields()) {
			field.getFieldBehavior().execute(this);
		}
		return formEnd();
	}

	protected abstract void formStart();

	protected abstract Object formEnd();

	@Override
	public Object doForm(Map<String, Object> requestForm) {
		return null;
	}

	@Override
	public void executeFvmField(FvmField field) {

	}

}
