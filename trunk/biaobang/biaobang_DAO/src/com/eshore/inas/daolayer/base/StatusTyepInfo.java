package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * StatusTyepInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class StatusTyepInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String typeName;
	private String typeRemark;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public StatusTyepInfo() {
	}

	/** minimal constructor */
	public StatusTyepInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public StatusTyepInfo(String id, String typeName, String typeRemark,
			String operatorId, Date modifyTime) {
		this.id = id;
		this.typeName = typeName;
		this.typeRemark = typeRemark;
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

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeRemark() {
		return this.typeRemark;
	}

	public void setTypeRemark(String typeRemark) {
		this.typeRemark = typeRemark;
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