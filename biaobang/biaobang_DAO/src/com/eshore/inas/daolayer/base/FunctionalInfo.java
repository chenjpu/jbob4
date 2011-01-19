package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * FunctionalInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class FunctionalInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String menuId;
	private String actionType;
	private String remark;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public FunctionalInfo() {
	}

	/** minimal constructor */
	public FunctionalInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public FunctionalInfo(String id, String menuId, String actionType,
			String remark, String operatorId, Date modifyTime) {
		this.id = id;
		this.menuId = menuId;
		this.actionType = actionType;
		this.remark = remark;
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

	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getActionType() {
		return this.actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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