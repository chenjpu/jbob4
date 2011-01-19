package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * RisksRankInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class RisksRankInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String rankName;
	private String rankRemark;
	private String operatorId;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public RisksRankInfo() {
	}

	/** minimal constructor */
	public RisksRankInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public RisksRankInfo(String id, String rankName, String rankRemark,
			String operatorId, Date modifyTime) {
		this.id = id;
		this.rankName = rankName;
		this.rankRemark = rankRemark;
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

	public String getRankName() {
		return this.rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public String getRankRemark() {
		return this.rankRemark;
	}

	public void setRankRemark(String rankRemark) {
		this.rankRemark = rankRemark;
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