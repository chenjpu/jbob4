package com.jbob.system.model;

import java.util.Date;
import java.util.Set;

import com.jbob.core.model.BaseModel;

/**
 * @author chenbing
 * 职员
 */
public class Emploree extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 169130948283136218L;

	private String loginId;//

	private String password;//

	private int sel = 1;//

	private Date birthday;//

	private String telephone;//

	private String mobile;//

	private String email;//

	private int status;// default '0'

	private Set<Role> roles;

	private AppLevel level;

	private Set<AppPost> posts;

	private Department department;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSel() {
		return sel;
	}

	public void setSel(int sel) {
		this.sel = sel;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public AppLevel getLevel() {
		return level;
	}

	public void setLevel(AppLevel level) {
		this.level = level;
	}

	public Set<AppPost> getPosts() {
		return posts;
	}

	public void setPosts(Set<AppPost> posts) {
		this.posts = posts;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public boolean isSuperUser() {
		//return true;
		return "root".equalsIgnoreCase(loginId);
	}
}
