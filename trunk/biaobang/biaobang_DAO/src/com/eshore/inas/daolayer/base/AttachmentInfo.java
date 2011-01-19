package com.eshore.inas.daolayer.base;

import java.sql.Blob;

/**
 * AttachmentInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AttachmentInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String relativeId;
	private String relativeType;
	private String name;
	private Blob content;
	private String remark;

	// Constructors

	/** default constructor */
	public AttachmentInfo() {
	}

	/** minimal constructor */
	public AttachmentInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public AttachmentInfo(String id, String relativeId, String relativeType,
			String name, Blob content, String remark) {
		this.id = id;
		this.relativeId = relativeId;
		this.relativeType = relativeType;
		this.name = name;
		this.content = content;
		this.remark = remark;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRelativeId() {
		return this.relativeId;
	}

	public void setRelativeId(String relativeId) {
		this.relativeId = relativeId;
	}

	public String getRelativeType() {
		return this.relativeType;
	}

	public void setRelativeType(String relativeType) {
		this.relativeType = relativeType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Blob getContent() {
		return this.content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}