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

import com.bob.iform.fvm.FvmContext;
import com.bob.iform.fvm.form.FvmFormDefinition;
import com.bob.iform.fvm.impl.runtime.ExecutionImpl;
import com.bob.iform.fvm.runtime.FvmFormInstance;

/**
 * @author Chenb
 */
public abstract class FormDefinitionImpl extends ScopeImpl implements FvmFormDefinition {

	private static final long serialVersionUID = 1L;

	//protected FieldImpl initial;
	//protected List<FieldImpl> initialActivityStack;

	protected int colspan = 4;

	public FormDefinitionImpl(String id) {
		super(id, null);
		formDefinition = this;
	}

	public FvmFormInstance createFormInstance(FvmContext webUser) {
		ExecutionImpl formInstance = newFormInstance();
		formInstance.setFormDefinition(this);
		formInstance.setWebUser(webUser);
		//formInstance.setField(initial);

		return formInstance;
	}

	public int getColspan() {
		return colspan;
	}

	public void setColspan(int colspan) {
		this.colspan = colspan;
	}

	protected abstract ExecutionImpl newFormInstance();

	// getters and setters //////////////////////////////////////////////////////

	/* public FieldImpl getInitial() {
	   return initial;
	 }

	 public void setInitial(FieldImpl initial) {
	   this.initial = initial;
	 }*/

	public String toString() {
		return "FormDefinition(" + id + ")";
	}
}
