package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * RiskLevelInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class RiskLevelInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String riskLevel;
	private String riskLevelName;
	private String remark;
	private String relativeId;
	private String status;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public RiskLevelInfo() {
	}

	/** minimal constructor */
	public RiskLevelInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public RiskLevelInfo(String id, String riskLevel, String riskLevelName,
			String remark, String relativeId, String status, String operatorId,
			Date modifyTime) {
		this.id = id;
		this.riskLevel = riskLevel;
		this.riskLevelName = riskLevelName;
		this.remark = remark;
		this.relativeId = relativeId;
		this.status = status;
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

	public String getRiskLevel() {
		return this.riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getRiskLevelName() {
		return this.riskLevelName;
	}

	public void setRiskLevelName(String riskLevelName) {
		this.riskLevelName = riskLevelName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRelativeId() {
		return this.relativeId;
	}

	public void setRelativeId(String relativeId) {
		this.relativeId = relativeId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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