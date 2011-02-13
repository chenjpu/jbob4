package com.cy.erp.daolayer.base;

import java.util.HashSet;
import java.util.Set;

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
	private Set billOfParticularses = new HashSet(0);

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
			String client, Double otherFee, Set billOfParticularses) {
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
		this.billOfParticularses = billOfParticularses;
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

	public Set getBillOfParticularses() {
		return this.billOfParticularses;
	}

	public void setBillOfParticularses(Set billOfParticularses) {
		this.billOfParticularses = billOfParticularses;
	}

}