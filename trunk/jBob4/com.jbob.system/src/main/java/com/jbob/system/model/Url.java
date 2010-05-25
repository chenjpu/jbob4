/*
 * 
 * 创建日期：2010-4-21 下午03:09:51
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.system.model;

import java.io.Serializable;

public class Url implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4286510723192107932L;
	private String url;
	private Function function;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

}
