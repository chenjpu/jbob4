package com.cy.erp.daolayer.base;

import java.util.Date;

/**
 * Inventory entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Inventory implements java.io.Serializable {

	// Fields

	private String id;
	private String bno;
	private Double az;
	private String bfsl;
	private String jsys;
	private String cfzzgg;
	private Integer kc;
	private Integer pb;
	private Integer zjjtNumber;
	private Integer czms;
	private Double dsPrice;
	private Double price;
	private String isDd;
	private String isFd;
	private String isPb;
	private String isRb;
	private String hnumberWay;
	private String xdr;
	private String remark;
	private Date ctime;
	private String cuser;

	// Constructors

	/** default constructor */
	public Inventory() {
	}

	/** minimal constructor */
	public Inventory(String id) {
		this.id = id;
	}

	/** full constructor */
	public Inventory(String id, String bno, Double az, String bfsl,
			String jsys, String cfzzgg, Integer kc, Integer pb,
			Integer zjjtNumber, Integer czms, Double dsPrice, Double price,
			String isDd, String isFd, String isPb, String isRb,
			String hnumberWay, String xdr, String remark, Date ctime,
			String cuser) {
		this.id = id;
		this.bno = bno;
		this.az = az;
		this.bfsl = bfsl;
		this.jsys = jsys;
		this.cfzzgg = cfzzgg;
		this.kc = kc;
		this.pb = pb;
		this.zjjtNumber = zjjtNumber;
		this.czms = czms;
		this.dsPrice = dsPrice;
		this.price = price;
		this.isDd = isDd;
		this.isFd = isFd;
		this.isPb = isPb;
		this.isRb = isRb;
		this.hnumberWay = hnumberWay;
		this.xdr = xdr;
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

	public String getBno() {
		return this.bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public String getBfsl() {
		return this.bfsl;
	}

	public void setBfsl(String bfsl) {
		this.bfsl = bfsl;
	}

	public String getJsys() {
		return this.jsys;
	}

	public void setJsys(String jsys) {
		this.jsys = jsys;
	}

	public String getCfzzgg() {
		return this.cfzzgg;
	}

	public void setCfzzgg(String cfzzgg) {
		this.cfzzgg = cfzzgg;
	}

	public Integer getKc() {
		return this.kc;
	}

	public void setKc(Integer kc) {
		this.kc = kc;
	}

	public Integer getPb() {
		return this.pb;
	}

	public void setPb(Integer pb) {
		this.pb = pb;
	}

	public Integer getZjjtNumber() {
		return this.zjjtNumber;
	}

	public void setZjjtNumber(Integer zjjtNumber) {
		this.zjjtNumber = zjjtNumber;
	}

	public Integer getCzms() {
		return this.czms;
	}

	public void setCzms(Integer czms) {
		this.czms = czms;
	}

	public Double getDsPrice() {
		return this.dsPrice;
	}

	public void setDsPrice(Double dsPrice) {
		this.dsPrice = dsPrice;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getIsDd() {
		return this.isDd;
	}

	public void setIsDd(String isDd) {
		this.isDd = isDd;
	}

	public String getIsFd() {
		return this.isFd;
	}

	public void setIsFd(String isFd) {
		this.isFd = isFd;
	}

	public String getIsPb() {
		return this.isPb;
	}

	public void setIsPb(String isPb) {
		this.isPb = isPb;
	}

	public String getIsRb() {
		return this.isRb;
	}

	public void setIsRb(String isRb) {
		this.isRb = isRb;
	}

	public String getHnumberWay() {
		return this.hnumberWay;
	}

	public void setHnumberWay(String hnumberWay) {
		this.hnumberWay = hnumberWay;
	}

	public String getXdr() {
		return this.xdr;
	}

	public void setXdr(String xdr) {
		this.xdr = xdr;
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

	public Double getAz() {
		return az;
	}

	public void setAz(Double az) {
		this.az = az;
	}

}