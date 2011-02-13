package com.cy.erp.daolayer.base;

import java.util.Date;

/**
 * Trackorder entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Trackorder implements java.io.Serializable {

	// Fields

	private String id;
	private String orderNo;
	private String client;
	private Double price;
	private Integer number;
	private Date xtime;
	private Date jwctime;
	private Date jchtime;
	private Date jdstime;
	private Date jdztime;
	private Date swctime;
	private Date schtime;
	private Date sdstime;
	private Date sdztime;
	private String isSj;
	private String isPb;
	private String isFd;
	private String isWd;
	private String remark;
	private Date ctime;
	private String cuser;

	// Constructors

	/** default constructor */
	public Trackorder() {
	}

	/** minimal constructor */
	public Trackorder(String id) {
		this.id = id;
	}

	/** full constructor */
	public Trackorder(String id, String orderNo, String client, Double price,
			Integer number, Date xtime, Date jwctime, Date jchtime,
			Date jdstime, Date jdztime, Date swctime, Date schtime,
			Date sdstime, Date sdztime, String isSj, String isPb, String isFd,
			String isWd, String remark, Date ctime, String cuser) {
		this.id = id;
		this.orderNo = orderNo;
		this.client = client;
		this.price = price;
		this.number = number;
		this.xtime = xtime;
		this.jwctime = jwctime;
		this.jchtime = jchtime;
		this.jdstime = jdstime;
		this.jdztime = jdztime;
		this.swctime = swctime;
		this.schtime = schtime;
		this.sdstime = sdstime;
		this.sdztime = sdztime;
		this.isSj = isSj;
		this.isPb = isPb;
		this.isFd = isFd;
		this.isWd = isWd;
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

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getXtime() {
		return this.xtime;
	}

	public void setXtime(Date xtime) {
		this.xtime = xtime;
	}

	public Date getJwctime() {
		return this.jwctime;
	}

	public void setJwctime(Date jwctime) {
		this.jwctime = jwctime;
	}

	public Date getJchtime() {
		return this.jchtime;
	}

	public void setJchtime(Date jchtime) {
		this.jchtime = jchtime;
	}

	public Date getJdstime() {
		return this.jdstime;
	}

	public void setJdstime(Date jdstime) {
		this.jdstime = jdstime;
	}

	public Date getJdztime() {
		return this.jdztime;
	}

	public void setJdztime(Date jdztime) {
		this.jdztime = jdztime;
	}

	public Date getSwctime() {
		return this.swctime;
	}

	public void setSwctime(Date swctime) {
		this.swctime = swctime;
	}

	public Date getSchtime() {
		return this.schtime;
	}

	public void setSchtime(Date schtime) {
		this.schtime = schtime;
	}

	public Date getSdstime() {
		return this.sdstime;
	}

	public void setSdstime(Date sdstime) {
		this.sdstime = sdstime;
	}

	public Date getSdztime() {
		return this.sdztime;
	}

	public void setSdztime(Date sdztime) {
		this.sdztime = sdztime;
	}

	public String getIsSj() {
		return this.isSj;
	}

	public void setIsSj(String isSj) {
		this.isSj = isSj;
	}

	public String getIsPb() {
		return this.isPb;
	}

	public void setIsPb(String isPb) {
		this.isPb = isPb;
	}

	public String getIsFd() {
		return this.isFd;
	}

	public void setIsFd(String isFd) {
		this.isFd = isFd;
	}

	public String getIsWd() {
		return this.isWd;
	}

	public void setIsWd(String isWd) {
		this.isWd = isWd;
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