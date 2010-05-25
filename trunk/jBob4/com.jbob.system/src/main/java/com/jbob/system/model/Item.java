/*
 * 
 * 创建日期：2010-4-21 下午03:31:46
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.system.model;

import java.io.Serializable;

public abstract class Item<T extends Item<T>> implements Serializable, Comparable<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2293932187486418973L;

	private String code; //菜单编码
	private String name; //菜单名称
	private String iconCls; //显示样式
	private int order;//显示序号

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int hashCode() {
		return code.hashCode();
	}

	public boolean equals(Object m) {
		if (m == this) {
			return true;
		}
		return ((T) m).code.equals(code);
	}

	public int compareTo(T o) {
		return o.order - order;
	}
}
