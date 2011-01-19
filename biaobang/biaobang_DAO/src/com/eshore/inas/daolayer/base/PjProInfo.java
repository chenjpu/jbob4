package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * PjProInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PjProInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String pjProName;
	private String pjProRemark;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public PjProInfo() {
	}

	/** minimal constructor */
	public PjProInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public PjProInfo(String id, String pjProName, String pjProRemark,
			String operatorId, Date modifyTime) {
		this.id = id;
		this.pjProName = pjProName;
		this.pjProRemark = pjProRemark;
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

	public String getPjProName() {
		return this.pjProName;
	}

	public void setPjProName(String pjProName) {
		this.pjProName = pjProName;
	}

	public String getPjProRemark() {
		return this.pjProRemark;
	}

	public void setPjProRemark(String pjProRemark) {
		this.pjProRemark = pjProRemark;
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