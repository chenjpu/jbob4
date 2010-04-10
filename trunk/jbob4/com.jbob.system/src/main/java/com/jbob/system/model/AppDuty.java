package com.jbob.system.model;

import java.util.Set;

import com.jbob.core.TreeEntity;
import com.jbob.core.model.BaseModel;

/**
 * @author chenbing
 * 职责
 */
public class AppDuty extends BaseModel implements TreeEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 211939211293130746L;

	private AppDuty parent;

	private Set<AppDuty> childs;

	public AppDuty getParent() {
		return parent;
	}

	public void setParent(AppDuty parent) {
		this.parent = parent;
	}

	public Set<AppDuty> getChilds() {
		return childs;
	}

	public void setChilds(Set<AppDuty> childs) {
		this.childs = childs;
	}

}
