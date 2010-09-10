package com.bob.iform.engine.impl.html.ui;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

import com.bob.iform.fvm.FvmContext;

import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.SimpleHash;
import freemarker.template.Template;

public abstract class UIBean extends Component {

	protected String template;


	protected String theme;

	public void setTemplate(String template) {
		this.template = template;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public UIBean(FvmContext context) {
		super(context);
	}

	public boolean end(Writer writer, String body) {
		try {
			super.end(writer, body, false);
			mergeTemplate(writer, getTemplate(template, getDefaultTemplate()));
		} catch (Exception e) {
			//LOG.error("error when rendering", e);
		} finally {
			// popComponentStack();
		}

		return false;
	}

	/**
	 * A contract that requires each concrete UI Tag to specify which template should be used as a default.  For
	 * example, the CheckboxTab might return "checkbox.vm" while the RadioTag might return "radio.vm".  This value
	 * <strong>not</strong> begin with a '/' unless you intend to make the path absolute rather than relative to the
	 * current theme.
	 *
	 * @return The name of the template to be used as the default.
	 */
	protected abstract String getDefaultTemplate();

	protected Template getTemplate(String myTemplate, String myDefaultTemplate) throws IOException {
		String template = myDefaultTemplate;
		
		if(null != myTemplate){
			template = myTemplate;
		}

		String theme = getTheme();

		return context.getFormEngine().get(Configuration.class).getTemplate(theme + File.pathSeparator + template);
	}
	
	protected ObjectWrapper getObjectWrapper() {
		ObjectWrapper ow = context.getFormEngine().get(Configuration.class).getObjectWrapper();
		return (ow != null ? ow : ObjectWrapper.DEFAULT_WRAPPER);
	}
	
	protected SimpleHash buildTemplateModel() {
		SimpleHash fmModel = new SimpleHash(getObjectWrapper());
		fmModel.putAll(getParameters());
		return fmModel;
	}
	
	protected void mergeTemplate(Writer writer, Template template) throws Exception {
		template.process(buildTemplateModel(), writer);
	}

	public String getTheme() {
		return null;
	}

	protected String escape(String name) {
		// escape any possible values that can make the ID painful to work with in JavaScript
		if (name != null) {
			return name.replaceAll("[\\.\\[\\]]", "_");
		} else {
			return "";
		}
	}

	/**
	 * Ensures an unescaped attribute value cannot be vulnerable to XSS attacks
	 *
	 * @param val The value to check
	 * @return The escaped value
	 */
	protected String ensureAttributeSafelyNotEscaped(String val) {
		if (val != null) {
			return val.replaceAll("\"", "&#34;");
		} else {
			return "";
		}
	}

}