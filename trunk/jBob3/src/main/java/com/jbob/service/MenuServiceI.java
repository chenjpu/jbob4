package com.jbob.service;

import java.util.List;

import com.jbob.pageModel.Menu;


public interface MenuServiceI {

	public List<Menu> allTreeNode();

	public List<Menu> treegrid();

	public void remove(String id);

	public Menu add(Menu menu);

	public Menu edit(Menu menu);

}
