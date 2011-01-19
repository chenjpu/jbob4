package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * PjInformation entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PjInformation implements java.io.Serializable {

	// Fields

	private String pjNo;
	private String pjSources;
	private String pjCategory;
	private String pjName;
	private Date pjItime;
	private String pjDepartment;
	private String pjManager;
	private Date pjCtime;
	private String operatorId;
	private Date pjAtime;

	// Constructors

	/** default constructor */
	public PjInformation() {
	}

	/** minimal constructor */
	public PjInformation(String pjNo) {
		this.pjNo = pjNo;
	}

	/** full constructor */
	public PjInformation(String pjNo, String pjSources, String pjCategory,
			String pjName, Date pjItime, String pjDepartment, String pjManager,
			Date pjCtime, String operatorId, Date pjAtime) {
		this.pjNo = pjNo;
		this.pjSources = pjSources;
		this.pjCategory = pjCategory;
		this.pjName = pjName;
		this.pjItime = pjItime;
		this.pjDepartment = pjDepartment;
		this.pjManager = pjManager;
		this.pjCtime = pjCtime;
		this.operatorId = operatorId;
		this.pjAtime = pjAtime;
	}

	// Property accessors

	public String getPjNo() {
		return this.pjNo;
	}

	public void setPjNo(String pjNo) {
		this.pjNo = pjNo;
	}

	public String getPjSources() {
		return this.pjSources;
	}

	public void setPjSources(String pjSources) {
		this.pjSources = pjSources;
	}

	public String getPjCategory() {
		return this.pjCategory;
	}

	public void setPjCategory(String pjCategory) {
		this.pjCategory = pjCategory;
	}

	public String getPjName() {
		return this.pjName;
	}

	public void setPjName(String pjName) {
		this.pjName = pjName;
	}

	public Date getPjItime() {
		return this.pjItime;
	}

	public void setPjItime(Date pjItime) {
		this.pjItime = pjItime;
	}

	public String getPjDepartment() {
		return this.pjDepartment;
	}

	public void setPjDepartment(String pjDepartment) {
		this.pjDepartment = pjDepartment;
	}

	public String getPjManager() {
		return this.pjManager;
	}

	public void setPjManager(String pjManager) {
		this.pjManager = pjManager;
	}

	public Date getPjCtime() {
		return this.pjCtime;
	}

	public void setPjCtime(Date pjCtime) {
		this.pjCtime = pjCtime;
	}

	public String getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public Date getPjAtime() {
		return this.pjAtime;
	}

	public void setPjAtime(Date pjAtime) {
		this.pjAtime = pjAtime;
	}

}