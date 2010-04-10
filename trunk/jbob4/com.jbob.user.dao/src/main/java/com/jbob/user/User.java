package com.jbob.user;

import java.io.Serializable;

import com.jbob.core.Entity;

public class User extends Entity {
	private Integer id;

	public Serializable getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
