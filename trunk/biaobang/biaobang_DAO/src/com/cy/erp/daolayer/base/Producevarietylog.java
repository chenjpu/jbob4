package com.cy.erp.daolayer.base;

import java.util.Date;

/**
 * Producevarietylog entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Producevarietylog implements java.io.Serializable {

	// Fields

	private String id;
	private String client;
	private String bno;
	private String gno;
	private Integer tnumber;
	private Integer mc;
	private Integer tf;
	private Integer kh;
	private Integer wm;
	private String zz;
	private String ws;
	private String jtNo;
	private String cz;
	private String remark;
	private Date ctime;
	private String cuser;

	// Constructors

	/** default constructor */
	public Producevarietylog() {
	}

	/** minimal constructor */
	public Producevarietylog(String id) {
		this.id = id;
	}

	/** full constructor */
	public Producevarietylog(String id, String client, String bno, String gno,
			Integer tnumber, Integer mc, Integer tf, Integer kh, Integer wm,
			String zz, String ws, String jtNo, String cz, String remark,
			Date ctime, String cuser) {
		this.id = id;
		this.client = client;
		this.bno = bno;
		this.gno = gno;
		this.tnumber = tnumber;
		this.mc = mc;
		this.tf = tf;
		this.kh = kh;
		this.wm = wm;
		this.zz = zz;
		this.ws = ws;
		this.jtNo = jtNo;
		this.cz = cz;
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

	public String getBno() {
		return this.bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public String getGno() {
		return this.gno;
	}

	public void setGno(String gno) {
		this.gno = gno;
	}

	public Integer getTf() {
		return this.tf;
	}

	public void setTf(Integer tf) {
		this.tf = tf;
	}

	public Integer getTnumber() {
		return tnumber;
	}

	public void setTnumber(Integer tnumber) {
		this.tnumber = tnumber;
	}

	public Integer getMc() {
		return mc;
	}

	public void setMc(Integer mc) {
		this.mc = mc;
	}

	public Integer getKh() {
		return kh;
	}

	public void setKh(Integer kh) {
		this.kh = kh;
	}

	public Integer getWm() {
		return wm;
	}

	public void setWm(Integer wm) {
		this.wm = wm;
	}

	public String getZz() {
		return this.zz;
	}

	public void setZz(String zz) {
		this.zz = zz;
	}

	public String getWs() {
		return this.ws;
	}

	public void setWs(String ws) {
		this.ws = ws;
	}

	public String getJtNo() {
		return this.jtNo;
	}

	public void setJtNo(String jtNo) {
		this.jtNo = jtNo;
	}

	public String getCz() {
		return this.cz;
	}

	public void setCz(String cz) {
		this.cz = cz;
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