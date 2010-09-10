package com.bob.iform.fvm;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.bob.iform.engine.FormEngine;

/**
 * @author chenbing
 * 表单执行上下文
 */
public interface FvmContext extends Serializable {
	//~

	Object getUser();

	Serializable getUserId();

	List<String> getUserRoles();

	FormEngine getFormEngine();

	Map<String, Object> getVariables();

	<T> T getVariable(String key);

	Object evaluate(String expression);

	Object evaluate(String expression, Class<?> expectedResultType);

	Object evaluate(String expression, Map<String, Object> context);

	Object evaluate(String expression, Map<String, Object> context, Class<?> expectedResultType);

	String format(Object object, String format);
}
