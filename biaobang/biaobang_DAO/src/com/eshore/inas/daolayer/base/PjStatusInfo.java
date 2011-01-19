package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * PjStatusInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PjStatusInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String pjStatusName;
	private String pjStatusRemark;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public PjStatusInfo() {
	}

	/** minimal constructor */
	public PjStatusInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public PjStatusInfo(String id, String pjStatusName, String pjStatusRemark,
			String operatorId, Date modifyTime) {
		this.id = id;
		this.pjStatusName = pjStatusName;
		this.pjStatusRemark = pjStatusRemark;
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

	public String getPjStatusName() {
		return this.pjStatusName;
	}

	public void setPjStatusName(String pjStatusName) {
		this.pjStatusName = pjStatusName;
	}

	public String getPjStatusRemark() {
		return this.pjStatusRemark;
	}

	public void setPjStatusRemark(String pjStatusRemark) {
		this.pjStatusRemark = pjStatusRemark;
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