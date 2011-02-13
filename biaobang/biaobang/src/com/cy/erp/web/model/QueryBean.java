package com.cy.erp.web.model;

import java.util.Date;

/**
 * PjInformation entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class QueryBean implements java.io.Serializable {

	// Fields

	private String pjNo;
	private String pjSources;
	private String pjCategory;
	private String pjName;
	private String pjItime1;
	private String pjItime2;
	private String pjDepartment;
	private String pjManager;
	private String pjFiles;
	private Date pjCtime;
	private String operatorId;
	private Date pjAtime;
	
	private String risksNo;
	private String risksCategory1;
	private String risksCategory2;
	private String risksCategory3;
	private String risksSketch;
	private String risksDetail;
	private String risksDepartment;
	private String proLevel;
	private Double risksMoney1;
	private Double risksMoney2;
	private String risksEffectDjsr;
	private String risksEffectSjsr;
	private String risksEffectDjcb;
	private String risksEffectSjcb;
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
	private String risksFiles;

	// Constructors

	/** default constructor */
	public QueryBean() {
	}

	/** minimal constructor */
	public QueryBean(String pjNo) {
		this.pjNo = pjNo;
	}

	/** full constructor */
	public QueryBean(String pjNo, String pjSources, String pjCategory,
			String pjName, String pjItime1, String pjItime2, String pjDepartment, String pjManager,
			String pjFiles, Date pjCtime, String operatorId, Date pjAtime,String risksNo, String risksCategory1,
			String risksCategory2, String risksCategory3, String risksSketch,
			String risksDetail, String risksDepartment, String proLevel,
			Double risksMoney1, Double risksMoney2, String risksEffectDjsr, String risksEffectSjsr,
			String risksEffectDjcb, String risksEffectSjcb,
			String risksAnalysis, String risksLevel, String risksSuggestion,
			String alterCase, String followCase, String auditor, String rmark,
			String risksManager, Date risksCtime, Date modifyTime) {
		this.pjNo = pjNo;
		this.pjSources = pjSources;
		this.pjCategory = pjCategory;
		this.pjName = pjName;
		this.pjItime1 = pjItime1;
		this.pjItime2 = pjItime2;
		this.pjDepartment = pjDepartment;
		this.pjManager = pjManager;
		this.pjFiles = pjFiles;
		this.pjCtime = pjCtime;
		this.operatorId = operatorId;
		this.pjAtime = pjAtime;
		
		this.pjNo = pjNo;
		this.risksCategory1 = risksCategory1;
		this.risksCategory2 = risksCategory2;
		this.risksCategory3 = risksCategory3;
		this.risksSketch = risksSketch;
		this.risksDetail = risksDetail;
		this.risksDepartment = risksDepartment;
		this.proLevel = proLevel;
		this.risksMoney1 = risksMoney1;
		this.risksMoney2 = risksMoney2;
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

	public String getPjFiles() {
		return this.pjFiles;
	}

	public void setPjFiles(String pjFiles) {
		this.pjFiles = pjFiles;
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

	public String getRisksNo() {
		return risksNo;
	}

	public void setRisksNo(String risksNo) {
		this.risksNo = risksNo;
	}

	public String getRisksCategory1() {
		return risksCategory1;
	}

	public void setRisksCategory1(String risksCategory1) {
		this.risksCategory1 = risksCategory1;
	}

	public String getRisksCategory2() {
		return risksCategory2;
	}

	public void setRisksCategory2(String risksCategory2) {
		this.risksCategory2 = risksCategory2;
	}

	public String getRisksCategory3() {
		return risksCategory3;
	}

	public void setRisksCategory3(String risksCategory3) {
		this.risksCategory3 = risksCategory3;
	}

	public String getRisksSketch() {
		return risksSketch;
	}

	public void setRisksSketch(String risksSketch) {
		this.risksSketch = risksSketch;
	}

	public String getRisksDetail() {
		return risksDetail;
	}

	public void setRisksDetail(String risksDetail) {
		this.risksDetail = risksDetail;
	}

	public String getRisksDepartment() {
		return risksDepartment;
	}

	public void setRisksDepartment(String risksDepartment) {
		this.risksDepartment = risksDepartment;
	}

	public String getProLevel() {
		return proLevel;
	}

	public void setProLevel(String proLevel) {
		this.proLevel = proLevel;
	}

	public Double getRisksMoney1() {
		return risksMoney1;
	}

	public void setRisksMoney1(Double risksMoney1) {
		this.risksMoney1 = risksMoney1;
	}

	public Double getRisksMoney2() {
		return risksMoney2;
	}

	public void setRisksMoney2(Double risksMoney2) {
		this.risksMoney2 = risksMoney2;
	}

	public String getRisksEffectDjsr() {
		return risksEffectDjsr;
	}

	public void setRisksEffectDjsr(String risksEffectDjsr) {
		this.risksEffectDjsr = risksEffectDjsr;
	}

	public String getRisksEffectSjsr() {
		return risksEffectSjsr;
	}

	public void setRisksEffectSjsr(String risksEffectSjsr) {
		this.risksEffectSjsr = risksEffectSjsr;
	}

	public String getRisksEffectDjcb() {
		return risksEffectDjcb;
	}

	public void setRisksEffectDjcb(String risksEffectDjcb) {
		this.risksEffectDjcb = risksEffectDjcb;
	}

	public String getRisksEffectSjcb() {
		return risksEffectSjcb;
	}

	public void setRisksEffectSjcb(String risksEffectSjcb) {
		this.risksEffectSjcb = risksEffectSjcb;
	}

	public String getRisksAnalysis() {
		return risksAnalysis;
	}

	public void setRisksAnalysis(String risksAnalysis) {
		this.risksAnalysis = risksAnalysis;
	}

	public String getRisksLevel() {
		return risksLevel;
	}

	public void setRisksLevel(String risksLevel) {
		this.risksLevel = risksLevel;
	}

	public String getRisksSuggestion() {
		return risksSuggestion;
	}

	public void setRisksSuggestion(String risksSuggestion) {
		this.risksSuggestion = risksSuggestion;
	}

	public String getAlterCase() {
		return alterCase;
	}

	public void setAlterCase(String alterCase) {
		this.alterCase = alterCase;
	}

	public String getFollowCase() {
		return followCase;
	}

	public void setFollowCase(String followCase) {
		this.followCase = followCase;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public String getRmark() {
		return rmark;
	}

	public void setRmark(String rmark) {
		this.rmark = rmark;
	}

	public String getRisksManager() {
		return risksManager;
	}

	public void setRisksManager(String risksManager) {
		this.risksManager = risksManager;
	}

	public Date getRisksCtime() {
		return risksCtime;
	}

	public void setRisksCtime(Date risksCtime) {
		this.risksCtime = risksCtime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getRisksFiles() {
		return risksFiles;
	}

	public void setRisksFiles(String risksFiles) {
		this.risksFiles = risksFiles;
	}

	public String getPjItime1() {
		return pjItime1;
	}

	public void setPjItime1(String pjItime1) {
		this.pjItime1 = pjItime1;
	}

	public String getPjItime2() {
		return pjItime2;
	}

	public void setPjItime2(String pjItime2) {
		this.pjItime2 = pjItime2;
	}

}