/*
 * 
 * 创建日期：2010-4-16 下午12:54:50
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.core.web;

public abstract class BaseJson implements BaseController {
	protected String json;
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
}
