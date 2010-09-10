package com.bob.iform.engine;

import com.bob.iform.fvm.widget.Widget;

/**
 * @author chenbing
 * 表单引擎
 */
public interface FormEngine {

	FormService getFormService();

	<T> T get(Class<T> type);

	Object get(String name);

	Widget getWidget(String type);

	/** sets the authenticated user's id for the next invocation of 
	 * a service method in the same thread. 
	 * This method returns the process engine for convenient method concatenations. */
	FormEngine setAuthenticatedUserId(String authenticatedUserId);

	void close();

}
