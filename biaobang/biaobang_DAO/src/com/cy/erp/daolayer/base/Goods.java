package com.cy.erp.daolayer.base;

/**
 * Goods entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Long id;
	private String type;
	private String name;
	private String netMass;
	private String netWeight;
	private Double length;
	private Double width;
	private Double height;
	private Double volume;
	private Double bottleWeight;
	private Double boxWeight;
	private String barCode;
	private String number;
	private Integer specification;
	private String standard;

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Goods(Long id, String type, String name, String netMass,
			String netWeight, Double length, Double width, Double height,
			Double volume, Double bottleWeight, Double boxWeight,
			String barCode, String number, Integer specification,
			String standard) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.netMass = netMass;
		this.netWeight = netWeight;
		this.length = length;
		this.width = width;
		this.height = height;
		this.volume = volume;
		this.bottleWeight = bottleWeight;
		this.boxWeight = boxWeight;
		this.barCode = barCode;
		this.number = number;
		this.specification = specification;
		this.standard = standard;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNetMass() {
		return this.netMass;
	}

	public void setNetMass(String netMass) {
		this.netMass = netMass;
	}

	public String getNetWeight() {
		return this.netWeight;
	}

	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}

	public Double getLength() {
		return this.length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return this.width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getVolume() {
		return this.volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getBottleWeight() {
		return this.bottleWeight;
	}

	public void setBottleWeight(Double bottleWeight) {
		this.bottleWeight = bottleWeight;
	}

	public Double getBoxWeight() {
		return this.boxWeight;
	}

	public void setBoxWeight(Double boxWeight) {
		this.boxWeight = boxWeight;
	}

	public String getBarCode() {
		return this.barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getSpecification() {
		return this.specification;
	}

	public void setSpecification(Integer specification) {
		this.specification = specification;
	}

	public String getStandard() {
		return this.standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

}