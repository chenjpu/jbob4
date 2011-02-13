package com.cy.erp.daolayer.base;

/**
 * Forwarder entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Forwarder implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String telephone;
	private String address;
	private Long franchiserId;

	// Constructors

	/** default constructor */
	public Forwarder() {
	}

	/** minimal constructor */
	public Forwarder(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Forwarder(Long id, String name, String telephone, String address,
			Long franchiserId) {
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.address = address;
		this.franchiserId = franchiserId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getFranchiserId() {
		return this.franchiserId;
	}

	public void setFranchiserId(Long franchiserId) {
		this.franchiserId = franchiserId;
	}

}