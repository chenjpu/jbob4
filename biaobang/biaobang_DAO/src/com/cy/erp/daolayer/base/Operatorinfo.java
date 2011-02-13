package com.cy.erp.daolayer.base;

import java.util.Date;

/**
 * Operatorinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Operatorinfo implements java.io.Serializable {

	// Fields

	private String id;
	private String user;
	private String password;
	private String name;
	private String phone;
	private String cuser;
	private Date ctime;
	private String remark;
	private String roleId;

	// Constructors

	/** default constructor */
	public Operatorinfo() {
	}

	/** minimal constructor */
	public Operatorinfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public Operatorinfo(String id, String user, String password, String name,
			String phone, String cuser, Date ctime, String remark, String roleId) {
		this.id = id;
		this.user = user;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.cuser = cuser;
		this.ctime = ctime;
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

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
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