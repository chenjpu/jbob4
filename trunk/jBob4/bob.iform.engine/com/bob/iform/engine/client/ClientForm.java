package com.bob.iform.engine.client;

import com.bob.iform.engine.Form;
import com.bob.iform.engine.FormException;

public interface ClientForm extends Form {

	String FORM_BEAN = "FORM_BEAN";//表单bean对象

	//void start();
	String onRender() throws FormException;//解析
}
