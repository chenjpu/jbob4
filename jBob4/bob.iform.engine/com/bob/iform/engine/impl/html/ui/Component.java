package com.bob.iform.engine.impl.html.ui;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

import com.bob.iform.fvm.FvmContext;
import com.bob.iform.fvm.FvmException;

public class Component {


	protected Map<String, Object> parameters;
	protected String id;

	protected FvmContext context;

	public Component(FvmContext context) {
		this.context = context;
		this.parameters = new LinkedHashMap<String, Object>();
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void addAllParameters(Map<String, Object> params) {
		parameters.putAll(params);
	}

	public void addParameter(String key, Object value) {
		if (key != null) {
			Map<String, Object> params = getParameters();
			if (value == null) {
				params.remove(key);
			} else {
				params.put(key, value);
			}
		}
	}

	public boolean start(Writer writer) {
		return true;
	}

	public boolean end(Writer writer, String body) {
		return end(writer, body, true);
	}

	protected boolean end(Writer writer, String body, boolean popComponentStack) {
		assert (body != null);

		try {
			writer.write(body);
		} catch (IOException e) {
			throw new FvmException("IOError while writing the body: " + e.getMessage(), e);
		}
		if (popComponentStack) {
			//popComponentStack();
		}
		return false;
	}
}