package com.bob.iform.engine.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author chenbing
 * Base class to extend for UI form item.
 */
public interface Field extends Serializable {

	//表单项ID
	String getId();

	//表单项名称
	String getName();
	
	//表单label
	String getLabel();

	//初始值
	String getInitialValue();

	//表单项目描述
	String getDescription();

	//~~表单项 相关的js事件
	boolean hasJsEvents();

	List<? extends JsEventDef> getJsEvents();

	int getColSpan();

	int getRowSpan();

	String getHeight();

	String getWeight();

	String getCssClass();

	String getCssStyle();

	//~~ 表单项包含的子表单项
	boolean hasFields();

	List<? extends Field> getFields();

	//数据库类型
	String getSqlType();

	//Web类型
	String getWebType();

	//java类型
	String getJavaType();

	//String onRender(WebUser webUser) throws FormException;//解析

}
