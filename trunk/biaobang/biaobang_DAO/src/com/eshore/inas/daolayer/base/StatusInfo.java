package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * StatusInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class StatusInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String statusName;
	private String statusTyep;
	private String statusRemark;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public StatusInfo() {
	}

	/** minimal constructor */
	public StatusInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public StatusInfo(String id, String statusName, String statusTyep,
			String statusRemark, String operatorId, Date modifyTime) {
		this.id = id;
		this.statusName = statusName;
		this.statusTyep = statusTyep;
		this.statusRemark = statusRemark;
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

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getStatusTyep() {
		return this.statusTyep;
	}

	public void setStatusTyep(String statusTyep) {
		this.statusTyep = statusTyep;
	}

	public String getStatusRemark() {
		return this.statusRemark;
	}

	public void setStatusRemark(String statusRemark) {
		this.statusRemark = statusRemark;
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