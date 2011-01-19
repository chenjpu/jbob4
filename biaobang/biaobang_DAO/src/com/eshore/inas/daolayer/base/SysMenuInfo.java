package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * SysMenuInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SysMenuInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String menuName;
	private String menuCode;
	private String rmark;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public SysMenuInfo() {
	}

	/** minimal constructor */
	public SysMenuInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public SysMenuInfo(String id, String menuName, String menuCode,
			String rmark, String operatorId, Date modifyTime) {
		this.id = id;
		this.menuName = menuName;
		this.menuCode = menuCode;
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