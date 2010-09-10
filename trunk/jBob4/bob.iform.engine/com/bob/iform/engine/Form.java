package com.bob.iform.engine;

import com.bob.iform.engine.model.Field;

public interface Form {
	FormDefinition getFormDefinition();//表单定义对象
	Field getField();//返回当前正在处理的
}
