package com.jbob.service;

import com.jbob.pageModel.DataGrid;
import com.jbob.pageModel.Role;

public interface RoleServiceI {

	public DataGrid datagrid(Role role);

	public Role save(Role role);

	public void remove(String ids);

	public Role edit(Role role);

}
