package com.eshore.inas.daolayer.base;

import java.util.Date;

/**
 * PjRisksInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PjRisksInfo implements java.io.Serializable {

	// Fields

	private String risksNo;
	private String pjNo;
	private String risksCategory1;
	private String risksCategory2;
	private String risksCategory3;
	private String risksSketch;
	private String risksDetail;
	private String risksDepartment;
	private String proLevel;
	private Double risksMoney;
	private Double risksEffectDjsr;
	private Double risksEffectSjsr;
	private Double risksEffectDjcb;
	private Double risksEffectSjcb;
	private String risksAnalysis;
	private String risksLevel;
	private String risksSuggestion;
	private String alterCase;
	private String followCase;
	private String auditor;
	private String rmark;
	private String risksManager;
	private Date risksCtime;
	private Date modifyTime;
	private String operatorId;

	// Constructors

	/** default constructor */
	public PjRisksInfo() {
	}

	/** minimal constructor */
	public PjRisksInfo(String risksNo, String pjNo) {
		this.risksNo = risksNo;
		this.pjNo = pjNo;
	}

	/** full constructor */
	public PjRisksInfo(String risksNo, String pjNo, String risksCategory1,
			String risksCategory2, String risksCategory3, String risksSketch,
			String risksDetail, String risksDepartment, String proLevel,
			Double risksMoney, Double risksEffectDjsr, Double risksEffectSjsr,
			Double risksEffectDjcb, Double risksEffectSjcb,
			String risksAnalysis, String risksLevel, String risksSuggestion,
			String alterCase, String followCase, String auditor, String rmark,
			String risksManager, Date risksCtime, Date modifyTime,
			String operatorId) {
		this.risksNo = risksNo;
		this.pjNo = pjNo;
		this.risksCategory1 = risksCategory1;
		this.risksCategory2 = risksCategory2;
		this.risksCategory3 = risksCategory3;
		this.risksSketch = risksSketch;
		this.risksDetail = risksDetail;
		this.risksDepartment = risksDepartment;
		this.proLevel = proLevel;
		this.risksMoney = risksMoney;
		this.risksEffectDjsr = risksEffectDjsr;
		this.risksEffectSjsr = risksEffectSjsr;
		this.risksEffectDjcb = risksEffectDjcb;
		this.risksEffectSjcb = risksEffectSjcb;
		this.risksAnalysis = risksAnalysis;
		this.risksLevel = risksLevel;
		this.risksSuggestion = risksSuggestion;
		this.alterCase = alterCase;
		this.followCase = followCase;
		this.auditor = auditor;
		this.rmark = rmark;
		this.risksManager = risksManager;
		this.risksCtime = risksCtime;
		this.modifyTime = modifyTime;
		this.operatorId = operatorId;
	}

	// Property accessors

	public String getRisksNo() {
		return this.risksNo;
	}

	public void setRisksNo(String risksNo) {
		this.risksNo = risksNo;
	}

	public String getPjNo() {
		return this.pjNo;
	}

	public void setPjNo(String pjNo) {
		this.pjNo = pjNo;
	}

	public String getRisksCategory1() {
		return this.risksCategory1;
	}

	public void setRisksCategory1(String risksCategory1) {
		this.risksCategory1 = risksCategory1;
	}

	public String getRisksCategory2() {
		return this.risksCategory2;
	}

	public void setRisksCategory2(String risksCategory2) {
		this.risksCategory2 = risksCategory2;
	}

	public String getRisksCategory3() {
		return this.risksCategory3;
	}

	public void setRisksCategory3(String risksCategory3) {
		this.risksCategory3 = risksCategory3;
	}

	public String getRisksSketch() {
		return this.risksSketch;
	}

	public void setRisksSketch(String risksSketch) {
		this.risksSketch = risksSketch;
	}

	public String getRisksDetail() {
		return this.risksDetail;
	}

	public void setRisksDetail(String risksDetail) {
		this.risksDetail = risksDetail;
	}

	public String getRisksDepartment() {
		return this.risksDepartment;
	}

	public void setRisksDepartment(String risksDepartment) {
		this.risksDepartment = risksDepartment;
	}

	public String getProLevel() {
		return this.proLevel;
	}

	public void setProLevel(String proLevel) {
		this.proLevel = proLevel;
	}

	public Double getRisksMoney() {
		return this.risksMoney;
	}

	public void setRisksMoney(Double risksMoney) {
		this.risksMoney = risksMoney;
	}

	public Double getRisksEffectDjsr() {
		return this.risksEffectDjsr;
	}

	public void setRisksEffectDjsr(Double risksEffectDjsr) {
		this.risksEffectDjsr = risksEffectDjsr;
	}

	public Double getRisksEffectSjsr() {
		return this.risksEffectSjsr;
	}

	public void setRisksEffectSjsr(Double risksEffectSjsr) {
		this.risksEffectSjsr = risksEffectSjsr;
	}

	public Double getRisksEffectDjcb() {
		return this.risksEffectDjcb;
	}

	public void setRisksEffectDjcb(Double risksEffectDjcb) {
		this.risksEffectDjcb = risksEffectDjcb;
	}

	public Double getRisksEffectSjcb() {
		return this.risksEffectSjcb;
	}

	public void setRisksEffectSjcb(Double risksEffectSjcb) {
		this.risksEffectSjcb = risksEffectSjcb;
	}

	public String getRisksAnalysis() {
		return this.risksAnalysis;
	}

	public void setRisksAnalysis(String risksAnalysis) {
		this.risksAnalysis = risksAnalysis;
	}

	public String getRisksLevel() {
		return this.risksLevel;
	}

	public void setRisksLevel(String risksLevel) {
		this.risksLevel = risksLevel;
	}

	public String getRisksSuggestion() {
		return this.risksSuggestion;
	}

	public void setRisksSuggestion(String risksSuggestion) {
		this.risksSuggestion = risksSuggestion;
	}

	public String getAlterCase() {
		return this.alterCase;
	}

	public void setAlterCase(String alterCase) {
		this.alterCase = alterCase;
	}

	public String getFollowCase() {
		return this.followCase;
	}

	public void setFollowCase(String followCase) {
		this.followCase = followCase;
	}

	public String getAuditor() {
		return this.auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public String getRmark() {
		return this.rmark;
	}

	public void setRmark(String rmark) {
		this.rmark = rmark;
	}

	public String getRisksManager() {
		return this.risksManager;
	}

	public void setRisksManager(String risksManager) {
		this.risksManager = risksManager;
	}

	public Date getRisksCtime() {
		return this.risksCtime;
	}

	public void setRisksCtime(Date risksCtime) {
		this.risksCtime = risksCtime;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

}