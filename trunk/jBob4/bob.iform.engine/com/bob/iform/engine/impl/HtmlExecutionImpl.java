package com.bob.iform.engine.impl;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.io.Writer;

import com.bob.iform.fvm.impl.runtime.ExecutionImpl;

public class HtmlExecutionImpl extends ExecutionImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4226051878049427672L;
	
	private BufferedWriter writer = new BufferedWriter(new StringWriter(2054));

	@Override
	protected void formStart() {
		//FIXME:资源文件
	}

	@Override
	protected Object formEnd() {
		return writer;
	}
	
	public Writer getWriter(){
		return writer;
	}
}
