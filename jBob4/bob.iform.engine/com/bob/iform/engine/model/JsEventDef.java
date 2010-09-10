package com.bob.iform.engine.model;

import java.io.Serializable;

public class JsEventDef implements Serializable {

	private static final long serialVersionUID = -7315682701219244694L;
	
	
	private String name;//事件名称
	
	private String js;//事件函数

	//~~~
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getJs() {
		return js;
	}


	public void setJs(String js) {
		this.js = js;
	}
}
