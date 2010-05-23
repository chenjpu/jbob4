package com.jbob.system.model;

import java.util.Set;

import com.jbob.core.Entity;
import com.jbob.core.model.BaseModel;

/**
 * @author chenbing
 * 级别 抽象的岗位职务级别
 */
public class AppLevel extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -351163281461135554L;

	private AppLevel parent;

	private Set<AppLevel> childs;

	public AppLevel getParent() {
		return parent;
	}

	public void setParent(AppLevel parent) {
		this.parent = parent;
	}

	public Set<AppLevel> getChilds() {
		return childs;
	}

	public void setChilds(Set<AppLevel> childs) {
		this.childs = childs;
	}

}
