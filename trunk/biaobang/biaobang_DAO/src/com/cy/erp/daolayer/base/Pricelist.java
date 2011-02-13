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

	// Constructors

	/** default constructor */
	public Pricelist() {
	}

	/** minimal constructor */
	public Pricelist(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Pricelist(Long id, Long franchiserId, Long goodsId, Double price) {
		this.id = id;
		this.franchiserId = franchiserId;
		this.goodsId = goodsId;
		this.price = price;
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

}