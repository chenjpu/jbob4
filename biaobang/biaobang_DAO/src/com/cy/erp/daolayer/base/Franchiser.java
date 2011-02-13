package com.cy.erp.daolayer.base;

/**
 * Franchiser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Franchiser implements java.io.Serializable {

	// Fields

	private Long id;
	private String number;
	private String level;
	private String area;
	private String phoneCode;
	private String faxNumber;
	private String receivingDetails;
	private Long parentId;

	// Constructors

	/** default constructor */
	public Franchiser() {
	}

	/** minimal constructor */
	public Franchiser(Long id, String number, String level, String area) {
		this.id = id;
		this.number = number;
		this.level = level;
		this.area = area;
	}

	/** full constructor */
	public Franchiser(Long id, String number, String level, String area,
			String phoneCode, String faxNumber, String receivingDetails,
			Long parentId) {
		this.id = id;
		this.number = number;
		this.level = level;
		this.area = area;
		this.phoneCode = phoneCode;
		this.faxNumber = faxNumber;
		this.receivingDetails = receivingDetails;
		this.parentId = parentId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhoneCode() {
		return this.phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public String getFaxNumber() {
		return this.faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getReceivingDetails() {
		return this.receivingDetails;
	}

	public void setReceivingDetails(String receivingDetails) {
		this.receivingDetails = receivingDetails;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}