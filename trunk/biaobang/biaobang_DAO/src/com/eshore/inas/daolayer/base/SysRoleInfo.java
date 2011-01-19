package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * SysRoleInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SysRoleInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String roleName;
	private String roleCode;
	private String organizationScope;
	private String functionalScope;
	private String rmark;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public SysRoleInfo() {
	}

	/** minimal constructor */
	public SysRoleInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public SysRoleInfo(String id, String roleName, String roleCode,
			String organizationScope, String functionalScope, String rmark,
			String operatorId, Date modifyTime) {
		this.id = id;
		this.roleName = roleName;
		this.roleCode = roleCode;
		this.organizationScope = organizationScope;
		this.functionalScope = functionalScope;
		this.rmark = rmark;
		this.operatorId = operatorId;
		this.modifyTime = modifyTime;
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

	public String getOrganizationScope() {
		return this.organizationScope;
	}

	public void setOrganizationScope(String organizationScope) {
		this.organizationScope = organizationScope;
	}

	public String getFunctionalScope() {
		return this.functionalScope;
	}

	public void setFunctionalScope(String functionalScope) {
		this.functionalScope = functionalScope;
	}

	public String getRmark() {
		return this.rmark;
	}

	public void setRmark(String rmark) {
		this.rmark = rmark;
	}

	public String getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}