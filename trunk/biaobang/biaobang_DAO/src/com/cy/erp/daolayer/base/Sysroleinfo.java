package com.cy.erp.daolayer.base;

import java.util.Date;

/**
 * Sysroleinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Sysroleinfo implements java.io.Serializable {

	// Fields

	private String id;
	private String roleName;
	private String roleCode;
	private String functionScope;
	private String remark;
	private String cuser;
	private Date ctime;

	// Constructors

	/** default constructor */
	public Sysroleinfo() {
	}

	/** minimal constructor */
	public Sysroleinfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public Sysroleinfo(String id, String roleName, String roleCode,
			String functionScope, String remark, String cuser, Date ctime) {
		this.id = id;
		this.roleName = roleName;
		this.roleCode = roleCode;
		this.functionScope = functionScope;
		this.remark = remark;
		this.cuser = cuser;
		this.ctime = ctime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getFunctionScope() {
		return this.functionScope;
	}

	public void setFunctionScope(String functionScope) {
		this.functionScope = functionScope;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCuser() {
		return this.cuser;
	}

	public void setCuser(String cuser) {
		this.cuser = cuser;
	}

	public Date getCtime() {
		return this.ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

}