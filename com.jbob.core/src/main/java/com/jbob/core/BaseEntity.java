/*
 * 
 * 创建日期：2010-4-16 上午11:28:52
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.core;

import com.google.gson.annotations.Expose;

public class BaseEntity implements Entity {
	@Expose
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
