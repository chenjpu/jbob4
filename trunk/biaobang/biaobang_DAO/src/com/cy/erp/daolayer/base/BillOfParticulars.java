package com.cy.erp.daolayer.base;

/**
 * BillOfParticulars entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BillOfParticulars implements java.io.Serializable {

	// Fields

	private Long id;
	private BillOfLading billOfLading;
	private String code;
	private String specificationModel;
	private String sort;
	private String spec;
	private Double unitPrice;
	private Integer amount;
	private String units;
	private Double weight;
	private Double volume;
	private Double sum;
	private String attribute;

	// Constructors

	/** default constructor */
	public BillOfParticulars() {
	}

	/** minimal constructor */
	public BillOfParticulars(Long id, BillOfLading billOfLading, String code) {
		this.id = id;
		this.billOfLading = billOfLading;
		this.code = code;
	}

	/** full constructor */
	public BillOfParticulars(Long id, BillOfLading billOfLading, String code,
			String specificationModel, String sort, String spec,
			Double unitPrice, Integer amount, String units, Double weight,
			Double volume, Double sum, String attribute) {
		this.id = id;
		this.billOfLading = billOfLading;
		this.code = code;
		this.specificationModel = specificationModel;
		this.sort = sort;
		this.spec = spec;
		this.unitPrice = unitPrice;
		this.amount = amount;
		this.units = units;
		this.weight = weight;
		this.volume = volume;
		this.sum = sum;
		this.attribute = attribute;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BillOfLading getBillOfLading() {
		return this.billOfLading;
	}

	public void setBillOfLading(BillOfLading billOfLading) {
		this.billOfLading = billOfLading;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSpecificationModel() {
		return this.specificationModel;
	}

	public void setSpecificationModel(String specificationModel) {
		this.specificationModel = specificationModel;
	}

	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSpec() {
		return this.spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getUnits() {
		return this.units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getVolume() {
		return this.volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getSum() {
		return this.sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public String getAttribute() {
		return this.attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

}