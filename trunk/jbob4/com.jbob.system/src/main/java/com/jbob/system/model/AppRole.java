package com.jbob.system.model;


import org.springframework.security.core.GrantedAuthority;

import com.jbob.core.model.BaseModel;


public class AppRole extends BaseModel implements GrantedAuthority{
	/**
	 * 
	 */
	private static final long serialVersionUID = -252647602150299801L;
	private Long roleId;
	private String roleName;
	private String roleDesc;
	private Short status;
	private String rights;
	
	public AppRole() {
		
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}

	public String getAuthority() {
		return roleName;
	}

	public int compareTo(Object o) {
		return 0;
	}


	public String getId() {
		return roleId.toString();
	}


	public String getName() {
		return roleName;
	}
}
