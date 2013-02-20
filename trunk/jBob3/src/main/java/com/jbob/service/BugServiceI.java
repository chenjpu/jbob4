package com.jbob.service;

import com.jbob.pageModel.Bug;
import com.jbob.pageModel.DataGrid;

public interface BugServiceI {

	public DataGrid datagrid(Bug bug);

	public Bug save(Bug bug);

	public void remove(String ids);

	public Bug getBug(String id);

	public Bug edit(Bug bug);

}
