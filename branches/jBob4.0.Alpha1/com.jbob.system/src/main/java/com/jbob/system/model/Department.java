package com.jbob.system.model;

import java.util.Set;

import com.jbob.core.TreeEntity;
import com.jbob.core.model.BaseModel;

/**
 * @author chenbing
 * 部门
 */
public class Department extends BaseModel implements TreeEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1262343889840086070L;
	private Department parent;
	private Set<Department> childs;

	public Department getParent() {
		return parent;
	}

	public Set<Department> getChilds() {
		return childs;
	}

	public void setChilds(Set<Department> childs) {
		this.childs = childs;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

}
