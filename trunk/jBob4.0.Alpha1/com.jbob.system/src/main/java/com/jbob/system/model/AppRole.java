package com.jbob.system.model;


import org.springframework.security.core.GrantedAuthority;

import com.google.gson.annotations.Expose;
import com.jbob.core.model.BaseModel;


public class AppRole extends BaseModel implements GrantedAuthority{
	/**
	 * 
	 */
	public static final String SUPER_RIGHTS = "__ALL";
	public static String ROLE_PUBLIC = "ROLE_PUBLIC";
    public static String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";
	private static final long serialVersionUID = -252647602150299801L;
	@Expose
	private Short status;
	@Expose
	private String rights;
	@Expose
	private Short isDefaultIn;
	
	public AppRole() {
		
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}

	public int compareTo(Object o) {
		return 0;
	}

	public Short getIsDefaultIn() {
		return isDefaultIn;
	}

	public void setIsDefaultIn(Short isDefaultIn) {
		this.isDefaultIn = isDefaultIn;
	}

	public String getAuthority() {
		return getName();
	}
}
