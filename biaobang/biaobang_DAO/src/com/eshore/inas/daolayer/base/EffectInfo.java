package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * EffectInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class EffectInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String effectName;
	private String effectRemark;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public EffectInfo() {
	}

	/** minimal constructor */
	public EffectInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public EffectInfo(String id, String effectName, String effectRemark,
			String operatorId, Date modifyTime) {
		this.id = id;
		this.effectName = effectName;
		this.effectRemark = effectRemark;
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

	public String getEffectName() {
		return this.effectName;
	}

	public void setEffectName(String effectName) {
		this.effectName = effectName;
	}

	public String getEffectRemark() {
		return this.effectRemark;
	}

	public void setEffectRemark(String effectRemark) {
		this.effectRemark = effectRemark;
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