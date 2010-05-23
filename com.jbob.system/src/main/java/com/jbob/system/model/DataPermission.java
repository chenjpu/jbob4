package com.jbob.system.model;

/**
 * @author chenbing
 * 数据权限
 */
@SuppressWarnings("serial")
public class DataPermission extends Permission{
	
	private DataTarget dataTarget;//目标对象(组织,角色，用户等对象)
	
	private String condition;//条件
	
	private boolean read;
	
	private boolean write;
	
	private boolean delete;
	
	public DataTarget getDataTarget() {
		return dataTarget;
	}

	public void setDataTarget(DataTarget dataTarget) {
		this.dataTarget = dataTarget;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean isWrite() {
		return write;
	}

	public void setWrite(boolean write) {
		this.write = write;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}
}
