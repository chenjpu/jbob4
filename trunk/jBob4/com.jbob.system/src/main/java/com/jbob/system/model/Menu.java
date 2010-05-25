/*
 * 
 * 创建日期：2010-4-21 下午03:08:47
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.system.model;

import java.util.Set;
import java.util.TreeSet;

public class Menu extends Item<Menu> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3101714171939371157L;

	private boolean isPublic;
	private Set<Menu> menus = new TreeSet<Menu>();
	private Set<Function> functions = new TreeSet<Function>();

	//~~

	public Menu findMenu(String code) {
		if (code.equals(getCode())) {
			return this;
		}
		for (Menu menu : menus) {
			Menu m = menu.findMenu(code);
			if (null != m) {
				return m;
			}
		}
		return null;
	}

	public boolean add(Menu e) {
		return menus.add(e);
	}

	public boolean add(Function e) {
		return functions.add(e);
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public Set<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}

	public String getModelXml() {
		StringBuilder builder = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r");
		builder.append("<Menus>\r");
		this.asLetfXml(builder);
		builder.append("\r</Menus>\r");
		return builder.toString();
	}

	public void asLetfXml(StringBuilder builder) {
		builder.append("<Menu");
		builder.append(" id = '").append(getCode()).append("'");
		builder.append(" text = '").append(getName()).append("'");
		builder.append(" iconCls = '").append(getIconCls()).append("'>\r");
		for (Menu menu : menus) {
			//menu.asLetfXml(builder);
		}
		builder.append("\r</Menu>\r");
	}

	public void asLetfXml(StringBuilder builder, Set<String> rights) {

	}

	public void asXml(StringBuilder builder) {

	}

	public void asXml(StringBuilder builder, Set<String> rights) {

	}
}
