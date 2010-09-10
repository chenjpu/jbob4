package com.bob.iform.engine.impl.html.widget;

import java.io.Writer;

import com.bob.iform.engine.impl.HtmlExecutionImpl;
import com.bob.iform.engine.impl.html.ui.Component;
import com.bob.iform.engine.impl.html.ui.UIBean;
import com.bob.iform.engine.util.FieldNameUtil;
import com.bob.iform.fvm.FvmContext;
import com.bob.iform.fvm.FvmException;
import com.bob.iform.fvm.impl.util.FormUtils;
import com.bob.iform.fvm.runtime.FvmFormInstance;
import com.bob.iform.fvm.widget.Widget;

public abstract class AbstractHtm implements Widget {
	
	public static final String DEFAULT_THEME = "easyui";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String LOCATION_DELIMITERS = ",; \t\n";
	public static final String RESOURCE_CSS = "css";
	public static final String RESOURCE_JS = "javascript";

	@Override
	public final void render(FvmFormInstance formInstance, FvmContext context) throws FvmException {
		
		registerResource(formInstance, context);
		UIBean component = getBean(formInstance, context);
		
		component.setTemplate((String) formInstance.getProperty("template"));
		
		String theme = (String) formInstance.getProperty("theme");
		if(FormUtils.isEmpty(theme)){
			theme = DEFAULT_THEME;
		}
		component.setTheme(theme);
		
		
		String defaultValue = context.format((String) formInstance.getProperty("defaultValue"), (String) formInstance.getProperty("formatter"));
		Boolean required = (Boolean)context.evaluate((String) formInstance.getProperty("required"),Boolean.class);
		String validType = (String)context.evaluate((String) formInstance.getProperty("validType"),String.class);
		String template = (String)context.evaluate((String) formInstance.getProperty("template"),String.class);
		
		component.addParameter("template", template);
		component.addParameter("defaultValue", defaultValue);
		component.addParameter("required", required);
		component.addParameter("validType", validType);
		
		
		evaluateParams(formInstance, context, component);
		
		Writer writer = ((HtmlExecutionImpl) formInstance).getWriter();
		
		//doRender(formInstance, context,component);
		
		component.start(writer);
		
		component.end(writer, "");
	}

	/**
	 * 注册组件需要的资源
	 * @param formInstance
	 */
	protected void registerResource(FvmFormInstance formInstance, FvmContext context) {
		String css = (String) formInstance.getProperty(RESOURCE_CSS);
		String js = (String) formInstance.getProperty(RESOURCE_JS);

		if (FormUtils.isNotEmpty(css)) {

			for (String st : FormUtils.tokenizeToStringArray(css, LOCATION_DELIMITERS)) {
				formInstance.registerResource(RESOURCE_CSS, st);
			}

		}
		if (FormUtils.isNotEmpty(js)) {
			for (String st : FormUtils.tokenizeToStringArray(js, LOCATION_DELIMITERS)) {
				formInstance.registerResource(RESOURCE_JS, st);
			}
		}
	}

	protected void evaluateParams(FvmFormInstance formInstance, FvmContext context,Component component) {
		
		String defaultValue = context.format((String) formInstance.getProperty("defaultValue"), (String) formInstance.getProperty("formatter"));
		Boolean required = (Boolean)context.evaluate((String) formInstance.getProperty("required"),Boolean.class);
		String validType = (String)context.evaluate((String) formInstance.getProperty("validType"),String.class);
		String template = (String)context.evaluate((String) formInstance.getProperty("template"),String.class);
		
		String displayName = (String)context.evaluate((String) formInstance.getProperty("displayName"),String.class);
		String name = (String)context.evaluate((String) formInstance.getProperty("name"),String.class);
		
		String type = (String)context.evaluate((String) formInstance.getProperty("type"),String.class);
		
		if (FormUtils.isEmpty(type)) {
			type = "string";
		}
		
		component.addParameter("template", template);
		component.addParameter("defaultValue", defaultValue);
		component.addParameter("required", required);
		component.addParameter("validType", validType);
		component.addParameter("displayName", displayName);
		component.addParameter("name", FieldNameUtil.getUIName(name, type));
	}
	
	protected abstract UIBean getBean(FvmFormInstance formInstance, FvmContext context);

	//protected abstract void doRender(FvmFormInstance formInstance, FvmContext context, Component component);

}
