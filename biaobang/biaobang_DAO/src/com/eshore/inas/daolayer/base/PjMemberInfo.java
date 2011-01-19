package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * PjMemberInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PjMemberInfo implements java.io.Serializable {

	// Fields

	private String pjMemberId;
	private String pjNo;
	private String pjMember;
	private String pjRole;
	private Float pjJmpercent;
	private String pjBdepartment;
	private String pjAuditteam;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public PjMemberInfo() {
	}

	/** minimal constructor */
	public PjMemberInfo(String pjMemberId, String pjNo) {
		this.pjMemberId = pjMemberId;
		this.pjNo = pjNo;
	}

	/** full constructor */
	public PjMemberInfo(String pjMemberId, String pjNo, String pjMember,
			String pjRole, Float pjJmpercent, String pjBdepartment,
			String pjAuditteam, String operatorId, Date modifyTime) {
		this.pjMemberId = pjMemberId;
		this.pjNo = pjNo;
		this.pjMember = pjMember;
		this.pjRole = pjRole;
		this.pjJmpercent = pjJmpercent;
		this.pjBdepartment = pjBdepartment;
		this.pjAuditteam = pjAuditteam;
		this.operatorId = operatorId;
		this.modifyTime = modifyTime;
	}

	// Property accessors

	public String getPjMemberId() {
		return this.pjMemberId;
	}

	public void setPjMemberId(String pjMemberId) {
		this.pjMemberId = pjMemberId;
	}

	public String getPjNo() {
		return this.pjNo;
	}

	public void setPjNo(String pjNo) {
		this.pjNo = pjNo;
	}

	public String getPjMember() {
		return this.pjMember;
	}

	public void setPjMember(String pjMember) {
		this.pjMember = pjMember;
	}

	public String getPjRole() {
		return this.pjRole;
	}

	public void setPjRole(String pjRole) {
		this.pjRole = pjRole;
	}

	public Float getPjJmpercent() {
		return this.pjJmpercent;
	}

	public void setPjJmpercent(Float pjJmpercent) {
		this.pjJmpercent = pjJmpercent;
	}

	public String getPjBdepartment() {
		return this.pjBdepartment;
	}

	public void setPjBdepartment(String pjBdepartment) {
		this.pjBdepartment = pjBdepartment;
	}

	public String getPjAuditteam() {
		return this.pjAuditteam;
	}

	public void setPjAuditteam(String pjAuditteam) {
		this.pjAuditteam = pjAuditteam;
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