package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * OperatorInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class OperatorInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String crId;
	private String password;
	private String name;
	private String phone;
	private String creatorId;
	private Date modifyTime;
	private String remark;
	private String roleId;

	// Constructors

	/** default constructor */
	public OperatorInfo() {
	}

	/** minimal constructor */
	public OperatorInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public OperatorInfo(String id, String crId, String password, String name,
			String phone, String creatorId, Date modifyTime, String remark,
			String roleId) {
		this.id = id;
		this.crId = crId;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.creatorId = creatorId;
		this.modifyTime = modifyTime;
		this.remark = remark;
		this.roleId = roleId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCrId() {
		return this.crId;
	}

	public void setCrId(String crId) {
		this.crId = crId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}