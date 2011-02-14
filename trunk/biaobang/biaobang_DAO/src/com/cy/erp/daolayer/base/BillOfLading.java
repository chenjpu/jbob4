package com.cy.erp.daolayer.base;

import java.util.Date;

/**
 * BillOfLading entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BillOfLading implements java.io.Serializable {

	// Fields

	private Long id;
	private String customer;
	private String contactInformation;
	private String receivingDetial;
	private String freightName;
	private String freightPhone;
	private String freightAddress;
	private String remark1;
	private String remark2;
	private String remark3;
	private String sheetName;
	private String auditor;
	private String sender;
	private String client;
	private Double otherFee;
	private String busiKey;
	private Date ttime;
	private Date ctime;
	private String cuser;
	private String remark4;
	private String remark5;
	private String customer2;
	private String number;
	private String level;
	private String area;

	// Constructors

	/** default constructor */
	public BillOfLading() {
	}

	/** minimal constructor */
	public BillOfLading(Long id, String customer, String contactInformation,
			String freightName) {
		this.id = id;
		this.customer = customer;
		this.contactInformation = contactInformation;
		this.freightName = freightName;
	}

	/** full constructor */
	public BillOfLading(Long id, String customer, String contactInformation,
			String receivingDetial, String freightName, String freightPhone,
			String freightAddress, String remark1, String remark2,
			String remark3, String sheetName, String auditor, String sender,
			String client, Double otherFee, String busiKey, Date ttime,
			Date ctime, String cuser, String remark4, String remark5,
			String customer2, String number, String level, String area) {
		this.id = id;
		this.customer = customer;
		this.contactInformation = contactInformation;
		this.receivingDetial = receivingDetial;
		this.freightName = freightName;
		this.freightPhone = freightPhone;
		this.freightAddress = freightAddress;
		this.remark1 = remark1;
		this.remark2 = remark2;
		this.remark3 = remark3;
		this.sheetName = sheetName;
		this.auditor = auditor;
		this.sender = sender;
		this.client = client;
		this.otherFee = otherFee;
		this.busiKey = busiKey;
		this.ttime = ttime;
		this.ctime = ctime;
		this.cuser = cuser;
		this.remark4 = remark4;
		this.remark5 = remark5;
		this.customer2 = customer2;
		this.number = number;
		this.level = level;
		this.area = area;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getContactInformation() {
		return this.contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getReceivingDetial() {
		return this.receivingDetial;
	}

	public void setReceivingDetial(String receivingDetial) {
		this.receivingDetial = receivingDetial;
	}

	public String getFreightName() {
		return this.freightName;
	}

	public void setFreightName(String freightName) {
		this.freightName = freightName;
	}

	public String getFreightPhone() {
		return this.freightPhone;
	}

	public void setFreightPhone(String freightPhone) {
		this.freightPhone = freightPhone;
	}

	public String getFreightAddress() {
		return this.freightAddress;
	}

	public void setFreightAddress(String freightAddress) {
		this.freightAddress = freightAddress;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getSheetName() {
		return this.sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getAuditor() {
		return this.auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Double getOtherFee() {
		return this.otherFee;
	}

	public void setOtherFee(Double otherFee) {
		this.otherFee = otherFee;
	}

	public String getBusiKey() {
		return this.busiKey;
	}

	public void setBusiKey(String busiKey) {
		this.busiKey = busiKey;
	}

	public Date getTtime() {
		return this.ttime;
	}

	public void setTtime(Date ttime) {
		this.ttime = ttime;
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

	public String getRemark4() {
		return this.remark4;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public String getRemark5() {
		return this.remark5;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public String getCustomer2() {
		return this.customer2;
	}

	public void setCustomer2(String customer2) {
		this.customer2 = customer2;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}