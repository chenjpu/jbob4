package com.jbob.system.model;

import com.jbob.core.model.BaseModel;

/**
 * 
 * 
 */
public class FileAttach extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2226805671345907700L;
	protected Long fileId;
	protected String fileName;
	protected String filePath;
	protected java.util.Date createtime;
	protected String ext;
	protected String fileType;
	protected String note;
	protected String creator;

	/**
	 * Default Empty Constructor for class FileAttach
	 */
	public FileAttach() {
		super();
	}

	/**
	 * Default Key Fields Constructor for class FileAttach
	 */
	public FileAttach(Long in_fileId) {
		this.setFileId(in_fileId);
	}

	/**
	 * 	 * @return Long
	 * @hibernate.id column="fileId" type="java.lang.Long" generator-class="native"
	 */
	public Long getFileId() {
		return this.fileId;
	}

	/**
	 * Set the fileId
	 */
	public void setFileId(Long aValue) {
		this.fileId = aValue;
	}

	/**
	 * 文件名	 * @return String
	 * @hibernate.property column="fileName" type="java.lang.String" length="128" not-null="true" unique="false"
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * Set the fileName
	 * @spring.validator type="required"
	 */
	public void setFileName(String aValue) {
		this.fileName = aValue;
	}

	/**
	 * 文件路径	 * @return String
	 * @hibernate.property column="filePath" type="java.lang.String" length="128" not-null="true" unique="false"
	 */
	public String getFilePath() {
		return this.filePath;
	}

	/**
	 * Set the filePath
	 * @spring.validator type="required"
	 */
	public void setFilePath(String aValue) {
		this.filePath = aValue;
	}

	/**
	 * 创建时间	 * @return java.util.Date
	 * @hibernate.property column="createtime" type="java.util.Date" length="19" not-null="true" unique="false"
	 */
	public java.util.Date getCreatetime() {
		return this.createtime;
	}

	/**
	 * Set the createtime
	 * @spring.validator type="required"
	 */
	public void setCreatetime(java.util.Date aValue) {
		this.createtime = aValue;
	}

	/**
	 * 扩展名	 * @return String
	 * @hibernate.property column="ext" type="java.lang.String" length="32" not-null="false" unique="false"
	 */
	public String getExt() {
		return this.ext;
	}

	/**
	 * Set the ext
	 */
	public void setExt(String aValue) {
		this.ext = aValue;
	}

	/**
	 * 附件类型
	        如：邮件附件	 * @return String
	 * @hibernate.property column="fileType" type="java.lang.String" length="32" not-null="true" unique="false"
	 */
	public String getFileType() {
		return this.fileType;
	}

	/**
	 * Set the type
	 * @spring.validator type="required"
	 */
	public void setFileType(String aValue) {
		this.fileType = aValue;
	}

	/**
	 * 说明	 * @return String
	 * @hibernate.property column="note" type="java.lang.String" length="1024" not-null="false" unique="false"
	 */
	public String getNote() {
		return this.note;
	}

	/**
	 * Set the note
	 */
	public void setNote(String aValue) {
		this.note = aValue;
	}

	/**
	 * 上传者	 * @return String
	 * @hibernate.property column="creator" type="java.lang.String" length="32" not-null="true" unique="false"
	 */
	public String getCreator() {
		return this.creator;
	}

	/**
	 * Set the creator
	 * @spring.validator type="required"
	 */
	public void setCreator(String aValue) {
		this.creator = aValue;
	}

	/**
	 * Return the name of the first key column
	 */
	public String getFirstKeyColumnName() {
		return "fileId";
	}

	/**
	 * Return the Id (pk) of the entity, must be Integer
	 */
	public Long getId() {
		return fileId;
	}

}
