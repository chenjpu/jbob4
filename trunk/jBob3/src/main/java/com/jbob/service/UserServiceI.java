package com.jbob.service;

import java.util.List;

import com.jbob.pageModel.DataGrid;
import com.jbob.pageModel.User;


public interface UserServiceI {

	public User save(User user);

	public User find(User user);
	public User getUser(String name);

	public DataGrid datagrid(User user);

	public List<User> combobox(User user);

	public void remove(String ids);

	public User edit(User user);

	public void modifyRole(User user);

	public void modifyPwd(User user);

}
