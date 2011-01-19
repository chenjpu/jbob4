package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * PjSourceInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PjSourceInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String pjSource;
	private String pjStatus;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public PjSourceInfo() {
	}

	/** minimal constructor */
	public PjSourceInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public PjSourceInfo(String id, String pjSource, String pjStatus,
			String operatorId, Date modifyTime) {
		this.id = id;
		this.pjSource = pjSource;
		this.pjStatus = pjStatus;
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

	public String getPjSource() {
		return this.pjSource;
	}

	public void setPjSource(String pjSource) {
		this.pjSource = pjSource;
	}

	public String getPjStatus() {
		return this.pjStatus;
	}

	public void setPjStatus(String pjStatus) {
		this.pjStatus = pjStatus;
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