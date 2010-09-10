package com.bob.iform.engine;

import java.io.Serializable;
import java.util.List;

import com.bob.iform.engine.model.Field;

/**
 * @author chenbing
 * 表单定义
 */
public interface FormDefinition extends Serializable {
	String getName();

	String getKey();

	String getId();

	int getVersion();

	String getDeploymentId();

	int getCols();

	String getDescription();

	//~~ 表单项包含的子表单项
	boolean hasFields();

	List<? extends Field> getFields();
}
