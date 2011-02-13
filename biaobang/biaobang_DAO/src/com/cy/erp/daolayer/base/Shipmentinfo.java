package com.cy.erp.daolayer.base;

import java.util.Date;

/**
 * Shipmentinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Shipmentinfo implements java.io.Serializable {

	// Fields

	private String id;
	private String client;
	private Date chTime;
	private String xhNo;
	private String gsNo;
	private String pz;
	private Integer ms;
	private Double price;
	private String db;
	private String remark;
	private Date ctime;
	private String cuser;

	// Constructors

	/** default constructor */
	public Shipmentinfo() {
	}

	/** minimal constructor */
	public Shipmentinfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public Shipmentinfo(String id, String client, Date chTime, String xhNo,
			String gsNo, String pz, Integer ms, Double price, String db,
			String remark, Date ctime, String cuser) {
		this.id = id;
		this.client = client;
		this.chTime = chTime;
		this.xhNo = xhNo;
		this.gsNo = gsNo;
		this.pz = pz;
		this.ms = ms;
		this.price = price;
		this.db = db;
		this.remark = remark;
		this.ctime = ctime;
		this.cuser = cuser;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getChTime() {
		return this.chTime;
	}

	public void setChTime(Date chTime) {
		this.chTime = chTime;
	}

	public String getXhNo() {
		return this.xhNo;
	}

	public void setXhNo(String xhNo) {
		this.xhNo = xhNo;
	}

	public String getGsNo() {
		return this.gsNo;
	}

	public void setGsNo(String gsNo) {
		this.gsNo = gsNo;
	}

	public String getPz() {
		return this.pz;
	}

	public void setPz(String pz) {
		this.pz = pz;
	}

	public Integer getMs() {
		return this.ms;
	}

	public void setMs(Integer ms) {
		this.ms = ms;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDb() {
		return this.db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCtime() {
		return this.ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getCuser() {
		return this.cuser;
	}

	public void setCuser(String cuser) {
		this.cuser = cuser;
	}

}