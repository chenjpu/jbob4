package com.jbob.core.model;

import com.google.gson.annotations.Expose;
import com.jbob.core.BaseEntity;

/**
 * @author chenbing
 * 组织模型
 */
public abstract class BaseModel extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5505906463885538098L;
	@Expose
	private String name; //名称
	@Expose
	private String code; //编码
	@Expose
	private String description;//描述
	private int order; //显示序号

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
