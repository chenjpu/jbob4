package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * PjAuditorsInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PjAuditorsInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String auName;
	private String auCompany;
	private String auDepartment;
	private String auPost;
	private String auOfficePhone;
	private String auPhone;
	private String auStatus;
	private String userId;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public PjAuditorsInfo() {
	}

	/** minimal constructor */
	public PjAuditorsInfo(String id, String userId) {
		this.id = id;
		this.userId = userId;
	}

	/** full constructor */
	public PjAuditorsInfo(String id, String auName, String auCompany,
			String auDepartment, String auPost, String auOfficePhone,
			String auPhone, String auStatus, String userId, String operatorId,
			Date modifyTime) {
		this.id = id;
		this.auName = auName;
		this.auCompany = auCompany;
		this.auDepartment = auDepartment;
		this.auPost = auPost;
		this.auOfficePhone = auOfficePhone;
		this.auPhone = auPhone;
		this.auStatus = auStatus;
		this.userId = userId;
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

	public String getAuName() {
		return this.auName;
	}

	public void setAuName(String auName) {
		this.auName = auName;
	}

	public String getAuCompany() {
		return this.auCompany;
	}

	public void setAuCompany(String auCompany) {
		this.auCompany = auCompany;
	}

	public String getAuDepartment() {
		return this.auDepartment;
	}

	public void setAuDepartment(String auDepartment) {
		this.auDepartment = auDepartment;
	}

	public String getAuPost() {
		return this.auPost;
	}

	public void setAuPost(String auPost) {
		this.auPost = auPost;
	}

	public String getAuOfficePhone() {
		return this.auOfficePhone;
	}

	public void setAuOfficePhone(String auOfficePhone) {
		this.auOfficePhone = auOfficePhone;
	}

	public String getAuPhone() {
		return this.auPhone;
	}

	public void setAuPhone(String auPhone) {
		this.auPhone = auPhone;
	}

	public String getAuStatus() {
		return this.auStatus;
	}

	public void setAuStatus(String auStatus) {
		this.auStatus = auStatus;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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