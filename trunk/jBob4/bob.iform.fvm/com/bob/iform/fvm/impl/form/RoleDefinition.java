package com.bob.iform.fvm.impl.form;

import java.io.Serializable;

import com.bob.iform.fvm.security.Permission;

public class RoleDefinition  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	
	private Permission permission;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}
}
