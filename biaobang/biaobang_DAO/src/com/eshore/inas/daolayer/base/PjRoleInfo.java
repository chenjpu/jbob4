package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * PjRoleInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PjRoleInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String pjRoleName;
	private String pjRoleRemark;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public PjRoleInfo() {
	}

	/** minimal constructor */
	public PjRoleInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public PjRoleInfo(String id, String pjRoleName, String pjRoleRemark,
			String operatorId, Date modifyTime) {
		this.id = id;
		this.pjRoleName = pjRoleName;
		this.pjRoleRemark = pjRoleRemark;
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

	public String getPjRoleName() {
		return this.pjRoleName;
	}

	public void setPjRoleName(String pjRoleName) {
		this.pjRoleName = pjRoleName;
	}

	public String getPjRoleRemark() {
		return this.pjRoleRemark;
	}

	public void setPjRoleRemark(String pjRoleRemark) {
		this.pjRoleRemark = pjRoleRemark;
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