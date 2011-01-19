package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * OrganizationInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class OrganizationInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String orCategory;
	private String orName;
	private String orStatus;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public OrganizationInfo() {
	}

	/** minimal constructor */
	public OrganizationInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public OrganizationInfo(String id, String orCategory, String orName,
			String orStatus, String operatorId, Date modifyTime) {
		this.id = id;
		this.orCategory = orCategory;
		this.orName = orName;
		this.orStatus = orStatus;
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

	public String getOrCategory() {
		return this.orCategory;
	}

	public void setOrCategory(String orCategory) {
		this.orCategory = orCategory;
	}

	public String getOrName() {
		return this.orName;
	}

	public void setOrName(String orName) {
		this.orName = orName;
	}

	public String getOrStatus() {
		return this.orStatus;
	}

	public void setOrStatus(String orStatus) {
		this.orStatus = orStatus;
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