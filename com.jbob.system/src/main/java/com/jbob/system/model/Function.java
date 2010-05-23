/*
 * 
 * 创建日期：2010-4-21 下午03:09:39
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.system.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Function extends Item<Function> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4630903580818657203L;

	private List<Url> urls = new ArrayList<Url>();

	public void add(Url e) {
		e.setFunction(this);
		urls.add(e);
	}
	public List<Url> getUrls() {
		return Collections.unmodifiableList(urls);
	}
}
