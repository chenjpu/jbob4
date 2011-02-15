package com.cy.erp.daolayer.base;

/**
 * Pricelist entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Pricelist implements java.io.Serializable {

	// Fields

	private Long id;
	private Long franchiserId;
	private Long goodsId;
	private Double price;
	private String name;

	// Constructors

	/** default constructor */
	public Pricelist() {
	}

	/** minimal constructor */
	public Pricelist(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Pricelist(Long id, Long franchiserId, Long goodsId, Double price,
			String name) {
		this.id = id;
		this.franchiserId = franchiserId;
		this.goodsId = goodsId;
		this.price = price;
		this.name = name;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFranchiserId() {
		return this.franchiserId;
	}

	public void setFranchiserId(Long franchiserId) {
		this.franchiserId = franchiserId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}