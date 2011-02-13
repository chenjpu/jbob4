package com.cy.erp.daolayer.base;

import java.util.Date;

/**
 * Sysmenuinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Sysmenuinfo implements java.io.Serializable {

	// Fields

	private String id;
	private String menuName;
	private String menuCode;
	private String remark;
	private String cuser;
	private Date ctime;

	// Constructors

	/** default constructor */
	public Sysmenuinfo() {
	}

	/** minimal constructor */
	public Sysmenuinfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public Sysmenuinfo(String id, String menuName, String menuCode,
			String remark, String cuser, Date ctime) {
		this.id = id;
		this.menuName = menuName;
		this.menuCode = menuCode;
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

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuCode() {
		return this.menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
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