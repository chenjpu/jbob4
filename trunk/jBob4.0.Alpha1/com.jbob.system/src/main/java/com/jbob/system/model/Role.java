package com.jbob.system.model;

import java.util.List;

import com.jbob.core.TreeEntity;
import com.jbob.core.model.BaseModel;

/**
 * @author chenbing
 * 角色
 */
public class Role extends BaseModel implements TreeEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2695779923788221302L;

	private Role parent;

	private List<Role> childs;

	public Role getParent() {
		return parent;
	}

	public void setParent(Role parent) {
		this.parent = parent;
	}

	public List<Role> getChilds() {
		return childs;
	}

	public void setChilds(List<Role> childs) {
		this.childs = childs;
	}

}
