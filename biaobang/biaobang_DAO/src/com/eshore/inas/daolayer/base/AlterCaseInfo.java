package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * AlterCaseInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AlterCaseInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String caseName;
	private String caseRemark;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public AlterCaseInfo() {
	}

	/** minimal constructor */
	public AlterCaseInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public AlterCaseInfo(String id, String caseName, String caseRemark,
			String operatorId, Date modifyTime) {
		this.id = id;
		this.caseName = caseName;
		this.caseRemark = caseRemark;
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

	public String getCaseName() {
		return this.caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public String getCaseRemark() {
		return this.caseRemark;
	}

	public void setCaseRemark(String caseRemark) {
		this.caseRemark = caseRemark;
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