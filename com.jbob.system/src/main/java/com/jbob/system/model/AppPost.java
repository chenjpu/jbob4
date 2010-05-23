package com.jbob.system.model;

import java.util.Set;

import com.jbob.core.TreeEntity;
import com.jbob.core.model.BaseModel;

/**
 * @author chenbing
 * 岗位
 */
public class AppPost extends BaseModel implements TreeEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3351897538909183875L;

	private AppPost parent;

	private AppDuty duty;

	private Set<AppPost> childs;

	private Set<Emploree> users;

	public AppPost getParent() {
		return parent;
	}

	public void setParent(AppPost parent) {
		this.parent = parent;
	}

	public AppDuty getDuty() {
		return duty;
	}

	public void setDuty(AppDuty duty) {
		this.duty = duty;
	}

	public Set<AppPost> getChilds() {
		return childs;
	}

	public void setChilds(Set<AppPost> childs) {
		this.childs = childs;
	}

	public Set<Emploree> getUsers() {
		return users;
	}

	public void setUsers(Set<Emploree> users) {
		this.users = users;
	}

}
