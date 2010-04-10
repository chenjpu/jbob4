package com.jbob.system.model;

import java.util.Set;

import com.jbob.core.Entity;
import com.jbob.core.model.BaseModel;

/**
 * @author chenbing
 * 工作组
 */
public class Workgroup extends BaseModel implements Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6617729590384149082L;

	public static final String TYPE_UNIT = "unit";

	private String type = TYPE_UNIT;

	private Department manageOrg;//管理部门()
	
	private Department dutyOrg;//责任部门

	private Set<Emploree> users;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Department getManageOrg() {
		return manageOrg;
	}

	public void setManageOrg(Department manageOrg) {
		this.manageOrg = manageOrg;
	}

	public Department getDutyOrg() {
		return dutyOrg;
	}

	public void setDutyOrg(Department dutyOrg) {
		this.dutyOrg = dutyOrg;
	}

	public Set<Emploree> getUsers() {
		return users;
	}

	public void setUsers(Set<Emploree> users) {
		this.users = users;
	}

}
